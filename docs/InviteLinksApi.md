# InviteLinksApi

All URIs are relative to *https://your-api-subdomain.onelogin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getInviteLink**](InviteLinksApi.md#getInviteLink) | **POST** /api/1/invites/get_invite_link | Generate Invite Link |
| [**sendInviteLink**](InviteLinksApi.md#sendInviteLink) | **POST** /api/1/invites/send_invite_link | Send  Invite Link |


<a name="getInviteLink"></a>
# **getInviteLink**
> GetInviteLink200Response getInviteLink(getInviteLinkRequest)

Generate Invite Link

Generate Invite Link

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.InviteLinksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    InviteLinksApi apiInstance = new InviteLinksApi(defaultClient);
    GetInviteLinkRequest getInviteLinkRequest = new GetInviteLinkRequest(); // GetInviteLinkRequest | 
    try {
      GetInviteLink200Response result = apiInstance.getInviteLink(getInviteLinkRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InviteLinksApi#getInviteLink");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **getInviteLinkRequest** | [**GetInviteLinkRequest**](GetInviteLinkRequest.md)|  | [optional] |

### Return type

[**GetInviteLink200Response**](GetInviteLink200Response.md)

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

<a name="sendInviteLink"></a>
# **sendInviteLink**
> SendInviteLink200Response sendInviteLink(sendInviteLinkRequest)

Send  Invite Link

Send Invite Link

### Example
```java
// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import org.openapitools.client.api.InviteLinksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    InviteLinksApi apiInstance = new InviteLinksApi(defaultClient);
    SendInviteLinkRequest sendInviteLinkRequest = new SendInviteLinkRequest(); // SendInviteLinkRequest | 
    try {
      SendInviteLink200Response result = apiInstance.sendInviteLink(sendInviteLinkRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InviteLinksApi#sendInviteLink");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **sendInviteLinkRequest** | [**SendInviteLinkRequest**](SendInviteLinkRequest.md)|  | [optional] |

### Return type

[**SendInviteLink200Response**](SendInviteLink200Response.md)

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

