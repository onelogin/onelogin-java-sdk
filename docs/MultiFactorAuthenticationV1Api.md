# MultiFactorAuthenticationV1Api

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**activateMfaFactors**](MultiFactorAuthenticationV1Api.md#activateMfaFactors) | **POST** /api/1/users/{user_id}/otp_devices/{device_id}/trigger | Activate a Factor |
| [**enrollMfaFactor**](MultiFactorAuthenticationV1Api.md#enrollMfaFactor) | **POST** /api/1/users/{user_id}/otp_devices | Enroll a Factor |
| [**generateMFAtoken**](MultiFactorAuthenticationV1Api.md#generateMFAtoken) | **POST** /api/1/users/{user_id}/mfa_token | Generate Temp MFA Token |
| [**getEnrolledFactors**](MultiFactorAuthenticationV1Api.md#getEnrolledFactors) | **GET** /api/1/users/{user_id}/otp_devices | Get Enrolled Factors |
| [**getMFAFactors**](MultiFactorAuthenticationV1Api.md#getMFAFactors) | **GET** /api/1/users/{user_id}/auth_factor | Get Available Factors |
| [**removeMfaFactors**](MultiFactorAuthenticationV1Api.md#removeMfaFactors) | **DELETE** /api/1/users/{user_id}/otp_devices/{device_id} | Remove an Enrolled Factor |
| [**verifyMfaFactor**](MultiFactorAuthenticationV1Api.md#verifyMfaFactor) | **POST** /api/1/users/{user_id}/otp_devices/{device_id}/verify | Verify a Factor |


<a name="activateMfaFactors"></a>
# **activateMfaFactors**
> GetEnrolledFactors200Response activateMfaFactors(userId, deviceId, activateMfaFactorsRequest)

Activate a Factor

Activate a Factor

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.MultiFactorAuthenticationV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationV1Api apiInstance = new MultiFactorAuthenticationV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    String deviceId = "deviceId_example"; // String | 
    ActivateMfaFactorsRequest activateMfaFactorsRequest = new ActivateMfaFactorsRequest(); // ActivateMfaFactorsRequest | 
    try {
      GetEnrolledFactors200Response result = apiInstance.activateMfaFactors(userId, deviceId, activateMfaFactorsRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationV1Api#activateMfaFactors");
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
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **deviceId** | **String**|  | |
| **activateMfaFactorsRequest** | [**ActivateMfaFactorsRequest**](ActivateMfaFactorsRequest.md)|  | [optional] |

### Return type

[**GetEnrolledFactors200Response**](GetEnrolledFactors200Response.md)

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

<a name="enrollMfaFactor"></a>
# **enrollMfaFactor**
> EnrollMfaFactor200Response enrollMfaFactor(userId, otpDevice)

Enroll a Factor

 Enroll an Authentication Factor

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.MultiFactorAuthenticationV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationV1Api apiInstance = new MultiFactorAuthenticationV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    OtpDevice otpDevice = new OtpDevice(); // OtpDevice | 
    try {
      EnrollMfaFactor200Response result = apiInstance.enrollMfaFactor(userId, otpDevice);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationV1Api#enrollMfaFactor");
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
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **otpDevice** | [**OtpDevice**](OtpDevice.md)|  | [optional] |

### Return type

[**EnrollMfaFactor200Response**](EnrollMfaFactor200Response.md)

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

<a name="generateMFAtoken"></a>
# **generateMFAtoken**
> GenerateMFAtoken200Response generateMFAtoken(userId, generateMFAtokenRequest)

Generate Temp MFA Token

Generate MFA Token

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.MultiFactorAuthenticationV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationV1Api apiInstance = new MultiFactorAuthenticationV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    GenerateMFAtokenRequest generateMFAtokenRequest = new GenerateMFAtokenRequest(); // GenerateMFAtokenRequest | 
    try {
      GenerateMFAtoken200Response result = apiInstance.generateMFAtoken(userId, generateMFAtokenRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationV1Api#generateMFAtoken");
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
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **generateMFAtokenRequest** | [**GenerateMFAtokenRequest**](GenerateMFAtokenRequest.md)|  | [optional] |

### Return type

[**GenerateMFAtoken200Response**](GenerateMFAtoken200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |

<a name="getEnrolledFactors"></a>
# **getEnrolledFactors**
> GetEnrolledFactors200Response getEnrolledFactors(userId)

Get Enrolled Factors

Get Enrolled Factors

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.MultiFactorAuthenticationV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationV1Api apiInstance = new MultiFactorAuthenticationV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    try {
      GetEnrolledFactors200Response result = apiInstance.getEnrolledFactors(userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationV1Api#getEnrolledFactors");
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
| **userId** | **Integer**| Set to the id of the user that you want to return. | |

### Return type

[**GetEnrolledFactors200Response**](GetEnrolledFactors200Response.md)

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

<a name="getMFAFactors"></a>
# **getMFAFactors**
> GetMFAFactors200Response getMFAFactors(userId)

Get Available Factors

Get MFA Factors

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.MultiFactorAuthenticationV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationV1Api apiInstance = new MultiFactorAuthenticationV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    try {
      GetMFAFactors200Response result = apiInstance.getMFAFactors(userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationV1Api#getMFAFactors");
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
| **userId** | **Integer**| Set to the id of the user that you want to return. | |

### Return type

[**GetMFAFactors200Response**](GetMFAFactors200Response.md)

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

<a name="removeMfaFactors"></a>
# **removeMfaFactors**
> removeMfaFactors(userId, deviceId)

Remove an Enrolled Factor

Remove an enrolled MFA device for a user

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.MultiFactorAuthenticationV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationV1Api apiInstance = new MultiFactorAuthenticationV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    String deviceId = "deviceId_example"; // String | 
    try {
      apiInstance.removeMfaFactors(userId, deviceId);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationV1Api#removeMfaFactors");
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
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **deviceId** | **String**|  | |

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
| **200** | Successful response |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |

<a name="verifyMfaFactor"></a>
# **verifyMfaFactor**
> Error verifyMfaFactor(userId, deviceId, verifyMfaFactorRequest)

Verify a Factor

Verify a Factor

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.MultiFactorAuthenticationV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationV1Api apiInstance = new MultiFactorAuthenticationV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    String deviceId = "deviceId_example"; // String | 
    VerifyMfaFactorRequest verifyMfaFactorRequest = new VerifyMfaFactorRequest(); // VerifyMfaFactorRequest | 
    try {
      Error result = apiInstance.verifyMfaFactor(userId, deviceId, verifyMfaFactorRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationV1Api#verifyMfaFactor");
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
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **deviceId** | **String**|  | |
| **verifyMfaFactorRequest** | [**VerifyMfaFactorRequest**](VerifyMfaFactorRequest.md)|  | [optional] |

### Return type

[**Error**](Error.md)

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

