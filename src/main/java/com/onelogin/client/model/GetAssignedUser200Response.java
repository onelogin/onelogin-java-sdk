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
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;

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
 * GetAssignedUser200Response
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-03-16T12:13:23.145217-07:00[America/Los_Angeles]")
public class GetAssignedUser200Response {
  public static final String SERIALIZED_NAME_TOTAL = "total";
  @SerializedName(SERIALIZED_NAME_TOTAL)
  private Integer total;

  public static final String SERIALIZED_NAME_USERS = "users";
  @SerializedName(SERIALIZED_NAME_USERS)
  private List<Integer> users = null;

  public static final String SERIALIZED_NAME_BEFORE_CURSOR = "beforeCursor";
  @SerializedName(SERIALIZED_NAME_BEFORE_CURSOR)
  private Integer beforeCursor;

  public static final String SERIALIZED_NAME_PREVIOUS_LINK = "previousLink";
  @SerializedName(SERIALIZED_NAME_PREVIOUS_LINK)
  private String previousLink;

  public static final String SERIALIZED_NAME_AFTER_CURSOR = "afterCursor";
  @SerializedName(SERIALIZED_NAME_AFTER_CURSOR)
  private Integer afterCursor;

  public static final String SERIALIZED_NAME_NEXT_LINK = "nextLink";
  @SerializedName(SERIALIZED_NAME_NEXT_LINK)
  private String nextLink;

  public GetAssignedUser200Response() {
  }

  public GetAssignedUser200Response total(Integer total) {
    
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @javax.annotation.Nullable

  public Integer getTotal() {
    return total;
  }


  public void setTotal(Integer total) {
    this.total = total;
  }


  public GetAssignedUser200Response users(List<Integer> users) {
    
    this.users = users;
    return this;
  }

  public GetAssignedUser200Response addUsersItem(Integer usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<>();
    }
    this.users.add(usersItem);
    return this;
  }

   /**
   * Get users
   * @return users
  **/
  @javax.annotation.Nullable

  public List<Integer> getUsers() {
    return users;
  }


  public void setUsers(List<Integer> users) {
    this.users = users;
  }


  public GetAssignedUser200Response beforeCursor(Integer beforeCursor) {
    
    this.beforeCursor = beforeCursor;
    return this;
  }

   /**
   * Get beforeCursor
   * @return beforeCursor
  **/
  @javax.annotation.Nullable

  public Integer getBeforeCursor() {
    return beforeCursor;
  }


  public void setBeforeCursor(Integer beforeCursor) {
    this.beforeCursor = beforeCursor;
  }


  public GetAssignedUser200Response previousLink(String previousLink) {
    
    this.previousLink = previousLink;
    return this;
  }

   /**
   * Get previousLink
   * @return previousLink
  **/
  @javax.annotation.Nullable

  public String getPreviousLink() {
    return previousLink;
  }


  public void setPreviousLink(String previousLink) {
    this.previousLink = previousLink;
  }


  public GetAssignedUser200Response afterCursor(Integer afterCursor) {
    
    this.afterCursor = afterCursor;
    return this;
  }

   /**
   * Get afterCursor
   * @return afterCursor
  **/
  @javax.annotation.Nullable

  public Integer getAfterCursor() {
    return afterCursor;
  }


  public void setAfterCursor(Integer afterCursor) {
    this.afterCursor = afterCursor;
  }


  public GetAssignedUser200Response nextLink(String nextLink) {
    
    this.nextLink = nextLink;
    return this;
  }

   /**
   * Get nextLink
   * @return nextLink
  **/
  @javax.annotation.Nullable

  public String getNextLink() {
    return nextLink;
  }


  public void setNextLink(String nextLink) {
    this.nextLink = nextLink;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAssignedUser200Response getAssignedUser200Response = (GetAssignedUser200Response) o;
    return Objects.equals(this.total, getAssignedUser200Response.total) &&
        Objects.equals(this.users, getAssignedUser200Response.users) &&
        Objects.equals(this.beforeCursor, getAssignedUser200Response.beforeCursor) &&
        Objects.equals(this.previousLink, getAssignedUser200Response.previousLink) &&
        Objects.equals(this.afterCursor, getAssignedUser200Response.afterCursor) &&
        Objects.equals(this.nextLink, getAssignedUser200Response.nextLink);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, users, beforeCursor, previousLink, afterCursor, nextLink);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAssignedUser200Response {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    beforeCursor: ").append(toIndentedString(beforeCursor)).append("\n");
    sb.append("    previousLink: ").append(toIndentedString(previousLink)).append("\n");
    sb.append("    afterCursor: ").append(toIndentedString(afterCursor)).append("\n");
    sb.append("    nextLink: ").append(toIndentedString(nextLink)).append("\n");
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
    openapiFields.add("total");
    openapiFields.add("users");
    openapiFields.add("beforeCursor");
    openapiFields.add("previousLink");
    openapiFields.add("afterCursor");
    openapiFields.add("nextLink");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GetAssignedUser200Response
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!GetAssignedUser200Response.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GetAssignedUser200Response is not found in the empty JSON string", GetAssignedUser200Response.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!GetAssignedUser200Response.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `GetAssignedUser200Response` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("users") != null && !jsonObj.get("users").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `users` to be an array in the JSON string but got `%s`", jsonObj.get("users").toString()));
      }
      if ((jsonObj.get("previousLink") != null && !jsonObj.get("previousLink").isJsonNull()) && !jsonObj.get("previousLink").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `previousLink` to be a primitive type in the JSON string but got `%s`", jsonObj.get("previousLink").toString()));
      }
      if ((jsonObj.get("nextLink") != null && !jsonObj.get("nextLink").isJsonNull()) && !jsonObj.get("nextLink").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `nextLink` to be a primitive type in the JSON string but got `%s`", jsonObj.get("nextLink").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GetAssignedUser200Response.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GetAssignedUser200Response' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GetAssignedUser200Response> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GetAssignedUser200Response.class));

       return (TypeAdapter<T>) new TypeAdapter<GetAssignedUser200Response>() {
           @Override
           public void write(JsonWriter out, GetAssignedUser200Response value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public GetAssignedUser200Response read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of GetAssignedUser200Response given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GetAssignedUser200Response
  * @throws IOException if the JSON string is invalid with respect to GetAssignedUser200Response
  */
  public static GetAssignedUser200Response fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GetAssignedUser200Response.class);
  }

 /**
  * Convert an instance of GetAssignedUser200Response to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

