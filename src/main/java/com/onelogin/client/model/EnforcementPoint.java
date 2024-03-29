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
import com.onelogin.client.model.ClockCounter;
import com.onelogin.client.model.EnforcementPointResourcesInner;
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
 * For apps that connect to a OneLogin Access Enforcement Point the following enforcement_point object will be included with the app payload.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-07-18T11:53:48.226013-07:00[America/Los_Angeles]")
public class EnforcementPoint {
  public static final String SERIALIZED_NAME_REQUIRE_SITEWIDE_AUTHENTICATION = "require_sitewide_authentication";
  @SerializedName(SERIALIZED_NAME_REQUIRE_SITEWIDE_AUTHENTICATION)
  private Boolean requireSitewideAuthentication;

  public static final String SERIALIZED_NAME_CONDITIONS = "conditions";
  @SerializedName(SERIALIZED_NAME_CONDITIONS)
  private String conditions;

  public static final String SERIALIZED_NAME_SESSION_EXPIRY_FIXED = "session_expiry_fixed";
  @SerializedName(SERIALIZED_NAME_SESSION_EXPIRY_FIXED)
  private ClockCounter sessionExpiryFixed;

  public static final String SERIALIZED_NAME_SESSION_EXPIRY_INACTIVITY = "session_expiry_inactivity";
  @SerializedName(SERIALIZED_NAME_SESSION_EXPIRY_INACTIVITY)
  private ClockCounter sessionExpiryInactivity;

  /**
   * Specify to always &#x60;allow&#x60;, &#x60;deny&#x60; access to resources, of if access is &#x60;conditional&#x60;.
   */
  @JsonAdapter(PermissionsEnum.Adapter.class)
  public enum PermissionsEnum {
    ALLOW("allow"),
    
    DENY("deny"),
    
    CONDITIONAL("conditional");

    private String value;

    PermissionsEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PermissionsEnum fromValue(String value) {
      for (PermissionsEnum b : PermissionsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PermissionsEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PermissionsEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PermissionsEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PermissionsEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PERMISSIONS = "permissions";
  @SerializedName(SERIALIZED_NAME_PERMISSIONS)
  private PermissionsEnum permissions;

  public static final String SERIALIZED_NAME_TOKEN = "token";
  @SerializedName(SERIALIZED_NAME_TOKEN)
  private String token;

  public static final String SERIALIZED_NAME_TARGET = "target";
  @SerializedName(SERIALIZED_NAME_TARGET)
  private String target;

  public static final String SERIALIZED_NAME_RESOURCES = "resources";
  @SerializedName(SERIALIZED_NAME_RESOURCES)
  private List<EnforcementPointResourcesInner> resources;

  public static final String SERIALIZED_NAME_CONTEXT_ROOT = "context_root";
  @SerializedName(SERIALIZED_NAME_CONTEXT_ROOT)
  private String contextRoot;

  public static final String SERIALIZED_NAME_USE_TARGET_HOST_HEADER = "use_target_host_header";
  @SerializedName(SERIALIZED_NAME_USE_TARGET_HOST_HEADER)
  private Boolean useTargetHostHeader;

  public static final String SERIALIZED_NAME_VHOST = "vhost";
  @SerializedName(SERIALIZED_NAME_VHOST)
  private String vhost;

  public static final String SERIALIZED_NAME_LANDING_PAGE = "landing_page";
  @SerializedName(SERIALIZED_NAME_LANDING_PAGE)
  private String landingPage;

  public static final String SERIALIZED_NAME_CASE_SENSITIVE = "case_sensitive";
  @SerializedName(SERIALIZED_NAME_CASE_SENSITIVE)
  private Boolean caseSensitive;

  public EnforcementPoint() {
  }

  
  public EnforcementPoint(
     String token
  ) {
    this();
    this.token = token;
  }

  public EnforcementPoint requireSitewideAuthentication(Boolean requireSitewideAuthentication) {
    
    this.requireSitewideAuthentication = requireSitewideAuthentication;
    return this;
  }

   /**
   * Require user authentication to access any resource protected by this enforcement point.
   * @return requireSitewideAuthentication
  **/
  @javax.annotation.Nullable
  public Boolean getRequireSitewideAuthentication() {
    return requireSitewideAuthentication;
  }


  public void setRequireSitewideAuthentication(Boolean requireSitewideAuthentication) {
    this.requireSitewideAuthentication = requireSitewideAuthentication;
  }


  public EnforcementPoint conditions(String conditions) {
    
    this.conditions = conditions;
    return this;
  }

   /**
   * If access is conditional, the conditions that must evaluate to true to allow access to a resource. For example, to require the user must be authenticated and have either the role Admin or User
   * @return conditions
  **/
  @javax.annotation.Nullable
  public String getConditions() {
    return conditions;
  }


  public void setConditions(String conditions) {
    this.conditions = conditions;
  }


  public EnforcementPoint sessionExpiryFixed(ClockCounter sessionExpiryFixed) {
    
    this.sessionExpiryFixed = sessionExpiryFixed;
    return this;
  }

   /**
   * Get sessionExpiryFixed
   * @return sessionExpiryFixed
  **/
  @javax.annotation.Nullable
  public ClockCounter getSessionExpiryFixed() {
    return sessionExpiryFixed;
  }


  public void setSessionExpiryFixed(ClockCounter sessionExpiryFixed) {
    this.sessionExpiryFixed = sessionExpiryFixed;
  }


  public EnforcementPoint sessionExpiryInactivity(ClockCounter sessionExpiryInactivity) {
    
    this.sessionExpiryInactivity = sessionExpiryInactivity;
    return this;
  }

   /**
   * Get sessionExpiryInactivity
   * @return sessionExpiryInactivity
  **/
  @javax.annotation.Nullable
  public ClockCounter getSessionExpiryInactivity() {
    return sessionExpiryInactivity;
  }


  public void setSessionExpiryInactivity(ClockCounter sessionExpiryInactivity) {
    this.sessionExpiryInactivity = sessionExpiryInactivity;
  }


  public EnforcementPoint permissions(PermissionsEnum permissions) {
    
    this.permissions = permissions;
    return this;
  }

   /**
   * Specify to always &#x60;allow&#x60;, &#x60;deny&#x60; access to resources, of if access is &#x60;conditional&#x60;.
   * @return permissions
  **/
  @javax.annotation.Nullable
  public PermissionsEnum getPermissions() {
    return permissions;
  }


  public void setPermissions(PermissionsEnum permissions) {
    this.permissions = permissions;
  }


   /**
   * Can only be set on create. Access Gateway Token.
   * @return token
  **/
  @javax.annotation.Nullable
  public String getToken() {
    return token;
  }




  public EnforcementPoint target(String target) {
    
    this.target = target;
    return this;
  }

   /**
   * A fully-qualified URL to the internal application including scheme, authority and path. The target host authority must be an IP address, not a hostname.
   * @return target
  **/
  @javax.annotation.Nullable
  public String getTarget() {
    return target;
  }


  public void setTarget(String target) {
    this.target = target;
  }


  public EnforcementPoint resources(List<EnforcementPointResourcesInner> resources) {
    
    this.resources = resources;
    return this;
  }

  public EnforcementPoint addResourcesItem(EnforcementPointResourcesInner resourcesItem) {
    if (this.resources == null) {
      this.resources = new ArrayList<>();
    }
    this.resources.add(resourcesItem);
    return this;
  }

   /**
   * Array of resource objects
   * @return resources
  **/
  @javax.annotation.Nullable
  public List<EnforcementPointResourcesInner> getResources() {
    return resources;
  }


  public void setResources(List<EnforcementPointResourcesInner> resources) {
    this.resources = resources;
  }


  public EnforcementPoint contextRoot(String contextRoot) {
    
    this.contextRoot = contextRoot;
    return this;
  }

   /**
   * The root path to the application, often the name of the application. Can be any name, path or just a slash (“/”). The context root uniquely identifies the application within the enforcement point.
   * @return contextRoot
  **/
  @javax.annotation.Nullable
  public String getContextRoot() {
    return contextRoot;
  }


  public void setContextRoot(String contextRoot) {
    this.contextRoot = contextRoot;
  }


  public EnforcementPoint useTargetHostHeader(Boolean useTargetHostHeader) {
    
    this.useTargetHostHeader = useTargetHostHeader;
    return this;
  }

   /**
   * Use the target host header as opposed to the original gateway or upstream host header.
   * @return useTargetHostHeader
  **/
  @javax.annotation.Nullable
  public Boolean getUseTargetHostHeader() {
    return useTargetHostHeader;
  }


  public void setUseTargetHostHeader(Boolean useTargetHostHeader) {
    this.useTargetHostHeader = useTargetHostHeader;
  }


  public EnforcementPoint vhost(String vhost) {
    
    this.vhost = vhost;
    return this;
  }

   /**
   * A comma-delimited list of one or more virtual hosts that map to applications assigned to the enforcement point. A VHOST may be a host name or an IP address. VHOST distinguish between applications that are at the same context root.
   * @return vhost
  **/
  @javax.annotation.Nullable
  public String getVhost() {
    return vhost;
  }


  public void setVhost(String vhost) {
    this.vhost = vhost;
  }


  public EnforcementPoint landingPage(String landingPage) {
    
    this.landingPage = landingPage;
    return this;
  }

   /**
   * The location within the context root to which the browser will be redirected for IdP-initiated single sign-on. For example, the landing page might be an index page in the context root such as index.html or default.aspx. The landing page cannot begin with a slash and must use valid URL characters.
   * @return landingPage
  **/
  @javax.annotation.Nullable
  public String getLandingPage() {
    return landingPage;
  }


  public void setLandingPage(String landingPage) {
    this.landingPage = landingPage;
  }


  public EnforcementPoint caseSensitive(Boolean caseSensitive) {
    
    this.caseSensitive = caseSensitive;
    return this;
  }

   /**
   * The URL path evaluation is case insensitive by default. Resources hosted on web servers such as Apache, NGINX and Java EE are case sensitive paths. Web servers such as Microsoft IIS are not case-sensitive.
   * @return caseSensitive
  **/
  @javax.annotation.Nullable
  public Boolean getCaseSensitive() {
    return caseSensitive;
  }


  public void setCaseSensitive(Boolean caseSensitive) {
    this.caseSensitive = caseSensitive;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnforcementPoint enforcementPoint = (EnforcementPoint) o;
    return Objects.equals(this.requireSitewideAuthentication, enforcementPoint.requireSitewideAuthentication) &&
        Objects.equals(this.conditions, enforcementPoint.conditions) &&
        Objects.equals(this.sessionExpiryFixed, enforcementPoint.sessionExpiryFixed) &&
        Objects.equals(this.sessionExpiryInactivity, enforcementPoint.sessionExpiryInactivity) &&
        Objects.equals(this.permissions, enforcementPoint.permissions) &&
        Objects.equals(this.token, enforcementPoint.token) &&
        Objects.equals(this.target, enforcementPoint.target) &&
        Objects.equals(this.resources, enforcementPoint.resources) &&
        Objects.equals(this.contextRoot, enforcementPoint.contextRoot) &&
        Objects.equals(this.useTargetHostHeader, enforcementPoint.useTargetHostHeader) &&
        Objects.equals(this.vhost, enforcementPoint.vhost) &&
        Objects.equals(this.landingPage, enforcementPoint.landingPage) &&
        Objects.equals(this.caseSensitive, enforcementPoint.caseSensitive);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(requireSitewideAuthentication, conditions, sessionExpiryFixed, sessionExpiryInactivity, permissions, token, target, resources, contextRoot, useTargetHostHeader, vhost, landingPage, caseSensitive);
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
    sb.append("class EnforcementPoint {\n");
    sb.append("    requireSitewideAuthentication: ").append(toIndentedString(requireSitewideAuthentication)).append("\n");
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
    sb.append("    sessionExpiryFixed: ").append(toIndentedString(sessionExpiryFixed)).append("\n");
    sb.append("    sessionExpiryInactivity: ").append(toIndentedString(sessionExpiryInactivity)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
    sb.append("    contextRoot: ").append(toIndentedString(contextRoot)).append("\n");
    sb.append("    useTargetHostHeader: ").append(toIndentedString(useTargetHostHeader)).append("\n");
    sb.append("    vhost: ").append(toIndentedString(vhost)).append("\n");
    sb.append("    landingPage: ").append(toIndentedString(landingPage)).append("\n");
    sb.append("    caseSensitive: ").append(toIndentedString(caseSensitive)).append("\n");
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
    openapiFields.add("require_sitewide_authentication");
    openapiFields.add("conditions");
    openapiFields.add("session_expiry_fixed");
    openapiFields.add("session_expiry_inactivity");
    openapiFields.add("permissions");
    openapiFields.add("token");
    openapiFields.add("target");
    openapiFields.add("resources");
    openapiFields.add("context_root");
    openapiFields.add("use_target_host_header");
    openapiFields.add("vhost");
    openapiFields.add("landing_page");
    openapiFields.add("case_sensitive");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to EnforcementPoint
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!EnforcementPoint.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in EnforcementPoint is not found in the empty JSON string", EnforcementPoint.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!EnforcementPoint.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `EnforcementPoint` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("conditions") != null && !jsonObj.get("conditions").isJsonNull()) && !jsonObj.get("conditions").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `conditions` to be a primitive type in the JSON string but got `%s`", jsonObj.get("conditions").toString()));
      }
      // validate the optional field `session_expiry_fixed`
      if (jsonObj.get("session_expiry_fixed") != null && !jsonObj.get("session_expiry_fixed").isJsonNull()) {
        ClockCounter.validateJsonObject(jsonObj.getAsJsonObject("session_expiry_fixed"));
      }
      // validate the optional field `session_expiry_inactivity`
      if (jsonObj.get("session_expiry_inactivity") != null && !jsonObj.get("session_expiry_inactivity").isJsonNull()) {
        ClockCounter.validateJsonObject(jsonObj.getAsJsonObject("session_expiry_inactivity"));
      }
      if ((jsonObj.get("permissions") != null && !jsonObj.get("permissions").isJsonNull()) && !jsonObj.get("permissions").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `permissions` to be a primitive type in the JSON string but got `%s`", jsonObj.get("permissions").toString()));
      }
      if ((jsonObj.get("token") != null && !jsonObj.get("token").isJsonNull()) && !jsonObj.get("token").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `token` to be a primitive type in the JSON string but got `%s`", jsonObj.get("token").toString()));
      }
      if ((jsonObj.get("target") != null && !jsonObj.get("target").isJsonNull()) && !jsonObj.get("target").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `target` to be a primitive type in the JSON string but got `%s`", jsonObj.get("target").toString()));
      }
      if (jsonObj.get("resources") != null && !jsonObj.get("resources").isJsonNull()) {
        JsonArray jsonArrayresources = jsonObj.getAsJsonArray("resources");
        if (jsonArrayresources != null) {
          // ensure the json data is an array
          if (!jsonObj.get("resources").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `resources` to be an array in the JSON string but got `%s`", jsonObj.get("resources").toString()));
          }

          // validate the optional field `resources` (array)
          for (int i = 0; i < jsonArrayresources.size(); i++) {
            EnforcementPointResourcesInner.validateJsonObject(jsonArrayresources.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("context_root") != null && !jsonObj.get("context_root").isJsonNull()) && !jsonObj.get("context_root").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `context_root` to be a primitive type in the JSON string but got `%s`", jsonObj.get("context_root").toString()));
      }
      if ((jsonObj.get("vhost") != null && !jsonObj.get("vhost").isJsonNull()) && !jsonObj.get("vhost").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `vhost` to be a primitive type in the JSON string but got `%s`", jsonObj.get("vhost").toString()));
      }
      if ((jsonObj.get("landing_page") != null && !jsonObj.get("landing_page").isJsonNull()) && !jsonObj.get("landing_page").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `landing_page` to be a primitive type in the JSON string but got `%s`", jsonObj.get("landing_page").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!EnforcementPoint.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'EnforcementPoint' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<EnforcementPoint> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(EnforcementPoint.class));

       return (TypeAdapter<T>) new TypeAdapter<EnforcementPoint>() {
           @Override
           public void write(JsonWriter out, EnforcementPoint value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public EnforcementPoint read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of EnforcementPoint given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of EnforcementPoint
  * @throws IOException if the JSON string is invalid with respect to EnforcementPoint
  */
  public static EnforcementPoint fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, EnforcementPoint.class);
  }

 /**
  * Convert an instance of EnforcementPoint to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

