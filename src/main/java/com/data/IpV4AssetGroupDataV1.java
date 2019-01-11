package com.data;

import java.util.List;

public class IpV4AssetGroupDataV1 implements UpdatableData<DefaultDataAffinityKey> {


  private long id;

  private long subscriptionId;

  List<IpV4Range> ipV4Ranges;

  private int partitionId;


  @Override
  public boolean isUpdated() {
    return false;
  }

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(id,subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.IPV4_ASSET_GROUP_DETAIL_CACHE.name();
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(long subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public List<IpV4Range> getIpV4Ranges() {
    return ipV4Ranges;
  }

  public void setIpV4Ranges(List<IpV4Range> ipV4Ranges) {
    this.ipV4Ranges = ipV4Ranges;
  }

  public int getPartitionId() {
    return partitionId;
  }

  public void setPartitionId(int partitionId) {
    this.partitionId = partitionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    IpV4AssetGroupDataV1 that = (IpV4AssetGroupDataV1) o;

    if (id != that.id) {
      return false;
    }
    if (subscriptionId != that.subscriptionId) {
      return false;
    }
    return ipV4Ranges.equals(that.ipV4Ranges);
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
    result = 31 * result + ipV4Ranges.hashCode();
    return result;
  }
}
