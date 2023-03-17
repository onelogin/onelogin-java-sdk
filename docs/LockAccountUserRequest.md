

# LockAccountUserRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**lockedUntil** | **Integer** | Set to the number of minutes for which you want to lock the user account. Set to 0 if you want to lock the user account based on the Lock effective period set in the policy assigned to the user. If no policy is assigned to the user, setting this value to 0 will lock the user’s account until you unlock it Note that this value can not be less time that the Lock Effective Period specified on a user policy. |  |



