# ApiAuthClientAppsApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addClientApp**](ApiAuthClientAppsApi.md#addClientApp) | **POST** /api/2/api_authorizations/{api_auth_id}/clients | Add Client App |
| [**deleteClientApp**](ApiAuthClientAppsApi.md#deleteClientApp) | **DELETE** /api/2/api_authorizations/{api_auth_id}/clients/{client_app_id} | Remove Client App |
| [**listClientApps**](ApiAuthClientAppsApi.md#listClientApps) | **GET** /api/2/api_authorizations/{api_auth_id}/clients | List Clients Apps |
| [**updateClientApp**](ApiAuthClientAppsApi.md#updateClientApp) | **PUT** /api/2/api_authorizations/{api_auth_id}/clients/{client_app_id} | Update Client App |


<a id="addClientApp"></a>
# **addClientApp**
> AddClientApp201Response addClientApp(apiAuthId, contentType, addClientAppRequest)

Add Client App

Add Client App

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.ApiAuthClientAppsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthClientAppsApi apiInstance = new ApiAuthClientAppsApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    String contentType = "application/json"; // String | 
    AddClientAppRequest addClientAppRequest = new AddClientAppRequest(); // AddClientAppRequest | 
    try {
      AddClientApp201Response result = apiInstance.addClientApp(apiAuthId, contentType, addClientAppRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthClientAppsApi#addClientApp");
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
| **addClientAppRequest** | [**AddClientAppRequest**](AddClientAppRequest.md)|  | [optional] |

### Return type

[**AddClientApp201Response**](AddClientApp201Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |

<a id="deleteClientApp"></a>
# **deleteClientApp**
> AddClientApp201Response deleteClientApp(apiAuthId, clientAppId, contentType)

Remove Client App

Delete Client App

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.ApiAuthClientAppsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthClientAppsApi apiInstance = new ApiAuthClientAppsApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    Integer clientAppId = 56; // Integer | 
    String contentType = "application/json"; // String | 
    try {
      AddClientApp201Response result = apiInstance.deleteClientApp(apiAuthId, clientAppId, contentType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthClientAppsApi#deleteClientApp");
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
| **clientAppId** | **Integer**|  | |
| **contentType** | **String**|  | [optional] [default to application/json] |

### Return type

[**AddClientApp201Response**](AddClientApp201Response.md)

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
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |

<a id="listClientApps"></a>
# **listClientApps**
> ClientAppFull listClientApps(apiAuthId, contentType)

List Clients Apps

List Client Apps

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.ApiAuthClientAppsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthClientAppsApi apiInstance = new ApiAuthClientAppsApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    String contentType = "application/json"; // String | 
    try {
      ClientAppFull result = apiInstance.listClientApps(apiAuthId, contentType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthClientAppsApi#listClientApps");
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

[**ClientAppFull**](ClientAppFull.md)

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
| **404** | Not Found |  -  |

<a id="updateClientApp"></a>
# **updateClientApp**
> AddClientApp201Response updateClientApp(apiAuthId, clientAppId, contentType, updateClientAppRequest)

Update Client App

Update Client App

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.ApiAuthClientAppsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthClientAppsApi apiInstance = new ApiAuthClientAppsApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    Integer clientAppId = 56; // Integer | 
    String contentType = "application/json"; // String | 
    UpdateClientAppRequest updateClientAppRequest = new UpdateClientAppRequest(); // UpdateClientAppRequest | 
    try {
      AddClientApp201Response result = apiInstance.updateClientApp(apiAuthId, clientAppId, contentType, updateClientAppRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthClientAppsApi#updateClientApp");
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
| **clientAppId** | **Integer**|  | |
| **contentType** | **String**|  | [optional] [default to application/json] |
| **updateClientAppRequest** | [**UpdateClientAppRequest**](UpdateClientAppRequest.md)|  | [optional] |

### Return type

[**AddClientApp201Response**](AddClientApp201Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable Entity |  -  |

