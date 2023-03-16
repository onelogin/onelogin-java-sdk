# SamlAssertionsApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**generateSamlAssert**](SamlAssertionsApi.md#generateSamlAssert) | **POST** /api/1/saml_assertion | Generate SAML Assertion |
| [**generateSamlAssert2**](SamlAssertionsApi.md#generateSamlAssert2) | **POST** /api/2/saml_assertion | Generate SAML Assertion |
| [**verFactorSaml**](SamlAssertionsApi.md#verFactorSaml) | **POST** /api/1/saml_assertion/verify_factor | Verify Factor SAML |
| [**verFactorSaml2**](SamlAssertionsApi.md#verFactorSaml2) | **POST** /api/2/saml_assertion/verify_factor | Verify Factor SAML |


<a name="generateSamlAssert"></a>
# **generateSamlAssert**
> GenerateSamlAssert200Response generateSamlAssert(contentType, samlAssert)

Generate SAML Assertion

Generate SAML Assertion

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.SamlAssertionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SamlAssertionsApi apiInstance = new SamlAssertionsApi(defaultClient);
    String contentType = "application/json"; // String | 
    SamlAssert samlAssert = new SamlAssert(); // SamlAssert | 
    try {
      GenerateSamlAssert200Response result = apiInstance.generateSamlAssert(contentType, samlAssert);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SamlAssertionsApi#generateSamlAssert");
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
| **samlAssert** | [**SamlAssert**](SamlAssert.md)|  | [optional] |

### Return type

[**GenerateSamlAssert200Response**](GenerateSamlAssert200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |

<a name="generateSamlAssert2"></a>
# **generateSamlAssert2**
> GenerateSamlAssert200Response generateSamlAssert2(contentType, samlAssert)

Generate SAML Assertion

Generate SAML Assertion

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.SamlAssertionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SamlAssertionsApi apiInstance = new SamlAssertionsApi(defaultClient);
    String contentType = "application/json"; // String | 
    SamlAssert samlAssert = new SamlAssert(); // SamlAssert | 
    try {
      GenerateSamlAssert200Response result = apiInstance.generateSamlAssert2(contentType, samlAssert);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SamlAssertionsApi#generateSamlAssert2");
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
| **samlAssert** | [**SamlAssert**](SamlAssert.md)|  | [optional] |

### Return type

[**GenerateSamlAssert200Response**](GenerateSamlAssert200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |

<a name="verFactorSaml"></a>
# **verFactorSaml**
> VerFactorSaml200Response verFactorSaml(contentType, samlFactor)

Verify Factor SAML

Verify Factor: SAML

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.SamlAssertionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SamlAssertionsApi apiInstance = new SamlAssertionsApi(defaultClient);
    String contentType = "application/json"; // String | 
    SamlFactor samlFactor = new SamlFactor(); // SamlFactor | 
    try {
      VerFactorSaml200Response result = apiInstance.verFactorSaml(contentType, samlFactor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SamlAssertionsApi#verFactorSaml");
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
| **samlFactor** | [**SamlFactor**](SamlFactor.md)|  | [optional] |

### Return type

[**VerFactorSaml200Response**](VerFactorSaml200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

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

<a name="verFactorSaml2"></a>
# **verFactorSaml2**
> VerFactorSaml200Response verFactorSaml2(contentType, samlFactor)

Verify Factor SAML

Verify Factor: SAML

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.SamlAssertionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SamlAssertionsApi apiInstance = new SamlAssertionsApi(defaultClient);
    String contentType = "application/json"; // String | 
    SamlFactor samlFactor = new SamlFactor(); // SamlFactor | 
    try {
      VerFactorSaml200Response result = apiInstance.verFactorSaml2(contentType, samlFactor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SamlAssertionsApi#verFactorSaml2");
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
| **samlFactor** | [**SamlFactor**](SamlFactor.md)|  | [optional] |

### Return type

[**VerFactorSaml200Response**](VerFactorSaml200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

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

