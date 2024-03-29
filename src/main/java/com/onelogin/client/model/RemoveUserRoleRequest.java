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
import com.onelogin.client.model.RemoveUserRoleRequestRoleIdArrayInner;
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
 * RemoveUserRoleRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-07-18T11:53:48.226013-07:00[America/Los_Angeles]")
public class RemoveUserRoleRequest {
  public static final String SERIALIZED_NAME_ROLE_ID_ARRAY = "role_id_array";
  @SerializedName(SERIALIZED_NAME_ROLE_ID_ARRAY)
  private List<RemoveUserRoleRequestRoleIdArrayInner> roleIdArray = new ArrayList<>();

  public RemoveUserRoleRequest() {
  }

  public RemoveUserRoleRequest roleIdArray(List<RemoveUserRoleRequestRoleIdArrayInner> roleIdArray) {
    
    this.roleIdArray = roleIdArray;
    return this;
  }

  public RemoveUserRoleRequest addRoleIdArrayItem(RemoveUserRoleRequestRoleIdArrayInner roleIdArrayItem) {
    if (this.roleIdArray == null) {
      this.roleIdArray = new ArrayList<>();
    }
    this.roleIdArray.add(roleIdArrayItem);
    return this;
  }

   /**
   * Get roleIdArray
   * @return roleIdArray
  **/
  @javax.annotation.Nonnull
  public List<RemoveUserRoleRequestRoleIdArrayInner> getRoleIdArray() {
    return roleIdArray;
  }


  public void setRoleIdArray(List<RemoveUserRoleRequestRoleIdArrayInner> roleIdArray) {
    this.roleIdArray = roleIdArray;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RemoveUserRoleRequest removeUserRoleRequest = (RemoveUserRoleRequest) o;
    return Objects.equals(this.roleIdArray, removeUserRoleRequest.roleIdArray);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleIdArray);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RemoveUserRoleRequest {\n");
    sb.append("    roleIdArray: ").append(toIndentedString(roleIdArray)).append("\n");
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
    openapiFields.add("role_id_array");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("role_id_array");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RemoveUserRoleRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RemoveUserRoleRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RemoveUserRoleRequest is not found in the empty JSON string", RemoveUserRoleRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RemoveUserRoleRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RemoveUserRoleRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : RemoveUserRoleRequest.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      // ensure the json data is an array
      if (!jsonObj.get("role_id_array").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `role_id_array` to be an array in the JSON string but got `%s`", jsonObj.get("role_id_array").toString()));
      }

      JsonArray jsonArrayroleIdArray = jsonObj.getAsJsonArray("role_id_array");
      // validate the required field `role_id_array` (array)
      for (int i = 0; i < jsonArrayroleIdArray.size(); i++) {
        RemoveUserRoleRequestRoleIdArrayInner.validateJsonObject(jsonArrayroleIdArray.get(i).getAsJsonObject());
      };
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RemoveUserRoleRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RemoveUserRoleRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RemoveUserRoleRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RemoveUserRoleRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<RemoveUserRoleRequest>() {
           @Override
           public void write(JsonWriter out, RemoveUserRoleRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RemoveUserRoleRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RemoveUserRoleRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RemoveUserRoleRequest
  * @throws IOException if the JSON string is invalid with respect to RemoveUserRoleRequest
  */
  public static RemoveUserRoleRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RemoveUserRoleRequest.class);
  }

 /**
  * Convert an instance of RemoveUserRoleRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

