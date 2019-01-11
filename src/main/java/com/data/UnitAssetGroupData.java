package com.data;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class UnitAssetGroupData implements UpdatableData<DefaultDataAffinityKey> {

  @QuerySqlField
  private long id;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "unit_asset_group_data_idx1", order = 1),
      @QuerySqlField.Group(name = "unit_asset_group_data_idx2", order = 2)})
  private long unitId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "unit_asset_group_data_idx1", order = 2),
      @QuerySqlField.Group(name = "unit_asset_group_data_idx2", order = 1)})
  private long assetGroupId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "unit_asset_group_data_idx1", order = 0),
      @QuerySqlField.Group(name = "unit_asset_group_data_idx2", order = 0)})
  private long subscriptionId;
  private int partitionId;
  private long updatedDate;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUnitId() {
    return unitId;
  }

  public void setUnitId(long unitId) {
    this.unitId = unitId;
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
    if (!(o instanceof UnitAssetGroupData)) {
      return false;
    }

    UnitAssetGroupData that = (UnitAssetGroupData) o;

    if (id != that.id) {
      return false;
    }
    if (unitId != that.unitId) {
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
    result = 31 * result + (int) (unitId ^ (unitId >>> 32));
    result = 31 * result + (int) (assetGroupId ^ (assetGroupId >>> 32));
    result = 31 * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
    result = 31 * result + partitionId;
    result = 31 * result + (int) (updatedDate ^ (updatedDate >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "UnitAssetGroupData{" + "id=" + id + ", unitId=" + unitId + ", assetGroupId=" + assetGroupId
        + ", subscriptionId=" + subscriptionId + ", partitionId=" + partitionId + ", updatedDate=" + updatedDate + '}';
  }

  /**
   * TODO: We could have kept the key as combination of unitId and assetGroupId
   */
  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(this.id, this.subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.UNIT_ASSET_GROUP_CACHE.name();
  }

  /**
   * @return true if the data/entry is newly created. false if it is existing data/entry is updated
   */
  @Override
  public boolean isUpdated() {
    return false;
  }
}
