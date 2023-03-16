# EventsApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getEventById**](EventsApi.md#getEventById) | **GET** /api/1/events/{event_id} | Get Event by ID |
| [**getEventTypes**](EventsApi.md#getEventTypes) | **GET** /api/1/events/types | Get Event Types |
| [**getEvents**](EventsApi.md#getEvents) | **GET** /api/1/events | Get Events |


<a name="getEventById"></a>
# **getEventById**
> GetEventById200Response getEventById(eventId)

Get Event by ID

Get Event By ID

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.EventsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    EventsApi apiInstance = new EventsApi(defaultClient);
    Integer eventId = 56; // Integer | 
    try {
      GetEventById200Response result = apiInstance.getEventById(eventId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EventsApi#getEventById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
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

### Return type

[**GetEventById200Response**](GetEventById200Response.md)

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
| **404** | Not Found |  -  |

<a name="getEventTypes"></a>
# **getEventTypes**
> GetEventTypes200Response getEventTypes(contentType)

Get Event Types

Get Event types

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.models.*;
import org.openapitools.client.api.EventsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");

    EventsApi apiInstance = new EventsApi(defaultClient);
    String contentType = "application/json"; // String | 
    try {
      GetEventTypes200Response result = apiInstance.getEventTypes(contentType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EventsApi#getEventTypes");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
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

### Return type

[**GetEventTypes200Response**](GetEventTypes200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful response |  -  |

<a name="getEvents"></a>
# **getEvents**
> GetEvents200Response getEvents(eventTypeId, clientId, directoryId, id, createdAt, resolution, since, until, userId)

Get Events

Get Events

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.EventsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    EventsApi apiInstance = new EventsApi(defaultClient);
    List<Integer> eventTypeId = Arrays.asList(); // List<Integer> | 
    Integer clientId = 56; // Integer | 
    Integer directoryId = 56; // Integer | 
    Integer id = 56; // Integer | 
    String createdAt = "createdAt_example"; // String | 
    String resolution = "resolution_example"; // String | 
    String since = "since_example"; // String | 
    String until = "until_example"; // String | 
    Integer userId = 56; // Integer | Set to the id of the user that you want to return.
    try {
      GetEvents200Response result = apiInstance.getEvents(eventTypeId, clientId, directoryId, id, createdAt, resolution, since, until, userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EventsApi#getEvents");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **eventTypeId** | [**List&lt;Integer&gt;**](Integer.md)|  | [optional] |
| **clientId** | **Integer**|  | [optional] |
| **directoryId** | **Integer**|  | [optional] |
| **id** | **Integer**|  | [optional] |
| **createdAt** | **String**|  | [optional] |
| **resolution** | **String**|  | [optional] |
| **since** | **String**|  | [optional] |
| **until** | **String**|  | [optional] |
| **userId** | **Integer**| Set to the id of the user that you want to return. | [optional] |

### Return type

[**GetEvents200Response**](GetEvents200Response.md)

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

