# OneLogin's Java SDK

This SDK will let you execute all the API methods, version/1, described
at https://developers.onelogin.com/api-docs/1/getting-started/dev-overview.

## Installation
### Hosting
#### Github
The toolkit is hosted on github. You can download it from:
* Lastest release: https://github.com/onelogin/onelogin-java-sdk/releases/latest
* Master repo: https://github.com/onelogin/onelogin-java-sdk/tree/master

#### Maven
The toolkit is hosted at [Sonatype OSSRH (OSS Repository Hosting)](http://central.sonatype.org/pages/ossrh-guide.html) that is synced to the Central Repository.

Install it as a maven dependecy:
```
  <dependency>
      <groupId>com.onelogin</groupId>
      <artifactId>onelogin-java-sdk</artifactId>
      <version>1.3.2</version>
  </dependency>
```

### Dependencies
onelogin-java-sdk (com.onelogin:onelogin-java-sdk) has the following dependencies:

*core:*
* org.apache.oltu.oauth2.common
* org.apache.oltu.oauth2.client
* commons-code:commons
* javax.servlet:servlet-api
* org.apache.httpcomponents:httpclient
* org.json:json
* joda-time:joda-time

*testing:*
* junit:junit

*logging:*
* org.slf4j:slf4j-api
* ch.qos.logback:logback-classic

also the [Java Cryptography Extension (JCE)](https://en.wikipedia.org/wiki/Java_Cryptography_Extension) is required. If you don't have it, download the version of [jce-6](http://www.oracle.com/technetwork/java/javase/downloads/jce-6-download-429243.html), [jce-7](http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html) or [jce-8](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html), unzip it, and drop its content at
*${java.home}/jre/lib/security/*

*maven:*
* org.apache.maven.plugins:maven-jar-plugin
* org.apache.maven.plugins:maven-surefire-plugin
* org.apache.maven.plugins:maven-enforcer-plugin

For more info, open and read the [pom.xml](https://github.com/onelogin/onelogin-java-sdk/blob/master/pom.xml) file.


## Working with the github repository code and Eclipse.
### Get the sdk.
The sdk is hosted on github. You can download it from:
* Lastest release: https://github.com/onelogin/onelogin-java-sdk/releases/latest
* Master repo: https://github.com/onelogin/onelogin-java-sdk/tree/master

### Adding onelogin-java-sdk components as a project
1. Open Eclipse and set a workspace
2. File > Import > Maven : Existing Maven Projects > Select the path where the sdk was downloaded, resolve the Workspace project and select the pom.xml


## Getting started

### Javadocs

Javadocs of this SDK are published at:
https://onelogin.github.io/onelogin-java-sdk/index.html


### Settings

SDK settings are stored in a file named *onelogin.sdk.properties* that can be found at *src/resources* folder.

The SDK has 3 settings parameters:
* onelogin.sdk.client_id  Onelogin OAuth2 client ID
* onelogin.sdk.client_secret  Onelogin OAuth2 client secret
* onelogin.sdk.region  Indicates where the instance is hosted. Possible values: 'us' or 'eu'.
* onelogin.sdk.ip  Set an ip address value that can later be retrieved with the getIP method and used on the getSAMLAssertion method to bypass MFA protection if that IP was whitelisted on the user's policy.

Read more about Onelogin API credentials at:
https://developers.onelogin.com/api-docs/1/getting-started/working-with-api-credentials


### Errors and exceptions

Onelogin's API can return 400, 401, 403 or 404 when there was any issue executing the action. When that happens, the methods of the SDK will raise an OAuthProblemException.

If you want to avoid this kind of exceptions to be raised, you can edit the init method of the *main/java/com/onelogin/sdk/conn/OneloginOAuthJSONResourceResponse.java* file and try/catch the OAuthProblemException, then the error and description will be stored on the SDK Client object and you can retrieve them with *client.getError()* and *client.getErrorDescription()*.

### How it works

Following there is Java code that executes calls on all the available methods on the SDK.

It assumes that there are 2 users on the OL instance: 'user@example.com' and other with MFA enabled 'usermfa@example.com' and some roles, custom attributes and groups defined.

```java
package com.onelogin.sdk;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.xml.sax.SAXException;

import com.onelogin.sdk.conn.Client;
import com.onelogin.sdk.exception.Error;

import com.onelogin.sdk.model.App;
import com.onelogin.sdk.model.Event;
import com.onelogin.sdk.model.EventType;
import com.onelogin.sdk.model.Group;
import com.onelogin.sdk.model.MFA;
import com.onelogin.sdk.model.RateLimit;
import com.onelogin.sdk.model.Role;
import com.onelogin.sdk.model.SAMLEndpointResponse;
import com.onelogin.sdk.model.SessionTokenInfo;
import com.onelogin.sdk.model.SessionTokenMFAInfo;
import com.onelogin.sdk.model.User;


public class AppTest
{
    public static void main( String[] args ) throws IOException, Error, OAuthSystemException, OAuthProblemException, URISyntaxException, XPathExpressionException, ParserConfigurationException, SAXException, NoSuchFieldException
    {
        Client client = new Client();

        /* Get an AccessToken */
        client.getAccessToken();

        /* Refresh an AccessToken */
        client.refreshToken();

        /* Revoke an AccessToken */
        client.revokeToken();

        // By default methods call internally to getAccessToken()
        // if there is not valid access_token

        /* Get rate limits */
        RateLimit ratelimit = client.getRateLimit();

        /* Get Custom Attributes */
        List<String> globalCustomAttributes = client.getCustomAttributes();

        /* Get Users with no query parameters */
        List<User> users = client.getUsers();

        /* Get Users with query parameters */
        HashMap<String,String> userQueryParameters = new HashMap<String,String>();
        userQueryParameters.put("email", "user@example.com");
        List<User> usersFiltered = client.getUsers(userQueryParameters);

        HashMap<String,String> userQueryParameters2 = new HashMap<String,String>();
        userQueryParameters2.put("email", "usermfa@example.com");
        List<User> usersFiltered2 = client.getUsers(userQueryParameters2);

        /* Get User By ID */
        User user = client.getUser(usersFiltered.get(0).id);
        User userMFA = client.getUser(usersFiltered2.get(0).id);

        /* Update User with specific id */
        Map<String, Object> updateUserParams = user.getUserParams();
        updateUserParams.put("firstname", "modified_firstname");
        user = client.updateUser(user.id, updateUserParams);

        /* Get Global Roles */
        List<Role> roleIds = client.getRoles();

        /* Get Role */
        Role role = client.getRole(roleIds.get(0));
        Role role2 = client.getRole(roleIds.get(1));

        /* Assign & Remove Roles On Users */
        List<Long> newRoleIds = new ArrayList<Long>();
        newRoleIds.add(role.id);
        newRoleIds.add(role2.id);
        client.assignRoleToUser(user.id, newRoleIds);
        user = client.getUser(user.id);
        newRoleIds.remove(role2.id);
        client.removeRoleFromUser(user.id, newRoleIds);
        user = client.getUser(user.id);

        /* Sets Password by ID Using Cleartext */
        String password = "Aa765431-XxX";
        client.setPasswordUsingClearText(user.id, password, password);

        /* Sets Password by ID Using Salt and SHA-256 */
        password = "Aa765432-YyY";
        String salt = "11xxxx1";
        String hashedSaltedPassword = DigestUtils.sha256Hex(salt+password);
        client.setPasswordUsingHashSalt(userMFA.id, hashedSaltedPassword, hashedSaltedPassword, "salt+sha256", salt);

        /* Set Custom Attribute Value to User */
        Map<String, Object> customAttributes = new HashMap<String,Object>();
        customAttributes.put("customattr1", "xxxx");
        customAttributes.put("customattr2", "yyyy");
        client.setCustomAttributeToUser(user.id, customAttributes);

        /* Log Out User */
        client.logUserOut(user.id);

        /* Lock User */
        client.lockUser(user.id, 1);  // Lock the user 1 min

        /* Get User apps */
        List<App> userApps = client.getUserApps(user.id);

        /* Get User Roles */
        List<Integer> userRolesIds = client.getUserRoles(user.id);

        /* Create user */
        Map<String, Object> newUserParams = new HashMap<String, Object>();
        newUserParams.put("email", "testcreate_1@example.com");
        newUserParams.put("firstname", "testcreate_1_fn");
        newUserParams.put("lastname", "testcreate_1_ln");
        newUserParams.put("username", "testcreate_1@example.com");
        User createdUser = client.createUser(newUserParams);

        /* Delete user */
        Boolean removed = client.deleteUser(createdUser.id);

        /* Get EventTypes */
        List<EventType> eventTypes = client.getEventTypes();

        /* Get Events */
        List<Event> events = client.getEvents();

        /* Get 30 Events */
        List<Event> events2 = client.getEvents(30);

        /* Get Event */
        Event event = client.getEvent(events.get(0).id);

        /* Create Event */
        int eventTypeId = 000;
        Long accountId = 00000L;
        String actorSystem = 00;

        Map<String, Object> eventParams = new HashMap<String, Object>();
        eventParams.put("event_type_id", eventTypeId);
        eventParams.put("account_id", accountId);
        eventParams.put("actor_system", actorSystem);
        eventParams.put("user_id", user.id);
        eventParams.put("user_name", user.username);
        eventParams.put("custom_message", "test creating event");
        client.createEvent(eventParams);

        /* Get Filtered Events */
        HashMap<String, String> eventQueryParameters = new HashMap<String, String>();
        eventQueryParameters.put("event_type_id", Long.toString(eventTypeId));
        eventQueryParameters.put("user_id", Long.toString(user.id));
        List<Event> filteredEvents = client.getEvents(eventQueryParameters);

        /* Get Groups */
        List<Group> groups = client.getGroups();

        /* Get Group */
        Group group = client.getGroup(groups.get(0).id);

        String appId = "000000";

        /* Get SAMLResponse directly */
        SAMLEndpointResponse samlEndpointResponse = client.getSAMLAssertion("user@example.com", "Aa765431-XxX", appId, "example-onelogin-subdomain");

        /* Get SAMLResponse after MFA */
        SAMLEndpointResponse samlEndpointResponse2 = client.getSAMLAssertion("usermfa@example.com", "Aa765432-YyY", appId, "example-onelogin-subdomain");
        MFA mfa = samlEndpointResponse2.getMFA();
        String otpCode2 = "000000";
        SAMLEndpointResponse samlEndpointResponseAfterVerify = client.getSAMLAssertionVerifying(appId, String.valueOf(mfa.getDevices().get(0).getID()), mfa.getStateToken(), otpCode2, null);

        /* Create Session Login Token */
        Map<String, Object> sessionLoginTokenParams = new HashMap<String, Object>();
        sessionLoginTokenParams.put("username_or_email", "user@example.com");
        sessionLoginTokenParams.put("password", "Aa765431-XxX");
        sessionLoginTokenParams.put("subdomain", "example-onelogin-subdomain");
        SessionTokenInfo sessionTokenData = (SessionTokenInfo) client.createSessionLoginToken(sessionLoginTokenParams);

        /* Create Session Via API Token */
        String cookieHeader = client.createSessionViaToken(sessionTokenData.sessionToken);

        /* Create Session Login Token MFA , after verify */
        Map<String, Object> sessionLoginTokenMFAParams = new HashMap<String, Object>();
        sessionLoginTokenMFAParams.put("username_or_email", "usermfa@example.com");
        sessionLoginTokenMFAParams.put("password", "Aa765432-YyY");
        sessionLoginTokenMFAParams.put("subdomain", "example-onelogin-subdomain");
        SessionTokenMFAInfo sessionTokenMFAData = (SessionTokenMFAInfo) client.createSessionLoginToken(sessionLoginTokenMFAParams);
        String otpCode = "645645";
        SessionTokenInfo sessionTokenData2 = client.getSessionTokenVerified(Long.toString(sessionTokenMFAData.devices.get(0).getID()), sessionTokenMFAData.stateToken, otpCode);

        long userId = 00000000;

        # Get Available Authentication Factors
        List<AuthFactor> authFactors = client.getFactors(userId);

        # Enroll an Authentication Factor
        AuthFactor enrollFactor = client.enrollFactor(userId, authFactors.get(0).id, 'My Device', '+14156456830');

        # Get Enrolled Authentication Factors
        List<OTPDevice> otpDevices = client.getEnrolledFactors(userId);

        long deviceId = 0000000;

        # Activate an Authentication Factor
        FactorEnrollmentResponse enrollmentResponse = client.activateFactor(userId, deviceId);

        String otpToken= "XXXXXXXXXX";

        # Verify an Authentication Factor
        Boolean verified = client.verifyFactor(userId, deviceId, otpToken);

        # Remove an Authentication Factor
        Boolean removed = client.removeFactor(userId, deviceId);

        /* Generate Invite Link */
        String urlLink = client.generateInviteLink("user@example.com");

        /* Send Invite Link */
        Boolean sent  = client.sendInviteLink("user@example.com");

        /* Get Apps to Embed for a User */
        String embedToken = "30e256c101cd0d2e731de1ec222e93c4be8a1578"
        List<App> apps = client.getEmbedApps(embedToken, "user@example.com");
    }
}
```
