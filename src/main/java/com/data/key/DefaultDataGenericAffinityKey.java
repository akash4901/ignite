package com.data.key;

import org.apache.ignite.cache.affinity.AffinityKeyMapped;

public class DefaultDataGenericAffinityKey<T> implements DataKey<T> {

  private static final long serialVersionUID = 1295196872907610653L;

  private T id;

  @AffinityKeyMapped
  private long affinityId;

  public DefaultDataGenericAffinityKey(T id, long affinityId) {
    this.id = id;
    this.affinityId = affinityId;
  }

  @Override
  public T getId() {
    return id;
  }

  public long getAffinityId() {
    return affinityId;
  }

  @Override
  public String toString() {
    return "DefaultDataGenericAffinityKey{" + "id=" + id + ", affinityId=" + affinityId + '}';
  }
}
