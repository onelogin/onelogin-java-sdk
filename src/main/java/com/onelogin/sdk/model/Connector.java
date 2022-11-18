/*
 * OneLogin API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 3.0.1
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
import com.onelogin.sdk.model.AuthMethod;
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
 * Connector
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-11-18T10:01:18.133614-08:00[America/Los_Angeles]")
public class Connector {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_AUTH_METHOD = "auth_method";
  @SerializedName(SERIALIZED_NAME_AUTH_METHOD)
  private AuthMethod authMethod;

  public static final String SERIALIZED_NAME_ALLOWS_NEW_PARAMETERS = "allows_new_parameters";
  @SerializedName(SERIALIZED_NAME_ALLOWS_NEW_PARAMETERS)
  private Boolean allowsNewParameters;

  public static final String SERIALIZED_NAME_ICON_URL = "icon_url";
  @SerializedName(SERIALIZED_NAME_ICON_URL)
  private String iconUrl;

  public Connector() {
  }

  public Connector id(Integer id) {
    
    this.id = id;
    return this;
  }

   /**
   * The connectors unique ID in OneLogin.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The connectors unique ID in OneLogin.")

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public Connector name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the connector.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the connector.")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public Connector authMethod(AuthMethod authMethod) {
    
    this.authMethod = authMethod;
    return this;
  }

   /**
   * Get authMethod
   * @return authMethod
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public AuthMethod getAuthMethod() {
    return authMethod;
  }


  public void setAuthMethod(AuthMethod authMethod) {
    this.authMethod = authMethod;
  }


  public Connector allowsNewParameters(Boolean allowsNewParameters) {
    
    this.allowsNewParameters = allowsNewParameters;
    return this;
  }

   /**
   * Indicates if apps created using this connector will be allowed to create custom parameters.
   * @return allowsNewParameters
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates if apps created using this connector will be allowed to create custom parameters.")

  public Boolean getAllowsNewParameters() {
    return allowsNewParameters;
  }


  public void setAllowsNewParameters(Boolean allowsNewParameters) {
    this.allowsNewParameters = allowsNewParameters;
  }


  public Connector iconUrl(String iconUrl) {
    
    this.iconUrl = iconUrl;
    return this;
  }

   /**
   * A link to the apps icon url.
   * @return iconUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A link to the apps icon url.")

  public String getIconUrl() {
    return iconUrl;
  }


  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Connector connector = (Connector) o;
    return Objects.equals(this.id, connector.id) &&
        Objects.equals(this.name, connector.name) &&
        Objects.equals(this.authMethod, connector.authMethod) &&
        Objects.equals(this.allowsNewParameters, connector.allowsNewParameters) &&
        Objects.equals(this.iconUrl, connector.iconUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, authMethod, allowsNewParameters, iconUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Connector {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    authMethod: ").append(toIndentedString(authMethod)).append("\n");
    sb.append("    allowsNewParameters: ").append(toIndentedString(allowsNewParameters)).append("\n");
    sb.append("    iconUrl: ").append(toIndentedString(iconUrl)).append("\n");
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
    openapiFields.add("name");
    openapiFields.add("auth_method");
    openapiFields.add("allows_new_parameters");
    openapiFields.add("icon_url");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to Connector
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (Connector.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in Connector is not found in the empty JSON string", Connector.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!Connector.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Connector` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if ((jsonObj.get("icon_url") != null && !jsonObj.get("icon_url").isJsonNull()) && !jsonObj.get("icon_url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `icon_url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("icon_url").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Connector.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Connector' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Connector> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Connector.class));

       return (TypeAdapter<T>) new TypeAdapter<Connector>() {
           @Override
           public void write(JsonWriter out, Connector value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Connector read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Connector given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Connector
  * @throws IOException if the JSON string is invalid with respect to Connector
  */
  public static Connector fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Connector.class);
  }

 /**
  * Convert an instance of Connector to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

