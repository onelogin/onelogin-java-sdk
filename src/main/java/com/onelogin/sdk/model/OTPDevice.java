package com.onelogin.sdk.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.joda.time.DateTime;
import org.json.JSONObject;

public class OTPDevice extends OneLoginResource {

	public String id;
	public Boolean active;
	public Boolean defaultDevice;
	public String authFactorName;
	public String typeDisplayName;
	public Boolean needsTrigger;
	public String userDisplayName;
	public String stateToken;
	public String phone;
	public String status;
	public DateTime expiresAt;
	public Map<String, String> factorData;

	public OTPDevice(JSONObject data) {
		id = data.optString("id", data.optString("device_id", null));
		if (data.has("active")) {
			active = data.optBoolean("active", false);
		}
		if (data.has("needs_trigger")) {
			needsTrigger = data.optBoolean("needs_trigger", false);
		}
		authFactorName = data.optString("auth_factor_name", null);
		typeDisplayName = data.optString("type_display_name", null);
		userDisplayName = data.optString("user_display_name", null);
		defaultDevice = data.optBoolean("default", false);
		stateToken = data.optString("state_token", null);
		phone = data.optString("phone_number", null);
		if (data.has("status")) {
			status = data.optString("status", null);
			if (status.equals("accepted")) {
				active = data.optBoolean("active", true);
			}
		}
		if (data.has("expires_at")) {
			expiresAt = (data.optString("expires_at" , null) == null)? null : DateTime.parse(data.getString("expires_at"));
		}
		if (data.has("factor_data")) {
			factorData = new HashMap<String, String>();
			JSONObject extractedFactorData = data.getJSONObject("factor_data");
			Iterator<String> keys = extractedFactorData.keys();
			while(keys.hasNext()) {
			    String key = keys.next();
			    factorData.put(key, (String) extractedFactorData.get(key));			    
			}
		}
	}
}