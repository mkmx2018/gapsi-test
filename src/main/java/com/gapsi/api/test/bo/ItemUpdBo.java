package com.gapsi.api.test.bo;

import java.io.Serializable;


public class ItemUpdBo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String description;

	private String model;

	public ItemUpdBo() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}