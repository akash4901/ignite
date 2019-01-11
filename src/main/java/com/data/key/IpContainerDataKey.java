package com.data.key;

import org.apache.ignite.cache.affinity.AffinityKeyMapped;

public class IpContainerDataKey implements DataKey<Long> {

  private long id;

  @AffinityKeyMapped
  private long subscriptionId;


  public IpContainerDataKey(long id, long subscriptionId) {
    this.id = id;
    this.subscriptionId = subscriptionId;
  }

  public Long getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    IpContainerDataKey that = (IpContainerDataKey) o;

    return id == that.id;
  }

  @Override
  public int hashCode() {
    return (int) (id ^ (id >>> 32));
  }
}
