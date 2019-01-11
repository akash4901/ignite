package com.data;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class DomainData implements UpdatableData<DefaultDataAffinityKey> {

  @QuerySqlField
  private long id;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_idx1", order = 1)})
  private String value;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_idx1", order = 2)})
  private long networkId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_idx1", order = 3)})
  private long subscriptionId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_idx1", order = 4)})
  private int partitionId;
  @QuerySqlField
  private long createdDate;
  @QuerySqlField
  private long updatedDate;

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(id, subscriptionId);
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

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public long getNetworkId() {
    return networkId;
  }

  public void setNetworkId(long networkId) {
    this.networkId = networkId;
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

  public long getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(long createdDate) {
    this.createdDate = createdDate;
  }

  public long getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(long updatedDate) {
    this.updatedDate = updatedDate;
  }

  @Override
  public boolean isUpdated() {
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    DomainData that = (DomainData) o;

    if (id != that.id) {
      return false;
    }
    if (networkId != that.networkId) {
      return false;
    }
    if (subscriptionId != that.subscriptionId) {
      return false;
    }
    if (partitionId != that.partitionId) {
      return false;
    }
    if (createdDate != that.createdDate) {
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
    result = 31 * result + (value != null ? value.hashCode() : 0);
    result = 31 * result + (int) (networkId ^ (networkId >>> 32));
    result = 31 * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
    result = 31 * result + partitionId;
    result = 31 * result + (int) (createdDate ^ (createdDate >>> 32));
    result = 31 * result + (int) (updatedDate ^ (updatedDate >>> 32));
    return result;
  }
}
