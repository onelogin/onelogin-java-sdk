

# PrivilegePrivilegeStatementInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**effect** | **String** | Set to “Allow.” By default, all actions are denied, this Statement allows the listed actions to be executed. |  |
|**action** | [**List&lt;ActionEnum&gt;**](#List&lt;ActionEnum&gt;) | An array of strings that represent actions within OneLogin. Actions are prefixed with the class of object they are related to and followed by a specific action for the given class. e.g. users:List, where the class is users and the specific action is List. Don’t mix classes within an Action array. To create a privilege that includes multiple different classes, create multiple statements. A wildcard * that includes all actions is supported. Use wildcards to create a Super User privilege. |  |
|**scope** | **List&lt;String&gt;** | Target the privileged action against specific resources with the scope. The scope pattern is the class of object used by the Action, followed by an ID that represents a resource in OneLogin. e.g. apps/1234, where apps is the class and 1234 is the ID of an app. The wildcard * is supported and indicates that all resources of the class type declared, in the Action, are in scope. The Action and Scope classes must match. However, there is an exception, a scope of roles/{role_id} can be combined with Actions on the user or app class. The exception allows you to target groups of users or apps with specific actions. |  |



## Enum: List&lt;ActionEnum&gt;

| Name | Value |
|---- | -----|
| APPS_CREATE | &quot;Apps:Create&quot; |
| APPS_DELETE | &quot;Apps:Delete&quot; |
| APPS_LIST | &quot;Apps:List&quot; |
| APPS_GET | &quot;Apps:Get&quot; |
| APPS_UPDATE | &quot;Apps:Update&quot; |
| APPS_MANAGECONNECTORS | &quot;Apps:ManageConnectors&quot; |
| APPS_MANAGEROLES | &quot;Apps:ManageRoles&quot; |
| APPS_MANAGETABS | &quot;Apps:ManageTabs&quot; |
| APPS_MANAGEUSERS | &quot;Apps:ManageUsers&quot; |
| APPS_REAPPLYMAPPINGS | &quot;Apps:ReapplyMappings&quot; |
| USERS_CREATE | &quot;Users:Create&quot; |
| USERS_DELETE | &quot;Users:Delete&quot; |
| USERS_LIST | &quot;Users:List&quot; |
| USERS_GET | &quot;Users:Get&quot; |
| USERS_UPDATE | &quot;Users:Update&quot; |
| USERS_ASSUMEUSER | &quot;Users:AssumeUser&quot; |
| USERS_MANAGEAPPS | &quot;Users:ManageApps&quot; |
| USERS_UNLOCK | &quot;Users:Unlock&quot; |
| USERS_GENERATETEMPMFATOKEN | &quot;Users:GenerateTempMfaToken&quot; |
| USERS_RESETPASSWORD | &quot;Users:ResetPassword&quot; |
| USERS_REAPPLYMAPPINGS | &quot;Users:ReapplyMappings&quot; |
| USERS_MANAGELICENSE | &quot;Users:ManageLicense&quot; |
| USERS_INVITE | &quot;Users:Invite&quot; |
| USERS_MANAGEROLES | &quot;Users:ManageRoles&quot; |
| ROLES_CREATE | &quot;Roles:Create&quot; |
| ROLES_GET | &quot;Roles:Get&quot; |
| ROLES_LIST | &quot;Roles:List&quot; |
| ROLES_UPDATE | &quot;Roles:Update&quot; |
| ROLES_DELETE | &quot;Roles:Delete&quot; |
| ROLES_MANAGEUSERS | &quot;Roles:ManageUsers&quot; |
| ROLES_MANAGEAPPS | &quot;Roles:ManageApps&quot; |
| REPORTS_CREATE | &quot;Reports:Create&quot; |
| REPORTS_GET | &quot;Reports:Get&quot; |
| REPORTS_LIST | &quot;Reports:List&quot; |
| REPORTS_UPDATE | &quot;Reports:Update&quot; |
| REPORTS_DELETE | &quot;Reports:Delete&quot; |
| REPORTS_CLONE | &quot;Reports:Clone&quot; |
| EVENTS_GET | &quot;Events:Get&quot; |
| EVENTS_LIST | &quot;Events:List&quot; |
| GROUPS_CREATE | &quot;Groups:Create&quot; |
| GROUPS_GET | &quot;Groups:Get&quot; |
| GROUPS_LIST | &quot;Groups:List&quot; |
| GROUPS_UPDATE | &quot;Groups:Update&quot; |
| GROUPS_DELETE | &quot;Groups:Delete&quot; |
| POLICIES_CREATE | &quot;Policies:Create&quot; |
| POLICIES_GET | &quot;Policies:Get&quot; |
| POLICIES_LIST | &quot;Policies:List&quot; |
| POLICIES_UPDATE | &quot;Policies:Update&quot; |
| POLICIES_DELETE | &quot;Policies:Delete&quot; |
| POLICIES_SETDEFAULT | &quot;Policies:SetDefault&quot; |



