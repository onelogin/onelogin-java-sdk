package com.onelogin.sdk.conn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.oltu.oauth2.client.response.OAuthClientResponse;
import org.apache.oltu.oauth2.client.validator.ResourceValidator;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.utils.JSONUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class OneloginOAuthJSONResourceResponse extends OAuthClientResponse {

	private static boolean throwOAuthProblemException = true;

	public OneloginOAuthJSONResourceResponse() {
		this.validator = new ResourceValidator();
	}

	protected void init(String body, String contentType, int responseCode, Map<String, List<String>> headers)
			throws OAuthProblemException {
		setBody(body);
		setContentType(contentType);
		setResponseCode(responseCode);
		setHeaders(headers);

		try {
			validate();
		} catch (OAuthProblemException e) {
			if (throwOAuthProblemException) {
				throw e;
			}
		}
	}	
	
	public String getBody() {
		return this.body;
	}

	public int getResponseCode() {
		return this.responseCode;
	}

	public String getContentType() {
		return this.contentType;
	}

	protected void setBody(String body) throws OAuthProblemException {
		try {
			this.body = body;

			this.parameters = this.transformOLData(JSONUtils.parseJSON(body));
		} catch (Throwable e) {
			throw OAuthProblemException.error("unsupported_response_type",
					"Invalid response! Response body is not application/json encoded or has non expected values");
		}
	}

	public Map<String, List<String>> getHeaders() {
		return this.headers;
	}

	protected void setContentType(String contentType) {
		this.contentType = contentType;
	}

	protected void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public JSONObject getData() {
		JSONObject data = null;
		if (this.parameters.containsKey("data")) {
			try {
				data = (JSONObject) this.parameters.get("data");
			} catch (Exception e){
				Object[] objArray = (Object[])this.parameters.get("data");
				data = (JSONObject) objArray[0];
			}
		}
		return data;
	}

	public JSONObject[] getDataArray() {
		JSONObject[] jsonArray = null;
		if (this.parameters.containsKey("data")) {
			ArrayList<JSONObject> data = new ArrayList<JSONObject>();
			Object[] objArray = (Object[])this.parameters.get("data");

			if (objArray.length == 1 && objArray[0].getClass().getName().equals("org.json.JSONArray") && ((JSONArray)objArray[0]).length() == 0) {
				return jsonArray;
			}

			for (Object obj: objArray) {
				JSONObject jobj = (JSONObject)obj;
				data.add(jobj);
			}
			if (data.size() > 0) {
				jsonArray = data.toArray(new JSONObject[data.size()]);
			}
		}

		return jsonArray;
	}

	public String getStringFromData() {
		String data = null;
		if (this.parameters.containsKey("data")) {
			data = (String) this.parameters.get("data");
		}
		return data;
	}

	public Object[] getArrayFromData() {
		Object[] objArray = null;
		if (this.parameters.containsKey("data")) {
			objArray = (Object[])this.parameters.get("data");
		}
		return objArray;
	}
	
	public List<Integer> getIdsFromData() {
		List<Integer> idList = new ArrayList<Integer>();
		if (this.parameters.containsKey("data")) {
			Object[] objArray = (Object[])this.parameters.get("data");
			for (Object obj: objArray) {
				JSONArray array = (JSONArray)obj;
				for(int n = 0; n < array.length(); n++) {
				    Integer object = (Integer) array.getInt(n);
				    idList.add(object);
				}
			}
		}

		return idList;
	}

	public List<String> getValuesFromData() {
		List<String> idValues = new ArrayList<String>();
		if (this.parameters.containsKey("data")) {
			Object[] objArray = (Object[])this.parameters.get("data");
			for (Object obj: objArray) {
				JSONArray array = (JSONArray)obj;
				for(int n = 0; n < array.length(); n++) {
					String object = array.getString(n);
					idValues.add(object);
				}
			}
		}

		return idValues;
	}

	public String getBeforeCursor() {
		String value = getParam("before_cursor");
		if (value == "null") {
			return null;
		} else {
			return value;
		}
	}

	public String getAfterCursor() {
		String value = getParam("after_cursor");
		if (value == "null") {
			return null;
		} else {
			return value;
		}
	}

	public String getPreviousLink() {
		return getParam("previous_link");
	}

	public String getNextLink() {
		return getParam("next_link");
	}

	public String getError() {
		return getParam("error");
	}

	public String getErrorDescription() {
		return getParam("error_description");
	}

	public String getErrorAttribute() {
		return getParam("error_attribute");
	}

	public String getType() {
		return getParam("type");
	}

	public String getMessage() {
		return getParam("message");
	}

	protected Map<String, Object> transformOLData(Map<String, Object> map)
	{
		Map<String, Object> newmap = new HashMap<String, Object>();

		if (map.keySet().contains("data")) {
			newmap.put("data", map.get("data"));
		}

		if (map.keySet().contains("status")) {
			JSONObject status = (JSONObject) map.get("status");
			Boolean error = status.getBoolean("error");
			if (error) {
				newmap.put("error", status.get("type"));
				newmap.put("state", status.get("code"));
				if (status.get("message") instanceof JSONObject) {
					if (((JSONObject)status.get("message")).optString("description", null) != null) {
						newmap.put("error_description", ((JSONObject)status.get("message")).get("description"));
					}
					if (((JSONObject)status.get("message")).optString("attribute", null) != null) {
						newmap.put("error_attribute", ((JSONObject)status.get("message")).get("attribute"));
					}
				} else {
					newmap.put("error_description", status.get("message"));
				}
			} else {
				if (status.optString("type", null) != null) {
					newmap.put("type", status.getString("type"));
				}
				if (status.optString("message", null) != null) {
					newmap.put("message", status.getString("message"));
				}
			}
		}

		if (map.keySet().contains("pagination")) {
			JSONObject pagination = (JSONObject) map.get("pagination");
			newmap.put("before_cursor", pagination.get("before_cursor"));
			newmap.put("after_cursor", pagination.get("after_cursor"));
			newmap.put("previous_link", pagination.get("previous_link"));
			newmap.put("next_link", pagination.get("next_link"));
		}
		return newmap;
	}

	public static void enableThrowingOAuthProblemException(boolean value) {
		throwOAuthProblemException = value;
	}
}