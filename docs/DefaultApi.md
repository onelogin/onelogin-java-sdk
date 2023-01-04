# DefaultApi

All URIs are relative to *https://api.us.onelogin.com*

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
| [**createSessionLoginToken**](DefaultApi.md#createSessionLoginToken) | **POST** /api/1/login/auth |  |
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
| [**getEventById**](DefaultApi.md#getEventById) | **GET** /api/1/events/{event_id} |  |
| [**getEventTypes**](DefaultApi.md#getEventTypes) | **GET** /api/1/events/types |  |
| [**getEvents**](DefaultApi.md#getEvents) | **GET** /api/1/events |  |
| [**getGroupById**](DefaultApi.md#getGroupById) | **GET** /api/1/groups/{group_id} |  |
| [**getGroups**](DefaultApi.md#getGroups) | **GET** /api/1/groups |  |
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
| [**listActionValues**](DefaultApi.md#listActionValues) | **GET** /api/2/apps/{app_id}/rules/actions/{action_value}/values |  |
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
| [**listMappingActionValues**](DefaultApi.md#listMappingActionValues) | **GET** /api/2/apps/mappings/actions/{action_value}/values |  |
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
| [**v1VerifyFactor**](DefaultApi.md#v1VerifyFactor) | **POST** /api/1/login/verify_factor |  |
| [**verifyEnrollment**](DefaultApi.md#verifyEnrollment) | **PUT** /api/2/mfa/users/{user_id}/registrations/{registration_id} |  |
| [**verifyEnrollmentVoiceProtect**](DefaultApi.md#verifyEnrollmentVoiceProtect) | **GET** /api/2/mfa/users/{user_id}/registrations/{registration_id} |  |
| [**verifyFactor**](DefaultApi.md#verifyFactor) | **PUT** /api/2/mfa/users/{user_id}/verifications/{verification_id} |  |
| [**verifyFactorSaml**](DefaultApi.md#verifyFactorSaml) | **POST** /api/2/saml_assertion/verify_factor |  |
| [**verifyFactorVoice**](DefaultApi.md#verifyFactorVoice) | **GET** /api/2/mfa/users/{user_id}/verifications/{verification_id} |  |


<a name="activateFactor"></a>
# **activateFactor**
> Status activateFactor(userId, activateFactorRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    ActivateFactorRequest activateFactorRequest = new ActivateFactorRequest(); // ActivateFactorRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Status result = apiInstance.activateFactor(userId, activateFactorRequest, authorization);
      System.out.println(result);
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
| **userId** | **Integer**| Set to the id of the user. | |
| **activateFactorRequest** | [**ActivateFactorRequest**](ActivateFactorRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Status**](Status.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Typically, this error means that your access token value is invalid. |  -  |

<a name="addAccessTokenClaim"></a>
# **addAccessTokenClaim**
> Id addAccessTokenClaim(id, addAccessTokenClaimRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    AddAccessTokenClaimRequest addAccessTokenClaimRequest = new AddAccessTokenClaimRequest(); // AddAccessTokenClaimRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Id result = apiInstance.addAccessTokenClaim(id, addAccessTokenClaimRequest, authorization);
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
| **id** | **Integer**|  | |
| **addAccessTokenClaimRequest** | [**AddAccessTokenClaimRequest**](AddAccessTokenClaimRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Id**](Id.md)

### Authorization

[bearer](../README.md#bearer)

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
> ClientApp addClientApp(id, addClientAppRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    AddClientAppRequest addClientAppRequest = new AddClientAppRequest(); // AddClientAppRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      ClientApp result = apiInstance.addClientApp(id, addClientAppRequest, authorization);
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
| **id** | **Integer**|  | |
| **addClientAppRequest** | [**AddClientAppRequest**](AddClientAppRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**ClientApp**](ClientApp.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;AddRoleUsers200ResponseInner&gt; addRoleAdmins(roleId, requestBody, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<AddRoleUsers200ResponseInner> result = apiInstance.addRoleAdmins(roleId, requestBody, authorization);
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
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;AddRoleUsers200ResponseInner&gt;**](AddRoleUsers200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;AddRoleUsers200ResponseInner&gt; addRoleUsers(roleId, requestBody, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<AddRoleUsers200ResponseInner> result = apiInstance.addRoleUsers(roleId, requestBody, authorization);
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
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;AddRoleUsers200ResponseInner&gt;**](AddRoleUsers200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> Id addScope(id, addScopeRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    AddScopeRequest addScopeRequest = new AddScopeRequest(); // AddScopeRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Id result = apiInstance.addScope(id, addScopeRequest, authorization);
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
| **id** | **Integer**|  | |
| **addScopeRequest** | [**AddScopeRequest**](AddScopeRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Id**](Id.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;Integer&gt; bulkMappingSort(requestBody, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | The request body must contain an array of User Mapping IDs in the desired order.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<Integer> result = apiInstance.bulkMappingSort(requestBody, authorization);
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
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)| The request body must contain an array of User Mapping IDs in the desired order. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

**List&lt;Integer&gt;**

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;Integer&gt; bulkSort(appId, requestBody, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | The request body must contain an array of App Rule IDs in the desired order.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<Integer> result = apiInstance.bulkSort(appId, requestBody, authorization);
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
| **appId** | **Integer**|  | |
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)| The request body must contain an array of App Rule IDs in the desired order. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

**List&lt;Integer&gt;**

### Authorization

[bearer](../README.md#bearer)

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
> Schema createApp(schema, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Schema schema = new Schema(); // Schema | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Schema result = apiInstance.createApp(schema, authorization);
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
| **schema** | [**Schema**](Schema.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Schema**](Schema.md)

### Authorization

[bearer](../README.md#bearer)

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
> Id createAuthorizationServer(createAuthorizationServerRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    CreateAuthorizationServerRequest createAuthorizationServerRequest = new CreateAuthorizationServerRequest(); // CreateAuthorizationServerRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Id result = apiInstance.createAuthorizationServer(createAuthorizationServerRequest, authorization);
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
| **createAuthorizationServerRequest** | [**CreateAuthorizationServerRequest**](CreateAuthorizationServerRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Id**](Id.md)

### Authorization

[bearer](../README.md#bearer)

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
> Envvar createEnvironmentVariable(createEnvironmentVariableRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    CreateEnvironmentVariableRequest createEnvironmentVariableRequest = new CreateEnvironmentVariableRequest(); // CreateEnvironmentVariableRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Envvar result = apiInstance.createEnvironmentVariable(createEnvironmentVariableRequest, authorization);
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
| **createEnvironmentVariableRequest** | [**CreateEnvironmentVariableRequest**](CreateEnvironmentVariableRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Envvar**](Envvar.md)

### Authorization

[bearer](../README.md#bearer)

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
> Hook createHook(hook, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Hook hook = new Hook(); // Hook | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Hook result = apiInstance.createHook(hook, authorization);
      System.out.println(result);
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
| **hook** | [**Hook**](Hook.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Hook**](Hook.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **409** | You have tried to create another function for a hook that only allows a single one to be defined. |  -  |
| **422** | You function is not base64 encoded. |  -  |

<a name="createMapping"></a>
# **createMapping**
> Integer createMapping(mapping, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Mapping mapping = new Mapping(); // Mapping | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Integer result = apiInstance.createMapping(mapping, authorization);
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
| **mapping** | [**Mapping**](Mapping.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

**Integer**

### Authorization

[bearer](../README.md#bearer)

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
> RiskRule createRiskRule(riskRule, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    RiskRule riskRule = new RiskRule(); // RiskRule | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      RiskRule result = apiInstance.createRiskRule(riskRule, authorization);
      System.out.println(result);
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
| **riskRule** | [**RiskRule**](RiskRule.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**RiskRule**](RiskRule.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | Invalid API Key |  -  |

<a name="createRoles"></a>
# **createRoles**
> List&lt;CreateRoles201ResponseInner&gt; createRoles(role, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Role role = new Role(); // Role | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<CreateRoles201ResponseInner> result = apiInstance.createRoles(role, authorization);
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
| **role** | [**Role**](Role.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;CreateRoles201ResponseInner&gt;**](CreateRoles201ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="createRule"></a>
# **createRule**
> RuleId createRule(appId, rule, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    Rule rule = new Rule(); // Rule | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      RuleId result = apiInstance.createRule(appId, rule, authorization);
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
| **appId** | **Integer**|  | |
| **rule** | [**Rule**](Rule.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**RuleId**](RuleId.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | CREATED |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **422** | UNPROCESSABLE ENTRY |  -  |

<a name="createSessionLoginToken"></a>
# **createSessionLoginToken**
> CreateSessionLoginToken200Response createSessionLoginToken(createSessionLoginTokenRequest, authorization, customAllowedOriginHeader1)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    CreateSessionLoginTokenRequest createSessionLoginTokenRequest = new CreateSessionLoginTokenRequest(); // CreateSessionLoginTokenRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    String customAllowedOriginHeader1 = "customAllowedOriginHeader1_example"; // String | Required for CORS requests only. Set to the Origin URI from which you are allowed to send a request using CORS.
    try {
      CreateSessionLoginToken200Response result = apiInstance.createSessionLoginToken(createSessionLoginTokenRequest, authorization, customAllowedOriginHeader1);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createSessionLoginToken");
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
| **createSessionLoginTokenRequest** | [**CreateSessionLoginTokenRequest**](CreateSessionLoginTokenRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **customAllowedOriginHeader1** | **String**| Required for CORS requests only. Set to the Origin URI from which you are allowed to send a request using CORS. | [optional] |

### Return type

[**CreateSessionLoginToken200Response**](CreateSessionLoginToken200Response.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | UNAUTHORIZED |  -  |

<a name="createUser"></a>
# **createUser**
> User createUser(user, authorization, mappings, validatePolicy)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    User user = new User(); // User | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    String mappings = "async"; // String | Controls how mappings will be applied to the user on creation. Defaults to async.
    Boolean validatePolicy = true; // Boolean | Will passwords validate against the User Policy? Defaults to true.
    try {
      User result = apiInstance.createUser(user, authorization, mappings, validatePolicy);
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
| **user** | [**User**](User.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **mappings** | **String**| Controls how mappings will be applied to the user on creation. Defaults to async. | [optional] [enum: async, sync, disabled] |
| **validatePolicy** | **Boolean**| Will passwords validate against the User Policy? Defaults to true. | [optional] |

### Return type

[**User**](User.md)

### Authorization

[bearer](../README.md#bearer)

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
> deleteAccessTokenClaim(id, claimId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    Integer claimId = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.deleteAccessTokenClaim(id, claimId, authorization);
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
| **id** | **Integer**|  | |
| **claimId** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
> deleteApp(appId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.deleteApp(appId, authorization);
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
| **appId** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
> deleteAppParameter(appId, parameterId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    Integer parameterId = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.deleteAppParameter(appId, parameterId, authorization);
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
| **appId** | **Integer**|  | |
| **parameterId** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
> deleteAuthorizationServer(id, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.deleteAuthorizationServer(id, authorization);
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
| **id** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
> deleteEnvironmentVariable(envvarId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String envvarId = "envvarId_example"; // String | Set to the id of the Hook Environment Variable that you want to fetch.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.deleteEnvironmentVariable(envvarId, authorization);
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
| **envvarId** | **String**| Set to the id of the Hook Environment Variable that you want to fetch. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
> deleteFactor(userId, deviceId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    Integer deviceId = 56; // Integer | Set to the device_id of the MFA device.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.deleteFactor(userId, deviceId, authorization);
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
| **userId** | **Integer**| Set to the id of the user. | |
| **deviceId** | **Integer**| Set to the device_id of the MFA device. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | NO CONTENT |  -  |

<a name="deleteHook"></a>
# **deleteHook**
> deleteHook(hookId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String hookId = "hookId_example"; // String | Set to the id of the Hook that you want to return.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.deleteHook(hookId, authorization);
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
| **hookId** | **String**| Set to the id of the Hook that you want to return. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
> deleteMapping(mappingId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer mappingId = 56; // Integer | The id of the user mapping to locate.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.deleteMapping(mappingId, authorization);
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
| **mappingId** | **Integer**| The id of the user mapping to locate. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
> RiskRule deleteRiskRule(riskRuleId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String riskRuleId = "riskRuleId_example"; // String | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      RiskRule result = apiInstance.deleteRiskRule(riskRuleId, authorization);
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
| **riskRuleId** | **String**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**RiskRule**](RiskRule.md)

### Authorization

[bearer](../README.md#bearer)

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
> deleteRole(roleId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.deleteRole(roleId, authorization);
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
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
> deleteRule(appId, ruleId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    Integer ruleId = 56; // Integer | The id of the app rule to locate.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.deleteRule(appId, ruleId, authorization);
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
| **appId** | **Integer**|  | |
| **ruleId** | **Integer**| The id of the app rule to locate. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
> deleteScope(id, scopeId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    Integer scopeId = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.deleteScope(id, scopeId, authorization);
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
| **id** | **Integer**|  | |
| **scopeId** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
> deleteUser(userId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.deleteUser(userId, authorization);
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
| **userId** | **Integer**| Set to the id of the user. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;DryRunMapping200ResponseInner&gt; dryRunMapping(mappingId, requestBody, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer mappingId = 56; // Integer | The id of the user mapping to locate.
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | Request body is a list of user IDs tested against the mapping conditions to verify that the mapping would be applied
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<DryRunMapping200ResponseInner> result = apiInstance.dryRunMapping(mappingId, requestBody, authorization);
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
| **mappingId** | **Integer**| The id of the user mapping to locate. | |
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)| Request body is a list of user IDs tested against the mapping conditions to verify that the mapping would be applied | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;DryRunMapping200ResponseInner&gt;**](DryRunMapping200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;List&lt;FactorInner&gt;&gt; enrollFactor(userId, enrollFactorRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    EnrollFactorRequest enrollFactorRequest = new EnrollFactorRequest(); // EnrollFactorRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<List<FactorInner>> result = apiInstance.enrollFactor(userId, enrollFactorRequest, authorization);
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
| **userId** | **Integer**| Set to the id of the user. | |
| **enrollFactorRequest** | [**EnrollFactorRequest**](EnrollFactorRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;List&lt;FactorInner&gt;&gt;**](List.md)

### Authorization

[bearer](../README.md#bearer)

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
> GenerateMfaToken200Response generateMfaToken(userId, generateMfaTokenRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    GenerateMfaTokenRequest generateMfaTokenRequest = new GenerateMfaTokenRequest(); // GenerateMfaTokenRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      GenerateMfaToken200Response result = apiInstance.generateMfaToken(userId, generateMfaTokenRequest, authorization);
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
| **userId** | **Integer**| Set to the id of the user. | |
| **generateMfaTokenRequest** | [**GenerateMfaTokenRequest**](GenerateMfaTokenRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**GenerateMfaToken200Response**](GenerateMfaToken200Response.md)

### Authorization

[bearer](../README.md#bearer)

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
> GenerateSamlAssertion200Response generateSamlAssertion(generateSamlAssertionRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    GenerateSamlAssertionRequest generateSamlAssertionRequest = new GenerateSamlAssertionRequest(); // GenerateSamlAssertionRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      GenerateSamlAssertion200Response result = apiInstance.generateSamlAssertion(generateSamlAssertionRequest, authorization);
      System.out.println(result);
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
| **generateSamlAssertionRequest** | [**GenerateSamlAssertionRequest**](GenerateSamlAssertionRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**GenerateSamlAssertion200Response**](GenerateSamlAssertion200Response.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | UNAUTHORIZED |  -  |

<a name="generateToken"></a>
# **generateToken**
> GenerateToken200Response generateToken(clientId, clientSecret, grantType)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String clientId = "clientId_example"; // String | 
    String clientSecret = "clientSecret_example"; // String | 
    String grantType = "client_credentials"; // String | 
    try {
      GenerateToken200Response result = apiInstance.generateToken(clientId, clientSecret, grantType);
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
| **clientId** | **String**|  | |
| **clientSecret** | **String**|  | |
| **grantType** | **String**|  | [enum: client_credentials] |

### Return type

[**GenerateToken200Response**](GenerateToken200Response.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
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
> Schema getApp(appId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Schema result = apiInstance.getApp(appId, authorization);
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
| **appId** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Schema**](Schema.md)

### Authorization

[bearer](../README.md#bearer)

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
> GetAuthorizationServer200Response getAuthorizationServer(id, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      GetAuthorizationServer200Response result = apiInstance.getAuthorizationServer(id, authorization);
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
| **id** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**GetAuthorizationServer200Response**](GetAuthorizationServer200Response.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;GetAvailableFactors200ResponseInner&gt; getAvailableFactors(userId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<GetAvailableFactors200ResponseInner> result = apiInstance.getAvailableFactors(userId, authorization);
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
| **userId** | **Integer**| Set to the id of the user. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;GetAvailableFactors200ResponseInner&gt;**](GetAvailableFactors200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;GetClientApps200ResponseInner&gt; getClientApps(id, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<GetClientApps200ResponseInner> result = apiInstance.getClientApps(id, authorization);
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
| **id** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;GetClientApps200ResponseInner&gt;**](GetClientApps200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;Device&gt; getEnrolledFactors(userId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<Device> result = apiInstance.getEnrolledFactors(userId, authorization);
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
| **userId** | **Integer**| Set to the id of the user. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;Device&gt;**](Device.md)

### Authorization

[bearer](../README.md#bearer)

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
> Envvar getEnvironmentVariable(envvarId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String envvarId = "envvarId_example"; // String | Set to the id of the Hook Environment Variable that you want to fetch.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Envvar result = apiInstance.getEnvironmentVariable(envvarId, authorization);
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
| **envvarId** | **String**| Set to the id of the Hook Environment Variable that you want to fetch. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Envvar**](Envvar.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="getEventById"></a>
# **getEventById**
> GetEventById200Response getEventById(eventId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer eventId = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      GetEventById200Response result = apiInstance.getEventById(eventId, authorization);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getEventById");
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
| **eventId** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**GetEventById200Response**](GetEventById200Response.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="getEventTypes"></a>
# **getEventTypes**
> GetEventTypes200Response getEventTypes()



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      GetEventTypes200Response result = apiInstance.getEventTypes();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getEventTypes");
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

[**GetEventTypes200Response**](GetEventTypes200Response.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getEvents"></a>
# **getEvents**
> GetEvents200Response getEvents(userId, authorization, fields, until, since, limit, sort, clientId, createdAt, directoryId, eventTypeId, id, resolution)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    String fields = "apps"; // String | Optional. Comma delimited list of fields to return.
    String until = "until_example"; // String | Include the until query parameter to return results with created_at before the value
    String since = "since_example"; // String | Include the until query parameter to return results with created_at after the value
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    String sort = "sort_example"; // String | When you call a resource API, include the sort query parameter to sort results by id attribute value.
    Integer clientId = 56; // Integer | 
    String createdAt = "createdAt_example"; // String | 
    String directoryId = "directoryId_example"; // String | The ID in OneLogin of the Directory that the user belongs to
    List<Integer> eventTypeId = Arrays.asList(); // List<Integer> | 
    Integer id = 56; // Integer | 
    String resolution = "resolution_example"; // String | 
    try {
      GetEvents200Response result = apiInstance.getEvents(userId, authorization, fields, until, since, limit, sort, clientId, createdAt, directoryId, eventTypeId, id, resolution);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getEvents");
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
| **userId** | **Integer**| Set to the id of the user. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **fields** | **String**| Optional. Comma delimited list of fields to return. | [optional] [enum: apps, users, admins] |
| **until** | **String**| Include the until query parameter to return results with created_at before the value | [optional] |
| **since** | **String**| Include the until query parameter to return results with created_at after the value | [optional] |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **sort** | **String**| When you call a resource API, include the sort query parameter to sort results by id attribute value. | [optional] |
| **clientId** | **Integer**|  | [optional] |
| **createdAt** | **String**|  | [optional] |
| **directoryId** | **String**| The ID in OneLogin of the Directory that the user belongs to | [optional] |
| **eventTypeId** | [**List&lt;Integer&gt;**](Integer.md)|  | [optional] |
| **id** | **Integer**|  | [optional] |
| **resolution** | **String**|  | [optional] |

### Return type

[**GetEvents200Response**](GetEvents200Response.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="getGroupById"></a>
# **getGroupById**
> GetGroupById200Response getGroupById(groupId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer groupId = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      GetGroupById200Response result = apiInstance.getGroupById(groupId, authorization);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getGroupById");
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
| **groupId** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**GetGroupById200Response**](GetGroupById200Response.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |
| **404** | Invalid ID |  -  |

<a name="getGroups"></a>
# **getGroups**
> GetGroups200Response getGroups(authorization, fields, until, since, limit, sort, groupId)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    String fields = "apps"; // String | Optional. Comma delimited list of fields to return.
    String until = "until_example"; // String | Include the until query parameter to return results with created_at before the value
    String since = "since_example"; // String | Include the until query parameter to return results with created_at after the value
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    String sort = "sort_example"; // String | When you call a resource API, include the sort query parameter to sort results by id attribute value.
    Integer groupId = 56; // Integer | 
    try {
      GetGroups200Response result = apiInstance.getGroups(authorization, fields, until, since, limit, sort, groupId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getGroups");
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
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **fields** | **String**| Optional. Comma delimited list of fields to return. | [optional] [enum: apps, users, admins] |
| **until** | **String**| Include the until query parameter to return results with created_at before the value | [optional] |
| **since** | **String**| Include the until query parameter to return results with created_at after the value | [optional] |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **sort** | **String**| When you call a resource API, include the sort query parameter to sort results by id attribute value. | [optional] |
| **groupId** | **Integer**|  | [optional] |

### Return type

[**GetGroups200Response**](GetGroups200Response.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | Typically, this error means that your access token value is invalid. |  -  |

<a name="getHook"></a>
# **getHook**
> Hook getHook(hookId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String hookId = "hookId_example"; // String | Set to the id of the Hook that you want to return.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Hook result = apiInstance.getHook(hookId, authorization);
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
| **hookId** | **String**| Set to the id of the Hook that you want to return. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Hook**](Hook.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;Log&gt; getLogs(hookId, authorization, limit, page, cursor, requestId, correlationId)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String hookId = "hookId_example"; // String | Set to the id of the Hook that you want to return.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String requestId = "requestId_example"; // String | Returns logs that contain this request_id.
    String correlationId = "correlationId_example"; // String | Returns logs that contain this correlation_id.
    try {
      List<Log> result = apiInstance.getLogs(hookId, authorization, limit, page, cursor, requestId, correlationId);
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
| **hookId** | **String**| Set to the id of the Hook that you want to return. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **requestId** | **String**| Returns logs that contain this request_id. | [optional] |
| **correlationId** | **String**| Returns logs that contain this correlation_id. | [optional] |

### Return type

[**List&lt;Log&gt;**](Log.md)

### Authorization

[bearer](../README.md#bearer)

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
> Mapping getMapping(mappingId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer mappingId = 56; // Integer | The id of the user mapping to locate.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Mapping result = apiInstance.getMapping(mappingId, authorization);
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
| **mappingId** | **Integer**| The id of the user mapping to locate. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Mapping**](Mapping.md)

### Authorization

[bearer](../README.md#bearer)

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
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
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
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**GetRateLimit200Response**](GetRateLimit200Response.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Typically, this error means that you are using the incorrect method. If you receive this error, ensure that you are making a GET. |  -  |

<a name="getRiskRule"></a>
# **getRiskRule**
> RiskRule getRiskRule(riskRuleId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String riskRuleId = "riskRuleId_example"; // String | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      RiskRule result = apiInstance.getRiskRule(riskRuleId, authorization);
      System.out.println(result);
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
| **riskRuleId** | **String**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**RiskRule**](RiskRule.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Invalid API Key |  -  |

<a name="getRiskScore"></a>
# **getRiskScore**
> GetRiskScore200Response getRiskScore(getRiskScoreRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    GetRiskScoreRequest getRiskScoreRequest = new GetRiskScoreRequest(); // GetRiskScoreRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      GetRiskScore200Response result = apiInstance.getRiskScore(getRiskScoreRequest, authorization);
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
| **getRiskScoreRequest** | [**GetRiskScoreRequest**](GetRiskScoreRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**GetRiskScore200Response**](GetRiskScore200Response.md)

### Authorization

[bearer](../README.md#bearer)

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
> Role getRole(roleId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Role result = apiInstance.getRole(roleId, authorization);
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
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Role**](Role.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;Schema1&gt; getRoleAdmins(roleId, authorization, limit, page, cursor, name, includeUnassigned)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String name = "name_example"; // String | Allows you to filter on first name, last name, username, and email address.
    Boolean includeUnassigned = true; // Boolean | Optional. Defaults to false. Include users that aren’t assigned to the role.
    try {
      List<Schema1> result = apiInstance.getRoleAdmins(roleId, authorization, limit, page, cursor, name, includeUnassigned);
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
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **name** | **String**| Allows you to filter on first name, last name, username, and email address. | [optional] |
| **includeUnassigned** | **Boolean**| Optional. Defaults to false. Include users that aren’t assigned to the role. | [optional] |

### Return type

[**List&lt;Schema1&gt;**](Schema1.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;Schema&gt; getRoleApps(roleId, authorization, limit, page, cursor, assigned)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    Boolean assigned = true; // Boolean | Optional. Defaults to true. Returns all apps not yet assigned to the role.
    try {
      List<Schema> result = apiInstance.getRoleApps(roleId, authorization, limit, page, cursor, assigned);
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
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **assigned** | **Boolean**| Optional. Defaults to true. Returns all apps not yet assigned to the role. | [optional] |

### Return type

[**List&lt;Schema&gt;**](Schema.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;Schema1&gt; getRoleUsers(roleId, authorization, limit, page, cursor, name, includeUnassigned)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String name = "name_example"; // String | Allows you to filter on first name, last name, username, and email address.
    Boolean includeUnassigned = true; // Boolean | Optional. Defaults to false. Include users that aren’t assigned to the role.
    try {
      List<Schema1> result = apiInstance.getRoleUsers(roleId, authorization, limit, page, cursor, name, includeUnassigned);
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
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **name** | **String**| Allows you to filter on first name, last name, username, and email address. | [optional] |
| **includeUnassigned** | **Boolean**| Optional. Defaults to false. Include users that aren’t assigned to the role. | [optional] |

### Return type

[**List&lt;Schema1&gt;**](Schema1.md)

### Authorization

[bearer](../README.md#bearer)

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
> Rule getRule(appId, ruleId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    Integer ruleId = 56; // Integer | The id of the app rule to locate.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Rule result = apiInstance.getRule(appId, ruleId, authorization);
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
| **appId** | **Integer**|  | |
| **ruleId** | **Integer**| The id of the app rule to locate. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Rule**](Rule.md)

### Authorization

[bearer](../README.md#bearer)

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
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
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
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **before** | **String**| Optional ISO8601 formatted date string. Defaults to current date. Maximum date is 90 days ago. | [optional] |
| **after** | **String**| Optional ISO8601 formatted date string. Defaults to 30 days ago. Maximum date is 90 days ago. | [optional] |

### Return type

[**GetScoreInsights200Response**](GetScoreInsights200Response.md)

### Authorization

[bearer](../README.md#bearer)

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
> User getUser(userId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      User result = apiInstance.getUser(userId, authorization);
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
| **userId** | **Integer**| Set to the id of the user. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**User**](User.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;GetUserApps200ResponseInner&gt; getUserApps(userId, authorization, ignoreVisibility)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    Boolean ignoreVisibility = true; // Boolean | Defaults to `false`. When `true` will show all apps that are assigned to a user regardless of their portal visibility setting.
    try {
      List<GetUserApps200ResponseInner> result = apiInstance.getUserApps(userId, authorization, ignoreVisibility);
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
| **userId** | **Integer**| Set to the id of the user. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **ignoreVisibility** | **Boolean**| Defaults to &#x60;false&#x60;. When &#x60;true&#x60; will show all apps that are assigned to a user regardless of their portal visibility setting. | [optional] |

### Return type

[**List&lt;GetUserApps200ResponseInner&gt;**](GetUserApps200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;ListAccessTokenClaims200ResponseInner&gt; listAccessTokenClaims(id, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<ListAccessTokenClaims200ResponseInner> result = apiInstance.listAccessTokenClaims(id, authorization);
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
| **id** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;ListAccessTokenClaims200ResponseInner&gt;**](ListAccessTokenClaims200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;ListConditionValues200ResponseInner&gt; listActionValues(appId, actionValue, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    String actionValue = "actionValue_example"; // String | The value for the selected action.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<ListConditionValues200ResponseInner> result = apiInstance.listActionValues(appId, actionValue, authorization);
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
| **appId** | **Integer**|  | |
| **actionValue** | **String**| The value for the selected action. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;ListConditionValues200ResponseInner&gt;**](ListConditionValues200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;ListActions200ResponseInner&gt; listActions(appId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<ListActions200ResponseInner> result = apiInstance.listActions(appId, authorization);
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
| **appId** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;ListActions200ResponseInner&gt;**](ListActions200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;ListAppUsers200ResponseInner&gt; listAppUsers(appId, authorization, limit, page, cursor)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    try {
      List<ListAppUsers200ResponseInner> result = apiInstance.listAppUsers(appId, authorization, limit, page, cursor);
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
| **appId** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |

### Return type

[**List&lt;ListAppUsers200ResponseInner&gt;**](ListAppUsers200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
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
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **name** | **String**| The name or partial name of the app to search for. When using a partial name you must append a wildcard &#x60;*&#x60; | [optional] |
| **connectorId** | **Integer**| Returns all apps based off a specific connector. See List Connectors for a complete list of Connector IDs. | [optional] |
| **authMethod** | [**AuthMethod**](.md)| Returns all apps based of a given type. | [optional] [enum: 0, 1, 2, 3, 4, 6, 7, 8] |

### Return type

[**List&lt;Schema&gt;**](Schema.md)

### Authorization

[bearer](../README.md#bearer)

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
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
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
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;ListAuthorizationServers200ResponseInner&gt;**](ListAuthorizationServers200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;ListConditionOperators200ResponseInner&gt; listConditionOperators(appId, conditionValue, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    String conditionValue = "conditionValue_example"; // String | The value for the selected condition.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<ListConditionOperators200ResponseInner> result = apiInstance.listConditionOperators(appId, conditionValue, authorization);
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
| **appId** | **Integer**|  | |
| **conditionValue** | **String**| The value for the selected condition. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;ListConditionOperators200ResponseInner&gt;**](ListConditionOperators200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;ListConditionValues200ResponseInner&gt; listConditionValues(appId, conditionValue, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    String conditionValue = "conditionValue_example"; // String | The value for the selected condition.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<ListConditionValues200ResponseInner> result = apiInstance.listConditionValues(appId, conditionValue, authorization);
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
| **appId** | **Integer**|  | |
| **conditionValue** | **String**| The value for the selected condition. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;ListConditionValues200ResponseInner&gt;**](ListConditionValues200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;ListConditions200ResponseInner&gt; listConditions(appId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<ListConditions200ResponseInner> result = apiInstance.listConditions(appId, authorization);
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
| **appId** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;ListConditions200ResponseInner&gt;**](ListConditions200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String name = "name_example"; // String | The name or partial name of the app to search for. When using a partial name you must append a wildcard `*`
    AuthMethod authMethod = AuthMethod.fromValue("0"); // AuthMethod | Returns all apps based of a given type.
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
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **name** | **String**| The name or partial name of the app to search for. When using a partial name you must append a wildcard &#x60;*&#x60; | [optional] |
| **authMethod** | [**AuthMethod**](.md)| Returns all apps based of a given type. | [optional] [enum: 0, 1, 2, 3, 4, 6, 7, 8] |

### Return type

[**List&lt;Connector&gt;**](Connector.md)

### Authorization

[bearer](../README.md#bearer)

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
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
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
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |

### Return type

[**List&lt;Envvar&gt;**](Envvar.md)

### Authorization

[bearer](../README.md#bearer)

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
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
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
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |

### Return type

[**List&lt;Hook&gt;**](Hook.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;ListConditionValues200ResponseInner&gt; listMappingActionValues(actionValue, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String actionValue = "actionValue_example"; // String | The value for the selected action.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<ListConditionValues200ResponseInner> result = apiInstance.listMappingActionValues(actionValue, authorization);
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
| **actionValue** | **String**| The value for the selected action. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;ListConditionValues200ResponseInner&gt;**](ListConditionValues200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
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
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;ListActions200ResponseInner&gt;**](ListActions200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;ListMappingConditionOperators200ResponseInner&gt; listMappingConditionOperators(conditionValue, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String conditionValue = "conditionValue_example"; // String | The value for the selected condition.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<ListMappingConditionOperators200ResponseInner> result = apiInstance.listMappingConditionOperators(conditionValue, authorization);
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
| **conditionValue** | **String**| The value for the selected condition. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;ListMappingConditionOperators200ResponseInner&gt;**](ListMappingConditionOperators200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;ListConditionValues200ResponseInner&gt; listMappingConditionValues(conditionValue, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String conditionValue = "conditionValue_example"; // String | The value for the selected condition.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<ListConditionValues200ResponseInner> result = apiInstance.listMappingConditionValues(conditionValue, authorization);
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
| **conditionValue** | **String**| The value for the selected condition. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;ListConditionValues200ResponseInner&gt;**](ListConditionValues200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
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
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;ListMappingConditions200ResponseInner&gt;**](ListMappingConditions200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    Boolean enabled = true; // Boolean | Defaults to true. When set to `false` will return all disabled rules.
    String hasCondition = "hasCondition_example"; // String | Filters Rules based on their Conditions.
    String hasConditionType = "hasConditionType_example"; // String | Filters Rules based on their condition types.
    String hasAction = "hasAction_example"; // String | Filters Rules based on their Actions.
    String hasActionType = "hasActionType_example"; // String | Filters Rules based on their action types.
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
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **enabled** | **Boolean**| Defaults to true. When set to &#x60;false&#x60; will return all disabled rules. | [optional] |
| **hasCondition** | **String**| Filters Rules based on their Conditions. | [optional] |
| **hasConditionType** | **String**| Filters Rules based on their condition types. | [optional] |
| **hasAction** | **String**| Filters Rules based on their Actions. | [optional] |
| **hasActionType** | **String**| Filters Rules based on their action types. | [optional] |

### Return type

[**List&lt;Mapping&gt;**](Mapping.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;RiskRule&gt; listRiskRules(authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<RiskRule> result = apiInstance.listRiskRules(authorization);
      System.out.println(result);
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
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;RiskRule&gt;**](RiskRule.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Invalid API Key |  -  |

<a name="listRoles"></a>
# **listRoles**
> List&lt;Role&gt; listRoles(authorization, limit, page, cursor, name, appId, fields)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
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
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **name** | **String**| Optional. Filters by role name. | [optional] |
| **appId** | **String**| Optional. Returns roles that contain this app name. | [optional] |
| **fields** | **String**| Optional. Comma delimited list of fields to return. | [optional] [enum: apps, users, admins] |

### Return type

[**List&lt;Role&gt;**](Role.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;Rule&gt; listRules(appId, authorization, enabled, hasCondition, hasConditionType, hasAction, hasActionType)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    Boolean enabled = true; // Boolean | Defaults to true. When set to `false` will return all disabled rules.
    String hasCondition = "hasCondition_example"; // String | Filters Rules based on their Conditions.
    String hasConditionType = "hasConditionType_example"; // String | Filters Rules based on their condition types.
    String hasAction = "hasAction_example"; // String | Filters Rules based on their Actions.
    String hasActionType = "hasActionType_example"; // String | Filters Rules based on their action types.
    try {
      List<Rule> result = apiInstance.listRules(appId, authorization, enabled, hasCondition, hasConditionType, hasAction, hasActionType);
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
| **appId** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **enabled** | **Boolean**| Defaults to true. When set to &#x60;false&#x60; will return all disabled rules. | [optional] |
| **hasCondition** | **String**| Filters Rules based on their Conditions. | [optional] |
| **hasConditionType** | **String**| Filters Rules based on their condition types. | [optional] |
| **hasAction** | **String**| Filters Rules based on their Actions. | [optional] |
| **hasActionType** | **String**| Filters Rules based on their action types. | [optional] |

### Return type

[**List&lt;Rule&gt;**](Rule.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;ListScopes200ResponseInner&gt; listScopes(id, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<ListScopes200ResponseInner> result = apiInstance.listScopes(id, authorization);
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
| **id** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;ListScopes200ResponseInner&gt;**](ListScopes200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;User&gt; listUsers(appId, authorization, limit, page, cursor, createdSince, createdUntil, updatedSince, updatedUntil, lastLoginSince, lastLoginUntil, firstname, lastname, email, username, samaccountname, directoryId, externalId, userIds, customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket, fields)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    Integer limit = 56; // Integer | The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit.
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String createdSince = "createdSince_example"; // String | An ISO8601 timestamp value that returns all users created after a given date & time.
    String createdUntil = "createdUntil_example"; // String | An ISO8601 timestamp value that returns all users created before a given date & time.
    String updatedSince = "updatedSince_example"; // String | An ISO8601 timestamp value that returns all users updated after a given date & time.
    String updatedUntil = "updatedUntil_example"; // String | An ISO8601 timestamp value that returns all users updated before a given date & time.
    String lastLoginSince = "lastLoginSince_example"; // String | An ISO8601 timestamp value that returns all users that logged in after a given date & time.
    String lastLoginUntil = "lastLoginUntil_example"; // String | An ISO8601 timestamp value that returns all users that logged in before a given date & time.
    String firstname = "firstname_example"; // String | The first name of the user
    String lastname = "lastname_example"; // String | The last name of the user
    String email = "email_example"; // String | The email address of the user
    String username = "username_example"; // String | The username for the user
    String samaccountname = "samaccountname_example"; // String | The AD login name for the user
    String directoryId = "directoryId_example"; // String | The ID in OneLogin of the Directory that the user belongs to
    String externalId = "externalId_example"; // String | An external identifier that has been set on the user
    String userIds = "userIds_example"; // String | A comma separated list of OneLogin User IDs
    String customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket = "customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket_example"; // String | The short name of a custom attribute. Note that the attribute name is prefixed with custom_attributes.
    String fields = "apps"; // String | Optional. Comma delimited list of fields to return.
    try {
      List<User> result = apiInstance.listUsers(appId, authorization, limit, page, cursor, createdSince, createdUntil, updatedSince, updatedUntil, lastLoginSince, lastLoginUntil, firstname, lastname, email, username, samaccountname, directoryId, externalId, userIds, customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket, fields);
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
| **appId** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **limit** | **Integer**| The total number of items returned per page. The maximum limit varies between endpoints, see the relevant endpoint documentation for the specific limit. | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **createdSince** | **String**| An ISO8601 timestamp value that returns all users created after a given date &amp; time. | [optional] |
| **createdUntil** | **String**| An ISO8601 timestamp value that returns all users created before a given date &amp; time. | [optional] |
| **updatedSince** | **String**| An ISO8601 timestamp value that returns all users updated after a given date &amp; time. | [optional] |
| **updatedUntil** | **String**| An ISO8601 timestamp value that returns all users updated before a given date &amp; time. | [optional] |
| **lastLoginSince** | **String**| An ISO8601 timestamp value that returns all users that logged in after a given date &amp; time. | [optional] |
| **lastLoginUntil** | **String**| An ISO8601 timestamp value that returns all users that logged in before a given date &amp; time. | [optional] |
| **firstname** | **String**| The first name of the user | [optional] |
| **lastname** | **String**| The last name of the user | [optional] |
| **email** | **String**| The email address of the user | [optional] |
| **username** | **String**| The username for the user | [optional] |
| **samaccountname** | **String**| The AD login name for the user | [optional] |
| **directoryId** | **String**| The ID in OneLogin of the Directory that the user belongs to | [optional] |
| **externalId** | **String**| An external identifier that has been set on the user | [optional] |
| **userIds** | **String**| A comma separated list of OneLogin User IDs | [optional] |
| **customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket** | **String**| The short name of a custom attribute. Note that the attribute name is prefixed with custom_attributes. | [optional] |
| **fields** | **String**| Optional. Comma delimited list of fields to return. | [optional] [enum: apps, users, admins] |

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

[bearer](../README.md#bearer)

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
> removeClientApp(id, clientAppId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    Integer clientAppId = 56; // Integer | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.removeClientApp(id, clientAppId, authorization);
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
| **id** | **Integer**|  | |
| **clientAppId** | **Integer**|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
> removeRoleAdmins(roleId, removeRoleUsersRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    RemoveRoleUsersRequest removeRoleUsersRequest = new RemoveRoleUsersRequest(); // RemoveRoleUsersRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.removeRoleAdmins(roleId, removeRoleUsersRequest, authorization);
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
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **removeRoleUsersRequest** | [**RemoveRoleUsersRequest**](RemoveRoleUsersRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
> removeRoleUsers(roleId, removeRoleUsersRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    RemoveRoleUsersRequest removeRoleUsersRequest = new RemoveRoleUsersRequest(); // RemoveRoleUsersRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.removeRoleUsers(roleId, removeRoleUsersRequest, authorization);
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
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **removeRoleUsersRequest** | [**RemoveRoleUsersRequest**](RemoveRoleUsersRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

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

[bearer](../README.md#bearer)

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
> List&lt;SetRoleApps200ResponseInner&gt; setRoleApps(roleId, requestBody, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<SetRoleApps200ResponseInner> result = apiInstance.setRoleApps(roleId, requestBody, authorization);
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
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;SetRoleApps200ResponseInner&gt;**](SetRoleApps200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

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
> trackEvent(trackEventRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    TrackEventRequest trackEventRequest = new TrackEventRequest(); // TrackEventRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      apiInstance.trackEvent(trackEventRequest, authorization);
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
| **trackEventRequest** | [**TrackEventRequest**](TrackEventRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

null (empty response body)

### Authorization

[bearer](../README.md#bearer)

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
> Id updateAccessTokenClaim(id, claimId, addAccessTokenClaimRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    Integer claimId = 56; // Integer | 
    AddAccessTokenClaimRequest addAccessTokenClaimRequest = new AddAccessTokenClaimRequest(); // AddAccessTokenClaimRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Id result = apiInstance.updateAccessTokenClaim(id, claimId, addAccessTokenClaimRequest, authorization);
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
| **id** | **Integer**|  | |
| **claimId** | **Integer**|  | |
| **addAccessTokenClaimRequest** | [**AddAccessTokenClaimRequest**](AddAccessTokenClaimRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Id**](Id.md)

### Authorization

[bearer](../README.md#bearer)

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
> Schema updateApp(appId, schema, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    Schema schema = new Schema(); // Schema | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Schema result = apiInstance.updateApp(appId, schema, authorization);
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
| **appId** | **Integer**|  | |
| **schema** | [**Schema**](Schema.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Schema**](Schema.md)

### Authorization

[bearer](../README.md#bearer)

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
> Id updateAuthorizationServer(id, createAuthorizationServerRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    CreateAuthorizationServerRequest createAuthorizationServerRequest = new CreateAuthorizationServerRequest(); // CreateAuthorizationServerRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Id result = apiInstance.updateAuthorizationServer(id, createAuthorizationServerRequest, authorization);
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
| **id** | **Integer**|  | |
| **createAuthorizationServerRequest** | [**CreateAuthorizationServerRequest**](CreateAuthorizationServerRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Id**](Id.md)

### Authorization

[bearer](../README.md#bearer)

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
> ClientApp updateClientApp(id, clientAppId, updateClientAppRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    Integer clientAppId = 56; // Integer | 
    UpdateClientAppRequest updateClientAppRequest = new UpdateClientAppRequest(); // UpdateClientAppRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      ClientApp result = apiInstance.updateClientApp(id, clientAppId, updateClientAppRequest, authorization);
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
| **id** | **Integer**|  | |
| **clientAppId** | **Integer**|  | |
| **updateClientAppRequest** | [**UpdateClientAppRequest**](UpdateClientAppRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**ClientApp**](ClientApp.md)

### Authorization

[bearer](../README.md#bearer)

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
> Envvar updateEnvironmentVariable(envvarId, updateEnvironmentVariableRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String envvarId = "envvarId_example"; // String | Set to the id of the Hook Environment Variable that you want to fetch.
    UpdateEnvironmentVariableRequest updateEnvironmentVariableRequest = new UpdateEnvironmentVariableRequest(); // UpdateEnvironmentVariableRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Envvar result = apiInstance.updateEnvironmentVariable(envvarId, updateEnvironmentVariableRequest, authorization);
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
| **envvarId** | **String**| Set to the id of the Hook Environment Variable that you want to fetch. | |
| **updateEnvironmentVariableRequest** | [**UpdateEnvironmentVariableRequest**](UpdateEnvironmentVariableRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Envvar**](Envvar.md)

### Authorization

[bearer](../README.md#bearer)

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
> Hook updateHook(hookId, hook, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String hookId = "hookId_example"; // String | Set to the id of the Hook that you want to return.
    Hook hook = new Hook(); // Hook | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Hook result = apiInstance.updateHook(hookId, hook, authorization);
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
| **hookId** | **String**| Set to the id of the Hook that you want to return. | |
| **hook** | [**Hook**](Hook.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Hook**](Hook.md)

### Authorization

[bearer](../README.md#bearer)

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
> Integer updateMapping(mappingId, mapping, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer mappingId = 56; // Integer | The id of the user mapping to locate.
    Mapping mapping = new Mapping(); // Mapping | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Integer result = apiInstance.updateMapping(mappingId, mapping, authorization);
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
| **mappingId** | **Integer**| The id of the user mapping to locate. | |
| **mapping** | [**Mapping**](Mapping.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

**Integer**

### Authorization

[bearer](../README.md#bearer)

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
> RiskRule updateRiskRule(riskRuleId, riskRule, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String riskRuleId = "riskRuleId_example"; // String | 
    RiskRule riskRule = new RiskRule(); // RiskRule | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      RiskRule result = apiInstance.updateRiskRule(riskRuleId, riskRule, authorization);
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
| **riskRuleId** | **String**|  | |
| **riskRule** | [**RiskRule**](RiskRule.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**RiskRule**](RiskRule.md)

### Authorization

[bearer](../README.md#bearer)

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
> UpdateRole200Response updateRole(roleId, role, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer roleId = 56; // Integer | Set to the id of the role you want to return.
    Role role = new Role(); // Role | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      UpdateRole200Response result = apiInstance.updateRole(roleId, role, authorization);
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
| **roleId** | **Integer**| Set to the id of the role you want to return. | |
| **role** | [**Role**](Role.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**UpdateRole200Response**](UpdateRole200Response.md)

### Authorization

[bearer](../README.md#bearer)

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
> RuleId updateRule(appId, ruleId, rule, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer appId = 56; // Integer | 
    Integer ruleId = 56; // Integer | The id of the app rule to locate.
    Rule rule = new Rule(); // Rule | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      RuleId result = apiInstance.updateRule(appId, ruleId, rule, authorization);
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
| **appId** | **Integer**|  | |
| **ruleId** | **Integer**| The id of the app rule to locate. | |
| **rule** | [**Rule**](Rule.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**RuleId**](RuleId.md)

### Authorization

[bearer](../README.md#bearer)

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
> Id updateScope(id, scopeId, addScopeRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | 
    Integer scopeId = 56; // Integer | 
    AddScopeRequest addScopeRequest = new AddScopeRequest(); // AddScopeRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      Id result = apiInstance.updateScope(id, scopeId, addScopeRequest, authorization);
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
| **id** | **Integer**|  | |
| **scopeId** | **Integer**|  | |
| **addScopeRequest** | [**AddScopeRequest**](AddScopeRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**Id**](Id.md)

### Authorization

[bearer](../README.md#bearer)

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
> User updateUser(userId, user, authorization, mappings, validatePolicy)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    User user = new User(); // User | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    String mappings = "async"; // String | Controls how mappings will be applied to the user on creation. Defaults to async.
    Boolean validatePolicy = true; // Boolean | Will passwords validate against the User Policy? Defaults to true.
    try {
      User result = apiInstance.updateUser(userId, user, authorization, mappings, validatePolicy);
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
| **userId** | **Integer**| Set to the id of the user. | |
| **user** | [**User**](User.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **mappings** | **String**| Controls how mappings will be applied to the user on creation. Defaults to async. | [optional] [enum: async, sync, disabled] |
| **validatePolicy** | **Boolean**| Will passwords validate against the User Policy? Defaults to true. | [optional] |

### Return type

[**User**](User.md)

### Authorization

[bearer](../README.md#bearer)

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

<a name="v1VerifyFactor"></a>
# **v1VerifyFactor**
> V1VerifyFactor200Response v1VerifyFactor(v1VerifyFactorRequest, authorization, customAllowedOriginHeader1)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    V1VerifyFactorRequest v1VerifyFactorRequest = new V1VerifyFactorRequest(); // V1VerifyFactorRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    String customAllowedOriginHeader1 = "customAllowedOriginHeader1_example"; // String | Required for CORS requests only. Set to the Origin URI from which you are allowed to send a request using CORS.
    try {
      V1VerifyFactor200Response result = apiInstance.v1VerifyFactor(v1VerifyFactorRequest, authorization, customAllowedOriginHeader1);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#v1VerifyFactor");
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
| **v1VerifyFactorRequest** | [**V1VerifyFactorRequest**](V1VerifyFactorRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |
| **customAllowedOriginHeader1** | **String**| Required for CORS requests only. Set to the Origin URI from which you are allowed to send a request using CORS. | [optional] |

### Return type

[**V1VerifyFactor200Response**](V1VerifyFactor200Response.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | BAD REQUEST |  -  |
| **401** | UNAUTHORIZED |  -  |

<a name="verifyEnrollment"></a>
# **verifyEnrollment**
> List&lt;Registration&gt; verifyEnrollment(userId, registrationId, verifyEnrollmentRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    Integer registrationId = 56; // Integer | Set to the uuid of the registration. This was included in the response as part of the initial request in Enroll Factor.
    VerifyEnrollmentRequest verifyEnrollmentRequest = new VerifyEnrollmentRequest(); // VerifyEnrollmentRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<Registration> result = apiInstance.verifyEnrollment(userId, registrationId, verifyEnrollmentRequest, authorization);
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
| **userId** | **Integer**| Set to the id of the user. | |
| **registrationId** | **Integer**| Set to the uuid of the registration. This was included in the response as part of the initial request in Enroll Factor. | |
| **verifyEnrollmentRequest** | [**VerifyEnrollmentRequest**](VerifyEnrollmentRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;Registration&gt;**](Registration.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;Registration&gt; verifyEnrollmentVoiceProtect(userId, registrationId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    Integer registrationId = 56; // Integer | Set to the uuid of the registration. This was included in the response as part of the initial request in Enroll Factor.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<Registration> result = apiInstance.verifyEnrollmentVoiceProtect(userId, registrationId, authorization);
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
| **userId** | **Integer**| Set to the id of the user. | |
| **registrationId** | **Integer**| Set to the uuid of the registration. This was included in the response as part of the initial request in Enroll Factor. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;Registration&gt;**](Registration.md)

### Authorization

[bearer](../README.md#bearer)

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
> GenerateToken400Response verifyFactor(userId, verificationId, verifyFactorRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    Integer verificationId = 56; // Integer | The verification_id is returned on activation of the factor or you can get the device_id using the Activate Factor API call.
    VerifyFactorRequest verifyFactorRequest = new VerifyFactorRequest(); // VerifyFactorRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      GenerateToken400Response result = apiInstance.verifyFactor(userId, verificationId, verifyFactorRequest, authorization);
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
| **userId** | **Integer**| Set to the id of the user. | |
| **verificationId** | **Integer**| The verification_id is returned on activation of the factor or you can get the device_id using the Activate Factor API call. | |
| **verifyFactorRequest** | [**VerifyFactorRequest**](VerifyFactorRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**GenerateToken400Response**](GenerateToken400Response.md)

### Authorization

[bearer](../README.md#bearer)

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
> VerifyFactorSaml200Response verifyFactorSaml(verifyFactorSamlRequest, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    VerifyFactorSamlRequest verifyFactorSamlRequest = new VerifyFactorSamlRequest(); // VerifyFactorSamlRequest | 
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      VerifyFactorSaml200Response result = apiInstance.verifyFactorSaml(verifyFactorSamlRequest, authorization);
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
| **verifyFactorSamlRequest** | [**VerifyFactorSamlRequest**](VerifyFactorSamlRequest.md)|  | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**VerifyFactorSaml200Response**](VerifyFactorSaml200Response.md)

### Authorization

[bearer](../README.md#bearer)

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
> List&lt;VerifyFactorVoice200ResponseInner&gt; verifyFactorVoice(userId, verificationId, authorization)



### Example
```java
// Import classes:
import com.onelogin.sdk.ApiClient;
import com.onelogin.sdk.ApiException;
import com.onelogin.sdk.Configuration;
import com.onelogin.sdk.auth.*;
import com.onelogin.sdk.models.*;
import com.onelogin.sdk.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.us.onelogin.com");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user.
    Integer verificationId = 56; // Integer | The verification_id is returned on activation of the factor or you can get the device_id using the Activate Factor API call.
    String authorization = "authorization_example"; // String | Must be in the form of 'bearer <access_token>'
    try {
      List<VerifyFactorVoice200ResponseInner> result = apiInstance.verifyFactorVoice(userId, verificationId, authorization);
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
| **userId** | **Integer**| Set to the id of the user. | |
| **verificationId** | **Integer**| The verification_id is returned on activation of the factor or you can get the device_id using the Activate Factor API call. | |
| **authorization** | **String**| Must be in the form of &#39;bearer &lt;access_token&gt;&#39; | [optional] |

### Return type

[**List&lt;VerifyFactorVoice200ResponseInner&gt;**](VerifyFactorVoice200ResponseInner.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | NOT FOUND |  -  |
| **404** | Invalid ID |  -  |

