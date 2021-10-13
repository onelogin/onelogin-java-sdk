package com.onelogin.sdk.conn;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import com.onelogin.sdk.conn.org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.onelogin.sdk.exception.Error;
import com.onelogin.sdk.exception.ErrorResourceInitialization;
import com.onelogin.sdk.util.Settings;

public class TestClientSettings {
        @Test
        public void testFileSettings() throws IOException, Error, OAuthSystemException, OAuthProblemException, URISyntaxException {
                Settings settings = new Settings();
                Client client = new Client(settings.getClientId(), settings.getClientSecret(), settings.getRegion());
        }

        @Test
        public void testParameterSettings() throws IOException, Error, OAuthSystemException, OAuthProblemException, URISyntaxException {
                Settings settings = new Settings();
                Client client = new Client("id", "secret", "us");
        }

        @Test(expected = OAuthProblemException.class)
        public void testInvalidSettings() throws IOException, Error, OAuthSystemException, OAuthProblemException, URISyntaxException, ErrorResourceInitialization {
                Settings settings = new Settings();
                Client client = new Client(settings.getClientId(), "badClientSecret", settings.getRegion());
                client.getUsers(1);
        }

        @Test
        public void testGetApiConfigurationDefaultCase() throws IOException, Error, OAuthSystemException, OAuthProblemException, URISyntaxException {
                Settings settings = new Settings();
                Map<String, Integer> conf = settings.getApiConfiguration();
                assertEquals(settings.getDefaultApiConfiguration() , conf);
        }

        @Test
        public void testGetApiConfigurationModifiedApiConfigClient() throws IOException, Error, OAuthSystemException, OAuthProblemException, URISyntaxException {
        	Map<String, Integer> newApiConfiguration = new HashMap<String, Integer>();
        	newApiConfiguration.put("role", 1);
        	newApiConfiguration.put("user", 1);
        	
            Settings settings = new Settings("id", "secret", "subdomain", newApiConfiguration);
            Map<String, Integer> conf = settings.getApiConfiguration();
            assertEquals((Integer) 1 , (Integer) conf.get("role"));
            assertEquals((Integer) 1 , (Integer) conf.get("user"));
        }
        
        @Test
        public void testGetApiConfigurationModifiedApiConfigMethod() throws IOException, Error, OAuthSystemException, OAuthProblemException, URISyntaxException {
        	Map<String, Integer> newApiConfiguration = new HashMap<String, Integer>();
        	newApiConfiguration.put("role", 1);
        	newApiConfiguration.put("user", 1);

            Settings settings = new Settings();
        	Map<String, Integer> defaultConf = settings.getApiConfiguration();
        	
        	Map<String, Integer> conf = settings.getApiConfiguration();
        	
            assertEquals((Integer) defaultConf.get("role") , (Integer) conf.get("role"));
            assertEquals((Integer) defaultConf.get("user") , (Integer) conf.get("user"));
        	
            settings.setApiConfiguration(newApiConfiguration);
            conf = settings.getApiConfiguration();
            assertEquals((Integer) 1 , (Integer) conf.get("role"));
            assertEquals((Integer) 1 , (Integer) conf.get("user"));
        }
}
