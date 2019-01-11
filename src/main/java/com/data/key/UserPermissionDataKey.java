package com.data.key;

import org.apache.ignite.cache.affinity.AffinityKeyMapped;

public class UserPermissionDataKey implements DataKey<String> {

  private long userId;
  private String permissionKey;

  @AffinityKeyMapped
  private long subscriptionId;

  public UserPermissionDataKey(long userId, String permissionKey, long subscriptionId) {
    this.userId = userId;
    this.permissionKey = permissionKey;
    this.subscriptionId = subscriptionId;
  }

  @Override
  public String getId() {
    return userId + permissionKey;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserPermissionDataKey that = (UserPermissionDataKey) o;

    if (userId != that.userId) {
      return false;
    }
    return permissionKey.equals(that.permissionKey);
  }

  @Override
  public int hashCode() {
    int result = (int) (userId ^ (userId >>> 32));
    result = 31 * result + permissionKey.hashCode();
    return result;
  }
}
