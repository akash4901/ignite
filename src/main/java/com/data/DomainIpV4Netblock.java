package com.data;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class DomainIpV4Netblock implements UpdatableData<DefaultDataAffinityKey> {

  @QuerySqlField
  private long id;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_ipv4_idx1", order = 2)})
  private long domainId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_ipv4_idx1", order = 3)})
  private int ipStart;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_ipv4_idx1", order = 4)})
  private int ipEnd;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_ipv4_idx1", order = 1)})
  private long subscriptionId;
  private int partitionId;
  private boolean isUpdatedData = false;

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(id, subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.DOMAIN_IPV4_NETBLOCK_CACHE.name();
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    DomainIpV4Netblock netblock = (DomainIpV4Netblock) o;

    if (domainId != netblock.domainId) {
      return false;
    }
    if (ipStart != netblock.ipStart) {
      return false;
    }
    if (ipEnd != netblock.ipEnd) {
      return false;
    }
    return subscriptionId == netblock.subscriptionId;
  }

  @Override
  public int hashCode() {
    int result = (int) (domainId ^ (domainId >>> 32));
    result = 31 * result + (int) (ipStart ^ (ipStart >>> 32));
    result = 31 * result + (int) (ipEnd ^ (ipEnd >>> 32));
    result = 31 * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
    return result;
  }

//  @Override
//  public String toString() {
//    return "DomainIpV4Netblock{" + "id=" + id + ", domainId=" + domainId + ", ipStart=" + IPv4Util.intToIp(ipStart)
//        + ", ipEnd=" + IPv4Util.intToIp(ipEnd) + ", subscriptionId=" + subscriptionId + '}';
//  }

  @Override
  public boolean isUpdated() {
    return isUpdatedData;
  }
}
