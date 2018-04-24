package com.onelogin.sdk.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

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

	private String clientID;
	private String clientSecret;
	private String region = "us";

	public Settings() throws IOException, Error {
		this.loadPropFile("onelogin.sdk.properties");
		this.clientID = loadStringProperty(CLIENT_ID_KEY);
		this.clientSecret = loadStringProperty(CLIENT_SECRET_KEY);
		String regionValue = loadStringProperty(REGION);
		if (regionValue == null || regionValue.isEmpty()) {			
			regionValue = loadStringProperty(INSTANCE);
		}

		if (regionValue != null && !regionValue.isEmpty()) {
		    this.region = regionValue;
		}
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

	public String getURL(String name, String id, String extraId) {
		if (id == null) {
			return String.format(name, this.region);			
		} else if (extraId == null){
			return String.format(name, this.region, id);
		} else {
			return String.format(name, this.region, id, extraId);
		}
	}

	public String getURL(String name, int id, int extraId) {
		if (id == 0) {
			return String.format(name, this.region);			
		} else if (extraId == 0){
			return String.format(name, this.region, id);
		} else {
			return String.format(name, this.region, id, extraId);
		}
	}

	public String getURL(String name, long id, long extraId) {
		if (id == 0) {
			return String.format(name, this.region);			
		} else if (extraId == 0){
			return String.format(name, this.region, id);
		} else {
			return String.format(name, this.region, id, extraId);
		}
	}

	public String getURL(String name, String id) {
		if (id != null) {
			return String.format(name, this.region, id);
		} else {
			return String.format(name, this.region);
		}
	}

	public String getURL(String name, int id) {
		if (id == 0) {
			return String.format(name, this.region);
		} else {
			return String.format(name, this.region, id);
		}
	}

	public String getURL(String name, long id) {
		if (id == 0) {
			return String.format(name, this.region);
		} else {
			return String.format(name, this.region, id);
		}
	}
	
	public String getURL(String name) {
		return getURL(name, null);
	}

	/**
	 * Loads the settings from the properties file
	 *
	 * @param propFileName
	 *            the name of the file
	 *
	 * @throws IOException
	 * @throws Error
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