package com.onelogin.sdk.conn;

import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.exception.OAuthRuntimeException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.oltu.oauth2.common.utils.JSONUtils;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.onelogin.sdk.exception.Error;
import com.onelogin.sdk.model.App;
import com.onelogin.sdk.model.EmbedApp;
import com.onelogin.sdk.model.Event;
import com.onelogin.sdk.model.EventType;
import com.onelogin.sdk.model.Group;
import com.onelogin.sdk.model.MFA;
import com.onelogin.sdk.model.RateLimit;
import com.onelogin.sdk.model.Role;
import com.onelogin.sdk.model.SAMLEndpointResponse;
import com.onelogin.sdk.model.SessionTokenInfo;
import com.onelogin.sdk.model.SessionTokenMFAInfo;
import com.onelogin.sdk.model.User;
import com.onelogin.sdk.util.Constants;
import com.onelogin.sdk.util.Settings;


public class Client {

	public static final String VERSION = "1.0.0";

	public static final String CUSTOM_USER_AGENT = "onelogin-java-sdk " + VERSION;

	/**
	 * OAuth 2.0 Access Token
	 */
	protected String accessToken;

	/**
	 * OAuth 2.0 Refresh Token
	 */
	protected String refreshToken;

	/**
	 * OAuth 2.0 Token expiration
	 */
	protected DateTime expiration;

	/**
	 * Last error found
	 */
	protected String error;

	/**
	 * Description of last error found
	 */
	protected String errorDescription;

	/**
	 * Settings object
	 */		
	protected Settings settings;

	/**
	 * The User-Agent to be used on requests
	 */
	public String userAgent;

	/**
	 * Constructs the client to execute Onelogin's API calls.
	 * It initializes the Settings (read Onelogin's credentials
	 * and the region from the config file)
	 *
	 * @throws IOException
	 * @throws Error
	 */
	public Client() throws IOException, Error {
		this.settings = new Settings();
		this.userAgent = CUSTOM_USER_AGENT;
	}

	////////////////////////////////
	//  OAuth 2.0 Tokens Methods  //
	////////////////////////////////

	/**
  	 * Generates an access token and refresh token that you may use to call Onelogin's API methods.
  	 *
  	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/oauth20-tokens/generate-tokens">Generate Tokens documentation</a>
	 */
	public void getAccessToken() throws OAuthSystemException, OAuthProblemException {
		cleanError();
		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		//OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest request = OAuthClientRequest
			.tokenLocation(settings.getURL(Constants.TOKEN_REQUEST_URL))            
            //.setGrantType(GrantType.CLIENT_CREDENTIALS)
            .buildBodyMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization(false));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("grant_type", GrantType.CLIENT_CREDENTIALS);
		String body = JSONUtils.buildJSON(params);
		request.setBody(body);

		// I can't use because OAuthClient 1.0.2 Line 28 overrides Content-Type 
		// request.setHeader(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		// request.setHeader(OAuth.HeaderType.AUTHORIZATION, "client_id:"+this.settings.getClientId()+", client_secret:"+this.settings.getClientSecret());
		// OAuthJSONAccessTokenResponse oAuthResponse = oAuthClient.accessToken(request, OAuth.HttpMethod.POST, OAuthJSONAccessTokenResponse.class);
		OneloginOAuthJSONAccessTokenResponse oAuthResponse = (OneloginOAuthJSONAccessTokenResponse) httpClient.execute(request, headers, OAuth.HttpMethod.POST, OneloginOAuthJSONAccessTokenResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			accessToken = oAuthResponse.getAccessToken();
			refreshToken = oAuthResponse.getRefreshToken();
			Long expiresIn = oAuthResponse.getExpiresIn();
			expiration = null;
			if (expiresIn != null) {
				expiration = new DateTime(System.currentTimeMillis() + (expiresIn * 1000));
			}
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
	}

	/**
  	 * Refreshing tokens provides a new set of access and refresh tokens.
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/oauth20-tokens/refresh-tokens">Refresh Tokens documentation</a>
	 */
	public void refreshToken() throws OAuthSystemException, OAuthProblemException {
		cleanError();
		if (accessToken == null || refreshToken == null) {
			throw new OAuthRuntimeException("Access token ot Refresh token not provided");
		}

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClientRequest request = OAuthClientRequest
			.tokenLocation(settings.getURL(Constants.TOKEN_REFRESH_URL))            
            .buildBodyMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("grant_type", GrantType.REFRESH_TOKEN);
		params.put("access_token", accessToken);
		params.put("refresh_token", refreshToken);
		String body = JSONUtils.buildJSON(params);
		request.setBody(body);

		OneloginOAuthJSONAccessTokenResponse oAuthResponse = (OneloginOAuthJSONAccessTokenResponse) httpClient.execute(request, headers, OAuth.HttpMethod.POST, OneloginOAuthJSONAccessTokenResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			accessToken = oAuthResponse.getAccessToken();
			refreshToken = oAuthResponse.getRefreshToken();
			Long expiresIn = oAuthResponse.getExpiresIn();
			expiration = null;
			if (expiresIn != null) {
				expiration = new DateTime(System.currentTimeMillis() + (expiresIn * 1000));
			}
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
	}

	/**
  	 * Revokes an access token and refresh token pair.
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/oauth20-tokens/revoke-tokens">Revoke Tokens documentation</a>
	 */
	public void revokeToken() throws OAuthSystemException, OAuthProblemException {
		cleanError();
		if (accessToken == null) {
			throw new OAuthRuntimeException("Access token not provided");
		}

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClientRequest request = OAuthClientRequest
			.tokenLocation(settings.getURL(Constants.TOKEN_REVOKE_URL))            
            .buildBodyMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization(false));
		headers.put("User-Agent", this.userAgent);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("access_token", accessToken);
		String body = JSONUtils.buildJSON(params);
		request.setBody(body);

		OneloginOAuthJSONAccessTokenResponse oAuthResponse = (OneloginOAuthJSONAccessTokenResponse) httpClient.execute(request, headers, OAuth.HttpMethod.POST, OneloginOAuthJSONAccessTokenResponse.class);

		if (oAuthResponse.getResponseCode() == 200) {
			accessToken = null;
			refreshToken = null;
			expiration = null;
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
	}

	/**
  	 * Gets current rate limit details about an access token.
  	 *
  	 * @return RateLimit object
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
	 *
  	 * @see com.onelogin.sdk.model.RateLimit
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/oauth20-tokens/get-rate-limit">Get Rate Limit documentation</a>
	 */
	public RateLimit getRateLimit() throws OAuthSystemException, OAuthProblemException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(settings.getURL(Constants.GET_RATE_URL))
			//.setAccessToken(accessToken) // 'Authorization' => 'Bearer xxxx' not accepted right now
            .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);		

		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
		RateLimit ratelimit = null;
		if (oAuthResponse.getResponseCode() == 200) {
			JSONObject data = oAuthResponse.getData();
			if (data != null) {
				ratelimit = new RateLimit(data);
			}
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return ratelimit;
	}

	////////////////////
	//  User Methods  //
	////////////////////

	/**
  	 * Gets a list of User resources. (if no limit provided, by default get 50 elements)
  	 *
	 * @param queryParameters
	 *            Parameters to filter the result of the list
  	 *
  	 * @return List of User
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.User
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 */
	public List<User> getUsers(HashMap<String, String> queryParameters) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		int limit = 50;
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_USERS_URL));
		for (Map.Entry<String,String> parameter: queryParameters.entrySet()) {
			if (parameter.getKey() == "limit") {
				limit = Integer.parseInt(parameter.getValue());
				if (limit >= 50) {
					// We don't add limit if is more than 50, API call have that limitation
					continue;
				}
			}
			url.addParameter(parameter.getKey(), parameter.getValue());
		}

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		OneloginOAuthJSONResourceResponse oAuthResponse = null;
		String afterCursor = null;
		List<User> users = new ArrayList<User>();
		while (oAuthResponse == null || (users.size() < limit && afterCursor != null)) {
			oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
			if (oAuthResponse.getResponseCode() == 200) {
				JSONObject[] dataArray = oAuthResponse.getDataArray();
				if (dataArray != null && dataArray.length > 0) {
					User user;
					for (JSONObject data: dataArray) {
						if (users.size() < limit) {
							user = new User(data);
							users.add(user);
						} else {
							return users;
						}
					}					
				}

				afterCursor = oAuthResponse.getAfterCursor();
				if (afterCursor != null && !afterCursor.isEmpty()) {
					url.setParameter("after_cursor", oAuthResponse.getAfterCursor());
					bearerRequest.setLocationUri(url.toString());
				}
			} else {
				error = oAuthResponse.getError();
				errorDescription = oAuthResponse.getErrorDescription();
				break;
			}
		}

		return users;
	}

	/**
  	 * Gets a list of User resources (50 users).
  	 *
  	 * @return List of User
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.User
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 */
	public List<User> getUsers() throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		HashMap<String, String> queryParameters = new HashMap<String, String>();
		return getUsers(queryParameters);
	}

	/**
  	 * Gets User by ID.
  	 *
	 * @param id
	 *            Id of the user
  	 *
  	 * @return User
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.User
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-user-by-id">Get User by ID documentation</a>
	 */
	public User getUser(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_USER_URL, Long.toString(id)));		

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		User user = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			JSONObject data = oAuthResponse.getData();
			user = new User(data);
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return user;
	}

	/**
  	 * Gets a list of apps accessible by a user, not including personal apps.
  	 *
	 * @param id
	 *            Id of the user
  	 *
  	 * @return List of Apps
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.App
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-apps-for-user">Get Apps for a User documentation</a>
	 */
	public List<App> getUserApps(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_APPS_FOR_USER_URL, Long.toString(id)));		

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		List<App> apps = new ArrayList<App>();
		App app = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			JSONObject[] dataArray = oAuthResponse.getDataArray();
			if (dataArray != null && dataArray.length > 0) {
				for (JSONObject data: dataArray) {
					app = new App(data);
					apps.add(app);					
				}					
			}
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return apps;
	}

	/**
  	 * Gets a list of role IDs that have been assigned to a user.
  	 *
	 * @param id
	 *            Id of the user
  	 *
  	 * @return List of Role Ids
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.Role
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-roles-for-user">Get Roles for a User documentation</a>
	 */
	public List<Integer> getUserRoles(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_ROLES_FOR_USER_URL, Long.toString(id)));		

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		List<Integer> roles = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			roles = oAuthResponse.getIdsFromData();
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return roles;
	}

	/**
  	 * Gets a list of all custom attribute fields (also known as custom user fields) that have been defined for OL account.
  	 *
  	 * @return List of custom attribute fields
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-custom-attributes">Get Custom Attributes documentation</a>
	 */
	public List<String> getCustomAttributes() throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_CUSTOM_ATTRIBUTES_URL));		

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		List<String> customAttributes = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			customAttributes = oAuthResponse.getValuesFromData();
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return customAttributes;
	}

	/**
  	 * Creates an user
  	 *
	 * @param userParams
	 *            User data (firstname, lastname, email, username, company, department, directory_id, distinguished_name,
	 *            external_id, group_id, invalid_login_attempts, locale_code, manager_ad_id, member_of, notes, openid_name,
	 *            phone, samaccountname, title, userprincipalname)
	 *
	 * @return Created user
	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/create-user">Create User documentation</a>
	 */
	public User createUser(Map<String, Object> userParams) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.CREATE_USER_URL));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		String body = JSONUtils.buildJSON(userParams);
		bearerRequest.setBody(body);

		User user = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			if (oAuthResponse.getType().equals("success")) {
				if (oAuthResponse.getMessage().equals("Success")) {
					JSONObject data = oAuthResponse.getData();
					user = new User(data);
				}
			}
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return user;		
	}

	/**
  	 * Generates a session login token in scenarios in which MFA may or may not be required.
  	 * A session login token expires two minutes after creation.
  	 *
	 * @param queryParams
	 *            Query Parameters (username_or_email, password, subdomain, return_to_url, ip_address, browser_id)
	 * @param allowedOrigin
	 *            Custom-Allowed-Origin-Header. Required for CORS requests only. Set to the Origin URI from which you are allowed to send a request using CORS.
	 *
	 * @return SessionTokenInfo or SessionTokenMFAInfo object if success
	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/create-session-login-token">Create Session Login Token documentation</a>
	 */
	public Object createSessionLoginToken(Map<String, Object> queryParams, String allowedOrigin) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.SESSION_LOGIN_TOKEN_URL));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		if (allowedOrigin != null) {
			headers.put("Custom-Allowed-Origin-Header-1", allowedOrigin);
		}
		bearerRequest.setHeaders(headers);

		String body = JSONUtils.buildJSON(queryParams);
		bearerRequest.setBody(body);

		Object sessionToken = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			if (oAuthResponse.getType().equals("success")) {
				JSONObject data = oAuthResponse.getData();
				if (oAuthResponse.getMessage().equals("Success")) {					
					sessionToken = new SessionTokenInfo(data);
				} else if (oAuthResponse.getMessage().equals("MFA is required for this user")) {
					sessionToken = new SessionTokenMFAInfo(data);
				}
			}
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return sessionToken;		
	}

	/**
  	 * Generate a session login token in scenarios in which MFA may or may not be required.
  	 * A session login token expires two minutes after creation.
  	 *
	 * @param queryParams
	 *            Query Parameters (username_or_email, password, subdomain, return_to_url, ip_address, browser_id)
	 *
	 * @return SessionTokenInfo or SessionTokenMFAInfo object if success
	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/create-session-login-token">Create Session Login Token documentation</a>
	 */
	public Object createSessionLoginToken(Map<String, Object> queryParams) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return createSessionLoginToken(queryParams, null);
	}

	/**
  	 * Verify a one-time password (OTP) value provided for multi-factor authentication (MFA).
  	 *
	 * @param devideId
	 *            Provide the MFA device_id you are submitting for verification.  
	 * @param stateToken
	 *            Provide the state_token associated with the MFA device_id you are submitting for verification.
	 * @param otpToken
	 *            Provide the OTP value for the MFA factor you are submitting for verification.
  	 *
  	 * @return Session Token
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/verify-factor">Verify Factor documentation</a>
	 */
	public SessionTokenInfo getSessionTokenVerified(String devideId, String stateToken, String otpToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_TOKEN_VERIFY_FACTOR));		

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("device_id", devideId);
		params.put("state_token", stateToken);

		if (otpToken != null && !otpToken.isEmpty()) {
			params.put("otp_token", otpToken);
		}
		String body = JSONUtils.buildJSON(params);
		bearerRequest.setBody(body);

		SessionTokenInfo sessionToken = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class);		
		if (oAuthResponse.getResponseCode() == 200) {
			if (oAuthResponse.getType().equals("success")) {
				if (oAuthResponse.getMessage().equals("Success")) {
					JSONObject data = oAuthResponse.getData();
					sessionToken = new SessionTokenInfo(data);
				}
			}
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return sessionToken;
	}

	/**
  	 * Verify a one-time password (OTP) value provided for multi-factor authentication (MFA).
  	 *
	 * @param devideId
	 *            Provide the MFA device_id you are submitting for verification.  
	 * @param stateToken
	 *            Provide the state_token associated with the MFA device_id you are submitting for verification.
  	 *
  	 * @return Session Token
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/verify-factor">Verify Factor documentation</a>
	 */
	public SessionTokenInfo getSessionTokenVerified(String devideId, String stateToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getSessionTokenVerified(devideId, stateToken, null);
	}
	
	/**
  	 * Post a session token to this API endpoint to start a session and set a cookie to log a user into an app.
  	 *
	 * @param sessionToken
	 *            The session token
	 *
	 @return Header 'Set-Cookie' value
	 *
  	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 *
	 * @see <a target="_blank" href="https://github.com/onelogin/onelogin-api-examples/blob/master/php/users/session_via_api_token.php">Create Session Via API Token documentation</a>
	 */
	public String createSessionViaToken(String sessionToken) throws URISyntaxException, ClientProtocolException, IOException {
		URIBuilder url = new URIBuilder(settings.getURL(Constants.SESSION_API_TOKEN_URL));

		CloseableHttpClient httpclient = HttpClients.createDefault(); 
		HttpPost httpPost = new HttpPost(url.toString());
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("session_token", sessionToken);
		String body = JSONUtils.buildJSON(queryParams);
		StringEntity input = new StringEntity(body);
		input.setContentType("application/json;charset=UTF-8");
		httpPost.setEntity(input);
        input.setContentEncoding(new BasicHeader("Content-Type","application/json;charset=UTF-8"));
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("User-Agent", this.userAgent);
        httpPost.setEntity(input); 
        CloseableHttpResponse response = httpclient.execute(httpPost);
        String cookieHeader = null;
        if (response.getHeaders("Set-Cookie").length > 0) {
        	cookieHeader = response.getHeaders("Set-Cookie")[0].getValue();
        }

        return cookieHeader;
	}

	/**
  	 * Updates an user
  	 *
	 * @param id
	 *            Id of the user to be modified
	 * @param userParams
	 *            User data (firstname, lastname, email, username, company, department, directory_id, distinguished_name,
	 *            external_id, group_id, invalid_login_attempts, locale_code, manager_ad_id, member_of, notes, openid_name,
	 *            phone, samaccountname, title, userprincipalname)
	 *
	 * @return Updated user
	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/update-user">Update User by ID documentation</a>
	 */
	public User updateUser(long id, Map<String, Object> userParams) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.UPDATE_USER_URL, Long.toString(id)));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		String body = JSONUtils.buildJSON(userParams);
		bearerRequest.setBody(body);

		User user = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.PUT, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			if (oAuthResponse.getType().equals("success")) {
				if (oAuthResponse.getMessage().equals("Success")) {
					JSONObject data = oAuthResponse.getData();
					user = new User(data);
				}
			}
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return user;		
	}

	/**
  	 * Assigns Role to User
  	 *
	 * @param id
	 *            Id of the user to be modified
	 * @param roleIds
	 *            Set to an array of one or more role IDs.
	 *
	 * @return true if success
	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/assign-role-to-user">Assign Role to User documentation</a>
	 */
	public Boolean assignRoleToUser(long id, List<Long> roleIds) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.ADD_ROLE_TO_USER_URL, Long.toString(id)));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("role_id_array", roleIds);

		String body = JSONUtils.buildJSON(params);
		bearerRequest.setBody(body);

		Boolean success = true;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.PUT, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200) {
			success = false;
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return success;		
	}

	/**
  	 * Remove Role from User
  	 *
	 * @param id
	 *            Id of the user to be modified
	 * @param roleIds
	 *            Set to an array of one or more role IDs.
	 *
	 * @return true if success
	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/remove-role-from-user">Remove Role from User documentation</a>
	 */
	public Boolean removeRoleFromUser(long id, List<Long> roleIds) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.DELETE_ROLE_TO_USER_URL, Long.toString(id)));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("role_id_array", roleIds);

		String body = JSONUtils.buildJSON(params);
		bearerRequest.setBody(body);

		Boolean success = true;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.PUT, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200) {
			success = false;
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return success;		
	}

	/**
  	 * Sets Password by ID Using Cleartext
  	 *
	 * @param id
	 *            Id of the user to be modified
	 * @param password
	 *            Set to the password value using cleartext.
	 * @param passwordConfirmation
	 *            Ensure that this value matches the password value exactly.
	 *
	 * @return true if success
	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/set-password-in-cleartext">Set Password by ID Using Cleartext documentation</a>
	 */
	public Boolean setPasswordUsingClearText(long id, String password, String passwordConfirmation) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.SET_PW_CLEARTEXT, Long.toString(id)));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("password", password);
		params.put("password_confirmation", passwordConfirmation);

		String body = JSONUtils.buildJSON(params);
		bearerRequest.setBody(body);

		Boolean success = true;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.PUT, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200) {
			success = false;
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return success;		
	}

	/**
  	 * Set Password by ID Using Salt and SHA-256
  	 *
	 * @param id
	 *            Id of the user to be modified
	 * @param password
	 *            Set to the password value using a SHA-256-encoded value.
	 * @param passwordConfirmation
	 *            This value must match the password value.
	 * @param passwordAlgorithm
	 *            Set to salt+sha256.
	 * @param passwordSalt
	 *            To provide your own salt value.            
	 *
	 * @return true if success
	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/set-password-using-sha-256">Set Password by ID Using Salt and SHA-256 documentation</a>
	 */
	public Boolean setPasswordUsingHashSalt(long id, String password, String passwordConfirmation, String passwordAlgorithm, String passwordSalt) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.SET_PW_SALT, Long.toString(id)));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("password", password);
		params.put("password_confirmation", passwordConfirmation);
		params.put("password_algorithm", passwordAlgorithm);
		if (passwordSalt != null && !passwordSalt.isEmpty()) {
			params.put("password_salt", passwordSalt);
		}

		String body = JSONUtils.buildJSON(params);
		bearerRequest.setBody(body);

		Boolean success = true;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.PUT, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200) {
			success = false;
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return success;		
	}

	/**
  	 * Set Password by ID Using Salt and SHA-256
  	 *
	 * @param id
	 *            Id of the user to be modified
	 * @param password
	 *            Set to the password value using a SHA-256-encoded value.
	 * @param passwordConfirmation
	 *            This value must match the password value.
	 * @param passwordAlgorithm
	 *            Set to salt+sha256.
	 *
	 * @return true if success
	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/set-password-using-sha-256">Set Password by ID Using Salt and SHA-256 documentation</a>
	 */
	public Boolean setPasswordUsingHashSalt(long id, String password, String passwordConfirmation, String passwordAlgorithm) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return setPasswordUsingHashSalt(id, password, passwordConfirmation, passwordAlgorithm, null);
	}

	/**
  	 * Set Custom Attribute Value
  	 *
	 * @param id
	 *            Id of the user to be modified
	 * @param customAttributes
	 *            Provide one or more key value pairs composed of the custom attribute field shortname and the value that you want to set the field to.
	 *
	 * @return true if success
	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/set-custom-attribute">Set Custom Attribute Value documentation</a>
	 */
	public Boolean setCustomAttributeToUser(long id, Map<String, Object> customAttributes) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.SET_CUSTOM_ATTRIBUTE_TO_USER_URL, Long.toString(id)));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("custom_attributes", (Object)customAttributes);

		String body = JSONUtils.buildJSON(params);
		bearerRequest.setBody(body);

		Boolean success = true;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.PUT, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200) {
			success = false;
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return success;		
	}

	/**
  	 * Log a user out of any and all sessions.
  	 *
	 * @param id
	 *            Id of the user to be modified
	 *
	 * @return true if success
	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/log-user-out">Log User Out documentation</a>
	 */
	public Boolean logUserOut(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.LOG_USER_OUT_URL, Long.toString(id)));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		Boolean success = true;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.PUT, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200) {
			success = false;
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return success;		
	}

	/**
  	 * Use this call to lock a user’s account based on the policy assigned to the user,
  	 * for a specific time you define in the request, or until you unlock it.
  	 *
	 * @param id
	 *            Id of the user to be modified
	 * @param minutes
	 *            Set to the number of minutes for which you want to lock the user account. (0 to delegate on policy)
  	 *
	 * @return true if success
	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/lock-user-account">Lock User Account documentation</a>
	 */
	public Boolean lockUser(long id, int minutes) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.LOCK_USER_URL, Long.toString(id)));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("locked_until", minutes);
		String body = JSONUtils.buildJSON(params);
		bearerRequest.setBody(body);
		
		Boolean success = true;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.PUT, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200) {
			success = false;
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return success;		
	}

	/**
  	 * Deletes an user
  	 *
	 * @param id
	 *            Id of the user to be deleted
	 *
	 * @return true if success
	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/delete-user">Delete User by ID documentation</a>
	 */
	public Boolean deleteUser(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.DELETE_USER_URL, Long.toString(id)));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		Boolean removed = true;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.DELETE, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200) {
			removed = false;
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		
		return removed;
	}

	////////////////////
	//  Role Methods  //
	////////////////////

	/**
  	 * Gets a list of Role resources. (if no limit provided, by default get 50 elements)
  	 *
	 * @param queryParameters
	 *            Parameters to filter the result of the list
  	 *
  	 * @return List of Role
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.Role
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/roles/get-roles">Get Roles documentation</a>
	 */
	public List<Role> getRoles(HashMap<String, String> queryParameters) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		int limit = 50;
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_ROLES_URL));
		for (Map.Entry<String,String> parameter: queryParameters.entrySet()) {
			if (parameter.getKey() == "limit") {
				limit = Integer.parseInt(parameter.getValue());
				if (limit >= 50) {
					// We don't add limit if is more than 50, API call have that limitation
					continue;
				}
			}
			url.addParameter(parameter.getKey(), parameter.getValue());
		}

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		OneloginOAuthJSONResourceResponse oAuthResponse = null;
		List<Role> roles = new ArrayList<Role>();
		String afterCursor = null;
		while (oAuthResponse == null || (roles.size() < limit && afterCursor != null)) {
			oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
			if (oAuthResponse.getResponseCode() == 200) {
				JSONObject[] dataArray = oAuthResponse.getDataArray();
				if (dataArray != null && dataArray.length > 0) {
					Role role;
					for (JSONObject data: dataArray) {
						if (roles.size() < limit) {
							role = new Role(data);
							roles.add(role);
						} else {
							return roles;
						}
					}					
				}

				afterCursor = oAuthResponse.getAfterCursor();
				if (afterCursor == "null") {
					afterCursor = null;
				} else if (!afterCursor.isEmpty()) {
					url.setParameter("after_cursor", oAuthResponse.getAfterCursor());
					bearerRequest.setLocationUri(url.toString());
				}
			} else {
				error = oAuthResponse.getError();
				errorDescription = oAuthResponse.getErrorDescription();
				break;
			}
		}

		return roles;
	}

	/**
  	 * Gets a list of Role resources. (50 elements).
  	 *
  	 * @return List of Role
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.Role
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/roles/get-roles">Get Roles documentation</a>
	 */
	public List<Role> getRoles() throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		HashMap<String, String> queryParameters = new HashMap<String, String>();
		return getRoles(queryParameters);
	}

	/**
  	 * Gets Role by ID.
  	 *
	 * @param id
	 *            Id of the role
  	 *
  	 * @return Role
     *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.Role
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/roles/get-role-by-id">Get Role by ID documentation</a>
	 */
	public Role getRole(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_ROLE_URL, Long.toString(id)));		

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		Role role = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			JSONObject data = oAuthResponse.getData();
			role = new Role(data);
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return role;
	}

	/////////////////////
	//  Event Methods  //
	/////////////////////
	
	/**
  	 * List of all OneLogin event types available to the Events API.
  	 *
  	 * @return List of EventType
  	 *
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
  	 *
  	 * @see com.onelogin.sdk.model.EventType
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/event-types">Get Event Types documentation</a>
	 */
	public List<EventType> getEventTypes() throws URISyntaxException, ClientProtocolException, IOException {
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_EVENT_TYPES_URL));
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url.toString());
		httpGet.setHeader("Accept", "application/json");
		CloseableHttpResponse response = httpclient.execute(httpGet);
		String json_string = EntityUtils.toString(response.getEntity());
		JSONObject json_object = new JSONObject(json_string);
		JSONArray data = json_object.getJSONArray("data");
		List<EventType> eventTypes = new ArrayList<EventType>();
		for (int i = 0; i < data.length(); i++) {
			JSONObject j_object = data.getJSONObject(i);
			EventType eventType = new EventType(j_object);
			eventTypes.add(eventType);
		}
		
		return eventTypes;
	}

	/**
  	 * Gets a list of Event resources. (if no limit provided, by default get 50 elements)
  	 *
	 * @param queryParameters
	 *            Parameters to filter the result of the list
  	 *
  	 * @return List of Event
     *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.Event
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/get-events">Get Events documentation</a>
	 */
	public List<Event> getEvents(HashMap<String, String> queryParameters) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		int limit = 50;
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_EVENTS_URL));
		for (Map.Entry<String,String> parameter: queryParameters.entrySet()) {
			if (parameter.getKey() == "limit") {
				limit = Integer.parseInt(parameter.getValue());
				if (limit >= 50) {
					continue;
				}
			}
			url.addParameter(parameter.getKey(), parameter.getValue());
		}

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		OneloginOAuthJSONResourceResponse oAuthResponse = null;
		String afterCursor = null;
		List<Event> events = new ArrayList<Event>();
		while (oAuthResponse == null || (events.size() < limit && afterCursor != null)) {
			oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
			if (oAuthResponse.getResponseCode() == 200) {
				JSONObject[] dataArray = oAuthResponse.getDataArray();
				if (dataArray != null && dataArray.length > 0) {
					Event event;
					for (JSONObject data: dataArray) {
						if (events.size() < limit) {
							event = new Event(data);
							events.add(event);
						} else {
							return events;
						}
					}					
				}

				afterCursor = oAuthResponse.getAfterCursor();
				if (afterCursor != null && !afterCursor.isEmpty()) {
					url.setParameter("after_cursor", oAuthResponse.getAfterCursor());
					bearerRequest.setLocationUri(url.toString());
				}
			} else {
				error = oAuthResponse.getError();
				errorDescription = oAuthResponse.getErrorDescription();
				break;
			}
		}

		return events;
	}

	/**
  	 * Gets a list of Event resources. (50 elements)
  	 *
  	 * @return List of Event
     *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.Event
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/get-events">Get Events documentation</a>
	 */
	public List<Event> getEvents() throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		HashMap<String, String> queryParameters = new HashMap<String, String>();
		return getEvents(queryParameters);
	}
	
	/**
  	 * Gets Event by ID.
  	 *
	 * @param id
	 *            Id of the event
  	 *
  	 * @return Event
     *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.Event
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/get-event-by-id">Get Event by ID documentation</a>
	 */
	public Event getEvent(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_EVENT_URL, Long.toString(id)));

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		Event event = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			JSONObject data = oAuthResponse.getData();
			event = new Event(data);
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return event;
	}

	/**
  	 * Create an event in the OneLogin event log.
  	 *
	 * @param eventParams
	 *            Event Data (event_type_id, account_id, actor_system, actor_user_id, actor_user_name, app_id,
	 *            assuming_acting_user_id, custom_message, directory_sync_run_id, group_id, group_name, ipaddr,
	 *            otp_device_id, otp_device_name, policy_id, policy_name, role_id, role_name, user_id, user_name)
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.Event
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/create-event">Create Event documentation</a>
	 */
	public void createEvent(Map<String, Object> eventParams) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.CREATE_EVENT_URL));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		String body = JSONUtils.buildJSON(eventParams);
		bearerRequest.setBody(body);

		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200 || !oAuthResponse.getType().equals("success")) {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
	}

	/////////////////////
	//  Group Methods  //
	/////////////////////

	/**
  	 * Gets a list of Group resources (element of groups limited with the limit parameter).
  	 *
	 * @param limit
	 *            Limit the number of groups returned
	 *
  	 * @return List of Group
	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.Group
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/groups/get-groups">Get Groups documentation</a>
	 */
	public List<Group> getGroups(int limit) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_GROUPS_URL));
		
		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		OneloginOAuthJSONResourceResponse oAuthResponse = null;
		String afterCursor = null;
		List<Group> groups = new ArrayList<Group>();
		while (oAuthResponse == null || (groups.size() < limit && afterCursor != null)) {
			oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
			if (oAuthResponse.getResponseCode() == 200) {
				JSONObject[] dataArray = oAuthResponse.getDataArray();
				if (dataArray != null && dataArray.length > 0) {
					Group group;
					for (JSONObject data: dataArray) {
						if (groups.size() < limit) {
							group = new Group(data);
							groups.add(group);
						} else {
							return groups;
						}
					}					
				}

				afterCursor = oAuthResponse.getAfterCursor();
				if (afterCursor != null && !afterCursor.isEmpty()) {
					url.setParameter("after_cursor", oAuthResponse.getAfterCursor());
					bearerRequest.setLocationUri(url.toString());
				}
			} else {
				error = oAuthResponse.getError();
				errorDescription = oAuthResponse.getErrorDescription();
				break;
			}
		}

		return groups;
	}

	/**
  	 * Gets a list of Group resources. (50 elements)
  	 *
  	 * @return List of Group
     *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.Group
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/groups/get-groups">Get Groups documentation</a>
	 */
	public List<Group> getGroups() throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getGroups(50);
	}

	/**
  	 * Gets Group by ID.
  	 *
	 * @param id
	 *            Id of the group
  	 *
  	 * @return Group
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.Group
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/groups/get-group-by-id">Get Group by ID documentation</a>
	 */
	public Group getGroup(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_ROLE_URL, Long.toString(id)));
		
		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		Group group = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			JSONObject data = oAuthResponse.getData();
			group = new Group(data);
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return group;
	}

	//////////////////////////////
	//  SAML Assertion Methods  //
	//////////////////////////////

	/**
  	 * Generates a SAML Assertion.
  	 *
	 * @param usernameOrEmail
	 *            username or email of the OneLogin user accessing the app
	 * @param password
	 *            Password of the OneLogin user accessing the app
	 * @param appId
	 *            App ID of the app for which you want to generate a SAML token
	 * @param subdomain
	 *            subdomain of the OneLogin account related to the user/app
	 * @param ipAddress
	 *             whitelisted IP address that needs to be bypassed (some MFA scenarios). 
  	 *
  	 * @return SAMLEndpointResponse
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.SAMLEndpointResponse
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/saml-assertions/generate-saml-assertion">Generate SAML Assertion documentation</a>
	 */
	public SAMLEndpointResponse getSAMLAssertion(String usernameOrEmail, String password, String appId, String subdomain, String ipAddress) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_SAML_ASSERTION_URL));		

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
				//.setAccessToken(accessToken) // 'Authorization' => 'Bearer xxxx' not accepted
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username_or_email", usernameOrEmail);
		params.put("password", password);
		params.put("app_id", appId);
		params.put("subdomain", subdomain);
		if (ipAddress != null && !ipAddress.isEmpty()) {
			params.put("ip_address", ipAddress);
		}
		String body = JSONUtils.buildJSON(params);
		bearerRequest.setBody(body);

		SAMLEndpointResponse samlEndpointResponse = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			samlEndpointResponse = new SAMLEndpointResponse(oAuthResponse.getType(), oAuthResponse.getMessage());
			if (oAuthResponse.getType().equals("success")) {
				if (oAuthResponse.getMessage().equals("Success")) {
					samlEndpointResponse.setSAMLResponse((String)oAuthResponse.getStringFromData());
				} else {
					MFA mfa = new MFA(oAuthResponse.getData());
					samlEndpointResponse.setMFA(mfa);
				}
			}
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return samlEndpointResponse;
	}

	/**
  	 * Generates a SAML Assertion.
  	 *
	 * @param usernameOrEmail
	 *            username or email of the OneLogin user accessing the app
	 * @param password
	 *            Password of the OneLogin user accessing the app
	 * @param appId
	 *            App ID of the app for which you want to generate a SAML token
	 * @param subdomain
	 *            subdomain of the OneLogin user accessing the app
  	 *
  	 * @return SAMLEndpointResponse
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.SAMLEndpointResponse
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/saml-assertions/generate-saml-assertion">Generate SAML Assertion documentation</a>
	 */
	public SAMLEndpointResponse getSAMLAssertion(String usernameOrEmail, String password, String appId, String subdomain) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getSAMLAssertion(usernameOrEmail, password, appId, subdomain, null);
	}

	/**
  	 * Verifies a one-time password (OTP) value provided for a second factor when multi-factor authentication (MFA) is required for SAML authentication.
  	 *
	 * @param appId
	 *            App ID of the app for which you want to generate a SAML token
	 * @param devideId
	 *            Provide the MFA device_id you are submitting for verification.  
	 * @param stateToken
	 *            Provide the state_token associated with the MFA device_id you are submitting for verification.
	 * @param otpToken
	 *            Provide the OTP value for the MFA factor you are submitting for verification.
	 * @param urlEndpoint
	 *			  Specify an url where return the response.
  	 *
  	 * @return SAMLEndpointResponse
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.SAMLEndpointResponse
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/saml-assertions/verify-factor">Verify Factor documentation</a>
	 */
	public SAMLEndpointResponse getSAMLAssertionVerifying(String appId, String devideId, String stateToken, String otpToken, String urlEndpoint) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		String target;
		if (urlEndpoint != null && !urlEndpoint.isEmpty()) {
			target = urlEndpoint;
		} else {
			URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_SAML_VERIFY_FACTOR));
			target = url.toString();
		}

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(target)
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put("User-Agent", this.userAgent);
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		bearerRequest.setHeaders(headers);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("app_id", appId);
		params.put("device_id", devideId);
		params.put("state_token", stateToken);

		if (otpToken != null && !otpToken.isEmpty()) {
			params.put("otp_token", otpToken);
		}
		String body = JSONUtils.buildJSON(params);
		bearerRequest.setBody(body);

		SAMLEndpointResponse samlEndpointResponse = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			samlEndpointResponse = new SAMLEndpointResponse(oAuthResponse.getType(), oAuthResponse.getMessage());
			if (oAuthResponse.getType().equals("success")) {
				if (oAuthResponse.getMessage().equals("Success")) {
					samlEndpointResponse.setSAMLResponse((String)oAuthResponse.getStringFromData());
				}
			}
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return samlEndpointResponse;
	}

	/**
  	 * Verifies a one-time password (OTP) value provided for a second factor when multi-factor authentication (MFA) is required for SAML authentication.
  	 *
	 * @param appId
	 *            App ID of the app for which you want to generate a SAML token
	 * @param devideId
	 *            Provide the MFA device_id you are submitting for verification.  
	 * @param stateToken
	 *            Provide the state_token associated with the MFA device_id you are submitting for verification.
	 * @param otpToken
	 *            Provide the OTP value for the MFA factor you are submitting for verification.
  	 *
  	 * @return SAMLEndpointResponse
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.SAMLEndpointResponse
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/saml-assertions/verify-factor">Verify Factor documentation</a>
	 */
	public SAMLEndpointResponse getSAMLAssertionVerifying(String appId, String devideId, String stateToken, String otpToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getSAMLAssertionVerifying(appId, devideId, stateToken, otpToken, null);
	}

	/**
  	 * Verifies a one-time password (OTP) value provided for a second factor when multi-factor authentication (MFA) is required for SAML authentication.
  	 *
	 * @param appId
	 *            App ID of the app for which you want to generate a SAML token
	 * @param devideId
	 *            Provide the MFA device_id you are submitting for verification.  
	 * @param stateToken
	 *            Provide the state_token associated with the MFA device_id you are submitting for verification.
  	 *
  	 * @return SAMLEndpointResponse
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see com.onelogin.sdk.model.SAMLEndpointResponse
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/saml-assertions/verify-factor">Verify Factor documentation</a>
	 */
	public SAMLEndpointResponse getSAMLAssertionVerifying(String appId, String devideId, String stateToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getSAMLAssertionVerifying(appId, devideId, stateToken, null, null);
	}

	////////////////////////////
	//  Invite Links Methods  //
	////////////////////////////

	/**
  	 * Generates an invite link for a user that you have already created in your OneLogin account.
  	 *
	 * @param email
	 *            Set to the email address of the user that you want to generate an invite link for.
	 *
  	 * @return String with the link
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/invite-links/generate-invite-link">Generate Invite Link documentation</a>
	 */
	public String generateInviteLink(String email) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GENERATE_INVITE_LINK_URL));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		String body = JSONUtils.buildJSON(params);
		bearerRequest.setBody(body);

		String urlLink = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			if (oAuthResponse.getType().equals("success")) {
				if (oAuthResponse.getMessage().equals("Success")) {
					Object[] objArray = oAuthResponse.getArrayFromData();
					urlLink = (String)objArray[0];
				}
			}
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return urlLink;
	}

	/**
  	 * Sends an invite link to a user that you have already created in your OneLogin account.
  	 *
	 * @param email
	 *            Set to the email address of the user that you want to send an invite link for.
	 * @param personal_email
	 *            If you want to send the invite email to an email other than the one provided in  email, 
	 *            provide it here. The invite link will be sent to this address instead.
	 *
  	 * @return True if the mail with the link was sent
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/invite-links/send-invite-link">Send Invite Link documentation</a>
	 */
	public Boolean sendInviteLink(String email, String personalEmail) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.SEND_INVITE_LINK_URL));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
                .buildHeaderMessage();

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization());
		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		bearerRequest.setHeaders(headers);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		if (personalEmail != null) {
			params.put("personal_email", personalEmail);
		}
		String body = JSONUtils.buildJSON(params);
		bearerRequest.setBody(body);

		Boolean sent = false;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			if (oAuthResponse.getType().equals("success")) {
				sent = true;
			}
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return sent;
	}

	/**
  	 * Send an invite link to a user that you have already created in your OneLogin account.
  	 *
	 * @param email
	 *            Set to the email address of the user that you want to send an invite link for.
	 *
  	 * @return True if the mail with the link was sent
  	 *
  	 * @throws OAuthSystemException
  	 * @throws OAuthProblemException
  	 * @throws URISyntaxException
	 *
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/invite-links/send-invite-link">Send Invite Link documentation</a>
	 */
	public Boolean sendInviteLink(String email) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return sendInviteLink(email, null);
	}

	///////////////////////////
	//  Embed Apps   Method  //
	///////////////////////////

	/**
  	 * Lists apps accessible by a OneLogin user.
  	 *
	 * @param token
	 *            Provide your embedding token.
	 * @param email
	 *            Provide the email of the user for which you want to return a list of apps to be embed.
	 *
  	 * @return String that contains an XML with the App info
  	 *
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws XPathExpressionException 
  	 *
  	 * @see com.onelogin.sdk.model.App
  	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/embed-apps/get-apps-to-embed-for-a-user">Get Apps to Embed for a User documentation</a>
	 */
	public List<EmbedApp> getEmbedApps(String token, String email) throws URISyntaxException, ClientProtocolException, IOException, ParserConfigurationException, SAXException, XPathExpressionException {
		cleanError();
		URIBuilder url = new URIBuilder(Constants.EMBED_APP_URL);
		url.addParameter("token", token);
		url.addParameter("email", email);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url.toString());
		httpGet.setHeader("Accept", "application/json");
		CloseableHttpResponse response = httpclient.execute(httpGet);
		String xmlString = EntityUtils.toString(response.getEntity());
		List<EmbedApp> embedApps = new ArrayList<EmbedApp>();
		DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = docfactory.newDocumentBuilder();
		Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList appNodeList = (NodeList) xpath.evaluate("/apps/app", doc, XPathConstants.NODESET);
		if (appNodeList.getLength() > 0) {
			Node appNode;
			NodeList appAttrs;
			EmbedApp embedApp;
			for (int i = 0; i < appNodeList.getLength(); i++) {
				appNode = appNodeList.item(0);
				appAttrs = appNode.getChildNodes();
				String appAttrName;
				JSONObject appJson = new JSONObject();
				Set<String> desiredAttrs = new HashSet<String>(Arrays.asList(new String[] {"id", "icon", "name", "provisioned", "extension_required", "personal", "login_id"}));
				for (int j = 0; j < appAttrs.getLength(); j++) {
					appAttrName = appAttrs.item(j).getNodeName();
					if (desiredAttrs.contains(appAttrName)) {
						appJson.put(appAttrName, appAttrs.item(j).getTextContent());
					}
				}
				embedApp = new EmbedApp(appJson);
				embedApps.add(embedApp);
			}
		}
		
		return embedApps;
	}
	
	
	/////////////////////////
	//  Auxiliary methods  //
	/////////////////////////

	/**
	 * Prepare the client before execute a call to the API (get token ready)  
	 * @throws OAuthProblemException 
	 * @throws OAuthSystemException 
	 */
	public void prepareToken() throws OAuthSystemException, OAuthProblemException {	
		if (accessToken == null) {
			getAccessToken();
		} else if (this.isExpired()) {
			refreshToken();
		}
	}
	
	/**
	 * @return when the token has expired. 
	 */
	public boolean isExpired() {
		return expiration != null && expiration.isBeforeNow();
	}

	/**
	 * @return the last error 
	 */
	public String getError() {
		return error;
	}

	/**
	 * @return the last error description 
	 */
	public String getErrorDescription() {
		return errorDescription;
	}
	
	/**
	 * Clean error message 
	 */
	public void cleanError() {
		error = null;
		errorDescription = null;
	}

	protected String getAuthorization(Boolean bearer) {
		if (bearer == true) {
			return "bearer:" + accessToken;
		} else {
			return "client_id:" + settings.getClientId() + ", client_secret:" + settings.getClientSecret();
		}
	}

	protected String getAuthorization() {
		return getAuthorization(true);
	}
}

