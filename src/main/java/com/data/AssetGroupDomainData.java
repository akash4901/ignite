package com.data;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class AssetGroupDomainData implements UpdatableData<DefaultDataAffinityKey> {

  @QuerySqlField
  private long id;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "asset_group_domain_idx1", order = 1)})
  private long domainId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "asset_group_domain_idx1", order = 2)})
  private long assetGroupId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "asset_group_domain_idx1", order = 3)})
  private long subscriptionId;
  @QuerySqlField
  private long createdDate;
  private int partitionId;



  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(id,subscriptionId);
  }

  @Override
  public String getCacheName() {
    return null;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getDomainId() {
    return domainId;
  }

  public void setDomainId(long domainId) {
    this.domainId = domainId;
  }

  public long getAssetGroupId() {
    return assetGroupId;
  }

  public void setAssetGroupId(long assetGroupId) {
    this.assetGroupId = assetGroupId;
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

  @Override
  public boolean isUpdated() {
    return false;
  }

  public long getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(long createdDate) {
    this.createdDate = createdDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    AssetGroupDomainData that = (AssetGroupDomainData) o;

    if (id != that.id) {
      return false;
    }
    if (domainId != that.domainId) {
      return false;
    }
    if (assetGroupId != that.assetGroupId) {
      return false;
    }
    if (subscriptionId != that.subscriptionId) {
      return false;
    }
    return partitionId == that.partitionId;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (int) (domainId ^ (domainId >>> 32));
    result = 31 * result + (int) (assetGroupId ^ (assetGroupId >>> 32));
    result = 31 * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
    result = 31 * result + partitionId;
    return result;
  }
}
