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

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.onelogin.client.JSON;

/**
 * Device
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-03-16T13:09:58.336938-07:00[America/Los_Angeles]")
public class Device {
  public static final String SERIALIZED_NAME_DEVICE_ID = "device_id";
  @SerializedName(SERIALIZED_NAME_DEVICE_ID)
  private Integer deviceId;

  public static final String SERIALIZED_NAME_DEVICE_TYPE = "device_type";
  @SerializedName(SERIALIZED_NAME_DEVICE_TYPE)
  private String deviceType;

  public Device() {
  }

  public Device deviceId(Integer deviceId) {
    
    this.deviceId = deviceId;
    return this;
  }

   /**
   * an ID for the device type that must be submitted with the Verify Factor API call.
   * @return deviceId
  **/
  @javax.annotation.Nullable

  public Integer getDeviceId() {
    return deviceId;
  }


  public void setDeviceId(Integer deviceId) {
    this.deviceId = deviceId;
  }


  public Device deviceType(String deviceType) {
    
    this.deviceType = deviceType;
    return this;
  }

   /**
   * Lists an available MFA device type, such as OneLogin OTP SMS or Google Authenticator.
   * @return deviceType
  **/
  @javax.annotation.Nullable

  public String getDeviceType() {
    return deviceType;
  }


  public void setDeviceType(String deviceType) {
    this.deviceType = deviceType;
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
        Objects.equals(this.deviceType, device.deviceType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceId, deviceType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Device {\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
    sb.append("    deviceType: ").append(toIndentedString(deviceType)).append("\n");
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
    openapiFields.add("device_type");

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
        if (!Device.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
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
      if ((jsonObj.get("device_type") != null && !jsonObj.get("device_type").isJsonNull()) && !jsonObj.get("device_type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `device_type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("device_type").toString()));
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

