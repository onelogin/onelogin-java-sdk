# UsersV1Api

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addRolesToUser**](UsersV1Api.md#addRolesToUser) | **PUT** /api/1/users/{user_id}/add_roles | Add Roles for a User |
| [**createUser**](UsersV1Api.md#createUser) | **POST** /api/1/users | Create a User |
| [**deleteUser**](UsersV1Api.md#deleteUser) | **DELETE** /api/1/users/{user_id} | Delete a User |
| [**getCustomAttributes**](UsersV1Api.md#getCustomAttributes) | **GET** /api/1/users/custom_attributes | Get Custom Attributes |
| [**getUserApps**](UsersV1Api.md#getUserApps) | **GET** /api/1/users/{user_id}/apps | Get Apps for a User |
| [**getUserById**](UsersV1Api.md#getUserById) | **GET** /api/1/users/{user_id} | Get User by ID |
| [**getUserRoles**](UsersV1Api.md#getUserRoles) | **GET** /api/1/users/{user_id}/roles | Get Roles for a User |
| [**listUsers**](UsersV1Api.md#listUsers) | **GET** /api/1/users | List Users |
| [**lockAccountUser**](UsersV1Api.md#lockAccountUser) | **PUT** /api/1/users/{user_id}/lock_user | Lock User Account |
| [**logOutUser**](UsersV1Api.md#logOutUser) | **PUT** /api/1/users/{user_id}/logout | Log User Out |
| [**removeUserRole**](UsersV1Api.md#removeUserRole) | **PUT** /api/1/users/{user_id}/remove_roles | Remove Roles for a User |
| [**setUserState**](UsersV1Api.md#setUserState) | **PUT** /api/1/users/{user_id}/set_state | Set User State |
| [**updatePasswordInsecure**](UsersV1Api.md#updatePasswordInsecure) | **PUT** /api/1/users/set_password_clear_text/{user_id} | Set Password Using ID in Cleartext |
| [**updatePasswordSecure**](UsersV1Api.md#updatePasswordSecure) | **PUT** /api/1/users/set_password_using_salt/{user_id} | Set Password Using ID and SHA-256 and Salt |
| [**updateUser**](UsersV1Api.md#updateUser) | **PUT** /api/1/users/{user_id} | Update a User |


<a name="addRolesToUser"></a>
# **addRolesToUser**
> Error addRolesToUser(userId, addRolesToUserRequest)

Add Roles for a User

Add Roles for a User

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    AddRolesToUserRequest addRolesToUserRequest = new AddRolesToUserRequest(); // AddRolesToUserRequest | 
    try {
      Error result = apiInstance.addRolesToUser(userId, addRolesToUserRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#addRolesToUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **addRolesToUserRequest** | [**AddRolesToUserRequest**](AddRolesToUserRequest.md)|  | [optional] |

### Return type

[**Error**](Error.md)

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
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a name="createUser"></a>
# **createUser**
> User createUser(mappings, validatePolicy, user)

Create a User

Create a User

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    String mappings = "async"; // String | Controls how mappings will be applied to the user on creation. Defaults to async.
    Boolean validatePolicy = true; // Boolean | Will passwords validate against the User Policy? Defaults to true.
    User user = new User(); // User | 
    try {
      User result = apiInstance.createUser(mappings, validatePolicy, user);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#createUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **mappings** | **String**| Controls how mappings will be applied to the user on creation. Defaults to async. | [optional] [enum: async, sync, disabled] |
| **validatePolicy** | **Boolean**| Will passwords validate against the User Policy? Defaults to true. | [optional] |
| **user** | [**User**](User.md)|  | [optional] |

### Return type

[**User**](User.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The full user resource is returned |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unprocessable |  -  |

<a name="deleteUser"></a>
# **deleteUser**
> deleteUser(userId)

Delete a User

Delete A User

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    try {
      apiInstance.deleteUser(userId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#deleteUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
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
| **204** | On success, no content is returned in the response body. |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a name="getCustomAttributes"></a>
# **getCustomAttributes**
> GetCustomAttributes200Response getCustomAttributes()

Get Custom Attributes

Get Custom Attributes

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    try {
      GetCustomAttributes200Response result = apiInstance.getCustomAttributes();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#getCustomAttributes");
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

[**GetCustomAttributes200Response**](GetCustomAttributes200Response.md)

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

<a name="getUserApps"></a>
# **getUserApps**
> List&lt;GetUserApps200ResponseInner&gt; getUserApps(userId, ignoreVisibility)

Get Apps for a User

Get Apps for User

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    Boolean ignoreVisibility = false; // Boolean | Defaults to `false`. When `true` will show all apps that are assigned to a user regardless of their portal visibility setting.
    try {
      List<GetUserApps200ResponseInner> result = apiInstance.getUserApps(userId, ignoreVisibility);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#getUserApps");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **ignoreVisibility** | **Boolean**| Defaults to &#x60;false&#x60;. When &#x60;true&#x60; will show all apps that are assigned to a user regardless of their portal visibility setting. | [optional] [default to false] |

### Return type

[**List&lt;GetUserApps200ResponseInner&gt;**](GetUserApps200ResponseInner.md)

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

<a name="getUserById"></a>
# **getUserById**
> User getUserById(userId)

Get User by ID

Get User By ID

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    try {
      User result = apiInstance.getUserById(userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#getUserById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **Integer**| Set to the id of the user that you want to return. | |

### Return type

[**User**](User.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **404** | Not Found |  -  |

<a name="getUserRoles"></a>
# **getUserRoles**
> GetUserRoles200Response getUserRoles(userId)

Get Roles for a User

Get User Roles

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    try {
      GetUserRoles200Response result = apiInstance.getUserRoles(userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#getUserRoles");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **Integer**| Set to the id of the user that you want to return. | |

### Return type

[**GetUserRoles200Response**](GetUserRoles200Response.md)

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

<a name="listUsers"></a>
# **listUsers**
> List&lt;User&gt; listUsers(limit, page, cursor, createdSince, createdUntil, updatedSince, updatedUntil, lastLoginSince, lastLoginUntil, firstname, lastname, email, username, samaccountname, directoryId, externalId, userIds, customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket, fields)

List Users

List Users

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    Integer limit = 56; // Integer | How many items to return at one time (max 100)
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
    Integer directoryId = 56; // Integer | 
    String externalId = "externalId_example"; // String | An external identifier that has been set on the user
    String userIds = "userIds_example"; // String | A comma separated list of OneLogin User IDs
    String customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket = "customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket_example"; // String | The short name of a custom attribute. Note that the attribute name is prefixed with custom_attributes.
    String fields = "apps"; // String | Optional. Comma delimited list of fields to return.
    try {
      List<User> result = apiInstance.listUsers(limit, page, cursor, createdSince, createdUntil, updatedSince, updatedUntil, lastLoginSince, lastLoginUntil, firstname, lastname, email, username, samaccountname, directoryId, externalId, userIds, customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket, fields);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#listUsers");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
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
| **directoryId** | **Integer**|  | [optional] |
| **externalId** | **String**| An external identifier that has been set on the user | [optional] |
| **userIds** | **String**| A comma separated list of OneLogin User IDs | [optional] |
| **customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket** | **String**| The short name of a custom attribute. Note that the attribute name is prefixed with custom_attributes. | [optional] |
| **fields** | **String**| Optional. Comma delimited list of fields to return. | [optional] [enum: apps, users, admins] |

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Current-Page -  <br>  * Page-Items -  <br>  * Total-Count -  <br>  * Total-Pages -  <br>  * Link -  <br>  * Before-Cursor -  <br>  * After-Cursor -  <br>  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unprocessable |  -  |

<a name="lockAccountUser"></a>
# **lockAccountUser**
> Error lockAccountUser(userId, lockAccountUserRequest)

Lock User Account

Lock User Account

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    LockAccountUserRequest lockAccountUserRequest = new LockAccountUserRequest(); // LockAccountUserRequest | 
    try {
      Error result = apiInstance.lockAccountUser(userId, lockAccountUserRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#lockAccountUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **lockAccountUserRequest** | [**LockAccountUserRequest**](LockAccountUserRequest.md)|  | [optional] |

### Return type

[**Error**](Error.md)

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
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a name="logOutUser"></a>
# **logOutUser**
> Error logOutUser(userId, body)

Log User Out

Log Out User

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    Object body = null; // Object | 
    try {
      Error result = apiInstance.logOutUser(userId, body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#logOutUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **body** | **Object**|  | [optional] |

### Return type

[**Error**](Error.md)

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
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a name="removeUserRole"></a>
# **removeUserRole**
> Error removeUserRole(userId, removeUserRoleRequest)

Remove Roles for a User

Remove Roles for a User

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    RemoveUserRoleRequest removeUserRoleRequest = new RemoveUserRoleRequest(); // RemoveUserRoleRequest | 
    try {
      Error result = apiInstance.removeUserRole(userId, removeUserRoleRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#removeUserRole");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **removeUserRoleRequest** | [**RemoveUserRoleRequest**](RemoveUserRoleRequest.md)|  | [optional] |

### Return type

[**Error**](Error.md)

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
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a name="setUserState"></a>
# **setUserState**
> Error setUserState(userId, setUserStateRequest)

Set User State

Set User State

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    SetUserStateRequest setUserStateRequest = new SetUserStateRequest(); // SetUserStateRequest | 
    try {
      Error result = apiInstance.setUserState(userId, setUserStateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#setUserState");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **setUserStateRequest** | [**SetUserStateRequest**](SetUserStateRequest.md)|  | [optional] |

### Return type

[**Error**](Error.md)

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
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a name="updatePasswordInsecure"></a>
# **updatePasswordInsecure**
> Error updatePasswordInsecure(userId, updatePasswordInsecureRequest)

Set Password Using ID in Cleartext

Update User password using their ID. This is done in cleartext and is insecure.

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    UpdatePasswordInsecureRequest updatePasswordInsecureRequest = new UpdatePasswordInsecureRequest(); // UpdatePasswordInsecureRequest | 
    try {
      Error result = apiInstance.updatePasswordInsecure(userId, updatePasswordInsecureRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#updatePasswordInsecure");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **updatePasswordInsecureRequest** | [**UpdatePasswordInsecureRequest**](UpdatePasswordInsecureRequest.md)|  | [optional] |

### Return type

[**Error**](Error.md)

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
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a name="updatePasswordSecure"></a>
# **updatePasswordSecure**
> Error updatePasswordSecure(userId, updatePasswordSecureRequest)

Set Password Using ID and SHA-256 and Salt

Update User Password Using ID and SHA-256 with salt.

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    UpdatePasswordSecureRequest updatePasswordSecureRequest = new UpdatePasswordSecureRequest(); // UpdatePasswordSecureRequest | 
    try {
      Error result = apiInstance.updatePasswordSecure(userId, updatePasswordSecureRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#updatePasswordSecure");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **updatePasswordSecureRequest** | [**UpdatePasswordSecureRequest**](UpdatePasswordSecureRequest.md)|  | [optional] |

### Return type

[**Error**](Error.md)

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
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a name="updateUser"></a>
# **updateUser**
> User updateUser(userId, mappings, validatePolicy, user)

Update a User

Update a User

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV1Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV1Api apiInstance = new UsersV1Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    String mappings = "async"; // String | Controls how mappings will be applied to the user on creation. Defaults to async.
    Boolean validatePolicy = true; // Boolean | Will passwords validate against the User Policy? Defaults to true.
    User user = new User(); // User | 
    try {
      User result = apiInstance.updateUser(userId, mappings, validatePolicy, user);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV1Api#updateUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userId** | **Integer**| Set to the id of the user that you want to return. | |
| **mappings** | **String**| Controls how mappings will be applied to the user on creation. Defaults to async. | [optional] [enum: async, sync, disabled] |
| **validatePolicy** | **Boolean**| Will passwords validate against the User Policy? Defaults to true. | [optional] |
| **user** | [**User**](User.md)|  | [optional] |

### Return type

[**User**](User.md)

### Authorization

[OAuth2](../README.md#OAuth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The full user resource is returned |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Unprocessable |  -  |

