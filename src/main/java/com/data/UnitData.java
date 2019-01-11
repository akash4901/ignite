package com.data;

public class UnitData implements Data<DefaultDataAffinityKey> {

  private Long unitId;
  private Long subscriptionId;
  private String name;

  public Long getUnitId() {
    return unitId;
  }

  public void setUnitId(Long unitId) {
    this.unitId = unitId;
  }

  public Long getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(Long subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(this.unitId, this.subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.UNIT_CACHE.name();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UnitData unitData = (UnitData) o;

    if (unitId != null ? !unitId.equals(unitData.unitId) : unitData.unitId != null) {
      return false;
    }
    if (subscriptionId != null ? !subscriptionId.equals(unitData.subscriptionId) : unitData.subscriptionId != null) {
      return false;
    }
    return name != null ? name.equals(unitData.name) : unitData.name == null;

  }

  @Override
  public int hashCode() {
    int result = unitId != null ? unitId.hashCode() : 0;
    result = 31 * result + (subscriptionId != null ? subscriptionId.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
