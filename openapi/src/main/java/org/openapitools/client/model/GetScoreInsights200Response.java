/*
 * OneLogin API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

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
import org.openapitools.client.model.GetScoreInsights200ResponseScores;

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

import org.openapitools.client.JSON;

/**
 * GetScoreInsights200Response
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-08T11:55:15.106928-07:00[America/Los_Angeles]")
public class GetScoreInsights200Response {
  public static final String SERIALIZED_NAME_SCORES = "scores";
  @SerializedName(SERIALIZED_NAME_SCORES)
  private GetScoreInsights200ResponseScores scores;

  public static final String SERIALIZED_NAME_TOTAL = "total";
  @SerializedName(SERIALIZED_NAME_TOTAL)
  private Integer total;

  public GetScoreInsights200Response() { 
  }

  public GetScoreInsights200Response scores(GetScoreInsights200ResponseScores scores) {
    
    this.scores = scores;
    return this;
  }

   /**
   * Get scores
   * @return scores
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public GetScoreInsights200ResponseScores getScores() {
    return scores;
  }


  public void setScores(GetScoreInsights200ResponseScores scores) {
    this.scores = scores;
  }


  public GetScoreInsights200Response total(Integer total) {
    
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTotal() {
    return total;
  }


  public void setTotal(Integer total) {
    this.total = total;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetScoreInsights200Response getScoreInsights200Response = (GetScoreInsights200Response) o;
    return Objects.equals(this.scores, getScoreInsights200Response.scores) &&
        Objects.equals(this.total, getScoreInsights200Response.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scores, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetScoreInsights200Response {\n");
    sb.append("    scores: ").append(toIndentedString(scores)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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
    openapiFields.add("scores");
    openapiFields.add("total");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GetScoreInsights200Response
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (GetScoreInsights200Response.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in GetScoreInsights200Response is not found in the empty JSON string", GetScoreInsights200Response.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!GetScoreInsights200Response.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `GetScoreInsights200Response` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      // validate the optional field `scores`
      if (jsonObj.getAsJsonObject("scores") != null) {
        GetScoreInsights200ResponseScores.validateJsonObject(jsonObj.getAsJsonObject("scores"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GetScoreInsights200Response.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GetScoreInsights200Response' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GetScoreInsights200Response> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GetScoreInsights200Response.class));

       return (TypeAdapter<T>) new TypeAdapter<GetScoreInsights200Response>() {
           @Override
           public void write(JsonWriter out, GetScoreInsights200Response value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public GetScoreInsights200Response read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of GetScoreInsights200Response given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GetScoreInsights200Response
  * @throws IOException if the JSON string is invalid with respect to GetScoreInsights200Response
  */
  public static GetScoreInsights200Response fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GetScoreInsights200Response.class);
  }

 /**
  * Convert an instance of GetScoreInsights200Response to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

