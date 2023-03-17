

# GetEnrolledFactors200ResponseDataOtpDevicesInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**active** | **Boolean** | True &#x3D; enabled (used successfully for authentication at least once). False &#x3D; pending (registered but never used). |  [optional] |
|**_default** | **Boolean** | True &#x3D; is user’s default MFA device for OneLogin. |  [optional] |
|**stateToken** | **String** | A short lived token that is required to Verify the Factor. This token expires in 120 seconds. |  [optional] |
|**authFactorName** | **String** | \&quot;Official\&quot; authentication factor name, as it appears to administrators in OneLogin. |  [optional] |
|**phoneNumber** | **String** | For OTP codes sent via SMS, the phone number receiving the SMS message. |  [optional] |
|**typeDisplayName** | **String** | Authentication factor display name as it appears to users upon initial registration, as defined by admins at Settings &gt; Authentication Factors. |  [optional] |
|**needsTrigger** | **Boolean** | true: You MUST Activate this Factor to trigger an SMS or Push notification before Verifying the OTP code. false: No Activation required. You can Verify the OTP immediately. MFA factors that provide both push notifications (user accepts notification) and pull code submission (user initiates code submission from device or enters it manually) should appear twice; once with needs_trigger: true and once with needs_trigger: false. |  [optional] |
|**userDisplayName** | **String** | Authentication factor display name assigned by users when they enroll the device. |  [optional] |
|**id** | **Integer** | MFA device identifier. |  [optional] |



