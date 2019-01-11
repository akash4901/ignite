package com.data;


import com.data.key.UserPermissionDataKey;

public class UserPermissionsData implements Data<UserPermissionDataKey> {

  private long gid;
  private long userId;
  private long subscriptionId;
  private String permissionKey;
  private String value;
  private String oldValue;

  @Override
  public UserPermissionDataKey getKey() {
    return new UserPermissionDataKey(userId, permissionKey, subscriptionId);
  }

  public long getGid() {
    return gid;
  }

  public void setGid(long gid) {
    this.gid = gid;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(long subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public String getPermissionKey() {
    return permissionKey;
  }

  public void setPermissionKey(String permissionKey) {
    this.permissionKey = permissionKey;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getOldValue() {
    return oldValue;
  }

  public void setOldValue(String oldValue) {
    this.oldValue = oldValue;
  }

  @Override
  public String getCacheName() {
    return CacheName.USER_PERMISSION_CACHE.name();
  }
}
