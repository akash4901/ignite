package com.data;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class IpContainerIpV4Data implements Data<DefaultDataAffinityKey>, UpdatableData<DefaultDataAffinityKey> {

  @QuerySqlField
  private long id;

  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "ip_container_ipv4_idx1", order = 2)})
  private int moduleId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "ip_container_ipv4_idx1", order = 1),
      @QuerySqlField.Group(name = "ip_container_ipv4_idx2", order = 0)})
  private long subscriptionId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "ip_container_ipv4_idx1", order = 4, descending = true),
      @QuerySqlField.Group(name = "ip_container_ipv4_idx2", order = 2, descending = true)})
  private int ipEnd;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "ip_container_ipv4_idx1", order = 3),
      @QuerySqlField.Group(name = "ip_container_ipv4_idx2", order = 1)})
  private int ipStart;
  @QuerySqlField
  private int partitionId;
  @QuerySqlField
  private long updatedDate;

  private boolean updated = false;

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

  public int getModuleId() {
    return moduleId;
  }

  public void setModuleId(int moduleId) {
    this.moduleId = moduleId;
  }

  public int getIpEnd() {
    return ipEnd;
  }

  public void setIpEnd(int ipEnd) {
    this.ipEnd = ipEnd;
  }

  public int getIpStart() {
    return ipStart;
  }

  public void setIpStart(int ipStart) {
    this.ipStart = ipStart;
  }

  public int getPartitionId() {
    return partitionId;
  }

  public void setPartitionId(int partitionId) {
    this.partitionId = partitionId;
  }

  public long getUpdatedOn() {
    return updatedDate;
  }

  public void setUpdatedOn(long updatedOn) {
    this.updatedDate = updatedOn;
  }

  @Override
  public boolean isUpdated() {
    return updated;
  }

  public void setUpdated(boolean updated) {
    this.updated = updated;
  }

//  @Override
//  public String toString() {
//    return "IpContainerIpV4Data{" + "id=" + id + ", moduleId=" + moduleId + ", subscriptionId=" + subscriptionId
//        + ", ipStart=" + IPv4Util.intToIp(ipStart) + ", ipEnd=" + IPv4Util.intToIp(ipEnd) + ", partitionId="
//        + partitionId + ", updatedDate=" + updatedDate + '}';
//  }

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(id, subscriptionId);
  }


  @Override
  public String getCacheName() {
    return CacheName.IP_CONTAINER_IPV4_CACHE.name();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IpContainerIpV4Data)) {
      return false;
    }

    IpContainerIpV4Data that = (IpContainerIpV4Data) o;

    if (id != that.id) {
      return false;
    }
    if (moduleId != that.moduleId) {
      return false;
    }
    if (subscriptionId != that.subscriptionId) {
      return false;
    }
    if (ipEnd != that.ipEnd) {
      return false;
    }
    if (ipStart != that.ipStart) {
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
    result = 31 * result + moduleId;
    result = 31 * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
    result = 31 * result + (int) (ipEnd ^ (ipEnd >>> 32));
    result = 31 * result + (int) (ipStart ^ (ipStart >>> 32));
    result = 31 * result + partitionId;
    result = 31 * result + (int) (updatedDate ^ (updatedDate >>> 32));
    result = 31 * result + (updated ? 1 : 0);
    return result;
  }
}
