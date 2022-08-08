# DefaultApi

All URIs are relative to *https://onelogininc.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**activateFactor**](DefaultApi.md#activateFactor) | **POST** /api/2/mfa/users/{user_id}/verifications |  |
| [**addAccessTokenClaim**](DefaultApi.md#addAccessTokenClaim) | **POST** /api/2/api_authorizations/{id}/claims |  |
| [**addClientApp**](DefaultApi.md#addClientApp) | **POST** /api/2/api_authorizations/{id}/clients |  |
| [**addRoleAdmins**](DefaultApi.md#addRoleAdmins) | **POST** /api/2/roles/{role_id}/admins |  |
| [**addRoleUsers**](DefaultApi.md#addRoleUsers) | **POST** /api/2/roles/{role_id}/users |  |
| [**addScope**](DefaultApi.md#addScope) | **POST** /api/2/api_authorizations/{id}/scopes |  |
| [**bulkMappingSort**](DefaultApi.md#bulkMappingSort) | **PUT** /api/2/apps/mappings/sort |  |
| [**bulkSort**](DefaultApi.md#bulkSort) | **PUT** /api/2/apps/{app_id}/rules/sort |  |
| [**createApp**](DefaultApi.md#createApp) | **POST** /api/2/apps |  |
| [**createAuthorizationServer**](DefaultApi.md#createAuthorizationServer) | **POST** /api/2/api_authorizations |  |
| [**createEnvironmentVariable**](DefaultApi.md#createEnvironmentVariable) | **POST** /api/2/hooks/envs |  |
| [**createHook**](DefaultApi.md#createHook) | **POST** /api/2/hooks |  |
| [**createMapping**](DefaultApi.md#createMapping) | **POST** /api/2/mappings |  |
| [**createRiskRule**](DefaultApi.md#createRiskRule) | **POST** /api/2/risk/rules |  |
| [**createRoles**](DefaultApi.md#createRoles) | **POST** /api/2/roles |  |
| [**createRule**](DefaultApi.md#createRule) | **POST** /api/2/apps/{app_id}/rules |  |
| [**createUser**](DefaultApi.md#createUser) | **POST** /api/2/users |  |
| [**deleteAccessTokenClaim**](DefaultApi.md#deleteAccessTokenClaim) | **DELETE** /api/2/api_authorizations/{id}/claims/{claim_id} |  |
| [**deleteApp**](DefaultApi.md#deleteApp) | **DELETE** /api/2/apps/{app_id} |  |
| [**deleteAppParameter**](DefaultApi.md#deleteAppParameter) | **DELETE** /api/2/apps/{app_id}/parameters/{parameter_id} |  |
| [**deleteAuthorizationServer**](DefaultApi.md#deleteAuthorizationServer) | **DELETE** /api/2/api_authorizations/{id} |  |
| [**deleteEnvironmentVariable**](DefaultApi.md#deleteEnvironmentVariable) | **DELETE** /api/2/hooks/envs/{envvar_id} |  |
| [**deleteFactor**](DefaultApi.md#deleteFactor) | **DELETE** /api/2/mfa/users/{user_id}/devices/{device_id} |  |
| [**deleteHook**](DefaultApi.md#deleteHook) | **DELETE** /api/2/hooks/{hook_id} |  |
| [**deleteMapping**](DefaultApi.md#deleteMapping) | **DELETE** /api/2/mappings/{mapping_id} |  |
| [**deleteRiskRule**](DefaultApi.md#deleteRiskRule) | **DELETE** /api/2/risk/rules/{risk_rule_id} |  |
| [**deleteRole**](DefaultApi.md#deleteRole) | **DELETE** /api/2/roles/{role_id} |  |
| [**deleteRule**](DefaultApi.md#deleteRule) | **DELETE** /api/2/apps/{app_id}/rules/{rule_id} |  |
| [**deleteScope**](DefaultApi.md#deleteScope) | **DELETE** /api/2/api_authorizations/{id}/scopes/{scope_id} |  |
| [**deleteUser**](DefaultApi.md#deleteUser) | **DELETE** /api/2/users/{user_id} |  |
| [**dryRunMapping**](DefaultApi.md#dryRunMapping) | **POST** /api/2/mappings/{mapping_id}/dryrun |  |
| [**enrollFactor**](DefaultApi.md#enrollFactor) | **POST** /api/2/mfa/users/{user_id}/registrations |  |
| [**generateMfaToken**](DefaultApi.md#generateMfaToken) | **POST** /api/2/mfs/users/{user_id}/mfa_token |  |
| [**generateSamlAssertion**](DefaultApi.md#generateSamlAssertion) | **POST** /api/2/saml_assertion |  |
| [**generateToken**](DefaultApi.md#generateToken) | **POST** /auth/oauth2/v2/token |  |
| [**getApp**](DefaultApi.md#getApp) | **GET** /api/2/apps/{app_id} |  |
| [**getAuthorizationServer**](DefaultApi.md#getAuthorizationServer) | **GET** /api/2/api_authorizations/{id} |  |
| [**getAvailableFactors**](DefaultApi.md#getAvailableFactors) | **GET** /api/2/mfa/users/{user_id}/factors |  |
| [**getClientApps**](DefaultApi.md#getClientApps) | **GET** /api/2/api_authorizations/{id}/clients |  |
| [**getEnrolledFactors**](DefaultApi.md#getEnrolledFactors) | **GET** /api/2/mfa/users/{user_id}/devices |  |
| [**getEnvironmentVariable**](DefaultApi.md#getEnvironmentVariable) | **GET** /api/2/hooks/envs/{envvar_id} |  |
| [**getHook**](DefaultApi.md#getHook) | **GET** /api/2/hooks/{hook_id} |  |
| [**getLogs**](DefaultApi.md#getLogs) | **GET** /api/2/hooks/{hook_id}/logs |  |
| [**getMapping**](DefaultApi.md#getMapping) | **GET** /api/2/mappings/{mapping_id} |  |
| [**getRateLimit**](DefaultApi.md#getRateLimit) | **GET** /auth/rate_limit |  |
| [**getRiskRule**](DefaultApi.md#getRiskRule) | **GET** /api/2/risk/rules/{risk_rule_id} |  |
| [**getRiskScore**](DefaultApi.md#getRiskScore) | **POST** /api/2/risk/verify |  |
| [**getRole**](DefaultApi.md#getRole) | **GET** /api/2/roles/{role_id} |  |
| [**getRoleAdmins**](DefaultApi.md#getRoleAdmins) | **GET** /api/2/roles/{role_id}/admins |  |
| [**getRoleApps**](DefaultApi.md#getRoleApps) | **GET** /api/2/roles/{role_id}/apps |  |
| [**getRoleUsers**](DefaultApi.md#getRoleUsers) | **GET** /api/2/roles/{role_id}/users |  |
| [**getRule**](DefaultApi.md#getRule) | **GET** /api/2/apps/{app_id}/rules/{rule_id} |  |
| [**getScoreInsights**](DefaultApi.md#getScoreInsights) | **GET** /api/2/risk/scores |  |
| [**getUser**](DefaultApi.md#getUser) | **GET** /api/2/users/{user_id} |  |
| [**getUserApps**](DefaultApi.md#getUserApps) | **GET** /api/2/users/{user_id}/apps |  |
| [**listAccessTokenClaims**](DefaultApi.md#listAccessTokenClaims) | **GET** /api/2/api_authorizations/{id}/claims |  |
| [**listActionValues**](DefaultApi.md#listActionValues) | **GET** /api/2/apps/{app_id}/rules/actions/{actuion_value}/values |  |
| [**listActions**](DefaultApi.md#listActions) | **GET** /api/2/apps/{app_id}/rules/actions |  |
| [**listAppUsers**](DefaultApi.md#listAppUsers) | **GET** /api/2/apps/{app_id}/users |  |
| [**listApps**](DefaultApi.md#listApps) | **GET** /api/2/apps |  |
| [**listAuthorizationServers**](DefaultApi.md#listAuthorizationServers) | **GET** /api/2/api_authorizations |  |
| [**listConditionOperators**](DefaultApi.md#listConditionOperators) | **GET** /api/2/apps/{app_id}/rules/conditions/{condition_value}/operators |  |
| [**listConditionValues**](DefaultApi.md#listConditionValues) | **GET** /api/2/apps/{app_id}/rules/conditions/{condition_value}/values |  |
| [**listConditions**](DefaultApi.md#listConditions) | **GET** /api/2/apps/{app_id}/rules/conditions |  |
| [**listConnectors**](DefaultApi.md#listConnectors) | **GET** /api/2/connectors |  |
| [**listEnvironmentVariables**](DefaultApi.md#listEnvironmentVariables) | **GET** /api/2/hooks/envs |  |
| [**listHooks**](DefaultApi.md#listHooks) | **GET** /api/2/hooks |  |
| [**listMappingActionValues**](DefaultApi.md#listMappingActionValues) | **GET** /api/2/apps/mappings/actions/{actuion_value}/values |  |
| [**listMappingActions**](DefaultApi.md#listMappingActions) | **GET** /api/2/apps/mappings/actions |  |
| [**listMappingConditionOperators**](DefaultApi.md#listMappingConditionOperators) | **GET** /api/2/apps/mappings/conditions/{condition_value}/operators |  |
| [**listMappingConditionValues**](DefaultApi.md#listMappingConditionValues) | **GET** /api/2/apps/mappings/conditions/{condition_value}/values |  |
| [**listMappingConditions**](DefaultApi.md#listMappingConditions) | **GET** /api/2/apps/mappings/conditions |  |
| [**listMappings**](DefaultApi.md#listMappings) | **GET** /api/2/mappings |  |
| [**listRiskRules**](DefaultApi.md#listRiskRules) | **GET** /api/2/risk/rules |  |
| [**listRoles**](DefaultApi.md#listRoles) | **GET** /api/2/roles |  |
| [**listRules**](DefaultApi.md#listRules) | **GET** /api/2/apps/{app_id}/rules |  |
| [**listScopes**](DefaultApi.md#listScopes) | **GET** /api/2/api_authorizations/{id}/scopes |  |
| [**listUsers**](DefaultApi.md#listUsers) | **GET** /api/2/users |  |
| [**removeClientApp**](DefaultApi.md#removeClientApp) | **DELETE** /api/2/api_authorizations/{id}/clients/{client_app_id} |  |
| [**removeRoleAdmins**](DefaultApi.md#removeRoleAdmins) | **DELETE** /api/2/roles/{role_id}/admins |  |
| [**removeRoleUsers**](DefaultApi.md#removeRoleUsers) | **DELETE** /api/2/roles/{role_id}/users |  |
| [**revokeToken**](DefaultApi.md#revokeToken) | **POST** /auth/oauth2/revoke |  |
| [**setRoleApps**](DefaultApi.md#setRoleApps) | **PUT** /api/2/roles/{role_id}/apps |  |
| [**trackEvent**](DefaultApi.md#trackEvent) | **POST** /api/2/risk/events |  |
| [**updateAccessTokenClaim**](DefaultApi.md#updateAccessTokenClaim) | **PUT** /api/2/api_authorizations/{id}/claims/{claim_id} |  |
| [**updateApp**](DefaultApi.md#updateApp) | **PUT** /api/2/apps/{app_id} |  |
| [**updateAuthorizationServer**](DefaultApi.md#updateAuthorizationServer) | **PUT** /api/2/api_authorizations/{id} |  |
| [**updateClientApp**](DefaultApi.md#updateClientApp) | **PUT** /api/2/api_authorizations/{id}/clients/{client_app_id} |  |
| [**updateEnvironmentVariable**](DefaultApi.md#updateEnvironmentVariable) | **PUT** /api/2/hooks/envs/{envvar_id} |  |
| [**updateHook**](DefaultApi.md#updateHook) | **PUT** /api/2/hooks/{hook_id} |  |
| [**updateMapping**](DefaultApi.md#updateMapping) | **PUT** /api/2/mappings/{mapping_id} |  |
| [**updateRiskRule**](DefaultApi.md#updateRiskRule) | **PUT** /api/2/risk/rules/{risk_rule_id} |  |
| [**updateRole**](DefaultApi.md#updateRole) | **PUT** /api/2/roles/{role_id} |  |
| [**updateRule**](DefaultApi.md#updateRule) | **PUT** /api/2/apps/{app_id}/rules/{rule_id} |  |
| [**updateScope**](DefaultApi.md#updateScope) | **PUT** /api/2/api_authorizations/{id}/scopes/{scope_id} |  |
| [**updateUser**](DefaultApi.md#updateUser) | **PUT** /api/2/users/{user_id} |  |
| [**verifyEnrollment**](DefaultApi.md#verifyEnrollment) | **PUT** /api/2/mfa/users/{user_id}/registrations/{registration_id} |  |
| [**verifyEnrollmentVoiceProtect**](DefaultApi.md#verifyEnrollmentVoiceProtect) | **GET** /api/2/mfa/users/{user_id}/registrations/{registration_id} |  |
| [**verifyFactor**](DefaultApi.md#verifyFactor) | **PUT** /api/2/mfa/users/{user_id}/verifications/{verification_id} |  |
| [**verifyFactorSaml**](DefaultApi.md#verifyFactorSaml) | **POST** /api/2/saml_assertion/verify_factor |  |
| [**verifyFactorVoice**](DefaultApi.md#verifyFactorVoice) | **GET** /api/2/mfa/users/{user_id}/verifications/{verification_id} |  |


<a name="activateFactor"></a>
# **activateFactor**
> activateFactor(authorization, userId, activateFactorRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user.
    ActivateFactorRequest activateFactorRequest = new ActivateFactorRequest(); // ActivateFactorRequest | 
    try {
      apiInstance.activateFactor(authorization, userId, activateFactorRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#activateFactor");
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
| **authorization** | **String**|  | |
| **userId** | **Integer**| Set to the id of the user. | |
| **activateFactorRequest** | [**ActivateFactorRequest**](ActivateFactorRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="addAccessTokenClaim"></a>
# **addAccessTokenClaim**
> Id addAccessTokenClaim(authorization, id, addAccessTokenClaimRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    AddAccessTokenClaimRequest addAccessTokenClaimRequest = new AddAccessTokenClaimRequest(); // AddAccessTokenClaimRequest | 
    try {
      Id result = apiInstance.addAccessTokenClaim(authorization, id, addAccessTokenClaimRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#addAccessTokenClaim");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |
| **addAccessTokenClaimRequest** | [**AddAccessTokenClaimRequest**](AddAccessTokenClaimRequest.md)|  | |

### Return type

[**Id**](Id.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |
| **422** | This name already exists |  -  |

<a name="addClientApp"></a>
# **addClientApp**
> ClientApp addClientApp(authorization, id, addClientAppRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    AddClientAppRequest addClientAppRequest = new AddClientAppRequest(); // AddClientAppRequest | 
    try {
      ClientApp result = apiInstance.addClientApp(authorization, id, addClientAppRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#addClientApp");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |
| **addClientAppRequest** | [**AddClientAppRequest**](AddClientAppRequest.md)|  | |

### Return type

[**ClientApp**](ClientApp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |
| **422** | An invalid scope id has been provided |  -  |

<a name="addRoleAdmins"></a>
# **addRoleAdmins**
> List&lt;AddRoleUsers200ResponseInner&gt; addRoleAdmins(authorization, roleId, requestBody)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | 
    try {
      List<AddRoleUsers200ResponseInner> result = apiInstance.addRoleAdmins(authorization, roleId, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#addRoleAdmins");
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
| **authorization** | **String**|  | |
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)|  | |

### Return type

[**List&lt;AddRoleUsers200ResponseInner&gt;**](AddRoleUsers200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="addRoleUsers"></a>
# **addRoleUsers**
> List&lt;AddRoleUsers200ResponseInner&gt; addRoleUsers(authorization, roleId, requestBody)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | 
    try {
      List<AddRoleUsers200ResponseInner> result = apiInstance.addRoleUsers(authorization, roleId, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#addRoleUsers");
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
| **authorization** | **String**|  | |
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)|  | |

### Return type

[**List&lt;AddRoleUsers200ResponseInner&gt;**](AddRoleUsers200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | Indicates that the syntax of the request is good but a value supplied is not valid. |  -  |

<a name="addScope"></a>
# **addScope**
> Id addScope(authorization, id, addScopeRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    AddScopeRequest addScopeRequest = new AddScopeRequest(); // AddScopeRequest | 
    try {
      Id result = apiInstance.addScope(authorization, id, addScopeRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#addScope");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |
| **addScopeRequest** | [**AddScopeRequest**](AddScopeRequest.md)|  | |

### Return type

[**Id**](Id.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |
| **422** | This name already exists |  -  |

<a name="bulkMappingSort"></a>
# **bulkMappingSort**
> List&lt;Integer&gt; bulkMappingSort(authorization, requestBody)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | The request body must contain an array of User Mapping IDs in the desired order.
    try {
      List<Integer> result = apiInstance.bulkMappingSort(authorization, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#bulkMappingSort");
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
| **authorization** | **String**|  | |
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)| The request body must contain an array of User Mapping IDs in the desired order. | |

### Return type

**List&lt;Integer&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success a complete list of ordered mappings is returned. |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | Indicates that not all mapping IDs were included in the request. |  -  |

<a name="bulkSort"></a>
# **bulkSort**
> List&lt;Integer&gt; bulkSort(authorization, appId, requestBody)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | The request body must contain an array of App Rule IDs in the desired order.
    try {
      List<Integer> result = apiInstance.bulkSort(authorization, appId, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#bulkSort");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)| The request body must contain an array of App Rule IDs in the desired order. | |

### Return type

**List&lt;Integer&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | On success a complete list of ordered rules is returned. |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | Indicates that not all rule IDs were included in the request. |  -  |

<a name="createApp"></a>
# **createApp**
> Schema createApp(authorization, schema)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Schema schema = new Schema(); // Schema | 
    try {
      Schema result = apiInstance.createApp(authorization, schema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createApp");
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
| **authorization** | **String**|  | |
| **schema** | [**Schema**](Schema.md)|  | |

### Return type

[**Schema**](Schema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | Indicates that the syntax of the request is good but a value supplied is not valid. |  -  |

<a name="createAuthorizationServer"></a>
# **createAuthorizationServer**
> Id createAuthorizationServer(authorization, createAuthorizationServerRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    CreateAuthorizationServerRequest createAuthorizationServerRequest = new CreateAuthorizationServerRequest(); // CreateAuthorizationServerRequest | 
    try {
      Id result = apiInstance.createAuthorizationServer(authorization, createAuthorizationServerRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createAuthorizationServer");
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
| **authorization** | **String**|  | |
| **createAuthorizationServerRequest** | [**CreateAuthorizationServerRequest**](CreateAuthorizationServerRequest.md)|  | |

### Return type

[**Id**](Id.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | Audiences are required |  -  |

<a name="createEnvironmentVariable"></a>
# **createEnvironmentVariable**
> Envvar createEnvironmentVariable(authorization, createEnvironmentVariableRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    CreateEnvironmentVariableRequest createEnvironmentVariableRequest = new CreateEnvironmentVariableRequest(); // CreateEnvironmentVariableRequest | 
    try {
      Envvar result = apiInstance.createEnvironmentVariable(authorization, createEnvironmentVariableRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createEnvironmentVariable");
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
| **authorization** | **String**|  | |
| **createEnvironmentVariableRequest** | [**CreateEnvironmentVariableRequest**](CreateEnvironmentVariableRequest.md)|  | |

### Return type

[**Envvar**](Envvar.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | Indicates that the syntax of the request is good but a value supplied is not valid. |  -  |

<a name="createHook"></a>
# **createHook**
> createHook(authorization, hook)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Hook hook = new Hook(); // Hook | 
    try {
      apiInstance.createHook(authorization, hook);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createHook");
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
| **authorization** | **String**|  | |
| **hook** | [**Hook**](Hook.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


<a name="createMapping"></a>
# **createMapping**
> Integer createMapping(authorization, mapping)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Mapping mapping = new Mapping(); // Mapping | 
    try {
      Integer result = apiInstance.createMapping(authorization, mapping);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createMapping");
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
| **authorization** | **String**|  | |
| **mapping** | [**Mapping**](Mapping.md)|  | |

### Return type

**Integer**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | UNPROCESSABLE_ENTRY |  -  |

<a name="createRiskRule"></a>
# **createRiskRule**
> createRiskRule(authorization, riskRule)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    RiskRule riskRule = new RiskRule(); // RiskRule | 
    try {
      apiInstance.createRiskRule(authorization, riskRule);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createRiskRule");
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
| **authorization** | **String**|  | |
| **riskRule** | [**RiskRule**](RiskRule.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


<a name="createRoles"></a>
# **createRoles**
> List&lt;CreateRoles201ResponseInner&gt; createRoles(authorization)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    try {
      List<CreateRoles201ResponseInner> result = apiInstance.createRoles(authorization);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createRoles");
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
| **authorization** | **String**|  | |

### Return type

[**List&lt;CreateRoles201ResponseInner&gt;**](CreateRoles201ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="createRule"></a>
# **createRule**
> RuleId createRule(authorization, appId, rule)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    Rule rule = new Rule(); // Rule | 
    try {
      RuleId result = apiInstance.createRule(authorization, appId, rule);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createRule");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |
| **rule** | [**Rule**](Rule.md)|  | |

### Return type

[**RuleId**](RuleId.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | UNPROCESSABLE ENTRY |  -  |

<a name="createUser"></a>
# **createUser**
> User createUser(authorization, user, mappings, validatePolicy)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    User user = new User(); // User | 
    String mappings = "async"; // String | Controls how mappings will be applied to the user on creation. Defaults to async.
    Boolean validatePolicy = true; // Boolean | Will passwords validate against the User Policy? Defaults to true.
    try {
      User result = apiInstance.createUser(authorization, user, mappings, validatePolicy);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createUser");
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
| **authorization** | **String**|  | |
| **user** | [**User**](User.md)|  | |
| **mappings** | **String**| Controls how mappings will be applied to the user on creation. Defaults to async. | [optional] [enum: async, sync, disabled] |
| **validatePolicy** | **Boolean**| Will passwords validate against the User Policy? Defaults to true. | [optional] |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The full user resource is returned |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | Indicates that the syntax of the request is good but a value supplied is not valid. |  -  |

<a name="deleteAccessTokenClaim"></a>
# **deleteAccessTokenClaim**
> deleteAccessTokenClaim(authorization, id, claimId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    Integer claimId = 56; // Integer | 
    try {
      apiInstance.deleteAccessTokenClaim(authorization, id, claimId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteAccessTokenClaim");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |
| **claimId** | **Integer**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | NO CONTENT |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="deleteApp"></a>
# **deleteApp**
> deleteApp(authorization, appId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    try {
      apiInstance.deleteApp(authorization, appId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteApp");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | NO CONTENT |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="deleteAppParameter"></a>
# **deleteAppParameter**
> deleteAppParameter(authorization, appId, parameterId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    Integer parameterId = 56; // Integer | 
    try {
      apiInstance.deleteAppParameter(authorization, appId, parameterId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteAppParameter");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |
| **parameterId** | **Integer**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | NO CONTENT |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **403** | You attempted to delete a connector level parameter. |  -  |
| **404** | Invalid ID |  -  |

<a name="deleteAuthorizationServer"></a>
# **deleteAuthorizationServer**
> deleteAuthorizationServer(authorization, id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    try {
      apiInstance.deleteAuthorizationServer(authorization, id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteAuthorizationServer");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | NO CONTENT |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="deleteEnvironmentVariable"></a>
# **deleteEnvironmentVariable**
> deleteEnvironmentVariable(authorization, envvarId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    String envvarId = "envvarId_example"; // String | Set to the id of the Hook Environment Variable that you want to fetch.
    try {
      apiInstance.deleteEnvironmentVariable(authorization, envvarId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteEnvironmentVariable");
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
| **authorization** | **String**|  | |
| **envvarId** | **String**| Set to the id of the Hook Environment Variable that you want to fetch. | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Success. The environment variable has been deleted. No content is returned. |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="deleteFactor"></a>
# **deleteFactor**
> deleteFactor(authorization, userId, deviceId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user.
    Integer deviceId = 56; // Integer | Set to the device_id of the MFA device.
    try {
      apiInstance.deleteFactor(authorization, userId, deviceId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteFactor");
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
| **authorization** | **String**|  | |
| **userId** | **Integer**| Set to the id of the user. | |
| **deviceId** | **Integer**| Set to the device_id of the MFA device. | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | NO CONTENT |  -  |

<a name="deleteHook"></a>
# **deleteHook**
> deleteHook(authorization, hookId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    String hookId = "hookId_example"; // String | Set to the id of the Hook that you want to return.
    try {
      apiInstance.deleteHook(authorization, hookId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteHook");
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
| **authorization** | **String**|  | |
| **hookId** | **String**| Set to the id of the Hook that you want to return. | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Success. The hook function has been queued for deletion. This typically happens within seconds of making the request. |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="deleteMapping"></a>
# **deleteMapping**
> deleteMapping(authorization, mappingId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer mappingId = 56; // Integer | The id of the user mapping to locate.
    try {
      apiInstance.deleteMapping(authorization, mappingId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteMapping");
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
| **authorization** | **String**|  | |
| **mappingId** | **Integer**| The id of the user mapping to locate. | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | NO CONTENT |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="deleteRiskRule"></a>
# **deleteRiskRule**
> RiskRule deleteRiskRule(authorization, riskRuleId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    String riskRuleId = "riskRuleId_example"; // String | 
    try {
      RiskRule result = apiInstance.deleteRiskRule(authorization, riskRuleId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteRiskRule");
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
| **authorization** | **String**|  | |
| **riskRuleId** | **String**|  | |

### Return type

[**RiskRule**](RiskRule.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Invalid API Key |  -  |

<a name="deleteRole"></a>
# **deleteRole**
> deleteRole(authorization, roleId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    try {
      apiInstance.deleteRole(authorization, roleId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteRole");
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
| **authorization** | **String**|  | |
| **roleId** | **Integer**| Set to the id of the role you want to return. | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | NO CONTENT |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="deleteRule"></a>
# **deleteRule**
> deleteRule(authorization, appId, ruleId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    Integer ruleId = 56; // Integer | The id of the app rule to locate.
    try {
      apiInstance.deleteRule(authorization, appId, ruleId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteRule");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |
| **ruleId** | **Integer**| The id of the app rule to locate. | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | NO CONTENT |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="deleteScope"></a>
# **deleteScope**
> deleteScope(authorization, id, scopeId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    Integer scopeId = 56; // Integer | 
    try {
      apiInstance.deleteScope(authorization, id, scopeId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteScope");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |
| **scopeId** | **Integer**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | NO CONTENT |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="deleteUser"></a>
# **deleteUser**
> deleteUser(authorization, userId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    try {
      apiInstance.deleteUser(authorization, userId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteUser");
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
| **authorization** | **String**|  | |
| **userId** | **Integer**| Set to the id of the user that you want to return. | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | On success, no content is returned in the response body. |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="dryRunMapping"></a>
# **dryRunMapping**
> List&lt;Object&gt; dryRunMapping(authorization, mappingId, requestBody)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer mappingId = 56; // Integer | The id of the user mapping to locate.
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | Request body is a list of user IDs tested against the mapping conditions to verify that the mapping would be applied
    try {
      List<Object> result = apiInstance.dryRunMapping(authorization, mappingId, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#dryRunMapping");
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
| **authorization** | **String**|  | |
| **mappingId** | **Integer**| The id of the user mapping to locate. | |
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)| Request body is a list of user IDs tested against the mapping conditions to verify that the mapping would be applied | |

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | UNPROCESSABLE_ENTRY |  -  |

<a name="enrollFactor"></a>
# **enrollFactor**
> List&lt;List&lt;FactorInner&gt;&gt; enrollFactor(authorization, userId, enrollFactorRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user.
    EnrollFactorRequest enrollFactorRequest = new EnrollFactorRequest(); // EnrollFactorRequest | 
    try {
      List<List<FactorInner>> result = apiInstance.enrollFactor(authorization, userId, enrollFactorRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#enrollFactor");
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
| **authorization** | **String**|  | |
| **userId** | **Integer**| Set to the id of the user. | |
| **enrollFactorRequest** | [**EnrollFactorRequest**](EnrollFactorRequest.md)|  | |

### Return type

[**List&lt;List&lt;FactorInner&gt;&gt;**](List.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **201** | CREATED |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="generateMfaToken"></a>
# **generateMfaToken**
> GenerateMfaToken200Response generateMfaToken(authorization, generateMfaTokenRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    GenerateMfaTokenRequest generateMfaTokenRequest = new GenerateMfaTokenRequest(); // GenerateMfaTokenRequest | 
    try {
      GenerateMfaToken200Response result = apiInstance.generateMfaToken(authorization, generateMfaTokenRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#generateMfaToken");
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
| **authorization** | **String**|  | |
| **generateMfaTokenRequest** | [**GenerateMfaTokenRequest**](GenerateMfaTokenRequest.md)|  | |

### Return type

[**GenerateMfaToken200Response**](GenerateMfaToken200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | The structure of the request payload is correct but it contains an invalid value. |  -  |

<a name="generateSamlAssertion"></a>
# **generateSamlAssertion**
> generateSamlAssertion(authorization, generateSamlAssertionRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    GenerateSamlAssertionRequest generateSamlAssertionRequest = new GenerateSamlAssertionRequest(); // GenerateSamlAssertionRequest | 
    try {
      apiInstance.generateSamlAssertion(authorization, generateSamlAssertionRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#generateSamlAssertion");
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
| **authorization** | **String**|  | |
| **generateSamlAssertionRequest** | [**GenerateSamlAssertionRequest**](GenerateSamlAssertionRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="generateToken"></a>
# **generateToken**
> GenerateToken200Response generateToken(authorization, generateTokenRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    GenerateTokenRequest generateTokenRequest = new GenerateTokenRequest(); // GenerateTokenRequest | 
    try {
      GenerateToken200Response result = apiInstance.generateToken(authorization, generateTokenRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#generateToken");
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
| **authorization** | **String**|  | |
| **generateTokenRequest** | [**GenerateTokenRequest**](GenerateTokenRequest.md)|  | |

### Return type

[**GenerateToken200Response**](GenerateToken200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Typically, either grant_type value is incorrect or Authorization header is incorrectly formatted. |  -  |
| **401** | Typically, this error means that your client_id and/or client_secret values are invalid. |  -  |
| **404** | Typically, this error means that you are using the incorrect method. Ensure that you are making a POST. |  -  |

<a name="getApp"></a>
# **getApp**
> Schema getApp(authorization, appId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    try {
      Schema result = apiInstance.getApp(authorization, appId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getApp");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |

### Return type

[**Schema**](Schema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="getAuthorizationServer"></a>
# **getAuthorizationServer**
> GetAuthorizationServer200Response getAuthorizationServer(authorization, id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    try {
      GetAuthorizationServer200Response result = apiInstance.getAuthorizationServer(authorization, id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getAuthorizationServer");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |

### Return type

[**GetAuthorizationServer200Response**](GetAuthorizationServer200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | NOT FOUND |  -  |

<a name="getAvailableFactors"></a>
# **getAvailableFactors**
> List&lt;GetAvailableFactors200ResponseInner&gt; getAvailableFactors(authorization, userId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user.
    try {
      List<GetAvailableFactors200ResponseInner> result = apiInstance.getAvailableFactors(authorization, userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getAvailableFactors");
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
| **authorization** | **String**|  | |
| **userId** | **Integer**| Set to the id of the user. | |

### Return type

[**List&lt;GetAvailableFactors200ResponseInner&gt;**](GetAvailableFactors200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="getClientApps"></a>
# **getClientApps**
> List&lt;GetClientApps200ResponseInner&gt; getClientApps(authorization, id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    try {
      List<GetClientApps200ResponseInner> result = apiInstance.getClientApps(authorization, id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getClientApps");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |

### Return type

[**List&lt;GetClientApps200ResponseInner&gt;**](GetClientApps200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="getEnrolledFactors"></a>
# **getEnrolledFactors**
> List&lt;Device&gt; getEnrolledFactors(authorization, userId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user.
    try {
      List<Device> result = apiInstance.getEnrolledFactors(authorization, userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getEnrolledFactors");
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
| **authorization** | **String**|  | |
| **userId** | **Integer**| Set to the id of the user. | |

### Return type

[**List&lt;Device&gt;**](Device.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="getEnvironmentVariable"></a>
# **getEnvironmentVariable**
> Envvar getEnvironmentVariable(authorization, envvarId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    String envvarId = "envvarId_example"; // String | Set to the id of the Hook Environment Variable that you want to fetch.
    try {
      Envvar result = apiInstance.getEnvironmentVariable(authorization, envvarId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getEnvironmentVariable");
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
| **authorization** | **String**|  | |
| **envvarId** | **String**| Set to the id of the Hook Environment Variable that you want to fetch. | |

### Return type

[**Envvar**](Envvar.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="getHook"></a>
# **getHook**
> Hook getHook(authorization, hookId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    String hookId = "hookId_example"; // String | Set to the id of the Hook that you want to return.
    try {
      Hook result = apiInstance.getHook(authorization, hookId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getHook");
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
| **authorization** | **String**|  | |
| **hookId** | **String**| Set to the id of the Hook that you want to return. | |

### Return type

[**Hook**](Hook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="getLogs"></a>
# **getLogs**
> List&lt;Log&gt; getLogs(authorization, hookId, limit, page, cursor, requestId, correlationId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    String hookId = "hookId_example"; // String | Set to the id of the Hook that you want to return.
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String requestId = "requestId_example"; // String | Returns logs that contain this request_id.
    String correlationId = "correlationId_example"; // String | Returns logs that contain this correlation_id.
    try {
      List<Log> result = apiInstance.getLogs(authorization, hookId, limit, page, cursor, requestId, correlationId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getLogs");
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
| **authorization** | **String**|  | |
| **hookId** | **String**| Set to the id of the Hook that you want to return. | |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **requestId** | **String**| Returns logs that contain this request_id. | [optional] |
| **correlationId** | **String**| Returns logs that contain this correlation_id. | [optional] |

### Return type

[**List&lt;Log&gt;**](Log.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="getMapping"></a>
# **getMapping**
> Mapping getMapping(authorization, mappingId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer mappingId = 56; // Integer | The id of the user mapping to locate.
    try {
      Mapping result = apiInstance.getMapping(authorization, mappingId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getMapping");
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
| **authorization** | **String**|  | |
| **mappingId** | **Integer**| The id of the user mapping to locate. | |

### Return type

[**Mapping**](Mapping.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="getRateLimit"></a>
# **getRateLimit**
> GetRateLimit200Response getRateLimit(authorization)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    try {
      GetRateLimit200Response result = apiInstance.getRateLimit(authorization);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getRateLimit");
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
| **authorization** | **String**|  | |

### Return type

[**GetRateLimit200Response**](GetRateLimit200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** |  |  -  |

<a name="getRiskRule"></a>
# **getRiskRule**
> getRiskRule(authorization, riskRuleId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    String riskRuleId = "riskRuleId_example"; // String | 
    try {
      apiInstance.getRiskRule(authorization, riskRuleId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getRiskRule");
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
| **authorization** | **String**|  | |
| **riskRuleId** | **String**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined


<a name="getRiskScore"></a>
# **getRiskScore**
> GetRiskScore200Response getRiskScore(authorization, getRiskScoreRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    GetRiskScoreRequest getRiskScoreRequest = new GetRiskScoreRequest(); // GetRiskScoreRequest | 
    try {
      GetRiskScore200Response result = apiInstance.getRiskScore(authorization, getRiskScoreRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getRiskScore");
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
| **authorization** | **String**|  | |
| **getRiskScoreRequest** | [**GetRiskScoreRequest**](GetRiskScoreRequest.md)|  | |

### Return type

[**GetRiskScore200Response**](GetRiskScore200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | Invalid API Key |  -  |

<a name="getRole"></a>
# **getRole**
> Role getRole(authorization, roleId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    try {
      Role result = apiInstance.getRole(authorization, roleId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getRole");
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
| **authorization** | **String**|  | |
| **roleId** | **Integer**| Set to the id of the role you want to return. | |

### Return type

[**Role**](Role.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="getRoleAdmins"></a>
# **getRoleAdmins**
> List&lt;Schema1&gt; getRoleAdmins(authorization, roleId, limit, page, cursor, name, includeUnassigned)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String name = "name_example"; // String | Allows you to filter on first name, last name, username, and email address.
    Boolean includeUnassigned = true; // Boolean | Optional. Defaults to false. Include users that aren’t assigned to the role.
    try {
      List<Schema1> result = apiInstance.getRoleAdmins(authorization, roleId, limit, page, cursor, name, includeUnassigned);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getRoleAdmins");
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
| **authorization** | **String**|  | |
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **name** | **String**| Allows you to filter on first name, last name, username, and email address. | [optional] |
| **includeUnassigned** | **Boolean**| Optional. Defaults to false. Include users that aren’t assigned to the role. | [optional] |

### Return type

[**List&lt;Schema1&gt;**](Schema1.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: applcation/json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="getRoleApps"></a>
# **getRoleApps**
> List&lt;Schema&gt; getRoleApps(authorization, roleId, limit, page, cursor, assigned)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    Boolean assigned = true; // Boolean | Optional. Defaults to true. Returns all apps not yet assigned to the role.
    try {
      List<Schema> result = apiInstance.getRoleApps(authorization, roleId, limit, page, cursor, assigned);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getRoleApps");
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
| **authorization** | **String**|  | |
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **assigned** | **Boolean**| Optional. Defaults to true. Returns all apps not yet assigned to the role. | [optional] |

### Return type

[**List&lt;Schema&gt;**](Schema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: applcation/json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="getRoleUsers"></a>
# **getRoleUsers**
> List&lt;Schema1&gt; getRoleUsers(authorization, roleId, limit, page, cursor, name, includeUnassigned)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String name = "name_example"; // String | Allows you to filter on first name, last name, username, and email address.
    Boolean includeUnassigned = true; // Boolean | Optional. Defaults to false. Include users that aren’t assigned to the role.
    try {
      List<Schema1> result = apiInstance.getRoleUsers(authorization, roleId, limit, page, cursor, name, includeUnassigned);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getRoleUsers");
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
| **authorization** | **String**|  | |
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **name** | **String**| Allows you to filter on first name, last name, username, and email address. | [optional] |
| **includeUnassigned** | **Boolean**| Optional. Defaults to false. Include users that aren’t assigned to the role. | [optional] |

### Return type

[**List&lt;Schema1&gt;**](Schema1.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: applcation/json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="getRule"></a>
# **getRule**
> Rule getRule(authorization, appId, ruleId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    Integer ruleId = 56; // Integer | The id of the app rule to locate.
    try {
      Rule result = apiInstance.getRule(authorization, appId, ruleId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getRule");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |
| **ruleId** | **Integer**| The id of the app rule to locate. | |

### Return type

[**Rule**](Rule.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="getScoreInsights"></a>
# **getScoreInsights**
> GetScoreInsights200Response getScoreInsights(authorization, before, after)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    String before = "before_example"; // String | Optional ISO8601 formatted date string. Defaults to current date. Maximum date is 90 days ago.
    String after = "after_example"; // String | Optional ISO8601 formatted date string. Defaults to 30 days ago. Maximum date is 90 days ago.
    try {
      GetScoreInsights200Response result = apiInstance.getScoreInsights(authorization, before, after);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getScoreInsights");
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
| **authorization** | **String**|  | |
| **before** | **String**| Optional ISO8601 formatted date string. Defaults to current date. Maximum date is 90 days ago. | [optional] |
| **after** | **String**| Optional ISO8601 formatted date string. Defaults to 30 days ago. Maximum date is 90 days ago. | [optional] |

### Return type

[**GetScoreInsights200Response**](GetScoreInsights200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Invalid Access Token |  -  |

<a name="getUser"></a>
# **getUser**
> User getUser(authorization, userId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    try {
      User result = apiInstance.getUser(authorization, userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getUser");
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
| **authorization** | **String**|  | |
| **userId** | **Integer**| Set to the id of the user that you want to return. | |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="getUserApps"></a>
# **getUserApps**
> List&lt;GetUserApps200ResponseInner&gt; getUserApps(authorization, userId, ignoreVisibility)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    Boolean ignoreVisibility = true; // Boolean | Defaults to `false`. When `true` will show all apps that are assigned to a user regardless of their portal visibility setting.
    try {
      List<GetUserApps200ResponseInner> result = apiInstance.getUserApps(authorization, userId, ignoreVisibility);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getUserApps");
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
| **authorization** | **String**|  | |
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **ignoreVisibility** | **Boolean**| Defaults to &#x60;false&#x60;. When &#x60;true&#x60; will show all apps that are assigned to a user regardless of their portal visibility setting. | [optional] |

### Return type

[**List&lt;GetUserApps200ResponseInner&gt;**](GetUserApps200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="listAccessTokenClaims"></a>
# **listAccessTokenClaims**
> List&lt;ListAccessTokenClaims200ResponseInner&gt; listAccessTokenClaims(authorization, id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    try {
      List<ListAccessTokenClaims200ResponseInner> result = apiInstance.listAccessTokenClaims(authorization, id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listAccessTokenClaims");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |

### Return type

[**List&lt;ListAccessTokenClaims200ResponseInner&gt;**](ListAccessTokenClaims200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="listActionValues"></a>
# **listActionValues**
> List&lt;ListConditionValues200ResponseInner&gt; listActionValues(authorization, appId, actionValue)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    String actionValue = "actionValue_example"; // String | The value for the selected action.
    try {
      List<ListConditionValues200ResponseInner> result = apiInstance.listActionValues(authorization, appId, actionValue);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listActionValues");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |
| **actionValue** | **String**| The value for the selected action. | |

### Return type

[**List&lt;ListConditionValues200ResponseInner&gt;**](ListConditionValues200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listActions"></a>
# **listActions**
> List&lt;ListActions200ResponseInner&gt; listActions(authorization, appId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    try {
      List<ListActions200ResponseInner> result = apiInstance.listActions(authorization, appId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listActions");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |

### Return type

[**List&lt;ListActions200ResponseInner&gt;**](ListActions200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listAppUsers"></a>
# **listAppUsers**
> List&lt;ListAppUsers200ResponseInner&gt; listAppUsers(authorization, appId, limit, page, cursor)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    try {
      List<ListAppUsers200ResponseInner> result = apiInstance.listAppUsers(authorization, appId, limit, page, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listAppUsers");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |

### Return type

[**List&lt;ListAppUsers200ResponseInner&gt;**](ListAppUsers200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listApps"></a>
# **listApps**
> List&lt;Schema&gt; listApps(authorization, limit, page, cursor, name, connectorId, authMethod)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String name = "name_example"; // String | The name or partial name of the app to search for. When using a partial name you must append a wildcard `*`
    Integer connectorId = 56; // Integer | Returns all apps based off a specific connector. See List Connectors for a complete list of Connector IDs.
    AuthMethod authMethod = AuthMethod.fromValue("0"); // AuthMethod | Returns all apps based of a given type.
    try {
      List<Schema> result = apiInstance.listApps(authorization, limit, page, cursor, name, connectorId, authMethod);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listApps");
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
| **authorization** | **String**|  | |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **name** | **String**| The name or partial name of the app to search for. When using a partial name you must append a wildcard &#x60;*&#x60; | [optional] |
| **connectorId** | **Integer**| Returns all apps based off a specific connector. See List Connectors for a complete list of Connector IDs. | [optional] |
| **authMethod** | [**AuthMethod**](.md)| Returns all apps based of a given type. | [optional] [enum: 0, 1, 2, 3, 4, 6, 7, 8] |

### Return type

[**List&lt;Schema&gt;**](Schema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | Indicates that the syntax of the request is good but a value supplied is not valid. |  -  |

<a name="listAuthorizationServers"></a>
# **listAuthorizationServers**
> List&lt;ListAuthorizationServers200ResponseInner&gt; listAuthorizationServers(authorization)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    try {
      List<ListAuthorizationServers200ResponseInner> result = apiInstance.listAuthorizationServers(authorization);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listAuthorizationServers");
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
| **authorization** | **String**|  | |

### Return type

[**List&lt;ListAuthorizationServers200ResponseInner&gt;**](ListAuthorizationServers200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listConditionOperators"></a>
# **listConditionOperators**
> List&lt;ListConditionOperators200ResponseInner&gt; listConditionOperators(authorization, appId, conditionValue)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    String conditionValue = "conditionValue_example"; // String | The value for the selected condition.
    try {
      List<ListConditionOperators200ResponseInner> result = apiInstance.listConditionOperators(authorization, appId, conditionValue);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listConditionOperators");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |
| **conditionValue** | **String**| The value for the selected condition. | |

### Return type

[**List&lt;ListConditionOperators200ResponseInner&gt;**](ListConditionOperators200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listConditionValues"></a>
# **listConditionValues**
> List&lt;ListConditionValues200ResponseInner&gt; listConditionValues(authorization, appId, conditionValue)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    String conditionValue = "conditionValue_example"; // String | The value for the selected condition.
    try {
      List<ListConditionValues200ResponseInner> result = apiInstance.listConditionValues(authorization, appId, conditionValue);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listConditionValues");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |
| **conditionValue** | **String**| The value for the selected condition. | |

### Return type

[**List&lt;ListConditionValues200ResponseInner&gt;**](ListConditionValues200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listConditions"></a>
# **listConditions**
> List&lt;ListConditions200ResponseInner&gt; listConditions(authorization, appId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    try {
      List<ListConditions200ResponseInner> result = apiInstance.listConditions(authorization, appId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listConditions");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |

### Return type

[**List&lt;ListConditions200ResponseInner&gt;**](ListConditions200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listConnectors"></a>
# **listConnectors**
> List&lt;Connector&gt; listConnectors(authorization, limit, page, cursor, name, authMethod)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String name = "name_example"; // String | The name or partial name of the connector to search for. When using a partial name you must append a wildcard `*`
    AuthMethod authMethod = AuthMethod.fromValue("0"); // AuthMethod | Returns all connectors of a given type.
    try {
      List<Connector> result = apiInstance.listConnectors(authorization, limit, page, cursor, name, authMethod);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listConnectors");
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
| **authorization** | **String**|  | |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **name** | **String**| The name or partial name of the connector to search for. When using a partial name you must append a wildcard &#x60;*&#x60; | [optional] |
| **authMethod** | [**AuthMethod**](.md)| Returns all connectors of a given type. | [optional] [enum: 0, 1, 2, 3, 4, 6, 7, 8] |

### Return type

[**List&lt;Connector&gt;**](Connector.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | Indicates that the syntax of the request is good but a value supplied is not valid. |  -  |

<a name="listEnvironmentVariables"></a>
# **listEnvironmentVariables**
> List&lt;Envvar&gt; listEnvironmentVariables(authorization, limit, page, cursor)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    try {
      List<Envvar> result = apiInstance.listEnvironmentVariables(authorization, limit, page, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listEnvironmentVariables");
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
| **authorization** | **String**|  | |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |

### Return type

[**List&lt;Envvar&gt;**](Envvar.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listHooks"></a>
# **listHooks**
> List&lt;Hook&gt; listHooks(authorization, limit, page, cursor)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    try {
      List<Hook> result = apiInstance.listHooks(authorization, limit, page, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listHooks");
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
| **authorization** | **String**|  | |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |

### Return type

[**List&lt;Hook&gt;**](Hook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listMappingActionValues"></a>
# **listMappingActionValues**
> List&lt;ListConditionValues200ResponseInner&gt; listMappingActionValues(authorization, actionValue)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    String actionValue = "actionValue_example"; // String | The value for the selected action.
    try {
      List<ListConditionValues200ResponseInner> result = apiInstance.listMappingActionValues(authorization, actionValue);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listMappingActionValues");
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
| **authorization** | **String**|  | |
| **actionValue** | **String**| The value for the selected action. | |

### Return type

[**List&lt;ListConditionValues200ResponseInner&gt;**](ListConditionValues200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listMappingActions"></a>
# **listMappingActions**
> List&lt;ListActions200ResponseInner&gt; listMappingActions(authorization)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    try {
      List<ListActions200ResponseInner> result = apiInstance.listMappingActions(authorization);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listMappingActions");
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
| **authorization** | **String**|  | |

### Return type

[**List&lt;ListActions200ResponseInner&gt;**](ListActions200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listMappingConditionOperators"></a>
# **listMappingConditionOperators**
> List&lt;ListMappingConditionOperators200ResponseInner&gt; listMappingConditionOperators(authorization, conditionValue)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    String conditionValue = "conditionValue_example"; // String | The value for the selected condition.
    try {
      List<ListMappingConditionOperators200ResponseInner> result = apiInstance.listMappingConditionOperators(authorization, conditionValue);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listMappingConditionOperators");
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
| **authorization** | **String**|  | |
| **conditionValue** | **String**| The value for the selected condition. | |

### Return type

[**List&lt;ListMappingConditionOperators200ResponseInner&gt;**](ListMappingConditionOperators200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listMappingConditionValues"></a>
# **listMappingConditionValues**
> List&lt;ListConditionValues200ResponseInner&gt; listMappingConditionValues(authorization, conditionValue)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    String conditionValue = "conditionValue_example"; // String | The value for the selected condition.
    try {
      List<ListConditionValues200ResponseInner> result = apiInstance.listMappingConditionValues(authorization, conditionValue);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listMappingConditionValues");
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
| **authorization** | **String**|  | |
| **conditionValue** | **String**| The value for the selected condition. | |

### Return type

[**List&lt;ListConditionValues200ResponseInner&gt;**](ListConditionValues200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listMappingConditions"></a>
# **listMappingConditions**
> List&lt;ListMappingConditions200ResponseInner&gt; listMappingConditions(authorization)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    try {
      List<ListMappingConditions200ResponseInner> result = apiInstance.listMappingConditions(authorization);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listMappingConditions");
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
| **authorization** | **String**|  | |

### Return type

[**List&lt;ListMappingConditions200ResponseInner&gt;**](ListMappingConditions200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listMappings"></a>
# **listMappings**
> List&lt;Mapping&gt; listMappings(authorization, enabled, hasCondition, hasConditionType, hasAction, hasActionType)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Boolean enabled = true; // Boolean | Defaults to true. When set to `false` will return all disabled mappings.
    String hasCondition = "has_condition=has_role:123456,status:1"; // String | Filters Mappings based on their Conditions.
    String hasConditionType = "builtin"; // String | Filters Mappings based on their condition types.
    String hasAction = "has_action=set_groups:123456,set_usertype:*"; // String | Filters Mappings based on their Actions.
    String hasActionType = "builtin"; // String | Filters Mappings based on their action types.
    try {
      List<Mapping> result = apiInstance.listMappings(authorization, enabled, hasCondition, hasConditionType, hasAction, hasActionType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listMappings");
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
| **authorization** | **String**|  | |
| **enabled** | **Boolean**| Defaults to true. When set to &#x60;false&#x60; will return all disabled mappings. | [optional] [default to true] |
| **hasCondition** | **String**| Filters Mappings based on their Conditions. | [optional] |
| **hasConditionType** | **String**| Filters Mappings based on their condition types. | [optional] [enum: builtin, custom, none] |
| **hasAction** | **String**| Filters Mappings based on their Actions. | [optional] |
| **hasActionType** | **String**| Filters Mappings based on their action types. | [optional] [enum: builtin, custom, none] |

### Return type

[**List&lt;Mapping&gt;**](Mapping.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listRiskRules"></a>
# **listRiskRules**
> listRiskRules(authorization)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    try {
      apiInstance.listRiskRules(authorization);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listRiskRules");
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
| **authorization** | **String**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined


<a name="listRoles"></a>
# **listRoles**
> List&lt;Role&gt; listRoles(authorization, limit, page, cursor, name, appId, fields)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String name = "name_example"; // String | Optional. Filters by role name.
    String appId = "appId_example"; // String | Optional. Returns roles that contain this app name.
    String fields = "apps"; // String | Optional. Comma delimited list of fields to return.
    try {
      List<Role> result = apiInstance.listRoles(authorization, limit, page, cursor, name, appId, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listRoles");
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
| **authorization** | **String**|  | |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **name** | **String**| Optional. Filters by role name. | [optional] |
| **appId** | **String**| Optional. Returns roles that contain this app name. | [optional] |
| **fields** | **String**| Optional. Comma delimited list of fields to return. | [optional] [enum: apps, users, admins] |

### Return type

[**List&lt;Role&gt;**](Role.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listRules"></a>
# **listRules**
> List&lt;Rule&gt; listRules(authorization, appId, enabled, hasCondition, hasConditionType, hasAction, hasActionType)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    Boolean enabled = true; // Boolean | Defaults to true. When set to `false` will return all disabled rules.
    String hasCondition = "hasCondition_example"; // String | Filters Rules based on their Conditions.
    String hasConditionType = "hasConditionType_example"; // String | Filters Rules based on their condition types.
    String hasAction = "hasAction_example"; // String | Filters Rules based on their Actions.
    String hasActionType = "hasActionType_example"; // String | Filters Rules based on their action types.
    try {
      List<Rule> result = apiInstance.listRules(authorization, appId, enabled, hasCondition, hasConditionType, hasAction, hasActionType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listRules");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |
| **enabled** | **Boolean**| Defaults to true. When set to &#x60;false&#x60; will return all disabled rules. | [optional] |
| **hasCondition** | **String**| Filters Rules based on their Conditions. | [optional] |
| **hasConditionType** | **String**| Filters Rules based on their condition types. | [optional] |
| **hasAction** | **String**| Filters Rules based on their Actions. | [optional] |
| **hasActionType** | **String**| Filters Rules based on their action types. | [optional] |

### Return type

[**List&lt;Rule&gt;**](Rule.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="listScopes"></a>
# **listScopes**
> List&lt;ListScopes200ResponseInner&gt; listScopes(authorization, id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    try {
      List<ListScopes200ResponseInner> result = apiInstance.listScopes(authorization, id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listScopes");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |

### Return type

[**List&lt;ListScopes200ResponseInner&gt;**](ListScopes200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="listUsers"></a>
# **listUsers**
> List&lt;User&gt; listUsers(authorization, limit, page, cursor, createdSince, createdUntil, updatedSince, updatedUntil, lastLoginSince, lastLoginUntil, firstname, lastname, email, username, samaccountname, directoryId, externalId, appId, userIds, customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket, fields)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String createdSince = "createdSince_example"; // String | An ISO8601 timestamp value that returns all users created after a given date & time.
    String createdUntil = "createdUntil_example"; // String | An ISO8601 timestamp value that returns all users created before a given date & time.
    String updatedSince = "updatedSince_example"; // String | An ISO8601 timestamp value that returns all users updated after a given date & time.
    String updatedUntil = "updatedUntil_example"; // String | An ISO8601 timestamp value that returns all users updated before a given date & time.
    String lastLoginSince = "lastLoginSince_example"; // String | An ISO8601 timestamp value that returns all users that logged in after a given date & time.
    String lastLoginUntil = "lastLoginUntil_example"; // String | 
    String firstname = "firstname_example"; // String | The first name of the user
    String lastname = "lastname_example"; // String | The last name of the user
    String email = "email_example"; // String | The email address of the user
    String username = "username_example"; // String | The username for the user
    String samaccountname = "samaccountname_example"; // String | The AD login name for the user
    String directoryId = "directoryId_example"; // String | The ID in OneLogin of the Directory that the user belongs to
    String externalId = "externalId_example"; // String | An external identifier that has been set on the user
    String appId = "appId_example"; // String | The ID of a OneLogin Application
    String userIds = "userIds_example"; // String | A comma separated list of OneLogin User IDs
    String customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket = "customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket_example"; // String | The short name of a custom attribute. Note that the attribute name is prefixed with custom_attributes.
    String fields = "fields_example"; // String | A comma separated list user attributes to return.
    try {
      List<User> result = apiInstance.listUsers(authorization, limit, page, cursor, createdSince, createdUntil, updatedSince, updatedUntil, lastLoginSince, lastLoginUntil, firstname, lastname, email, username, samaccountname, directoryId, externalId, appId, userIds, customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listUsers");
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
| **authorization** | **String**|  | |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **createdSince** | **String**| An ISO8601 timestamp value that returns all users created after a given date &amp; time. | [optional] |
| **createdUntil** | **String**| An ISO8601 timestamp value that returns all users created before a given date &amp; time. | [optional] |
| **updatedSince** | **String**| An ISO8601 timestamp value that returns all users updated after a given date &amp; time. | [optional] |
| **updatedUntil** | **String**| An ISO8601 timestamp value that returns all users updated before a given date &amp; time. | [optional] |
| **lastLoginSince** | **String**| An ISO8601 timestamp value that returns all users that logged in after a given date &amp; time. | [optional] |
| **lastLoginUntil** | **String**|  | [optional] |
| **firstname** | **String**| The first name of the user | [optional] |
| **lastname** | **String**| The last name of the user | [optional] |
| **email** | **String**| The email address of the user | [optional] |
| **username** | **String**| The username for the user | [optional] |
| **samaccountname** | **String**| The AD login name for the user | [optional] |
| **directoryId** | **String**| The ID in OneLogin of the Directory that the user belongs to | [optional] |
| **externalId** | **String**| An external identifier that has been set on the user | [optional] |
| **appId** | **String**| The ID of a OneLogin Application | [optional] |
| **userIds** | **String**| A comma separated list of OneLogin User IDs | [optional] |
| **customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket** | **String**| The short name of a custom attribute. Note that the attribute name is prefixed with custom_attributes. | [optional] |
| **fields** | **String**| A comma separated list user attributes to return. | [optional] |

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **400** | An invalid search parameter was used. |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | You cant sort on this field. |  -  |

<a name="removeClientApp"></a>
# **removeClientApp**
> removeClientApp(authorization, id, clientAppId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    Integer clientAppId = 56; // Integer | 
    try {
      apiInstance.removeClientApp(authorization, id, clientAppId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#removeClientApp");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |
| **clientAppId** | **Integer**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | NO CONTENT |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | Indicates that the syntax of the request is good but a value supplied is not valid. |  -  |

<a name="removeRoleAdmins"></a>
# **removeRoleAdmins**
> removeRoleAdmins(authorization, roleId, removeRoleUsersRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    RemoveRoleUsersRequest removeRoleUsersRequest = new RemoveRoleUsersRequest(); // RemoveRoleUsersRequest | 
    try {
      apiInstance.removeRoleAdmins(authorization, roleId, removeRoleUsersRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#removeRoleAdmins");
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
| **authorization** | **String**|  | |
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **removeRoleUsersRequest** | [**RemoveRoleUsersRequest**](RemoveRoleUsersRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | NO CONTENT |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="removeRoleUsers"></a>
# **removeRoleUsers**
> removeRoleUsers(authorization, roleId, removeRoleUsersRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    RemoveRoleUsersRequest removeRoleUsersRequest = new RemoveRoleUsersRequest(); // RemoveRoleUsersRequest | 
    try {
      apiInstance.removeRoleUsers(authorization, roleId, removeRoleUsersRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#removeRoleUsers");
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
| **authorization** | **String**|  | |
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **removeRoleUsersRequest** | [**RemoveRoleUsersRequest**](RemoveRoleUsersRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | NO CONTENT |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="revokeToken"></a>
# **revokeToken**
> GenerateToken400Response revokeToken(authorization, revokeTokenRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    RevokeTokenRequest revokeTokenRequest = new RevokeTokenRequest(); // RevokeTokenRequest | 
    try {
      GenerateToken400Response result = apiInstance.revokeToken(authorization, revokeTokenRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#revokeToken");
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
| **authorization** | **String**|  | |
| **revokeTokenRequest** | [**RevokeTokenRequest**](RevokeTokenRequest.md)|  | [optional] |

### Return type

[**GenerateToken400Response**](GenerateToken400Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Possibly, the Authorization header is incorrectly formatted. |  -  |
| **401** | Typically, this error means that your client_id and/or client_secret values are invalid. |  -  |
| **404** | Typically, this error means that you are using the incorrect method. Ensure that you are making a POST. |  -  |

<a name="setRoleApps"></a>
# **setRoleApps**
> List&lt;SetRoleApps200ResponseInner&gt; setRoleApps(authorization, roleId, requestBody)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | 
    try {
      List<SetRoleApps200ResponseInner> result = apiInstance.setRoleApps(authorization, roleId, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#setRoleApps");
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
| **authorization** | **String**|  | |
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)|  | |

### Return type

[**List&lt;SetRoleApps200ResponseInner&gt;**](SetRoleApps200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The response returns an array of app IDs sent in the request. |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="trackEvent"></a>
# **trackEvent**
> trackEvent(authorization, trackEventRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    TrackEventRequest trackEventRequest = new TrackEventRequest(); // TrackEventRequest | 
    try {
      apiInstance.trackEvent(authorization, trackEventRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#trackEvent");
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
| **authorization** | **String**|  | |
| **trackEventRequest** | [**TrackEventRequest**](TrackEventRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | No content is returned. This API is fire and forget. |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | Invalid API Key |  -  |

<a name="updateAccessTokenClaim"></a>
# **updateAccessTokenClaim**
> Id updateAccessTokenClaim(authorization, id, claimId, addAccessTokenClaimRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    Integer claimId = 56; // Integer | 
    AddAccessTokenClaimRequest addAccessTokenClaimRequest = new AddAccessTokenClaimRequest(); // AddAccessTokenClaimRequest | 
    try {
      Id result = apiInstance.updateAccessTokenClaim(authorization, id, claimId, addAccessTokenClaimRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateAccessTokenClaim");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |
| **claimId** | **Integer**|  | |
| **addAccessTokenClaimRequest** | [**AddAccessTokenClaimRequest**](AddAccessTokenClaimRequest.md)|  | |

### Return type

[**Id**](Id.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |
| **422** | This name already exists |  -  |

<a name="updateApp"></a>
# **updateApp**
> Schema updateApp(authorization, appId, schema)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    Schema schema = new Schema(); // Schema | 
    try {
      Schema result = apiInstance.updateApp(authorization, appId, schema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateApp");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |
| **schema** | [**Schema**](Schema.md)|  | |

### Return type

[**Schema**](Schema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | Indicates that the syntax of the request is good but a value supplied is not valid. |  -  |

<a name="updateAuthorizationServer"></a>
# **updateAuthorizationServer**
> Id updateAuthorizationServer(authorization, id, createAuthorizationServerRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    CreateAuthorizationServerRequest createAuthorizationServerRequest = new CreateAuthorizationServerRequest(); // CreateAuthorizationServerRequest | 
    try {
      Id result = apiInstance.updateAuthorizationServer(authorization, id, createAuthorizationServerRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateAuthorizationServer");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |
| **createAuthorizationServerRequest** | [**CreateAuthorizationServerRequest**](CreateAuthorizationServerRequest.md)|  | |

### Return type

[**Id**](Id.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | You need to submit all of the attributes |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | Indicates that the syntax of the request is good but a value supplied is not valid. |  -  |

<a name="updateClientApp"></a>
# **updateClientApp**
> ClientApp updateClientApp(authorization, id, clientAppId, updateClientAppRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    Integer clientAppId = 56; // Integer | 
    UpdateClientAppRequest updateClientAppRequest = new UpdateClientAppRequest(); // UpdateClientAppRequest | 
    try {
      ClientApp result = apiInstance.updateClientApp(authorization, id, clientAppId, updateClientAppRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateClientApp");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |
| **clientAppId** | **Integer**|  | |
| **updateClientAppRequest** | [**UpdateClientAppRequest**](UpdateClientAppRequest.md)|  | |

### Return type

[**ClientApp**](ClientApp.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |
| **422** | An invalid scope id has been provided |  -  |

<a name="updateEnvironmentVariable"></a>
# **updateEnvironmentVariable**
> Envvar updateEnvironmentVariable(authorization, envvarId, updateEnvironmentVariableRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    String envvarId = "envvarId_example"; // String | Set to the id of the Hook Environment Variable that you want to fetch.
    UpdateEnvironmentVariableRequest updateEnvironmentVariableRequest = new UpdateEnvironmentVariableRequest(); // UpdateEnvironmentVariableRequest | 
    try {
      Envvar result = apiInstance.updateEnvironmentVariable(authorization, envvarId, updateEnvironmentVariableRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateEnvironmentVariable");
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
| **authorization** | **String**|  | |
| **envvarId** | **String**| Set to the id of the Hook Environment Variable that you want to fetch. | |
| **updateEnvironmentVariableRequest** | [**UpdateEnvironmentVariableRequest**](UpdateEnvironmentVariableRequest.md)|  | |

### Return type

[**Envvar**](Envvar.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | The name of a var can not be changed |  -  |

<a name="updateHook"></a>
# **updateHook**
> Hook updateHook(authorization, hookId, hook)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    String hookId = "hookId_example"; // String | Set to the id of the Hook that you want to return.
    Hook hook = new Hook(); // Hook | 
    try {
      Hook result = apiInstance.updateHook(authorization, hookId, hook);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateHook");
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
| **authorization** | **String**|  | |
| **hookId** | **String**| Set to the id of the Hook that you want to return. | |
| **hook** | [**Hook**](Hook.md)|  | |

### Return type

[**Hook**](Hook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | You function is not base64 encoded. |  -  |

<a name="updateMapping"></a>
# **updateMapping**
> Integer updateMapping(authorization, mappingId, mapping)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer mappingId = 56; // Integer | The id of the user mapping to locate.
    Mapping mapping = new Mapping(); // Mapping | 
    try {
      Integer result = apiInstance.updateMapping(authorization, mappingId, mapping);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateMapping");
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
| **authorization** | **String**|  | |
| **mappingId** | **Integer**| The id of the user mapping to locate. | |
| **mapping** | [**Mapping**](Mapping.md)|  | |

### Return type

**Integer**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | UNPROCESSABLE_ENTRY |  -  |

<a name="updateRiskRule"></a>
# **updateRiskRule**
> RiskRule updateRiskRule(authorization, riskRuleId, riskRule)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    String riskRuleId = "riskRuleId_example"; // String | 
    RiskRule riskRule = new RiskRule(); // RiskRule | 
    try {
      RiskRule result = apiInstance.updateRiskRule(authorization, riskRuleId, riskRule);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateRiskRule");
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
| **authorization** | **String**|  | |
| **riskRuleId** | **String**|  | |
| **riskRule** | [**RiskRule**](RiskRule.md)|  | |

### Return type

[**RiskRule**](RiskRule.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | UNAUTHORIZED |  -  |

<a name="updateRole"></a>
# **updateRole**
> UpdateRole200Response updateRole(authorization, roleId, role)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    Role role = new Role(); // Role | 
    try {
      UpdateRole200Response result = apiInstance.updateRole(authorization, roleId, role);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateRole");
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
| **authorization** | **String**|  | |
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **role** | [**Role**](Role.md)|  | |

### Return type

[**UpdateRole200Response**](UpdateRole200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | Indicates that the syntax of the request is good but a value supplied is not valid. |  -  |

<a name="updateRule"></a>
# **updateRule**
> RuleId updateRule(authorization, appId, ruleId, rule)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer appId = 56; // Integer | 
    Integer ruleId = 56; // Integer | The id of the app rule to locate.
    Rule rule = new Rule(); // Rule | 
    try {
      RuleId result = apiInstance.updateRule(authorization, appId, ruleId, rule);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateRule");
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
| **authorization** | **String**|  | |
| **appId** | **Integer**|  | |
| **ruleId** | **Integer**| The id of the app rule to locate. | |
| **rule** | [**Rule**](Rule.md)|  | |

### Return type

[**RuleId**](RuleId.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | ID should not be included in the payload body. |  -  |

<a name="updateScope"></a>
# **updateScope**
> Id updateScope(authorization, id, scopeId, addScopeRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer id = 56; // Integer | 
    Integer scopeId = 56; // Integer | 
    AddScopeRequest addScopeRequest = new AddScopeRequest(); // AddScopeRequest | 
    try {
      Id result = apiInstance.updateScope(authorization, id, scopeId, addScopeRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateScope");
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
| **authorization** | **String**|  | |
| **id** | **Integer**|  | |
| **scopeId** | **Integer**|  | |
| **addScopeRequest** | [**AddScopeRequest**](AddScopeRequest.md)|  | |

### Return type

[**Id**](Id.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |
| **422** | This name already exists |  -  |

<a name="updateUser"></a>
# **updateUser**
> User updateUser(authorization, userId, user, mappings, validatePolicy)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    User user = new User(); // User | 
    String mappings = "async"; // String | Controls how mappings will be applied to the user on creation. Defaults to async.
    Boolean validatePolicy = true; // Boolean | Will passwords validate against the User Policy? Defaults to true.
    try {
      User result = apiInstance.updateUser(authorization, userId, user, mappings, validatePolicy);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateUser");
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
| **authorization** | **String**|  | |
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **user** | [**User**](User.md)|  | |
| **mappings** | **String**| Controls how mappings will be applied to the user on creation. Defaults to async. | [optional] [enum: async, sync, disabled] |
| **validatePolicy** | **Boolean**| Will passwords validate against the User Policy? Defaults to true. | [optional] |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The full user resource is returned |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |
| **422** | Indicates that the syntax of the request is good but a value supplied is not valid. |  -  |

<a name="verifyEnrollment"></a>
# **verifyEnrollment**
> List&lt;Registration&gt; verifyEnrollment(authorization, userId, registrationId, verifyEnrollmentRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user.
    Integer registrationId = 56; // Integer | Set to the uuid of the registration. This was included in the response as part of the initial request in Enroll Factor.
    VerifyEnrollmentRequest verifyEnrollmentRequest = new VerifyEnrollmentRequest(); // VerifyEnrollmentRequest | 
    try {
      List<Registration> result = apiInstance.verifyEnrollment(authorization, userId, registrationId, verifyEnrollmentRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#verifyEnrollment");
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
| **authorization** | **String**|  | |
| **userId** | **Integer**| Set to the id of the user. | |
| **registrationId** | **Integer**| Set to the uuid of the registration. This was included in the response as part of the initial request in Enroll Factor. | |
| **verifyEnrollmentRequest** | [**VerifyEnrollmentRequest**](VerifyEnrollmentRequest.md)|  | |

### Return type

[**List&lt;Registration&gt;**](Registration.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="verifyEnrollmentVoiceProtect"></a>
# **verifyEnrollmentVoiceProtect**
> List&lt;Registration&gt; verifyEnrollmentVoiceProtect(authorization, userId, registrationId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user.
    Integer registrationId = 56; // Integer | Set to the uuid of the registration. This was included in the response as part of the initial request in Enroll Factor.
    try {
      List<Registration> result = apiInstance.verifyEnrollmentVoiceProtect(authorization, userId, registrationId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#verifyEnrollmentVoiceProtect");
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
| **authorization** | **String**|  | |
| **userId** | **Integer**| Set to the id of the user. | |
| **registrationId** | **Integer**| Set to the uuid of the registration. This was included in the response as part of the initial request in Enroll Factor. | |

### Return type

[**List&lt;Registration&gt;**](Registration.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="verifyFactor"></a>
# **verifyFactor**
> Status2 verifyFactor(authorization, userId, verificationId, verifyFactorRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user.
    Integer verificationId = 56; // Integer | The verification_id is returned on activation of the factor or you can get the device_id using the Activate Factor API call.
    VerifyFactorRequest verifyFactorRequest = new VerifyFactorRequest(); // VerifyFactorRequest | 
    try {
      Status2 result = apiInstance.verifyFactor(authorization, userId, verificationId, verifyFactorRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#verifyFactor");
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
| **authorization** | **String**|  | |
| **userId** | **Integer**| Set to the id of the user. | |
| **verificationId** | **Integer**| The verification_id is returned on activation of the factor or you can get the device_id using the Activate Factor API call. | |
| **verifyFactorRequest** | [**VerifyFactorRequest**](VerifyFactorRequest.md)|  | |

### Return type

[**Status2**](Status2.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **403** | FORBIDDEN |  -  |

<a name="verifyFactorSaml"></a>
# **verifyFactorSaml**
> VerifyFactorSaml200Response verifyFactorSaml(authorization, verifyFactorSamlRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    VerifyFactorSamlRequest verifyFactorSamlRequest = new VerifyFactorSamlRequest(); // VerifyFactorSamlRequest | 
    try {
      VerifyFactorSaml200Response result = apiInstance.verifyFactorSaml(authorization, verifyFactorSamlRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#verifyFactorSaml");
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
| **authorization** | **String**|  | |
| **verifyFactorSamlRequest** | [**VerifyFactorSamlRequest**](VerifyFactorSamlRequest.md)|  | |

### Return type

[**VerifyFactorSaml200Response**](VerifyFactorSaml200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | UNAUTHORIZED |  -  |
| **404** | Invalid ID |  -  |

<a name="verifyFactorVoice"></a>
# **verifyFactorVoice**
> List&lt;VerifyFactorVoice200ResponseInner&gt; verifyFactorVoice(authorization, userId, verificationId)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://onelogininc.onelogin.com");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user.
    Integer verificationId = 56; // Integer | The verification_id is returned on activation of the factor or you can get the device_id using the Activate Factor API call.
    try {
      List<VerifyFactorVoice200ResponseInner> result = apiInstance.verifyFactorVoice(authorization, userId, verificationId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#verifyFactorVoice");
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
| **authorization** | **String**|  | |
| **userId** | **Integer**| Set to the id of the user. | |
| **verificationId** | **Integer**| The verification_id is returned on activation of the factor or you can get the device_id using the Activate Factor API call. | |

### Return type

[**List&lt;VerifyFactorVoice200ResponseInner&gt;**](VerifyFactorVoice200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | NOT FOUND |  -  |
| **404** | Invalid ID |  -  |

