package com.onelogin.sdk.conn;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

// Abandoned apache.oltu project
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.client.OAuthClient;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.client.response.OAuthClientResponse;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.exception.OAuthRuntimeException;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.message.types.GrantType;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.utils.JSONUtils;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.OAuth;

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
import com.onelogin.sdk.exception.ErrorResourceInitialization;
import com.onelogin.sdk.model.App;
import com.onelogin.sdk.model.AssignedAdmin;
import com.onelogin.sdk.model.AssignedApp;
import com.onelogin.sdk.model.AssignedUser;
import com.onelogin.sdk.model.AuthFactor;
import com.onelogin.sdk.model.Condition;
import com.onelogin.sdk.model.EmbedApp;
import com.onelogin.sdk.model.Event;
import com.onelogin.sdk.model.EventType;
import com.onelogin.sdk.model.FactorEnrollmentResponse;
import com.onelogin.sdk.model.Group;
import com.onelogin.sdk.model.MFA;
import com.onelogin.sdk.model.MFACheckStatus;
import com.onelogin.sdk.model.MFAToken;
import com.onelogin.sdk.model.Mapping;
import com.onelogin.sdk.model.OneLoginApp;
import com.onelogin.sdk.model.OneLoginResource;
import com.onelogin.sdk.model.OTPDevice;
import com.onelogin.sdk.model.Privilege;
import com.onelogin.sdk.model.RateLimit;
import com.onelogin.sdk.model.RiskScore;
import com.onelogin.sdk.model.RiskScoreInsights;
import com.onelogin.sdk.model.Role;
import com.onelogin.sdk.model.SAMLEndpointResponse;
import com.onelogin.sdk.model.SessionToken;
import com.onelogin.sdk.model.SessionTokenInfo;
import com.onelogin.sdk.model.SessionTokenMFAInfo;
import com.onelogin.sdk.model.SmartMFA;
import com.onelogin.sdk.model.Statement;
import com.onelogin.sdk.model.User;
import com.onelogin.sdk.util.Constants;
import com.onelogin.sdk.util.Settings;


public class Client {

	public static final String VERSION = "2.0.0";

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
	 * @param maxResults Set max number of items returned by a collection
	 *
	 * @throws IOException - If Settings initialization raises that exception when calling loadPropFile to load the file
	 * @throws Error  - If Settings initialization raises that exception when calling loadPropFile to load the file
	 */
	public Client(int maxResults, boolean throwOAuthProblemException) throws IOException, Error {
		this.settings = new Settings();
		this.userAgent = CUSTOM_USER_AGENT;
		this.maxResults = maxResults;
		OneloginOAuthJSONAccessTokenResponse.enableThrowingOAuthProblemException(throwOAuthProblemException);
		OneloginOAuthJSONResourceResponse.enableThrowingOAuthProblemException(throwOAuthProblemException);
	}

	public Client(int maxResults) throws IOException, Error {
		this(maxResults, true);
	}

	public Client() throws IOException, Error {
		this(1000, true);
	}

	public Client(boolean throwOAuthProblemException) throws IOException, Error {
		this(1000, throwOAuthProblemException);
	}

	public Client(String clientID, String clientSecret, String region) {
		this(clientID, clientSecret, region, true);
	}

	public Client(String clientID, String clientSecret, String region, boolean throwOAuthProblemException) {
		this.settings = new Settings(clientID, clientSecret, region);
		this.userAgent = CUSTOM_USER_AGENT;
		this.maxResults = 1000;
		OneloginOAuthJSONAccessTokenResponse.enableThrowingOAuthProblemException(throwOAuthProblemException);
		OneloginOAuthJSONResourceResponse.enableThrowingOAuthProblemException(throwOAuthProblemException);
	}

	public Client(String clientID, String clientSecret, String region, String subdomain, boolean throwOAuthProblemException) {
		this.settings = new Settings(clientID, clientSecret, region, subdomain);
		this.userAgent = CUSTOM_USER_AGENT;
		this.maxResults = 1000;
		OneloginOAuthJSONAccessTokenResponse.enableThrowingOAuthProblemException(throwOAuthProblemException);
		OneloginOAuthJSONResourceResponse.enableThrowingOAuthProblemException(throwOAuthProblemException);
	}

	public Client(String clientID, String clientSecret, String subdomain, Map<String, Integer> api_configuration, boolean throwOAuthProblemException) {
		this.settings = new Settings(clientID, clientSecret, subdomain, api_configuration);
		this.userAgent = CUSTOM_USER_AGENT;
		this.maxResults = 1000;
		OneloginOAuthJSONAccessTokenResponse.enableThrowingOAuthProblemException(throwOAuthProblemException);
		OneloginOAuthJSONResourceResponse.enableThrowingOAuthProblemException(throwOAuthProblemException);
	}

	public void setDefaultApiConfiguration() {
		this.settings.setDefaultApiConfiguration();
	}

	public void setApiConfiguration(Map<String, Integer> apiConfiguration) {
		this.settings.setApiConfiguration(apiConfiguration);
	}

	public void replaceSubsetApiConfiguration(Map<String, Integer> apiConfiguration) {
		this.settings.replaceSubsetApiConfiguration(apiConfiguration);
	}

	public Map<String, Integer> getApiConfiguration(Map<String, Integer> apiConfiguration) {
		return this.settings.getApiConfiguration();
	}

	public Map<String, Integer> getDefaultApiConfiguration() {
		return this.settings.getDefaultApiConfiguration();
	}

	////////////////////////////////
	//  OAuth 2.0 Tokens Methods  //
	////////////////////////////////

	/**
	 * Generates an access token and refresh token that you may use to call Onelogin's API methods.
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONAccessTokenResponse and throwOAuthProblemException is enabled
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/oauth20-tokens/generate-tokens">Generate Tokens documentation</a>
	 */
	public void getAccessToken() throws OAuthSystemException, OAuthProblemException {
		cleanError();
		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClientRequest request = OAuthClientRequest
			.tokenLocation(settings.getURL(Constants.TOKEN_REQUEST_URL))
			.buildBodyMessage();

		Map<String, String> headers = getAuthorizedHeader(false);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("grant_type", GrantType.CLIENT_CREDENTIALS.toString());
		String body = JSONUtils.buildJSON(params);
		request.setBody(body);

		updateTokens(httpClient, request, headers);
	}

	/**
	 * Refreshing tokens provides a new set of access and refresh tokens.
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONAccessTokenResponse and throwOAuthProblemException is enabled
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
		params.put("grant_type", GrantType.REFRESH_TOKEN.toString());
		params.put("access_token", accessToken);
		params.put("refresh_token", refreshToken);
		String body = JSONUtils.buildJSON(params);
		request.setBody(body);

		updateTokens(httpClient, request, headers);
	}

	/**
	 * Revokes an access token and refresh token pair.
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONAccessTokenResponse and throwOAuthProblemException is enabled
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
			setResponseError(oAuthResponse);
		}
	}

	/**
	 * Gets current rate limit details about an access token.
	 *
	 * @return RateLimit object
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.RateLimit
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/oauth20-tokens/get-rate-limit">Get Rate Limit documentation</a>
	 */
	public RateLimit getRateLimit() throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = 1;
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_RATE_URL));

		return (RateLimit)getResource(RateLimit.class, url, versionId);
	}

	////////////////////
	//  User Methods  //
	////////////////////

    /**
	 * Gets a list of User resources.
	 *
	 * @param queryParameters Query parameters of the Resource
	 *            Parameters to filter the result of the list
	 * @param maxResults
	 *            Limit the number of users returned (optional)
	 *
	 * @return List of User
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResourceContext call
     * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.User
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/users/list-users">List Users documentation</a>
	 */
	public List<User> getUsers(HashMap<String, String> queryParameters, int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_USERS_URL");
		ExtractionContext context = getResourceContext(queryParameters, Constants.GET_USERS_URL, versionId);

		@SuppressWarnings("unchecked")
		List<User> users = (List<User>)iterateResourceCollector(User.class, context, maxResults, versionId);
		return users;
	}

	/**
	 * Gets a list of User resources.
	 *
	 * @param queryParameters Query parameters of the Resource
	 *            Parameters to filter the result of the list
	 *
	 * @return List of User
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResourceContext call
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.User
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/users/list-users">List Users documentation</a>
	 */
	public List<User> getUsers(HashMap<String, String> queryParameters) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResourceContext call
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.User
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/users/list-users">List Users documentation</a>
	 */
	public List<User> getUsers(int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getUsers(new HashMap<String, String>(), maxResults);
	}

	/**
	 * Gets a list of User resources
	 *
	 * @return List of User
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResourceContext call
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.User
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/users/list-users">List Users documentation</a>
	 */
	public List<User> getUsers() throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getUsers(new HashMap<String, String>());
	}

	/**
	 * Get a batch Users.
	 * 
	 * This is usually the first version of the user batching methods to call as it requires no after-cursor information.
	 * 
	 * @param batchSize Size of the Batch
	 *
	 * @return OneLoginResponse of User (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResourceContext call
	 * @throws ErrorResourceInitialization
	 * @throws NoSuchMethodException
	 *
	 * @see com.onelogin.sdk.model.User
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/users/list-users">List Users documentation</a>
	 */
	public OneLoginResponse<User> getUsersBatch(int batchSize) throws OAuthSystemException, OAuthProblemException, URISyntaxException, NoSuchMethodException, ErrorResourceInitialization  {
		return getUsersBatch(batchSize, null);
	}

	/**
	 * Get a batch Users.
	 * 
	 * This is usually the first version of the user batching methods to call as it requires no after-cursor information.
	 * 
	 * @param batchSize Size of the Batch
	 * @param afterCursor Reference to continue collecting items of next page
	 *
	 * @return OneLoginResponse of User (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResourceContext call
	 * @throws ErrorResourceInitialization
	 * @throws NoSuchMethodException
	 *
	 * @see com.onelogin.sdk.model.User
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/users/list-users">List Users documentation</a>
	 */
	public OneLoginResponse<User> getUsersBatch(int batchSize, String afterCursor) throws OAuthSystemException, OAuthProblemException, URISyntaxException, NoSuchMethodException, ErrorResourceInitialization  {
		HashMap<String, String> queryParameters = new HashMap<String, String>();
		return getUsersBatch(queryParameters, batchSize, afterCursor);
	}

	/**
	 * Get a batch of Users.
	 * 
	 * @param batchSize Size of the Batch
	 * @param queryParameters Query parameters of the Resource
	 *
	 * @return OneLoginResponse of User (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResourceContext call
	 * @throws ErrorResourceInitialization
	 * 
	 * @see com.onelogin.sdk.model.User
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/users/list-users">List Users documentation</a>
	 */
	public OneLoginResponse<User> getUsersBatch(HashMap<String, String> queryParameters, int batchSize) throws NoSuchMethodException, OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getUsersBatch(queryParameters, batchSize, null);
	}

	/**
	 * Get a batch of Users.
	 *
	 * @deprecated This method will be private in future releases, you don't need to provide the queryParameters because its value is already contained in the afterCursor value
	 * 
	 * @param queryParameters Query parameters of the Resource
	 * @param batchSize Size of the Batch
	 * @param afterCursor Reference to continue collecting items of next page
	 *
	 * @return OneLoginResponse of User (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResourceContext call
	 * @throws ErrorResourceInitialization
	 * 
	 * @see com.onelogin.sdk.model.User
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/users/list-users">List Users documentation</a>
	 */
	@Deprecated
	public OneLoginResponse<User> getUsersBatch(HashMap<String, String> queryParameters, int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_USERS_URL");
		ExtractionContext context = extractResourceBatch(queryParameters, batchSize, afterCursor, Constants.GET_USERS_URL, versionId);
		List<OneLoginResource> resourceList = new ArrayList<OneLoginResource>();
		afterCursor = getResourceListBatch(resourceList, User.class, context, versionId);
		return new OneLoginResponse<User>(resourceList, afterCursor);
	}

	/**
	 * Gets User by ID.
	 *
	 * @param id
	 *            Id of the user
	 *
	 * @return User
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.User
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-user-by-id">Get User by ID documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/users/get-user">Get User documentation</a>
	 */
	public User getUser(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_USER_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_USER_URL, Long.toString(id), versionId));

		return (User)getResource(User.class, url, versionId);
	}

	/**
	 * Gets a list of apps accessible by a user, not including personal apps.
	 *
	 * @param id
	 *            Id of the user
	 * @param ignore_visibility
	 *            Defaults to `false`. When `true` will all apps that are assigned to a user regardless of their portal visibility setting.
	 *
	 * @return List of App
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.UserApp
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-apps-for-user">Get Apps for a User documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/users/get-user-apps">Get User Apps documentation</a>
	 */
	public List<App> getUserApps(long id, boolean ignore_visibility) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_APPS_FOR_USER_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_APPS_FOR_USER_URL, Long.toString(id), versionId));
		HashMap<String, Object> queryParameters = new HashMap<String, Object>();
		if (versionId != 1) {
			queryParameters.put("ignore_visibility", String.valueOf(ignore_visibility));
		}

		@SuppressWarnings("unchecked")
		List<App> apps = (List<App>) retrieveResourceList(App.class, url, queryParameters, versionId);
		return apps;
	}

	/**
	 * Gets a list of apps accessible by a user, not including personal apps.
	 *
	 * @param id
	 *            Id of the user
	 *
	 * @return List of App
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.UserApp
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-apps-for-user">Get Apps for a User documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/users/get-user-apps">Get User Apps documentation</a>
	 */
	public List<App> getUserApps(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getUserApps(id, false);
	}

	/**
	 * Gets a list of role IDs that have been assigned to a user.
	 *
	 * @param id
	 *            Id of the user
	 *
	 * @return List of Role Ids
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Role
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-roles-for-user">Get Roles for a User documentation</a>
	 */
	public List<Long> getUserRoles(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		int versionId = settings.getVersionId("GET_ROLES_FOR_USER_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_ROLES_FOR_USER_URL, Long.toString(id), versionId));

		return getIdList(url, versionId);
	}

	/**
	 * Gets a list of all custom attribute fields (also known as custom user fields) that have been defined for OL account.
	 *
	 * @return List of custom attribute fields
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-custom-attributes">Get Custom Attributes documentation</a>
	 */
	public List<String> getCustomAttributes() throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		int versionId = settings.getVersionId("GET_CUSTOM_ATTRIBUTES_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_CUSTOM_ATTRIBUTES_URL, versionId));

		return retrieveList(url, versionId);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/create-user">Create User documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/users/create-user">Create User documentation</a>
	 */
	public User createUser(Map<String, Object> userParams) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("CREATE_USER_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.CREATE_USER_URL, versionId));

		return (User) createResource(User.class, userParams, url, versionId);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/update-user">Update User by ID documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/users/update-user">Update User documentation</a>
	 */
	public User updateUser(long id, Map<String, Object> userParams) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("UPDATE_USER_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.UPDATE_USER_URL, Long.toString(id), versionId));

		return (User) updateResource(User.class, userParams, url, versionId);
	}

	/**
	 * Assigns Role to User
	 *
	 * @param id
	 *            Id of the user to be modified
	 * @param roleIds
	 *            Array of one or more role IDs to be added.
	 *
	 * @return true if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/assign-role-to-user">Assign Role to User documentation</a>
	 */
	public Boolean assignRoleToUser(long id, List<Long> roleIds) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("ADD_ROLE_TO_USER_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.ADD_ROLE_TO_USER_URL, Long.toString(id), versionId));

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("role_id_array", roleIds);

		return updateOperation(params, url, versionId);
	}

	/**
	 * Remove Role from User
	 *
	 * @param id
	 *            Id of the user to be modified
	 * @param roleIds
	 *            An array of one or more role IDs to be removed.
	 *
	 * @return true if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/remove-role-from-user">Remove Role from User documentation</a>
	 */
	public Boolean removeRoleFromUser(long id, List<Long> roleIds) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("DELETE_ROLE_TO_USER_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.DELETE_ROLE_TO_USER_URL, Long.toString(id), versionId));

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("role_id_array", roleIds);

		return updateOperation(params, url, versionId);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/set-password-in-cleartext">Set Password by ID Using Cleartext documentation</a>
	 */
	public Boolean setPasswordUsingClearText(long id, String password, String passwordConfirmation) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("SET_PW_CLEARTEXT");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.SET_PW_CLEARTEXT, Long.toString(id), versionId));

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("password", password);
		params.put("password_confirmation", passwordConfirmation);

		return updateOperation(params, url, versionId);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/set-password-using-sha-256">Set Password by ID Using Salt and SHA-256 documentation</a>
	 */
	public Boolean setPasswordUsingHashSalt(long id, String password, String passwordConfirmation, String passwordAlgorithm, String passwordSalt) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("SET_PW_SALT");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.SET_PW_SALT, Long.toString(id), versionId));

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("password", password);
		params.put("password_confirmation", passwordConfirmation);
		params.put("password_algorithm", passwordAlgorithm);
		if (passwordSalt != null && !passwordSalt.isEmpty()) {
			params.put("password_salt", passwordSalt);
		}

		return updateOperation(params, url, versionId);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/set-password-using-sha-256">Set Password by ID Using Salt and SHA-256 documentation</a>
	 */
	public Boolean setPasswordUsingHashSalt(long id, String password, String passwordConfirmation, String passwordAlgorithm) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/set-state">Set User State documentation</a>
	 */
	public Boolean setStateToUser(long id, int state) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {

		int versionId = settings.getVersionId("SET_STATE_TO_USER_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.SET_STATE_TO_USER_URL, Long.toString(id), versionId));

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("state", state);

		return updateOperation(params, url, versionId);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/set-custom-attribute">Set Custom Attribute Value documentation</a>
	 */
	public Boolean setCustomAttributeToUser(long id, Map<String, Object> customAttributes) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("SET_CUSTOM_ATTRIBUTE_TO_USER_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.SET_CUSTOM_ATTRIBUTE_TO_USER_URL, Long.toString(id), versionId));

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("custom_attributes", (Object)customAttributes);

		return updateOperation(params, url, versionId);
	}

	/**
	 * Log a user out of any and all sessions.
	 *
	 * @param id
	 *            Id of the user to be modified
	 *
	 * @return true if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/log-user-out">Log User Out documentation</a>
	 */
	public Boolean logUserOut(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("LOG_USER_OUT_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.LOG_USER_OUT_URL, Long.toString(id), versionId));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
			.buildHeaderMessage();

		return updateOperation(null, url, versionId);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/lock-user-account">Lock User Account documentation</a>
	 */
	public Boolean lockUser(long id, int minutes) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("LOCK_USER_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.LOCK_USER_URL, Long.toString(id), versionId));

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("locked_until", minutes);

		return updateOperation(params, url, versionId);
	}

	/**
	 * Deletes an user
	 *
	 * @param id
	 *            Id of the user to be deleted
	 *
	 * @return true if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/delete-user">Delete User by ID documentation</a>
	 */
	public Boolean deleteUser(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("DELETE_USER_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.DELETE_USER_URL, Long.toString(id), versionId));

		return deleteResource(url, versionId);
	}


	//////////////////////////////
	//  Onelogin Login Methods  //
	//////////////////////////////

	/**
	 * Generates a session login token in scenarios in which MFA may or may not be required.
	 * A session login token expires two minutes after creation.
	 *
	 * @param params
	 *            Parameters (username_or_email, password, subdomain, return_to_url, ip_address, browser_id)
	 * @param allowedOrigin
	 *            Custom-Allowed-Origin-Header. Required for CORS requests only. Set to the Origin URI from which you are allowed to send a request using CORS.
	 *
	 * @return SessionToken (SessionTokenInfo or SessionTokenMFAInfo) object if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/create-session-login-token">Create Session Login Token documentation</a>
	 */
	public SessionToken createSessionLoginToken(Map<String, Object> params, String allowedOrigin) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		int versionId = settings.getVersionId("SESSION_LOGIN_TOKEN_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.SESSION_LOGIN_TOKEN_URL, versionId));

		return processLogin(url, versionId, params, allowedOrigin);
	}

	/**
	 * Generate a session login token in scenarios in which MFA may or may not be required.
	 * A session login token expires two minutes after creation.
	 *
	 * @param params
	 *            Parameters (username_or_email, password, subdomain, return_to_url, ip_address, browser_id)
	 *
	 * @return SessionToken (SessionTokenInfo or SessionTokenMFAInfo) object if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/create-session-login-token">Create Session Login Token documentation</a>
	 */
	public SessionToken createSessionLoginToken(Map<String, Object> params) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return createSessionLoginToken(params, null);
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
	 * @return SessionToken (SessionTokenInfo or SessionTokenMFAInfo) object if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/verify-factor">Verify Factor documentation</a>
	 */
	public SessionToken getSessionTokenVerified(String devideId, String stateToken, String otpToken, String allowedOrigin, Boolean doNotNotify) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		int versionId = settings.getVersionId("GET_TOKEN_VERIFY_FACTOR");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_TOKEN_VERIFY_FACTOR, versionId));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("device_id", devideId);
		params.put("state_token", stateToken);
		params.put("do_not_notify", doNotNotify);

		if (otpToken != null && !otpToken.isEmpty()) {
			params.put("otp_token", otpToken);
		}

		return processLogin(url, versionId, params, allowedOrigin);
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
	 * @return SessionToken (SessionTokenInfo or SessionTokenMFAInfo) object if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/verify-factor">Verify Factor documentation</a>
	 */
	public SessionToken getSessionTokenVerified(long devideId, String stateToken, String otpToken, String allowedOrigin, Boolean doNotNotify) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getSessionTokenVerified(Long.toString(devideId), stateToken, otpToken, allowedOrigin, doNotNotify);
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
	 * @return SessionToken (SessionTokenInfo or SessionTokenMFAInfo) object if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/verify-factor">Verify Factor documentation</a>
	 */
	public SessionToken  getSessionTokenVerified(String devideId, String stateToken, String otpToken, String allowedOrigin) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
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
	 * @param allowedOrigin
	 *            Custom-Allowed-Origin-Header. Required for CORS requests only. Set to the Origin URI from which you are allowed to send a request using CORS.
	 *
	 * @return SessionToken (SessionTokenInfo or SessionTokenMFAInfo) object if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/verify-factor">Verify Factor documentation</a>
	 */
	public SessionToken  getSessionTokenVerified(long devideId, String stateToken, String otpToken, String allowedOrigin) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getSessionTokenVerified(Long.toString(devideId), stateToken, otpToken, allowedOrigin, false);
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
	 * @return SessionToken (SessionTokenInfo or SessionTokenMFAInfo) object if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/verify-factor">Verify Factor documentation</a>
	 */
	public SessionToken getSessionTokenVerified(String devideId, String stateToken, String otpToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getSessionTokenVerified(devideId, stateToken, otpToken, null, false);
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
	 * @return SessionToken (SessionTokenInfo or SessionTokenMFAInfo) object if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/verify-factor">Verify Factor documentation</a>
	 */
	public SessionToken getSessionTokenVerified(long devideId, String stateToken, String otpToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getSessionTokenVerified(Long.toString(devideId), stateToken, otpToken, null, false);
	}

	/**
	 * Verify a one-time password (OTP) value provided for multi-factor authentication (MFA).
	 *
	 * @param devideId
	 *            Provide the MFA device_id you are submitting for verification.
	 * @param stateToken
	 *            Provide the state_token associated with the MFA device_id you are submitting for verification.
	 *
	 * @return SessionToken (SessionTokenInfo or SessionTokenMFAInfo) object if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/verify-factor">Verify Factor documentation</a>
	 */
	public SessionToken getSessionTokenVerified(String devideId, String stateToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getSessionTokenVerified(devideId, stateToken, null);
	}

	/**
	 * Verify a one-time password (OTP) value provided for multi-factor authentication (MFA).
	 *
	 * @param devideId
	 *            Provide the MFA device_id you are submitting for verification.
	 * @param stateToken
	 *            Provide the state_token associated with the MFA device_id you are submitting for verification.
	 *
	 * @return SessionToken (SessionTokenInfo or SessionTokenMFAInfo) object if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/verify-factor">Verify Factor documentation</a>
	 */
	public SessionToken getSessionTokenVerified(long devideId, String stateToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getSessionTokenVerified(Long.toString(devideId), stateToken, null);
	}

	/////////////////////////////
	//  Onelogin Apps Methods  //
	/////////////////////////////

	/**
	 * Gets a list of OneLoginApp resources.
	 *
	 * @param queryParameters Query parameters of the Resource
	 *            Parameters to filter the result of the list
	 * @param maxResults
	 *            Limit the number of OneLoginApp returned (optional)
	 *
	 * @return List of OneLoginApp
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at getResource call
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.OneLoginApp
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/apps/get-apps">Get Apps documentation</a>
	 */
	public List<OneLoginApp> getApps(HashMap<String, String> queryParameters, int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_APPS_URL");
		ExtractionContext context = getResourceContext(queryParameters, Constants.GET_APPS_URL, versionId);

		@SuppressWarnings("unchecked")
		List<OneLoginApp> apps = (List<OneLoginApp>) iterateResourceCollector(OneLoginApp.class, context, maxResults, versionId);
		return apps;
	}

	/**
	 * Gets a list of OneLoginApp resources.
	 *
	 * @param queryParameters Query parameters of the Resource
	 *            Parameters to filter the result of the list
	 *
	 * @return List of OneLoginApp
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.OneLoginApp
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/apps/get-apps">Get Apps documentation</a>
	 */
	public List<OneLoginApp> getApps(HashMap<String, String> queryParameters) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getApps(queryParameters, this.maxResults);
	}

	/**
	 * Gets a list of OneLoginApp resources.
	 *
	 * @param maxResults
	 *            Limit the number of OneLoginApps returned (optional)
	 *
	 * @return List of OneLoginApp
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.OneLoginApp
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/apps/get-apps">Get Apps documentation</a>
	 */
	public List<OneLoginApp> getApps(int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getApps(new HashMap<String, String>(), maxResults);
	}

	/**
	 * Gets a list of OneLoginApp resources
	 *
	 * @return List of OneLoginApp
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.OneLoginApp
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/apps/get-apps">Get Apps documentation</a>
	 */
	public List<OneLoginApp> getApps() throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getApps(new HashMap<String, String>());
	}

	/**
	 * Get a batch of OneLoginApps.
	 * 
	 * @param batchSize Size of the Batch
	 *
	 * @return OneLoginResponse of OneLoginApp (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 * 
	 * @see com.onelogin.sdk.model.OneLoginApp
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/apps/get-apps">Get Apps documentation</a>
	 */
	public OneLoginResponse<OneLoginApp> getOneLoginAppsBatch(int batchSize) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getOneLoginAppsBatch(batchSize, null);
	}

	/**
	 * Get a batch of OneLoginApps.
	 * 
	 * @param batchSize Size of the Batch
	 * @param afterCursor Reference to continue collecting items of next page
	 *
	 * @return OneLoginResponse of OneLoginApp (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 * 
	 * @see com.onelogin.sdk.model.OneLoginApp
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/apps/get-apps">Get Apps documentation</a>
	 */
	public OneLoginResponse<OneLoginApp> getOneLoginAppsBatch(int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getOneLoginAppsBatch(new HashMap<String, String>(), batchSize, afterCursor);
	}

	/**
	 * Get a batch of OneLoginApps.
	 *
	 * @deprecated This method will be private in future releases, you don't need to provide the queryParameters because its value is already contained in the afterCursor value
	 *
	 * @param queryParameters Query parameters of the Resource
	 * @param batchSize Size of the Batch
	 * @param afterCursor Reference to continue collecting items of next page
	 *
	 * @return OneLoginResponse of OneLoginApp (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 * 
	 * @see com.onelogin.sdk.model.OneLoginApp
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/apps/get-apps">Get Apps documentation</a>
	 */
	@Deprecated
	public OneLoginResponse<OneLoginApp> getOneLoginAppsBatch(HashMap<String, String> queryParameters, int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_APPS_URL");
		ExtractionContext context = extractResourceBatch(queryParameters, batchSize, afterCursor, Constants.GET_APPS_URL, versionId);

		List<OneLoginResource> resourceList = new ArrayList<OneLoginResource>();
		afterCursor = getResourceListBatch(resourceList, OneLoginApp.class, context, versionId);
		return new OneLoginResponse<OneLoginApp>(resourceList, afterCursor);
	}

	////////////////////
	//  Role Methods  //
	////////////////////

	/**
	 * Gets a list of Role resources.
	 *
	 * @param queryParameters Query parameters of the Resource
	 *            Parameters to filter the result of the list
	 * @param maxResults
	 *            Limit the number of roles returned (optional)
	 *
	 * @return List of Role
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at getResource call
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Role
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/roles/get-roles">Get Roles documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/list-roles">List Roles documentation</a>
	 */
	public List<Role> getRoles(HashMap<String, String> queryParameters, int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_ROLES_URL");
		ExtractionContext context = getResourceContext(queryParameters, Constants.GET_ROLES_URL, versionId);

		@SuppressWarnings("unchecked")
		List<Role> roles = (List<Role>)iterateResourceCollector(Role.class, context, maxResults, versionId);
		return roles;
	}

	/**
	 * Gets a list of Role resources.
	 *
	 * @param queryParameters Query parameters of the Resource
	 *            Parameters to filter the result of the list
	 *
	 * @return List of Role
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Role
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/roles/get-roles">Get Roles documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/list-roles">List Roles documentation</a>
	 */
	public List<Role> getRoles(HashMap<String, String> queryParameters) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Role
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/roles/get-roles">Get Roles documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/list-roles">List Roles documentation</a>
	 */
	public List<Role> getRoles(int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getRoles(new HashMap<String, String>(), maxResults);
	}

	/**
	 * Gets a list of Role resources
	 *
	 * @return List of Role
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Role
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/roles/get-roles">Get Roles documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/list-roles">List Roles documentation</a>
	 */
	public List<Role> getRoles() throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		HashMap<String, String> queryParameters = new HashMap<String, String>();
		return getRoles(queryParameters);
	}

	/**
	 * Get a batch of Roles.
	 * 
	 * @param batchSize Size of the Batch
	 *
	 * @return OneLoginResponse of Role (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 * 
	 * @see com.onelogin.sdk.model.Role
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/roles/get-roles">Get Roles documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/list-roles">List Roles documentation</a>
	 */
	public OneLoginResponse<Role> getRolesBatch(int batchSize) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getRolesBatch(batchSize, null);
	}

	/**
	 * Get a batch of Roles.
	 * 
	 * @param batchSize Size of the Batch
	 * @param afterCursor Reference to continue collecting items of next page
	 *
	 * @return OneLoginResponse of Role (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 * 
	 * @see com.onelogin.sdk.model.Role
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/roles/get-roles">Get Roles documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/list-roles">List Roles documentation</a>
	 */
	public OneLoginResponse<Role> getRolesBatch(int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getRolesBatch(new HashMap<String, String>(), batchSize, afterCursor);
	}

	/**
	 * Get a batch of Roles.
	 * 
	 * @deprecated This method will be private in future releases, you don't need to provide the queryParameters because its value is already contained in the afterCursor value
	 * 
	 * @param queryParameters Query parameters of the Resource
	 * @param batchSize Size of the Batch
	 * @param afterCursor Reference to continue collecting items of next page
	 *
	 * @return OneLoginResponse of Role (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 * 
	 * @see com.onelogin.sdk.model.Role
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/roles/get-roles">Get Roles documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/list-roles">List Roles documentation</a>
	 */
	@Deprecated
	public OneLoginResponse<Role> getRolesBatch(HashMap<String, String> queryParameters, int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_ROLES_URL");
		ExtractionContext context = extractResourceBatch(queryParameters, batchSize, afterCursor, Constants.GET_ROLES_URL, versionId);
		List<OneLoginResource> resourceList = new ArrayList<OneLoginResource>();
		afterCursor = getResourceListBatch(resourceList, Role.class, context, versionId);
		return new OneLoginResponse<Role>(resourceList, afterCursor);
	}

	/**
	 * Creates a role
	 *
	 * @param roleParams
	 *            Role data (name, apps, users, admins)
	 *
	 * @return Created role id
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/create-role">Create Role documentation</a>
	 */
	public Long createRole(Map<String, Object> roleParams) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("CREATE_ROLE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.CREATE_ROLE_URL, versionId));

		String roleId = createResource(roleParams, url, versionId);
		if (roleId != null) {
			return Long.parseLong(roleId);
		}
		return null;
	}

	/**
	 * Gets Role by ID.
	 *
	 * @param id
	 *            Id of the role
	 *
	 * @return Role
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Role
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/roles/get-role-by-id">Get Role by ID documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/get-role">Get Role documentation</a>
	 */
	public Role getRole(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_ROLE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_ROLE_URL, Long.toString(id), versionId));

		return (Role) getResource(Role.class, url, versionId);
	}

	/**
	 * Updates a role
	 *
	 * @param id
	 *            Id of the role to be modified
	 * @param roleParams
	 *            Role data (name, apps, users, admins)
	 *
	 * @return Updated user
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/users/update-role">Update Role documentation</a>
	 */
	public Long updateRole(long id, Map<String, Object> roleParams) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("UPDATE_ROLE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.UPDATE_ROLE_URL, Long.toString(id), versionId));

		String roleId = updateResource(roleParams, url, versionId);
		if (roleId != null) {
			return Long.parseLong(roleId);
		}
		return null;
	}

	/**
	 * Gets a list of Apps assigned to a role.
	 *
	 * @param roleId
	 *            Id of the role
	 * @param assigned
	 *            Defaults to true. Returns all apps assigned to the role, or the opposite (optional)
	 *
	 * @return List of app
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/get-role-apps">Get Role Apps documentation</a>
	 */
	public List<AssignedApp> getRoleApps(long roleId, Boolean assigned) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_ROLE_APPS_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_ROLE_APPS_URL, Long.toString(roleId), versionId));

		HashMap<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put("assigned", assigned);

		@SuppressWarnings("unchecked")
		List<AssignedApp> roleApps = (List<AssignedApp>) retrieveResourceList(AssignedApp.class, url, queryParameters, versionId);
		return roleApps;
	}

	public List<AssignedApp> getRoleApps(long roleId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getRoleApps(roleId, true);
	}

	/**
	 * Assign applications to a role.
	 *
	 * @param roleId
	 *            Id of the role
	 * @param appIds
	 *            List of app ids
	 *
	 * @return List of app ids of a role
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/set-role-apps">Set Role Apps documentation</a>
	 */
	public List<Long> setRoleApps(long roleId, List<Long> appIds) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("SET_ROLE_APPS_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.SET_ROLE_APPS_URL, Long.toString(roleId), versionId));

		return setOperation(appIds, url, versionId);
	}

	/**
	 * Gets a list of Users assigned to a role.
	 *
	 * @param roleId
	 *            Id of the role
	 * @param name
	 *            Allows you to filter on first name, last name, username, and email address.
	 * @param includeUnassigned
	 *            Include users that aren't assigned to the role. (optional)
	 *
	 * @return List of related users
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/get-role-users">Get Role Users documentation</a>
	 */
	public List<AssignedUser> getRoleUsers(long roleId, String name, Boolean includeUnassigned) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_ROLE_USERS_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_ROLE_USERS_URL, Long.toString(roleId), versionId));

		HashMap<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put("name", name);
		queryParameters.put("include_unassigned", includeUnassigned);

		@SuppressWarnings("unchecked")
		List<AssignedUser> roleApps = (List<AssignedUser>) retrieveResourceList(AssignedUser.class, url, queryParameters, versionId);
		return roleApps;
	}

	/**
	 *  Add users to a role.
	 *
	 * @param roleId
	 *            Id of the role
	 * @param userIds
	 *            List of user ids to be added to the role
	 *
	 * @return List of user ids added to the role
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/add-role-users">Add Role Users documentation</a>
	 */
	public List<Long> addRoleUsers(long roleId, List<Long> userIds) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("ADD_ROLE_USERS_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.ADD_ROLE_USERS_URL, Long.toString(roleId), versionId));

		return  addToResourceOperation(userIds, url, versionId);
	}

	/**
	 *  Remove users from a role.
	 *
	 * @param roleId
	 *            Id of the role
	 * @param userIds
	 *            List of user ids to be removed from the role
	 *
	 * @return true if succeed
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/remove-role-users">Remove Role Users documentation</a>
	 */
	public Boolean removeRoleUsers(long roleId, List<Long> userIds) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("REMOVE_ROLE_USERS_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.REMOVE_ROLE_USERS_URL, Long.toString(roleId), versionId));

		return  removeFromResourceOperation(userIds, url, versionId);
	}

	/**
	 * Gets a list of Admins assigned to a role.
	 *
	 * @param roleId
	 *            Id of the role
	 * @param name
	 *            Allows you to filter on first name, last name, username, ad email address.
	 * @param includeUnassigned
	 *            Include users that aren't assigned to the role. (optional)
	 *
	 * @return List of related admins
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/get-role-admins">Get Role Admins documentation</a>
	 */
	public List<AssignedAdmin> getRoleAdmins(long roleId, String name, Boolean includeUnassigned) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_ROLE_ADMINS_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_ROLE_ADMINS_URL, Long.toString(roleId), versionId));

		HashMap<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put("name", name);
		queryParameters.put("include_unassigned", includeUnassigned);

		@SuppressWarnings("unchecked")
		List<AssignedAdmin> roleApps = (List<AssignedAdmin>) retrieveResourceList(AssignedAdmin.class, url, queryParameters, versionId);
		return roleApps;
	}

	/**
	 *  Add admins to a role.
	 *
	 * @param roleId
	 *            Id of the role
	 * @param adminIds
	 *            List of admin ids to be added to the role
	 *
	 * @return List of admin ids added to the role
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/add-role-admins">Add Role Admins documentation</a>
	 */
	public List<Long> addRoleAdmins(long roleId, List<Long> adminIds) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("ADD_ROLE_ADMINS_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.ADD_ROLE_ADMINS_URL, Long.toString(roleId), versionId));

		return  addToResourceOperation(adminIds, url, versionId);
	}

	/**
	 *  Remove admins from a role.
	 *
	 * @param roleId
	 *            Id of the role
	 * @param adminIds
	 *            List of admin ids to be removed from the role
	 *
	 * @return true if succeed
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/remove-role-admins">Remove Role Admins documentation</a>
	 */
	public Boolean removeRoleAdmins(long roleId, List<Long> adminIds) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("REMOVE_ROLE_ADMINS_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.REMOVE_ROLE_ADMINS_URL, Long.toString(roleId), versionId));

		return  removeFromResourceOperation(adminIds, url, versionId);
	}

	/**
	 * Deletes a role
	 *
	 * @param id
	 *            Id of the role to be deleted
	 *
	 * @return true if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/roles/delete-role">Delete Role by ID documentation</a>
	 */
	public Boolean deleteRole(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("DELETE_ROLE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.DELETE_ROLE_URL, Long.toString(id), versionId));

		return deleteResource(url, versionId);
	}

	/////////////////////
	//  Event Methods  //
	/////////////////////

	/**
	 * List of all OneLogin event types available to the Events API.
	 *
	 * @return List of EventType
	 *
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws IOException - if CloseableHttpClient raises the exception
	 * @throws ClientProtocolException - if CloseableHttpClient raises the exception
	 * @throws ErrorResourceInitialization
	 * @throws OAuthProblemException 
	 * @throws OAuthSystemException 
	 *
	 * @see com.onelogin.sdk.model.EventType
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/event-types">Get Event Types documentation</a>
	 */
	public List<EventType> getEventTypes() throws URISyntaxException, ClientProtocolException, IOException, OAuthSystemException, OAuthProblemException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_EVENT_TYPES_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_EVENT_TYPES_URL, versionId));

		List<EventType> eventTypes = (List<EventType>) retrieveResourceList(EventType.class, url, new HashMap<String, Object>(), versionId); 
		return eventTypes;
	}

	/**
	 * Gets a list of Event resources.
	 *
	 * @param queryParameters Query parameters of the Resource
	 *            Parameters to filter the result of the list
	 * @param maxResults
	 *            Limit the number of events returned (optional)
	 *
	 * @return List of Event
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitializationd
	 *
	 * @see com.onelogin.sdk.model.Event
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/get-events">Get Events documentation</a>
	 */
	public List<Event> getEvents(HashMap<String, String> queryParameters, int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_EVENTS_URL");
		ExtractionContext context = getResourceContext(queryParameters, Constants.GET_EVENTS_URL, versionId);

		@SuppressWarnings("unchecked")
		List<Event> events = (List<Event>)iterateResourceCollector(Event.class, context, maxResults, versionId);
		return events;
	}

	/**
	 * Gets a list of Event resources.
	 *
	 * @param queryParameters Query parameters of the Resource
	 *            Parameters to filter the result of the list
	 *
	 * @return List of Event
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Event
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/get-events">Get Events documentation</a>
	 */
	public List<Event> getEvents(HashMap<String, String> queryParameters) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Event
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/get-events">Get Events documentation</a>
	 */
	public List<Event> getEvents(int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		HashMap<String, String> queryParameters = new HashMap<String, String>();
		return getEvents(queryParameters, maxResults);
	}

	/**
	 * Gets a list of Event resources. (50 elements)
	 *
	 * @return List of Event
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Event
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/get-events">Get Events documentation</a>
	 */
	public List<Event> getEvents() throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		HashMap<String, String> queryParameters = new HashMap<String, String>();
		return getEvents(queryParameters);
	}

	/**
	 * Get a batch of Events.
	 * 
	 * @param batchSize Size of the Batch
	 *
	 * @return OneLoginResponse of Event (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 * 
	 * @see com.onelogin.sdk.model.Event
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/get-events">Get Events documentation</a>
	 */
	public OneLoginResponse<Event> getEventsBatch(int batchSize) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getEventsBatch(batchSize, null);
	}

	/**
	 * Get a batch of Events.
	 * 
	 * @param batchSize Size of the Batch
	 * @param afterCursor Reference to continue collecting items of next page
	 *
	 * @return OneLoginResponse of Event (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 * 
	 * @see com.onelogin.sdk.model.Event
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/get-events">Get Events documentation</a>
	 */
	public OneLoginResponse<Event> getEventsBatch(int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getEventsBatch(new HashMap<String, String>(), batchSize, afterCursor);
	}

	/**
	 * Get a batch of Events.
	 *
	 * @deprecated This method will be private in future releases, you don't need to provide the queryParameters because its value is already contained in the afterCursor value
	 *
	 * @param queryParameters Query parameters of the Resource
	 * @param batchSize Size of the Batch
	 * @param afterCursor Reference to continue collecting items of next page
	 *
	 * @return OneLoginResponse of Event (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 * 
	 * @see com.onelogin.sdk.model.Event
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/get-events">Get Events documentation</a>
	 */
	@Deprecated
	public OneLoginResponse<Event> getEventsBatch(HashMap<String, String> queryParameters, int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_EVENTS_URL");
		ExtractionContext context = extractResourceBatch(queryParameters, batchSize, afterCursor, Constants.GET_EVENTS_URL, versionId);

		List<OneLoginResource> resourceList = new ArrayList<OneLoginResource>();
		afterCursor = getResourceListBatch(resourceList, Event.class, context, versionId);
		return new OneLoginResponse<Event>(resourceList, afterCursor);

	}

	/**
	 * Gets Event by ID.
	 *
	 * @param id
	 *            Id of the event
	 *
	 * @return Event
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Event
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/get-event-by-id">Get Event by ID documentation</a>
	 */
	public Event getEvent(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_EVENT_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_EVENT_URL, Long.toString(id), versionId));

		return (Event)getResource(Event.class, url, versionId);
	}

	/**
	 * Create an event in the OneLogin event log.
     *
	 * @deprecated This method should not be used anymore, the API call will be deprecated in the platform
	 *
	 * @param eventParams
	 *            Event Data (event_type_id, account_id, actor_system, actor_user_id, actor_user_name, app_id,
	 *            assuming_acting_user_id, custom_message, directory_sync_run_id, group_id, group_name, ipaddr,
	 *            otp_device_id, otp_device_name, policy_id, policy_name, role_id, role_name, user_id, user_name)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see com.onelogin.sdk.model.Event
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/events/create-event">Create Event documentation</a>
	 */
	public void createEvent(Map<String, Object> eventParams) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);

		int versionId = settings.getVersionId("CREATE_EVENT_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.CREATE_EVENT_URL, versionId));
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString())
			.buildHeaderMessage();

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		String body = JSONUtils.buildJSON(eventParams);
		bearerRequest.setBody(body);

		OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class);
		if (oAuthResponse.getResponseCode() != 200 || !oAuthResponse.getType().equals("success")) {
			setResponseError(oAuthResponse, true);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResource call
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Group
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/groups/get-groups">Get Groups documentation</a>
	 */
	public List<Group> getGroups(int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_GROUPS_URL");
		ExtractionContext context = getResourceContext(new HashMap<String, String>(), Constants.GET_GROUPS_URL, versionId);

		@SuppressWarnings("unchecked")
		List<Group> groups = (List<Group>)iterateResourceCollector(Group.class, context, maxResults, versionId);
		return groups;
	}

	/**
	 * Gets a list of Group resources.
	 *
	 * @return List of Group
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Group
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/groups/get-groups">Get Groups documentation</a>
	 */
	public List<Group> getGroups() throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getGroups(this.maxResults);
	}

	/**
	 * Get a batch of Groups.
	 * 
	 * @param batchSize Size of the Batch
	 *
	 * @return OneLoginResponse of Group
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 * 
	 * @see com.onelogin.sdk.model.Group
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/groups/get-groups">Get Groups documentation</a>
	 */
	public OneLoginResponse<Group> getGroupsBatch(int batchSize) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getGroupsBatch(batchSize, null);
	}

	/**
	 * Get a batch of Groups.
	 *
	 * @deprecated This method will be private in future releases, you don't need to provide the queryParameters because its value is already contained in the afterCursor value
     *
	 * @param batchSize Size of the Batch
	 * @param afterCursor Reference to continue collecting items of next page
	 *
	 * @return OneLoginResponse of Group
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 * 
	 * @see com.onelogin.sdk.model.Group
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/groups/get-groups">Get Groups documentation</a>
	 */
	public OneLoginResponse<Group> getGroupsBatch(int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return getGroupsBatch(new HashMap<String, String>(), batchSize, afterCursor);
	}

	/**
	 * Get a batch of Groups
	 *
	 * @deprecated This method will be private in future releases, you don't need to provide the queryParameters because its value is already contained in the afterCursor value
	 *
	 * @param queryParameters Query parameters of the Resource
	 * @param batchSize Size of the Batch
	 * @param afterCursor Reference to continue collecting items of next page
	 *
	 * @return OneLoginResponse of Group
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 * 
	 * @see com.onelogin.sdk.model.Group
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/groups/get-groups">Get Groups documentation</a>
	 */
	@Deprecated
	public OneLoginResponse<Group> getGroupsBatch(HashMap<String, String> queryParameters, int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_GROUPS_URL");
		ExtractionContext context = extractResourceBatch(queryParameters, batchSize, afterCursor, Constants.GET_GROUPS_URL, versionId);

		List<OneLoginResource> resourceList = new ArrayList<OneLoginResource>();
		afterCursor = getResourceListBatch(resourceList, Group.class, context, versionId);
		return new OneLoginResponse<Group>(resourceList, afterCursor);
	}

	/**
	 * Gets Group by ID.
	 *
	 * @param id
	 *            Id of the group
	 *
	 * @return Group
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Group
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/groups/get-group-by-id">Get Group by ID documentation</a>
	 */
	public Group getGroup(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_GROUP_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_GROUP_URL, Long.toString(id), versionId));

		return (Group)getResource(Group.class, url, versionId);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see com.onelogin.sdk.model.SAMLEndpointResponse
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/saml-assertions/generate-saml-assertion">Generate SAML Assertion documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/saml-assertions/generate-saml-assertion">Generate SAML Assertion documentation</a>
	 */
	public SAMLEndpointResponse getSAMLAssertion(String usernameOrEmail, String password, String appId, String subdomain, String ipAddress) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		int versionId = settings.getVersionId("GET_SAML_ASSERTION_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_SAML_ASSERTION_URL, versionId));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username_or_email", usernameOrEmail);
		params.put("password", password);
		params.put("app_id", appId);
		params.put("subdomain", subdomain);
		if (ipAddress != null && !ipAddress.isEmpty()) {
			params.put("ip_address", ipAddress);
		}
		String body = JSONUtils.buildJSON(params);

		return retrieveSamlAssertion(url, versionId, params);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see com.onelogin.sdk.model.SAMLEndpointResponse
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/saml-assertions/generate-saml-assertion">Generate SAML Assertion documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/saml-assertions/generate-saml-assertion">Generate SAML Assertion documentation</a>
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see com.onelogin.sdk.model.SAMLEndpointResponse
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/saml-assertions/verify-factor">Verify Factor documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/saml-assertions/verify-factor">Verify Factor documentation</a>
	 */
	public SAMLEndpointResponse getSAMLAssertionVerifying(String appId, String devideId, String stateToken, String otpToken, String urlEndpoint, Boolean doNotNotify) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		int versionId = settings.getVersionId("GET_SAML_VERIFY_FACTOR");

		URIBuilder url;
		if (urlEndpoint != null && !urlEndpoint.isEmpty()) {
			url = new URIBuilder(urlEndpoint);
		} else {
			url = new URIBuilder(settings.getURL(Constants.GET_SAML_VERIFY_FACTOR, versionId));
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("app_id", appId);
		params.put("device_id", devideId);
		params.put("state_token", stateToken);
		params.put("do_not_notify", doNotNotify);

		if (otpToken != null && !otpToken.isEmpty()) {
			params.put("otp_token", otpToken);
		}

		return retrieveSamlAssertion(url, versionId, params);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see com.onelogin.sdk.model.SAMLEndpointResponse
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/saml-assertions/verify-factor">Verify Factor documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/saml-assertions/verify-factor">Verify Factor documentation</a>
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see com.onelogin.sdk.model.SAMLEndpointResponse
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/saml-assertions/verify-factor">Verify Factor documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/saml-assertions/verify-factor">Verify Factor documentation</a>
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see com.onelogin.sdk.model.SAMLEndpointResponse
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/saml-assertions/verify-factor">Verify Factor documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/saml-assertions/verify-factor">Verify Factor documentation</a>
	 */
	public SAMLEndpointResponse getSAMLAssertionVerifying(String appId, String devideId, String stateToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getSAMLAssertionVerifying(appId, devideId, stateToken, null, null);
	}

	///////////////////////
	//  SMART MFA        //
	///////////////////////

	/**
	 * Validates a User
     *
	 * @param validateUserParams Smart MFA User data (user_identifier, email, phone, context, risk_threshold,
     *                                                 firstname, lastname, expires_in)
	 *
	 * @return SmartMFA
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.SmartMFA
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/smart-mfa/validate-user">Validate a Use documentation</a>
	 */
	public SmartMFA validateUser(Map<String, Object> validateUserParams) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
			int versionId = settings.getVersionId("SMART_MFA_VALIDATE_USER");
			URIBuilder url = new URIBuilder(settings.getURL(Constants.SMART_MFA_VALIDATE_USER, versionId));

			return (SmartMFA) createResource(SmartMFA.class, validateUserParams, url, versionId);
	}

	/**
	 * Verify MFA Token
     *
	 * @param stateToken The state_token value returned from the Validate a User endpoint
	 * @param OTPToken The MFA token that was sent to the user via Email or SMS using the Validate a User endpoint
	 *
	 * @return boolean
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/smart-mfa/verify-token">Verify MFA Token documentation</a>
	 */
	public boolean verifyToken(String stateToken, String OTPToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
			int versionId = settings.getVersionId("SMART_MFA_VERFY_TOKEN");
			URIBuilder url = new URIBuilder(settings.getURL(Constants.SMART_MFA_VERFY_TOKEN, versionId));

			Map<String, Object> data = new HashMap<String, Object>();
			data.put("state_token", stateToken);
			data.put("otp_token", OTPToken);

			String body = null;
			if (!data.isEmpty()) {
				body = JSONUtils.buildJSON(data);
			}

			OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuth2JSONResourceResponse.class, body);
			if (oAuth2Response.getResponseCode() == 200) {
				return true;
			} else {
				setResponseError(oAuth2Response, true);
				return false;
			}
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/multi-factor-authentication/available-factors">Get Available Authentication Factors documentation</a>
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/multi-factor-authentication/available-factors">Get Available Authentication Factors documentation</a> 
     */
    public List<AuthFactor> getFactors(long userId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
		int versionId = settings.getVersionId("GET_FACTORS_URL");
		URIBuilder url = null;
		String index = null;
		if (versionId == 1) {
			url = new URIBuilder(settings.getURL(Constants.GET_FACTORS_URL, userId, versionId));
			index = "auth_factors";
		} else {
			url = new URIBuilder(settings.getURL(Constants.V2_GET_FACTORS_URL, userId, versionId));
		}

		@SuppressWarnings("unchecked")
		List<AuthFactor> authFactors = (List<AuthFactor>) retrieveResourceList(AuthFactor.class, url, null, index, versionId);
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
     *            The phone number of the user in E.164 format.   (V1 only)
     * @param verified
     *            Default false. Pre-verified and can be immediately activated.
                                 (OL Voice requires verified = true)
     * @param expiresIn  Only applies to SMS factor (V2 only)
     *
     * @param customMessage
     *            The phone number of the user in E.164 format.   (V1 only)
     *
     *
     * @return OTPDevice The MFA device
     *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/multi-factor-authentication/enroll-factor">Enroll an Authentication Factor documentation</a>
     * @see <a target="_blank" https://developers.onelogin.com/api-docs/2/multi-factor-authentication/enroll-factor">Enroll an Authentication Factor documentation</a>
     */
    public OTPDevice enrollFactor(long userId, long factorId, String displayName, String number, Boolean verified, Integer expiresIn, String customMessage) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
		int versionId = settings.getVersionId("ENROLL_FACTOR_URL");
		URIBuilder url;
		if (versionId == 1) {
			url = new URIBuilder(settings.getURL(Constants.ENROLL_FACTOR_URL, userId, versionId));
		} else {
			url = new URIBuilder(settings.getURL(Constants.V2_ENROLL_FACTOR_URL, userId, versionId));
		}

		if (versionId == 1) {
			if (customMessage != null) {
				error = "422";
				errorDescription = "V1 does not support customMessage param";
				return null;
			}
			if (expiresIn != null) {
				error = "422";
				errorDescription = "V1 does not support expiresIn param";
				return null;
			}
		} else {
			if (number != null) {
				error = "422";
				errorDescription = "V2 does not support number param";
				return null;
			}
		}

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("factor_id", factorId);
		params.put("display_name", displayName);
		params.put("number", number);
		params.put("verified", verified);
		params.put("expires_in", expiresIn);
		params.put("custom_message", customMessage);

		return (OTPDevice) createResource(OTPDevice.class, params, url, versionId);
    }

    public OTPDevice enrollFactor(long userId, long factorId, String displayName, String number, Boolean verified) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
    	return enrollFactor(userId, factorId, displayName, number, verified, null, null);
    }

    public OTPDevice enrollFactor(long userId, long factorId, String displayName, String number) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
    	  return enrollFactor(userId, factorId, displayName, number, false);
    }

    public OTPDevice enrollFactor(long userId, long factorId, String displayName, Boolean verified, Integer expiresIn, String customMessage) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
    	return enrollFactor(userId, factorId, displayName, null, verified, expiresIn, customMessage);    	
    }

    /**
     * Verify enrollment for OneLogin SMS, OneLogin Email, OneLogin Protect and Authenticator authentication factors.
     *
     * @param userId
     *            The id of the user.
     * @param registrationId
     *            uuid of the registration process (enroll factor)
     * @param otp
     *            One-Time-Password
     *
     * @return MFACheckStatus Enrollment status
     *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/multi-factor-authentication/enroll-factor-verify-otp">Verify Enrollment of Authentication Factors documentation</a>
     */
    public MFACheckStatus verifyEnrollFactorOtp(long userId, String registrationId, String otp) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
	    int versionId = settings.getVersionId("VERIFY_ENROLLMENT_SMS_EMAIL_PROTECT_AUTH_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.VERIFY_ENROLLMENT_SMS_EMAIL_PROTECT_AUTH_URL, userId, registrationId, versionId));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("otp", otp);

		return (MFACheckStatus) updateResource(MFACheckStatus.class, params, url, versionId);
	}

    /**
     * Verify enrollment for OneLogin Voice & Protect Push authentication factors.
     *
     * @param userId
     *            The id of the user.
     * @param registrationId
     *            uuid of the registration process (enroll factor)
     *
     * @return MFACheckStatus Enrollment status
     *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/multi-factor-authentication/enroll-factor-verify-poll">Verify Enrollment of OneLogin Voice & Protect documentation</a>
     */
    public MFACheckStatus verifyEnrollFactorPoll(long userId, String registrationId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
	    int versionId = settings.getVersionId("VERIFY_ENROLLMENT__PROTECTPUSH_VOICE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.VERIFY_ENROLLMENT__PROTECTPUSH_VOICE_URL, userId, registrationId, versionId));

		return (MFACheckStatus)getResource(MFACheckStatus.class, url, versionId);
	}

    /**
     * Return a list of authentication factors registered to a particular user
     * for multifactor authentication (MFA)
     *
     * @param userId
     *            The id of the user.
     *
     * @return Array OTPDevice list
     *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/multi-factor-authentication/enrolled-factors">Get Enrolled Authentication Factors documentation</a>
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/multi-factor-authentication/enrolled-factors">Get Enrolled Authentication Factors documentation</a>
     */
    public List<OTPDevice> getEnrolledFactors(long userId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
		int versionId = settings.getVersionId("GET_ENROLLED_FACTORS_URL");
		URIBuilder url;
		String index = null;
		if (versionId == 1) {
			url = new URIBuilder(settings.getURL(Constants.GET_ENROLLED_FACTORS_URL, userId, versionId));
			index = "otp_devices";
		} else {
			url = new URIBuilder(settings.getURL(Constants.V2_GET_ENROLLED_FACTORS_URL, userId, versionId));
		}

		@SuppressWarnings("unchecked")
		List<OTPDevice> otp_devices = (List<OTPDevice>) retrieveResourceList(OTPDevice.class, url, null, index, versionId);
		return otp_devices;
    }

    /**
     * Triggers an SMS or Push notification containing a One-Time Password (OTP)
     * that can be used to authenticate a user with the Verify Factor call.
     *
     * @param userId
     *            The id of the user.
     * @param deviceId
     *            the id of the MFA device.
     * @param expiresIn
     *            Sets the window of time in seconds that the factor must be verified within. Default 120. Valid range 120-900  (V2 Only).
     * @param customMessage
     *            Only applies to SMS factor (V2 only)
     *
     * @return FactorEnrollmentResponse Info with User Id, Device Id, and OTP Device
     *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/multi-factor-authentication/activate-factor">Activate an Authentication Factor documentation</a>
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/multi-factor-authentication/activate-factor">Activate an Authentication Factor documentation</a>
     */
    public FactorEnrollmentResponse activateFactor(long userId, String deviceId, Integer expiresIn, String customMessage) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
		int versionId = settings.getVersionId("ACTIVATE_FACTOR_URL");
		URIBuilder url;
		Map<String, Object> params = new HashMap<String, Object>();
		if (versionId == 1) {
			url = new URIBuilder(settings.getURL(Constants.ACTIVATE_FACTOR_URL, userId, deviceId, versionId));
		} else {
			url = new URIBuilder(settings.getURL(Constants.V2_ACTIVATE_FACTOR_URL, userId, versionId));

			params.put("device_id", deviceId);
			if (expiresIn == null) {
				expiresIn = 120;
			}
			params.put("expires_in", expiresIn);
			params.put("custom_message", customMessage);
		}

		return (FactorEnrollmentResponse) createResource(FactorEnrollmentResponse.class, params, url, versionId);
    }

    public FactorEnrollmentResponse activateFactor(long userId, long deviceId, Integer expiresIn, String customMessage) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
    	return activateFactor(userId, Long.toString(deviceId), expiresIn, customMessage);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/multi-factor-authentication/activate-factor">Activate an Authentication Factor documentation</a>
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/multi-factor-authentication/activate-factor">Activate an Authentication Factor documentation</a>
     */
    public FactorEnrollmentResponse activateFactor(long userId, String deviceId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
    	return activateFactor(userId, deviceId, null, null);
    }

    public FactorEnrollmentResponse activateFactor(long userId, long deviceId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
    	return activateFactor(userId, Long.toString(deviceId), null, null);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/multi-factor-authentication/verify-factor">Verify an Authentication Factor documentation</a>
     */
    public Boolean verifyFactor(long userId, String deviceId, String otpToken, String stateToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
		int versionId = settings.getVersionId("VERIFY_FACTOR_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.VERIFY_FACTOR_URL, userId, deviceId, versionId));

		HashMap<String, Object> params = new HashMap<String, Object>();
		if (otpToken!= null && !otpToken.isEmpty()) {
			params.put("otp_token", otpToken);
		}
		if (stateToken!= null && !stateToken.isEmpty()) {
			params.put("state_token", stateToken);
		}

		return createOperation(params, url, versionId);
    }

    public Boolean verifyFactor(long userId, long deviceId, String otpToken, String stateToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
    	return verifyFactor(userId, Long.toString(deviceId), otpToken, stateToken);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/multi-factor-authentication/verify-factor">Verify an Authentication Factor documentation</a>
     */
    public Boolean verifyFactor(long userId, String deviceId, String otpToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
    	return verifyFactor(userId, deviceId, otpToken, null);
    }

    public Boolean verifyFactor(long userId, long deviceId, String otpToken) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/multi-factor-authentication/verify-factor">Verify an Authentication Factor documentation</a>
     */
    public Boolean verifyFactor(long userId, String deviceId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
    	return verifyFactor(userId, deviceId, null, null);
    }

    public Boolean verifyFactor(long userId, long deviceId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
    	return verifyFactor(userId, deviceId, null, null);
    }

    /**
     * Verify an OTP code provided by SMS, Email, OneLogin Protect or Authenticator
     *
     * @param userId
     *            The id of the user.
     * @param verificationId
     *            uuid of the verification process (activate factor)
     * @param otp
     *            One-Time-Password
     * @param deviceId
     *            The device_id of the enrolled factors (No required on OL SMS and OL Email)
     *
     * @return Boolean True if Factor is verified
     *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/multi-factor-authentication/verify-factor">Verify an Authentication Factor documentation</a>
     */
    public Boolean verifyFactorOtp(long userId, String verificationId, String otp, String deviceId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
		int versionId = settings.getVersionId("VERIFY_FACTOR_SMS_EMAIL_PROTECT_AUTH_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.VERIFY_FACTOR_SMS_EMAIL_PROTECT_AUTH_URL, userId, verificationId, versionId));

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("otp", otp);
		params.put("device_id", deviceId);
		
		return updateOperation(params, url, versionId);
    }
    
    public Boolean verifyFactorOtp(long userId, String verificationId, String otp, long deviceId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
    	return verifyFactorOtp(userId, verificationId, otp, Long.toString(deviceId));
    }

    /**
     * Verify completion of OneLogin Push or OneLogin Voice factors.
     *
     * @param userId
     *            The id of the user.
     * @param verificationId
     *            uuid of the verification process (activate factor)
     *
     * @return MFACheckStatus Enrollment status
     *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
     * @see <a target="_blank" https://developers.onelogin.com/api-docs/2/multi-factor-authentication/verify-factor-poll">Verify an Authentication Factor documentation</a>
     */
    public MFACheckStatus verifyFactorPoll(long userId, String verificationId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
		int versionId = settings.getVersionId("VERIFY_FACTOR_PROTECTPUSH_VOICE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.VERIFY_FACTOR_PROTECTPUSH_VOICE_URL, userId, verificationId, versionId));

		return (MFACheckStatus)getResource(MFACheckStatus.class, url, versionId);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/multi-factor-authentication/remove-factor">Remove a Factor documentation</a>
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/multi-factor-authentication/remove-factor">Remove a Factor documentation</a>
     */
    public Boolean removeFactor(long userId, String deviceId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
		int versionId = settings.getVersionId("DELETE_FACTOR_URL");
		URIBuilder url;
		if (versionId == 1) {
			url = new URIBuilder(settings.getURL(Constants.DELETE_FACTOR_URL, userId, deviceId, versionId));
		} else {
			url = new URIBuilder(settings.getURL(Constants.V2_DELETE_FACTOR_URL, userId, deviceId, versionId));
		}

		return deleteResource(url, versionId);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/multi-factor-authentication/remove-factor">Remove a Factor documentation</a>
     * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/multi-factor-authentication/remove-factor">Remove a Factor documentation</a>
     */
    public Boolean removeFactor(long userId, long deviceId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization
    {
    	return removeFactor(userId, Long.toString(deviceId));
    }

    /**
	 * Generates an access token for a user
	 *
	 * @param userId
	 *            Id of the user
	 * @param expiresIn
	 *            Set the duration of the token in seconds. (default: 259200 seconds = 72h)
	 *            72 hours is the max value.
	 * @param reusable
	 *            Defines if the token reusable. (default: false) If set to true, token can be used for multiple apps, until it expires.
	 *
	 * @return Created MFAToken
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/multi-factor-authentication/generate-mfa-token">Generate MFA Token documentation</a>
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/multi-factor-authentication/generate-mfa-token">Generate MFA Token documentation</a>
	 */
	public MFAToken generateMFAToken(long userId, Integer expiresIn, Boolean reusable) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GENERATE_MFA_TOKEN_URL");
		URIBuilder url = null;
		if (versionId == 1) {
			url = new URIBuilder(settings.getURL(Constants.GENERATE_MFA_TOKEN_URL, Long.toString(userId), versionId));
		} else {
			url = new URIBuilder(settings.getURL(Constants.V2_GENERATE_MFA_TOKEN_URL, Long.toString(userId), versionId));
		}

		Map<String, Object> mfaParams = new HashMap<String, Object>();
		if (expiresIn != null) {
			if (expiresIn < 120 || expiresIn > 259200) {
				error = "422";
				errorDescription = "expiresIn needs to be an integer between 120 and 259200";
				errorAttribute = "expiresIn";
				return null;
			}
			mfaParams.put("expires_in", expiresIn);
		}
		if (reusable != null) {
			mfaParams.put("reusable", reusable);
		}

		// It has version 2 result
		return (MFAToken) createResource(MFAToken.class, mfaParams, url, 2);
	}

	/**
	 * Generates an access token for a user
	 *
	 * @param userId
	 *            Id of the user
	 * @param expiresIn
	 *            Set the duration of the token in seconds. (default: 259200 seconds = 72h)
	 *            72 hours is the max value.
	 *
	 * @return Created MFAToken
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
     * @throws ErrorResourceInitialization
     *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/multi-factor-authentication/generate-mfa-token">Generate MFA Token documentation</a>
	 */
	public MFAToken generateMFAToken(long userId,Integer expiresIn) throws OAuthSystemException, OAuthProblemException, URISyntaxException , ErrorResourceInitialization{
		return generateMFAToken(userId, expiresIn, false);
	}

	/**
	 * Generates an access token for a user
	 *
	 * @param userId
	 *            Id of the user
	 *
	 * @return Created MFAToken
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/multi-factor-authentication/generate-mfa-token">Generate MFA Token documentation</a>
	 */
	public MFAToken generateMFAToken(long userId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		return generateMFAToken(userId, 259200, false);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/invite-links/generate-invite-link">Generate Invite Link documentation</a>
	 */
	public String generateInviteLink(String email) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		int versionId = settings.getVersionId("GENERATE_INVITE_LINK_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GENERATE_INVITE_LINK_URL, versionId));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		String body = JSONUtils.buildJSON(params);

		OneloginOAuthJSONResourceResponse oAuthResponse = (OneloginOAuthJSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class, body);

		String urlLink = null;
		if (oAuthResponse.getResponseCode() == 200) {
			if (oAuthResponse.getType().equals("success")) {
				if (oAuthResponse.getMessage().equals("Success")) {
					Object[] objArray = oAuthResponse.getArrayFromData();
					urlLink = (String)objArray[0];
				}
			}
		} else {
			setResponseError(oAuthResponse, false);
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
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/invite-links/send-invite-link">Send Invite Link documentation</a>
	 */
	public Boolean sendInviteLink(String email, String personalEmail) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("SEND_INVITE_LINK_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.SEND_INVITE_LINK_URL, versionId));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		if (personalEmail != null) {
			params.put("personal_email", personalEmail);
		}

		return createOperation(params, url, versionId);
	}

	/**
	 * Send an invite link to a user that you have already created in your OneLogin account.
	 *
	 * @param email
	 *            Set to the email address of the user that you want to send an invite link for.
	 *
	 * @return True if the mail with the link was sent
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/invite-links/send-invite-link">Send Invite Link documentation</a>
	 */
	public Boolean sendInviteLink(String email) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
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
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws IOException - if DocumentBuilder, CloseableHttpClient or EntityUtils raises the exception
	 * @throws ClientProtocolException - if CloseableHttpClient raises the exception
	 * @throws ParserConfigurationException - if a DocumentBuilder cannot be created which satisfies the configuration requested.
	 * @throws SAXException - If any parse errors occur when calling parse method of DocumentBuilder
	 * @throws XPathExpressionException - If XPathExpression cannot be evaluated.
	 *
	 * @see com.onelogin.sdk.model.EmbedApp
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

	////////////////////
	//  Privilege Methods  //
	////////////////////

    /**
	 * Gets a list of the Privileges created in an account.
	 *
	 * @return List of Privilege
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResource call
     * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Privileges
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/list-privileges">Get Privileges documentation</a>
	 */
	public List<Privilege> getPrivileges() throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("LIST_PRIVILEGES_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.LIST_PRIVILEGES_URL, versionId));

		// It has version 2 result
		@SuppressWarnings("unchecked")
		List<Privilege> privileges = (List<Privilege>) retrieveResourceList(Privilege.class, url, null, 2);
		return privileges;
	}

	/**
	 * Creates a Privilege
	 *
	 * @param name
	 *            The name of this privilege.
	 * @param version
	 *            The version for the privilege schema. Set to 2018-05-18.
	 * @param statements
	 *            A list of Statement objects or HashMap<String, Object>
	 *
	 * @return Created Privilege
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/create-privilege">Create Privilege documentation</a>
	 */
	public Privilege createPrivilege(String name, String version, List<?> statements) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		int versionId = settings.getVersionId("CREATE_PRIVILEGE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.CREATE_PRIVILEGE_URL, versionId));

		List<HashMap<String, Object>> statementData = new ArrayList<HashMap<String, Object>>();
		if (!statements.isEmpty()) {
			if (statements.get(0) instanceof Statement) {
				@SuppressWarnings("unchecked")
				List<Statement> data = (List<Statement>) statements;
				HashMap<String, Object> dataObj;
				for (Statement statement: data) {
					dataObj = new HashMap<String, Object>();
					dataObj.put("Effect", statement.effect);
					dataObj.put("Action", statement.actions);
					dataObj.put("Scope", statement.scopes);
					statementData.add(dataObj);
				}
			} else if (statements.get(0) instanceof HashMap) {
				@SuppressWarnings("unchecked")
				List<HashMap<String, Object>> data = (List<HashMap<String, Object>>) statements;
				for (HashMap<String, Object> statement: data) {
					statementData.add(statement);
				}
			}
		}

		Map<String, Object> privilegeData = new HashMap<String, Object>();
		privilegeData.put("Version", version);
		privilegeData.put("Statement", statementData);

		Map<String, Object> privilegeParams = new HashMap<String, Object>();
		privilegeParams.put("name", name);
		privilegeParams.put("privilege", privilegeData);

		String body = null;
		if (!privilegeParams.isEmpty()) {
			body = JSONUtils.buildJSON(privilegeParams);
		}
		
		Privilege privilege = null;
		OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuth2JSONResourceResponse.class, body);
		if (oAuth2Response.getResponseCode() == 201) {
			String id = (String) oAuth2Response.getFromContent("id");
			if (id != null &&  !id.isEmpty()) {
				privilege = new Privilege(id, name, version, statements);
			}
		} else {
			setResponseError(oAuth2Response, false);
		}
		
		return privilege;
	}

	/**
	 * Get a Privilege
	 *
	 * @param id
	 *            The id of the privilege you want to update.
	 *
	 * @return Privilege
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Privilege
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/get-privilege">Get Privilege documentation</a>
	 */
	public Privilege getPrivilege(String id) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_PRIVILEGE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_PRIVILEGE_URL, id, versionId));

		// It has version 2 result
		return (Privilege) getResource(Privilege.class, url, 2);
	}

	/**
	 * Updates a Privilege
	 *
	 * @param id
	 *            The id of the privilege to be updated.
	 * @param name
	 *            The name of this privilege.
	 * @param version
	 *            The version for the privilege schema. Set to 2018-05-18.
	 * @param statements
	 *            A list of Statement objects or HashMap<String, Object>
	 *
	 * @return Privilege
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 *
	 * @see com.onelogin.sdk.model.Privilege
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/update-privilege">Update Privilege documentation</a>
	 */
	public Privilege updatePrivilege(String id, String name, String version, List<?> statements) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		int versionId = settings.getVersionId("UPDATE_PRIVILEGE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.UPDATE_PRIVILEGE_URL, id, versionId));

		List<HashMap<String, Object>> statementData = new ArrayList<HashMap<String, Object>>();
		if (!statements.isEmpty()) {
			if (statements.get(0) instanceof Statement) {
				@SuppressWarnings("unchecked")
				List<Statement> data = (List<Statement>) statements;
				HashMap<String, Object> dataObj;
				for (Statement statement: data) {
					dataObj = new HashMap<String, Object>();
					dataObj.put("Effect", statement.effect);
					dataObj.put("Action", statement.actions);
					dataObj.put("Scope", statement.scopes);
					statementData.add(dataObj);
				}
			} else if (statements.get(0) instanceof HashMap) {
				@SuppressWarnings("unchecked")
				List<HashMap<String, Object>> data = (List<HashMap<String, Object>>) statements;
				for (HashMap<String, Object> statement: data) {
					statementData.add(statement);
				}
			}
		}

		Map<String, Object> privilegeData = new HashMap<String, Object>();
		privilegeData.put("Version", version);
		privilegeData.put("Statement", statementData);

		Map<String, Object> privilegeParams = new HashMap<String, Object>();
		privilegeParams.put("name", name);
		privilegeParams.put("privilege", privilegeData);

		String body = null;
		if (!privilegeParams.isEmpty()) {
			body = JSONUtils.buildJSON(privilegeParams);
		}

		Privilege privilege = null;
		OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.PUT, OneloginOAuth2JSONResourceResponse.class, body);
		if (oAuth2Response.getResponseCode() == 200) {
			String privilegeId = (String) oAuth2Response.getFromContent("id");
			if (privilegeId != null &&  !privilegeId.isEmpty()) {
				privilege = new Privilege(privilegeId, name, version, statements);
			}
		} else {
			setResponseError(oAuth2Response, false);
		}

		return privilege;
	}

	/**
	 * Deletes a privilege
	 *
	 * @param id
	 *            Id of the privilege to be deleted
	 *
	 * @return true if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/delete-privilege">Delete Privilege documentation</a>
	 */
	public Boolean deletePrivilege(String id) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("DELETE_PRIVILEGE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.DELETE_PRIVILEGE_URL, id, versionId));

		// Version 2 result, no content
		return deleteResource(url, 2);
	}

    /**
	 * Gets a list of the role ids assigned to a privilege.
	 *
	 * @param id
	 *            Id of the privilege
	 * @param maxResults
	 *            Limit the number of roles returned
	 *
	 * @return List of role Ids
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResource call
     * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/get-roles">Get Assigned Roles documentation</a>
	 */
	public List<Long> getRolesAssignedToPrivileges(String id, int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_ROLES_ASSIGNED_TO_PRIVILEGE_URL");
		ExtractionContext context = getResourceContext(Constants.GET_ROLES_ASSIGNED_TO_PRIVILEGE_URL, id, versionId);

		// Version 2 result
		return iterateIdsCollector(context, maxResults, 2, "roles");
	}

    /**
	 * Gets a list of the role ids assigned to a privilege.
	 *
	 * @param id
	 *            Id of the privilege
	 *
	 * @return List of role Ids
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResource call
     * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/get-roles">Get Assigned Roles documentation</a>
	 */
	public List<Long> getRolesAssignedToPrivileges(String id) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int maxResults = this.maxResults > 1000? this.maxResults : 1000;

		return getRolesAssignedToPrivileges(id, maxResults);
	}

	/**
	 * Get a batch of roles assigned to privilege.
	 * 
	 * This is usually the first version of the roles assigned to privilege batching methods to call as it requires no after-cursor information.
     *
	 * @param id Id of the privilege
	 * @param batchSize Size of the Batch
	 *
	 * @return OneLoginResponse of Long (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResource call
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/get-roles">Get Assigned Roles documentation</a>
	 */
	public OneLoginResponse<Long> getRolesAssignedToPrivilegesBatch(String id, int batchSize) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getRolesAssignedToPrivilegesBatch(id, batchSize, null);
	}

	/**
	 * Get a batch of roles assigned to privilege.
	 * 
	 * @param id Id of the privilege
	 * @param batchSize Size of the Batch
	 * @param afterCursor Reference to continue collecting items of next page
	 *
	 * @return OneLoginResponse of User (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResource call
	 * 
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/get-roles">Get Assigned Roles documentation</a>
	 */
	public OneLoginResponse<Long> getRolesAssignedToPrivilegesBatch(String id, int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		int versionId = settings.getVersionId("GET_ROLES_ASSIGNED_TO_PRIVILEGE_URL");
		ExtractionContext context = extractResourceBatch((Object)id, batchSize, afterCursor, Constants.GET_ROLES_ASSIGNED_TO_PRIVILEGE_URL, 2);
		List<Long> roleIds = new ArrayList<Long>(batchSize);
		afterCursor = getRolesAssignedToPrivilegesBatch(roleIds, context.url, context.bearerRequest, context.oAuth2Response);
		return new OneLoginResponse<Long>(roleIds, afterCursor);
	}

	/**
	 * Get a batch of roles assigned to privilege.
	 * 
	 * @param roleIds
	 * @param url
	 * @param bearerRequest
	 * @param oAuth2Response
	 *
	 * @return The Batch reference
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 */
	private String getRolesAssignedToPrivilegesBatch(List<Long> roleIds, URIBuilder url, OAuthClientRequest bearerRequest,
			OneloginOAuth2JSONResourceResponse oAuth2Response) {
		if (oAuth2Response.getResponseCode() == 200) {
			JSONArray dataArray = (JSONArray)oAuth2Response.getFromContent("roles");
			for (int i = 0; i < dataArray.length(); i++) {
				roleIds.add(dataArray.optLong(i));
			}
			return collectAfterCursor(url, bearerRequest, oAuth2Response);
		} else {
			setResponseError(oAuth2Response, false);
		}
		return null;
	}

	/**
	 * Assign one or more roles to a privilege.
	 *
	 * @param id
	 *            Id of the privilege
	 * @param roleIds
	 *            The ids of the roles to be assigned.
	 *
	 * @return true if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/assign-role">Assign Roles documentation</a>
	 */
	public Boolean assignRolesToPrivilege(String id, List<Long> roleIds) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("ASSIGN_ROLES_TO_PRIVILEGE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.ASSIGN_ROLES_TO_PRIVILEGE_URL, id, versionId));
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roles", roleIds);

		// Version 2 result
		return createOperation(params, url, 2);
	}

	/**
	 * Removes one role from the privilege.
	 *
	 * @param id
	 *            Id of the privilege
	 * @param roleId
	 *            The id of the role to be removed.
	 *
	 * @return true if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/remove-role">Remove Role documentation</a>
	 */
	public Boolean removeRoleFromPrivilege(String id, Long roleId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		cleanError();
		int versionId = settings.getVersionId("REMOVE_ROLE_FROM_PRIVILEGE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.REMOVE_ROLE_FROM_PRIVILEGE_URL, id, roleId.toString(), versionId));

		// Version 2 result, no content
		return deleteResource(url, 2);
	}

    /**
	 * Gets a list of the user Ids assigned to a privilege.
	 *
	 * @param id
	 *            Id of the privilege
	 * @param maxResults
	 *            Limit the number of users returned
	 *
	 * @return List of user Ids
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResource call
     * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/get-users">Get Assigned Users documentation</a>
	 */
	public List<Long> getUsersAssignedToPrivileges(String id, int maxResults) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_USERS_ASSIGNED_TO_PRIVILEGE_URL");
		ExtractionContext context = getResourceContext(Constants.GET_USERS_ASSIGNED_TO_PRIVILEGE_URL, id, versionId);

		// Version 2 result
		return iterateIdsCollector(context, maxResults, 2, "users");
	}

    /**
	 * Gets a list of the user Ids assigned to a privilege.
	 *
	 * @param id
	 *            Id of the privilege
	 *
	 * @return List of user Ids
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResource call
     * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/get-users">Get Assigned Users documentation</a>
	 */
	public List<Long> getUsersAssignedToPrivileges(String id) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int maxResults = this.maxResults > 1000? this.maxResults : 1000;

		return getUsersAssignedToPrivileges(id, maxResults);
	}

	/**
	 * Get a batch of users assigned to privilege.
	 * 
	 * This is usually the first version of the users assigned to privilege batching methods to call as it requires no after-cursor information.
     *
	 * @param id Id of the privilege
	 * @param batchSize Size of the Batch
	 *
	 * @return OneLoginResponse of Long (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResource call
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/get-users">Get Assigned Users documentation</a>
	 */
	public OneLoginResponse<Long> getUsersAssignedToPrivilegesBatch(String id, int batchSize) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		return getUsersAssignedToPrivilegesBatch(id, batchSize, null);
	}

	/**
	 * Get a batch of users assigned to privilege.
	 * 
	 * @param id Id of the privilege
	 * @param batchSize Size of the Batch
	 * @param afterCursor Reference to continue collecting items of next page
	 *
	 * @return OneLoginResponse of User (Batch)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the getResource call
	 * 
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/get-users">Get Assigned Users documentation</a>
	 */
	public OneLoginResponse<Long> getUsersAssignedToPrivilegesBatch(String id, int batchSize, String afterCursor)
			throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		int versionId = settings.getVersionId("GET_USERS_ASSIGNED_TO_PRIVILEGE_URL");
		ExtractionContext context = extractResourceBatch((Object)id, batchSize, afterCursor, Constants.GET_USERS_ASSIGNED_TO_PRIVILEGE_URL, 2);
		List<Long> userIds = new ArrayList<Long>(batchSize);
		afterCursor = getUsersAssignedToPrivilegesBatch(userIds, context.url, context.bearerRequest, context.oAuth2Response);
		return new OneLoginResponse<Long>(userIds, afterCursor);
	}

	/**
	 * Get a batch of users assigned to privilege.
	 * 
	 * @param userIds
	 * @param url
	 * @param bearerRequest
	 * @param oAuth2Response
	 *
	 * @return The Batch reference
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/users/get-users">Get Users documentation</a>
	 */
	private String getUsersAssignedToPrivilegesBatch(List<Long> userIds, URIBuilder url, OAuthClientRequest bearerRequest,
			OneloginOAuth2JSONResourceResponse oAuth2Response) {
		if (oAuth2Response.getResponseCode() == 200) {
			JSONArray dataArray = (JSONArray)oAuth2Response.getFromContent("users");
			for (int i = 0; i < dataArray.length(); i++) {
				userIds.add(dataArray.optLong(i));
			}
			return collectAfterCursor(url, bearerRequest, oAuth2Response);
		} else {
			setResponseError(oAuth2Response, false);
		}
		return null;
	}

	/**
	 * Assign one or more users to a privilege.
	 *
	 * @param id
	 *            Id of the privilege
	 * @param userIds
	 *            The ids of the users to be assigned.
	 *
	 * @return true if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization 
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/assign-users">Assign Users documentation</a>
	 */
	public Boolean assignUsersToPrivilege(String id, List<Long> userIds) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("ASSIGN_USERS_TO_PRIVILEGE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.ASSIGN_USERS_TO_PRIVILEGE_URL, id, versionId));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("users", userIds);

		// Version 2 result
		return createOperation(params, url, 2);
	}

	/**
	 * Removes one user from the privilege.
	 *
	 * @param id
	 *            Id of the privilege
	 * @param userId
	 *            The id of the user to be removed.
	 *
	 * @return true if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/1/privileges/remove-user">Remove User documentation</a>
	 */
	public Boolean removeUserFromPrivilege(String id, Long userId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("REMOVE_USER_FROM_PRIVILEGE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.REMOVE_USER_FROM_PRIVILEGE_URL, id, userId.toString(), versionId));

		// Version 2 result, no content
		return deleteResource(url, 2);
	}

	////////////////////////////
	// User Mappings Methods  //
	////////////////////////////

	/**
	 * Gets a list of Mapping resources.
	 *
	 * @param queryParameters Query parameters of the Resource
	 *            			  Parameters to filter the result of the list
	 *
	 * @return List<Mapping>
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Mapping
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/user-mappings/list-mappings">List Mappings documentation</a>
	 */
	public List<Mapping> getMappings(HashMap<String, String> queryParameters) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_MAPPINGS_URL");

		ExtractionContext context = getResourceContext(queryParameters, Constants.GET_MAPPINGS_URL, versionId);

		@SuppressWarnings("unchecked")
		List<Mapping> mappings = (List<Mapping>)iterateResourceCollector(Mapping.class, context, this.maxResults, versionId);
		return mappings;
	}

	/**
	 * Creates Mapping
     *
	 * @param mappingParams Mapping data (name, enabled, match, position
     *                                    conditions[source, operator, value],
     *                                    actions[action, value])
	 *
	 * @return Mapping 
	 * 
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Mapping
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/user-mappings/create-mapping">Create Mapping documentation</a>
	 */
	 public Mapping createMapping(Map<String, Object> mappingParams) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
			int versionId = settings.getVersionId("CREATE_MAPPING_URL");
			URIBuilder url = new URIBuilder(settings.getURL(Constants.CREATE_MAPPING_URL, versionId));

			return (Mapping) createResource(Mapping.class, mappingParams, url, versionId);
	 } 

	/**
	 * Gets Mapping by ID.
	 *
	 * @param id
	 *            Id of the mapping
	 *
	 * @return Mapping
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Mapping
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/user-mappings/get-mapping">Get Mapping documentation</a>
	 */
	public Mapping getMapping(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_MAPPING_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_MAPPING_URL, Long.toString(id), versionId));

		return (Mapping)getResource(Mapping.class, url, versionId);
	}

	/**
	 * Updates Mapping
	 *
	 * @param id
	 *            Id of the mapping to be modified
	 * @param mappingParams Mapping data (name, enabled, match, position
     *                                    conditions[source, operator, value],
     *                                    actions[action, value])
	 *
	 * @return Updated Mapping
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see com.onelogin.sdk.model.Mapping
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/user-mappings/update-mapping">Update Mapping documentation</a>
	 */
	public Mapping updateMapping(long id, Map<String, Object> mappingParams) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("UPDATE_MAPPING_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.UPDATE_MAPPING_URL, Long.toString(id), versionId));

		return (Mapping) updateResource(Mapping.class, mappingParams, url, versionId);
	}

	/**
	 * Deletes mapping
	 *
	 * @param id
	 *            Id of the mapping to be deleted
	 *
	 * @return true if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/user-mappings/delete-mapping">Delete Mapping documentation</a>
	 */
	public Boolean deleteMapping(long id) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("DELETE_MAPPING_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.DELETE_MAPPING_URL, Long.toString(id), versionId));

		return deleteResource(url, versionId);
	}

	/**
	 * Performs a User Mappings dry run
	 *
	 * @param mappingId
	 *            Id of the mapping to be processed
	 * @param userIds
	 *            List of user IDs tested against the mapping conditions to verify that the mapping would be applied
	 *
	 * @return true if success
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/user-mappings/dry-run-mapping">Dry Run Mapping documentation</a>
	 */
	public List<HashMap<String, Object>> dryRunMapping(long mappingId, List<Long> userIds) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("DRYRUN_MAPPING_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.DRYRUN_MAPPING_URL, Long.toString(mappingId), versionId));

		String body = null;
		if (userIds != null && !userIds.isEmpty()) {
			body = userIds.toString();
		}

		OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuth2JSONResourceResponse.class, body);

		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> resultData ;
		if (oAuth2Response.getResponseCode() == 200) {
			JSONArray jsonArray = oAuth2Response.getJSONArrayFromContent();
			JSONObject info;
			for(int i = 0; i < jsonArray.length (); i++) {
				info = jsonArray.getJSONObject(i);
				resultData = new HashMap<String, Object>();
				resultData.put("user", new User(info.getJSONObject("user")));
				resultData.put("mapped", info.getBoolean("mapped"));
				result.add(resultData);
			}
		} else {
			setResponseError(oAuth2Response, false);
		}
		return result;
	}

	/**
	 * Gets a list of Mapping Conditions types that can be used to match users when mappings are run.
	 *
	 * @return List<HashMap<String,String>>
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/user-mappings/list-conditions">List Conditions documentation</a>
	 */
	public List<HashMap<String, String>> getMappingConditions() throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_MAPPING_CONDITIONS_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_MAPPING_CONDITIONS_URL, versionId));

		return retrieveListNameValue(url, versionId);
	}

	/**
	 * Gets a list of possible operators for a given condition value.
     *
	 * @param conditionValue
	 *            The name of the condition (A Mapping Condition)
	 *
	 * @return List<HashMap<String,String>>
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/user-mappings/list-condition-operator">List Conditions Operators documentation</a>
	 */
	public List<HashMap<String, String>> getMappingConditionOperators(String conditionValue) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_MAPPING_CONDITION_OPERATORS_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_MAPPING_CONDITION_OPERATORS_URL, conditionValue, versionId));

		return retrieveListNameValue(url, versionId);
	}

	/**
	 * Gets a list of possible values to compare to a condition type.
     *
	 * @param conditionValue
	 *            The name of the condition (A Mapping Condition)
	 *
	 * @return List<HashMap<String,String>>
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/user-mappings/list-condition-values">List Conditions Values documentation</a>
	 */
	public List<HashMap<String, String>> getMappingConditionValues(String conditionValue) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_MAPPING_CONDITION_VALUES_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_MAPPING_CONDITION_VALUES_URL, conditionValue, versionId));

		return retrieveListNameValue(url, versionId);
	}

	/**
	 * Gets a list of the actions that can be applied when a mapping runs.
	 *
	 * @return List<HashMap<String,String>>
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/user-mappings/list-actions">List Actions documentation</a>
	 */
	public List<HashMap<String, String>> getMappingActions() throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_MAPPING_ACTIONS_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_MAPPING_ACTIONS_URL, versionId));

		return retrieveListNameValue(url, versionId);
	}

	/**
	 * Update order of mappings
	 *
	 * @param mappingIds ordered list of Mapping IDs
	 *
	 * @return List<Long>
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/user-mappings/bulk-sort">Bulk Sort documentation</a>
	 */
	public List<Long> mappingSort(List<Long> mappingIds) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {

		int versionId = settings.getVersionId("MAPPING_SORT_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.MAPPING_SORT_URL, versionId));

		return setOperation(mappingIds, url, versionId);
	}

	/**
	 * Gets a list of possible values to set using a given action.
     *
	 * @param actionValue
	 *            The name of the action (A Mapping Action)
	 *
	 * @return List<HashMap<String,String>>
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/user-mappings/list-action-values">List Action Values documentation</a>
	 */
	public List<HashMap<String, String>> getMappingActionValues(String conditionValue) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_MAPPING_ACTION_VALUES_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_MAPPING_ACTION_VALUES_URL, conditionValue, versionId));

		return retrieveListNameValue(url, versionId);
	}

    ////////////////////////////
    //  Vigilance AI Methods  //
    ////////////////////////////

	/**
	 * Tracks an Event
	 *
	 * @param trackEventParams: Event data (verb, ip, user_agent, user[id, name, authenticated],
     *                            source[id,name], session[id], device[id], fp, published)
     *                       	  user id data needs to be in the format: {instance region}_{OneLogin User Id}
	 *
	 * @return boolean
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/vigilance/train">Track an Event documentation</a>
	 */
	public boolean trackEvent(Map<String, Object> trackEventParams) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {

		int versionId = settings.getVersionId("TRACK_EVENT_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.TRACK_EVENT_URL, versionId));

		return submitOperation(url, trackEventParams);
	}

	/**
	 * Gets a Risk Score
	 *
	 * @param trackEventParams Event data (ip, user_agent, user[id, name, authenticated],
     *                                     source[id,name], session[id], device[id], fp)
	 *
	 * @return RiskScore
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/vigilance/verify">Get a Risk Score documentation</a>
	 */
	public RiskScore getRiskScore(Map<String, Object> trackEventParams) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_RISK_SCORE_URL");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_RISK_SCORE_URL, versionId));

		return (RiskScore) createResource(RiskScore.class, trackEventParams, url, versionId);
	}

	/**
	 * Gets Score Insights
	 *
	 * @param before Optional ISO8601 formatted date string. Defaults to current date. Maximum date is 90 days ago.
	 * @param after Optional ISO8601 formatted date string. Defaults to 30 days ago. Maximum date is 90 days ago.
	 *
	 * @return RiskScore
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONResourceResponse and throwOAuthProblemException is enabled
	 * @throws URISyntaxException - if there is an error when generating the target URL at the URIBuilder constructor
	 * @throws ErrorResourceInitialization
	 *
	 * @see <a target="_blank" href="https://developers.onelogin.com/api-docs/2/vigilance/verify">Get a Risk Score documentation</a>
	 */
	public RiskScoreInsights getRiskScoreInsights(String before,String after) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		int versionId = settings.getVersionId("GET_SCORE_INSIGHTS");
		URIBuilder url = new URIBuilder(settings.getURL(Constants.GET_SCORE_INSIGHTS, versionId));

		if (before != null && !before.isEmpty()) {
			url.addParameter("before", before);
		}
		if (after != null && !after.isEmpty()) {
			url.addParameter("after", after);
		}

		return (RiskScoreInsights)getResource(RiskScoreInsights.class, url, versionId);
	}

	/////////////////////////
	//  Auxiliary methods  //
	/////////////////////////

	/**
	 * Prepare the client before execute a call to the API (get token ready)
	 *
	 * @throws OAuthSystemException - if there is a IOException reading parameters of the httpURLConnection
	 * @throws OAuthProblemException - if there are errors validating the OneloginOAuthJSONAccessTokenResponse and throwOAuthProblemException is enabled
	 *
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
			return "bearer " + accessToken;
		} else {
			return "client_id:" + settings.getClientId() + ", client_secret:" + settings.getClientSecret();
		}
	}

	protected String getAuthorization() {
		return getAuthorization(true);
	}

	public String getIP() {
		return settings.getIP();
	}

	//////////////////////////////////
	//  Auxiliary private methods   //   
	//////////////////////////////////

	private void updateTokens(OneloginURLConnectionClient httpClient, OAuthClientRequest request, Map<String, String> headers)
			throws OAuthSystemException, OAuthProblemException {
		OneloginOAuthJSONAccessTokenResponse oAuthResponse = (OneloginOAuthJSONAccessTokenResponse) httpClient.execute(request, headers,
				OAuth.HttpMethod.POST, OneloginOAuthJSONAccessTokenResponse.class);
		if (oAuthResponse.getResponseCode() == 200) {
			accessToken = oAuthResponse.getAccessToken();
			refreshToken = oAuthResponse.getRefreshToken();
			Long expiresIn = oAuthResponse.getExpiresIn();
			DateTime createdAt = oAuthResponse.getCreateAt();
			expiration = null;
			if (expiresIn != null && createdAt != null) {
				expiration = createdAt.plusSeconds(expiresIn.intValue());
			}
		} else {
			setResponseError(oAuthResponse);
		}
	}

	@SuppressWarnings("rawtypes")
	private List<? extends OneLoginResource> iterateResourceCollector(Class clazz, ExtractionContext context, int maxResults, int versionId) throws ErrorResourceInitialization, OAuthSystemException, OAuthProblemException {
		List<OneLoginResource> resourceList = new ArrayList<OneLoginResource>();
		String afterCursor = null;

		while ((context.oAuthResponse == null && context.oAuth2Response == null) || (resourceList.size() < maxResults && afterCursor != null)) {
			if (versionId == 1) {
				context.response(context.oAuthClient.resource(context.bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class));
			} else {
				context.response(context.oAuthClient.resource(context.bearerRequest, OAuth.HttpMethod.GET, OneloginOAuth2JSONResourceResponse.class));
			}

			afterCursor = getResourceListBatch(resourceList, clazz, context, versionId);
		}
		return resourceList;
	}

	private List<Long> iterateIdsCollector(ExtractionContext context, int maxResults, int versionId, String index) throws ErrorResourceInitialization, OAuthSystemException, OAuthProblemException {
		List<Long> resourceList = new ArrayList<Long>();
		String afterCursor = null;

		while ((context.oAuthResponse == null && context.oAuth2Response == null) || (resourceList.size() < maxResults && afterCursor != null)) {
			if (versionId == 1) {
				context.response(context.oAuthClient.resource(context.bearerRequest, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class));
			} else {
				context.response(context.oAuthClient.resource(context.bearerRequest, OAuth.HttpMethod.GET, OneloginOAuth2JSONResourceResponse.class));
			}

			afterCursor = getIdsListBatch(resourceList, context, versionId, index);
		}
		return resourceList;
	}
	
	
	@SuppressWarnings("rawtypes")
	private String getResourceListBatch(List<OneLoginResource> resourceList, Class clazz, ExtractionContext context, int versionId) throws ErrorResourceInitialization {
		Constructor<?> clazzConstructor = getClassConstructor(clazz);
		if (versionId == 1) {
			if (context.oAuthResponse.getResponseCode() == 200) {
				JSONObject[] dataArray = context.oAuthResponse.getDataArray();
				if (dataArray != null && dataArray.length > 0) {
					for (JSONObject data : dataArray) {
						resourceList.add(getOneLoginResource(clazzConstructor, data));
					}
				}

				return collectAfterCursor(context, versionId);
			} else {
				setResponseError(context.oAuthResponse, false);
			}
		} else {
			if (context.oAuth2Response.getResponseCode() == 200) {
				JSONArray dataArray = context.oAuth2Response.getJSONArrayFromContent();
				JSONObject data;
				for (int i = 0, size = dataArray.length(); i < size; i++) {
					data = dataArray.getJSONObject(i);
					resourceList.add(getOneLoginResource(clazzConstructor, data));
				}

				return collectAfterCursor(context, versionId);
			} else {
				setResponseError(context.oAuth2Response, false);
			}
		}
		return null;
	}

	private String getIdsListBatch(List<Long> resourceList, ExtractionContext context, int versionId, String index) throws ErrorResourceInitialization {
		if (versionId == 1) {
			if (context.oAuthResponse.getResponseCode() == 200) {
				JSONObject[] dataArray = context.oAuthResponse.getDataArray();
				if (dataArray != null && dataArray.length > 0) {
					for (Object data : dataArray) {
						resourceList.add((Long) data);
					}
				}
				return collectAfterCursor(context, versionId);
			} else {
				setResponseError(context.oAuthResponse, false);
			}
		} else {
			if (context.oAuth2Response.getResponseCode() == 200) {
				JSONArray dataArray = null;
				if (index == null) {
					dataArray = context.oAuth2Response.getJSONArrayFromContent();
				} else {
					dataArray = (JSONArray) context.oAuth2Response.getFromContent(index);
				}

				if (dataArray != null) {
					for (int i = 0, size = dataArray.length(); i < size; i++) {
						resourceList.add(dataArray.optLong(i));
					}
				}

				return collectAfterCursor(context, versionId);
			} else {
				setResponseError(context.oAuth2Response, false);
			}
		}
		return null;
	}
	
	private List<String> retrieveList(URIBuilder url, int versionId) throws OAuthSystemException, OAuthProblemException {
		List<String> strList = new ArrayList<String>();
		if (versionId == 1) {
			OneloginOAuthJSONResourceResponse oAuthResponse = (OneloginOAuthJSONResourceResponse) executeCall(url, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class); 
			if (oAuthResponse.getResponseCode() == 200) {
				strList = oAuthResponse.getValuesFromData();
			} else {
				setResponseError(oAuthResponse, false);
			}
		} else {
			OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
			if (oAuth2Response.getResponseCode() == 200) {
				JSONArray dataArray = oAuth2Response.getJSONArrayFromContent();
				for(int i = 0; i < dataArray.length(); i++) {
					strList.add(dataArray.optString(i));
				}
			} else {
				setResponseError(oAuth2Response, false);
			}
		}

		return strList;
	}

	private List<HashMap<String, String>> retrieveListNameValue(URIBuilder url, int versionId) throws OAuthSystemException, OAuthProblemException {
		List<HashMap<String, String>> listNameValue = new ArrayList<HashMap<String, String>>();

		OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.GET, OneloginOAuth2JSONResourceResponse.class);
		if (oAuth2Response.getResponseCode() == 200) {
			HashMap<String, String> info;
			JSONArray dataArray = oAuth2Response.getJSONArrayFromContent();
			if (dataArray == null) return null;
			
			for(int i = 0; i < dataArray.length(); i++) {
				JSONObject data = dataArray.getJSONObject(i);
				info = new HashMap<String, String>();
				info.put("name", data.optString("name"));
				info.put("value", data.optString("value"));
				listNameValue.add(info);
			}
		} else {
			setResponseError(oAuth2Response, false);
		}

		return listNameValue;
	}

	private List<Long> getIdList(URIBuilder url, int versionId) throws OAuthSystemException, OAuthProblemException {
		List<Long> ids = new ArrayList<Long>();
		if (versionId == 1) { 
			OneloginOAuthJSONResourceResponse oAuthResponse = (OneloginOAuthJSONResourceResponse) executeCall(url, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
			if (oAuthResponse.getResponseCode() == 200) {
				ids = (List<Long>) oAuthResponse.getIdsFromData();
			} else {
				setResponseError(oAuthResponse, false);
			}
		} else {
			OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.GET, OneloginOAuth2JSONResourceResponse.class);
			if (oAuth2Response.getResponseCode() == 200) {
				JSONArray dataArray = oAuth2Response.getJSONArrayFromContent();
				if (dataArray != null) {
					for(int i = 0; i < dataArray.length(); i++) {
						ids.add(dataArray.getLong(i));
					}
				}
			} else {
				setResponseError(oAuth2Response, false);
			}
		}
		return ids;
	}

	private List<? extends OneLoginResource> retrieveResourceList(Class<? extends OneLoginResource> clazz, URIBuilder url, HashMap<String, Object> params, int versionId) throws OAuthSystemException, OAuthProblemException, ErrorResourceInitialization {
		return retrieveResourceList(clazz, url, params, null, versionId);
	}
	
	private List<? extends OneLoginResource> retrieveResourceList(Class<? extends OneLoginResource> clazz, URIBuilder url, HashMap<String, Object> params, String index, int versionId) throws OAuthSystemException, OAuthProblemException, ErrorResourceInitialization {
		OneLoginResource resource = null;
		Constructor<?> clazzConstructor = getClassConstructor(clazz);

		String body = null;
		if (params != null && !params.isEmpty()) {
			body = JSONUtils.buildJSON(params);
		}

		List<OneLoginResource> resources = new ArrayList<OneLoginResource>();
		if (versionId == 1) {
			OneloginOAuthJSONResourceResponse oAuthResponse = (OneloginOAuthJSONResourceResponse) executeCall(url, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class, body);
			if (oAuthResponse.getResponseCode() == 200) {
				if (index != null) {
					JSONObject data = oAuthResponse.getData();
					if (data.has(index)) {
						JSONArray dataArray = data.getJSONArray(index);
						if (dataArray != null && dataArray.length() > 0) {
							for (int i = 0; i < dataArray.length(); i++) {
								resource = getOneLoginResource(clazzConstructor, dataArray.getJSONObject(i));
								resources.add(resource);
							}
						}
					} else {
						error = "500";
						errorDescription = "Wrong index provided to the retrieveResourceList method: "+ index;
					}
				} else {
					JSONObject[] dataArray = oAuthResponse.getDataArray();
					if (dataArray != null) {
						for (JSONObject dataObj: dataArray) {
							resource = getOneLoginResource(clazzConstructor, dataObj);
							resources.add(resource);
						}
					}
				}
			} else {
				setResponseError(oAuthResponse, false);
			}
		} else {
			OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.GET, OneloginOAuth2JSONResourceResponse.class, body);
			if (oAuth2Response.getResponseCode() == 200) {
				JSONArray dataArray = oAuth2Response.getJSONArrayFromContent();
				if (dataArray != null) {
					for(int i = 0; i < dataArray.length(); i++) {
						resource = getOneLoginResource(clazzConstructor, dataArray.optJSONObject(i));
						resources.add(resource);
					}
				}
			} else {
				setResponseError(oAuth2Response, false);
			}
		}

		return resources;
	}

	private OneLoginResource getResource(Class<? extends OneLoginResource> clazz, URIBuilder url, int versionId) throws OAuthSystemException, OAuthProblemException, ErrorResourceInitialization {
		OneLoginResource resource = null;
		Constructor<?> clazzConstructor = getClassConstructor(clazz);

		if (versionId == 1) {
			OneloginOAuthJSONResourceResponse oAuthResponse = (OneloginOAuthJSONResourceResponse) executeCall(url, OAuth.HttpMethod.GET, OneloginOAuthJSONResourceResponse.class);
			if (oAuthResponse.getResponseCode() == 200) {
				JSONObject data = oAuthResponse.getData();
				resource = getOneLoginResource(clazzConstructor, data);
			} else {
				setResponseError(oAuthResponse, false);
			}
		} else {
			OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.GET, OneloginOAuth2JSONResourceResponse.class);
			if (oAuth2Response.getResponseCode() == 200) {
				JSONObject data = oAuth2Response.getJSONObjectFromContent();
				resource = getOneLoginResource(clazzConstructor, data);
			} else {
				setResponseError(oAuth2Response, false);
			}
		}
		
		return resource;
	}

	private SessionToken processLogin(URIBuilder url, int versionId, Map<String, Object> params, String allowedOrigin) throws OAuthSystemException, OAuthProblemException {
		Map<String, String> extraHeaders = new HashMap<String,String>();
		if (allowedOrigin != null) {
			extraHeaders.put("Custom-Allowed-Origin-Header-1", allowedOrigin);
		}

		String body = null;
		if (params != null && !params.isEmpty()) {
			body = JSONUtils.buildJSON(params);
		}

		SessionToken sessionToken = null;
		if (versionId == 1) {
			OneloginOAuthJSONResourceResponse oAuthResponse = (OneloginOAuthJSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class, body, extraHeaders);
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
				setResponseError(oAuthResponse, false);
			}
		}
		return sessionToken;
	}

	private SAMLEndpointResponse retrieveSamlAssertion(URIBuilder url, int versionId, Map<String, Object> params) throws OAuthSystemException, OAuthProblemException {
		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		OAuthClient oAuthClient = new OAuthClient(httpClient);
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString()).buildHeaderMessage();

		String body = null;
		if (params != null && !params.isEmpty()) {
			body = JSONUtils.buildJSON(params);
		}

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		SAMLEndpointResponse samlEndpointResponse = null;

		if (versionId == 1) {
			OneloginOAuthJSONResourceResponse oAuthResponse = (OneloginOAuthJSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class, body);
			if (oAuthResponse.getResponseCode() == 200) {
				samlEndpointResponse = new SAMLEndpointResponse(oAuthResponse.getType(), oAuthResponse.getMessage());
				if (oAuthResponse.getType().equals("success")) {
					if (oAuthResponse.getMessage().equals("Success")) {
						samlEndpointResponse.setSAMLResponse((String)oAuthResponse.getStringFromData());
					} else {
						MFA mfa = new MFA(oAuthResponse.getData());
						samlEndpointResponse.setMFA(mfa);
					}
				} else if (oAuthResponse.getType().equals("pending")) {
					setResponseError(oAuthResponse, false);
				}
			} else {
				setResponseError(oAuthResponse, false);
			}
		} else {
			OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuth2JSONResourceResponse.class, body);
			if (oAuth2Response.getResponseCode() == 200) {
				String message = (String) oAuth2Response.getFromContent("message");
				String statusType = null;
				if (message != null && message.equals("Success") || message.contains("MFA is required")) {
					statusType = "success";
				} else if (message != null && message.contains("pending")) {
					statusType = "pending";
				}
				samlEndpointResponse = new SAMLEndpointResponse(statusType, message);

				Object data = oAuth2Response.getFromContent("data");
				Object state_token = oAuth2Response.getFromContent("state_token");
				if (data != null) {
					samlEndpointResponse.setSAMLResponse((String) data);
				} else if (state_token != null) {
					MFA mfa = new MFA(oAuth2Response.getJSONObjectFromContent());
					samlEndpointResponse.setMFA(mfa);
				}
			} else {
				setResponseError(oAuth2Response, false);
			}
		}
		return samlEndpointResponse;
	}

	private String collectAfterCursor(URIBuilder url, OAuthClientRequest bearerRequest, OAuthClientResponse oAuthResponse) {
		String afterCursor = oAuthResponse.getAfterCursor();
		if (afterCursor != null && !afterCursor.isEmpty()) {
			if (oAuthResponse.getClass() == OneloginOAuthJSONResourceResponse.class) {
				url.setParameter("after_cursor", afterCursor); 
			} else {
				url.setParameter("cursor", afterCursor);
			}
			bearerRequest.setLocationUri(url.toString());
		}

		return afterCursor;
	}

	private String collectAfterCursor(ExtractionContext context, int versionId) {
		String afterCursor = null;
		if (versionId == 1) {
			afterCursor = context.oAuthResponse.getAfterCursor();
			if (afterCursor != null && !afterCursor.isEmpty()) {
				context.url.setParameter("after_cursor", afterCursor);
				context.bearerRequest.setLocationUri(context.url.toString());
			}
		} else {
			afterCursor = context.oAuth2Response.getAfterCursor();
			if (afterCursor != null && !afterCursor.isEmpty()) {
				context.url.setParameter("cursor", afterCursor);
				context.bearerRequest.setLocationUri(context.url.toString());
			}
		}

		return afterCursor;
	}

	private OneLoginResource createResource(Class<? extends OneLoginResource> clazz, Map<String, Object> params, URIBuilder url, int versionId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		String body = null;
		if (params != null && !params.isEmpty()) {
			body = JSONUtils.buildJSON(params);
		}

		OneLoginResource resource = null;
		Constructor<?> clazzConstructor = getClassConstructor(clazz);

		if (versionId == 1) {
			OneloginOAuthJSONResourceResponse oAuthResponse = (OneloginOAuthJSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class, body);
			if (oAuthResponse.getResponseCode() == 200) {
				if (oAuthResponse.getType().equals("success")) {
					if (oAuthResponse.getMessage().equals("Success") || oAuthResponse.getMessage().contains("Authentication pending")) {
						JSONObject data = oAuthResponse.getData();
						resource = getOneLoginResource(clazzConstructor, data);
					}
				}
			} else {
				setResponseError(oAuthResponse, true);
			}
		} else {
			OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuth2JSONResourceResponse.class, body);
			if (oAuth2Response.getResponseCode() == 201) {
				JSONObject data = oAuth2Response.getJSONObjectFromContent();
				resource = getOneLoginResource(clazzConstructor, data);
			} else {
				setResponseError(oAuth2Response, true);
			}
		}

		return resource;
	}

	private String createResource(Map<String, Object> params, URIBuilder url, int versionId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		String body = null;
		if (params != null && !params.isEmpty()) {
			body = JSONUtils.buildJSON(params);
		}

		String resourceId = null;
		if (versionId == 1) {
			OneloginOAuthJSONResourceResponse oAuthResponse = (OneloginOAuthJSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class, body);
			if (oAuthResponse.getResponseCode() == 200) {
				if (oAuthResponse.getType().equals("success")) {
					if (oAuthResponse.getMessage().equals("Success")) {
						resourceId = oAuthResponse.getDataId();
					}
				}
			} else {
				setResponseError(oAuthResponse, true);
			}
		} else {
			OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuth2JSONResourceResponse.class, body);
			if (oAuth2Response.getResponseCode() == 201) {
				resourceId = oAuth2Response.getIdFromContent();
			} else {
				setResponseError(oAuth2Response, true);
			}
		}

		return resourceId;
	}

	@SuppressWarnings("rawtypes")
	private OneLoginResource updateResource(Class clazz, Map<String, Object> params, URIBuilder url, int versionId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		String body = null;
		if (params != null && !params.isEmpty()) {
			body = JSONUtils.buildJSON(params);
		}

		OneLoginResource resource = null;
		Constructor<?> clazzConstructor = getClassConstructor(clazz);

		if (versionId == 1) {
			OneloginOAuthJSONResourceResponse oAuthResponse = (OneloginOAuthJSONResourceResponse) executeCall(url, OAuth.HttpMethod.PUT, OneloginOAuthJSONResourceResponse.class, body);
			if (oAuthResponse.getResponseCode() == 200) {
				if (oAuthResponse.getType().equals("success")) {
					if (oAuthResponse.getMessage().equals("Success")) {
						JSONObject data = oAuthResponse.getData();
						resource = getOneLoginResource(clazzConstructor, data);
					}
				}
			} else {
				setResponseError(oAuthResponse, true);
			}
		} else {
			OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.PUT, OneloginOAuth2JSONResourceResponse.class, body);
			if (oAuth2Response.getResponseCode() == 200) {
				JSONObject data = oAuth2Response.getJSONObjectFromContent();
				resource = getOneLoginResource(clazzConstructor, data);
			} else {
				setResponseError(oAuth2Response, true);
			}
		}

		return resource;
	}

	private String updateResource(Map<String, Object> params, URIBuilder url, int versionId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		String body = null;
		if (params != null && !params.isEmpty()) {
			body = JSONUtils.buildJSON(params);
		}

		String resourceId = null;
		if (versionId == 1) {
			OneloginOAuthJSONResourceResponse oAuthResponse = (OneloginOAuthJSONResourceResponse) executeCall(url, OAuth.HttpMethod.PUT, OneloginOAuthJSONResourceResponse.class, body);
			if (oAuthResponse.getResponseCode() == 200) {
				if (oAuthResponse.getType().equals("success")) {
					if (oAuthResponse.getMessage().equals("Success")) {
						resourceId = oAuthResponse.getDataId();
					}
				}
			} else {
				setResponseError(oAuthResponse, true);
			}
		} else {
			OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.PUT, OneloginOAuth2JSONResourceResponse.class, body);
			if (oAuth2Response.getResponseCode() == 200) {
				resourceId = oAuth2Response.getIdFromContent();
			} else {
				setResponseError(oAuth2Response, true);
			}
		}

		return resourceId;
	}

	private Boolean deleteResource(URIBuilder url, int versionId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		Boolean removed = true;

		List<Integer> validV2DeleteStatus = Arrays.asList(200, 202, 204);


		if (versionId == 1) {
			OneloginOAuthJSONResourceResponse oAuthResponse = (OneloginOAuthJSONResourceResponse) executeCall(url, OAuth.HttpMethod.DELETE, OneloginOAuthJSONResourceResponse.class);
			if (oAuthResponse.getResponseCode() != 200) {
				removed = false;
				setResponseError(oAuthResponse, true);
			}
		} else {
			OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.DELETE, OneloginOAuth2JSONResourceResponse.class);
			if (!validV2DeleteStatus.contains(oAuth2Response.getResponseCode())) {
				removed = false;
				setResponseError(oAuth2Response, true);
			}
		}

		return removed;
	}

	private Boolean updateOperation(Map<String, Object> params, URIBuilder url, int versionId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		String body = null;
		if (params != null && !params.isEmpty()) {
			body = JSONUtils.buildJSON(params);
		}

		Boolean success = true;
		if (versionId == 1) {
			OneloginOAuthJSONResourceResponse oAuthResponse = (OneloginOAuthJSONResourceResponse) executeCall(url, OAuth.HttpMethod.PUT, OneloginOAuthJSONResourceResponse.class, body);
			if (oAuthResponse.getResponseCode() != 200) {
				success = false;
				setResponseError(oAuthResponse, true);
			}
		} else {
			OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.PUT, OneloginOAuth2JSONResourceResponse.class, body);
			if (oAuth2Response.getResponseCode() != 200) {
				success = false;
				setResponseError(oAuth2Response, true);
			}
		}

		return success;
	}

	private Boolean createOperation(Map<String, Object> params, URIBuilder url, int versionId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		String body = null;
		if (params != null && !params.isEmpty()) {
			body = JSONUtils.buildJSON(params);
		}
		Boolean success = false;
		
		if (versionId == 1) {
			OneloginOAuthJSONResourceResponse oAuthResponse = (OneloginOAuthJSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuthJSONResourceResponse.class, body);
			if (oAuthResponse.getResponseCode() == 200 || oAuthResponse.getResponseCode() == 201) {
				if (oAuthResponse.getType().equals("success")) {
					success = true;
				} else {
					setResponseError(oAuthResponse, false);
				}
			}
		} else {
			OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuth2JSONResourceResponse.class, body);
			if (oAuth2Response.getResponseCode() == 200 || oAuth2Response.getResponseCode() == 201) {
				success = true;
			} else {
				setResponseError(oAuth2Response, false);
			}
		}

		return success;
	}

	private List<Long> setOperation(List<Long> ids, URIBuilder url, int versionId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		List<Long> responseIds = null;

		String body = null;
		JSONArray jsonArray = new JSONArray(ids);
		body = jsonArray.toString();

		OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.PUT, OneloginOAuth2JSONResourceResponse.class, body);
		if (oAuth2Response.getResponseCode() == 200) {
			responseIds = oAuth2Response.getIdsFromContent();
		} else {
			setResponseError(oAuth2Response, false);
		}

		return responseIds;
	}

	private boolean submitOperation(URIBuilder url, Map<String, Object> params) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		String body = null;
		if (params != null && !params.isEmpty()) {
			body = JSONUtils.buildJSON(params);
		}

		OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuth2JSONResourceResponse.class, body);
		if (oAuth2Response.getResponseCode() == 200) {
			return true;
		} else {
			setResponseError(oAuth2Response, false);
			return false;
		}
	}

	private List<Long> addToResourceOperation(List<Long> ids, URIBuilder url, int versionId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		List<Long> responseIds = null;

		String body = null;
		JSONArray jsonArray = new JSONArray(ids);
		body = jsonArray.toString();

		OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.POST, OneloginOAuth2JSONResourceResponse.class, body);
		if (oAuth2Response.getResponseCode() == 200) {
			responseIds = oAuth2Response.getIdsFromContent();
		} else {
			setResponseError(oAuth2Response, false);
		}

		return responseIds;
	}

	private Boolean removeFromResourceOperation(List<Long> ids, URIBuilder url, int versionId) throws OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
		Boolean success = false;

		String body = null;
		JSONArray jsonArray = new JSONArray(ids);
		body = jsonArray.toString();

		OneloginOAuth2JSONResourceResponse oAuth2Response = (OneloginOAuth2JSONResourceResponse) executeCall(url, OAuth.HttpMethod.DELETE, OneloginOAuth2JSONResourceResponse.class, body);
		if (oAuth2Response.getResponseCode() == 204) {
			success = true;
		} else {
			setResponseError(oAuth2Response, false);
		}

		return success;
	}

	private void setResponseError(OneloginOAuthJSONAccessTokenResponse oAuthResponse) {
		error = oAuthResponse.getError();
		errorDescription = oAuthResponse.getErrorDescription();
	}
	
	private void setResponseError(OneloginOAuthJSONResourceResponse oAuthResponse, Boolean includeAttrError) {
		error = oAuthResponse.getError();
		errorDescription = oAuthResponse.getErrorDescription();
		if (includeAttrError) {
			errorAttribute = oAuthResponse.getErrorAttribute();
		}
	}

	private void setResponseError(OneloginOAuth2JSONResourceResponse oAuthResponse, Boolean includeAttrError) {
		error = oAuthResponse.getError();
		if (error == null) {
			error = Integer.toString(oAuthResponse.getResponseCode());
		}
		errorDescription = oAuthResponse.getErrorDescription();
		if (includeAttrError) {
			errorAttribute = oAuthResponse.getErrorAttribute();
		}
	}

	private ExtractionContext getResourceContext(String resourceUrl, int versionId) throws URISyntaxException, OAuthSystemException, OAuthProblemException {
		return getResourceContext(new HashMap<String, String>(), resourceUrl, versionId);
	}

	private ExtractionContext getResourceContext(HashMap<String, String> queryParameters, String resourceUrl, int versionId) throws URISyntaxException, OAuthSystemException, OAuthProblemException {
		OAuthClient oAuthClient = initClient();

		URIBuilder url = new URIBuilder(settings.getURL(resourceUrl, versionId));
		for (Map.Entry<String,String> parameter: queryParameters.entrySet()) {
			url.addParameter(parameter.getKey(), parameter.getValue());
		}
		OAuthClientRequest bearerRequest = getAuthorizedBearerRequest(url);

		return new ExtractionContext().url(url).request(bearerRequest).client(oAuthClient).version(versionId);
	}

	private ExtractionContext getResourceContext(String resourceUrl, Object id, int versionId) throws URISyntaxException, OAuthSystemException, OAuthProblemException {
		OAuthClient oAuthClient = initClient();
		URIBuilder url = new URIBuilder(settings.getURL(resourceUrl, id.toString(), versionId));
		OAuthClientRequest bearerRequest = getAuthorizedBearerRequest(url);

		return new ExtractionContext().url(url).request(bearerRequest).client(oAuthClient).version(versionId);
	}

	private ExtractionContext extractResourceBatch(HashMap<String, String> queryParameters, int batchSize, String afterCursor, String resourceUrl, int versionId) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		URIBuilder url = new URIBuilder(settings.getURL(resourceUrl, versionId));
		if(!queryParameters.containsKey("limit")) {
			url.addParameter("limit", String.valueOf(batchSize));
		}
		for (Map.Entry<String, String> parameter : queryParameters.entrySet()) {
			url.addParameter(parameter.getKey(), parameter.getValue());
		}

		return auxExtractResourceBatch(url, batchSize, afterCursor, versionId);
	}

	private ExtractionContext extractResourceBatch(Object id, int batchSize, String afterCursor, String resourceUrl, int versionId) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		URIBuilder url = new URIBuilder(settings.getURL(resourceUrl, id.toString(), versionId));

		return auxExtractResourceBatch(url, batchSize, afterCursor, versionId);
	}

	private ExtractionContext auxExtractResourceBatch(URIBuilder url, int batchSize, String afterCursor, int versionId) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		if (afterCursor != null && !afterCursor.isEmpty()) {
			if (versionId==1) {
				url.setParameter("after_cursor", afterCursor);
			} else {
				url.setParameter("cursor", afterCursor);
			}
		}

		return executeCallAndGetContext(url, versionId);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Constructor<?> getClassConstructor(Class clazz) throws ErrorResourceInitialization {
		Constructor<?> clazzConstructor;
		try {
			clazzConstructor = clazz.getConstructor(JSONObject.class);
			return clazzConstructor;
		} catch (NoSuchMethodException | SecurityException e) {
			throw(new ErrorResourceInitialization(e.getMessage()));
		}
	}

	@SuppressWarnings("rawtypes")
	private OneLoginResource getOneLoginResource(Constructor clazzConstructor, JSONObject data) throws ErrorResourceInitialization {
		try {
			return (OneLoginResource)clazzConstructor.newInstance(data);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			throw(new ErrorResourceInitialization(e.getMessage()));
		}
	}
	
	@SuppressWarnings("rawtypes")
	private OAuthClientResponse executeCall(URIBuilder url, String httpMethod, Class clazz) throws OAuthSystemException, OAuthProblemException {
		return executeCall(url, httpMethod, clazz, null);
	}

	@SuppressWarnings({ "rawtypes" })
	private OAuthClientResponse executeCall(URIBuilder url, String httpMethod, Class clazz, String body) throws OAuthSystemException, OAuthProblemException {
		Map<String, String> extraHeaders = new HashMap<String,String>();
		return executeCall(url, httpMethod, clazz, body, extraHeaders);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private OAuthClientResponse executeCall(URIBuilder url, String httpMethod, Class clazz, String body, Map<String, String> extraHeaders) throws OAuthSystemException, OAuthProblemException {
		OAuthClient oAuthClient = initClient();
		OAuthClientRequest bearerRequest = getAuthorizedBearerRequest(url);

		if (!extraHeaders.isEmpty()) {
			for (Map.Entry<String, String> entry : extraHeaders.entrySet())
			bearerRequest.addHeader(entry.getKey(), entry.getValue());
		}

		if (body != null && !body.isEmpty()) {
			bearerRequest.setBody(body);
		}

		return oAuthClient.resource(bearerRequest, httpMethod, clazz);
	}

	private ExtractionContext executeCallAndGetContext(URIBuilder url, Integer versionId) throws OAuthSystemException, OAuthProblemException {
		OAuthClient oAuthClient = initClient();
		OAuthClientRequest bearerRequest = getAuthorizedBearerRequest(url);
		ExtractionContext context = new ExtractionContext().url(url).request(bearerRequest).version(versionId);

		if (versionId == 1) {
			OneloginOAuthJSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET,
					OneloginOAuthJSONResourceResponse.class);
			context.response(oAuthResponse);
		} else {
			OneloginOAuth2JSONResourceResponse oAuthResponse = oAuthClient.resource(bearerRequest, OAuth.HttpMethod.GET,
					OneloginOAuth2JSONResourceResponse.class);
			context.response(oAuthResponse);
		}

		return context;
	}

	private OAuthClient initClient() throws OAuthSystemException, OAuthProblemException {
		cleanError();
		prepareToken();

		OneloginURLConnectionClient httpClient = new OneloginURLConnectionClient();
		return new OAuthClient(httpClient);
	}

	private OAuthClientRequest getAuthorizedBearerRequest(URIBuilder url) throws OAuthSystemException {
		OAuthClientRequest bearerRequest = new OAuthBearerClientRequest(url.toString()).buildHeaderMessage();

		Map<String, String> headers = getAuthorizedHeader();
		bearerRequest.setHeaders(headers);

		return bearerRequest;
	}

	private class ExtractionContext {
		private OneloginOAuth2JSONResourceResponse oAuth2Response;
		private OneloginOAuthJSONResourceResponse oAuthResponse;
		private URIBuilder url;
		private OAuthClientRequest bearerRequest;
		private OAuthClient oAuthClient;
		private int versionId; 

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

		private ExtractionContext response(OneloginOAuth2JSONResourceResponse oAuth2Response) {
			this.oAuth2Response = oAuth2Response;
			return this;
		}

		private ExtractionContext client(OAuthClient oAuthClient) {
			this.oAuthClient = oAuthClient;
			return this;
		}

		private ExtractionContext version(int versionId) {
			this.versionId = versionId;
			return this;
		}
	}
}

