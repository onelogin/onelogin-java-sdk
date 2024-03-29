# onelogin-java-sdk

OneLogin API
- API version: 3.1.1
  - Build date: 2023-07-18T11:53:48.226013-07:00[America/Los_Angeles]

OpenAPI Specification for OneLogin

  For more information, please visit [https://support.onelogin.com](https://support.onelogin.com)

*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.onelogin</groupId>
  <artifactId>onelogin-java-sdk</artifactId>
  <version>3.1.1</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'onelogin-java-sdk' jar has been published to maven central.
    mavenLocal()       // Needed if the 'onelogin-java-sdk' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "com.onelogin:onelogin-java-sdk:3.1.1"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/onelogin-java-sdk-3.1.1.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import com.onelogin.client.ApiClient;
import com.onelogin.client.ApiException;
import com.onelogin.client.Configuration;
import com.onelogin.client.auth.*;
import com.onelogin.client.models.*;
import com.onelogin.client.api.ApiAuthClaimsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://your-api-subdomain.onelogin.com");
    
    // Configure OAuth2 access token for authorization: OAuth2
    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
    OAuth2.setAccessToken("YOUR ACCESS TOKEN");

    ApiAuthClaimsApi apiInstance = new ApiAuthClaimsApi(defaultClient);
    String apiAuthId = "apiAuthId_example"; // String | 
    String contentType = "application/json"; // String | 
    AuthClaim authClaim = new AuthClaim(); // AuthClaim | 
    try {
      Integer result = apiInstance.createAuthClaim(apiAuthId, contentType, authClaim);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiAuthClaimsApi#createAuthClaim");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://your-api-subdomain.onelogin.com*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ApiAuthClaimsApi* | [**createAuthClaim**](docs/ApiAuthClaimsApi.md#createAuthClaim) | **POST** /api/2/api_authorizations/{api_auth_id}/claims | Create Api Auth Server Claim
*ApiAuthClaimsApi* | [**deleteAuthClaim**](docs/ApiAuthClaimsApi.md#deleteAuthClaim) | **DELETE** /api/2/api_authorizations/{api_auth_id}/claims/{claim_id} | Delete Api Auth Server Claim
*ApiAuthClaimsApi* | [**getAuthclaims**](docs/ApiAuthClaimsApi.md#getAuthclaims) | **GET** /api/2/api_authorizations/{api_auth_id}/claims | Get Api Auth Server claims
*ApiAuthClaimsApi* | [**updateClaim**](docs/ApiAuthClaimsApi.md#updateClaim) | **PUT** /api/2/api_authorizations/{api_auth_id}/claims/{claim_id} | Update Api Auth Server Claim
*ApiAuthClientAppsApi* | [**addClientApp**](docs/ApiAuthClientAppsApi.md#addClientApp) | **POST** /api/2/api_authorizations/{api_auth_id}/clients | Add Client App
*ApiAuthClientAppsApi* | [**deleteClientApp**](docs/ApiAuthClientAppsApi.md#deleteClientApp) | **DELETE** /api/2/api_authorizations/{api_auth_id}/clients/{client_app_id} | Remove Client App
*ApiAuthClientAppsApi* | [**listClientApps**](docs/ApiAuthClientAppsApi.md#listClientApps) | **GET** /api/2/api_authorizations/{api_auth_id}/clients | List Clients Apps
*ApiAuthClientAppsApi* | [**updateClientApp**](docs/ApiAuthClientAppsApi.md#updateClientApp) | **PUT** /api/2/api_authorizations/{api_auth_id}/clients/{client_app_id} | Update Client App
*ApiAuthScopesApi* | [**createScope**](docs/ApiAuthScopesApi.md#createScope) | **POST** /api/2/api_authorizations/{api_auth_id}/scopes | Create Api Auth Server Scope
*ApiAuthScopesApi* | [**deleteScope**](docs/ApiAuthScopesApi.md#deleteScope) | **DELETE** /api/2/api_authorizations/{api_auth_id}/scopes/{scope_id} | Delete Api Auth Server Scope
*ApiAuthScopesApi* | [**getScopes**](docs/ApiAuthScopesApi.md#getScopes) | **GET** /api/2/api_authorizations/{api_auth_id}/scopes | Get Api Auth Server Scopes
*ApiAuthScopesApi* | [**updateScope**](docs/ApiAuthScopesApi.md#updateScope) | **PUT** /api/2/api_authorizations/{api_auth_id}/scopes/{scope_id} | Update Api Auth Server Scope
*ApiAuthorizationServerApi* | [**createAuthServer**](docs/ApiAuthorizationServerApi.md#createAuthServer) | **POST** /api/2/api_authorizations | Create Api Auth Server
*ApiAuthorizationServerApi* | [**deleteAuthServer**](docs/ApiAuthorizationServerApi.md#deleteAuthServer) | **DELETE** /api/2/api_authorizations/{api_auth_id} | Delete Api Auth Server
*ApiAuthorizationServerApi* | [**getAuthServer**](docs/ApiAuthorizationServerApi.md#getAuthServer) | **GET** /api/2/api_authorizations/{api_auth_id} | Get Api Auth Server
*ApiAuthorizationServerApi* | [**listAuthServers**](docs/ApiAuthorizationServerApi.md#listAuthServers) | **GET** /api/2/api_authorizations | List Api Auth Servers
*ApiAuthorizationServerApi* | [**updateAuthServer**](docs/ApiAuthorizationServerApi.md#updateAuthServer) | **PUT** /api/2/api_authorizations/{api_auth_id} | Update Api Auth Server
*AppRulesApi* | [**createAppRule**](docs/AppRulesApi.md#createAppRule) | **POST** /api/2/apps/{app_id}/rules | 
*AppRulesApi* | [**deleteRule**](docs/AppRulesApi.md#deleteRule) | **DELETE** /api/2/apps/{app_id}/rules/{rule_id} | Delete Rule
*AppRulesApi* | [**getAppRule**](docs/AppRulesApi.md#getAppRule) | **GET** /api/2/apps/{app_id}/rules/{rule_id} | Get Rule
*AppRulesApi* | [**listActionValies**](docs/AppRulesApi.md#listActionValies) | **GET** /api/2/apps/{app_id}/rules/actions/{rule_action_value}/values | List Actions Values
*AppRulesApi* | [**listActions**](docs/AppRulesApi.md#listActions) | **GET** /api/2/apps/{app_id}/rules/actions | List Actions
*AppRulesApi* | [**listAppRules**](docs/AppRulesApi.md#listAppRules) | **GET** /api/2/apps/{app_id}/rules | List Rules
*AppRulesApi* | [**listConditionOperators**](docs/AppRulesApi.md#listConditionOperators) | **GET** /api/2/apps/{app_id}/rules/conditions/{rule_condition_value}/operators | List Conditions Operators
*AppRulesApi* | [**listConditionValues**](docs/AppRulesApi.md#listConditionValues) | **GET** /api/2/apps/{app_id}/rules/conditions/{rule_condition_value}/values | List Conditions Values
*AppRulesApi* | [**listConditions**](docs/AppRulesApi.md#listConditions) | **GET** /api/2/apps/{app_id}/rules/conditions | List Conditions
*AppRulesApi* | [**sortAppRules**](docs/AppRulesApi.md#sortAppRules) | **PUT** /api/2/apps/{app_id}/rules/sort | Bulk Sort
*AppRulesApi* | [**updateAppRule**](docs/AppRulesApi.md#updateAppRule) | **PUT** /api/2/apps/{app_id}/rules/{rule_id} | Update Rule
*AppsApi* | [**createApp**](docs/AppsApi.md#createApp) | **POST** /api/2/apps | Create App
*AppsApi* | [**deleteApp**](docs/AppsApi.md#deleteApp) | **DELETE** /api/2/apps/{app_id} | Delete App
*AppsApi* | [**deleteAppParameter**](docs/AppsApi.md#deleteAppParameter) | **DELETE** /api/2/apps/{app_id}/parameters/{parameter_id} | Delete Parameter from App
*AppsApi* | [**getApp**](docs/AppsApi.md#getApp) | **GET** /api/2/apps/{app_id} | Get App
*AppsApi* | [**getAppUsers**](docs/AppsApi.md#getAppUsers) | **GET** /api/2/apps/{app_id}/users | Get App Users
*AppsApi* | [**listApps**](docs/AppsApi.md#listApps) | **GET** /api/2/apps | List Apps
*AppsApi* | [**listConnectors**](docs/AppsApi.md#listConnectors) | **GET** /api/2/connectors | List Connectors
*AppsApi* | [**updateApp**](docs/AppsApi.md#updateApp) | **PUT** /api/2/apps/{app_id} | Update App
*BrandingServiceApi* | [**createBrand**](docs/BrandingServiceApi.md#createBrand) | **POST** /api/2/branding/brands | Create Brand
*BrandingServiceApi* | [**deleteBrand**](docs/BrandingServiceApi.md#deleteBrand) | **DELETE** /api/2/branding/brands/{brand_id} | Delete Brand
*BrandingServiceApi* | [**getBrand**](docs/BrandingServiceApi.md#getBrand) | **GET** /api/2/branding/brands/{brand_id} | Get Brand
*BrandingServiceApi* | [**getBrandApps**](docs/BrandingServiceApi.md#getBrandApps) | **GET** /api/2/branding/brands/{brand_id}/apps | Get Brand Apps
*BrandingServiceApi* | [**listBrands**](docs/BrandingServiceApi.md#listBrands) | **GET** /api/2/branding/brands | List Account Brands
*BrandingServiceApi* | [**updateBrand**](docs/BrandingServiceApi.md#updateBrand) | **PUT** /api/2/branding/brands/{brand_id} | Update Brand
*BrandingServiceSmtpApi* | [**deleteEmailSettings**](docs/BrandingServiceSmtpApi.md#deleteEmailSettings) | **DELETE** /api/2/branding/email_settings | Delete Custom Email Settings
*BrandingServiceSmtpApi* | [**getEmailSettings**](docs/BrandingServiceSmtpApi.md#getEmailSettings) | **GET** /api/2/branding/email_settings | Get Email Settings
*BrandingServiceSmtpApi* | [**updateEmailSettings**](docs/BrandingServiceSmtpApi.md#updateEmailSettings) | **PUT** /api/2/branding/email_settings | Update Email Settings
*BrandingServiceTemplatesApi* | [**createMessageTemplate**](docs/BrandingServiceTemplatesApi.md#createMessageTemplate) | **POST** /api/2/branding/brands/{brand_id}/templates | Create Message Template
*BrandingServiceTemplatesApi* | [**deleteMessageTemplate**](docs/BrandingServiceTemplatesApi.md#deleteMessageTemplate) | **DELETE** /api/2/branding/brands/{brand_id}/templates/{template_id} | Delete Message Template
*BrandingServiceTemplatesApi* | [**getMasterByType**](docs/BrandingServiceTemplatesApi.md#getMasterByType) | **GET** /api/2/branding/brands/master/templates/{template_type} | Get Master Template by Type
*BrandingServiceTemplatesApi* | [**getMessageTemplateById**](docs/BrandingServiceTemplatesApi.md#getMessageTemplateById) | **GET** /api/2/branding/brands/{brand_id}/templates/{template_id} | Get Message Template
*BrandingServiceTemplatesApi* | [**getTemplateByLocale**](docs/BrandingServiceTemplatesApi.md#getTemplateByLocale) | **GET** /api/2/branding/brands/{brand_id}/templates/{template_type}/{locale} | Get Template by Type &amp; Locale
*BrandingServiceTemplatesApi* | [**listMessageTemplates**](docs/BrandingServiceTemplatesApi.md#listMessageTemplates) | **GET** /api/2/branding/brands/{brand_id}/templates | List Message Templates
*BrandingServiceTemplatesApi* | [**updateMessageTemplateById**](docs/BrandingServiceTemplatesApi.md#updateMessageTemplateById) | **PUT** /api/2/branding/brands/{brand_id}/templates/{template_id} | Update Message Template
*BrandingServiceTemplatesApi* | [**updateTemplateByLocale**](docs/BrandingServiceTemplatesApi.md#updateTemplateByLocale) | **PUT** /api/2/branding/brands/{brand_id}/templates/{template_type}/{locale} | Update Template by Type &amp; Locale
*EventsApi* | [**getEventById**](docs/EventsApi.md#getEventById) | **GET** /api/1/events/{event_id} | Get Event by ID
*EventsApi* | [**getEventTypes**](docs/EventsApi.md#getEventTypes) | **GET** /api/1/events/types | Get Event Types
*EventsApi* | [**getEvents**](docs/EventsApi.md#getEvents) | **GET** /api/1/events | Get Events
*GroupsApi* | [**getGroupById**](docs/GroupsApi.md#getGroupById) | **GET** /api/1/groups/{group_id} | Get Group by ID
*GroupsApi* | [**getGroups**](docs/GroupsApi.md#getGroups) | **GET** /api/1/groups | Get Groups
*InviteLinksApi* | [**getInviteLink**](docs/InviteLinksApi.md#getInviteLink) | **POST** /api/1/invites/get_invite_link | Generate Invite Link
*InviteLinksApi* | [**sendInviteLink**](docs/InviteLinksApi.md#sendInviteLink) | **POST** /api/1/invites/send_invite_link | Send  Invite Link
*MultiFactorAuthenticationApi* | [**createDeviceVerification**](docs/MultiFactorAuthenticationApi.md#createDeviceVerification) | **POST** /api/2/mfa/users/{user_id}/verifications | Create Device Verification
*MultiFactorAuthenticationApi* | [**createFactorRegistration**](docs/MultiFactorAuthenticationApi.md#createFactorRegistration) | **POST** /api/2/mfa/users/{user_id}/registrations | Create Factor Registration
*MultiFactorAuthenticationApi* | [**deleteEnrolledFactor**](docs/MultiFactorAuthenticationApi.md#deleteEnrolledFactor) | **DELETE** /api/2/mfa/users/{user_id}/devices/{device_id} | Delete Enrolled Factor
*MultiFactorAuthenticationApi* | [**generateOTP**](docs/MultiFactorAuthenticationApi.md#generateOTP) | **POST** /api/2/mfa/users/{user_id}/mfa_token | Generate MFA token
*MultiFactorAuthenticationApi* | [**getAuthFactors**](docs/MultiFactorAuthenticationApi.md#getAuthFactors) | **GET** /api/2/mfa/users/{user_id}/factors | Get User Factors
*MultiFactorAuthenticationApi* | [**getAuthenticationDevices**](docs/MultiFactorAuthenticationApi.md#getAuthenticationDevices) | **GET** /api/2/mfa/users/{user_id}/devices | Get User Devices
*MultiFactorAuthenticationApi* | [**getUserRegistration**](docs/MultiFactorAuthenticationApi.md#getUserRegistration) | **GET** /api/2/mfa/users/{user_id}/registrations/{registration_id} | Get User Registration
*MultiFactorAuthenticationApi* | [**getUserVerification**](docs/MultiFactorAuthenticationApi.md#getUserVerification) | **GET** /api/2/mfa/users/{user_id}/verifications/{verification_id} | Get User Verification
*MultiFactorAuthenticationApi* | [**verifyUserRegistration**](docs/MultiFactorAuthenticationApi.md#verifyUserRegistration) | **PUT** /api/2/mfa/users/{user_id}/registrations/{registration_id} | Verify User Registration
*MultiFactorAuthenticationApi* | [**verifyUserVerification**](docs/MultiFactorAuthenticationApi.md#verifyUserVerification) | **PUT** /api/2/mfa/users/{user_id}/verifications/{verification_id} | Verify User Verification
*MultiFactorAuthenticationV1Api* | [**activateMfaFactors**](docs/MultiFactorAuthenticationV1Api.md#activateMfaFactors) | **POST** /api/1/users/{user_id}/otp_devices/{device_id}/trigger | Activate a Factor
*MultiFactorAuthenticationV1Api* | [**enrollMfaFactor**](docs/MultiFactorAuthenticationV1Api.md#enrollMfaFactor) | **POST** /api/1/users/{user_id}/otp_devices | Enroll a Factor
*MultiFactorAuthenticationV1Api* | [**generateMFAtoken**](docs/MultiFactorAuthenticationV1Api.md#generateMFAtoken) | **POST** /api/1/users/{user_id}/mfa_token | Generate Temp MFA Token
*MultiFactorAuthenticationV1Api* | [**getEnrolledFactors**](docs/MultiFactorAuthenticationV1Api.md#getEnrolledFactors) | **GET** /api/1/users/{user_id}/otp_devices | Get Enrolled Factors
*MultiFactorAuthenticationV1Api* | [**getMFAFactors**](docs/MultiFactorAuthenticationV1Api.md#getMFAFactors) | **GET** /api/1/users/{user_id}/auth_factor | Get Available Factors
*MultiFactorAuthenticationV1Api* | [**removeMfaFactors**](docs/MultiFactorAuthenticationV1Api.md#removeMfaFactors) | **DELETE** /api/1/users/{user_id}/otp_devices/{device_id} | Remove an Enrolled Factor
*MultiFactorAuthenticationV1Api* | [**verifyMfaFactor**](docs/MultiFactorAuthenticationV1Api.md#verifyMfaFactor) | **POST** /api/1/users/{user_id}/otp_devices/{device_id}/verify | Verify a Factor
*OAuth2Api* | [**generateToken**](docs/OAuth2Api.md#generateToken) | **POST** /auth/oauth2/v2/token | Generate Token
*OAuth2Api* | [**getRateLimit**](docs/OAuth2Api.md#getRateLimit) | **GET** /auth/rate_limit | Get Rate Limit
*OAuth2Api* | [**revokeTokens**](docs/OAuth2Api.md#revokeTokens) | **POST** /auth/oauth2/revoke | Revoke Tokens
*PrivilegesApi* | [**addPrivilegeToRole**](docs/PrivilegesApi.md#addPrivilegeToRole) | **POST** /api/1/privileges/{privilege_id}/roles | Assign a Privilege to Roles
*PrivilegesApi* | [**assignUsersToPrivilege**](docs/PrivilegesApi.md#assignUsersToPrivilege) | **POST** /api/1/privileges/{privilege_id}/users | Assign Users to a Privilege
*PrivilegesApi* | [**createPrivilege**](docs/PrivilegesApi.md#createPrivilege) | **POST** /api/1/privileges | Create a Privilege
*PrivilegesApi* | [**deletePrivilege**](docs/PrivilegesApi.md#deletePrivilege) | **DELETE** /api/1/privileges/{privilege_id} | Delete a Privilege
*PrivilegesApi* | [**deleteRoleFromPrivilege**](docs/PrivilegesApi.md#deleteRoleFromPrivilege) | **DELETE** /api/1/privileges/{privilege_id}/roles/{role_id} | Remove a Privilege from a Role
*PrivilegesApi* | [**getAssignedUser**](docs/PrivilegesApi.md#getAssignedUser) | **GET** /api/1/privileges/{privilege_id}/users | Get Users assigned to a Privilege
*PrivilegesApi* | [**getPrivilege**](docs/PrivilegesApi.md#getPrivilege) | **GET** /api/1/privileges/{privilege_id} | Get a Privilege
*PrivilegesApi* | [**listPrivilegeRoles**](docs/PrivilegesApi.md#listPrivilegeRoles) | **GET** /api/1/privileges/{privilege_id}/roles | Get Roles assigned to Privilege
*PrivilegesApi* | [**listPrivileges**](docs/PrivilegesApi.md#listPrivileges) | **GET** /api/1/privileges | List Privileges
*PrivilegesApi* | [**removeUserFromPrivilege**](docs/PrivilegesApi.md#removeUserFromPrivilege) | **DELETE** /api/1/privileges/{privilege_id}/users/{user_id} | Remove a Privilege from Users
*PrivilegesApi* | [**updatePrivilege**](docs/PrivilegesApi.md#updatePrivilege) | **PUT** /api/1/privileges/{privilege_id} | Update a Privilege
*RolesApi* | [**addRoleAdmins**](docs/RolesApi.md#addRoleAdmins) | **POST** /api/2/roles/{role_id}/admins | Add Role Admins
*RolesApi* | [**addRoleUsers**](docs/RolesApi.md#addRoleUsers) | **POST** /api/2/roles/{role_id}/users | Add Role Users
*RolesApi* | [**createRole**](docs/RolesApi.md#createRole) | **POST** /api/2/roles | Create Role
*RolesApi* | [**deleteRole**](docs/RolesApi.md#deleteRole) | **DELETE** /api/2/roles/{role_id} | Delete Role by ID
*RolesApi* | [**getRole**](docs/RolesApi.md#getRole) | **GET** /api/2/roles/{role_id} | Get Role by ID
*RolesApi* | [**getRoleAdmins**](docs/RolesApi.md#getRoleAdmins) | **GET** /api/2/roles/{role_id}/admins | Get Role Admins
*RolesApi* | [**getRoleApps**](docs/RolesApi.md#getRoleApps) | **GET** /api/2/roles/{role_id}/apps | Get all Apps assigned to Role
*RolesApi* | [**getRoleById**](docs/RolesApi.md#getRoleById) | **GET** /api/1/roles/{role_id} | Get Role by ID
*RolesApi* | [**getRoleByName**](docs/RolesApi.md#getRoleByName) | **GET** /api/1/roles | Get Role by Name
*RolesApi* | [**getRoleUsers**](docs/RolesApi.md#getRoleUsers) | **GET** /api/2/roles/{role_id}/users | Get Role Users
*RolesApi* | [**listRoles**](docs/RolesApi.md#listRoles) | **GET** /api/2/roles | List Roles
*RolesApi* | [**removeRoleAdmins**](docs/RolesApi.md#removeRoleAdmins) | **DELETE** /api/2/roles/{role_id}/admins | Remove Role Admins
*RolesApi* | [**removeRoleUsers**](docs/RolesApi.md#removeRoleUsers) | **DELETE** /api/2/roles/{role_id}/users | Remove Role Users
*RolesApi* | [**setRoleApps**](docs/RolesApi.md#setRoleApps) | **PUT** /api/2/roles/{role_id}/apps | Set Role Apps
*RolesApi* | [**updateRole**](docs/RolesApi.md#updateRole) | **PUT** /api/2/roles/{role_id} | Update Role
*SamlAssertionsApi* | [**generateSamlAssert**](docs/SamlAssertionsApi.md#generateSamlAssert) | **POST** /api/1/saml_assertion | Generate SAML Assertion
*SamlAssertionsApi* | [**generateSamlAssert2**](docs/SamlAssertionsApi.md#generateSamlAssert2) | **POST** /api/2/saml_assertion | Generate SAML Assertion
*SamlAssertionsApi* | [**verFactorSaml**](docs/SamlAssertionsApi.md#verFactorSaml) | **POST** /api/1/saml_assertion/verify_factor | Verify Factor SAML
*SamlAssertionsApi* | [**verFactorSaml2**](docs/SamlAssertionsApi.md#verFactorSaml2) | **POST** /api/2/saml_assertion/verify_factor | Verify Factor SAML
*SmartHooksApi* | [**createEnvironmentVariable**](docs/SmartHooksApi.md#createEnvironmentVariable) | **POST** /api/2/hooks/envs | Create Environment Variable
*SmartHooksApi* | [**createHook**](docs/SmartHooksApi.md#createHook) | **POST** /api/2/hooks | Create Smart Hook
*SmartHooksApi* | [**deleteEnvironmentVariable**](docs/SmartHooksApi.md#deleteEnvironmentVariable) | **DELETE** /api/2/hooks/envs/{envvar_id} | Delete Environment Variable
*SmartHooksApi* | [**deleteHook**](docs/SmartHooksApi.md#deleteHook) | **DELETE** /api/2/hooks/{hook_id} | Delete Smart Hook by ID
*SmartHooksApi* | [**getEnvironmentVariable**](docs/SmartHooksApi.md#getEnvironmentVariable) | **GET** /api/2/hooks/envs/{envvar_id} | Get Environment Variable
*SmartHooksApi* | [**getHook**](docs/SmartHooksApi.md#getHook) | **GET** /api/2/hooks/{hook_id} | Get Smart Hook by ID
*SmartHooksApi* | [**getLogs**](docs/SmartHooksApi.md#getLogs) | **GET** /api/2/hooks/{hook_id}/logs | Get Smart Hook Logs
*SmartHooksApi* | [**listEnvironmentVariables**](docs/SmartHooksApi.md#listEnvironmentVariables) | **GET** /api/2/hooks/envs | List Environment Variables
*SmartHooksApi* | [**listHooks**](docs/SmartHooksApi.md#listHooks) | **GET** /api/2/hooks | List all Smart Hooks
*SmartHooksApi* | [**updateEnvironmentVariable**](docs/SmartHooksApi.md#updateEnvironmentVariable) | **PUT** /api/2/hooks/envs/{envvar_id} | Update Environment Variable
*SmartHooksApi* | [**updateHook**](docs/SmartHooksApi.md#updateHook) | **PUT** /api/2/hooks/{hook_id} | Update Smart Hook by ID
*UserMappingsApi* | [**createMapping**](docs/UserMappingsApi.md#createMapping) | **POST** /api/2/mappings | Create Mapping
*UserMappingsApi* | [**deleteMapping**](docs/UserMappingsApi.md#deleteMapping) | **DELETE** /api/2/mappings/{mapping_id} | Delete Mapping
*UserMappingsApi* | [**getMapping**](docs/UserMappingsApi.md#getMapping) | **GET** /api/2/mappings/{mapping_id} | Get Mapping
*UserMappingsApi* | [**listMappingActionValues**](docs/UserMappingsApi.md#listMappingActionValues) | **GET** /api/2/mappings/actions/{mapping_action_value}/values | List Actions Values
*UserMappingsApi* | [**listMappingConditions**](docs/UserMappingsApi.md#listMappingConditions) | **GET** /api/2/mappings/conditions | List Conditions
*UserMappingsApi* | [**listMappingConditionsOperators**](docs/UserMappingsApi.md#listMappingConditionsOperators) | **GET** /api/2/mappings/conditions/{mapping_condition_value}/operators | List Conditions Operators
*UserMappingsApi* | [**listMappingContionValues**](docs/UserMappingsApi.md#listMappingContionValues) | **GET** /api/2/mappings/conditions/{mapping_condition_value}/values | List Conditions Values
*UserMappingsApi* | [**listMappings**](docs/UserMappingsApi.md#listMappings) | **GET** /api/2/mappings | List Mappings
*UserMappingsApi* | [**listMappingsActions**](docs/UserMappingsApi.md#listMappingsActions) | **GET** /api/2/mappings/actions | List Actions
*UserMappingsApi* | [**sortMappings**](docs/UserMappingsApi.md#sortMappings) | **PUT** /api/2/mappings/sort | Bulk Sort
*UserMappingsApi* | [**updateMapping**](docs/UserMappingsApi.md#updateMapping) | **PUT** /api/2/mappings/{mapping_id} | Update Mapping
*UsersV1Api* | [**addRolesToUser**](docs/UsersV1Api.md#addRolesToUser) | **PUT** /api/1/users/{user_id}/add_roles | Add Roles for a User
*UsersV1Api* | [**createUser**](docs/UsersV1Api.md#createUser) | **POST** /api/1/users | Create a User
*UsersV1Api* | [**deleteUser**](docs/UsersV1Api.md#deleteUser) | **DELETE** /api/1/users/{user_id} | Delete a User
*UsersV1Api* | [**getCustomAttributes**](docs/UsersV1Api.md#getCustomAttributes) | **GET** /api/1/users/custom_attributes | Get Custom Attributes
*UsersV1Api* | [**getUserApps**](docs/UsersV1Api.md#getUserApps) | **GET** /api/1/users/{user_id}/apps | Get Apps for a User
*UsersV1Api* | [**getUserById**](docs/UsersV1Api.md#getUserById) | **GET** /api/1/users/{user_id} | Get User by ID
*UsersV1Api* | [**getUserRoles**](docs/UsersV1Api.md#getUserRoles) | **GET** /api/1/users/{user_id}/roles | Get Roles for a User
*UsersV1Api* | [**listUsers**](docs/UsersV1Api.md#listUsers) | **GET** /api/1/users | List Users
*UsersV1Api* | [**lockAccountUser**](docs/UsersV1Api.md#lockAccountUser) | **PUT** /api/1/users/{user_id}/lock_user | Lock User Account
*UsersV1Api* | [**logOutUser**](docs/UsersV1Api.md#logOutUser) | **PUT** /api/1/users/{user_id}/logout | Log User Out
*UsersV1Api* | [**removeUserRole**](docs/UsersV1Api.md#removeUserRole) | **PUT** /api/1/users/{user_id}/remove_roles | Remove Roles for a User
*UsersV1Api* | [**setUserState**](docs/UsersV1Api.md#setUserState) | **PUT** /api/1/users/{user_id}/set_state | Set User State
*UsersV1Api* | [**updatePasswordInsecure**](docs/UsersV1Api.md#updatePasswordInsecure) | **PUT** /api/1/users/set_password_clear_text/{user_id} | Set Password Using ID in Cleartext
*UsersV1Api* | [**updatePasswordSecure**](docs/UsersV1Api.md#updatePasswordSecure) | **PUT** /api/1/users/set_password_using_salt/{user_id} | Set Password Using ID and SHA-256 and Salt
*UsersV1Api* | [**updateUser**](docs/UsersV1Api.md#updateUser) | **PUT** /api/1/users/{user_id} | Update a User
*UsersV2Api* | [**createUser2**](docs/UsersV2Api.md#createUser2) | **POST** /api/2/users | Create User
*UsersV2Api* | [**deleteUser2**](docs/UsersV2Api.md#deleteUser2) | **DELETE** /api/2/users/{user_id} | Delete User
*UsersV2Api* | [**getUser2**](docs/UsersV2Api.md#getUser2) | **GET** /api/2/users/{user_id} | Get User
*UsersV2Api* | [**getUserApps2**](docs/UsersV2Api.md#getUserApps2) | **GET** /api/2/users/{user_id}/apps | Get User Apps
*UsersV2Api* | [**listUsers2**](docs/UsersV2Api.md#listUsers2) | **GET** /api/2/users | List Users
*UsersV2Api* | [**updateUser2**](docs/UsersV2Api.md#updateUser2) | **PUT** /api/2/users/{user_id} | Update User
*VigilanceAiApi* | [**createRiskRule**](docs/VigilanceAiApi.md#createRiskRule) | **POST** /api/2/risk/rules | Create Rule
*VigilanceAiApi* | [**deleteRiskRule**](docs/VigilanceAiApi.md#deleteRiskRule) | **DELETE** /api/2/risk/rules/{rule_id} | Delete Rule
*VigilanceAiApi* | [**getRiskRule**](docs/VigilanceAiApi.md#getRiskRule) | **GET** /api/2/risk/rules/{rule_id} | get Risk Rule
*VigilanceAiApi* | [**getRiskScore**](docs/VigilanceAiApi.md#getRiskScore) | **POST** /api/2/risk/verify | Get a Risk Score
*VigilanceAiApi* | [**getRiskScores**](docs/VigilanceAiApi.md#getRiskScores) | **GET** /api/2/risk/scores | Get Score Summary
*VigilanceAiApi* | [**listRiskRules**](docs/VigilanceAiApi.md#listRiskRules) | **GET** /api/2/risk/rules | List Rules
*VigilanceAiApi* | [**trackRiskEvent**](docs/VigilanceAiApi.md#trackRiskEvent) | **POST** /api/2/risk/events | Track an Event
*VigilanceAiApi* | [**updateRiskRule**](docs/VigilanceAiApi.md#updateRiskRule) | **PUT** /api/2/risk/rules/{rule_id} | Update Rule


## Documentation for Models

 - [ActionObj](docs/ActionObj.md)
 - [ActivateMfaFactorsRequest](docs/ActivateMfaFactorsRequest.md)
 - [AddClientApp201Response](docs/AddClientApp201Response.md)
 - [AddClientAppRequest](docs/AddClientAppRequest.md)
 - [AddPrivilegeToRole201Response](docs/AddPrivilegeToRole201Response.md)
 - [AddPrivilegeToRoleRequest](docs/AddPrivilegeToRoleRequest.md)
 - [AddRolesToUserRequest](docs/AddRolesToUserRequest.md)
 - [AltErr](docs/AltErr.md)
 - [AppParameters](docs/AppParameters.md)
 - [AppRule](docs/AppRule.md)
 - [AssignUsersToPrivilegeRequest](docs/AssignUsersToPrivilegeRequest.md)
 - [AuthClaim](docs/AuthClaim.md)
 - [AuthId](docs/AuthId.md)
 - [AuthMethod](docs/AuthMethod.md)
 - [AuthScope](docs/AuthScope.md)
 - [AuthServer](docs/AuthServer.md)
 - [AuthServerConfiguration](docs/AuthServerConfiguration.md)
 - [Brand](docs/Brand.md)
 - [BrandApp](docs/BrandApp.md)
 - [BrandBackground](docs/BrandBackground.md)
 - [BrandBackgroundUrls](docs/BrandBackgroundUrls.md)
 - [BrandLogo](docs/BrandLogo.md)
 - [BrandLogoUrls](docs/BrandLogoUrls.md)
 - [BrandReq](docs/BrandReq.md)
 - [ClientAppFull](docs/ClientAppFull.md)
 - [ClockCounter](docs/ClockCounter.md)
 - [Condition](docs/Condition.md)
 - [ConfigurationOidc](docs/ConfigurationOidc.md)
 - [ConfigurationSaml](docs/ConfigurationSaml.md)
 - [Connector](docs/Connector.md)
 - [CreateApp200Response](docs/CreateApp200Response.md)
 - [CreateAppRequest](docs/CreateAppRequest.md)
 - [CreateDeviceVerification201Response](docs/CreateDeviceVerification201Response.md)
 - [CreateDeviceVerificationRequest](docs/CreateDeviceVerificationRequest.md)
 - [CreateFactorRegistration201Response](docs/CreateFactorRegistration201Response.md)
 - [CreateFactorRegistrationRequest](docs/CreateFactorRegistrationRequest.md)
 - [CreateRole201ResponseInner](docs/CreateRole201ResponseInner.md)
 - [Device](docs/Device.md)
 - [EmailConfig](docs/EmailConfig.md)
 - [EnforcementPoint](docs/EnforcementPoint.md)
 - [EnforcementPointResourcesInner](docs/EnforcementPointResourcesInner.md)
 - [EnrollMfaFactor200Response](docs/EnrollMfaFactor200Response.md)
 - [Error](docs/Error.md)
 - [Event](docs/Event.md)
 - [GenerateMFAtoken200Response](docs/GenerateMFAtoken200Response.md)
 - [GenerateMFAtokenRequest](docs/GenerateMFAtokenRequest.md)
 - [GenerateOTP201Response](docs/GenerateOTP201Response.md)
 - [GenerateOTPRequest](docs/GenerateOTPRequest.md)
 - [GenerateSamlAssert200Response](docs/GenerateSamlAssert200Response.md)
 - [GenerateTokenRequest](docs/GenerateTokenRequest.md)
 - [GenericApp](docs/GenericApp.md)
 - [GenericAppProvisioning](docs/GenericAppProvisioning.md)
 - [GetAssignedUser200Response](docs/GetAssignedUser200Response.md)
 - [GetAuthFactors200Response](docs/GetAuthFactors200Response.md)
 - [GetAuthenticationDevices200ResponseInner](docs/GetAuthenticationDevices200ResponseInner.md)
 - [GetCustomAttributes200Response](docs/GetCustomAttributes200Response.md)
 - [GetEmailSettings200Response](docs/GetEmailSettings200Response.md)
 - [GetEmailSettings200ResponseOneOf](docs/GetEmailSettings200ResponseOneOf.md)
 - [GetEnrolledFactors200Response](docs/GetEnrolledFactors200Response.md)
 - [GetEnrolledFactors200ResponseData](docs/GetEnrolledFactors200ResponseData.md)
 - [GetEnrolledFactors200ResponseDataOtpDevicesInner](docs/GetEnrolledFactors200ResponseDataOtpDevicesInner.md)
 - [GetEventById200Response](docs/GetEventById200Response.md)
 - [GetEventTypes200Response](docs/GetEventTypes200Response.md)
 - [GetEventTypes200ResponseDataInner](docs/GetEventTypes200ResponseDataInner.md)
 - [GetEvents200Response](docs/GetEvents200Response.md)
 - [GetEvents200ResponsePagination](docs/GetEvents200ResponsePagination.md)
 - [GetGroups200Response](docs/GetGroups200Response.md)
 - [GetInviteLink200Response](docs/GetInviteLink200Response.md)
 - [GetInviteLinkRequest](docs/GetInviteLinkRequest.md)
 - [GetMFAFactors200Response](docs/GetMFAFactors200Response.md)
 - [GetMFAFactors200ResponseData](docs/GetMFAFactors200ResponseData.md)
 - [GetMFAFactors200ResponseDataAuthFactorsInner](docs/GetMFAFactors200ResponseDataAuthFactorsInner.md)
 - [GetRateLimit200Response](docs/GetRateLimit200Response.md)
 - [GetRiskScore200Response](docs/GetRiskScore200Response.md)
 - [GetRiskScoreRequest](docs/GetRiskScoreRequest.md)
 - [GetRiskScores200Response](docs/GetRiskScores200Response.md)
 - [GetRiskScores200ResponseScores](docs/GetRiskScores200ResponseScores.md)
 - [GetRoleApps200ResponseInner](docs/GetRoleApps200ResponseInner.md)
 - [GetRoleById200Response](docs/GetRoleById200Response.md)
 - [GetRoleById200ResponseDataInner](docs/GetRoleById200ResponseDataInner.md)
 - [GetRoleByName200Response](docs/GetRoleByName200Response.md)
 - [GetRoleByName200ResponseDataInner](docs/GetRoleByName200ResponseDataInner.md)
 - [GetRoleByName200ResponsePagination](docs/GetRoleByName200ResponsePagination.md)
 - [GetUserApps200ResponseInner](docs/GetUserApps200ResponseInner.md)
 - [GetUserRoles200Response](docs/GetUserRoles200Response.md)
 - [GetUserVerification200Response](docs/GetUserVerification200Response.md)
 - [Group](docs/Group.md)
 - [Hook](docs/Hook.md)
 - [HookEnvvar](docs/HookEnvvar.md)
 - [HookLog](docs/HookLog.md)
 - [HookOptions](docs/HookOptions.md)
 - [HookStatus](docs/HookStatus.md)
 - [ListConditions200ResponseInner](docs/ListConditions200ResponseInner.md)
 - [ListMappingActionValues200ResponseInner](docs/ListMappingActionValues200ResponseInner.md)
 - [ListMappingConditions200Response](docs/ListMappingConditions200Response.md)
 - [ListMappingConditionsOperators200ResponseInner](docs/ListMappingConditionsOperators200ResponseInner.md)
 - [ListMappingContionValues200ResponseInner](docs/ListMappingContionValues200ResponseInner.md)
 - [ListMappingsActions200ResponseInner](docs/ListMappingsActions200ResponseInner.md)
 - [ListMessageTemplates200ResponseInner](docs/ListMessageTemplates200ResponseInner.md)
 - [ListPrivilegeRoles200Response](docs/ListPrivilegeRoles200Response.md)
 - [Locale](docs/Locale.md)
 - [LockAccountUserRequest](docs/LockAccountUserRequest.md)
 - [Mapping](docs/Mapping.md)
 - [MessageTemplate](docs/MessageTemplate.md)
 - [MessageTemplateTemplate](docs/MessageTemplateTemplate.md)
 - [MessageTemplateTemplateOneOf](docs/MessageTemplateTemplateOneOf.md)
 - [MessageTemplateTemplateOneOf1](docs/MessageTemplateTemplateOneOf1.md)
 - [OauthToken](docs/OauthToken.md)
 - [OidcApp](docs/OidcApp.md)
 - [OidcAppAllOf](docs/OidcAppAllOf.md)
 - [OtpDevice](docs/OtpDevice.md)
 - [Privilege](docs/Privilege.md)
 - [PrivilegePrivilege](docs/PrivilegePrivilege.md)
 - [PrivilegePrivilegeStatementInner](docs/PrivilegePrivilegeStatementInner.md)
 - [RateLimit](docs/RateLimit.md)
 - [RemoveRoleUsersRequest](docs/RemoveRoleUsersRequest.md)
 - [RemoveUserRoleRequest](docs/RemoveUserRoleRequest.md)
 - [RemoveUserRoleRequestRoleIdArrayInner](docs/RemoveUserRoleRequestRoleIdArrayInner.md)
 - [RequestBrand](docs/RequestBrand.md)
 - [RevokeTokensRequest](docs/RevokeTokensRequest.md)
 - [RiskDevice](docs/RiskDevice.md)
 - [RiskRule](docs/RiskRule.md)
 - [RiskUser](docs/RiskUser.md)
 - [Role](docs/Role.md)
 - [RuleAction](docs/RuleAction.md)
 - [RuleCondition](docs/RuleCondition.md)
 - [SamlApp](docs/SamlApp.md)
 - [SamlAppAllOf](docs/SamlAppAllOf.md)
 - [SamlAppAllOfParameters](docs/SamlAppAllOfParameters.md)
 - [SamlAppAllOfParametersSamlUsername](docs/SamlAppAllOfParametersSamlUsername.md)
 - [SamlAssert](docs/SamlAssert.md)
 - [SamlFactor](docs/SamlFactor.md)
 - [Scope](docs/Scope.md)
 - [SendInviteLink200Response](docs/SendInviteLink200Response.md)
 - [SendInviteLinkRequest](docs/SendInviteLinkRequest.md)
 - [Session](docs/Session.md)
 - [SetUserStateRequest](docs/SetUserStateRequest.md)
 - [Source](docs/Source.md)
 - [SsoOidc](docs/SsoOidc.md)
 - [SsoSaml](docs/SsoSaml.md)
 - [SsoSamlCertificate](docs/SsoSamlCertificate.md)
 - [TokenClaim](docs/TokenClaim.md)
 - [TrackRiskEventRequest](docs/TrackRiskEventRequest.md)
 - [UpdateClientAppRequest](docs/UpdateClientAppRequest.md)
 - [UpdateEnvironmentVariableRequest](docs/UpdateEnvironmentVariableRequest.md)
 - [UpdatePasswordInsecureRequest](docs/UpdatePasswordInsecureRequest.md)
 - [UpdatePasswordSecureRequest](docs/UpdatePasswordSecureRequest.md)
 - [UpdatePrivilege200Response](docs/UpdatePrivilege200Response.md)
 - [UpdateRiskRuleRequest](docs/UpdateRiskRuleRequest.md)
 - [UpdateRole200Response](docs/UpdateRole200Response.md)
 - [User](docs/User.md)
 - [VerFactorSaml200Response](docs/VerFactorSaml200Response.md)
 - [Verb](docs/Verb.md)
 - [VerifyMfaFactorRequest](docs/VerifyMfaFactorRequest.md)
 - [VerifyUserRegistration200Response](docs/VerifyUserRegistration200Response.md)
 - [VerifyUserRegistrationRequest](docs/VerifyUserRegistrationRequest.md)
 - [VerifyUserVerificationRequest](docs/VerifyUserVerificationRequest.md)


<a id="documentation-for-authorization"></a>
## Documentation for Authorization


Authentication schemes defined for the API:
<a id="OAuth2"></a>
### OAuth2

- **Type**: OAuth
- **Flow**: application
- **Authorization URL**: 
- **Scopes**: 
  - Authentication Only: Gives the credential pair the ability to generate an access token that can perform POST calls only to authentication endpoints, providing least privileged access to authentication code. These endpoints include:   - Verify Factor (SAML Assertion)   - Generate SAML Assertion   - Verify Factor (Login)   - Create Session Login Token   - Log User Out
  - Read Users: Gives the credential pair the ability to generate an access token that can perform GET calls available for the User, Role, and Group API resources.
  - Manage users: Gives the credential pair the ability to generate an access token that can perform GET, POST, PUT, and DELETE calls available for the User, Role, and Group API resources, with the exception of setting passwords and assigning and removing roles
  - Manage All: Gives the credential pair the ability to generate an access token that can perform GET, POST, PUT, and DELETE calls for all available API resources, including the ability to set passwords and assign and remove roles.
  - Read All: Gives the credential pair the ability to generate an access token that can perform GET calls available for all API resources.

<a id="basicAuth"></a>
### basicAuth

- **Type**: HTTP basic authentication


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



