# BrandingServiceSmtpApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteEmailSettings**](BrandingServiceSmtpApi.md#deleteEmailSettings) | **DELETE** /api/2/branding/email_settings | Delete Custom Email Settings |
| [**getEmailSettings**](BrandingServiceSmtpApi.md#getEmailSettings) | **GET** /api/2/branding/email_settings | Get Email Settings |
| [**updateEmailSettings**](BrandingServiceSmtpApi.md#updateEmailSettings) | **PUT** /api/2/branding/email_settings | Update Email Settings |


<a name="deleteEmailSettings"></a>
# **deleteEmailSettings**
> AltErr deleteEmailSettings()

Delete Custom Email Settings

Reset Email Setting config

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceSmtpApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceSmtpApi apiInstance = new BrandingServiceSmtpApi(defaultClient);
    try {
      AltErr result = apiInstance.deleteEmailSettings();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceSmtpApi#deleteEmailSettings");
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

[**AltErr**](AltErr.md)

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

<a name="getEmailSettings"></a>
# **getEmailSettings**
> GetEmailSettings200Response getEmailSettings()

Get Email Settings

Get Email Settings Config

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceSmtpApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceSmtpApi apiInstance = new BrandingServiceSmtpApi(defaultClient);
    try {
      GetEmailSettings200Response result = apiInstance.getEmailSettings();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceSmtpApi#getEmailSettings");
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

[**GetEmailSettings200Response**](GetEmailSettings200Response.md)

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

<a name="updateEmailSettings"></a>
# **updateEmailSettings**
> AltErr updateEmailSettings(emailConfig)

Update Email Settings

Update Email Settings Config

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceSmtpApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceSmtpApi apiInstance = new BrandingServiceSmtpApi(defaultClient);
    EmailConfig emailConfig = new EmailConfig(); // EmailConfig | 
    try {
      AltErr result = apiInstance.updateEmailSettings(emailConfig);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceSmtpApi#updateEmailSettings");
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
| **emailConfig** | [**EmailConfig**](EmailConfig.md)|  | [optional] |

### Return type

[**AltErr**](AltErr.md)

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

