package com.onelogin.sdk.conn;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.junit.Test;

import com.onelogin.sdk.exception.Error;
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
	public void testInvalidSettings() throws IOException, Error, OAuthSystemException, OAuthProblemException, URISyntaxException {
		Settings settings = new Settings();
		Client client = new Client(settings.getClientId(), "badClientSecret", settings.getRegion());
		client.getUsers(1);
	}
}
