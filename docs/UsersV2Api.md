# UsersV2Api

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createUser2**](UsersV2Api.md#createUser2) | **POST** /api/2/users | Create User |
| [**deleteUser2**](UsersV2Api.md#deleteUser2) | **DELETE** /api/2/users/{user_id} | Delete User |
| [**getUser2**](UsersV2Api.md#getUser2) | **GET** /api/2/users/{user_id} | Get User |
| [**getUserApps2**](UsersV2Api.md#getUserApps2) | **GET** /api/2/users/{user_id}/apps | Get User Apps |
| [**listUsers2**](UsersV2Api.md#listUsers2) | **GET** /api/2/users | List Users |
| [**updateUser2**](UsersV2Api.md#updateUser2) | **PUT** /api/2/users/{user_id} | Update User |


<a id="createUser2"></a>
# **createUser2**
> User createUser2(mappings, validatePolicy, user)

Create User

Create User

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");

    UsersV2Api apiInstance = new UsersV2Api(defaultClient);
    String mappings = "async"; // String | Controls how mappings will be applied to the user on creation. Defaults to async.
    Boolean validatePolicy = true; // Boolean | Will passwords validate against the User Policy? Defaults to true.
    User user = new User(); // User | 
    try {
      User result = apiInstance.createUser2(mappings, validatePolicy, user);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV2Api#createUser2");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
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

No authorization required

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

<a id="deleteUser2"></a>
# **deleteUser2**
> deleteUser2(userId)

Delete User

Delete User

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV2Api apiInstance = new UsersV2Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    try {
      apiInstance.deleteUser2(userId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV2Api#deleteUser2");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
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

<a id="getUser2"></a>
# **getUser2**
> User getUser2(userId)

Get User

Get User

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV2Api apiInstance = new UsersV2Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    try {
      User result = apiInstance.getUser2(userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV2Api#getUser2");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
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

<a id="getUserApps2"></a>
# **getUserApps2**
> List&lt;GetUserApps200ResponseInner&gt; getUserApps2(userId, ignoreVisibility)

Get User Apps

Get User Apps

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV2Api apiInstance = new UsersV2Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    Boolean ignoreVisibility = false; // Boolean | Defaults to `false`. When `true` will show all apps that are assigned to a user regardless of their portal visibility setting.
    try {
      List<GetUserApps200ResponseInner> result = apiInstance.getUserApps2(userId, ignoreVisibility);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV2Api#getUserApps2");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
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

<a id="listUsers2"></a>
# **listUsers2**
> List&lt;User&gt; listUsers2(limit, page, cursor, createdSince, createdUntil, updatedSince, updatedUntil, lastLoginSince, lastLoginUntil, firstname, lastname, email, username, samaccountname, directoryId, externalId, userIds, customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket, fields, appId)

List Users

Get a list of users

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    UsersV2Api apiInstance = new UsersV2Api(defaultClient);
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
    Integer appId = 56; // Integer | 
    try {
      List<User> result = apiInstance.listUsers2(limit, page, cursor, createdSince, createdUntil, updatedSince, updatedUntil, lastLoginSince, lastLoginUntil, firstname, lastname, email, username, samaccountname, directoryId, externalId, userIds, customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket, fields, appId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV2Api#listUsers2");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
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
| **appId** | **Integer**|  | [optional] |

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
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unprocessable |  -  |

<a id="updateUser2"></a>
# **updateUser2**
> User updateUser2(userId, mappings, validatePolicy, user)

Update User

Update User

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.models.*;
import com.onelogin.client.api.UsersV2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");

    UsersV2Api apiInstance = new UsersV2Api(defaultClient);
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    String mappings = "async"; // String | Controls how mappings will be applied to the user on creation. Defaults to async.
    Boolean validatePolicy = true; // Boolean | Will passwords validate against the User Policy? Defaults to true.
    User user = new User(); // User | 
    try {
      User result = apiInstance.updateUser2(userId, mappings, validatePolicy, user);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersV2Api#updateUser2");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
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

No authorization required

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

