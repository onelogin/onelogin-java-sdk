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
 * SamlFactor
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-07-18T11:53:48.226013-07:00[America/Los_Angeles]")
public class SamlFactor {
  public static final String SERIALIZED_NAME_APP_ID = "app_id";
  @SerializedName(SERIALIZED_NAME_APP_ID)
  private String appId;

  public static final String SERIALIZED_NAME_DEVICE_ID = "device_id";
  @SerializedName(SERIALIZED_NAME_DEVICE_ID)
  private String deviceId;

  public static final String SERIALIZED_NAME_STATE_TOKEN = "state_token";
  @SerializedName(SERIALIZED_NAME_STATE_TOKEN)
  private String stateToken;

  public static final String SERIALIZED_NAME_OTP_TOKEN = "otp_token";
  @SerializedName(SERIALIZED_NAME_OTP_TOKEN)
  private String otpToken;

  public static final String SERIALIZED_NAME_DO_NOT_NOTIFY = "do_not_notify";
  @SerializedName(SERIALIZED_NAME_DO_NOT_NOTIFY)
  private Boolean doNotNotify;

  public SamlFactor() {
  }

  public SamlFactor appId(String appId) {
    
    this.appId = appId;
    return this;
  }

   /**
   * App ID of the app for which you want to generate a SAML token. This is the app ID in OneLogin.
   * @return appId
  **/
  @javax.annotation.Nonnull
  public String getAppId() {
    return appId;
  }


  public void setAppId(String appId) {
    this.appId = appId;
  }


  public SamlFactor deviceId(String deviceId) {
    
    this.deviceId = deviceId;
    return this;
  }

   /**
   * Provide the MFA device_id you are submitting for verification. The device_id is supplied by the Generate SAML Assertion API.
   * @return deviceId
  **/
  @javax.annotation.Nonnull
  public String getDeviceId() {
    return deviceId;
  }


  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }


  public SamlFactor stateToken(String stateToken) {
    
    this.stateToken = stateToken;
    return this;
  }

   /**
   * Provide the state_token associated with the MFA device_id you are submitting for verification. The state_token is supplied by the Generate SAML Assertion API.
   * @return stateToken
  **/
  @javax.annotation.Nonnull
  public String getStateToken() {
    return stateToken;
  }


  public void setStateToken(String stateToken) {
    this.stateToken = stateToken;
  }


  public SamlFactor otpToken(String otpToken) {
    
    this.otpToken = otpToken;
    return this;
  }

   /**
   * Provide the OTP value for the MFA factor you are submitting for verification. For some MFA factors; such as OneLogin OTP SMS, which requires the user to request an OTP; the otp_token value is not required, and if not included, returns a 200 OK - Pending result. You’ll make a subsequent Verify Factor API call to provide the otp_token value once it has been provided to the user.
   * @return otpToken
  **/
  @javax.annotation.Nullable
  public String getOtpToken() {
    return otpToken;
  }


  public void setOtpToken(String otpToken) {
    this.otpToken = otpToken;
  }


  public SamlFactor doNotNotify(Boolean doNotNotify) {
    
    this.doNotNotify = doNotNotify;
    return this;
  }

   /**
   * When verifying MFA via Protect Push, set this to true to stop additional push notifications being sent to the OneLogin Protect device.
   * @return doNotNotify
  **/
  @javax.annotation.Nullable
  public Boolean getDoNotNotify() {
    return doNotNotify;
  }


  public void setDoNotNotify(Boolean doNotNotify) {
    this.doNotNotify = doNotNotify;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SamlFactor samlFactor = (SamlFactor) o;
    return Objects.equals(this.appId, samlFactor.appId) &&
        Objects.equals(this.deviceId, samlFactor.deviceId) &&
        Objects.equals(this.stateToken, samlFactor.stateToken) &&
        Objects.equals(this.otpToken, samlFactor.otpToken) &&
        Objects.equals(this.doNotNotify, samlFactor.doNotNotify);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appId, deviceId, stateToken, otpToken, doNotNotify);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SamlFactor {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
    sb.append("    stateToken: ").append(toIndentedString(stateToken)).append("\n");
    sb.append("    otpToken: ").append(toIndentedString(otpToken)).append("\n");
    sb.append("    doNotNotify: ").append(toIndentedString(doNotNotify)).append("\n");
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
    openapiFields.add("app_id");
    openapiFields.add("device_id");
    openapiFields.add("state_token");
    openapiFields.add("otp_token");
    openapiFields.add("do_not_notify");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("app_id");
    openapiRequiredFields.add("device_id");
    openapiRequiredFields.add("state_token");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to SamlFactor
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!SamlFactor.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in SamlFactor is not found in the empty JSON string", SamlFactor.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!SamlFactor.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `SamlFactor` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : SamlFactor.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("app_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `app_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("app_id").toString()));
      }
      if (!jsonObj.get("device_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `device_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("device_id").toString()));
      }
      if (!jsonObj.get("state_token").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `state_token` to be a primitive type in the JSON string but got `%s`", jsonObj.get("state_token").toString()));
      }
      if ((jsonObj.get("otp_token") != null && !jsonObj.get("otp_token").isJsonNull()) && !jsonObj.get("otp_token").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `otp_token` to be a primitive type in the JSON string but got `%s`", jsonObj.get("otp_token").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!SamlFactor.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'SamlFactor' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<SamlFactor> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(SamlFactor.class));

       return (TypeAdapter<T>) new TypeAdapter<SamlFactor>() {
           @Override
           public void write(JsonWriter out, SamlFactor value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public SamlFactor read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of SamlFactor given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of SamlFactor
  * @throws IOException if the JSON string is invalid with respect to SamlFactor
  */
  public static SamlFactor fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, SamlFactor.class);
  }

 /**
  * Convert an instance of SamlFactor to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

