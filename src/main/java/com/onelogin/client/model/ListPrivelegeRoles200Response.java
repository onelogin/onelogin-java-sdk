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
 * ListPrivelegeRoles200Response
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-03-16T12:13:23.145217-07:00[America/Los_Angeles]")
public class ListPrivelegeRoles200Response {
  public static final String SERIALIZED_NAME_TOTAL = "total";
  @SerializedName(SERIALIZED_NAME_TOTAL)
  private Integer total;

  public static final String SERIALIZED_NAME_ROLES = "roles";
  @SerializedName(SERIALIZED_NAME_ROLES)
  private List<Integer> roles = null;

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

  public ListPrivelegeRoles200Response() {
  }

  public ListPrivelegeRoles200Response total(Integer total) {
    
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


  public ListPrivelegeRoles200Response roles(List<Integer> roles) {
    
    this.roles = roles;
    return this;
  }

  public ListPrivelegeRoles200Response addRolesItem(Integer rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<>();
    }
    this.roles.add(rolesItem);
    return this;
  }

   /**
   * Get roles
   * @return roles
  **/
  @javax.annotation.Nullable

  public List<Integer> getRoles() {
    return roles;
  }


  public void setRoles(List<Integer> roles) {
    this.roles = roles;
  }


  public ListPrivelegeRoles200Response beforeCursor(Integer beforeCursor) {
    
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


  public ListPrivelegeRoles200Response previousLink(String previousLink) {
    
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


  public ListPrivelegeRoles200Response afterCursor(Integer afterCursor) {
    
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


  public ListPrivelegeRoles200Response nextLink(String nextLink) {
    
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
    ListPrivelegeRoles200Response listPrivelegeRoles200Response = (ListPrivelegeRoles200Response) o;
    return Objects.equals(this.total, listPrivelegeRoles200Response.total) &&
        Objects.equals(this.roles, listPrivelegeRoles200Response.roles) &&
        Objects.equals(this.beforeCursor, listPrivelegeRoles200Response.beforeCursor) &&
        Objects.equals(this.previousLink, listPrivelegeRoles200Response.previousLink) &&
        Objects.equals(this.afterCursor, listPrivelegeRoles200Response.afterCursor) &&
        Objects.equals(this.nextLink, listPrivelegeRoles200Response.nextLink);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, roles, beforeCursor, previousLink, afterCursor, nextLink);
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
    sb.append("class ListPrivelegeRoles200Response {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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
    openapiFields.add("roles");
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
  * @throws IOException if the JSON Object is invalid with respect to ListPrivelegeRoles200Response
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ListPrivelegeRoles200Response.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ListPrivelegeRoles200Response is not found in the empty JSON string", ListPrivelegeRoles200Response.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!ListPrivelegeRoles200Response.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ListPrivelegeRoles200Response` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("roles") != null && !jsonObj.get("roles").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `roles` to be an array in the JSON string but got `%s`", jsonObj.get("roles").toString()));
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
       if (!ListPrivelegeRoles200Response.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ListPrivelegeRoles200Response' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ListPrivelegeRoles200Response> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ListPrivelegeRoles200Response.class));

       return (TypeAdapter<T>) new TypeAdapter<ListPrivelegeRoles200Response>() {
           @Override
           public void write(JsonWriter out, ListPrivelegeRoles200Response value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ListPrivelegeRoles200Response read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ListPrivelegeRoles200Response given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ListPrivelegeRoles200Response
  * @throws IOException if the JSON string is invalid with respect to ListPrivelegeRoles200Response
  */
  public static ListPrivelegeRoles200Response fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ListPrivelegeRoles200Response.class);
  }

 /**
  * Convert an instance of ListPrivelegeRoles200Response to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

