package com.digo.beans;

import java.util.ArrayList;
import java.util.List;

public class OneKindsGoods {
	private String kind;
	
	private String kindNum;
	
	private List<GoodsBean> list = new ArrayList<GoodsBean>();
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getKindNum() {
		return kindNum;
	}

	public void setKindNum(String kindNum) {
		this.kindNum = kindNum;
	}

	public List<GoodsBean> getList() {
		return list;
	}

	public void setList(List<GoodsBean> list) {
		this.list = list;
	}
}
