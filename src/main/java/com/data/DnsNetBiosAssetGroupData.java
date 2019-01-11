package com.data;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class DnsNetBiosAssetGroupData implements Data<DefaultDataAffinityKey>, UpdatableData<DefaultDataAffinityKey> {

  @QuerySqlField
  private long id;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "dns_nb_asset_group_data_idx1", order = 2),
      @QuerySqlField.Group(name = "dns_nb_asset_group_data_idx2", order = 1)})
  private long assetGroupId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "dns_nb_asset_group_data_idx1", order = 3),
      @QuerySqlField.Group(name = "dns_nb_asset_group_data_idx2", order = 2)})
  private int assetTypeInd;
  private int partitionId;
  @QuerySqlField
  private long subscriptionId;
  @QuerySqlField
  private long updatedDate;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "dns_nb_asset_group_data_idx1", order = 1),
      @QuerySqlField.Group(name = "dns_nb_asset_group_data_idx2", order = 3)})
  private String value;

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

  public int getAssetTypeInd() {
    return assetTypeInd;
  }

  public void setAssetTypeInd(int assetTypeInd) {
    this.assetTypeInd = assetTypeInd;
  }


  public int getPartitionId() {
    return partitionId;
  }

  public void setPartitionId(int partitionId) {
    this.partitionId = partitionId;
  }

  public long getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(long subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public long getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(long updatedDate) {
    this.updatedDate = updatedDate;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DnsNetBiosAssetGroupData)) {
      return false;
    }

    DnsNetBiosAssetGroupData that = (DnsNetBiosAssetGroupData) o;

    if (id != that.id) {
      return false;
    }
    if (assetGroupId != that.assetGroupId) {
      return false;
    }
    if (assetTypeInd != that.assetTypeInd) {
      return false;
    }
    if (partitionId != that.partitionId) {
      return false;
    }
    if (subscriptionId != that.subscriptionId) {
      return false;
    }
    if (updatedDate != that.updatedDate) {
      return false;
    }
    return value != null ? value.equals(that.value) : that.value == null;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (int) (assetGroupId ^ (assetGroupId >>> 32));
    result = 31 * result + assetTypeInd;
    result = 31 * result + partitionId;
    result = 31 * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
    result = 31 * result + (int) (updatedDate ^ (updatedDate >>> 32));
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "DnsNetBiosAssetGroupData{" + "id=" + id + ", assetGroupId=" + assetGroupId + ", assetTypeInd="
        + assetTypeInd + ", partitionId=" + partitionId + ", subscriptionId=" + subscriptionId + ", updatedDate="
        + updatedDate + ", value='" + value + '\'' + '}';
  }

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(this.id, this.subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.DNS_NB_ASSET_GROUP_DETAIL_CACHE.name();
  }

  /**
   * @return true if the data/entry is newly created. false if it is existing data/entry is updated
   */
  @Override
  public boolean isUpdated() {
    return false;
  }
}
