package com.onelogin.sdk.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class MFA {

	public String stateToken;
	public String callbackUrl;
	public User user;
	public List<Device> devices;

	public MFA(JSONObject data) {
		stateToken = data.optString("state_token", null);
		callbackUrl = data.optString("callback_url", null);
		if (!data.isNull("user")) {
			JSONObject userData = data.optJSONObject("user");
   		    user = new User(userData);
		}
		if (!data.isNull("devices")) {
			devices = new ArrayList<Device>();
			JSONArray objArray = data.getJSONArray("devices");
			Device device;
			for (int i=0; i<objArray.length(); i++){
				device = new Device(objArray.getJSONObject(i));
				devices.add(device);
			}
		}
	}

	public String getStateToken() {
		return stateToken;
	}

	public String getCallbackUrl()	{
		return callbackUrl;
	}

	public User getUser()	{
		return user;
	}

	public List<Device> getDevices()	{
		return devices;
	}
}
