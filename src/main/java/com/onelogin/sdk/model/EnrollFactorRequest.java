/*
 * OneLogin API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 3.0.0-alpha.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.onelogin.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.onelogin.sdk.JSON;

/**
 * EnrollFactorRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-10T13:08:46.841766-07:00[America/Los_Angeles]")
public class EnrollFactorRequest {
  public static final String SERIALIZED_NAME_FACTOR_ID = "factor_id";
  @SerializedName(SERIALIZED_NAME_FACTOR_ID)
  private Integer factorId;

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "display_name";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  public static final String SERIALIZED_NAME_EXPIRES_IN = "expires_in";
  @SerializedName(SERIALIZED_NAME_EXPIRES_IN)
  private String expiresIn;

  public static final String SERIALIZED_NAME_VERIFIED = "verified";
  @SerializedName(SERIALIZED_NAME_VERIFIED)
  private Boolean verified;

  public static final String SERIALIZED_NAME_REDIRECT_TO = "redirect_to";
  @SerializedName(SERIALIZED_NAME_REDIRECT_TO)
  private String redirectTo;

  public static final String SERIALIZED_NAME_CUSTOM_MESSAGE = "custom_message";
  @SerializedName(SERIALIZED_NAME_CUSTOM_MESSAGE)
  private String customMessage;

  public EnrollFactorRequest() { 
  }

  public EnrollFactorRequest factorId(Integer factorId) {
    
    this.factorId = factorId;
    return this;
  }

   /**
   * The identifier of the factor to enroll the user with.
   * @return factorId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The identifier of the factor to enroll the user with.")

  public Integer getFactorId() {
    return factorId;
  }


  public void setFactorId(Integer factorId) {
    this.factorId = factorId;
  }


  public EnrollFactorRequest displayName(String displayName) {
    
    this.displayName = displayName;
    return this;
  }

   /**
   * A name for the users device.
   * @return displayName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A name for the users device.")

  public String getDisplayName() {
    return displayName;
  }


  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public EnrollFactorRequest expiresIn(String expiresIn) {
    
    this.expiresIn = expiresIn;
    return this;
  }

   /**
   * Defaults to 120. Valid values are: 120-900 seconds.
   * @return expiresIn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Defaults to 120. Valid values are: 120-900 seconds.")

  public String getExpiresIn() {
    return expiresIn;
  }


  public void setExpiresIn(String expiresIn) {
    this.expiresIn = expiresIn;
  }


  public EnrollFactorRequest verified(Boolean verified) {
    
    this.verified = verified;
    return this;
  }

   /**
   * Defaults to false.
   * @return verified
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Defaults to false.")

  public Boolean getVerified() {
    return verified;
  }


  public void setVerified(Boolean verified) {
    this.verified = verified;
  }


  public EnrollFactorRequest redirectTo(String redirectTo) {
    
    this.redirectTo = redirectTo;
    return this;
  }

   /**
   * Redirects MagicLink success page to specified URL after 2 seconds.
   * @return redirectTo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Redirects MagicLink success page to specified URL after 2 seconds.")

  public String getRedirectTo() {
    return redirectTo;
  }


  public void setRedirectTo(String redirectTo) {
    this.redirectTo = redirectTo;
  }


  public EnrollFactorRequest customMessage(String customMessage) {
    
    this.customMessage = customMessage;
    return this;
  }

   /**
   * A message template that will be sent via SMS. Max length of the message after template items are inserted is 160 characters including the OTP code.
   * @return customMessage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A message template that will be sent via SMS. Max length of the message after template items are inserted is 160 characters including the OTP code.")

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
    EnrollFactorRequest enrollFactorRequest = (EnrollFactorRequest) o;
    return Objects.equals(this.factorId, enrollFactorRequest.factorId) &&
        Objects.equals(this.displayName, enrollFactorRequest.displayName) &&
        Objects.equals(this.expiresIn, enrollFactorRequest.expiresIn) &&
        Objects.equals(this.verified, enrollFactorRequest.verified) &&
        Objects.equals(this.redirectTo, enrollFactorRequest.redirectTo) &&
        Objects.equals(this.customMessage, enrollFactorRequest.customMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(factorId, displayName, expiresIn, verified, redirectTo, customMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnrollFactorRequest {\n");
    sb.append("    factorId: ").append(toIndentedString(factorId)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
    sb.append("    verified: ").append(toIndentedString(verified)).append("\n");
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
    openapiFields.add("factor_id");
    openapiFields.add("display_name");
    openapiFields.add("expires_in");
    openapiFields.add("verified");
    openapiFields.add("redirect_to");
    openapiFields.add("custom_message");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("factor_id");
    openapiRequiredFields.add("display_name");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to EnrollFactorRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (EnrollFactorRequest.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in EnrollFactorRequest is not found in the empty JSON string", EnrollFactorRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!EnrollFactorRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `EnrollFactorRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : EnrollFactorRequest.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (jsonObj.get("display_name") != null && !jsonObj.get("display_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `display_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("display_name").toString()));
      }
      if (jsonObj.get("expires_in") != null && !jsonObj.get("expires_in").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `expires_in` to be a primitive type in the JSON string but got `%s`", jsonObj.get("expires_in").toString()));
      }
      if (jsonObj.get("redirect_to") != null && !jsonObj.get("redirect_to").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `redirect_to` to be a primitive type in the JSON string but got `%s`", jsonObj.get("redirect_to").toString()));
      }
      if (jsonObj.get("custom_message") != null && !jsonObj.get("custom_message").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `custom_message` to be a primitive type in the JSON string but got `%s`", jsonObj.get("custom_message").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!EnrollFactorRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'EnrollFactorRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<EnrollFactorRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(EnrollFactorRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<EnrollFactorRequest>() {
           @Override
           public void write(JsonWriter out, EnrollFactorRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public EnrollFactorRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of EnrollFactorRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of EnrollFactorRequest
  * @throws IOException if the JSON string is invalid with respect to EnrollFactorRequest
  */
  public static EnrollFactorRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, EnrollFactorRequest.class);
  }

 /**
  * Convert an instance of EnrollFactorRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

