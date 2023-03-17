# ApiAuthorizationServerApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createAuthServer**](ApiAuthorizationServerApi.md#createAuthServer) | **POST** /api/2/api_authorizations | Create Api Auth Server |
| [**deleteAuthServer**](ApiAuthorizationServerApi.md#deleteAuthServer) | **DELETE** /api/2/api_authorizations/{api_auth_id} | Delete Api Auth Server |
| [**getAuthServer**](ApiAuthorizationServerApi.md#getAuthServer) | **GET** /api/2/api_authorizations/{api_auth_id} | Get Api Auth Server |
| [**listAuthServers**](ApiAuthorizationServerApi.md#listAuthServers) | **GET** /api/2/api_authorizations | List Api Auth Servers |
| [**updateAuthServer**](ApiAuthorizationServerApi.md#updateAuthServer) | **PUT** /api/2/api_authorizations/{api_auth_id} | Update Api Auth Server |


<a name="createAuthServer"></a>
# **createAuthServer**
> AuthServer createAuthServer(contentType, authServer)

Create Api Auth Server

Create Auth Server

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.ApiAuthorizationServerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthorizationServerApi apiInstance = new ApiAuthorizationServerApi(defaultClient);
    String contentType = "application/json"; // String | 
    AuthServer authServer = new AuthServer(); // AuthServer | 
    try {
      AuthServer result = apiInstance.createAuthServer(contentType, authServer);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthorizationServerApi#createAuthServer");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **contentType** | **String**|  | [optional] [default to application/json] |
| **authServer** | [**AuthServer**](AuthServer.md)|  | [optional] |

### Return type

[**AuthServer**](AuthServer.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unprocessable Entity |  -  |

<a name="deleteAuthServer"></a>
# **deleteAuthServer**
> deleteAuthServer(apiAuthId, contentType)

Delete Api Auth Server

Delete Authentication Server

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.ApiAuthorizationServerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthorizationServerApi apiInstance = new ApiAuthorizationServerApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    String contentType = "application/json"; // String | 
    try {
      apiInstance.deleteAuthServer(apiAuthId, contentType);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthorizationServerApi#deleteAuthServer");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **apiAuthId** | **String**|  | |
| **contentType** | **String**|  | [optional] [default to application/json] |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Success. The auth server is deleted. No content is returned. |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a name="getAuthServer"></a>
# **getAuthServer**
> AuthServer getAuthServer(apiAuthId, contentType)

Get Api Auth Server

Get Authorization Server

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.ApiAuthorizationServerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthorizationServerApi apiInstance = new ApiAuthorizationServerApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    String contentType = "application/json"; // String | 
    try {
      AuthServer result = apiInstance.getAuthServer(apiAuthId, contentType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthorizationServerApi#getAuthServer");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **apiAuthId** | **String**|  | |
| **contentType** | **String**|  | [optional] [default to application/json] |

### Return type

[**AuthServer**](AuthServer.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **401** | Unauthorized |  -  |

<a name="listAuthServers"></a>
# **listAuthServers**
> List&lt;AuthServer&gt; listAuthServers()

List Api Auth Servers

List Authorization Servers

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.ApiAuthorizationServerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthorizationServerApi apiInstance = new ApiAuthorizationServerApi(defaultClient);
    try {
      List<AuthServer> result = apiInstance.listAuthServers();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthorizationServerApi#listAuthServers");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;AuthServer&gt;**](AuthServer.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **401** | Unauthorized |  -  |

<a name="updateAuthServer"></a>
# **updateAuthServer**
> AuthServer updateAuthServer(apiAuthId, contentType, authServer)

Update Api Auth Server

Update Authorization Server

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.ApiAuthorizationServerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthorizationServerApi apiInstance = new ApiAuthorizationServerApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    String contentType = "application/json"; // String | 
    AuthServer authServer = new AuthServer(); // AuthServer | 
    try {
      AuthServer result = apiInstance.updateAuthServer(apiAuthId, contentType, authServer);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthorizationServerApi#updateAuthServer");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **apiAuthId** | **String**|  | |
| **contentType** | **String**|  | [optional] [default to application/json] |
| **authServer** | [**AuthServer**](AuthServer.md)|  | [optional] |

### Return type

[**AuthServer**](AuthServer.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |

