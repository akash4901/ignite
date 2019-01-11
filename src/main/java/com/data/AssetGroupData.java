package com.data;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class AssetGroupData implements UpdatableData<DefaultDataAffinityKey> {


  boolean updated;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "asset_group_idx1", order = 0)})
  private long assetGroupId;
  @QuerySqlField
  private String businessDivision;
  @QuerySqlField
  private String businessFunction;
  @QuerySqlField
  private long businessImpact;
  @QuerySqlField
  private String businessLocation;
  @QuerySqlField
  private String comments;
  @QuerySqlField
  private float cvssDamagePotential = -1;
  @QuerySqlField
  private float cvssEnvAr = -1;
  @QuerySqlField
  private float cvssEnvCr = -1;
  @QuerySqlField
  private float cvssEnvIr = -1;
  @QuerySqlField
  private float cvssTargetDistribution = -1;
  @QuerySqlField
  private long defaultScannerAppliance;
  @QuerySqlField
  private String name;
  @QuerySqlField
  private long networkId;
  private int partitionId;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "asset_group_idx3", order = 0)})
  private long subscriptionId;
  @QuerySqlField
  private long unitId;
  @QuerySqlField
  private long createdDate;
  @QuerySqlField
  private long updatedDate;
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "asset_group_idx2", order = 0)})
  private long userId;

  @QuerySqlField
  private long modifiedBy;

  public long getAssetGroupId() {
    return assetGroupId;
  }

  public void setAssetGroupId(long assetGroupId) {
    this.assetGroupId = assetGroupId;
  }

  public String getBusinessDivision() {
    return businessDivision;
  }

  public void setBusinessDivision(String businessDivision) {
    this.businessDivision = businessDivision;
  }

  public String getBusinessFunction() {
    return businessFunction;
  }

  public void setBusinessFunction(String businessFunction) {
    this.businessFunction = businessFunction;
  }

  public long getBusinessImpact() {
    return businessImpact;
  }

  public void setBusinessImpact(long businessImpact) {
    this.businessImpact = businessImpact;
  }

  public String getBusinessLocation() {
    return businessLocation;
  }

  public void setBusinessLocation(String businessLocation) {
    this.businessLocation = businessLocation;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public float getCvssDamagePotential() {
    return cvssDamagePotential;
  }

  public void setCvssDamagePotential(float cvssDamagePotential) {
    this.cvssDamagePotential = cvssDamagePotential;
  }

  public float getCvssEnvAr() {
    return cvssEnvAr;
  }

  public void setCvssEnvAr(float cvssEnvAr) {
    this.cvssEnvAr = cvssEnvAr;
  }

  public float getCvssEnvCr() {
    return cvssEnvCr;
  }

  public void setCvssEnvCr(float cvssEnvCr) {
    this.cvssEnvCr = cvssEnvCr;
  }

  public float getCvssEnvIr() {
    return cvssEnvIr;
  }

  public void setCvssEnvIr(float cvssEnvIr) {
    this.cvssEnvIr = cvssEnvIr;
  }

  public float getCvssTargetDistribution() {
    return cvssTargetDistribution;
  }

  public void setCvssTargetDistribution(float cvssTargetDistribution) {
    this.cvssTargetDistribution = cvssTargetDistribution;
  }

  public long getDefaultScannerAppliance() {
    return defaultScannerAppliance;
  }

  public void setDefaultScannerAppliance(long defaultScannerAppliance) {
    this.defaultScannerAppliance = defaultScannerAppliance;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getNetworkId() {
    return networkId;
  }

  public void setNetworkId(long networkId) {
    this.networkId = networkId;
  }

  public int getPartitionId() {
    return partitionId;
  }

  public void setPartitionId(int partitionId) {
    this.partitionId = partitionId;
  }

  public long getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(long subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public long getUnitId() {
    return unitId;
  }

  public void setUnitId(long unitId) {
    this.unitId = unitId;
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

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(this.assetGroupId, this.subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.ASSET_GROUP_CACHE.name();
  }

  /**
   * @return true if the data/entry is newly created. false if it is existing data/entry is updated
   */
  @Override
  public boolean isUpdated() {
    return updated;
  }

  public void setUpdated(boolean updated) {
    this.updated = updated;
  }

  public long getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(long modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AssetGroupData)) {
      return false;
    }

    AssetGroupData that = (AssetGroupData) o;

    if (updated != that.updated) {
      return false;
    }
    if (assetGroupId != that.assetGroupId) {
      return false;
    }
    if (businessImpact != that.businessImpact) {
      return false;
    }
    if (Float.compare(that.cvssDamagePotential, cvssDamagePotential) != 0) {
      return false;
    }
    if (Float.compare(that.cvssEnvAr, cvssEnvAr) != 0) {
      return false;
    }
    if (Float.compare(that.cvssEnvCr, cvssEnvCr) != 0) {
      return false;
    }
    if (Float.compare(that.cvssEnvIr, cvssEnvIr) != 0) {
      return false;
    }
    if (Float.compare(that.cvssTargetDistribution, cvssTargetDistribution) != 0) {
      return false;
    }
    if (defaultScannerAppliance != that.defaultScannerAppliance) {
      return false;
    }
    if (networkId != that.networkId) {
      return false;
    }
    if (partitionId != that.partitionId) {
      return false;
    }
    if (subscriptionId != that.subscriptionId) {
      return false;
    }
    if (unitId != that.unitId) {
      return false;
    }
    if (createdDate != that.createdDate) {
      return false;
    }
    if (updatedDate != that.updatedDate) {
      return false;
    }
    if (userId != that.userId) {
      return false;
    }
    if (modifiedBy != that.modifiedBy) {
      return false;
    }
    if (businessDivision != null ? !businessDivision.equals(that.businessDivision) : that.businessDivision != null) {
      return false;
    }
    if (businessFunction != null ? !businessFunction.equals(that.businessFunction) : that.businessFunction != null) {
      return false;
    }
    if (businessLocation != null ? !businessLocation.equals(that.businessLocation) : that.businessLocation != null) {
      return false;
    }
    if (comments != null ? !comments.equals(that.comments) : that.comments != null) {
      return false;
    }
    return name != null ? name.equals(that.name) : that.name == null;
  }

  @Override
  public int hashCode() {
    int result = (updated ? 1 : 0);
    result = 31 * result + (int) (assetGroupId ^ (assetGroupId >>> 32));
    result = 31 * result + (businessDivision != null ? businessDivision.hashCode() : 0);
    result = 31 * result + (businessFunction != null ? businessFunction.hashCode() : 0);
    result = 31 * result + (int) (businessImpact ^ (businessImpact >>> 32));
    result = 31 * result + (businessLocation != null ? businessLocation.hashCode() : 0);
    result = 31 * result + (comments != null ? comments.hashCode() : 0);
    result = 31 * result + (cvssDamagePotential != +0.0f ? Float.floatToIntBits(cvssDamagePotential) : 0);
    result = 31 * result + (cvssEnvAr != +0.0f ? Float.floatToIntBits(cvssEnvAr) : 0);
    result = 31 * result + (cvssEnvCr != +0.0f ? Float.floatToIntBits(cvssEnvCr) : 0);
    result = 31 * result + (cvssEnvIr != +0.0f ? Float.floatToIntBits(cvssEnvIr) : 0);
    result = 31 * result + (cvssTargetDistribution != +0.0f ? Float.floatToIntBits(cvssTargetDistribution) : 0);
    result = 31 * result + (int) (defaultScannerAppliance ^ (defaultScannerAppliance >>> 32));
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (int) (networkId ^ (networkId >>> 32));
    result = 31 * result + partitionId;
    result = 31 * result + (int) (subscriptionId ^ (subscriptionId >>> 32));
    result = 31 * result + (int) (unitId ^ (unitId >>> 32));
    result = 31 * result + (int) (createdDate ^ (createdDate >>> 32));
    result = 31 * result + (int) (updatedDate ^ (updatedDate >>> 32));
    result = 31 * result + (int) (userId ^ (userId >>> 32));
    result = 31 * result + (int) (modifiedBy ^ (modifiedBy >>> 32));
    return result;
  }
}
