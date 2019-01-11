package com.data;


import com.data.key.DefaultDataKey;
import java.util.Map;
import java.util.Set;

/**
 * Created by ragupta on 4/18/2018.
 */
public class SubscriptionData implements Data<DefaultDataKey> {

  private long subscriptionId;
  private String companyName;
  private long expirationDate;
  /**
   * Addon ids
   */
  Set<Long> activatedModules;
  private boolean enforced;
  private boolean ipv6Enabled;

  private Map<ModuleConfigNames, Long> modulePurchasedIPs;


  public long getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(long subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public long getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(long expirationDate) {
    this.expirationDate = expirationDate;
  }

  public Set<Long> getActivatedModules() {
    return activatedModules;
  }

  public void setActivatedModules(Set<Long> activatedModules) {
    this.activatedModules = activatedModules;
  }

  public boolean isEnforced() {
    return enforced;
  }

  public void setEnforced(boolean enforced) {
    this.enforced = enforced;
  }

  public boolean isIpv6Enabled() {
    return ipv6Enabled;
  }

  public void setIpv6Enabled(boolean ipv6Enabled) {
    this.ipv6Enabled = ipv6Enabled;
  }

  public Map<ModuleConfigNames, Long> getModulePurchasedIPs() {
    return modulePurchasedIPs;
  }

  public void setModulePurchasedIPs(Map<ModuleConfigNames, Long> modulePurchasedIPs) {
    this.modulePurchasedIPs = modulePurchasedIPs;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SubscriptionData)) {
      return false;
    }

    SubscriptionData that = (SubscriptionData) o;

    if (getSubscriptionId() != that.getSubscriptionId()) {
      return false;
    }
    if (getExpirationDate() != that.getExpirationDate()) {
      return false;
    }
    if (isEnforced() != that.isEnforced()) {
      return false;
    }
    if (isIpv6Enabled() != that.isIpv6Enabled()) {
      return false;
    }
    if (getCompanyName() != null ? !getCompanyName().equals(that.getCompanyName()) : that.getCompanyName() != null) {
      return false;
    }
    if (getActivatedModules() != null ? !getActivatedModules().equals(that.getActivatedModules())
        : that.getActivatedModules() != null) {
      return false;
    }
    return getModulePurchasedIPs() != null ? getModulePurchasedIPs().equals(that.getModulePurchasedIPs())
        : that.getModulePurchasedIPs() == null;
  }

  @Override
  public int hashCode() {
    int result = (int) (getSubscriptionId() ^ (getSubscriptionId() >>> 32));
    result = 31 * result + (getCompanyName() != null ? getCompanyName().hashCode() : 0);
    result = 31 * result + (int) (getExpirationDate() ^ (getExpirationDate() >>> 32));
    result = 31 * result + (getActivatedModules() != null ? getActivatedModules().hashCode() : 0);
    result = 31 * result + (isEnforced() ? 1 : 0);
    result = 31 * result + (isIpv6Enabled() ? 1 : 0);
    result = 31 * result + (getModulePurchasedIPs() != null ? getModulePurchasedIPs().hashCode() : 0);
    return result;
  }

  @Override
  public DefaultDataKey getKey() {
    return new DefaultDataKey(this.subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.SUBSCRIPTION_CACHE.name();
  }

  @Override
  public String toString() {
    return "SubscriptionData{" + "subscriptionId=" + subscriptionId + ", companyName='" + companyName + '\''
        + ", expirationDate=" + expirationDate + ", activatedModules=" + activatedModules + ", enforced=" + enforced
        + ", ipv6Enabled=" + ipv6Enabled + '}';
  }
}
