package com.onelogin.sdk.model;

import org.json.JSONObject;

public class Mapping extends OneLoginResource {

	public long id;
	
	public Mapping(JSONObject data) {
		id = data.getLong("id");
	}
	
}