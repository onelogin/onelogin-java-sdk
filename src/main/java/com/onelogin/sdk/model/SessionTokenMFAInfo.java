package com.onelogin.sdk.model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;

public class SessionTokenMFAInfo {

	public User user;
	public String stateToken;
	public String callbackUrl;
	public List<Device> devices = new ArrayList<Device>(); 

	public SessionTokenMFAInfo(JSONObject data) {
		user = new User(data.getJSONObject("user"));
		stateToken = data.optString("state_token", null);
		callbackUrl = data.optString("callback_url", null);
		
		JSONArray dataArray = data.getJSONArray("devices");
		for (int i = 0; i < dataArray.length(); i++) {
			JSONObject jobj = dataArray.getJSONObject(i);
			devices.add(new Device(jobj));
		}
	}
}