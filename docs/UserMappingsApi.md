# UserMappingsApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createMapping**](UserMappingsApi.md#createMapping) | **POST** /api/2/mappings | Create Mapping |
| [**deleteMapping**](UserMappingsApi.md#deleteMapping) | **DELETE** /api/2/mappings/{mapping_id} | Delete Mapping |
| [**getMapping**](UserMappingsApi.md#getMapping) | **GET** /api/2/mappings/{mapping_id} | Get Mapping |
| [**listMappingActionValues**](UserMappingsApi.md#listMappingActionValues) | **GET** /api/2/mappings/actions/{mapping_action_value}/values | List Actions Values |
| [**listMappingConditions**](UserMappingsApi.md#listMappingConditions) | **GET** /api/2/mappings/conditions | List Conditions |
| [**listMappingConditionsOperators**](UserMappingsApi.md#listMappingConditionsOperators) | **GET** /api/2/mappings/conditions/{mapping_condition_value}/operators | List Conditions Operators |
| [**listMappingContionValues**](UserMappingsApi.md#listMappingContionValues) | **GET** /api/2/mappings/conditions/{mapping_condition_value}/values | List Conditions Values |
| [**listMappings**](UserMappingsApi.md#listMappings) | **GET** /api/2/mappings | List Mappings |
| [**listMappingsActions**](UserMappingsApi.md#listMappingsActions) | **GET** /api/2/mappings/actions | List Actions |
| [**sortMappings**](UserMappingsApi.md#sortMappings) | **PUT** /api/2/mappings/sort | Bulk Sort |
| [**updateMapping**](UserMappingsApi.md#updateMapping) | **PUT** /api/2/mappings/{mapping_id} | Update Mapping |


<a name="createMapping"></a>
# **createMapping**
> List&lt;Mapping&gt; createMapping(contentType, mapping)

Create Mapping

Create Mapping

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UserMappingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UserMappingsApi apiInstance = new UserMappingsApi(defaultClient);
    String contentType = "application/json"; // String | 
    Mapping mapping = new Mapping(); // Mapping | 
    try {
      List<Mapping> result = apiInstance.createMapping(contentType, mapping);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserMappingsApi#createMapping");
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
| **mapping** | [**Mapping**](Mapping.md)|  | [optional] |

### Return type

[**List&lt;Mapping&gt;**](Mapping.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Successful response |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unprocessable |  -  |

<a name="deleteMapping"></a>
# **deleteMapping**
> deleteMapping(mappingId)

Delete Mapping

Delete Mapping

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UserMappingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UserMappingsApi apiInstance = new UserMappingsApi(defaultClient);
    Integer mappingId = 56; // Integer | The id of the user mapping to locate.
    try {
      apiInstance.deleteMapping(mappingId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserMappingsApi#deleteMapping");
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
| **mappingId** | **Integer**| The id of the user mapping to locate. | |

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

<a name="getMapping"></a>
# **getMapping**
> Mapping getMapping(mappingId)

Get Mapping

Get Mapping

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UserMappingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UserMappingsApi apiInstance = new UserMappingsApi(defaultClient);
    Integer mappingId = 56; // Integer | The id of the user mapping to locate.
    try {
      Mapping result = apiInstance.getMapping(mappingId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserMappingsApi#getMapping");
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
| **mappingId** | **Integer**| The id of the user mapping to locate. | |

### Return type

[**Mapping**](Mapping.md)

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

<a name="listMappingActionValues"></a>
# **listMappingActionValues**
> List&lt;ListMappingActionValues200ResponseInner&gt; listMappingActionValues(mappingActionValue)

List Actions Values

List Mappings&#39; Actions&#39; Values

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UserMappingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UserMappingsApi apiInstance = new UserMappingsApi(defaultClient);
    String mappingActionValue = "mappingActionValue_example"; // String | 
    try {
      List<ListMappingActionValues200ResponseInner> result = apiInstance.listMappingActionValues(mappingActionValue);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserMappingsApi#listMappingActionValues");
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
| **mappingActionValue** | **String**|  | |

### Return type

[**List&lt;ListMappingActionValues200ResponseInner&gt;**](ListMappingActionValues200ResponseInner.md)

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

<a name="listMappingConditions"></a>
# **listMappingConditions**
> ListMappingConditions200Response listMappingConditions()

List Conditions

List Mappings&#39; Conditions

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UserMappingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UserMappingsApi apiInstance = new UserMappingsApi(defaultClient);
    try {
      ListMappingConditions200Response result = apiInstance.listMappingConditions();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserMappingsApi#listMappingConditions");
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

[**ListMappingConditions200Response**](ListMappingConditions200Response.md)

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

<a name="listMappingConditionsOperators"></a>
# **listMappingConditionsOperators**
> List&lt;ListMappingConditionsOperators200ResponseInner&gt; listMappingConditionsOperators(mappingConditionValue)

List Conditions Operators

List Mappings&#39; Conditions&#39; Operators

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UserMappingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UserMappingsApi apiInstance = new UserMappingsApi(defaultClient);
    String mappingConditionValue = "mappingConditionValue_example"; // String | 
    try {
      List<ListMappingConditionsOperators200ResponseInner> result = apiInstance.listMappingConditionsOperators(mappingConditionValue);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserMappingsApi#listMappingConditionsOperators");
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
| **mappingConditionValue** | **String**|  | |

### Return type

[**List&lt;ListMappingConditionsOperators200ResponseInner&gt;**](ListMappingConditionsOperators200ResponseInner.md)

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

<a name="listMappingContionValues"></a>
# **listMappingContionValues**
> List&lt;ListMappingContionValues200ResponseInner&gt; listMappingContionValues(mappingConditionValue)

List Conditions Values

List Mappings&#39;  Conditions&#39; Values

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UserMappingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UserMappingsApi apiInstance = new UserMappingsApi(defaultClient);
    String mappingConditionValue = "mappingConditionValue_example"; // String | 
    try {
      List<ListMappingContionValues200ResponseInner> result = apiInstance.listMappingContionValues(mappingConditionValue);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserMappingsApi#listMappingContionValues");
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
| **mappingConditionValue** | **String**|  | |

### Return type

[**List&lt;ListMappingContionValues200ResponseInner&gt;**](ListMappingContionValues200ResponseInner.md)

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

<a name="listMappings"></a>
# **listMappings**
> List&lt;Mapping&gt; listMappings(enabled, hasCondition, hasConditionType, hasAction, hasActionType)

List Mappings

List Mappings

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UserMappingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UserMappingsApi apiInstance = new UserMappingsApi(defaultClient);
    Boolean enabled = true; // Boolean | Defaults to true. When set to `false` will return all disabled mappings.
    String hasCondition = "has_condition=has_role:123456"; // String | Filters Rules based on their Conditions. Values formatted as :, where name is the Condition to look for, and value is the value to find. Multiple filters can be declared by using a comma delimited list. Wildcards are supported in both the name and value fields. For example: Single filter. has_condition=has_role:123456 Multiple filters. has_condition=has_role:123456,status:1 Wildcard for conditions. has_condition=*:123456 Wildcard for condition values. has_condition=has_role:*
    String hasConditionType = "builtin"; // String | Filters Rules based on their Conditions. Values formatted as :, where name is the Condition to look for, and value is the value to find. Multiple filters can be declared by using a comma delimited list. Wildcards are supported in both the name and value fields. For example: Single filter. has_condition=has_role:123456 Multiple filters. has_condition=has_role:123456,status:1 Wildcard for conditions. has_condition=*:123456 Wildcard for condition values. has_condition=has_role:*
    String hasAction = "has_action=set_groups:123456,set_usertype:*"; // String | Filters Rules based on their Actions. Values formatted as :, where name is the Action to look for, and value is the value to find. Multiple filters can be declared by using a comma delimited list. Wildcards are supported in both the name and value fields. For example: Single filter. has_action=set_licenses:123456 Multiple filters. has_action=set_groups:123456,set_usertype:* Wildcard for actions. has_action=*:123456 Wildcard for action values. has_action=set_userprincipalname:*
    String hasActionType = "builtin"; // String | Filters Rules based on their action types. Allowed values are: builtin - actions that involve standard attributes custom - actions that involve custom attributes none - no actions are defined For example: Find Rules with no actions has_action_type=none
    try {
      List<Mapping> result = apiInstance.listMappings(enabled, hasCondition, hasConditionType, hasAction, hasActionType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserMappingsApi#listMappings");
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
| **enabled** | **Boolean**| Defaults to true. When set to &#x60;false&#x60; will return all disabled mappings. | [optional] [default to true] |
| **hasCondition** | **String**| Filters Rules based on their Conditions. Values formatted as :, where name is the Condition to look for, and value is the value to find. Multiple filters can be declared by using a comma delimited list. Wildcards are supported in both the name and value fields. For example: Single filter. has_condition&#x3D;has_role:123456 Multiple filters. has_condition&#x3D;has_role:123456,status:1 Wildcard for conditions. has_condition&#x3D;*:123456 Wildcard for condition values. has_condition&#x3D;has_role:* | [optional] |
| **hasConditionType** | **String**| Filters Rules based on their Conditions. Values formatted as :, where name is the Condition to look for, and value is the value to find. Multiple filters can be declared by using a comma delimited list. Wildcards are supported in both the name and value fields. For example: Single filter. has_condition&#x3D;has_role:123456 Multiple filters. has_condition&#x3D;has_role:123456,status:1 Wildcard for conditions. has_condition&#x3D;*:123456 Wildcard for condition values. has_condition&#x3D;has_role:* | [optional] [enum: builtin, custom, none] |
| **hasAction** | **String**| Filters Rules based on their Actions. Values formatted as :, where name is the Action to look for, and value is the value to find. Multiple filters can be declared by using a comma delimited list. Wildcards are supported in both the name and value fields. For example: Single filter. has_action&#x3D;set_licenses:123456 Multiple filters. has_action&#x3D;set_groups:123456,set_usertype:* Wildcard for actions. has_action&#x3D;*:123456 Wildcard for action values. has_action&#x3D;set_userprincipalname:* | [optional] |
| **hasActionType** | **String**| Filters Rules based on their action types. Allowed values are: builtin - actions that involve standard attributes custom - actions that involve custom attributes none - no actions are defined For example: Find Rules with no actions has_action_type&#x3D;none | [optional] [enum: builtin, custom, none] |

### Return type

[**List&lt;Mapping&gt;**](Mapping.md)

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

<a name="listMappingsActions"></a>
# **listMappingsActions**
> List&lt;ListMappingsActions200ResponseInner&gt; listMappingsActions()

List Actions

List Mappings&#39; Actions

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UserMappingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UserMappingsApi apiInstance = new UserMappingsApi(defaultClient);
    try {
      List<ListMappingsActions200ResponseInner> result = apiInstance.listMappingsActions();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserMappingsApi#listMappingsActions");
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

[**List&lt;ListMappingsActions200ResponseInner&gt;**](ListMappingsActions200ResponseInner.md)

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

<a name="sortMappings"></a>
# **sortMappings**
> List&lt;Integer&gt; sortMappings(requestBody)

Bulk Sort

Bulk Sort Mappings

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UserMappingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UserMappingsApi apiInstance = new UserMappingsApi(defaultClient);
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | 
    try {
      List<Integer> result = apiInstance.sortMappings(requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserMappingsApi#sortMappings");
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
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)|  | [optional] |

### Return type

**List&lt;Integer&gt;**

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
| **422** | Unprocessable |  -  |

<a name="updateMapping"></a>
# **updateMapping**
> Integer updateMapping(mappingId, contentType, body)

Update Mapping

Update Mapping

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UserMappingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UserMappingsApi apiInstance = new UserMappingsApi(defaultClient);
    Integer mappingId = 56; // Integer | The id of the user mapping to locate.
    String contentType = "application/json"; // String | 
    Object body = null; // Object | 
    try {
      Integer result = apiInstance.updateMapping(mappingId, contentType, body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserMappingsApi#updateMapping");
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
| **mappingId** | **Integer**| The id of the user mapping to locate. | |
| **contentType** | **String**|  | [optional] [default to application/json] |
| **body** | **Object**|  | [optional] |

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
| **422** | Unprocessable |  -  |

