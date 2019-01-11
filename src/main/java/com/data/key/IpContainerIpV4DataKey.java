package com.data.key;

import org.apache.ignite.cache.affinity.AffinityKeyMapped;

public class IpContainerIpV4DataKey implements DataKey<Long> {

  private long id;

  private long ipContainerId;

  @AffinityKeyMapped
  private long subscriptionId;

  public IpContainerIpV4DataKey(long id, long ipContainerId, long subscriptionId) {
    this.id = id;
    this.ipContainerId = ipContainerId;
    this.subscriptionId = subscriptionId;
  }

  @Override
  public Long getId() {
    return id;
  }

  public long getIpContainerId() {
    return ipContainerId;
  }

  public long getSubscriptionId() {
    return subscriptionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IpContainerIpV4DataKey)) {
      return false;
    }

    IpContainerIpV4DataKey that = (IpContainerIpV4DataKey) o;

    if (getId() != that.getId()) {
      return false;
    }
    if (getIpContainerId() != that.getIpContainerId()) {
      return false;
    }
    return getSubscriptionId() == that.getSubscriptionId();
  }

  @Override
  public int hashCode() {
    int result = (int) (getId() ^ (getId() >>> 32));
    result = 31 * result + (int) (getIpContainerId() ^ (getIpContainerId() >>> 32));
    result = 31 * result + (int) (getSubscriptionId() ^ (getSubscriptionId() >>> 32));
    return result;
  }
}
