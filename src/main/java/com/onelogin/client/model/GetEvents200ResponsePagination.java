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
 * GetEvents200ResponsePagination
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-03-16T13:09:58.336938-07:00[America/Los_Angeles]")
public class GetEvents200ResponsePagination {
  public static final String SERIALIZED_NAME_BEFORE_CURSOR = "before_cursor";
  @SerializedName(SERIALIZED_NAME_BEFORE_CURSOR)
  private String beforeCursor;

  public static final String SERIALIZED_NAME_AFTER_CURSOR = "after_cursor";
  @SerializedName(SERIALIZED_NAME_AFTER_CURSOR)
  private String afterCursor;

  public static final String SERIALIZED_NAME_PREVIOUS_LINK = "previous_link";
  @SerializedName(SERIALIZED_NAME_PREVIOUS_LINK)
  private String previousLink;

  public static final String SERIALIZED_NAME_NEXT_LINK = "next_link";
  @SerializedName(SERIALIZED_NAME_NEXT_LINK)
  private String nextLink;

  public GetEvents200ResponsePagination() {
  }

  public GetEvents200ResponsePagination beforeCursor(String beforeCursor) {
    
    this.beforeCursor = beforeCursor;
    return this;
  }

   /**
   * Get beforeCursor
   * @return beforeCursor
  **/
  @javax.annotation.Nullable

  public String getBeforeCursor() {
    return beforeCursor;
  }


  public void setBeforeCursor(String beforeCursor) {
    this.beforeCursor = beforeCursor;
  }


  public GetEvents200ResponsePagination afterCursor(String afterCursor) {
    
    this.afterCursor = afterCursor;
    return this;
  }

   /**
   * Get afterCursor
   * @return afterCursor
  **/
  @javax.annotation.Nullable

  public String getAfterCursor() {
    return afterCursor;
  }


  public void setAfterCursor(String afterCursor) {
    this.afterCursor = afterCursor;
  }


  public GetEvents200ResponsePagination previousLink(String previousLink) {
    
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


  public GetEvents200ResponsePagination nextLink(String nextLink) {
    
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
    GetEvents200ResponsePagination getEvents200ResponsePagination = (GetEvents200ResponsePagination) o;
    return Objects.equals(this.beforeCursor, getEvents200ResponsePagination.beforeCursor) &&
        Objects.equals(this.afterCursor, getEvents200ResponsePagination.afterCursor) &&
        Objects.equals(this.previousLink, getEvents200ResponsePagination.previousLink) &&
        Objects.equals(this.nextLink, getEvents200ResponsePagination.nextLink);
  }

  @Override
  public int hashCode() {
    return Objects.hash(beforeCursor, afterCursor, previousLink, nextLink);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetEvents200ResponsePagination {\n");
    sb.append("    beforeCursor: ").append(toIndentedString(beforeCursor)).append("\n");
    sb.append("    afterCursor: ").append(toIndentedString(afterCursor)).append("\n");
    sb.append("    previousLink: ").append(toIndentedString(previousLink)).append("\n");
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
    openapiFields.add("before_cursor");
    openapiFields.add("after_cursor");
    openapiFields.add("previous_link");
    openapiFields.add("next_link");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GetEvents200ResponsePagination
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!GetEvents200ResponsePagination.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GetEvents200ResponsePagination is not found in the empty JSON string", GetEvents200ResponsePagination.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!GetEvents200ResponsePagination.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `GetEvents200ResponsePagination` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("before_cursor") != null && !jsonObj.get("before_cursor").isJsonNull()) && !jsonObj.get("before_cursor").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `before_cursor` to be a primitive type in the JSON string but got `%s`", jsonObj.get("before_cursor").toString()));
      }
      if ((jsonObj.get("after_cursor") != null && !jsonObj.get("after_cursor").isJsonNull()) && !jsonObj.get("after_cursor").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `after_cursor` to be a primitive type in the JSON string but got `%s`", jsonObj.get("after_cursor").toString()));
      }
      if ((jsonObj.get("previous_link") != null && !jsonObj.get("previous_link").isJsonNull()) && !jsonObj.get("previous_link").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `previous_link` to be a primitive type in the JSON string but got `%s`", jsonObj.get("previous_link").toString()));
      }
      if ((jsonObj.get("next_link") != null && !jsonObj.get("next_link").isJsonNull()) && !jsonObj.get("next_link").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `next_link` to be a primitive type in the JSON string but got `%s`", jsonObj.get("next_link").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GetEvents200ResponsePagination.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GetEvents200ResponsePagination' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GetEvents200ResponsePagination> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GetEvents200ResponsePagination.class));

       return (TypeAdapter<T>) new TypeAdapter<GetEvents200ResponsePagination>() {
           @Override
           public void write(JsonWriter out, GetEvents200ResponsePagination value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public GetEvents200ResponsePagination read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of GetEvents200ResponsePagination given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GetEvents200ResponsePagination
  * @throws IOException if the JSON string is invalid with respect to GetEvents200ResponsePagination
  */
  public static GetEvents200ResponsePagination fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GetEvents200ResponsePagination.class);
  }

 /**
  * Convert an instance of GetEvents200ResponsePagination to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

