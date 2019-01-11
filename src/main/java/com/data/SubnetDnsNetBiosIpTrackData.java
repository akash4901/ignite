package com.data;


import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class SubnetDnsNetBiosIpTrackData implements UpdatableData<DefaultDataAffinityKey> {

  @QuerySqlField
  private long id;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "subnet_dns_nb_ip_track_idx1", order = 1)})
  private long subscriptionId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "subnet_dns_nb_ip_track_idx1", order = 2)})
  private int ipStart;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "subnet_dns_nb_ip_track_idx1", order = 3)})
  private int ipEnd;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "subnet_dns_nb_ip_track_idx1", order = 4)})
  private int trackingType;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "subnet_dns_nb_ip_track_idx1", order = 5)})
  private int partitionId;
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

  public long getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(long updatedDate) {
    this.updatedDate = updatedDate;
  }

  public int getTrackingType() {
    return trackingType;
  }

  public void setTrackingType(int trackingType) {
    this.trackingType = trackingType;
  }

  @Override
  public boolean isUpdated() {
    return updated;
  }

  public void setUpdated(boolean updated) {
    this.updated = updated;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SubnetDnsNetBiosIpTrackData)) {
      return false;
    }

    SubnetDnsNetBiosIpTrackData that = (SubnetDnsNetBiosIpTrackData) o;

    if (id != that.id) {
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
    if (trackingType != that.trackingType) {
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
    result = 31 * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
    result = 31 * result + (int) (ipStart ^ (ipStart >>> 32));
    result = 31 * result + (int) (ipEnd ^ (ipEnd >>> 32));
    result = 31 * result + trackingType;
    result = 31 * result + partitionId;
    result = 31 * result + (int) (updatedDate ^ (updatedDate >>> 32));
    return result;
  }

//  @Override
//  public String toString() {
//    return "SubnetDnsNetBiosIpTrackData{" + "id=" + id + ", subscriptionId=" + subscriptionId + ",ipStart=" + IPv4Util.intToIp(ipStart)
//        + ",   ipEnd= " + IPv4Util.intToIp(ipEnd)  + ", trackingType=" + trackingType + ", partitionId=" + partitionId + ", updatedDate="
//        + updatedDate + ", isUpdated=" + updated + '}';
//
//
//  }

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(this.id, this.subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.SUB_DNS_NB_TRACK_IP_CACHE.name();
  }
}
