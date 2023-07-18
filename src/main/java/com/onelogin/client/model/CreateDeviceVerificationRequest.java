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
 * CreateDeviceVerificationRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-07-18T11:53:48.226013-07:00[America/Los_Angeles]")
public class CreateDeviceVerificationRequest {
  public static final String SERIALIZED_NAME_DEVICE_ID = "device_id";
  @SerializedName(SERIALIZED_NAME_DEVICE_ID)
  private Integer deviceId;

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "display_name";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  public static final String SERIALIZED_NAME_EXPIRES_IN = "expires_in";
  @SerializedName(SERIALIZED_NAME_EXPIRES_IN)
  private String expiresIn;

  public static final String SERIALIZED_NAME_REDIRECT_TO = "redirect_to";
  @SerializedName(SERIALIZED_NAME_REDIRECT_TO)
  private String redirectTo;

  public static final String SERIALIZED_NAME_CUSTOM_MESSAGE = "custom_message";
  @SerializedName(SERIALIZED_NAME_CUSTOM_MESSAGE)
  private String customMessage;

  public CreateDeviceVerificationRequest() {
  }

  public CreateDeviceVerificationRequest deviceId(Integer deviceId) {
    
    this.deviceId = deviceId;
    return this;
  }

   /**
   * Specifies the factor to be verified.
   * @return deviceId
  **/
  @javax.annotation.Nonnull
  public Integer getDeviceId() {
    return deviceId;
  }


  public void setDeviceId(Integer deviceId) {
    this.deviceId = deviceId;
  }


  public CreateDeviceVerificationRequest displayName(String displayName) {
    
    this.displayName = displayName;
    return this;
  }

   /**
   * A name for the users device
   * @return displayName
  **/
  @javax.annotation.Nullable
  public String getDisplayName() {
    return displayName;
  }


  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public CreateDeviceVerificationRequest expiresIn(String expiresIn) {
    
    this.expiresIn = expiresIn;
    return this;
  }

   /**
   * Defaults to 120. Valid values are: 120-900 seconds.
   * @return expiresIn
  **/
  @javax.annotation.Nullable
  public String getExpiresIn() {
    return expiresIn;
  }


  public void setExpiresIn(String expiresIn) {
    this.expiresIn = expiresIn;
  }


  public CreateDeviceVerificationRequest redirectTo(String redirectTo) {
    
    this.redirectTo = redirectTo;
    return this;
  }

   /**
   * Only applies to Email MagicLink factor. Redirects MagicLink success page to specified URL after 2 seconds. Email must already be configured by the user.
   * @return redirectTo
  **/
  @javax.annotation.Nullable
  public String getRedirectTo() {
    return redirectTo;
  }


  public void setRedirectTo(String redirectTo) {
    this.redirectTo = redirectTo;
  }


  public CreateDeviceVerificationRequest customMessage(String customMessage) {
    
    this.customMessage = customMessage;
    return this;
  }

   /**
   * Only applies to SMS factor. A message template that will be sent via SMS. Max length of the message after template items are inserted is 160 characters including the OTP code. SMS must already be configured by the user. The following template variables can be included in the message. - {{otp_code}} - The security code. - {{otp_expiry}} - The number of minutes until the one time code expires.
   * @return customMessage
  **/
  @javax.annotation.Nullable
  public String getCustomMessage() {
    return customMessage;
  }


  public void setCustomMessage(String customMessage) {
    this.customMessage = customMessage;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDeviceVerificationRequest createDeviceVerificationRequest = (CreateDeviceVerificationRequest) o;
    return Objects.equals(this.deviceId, createDeviceVerificationRequest.deviceId) &&
        Objects.equals(this.displayName, createDeviceVerificationRequest.displayName) &&
        Objects.equals(this.expiresIn, createDeviceVerificationRequest.expiresIn) &&
        Objects.equals(this.redirectTo, createDeviceVerificationRequest.redirectTo) &&
        Objects.equals(this.customMessage, createDeviceVerificationRequest.customMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceId, displayName, expiresIn, redirectTo, customMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDeviceVerificationRequest {\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
    sb.append("    redirectTo: ").append(toIndentedString(redirectTo)).append("\n");
    sb.append("    customMessage: ").append(toIndentedString(customMessage)).append("\n");
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
    openapiFields.add("device_id");
    openapiFields.add("display_name");
    openapiFields.add("expires_in");
    openapiFields.add("redirect_to");
    openapiFields.add("custom_message");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("device_id");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to CreateDeviceVerificationRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!CreateDeviceVerificationRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CreateDeviceVerificationRequest is not found in the empty JSON string", CreateDeviceVerificationRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!CreateDeviceVerificationRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CreateDeviceVerificationRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CreateDeviceVerificationRequest.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if ((jsonObj.get("display_name") != null && !jsonObj.get("display_name").isJsonNull()) && !jsonObj.get("display_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `display_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("display_name").toString()));
      }
      if ((jsonObj.get("expires_in") != null && !jsonObj.get("expires_in").isJsonNull()) && !jsonObj.get("expires_in").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `expires_in` to be a primitive type in the JSON string but got `%s`", jsonObj.get("expires_in").toString()));
      }
      if ((jsonObj.get("redirect_to") != null && !jsonObj.get("redirect_to").isJsonNull()) && !jsonObj.get("redirect_to").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `redirect_to` to be a primitive type in the JSON string but got `%s`", jsonObj.get("redirect_to").toString()));
      }
      if ((jsonObj.get("custom_message") != null && !jsonObj.get("custom_message").isJsonNull()) && !jsonObj.get("custom_message").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `custom_message` to be a primitive type in the JSON string but got `%s`", jsonObj.get("custom_message").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CreateDeviceVerificationRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CreateDeviceVerificationRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CreateDeviceVerificationRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CreateDeviceVerificationRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<CreateDeviceVerificationRequest>() {
           @Override
           public void write(JsonWriter out, CreateDeviceVerificationRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CreateDeviceVerificationRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CreateDeviceVerificationRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CreateDeviceVerificationRequest
  * @throws IOException if the JSON string is invalid with respect to CreateDeviceVerificationRequest
  */
  public static CreateDeviceVerificationRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CreateDeviceVerificationRequest.class);
  }

 /**
  * Convert an instance of CreateDeviceVerificationRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

