# AppRulesApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createAppRule**](AppRulesApi.md#createAppRule) | **POST** /api/2/apps/{app_id}/rules |  |
| [**deleteRule**](AppRulesApi.md#deleteRule) | **DELETE** /api/2/apps/{app_id}/rules/{rule_id} | Delete Rule |
| [**getAppRule**](AppRulesApi.md#getAppRule) | **GET** /api/2/apps/{app_id}/rules/{rule_id} | Get Rule |
| [**listActionValies**](AppRulesApi.md#listActionValies) | **GET** /api/2/apps/{app_id}/rules/actions/{rule_action_value}/values | List Actions Values |
| [**listActions**](AppRulesApi.md#listActions) | **GET** /api/2/apps/{app_id}/rules/actions | List Actions |
| [**listAppRules**](AppRulesApi.md#listAppRules) | **GET** /api/2/apps/{app_id}/rules | List Rules |
| [**listConditionOperators**](AppRulesApi.md#listConditionOperators) | **GET** /api/2/apps/{app_id}/rules/conditions/{rule_condition_value}/operators | List Conditions Operators |
| [**listConditionValues**](AppRulesApi.md#listConditionValues) | **GET** /api/2/apps/{app_id}/rules/conditions/{rule_condition_value}/values | List Conditions Values |
| [**listConditions**](AppRulesApi.md#listConditions) | **GET** /api/2/apps/{app_id}/rules/conditions | List Conditions |
| [**sortAppRules**](AppRulesApi.md#sortAppRules) | **PUT** /api/2/apps/{app_id}/rules/sort | Bulk Sort |
| [**updateAppRule**](AppRulesApi.md#updateAppRule) | **PUT** /api/2/apps/{app_id}/rules/{rule_id} | Update Rule |


<a id="createAppRule"></a>
# **createAppRule**
> AppRule createAppRule(appId, appRule)



Create App Rule

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.AppRulesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    AppRulesApi apiInstance = new AppRulesApi(defaultClient);
    Integer appId = 56; // Integer | 
    AppRule appRule = new AppRule(); // AppRule | 
    try {
      AppRule result = apiInstance.createAppRule(appId, appRule);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AppRulesApi#createAppRule");
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
| **appId** | **Integer**|  | |
| **appRule** | [**AppRule**](AppRule.md)|  | [optional] |

### Return type

[**AppRule**](AppRule.md)

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

<a id="deleteRule"></a>
# **deleteRule**
> deleteRule(appId, ruleId)

Delete Rule

Delete App Rule

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.AppRulesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    AppRulesApi apiInstance = new AppRulesApi(defaultClient);
    Integer appId = 56; // Integer | 
    String ruleId = "ruleId_example"; // String | 
    try {
      apiInstance.deleteRule(appId, ruleId);
    } catch (ApiException e) {
      System.err.println("Exception when calling AppRulesApi#deleteRule");
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
| **appId** | **Integer**|  | |
| **ruleId** | **String**|  | |

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
| **204** | Success. The rule is deleted. No content is returned. |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="getAppRule"></a>
# **getAppRule**
> AppRule getAppRule(appId, ruleId)

Get Rule

Get App Rule

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.AppRulesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    AppRulesApi apiInstance = new AppRulesApi(defaultClient);
    Integer appId = 56; // Integer | 
    String ruleId = "ruleId_example"; // String | 
    try {
      AppRule result = apiInstance.getAppRule(appId, ruleId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AppRulesApi#getAppRule");
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
| **appId** | **Integer**|  | |
| **ruleId** | **String**|  | |

### Return type

[**AppRule**](AppRule.md)

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

<a id="listActionValies"></a>
# **listActionValies**
> List&lt;RuleAction&gt; listActionValies(appId, ruleActionValue)

List Actions Values

Sort App rules

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.AppRulesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    AppRulesApi apiInstance = new AppRulesApi(defaultClient);
    Integer appId = 56; // Integer | 
    String ruleActionValue = "ruleActionValue_example"; // String | 
    try {
      List<RuleAction> result = apiInstance.listActionValies(appId, ruleActionValue);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AppRulesApi#listActionValies");
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
| **appId** | **Integer**|  | |
| **ruleActionValue** | **String**|  | |

### Return type

[**List&lt;RuleAction&gt;**](RuleAction.md)

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

<a id="listActions"></a>
# **listActions**
> List&lt;RuleAction&gt; listActions(appId)

List Actions

List Actions

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.AppRulesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    AppRulesApi apiInstance = new AppRulesApi(defaultClient);
    Integer appId = 56; // Integer | 
    try {
      List<RuleAction> result = apiInstance.listActions(appId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AppRulesApi#listActions");
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
| **appId** | **Integer**|  | |

### Return type

[**List&lt;RuleAction&gt;**](RuleAction.md)

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

<a id="listAppRules"></a>
# **listAppRules**
> List&lt;AppRule&gt; listAppRules(appId, hasCondition, hasConditionType, hasAction, hasActionType, enabled)

List Rules

List App Rules

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.AppRulesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    AppRulesApi apiInstance = new AppRulesApi(defaultClient);
    Integer appId = 56; // Integer | 
    String hasCondition = "has_condition=has_role:123456"; // String | Filters Rules based on their Conditions. Values formatted as :, where name is the Condition to look for, and value is the value to find. Multiple filters can be declared by using a comma delimited list. Wildcards are supported in both the name and value fields. For example: Single filter. has_condition=has_role:123456 Multiple filters. has_condition=has_role:123456,status:1 Wildcard for conditions. has_condition=*:123456 Wildcard for condition values. has_condition=has_role:*
    String hasConditionType = "builtin"; // String | Filters Rules based on their Conditions. Values formatted as :, where name is the Condition to look for, and value is the value to find. Multiple filters can be declared by using a comma delimited list. Wildcards are supported in both the name and value fields. For example: Single filter. has_condition=has_role:123456 Multiple filters. has_condition=has_role:123456,status:1 Wildcard for conditions. has_condition=*:123456 Wildcard for condition values. has_condition=has_role:*
    String hasAction = "has_action=set_groups:123456,set_usertype:*"; // String | Filters Rules based on their Actions. Values formatted as :, where name is the Action to look for, and value is the value to find. Multiple filters can be declared by using a comma delimited list. Wildcards are supported in both the name and value fields. For example: Single filter. has_action=set_licenses:123456 Multiple filters. has_action=set_groups:123456,set_usertype:* Wildcard for actions. has_action=*:123456 Wildcard for action values. has_action=set_userprincipalname:*
    String hasActionType = "builtin"; // String | Filters Rules based on their action types. Allowed values are: builtin - actions that involve standard attributes custom - actions that involve custom attributes none - no actions are defined For example: Find Rules with no actions has_action_type=none
    Boolean enabled = true; // Boolean | Defaults to true. When set to `false` will return all disabled mappings.
    try {
      List<AppRule> result = apiInstance.listAppRules(appId, hasCondition, hasConditionType, hasAction, hasActionType, enabled);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AppRulesApi#listAppRules");
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
| **appId** | **Integer**|  | |
| **hasCondition** | **String**| Filters Rules based on their Conditions. Values formatted as :, where name is the Condition to look for, and value is the value to find. Multiple filters can be declared by using a comma delimited list. Wildcards are supported in both the name and value fields. For example: Single filter. has_condition&#x3D;has_role:123456 Multiple filters. has_condition&#x3D;has_role:123456,status:1 Wildcard for conditions. has_condition&#x3D;*:123456 Wildcard for condition values. has_condition&#x3D;has_role:* | [optional] |
| **hasConditionType** | **String**| Filters Rules based on their Conditions. Values formatted as :, where name is the Condition to look for, and value is the value to find. Multiple filters can be declared by using a comma delimited list. Wildcards are supported in both the name and value fields. For example: Single filter. has_condition&#x3D;has_role:123456 Multiple filters. has_condition&#x3D;has_role:123456,status:1 Wildcard for conditions. has_condition&#x3D;*:123456 Wildcard for condition values. has_condition&#x3D;has_role:* | [optional] [enum: builtin, custom, none] |
| **hasAction** | **String**| Filters Rules based on their Actions. Values formatted as :, where name is the Action to look for, and value is the value to find. Multiple filters can be declared by using a comma delimited list. Wildcards are supported in both the name and value fields. For example: Single filter. has_action&#x3D;set_licenses:123456 Multiple filters. has_action&#x3D;set_groups:123456,set_usertype:* Wildcard for actions. has_action&#x3D;*:123456 Wildcard for action values. has_action&#x3D;set_userprincipalname:* | [optional] |
| **hasActionType** | **String**| Filters Rules based on their action types. Allowed values are: builtin - actions that involve standard attributes custom - actions that involve custom attributes none - no actions are defined For example: Find Rules with no actions has_action_type&#x3D;none | [optional] [enum: builtin, custom, none] |
| **enabled** | **Boolean**| Defaults to true. When set to &#x60;false&#x60; will return all disabled mappings. | [optional] [default to true] |

### Return type

[**List&lt;AppRule&gt;**](AppRule.md)

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

<a id="listConditionOperators"></a>
# **listConditionOperators**
> List&lt;RuleCondition&gt; listConditionOperators(appId, ruleConditionValue)

List Conditions Operators

List Condition Operators

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.AppRulesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    AppRulesApi apiInstance = new AppRulesApi(defaultClient);
    Integer appId = 56; // Integer | 
    String ruleConditionValue = "ruleConditionValue_example"; // String | 
    try {
      List<RuleCondition> result = apiInstance.listConditionOperators(appId, ruleConditionValue);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AppRulesApi#listConditionOperators");
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
| **appId** | **Integer**|  | |
| **ruleConditionValue** | **String**|  | |

### Return type

[**List&lt;RuleCondition&gt;**](RuleCondition.md)

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

<a id="listConditionValues"></a>
# **listConditionValues**
> RuleCondition listConditionValues(appId, ruleConditionValue)

List Conditions Values

List Condition Values

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.AppRulesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    AppRulesApi apiInstance = new AppRulesApi(defaultClient);
    Integer appId = 56; // Integer | 
    String ruleConditionValue = "ruleConditionValue_example"; // String | 
    try {
      RuleCondition result = apiInstance.listConditionValues(appId, ruleConditionValue);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AppRulesApi#listConditionValues");
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
| **appId** | **Integer**|  | |
| **ruleConditionValue** | **String**|  | |

### Return type

[**RuleCondition**](RuleCondition.md)

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

<a id="listConditions"></a>
# **listConditions**
> List&lt;ListConditions200ResponseInner&gt; listConditions(appId)

List Conditions

List App Conditions

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.AppRulesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    AppRulesApi apiInstance = new AppRulesApi(defaultClient);
    Integer appId = 56; // Integer | 
    try {
      List<ListConditions200ResponseInner> result = apiInstance.listConditions(appId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AppRulesApi#listConditions");
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
| **appId** | **Integer**|  | |

### Return type

[**List&lt;ListConditions200ResponseInner&gt;**](ListConditions200ResponseInner.md)

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

<a id="sortAppRules"></a>
# **sortAppRules**
> List&lt;Integer&gt; sortAppRules(appId, requestBody)

Bulk Sort

Sort App rules

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.AppRulesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    AppRulesApi apiInstance = new AppRulesApi(defaultClient);
    Integer appId = 56; // Integer | 
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | 
    try {
      List<Integer> result = apiInstance.sortAppRules(appId, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AppRulesApi#sortAppRules");
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
| **appId** | **Integer**|  | |
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
| **422** | Unprocessable Entity |  -  |

<a id="updateAppRule"></a>
# **updateAppRule**
> AppRule updateAppRule(appId, ruleId, appRule)

Update Rule

Update App Rule.

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.AppRulesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    AppRulesApi apiInstance = new AppRulesApi(defaultClient);
    Integer appId = 56; // Integer | 
    String ruleId = "ruleId_example"; // String | 
    AppRule appRule = new AppRule(); // AppRule | 
    try {
      AppRule result = apiInstance.updateAppRule(appId, ruleId, appRule);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AppRulesApi#updateAppRule");
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
| **appId** | **Integer**|  | |
| **ruleId** | **String**|  | |
| **appRule** | [**AppRule**](AppRule.md)|  | [optional] |

### Return type

[**AppRule**](AppRule.md)

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

