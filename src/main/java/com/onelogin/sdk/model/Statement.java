package com.onelogin.sdk.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Statement {

	public String effect;
	public List<String> actions = new ArrayList<String>();
	public List<String> scopes = new ArrayList<String>();

	public Statement(JSONObject data) {
		effect = data.optString("Effect", "Allow");
		JSONArray jsonArray = data.getJSONArray("Action");
		if (jsonArray != null && jsonArray.length() > 0) {
			for (int i = 0; i < jsonArray.length(); i++) {				
				actions.add(jsonArray.getString(i));
			}
		}
		jsonArray = data.getJSONArray("Scope");
		if (jsonArray != null && jsonArray.length() > 0) {
			for (int i = 0; i < jsonArray.length(); i++) {				
				scopes.add(jsonArray.getString(i));
			}
		}
	}
	
	public Statement(String effect, List<String> actions, List<String> scopes) {
		this.effect = effect;
		this.actions = actions;
		this.scopes = scopes;
	}
}
