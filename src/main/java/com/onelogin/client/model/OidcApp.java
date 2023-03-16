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
import com.onelogin.client.model.AppParameters;
import com.onelogin.client.model.AuthMethod;
import com.onelogin.client.model.ConfigurationOidc;
import com.onelogin.client.model.EnforcementPoint;
import com.onelogin.client.model.GenericAppProvisioning;
import com.onelogin.client.model.SsoOidc;
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

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.onelogin.client.JSON;

/**
 * OidcApp
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-03-16T13:09:58.336938-07:00[America/Los_Angeles]")
public class OidcApp {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_VISIBLE = "visible";
  @SerializedName(SERIALIZED_NAME_VISIBLE)
  private Boolean visible;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_NOTES = "notes";
  @SerializedName(SERIALIZED_NAME_NOTES)
  private String notes;

  public static final String SERIALIZED_NAME_ICON_URL = "icon_url";
  @SerializedName(SERIALIZED_NAME_ICON_URL)
  private String iconUrl;

  public static final String SERIALIZED_NAME_AUTH_METHOD = "auth_method";
  @SerializedName(SERIALIZED_NAME_AUTH_METHOD)
  private AuthMethod authMethod;

  public static final String SERIALIZED_NAME_POLICY_ID = "policy_id";
  @SerializedName(SERIALIZED_NAME_POLICY_ID)
  private Integer policyId;

  public static final String SERIALIZED_NAME_ALLOW_ASSUMED_SIGNIN = "allow_assumed_signin";
  @SerializedName(SERIALIZED_NAME_ALLOW_ASSUMED_SIGNIN)
  private Boolean allowAssumedSignin;

  public static final String SERIALIZED_NAME_TAB_ID = "tab_id";
  @SerializedName(SERIALIZED_NAME_TAB_ID)
  private Integer tabId;

  public static final String SERIALIZED_NAME_CONNECTOR_ID = "connector_id";
  @SerializedName(SERIALIZED_NAME_CONNECTOR_ID)
  private Integer connectorId;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private String createdAt;

  public static final String SERIALIZED_NAME_UPDATED_AT = "updated_at";
  @SerializedName(SERIALIZED_NAME_UPDATED_AT)
  private String updatedAt;

  public static final String SERIALIZED_NAME_ROLE_IDS = "role_ids";
  @SerializedName(SERIALIZED_NAME_ROLE_IDS)
  private List<Integer> roleIds = null;

  public static final String SERIALIZED_NAME_PROVISIONING = "provisioning";
  @SerializedName(SERIALIZED_NAME_PROVISIONING)
  private GenericAppProvisioning provisioning;

  public static final String SERIALIZED_NAME_PARAMETERS = "parameters";
  @SerializedName(SERIALIZED_NAME_PARAMETERS)
  private AppParameters parameters;

  public static final String SERIALIZED_NAME_ENFORCEMENT_POINT = "enforcement_point";
  @SerializedName(SERIALIZED_NAME_ENFORCEMENT_POINT)
  private EnforcementPoint enforcementPoint;

  public static final String SERIALIZED_NAME_CONFIGURATION = "configuration";
  @SerializedName(SERIALIZED_NAME_CONFIGURATION)
  private ConfigurationOidc _configuration;

  public static final String SERIALIZED_NAME_SSO = "sso";
  @SerializedName(SERIALIZED_NAME_SSO)
  private SsoOidc sso;

  public OidcApp() {
  }

  
  public OidcApp(
     Integer id
  ) {
    this();
    this.id = id;
  }

   /**
   * Apps unique ID in OneLogin.
   * @return id
  **/
  @javax.annotation.Nullable

  public Integer getId() {
    return id;
  }




  public OidcApp name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the app.
   * @return name
  **/
  @javax.annotation.Nonnull

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public OidcApp visible(Boolean visible) {
    
    this.visible = visible;
    return this;
  }

   /**
   * Indicates if the app is visible in the OneLogin portal.
   * @return visible
  **/
  @javax.annotation.Nonnull

  public Boolean getVisible() {
    return visible;
  }


  public void setVisible(Boolean visible) {
    this.visible = visible;
  }


  public OidcApp description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Freeform description of the app.
   * @return description
  **/
  @javax.annotation.Nonnull

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public OidcApp notes(String notes) {
    
    this.notes = notes;
    return this;
  }

   /**
   * Freeform notes about the app.
   * @return notes
  **/
  @javax.annotation.Nullable

  public String getNotes() {
    return notes;
  }


  public void setNotes(String notes) {
    this.notes = notes;
  }


  public OidcApp iconUrl(String iconUrl) {
    
    this.iconUrl = iconUrl;
    return this;
  }

   /**
   * A link to the apps icon url
   * @return iconUrl
  **/
  @javax.annotation.Nullable

  public String getIconUrl() {
    return iconUrl;
  }


  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }


  public OidcApp authMethod(AuthMethod authMethod) {
    
    this.authMethod = authMethod;
    return this;
  }

   /**
   * Get authMethod
   * @return authMethod
  **/
  @javax.annotation.Nullable

  public AuthMethod getAuthMethod() {
    return authMethod;
  }


  public void setAuthMethod(AuthMethod authMethod) {
    this.authMethod = authMethod;
  }


  public OidcApp policyId(Integer policyId) {
    
    this.policyId = policyId;
    return this;
  }

   /**
   * The security policy assigned to the app.
   * @return policyId
  **/
  @javax.annotation.Nonnull

  public Integer getPolicyId() {
    return policyId;
  }


  public void setPolicyId(Integer policyId) {
    this.policyId = policyId;
  }


  public OidcApp allowAssumedSignin(Boolean allowAssumedSignin) {
    
    this.allowAssumedSignin = allowAssumedSignin;
    return this;
  }

   /**
   * Indicates whether or not administrators can access the app as a user that they have assumed control over.
   * @return allowAssumedSignin
  **/
  @javax.annotation.Nullable

  public Boolean getAllowAssumedSignin() {
    return allowAssumedSignin;
  }


  public void setAllowAssumedSignin(Boolean allowAssumedSignin) {
    this.allowAssumedSignin = allowAssumedSignin;
  }


  public OidcApp tabId(Integer tabId) {
    
    this.tabId = tabId;
    return this;
  }

   /**
   * ID of the OneLogin portal tab that the app is assigned to.
   * @return tabId
  **/
  @javax.annotation.Nullable

  public Integer getTabId() {
    return tabId;
  }


  public void setTabId(Integer tabId) {
    this.tabId = tabId;
  }


  public OidcApp connectorId(Integer connectorId) {
    
    this.connectorId = connectorId;
    return this;
  }

   /**
   * ID of the connector to base the app from.
   * @return connectorId
  **/
  @javax.annotation.Nonnull

  public Integer getConnectorId() {
    return connectorId;
  }


  public void setConnectorId(Integer connectorId) {
    this.connectorId = connectorId;
  }


  public OidcApp createdAt(String createdAt) {
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * the date the app was created
   * @return createdAt
  **/
  @javax.annotation.Nullable

  public String getCreatedAt() {
    return createdAt;
  }


  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }


  public OidcApp updatedAt(String updatedAt) {
    
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * the date the app was last updated
   * @return updatedAt
  **/
  @javax.annotation.Nullable

  public String getUpdatedAt() {
    return updatedAt;
  }


  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }


  public OidcApp roleIds(List<Integer> roleIds) {
    
    this.roleIds = roleIds;
    return this;
  }

  public OidcApp addRoleIdsItem(Integer roleIdsItem) {
    if (this.roleIds == null) {
      this.roleIds = new ArrayList<>();
    }
    this.roleIds.add(roleIdsItem);
    return this;
  }

   /**
   * List of Role IDs that are assigned to the app. On App Create or Update the entire array is replaced with the values provided.
   * @return roleIds
  **/
  @javax.annotation.Nullable

  public List<Integer> getRoleIds() {
    return roleIds;
  }


  public void setRoleIds(List<Integer> roleIds) {
    this.roleIds = roleIds;
  }


  public OidcApp provisioning(GenericAppProvisioning provisioning) {
    
    this.provisioning = provisioning;
    return this;
  }

   /**
   * Get provisioning
   * @return provisioning
  **/
  @javax.annotation.Nullable

  public GenericAppProvisioning getProvisioning() {
    return provisioning;
  }


  public void setProvisioning(GenericAppProvisioning provisioning) {
    this.provisioning = provisioning;
  }


  public OidcApp parameters(AppParameters parameters) {
    
    this.parameters = parameters;
    return this;
  }

   /**
   * Get parameters
   * @return parameters
  **/
  @javax.annotation.Nullable

  public AppParameters getParameters() {
    return parameters;
  }


  public void setParameters(AppParameters parameters) {
    this.parameters = parameters;
  }


  public OidcApp enforcementPoint(EnforcementPoint enforcementPoint) {
    
    this.enforcementPoint = enforcementPoint;
    return this;
  }

   /**
   * Get enforcementPoint
   * @return enforcementPoint
  **/
  @javax.annotation.Nullable

  public EnforcementPoint getEnforcementPoint() {
    return enforcementPoint;
  }


  public void setEnforcementPoint(EnforcementPoint enforcementPoint) {
    this.enforcementPoint = enforcementPoint;
  }


  public OidcApp _configuration(ConfigurationOidc _configuration) {
    
    this._configuration = _configuration;
    return this;
  }

   /**
   * Get _configuration
   * @return _configuration
  **/
  @javax.annotation.Nonnull

  public ConfigurationOidc getConfiguration() {
    return _configuration;
  }


  public void setConfiguration(ConfigurationOidc _configuration) {
    this._configuration = _configuration;
  }


  public OidcApp sso(SsoOidc sso) {
    
    this.sso = sso;
    return this;
  }

   /**
   * Get sso
   * @return sso
  **/
  @javax.annotation.Nullable

  public SsoOidc getSso() {
    return sso;
  }


  public void setSso(SsoOidc sso) {
    this.sso = sso;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OidcApp oidcApp = (OidcApp) o;
    return Objects.equals(this.id, oidcApp.id) &&
        Objects.equals(this.name, oidcApp.name) &&
        Objects.equals(this.visible, oidcApp.visible) &&
        Objects.equals(this.description, oidcApp.description) &&
        Objects.equals(this.notes, oidcApp.notes) &&
        Objects.equals(this.iconUrl, oidcApp.iconUrl) &&
        Objects.equals(this.authMethod, oidcApp.authMethod) &&
        Objects.equals(this.policyId, oidcApp.policyId) &&
        Objects.equals(this.allowAssumedSignin, oidcApp.allowAssumedSignin) &&
        Objects.equals(this.tabId, oidcApp.tabId) &&
        Objects.equals(this.connectorId, oidcApp.connectorId) &&
        Objects.equals(this.createdAt, oidcApp.createdAt) &&
        Objects.equals(this.updatedAt, oidcApp.updatedAt) &&
        Objects.equals(this.roleIds, oidcApp.roleIds) &&
        Objects.equals(this.provisioning, oidcApp.provisioning) &&
        Objects.equals(this.parameters, oidcApp.parameters) &&
        Objects.equals(this.enforcementPoint, oidcApp.enforcementPoint) &&
        Objects.equals(this._configuration, oidcApp._configuration) &&
        Objects.equals(this.sso, oidcApp.sso);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, visible, description, notes, iconUrl, authMethod, policyId, allowAssumedSignin, tabId, connectorId, createdAt, updatedAt, roleIds, provisioning, parameters, enforcementPoint, _configuration, sso);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OidcApp {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    visible: ").append(toIndentedString(visible)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    iconUrl: ").append(toIndentedString(iconUrl)).append("\n");
    sb.append("    authMethod: ").append(toIndentedString(authMethod)).append("\n");
    sb.append("    policyId: ").append(toIndentedString(policyId)).append("\n");
    sb.append("    allowAssumedSignin: ").append(toIndentedString(allowAssumedSignin)).append("\n");
    sb.append("    tabId: ").append(toIndentedString(tabId)).append("\n");
    sb.append("    connectorId: ").append(toIndentedString(connectorId)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    roleIds: ").append(toIndentedString(roleIds)).append("\n");
    sb.append("    provisioning: ").append(toIndentedString(provisioning)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    enforcementPoint: ").append(toIndentedString(enforcementPoint)).append("\n");
    sb.append("    _configuration: ").append(toIndentedString(_configuration)).append("\n");
    sb.append("    sso: ").append(toIndentedString(sso)).append("\n");
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
    openapiFields.add("visible");
    openapiFields.add("description");
    openapiFields.add("notes");
    openapiFields.add("icon_url");
    openapiFields.add("auth_method");
    openapiFields.add("policy_id");
    openapiFields.add("allow_assumed_signin");
    openapiFields.add("tab_id");
    openapiFields.add("connector_id");
    openapiFields.add("created_at");
    openapiFields.add("updated_at");
    openapiFields.add("role_ids");
    openapiFields.add("provisioning");
    openapiFields.add("parameters");
    openapiFields.add("enforcement_point");
    openapiFields.add("configuration");
    openapiFields.add("sso");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("name");
    openapiRequiredFields.add("visible");
    openapiRequiredFields.add("description");
    openapiRequiredFields.add("policy_id");
    openapiRequiredFields.add("connector_id");
    openapiRequiredFields.add("configuration");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to OidcApp
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!OidcApp.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in OidcApp is not found in the empty JSON string", OidcApp.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!OidcApp.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `OidcApp` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : OidcApp.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
      }
      if (!jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("notes") != null && !jsonObj.get("notes").isJsonNull()) && !jsonObj.get("notes").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `notes` to be a primitive type in the JSON string but got `%s`", jsonObj.get("notes").toString()));
      }
      if ((jsonObj.get("icon_url") != null && !jsonObj.get("icon_url").isJsonNull()) && !jsonObj.get("icon_url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `icon_url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("icon_url").toString()));
      }
      if ((jsonObj.get("created_at") != null && !jsonObj.get("created_at").isJsonNull()) && !jsonObj.get("created_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created_at").toString()));
      }
      if ((jsonObj.get("updated_at") != null && !jsonObj.get("updated_at").isJsonNull()) && !jsonObj.get("updated_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `updated_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("updated_at").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("role_ids") != null && !jsonObj.get("role_ids").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `role_ids` to be an array in the JSON string but got `%s`", jsonObj.get("role_ids").toString()));
      }
      // validate the optional field `provisioning`
      if (jsonObj.get("provisioning") != null && !jsonObj.get("provisioning").isJsonNull()) {
        GenericAppProvisioning.validateJsonObject(jsonObj.getAsJsonObject("provisioning"));
      }
      // validate the optional field `enforcement_point`
      if (jsonObj.get("enforcement_point") != null && !jsonObj.get("enforcement_point").isJsonNull()) {
        EnforcementPoint.validateJsonObject(jsonObj.getAsJsonObject("enforcement_point"));
      }
      // validate the required field `configuration`
      ConfigurationOidc.validateJsonObject(jsonObj.getAsJsonObject("configuration"));
      // validate the optional field `sso`
      if (jsonObj.get("sso") != null && !jsonObj.get("sso").isJsonNull()) {
        SsoOidc.validateJsonObject(jsonObj.getAsJsonObject("sso"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!OidcApp.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'OidcApp' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<OidcApp> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(OidcApp.class));

       return (TypeAdapter<T>) new TypeAdapter<OidcApp>() {
           @Override
           public void write(JsonWriter out, OidcApp value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public OidcApp read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of OidcApp given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of OidcApp
  * @throws IOException if the JSON string is invalid with respect to OidcApp
  */
  public static OidcApp fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, OidcApp.class);
  }

 /**
  * Convert an instance of OidcApp to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

