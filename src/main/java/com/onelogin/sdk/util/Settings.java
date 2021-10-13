package com.onelogin.sdk.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
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

	private static Map<String, Integer> defaultApiConfiguration;
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
		this.loadPropFile("onelogin.sdk.properties");
		this.clientID = loadStringProperty(CLIENT_ID_KEY);
		this.clientSecret = loadStringProperty(CLIENT_SECRET_KEY);
		String regionValue = loadStringProperty(REGION);
		String subdomainValue = loadStringProperty(SUBDOMAIN);
		String ip = loadStringProperty(IP);
		if (regionValue == null || regionValue.isEmpty()) {			
			regionValue = loadStringProperty(INSTANCE);
		}

		if (regionValue != null && !regionValue.isEmpty()) {
		    this.region = regionValue;
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
		setDefaultApiConfiguration();
		setApiConfiguration(apiConfiguration);
	}

	public Settings(String clientID, String clientSecret, String region, String subdomain){
		this.clientID = clientID;
		this.clientSecret = clientSecret;
		this.region = region;
		this.subdomain = subdomain;
		setDefaultApiConfiguration();
	}

	public Settings(String clientID, String clientSecret, String region){
		this.clientID = clientID;
		this.clientSecret = clientSecret;
		this.region = region;
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

	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}

	public Map<String, Integer> getApiConfiguration() {
		return this.apiConfiguration;
	}
	
	public Map<String, Integer> getDefaultApiConfiguration() {
		return defaultApiConfiguration;
	}
	
	public void setApiConfiguration(Map<String, Integer> apiConfiguration) {
		if (apiConfiguration != null && !apiConfiguration.isEmpty()) {
			for (Map.Entry<String, Integer> entry : apiConfiguration.entrySet()) {
				this.apiConfiguration.put(entry.getKey(), entry.getValue());
			}
		}
	}

	private void setDefaultApiConfiguration() {
		this.apiConfiguration = Settings.defaultApiConfiguration;
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
	
	public Integer getVersionId(String urlpattern) throws URISyntaxException {
		Integer version = null;
		Map<String, Integer> current_api_configuration;
		if (apiConfiguration == null) {
			current_api_configuration = defaultApiConfiguration;
		} else {
			current_api_configuration = apiConfiguration;
		}

		if (Endpoints.resource_matrix.containsKey(urlpattern) && Endpoints.version_matrix.containsKey(urlpattern)) {
			String resource = Endpoints.resource_matrix.get(urlpattern);
			Integer[] available_versions = Endpoints.version_matrix.get(urlpattern);
			if (!current_api_configuration.containsKey(resource)) {
				version = available_versions[available_versions.length-1];
			} else if (Arrays.asList(available_versions).contains(current_api_configuration.get(resource))) {
				version = current_api_configuration.get(resource);
			} else {
				version = available_versions[available_versions.length-1];
			}
		}
		
		if (version == null) {
			throw new URISyntaxException("URL pattern not registered as valid endpoint on SDK", urlpattern);
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

	/**
	 * Loads a property of the type Boolean from the Properties object
	 *
	 * @param propertyKey
	 *            the property name
	 *
	 * @return the value
	 */
	@SuppressWarnings("unused")
	private Boolean loadBooleanProperty(String propertyKey) {
		String booleanPropValue = prop.getProperty(propertyKey);
		if (booleanPropValue != null) {
			return Boolean.parseBoolean(booleanPropValue.trim());
		} else {
			return null;
		}
	}

	/**
	 * Loads a property of the type List from the Properties object
	 *
	 * @param propertyKey
	 *            the property name
	 *
	 * @return the value
	 */
	@SuppressWarnings("unused")
	private List<String> loadListProperty(String propertyKey) {
		String arrayPropValue = prop.getProperty(propertyKey);
		if (arrayPropValue != null && !arrayPropValue.isEmpty()) {
			String [] values = arrayPropValue.trim().split(",");
			for (int i = 0; i < values.length; i++) {
				values[i] = values[i].trim();
			}
			return Arrays.asList(values);
		} else {
			return null;
		}
	}

	/**
	 * Loads a property of the type URL from the Properties object
	 *
	 * @param propertyKey
	 *            the property name
	 *
	 * @return the value
	 */
	@SuppressWarnings("unused")
	private URL loadURLProperty(String propertyKey) {

		String urlPropValue = prop.getProperty(propertyKey);

		if (urlPropValue == null || urlPropValue.isEmpty()) {
			return null;
		} else {
			try {
				return new URL(urlPropValue.trim());
			} catch (MalformedURLException e) {
				LOGGER.error("'" + propertyKey + "' contains malformed url.", e);
				return null;
			}
		}
	}
}
