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
import com.onelogin.client.model.Scope;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * ClientAppFull
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-07-18T11:53:48.226013-07:00[America/Los_Angeles]")
public class ClientAppFull {
  public static final String SERIALIZED_NAME_SCOPES = "scopes";
  @SerializedName(SERIALIZED_NAME_SCOPES)
  private List<Scope> scopes;

  public static final String SERIALIZED_NAME_APP_ID = "app_id";
  @SerializedName(SERIALIZED_NAME_APP_ID)
  private Integer appId;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_API_AUTH_ID = "api_auth_id";
  @SerializedName(SERIALIZED_NAME_API_AUTH_ID)
  private Integer apiAuthId;

  public ClientAppFull() {
  }

  public ClientAppFull scopes(List<Scope> scopes) {
    
    this.scopes = scopes;
    return this;
  }

  public ClientAppFull addScopesItem(Scope scopesItem) {
    if (this.scopes == null) {
      this.scopes = new ArrayList<>();
    }
    this.scopes.add(scopesItem);
    return this;
  }

   /**
   * List of All Scopes assigned to a client app
   * @return scopes
  **/
  @javax.annotation.Nullable
  public List<Scope> getScopes() {
    return scopes;
  }


  public void setScopes(List<Scope> scopes) {
    this.scopes = scopes;
  }


  public ClientAppFull appId(Integer appId) {
    
    this.appId = appId;
    return this;
  }

   /**
   * Unique Client App ID
   * @return appId
  **/
  @javax.annotation.Nullable
  public Integer getAppId() {
    return appId;
  }


  public void setAppId(Integer appId) {
    this.appId = appId;
  }


  public ClientAppFull name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Name of client app
   * @return name
  **/
  @javax.annotation.Nullable
  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public ClientAppFull apiAuthId(Integer apiAuthId) {
    
    this.apiAuthId = apiAuthId;
    return this;
  }

   /**
   * Get apiAuthId
   * @return apiAuthId
  **/
  @javax.annotation.Nullable
  public Integer getApiAuthId() {
    return apiAuthId;
  }


  public void setApiAuthId(Integer apiAuthId) {
    this.apiAuthId = apiAuthId;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientAppFull clientAppFull = (ClientAppFull) o;
    return Objects.equals(this.scopes, clientAppFull.scopes) &&
        Objects.equals(this.appId, clientAppFull.appId) &&
        Objects.equals(this.name, clientAppFull.name) &&
        Objects.equals(this.apiAuthId, clientAppFull.apiAuthId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scopes, appId, name, apiAuthId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientAppFull {\n");
    sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    apiAuthId: ").append(toIndentedString(apiAuthId)).append("\n");
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
    openapiFields.add("scopes");
    openapiFields.add("app_id");
    openapiFields.add("name");
    openapiFields.add("api_auth_id");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ClientAppFull
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ClientAppFull.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ClientAppFull is not found in the empty JSON string", ClientAppFull.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!ClientAppFull.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ClientAppFull` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("scopes") != null && !jsonObj.get("scopes").isJsonNull()) {
        JsonArray jsonArrayscopes = jsonObj.getAsJsonArray("scopes");
        if (jsonArrayscopes != null) {
          // ensure the json data is an array
          if (!jsonObj.get("scopes").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `scopes` to be an array in the JSON string but got `%s`", jsonObj.get("scopes").toString()));
          }

          // validate the optional field `scopes` (array)
          for (int i = 0; i < jsonArrayscopes.size(); i++) {
            Scope.validateJsonObject(jsonArrayscopes.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("name") != null && !jsonObj.get("name").isJsonNull()) && !jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ClientAppFull.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ClientAppFull' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ClientAppFull> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ClientAppFull.class));

       return (TypeAdapter<T>) new TypeAdapter<ClientAppFull>() {
           @Override
           public void write(JsonWriter out, ClientAppFull value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ClientAppFull read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ClientAppFull given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ClientAppFull
  * @throws IOException if the JSON string is invalid with respect to ClientAppFull
  */
  public static ClientAppFull fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ClientAppFull.class);
  }

 /**
  * Convert an instance of ClientAppFull to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

