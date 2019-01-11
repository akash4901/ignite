package com.data;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class DomainIpv4ApprovedIpsData implements UpdatableData<DefaultDataAffinityKey> {


  @QuerySqlField
  private long id;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_ipv4_idx1", order = 1)})
  private long domainId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_ipv4_idx1", order = 2)})
  private int ipStart;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_ipv4_idx1", order = 3)})
  private int ipEnd;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_ipv4_idx1", order = 4)})
  private long subscriptionId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_ipv4_idx1", order = 5)})
  private long userId;
  private long updatedDate;
  private int partitionId;
  private boolean isUpdatedData = false;

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

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
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

  public long getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(long updatedDate) {
    this.updatedDate = updatedDate;
  }

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(id, subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.DOMAIN_IPV4_APPROVED_IPS_CACHE.name();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    DomainIpv4ApprovedIpsData that = (DomainIpv4ApprovedIpsData) o;

    if (id != that.id) {
      return false;
    }
    if (domainId != that.domainId) {
      return false;
    }
    if (ipStart != that.ipStart) {
      return false;
    }
    if (ipEnd != that.ipEnd) {
      return false;
    }
    if (subscriptionId != that.subscriptionId) {
      return false;
    }
    if (userId != that.userId) {
      return false;
    }
    if (updatedDate != that.updatedDate) {
      return false;
    }
    return partitionId == that.partitionId;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (int) (domainId ^ (domainId >>> 32));
    result = 31 * result + (int) (ipStart ^ (ipStart >>> 32));
    result = 31 * result + (int) (ipEnd ^ (ipEnd >>> 32));
    result = 31 * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
    result = 31 * result + (int) (userId ^ (userId >>> 32));
    result = 31 * result + (int) (updatedDate ^ (updatedDate >>> 32));
    result = 31 * result + partitionId;
    return result;
  }

  @Override
  public boolean isUpdated() {
    return isUpdatedData;
  }

//  @Override
//  public String toString() {
//    return "DomainIpv4ApprovedIpsData{" + "id=" + id + ", domainId=" + domainId + ", ipStart=" + IPv4Util.intToIp(ipStart)  + ", ipEnd="
//        + IPv4Util.intToIp(ipEnd)  + ", subscriptionId=" + subscriptionId + ", userId=" + userId + ", updatedDate=" + updatedDate
//        + ", partitionId=" + partitionId + '}';
//  }
}
