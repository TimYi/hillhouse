package com.doublev2v.foundation.core.model;

import java.io.Serializable;

/**
 * 拥有唯一主键的实体
 * @author pc
 *
 * @param <PK>
 */
public interface Identified<PK extends Serializable> {
	PK getId();
}
