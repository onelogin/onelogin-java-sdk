# BrandingServiceTemplatesApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createMessageTemplate**](BrandingServiceTemplatesApi.md#createMessageTemplate) | **POST** /api/2/branding/brands/{brand_id}/templates | Create Message Template |
| [**deleteMessageTemplate**](BrandingServiceTemplatesApi.md#deleteMessageTemplate) | **DELETE** /api/2/branding/brands/{brand_id}/templates/{template_id} | Delete Message Template |
| [**getMasterByType**](BrandingServiceTemplatesApi.md#getMasterByType) | **GET** /api/2/branding/brands/master/templates/{template_type} | Get Master Template by Type |
| [**getMessageTemplateById**](BrandingServiceTemplatesApi.md#getMessageTemplateById) | **GET** /api/2/branding/brands/{brand_id}/templates/{template_id} | Get Message Template |
| [**getTemplateByLocale**](BrandingServiceTemplatesApi.md#getTemplateByLocale) | **GET** /api/2/branding/brands/{brand_id}/templates/{template_type}/{locale} | Get Template by Type &amp; Locale |
| [**listMessageTemplates**](BrandingServiceTemplatesApi.md#listMessageTemplates) | **GET** /api/2/branding/brands/{brand_id}/templates | List Message Templates |
| [**updateMessageTemplateById**](BrandingServiceTemplatesApi.md#updateMessageTemplateById) | **PUT** /api/2/branding/brands/{brand_id}/templates/{template_id} | Update Message Template |
| [**updateTemplateByLocale**](BrandingServiceTemplatesApi.md#updateTemplateByLocale) | **PUT** /api/2/branding/brands/{brand_id}/templates/{template_type}/{locale} | Update Template by Type &amp; Locale |


<a id="createMessageTemplate"></a>
# **createMessageTemplate**
> MessageTemplate createMessageTemplate(brandId, locale, messageTemplate)

Create Message Template

Create Message Template

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceTemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceTemplatesApi apiInstance = new BrandingServiceTemplatesApi(defaultClient);
    Integer brandId = 9; // Integer | Unique identifier for the branding object.
    String locale = "en"; // String | The 2 character language locale for the template. e.g. en = English, es = Spanish
    MessageTemplate messageTemplate = new MessageTemplate(); // MessageTemplate | 
    try {
      MessageTemplate result = apiInstance.createMessageTemplate(brandId, locale, messageTemplate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceTemplatesApi#createMessageTemplate");
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
| **brandId** | **Integer**| Unique identifier for the branding object. | |
| **locale** | **String**| The 2 character language locale for the template. e.g. en &#x3D; English, es &#x3D; Spanish | [optional] |
| **messageTemplate** | [**MessageTemplate**](MessageTemplate.md)|  | [optional] |

### Return type

[**MessageTemplate**](MessageTemplate.md)

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

<a id="deleteMessageTemplate"></a>
# **deleteMessageTemplate**
> deleteMessageTemplate(brandId, templateId)

Delete Message Template

Delete Message Template

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceTemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceTemplatesApi apiInstance = new BrandingServiceTemplatesApi(defaultClient);
    Integer brandId = 9; // Integer | Unique identifier for the branding object.
    Integer templateId = 25; // Integer | Unique identifier for the template to return.
    try {
      apiInstance.deleteMessageTemplate(brandId, templateId);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceTemplatesApi#deleteMessageTemplate");
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
| **brandId** | **Integer**| Unique identifier for the branding object. | |
| **templateId** | **Integer**| Unique identifier for the template to return. | |

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
| **204** | No Content |  -  |
| **404** | Not Found |  -  |

<a id="getMasterByType"></a>
# **getMasterByType**
> MessageTemplate getMasterByType(templateType)

Get Master Template by Type

Get Master Template by Type

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceTemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceTemplatesApi apiInstance = new BrandingServiceTemplatesApi(defaultClient);
    String templateType = "email_template"; // String | The message template type to return.
    try {
      MessageTemplate result = apiInstance.getMasterByType(templateType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceTemplatesApi#getMasterByType");
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
| **templateType** | **String**| The message template type to return. | |

### Return type

[**MessageTemplate**](MessageTemplate.md)

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

<a id="getMessageTemplateById"></a>
# **getMessageTemplateById**
> MessageTemplate getMessageTemplateById(brandId, templateId)

Get Message Template

Get Message Template by ID

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceTemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceTemplatesApi apiInstance = new BrandingServiceTemplatesApi(defaultClient);
    Integer brandId = 9; // Integer | Unique identifier for the branding object.
    Integer templateId = 25; // Integer | Unique identifier for the template to return.
    try {
      MessageTemplate result = apiInstance.getMessageTemplateById(brandId, templateId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceTemplatesApi#getMessageTemplateById");
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
| **brandId** | **Integer**| Unique identifier for the branding object. | |
| **templateId** | **Integer**| Unique identifier for the template to return. | |

### Return type

[**MessageTemplate**](MessageTemplate.md)

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

<a id="getTemplateByLocale"></a>
# **getTemplateByLocale**
> MessageTemplate getTemplateByLocale(brandId, templateType, locale)

Get Template by Type &amp; Locale

Get Template by Type and Locale

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceTemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceTemplatesApi apiInstance = new BrandingServiceTemplatesApi(defaultClient);
    Integer brandId = 9; // Integer | Unique identifier for the branding object.
    String templateType = "email_template"; // String | The message template type to return.
    String locale = "en"; // String | The 2 character language locale for the template. e.g. en = English, es = Spanish
    try {
      MessageTemplate result = apiInstance.getTemplateByLocale(brandId, templateType, locale);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceTemplatesApi#getTemplateByLocale");
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
| **brandId** | **Integer**| Unique identifier for the branding object. | |
| **templateType** | **String**| The message template type to return. | |
| **locale** | **String**| The 2 character language locale for the template. e.g. en &#x3D; English, es &#x3D; Spanish | |

### Return type

[**MessageTemplate**](MessageTemplate.md)

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

<a id="listMessageTemplates"></a>
# **listMessageTemplates**
> List&lt;ListMessageTemplates200ResponseInner&gt; listMessageTemplates(brandId, locale)

List Message Templates

List Message Templates

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceTemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceTemplatesApi apiInstance = new BrandingServiceTemplatesApi(defaultClient);
    Integer brandId = 9; // Integer | Unique identifier for the branding object.
    String locale = "en"; // String | The 2 character language locale for the template. e.g. en = English, es = Spanish
    try {
      List<ListMessageTemplates200ResponseInner> result = apiInstance.listMessageTemplates(brandId, locale);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceTemplatesApi#listMessageTemplates");
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
| **brandId** | **Integer**| Unique identifier for the branding object. | |
| **locale** | **String**| The 2 character language locale for the template. e.g. en &#x3D; English, es &#x3D; Spanish | [optional] |

### Return type

[**List&lt;ListMessageTemplates200ResponseInner&gt;**](ListMessageTemplates200ResponseInner.md)

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
| **422** | Unprocessable Entity |  -  |

<a id="updateMessageTemplateById"></a>
# **updateMessageTemplateById**
> MessageTemplate updateMessageTemplateById(brandId, templateId)

Update Message Template

Update Message Template by ID

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceTemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceTemplatesApi apiInstance = new BrandingServiceTemplatesApi(defaultClient);
    Integer brandId = 9; // Integer | Unique identifier for the branding object.
    Integer templateId = 25; // Integer | Unique identifier for the template to return.
    try {
      MessageTemplate result = apiInstance.updateMessageTemplateById(brandId, templateId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceTemplatesApi#updateMessageTemplateById");
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
| **brandId** | **Integer**| Unique identifier for the branding object. | |
| **templateId** | **Integer**| Unique identifier for the template to return. | |

### Return type

[**MessageTemplate**](MessageTemplate.md)

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
| **422** | Unprocessable Entity |  -  |

<a id="updateTemplateByLocale"></a>
# **updateTemplateByLocale**
> MessageTemplate updateTemplateByLocale(brandId, templateType, locale)

Update Template by Type &amp; Locale

Update Template by Type and Locale

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceTemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceTemplatesApi apiInstance = new BrandingServiceTemplatesApi(defaultClient);
    Integer brandId = 9; // Integer | Unique identifier for the branding object.
    String templateType = "email_template"; // String | The message template type to return.
    String locale = "en"; // String | The 2 character language locale for the template. e.g. en = English, es = Spanish
    try {
      MessageTemplate result = apiInstance.updateTemplateByLocale(brandId, templateType, locale);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceTemplatesApi#updateTemplateByLocale");
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
| **brandId** | **Integer**| Unique identifier for the branding object. | |
| **templateType** | **String**| The message template type to return. | |
| **locale** | **String**| The 2 character language locale for the template. e.g. en &#x3D; English, es &#x3D; Spanish | |

### Return type

[**MessageTemplate**](MessageTemplate.md)

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

