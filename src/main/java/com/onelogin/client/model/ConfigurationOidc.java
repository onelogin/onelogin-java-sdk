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


package com.onelogin.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.onelogin.client.JSON;

/**
 * ConfigurationOidc
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-07-18T11:53:48.226013-07:00[America/Los_Angeles]")
public class ConfigurationOidc {
  public static final String SERIALIZED_NAME_LOGIN_URL = "login_url";
  @SerializedName(SERIALIZED_NAME_LOGIN_URL)
  private String loginUrl;

  public static final String SERIALIZED_NAME_REDIRECT_URI = "redirect_uri";
  @SerializedName(SERIALIZED_NAME_REDIRECT_URI)
  private String redirectUri;

  public static final String SERIALIZED_NAME_ACCESS_TOKEN_EXPIRATION_MINUTES = "access_token_expiration_minutes";
  @SerializedName(SERIALIZED_NAME_ACCESS_TOKEN_EXPIRATION_MINUTES)
  private Integer accessTokenExpirationMinutes;

  public static final String SERIALIZED_NAME_REFRESH_TOKEN_EXPIRATION_MINUTES = "refresh_token_expiration_minutes";
  @SerializedName(SERIALIZED_NAME_REFRESH_TOKEN_EXPIRATION_MINUTES)
  private Integer refreshTokenExpirationMinutes;

  /**
   * - 0: Basic - 1: POST - 2: None / PKCE
   */
  @JsonAdapter(TokenEndpointAuthMethodEnum.Adapter.class)
  public enum TokenEndpointAuthMethodEnum {
    NUMBER_0(0),
    
    NUMBER_1(1),
    
    NUMBER_2(2);

    private Integer value;

    TokenEndpointAuthMethodEnum(Integer value) {
      this.value = value;
    }

    public Integer getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TokenEndpointAuthMethodEnum fromValue(Integer value) {
      for (TokenEndpointAuthMethodEnum b : TokenEndpointAuthMethodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TokenEndpointAuthMethodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TokenEndpointAuthMethodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TokenEndpointAuthMethodEnum read(final JsonReader jsonReader) throws IOException {
        Integer value =  jsonReader.nextInt();
        return TokenEndpointAuthMethodEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TOKEN_ENDPOINT_AUTH_METHOD = "token_endpoint_auth_method";
  @SerializedName(SERIALIZED_NAME_TOKEN_ENDPOINT_AUTH_METHOD)
  private TokenEndpointAuthMethodEnum tokenEndpointAuthMethod;

  /**
   * - 0 : Web - 1 : Native / Mobile
   */
  @JsonAdapter(OidcApplicationTypeEnum.Adapter.class)
  public enum OidcApplicationTypeEnum {
    NUMBER_0(0),
    
    NUMBER_1(1);

    private Integer value;

    OidcApplicationTypeEnum(Integer value) {
      this.value = value;
    }

    public Integer getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OidcApplicationTypeEnum fromValue(Integer value) {
      for (OidcApplicationTypeEnum b : OidcApplicationTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<OidcApplicationTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OidcApplicationTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OidcApplicationTypeEnum read(final JsonReader jsonReader) throws IOException {
        Integer value =  jsonReader.nextInt();
        return OidcApplicationTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_OIDC_APPLICATION_TYPE = "oidc_application_type";
  @SerializedName(SERIALIZED_NAME_OIDC_APPLICATION_TYPE)
  private OidcApplicationTypeEnum oidcApplicationType;

  public ConfigurationOidc() {
  }

  public ConfigurationOidc loginUrl(String loginUrl) {
    
    this.loginUrl = loginUrl;
    return this;
  }

   /**
   * The OpenId Connect Client Id. Note that client_secret is only returned after Creating an App.
   * @return loginUrl
  **/
  @javax.annotation.Nonnull
  public String getLoginUrl() {
    return loginUrl;
  }


  public void setLoginUrl(String loginUrl) {
    this.loginUrl = loginUrl;
  }


  public ConfigurationOidc redirectUri(String redirectUri) {
    
    this.redirectUri = redirectUri;
    return this;
  }

   /**
   * Comma or newline separated list of valid redirect uris for the OpenId Connect Authorization Code flow.
   * @return redirectUri
  **/
  @javax.annotation.Nonnull
  public String getRedirectUri() {
    return redirectUri;
  }


  public void setRedirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
  }


  public ConfigurationOidc accessTokenExpirationMinutes(Integer accessTokenExpirationMinutes) {
    
    this.accessTokenExpirationMinutes = accessTokenExpirationMinutes;
    return this;
  }

   /**
   * Number of minutes the refresh token will be valid for.
   * @return accessTokenExpirationMinutes
  **/
  @javax.annotation.Nonnull
  public Integer getAccessTokenExpirationMinutes() {
    return accessTokenExpirationMinutes;
  }


  public void setAccessTokenExpirationMinutes(Integer accessTokenExpirationMinutes) {
    this.accessTokenExpirationMinutes = accessTokenExpirationMinutes;
  }


  public ConfigurationOidc refreshTokenExpirationMinutes(Integer refreshTokenExpirationMinutes) {
    
    this.refreshTokenExpirationMinutes = refreshTokenExpirationMinutes;
    return this;
  }

   /**
   * Number of minutes the refresh token will be valid for.
   * @return refreshTokenExpirationMinutes
  **/
  @javax.annotation.Nonnull
  public Integer getRefreshTokenExpirationMinutes() {
    return refreshTokenExpirationMinutes;
  }


  public void setRefreshTokenExpirationMinutes(Integer refreshTokenExpirationMinutes) {
    this.refreshTokenExpirationMinutes = refreshTokenExpirationMinutes;
  }


  public ConfigurationOidc tokenEndpointAuthMethod(TokenEndpointAuthMethodEnum tokenEndpointAuthMethod) {
    
    this.tokenEndpointAuthMethod = tokenEndpointAuthMethod;
    return this;
  }

   /**
   * - 0: Basic - 1: POST - 2: None / PKCE
   * @return tokenEndpointAuthMethod
  **/
  @javax.annotation.Nonnull
  public TokenEndpointAuthMethodEnum getTokenEndpointAuthMethod() {
    return tokenEndpointAuthMethod;
  }


  public void setTokenEndpointAuthMethod(TokenEndpointAuthMethodEnum tokenEndpointAuthMethod) {
    this.tokenEndpointAuthMethod = tokenEndpointAuthMethod;
  }


  public ConfigurationOidc oidcApplicationType(OidcApplicationTypeEnum oidcApplicationType) {
    
    this.oidcApplicationType = oidcApplicationType;
    return this;
  }

   /**
   * - 0 : Web - 1 : Native / Mobile
   * @return oidcApplicationType
  **/
  @javax.annotation.Nonnull
  public OidcApplicationTypeEnum getOidcApplicationType() {
    return oidcApplicationType;
  }


  public void setOidcApplicationType(OidcApplicationTypeEnum oidcApplicationType) {
    this.oidcApplicationType = oidcApplicationType;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfigurationOidc configurationOidc = (ConfigurationOidc) o;
    return Objects.equals(this.loginUrl, configurationOidc.loginUrl) &&
        Objects.equals(this.redirectUri, configurationOidc.redirectUri) &&
        Objects.equals(this.accessTokenExpirationMinutes, configurationOidc.accessTokenExpirationMinutes) &&
        Objects.equals(this.refreshTokenExpirationMinutes, configurationOidc.refreshTokenExpirationMinutes) &&
        Objects.equals(this.tokenEndpointAuthMethod, configurationOidc.tokenEndpointAuthMethod) &&
        Objects.equals(this.oidcApplicationType, configurationOidc.oidcApplicationType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loginUrl, redirectUri, accessTokenExpirationMinutes, refreshTokenExpirationMinutes, tokenEndpointAuthMethod, oidcApplicationType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfigurationOidc {\n");
    sb.append("    loginUrl: ").append(toIndentedString(loginUrl)).append("\n");
    sb.append("    redirectUri: ").append(toIndentedString(redirectUri)).append("\n");
    sb.append("    accessTokenExpirationMinutes: ").append(toIndentedString(accessTokenExpirationMinutes)).append("\n");
    sb.append("    refreshTokenExpirationMinutes: ").append(toIndentedString(refreshTokenExpirationMinutes)).append("\n");
    sb.append("    tokenEndpointAuthMethod: ").append(toIndentedString(tokenEndpointAuthMethod)).append("\n");
    sb.append("    oidcApplicationType: ").append(toIndentedString(oidcApplicationType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("login_url");
    openapiFields.add("redirect_uri");
    openapiFields.add("access_token_expiration_minutes");
    openapiFields.add("refresh_token_expiration_minutes");
    openapiFields.add("token_endpoint_auth_method");
    openapiFields.add("oidc_application_type");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("login_url");
    openapiRequiredFields.add("redirect_uri");
    openapiRequiredFields.add("access_token_expiration_minutes");
    openapiRequiredFields.add("refresh_token_expiration_minutes");
    openapiRequiredFields.add("token_endpoint_auth_method");
    openapiRequiredFields.add("oidc_application_type");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ConfigurationOidc
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ConfigurationOidc.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ConfigurationOidc is not found in the empty JSON string", ConfigurationOidc.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!ConfigurationOidc.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ConfigurationOidc` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ConfigurationOidc.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("login_url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `login_url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("login_url").toString()));
      }
      if (!jsonObj.get("redirect_uri").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `redirect_uri` to be a primitive type in the JSON string but got `%s`", jsonObj.get("redirect_uri").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ConfigurationOidc.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ConfigurationOidc' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ConfigurationOidc> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ConfigurationOidc.class));

       return (TypeAdapter<T>) new TypeAdapter<ConfigurationOidc>() {
           @Override
           public void write(JsonWriter out, ConfigurationOidc value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ConfigurationOidc read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ConfigurationOidc given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ConfigurationOidc
  * @throws IOException if the JSON string is invalid with respect to ConfigurationOidc
  */
  public static ConfigurationOidc fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ConfigurationOidc.class);
  }

 /**
  * Convert an instance of ConfigurationOidc to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

