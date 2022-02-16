package com.onelogin.sdk.conn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.client.response.OAuthClientResponse;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.client.validator.ResourceValidator;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.utils.JSONUtils;
import com.onelogin.sdk.model.App;

import org.json.JSONArray;
import org.json.JSONObject;

public class OneloginOAuth2JSONResourceResponse extends OAuthClientResponse {

	private static boolean throwOAuthProblemException = true;
	
	private JSONArray jsonArray = null;
	private JSONObject jsonObject = null;

	public OneloginOAuth2JSONResourceResponse() {
		this.validator = new ResourceValidator();
	}

	public void init(String body, String contentType, int responseCode, Map<String, List<String>> headers)
			throws OAuthProblemException {
		setContentType(contentType);
		setResponseCode(responseCode);
		setBody(body);
		processHeaderPagination(headers);
		setHeaders(headers);

		try {
			validate();
		} catch (OAuthProblemException e) {
			if (throwOAuthProblemException) {
				throw e;
			}
		}
	}	
	
    protected void validate() throws OAuthProblemException {
        validator.validateParameters(this);
    }
	
	protected void processHeaderPagination(Map<String, List<String>> headers) {
		if (headers != null) {
			if (headers.containsKey("before-cursor")) { 
					this.parameters.put("before_cursor", headers.get("before-cursor"));
			}
			if (headers.containsKey("after-cursor")) { 
				this.parameters.put("after_cursor", headers.get("after-cursor"));
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
	
	public boolean hadSuccess() {
		return (this.responseCode == 200 || this.responseCode == 201 || this.responseCode == 204); 
	}
	
	protected void setBody(String body) throws OAuthProblemException {
		try {
			this.body = body;

			if (!body.isEmpty()) {
				if (body.startsWith("[")) {
					this.jsonArray = new JSONArray(body);
				} else {
					this.jsonObject = new JSONArray("[" + body + "]").getJSONObject(0);
					Map<String, Object> map = JSONUtils.parseJSON(body);
					this.parameters = this.transformOLData(map);
				}
			}
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

	public Object getFromContent(String name) {
		Object data = null;
		if (this.jsonObject != null && this.jsonObject.has(name)) {
			data = this.jsonObject.get(name);
		}
		return data;
	}

	public JSONObject getJSONObjectFromContent() {
		return this.jsonObject;
	}

	public JSONArray getJSONArrayFromContent() {
		return this.jsonArray;
	}

	public String getIdFromContent() {
		String resourceId = null;

		if (this.jsonArray != null) {
			resourceId = ((JSONObject) this.jsonArray.get(0)).optString("id");
		} else {
			resourceId = jsonObject.optString("id");
		}
		return resourceId;
	}

	public List<Long> getIdsFromContent() {
		List<Long> resourceIds = new ArrayList<Long>();

		if (this.jsonArray != null) {
			for(Object elem : this.jsonArray) {
				if (elem instanceof JSONObject) {
					JSONObject data = (JSONObject)elem;
					if (data.has("id")) {
						resourceIds.add(data.getLong("id"));
					}
				} else {
					resourceIds.add(Long.parseLong(elem.toString()));
				}
			}
		}
		return resourceIds;
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

	public String getTotalCount() {
		return getParam("total_count");
	}

	public String getTotalPages() {
		return getParam("total_pages");
	}

	public String getCurrentPage() {
		return getParam("current_page");
	}

	public String getPageItems() {
		return getParam("page_items");
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

		if (!hadSuccess()) {
			if (map.containsKey("statusCode")) {
				newmap.put("error", map.get("statusCode"));
	
				if (map.containsKey("message")) {
				newmap.put("error_description", map.get("message"));
				} else if (map.containsKey("name")) {
					newmap.put("error_description", map.get("name"));
				}
			} else if (map.containsKey("status")) {
				if (map.containsKey("description") && map.containsKey("error")) {
					newmap.put("error", map.get("status"));
					newmap.put("error_description", map.get("description"));
				} else {
					newmap.put("error", ((JSONObject)map.get("status")).get("code"));
					newmap.put("error_description", ((JSONObject)map.get("status")).get("message"));
				}
			} else if (map.containsKey("message")) {
				newmap.put("error_description", map.get("message"));
				if (map.get("message").toString().contains("unknown attribute")) {
					newmap.put("error_attribute", map.get("messages").toString().replace("unknown attribute", ""));
				} else if (map.containsKey("errors")) {
					// https://developers.onelogin.com/api-docs/2/user-mappings/create-mapping
					Object[] message_errors =  (Object[])map.get("errors");
					List<String> errors = new ArrayList<String>();
					int i;
					JSONObject errorJson;
					JSONArray errorDetailJsonArray;
					List<String> auxList;
					String field, error_detail;
					for (i=0; i < message_errors.length; i++) {
						errorJson = (JSONObject)message_errors[i];
						field = errorJson.get("field").toString();
						errorDetailJsonArray = (JSONArray)errorJson.get("message");
						auxList = new ArrayList<String>();
						for (int j=0; j<errorDetailJsonArray.length(); j++) {
							auxList.add( errorDetailJsonArray.getString(j) );
						}
						error_detail = StringUtils.join(auxList, ". ");
						errors.add("Field: " + field + " - " + error_detail);
					}
					newmap.put("error_attribute", StringUtils.join(errors, ". "));
				}
		    } else if (map.keySet().contains("messages")) {
		    	Object[] objArray = (Object[])map.get("messages");
				newmap.put("error_description", StringUtils.join(objArray, " | "));                 
			} else if (map.keySet().contains("name")) {
				newmap.put("error_description", map.get("name"));                 
			}
		}
		return newmap;
	}

	public static void enableThrowingOAuthProblemException(boolean value) {
		throwOAuthProblemException = value;
	}
}