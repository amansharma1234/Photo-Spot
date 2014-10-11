package com.photoapp.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class PopularMedia {

	@Expose
	private Meta meta;
	@Expose
	private List<Datum> data = new ArrayList<Datum>();

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public List<Datum> getData() {
		return data;
	}

	public void setData(List<Datum> data) {
		this.data = data;
	}

}
