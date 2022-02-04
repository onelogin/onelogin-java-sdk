package com.onelogin.sdk.model;

import java.util.List;
import org.json.JSONObject;

public class Mapping extends Rule {

	public Mapping(long id, String name, String match, boolean enabled, int position, List<Condition> conditions, List<Action> actions) {
		super(id, name, match, enabled, position, conditions, actions);
	}
	
	public Mapping(JSONObject data) {
		super(data);
	}
}