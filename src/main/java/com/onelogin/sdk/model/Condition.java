package com.onelogin.sdk.model;

import org.json.JSONObject;

public class Condition {

	public String source;
	public String operator;
	public Object value;
	
	public Condition(JSONObject data) {
		source = data.optString("source");
		operator = data.optString("operator");
		value = data.opt("value");
	}
	
	public Condition(String source, String operator, Object value) {
		this.source = source;
		this.operator = operator;
		this.value = value;
	}
}
