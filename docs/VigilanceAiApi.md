# VigilanceAiApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createRiskRule**](VigilanceAiApi.md#createRiskRule) | **POST** /api/2/risk/rules | Create Rule |
| [**deleteRiskRule**](VigilanceAiApi.md#deleteRiskRule) | **DELETE** /api/2/risk/rules/{rule_id} | Delete Rule |
| [**getRiskRule**](VigilanceAiApi.md#getRiskRule) | **GET** /api/2/risk/rules/{rule_id} | get Risk Rule |
| [**getRiskScore**](VigilanceAiApi.md#getRiskScore) | **POST** /api/2/risk/verify | Get a Risk Score |
| [**getRiskScores**](VigilanceAiApi.md#getRiskScores) | **GET** /api/2/risk/scores | Get Score Summary |
| [**listRiskRules**](VigilanceAiApi.md#listRiskRules) | **GET** /api/2/risk/rules | List Rules |
| [**trackRiskEvent**](VigilanceAiApi.md#trackRiskEvent) | **POST** /api/2/risk/events | Track an Event |
| [**updateRiskRule**](VigilanceAiApi.md#updateRiskRule) | **PUT** /api/2/risk/rules/{rule_id} | Update Rule |


<a id="createRiskRule"></a>
# **createRiskRule**
> RiskRule createRiskRule(riskRule)

Create Rule

Create Vigilance AI (Risk Service) Rule

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.VigilanceAiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    VigilanceAiApi apiInstance = new VigilanceAiApi(defaultClient);
    RiskRule riskRule = new RiskRule(); // RiskRule | 
    try {
      RiskRule result = apiInstance.createRiskRule(riskRule);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VigilanceAiApi#createRiskRule");
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
| **riskRule** | [**RiskRule**](RiskRule.md)|  | [optional] |

### Return type

[**RiskRule**](RiskRule.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |

<a id="deleteRiskRule"></a>
# **deleteRiskRule**
> deleteRiskRule(ruleId)

Delete Rule

Delete Vigilance AI (Risk Service)

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.VigilanceAiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    VigilanceAiApi apiInstance = new VigilanceAiApi(defaultClient);
    String ruleId = "ruleId_example"; // String | 
    try {
      apiInstance.deleteRiskRule(ruleId);
    } catch (ApiException e) {
      System.err.println("Exception when calling VigilanceAiApi#deleteRiskRule");
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
| **204** | Successful response |  -  |
| **401** | Unauthorized |  -  |

<a id="getRiskRule"></a>
# **getRiskRule**
> RiskRule getRiskRule(ruleId)

get Risk Rule

Use this API to return a single rule that has been created in the Risk Sevice.

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.VigilanceAiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    VigilanceAiApi apiInstance = new VigilanceAiApi(defaultClient);
    String ruleId = "ruleId_example"; // String | 
    try {
      RiskRule result = apiInstance.getRiskRule(ruleId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VigilanceAiApi#getRiskRule");
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
| **ruleId** | **String**|  | |

### Return type

[**RiskRule**](RiskRule.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **401** | Unauthorized |  -  |

<a id="getRiskScore"></a>
# **getRiskScore**
> GetRiskScore200Response getRiskScore(getRiskScoreRequest, before, after)

Get a Risk Score

Get Vigilance AI (Risk Service) Score

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.VigilanceAiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    VigilanceAiApi apiInstance = new VigilanceAiApi(defaultClient);
    GetRiskScoreRequest getRiskScoreRequest = new GetRiskScoreRequest(); // GetRiskScoreRequest | 
    String before = "before_example"; // String | Optional ISO8601 formatted date string. Defaults to current date. Maximum date is 90 days ago.
    String after = "after_example"; // String | Optional ISO8601 formatted date string. Defaults to 30 days ago. Maximum date is 90 days ago.
    try {
      GetRiskScore200Response result = apiInstance.getRiskScore(getRiskScoreRequest, before, after);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VigilanceAiApi#getRiskScore");
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
| **getRiskScoreRequest** | [**GetRiskScoreRequest**](GetRiskScoreRequest.md)|  | |
| **before** | **String**| Optional ISO8601 formatted date string. Defaults to current date. Maximum date is 90 days ago. | [optional] |
| **after** | **String**| Optional ISO8601 formatted date string. Defaults to 30 days ago. Maximum date is 90 days ago. | [optional] |

### Return type

[**GetRiskScore200Response**](GetRiskScore200Response.md)

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

<a id="getRiskScores"></a>
# **getRiskScores**
> GetRiskScores200Response getRiskScores()

Get Score Summary

Get Vigilance AI (Risk Service) Score Summary

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.VigilanceAiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    VigilanceAiApi apiInstance = new VigilanceAiApi(defaultClient);
    try {
      GetRiskScores200Response result = apiInstance.getRiskScores();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VigilanceAiApi#getRiskScores");
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

[**GetRiskScores200Response**](GetRiskScores200Response.md)

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

<a id="listRiskRules"></a>
# **listRiskRules**
> List&lt;RiskRule&gt; listRiskRules()

List Rules

List Vigilance AI (Risk Service) Rules

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.VigilanceAiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    VigilanceAiApi apiInstance = new VigilanceAiApi(defaultClient);
    try {
      List<RiskRule> result = apiInstance.listRiskRules();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VigilanceAiApi#listRiskRules");
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

[**List&lt;RiskRule&gt;**](RiskRule.md)

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

<a id="trackRiskEvent"></a>
# **trackRiskEvent**
> trackRiskEvent(trackRiskEventRequest)

Track an Event

Track Vigilance AI (Risk Service) Event

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.VigilanceAiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    VigilanceAiApi apiInstance = new VigilanceAiApi(defaultClient);
    TrackRiskEventRequest trackRiskEventRequest = new TrackRiskEventRequest(); // TrackRiskEventRequest | 
    try {
      apiInstance.trackRiskEvent(trackRiskEventRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling VigilanceAiApi#trackRiskEvent");
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
| **trackRiskEventRequest** | [**TrackRiskEventRequest**](TrackRiskEventRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | No content is returned. This API is fire and forget. |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |

<a id="updateRiskRule"></a>
# **updateRiskRule**
> RiskRule updateRiskRule(ruleId, updateRiskRuleRequest)

Update Rule

Update Vigilance AI (Risk Service) Rule

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.VigilanceAiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    VigilanceAiApi apiInstance = new VigilanceAiApi(defaultClient);
    String ruleId = "ruleId_example"; // String | 
    UpdateRiskRuleRequest updateRiskRuleRequest = new UpdateRiskRuleRequest(); // UpdateRiskRuleRequest | 
    try {
      RiskRule result = apiInstance.updateRiskRule(ruleId, updateRiskRuleRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling VigilanceAiApi#updateRiskRule");
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
| **ruleId** | **String**|  | |
| **updateRiskRuleRequest** | [**UpdateRiskRuleRequest**](UpdateRiskRuleRequest.md)|  | [optional] |

### Return type

[**RiskRule**](RiskRule.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Response |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |

