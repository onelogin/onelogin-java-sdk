package com.onelogin.sdk.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Risk extends OneLoginResource {
	public int score;
	public List<String> reasons = new ArrayList<String>();
	
	public Risk(int score, List<String> reasons) {
		this.score = score;
		this.reasons = reasons;
	}

	public Risk(JSONObject data) {
		score = data.optInt("score");

		JSONArray jsonArrayConditions = data.getJSONArray("reasons");
		if (jsonArrayConditions != null && jsonArrayConditions.length() > 0) {
			for (int i = 0; i < jsonArrayConditions.length(); i++) {				
				reasons.add(jsonArrayConditions.getString(i));
			}
		}
	}
}