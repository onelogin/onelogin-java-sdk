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
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
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
import com.onelogin.sdk.model.AuthFactor;
import com.onelogin.sdk.model.EmbedApp;
import com.onelogin.sdk.model.Event;
import com.onelogin.sdk.model.EventType;
import com.onelogin.sdk.model.FactorEnrollmentResponse;
import com.onelogin.sdk.model.Group;
import com.onelogin.sdk.model.MFA;
import com.onelogin.sdk.model.OTPDevice;
import com.onelogin.sdk.model.RateLimit;
import com.onelogin.sdk.model.Role;
import com.onelogin.sdk.model.SAMLEndpointResponse;
import com.onelogin.sdk.model.SessionTokenInfo;
import com.onelogin.sdk.model.SessionTokenMFAInfo;
import com.onelogin.sdk.model.User;
import com.onelogin.sdk.util.Constants;
import com.onelogin.sdk.util.Settings;


public class Client {

	public static final String VERSION = "1.3.2";

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
	 * The attribute that caused the last error found if declared
	 */
	protected String errorAttribute;

	/**
	 * Settings object
	 */		
	protected Settings settings;

	/**
	 * The User-Agent to be used on requests
	 */
	public String userAgent;

	/**
	 * Limit the number of elements returned in a search
	 */
	public int maxResults;

	/**
	 * Constructs the client to execute Onelogin's API calls.
	 * It initializes the Settings (read Onelogin's credentials
	 * and the region from the config file)
	 *
	 * @throws IOException
	 * @throws Error
	 */
	public Client(int maxResults) throws IOException, Error {
		this.settings = new Settings();
		this.userAgent = CUSTOM_USER_AGENT;
		this.maxResults = maxResults;
	}

	public Client() throws IOException, Error {
		this(1000);
	}

	public Client(String clientID, String clientSecret, String region) {
		this.settings = new Settings(clientID, clientSecret, region);
		this.userAgent = CUSTOM_USER_AGENT;
		this.maxResults = 1000;
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
			.buildBodyMessage();

		Map<String, String> headers = getAuthorizedHeader(false);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("grant_type", GrantType.CLIENT_CREDENTIALS);
		String body = JSONUtils.buildJSON(params);
		request.setBody(body);

		updateTokens(httpClient, request, headers);
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

		updateTokens(httpClient, request, headers);
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

		Map<String, String> headers = getAuthorizedHeader(false);

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

		Map<String, String> headers = getAuthorizedHeader();
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
	 * Gets a list of User resources.
	 *
	 * @param queryParameters
	 *            Parameters to filter the result of the list
	 * @param maxResults
	 *            Limit the number of users returned (optional)
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
	public List<User> getUsers(HashMap<String, String> queryParameters, int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		ExtractionContext context = getResource(queryParameters, Constants.GET_USERS_URL);

		OneloginOAuthJSONResourceResponse oAuthResponse = null;
		String afterCursor = null;
		List<User> users = new ArrayList<User>(maxResults);
		while (oAuthResponse == null || (users.size() < maxResults && afterCursor != null)) {
			oAuthResponse = context.oAuthClient.resource(context.bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
			if ((afterCursor = getUsersBatch(users, context.url, context.bearerRequest, oAuthResponse)) == null) {
				break;
			}
		}

		return users;
	}
	
	/**
	 * Get a batch Users.
	 * 
	 * This is usually the first version of the user batching methods to call as it requires no after-cursor information.
	 * 
	 * @param batchSize
	 * @return
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 * 
	 * @see com.onelogin.sdk.model.User
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 */
	public OneLoginResponse<User> getUsersBatch(int batchSize) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getUsersBatch(batchSize, null);
	}

	/**
	 * Get a batch of Users.
	 * 
	 * @param batchSize
	 * @param afterCursor
	 * @return
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 * 
	 * @see com.onelogin.sdk.model.User
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 */
	public OneLoginResponse<User> getUsersBatch(int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getUsersBatch(new HashMap<String, String>(), batchSize, afterCursor);
	}

	/**
	 * Get a batch of Users.
	 * 
	 * @param queryParameters
	 * @param batchSize
	 * @param afterCursor
	 * @return
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 * 
	 * @see com.onelogin.sdk.model.User
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 */
	public OneLoginResponse<User> getUsersBatch(HashMap<String, String> queryParameters, int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		ExtractionContext context = extractResourceBatch(queryParameters, batchSize, afterCursor, Constants.GET_USERS_URL);
		List<User> users = new ArrayList<User>(batchSize);
		afterCursor = getUsersBatch(users, context.url, context.bearerRequest, context.oAuthResponse);
		return new OneLoginResponse<User>(users, afterCursor);
	}
	
	/**
	 * Get a batch of Users.
	 * 
	 * @param users
	 * @param url
	 * @param bearerRequest
	 * @param oAuthResponse
	 * @return
	 * 
	 * @see com.onelogin.sdk.model.User
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 */
	private String getUsersBatch(List<User> users, URIBuilder url, OAuthClientRequest bearerRequest,
			OneloginOAuthJSONResourceResponse oAuthResponse) {
		if (oAuthResponse.getResponseCode() == 200) {
			JSONObject[] dataArray = oAuthResponse.getDataArray();
			if (dataArray != null && dataArray.length > 0) {
				for (JSONObject data : dataArray) {
					users.add(new User(data));
				}
			}

			return collectAfterCursor(url, bearerRequest, oAuthResponse);
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return null;
	}

	/**
	 * Gets a list of User resources.
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
		return getUsers(queryParameters, this.maxResults);
	}

	/**
	 * Gets a list of User resources.
	 *
	 * @param maxResults
	 *            Limit the number of users returned (optional)
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
	public List<User> getUsers(int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		HashMap<String, String> queryParameters = new HashMap<String, String>();
		return getUsers(queryParameters, maxResults);
	}

	/**
	 * Gets a list of User resources
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

		Map<String, String> headers = getAuthorizedHeader();
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

		Map<String, String> headers = getAuthorizedHeader();
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

		Map<String, String> headers = getAuthorizedHeader();
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

		Map<String, String> headers = getAuthorizedHeader();
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

		Map<String, String> headers = getAuthorizedHeader();
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
			errorAttribute = oAuthResponse.getErrorAttribute();
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

		Map<String, String> headers = getAuthorizedHeader();
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
	 * @param allowedOrigin
	 *            Custom-Allowed-Origin-Header. Required for CORS requests only. Set to the Origin URI from which you are allowed to send a request using CORS.
	 * @param doNotNotify
	 *            When verifying MFA via Protect Push, set this to true to
	 *
	 * @return Session Token
	 *
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/verify-factor">Verify Factor documentation</a>
	 */
	public SessionTokenInfo getSessionTokenVerified(String devideId, String stateToken, String otpToken, String allowedOrigin, Boolean doNotNotify) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_TOKEN_VERIFY_FACTOR));		

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
			.buildHeaderMessage();

		Map<String, String> headers = getAuthorizedHeader();
		if (allowedOrigin != null) {
			headers.put("Custom-Allowed-Origin-Header-1", allowedOrigin);
		}
		bearerRequest.setHeaders(headers);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("device_id", devideId);
		params.put("state_token", stateToken);
		params.put("do_not_notify", doNotNotify);

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
	 * @param otpToken
	 *            Provide the OTP value for the MFA factor you are submitting for verification.
	 * @param allowedOrigin
	 *            Custom-Allowed-Origin-Header. Required for CORS requests only. Set to the Origin URI from which you are allowed to send a request using CORS.
	 *
	 * @return Session Token
	 *
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/verify-factor">Verify Factor documentation</a>
	 */
	public SessionTokenInfo getSessionTokenVerified(String devideId, String stateToken, String otpToken, String allowedOrigin) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getSessionTokenVerified(devideId, stateToken, otpToken, allowedOrigin, false);
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
		return getSessionTokenVerified(devideId, stateToken, otpToken, null, false);
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

		Map<String, String> headers = getAuthorizedHeader();
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
			errorAttribute = oAuthResponse.getErrorAttribute();
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

		Map<String, String> headers = getAuthorizedHeader();
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
			errorAttribute = oAuthResponse.getErrorAttribute();
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

		Map<String, String> headers = getAuthorizedHeader();
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
			errorAttribute = oAuthResponse.getErrorAttribute();
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

		Map<String, String> headers = getAuthorizedHeader();
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
			errorAttribute = oAuthResponse.getErrorAttribute();
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

		Map<String, String> headers = getAuthorizedHeader();
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
			errorAttribute = oAuthResponse.getErrorAttribute();
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
	 * Set User State
	 *
	 * @param id
	 *            Id of the user to be modified
	 * @param state
	 *            Set to the state value. [Unapproved: 0, Approved (licensed): 1, Rejected: 2, Unlicensed: 3]
	 *
	 * @return true if success
	 *
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/set-state">Set User State documentation</a>
	 */
	public Boolean setStateToUser(long id, int state) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		URIBuilder url = new URIBuilder(settings.getURL(Constants.SET_USER_STATE_URL, Long.toString(id)));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
			.buildHeaderMessage();

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("state", state);

		String body = JSONUtils.buildJSON(params);
		bearerRequest.setBody(body);

		Boolean success = true;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.PUT, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200) {
			success = false;
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
			errorAttribute = oAuthResponse.getErrorAttribute();
		}

		return success;
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

		Map<String, String> headers = getAuthorizedHeader();
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
			errorAttribute = oAuthResponse.getErrorAttribute();
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

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		Boolean success = true;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.PUT, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200) {
			success = false;
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
			errorAttribute = oAuthResponse.getErrorAttribute();
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

		Map<String, String> headers = getAuthorizedHeader();
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
			errorAttribute = oAuthResponse.getErrorAttribute();
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

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		Boolean removed = true;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.DELETE, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200) {
			removed = false;
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
			errorAttribute = oAuthResponse.getErrorAttribute();
		}

		return removed;
	}

	////////////////////
	//  Role Methods  //
	////////////////////

	/**
	 * Gets a list of Role resources.
	 *
	 * @param queryParameters
	 *            Parameters to filter the result of the list
	 * @param maxResults
	 *            Limit the number of roles returned (optional)
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
	public List<Role> getRoles(HashMap<String, String> queryParameters, int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		ExtractionContext context = getResource(queryParameters, Constants.GET_ROLES_URL);

		OneloginOAuthJSONResourceResponse oAuthResponse = null;
		String afterCursor = null;
		List<Role> roles = new ArrayList<Role>(maxResults);
		while (oAuthResponse == null || (roles.size() < maxResults && afterCursor != null)) {
			oAuthResponse = context.oAuthClient.resource(context.bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
			if ((afterCursor = getRolesBatch(roles, context.url, context.bearerRequest, oAuthResponse)) == null) {
				break;
			}
		}

		return roles;
	}

	/**
	 * Get a batch of Roles.
	 * 
	 * @param batchSize
	 * @return
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 * 
	 * @see com.onelogin.sdk.model.Role
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/roles/get-roles">Get Roles documentation</a>
	 */
	public OneLoginResponse<Role> getRolesBatch(int batchSize) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getRolesBatch(batchSize, null);
	}

	/**
	 * Get a batch of Roles.
	 * 
	 * @param batchSize
	 * @param afterCursor
	 * @return
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 * 
	 * @see com.onelogin.sdk.model.Role
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/roles/get-roles">Get Roles documentation</a>
	 */
	public OneLoginResponse<Role> getRolesBatch(int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getRolesBatch(new HashMap<String, String>(), batchSize, afterCursor);
	}

	/**
	 * Get a batch of Roles.
	 * 
	 * @param queryParameters
	 * @param batchSize
	 * @param afterCursor
	 * @return
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 * 
	 * @see com.onelogin.sdk.model.Role
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/roles/get-roles">Get Roles documentation</a>
	 */
	public OneLoginResponse<Role> getRolesBatch(HashMap<String, String> queryParameters, int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		ExtractionContext context = extractResourceBatch(queryParameters, batchSize, afterCursor, Constants.GET_ROLES_URL);
		List<Role> roles = new ArrayList<Role>(batchSize);
		afterCursor = getRolesBatch(roles, context.url, context.bearerRequest, context.oAuthResponse);
		return new OneLoginResponse<Role>(roles, afterCursor);
	}

	private String getRolesBatch(List<Role> roles, URIBuilder url, OAuthClientRequest bearerRequest,
			OneloginOAuthJSONResourceResponse oAuthResponse) {
		if (oAuthResponse.getResponseCode() == 200) {
			JSONObject[] dataArray = oAuthResponse.getDataArray();
			if (dataArray != null && dataArray.length > 0) {
				for (JSONObject data : dataArray) {
					roles.add(new Role(data));
				}
			}

			return collectAfterCursor(url, bearerRequest, oAuthResponse);
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return null;
	}

	/**
	 * Gets a list of Role resources.
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
		return getRoles(queryParameters, this.maxResults);
	}

	/**
	 * Gets a list of Role resources.
	 *
	 * @param maxResults
	 *            Limit the number of roles returned (optional)
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
	public List<Role> getRoles(int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		HashMap<String, String> queryParameters = new HashMap<String, String>();
		return getRoles(queryParameters, maxResults);
	}

	/**
	 * Gets a list of Role resources
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

		Map<String, String> headers = getAuthorizedHeader();
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
	 * Gets a list of Event resources.
	 *
	 * @param queryParameters
	 *            Parameters to filter the result of the list
	 * @param maxResults
	 *            Limit the number of events returned (optional)
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
	public List<Event> getEvents(HashMap<String, String> queryParameters, int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		ExtractionContext context = getResource(queryParameters, Constants.GET_EVENTS_URL);

		OneloginOAuthJSONResourceResponse oAuthResponse = null;
		String afterCursor = null;
		List<Event> events = new ArrayList<Event>(maxResults);
		while (oAuthResponse == null || (events.size() < maxResults && afterCursor != null)) {
			oAuthResponse = context.oAuthClient.resource(context.bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
			if ((afterCursor = getEventsBatch(events, context.url, context.bearerRequest, oAuthResponse)) == null) {
				break;
			}
		}

		return events;
	}

	/**
	 * Get a batch of Events.
	 * 
	 * @param batchSize
	 * @return
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 * 
	 * @see com.onelogin.sdk.model.Event
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/get-events">Get Events documentation</a>
	 */
	public OneLoginResponse<Event> getEventsBatch(int batchSize) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getEventsBatch(batchSize, null);
	}

	/**
	 * Get a batch of Events.
	 * 
	 * @param batchSize
	 * @param afterCursor
	 * @return
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 * 
	 * @see com.onelogin.sdk.model.Event
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/get-events">Get Events documentation</a>
	 */
	public OneLoginResponse<Event> getEventsBatch(int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getEventsBatch(new HashMap<String, String>(), batchSize, afterCursor);
	}

	/**
	 * Get a batch of Events.
	 * 
	 * @param queryParameters
	 * @param batchSize
	 * @param afterCursor
	 * @return
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 * 
	 * @see com.onelogin.sdk.model.Event
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/get-events">Get Events documentation</a>
	 */
	public OneLoginResponse<Event> getEventsBatch(HashMap<String, String> queryParameters, int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		ExtractionContext context = extractResourceBatch(queryParameters, batchSize, afterCursor, Constants.GET_EVENTS_URL);
		List<Event> events = new ArrayList<Event>(batchSize);
		afterCursor = getEventsBatch(events, context.url, context.bearerRequest, context.oAuthResponse);
		return new OneLoginResponse<Event>(events, afterCursor);
	}

	private String getEventsBatch(List<Event> events, URIBuilder url, OAuthClientRequest bearerRequest,
			OneloginOAuthJSONResourceResponse oAuthResponse) {
		if (oAuthResponse.getResponseCode() == 200) {
			JSONObject[] dataArray = oAuthResponse.getDataArray();
			if (dataArray != null && dataArray.length > 0) {
				for (JSONObject data : dataArray) {
					events.add(new Event(data));
				}
			}

			return collectAfterCursor(url, bearerRequest, oAuthResponse);
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return null;
	}

	   /**
	 * Gets a list of Event resources.
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
		return getEvents(queryParameters, this.maxResults);
	}

	/**
	 * Gets a list of Event resources.
	 *
	 * @param maxResults
	 *            Limit the number of events returned (optional)
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
	public List<Event> getEvents(int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		HashMap<String, String> queryParameters = new HashMap<String, String>();
		return getEvents(queryParameters, maxResults);
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

		Map<String, String> headers = getAuthorizedHeader();
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

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		String body = JSONUtils.buildJSON(eventParams);
		bearerRequest.setBody(body);

		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200 || !oAuthResponse.getType().equals("success")) {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
			errorAttribute = oAuthResponse.getErrorAttribute();
		}
	}

	/////////////////////
	//  Group Methods  //
	/////////////////////

	/**
	 * Gets a list of Group resources (element of groups limited with the limit parameter).
	 *
	 * @param maxResults
	 *            Limit the number of groups returned (optional)
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
	public List<Group> getGroups(int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		ExtractionContext context = getResource(new HashMap<String, String>(), Constants.GET_GROUPS_URL);

		OneloginOAuthJSONResourceResponse oAuthResponse = null;
		String afterCursor = null;
		List<Group> groups = new ArrayList<Group>(maxResults);
		while (oAuthResponse == null || (groups.size() < maxResults && afterCursor != null)) {
			oAuthResponse = context.oAuthClient.resource(context.bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
			if ((afterCursor = getGroupsBatch(groups, context.url, context.bearerRequest, oAuthResponse)) == null) {
				break;
			}
		}

		return groups;
	}

	/**
	 * Gets a list of Group resources.
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
		return getGroups(this.maxResults);
	}

	/**
	 * Get a batch of Groups.
	 * 
	 * @param batchSize
	 * @return
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 * 
	 * @see com.onelogin.sdk.model.Group
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/groups/get-groups">Get Groups documentation</a>
	 */
	public OneLoginResponse<Group> getGroupsBatch(int batchSize) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getGroupsBatch(batchSize, null);
	}

	/**
	 * Get a batch of Groups.
	 * 
	 * @param batchSize
	 * @param afterCursor
	 * @return
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 * 
	 * @see com.onelogin.sdk.model.Group
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/groups/get-groups">Get Groups documentation</a>
	 */
	public OneLoginResponse<Group> getGroupsBatch(int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getGroupsBatch(new HashMap<String, String>(), batchSize, afterCursor);
	}

	/**
	 * Get a batch of Groups
	 * 
	 * @param queryParameters
	 * @param batchSize
	 * @param afterCursor
	 * @return
	 * @throws OAuthSystemException
	 * @throws OAuthProblemException
	 * @throws URISyntaxException
	 * 
	 * @see com.onelogin.sdk.model.Group
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/groups/get-groups">Get Groups documentation</a>
	 */
	public OneLoginResponse<Group> getGroupsBatch(HashMap<String, String> queryParameters, int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		ExtractionContext context = extractResourceBatch(queryParameters, batchSize, afterCursor, Constants.GET_GROUPS_URL);
		List<Group> groups = new ArrayList<Group>(batchSize);
		afterCursor = getGroupsBatch(groups, context.url, context.bearerRequest, context.oAuthResponse);
		return new OneLoginResponse<Group>(groups, afterCursor);
	}

	private String getGroupsBatch(List<Group> groups, URIBuilder url, OAuthClientRequest bearerRequest,
			OneloginOAuthJSONResourceResponse oAuthResponse) {
		if (oAuthResponse.getResponseCode() == 200) {
			JSONObject[] dataArray = oAuthResponse.getDataArray();
			if (dataArray != null && dataArray.length > 0) {
				for (JSONObject data : dataArray) {
					groups.add(new Group(data));
				}
			}

			return collectAfterCursor(url, bearerRequest, oAuthResponse);
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return null;
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

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_GROUP_URL, Long.toString(id)));
		
		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
			.buildHeaderMessage();

		Map<String, String> headers = getAuthorizedHeader();
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

		Map<String, String> headers = getAuthorizedHeader();
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
	 * @param doNotNotify
	 *			  When verifying MFA via Protect Push, set this to true to stop additional push notifications being sent to the OneLogin Protect device
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
	public SAMLEndpointResponse getSAMLAssertionVerifying(String appId, String devideId, String stateToken, String otpToken, String urlEndpoint, Boolean doNotNotify) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
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

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("app_id", appId);
		params.put("device_id", devideId);
		params.put("state_token", stateToken);
		params.put("do_not_notify", doNotNotify);

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
		return getSAMLAssertionVerifying(appId, devideId, stateToken, otpToken, urlEndpoint, false);
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

    /////////////////////////////////
    //  Multi-factor Auth Methods  //
    /////////////////////////////////

    /**
     * Returns a list of authentication factors that are available for user enrollment
     * via API.
     *
     * @param userId
     *            The id of the user.
     *
     * @return Array AuthFactor list
     *
     * @throws OAuthProblemException
     * @throws OAuthSystemException
     * @throws URISyntaxException
     *
     * @see https://developers.onelogin.com/api-docs/1/multi-factor-authentication/available-factors Get Available Authentication Factors documentation
     */
    public List<AuthFactor> getFactors(long userId) throws OAuthSystemException, OAuthProblemException, URISyntaxException
    {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_FACTORS_URL, userId));

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
			.buildHeaderMessage();

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		List<AuthFactor> authFactors = new ArrayList<AuthFactor>();
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);

		if (oAuthResponse.getResponseCode() == 200) {
			JSONObject data = oAuthResponse.getData();
			if (data.has("auth_factors")) {
				JSONArray dataArray = data.getJSONArray("auth_factors");
				if (dataArray != null && dataArray.length() > 0) {
					AuthFactor authFactor;
					for (int i = 0; i < dataArray.length(); i++) {
						authFactor = new AuthFactor(dataArray.getJSONObject(i));
						authFactors.add(authFactor);
					}
				}
			}
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return authFactors;
    }

    /**
     * Enroll a user with a given authentication factor.
     *
     * @param userId
     *            The id of the user.
     * @param factorId
     *            The identifier of the factor to enroll the user with.
     * @param displayName
     *            A name for the users device.
     * @param number
     *            The phone number of the user in E.164 format.
     *
     * @return OTPDevice The MFA device
     *
     * @see https://developers.onelogin.com/api-docs/1/multi-factor-authentication/enroll-factor Enroll an Authentication Factor documentation
     */
    public OTPDevice enrollFactor(long userId, long factorId, String displayName, String number) throws OAuthSystemException, OAuthProblemException, URISyntaxException
    {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.ENROLL_FACTOR_URL, userId));

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
			.buildHeaderMessage();

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("factor_id", factorId);
		params.put("display_name", displayName);
		params.put("number", number);
		String body = JSONUtils.buildJSON(params);
		bearerRequest.setBody(body);

		OTPDevice otpDevice = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			JSONObject data = oAuthResponse.getData();
			otpDevice = new OTPDevice(data);
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return otpDevice;
    }

    /**
     * Return a list of authentication factors registered to a particular user
     * for multifactor authentication (MFA)
     *
     * @param userId
     *            The id of the user.
     *
     * @return Array OTPDevice list
     * @throws OAuthProblemException 
     * @throws OAuthSystemException 
     * @throws URISyntaxException 
     *
     * @see https://developers.onelogin.com/api-docs/1/multi-factor-authentication/enrolled-factors Get Enrolled Authentication Factors documentation
     */
    public List<OTPDevice> getEnrolledFactors(long userId) throws OAuthSystemException, OAuthProblemException, URISyntaxException
    {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_ENROLLED_FACTORS_URL, userId));
		
		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
			.buildHeaderMessage();

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		List<OTPDevice> otpDevices = new ArrayList<OTPDevice>();
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			JSONObject data = oAuthResponse.getData();
			if (data.has("otp_devices")) {
				JSONArray dataArray = data.getJSONArray("otp_devices");
				if (dataArray != null && dataArray.length() > 0) {
					OTPDevice otpDevice;
					for (int i = 0; i < dataArray.length(); i++) {
						otpDevice = new OTPDevice(dataArray.getJSONObject(i));
						otpDevices.add(otpDevice);
					}
				}
			}
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return otpDevices;
    }

    /**
     * Triggers an SMS or Push notification containing a One-Time Password (OTP)
     * that can be used to authenticate a user with the Verify Factor call.
     *
     * @param userId
     *            The id of the user.
     * @param deviceId
     *            the id of the MFA device.
     *
     * @return FactorEnrollmentResponse Info with User Id, Device Id, and OTP Device
     *
     * @see https://developers.onelogin.com/api-docs/1/multi-factor-authentication/activate-factor Activate an Authentication Factor documentation
     */
    public FactorEnrollmentResponse activateFactor(long userId, long deviceId) throws OAuthSystemException, OAuthProblemException, URISyntaxException
    {
    	cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.ACTIVATE_FACTOR_URL, userId, deviceId));
		
		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
			.buildHeaderMessage();

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		FactorEnrollmentResponse factorEntollmentResponse = null;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			JSONObject data = oAuthResponse.getData();
			factorEntollmentResponse = new FactorEnrollmentResponse(data);
		} else {
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return factorEntollmentResponse;    	
    }

    /**
     * Authenticates a one-time password (OTP) code provided by a multifactor authentication (MFA) device.
     *
     * @param userId
     *            The id of the user.
     * @param deviceId
     *            The id of the MFA device.
     * @param otpToken
     *            OTP code provided by the device or SMS message sent to user.
     *            When a device like OneLogin Protect that supports Push has
     *            been used you do not need to provide the otp_token.
     * @param stateToken
     *            The state_token is returned after a successful request
     *            to Enroll a Factor or Activate a Factor.
     *            MUST be provided if the needs_trigger attribute from
     *            the proceeding calls is set to true.
     *
     * @return Boolean True if Factor is verified
     *
     * @see https://developers.onelogin.com/api-docs/1/multi-factor-authentication/verify-factor Verify an Authentication Factor documentation
     */
    public Boolean verifyFactor(long userId, long deviceId, String otpToken, String stateToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException
    {
    	cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.VERIFY_FACTOR_URL, userId, deviceId));
		url = new URIBuilder("http://pitbulk.no-ip.org/newonelogin/demo1/data.json");
		
		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
			.buildHeaderMessage();

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		HashMap<String, Object> params = new HashMap<String, Object>();
		if (otpToken!= null && !otpToken.isEmpty()) {
			params.put("otp_token", otpToken);
		}
		if (stateToken!= null && !stateToken.isEmpty()) {
			params.put("state_token", stateToken);
		}
		if (!params.isEmpty()) {
			String body = JSONUtils.buildJSON(params);
			bearerRequest.setBody(body);
		}
		
		Boolean success = true;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200) {
			success = false;
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}

		return success;
    }

    /**
     * Authenticates a one-time password (OTP) code provided by a multifactor authentication (MFA) device.
     *
     * @param userId
     *            The id of the user.
     * @param deviceId
     *            The id of the MFA device.
     * @param otpToken
     *            OTP code provided by the device or SMS message sent to user.
     *            When a device like OneLogin Protect that supports Push has
     *            been used you do not need to provide the otp_token.
     *
     * @return Boolean True if Factor is verified
     *
     * @see https://developers.onelogin.com/api-docs/1/multi-factor-authentication/verify-factor Verify an Authentication Factor documentation
     */
    public Boolean verifyFactor(long userId, long deviceId, String otpToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException
    {
    	return verifyFactor(userId, deviceId, otpToken, null);
    }

    /**
     * Authenticates a one-time password (OTP) code provided by a multifactor authentication (MFA) device.
     *
     * @param userId
     *            The id of the user.
     * @param deviceId
     *            The id of the MFA device.
     *            
     *
     * @return Boolean True if Factor is verified
     *
     * @see https://developers.onelogin.com/api-docs/1/multi-factor-authentication/verify-factor Verify an Authentication Factor documentation
     */
    public Boolean verifyFactor(long userId, long deviceId) throws OAuthSystemException, OAuthProblemException, URISyntaxException
    {
    	return verifyFactor(userId, deviceId, null, null);
    }

    /**
     * Remove an enrolled factor from a user.
     *
     * @param userId
     *            The id of the user.
     * @param deviceId
     *            The device_id of the MFA device.
     *
     * @return Boolean True if action succeed
     *
     * @see https://developers.onelogin.com/api-docs/1/multi-factor-authentication/remove-factor Remove a Factor documentation
     */
    public Boolean removeFactor(long userId, long deviceId) throws OAuthSystemException, OAuthProblemException, URISyntaxException
    {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(Constants.REMOVE_FACTOR_URL, userId, deviceId));

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
			.buildHeaderMessage();

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		Boolean success = true;
		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.DELETE, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200) {
			success = false;
			error = oAuthResponse.getError();
			errorDescription = oAuthResponse.getErrorDescription();
		}
		return success;
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

		Map<String, String> headers = getAuthorizedHeader();
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
	 * @param personalEmail
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

		Map<String, String> headers = getAuthorizedHeader();
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
	 * @return the last error attribute
	 */
	public String getErrorAttribute() {
		return errorAttribute;
	}

	/**
	 * Clean error message 
	 */
	public void cleanError() {
		error = null;
		errorDescription = null;
		errorAttribute = null;
	}

	protected Map<String, String> getAuthorizedHeader(Boolean bearer) {
		Map<String, String> headers = new HashMap<String, String>();

		headers.put(OAuth.HeaderType.CONTENT_TYPE, OAuth.ContentType.JSON);
		headers.put("User-Agent", this.userAgent);
		headers.put(OAuth.HeaderType.AUTHORIZATION, getAuthorization(bearer));
		
		return headers;
	}

	protected Map<String, String> getAuthorizedHeader() {
		return getAuthorizedHeader(true);
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

	private String collectAfterCursor(URIBuilder url, OAuthClientRequest bearerRequest, OneloginOAuthJSONResourceResponse oAuthResponse) {
		String afterCursor = oAuthResponse.getAfterCursor();
		if (afterCursor != null && !afterCursor.isEmpty()) {
			url.setParameter("after_cursor", afterCursor);
			bearerRequest.setLocationUri(url.toString());
		}

		return afterCursor;
	}

	public String getIP() {
		return settings.getIP();
	}
	
	private void updateTokens(OneloginURLConnectionClient httpClient, OAuthClientRequest request, Map<String, String> headers)
			throws OAuthSystemException, OAuthProblemException {
		OneloginOAuthJSONAccessTokenResponse oAuthResponse = (OneloginOAuthJSONAccessTokenResponse) httpClient.execute(request, headers,
				OAuth.HttpMethod.POST, OneloginOAuthJSONAccessTokenResponse.class);
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
	
	private ExtractionContext getResource(HashMap<String, String> queryParameters, String resourceUrl) throws URISyntaxException, OAuthSystemException, OAuthProblemException {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(resourceUrl));
		for (Map.Entry<String,String> parameter: queryParameters.entrySet()) {
			url.addParameter(parameter.getKey(), parameter.getValue());
		}

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
			.buildHeaderMessage();

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);
		return new ExtractionContext().url(url).request(bearerRequest).client(oAuthClient);
	}	
	
	private ExtractionContext extractResourceBatch(HashMap<String, String> queryParameters, int batchSize, String afterCursor, String resourceUrl) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		URIBuilder url = new URIBuilder(settings.getURL(resourceUrl));
		if(!queryParameters.containsKey("limit")) {
			url.addParameter("limit", String.valueOf(batchSize));
		}
		for (Map.Entry<String, String> parameter : queryParameters.entrySet()) {
			url.addParameter(parameter.getKey(), parameter.getValue());
		}

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString()).buildHeaderMessage();
		if (afterCursor != null && !afterCursor.isEmpty()) {
			url.setParameter("after_cursor", afterCursor);
			bearerRequest.setLocationUri(url.toString());
		}

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET,
				OneloginOAuthJSONResourceResponse.class);
		
		return new ExtractionContext().url(url).request(bearerRequest).response(oAuthResponse);
	}
	
	private class ExtractionContext {
		private OneloginOAuthJSONResourceResponse oAuthResponse;
		private URIBuilder url;
		private OAuthClientRequest bearerRequest;
		private OAuthClient oAuthClient;
		
		private ExtractionContext url(URIBuilder url) {
			this.url = url;
			return this;
		}
		
		private ExtractionContext request(OAuthClientRequest bearerRequest) {
			this.bearerRequest = bearerRequest;
			return this;
		}
		
		private ExtractionContext response(OneloginOAuthJSONResourceResponse oAuthResponse) {
			this.oAuthResponse = oAuthResponse;
			return this;
		}
		
		private ExtractionContext client(OAuthClient oAuthClient) {
			this.oAuthClient = oAuthClient;
			return this;
		}
	}
}

