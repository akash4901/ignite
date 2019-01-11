package com.data;

public enum CacheName {

  USER_PERMISSION_CACHE("UserPermissionCache"),
  IP_CONTAINER_IPV4_CACHE("IpContainerIpV4Cache"),
  USER_ACCOUNT_CACHE("UserAccountCache"),
  ASSET_GROUP_CACHE("AssetGroupCache"),
  ASSET_GROUP_NAME_PER_ID_CACHE("AssetGroupNameIdCache"),
  IPV4_ASSET_GROUP_DETAIL_CACHE("IPV4AssetGroupDetailCache"),
  DNS_NB_ASSET_GROUP_DETAIL_CACHE("DnsNbAssetGroupDetailCache"),
  USER_ASSET_GROUP_CACHE("UserAssetGroupCache"),
  UNIT_ASSET_GROUP_CACHE("UnitAssetGroupCache"),
  SUB_DNS_NB_TRACK_IP_CACHE("SubDnsNbTrackIpCache"),
  SUBSCRIPTION_CACHE("SubscriptionCache"),
  NETWORK_CACHE("NetworkCache"),
  UNIT_CACHE("UnitCache"),
  ADDONS_CACHE("AddOnsCache"),
  DOMAIN_CACHE("DomainCache"),
  DOMAIN_IPV4_NETBLOCK_CACHE("DomainIpV4NetblockCache"),
  ASSET_GROUP_DOMAIN_CACHE("AssetGroupDomainCache"),
  ASSET_GROUP_DOMAIN_NETBLOCK_OVERRIDE_CACHE("AssetGroupDomainNetblockOverrideCache"),
  DOMAIN_IPV4_APPROVED_IPS_CACHE("DomainIpv4ApprovedIpsCache"),
  DOMAIN_COMMENTS("DomainComments"),
  USER_DOMAIN_NETBLOCK_IPV4("UserDomainNetblockIpv4"),
  UNIT_DOMAIN_NETBLOCK_IPV4("UnitDomainNetblockIpv4"),
  AGMS_FEED_AUDIT_CACHE("AGMS_FEED_AUDIT_CACHE");

  private final String cacheName;

  CacheName(String cacheName) {
    this.cacheName = cacheName;
  }
}
