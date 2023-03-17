# RolesApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addRoleAdmins**](RolesApi.md#addRoleAdmins) | **POST** /api/2/roles/{role_id}/admins | Add Role Admins |
| [**addRoleUsers**](RolesApi.md#addRoleUsers) | **POST** /api/2/roles/{role_id}/users | Add Role Users |
| [**createRole**](RolesApi.md#createRole) | **POST** /api/2/roles | Create Role |
| [**deleteRole**](RolesApi.md#deleteRole) | **DELETE** /api/2/roles/{role_id} | Delete Role by ID |
| [**getRole**](RolesApi.md#getRole) | **GET** /api/2/roles/{role_id} | Get Role by ID |
| [**getRoleAdmins**](RolesApi.md#getRoleAdmins) | **GET** /api/2/roles/{role_id}/admins | Get Role Admins |
| [**getRoleApps**](RolesApi.md#getRoleApps) | **GET** /api/2/roles/{role_id}/apps | Get all Apps assigned to Role |
| [**getRoleById**](RolesApi.md#getRoleById) | **GET** /api/1/roles/{role_id} | Get Role by ID |
| [**getRoleByName**](RolesApi.md#getRoleByName) | **GET** /api/1/roles | Get Role by Name |
| [**getRoleUsers**](RolesApi.md#getRoleUsers) | **GET** /api/2/roles/{role_id}/users | Get Role Users |
| [**listRoles**](RolesApi.md#listRoles) | **GET** /api/2/roles | List Roles |
| [**removeRoleAdmins**](RolesApi.md#removeRoleAdmins) | **DELETE** /api/2/roles/{role_id}/admins | Remove Role Admins |
| [**removeRoleUsers**](RolesApi.md#removeRoleUsers) | **DELETE** /api/2/roles/{role_id}/users | Remove Role Users |
| [**setRoleApps**](RolesApi.md#setRoleApps) | **PUT** /api/2/roles/{role_id}/apps | Set Role Apps |
| [**updateRole**](RolesApi.md#updateRole) | **PUT** /api/2/roles/{role_id} | Update Role |


<a name="addRoleAdmins"></a>
# **addRoleAdmins**
> List&lt;CreateRole201ResponseInner&gt; addRoleAdmins(roleId, requestBody)

Add Role Admins

Add Role Admins

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    String roleId = "roleId_example"; // String | Set to the id of the role you want to return.
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | 
    try {
      List<CreateRole201ResponseInner> result = apiInstance.addRoleAdmins(roleId, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#addRoleAdmins");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **roleId** | **String**| Set to the id of the role you want to return. | |
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)|  | |

### Return type

[**List&lt;CreateRole201ResponseInner&gt;**](CreateRole201ResponseInner.md)

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

<a name="addRoleUsers"></a>
# **addRoleUsers**
> List&lt;CreateRole201ResponseInner&gt; addRoleUsers(roleId, requestBody)

Add Role Users

Add Role Users

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    String roleId = "roleId_example"; // String | Set to the id of the role you want to return.
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | 
    try {
      List<CreateRole201ResponseInner> result = apiInstance.addRoleUsers(roleId, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#addRoleUsers");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **roleId** | **String**| Set to the id of the role you want to return. | |
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)|  | |

### Return type

[**List&lt;CreateRole201ResponseInner&gt;**](CreateRole201ResponseInner.md)

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
| **422** | Unprocessable Entity |  -  |

<a name="createRole"></a>
# **createRole**
> List&lt;CreateRole201ResponseInner&gt; createRole(role)

Create Role

Create Role

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    Role role = new Role(); // Role | 
    try {
      List<CreateRole201ResponseInner> result = apiInstance.createRole(role);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#createRole");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **role** | [**Role**](Role.md)|  | [optional] |

### Return type

[**List&lt;CreateRole201ResponseInner&gt;**](CreateRole201ResponseInner.md)

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

<a name="deleteRole"></a>
# **deleteRole**
> deleteRole(roleId)

Delete Role by ID

Delete Role

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    String roleId = "roleId_example"; // String | Set to the id of the role you want to return.
    try {
      apiInstance.deleteRole(roleId);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#deleteRole");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
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
| **204** | NO CONTENT |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a name="getRole"></a>
# **getRole**
> Role getRole(roleId)

Get Role by ID

Get Role

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    String roleId = "roleId_example"; // String | Set to the id of the role you want to return.
    try {
      Role result = apiInstance.getRole(roleId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#getRole");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **roleId** | **String**| Set to the id of the role you want to return. | |

### Return type

[**Role**](Role.md)

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

<a name="getRoleAdmins"></a>
# **getRoleAdmins**
> List&lt;User&gt; getRoleAdmins(roleId, limit, page, cursor, name, includeUnassigned)

Get Role Admins

Get Role Admins

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    String roleId = "roleId_example"; // String | Set to the id of the role you want to return.
    Integer limit = 56; // Integer | How many items to return at one time (max 100)
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String name = "name_example"; // String | Allows you to filter on first name, last name, username, and email address.
    Boolean includeUnassigned = true; // Boolean | Optional. Defaults to false. Include users that aren’t assigned to the role.
    try {
      List<User> result = apiInstance.getRoleAdmins(roleId, limit, page, cursor, name, includeUnassigned);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#getRoleAdmins");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **roleId** | **String**| Set to the id of the role you want to return. | |
| **limit** | **Integer**| How many items to return at one time (max 100) | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **name** | **String**| Allows you to filter on first name, last name, username, and email address. | [optional] |
| **includeUnassigned** | **Boolean**| Optional. Defaults to false. Include users that aren’t assigned to the role. | [optional] |

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: applcation/json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a name="getRoleApps"></a>
# **getRoleApps**
> List&lt;GetRoleApps200ResponseInner&gt; getRoleApps(roleId, limit, page, cursor, assigned)

Get all Apps assigned to Role

Get Role Apps

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    String roleId = "roleId_example"; // String | Set to the id of the role you want to return.
    Integer limit = 56; // Integer | How many items to return at one time (max 100)
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    Boolean assigned = true; // Boolean | Optional. Defaults to true. Returns all apps not yet assigned to the role.
    try {
      List<GetRoleApps200ResponseInner> result = apiInstance.getRoleApps(roleId, limit, page, cursor, assigned);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#getRoleApps");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **roleId** | **String**| Set to the id of the role you want to return. | |
| **limit** | **Integer**| How many items to return at one time (max 100) | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **assigned** | **Boolean**| Optional. Defaults to true. Returns all apps not yet assigned to the role. | [optional] |

### Return type

[**List&lt;GetRoleApps200ResponseInner&gt;**](GetRoleApps200ResponseInner.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: applcation/json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a name="getRoleById"></a>
# **getRoleById**
> GetRoleById200Response getRoleById(roleId)

Get Role by ID

Get Role By ID

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    String roleId = "roleId_example"; // String | Set to the id of the role you want to return.
    try {
      GetRoleById200Response result = apiInstance.getRoleById(roleId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#getRoleById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **roleId** | **String**| Set to the id of the role you want to return. | |

### Return type

[**GetRoleById200Response**](GetRoleById200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a name="getRoleByName"></a>
# **getRoleByName**
> GetRoleByName200Response getRoleByName(name)

Get Role by Name

Get Role by Name

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    String name = "name_example"; // String | 
    try {
      GetRoleByName200Response result = apiInstance.getRoleByName(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#getRoleByName");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**|  | [optional] |

### Return type

[**GetRoleByName200Response**](GetRoleByName200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |

<a name="getRoleUsers"></a>
# **getRoleUsers**
> List&lt;User&gt; getRoleUsers(roleId, limit, page, cursor, name, includeUnassigned)

Get Role Users

Get Role Users

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    String roleId = "roleId_example"; // String | Set to the id of the role you want to return.
    Integer limit = 56; // Integer | How many items to return at one time (max 100)
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String name = "name_example"; // String | Allows you to filter on first name, last name, username, and email address.
    Boolean includeUnassigned = true; // Boolean | Optional. Defaults to false. Include users that aren’t assigned to the role.
    try {
      List<User> result = apiInstance.getRoleUsers(roleId, limit, page, cursor, name, includeUnassigned);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#getRoleUsers");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **roleId** | **String**| Set to the id of the role you want to return. | |
| **limit** | **Integer**| How many items to return at one time (max 100) | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **name** | **String**| Allows you to filter on first name, last name, username, and email address. | [optional] |
| **includeUnassigned** | **Boolean**| Optional. Defaults to false. Include users that aren’t assigned to the role. | [optional] |

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: applcation/json, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a name="listRoles"></a>
# **listRoles**
> List&lt;Role&gt; listRoles(appId, limit, page, cursor, roleName, appName, fields)

List Roles

List Roles

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    Integer appId = 56; // Integer | 
    Integer limit = 56; // Integer | How many items to return at one time (max 100)
    Integer page = 56; // Integer | The page number of results to return.
    String cursor = "cursor_example"; // String | Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page.
    String roleName = "roleName_example"; // String | Optional. Filters by role name.
    String appName = "appName_example"; // String | Optional. Returns roles that contain this app name.
    String fields = "apps"; // String | Optional. Comma delimited list of fields to return.
    try {
      List<Role> result = apiInstance.listRoles(appId, limit, page, cursor, roleName, appName, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#listRoles");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
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
| **limit** | **Integer**| How many items to return at one time (max 100) | [optional] |
| **page** | **Integer**| The page number of results to return. | [optional] |
| **cursor** | **String**| Set to the value extracted from Before-Cursor or After-Cursor headers to return the previous or next page. | [optional] |
| **roleName** | **String**| Optional. Filters by role name. | [optional] |
| **appName** | **String**| Optional. Returns roles that contain this app name. | [optional] |
| **fields** | **String**| Optional. Comma delimited list of fields to return. | [optional] [enum: apps, users, admins] |

### Return type

[**List&lt;Role&gt;**](Role.md)

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

<a name="removeRoleAdmins"></a>
# **removeRoleAdmins**
> removeRoleAdmins(roleId, removeRoleUsersRequest)

Remove Role Admins

Remove Role Admins

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    String roleId = "roleId_example"; // String | Set to the id of the role you want to return.
    RemoveRoleUsersRequest removeRoleUsersRequest = new RemoveRoleUsersRequest(); // RemoveRoleUsersRequest | 
    try {
      apiInstance.removeRoleAdmins(roleId, removeRoleUsersRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#removeRoleAdmins");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **roleId** | **String**| Set to the id of the role you want to return. | |
| **removeRoleUsersRequest** | [**RemoveRoleUsersRequest**](RemoveRoleUsersRequest.md)|  | |

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
| **204** | NO CONTENT |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a name="removeRoleUsers"></a>
# **removeRoleUsers**
> removeRoleUsers(roleId, removeRoleUsersRequest)

Remove Role Users

Remove Role Users

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    String roleId = "roleId_example"; // String | Set to the id of the role you want to return.
    RemoveRoleUsersRequest removeRoleUsersRequest = new RemoveRoleUsersRequest(); // RemoveRoleUsersRequest | 
    try {
      apiInstance.removeRoleUsers(roleId, removeRoleUsersRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#removeRoleUsers");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **roleId** | **String**| Set to the id of the role you want to return. | |
| **removeRoleUsersRequest** | [**RemoveRoleUsersRequest**](RemoveRoleUsersRequest.md)|  | |

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
| **204** | NO CONTENT |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a name="setRoleApps"></a>
# **setRoleApps**
> List&lt;CreateRole201ResponseInner&gt; setRoleApps(roleId, requestBody)

Set Role Apps

Set Role Apps

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    String roleId = "roleId_example"; // String | Set to the id of the role you want to return.
    List<Integer> requestBody = Arrays.asList(); // List<Integer> | 
    try {
      List<CreateRole201ResponseInner> result = apiInstance.setRoleApps(roleId, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#setRoleApps");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **roleId** | **String**| Set to the id of the role you want to return. | |
| **requestBody** | [**List&lt;Integer&gt;**](Integer.md)|  | |

### Return type

[**List&lt;CreateRole201ResponseInner&gt;**](CreateRole201ResponseInner.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The response returns an array of app IDs sent in the request. |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a name="updateRole"></a>
# **updateRole**
> UpdateRole200Response updateRole(roleId, role)

Update Role

Update Role

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.RolesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    RolesApi apiInstance = new RolesApi(defaultClient);
    String roleId = "roleId_example"; // String | Set to the id of the role you want to return.
    Role role = new Role(); // Role | 
    try {
      UpdateRole200Response result = apiInstance.updateRole(roleId, role);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#updateRole");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **roleId** | **String**| Set to the id of the role you want to return. | |
| **role** | [**Role**](Role.md)|  | [optional] |

### Return type

[**UpdateRole200Response**](UpdateRole200Response.md)

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
| **422** | Unprocessable Entity |  -  |

