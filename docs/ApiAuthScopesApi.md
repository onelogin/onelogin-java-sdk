# ApiAuthScopesApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createScope**](ApiAuthScopesApi.md#createScope) | **POST** /api/2/api_authorizations/{api_auth_id}/scopes | Create Api Auth Server Scope |
| [**deleteScope**](ApiAuthScopesApi.md#deleteScope) | **DELETE** /api/2/api_authorizations/{api_auth_id}/scopes/{scope_id} | Delete Api Auth Server Scope |
| [**getScopes**](ApiAuthScopesApi.md#getScopes) | **GET** /api/2/api_authorizations/{api_auth_id}/scopes | Get Api Auth Server Scopes |
| [**updateScope**](ApiAuthScopesApi.md#updateScope) | **PUT** /api/2/api_authorizations/{api_auth_id}/scopes/{scope_id} | Update Api Auth Server Scope |


<a name="createScope"></a>
# **createScope**
> AuthScope createScope(apiAuthId, contentType, authScope)

Create Api Auth Server Scope

Create API Auth Server Scope

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.ApiAuthScopesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthScopesApi apiInstance = new ApiAuthScopesApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    String contentType = "application/json"; // String | 
    AuthScope authScope = new AuthScope(); // AuthScope | 
    try {
      AuthScope result = apiInstance.createScope(apiAuthId, contentType, authScope);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthScopesApi#createScope");
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
| **authScope** | [**AuthScope**](AuthScope.md)|  | [optional] |

### Return type

[**AuthScope**](AuthScope.md)

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

<a name="deleteScope"></a>
# **deleteScope**
> deleteScope(apiAuthId, scopeId, contentType)

Delete Api Auth Server Scope

Delete Scope

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.ApiAuthScopesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthScopesApi apiInstance = new ApiAuthScopesApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    Integer scopeId = 56; // Integer | 
    String contentType = "application/json"; // String | 
    try {
      apiInstance.deleteScope(apiAuthId, scopeId, contentType);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthScopesApi#deleteScope");
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
| **scopeId** | **Integer**|  | |
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
| **204** | Success. The scope is deleted. No content is returned. |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a name="getScopes"></a>
# **getScopes**
> List&lt;AuthScope&gt; getScopes(apiAuthId, contentType)

Get Api Auth Server Scopes

List Authorization Scopes

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.ApiAuthScopesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthScopesApi apiInstance = new ApiAuthScopesApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    String contentType = "application/json"; // String | 
    try {
      List<AuthScope> result = apiInstance.getScopes(apiAuthId, contentType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthScopesApi#getScopes");
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

[**List&lt;AuthScope&gt;**](AuthScope.md)

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

<a name="updateScope"></a>
# **updateScope**
> AuthId updateScope(apiAuthId, scopeId, contentType, authScope)

Update Api Auth Server Scope

Update Scope

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.ApiAuthScopesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthScopesApi apiInstance = new ApiAuthScopesApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    Integer scopeId = 56; // Integer | 
    String contentType = "application/json"; // String | 
    AuthScope authScope = new AuthScope(); // AuthScope | 
    try {
      AuthId result = apiInstance.updateScope(apiAuthId, scopeId, contentType, authScope);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthScopesApi#updateScope");
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
| **scopeId** | **Integer**|  | |
| **contentType** | **String**|  | [optional] [default to application/json] |
| **authScope** | [**AuthScope**](AuthScope.md)|  | [optional] |

### Return type

[**AuthId**](AuthId.md)

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

