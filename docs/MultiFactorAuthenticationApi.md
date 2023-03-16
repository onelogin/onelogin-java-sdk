# MultiFactorAuthenticationApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createDeviceVerification**](MultiFactorAuthenticationApi.md#createDeviceVerification) | **POST** /api/2/mfa/users/{user_id}/verifications | Create Device Verification |
| [**createFactorRegistration**](MultiFactorAuthenticationApi.md#createFactorRegistration) | **POST** /api/2/mfa/users/{user_id}/registrations | Create Factor Registration |
| [**deleteEnrolledFactor**](MultiFactorAuthenticationApi.md#deleteEnrolledFactor) | **DELETE** /api/2/mfa/users/{user_id}/devices/{device_id} | Delete Enrolled Factor |
| [**generateOTP**](MultiFactorAuthenticationApi.md#generateOTP) | **POST** /api/2/mfa/users/{user_id}/mfa_token | Generate MFA token |
| [**getAuthFactors**](MultiFactorAuthenticationApi.md#getAuthFactors) | **GET** /api/2/mfa/users/{user_id}/factors | Get User Factors |
| [**getAuthenticationDevices**](MultiFactorAuthenticationApi.md#getAuthenticationDevices) | **GET** /api/2/mfa/users/{user_id}/devices | Get User Devices |
| [**getUserRegistration**](MultiFactorAuthenticationApi.md#getUserRegistration) | **GET** /api/2/mfa/users/{user_id}/registrations/{registration_id} | Get User Registration |
| [**getUserVerification**](MultiFactorAuthenticationApi.md#getUserVerification) | **GET** /api/2/mfa/users/{user_id}/verifications/{verification_id} | Get User Verification |
| [**verifyUserRegistration**](MultiFactorAuthenticationApi.md#verifyUserRegistration) | **PUT** /api/2/mfa/users/{user_id}/registrations/{registration_id} | Verify User Registration |
| [**verifyUserVerification**](MultiFactorAuthenticationApi.md#verifyUserVerification) | **PUT** /api/2/mfa/users/{user_id}/verifications/{verification_id} | Verify User Verification |


<a name="createDeviceVerification"></a>
# **createDeviceVerification**
> CreateDeviceVerification201Response createDeviceVerification(userId, contentType, createDeviceVerificationRequest)

Create Device Verification

Create a new verification process

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.MultiFactorAuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationApi apiInstance = new MultiFactorAuthenticationApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    String contentType = "application/json"; // String | 
    CreateDeviceVerificationRequest createDeviceVerificationRequest = new CreateDeviceVerificationRequest(); // CreateDeviceVerificationRequest | 
    try {
      CreateDeviceVerification201Response result = apiInstance.createDeviceVerification(userId, contentType, createDeviceVerificationRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationApi#createDeviceVerification");
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
| **contentType** | **String**|  | [optional] [default to application/json] |
| **createDeviceVerificationRequest** | [**CreateDeviceVerificationRequest**](CreateDeviceVerificationRequest.md)|  | [optional] |

### Return type

[**CreateDeviceVerification201Response**](CreateDeviceVerification201Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  * Content-Type -  <br>  |
| **401** | Unauthorized |  -  |

<a name="createFactorRegistration"></a>
# **createFactorRegistration**
> CreateFactorRegistration201Response createFactorRegistration(userId, contentType, createFactorRegistrationRequest)

Create Factor Registration

Create a new registration process

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.MultiFactorAuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationApi apiInstance = new MultiFactorAuthenticationApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    String contentType = "application/json"; // String | 
    CreateFactorRegistrationRequest createFactorRegistrationRequest = new CreateFactorRegistrationRequest(); // CreateFactorRegistrationRequest | 
    try {
      CreateFactorRegistration201Response result = apiInstance.createFactorRegistration(userId, contentType, createFactorRegistrationRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationApi#createFactorRegistration");
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
| **contentType** | **String**|  | [optional] [default to application/json] |
| **createFactorRegistrationRequest** | [**CreateFactorRegistrationRequest**](CreateFactorRegistrationRequest.md)|  | [optional] |

### Return type

[**CreateFactorRegistration201Response**](CreateFactorRegistration201Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  * Accept-Language -  <br>  * Cache-Control -  <br>  * Content-Length -  <br>  * Content-Type -  <br>  * X-Content-Type-Options -  <br>  * X-Request-Id -  <br>  * Date -  <br>  |
| **401** | Unauthorized |  -  |

<a name="deleteEnrolledFactor"></a>
# **deleteEnrolledFactor**
> deleteEnrolledFactor(userId, deviceId)

Delete Enrolled Factor

Delete a user\\&#39;s authentication device

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.MultiFactorAuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationApi apiInstance = new MultiFactorAuthenticationApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    String deviceId = "deviceId_example"; // String | 
    try {
      apiInstance.deleteEnrolledFactor(userId, deviceId);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationApi#deleteEnrolledFactor");
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
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |

<a name="generateOTP"></a>
# **generateOTP**
> GenerateOTP201Response generateOTP(userId, contentType, generateOTPRequest)

Generate MFA token

Create new MFA token on the user&#39;s account

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.MultiFactorAuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationApi apiInstance = new MultiFactorAuthenticationApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    String contentType = "application/json"; // String | 
    GenerateOTPRequest generateOTPRequest = new GenerateOTPRequest(); // GenerateOTPRequest | 
    try {
      GenerateOTP201Response result = apiInstance.generateOTP(userId, contentType, generateOTPRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationApi#generateOTP");
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
| **contentType** | **String**|  | [optional] [default to application/json] |
| **generateOTPRequest** | [**GenerateOTPRequest**](GenerateOTPRequest.md)|  | [optional] |

### Return type

[**GenerateOTP201Response**](GenerateOTP201Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  * Content-Type -  <br>  |
| **401** | Unauthorized |  -  |
| **422** | Unprocessable Entity |  -  |

<a name="getAuthFactors"></a>
# **getAuthFactors**
> GetAuthFactors200Response getAuthFactors(userId)

Get User Factors

Get a user\\&#39;s available authentication factors

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.MultiFactorAuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationApi apiInstance = new MultiFactorAuthenticationApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    try {
      GetAuthFactors200Response result = apiInstance.getAuthFactors(userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationApi#getAuthFactors");
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

[**GetAuthFactors200Response**](GetAuthFactors200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Content-Type -  <br>  |
| **401** | Unauthorized |  -  |

<a name="getAuthenticationDevices"></a>
# **getAuthenticationDevices**
> List&lt;GetAuthenticationDevices200ResponseInner&gt; getAuthenticationDevices(userId)

Get User Devices

Get a user authentication devices

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.MultiFactorAuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationApi apiInstance = new MultiFactorAuthenticationApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    try {
      List<GetAuthenticationDevices200ResponseInner> result = apiInstance.getAuthenticationDevices(userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationApi#getAuthenticationDevices");
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

[**List&lt;GetAuthenticationDevices200ResponseInner&gt;**](GetAuthenticationDevices200ResponseInner.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |

<a name="getUserRegistration"></a>
# **getUserRegistration**
> Object getUserRegistration(userId, registrationId)

Get User Registration

Get registration state by id

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.MultiFactorAuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationApi apiInstance = new MultiFactorAuthenticationApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    String registrationId = "<UUID>"; // String | The id of a registration
    try {
      Object result = apiInstance.getUserRegistration(userId, registrationId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationApi#getUserRegistration");
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
| **registrationId** | **String**| The id of a registration | |

### Return type

**Object**

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Accept-Language -  <br>  * Cache-Control -  <br>  * Content-Length -  <br>  * Content-Type -  <br>  * X-Content-Type-Options -  <br>  * X-Request-Id -  <br>  * Date -  <br>  |
| **401** | Unauthorized |  -  |

<a name="getUserVerification"></a>
# **getUserVerification**
> GetUserVerification200Response getUserVerification(userId, verificationId)

Get User Verification

Get verification state by id

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.MultiFactorAuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationApi apiInstance = new MultiFactorAuthenticationApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    String verificationId = "<UUID>"; // String | The verification_id is returned on activation of the factor or you can get the device_id using the Activate Factor API call.
    try {
      GetUserVerification200Response result = apiInstance.getUserVerification(userId, verificationId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationApi#getUserVerification");
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
| **verificationId** | **String**| The verification_id is returned on activation of the factor or you can get the device_id using the Activate Factor API call. | |

### Return type

[**GetUserVerification200Response**](GetUserVerification200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a name="verifyUserRegistration"></a>
# **verifyUserRegistration**
> VerifyUserRegistration200Response verifyUserRegistration(userId, registrationId, contentType, verifyUserRegistrationRequest)

Verify User Registration

Submit an otp for verification.

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.MultiFactorAuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationApi apiInstance = new MultiFactorAuthenticationApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    String registrationId = "<UUID>"; // String | The id of a registration
    String contentType = "application/json"; // String | 
    VerifyUserRegistrationRequest verifyUserRegistrationRequest = new VerifyUserRegistrationRequest(); // VerifyUserRegistrationRequest | 
    try {
      VerifyUserRegistration200Response result = apiInstance.verifyUserRegistration(userId, registrationId, contentType, verifyUserRegistrationRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationApi#verifyUserRegistration");
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
| **registrationId** | **String**| The id of a registration | |
| **contentType** | **String**|  | [optional] [default to application/json] |
| **verifyUserRegistrationRequest** | [**VerifyUserRegistrationRequest**](VerifyUserRegistrationRequest.md)|  | [optional] |

### Return type

[**VerifyUserRegistration200Response**](VerifyUserRegistration200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Accept-Language -  <br>  * Cache-Control -  <br>  * Content-Length -  <br>  * Content-Type -  <br>  * X-Content-Type-Options -  <br>  * X-Request-Id -  <br>  * Date -  <br>  |
| **401** | Unauthorized |  -  |

<a name="verifyUserVerification"></a>
# **verifyUserVerification**
> Error verifyUserVerification(userId, verificationId, contentType, verifyUserVerificationRequest)

Verify User Verification

Submit an otp for verification.

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.MultiFactorAuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    MultiFactorAuthenticationApi apiInstance = new MultiFactorAuthenticationApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    String verificationId = "<UUID>"; // String | The verification_id is returned on activation of the factor or you can get the device_id using the Activate Factor API call.
    String contentType = "application/json"; // String | 
    VerifyUserVerificationRequest verifyUserVerificationRequest = new VerifyUserVerificationRequest(); // VerifyUserVerificationRequest | 
    try {
      Error result = apiInstance.verifyUserVerification(userId, verificationId, contentType, verifyUserVerificationRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MultiFactorAuthenticationApi#verifyUserVerification");
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
| **verificationId** | **String**| The verification_id is returned on activation of the factor or you can get the device_id using the Activate Factor API call. | |
| **contentType** | **String**|  | [optional] [default to application/json] |
| **verifyUserVerificationRequest** | [**VerifyUserVerificationRequest**](VerifyUserVerificationRequest.md)|  | [optional] |

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
| **200** | OK |  * Content-Type -  <br>  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |

