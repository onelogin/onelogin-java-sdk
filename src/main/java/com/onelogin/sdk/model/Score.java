package com.onelogin.sdk.model;

import org.json.JSONObject;

public class Score {
	 public int minimal;
	 public int low;
	 public int medium;
	 public int high;
	 public int very_high;
     
     public Score(JSONObject data) {
    	 minimal = data.getInt("minimal");
    	 low = data.getInt("low");
    	 medium = data.getInt("medium");
    	 high = data.getInt("high");
    	 very_high = data.getInt("very_high");
 	}
}