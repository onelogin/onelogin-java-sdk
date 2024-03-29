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
import com.onelogin.client.model.ConfigurationOidc;
import com.onelogin.client.model.SsoOidc;
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
 * OidcAppAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-07-18T11:53:48.226013-07:00[America/Los_Angeles]")
public class OidcAppAllOf {
  public static final String SERIALIZED_NAME_CONFIGURATION = "configuration";
  @SerializedName(SERIALIZED_NAME_CONFIGURATION)
  private ConfigurationOidc _configuration;

  public static final String SERIALIZED_NAME_SSO = "sso";
  @SerializedName(SERIALIZED_NAME_SSO)
  private SsoOidc sso;

  public OidcAppAllOf() {
  }

  public OidcAppAllOf _configuration(ConfigurationOidc _configuration) {
    
    this._configuration = _configuration;
    return this;
  }

   /**
   * Get _configuration
   * @return _configuration
  **/
  @javax.annotation.Nonnull
  public ConfigurationOidc getConfiguration() {
    return _configuration;
  }


  public void setConfiguration(ConfigurationOidc _configuration) {
    this._configuration = _configuration;
  }


  public OidcAppAllOf sso(SsoOidc sso) {
    
    this.sso = sso;
    return this;
  }

   /**
   * Get sso
   * @return sso
  **/
  @javax.annotation.Nullable
  public SsoOidc getSso() {
    return sso;
  }


  public void setSso(SsoOidc sso) {
    this.sso = sso;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OidcAppAllOf oidcAppAllOf = (OidcAppAllOf) o;
    return Objects.equals(this._configuration, oidcAppAllOf._configuration) &&
        Objects.equals(this.sso, oidcAppAllOf.sso);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_configuration, sso);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OidcAppAllOf {\n");
    sb.append("    _configuration: ").append(toIndentedString(_configuration)).append("\n");
    sb.append("    sso: ").append(toIndentedString(sso)).append("\n");
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
    openapiFields.add("configuration");
    openapiFields.add("sso");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("configuration");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to OidcAppAllOf
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!OidcAppAllOf.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in OidcAppAllOf is not found in the empty JSON string", OidcAppAllOf.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!OidcAppAllOf.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `OidcAppAllOf` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : OidcAppAllOf.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      // validate the required field `configuration`
      ConfigurationOidc.validateJsonObject(jsonObj.getAsJsonObject("configuration"));
      // validate the optional field `sso`
      if (jsonObj.get("sso") != null && !jsonObj.get("sso").isJsonNull()) {
        SsoOidc.validateJsonObject(jsonObj.getAsJsonObject("sso"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!OidcAppAllOf.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'OidcAppAllOf' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<OidcAppAllOf> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(OidcAppAllOf.class));

       return (TypeAdapter<T>) new TypeAdapter<OidcAppAllOf>() {
           @Override
           public void write(JsonWriter out, OidcAppAllOf value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public OidcAppAllOf read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of OidcAppAllOf given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of OidcAppAllOf
  * @throws IOException if the JSON string is invalid with respect to OidcAppAllOf
  */
  public static OidcAppAllOf fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, OidcAppAllOf.class);
  }

 /**
  * Convert an instance of OidcAppAllOf to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

