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
import com.onelogin.sdk.model.RiskDevice;
import com.onelogin.sdk.model.RiskUser;
import com.onelogin.sdk.model.Session;
import com.onelogin.sdk.model.Source;
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
 * TrackEventRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-08-10T13:08:46.841766-07:00[America/Los_Angeles]")
public class TrackEventRequest {
  public static final String SERIALIZED_NAME_VERB = "verb";
  @SerializedName(SERIALIZED_NAME_VERB)
  private String verb;

  public static final String SERIALIZED_NAME_IP = "ip";
  @SerializedName(SERIALIZED_NAME_IP)
  private String ip;

  public static final String SERIALIZED_NAME_USER_AGENT = "user_agent";
  @SerializedName(SERIALIZED_NAME_USER_AGENT)
  private String userAgent;

  public static final String SERIALIZED_NAME_USER = "user";
  @SerializedName(SERIALIZED_NAME_USER)
  private RiskUser user;

  public static final String SERIALIZED_NAME_SOURCE = "source";
  @SerializedName(SERIALIZED_NAME_SOURCE)
  private Source source;

  public static final String SERIALIZED_NAME_SESSION = "session";
  @SerializedName(SERIALIZED_NAME_SESSION)
  private Session session;

  public static final String SERIALIZED_NAME_DEVICE = "device";
  @SerializedName(SERIALIZED_NAME_DEVICE)
  private RiskDevice device;

  public static final String SERIALIZED_NAME_FP = "fp";
  @SerializedName(SERIALIZED_NAME_FP)
  private String fp;

  public static final String SERIALIZED_NAME_PUBLISHED = "published";
  @SerializedName(SERIALIZED_NAME_PUBLISHED)
  private String published;

  public TrackEventRequest() { 
  }

  public TrackEventRequest verb(String verb) {
    
    this.verb = verb;
    return this;
  }

   /**
   * Verbs are used to distinguish between different types of events.
   * @return verb
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Verbs are used to distinguish between different types of events.")

  public String getVerb() {
    return verb;
  }


  public void setVerb(String verb) {
    this.verb = verb;
  }


  public TrackEventRequest ip(String ip) {
    
    this.ip = ip;
    return this;
  }

   /**
   * The IP address of the User&#39;s request.
   * @return ip
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The IP address of the User's request.")

  public String getIp() {
    return ip;
  }


  public void setIp(String ip) {
    this.ip = ip;
  }


  public TrackEventRequest userAgent(String userAgent) {
    
    this.userAgent = userAgent;
    return this;
  }

   /**
   * The user agent of the User&#39;s request.
   * @return userAgent
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The user agent of the User's request.")

  public String getUserAgent() {
    return userAgent;
  }


  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }


  public TrackEventRequest user(RiskUser user) {
    
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public RiskUser getUser() {
    return user;
  }


  public void setUser(RiskUser user) {
    this.user = user;
  }


  public TrackEventRequest source(Source source) {
    
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Source getSource() {
    return source;
  }


  public void setSource(Source source) {
    this.source = source;
  }


  public TrackEventRequest session(Session session) {
    
    this.session = session;
    return this;
  }

   /**
   * Get session
   * @return session
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Session getSession() {
    return session;
  }


  public void setSession(Session session) {
    this.session = session;
  }


  public TrackEventRequest device(RiskDevice device) {
    
    this.device = device;
    return this;
  }

   /**
   * Get device
   * @return device
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public RiskDevice getDevice() {
    return device;
  }


  public void setDevice(RiskDevice device) {
    this.device = device;
  }


  public TrackEventRequest fp(String fp) {
    
    this.fp = fp;
    return this;
  }

   /**
   * Set to the value of the __tdli_fp cookie.
   * @return fp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Set to the value of the __tdli_fp cookie.")

  public String getFp() {
    return fp;
  }


  public void setFp(String fp) {
    this.fp = fp;
  }


  public TrackEventRequest published(String published) {
    
    this.published = published;
    return this;
  }

   /**
   * Date and time of the event in IS08601 format. Useful for preloading old events. Defaults to date time this API request is received.
   * @return published
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date and time of the event in IS08601 format. Useful for preloading old events. Defaults to date time this API request is received.")

  public String getPublished() {
    return published;
  }


  public void setPublished(String published) {
    this.published = published;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrackEventRequest trackEventRequest = (TrackEventRequest) o;
    return Objects.equals(this.verb, trackEventRequest.verb) &&
        Objects.equals(this.ip, trackEventRequest.ip) &&
        Objects.equals(this.userAgent, trackEventRequest.userAgent) &&
        Objects.equals(this.user, trackEventRequest.user) &&
        Objects.equals(this.source, trackEventRequest.source) &&
        Objects.equals(this.session, trackEventRequest.session) &&
        Objects.equals(this.device, trackEventRequest.device) &&
        Objects.equals(this.fp, trackEventRequest.fp) &&
        Objects.equals(this.published, trackEventRequest.published);
  }

  @Override
  public int hashCode() {
    return Objects.hash(verb, ip, userAgent, user, source, session, device, fp, published);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrackEventRequest {\n");
    sb.append("    verb: ").append(toIndentedString(verb)).append("\n");
    sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
    sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    session: ").append(toIndentedString(session)).append("\n");
    sb.append("    device: ").append(toIndentedString(device)).append("\n");
    sb.append("    fp: ").append(toIndentedString(fp)).append("\n");
    sb.append("    published: ").append(toIndentedString(published)).append("\n");
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
    openapiFields.add("verb");
    openapiFields.add("ip");
    openapiFields.add("user_agent");
    openapiFields.add("user");
    openapiFields.add("source");
    openapiFields.add("session");
    openapiFields.add("device");
    openapiFields.add("fp");
    openapiFields.add("published");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("verb");
    openapiRequiredFields.add("ip");
    openapiRequiredFields.add("user_agent");
    openapiRequiredFields.add("user");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to TrackEventRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (TrackEventRequest.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in TrackEventRequest is not found in the empty JSON string", TrackEventRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!TrackEventRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TrackEventRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : TrackEventRequest.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (jsonObj.get("verb") != null && !jsonObj.get("verb").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `verb` to be a primitive type in the JSON string but got `%s`", jsonObj.get("verb").toString()));
      }
      if (jsonObj.get("ip") != null && !jsonObj.get("ip").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ip` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ip").toString()));
      }
      if (jsonObj.get("user_agent") != null && !jsonObj.get("user_agent").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `user_agent` to be a primitive type in the JSON string but got `%s`", jsonObj.get("user_agent").toString()));
      }
      // validate the optional field `user`
      if (jsonObj.getAsJsonObject("user") != null) {
        RiskUser.validateJsonObject(jsonObj.getAsJsonObject("user"));
      }
      // validate the optional field `source`
      if (jsonObj.getAsJsonObject("source") != null) {
        Source.validateJsonObject(jsonObj.getAsJsonObject("source"));
      }
      // validate the optional field `session`
      if (jsonObj.getAsJsonObject("session") != null) {
        Session.validateJsonObject(jsonObj.getAsJsonObject("session"));
      }
      // validate the optional field `device`
      if (jsonObj.getAsJsonObject("device") != null) {
        RiskDevice.validateJsonObject(jsonObj.getAsJsonObject("device"));
      }
      if (jsonObj.get("fp") != null && !jsonObj.get("fp").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `fp` to be a primitive type in the JSON string but got `%s`", jsonObj.get("fp").toString()));
      }
      if (jsonObj.get("published") != null && !jsonObj.get("published").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `published` to be a primitive type in the JSON string but got `%s`", jsonObj.get("published").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TrackEventRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TrackEventRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TrackEventRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TrackEventRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<TrackEventRequest>() {
           @Override
           public void write(JsonWriter out, TrackEventRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TrackEventRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TrackEventRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TrackEventRequest
  * @throws IOException if the JSON string is invalid with respect to TrackEventRequest
  */
  public static TrackEventRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TrackEventRequest.class);
  }

 /**
  * Convert an instance of TrackEventRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

