package com.xcm.entity;

import java.util.List;

public class PageNation {
	//当前页
	private Integer page=1;
	//当前页数据的条数
	private Integer limit=10;
	//起始行数
	private Integer start=0;
	//状态码
	private Integer code;
	//消息
	private String msg;
	//总条数
	private Integer count;
	//当页数据
	private List<?> data;
	
	
	//条件参数
	
	private Integer num1;
	
	private Integer num2;
	
	private Integer num3;
	
	private Integer num4;
	
	private Integer num5;
	
	private Integer num6;
	
	private String  text1;
	
	private String  text2;
	
	private String  text3;
	
	private String  text4;
	
	private String  text5;
	
	private String  text6;
	
	public Integer getStart() {
		return (page-1)*limit;
	}
	public void setStart(Integer start) {
		this.start=start;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public Integer getNum1() {
		return num1;
	}
	public void setNum1(Integer num1) {
		this.num1 = num1;
	}
	public Integer getNum2() {
		return num2;
	}
	public void setNum2(Integer num2) {
		this.num2 = num2;
	}
	public Integer getNum3() {
		return num3;
	}
	public void setNum3(Integer num3) {
		this.num3 = num3;
	}
	public Integer getNum4() {
		return num4;
	}
	public void setNum4(Integer num4) {
		this.num4 = num4;
	}
	public Integer getNum5() {
		return num5;
	}
	public void setNum5(Integer num5) {
		this.num5 = num5;
	}
	public Integer getNum6() {
		return num6;
	}
	public void setNum6(Integer num6) {
		this.num6 = num6;
	}
	public String getText1() {
		return text1;
	}
	public void setText1(String text1) {
		this.text1 = text1;
	}
	public String getText2() {
		return text2;
	}
	public void setText2(String text2) {
		this.text2 = text2;
	}
	public String getText3() {
		return text3;
	}
	public void setText3(String text3) {
		this.text3 = text3;
	}
	public String getText4() {
		return text4;
	}
	public void setText4(String text4) {
		this.text4 = text4;
	}
	public String getText5() {
		return text5;
	}
	public void setText5(String text5) {
		this.text5 = text5;
	}
	public String getText6() {
		return text6;
	}
	public void setText6(String text6) {
		this.text6 = text6;
	}
	@Override
	public String toString() {
		return "PageNation [page=" + page + ", limit=" + limit + ", start=" + start + ", code=" + code + ", msg=" + msg
				+ ", count=" + count + ", data=" + data + ", num1=" + num1 + ", num2=" + num2 + ", num3=" + num3
				+ ", num4=" + num4 + ", num5=" + num5 + ", num6=" + num6 + ", text1=" + text1 + ", text2=" + text2
				+ ", text3=" + text3 + ", text4=" + text4 + ", text5=" + text5 + ", text6=" + text6 + "]";
	}
	
}
