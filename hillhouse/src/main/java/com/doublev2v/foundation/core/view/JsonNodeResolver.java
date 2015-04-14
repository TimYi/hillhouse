package com.doublev2v.foundation.core.view;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * 用于定制el表达式，解析@JsonNode 数据
 * @author pc
 *
 */
public class JsonNodeResolver {
	
	public static Iterator<JsonNode> iterate(JsonNode node, String key) {
		node=get(node, key);
		return node.iterator();
	}
	/**
	 * 获取@JsonNode 子节点
	 * @param node root节点
	 * @param key 用.分开的节点树，如result.list
	 * @return
	 */
	public static JsonNode get(JsonNode node, String key) {
		return get(node, null, key);
	}
	
	public static JsonNode get(JsonNode node, Integer index, String key) {
		if(StringUtils.isEmpty(key)) {
			return node;
		}
		String[] keys=key.split("\\.");
		JsonNode result=node;
		for (String k : keys) {
			result=result.path(k);
		}
		if(index!=null) {
			result=result.path(index);
		}
		return result;
	}
	
	/**
	 * 查找@JsonNode 子节点
	 * @param node
	 * @param key
	 * @return
	 */
	public static JsonNode find(JsonNode node, String key) {
		JsonNode result=node.findPath(key);
		return result;
	}
	
	/**
	 * 获取值节点
	 * @param node
	 * @param key
	 * @return
	 */
	public static String getString(JsonNode node, String key) {
		return getString(node, null, key);
	}
	
	public static String getString(JsonNode node, Integer index, String key) {
		JsonNode result=get(node, index, key);
		String value=result.asText();
		//防止在页面显示空串，影响美观
		return (value==null || value.equals("null"))?"":value;
	}
	
	public static String findString(JsonNode node, String key) {
		return find(node, key).asText();
	}
	
	/**
	 * 查看某个field是否全为空值
	 * @param node
	 * @param key
	 * @return
	 */
	public static boolean isEmpty(JsonNode node, String key) {
		List<JsonNode> values=node.findValues(key);
		for (JsonNode value : values) {
			if(!(value.isNull() || (value.isValueNode() && StringUtils.isEmpty(value.asText())))) {
				return false;
			}
		}
		return true;
	}
}
