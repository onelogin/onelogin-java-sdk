# OAuth2Api

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**generateToken**](OAuth2Api.md#generateToken) | **POST** /auth/oauth2/v2/token | Generate Token |
| [**getRateLimit**](OAuth2Api.md#getRateLimit) | **GET** /auth/rate_limit | Get Rate Limit |
| [**revokeTokens**](OAuth2Api.md#revokeTokens) | **POST** /auth/oauth2/revoke | Revoke Tokens |


<a id="generateToken"></a>
# **generateToken**
> OauthToken generateToken(generateTokenRequest, contentType)

Generate Token

Generate Token

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.OAuth2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    OAuth2Api apiInstance = new OAuth2Api(defaultClient);
    GenerateTokenRequest generateTokenRequest = new GenerateTokenRequest(); // GenerateTokenRequest | Request Body to Generate OAuth Token
    String contentType = "application/json"; // String | 
    try {
      OauthToken result = apiInstance.generateToken(generateTokenRequest, contentType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OAuth2Api#generateToken");
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
| **generateTokenRequest** | [**GenerateTokenRequest**](GenerateTokenRequest.md)| Request Body to Generate OAuth Token | |
| **contentType** | **String**|  | [optional] [default to application/json] |

### Return type

[**OauthToken**](OauthToken.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="getRateLimit"></a>
# **getRateLimit**
> GetRateLimit200Response getRateLimit()

Get Rate Limit

Get Rate Limit

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.OAuth2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    OAuth2Api apiInstance = new OAuth2Api(defaultClient);
    try {
      GetRateLimit200Response result = apiInstance.getRateLimit();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OAuth2Api#getRateLimit");
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

[**GetRateLimit200Response**](GetRateLimit200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="revokeTokens"></a>
# **revokeTokens**
> Error revokeTokens(contentType, revokeTokensRequest)

Revoke Tokens

Revoke Tokens

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.OAuth2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    OAuth2Api apiInstance = new OAuth2Api(defaultClient);
    String contentType = "application/json"; // String | 
    RevokeTokensRequest revokeTokensRequest = new RevokeTokensRequest(); // RevokeTokensRequest | 
    try {
      Error result = apiInstance.revokeTokens(contentType, revokeTokensRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OAuth2Api#revokeTokens");
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
| **revokeTokensRequest** | [**RevokeTokensRequest**](RevokeTokensRequest.md)|  | [optional] |

### Return type

[**Error**](Error.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

