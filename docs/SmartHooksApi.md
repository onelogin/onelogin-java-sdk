# SmartHooksApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createEnvironmentVariable**](SmartHooksApi.md#createEnvironmentVariable) | **POST** /api/2/hooks/envs | Create Environment Variable |
| [**createHook**](SmartHooksApi.md#createHook) | **POST** /api/2/hooks | Create Smart Hook |
| [**deleteEnvironmentVariable**](SmartHooksApi.md#deleteEnvironmentVariable) | **DELETE** /api/2/hooks/envs/{envvar_id} | Delete Environment Variable |
| [**deleteHook**](SmartHooksApi.md#deleteHook) | **DELETE** /api/2/hooks/{hook_id} | Delete Smart Hook by ID |
| [**getEnvironmentVariable**](SmartHooksApi.md#getEnvironmentVariable) | **GET** /api/2/hooks/envs/{envvar_id} | Get Environment Variable |
| [**getHook**](SmartHooksApi.md#getHook) | **GET** /api/2/hooks/{hook_id} | Get Smart Hook by ID |
| [**getLogs**](SmartHooksApi.md#getLogs) | **GET** /api/2/hooks/{hook_id}/logs | Get Smart Hook Logs |
| [**listEnvironmentVariables**](SmartHooksApi.md#listEnvironmentVariables) | **GET** /api/2/hooks/envs | List Environment Variables |
| [**listHooks**](SmartHooksApi.md#listHooks) | **GET** /api/2/hooks | List all Smart Hooks |
| [**updateEnvironmentVariable**](SmartHooksApi.md#updateEnvironmentVariable) | **PUT** /api/2/hooks/envs/{envvar_id} | Update Environment Variable |
| [**updateHook**](SmartHooksApi.md#updateHook) | **PUT** /api/2/hooks/{hook_id} | Update Smart Hook by ID |


<a name="createEnvironmentVariable"></a>
# **createEnvironmentVariable**
> HookEnvvar createEnvironmentVariable(hookEnvvar)

Create Environment Variable

Create Environment Variable

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.SmartHooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SmartHooksApi apiInstance = new SmartHooksApi(defaultClient);
    HookEnvvar hookEnvvar = new HookEnvvar(); // HookEnvvar | 
    try {
      HookEnvvar result = apiInstance.createEnvironmentVariable(hookEnvvar);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartHooksApi#createEnvironmentVariable");
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
| **hookEnvvar** | [**HookEnvvar**](HookEnvvar.md)|  | |

### Return type

[**HookEnvvar**](HookEnvvar.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unprocessable Entity |  -  |

<a name="createHook"></a>
# **createHook**
> Hook createHook(hook)

Create Smart Hook

Create Smart Hook

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.SmartHooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SmartHooksApi apiInstance = new SmartHooksApi(defaultClient);
    Hook hook = new Hook(); // Hook | 
    try {
      Hook result = apiInstance.createHook(hook);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartHooksApi#createHook");
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
| **hook** | [**Hook**](Hook.md)|  | |

### Return type

[**Hook**](Hook.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **401** | Unauthorized |  -  |
| **409** | Conflict |  -  |
| **422** | You function is not base64 encoded. |  -  |

<a name="deleteEnvironmentVariable"></a>
# **deleteEnvironmentVariable**
> deleteEnvironmentVariable(envvarId)

Delete Environment Variable

Delete Environment Variable

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.SmartHooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SmartHooksApi apiInstance = new SmartHooksApi(defaultClient);
    String envvarId = "envvarId_example"; // String | Set to the id of the Hook Environment Variable that you want to fetch.
    try {
      apiInstance.deleteEnvironmentVariable(envvarId);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartHooksApi#deleteEnvironmentVariable");
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
| **envvarId** | **String**| Set to the id of the Hook Environment Variable that you want to fetch. | |

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
| **204** | Success. The environment variable has been deleted. No content is returned. |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a name="deleteHook"></a>
# **deleteHook**
> deleteHook(hookId)

Delete Smart Hook by ID

Delete Smart Hook

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.SmartHooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SmartHooksApi apiInstance = new SmartHooksApi(defaultClient);
    String hookId = "hookId_example"; // String | Set to the id of the Hook that you want to return.
    try {
      apiInstance.deleteHook(hookId);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartHooksApi#deleteHook");
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
| **hookId** | **String**| Set to the id of the Hook that you want to return. | |

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
| **202** | Success. The hook function has been queued for deletion. This typically happens within seconds of making the request. |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a name="getEnvironmentVariable"></a>
# **getEnvironmentVariable**
> HookEnvvar getEnvironmentVariable(envvarId)

Get Environment Variable

Get Environment Variable

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.SmartHooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SmartHooksApi apiInstance = new SmartHooksApi(defaultClient);
    String envvarId = "envvarId_example"; // String | Set to the id of the Hook Environment Variable that you want to fetch.
    try {
      HookEnvvar result = apiInstance.getEnvironmentVariable(envvarId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartHooksApi#getEnvironmentVariable");
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
| **envvarId** | **String**| Set to the id of the Hook Environment Variable that you want to fetch. | |

### Return type

[**HookEnvvar**](HookEnvvar.md)

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

<a name="getHook"></a>
# **getHook**
> Hook getHook(hookId)

Get Smart Hook by ID

Get Smart Hook

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.SmartHooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SmartHooksApi apiInstance = new SmartHooksApi(defaultClient);
    String hookId = "hookId_example"; // String | Set to the id of the Hook that you want to return.
    try {
      Hook result = apiInstance.getHook(hookId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartHooksApi#getHook");
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
| **hookId** | **String**| Set to the id of the Hook that you want to return. | |

### Return type

[**Hook**](Hook.md)

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

<a name="getLogs"></a>
# **getLogs**
> List&lt;HookLog&gt; getLogs(hookId, limit, page, cursor, requestId, correlationId)

Get Smart Hook Logs

Get Smart Hook Logs

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.SmartHooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SmartHooksApi apiInstance = new SmartHooksApi(defaultClient);
    String hookId = "hookId_example"; // String | Set to the id of the Hook that you want to return.
    Integer limit = 56; // Integer | How many items to return at one time (max 100)
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String requestId = "requestId_example"; // String | Returns logs that contain this request_id.
    String correlationId = "correlationId_example"; // String | Returns logs that contain this correlation_id.
    try {
      List<HookLog> result = apiInstance.getLogs(hookId, limit, page, cursor, requestId, correlationId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartHooksApi#getLogs");
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
| **hookId** | **String**| Set to the id of the Hook that you want to return. | |
| **limit** | **Integer**| How many items to return at one time (max 100) | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **requestId** | **String**| Returns logs that contain this request_id. | [optional] |
| **correlationId** | **String**| Returns logs that contain this correlation_id. | [optional] |

### Return type

[**List&lt;HookLog&gt;**](HookLog.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a name="listEnvironmentVariables"></a>
# **listEnvironmentVariables**
> List&lt;HookEnvvar&gt; listEnvironmentVariables(limit, page, cursor)

List Environment Variables

List Environment Variables

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.SmartHooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SmartHooksApi apiInstance = new SmartHooksApi(defaultClient);
    Integer limit = 56; // Integer | How many items to return at one time (max 100)
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    try {
      List<HookEnvvar> result = apiInstance.listEnvironmentVariables(limit, page, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartHooksApi#listEnvironmentVariables");
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
| **limit** | **Integer**| How many items to return at one time (max 100) | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |

### Return type

[**List&lt;HookEnvvar&gt;**](HookEnvvar.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Unauthorized |  -  |

<a name="listHooks"></a>
# **listHooks**
> List&lt;Hook&gt; listHooks(limit, page, cursor)

List all Smart Hooks

List Smart Hooks

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.SmartHooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SmartHooksApi apiInstance = new SmartHooksApi(defaultClient);
    Integer limit = 56; // Integer | How many items to return at one time (max 100)
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    try {
      List<Hook> result = apiInstance.listHooks(limit, page, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartHooksApi#listHooks");
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
| **limit** | **Integer**| How many items to return at one time (max 100) | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |

### Return type

[**List&lt;Hook&gt;**](Hook.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Unauthorized |  -  |

<a name="updateEnvironmentVariable"></a>
# **updateEnvironmentVariable**
> HookEnvvar updateEnvironmentVariable(envvarId, updateEnvironmentVariableRequest)

Update Environment Variable

Update Environment Variable

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.SmartHooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SmartHooksApi apiInstance = new SmartHooksApi(defaultClient);
    String envvarId = "envvarId_example"; // String | Set to the id of the Hook Environment Variable that you want to fetch.
    UpdateEnvironmentVariableRequest updateEnvironmentVariableRequest = new UpdateEnvironmentVariableRequest(); // UpdateEnvironmentVariableRequest | 
    try {
      HookEnvvar result = apiInstance.updateEnvironmentVariable(envvarId, updateEnvironmentVariableRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartHooksApi#updateEnvironmentVariable");
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
| **envvarId** | **String**| Set to the id of the Hook Environment Variable that you want to fetch. | |
| **updateEnvironmentVariableRequest** | [**UpdateEnvironmentVariableRequest**](UpdateEnvironmentVariableRequest.md)|  | |

### Return type

[**HookEnvvar**](HookEnvvar.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unprocessable Entity |  -  |

<a name="updateHook"></a>
# **updateHook**
> Hook updateHook(hookId, hook)

Update Smart Hook by ID

Update Smart Hook

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.SmartHooksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    SmartHooksApi apiInstance = new SmartHooksApi(defaultClient);
    String hookId = "hookId_example"; // String | Set to the id of the Hook that you want to return.
    Hook hook = new Hook(); // Hook | 
    try {
      Hook result = apiInstance.updateHook(hookId, hook);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartHooksApi#updateHook");
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
| **hookId** | **String**| Set to the id of the Hook that you want to return. | |
| **hook** | [**Hook**](Hook.md)|  | |

### Return type

[**Hook**](Hook.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **422** | You function is not base64 encoded. |  -  |

