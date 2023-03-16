# ApiAuthClaimsApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createAuthClaim**](ApiAuthClaimsApi.md#createAuthClaim) | **POST** /api/2/api_authorizations/{api_auth_id}/claims | Create Api Auth Server Claim |
| [**deleteAuthClaim**](ApiAuthClaimsApi.md#deleteAuthClaim) | **DELETE** /api/2/api_authorizations/{api_auth_id}/claims/{claim_id} | Delete Api Auth Server Claim |
| [**getAuthclaims**](ApiAuthClaimsApi.md#getAuthclaims) | **GET** /api/2/api_authorizations/{api_auth_id}/claims | Get Api Auth Server claims |
| [**updateClaim**](ApiAuthClaimsApi.md#updateClaim) | **PUT** /api/2/api_authorizations/{api_auth_id}/claims/{claim_id} | Update Api Auth Server Claim |


<a name="createAuthClaim"></a>
# **createAuthClaim**
> Integer createAuthClaim(apiAuthId, contentType, authClaim)

Create Api Auth Server Claim

Create Authorization Claim

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.ApiAuthClaimsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthClaimsApi apiInstance = new ApiAuthClaimsApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    String contentType = "application/json"; // String | 
    AuthClaim authClaim = new AuthClaim(); // AuthClaim | 
    try {
      Integer result = apiInstance.createAuthClaim(apiAuthId, contentType, authClaim);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthClaimsApi#createAuthClaim");
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
| **authClaim** | [**AuthClaim**](AuthClaim.md)|  | [optional] |

### Return type

**Integer**

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

<a name="deleteAuthClaim"></a>
# **deleteAuthClaim**
> deleteAuthClaim(apiAuthId, claimId, contentType)

Delete Api Auth Server Claim

Delete Authorization Claim

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.ApiAuthClaimsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthClaimsApi apiInstance = new ApiAuthClaimsApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    Integer claimId = 56; // Integer | 
    String contentType = "application/json"; // String | 
    try {
      apiInstance.deleteAuthClaim(apiAuthId, claimId, contentType);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthClaimsApi#deleteAuthClaim");
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
| **claimId** | **Integer**|  | |
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
| **204** | Success. The claim is deleted. No content is returned. |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a name="getAuthclaims"></a>
# **getAuthclaims**
> List&lt;TokenClaim&gt; getAuthclaims(apiAuthId, contentType)

Get Api Auth Server claims

Get Authorization claims

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.ApiAuthClaimsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthClaimsApi apiInstance = new ApiAuthClaimsApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    String contentType = "application/json"; // String | 
    try {
      List<TokenClaim> result = apiInstance.getAuthclaims(apiAuthId, contentType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthClaimsApi#getAuthclaims");
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

[**List&lt;TokenClaim&gt;**](TokenClaim.md)

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

<a name="updateClaim"></a>
# **updateClaim**
> AuthId updateClaim(apiAuthId, claimId, contentType, authClaim)

Update Api Auth Server Claim

Update Authorization Server Claim

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.ApiAuthClaimsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthClaimsApi apiInstance = new ApiAuthClaimsApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    Integer claimId = 56; // Integer | 
    String contentType = "application/json"; // String | 
    AuthClaim authClaim = new AuthClaim(); // AuthClaim | 
    try {
      AuthId result = apiInstance.updateClaim(apiAuthId, claimId, contentType, authClaim);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthClaimsApi#updateClaim");
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
| **claimId** | **Integer**|  | |
| **contentType** | **String**|  | [optional] [default to application/json] |
| **authClaim** | [**AuthClaim**](AuthClaim.md)|  | [optional] |

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

