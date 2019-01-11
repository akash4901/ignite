package com.data;


import com.util.IPv4Util;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class IpV4AssetGroupData implements UpdatableData<DefaultDataAffinityKey> {

  @QuerySqlField
  private long id;

  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "ipv4_asset_group_data_idx2", order = 2)})
  private long assetGroupId;

  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "ipv4_asset_group_data_idx1", order = 1),
      @QuerySqlField.Group(name = "ipv4_asset_group_data_idx2", order = 1)})
  private long subscriptionId;

  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "ipv4_asset_group_data_idx1", order = 2),
      @QuerySqlField.Group(name = "ipv4_asset_group_data_idx2", order = 3)})
  private int ipStart;

  @QuerySqlField(orderedGroups = {
      @QuerySqlField.Group(name = "ipv4_asset_group_data_idx1", order = 3, descending = true),
      @QuerySqlField.Group(name = "ipv4_asset_group_data_idx2", order = 4, descending = true)})
  private int ipEnd;

  private int partitionId;

  private long updatedDate;

  private boolean updated = false;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public int getIpStart() {
    return ipStart;
  }

  public void setIpStart(int ipStart) {
    this.ipStart = ipStart;
  }

  public int getIpEnd() {
    return ipEnd;
  }

  public void setIpEnd(int ipEnd) {
    this.ipEnd = ipEnd;
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
  public String toString() {
    return "IpV4AssetGroupData{" + "id=" + id + ", assetGroupId=" + assetGroupId + ", subscriptionId=" + subscriptionId
        + ", ipStart=" + ipStart + " ( " + IPv4Util.intToIp(ipStart) + " ) " + ", ipEnd=" + ipEnd + " ( " + IPv4Util
        .intToIp(ipEnd) + " ) " + ", partitionId=" + partitionId + '}';
  }

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(this.id, this.subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.IPV4_ASSET_GROUP_DETAIL_CACHE.name();
  }

  /**
   * @return true if the data/entry is newly created. false if it is existing data/entry is updated
   */
  @Override
  public boolean isUpdated() {
    return updated;
  }

  public void setUpdated(boolean updatedData) {
    updated = updatedData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IpV4AssetGroupData)) {
      return false;
    }

    IpV4AssetGroupData that = (IpV4AssetGroupData) o;

    if (id != that.id) {
      return false;
    }
    if (assetGroupId != that.assetGroupId) {
      return false;
    }
    if (subscriptionId != that.subscriptionId) {
      return false;
    }
    if (ipStart != that.ipStart) {
      return false;
    }
    if (ipEnd != that.ipEnd) {
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
    result = 31 * result + (int) (assetGroupId ^ (assetGroupId >>> 32));
    result = 31 * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
    result = 31 * result + (int) (ipStart ^ (ipStart >>> 32));
    result = 31 * result + (int) (ipEnd ^ (ipEnd >>> 32));
    result = 31 * result + partitionId;
    result = 31 * result + (int) (updatedDate ^ (updatedDate >>> 32));
    result = 31 * result + (updated ? 1 : 0);
    return result;
  }
}
