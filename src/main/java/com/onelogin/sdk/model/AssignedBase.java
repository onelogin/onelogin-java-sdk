package com.onelogin.sdk.model;

import org.joda.time.DateTime;
import org.json.JSONObject;

public class AssignedBase extends OneLoginResource {
	public long id;
	public String name;
	public String email;
	public String username;
	public Boolean assigned;
	public long added_by_id;
	public String added_by_name;
	public DateTime added_at;

	
	public AssignedBase(JSONObject data) {
		id = data.optLong("id");
		name = data.optString("name", null);
		email = data.optString("email", null);
		username = data.optString("username", null);
		assigned = data.optBoolean("assigned", false);
		if (data.has("added_by")) {
			JSONObject addedBy = data.getJSONObject("added_by");
			if (addedBy != null) {
				added_by_id = addedBy.optLong("id");
				added_by_name = addedBy.optString("name", null);
			}
		}
		added_at = (data.optString("added_at", null) == null)? null : DateTime.parse(data.getString("added_at"));
	}
}