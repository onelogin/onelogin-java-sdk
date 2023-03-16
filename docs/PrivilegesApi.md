# PrivilegesApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addPrivilegeToRole**](PrivilegesApi.md#addPrivilegeToRole) | **POST** /api/1/privileges/{privilege_id}/roles | Assign a Privilege to Roles |
| [**assignUsersToPrivilege**](PrivilegesApi.md#assignUsersToPrivilege) | **POST** /api/1/privileges/{privilege_id}/users | Assign Users to a Privilege |
| [**createPrivilege**](PrivilegesApi.md#createPrivilege) | **POST** /api/1/privileges | Create a Privilege |
| [**deletePrivilege**](PrivilegesApi.md#deletePrivilege) | **DELETE** /api/1/privileges/{privilege_id} | Delete a Privilege |
| [**deleteRoleFromPrivilege**](PrivilegesApi.md#deleteRoleFromPrivilege) | **DELETE** /api/1/privileges/{privilege_id}/roles/{role_id} | Remove a Privilege from a Role |
| [**getAssignedUser**](PrivilegesApi.md#getAssignedUser) | **GET** /api/1/privileges/{privilege_id}/users | Get Users assigned to a Privilege |
| [**getPrivilege**](PrivilegesApi.md#getPrivilege) | **GET** /api/1/privileges/{privilege_id} | Get a Privilege |
| [**listPrivelegeRoles**](PrivilegesApi.md#listPrivelegeRoles) | **GET** /api/1/privileges/{privilege_id}/roles | Get Roles assigned to Privilege |
| [**listPriveleges**](PrivilegesApi.md#listPriveleges) | **GET** /api/1/privileges | List Privileges |
| [**removeUserFromPrivilege**](PrivilegesApi.md#removeUserFromPrivilege) | **DELETE** /api/1/privileges/{privilege_id}/users/{user_id} | Remove a Privilege from Users |
| [**updatePrivilege**](PrivilegesApi.md#updatePrivilege) | **PUT** /api/1/privileges/{privilege_id} | Update a Privilege |


<a name="addPrivilegeToRole"></a>
# **addPrivilegeToRole**
> AddPrivilegeToRole201Response addPrivilegeToRole(privilegeId, addPrivilegeToRoleRequest)

Assign a Privilege to Roles

Add roles to privilege 

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.PrivilegesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    PrivilegesApi apiInstance = new PrivilegesApi(defaultClient);
    String privilegeId = "privilegeId_example"; // String | 
    AddPrivilegeToRoleRequest addPrivilegeToRoleRequest = new AddPrivilegeToRoleRequest(); // AddPrivilegeToRoleRequest | 
    try {
      AddPrivilegeToRole201Response result = apiInstance.addPrivilegeToRole(privilegeId, addPrivilegeToRoleRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivilegesApi#addPrivilegeToRole");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **privilegeId** | **String**|  | |
| **addPrivilegeToRoleRequest** | [**AddPrivilegeToRoleRequest**](AddPrivilegeToRoleRequest.md)|  | [optional] |

### Return type

[**AddPrivilegeToRole201Response**](AddPrivilegeToRole201Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |

<a name="assignUsersToPrivilege"></a>
# **assignUsersToPrivilege**
> AddPrivilegeToRole201Response assignUsersToPrivilege(privilegeId, assignUsersToPrivilegeRequest)

Assign Users to a Privilege

Assign Users to Privilege

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.PrivilegesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    PrivilegesApi apiInstance = new PrivilegesApi(defaultClient);
    String privilegeId = "privilegeId_example"; // String | 
    AssignUsersToPrivilegeRequest assignUsersToPrivilegeRequest = new AssignUsersToPrivilegeRequest(); // AssignUsersToPrivilegeRequest | 
    try {
      AddPrivilegeToRole201Response result = apiInstance.assignUsersToPrivilege(privilegeId, assignUsersToPrivilegeRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivilegesApi#assignUsersToPrivilege");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **privilegeId** | **String**|  | |
| **assignUsersToPrivilegeRequest** | [**AssignUsersToPrivilegeRequest**](AssignUsersToPrivilegeRequest.md)|  | [optional] |

### Return type

[**AddPrivilegeToRole201Response**](AddPrivilegeToRole201Response.md)

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

<a name="createPrivilege"></a>
# **createPrivilege**
> CreatePrivilege200Response createPrivilege(privilege)

Create a Privilege

Create privilege

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.PrivilegesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    PrivilegesApi apiInstance = new PrivilegesApi(defaultClient);
    Privilege privilege = new Privilege(); // Privilege | 
    try {
      CreatePrivilege200Response result = apiInstance.createPrivilege(privilege);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivilegesApi#createPrivilege");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **privilege** | [**Privilege**](Privilege.md)|  | [optional] |

### Return type

[**CreatePrivilege200Response**](CreatePrivilege200Response.md)

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

<a name="deletePrivilege"></a>
# **deletePrivilege**
> deletePrivilege(privilegeId)

Delete a Privilege

Delete

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.PrivilegesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    PrivilegesApi apiInstance = new PrivilegesApi(defaultClient);
    String privilegeId = "privilegeId_example"; // String | 
    try {
      apiInstance.deletePrivilege(privilegeId);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivilegesApi#deletePrivilege");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **privilegeId** | **String**|  | |

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

<a name="deleteRoleFromPrivilege"></a>
# **deleteRoleFromPrivilege**
> deleteRoleFromPrivilege(privilegeId, roleId)

Remove a Privilege from a Role

Add roles to privilege

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.PrivilegesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    PrivilegesApi apiInstance = new PrivilegesApi(defaultClient);
    String privilegeId = "privilegeId_example"; // String | 
    String roleId = "roleId_example"; // String | Set to the id of the role you want to return.
    try {
      apiInstance.deleteRoleFromPrivilege(privilegeId, roleId);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivilegesApi#deleteRoleFromPrivilege");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **privilegeId** | **String**|  | |
| **roleId** | **String**| Set to the id of the role you want to return. | |

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

<a name="getAssignedUser"></a>
# **getAssignedUser**
> GetAssignedUser200Response getAssignedUser(privilegeId)

Get Users assigned to a Privilege

Get Assigned Users

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.PrivilegesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    PrivilegesApi apiInstance = new PrivilegesApi(defaultClient);
    String privilegeId = "privilegeId_example"; // String | 
    try {
      GetAssignedUser200Response result = apiInstance.getAssignedUser(privilegeId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivilegesApi#getAssignedUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **privilegeId** | **String**|  | |

### Return type

[**GetAssignedUser200Response**](GetAssignedUser200Response.md)

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

<a name="getPrivilege"></a>
# **getPrivilege**
> Privilege getPrivilege(privilegeId)

Get a Privilege

Get a Privilige

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.PrivilegesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    PrivilegesApi apiInstance = new PrivilegesApi(defaultClient);
    String privilegeId = "privilegeId_example"; // String | 
    try {
      Privilege result = apiInstance.getPrivilege(privilegeId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivilegesApi#getPrivilege");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **privilegeId** | **String**|  | |

### Return type

[**Privilege**](Privilege.md)

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

<a name="listPrivelegeRoles"></a>
# **listPrivelegeRoles**
> ListPrivelegeRoles200Response listPrivelegeRoles(privilegeId)

Get Roles assigned to Privilege

List roles for privilege

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.PrivilegesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    PrivilegesApi apiInstance = new PrivilegesApi(defaultClient);
    String privilegeId = "privilegeId_example"; // String | 
    try {
      ListPrivelegeRoles200Response result = apiInstance.listPrivelegeRoles(privilegeId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivilegesApi#listPrivelegeRoles");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **privilegeId** | **String**|  | |

### Return type

[**ListPrivelegeRoles200Response**](ListPrivelegeRoles200Response.md)

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

<a name="listPriveleges"></a>
# **listPriveleges**
> List&lt;Privilege&gt; listPriveleges()

List Privileges

List Privileges

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.PrivilegesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    PrivilegesApi apiInstance = new PrivilegesApi(defaultClient);
    try {
      List<Privilege> result = apiInstance.listPriveleges();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivilegesApi#listPriveleges");
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

[**List&lt;Privilege&gt;**](Privilege.md)

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

<a name="removeUserFromPrivilege"></a>
# **removeUserFromPrivilege**
> removeUserFromPrivilege(privilegeId, userId)

Remove a Privilege from Users

Remove a Privilege from Users

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.PrivilegesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    PrivilegesApi apiInstance = new PrivilegesApi(defaultClient);
    String privilegeId = "privilegeId_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    try {
      apiInstance.removeUserFromPrivilege(privilegeId, userId);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivilegesApi#removeUserFromPrivilege");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **privilegeId** | **String**|  | |
| **userId** | **Integer**| Set to the id of the user that you want to return. | |

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

<a name="updatePrivilege"></a>
# **updatePrivilege**
> UpdatePrivilege200Response updatePrivilege(privilegeId, privilege)

Update a Privilege

Update privilege

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.PrivilegesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    PrivilegesApi apiInstance = new PrivilegesApi(defaultClient);
    String privilegeId = "privilegeId_example"; // String | 
    Privilege privilege = new Privilege(); // Privilege | 
    try {
      UpdatePrivilege200Response result = apiInstance.updatePrivilege(privilegeId, privilege);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivilegesApi#updatePrivilege");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **privilegeId** | **String**|  | |
| **privilege** | [**Privilege**](Privilege.md)|  | [optional] |

### Return type

[**UpdatePrivilege200Response**](UpdatePrivilege200Response.md)

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

