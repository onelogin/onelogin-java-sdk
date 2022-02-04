package com.onelogin.sdk.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Action {

	public String action;
	public List<String> value = new ArrayList<String>();
	
	public Action(JSONObject data) {
		action = data.optString("action");
		JSONArray jsonArrayValue = data.getJSONArray("value");
		if (jsonArrayValue != null && jsonArrayValue.length() > 0) {
			for (int i = 0; i < jsonArrayValue.length(); i++) {
				this.value.add(jsonArrayValue.getString(i));
			}
		}
	}
	
	public Action(String action, List<String> value) {
		this.action = action;
		this.value = value;
	}
}