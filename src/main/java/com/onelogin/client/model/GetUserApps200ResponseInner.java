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
 * GetUserApps200ResponseInner
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-03-16T13:09:58.336938-07:00[America/Los_Angeles]")
public class GetUserApps200ResponseInner {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_ICON_URL = "icon_url";
  @SerializedName(SERIALIZED_NAME_ICON_URL)
  private String iconUrl;

  public static final String SERIALIZED_NAME_EXTENSION = "extension";
  @SerializedName(SERIALIZED_NAME_EXTENSION)
  private Boolean extension;

  public static final String SERIALIZED_NAME_LOGIN_ID = "login_id";
  @SerializedName(SERIALIZED_NAME_LOGIN_ID)
  private Integer loginId;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  /**
   * Gets or Sets provisioningStatus
   */
  @JsonAdapter(ProvisioningStatusEnum.Adapter.class)
  public enum ProvisioningStatusEnum {
    ENABLING("enabling"),
    
    DISABLING("disabling"),
    
    ENABLING_PENDING_APPROVAL("enabling_pending_approval"),
    
    DISABLING_PENDDING_APPROVAL("disabling_pendding_approval"),
    
    ENABLED("enabled"),
    
    DISABLED("disabled"),
    
    DISABLING_FAILED("disabling_failed"),
    
    ENABLING_FAILED("enabling_failed");

    private String value;

    ProvisioningStatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ProvisioningStatusEnum fromValue(String value) {
      for (ProvisioningStatusEnum b : ProvisioningStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ProvisioningStatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ProvisioningStatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ProvisioningStatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ProvisioningStatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PROVISIONING_STATUS = "provisioning_status";
  @SerializedName(SERIALIZED_NAME_PROVISIONING_STATUS)
  private ProvisioningStatusEnum provisioningStatus;

  /**
   * If provisioning is enabled this indicates the state of provisioning for the given user.
   */
  @JsonAdapter(ProvisioningStateEnum.Adapter.class)
  public enum ProvisioningStateEnum {
    UNKNOWN("unknown"),
    
    PROVISIONING("provisioning"),
    
    MODIFYING("modifying"),
    
    DELETING("deleting"),
    
    PROVISIONING_PENDING_APPROVAL("provisioning_pending_approval"),
    
    DELETING_PENDING_APPROVAL("deleting_pending_approval"),
    
    MODIFYING_PENDING_APPROVAL("modifying_pending_approval"),
    
    LINKING("linking"),
    
    PROVISIONED("provisioned"),
    
    DELETED("deleted"),
    
    MODIFYING_FAILED("modifying_failed"),
    
    PROVISIONING_FAILED("provisioning_failed"),
    
    DELETING_FAILED("deleting_failed"),
    
    LINKING_FAILED("linking_failed"),
    
    DISABLED("disabled"),
    
    NONEXISTENT("nonexistent"),
    
    MODIFYING_PENDING_APPROVAL_THEN_DISABLED("modifying_pending_approval_then_disabled");

    private String value;

    ProvisioningStateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ProvisioningStateEnum fromValue(String value) {
      for (ProvisioningStateEnum b : ProvisioningStateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ProvisioningStateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ProvisioningStateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ProvisioningStateEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ProvisioningStateEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PROVISIONING_STATE = "provisioning_state";
  @SerializedName(SERIALIZED_NAME_PROVISIONING_STATE)
  private ProvisioningStateEnum provisioningState;

  public static final String SERIALIZED_NAME_PROVISIONING_ENABLED = "provisioning_enabled";
  @SerializedName(SERIALIZED_NAME_PROVISIONING_ENABLED)
  private Boolean provisioningEnabled;

  public GetUserApps200ResponseInner() {
  }

  public GetUserApps200ResponseInner id(Integer id) {
    
    this.id = id;
    return this;
  }

   /**
   * The App ID
   * @return id
  **/
  @javax.annotation.Nullable

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public GetUserApps200ResponseInner iconUrl(String iconUrl) {
    
    this.iconUrl = iconUrl;
    return this;
  }

   /**
   * A url for the icon that represents the app in the OneLogin portal
   * @return iconUrl
  **/
  @javax.annotation.Nullable

  public String getIconUrl() {
    return iconUrl;
  }


  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }


  public GetUserApps200ResponseInner extension(Boolean extension) {
    
    this.extension = extension;
    return this;
  }

   /**
   * Boolean that indicates if the OneLogin browser extension is required to launch this app.
   * @return extension
  **/
  @javax.annotation.Nullable

  public Boolean getExtension() {
    return extension;
  }


  public void setExtension(Boolean extension) {
    this.extension = extension;
  }


  public GetUserApps200ResponseInner loginId(Integer loginId) {
    
    this.loginId = loginId;
    return this;
  }

   /**
   * Unqiue identifier for this user and app combination.
   * @return loginId
  **/
  @javax.annotation.Nullable

  public Integer getLoginId() {
    return loginId;
  }


  public void setLoginId(Integer loginId) {
    this.loginId = loginId;
  }


  public GetUserApps200ResponseInner name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the app.
   * @return name
  **/
  @javax.annotation.Nullable

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public GetUserApps200ResponseInner provisioningStatus(ProvisioningStatusEnum provisioningStatus) {
    
    this.provisioningStatus = provisioningStatus;
    return this;
  }

   /**
   * Get provisioningStatus
   * @return provisioningStatus
  **/
  @javax.annotation.Nullable

  public ProvisioningStatusEnum getProvisioningStatus() {
    return provisioningStatus;
  }


  public void setProvisioningStatus(ProvisioningStatusEnum provisioningStatus) {
    this.provisioningStatus = provisioningStatus;
  }


  public GetUserApps200ResponseInner provisioningState(ProvisioningStateEnum provisioningState) {
    
    this.provisioningState = provisioningState;
    return this;
  }

   /**
   * If provisioning is enabled this indicates the state of provisioning for the given user.
   * @return provisioningState
  **/
  @javax.annotation.Nullable

  public ProvisioningStateEnum getProvisioningState() {
    return provisioningState;
  }


  public void setProvisioningState(ProvisioningStateEnum provisioningState) {
    this.provisioningState = provisioningState;
  }


  public GetUserApps200ResponseInner provisioningEnabled(Boolean provisioningEnabled) {
    
    this.provisioningEnabled = provisioningEnabled;
    return this;
  }

   /**
   * Indicates if provisioning is enabled for this app.
   * @return provisioningEnabled
  **/
  @javax.annotation.Nullable

  public Boolean getProvisioningEnabled() {
    return provisioningEnabled;
  }


  public void setProvisioningEnabled(Boolean provisioningEnabled) {
    this.provisioningEnabled = provisioningEnabled;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetUserApps200ResponseInner getUserApps200ResponseInner = (GetUserApps200ResponseInner) o;
    return Objects.equals(this.id, getUserApps200ResponseInner.id) &&
        Objects.equals(this.iconUrl, getUserApps200ResponseInner.iconUrl) &&
        Objects.equals(this.extension, getUserApps200ResponseInner.extension) &&
        Objects.equals(this.loginId, getUserApps200ResponseInner.loginId) &&
        Objects.equals(this.name, getUserApps200ResponseInner.name) &&
        Objects.equals(this.provisioningStatus, getUserApps200ResponseInner.provisioningStatus) &&
        Objects.equals(this.provisioningState, getUserApps200ResponseInner.provisioningState) &&
        Objects.equals(this.provisioningEnabled, getUserApps200ResponseInner.provisioningEnabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, iconUrl, extension, loginId, name, provisioningStatus, provisioningState, provisioningEnabled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUserApps200ResponseInner {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    iconUrl: ").append(toIndentedString(iconUrl)).append("\n");
    sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
    sb.append("    loginId: ").append(toIndentedString(loginId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    provisioningStatus: ").append(toIndentedString(provisioningStatus)).append("\n");
    sb.append("    provisioningState: ").append(toIndentedString(provisioningState)).append("\n");
    sb.append("    provisioningEnabled: ").append(toIndentedString(provisioningEnabled)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("icon_url");
    openapiFields.add("extension");
    openapiFields.add("login_id");
    openapiFields.add("name");
    openapiFields.add("provisioning_status");
    openapiFields.add("provisioning_state");
    openapiFields.add("provisioning_enabled");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GetUserApps200ResponseInner
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!GetUserApps200ResponseInner.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GetUserApps200ResponseInner is not found in the empty JSON string", GetUserApps200ResponseInner.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!GetUserApps200ResponseInner.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `GetUserApps200ResponseInner` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("icon_url") != null && !jsonObj.get("icon_url").isJsonNull()) && !jsonObj.get("icon_url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `icon_url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("icon_url").toString()));
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("provisioning_status") != null && !jsonObj.get("provisioning_status").isJsonNull()) && !jsonObj.get("provisioning_status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `provisioning_status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("provisioning_status").toString()));
      }
      if ((jsonObj.get("provisioning_state") != null && !jsonObj.get("provisioning_state").isJsonNull()) && !jsonObj.get("provisioning_state").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `provisioning_state` to be a primitive type in the JSON string but got `%s`", jsonObj.get("provisioning_state").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GetUserApps200ResponseInner.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GetUserApps200ResponseInner' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GetUserApps200ResponseInner> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GetUserApps200ResponseInner.class));

       return (TypeAdapter<T>) new TypeAdapter<GetUserApps200ResponseInner>() {
           @Override
           public void write(JsonWriter out, GetUserApps200ResponseInner value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public GetUserApps200ResponseInner read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of GetUserApps200ResponseInner given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GetUserApps200ResponseInner
  * @throws IOException if the JSON string is invalid with respect to GetUserApps200ResponseInner
  */
  public static GetUserApps200ResponseInner fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GetUserApps200ResponseInner.class);
  }

 /**
  * Convert an instance of GetUserApps200ResponseInner to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

