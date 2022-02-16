package com.onelogin.sdk.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class RiskScore extends OneLoginResource {
	public int score;
	public List<String> triggers = new ArrayList<String>();
	public List<String> messages = new ArrayList<String>();
	
	public RiskScore(int score, List<String> triggers, List<String> messages) {
		this.score = score;
		this.triggers = triggers;
		this.messages = messages;
	}

	public RiskScore(JSONObject data) {
		score = data.optInt("score");

		JSONArray jsonArrayTriggers = data.getJSONArray("messages");
		if (jsonArrayTriggers != null && jsonArrayTriggers.length() > 0) {
			for (int i = 0; i < jsonArrayTriggers.length(); i++) {				
				triggers.add(jsonArrayTriggers.getString(i));
			}
		}
		
		JSONArray jsonArrayMessages = data.getJSONArray("messages");
		if (jsonArrayMessages != null && jsonArrayMessages.length() > 0) {
			for (int i = 0; i < jsonArrayMessages.length(); i++) {				
				messages.add(jsonArrayMessages.getString(i));
			}
		}
	}
}