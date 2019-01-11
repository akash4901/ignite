package com.data;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class DomainCommentsData implements UpdatableData<DefaultDataAffinityKey> {

  @QuerySqlField
  private long id;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_ipv4_idx1", order = 1)})
  private long domainId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_ipv4_idx1", order = 2)})
  private String comments;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_ipv4_idx1", order = 3)})
  private long subscriptionId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "domain_ipv4_idx1", order = 4)})
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

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
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

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(this.id, this.subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.DOMAIN_COMMENTS.name();
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    DomainCommentsData that = (DomainCommentsData) o;

    if (id != that.id) {
      return false;
    }
    if (domainId != that.domainId) {
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
    if (partitionId != that.partitionId) {
      return false;
    }
    return comments != null ? comments.equals(that.comments) : that.comments == null;
  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (int) (domainId ^ (domainId >>> 32));
    result = 31 * result + (comments != null ? comments.hashCode() : 0);
    result = 31 * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
    result = 31 * result + (int) (userId ^ (userId >>> 32));
    result = 31 * result + (int) (updatedDate ^ (updatedDate >>> 32));
    result = 31 * result + partitionId;
    return result;
  }
}
