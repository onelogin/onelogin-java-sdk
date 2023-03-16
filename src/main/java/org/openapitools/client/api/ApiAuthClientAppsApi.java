/*
 * OneLogin API
 * OpenAPI Specification for OneLogin
 *
 * The version of the OpenAPI document: 3.1.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import com.onelogin.client.ApiCallback;
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.ApiResponse;
import com.onelogin.client.Configuration;
import com.onelogin.client.Pair;
import com.onelogin.client.ProgressRequestBody;
import com.onelogin.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.onelogin.client.model.AddClientApp201Response;
import com.onelogin.client.model.AddClientAppRequest;
import com.onelogin.client.model.AltErr;
import com.onelogin.client.model.ClientAppFull;
import com.onelogin.client.model.UpdateClientAppRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class ApiAuthClientAppsApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public ApiAuthClientAppsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ApiAuthClientAppsApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for addClientApp
     * @param apiAuthId  (required)
     * @param contentType  (optional, default to application/json)
     * @param addClientAppRequest  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call addClientAppCall(String apiAuthId, String contentType, AddClientAppRequest addClientAppRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = addClientAppRequest;

        // create path and map variables
        String localVarPath = "/api/2/api_authorizations/{api_auth_id}/clients"
            .replace("{" + "api_auth_id" + "}", localVarApiClient.escapeString(apiAuthId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (contentType != null) {
            localVarHeaderParams.put("Content-Type", localVarApiClient.parameterToString(contentType));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "OAuth2" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call addClientAppValidateBeforeCall(String apiAuthId, String contentType, AddClientAppRequest addClientAppRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'apiAuthId' is set
        if (apiAuthId == null) {
            throw new ApiException("Missing the required parameter 'apiAuthId' when calling addClientApp(Async)");
        }

        return addClientAppCall(apiAuthId, contentType, addClientAppRequest, _callback);

    }

    /**
     * Add Client App
     * Add Client App
     * @param apiAuthId  (required)
     * @param contentType  (optional, default to application/json)
     * @param addClientAppRequest  (optional)
     * @return AddClientApp201Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
     </table>
     */
    public AddClientApp201Response addClientApp(String apiAuthId, String contentType, AddClientAppRequest addClientAppRequest) throws ApiException {
        ApiResponse<AddClientApp201Response> localVarResp = addClientAppWithHttpInfo(apiAuthId, contentType, addClientAppRequest);
        return localVarResp.getData();
    }

    /**
     * Add Client App
     * Add Client App
     * @param apiAuthId  (required)
     * @param contentType  (optional, default to application/json)
     * @param addClientAppRequest  (optional)
     * @return ApiResponse&lt;AddClientApp201Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<AddClientApp201Response> addClientAppWithHttpInfo(String apiAuthId, String contentType, AddClientAppRequest addClientAppRequest) throws ApiException {
        okhttp3.Call localVarCall = addClientAppValidateBeforeCall(apiAuthId, contentType, addClientAppRequest, null);
        Type localVarReturnType = new TypeToken<AddClientApp201Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Add Client App (asynchronously)
     * Add Client App
     * @param apiAuthId  (required)
     * @param contentType  (optional, default to application/json)
     * @param addClientAppRequest  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call addClientAppAsync(String apiAuthId, String contentType, AddClientAppRequest addClientAppRequest, final ApiCallback<AddClientApp201Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = addClientAppValidateBeforeCall(apiAuthId, contentType, addClientAppRequest, _callback);
        Type localVarReturnType = new TypeToken<AddClientApp201Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteClientApp
     * @param apiAuthId  (required)
     * @param clientAppId  (required)
     * @param contentType  (optional, default to application/json)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteClientAppCall(String apiAuthId, Integer clientAppId, String contentType, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/2/api_authorizations/{api_auth_id}/clients/{client_app_id}"
            .replace("{" + "api_auth_id" + "}", localVarApiClient.escapeString(apiAuthId.toString()))
            .replace("{" + "client_app_id" + "}", localVarApiClient.escapeString(clientAppId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (contentType != null) {
            localVarHeaderParams.put("Content-Type", localVarApiClient.parameterToString(contentType));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "OAuth2" };
        return localVarApiClient.buildCall(basePath, localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteClientAppValidateBeforeCall(String apiAuthId, Integer clientAppId, String contentType, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'apiAuthId' is set
        if (apiAuthId == null) {
            throw new ApiException("Missing the required parameter 'apiAuthId' when calling deleteClientApp(Async)");
        }

        // verify the required parameter 'clientAppId' is set
        if (clientAppId == null) {
            throw new ApiException("Missing the required parameter 'clientAppId' when calling deleteClientApp(Async)");
        }

        return deleteClientAppCall(apiAuthId, clientAppId, contentType, _callback);

    }

    /**
     * Remove Client App
     * Delete Client App
     * @param apiAuthId  (required)
     * @param clientAppId  (required)
     * @param contentType  (optional, default to application/json)
     * @return AddClientApp201Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
     </table>
     */
    public AddClientApp201Response deleteClientApp(String apiAuthId, Integer clientAppId, String contentType) throws ApiException {
        ApiResponse<AddClientApp201Response> localVarResp = deleteClientAppWithHttpInfo(apiAuthId, clientAppId, contentType);
        return localVarResp.getData();
    }

    /**
     * Remove Client App
     * Delete Client App
     * @param apiAuthId  (required)
     * @param clientAppId  (required)
     * @param contentType  (optional, default to application/json)
     * @return ApiResponse&lt;AddClientApp201Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<AddClientApp201Response> deleteClientAppWithHttpInfo(String apiAuthId, Integer clientAppId, String contentType) throws ApiException {
        okhttp3.Call localVarCall = deleteClientAppValidateBeforeCall(apiAuthId, clientAppId, contentType, null);
        Type localVarReturnType = new TypeToken<AddClientApp201Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Remove Client App (asynchronously)
     * Delete Client App
     * @param apiAuthId  (required)
     * @param clientAppId  (required)
     * @param contentType  (optional, default to application/json)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteClientAppAsync(String apiAuthId, Integer clientAppId, String contentType, final ApiCallback<AddClientApp201Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteClientAppValidateBeforeCall(apiAuthId, clientAppId, contentType, _callback);
        Type localVarReturnType = new TypeToken<AddClientApp201Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listClientApps
     * @param apiAuthId  (required)
     * @param contentType  (optional, default to application/json)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listClientAppsCall(String apiAuthId, String contentType, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/2/api_authorizations/{api_auth_id}/clients"
            .replace("{" + "api_auth_id" + "}", localVarApiClient.escapeString(apiAuthId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (contentType != null) {
            localVarHeaderParams.put("Content-Type", localVarApiClient.parameterToString(contentType));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "OAuth2" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listClientAppsValidateBeforeCall(String apiAuthId, String contentType, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'apiAuthId' is set
        if (apiAuthId == null) {
            throw new ApiException("Missing the required parameter 'apiAuthId' when calling listClientApps(Async)");
        }

        return listClientAppsCall(apiAuthId, contentType, _callback);

    }

    /**
     * List Clients Apps
     * List Client Apps
     * @param apiAuthId  (required)
     * @param contentType  (optional, default to application/json)
     * @return ClientAppFull
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ClientAppFull listClientApps(String apiAuthId, String contentType) throws ApiException {
        ApiResponse<ClientAppFull> localVarResp = listClientAppsWithHttpInfo(apiAuthId, contentType);
        return localVarResp.getData();
    }

    /**
     * List Clients Apps
     * List Client Apps
     * @param apiAuthId  (required)
     * @param contentType  (optional, default to application/json)
     * @return ApiResponse&lt;ClientAppFull&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ClientAppFull> listClientAppsWithHttpInfo(String apiAuthId, String contentType) throws ApiException {
        okhttp3.Call localVarCall = listClientAppsValidateBeforeCall(apiAuthId, contentType, null);
        Type localVarReturnType = new TypeToken<ClientAppFull>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List Clients Apps (asynchronously)
     * List Client Apps
     * @param apiAuthId  (required)
     * @param contentType  (optional, default to application/json)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listClientAppsAsync(String apiAuthId, String contentType, final ApiCallback<ClientAppFull> _callback) throws ApiException {

        okhttp3.Call localVarCall = listClientAppsValidateBeforeCall(apiAuthId, contentType, _callback);
        Type localVarReturnType = new TypeToken<ClientAppFull>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for updateClientApp
     * @param apiAuthId  (required)
     * @param clientAppId  (required)
     * @param contentType  (optional, default to application/json)
     * @param updateClientAppRequest  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful Response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateClientAppCall(String apiAuthId, Integer clientAppId, String contentType, UpdateClientAppRequest updateClientAppRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = updateClientAppRequest;

        // create path and map variables
        String localVarPath = "/api/2/api_authorizations/{api_auth_id}/clients/{client_app_id}"
            .replace("{" + "api_auth_id" + "}", localVarApiClient.escapeString(apiAuthId.toString()))
            .replace("{" + "client_app_id" + "}", localVarApiClient.escapeString(clientAppId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (contentType != null) {
            localVarHeaderParams.put("Content-Type", localVarApiClient.parameterToString(contentType));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "OAuth2" };
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateClientAppValidateBeforeCall(String apiAuthId, Integer clientAppId, String contentType, UpdateClientAppRequest updateClientAppRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'apiAuthId' is set
        if (apiAuthId == null) {
            throw new ApiException("Missing the required parameter 'apiAuthId' when calling updateClientApp(Async)");
        }

        // verify the required parameter 'clientAppId' is set
        if (clientAppId == null) {
            throw new ApiException("Missing the required parameter 'clientAppId' when calling updateClientApp(Async)");
        }

        return updateClientAppCall(apiAuthId, clientAppId, contentType, updateClientAppRequest, _callback);

    }

    /**
     * Update Client App
     * Update Client App
     * @param apiAuthId  (required)
     * @param clientAppId  (required)
     * @param contentType  (optional, default to application/json)
     * @param updateClientAppRequest  (optional)
     * @return AddClientApp201Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful Response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
     </table>
     */
    public AddClientApp201Response updateClientApp(String apiAuthId, Integer clientAppId, String contentType, UpdateClientAppRequest updateClientAppRequest) throws ApiException {
        ApiResponse<AddClientApp201Response> localVarResp = updateClientAppWithHttpInfo(apiAuthId, clientAppId, contentType, updateClientAppRequest);
        return localVarResp.getData();
    }

    /**
     * Update Client App
     * Update Client App
     * @param apiAuthId  (required)
     * @param clientAppId  (required)
     * @param contentType  (optional, default to application/json)
     * @param updateClientAppRequest  (optional)
     * @return ApiResponse&lt;AddClientApp201Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful Response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<AddClientApp201Response> updateClientAppWithHttpInfo(String apiAuthId, Integer clientAppId, String contentType, UpdateClientAppRequest updateClientAppRequest) throws ApiException {
        okhttp3.Call localVarCall = updateClientAppValidateBeforeCall(apiAuthId, clientAppId, contentType, updateClientAppRequest, null);
        Type localVarReturnType = new TypeToken<AddClientApp201Response>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update Client App (asynchronously)
     * Update Client App
     * @param apiAuthId  (required)
     * @param clientAppId  (required)
     * @param contentType  (optional, default to application/json)
     * @param updateClientAppRequest  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful Response </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateClientAppAsync(String apiAuthId, Integer clientAppId, String contentType, UpdateClientAppRequest updateClientAppRequest, final ApiCallback<AddClientApp201Response> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateClientAppValidateBeforeCall(apiAuthId, clientAppId, contentType, updateClientAppRequest, _callback);
        Type localVarReturnType = new TypeToken<AddClientApp201Response>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
