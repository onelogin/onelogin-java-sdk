package com.onelogin.sdk.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Privilege extends OneLoginResource {

	public String id;
	public String name;
	public String version;
	public List<Statement> statements = new ArrayList<Statement>();

	public Privilege(JSONObject data) {
		id = data.optString("id");
		name = data.optString("name", null);
		JSONObject privilege = (JSONObject)data.get("privilege");
		if (privilege != null) {
			version = privilege.optString("Version", null);
			JSONArray jsonArray = privilege.getJSONArray("Statement");
			if (jsonArray != null && jsonArray.length() > 0) {
				for (int i = 0; i < jsonArray.length(); i++) {				
					statements.add(new Statement(jsonArray.getJSONObject(i)));
				}
			}
		}
	}
	
	public Privilege(String id, String name, String version, List<?> statements) {
		this.id = id;
		this.name = name;
		this.version = version;
		if (!statements.isEmpty()) {
			if (statements.get(0) instanceof Statement) {
				this.statements = (List<Statement>) statements;
			} else if (statements.get(0) instanceof HashMap) {
				List<HashMap<String, Object>> data = (List<HashMap<String, Object>>) statements;
				if (data.get(0).containsKey("Effect") && data.get(0).containsKey("Action") && data.get(0).containsKey("Scope")) {
					for (HashMap<String, Object> statement: data) {
						this.statements.add(new Statement(statement.get("Effect").toString(), (List<String>)statement.get("Action"), (List<String>)statement.get("Scope")));
					}
				}
			}
		}
	}
}
