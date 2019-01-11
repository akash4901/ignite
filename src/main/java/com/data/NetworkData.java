package com.data;

import java.util.Objects;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class NetworkData implements Data<DefaultDataAffinityKey>{

  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "network_idx1", order = 1)})
  private long networkId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "network_idx1", order = 2)})
  private long subscriptionId;

  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "network_idx1", order = 3)})
  private String name;

  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "network_idx1", order = 4)})
  private String status;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(networkId,subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.NETWORK_CACHE.name();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NetworkData)) {
      return false;
    }
    NetworkData that = (NetworkData) o;
    return getNetworkId() == that.getNetworkId() && getSubscriptionId() == that.getSubscriptionId() && Objects
        .equals(getName(), that.getName()) && Objects.equals(getStatus(), that.getStatus());
  }

}
