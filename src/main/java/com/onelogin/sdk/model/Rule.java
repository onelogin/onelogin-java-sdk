package com.onelogin.sdk.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Rule extends OneLoginResource {

	public long id;
	public String name;
	public String match;
	public boolean enabled;
	public int position;
	public List<Condition> conditions = new ArrayList<Condition>();
	public List<Action> actions = new ArrayList<Action>();

	public Rule(long id, String name, String match, boolean enabled, int position, List<Condition> conditions, List<Action> actions) {
		this.id = id;
		this.name = name;
		this.match = match;
		this.enabled = enabled;
		this.position = position;
		this.conditions = conditions;
		this.actions = actions;
	}
	
	public Rule(JSONObject data) {
		id = data.optLong("id");
		name = data.optString("name", null);
		match = data.optString("match", null);
		enabled = data.optBoolean("enabled", false);
		position = data.optInt("position");
		
		JSONArray jsonArrayConditions = data.getJSONArray("conditions");
		if (jsonArrayConditions != null && jsonArrayConditions.length() > 0) {
			for (int i = 0; i < jsonArrayConditions.length(); i++) {				
				conditions.add(new Condition(jsonArrayConditions.getJSONObject(i)));
			}
		}
		
		JSONArray jsonArrayActions = data.getJSONArray("actions");
		if (jsonArrayActions != null && jsonArrayActions.length() > 0) {
			for (int i = 0; i < jsonArrayActions.length(); i++) {				
				actions.add(new Action(jsonArrayActions.getJSONObject(i)));
			}
		}
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
					return true;
				}
        if (obj == null) {
					return false;
				}
        if (getClass() != obj.getClass()) {
					return false;
				}
        Role other = (Role) obj;
        if (id != other.id) {
					return false;
				}
        return true;
    }
}