package com.onelogin.sdk.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.onelogin.sdk.exception.Error;

public class Settings {

	/**
	 * Private property to construct a logger for this class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Settings.class);

	/**
	 * Private property that contains the SDK settings
	 */
	private Properties prop = new Properties();

	public final static String CLIENT_ID_KEY = "onelogin.sdk.client_id";
	public final static String CLIENT_SECRET_KEY = "onelogin.sdk.client_secret";
	public final static String INSTANCE = "onelogin.sdk.instance";
	public final static String REGION = "onelogin.sdk.region";
	public final static String SUBDOMAIN = "onelogin.sdk.subdomain";
	public final static String IP = "onelogin.sdk.ip";

	private String clientID;
	private String clientSecret;
	private String region = "us";
	private String subdomain;
	private String ip;
	private Map<String, Integer> apiConfiguration;

	private static final Map<String, Integer> defaultApiConfiguration;
	static {
		defaultApiConfiguration = new HashMap<String, Integer>();
		defaultApiConfiguration.put("user", 2);
		defaultApiConfiguration.put("connector", 2);
		defaultApiConfiguration.put("app", 1);
		defaultApiConfiguration.put("app_rule", 2);
		defaultApiConfiguration.put("role", 2);
		defaultApiConfiguration.put("event", 1);
		defaultApiConfiguration.put("group", 1);
        defaultApiConfiguration.put("custom_login", 1);
        defaultApiConfiguration.put("assertion", 2);
        defaultApiConfiguration.put("mfa", 2);
        defaultApiConfiguration.put("invite", 1);
        defaultApiConfiguration.put("privilege", 1);
        defaultApiConfiguration.put("branding", 2);
        defaultApiConfiguration.put("smarthook", 2);
        defaultApiConfiguration.put("smartmfa", 2);
        defaultApiConfiguration.put("risk", 2);
        defaultApiConfiguration.put("user_mapping", 2);
	}

	public Settings() throws IOException, Error {
		this("onelogin.sdk.properties");
	}

	public Settings(String configFilename) throws IOException, Error {
		this.loadPropFile(configFilename);
		this.clientID = loadStringProperty(CLIENT_ID_KEY);
		this.clientSecret = loadStringProperty(CLIENT_SECRET_KEY);
		String regionValue = loadStringProperty(REGION);
		String subdomainValue = loadStringProperty(SUBDOMAIN);
		String ip = loadStringProperty(IP);
		if (regionValue == null || regionValue.isEmpty()) {
			regionValue = loadStringProperty(INSTANCE);
		} else {
			setRegion(regionValue);
		}

		if (subdomainValue != null && !subdomainValue.isEmpty()) {
		    this.subdomain = subdomainValue;
		}

		if (ip != null && !ip.isEmpty()) {
		    this.ip = ip;
		}

		setDefaultApiConfiguration();
	}

	public Settings(String clientID, String clientSecret, String subdomain, Map<String, Integer> apiConfiguration){
		this.clientID = clientID;
		this.clientSecret = clientSecret;
		this.subdomain = subdomain;
		setApiConfiguration(apiConfiguration);
	}

	public Settings(String clientID, String clientSecret, String region, String subdomain){
		this.clientID = clientID;
		this.clientSecret = clientSecret;
		setRegion(region);
		this.subdomain = subdomain;
		setDefaultApiConfiguration();
	}

	public Settings(String clientID, String clientSecret, String region){
		this.clientID = clientID;
		this.clientSecret = clientSecret;
		setRegion(region);
		setDefaultApiConfiguration();
	}

	public String getClientId() {
		return clientID;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public String getRegion() {
		return region;
	}

	public String getSubdomain() {
		return subdomain;
	}

	public String getIP() {
		return ip;
	}

	public void setRegion(String region) {
		if (region != null && !region.isEmpty()) {
		    this.region = region;
		}
	}

	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}

	public Map<String, Integer> getApiConfiguration() {
		return this.apiConfiguration;
	}

	public Map<String, Integer> getDefaultApiConfiguration() {
		return Settings.defaultApiConfiguration;
	}

	public void setApiConfiguration(Map<String, Integer> apiConfiguration) {
		if (apiConfiguration == null) {
			this.apiConfiguration = null;
		} else {
			this.apiConfiguration = new HashMap<String, Integer>();
			for (Map.Entry<String, Integer> entry : apiConfiguration.entrySet()) {
				this.apiConfiguration.put(entry.getKey(), entry.getValue());
			}
		}
	}

	public void replaceSubsetApiConfiguration(Map<String, Integer> apiConfiguration) {
		if (apiConfiguration != null && !apiConfiguration.isEmpty()) {
			if (this.apiConfiguration == null) {
				this.apiConfiguration = new HashMap<String, Integer>();
			}

			for (Map.Entry<String, Integer> entry : apiConfiguration.entrySet()) {
				this.apiConfiguration.put(entry.getKey(), entry.getValue());
			}
		}
	}

	public void setDefaultApiConfiguration() {
		this.apiConfiguration = new HashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : Settings.defaultApiConfiguration.entrySet()) {
			this.apiConfiguration.put(entry.getKey(), entry.getValue());
		}
	}

	public String getApiSubdomain() {
		if (this.subdomain != null && !this.subdomain.isEmpty()) {
			return this.subdomain;
		}
		return "api." + this.region;
	}

	public String getURL(String urlpattern, String id, String extraId, int versionId) {
		if (id == null) {
			return String.format(urlpattern, getApiSubdomain(), versionId);
		} else if (extraId == null){
			return String.format(urlpattern, getApiSubdomain(), versionId, id);
		} else {
			return String.format(urlpattern, getApiSubdomain(), versionId, id, extraId);
		}
	}

	public String getURL(String urlpattern, int id, int extraId, int versionId) {
		return this.getURL(urlpattern, (long)id, (long) extraId, versionId);
	}

	public String getURL(String urlpattern, long id, long extraId, int versionId) {
		if (id == 0) {
			return String.format(urlpattern, getApiSubdomain(), versionId);
		} else if (extraId == 0){
			return String.format(urlpattern, getApiSubdomain(), versionId, id);
		} else {
			return String.format(urlpattern, getApiSubdomain(), versionId, id, extraId);
		}
	}

	public String getURL(String urlpattern, long id, String extraId, int versionId) {
		if (id == 0) {
			return String.format(urlpattern, getApiSubdomain(), versionId);
		} else if (extraId == null){
			return String.format(urlpattern, getApiSubdomain(), versionId, id);
		} else {
			return String.format(urlpattern, getApiSubdomain(), versionId, id, extraId);
		}
	}

	public String getURL(String urlpattern, String id, int versionId) {
		if (id != null) {
			return String.format(urlpattern, getApiSubdomain(), versionId, id);
		} else {
			return String.format(urlpattern, getApiSubdomain(), versionId);
		}
	}

	public String getURL(String urlpattern, int id, int versionId) {
		return this.getURL(urlpattern, (long)id, versionId);
	}

	public String getURL(String urlpattern, long id, int versionId) {
		if (id == 0) {
			return String.format(urlpattern, getApiSubdomain(), versionId);
		} else {
			return String.format(urlpattern, getApiSubdomain(), versionId, id);
		}
	}

	public String getURL(String urlpattern, int versionId) {
		return getURL(urlpattern, null, versionId);
	}

	public String getURL(String urlpattern) {
		return String.format(urlpattern, getApiSubdomain());
	}

	public Integer getVersionId(String endpointName) throws URISyntaxException {
		Integer version = null;
		Map<String, Integer> currentApiConfiguration;
		if (apiConfiguration == null) {
			currentApiConfiguration = Settings.defaultApiConfiguration;
		} else {
			currentApiConfiguration = apiConfiguration;
		}

		if (Endpoints.resource_matrix.containsKey(endpointName) && Endpoints.version_matrix.containsKey(endpointName)) {
			String resource = Endpoints.resource_matrix.get(endpointName);
			Integer[] available_versions = Endpoints.version_matrix.get(endpointName);
			if (!currentApiConfiguration.containsKey(resource)) {
				version = available_versions[available_versions.length-1];
			} else if (Arrays.asList(available_versions).contains(currentApiConfiguration.get(resource))) {
				version = currentApiConfiguration.get(resource);
			} else {
				version = available_versions[available_versions.length-1];
			}
		}

		if (version == null) {
			throw new URISyntaxException("Name not registered as valid endpoint on SDK", endpointName);
		}

		return version;
	}

	/**
	 * Loads the settings from the properties file
	 *
	 * @param propFileName
	 *            the name of the file
	 *
	 * @throws IOException - if an error occurred when reading from the input stream.
	 * @throws Error - If setting file not found
	 */
	private void loadPropFile(String propFileName) throws IOException, Error {

		InputStream inputStream = null;
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				this.prop.load(inputStream);
				LOGGER.debug("properties file " + propFileName + " loaded succesfully");
			} else {
				String errorMsg = "properties file '" + propFileName + "' not found in the classpath";
				LOGGER.error(errorMsg);
				throw new Error(errorMsg, Error.SETTINGS_FILE_NOT_FOUND);
			}
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				LOGGER.warn("properties file '"  + propFileName +  "' not closed properly.");
			}
		}
	}

	/**
	 * Loads a property of the type String from the Properties object
	 *
	 * @param propertyKey
	 *            the property name
	 *
	 * @return the value
	 */
	private String loadStringProperty(String propertyKey) {
		String propValue = prop.getProperty(propertyKey);
		if (propValue != null) {
			propValue = propValue.trim();
		}
		return propValue;
	}
}
