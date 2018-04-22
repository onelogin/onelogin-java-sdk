package com.onelogin.sdk.model;

import java.util.Map;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;

public class TestUser {

    @Test
    public void testReadingCustomFields() {
        // Data array
        String jsonBody = "[{\"activated_at\":null,\"created_at\":\"2018-04-22T13:47:46.319Z\",\"email\":\"mohamed.gelbana@incorta.com\",\"username\":null,\"firstname\":\"Mohamed\",\"group_id\":null,\"id\":39027240,\"invalid_login_attempts\":null,\"invitation_sent_at\":\"2018-04-22T13:47:46.064Z\",\"last_login\":\"2018-04-22T13:49:11.090Z\",\"lastname\":\"Gelbana\",\"locked_until\":null,\"comment\":null,\"openid_name\":\"mohamed.gelbana\",\"locale_code\":null,\"password_changed_at\":\"2018-04-22T13:48:29.663Z\",\"phone\":null,\"status\":1,\"updated_at\":\"2018-04-22T13:49:11.414Z\",\"distinguished_name\":null,\"external_id\":null,\"directory_id\":null,\"member_of\":null,\"samaccountname\":null,\"userprincipalname\":null,\"manager_ad_id\":null,\"role_id\":[215481],\"company\":null,\"department\":null,\"title\":null,\"state\":1,\"trusted_idp_id\":null},{\"activated_at\":null,\"created_at\":\"2018-04-22T14:21:26.910Z\",\"email\":\"mohamed.gelbana_test@incorta.com\",\"username\":\"123!@#\",\"firstname\":\"Mohamed\",\"group_id\":null,\"id\":39027246,\"invalid_login_attempts\":null,\"invitation_sent_at\":null,\"last_login\":null,\"lastname\":\"Gelbana\",\"locked_until\":null,\"comment\":\"\",\"openid_name\":\"mohamed.gelbana_test\",\"locale_code\":null,\"password_changed_at\":null,\"phone\":\"+201004273399\",\"status\":1,\"updated_at\":\"2018-04-22T14:55:00.906Z\",\"distinguished_name\":null,\"external_id\":null,\"directory_id\":null,\"member_of\":null,\"samaccountname\":null,\"userprincipalname\":null,\"manager_ad_id\":null,\"role_id\":null,\"company\":\"Incorta\",\"department\":\"Engineering\",\"title\":\"Sr. Software Engineer\",\"state\":1,\"trusted_idp_id\":null,\"custom_attributes\":{\"custAttribute1\":\"value1\",\"custAttribute2\":\"value2\"}}]";

        JSONArray jsonArray = new JSONArray(jsonBody);

        User user = new User(jsonArray.getJSONObject(0));
        Map attributes = user.getUserCustomAttributes();
        Assert.assertTrue("User isn't expected to have custom attributes", attributes == null || attributes.isEmpty());

        user = new User(jsonArray.getJSONObject(1));
        attributes = user.getUserCustomAttributes();
        Assert.assertTrue("User is expected to have 2 custom attributes", attributes.size() == 2);
        Assert.assertEquals("Attribute custAttribute1 should have a value of 'value1'", "value1", attributes.get("custAttribute1"));
        Assert.assertEquals("Attribute custAttribute1 should have a value of 'value2'", "value2", attributes.get("custAttribute2"));
    }
}
