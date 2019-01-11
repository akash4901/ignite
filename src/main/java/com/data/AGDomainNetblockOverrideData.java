package com.data;


import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class AGDomainNetblockOverrideData implements UpdatableData<DefaultDataAffinityKey> {

  @QuerySqlField
  private long id;

  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "ag_domain_nb_override_data", order = 1)})
  private long assetGroupDomainId;

  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "ag_domain_nb_override_data", order = 2)})
  private int startIp;

  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "ag_domain_nb_override_data", order = 3)})
  private int endIp;

  private long subscriptionId;

  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "ag_domain_nb_override_data", order = 4)})
  private int partitionId;

  private boolean isUpdatedData = false;

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(id, subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.ASSET_GROUP_DOMAIN_NETBLOCK_OVERRIDE_CACHE.name();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getAssetGroupDomainId() {
    return assetGroupDomainId;
  }

  public void setAssetGroupDomainId(long assetGroupDomainId) {
    this.assetGroupDomainId = assetGroupDomainId;
  }

  public int getStartIp() {
    return startIp;
  }

  public void setStartIp(int startIp) {
    this.startIp = startIp;
  }

  public int getEndIp() {
    return endIp;
  }

  public void setEndIp(int endIp) {
    this.endIp = endIp;
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

  public boolean isUpdatedData() {
    return isUpdatedData;
  }

  public void setUpdatedData(boolean updatedData) {
    isUpdatedData = updatedData;
  }

//  @Override
//  public String toString() {
//    return "AGDomainNetblockOverrideData{" + "id=" + id + ", assetGroupDomainId=" + assetGroupDomainId + ", startIp="
//        + IPv4Util.intToIp(startIp) + ", endIp=" + IPv4Util.intToIp(endIp) + ", subscriptionId=" + subscriptionId
//        + ", isUpdated=" + isUpdatedData + '}';
//  }


//  @Override
//  public String toString() {
//    return "AGDomainNetblockOverrideData{" + "id=" + id + ", assetGroupDomainId=" + assetGroupDomainId + ", startIp="
//        +  IPv4Util.intToIp(startIp) + ", endIp=" + IPv4Util.intToIp(endIp) + ", subscriptionId=" + subscriptionId + ", partitionId=" + partitionId
//        + ", isUpdatedData=" + isUpdatedData + '}';
//  }

  @Override
  public boolean isUpdated() {
    return isUpdatedData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    AGDomainNetblockOverrideData that = (AGDomainNetblockOverrideData) o;

    if (id != that.id) {
      return false;
    }
    if (assetGroupDomainId != that.assetGroupDomainId) {
      return false;
    }
    if (startIp != that.startIp) {
      return false;
    }
    if (endIp != that.endIp) {
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
    result = 31 * result + (int) (assetGroupDomainId ^ (assetGroupDomainId >>> 32));
    result = 31 * result + (int) (startIp ^ (startIp >>> 32));
    result = 31 * result + (int) (endIp ^ (endIp >>> 32));
    result = 31 * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
    result = 31 * result + partitionId;
    return result;
  }
}
