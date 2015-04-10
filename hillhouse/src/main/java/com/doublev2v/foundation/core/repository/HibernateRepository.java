package com.doublev2v.foundation.core.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projections;

import com.doublev2v.foundation.core.model.PagedList;

/**
 * 基础数据仓库，为某种类型的数据提供基础持久化服务。内容应该尽量稳定，变化的部分交给子类实现，Criteria接口已经足够强大和灵活。
 * @author pc
 *
 * @param <T>
 */
public abstract class HibernateRepository<T,PK extends Serializable> implements BaseRepository<T,PK> {
	@Resource(name="sessionFactory")
	protected SessionFactory sessionFactory;
	
	/**
	 * 这个方法返回的是最终实体类的第一个泛型类，可能和T没有关系。
	 * 如果继承中用到泛型，并且有多个参数，需要在子类中重写此方法
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<T> getTClass() {		
		Type[] types=((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
		Class<T> classT=(Class<T>)types[0];
		return classT;
	}
	
	/**
	 * 获取 org.hibernate.Session
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected Criteria getCriteria() {
		Class<T> classT=getTClass();
		return getSession().createCriteria(classT);
	}
	
	/**
	 * 获取列表总数量
	 * @return
	 */
	public Integer getSize() {
		return getSize(getCriteria());
	}
	
	/**
	 * 为条件查询预留更多选择
	 * 获取某查询条件下的size
	 */
	protected Integer getSize(Criteria criteria) {
		Integer result = ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		criteria.setProjection(null);
		return result;
	}
	
	/**
	 * 根据id获取数据
	 * @param id
	 * @return 如果有list property，会启动延迟加载。
	 */
	public T getItem(PK id) {
		Object result=getSession().get(getTClass(), id);
		return getTClass().cast(result);
	}
	
	
	public void save(T t) {
		getSession().save(t);
	}

	public void update(T t) {
		getSession().update(t);
	}
	
	public void merge(T t) {
		getSession().merge(t);
	}

	public void delete(T t) {
		getSession().delete(t);
	}
	
	public void delete(PK id) {
		T t=getItem(id);
		getSession().delete(t);
	}

	public void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}
	
	/**
	 * 获取全部内容
	 * @return
	 */
	public List<T> getAll() {
		Criteria criteria=getCriteria().setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return getAll(criteria);
	}
	
	/**
	 * 为子类查询提供接口
	 * @param criteria
	 * @return
	 */
	protected List getAll(Criteria criteria) {
		return criteria.list();
	}
	
	/**
	 * 获取一个区间的数据列表
	 * @param startNumber
	 * @param size
	 * @return
	 */
	public List<T> getList(int startNumber, int size) {
		Criteria criteria=getCriteria();
		return getList(criteria, startNumber, size);
	}
	
	/**
	 * 用于为增加查询具体的条件预留接口
	 * @param criteria 查询条件
	 * @param startNumber 起始位置，从1开始，包含此数据。
	 * @param size 数据量
	 * @return
	 */
	protected List getList(Criteria criteria, int startNumber, int size) {
		criteria.setFirstResult(startNumber-1);
		criteria.setMaxResults(size);
		return criteria.list();
	}
	
	public PagedList<T> getPagedList(Integer pageNo, Integer pageSize) {
		Criteria criteria=getCriteria();
		addOrder(criteria);
		return getPagedList(criteria, pageNo, pageSize);
	}
	
	/**
	 * 为获取pagedList预留查询接口
	 * @param criteria
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	protected PagedList getPagedList(Criteria criteria, Integer pageNo, Integer pageSize) {
		Integer totalCount=getSize(criteria);
		PagedList<T> pagedList=new PagedList<T>(totalCount, pageNo, pageSize);
		int startNumber=pagedList.getStartNumber();
		int size=pagedList.getPageSize();
		List<T> result=getList(criteria, startNumber, size);
		pagedList.setResult(result);
		return pagedList;
	}
	/**
	 * 子类可以在Criteria中做排序处理。
	 * @param criteria
	 * @return
	 */
    protected Criteria addOrder(Criteria criteria) {
    	return criteria;
    }
}
