package com.data;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class UserAssetGroupData implements Data<DefaultDataAffinityKey>, UpdatableData<DefaultDataAffinityKey> {

  @QuerySqlField
  private long id;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "user_asset_group_data_idx1", order = 1),
      @QuerySqlField.Group(name = "user_asset_group_data_idx2", order = 2)})
  private long userId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "user_asset_group_data_idx1", order = 2),
      @QuerySqlField.Group(name = "user_asset_group_data_idx2", order = 1)})
  private long assetGroupId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "user_asset_group_data_idx1", order = 0),
      @QuerySqlField.Group(name = "user_asset_group_data_idx2", order = 0)})
  private long subscriptionId;

  private int partitionId;
  private long updatedDate;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getAssetGroupId() {
    return assetGroupId;
  }

  public void setAssetGroupId(long assetGroupId) {
    this.assetGroupId = assetGroupId;
  }

  public long getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(long subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public int getPartitionId() {
    return partitionId;
  }

  public void setPartitionId(int partitionId) {
    this.partitionId = partitionId;
  }

  public long getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(long updatedDate) {
    this.updatedDate = updatedDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserAssetGroupData)) {
      return false;
    }

    UserAssetGroupData that = (UserAssetGroupData) o;

    if (id != that.id) {
      return false;
    }
    if (userId != that.userId) {
      return false;
    }
    if (assetGroupId != that.assetGroupId) {
      return false;
    }
    if (subscriptionId != that.subscriptionId) {
      return false;
    }
    if (partitionId != that.partitionId) {
      return false;
    }
    return updatedDate == that.updatedDate;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (int) (userId ^ (userId >>> 32));
    result = 31 * result + (int) (assetGroupId ^ (assetGroupId >>> 32));
    result = 31 * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
    result = 31 * result + partitionId;
    result = 31 * result + (int) (updatedDate ^ (updatedDate >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "UserAssetGroupData{" + "id=" + id + ", userId=" + userId + ", assetGroupId=" + assetGroupId
        + ", subscriptionId=" + subscriptionId + ", partitionId=" + partitionId + ", updatedDate=" + updatedDate + '}';
  }

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(this.id, this.subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.USER_ASSET_GROUP_CACHE.name();
  }

  /**
   * @return true if the data/entry is newly created. false if it is existing data/entry is updated
   */
  @Override
  public boolean isUpdated() {
    return false;
  }
}
