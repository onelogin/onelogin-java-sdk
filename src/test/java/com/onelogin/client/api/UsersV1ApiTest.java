/*
 * OneLogin API
 * OpenAPI Specification for OneLogin
 *
 * The version of the OpenAPI document: 3.1.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.onelogin.client.api;

import com.onelogin.client.ApiException;
import com.onelogin.client.model.AddRolesToUserRequest;
import com.onelogin.client.model.Error;
import com.onelogin.client.model.GetCustomAttributes200Response;
import com.onelogin.client.model.GetUserApps200ResponseInner;
import com.onelogin.client.model.GetUserRoles200Response;
import com.onelogin.client.model.LockAccountUserRequest;
import com.onelogin.client.model.RemoveUserRoleRequest;
import com.onelogin.client.model.SetUserStateRequest;
import com.onelogin.client.model.UpdatePasswordInsecureRequest;
import com.onelogin.client.model.UpdatePasswordSecureRequest;
import com.onelogin.client.model.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UsersV1Api
 */
@Disabled
public class UsersV1ApiTest {

    private final UsersV1Api api = new UsersV1Api();

    /**
     * Add Roles for a User
     *
     * Add Roles for a User
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void addRolesToUserTest() throws ApiException {
        Integer userId = null;
        AddRolesToUserRequest addRolesToUserRequest = null;
        Error response = api.addRolesToUser(userId, addRolesToUserRequest);
        // TODO: test validations
    }

    /**
     * Create a User
     *
     * Create a User
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createUserTest() throws ApiException {
        String mappings = null;
        Boolean validatePolicy = null;
        User user = null;
        User response = api.createUser(mappings, validatePolicy, user);
        // TODO: test validations
    }

    /**
     * Delete a User
     *
     * Delete A User
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteUserTest() throws ApiException {
        Integer userId = null;
        api.deleteUser(userId);
        // TODO: test validations
    }

    /**
     * Get Custom Attributes
     *
     * Get Custom Attributes
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getCustomAttributesTest() throws ApiException {
        GetCustomAttributes200Response response = api.getCustomAttributes();
        // TODO: test validations
    }

    /**
     * Get Apps for a User
     *
     * Get Apps for User
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getUserAppsTest() throws ApiException {
        Integer userId = null;
        Boolean ignoreVisibility = null;
        List<GetUserApps200ResponseInner> response = api.getUserApps(userId, ignoreVisibility);
        // TODO: test validations
    }

    /**
     * Get User by ID
     *
     * Get User By ID
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getUserByIdTest() throws ApiException {
        Integer userId = null;
        User response = api.getUserById(userId);
        // TODO: test validations
    }

    /**
     * Get Roles for a User
     *
     * Get User Roles
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getUserRolesTest() throws ApiException {
        Integer userId = null;
        GetUserRoles200Response response = api.getUserRoles(userId);
        // TODO: test validations
    }

    /**
     * List Users
     *
     * List Users
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listUsersTest() throws ApiException {
        Integer limit = null;
        Integer page = null;
        String cursor = null;
        String createdSince = null;
        String createdUntil = null;
        String updatedSince = null;
        String updatedUntil = null;
        String lastLoginSince = null;
        String lastLoginUntil = null;
        String firstname = null;
        String lastname = null;
        String email = null;
        String username = null;
        String samaccountname = null;
        Integer directoryId = null;
        String externalId = null;
        String userIds = null;
        String customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket = null;
        String fields = null;
        List<User> response = api.listUsers(limit, page, cursor, createdSince, createdUntil, updatedSince, updatedUntil, lastLoginSince, lastLoginUntil, firstname, lastname, email, username, samaccountname, directoryId, externalId, userIds, customAttributesLeftCurlyBracketAttributeNameRightCurlyBracket, fields);
        // TODO: test validations
    }

    /**
     * Lock User Account
     *
     * Lock User Account
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void lockAccountUserTest() throws ApiException {
        Integer userId = null;
        LockAccountUserRequest lockAccountUserRequest = null;
        Error response = api.lockAccountUser(userId, lockAccountUserRequest);
        // TODO: test validations
    }

    /**
     * Log User Out
     *
     * Log Out User
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void logOutUserTest() throws ApiException {
        Integer userId = null;
        Object body = null;
        Error response = api.logOutUser(userId, body);
        // TODO: test validations
    }

    /**
     * Remove Roles for a User
     *
     * Remove Roles for a User
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void removeUserRoleTest() throws ApiException {
        Integer userId = null;
        RemoveUserRoleRequest removeUserRoleRequest = null;
        Error response = api.removeUserRole(userId, removeUserRoleRequest);
        // TODO: test validations
    }

    /**
     * Set User State
     *
     * Set User State
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void setUserStateTest() throws ApiException {
        Integer userId = null;
        SetUserStateRequest setUserStateRequest = null;
        Error response = api.setUserState(userId, setUserStateRequest);
        // TODO: test validations
    }

    /**
     * Set Password Using ID in Cleartext
     *
     * Update User password using their ID. This is done in cleartext and is insecure.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updatePasswordInsecureTest() throws ApiException {
        Integer userId = null;
        UpdatePasswordInsecureRequest updatePasswordInsecureRequest = null;
        Error response = api.updatePasswordInsecure(userId, updatePasswordInsecureRequest);
        // TODO: test validations
    }

    /**
     * Set Password Using ID and SHA-256 and Salt
     *
     * Update User Password Using ID and SHA-256 with salt.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updatePasswordSecureTest() throws ApiException {
        Integer userId = null;
        UpdatePasswordSecureRequest updatePasswordSecureRequest = null;
        Error response = api.updatePasswordSecure(userId, updatePasswordSecureRequest);
        // TODO: test validations
    }

    /**
     * Update a User
     *
     * Update a User
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateUserTest() throws ApiException {
        Integer userId = null;
        String mappings = null;
        Boolean validatePolicy = null;
        User user = null;
        User response = api.updateUser(userId, mappings, validatePolicy, user);
        // TODO: test validations
    }

}
