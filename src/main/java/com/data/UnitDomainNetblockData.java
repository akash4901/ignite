package com.data;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class UnitDomainNetblockData implements UpdatableData<DefaultDataAffinityKey> {

  @QuerySqlField
  private long id;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "unit_domain_ipv4_idx1", order = 1)})
  private long domainId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "unit_domain_ipv4_idx1", order = 2)})
  private int ipStart;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "unit_domain_ipv4_idx1", order = 3)})
  private int ipEnd;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "unit_domain_ipv4_idx1", order = 4)})
  private long subscriptionId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "unit_domain_ipv4_idx1", order = 5)})
  private long unitId;

  private int partitionId;

  private long updatedDate;
  private boolean isUpdatedData = false;

  @Override
  public boolean isUpdated() {
    return isUpdatedData;
  }

  public long getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(long updatedDate) {
    this.updatedDate = updatedDate;
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

  public long getUnitId() {
    return unitId;
  }

  public void setUnitId(long unitId) {
    this.unitId = unitId;
  }

  public boolean isUpdatedData() {
    return isUpdatedData;
  }

  public void setUpdatedData(boolean updatedData) {
    isUpdatedData = updatedData;
  }

  @Override
  public String getCacheName() {
    return CacheName.UNIT_DOMAIN_NETBLOCK_IPV4.name();
  }

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(id, subscriptionId);
  }

}