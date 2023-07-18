# BrandingServiceApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createBrand**](BrandingServiceApi.md#createBrand) | **POST** /api/2/branding/brands | Create Brand |
| [**deleteBrand**](BrandingServiceApi.md#deleteBrand) | **DELETE** /api/2/branding/brands/{brand_id} | Delete Brand |
| [**getBrand**](BrandingServiceApi.md#getBrand) | **GET** /api/2/branding/brands/{brand_id} | Get Brand |
| [**getBrandApps**](BrandingServiceApi.md#getBrandApps) | **GET** /api/2/branding/brands/{brand_id}/apps | Get Brand Apps |
| [**listBrands**](BrandingServiceApi.md#listBrands) | **GET** /api/2/branding/brands | List Account Brands |
| [**updateBrand**](BrandingServiceApi.md#updateBrand) | **PUT** /api/2/branding/brands/{brand_id} | Update Brand |


<a id="createBrand"></a>
# **createBrand**
> Brand createBrand(brand)

Create Brand

Create a new Account Brand

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceApi apiInstance = new BrandingServiceApi(defaultClient);
    Brand brand = new Brand(); // Brand | 
    try {
      Brand result = apiInstance.createBrand(brand);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceApi#createBrand");
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
| **brand** | [**Brand**](Brand.md)|  | [optional] |

### Return type

[**Brand**](Brand.md)

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
| **422** | Unprocessable Entity |  -  |

<a id="deleteBrand"></a>
# **deleteBrand**
> deleteBrand(brandId)

Delete Brand

Delete Brand

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceApi apiInstance = new BrandingServiceApi(defaultClient);
    Integer brandId = 9; // Integer | Unique identifier for the branding object.
    try {
      apiInstance.deleteBrand(brandId);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceApi#deleteBrand");
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
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="getBrand"></a>
# **getBrand**
> Brand getBrand(brandId)

Get Brand

Retrieve a single brand via ID

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceApi apiInstance = new BrandingServiceApi(defaultClient);
    Integer brandId = 9; // Integer | Unique identifier for the branding object.
    try {
      Brand result = apiInstance.getBrand(brandId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceApi#getBrand");
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

### Return type

[**Brand**](Brand.md)

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

<a id="getBrandApps"></a>
# **getBrandApps**
> List&lt;BrandApp&gt; getBrandApps(brandId)

Get Brand Apps

Get Apps Associated with Account Brand

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceApi apiInstance = new BrandingServiceApi(defaultClient);
    Integer brandId = 9; // Integer | Unique identifier for the branding object.
    try {
      List<BrandApp> result = apiInstance.getBrandApps(brandId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceApi#getBrandApps");
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

### Return type

[**List&lt;BrandApp&gt;**](BrandApp.md)

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

<a id="listBrands"></a>
# **listBrands**
> List&lt;BrandReq&gt; listBrands()

List Account Brands

List Account Brands

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceApi apiInstance = new BrandingServiceApi(defaultClient);
    try {
      List<BrandReq> result = apiInstance.listBrands();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceApi#listBrands");
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

[**List&lt;BrandReq&gt;**](BrandReq.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |

<a id="updateBrand"></a>
# **updateBrand**
> Brand updateBrand(brandId, requestBrand)

Update Brand

Update Account Brand

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.BrandingServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    BrandingServiceApi apiInstance = new BrandingServiceApi(defaultClient);
    Integer brandId = 9; // Integer | Unique identifier for the branding object.
    RequestBrand requestBrand = new RequestBrand(); // RequestBrand | 
    try {
      Brand result = apiInstance.updateBrand(brandId, requestBrand);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BrandingServiceApi#updateBrand");
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
| **requestBrand** | [**RequestBrand**](RequestBrand.md)|  | [optional] |

### Return type

[**Brand**](Brand.md)

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
| **422** | Unprocessable Entity |  -  |

