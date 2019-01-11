package com.data;


import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class UserDomainNetblockData implements UpdatableData<DefaultDataAffinityKey> {

  @QuerySqlField
  private long id;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "user_domain_ipv4_idx1", order = 1)})
  private long domainId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "user_domain_ipv4_idx1", order = 2)})
  private int ipStart;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "user_domain_ipv4_idx1", order = 3)})
  private int ipEnd;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "user_domain_ipv4_idx1", order = 4)})
  private long subscriptionId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "user_domain_ipv4_idx1", order = 5)})
  private long userId;
  private long updatedDate;
  private boolean isUpdatedData = false;
  private int partitionId;

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

  @Override
  public String getCacheName() {
    return CacheName.USER_DOMAIN_NETBLOCK_IPV4.name();
  }

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(id, subscriptionId);
  }

  public long getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(long updatedDate) {
    this.updatedDate = updatedDate;
  }

  public boolean isUpdatedData() {
    return isUpdatedData;
  }

  public void setUpdatedData(boolean updatedData) {
    isUpdatedData = updatedData;
  }

//  @Override
//  public String toString() {
//    return "UserDomainNetblockData{" + "id=" + id + ", domainId=" + domainId + ", ipStart=" + IPv4Util.intToIp(ipStart)
//        + ", ipEnd=" + IPv4Util.intToIp(ipEnd) + ", subscriptionId=" + subscriptionId + ", userId=" + userId + '}';
//  }

  /**
   * @return true if the data/entry is newly created. false if it is existing data/entry is updated
   */
  @Override
  public boolean isUpdated() {
    return isUpdatedData;
  }
}
