package com.onelogin.sdk.model;

import org.json.JSONObject;

public class AuthFactor extends OneLoginResource {

	protected long id;
	protected String name;
	protected String authFactorName;

	public AuthFactor(long id, String name, String authFactorName) {
		this.id = id;
		this.name = name;
		this.authFactorName = authFactorName;
	}

	public AuthFactor(long id, String name) {
		this(id, name, null);
	}
	
	public AuthFactor(JSONObject data) {
		id = data.optLong("factor_id");
		name = data.optString("name", null);
		authFactorName = data.optString("auth_factor_name", null);
	}

	public long getID() {
		return id;
	}

	public String getName()	{
		return name;
	}
	
	public String getAuthFactorName()	{
		return authFactorName;
	}
}