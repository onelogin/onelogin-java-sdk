package com.onelogin.sdk.util;


/**
 * Constants class of OneLogin's Java SDK.
 *
 * A class that contains several constants related to the SDK
 */ 
public final class Constants {

	// Oauth2 URLs
	public static final String TOKEN_REQUEST_URL = "https://%s.onelogin.com/auth/oauth2/v2/token";
	public static final String TOKEN_REFRESH_URL = "https://%s.onelogin.com/auth/oauth2/v2/token";
	public static final String TOKEN_REVOKE_URL = "https://%s.onelogin.com/auth/oauth2/revoke";
	public static final String GET_RATE_URL = "https://%s.onelogin.com/auth/rate_limit";

	// User URLs
	public static final String GET_USERS_URL = "https://%s.onelogin.com/api/%s/users";
	public static final String GET_USER_URL = "https://%s.onelogin.com/api/%s/users/%s";
	public static final String GET_APPS_FOR_USER_URL = "https://%s.onelogin.com/api/%s/users/%s/apps";
	public static final String GET_ROLES_FOR_USER_URL = "https://%s.onelogin.com/api/%s/users/%s/roles";
	public static final String GET_CUSTOM_ATTRIBUTES_URL = "https://%s.onelogin.com/api/%s/users/custom_attributes";
	public static final String CREATE_USER_URL = "https://%s.onelogin.com/api/%s/users";
	public static final String SESSION_LOGIN_TOKEN_URL = "https://%s.onelogin.com/api/%s/login/auth";
	public static final String GET_TOKEN_VERIFY_FACTOR = "https://%s.onelogin.com/api/%s/login/verify_factor";
	public static final String UPDATE_USER_URL = "https://%s.onelogin.com/api/%s/users/%s";
	public static final String DELETE_USER_URL = "https://%s.onelogin.com/api/%s/users/%s";
	public static final String ADD_ROLE_TO_USER_URL = "https://%s.onelogin.com/api/%s/users/%s/add_roles";
	public static final String DELETE_ROLE_TO_USER_URL = "https://%s.onelogin.com/api/%s/users/%s/remove_roles";
	public static final String SET_PW_CLEARTEXT = "https://%s.onelogin.com/api/%s/users/set_password_clear_text/%s";
	public static final String SET_PW_SALT = "https://%s.onelogin.com/api/%s/users/set_password_using_salt/%s";
	public static final String SET_CUSTOM_ATTRIBUTE_TO_USER_URL = "https://%s.onelogin.com/api/%s/users/%s/set_custom_attributes";
	public static final String SET_STATE_TO_USER_URL = "https://%s.onelogin.com/api/%s/users/%s/set_state";
	public static final String LOG_USER_OUT_URL = "https://%s.onelogin.com/api/%s/users/%s/logout";
	public static final String LOCK_USER_URL = "https://%s.onelogin.com/api/%s/users/%s/lock_user";
	public static final String GENERATE_MFA_TOKEN_URL = "https://%s.onelogin.com/api/%s/users/%s/mfa_token";
	public static final String V2_GENERATE_MFA_TOKEN_URL = "https://%s.onelogin.com/api/%s/mfa/users/%s/mfa_token";

	// Connectors URLs
	public static final String GET_CONNECTORS_URL = "https://%s.onelogin.com/api/%s/connectors";

	// Apps URL
	public static final String GET_APPS_URL = "https://%s.onelogin.com/api/%s/apps";
	public static final String CREATE_APP_URL = "https://%s.onelogin.com/api/%s/apps";
	public static final String GET_APP_URL = "https://%s.onelogin.com/api/%s/apps/%s";
	public static final String UPDATE_APP_URL = "https://%s.onelogin.com/api/%s/apps/%s";
	public static final String DELETE_APP_URL = "https://%s.onelogin.com/api/%s/apps/%s";
	public static final String DELETE_APP_PARAMETER_URL = "https://%s.onelogin.com/api/%s/apps/%s/parameters/%s";
	public static final String GET_APP_USERS_URL = "https://%s.onelogin.com/api/%s/apps/%s/users";

	// App Rules URLs
	public static final String GET_APP_RULES_URL = "https://%s.onelogin.com/api/%s/apps/%s/rules";
	public static final String CREATE_APP_RULE_URL = "https://%s.onelogin.com/api/%s/apps/%s/rules";
	public static final String GET_APP_RULE_URL = "https://%s.onelogin.com/api/%s/apps/%s/rules/%s";
	public static final String UPDATE_APP_RULE_URL = "https://%s.onelogin.com/api/%s/apps/%s/rules/%s";
	public static final String DELETE_APP_RULE_URL = "https://%s.onelogin.com/api/%s/apps/%s/rules/%s";
	public static final String GET_APP_CONDITIONS_URL = "https://%s.onelogin.com/api/%s/apps/%s/rules/conditions";
	public static final String GET_APP_CONDITION_OPERATORS_URL = "https://%s.onelogin.com/api/%s/apps/%s/rules/conditions/%s/operators";
	public static final String GET_APP_CONDITION_VALUES_URL = "https://%s.onelogin.com/api/%s/apps/%s/rules/conditions/%s/values";
	public static final String GET_APP_ACTIONS_URL = "https://%s.onelogin.com/api/%s/apps/%s/rules/actions";
	public static final String GET_APP_ACTION_VALUES_URL = "https://%s.onelogin.com/api/%s/apps/%s/rules/actions/%s/values";
	public static final String APP_RULE_SORT_URL = "https://%s.onelogin.com/api/%s/apps/%s/rules/sort";

	// Role URLs
	public static final String GET_ROLES_URL = "https://%s.onelogin.com/api/%s/roles";
	public static final String CREATE_ROLE_URL = "https://%s.onelogin.com/api/%s/roles";
	public static final String GET_ROLE_URL = "https://%s.onelogin.com/api/%s/roles/%s";
	public static final String UPDATE_ROLE_URL = "https://%s.onelogin.com/api/%s/roles/%s";
	public static final String GET_ROLE_APPS_URL = "https://%s.onelogin.com/api/%s/roles/%s/apps";
	public static final String SET_ROLE_APPS_URL = "https://%s.onelogin.com/api/%s/roles/%s/apps";
	public static final String GET_ROLE_USERS_URL = "https://%s.onelogin.com/api/%s/roles/%s/users";
	public static final String ADD_ROLE_USERS_URL = "https://%s.onelogin.com/api/%s/roles/%s/users";
	public static final String REMOVE_ROLE_USERS_URL = "https://%s.onelogin.com/api/%s/roles/%s/users";
	public static final String GET_ROLE_ADMINS_URL = "https://%s.onelogin.com/api/%s/roles/%s/admins";
	public static final String ADD_ROLE_ADMINS_URL = "https://%s.onelogin.com/api/%s/roles/%s/admins";
	public static final String REMOVE_ROLE_ADMINS_URL = "https://%s.onelogin.com/api/%s/roles/%s/admins";
	public static final String DELETE_ROLE_URL = "https://%s.onelogin.com/api/%s/roles/%s";

	// Event URLS
	public static final String GET_EVENT_TYPES_URL = "https://%s.onelogin.com/api/%s/events/types";
	public static final String GET_EVENTS_URL = "https://%s.onelogin.com/api/%s/events";
	public static final String CREATE_EVENT_URL = "https://%s.onelogin.com/api/%s/events";
	public static final String GET_EVENT_URL = "https://%s.onelogin.com/api/%s/events/%s";

	// Group URLs
	public static final String GET_GROUPS_URL = "https://%s.onelogin.com/api/%s/groups";
	public static final String CREATE_GROUP_URL = "https://%s.onelogin.com/api/%s/groups";
	public static final String GET_GROUP_URL = "https://%s.onelogin.com/api/%s/groups/%s";

	// SAML Assertion URLs
	public static final String GET_SAML_ASSERTION_URL = "https://%s.onelogin.com/api/%s/saml_assertion";
	public static final String GET_SAML_VERIFY_FACTOR = "https://%s.onelogin.com/api/%s/saml_assertion/verify_factor";

    // Multi-Factor Authentication URLs
	public static final String GET_FACTORS_URL = "https://%s.onelogin.com/api/%s/users/%s/auth_factors";
	public static final String V2_GET_FACTORS_URL = "https://%s.onelogin.com/api/%s/mfa/users/%s/factors";
	public static final String ENROLL_FACTOR_URL = "https://%s.onelogin.com/api/%s/users/%s/otp_devices";
	public static final String V2_ENROLL_FACTOR_URL = "https://%s.onelogin.com/api/%s/mfa/users/%s/registrations";
	public static final String GET_ENROLLED_FACTORS_URL = "https://%s.onelogin.com/api/%s/users/%s/otp_devices";
	public static final String VERIFY_ENROLLMENT_SMS_EMAIL_PROTECT_AUTH_URL = "https://%s.onelogin.com/api/%s/mfa/users/%s/registrations/%s";
	public static final String VERIFY_ENROLLMENT__PROTECTPUSH_VOICE_URL = "https://%s.onelogin.com/api/%s/mfa/users/%s/registrations/%s";
	public static final String V2_GET_ENROLLED_FACTORS_URL = "https://%s.onelogin.com/api/%s/mfa/users/%s/devices";
	public static final String ACTIVATE_FACTOR_URL = "https://%s.onelogin.com/api/%s/users/%s/otp_devices/%s/trigger";
	public static final String V2_ACTIVATE_FACTOR_URL = "https://%s.onelogin.com/api/%s/mfa/users/%s/verifications";
	public static final String VERIFY_FACTOR_URL = "https://%s.onelogin.com/api/%s/users/%s/otp_devices/%s/verify";
	public static final String VERIFY_FACTOR_SMS_EMAIL_PROTECT_AUTH_URL = "https://%s.onelogin.com/api/%s/mfa/users/%s/verifications/%s";
	public static final String VERIFY_FACTOR_PROTECTPUSH_VOICE_URL = "https://%s.onelogin.com/api/%s/mfa/users/%s/verifications/%s";
	public static final String DELETE_FACTOR_URL = "https://%s.onelogin.com/api/%s/users/%s/otp_devices/%s";
	public static final String V2_DELETE_FACTOR_URL = "https://%s.onelogin.com/api/%s/mfa/users/%s/devices/%s";

	// Invite Link URLS
	public static final String GENERATE_INVITE_LINK_URL = "https://%s.onelogin.com/api/%s/invites/get_invite_link";
	public static final String SEND_INVITE_LINK_URL = "https://%s.onelogin.com/api/%s/invites/send_invite_link";

	//Embed Apps URL
	public static final String EMBED_APP_URL = "https://api.onelogin.com/client/apps/embed2";

	// Account Brands URLs
	public static final String GET_ACCOUNT_BRANDS_URL = "https://%s.onelogin.com/api/%s/branding/brands";
	public static final String CREATE_ACCOUNT_BRAND_URL = "https://%s.onelogin.com/api/%s/branding/brands";
	public static final String GET_ACCOUNT_BRAND_URL = "https://%s.onelogin.com/api/%s/branding/brands/%s";
	public static final String UPDATE_ACCOUNT_BRAND_URL = "https://%s.onelogin.com/api/%s/branding/brands/%s";
	public static final String DELETE_ACCOUNT_BRAND_URL = "https://%s.onelogin.com/api/%s/branding/brands/%s";
	public static final String GET_APPS_BRAND_URL = "https://%s.onelogin.com/api/%s/branding/%s/apps";
	public static final String GET_ACCOUNT_EMAIL_SETTINGS = "https://%s.onelogin.com/api/%s/branding/email_settings";
	public static final String UPDATE_ACCOUNT_EMAIL_SETTINGS = "https://%s.onelogin.com/api/%s/branding/email_settings";
	public static final String RESET_ACCOUNT_EMAIL_SETTINGS = "https://%s.onelogin.com/api/%s/branding/email_settings";

    // Smart Hooks URLs
	public static final String GET_HOOKS_URL = "https://%s.onelogin.com/api/%s/hooks";
	public static final String CREATE_HOOK_URL = "https://%s.onelogin.com/api/%s/hooks";
	public static final String GET_HOOK_URL = "https://%s.onelogin.com/api/%s/hooks/%s";
	public static final String UPDATE_HOOK_URL = "https://%s.onelogin.com/api/%s/hooks/%s";
	public static final String DELETE_HOOK_URL = "https://%s.onelogin.com/api/%s/hooks/%s";
	public static final String GET_HOOK_LOGS_URL = "https://%s.onelogin.com/api/%s/hooks/%s/logs";
	public static final String GET_HOOK_ENVS_URL = "https://%s.onelogin.com/api/%s/hooks/envs";
	public static final String CREATE_HOOK_ENV_URL = "https://%s.onelogin.com/api/%s/hooks/envs";
	public static final String GET_HOOK_ENV_URL = "https://%s.onelogin.com/api/%s/hooks/envs/%s";
	public static final String UPDATE_HOOK_ENV_URL = "https://%s.onelogin.com/api/%s/hooks/envs/%s";
	public static final String DELETE_HOOK_ENV_URL = "https://%s.onelogin.com/api/%s/hooks/envs/%s";

    // Smart MFA
    public static final String SMART_MFA_VALIDATE_USER = "https://%s.onelogin.com/api/%s/smart-mfa";
    public static final String SMART_MFA_VERIFY_TOKEN = "https://%s.onelogin.com/api/%s/smart-mfa/verify";

    // Vigilance AI URLS
    public static final String TRACK_EVENT_URL = "https://%s.onelogin.com/api/%s/risk/events";
    public static final String GET_RISK_SCORE_URL = "https://%s.onelogin.com/api/%s/risk/verify";
    public static final String GET_RISK_RULES_URL = "https://%s.onelogin.com/api/%s/risk/rules";
    public static final String CREATE_RISK_RULE_URL = "https://%s.onelogin.com/api/%s/risk/rules";
    public static final String GET_RISK_RULE_URL = "https://%s.onelogin.com/api/%s/risk/rules/%s";
    public static final String UPDATE_RISK_RULE_URL = "https://%s.onelogin.com/api/%s/risk/rules/%s";
    public static final String DELETE_RISK_RULE_URL = "https://%s.onelogin.com/api/%s/risk/rules/%s";
    public static final String GET_SCORE_INSIGHTS = "https://%s.onelogin.com/api/%s/risk/scores";

    // Mappings URLS
    public static final String GET_MAPPINGS_URL = "https://%s.onelogin.com/api/%s/mappings";
    public static final String CREATE_MAPPING_URL = "https://%s.onelogin.com/api/%s/mappings";
    public static final String GET_MAPPING_URL = "https://%s.onelogin.com/api/%s/mappings/%s";
    public static final String UPDATE_MAPPING_URL = "https://%s.onelogin.com/api/%s/mappings/%s";
    public static final String DELETE_MAPPING_URL = "https://%s.onelogin.com/api/%s/mappings/%s";
    public static final String DRYRUN_MAPPING_URL = "https://%s.onelogin.com/api/%s/mappings/%s/dryrun";
    public static final String GET_MAPPING_CONDITIONS_URL = "https://%s.onelogin.com/api/%s/mappings/conditions";
    public static final String GET_MAPPING_CONDITION_OPERATORS_URL = "https://%s.onelogin.com/api/%s/mappings/conditions/%s/operators";
    public static final String GET_MAPPING_CONDITION_VALUES_URL = "https://%s.onelogin.com/api/%s/mappings/conditions/%s/values";
    public static final String GET_MAPPING_ACTIONS_URL = "https://%s.onelogin.com/api/%s/mappings/actions";
    public static final String GET_MAPPING_ACTION_VALUES_URL = "https://%s.onelogin.com/api/%s/mappings/actions/%s/values";
    public static final String MAPPING_SORT_URL = "https://%s.onelogin.com/api/%s/mappings/sort";
	
	// Privilege URLs
	public static final String LIST_PRIVILEGES_URL = "https://%s.onelogin.com/api/%s/privileges";
	public static final String CREATE_PRIVILEGE_URL = "https://%s.onelogin.com/api/%s/privileges";
	public static final String UPDATE_PRIVILEGE_URL = "https://%s.onelogin.com/api/%s/privileges/%s";
	public static final String GET_PRIVILEGE_URL = "https://%s.onelogin.com/api/%s/privileges/%s";
	public static final String DELETE_PRIVILEGE_URL = "https://%s.onelogin.com/api/%s/privileges/%s";
	public static final String GET_ROLES_ASSIGNED_TO_PRIVILEGE_URL = "https://%s.onelogin.com/api/%s/privileges/%s/roles";
	public static final String ASSIGN_ROLES_TO_PRIVILEGE_URL = "https://%s.onelogin.com/api/%s/privileges/%s/roles";
	public static final String REMOVE_ROLE_FROM_PRIVILEGE_URL = "https://%s.onelogin.com/api/%s/privileges/%s/roles/%s";
	public static final String GET_USERS_ASSIGNED_TO_PRIVILEGE_URL = "https://%s.onelogin.com/api/%s/privileges/%s/users";
	public static final String ASSIGN_USERS_TO_PRIVILEGE_URL = "https://%s.onelogin.com/api/%s/privileges/%s/users";
	public static final String REMOVE_USER_FROM_PRIVILEGE_URL = "https://%s.onelogin.com/api/%s/privileges/%s/users/%s";
	
	public static final  String[] VALID_ACTIONS = {
	        "apps:List",
	        "apps:Get",
	        "apps:Create",
	        "apps:Update",
	        "apps:Delete",
	        "apps:ManageRoles",
	        "apps:ManageUsers",
	        "directories:List",
	        "directories:Get",
	        "directories:Create",
	        "directories:Update",
	        "directories:Delete",
	        "directories:SyncUsers",
	        "directories:RefreshSchema",
	        "events:List",
	        "events:Get",
	        "mappings:List",
	        "mappings:Get",
	        "mappings:Create",
	        "mappings:Update",
	        "mappings:Delete",
	        "mappings:ReapplyAll",
	        "policies:List",
	        "policies:user:Get",
	        "policies:user:Create",
	        "policies:user:Update",
	        "policies:user:Delete",
	        "policies:app:Get",
	        "policies:app:Create",
	        "policies:app:Update",
	        "policies:app:Delete",
	        "privileges:List",
	        "privileges:Get",
	        "privileges:Create",
	        "privileges:Update",
	        "privileges:Delete",
	        "privileges:ListUsers",
	        "privileges:ListRoles",
	        "privileges:ManageUsers",
	        "privileges:ManageRoles",
	        "reports:List",
	        "reports:Get",
	        "reports:Create",
	        "reports:Update",
	        "reports:Delete",
	        "reports:Run",
	        "roles:List",
	        "roles:Get",
	        "roles:Create",
	        "roles:Update",
	        "roles:Delete",
	        "roles:ManageUsers",
	        "roles:ManageApps",
	        "trustedidp:List",
	        "trustedidp:Get",
	        "trustedidp:Create",
	        "trustedidp:Update",
	        "trustedidp:Delete",
	        "users:List",
	        "users:Get",
	        "users:Create",
	        "users:Update",
	        "users:Delete",
	        "users:Unlock",
	        "users:ResetPassword",
	        "users:ForceLogout",
	        "users:Invite",
	        "users:ReapplyMappings",
	        "users:ManageRoles",
	        "users:ManageApps",
	        "users:GenerateTempMfaToken"
		};
}
