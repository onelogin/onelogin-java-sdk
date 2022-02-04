package com.onelogin.sdk.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.joda.time.DateTime;
import org.json.JSONObject;

public class FactorEnrollmentResponse extends OneLoginResource {

	protected String id;
	protected long userId;
	protected long deviceId;
	protected Boolean active;
	protected String authFactorName;
	protected String typeDisplayName;
	protected String userDisplayName;
	protected String stateToken;
	protected DateTime expiresAt;
	protected Map<String, String> factorData;

	public FactorEnrollmentResponse(JSONObject data) {
		if (data.has("user_id")) {
			id = data.optString("id");
			userId = data.optLong("user_id");
		} else {
			userId = data.optLong("id");
		}

		deviceId = data.optLong("device_id");
		if (data.has("active")) {
			active = data.optBoolean("active", false);
		}
		authFactorName = data.optString("auth_factor_name", null);
		typeDisplayName = data.optString("type_display_name", null);
		userDisplayName = data.optString("user_display_name", null);
		stateToken = data.optString("state_token", null);
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

	public String geID() {
		return id;
	}

	public long getUserID() {
		return userId;
	}

	public long getDeviceID() {
		return deviceId;
	}

	public String getStateToken() {
		return stateToken;
	}

	public Boolean isActive() {
		return active;
	}

	public Map<String, Object> getFactorInfo() {
		Map<String, Object> factorInfo = new HashMap<String, Object>();
		factorInfo.put("active", active);
		factorInfo.put("stateToken", stateToken);
		factorInfo.put("authFactorName", authFactorName);
		factorInfo.put("typeDisplayName", typeDisplayName);
		factorInfo.put("userDisplayName", userDisplayName);
		factorInfo.put("expiresAt", expiresAt);
		factorInfo.put("factorData", factorData);
		return factorInfo;
	}
}
