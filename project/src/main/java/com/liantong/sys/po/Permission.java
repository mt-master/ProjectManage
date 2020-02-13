package com.liantong.sys.po;

import java.io.Serializable;

public class Permission implements Serializable {
	private String id;
	private String name;
	private String url;

	// 省略setter、getter方法

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}