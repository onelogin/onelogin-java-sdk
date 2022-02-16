package com.onelogin.sdk.model;

import org.json.JSONObject;

public class RiskScoreInsights extends OneLoginResource {
	public Score scores;
	public int total;
	
	public RiskScoreInsights(Score scores, int total) {
		this.scores = scores;
		this.total = total;
	}

	public RiskScoreInsights(JSONObject data) {
		JSONObject scoreData = data.optJSONObject("scores");
		scores = new Score(scoreData);
		total = data.optInt("total");		
	}
}