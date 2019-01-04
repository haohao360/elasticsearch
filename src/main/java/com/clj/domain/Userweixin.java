package com.clj.domain;

import java.io.Serializable;

import lombok.Data;

public class Userweixin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int wxId;
	
	private String  wxOpenId;
	
	private String  wxNickname;
	
	private String  wxSex;
	
	private String  wxProvince;
	
	private String  wxCity;
	
	private String  wxCountry;
	
	private String  wxHeadimgurl;
	
	private String  unionId;
	
	private String wxMobile;

	public String getWxMobile() {
		return wxMobile;
	}

	public void setWxMobile(String wxMobile) {
		this.wxMobile = wxMobile;
	}

	public int getWxId() {
		return wxId;
	}

	public void setWxId(int wxId) {
		this.wxId = wxId;
	}

	public String getWxOpenId() {
		return wxOpenId;
	}

	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}

	public String getWxNickname() {
		return wxNickname;
	}

	public void setWxNickname(String wxNickname) {
		this.wxNickname = wxNickname;
	}

	public String getWxSex() {
		return wxSex;
	}

	public void setWxSex(String wxSex) {
		this.wxSex = wxSex;
	}

	public String getWxProvince() {
		return wxProvince;
	}

	public void setWxProvince(String wxProvince) {
		this.wxProvince = wxProvince;
	}

	public String getWxCity() {
		return wxCity;
	}

	public void setWxCity(String wxCity) {
		this.wxCity = wxCity;
	}

	public String getWxCountry() {
		return wxCountry;
	}

	public void setWxCountry(String wxCountry) {
		this.wxCountry = wxCountry;
	}

	public String getWxHeadimgurl() {
		return wxHeadimgurl;
	}

	public void setWxHeadimgurl(String wxHeadimgurl) {
		this.wxHeadimgurl = wxHeadimgurl;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
}
