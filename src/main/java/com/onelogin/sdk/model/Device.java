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
 * Device
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-10T13:08:46.841766-07:00[America/Los_Angeles]")
public class Device {
  public static final String SERIALIZED_NAME_DEVICE_ID = "device_id";
  @SerializedName(SERIALIZED_NAME_DEVICE_ID)
  private String deviceId;

  public static final String SERIALIZED_NAME_USER_DISPLAY_NAME = "user_display_name";
  @SerializedName(SERIALIZED_NAME_USER_DISPLAY_NAME)
  private String userDisplayName;

  public static final String SERIALIZED_NAME_TYPE_DISPLAY_NAME = "type_display_name";
  @SerializedName(SERIALIZED_NAME_TYPE_DISPLAY_NAME)
  private String typeDisplayName;

  public static final String SERIALIZED_NAME_AUTH_FACTOR_NAME = "auth_factor_name";
  @SerializedName(SERIALIZED_NAME_AUTH_FACTOR_NAME)
  private String authFactorName;

  public static final String SERIALIZED_NAME_DEFAULT = "default";
  @SerializedName(SERIALIZED_NAME_DEFAULT)
  private Boolean _default;

  public Device() { 
  }

  public Device deviceId(String deviceId) {
    
    this.deviceId = deviceId;
    return this;
  }

   /**
   * Get deviceId
   * @return deviceId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDeviceId() {
    return deviceId;
  }


  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }


  public Device userDisplayName(String userDisplayName) {
    
    this.userDisplayName = userDisplayName;
    return this;
  }

   /**
   * Get userDisplayName
   * @return userDisplayName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getUserDisplayName() {
    return userDisplayName;
  }


  public void setUserDisplayName(String userDisplayName) {
    this.userDisplayName = userDisplayName;
  }


  public Device typeDisplayName(String typeDisplayName) {
    
    this.typeDisplayName = typeDisplayName;
    return this;
  }

   /**
   * Get typeDisplayName
   * @return typeDisplayName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getTypeDisplayName() {
    return typeDisplayName;
  }


  public void setTypeDisplayName(String typeDisplayName) {
    this.typeDisplayName = typeDisplayName;
  }


  public Device authFactorName(String authFactorName) {
    
    this.authFactorName = authFactorName;
    return this;
  }

   /**
   * Get authFactorName
   * @return authFactorName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getAuthFactorName() {
    return authFactorName;
  }


  public void setAuthFactorName(String authFactorName) {
    this.authFactorName = authFactorName;
  }


  public Device _default(Boolean _default) {
    
    this._default = _default;
    return this;
  }

   /**
   * Get _default
   * @return _default
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getDefault() {
    return _default;
  }


  public void setDefault(Boolean _default) {
    this._default = _default;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Device device = (Device) o;
    return Objects.equals(this.deviceId, device.deviceId) &&
        Objects.equals(this.userDisplayName, device.userDisplayName) &&
        Objects.equals(this.typeDisplayName, device.typeDisplayName) &&
        Objects.equals(this.authFactorName, device.authFactorName) &&
        Objects.equals(this._default, device._default);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceId, userDisplayName, typeDisplayName, authFactorName, _default);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Device {\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
    sb.append("    userDisplayName: ").append(toIndentedString(userDisplayName)).append("\n");
    sb.append("    typeDisplayName: ").append(toIndentedString(typeDisplayName)).append("\n");
    sb.append("    authFactorName: ").append(toIndentedString(authFactorName)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
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
    openapiFields.add("user_display_name");
    openapiFields.add("type_display_name");
    openapiFields.add("auth_factor_name");
    openapiFields.add("default");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to Device
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (Device.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in Device is not found in the empty JSON string", Device.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!Device.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Device` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("device_id") != null && !jsonObj.get("device_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `device_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("device_id").toString()));
      }
      if (jsonObj.get("user_display_name") != null && !jsonObj.get("user_display_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `user_display_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("user_display_name").toString()));
      }
      if (jsonObj.get("type_display_name") != null && !jsonObj.get("type_display_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type_display_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type_display_name").toString()));
      }
      if (jsonObj.get("auth_factor_name") != null && !jsonObj.get("auth_factor_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `auth_factor_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("auth_factor_name").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Device.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Device' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Device> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Device.class));

       return (TypeAdapter<T>) new TypeAdapter<Device>() {
           @Override
           public void write(JsonWriter out, Device value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Device read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Device given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Device
  * @throws IOException if the JSON string is invalid with respect to Device
  */
  public static Device fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Device.class);
  }

 /**
  * Convert an instance of Device to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

