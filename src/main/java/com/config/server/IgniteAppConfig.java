package com.config.server;

import com.data.AGDomainNetblockOverrideData;
import com.data.AddOnsData;
import com.data.AssetGroupData;
import com.data.AssetGroupDomainData;
import com.data.CacheName;
import com.data.DefaultDataAffinityKey;
import com.data.DnsNetBiosAssetGroupData;
import com.data.DomainCommentsData;
import com.data.DomainData;
import com.data.DomainIpV4Netblock;
import com.data.DomainIpv4ApprovedIpsData;
import com.data.IpContainerIpV4Data;
import com.data.IpV4AssetGroupData;
import com.data.NetworkData;
import com.data.SubnetDnsNetBiosIpTrackData;
import com.data.SubscriptionData;
import com.data.UnitAssetGroupData;
import com.data.UnitData;
import com.data.UnitDomainNetblockData;
import com.data.UserAccountData;
import com.data.UserAssetGroupData;
import com.data.UserDomainNetblockData;
import com.data.key.AddOnsKey;
import com.data.key.DefaultDataKey;
import java.util.Arrays;
import org.apache.ignite.IgniteSpringBean;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.CacheRebalanceMode;
import org.apache.ignite.cache.CacheWriteSynchronizationMode;
import org.apache.ignite.cache.affinity.rendezvous.RendezvousAffinityFunction;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.DataRegionConfiguration;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteAppConfig {



  private static boolean ENABLE_WRITE_THROUGH = true;

  private static final String DATA_REGION_NAME = "xyz";

  @Bean
  public IgniteSpringBean igniteInstance() {

   IgniteSpringBean ignite = new IgniteSpringBean();

    ignite.setConfiguration(getIgniteConfiguration(ignite));

    return ignite;
  }

  private IgniteConfiguration getIgniteConfiguration(IgniteSpringBean ignite) {

    TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
    String[] hosts = {"localhost"};
    ipFinder.setAddresses(Arrays.asList(hosts));

    TcpDiscoverySpi discoSpi = new TcpDiscoverySpi();
    discoSpi.setIpFinder(ipFinder);

    IgniteConfiguration cfg = new IgniteConfiguration();
    cfg.setDiscoverySpi(discoSpi);
    cfg.setIgniteInstanceName("springDataNode");
    cfg.setPeerClassLoadingEnabled(false);
    cfg.setRebalanceThreadPoolSize(4);
    //cfg.setClientMode(true);
    //  cfg.setTransactionConfiguration(transactionConfiguration());

    DataStorageConfiguration storageCfg = new DataStorageConfiguration();
    DataRegionConfiguration regionConfiguration = new DataRegionConfiguration();
    regionConfiguration.setInitialSize(3L * 1024 * 1024 * 1024);
    regionConfiguration.setMaxSize(3L * 1024 * 1024 * 1024);
    regionConfiguration.setMetricsEnabled(true);

    storageCfg.setDefaultDataRegionConfiguration(regionConfiguration);
    //storageCfg.getDefaultDataRegionConfiguration().setPersistenceEnabled(true);
    storageCfg.setStoragePath("c:/ignite-storage/storage");
    storageCfg.setWalPath("c:/ignite-storage/storage/wal");
    storageCfg.setWalArchivePath("c:/ignite-storage/storage/wal-archive");
    storageCfg.setMetricsEnabled(true);
    cfg.setDataStorageConfiguration(storageCfg);

    CacheConfiguration[] cacheConfigurations = getCacheConfigurations();
    cfg.setCacheConfiguration(cacheConfigurations);
    return cfg;
  }

  private CacheConfiguration[] getCacheConfigurations() {
    CacheConfiguration[] cacheConfigurations = {ipContainerIPV4CacheCfg(),
        subDnsNbIpTrackDataCacheCfg(),
        assetGroupCacheCfg(),
        ipv4AssetGroupDetailCacheCfg(),
        dnsNbAssetGroupDetailCacheCfg(),
        userAssetGroupCacheCfg(),
        unitAssetGroupCacheCfg(),
        domainDataCacheCfg(),
        domainNetblockDataCacheCfg(),
        assetGroupDomainDataCacheCfg(),
        agDomainNbOverrideDataCacheCfg(),
        domainIpv4ApprovedIpsDataCacheCfg(),
        domainCommentsDataCacheCfg(),
        userDomainNetblockDataCacheCfg(),
        unitDomainNetblockDataCacheCfg(),
        addOnsCacheCfg(),
        userPermissionCacheCfg(),
        userAccountCacheCfg(),
        subscriptionCacheCfg(),
        networkCacheCfg(),
        unitCacheCfg()};
    return cacheConfigurations;
  }

  private CacheConfiguration ipContainerIPV4CacheCfg() {

    CacheConfiguration ipContainerIpV4CacheCfg = new CacheConfiguration<>(CacheName.IP_CONTAINER_IPV4_CACHE.name());
    ipContainerIpV4CacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    ipContainerIpV4CacheCfg.setWriteThrough(false);
    ipContainerIpV4CacheCfg.setReadThrough(false);
    ipContainerIpV4CacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    ipContainerIpV4CacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    ipContainerIpV4CacheCfg.setBackups(1);
    ipContainerIpV4CacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, IpContainerIpV4Data.class);
    ipContainerIpV4CacheCfg.setSqlIndexMaxInlineSize(84);
    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    ipContainerIpV4CacheCfg.setAffinity(affinityFunction);
    ipContainerIpV4CacheCfg.setStatisticsEnabled(true);

    return ipContainerIpV4CacheCfg;
  }

  private CacheConfiguration subDnsNbIpTrackDataCacheCfg() {

    CacheConfiguration subDnsNbIpTrackDataCacheCfg = new CacheConfiguration<>(
        CacheName.SUB_DNS_NB_TRACK_IP_CACHE.name());
    subDnsNbIpTrackDataCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    subDnsNbIpTrackDataCacheCfg.setWriteThrough(false);
    subDnsNbIpTrackDataCacheCfg.setReadThrough(false);
    subDnsNbIpTrackDataCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    subDnsNbIpTrackDataCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    subDnsNbIpTrackDataCacheCfg.setBackups(1);

    subDnsNbIpTrackDataCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, SubnetDnsNetBiosIpTrackData.class);


    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    subDnsNbIpTrackDataCacheCfg.setAffinity(affinityFunction);
    subDnsNbIpTrackDataCacheCfg.setStatisticsEnabled(true);

    return subDnsNbIpTrackDataCacheCfg;
  }

  private CacheConfiguration ipv4AssetGroupDetailCacheCfg() {

    CacheConfiguration ipv4AssetGroupDetailCacheCfg = new CacheConfiguration<>(
        CacheName.IPV4_ASSET_GROUP_DETAIL_CACHE.name());
    ipv4AssetGroupDetailCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    ipv4AssetGroupDetailCacheCfg.setWriteThrough(false);
    ipv4AssetGroupDetailCacheCfg.setReadThrough(false);
    ipv4AssetGroupDetailCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    ipv4AssetGroupDetailCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    ipv4AssetGroupDetailCacheCfg.setBackups(1);
    ipv4AssetGroupDetailCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, IpV4AssetGroupData.class);

    ipv4AssetGroupDetailCacheCfg.setSqlIndexMaxInlineSize(65);
    ipv4AssetGroupDetailCacheCfg.setStatisticsEnabled(true);

    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    ipv4AssetGroupDetailCacheCfg.setAffinity(affinityFunction);
    ipv4AssetGroupDetailCacheCfg.setStatisticsEnabled(true);

    return ipv4AssetGroupDetailCacheCfg;
  }


  private CacheConfiguration assetGroupCacheCfg() {

    CacheConfiguration assetGroupCacheCfg = new CacheConfiguration<>(CacheName.ASSET_GROUP_CACHE.name());
    assetGroupCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    assetGroupCacheCfg.setWriteThrough(false);
    assetGroupCacheCfg.setReadThrough(false);
    assetGroupCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    //assetGroupCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    assetGroupCacheCfg.setBackups(1);
    assetGroupCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, AssetGroupData.class);

    assetGroupCacheCfg.setSqlIndexMaxInlineSize(100);
    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    assetGroupCacheCfg.setAffinity(affinityFunction);
    assetGroupCacheCfg.setStatisticsEnabled(true);


    return assetGroupCacheCfg;
  }

  private CacheConfiguration dnsNbAssetGroupDetailCacheCfg() {

    CacheConfiguration dnsNbAssetGroupDetailCacheCfg = new CacheConfiguration<>(
        CacheName.DNS_NB_ASSET_GROUP_DETAIL_CACHE.name());
    dnsNbAssetGroupDetailCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    dnsNbAssetGroupDetailCacheCfg.setWriteThrough(false);
    dnsNbAssetGroupDetailCacheCfg.setReadThrough(false);
    dnsNbAssetGroupDetailCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    dnsNbAssetGroupDetailCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    dnsNbAssetGroupDetailCacheCfg.setBackups(1);

    dnsNbAssetGroupDetailCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, DnsNetBiosAssetGroupData.class);

    dnsNbAssetGroupDetailCacheCfg.setSqlIndexMaxInlineSize(120);

    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    dnsNbAssetGroupDetailCacheCfg.setAffinity(affinityFunction);
    dnsNbAssetGroupDetailCacheCfg.setStatisticsEnabled(true);

    return dnsNbAssetGroupDetailCacheCfg;
  }

  private CacheConfiguration userAssetGroupCacheCfg() {

    CacheConfiguration userAssetGroupCacheCfg = new CacheConfiguration<>(CacheName.USER_ASSET_GROUP_CACHE.name());
    userAssetGroupCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    userAssetGroupCacheCfg.setWriteThrough(false);
    userAssetGroupCacheCfg.setReadThrough(false);
    userAssetGroupCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    userAssetGroupCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    userAssetGroupCacheCfg.setBackups(1);
    userAssetGroupCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, UserAssetGroupData.class);

    userAssetGroupCacheCfg.setSqlIndexMaxInlineSize(100);
    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    userAssetGroupCacheCfg.setAffinity(affinityFunction);
    userAssetGroupCacheCfg.setStatisticsEnabled(true);

    return userAssetGroupCacheCfg;
  }

  private CacheConfiguration unitAssetGroupCacheCfg() {

    CacheConfiguration unitAssetGroupCacheCfg = new CacheConfiguration<>(CacheName.UNIT_ASSET_GROUP_CACHE.name());
    unitAssetGroupCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    unitAssetGroupCacheCfg.setWriteThrough(false);
    unitAssetGroupCacheCfg.setReadThrough(false);
    unitAssetGroupCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    unitAssetGroupCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    unitAssetGroupCacheCfg.setBackups(1);

    unitAssetGroupCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, UnitAssetGroupData.class);

    unitAssetGroupCacheCfg.setSqlIndexMaxInlineSize(100);
    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    unitAssetGroupCacheCfg.setAffinity(affinityFunction);
    unitAssetGroupCacheCfg.setStatisticsEnabled(true);

    return unitAssetGroupCacheCfg;
  }

  private CacheConfiguration addOnsCacheCfg() {

    CacheConfiguration addOnsCacheCfg = new CacheConfiguration<>(CacheName.ADDONS_CACHE.name());
    addOnsCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    addOnsCacheCfg.setWriteThrough(false);
    addOnsCacheCfg.setReadThrough(false);
    addOnsCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    addOnsCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    addOnsCacheCfg.setBackups(1);
    addOnsCacheCfg.setIndexedTypes(AddOnsKey.class, AddOnsData.class);
    addOnsCacheCfg.setCacheMode(CacheMode.REPLICATED);
    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    addOnsCacheCfg.setAffinity(affinityFunction);
    addOnsCacheCfg.setStatisticsEnabled(true);

    return addOnsCacheCfg;
  }


  private CacheConfiguration userPermissionCacheCfg() {

    CacheConfiguration userPermissionCacheCfg = new CacheConfiguration<>(CacheName.USER_PERMISSION_CACHE.name());
    userPermissionCacheCfg.setAtomicityMode(CacheAtomicityMode.ATOMIC);
    userPermissionCacheCfg.setWriteThrough(false);
    userPermissionCacheCfg.setReadThrough(false);
    userPermissionCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    userPermissionCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    userPermissionCacheCfg.setBackups(1);
    userPermissionCacheCfg.setCacheMode(CacheMode.REPLICATED);

    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    userPermissionCacheCfg.setAffinity(affinityFunction);
    userPermissionCacheCfg.setStatisticsEnabled(true);

    return userPermissionCacheCfg;
  }

  private CacheConfiguration userAccountCacheCfg() {

    CacheConfiguration userAccountCacheCfg = new CacheConfiguration<>(CacheName.USER_ACCOUNT_CACHE.name());
    userAccountCacheCfg.setAtomicityMode(CacheAtomicityMode.ATOMIC);
    userAccountCacheCfg.setWriteThrough(false);
    userAccountCacheCfg.setReadThrough(false);
    userAccountCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    userAccountCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    userAccountCacheCfg.setBackups(1);

    userAccountCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, UserAccountData.class);
    userAccountCacheCfg.setSqlIndexMaxInlineSize(100);
    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    userAccountCacheCfg.setAffinity(affinityFunction);
    userAccountCacheCfg.setStatisticsEnabled(true);

    return userAccountCacheCfg;
  }

  private CacheConfiguration networkCacheCfg() {
    CacheConfiguration networkCacheCfg = new CacheConfiguration<>(CacheName.NETWORK_CACHE.name());
    networkCacheCfg.setAtomicityMode(CacheAtomicityMode.ATOMIC);
    networkCacheCfg.setWriteThrough(false);
    networkCacheCfg.setReadThrough(false);
    networkCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    networkCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    networkCacheCfg.setBackups(1);

    networkCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, NetworkData.class);
    networkCacheCfg.setSqlIndexMaxInlineSize(65);
    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    networkCacheCfg.setAffinity(affinityFunction);
    networkCacheCfg.setStatisticsEnabled(true);

    return networkCacheCfg;
  }

  private CacheConfiguration unitCacheCfg() {
    CacheConfiguration unitCacheCfg = new CacheConfiguration<>(CacheName.UNIT_CACHE.name());
    unitCacheCfg.setAtomicityMode(CacheAtomicityMode.ATOMIC);
    unitCacheCfg.setWriteThrough(false);
    unitCacheCfg.setReadThrough(false);
    unitCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    unitCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    unitCacheCfg.setBackups(1);
    unitCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, UnitData.class);
    unitCacheCfg.setSqlIndexMaxInlineSize(65);
    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    unitCacheCfg.setAffinity(affinityFunction);
    unitCacheCfg.setStatisticsEnabled(true);

    return unitCacheCfg;
  }


  private CacheConfiguration subscriptionCacheCfg() {

    CacheConfiguration subscriptionCacheCfg = new CacheConfiguration<>(CacheName.SUBSCRIPTION_CACHE.name());
    subscriptionCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    subscriptionCacheCfg.setWriteThrough(false);
    subscriptionCacheCfg.setReadThrough(false);
    subscriptionCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    subscriptionCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    subscriptionCacheCfg.setBackups(1);

    subscriptionCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, SubscriptionData.class);
    subscriptionCacheCfg.setIndexedTypes(DefaultDataKey.class, SubscriptionData.class);
    subscriptionCacheCfg.setSqlIndexMaxInlineSize(47);
    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    subscriptionCacheCfg.setAffinity(affinityFunction);
    subscriptionCacheCfg.setStatisticsEnabled(true);
    return subscriptionCacheCfg;
  }


  private CacheConfiguration domainDataCacheCfg() {

    CacheConfiguration domainDataCacheCfg = new CacheConfiguration<>(CacheName.DOMAIN_CACHE.name());
    domainDataCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    domainDataCacheCfg.setWriteThrough(false);
    domainDataCacheCfg.setReadThrough(false);
    domainDataCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    domainDataCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    domainDataCacheCfg.setBackups(1);
    domainDataCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, DomainData.class);

    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    domainDataCacheCfg.setAffinity(affinityFunction);
    domainDataCacheCfg.setStatisticsEnabled(true);

    return domainDataCacheCfg;
  }

  private CacheConfiguration domainNetblockDataCacheCfg() {

    CacheConfiguration domainNetblockDataCacheCfg = new CacheConfiguration<>(
        CacheName.DOMAIN_IPV4_NETBLOCK_CACHE.name());
    domainNetblockDataCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    domainNetblockDataCacheCfg.setWriteThrough(false);
    domainNetblockDataCacheCfg.setReadThrough(false);
    domainNetblockDataCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    domainNetblockDataCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    domainNetblockDataCacheCfg.setBackups(1);
    domainNetblockDataCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, DomainIpV4Netblock.class);

    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    domainNetblockDataCacheCfg.setAffinity(affinityFunction);
    domainNetblockDataCacheCfg.setStatisticsEnabled(true);

    return domainNetblockDataCacheCfg;
  }


  private CacheConfiguration assetGroupDomainDataCacheCfg() {

    CacheConfiguration assetGroupDomainDataCacheCfg = new CacheConfiguration<>(
        CacheName.ASSET_GROUP_DOMAIN_CACHE.name());
    assetGroupDomainDataCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    assetGroupDomainDataCacheCfg.setWriteThrough(false);
    assetGroupDomainDataCacheCfg.setReadThrough(false);
    assetGroupDomainDataCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    assetGroupDomainDataCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    assetGroupDomainDataCacheCfg.setBackups(1);
    assetGroupDomainDataCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, AssetGroupDomainData.class);


    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    assetGroupDomainDataCacheCfg.setAffinity(affinityFunction);
    assetGroupDomainDataCacheCfg.setStatisticsEnabled(true);
    return assetGroupDomainDataCacheCfg;
  }

  private CacheConfiguration agDomainNbOverrideDataCacheCfg() {

    CacheConfiguration agDomainNbOverrideDataCacheCfg = new CacheConfiguration<>(
        CacheName.ASSET_GROUP_DOMAIN_NETBLOCK_OVERRIDE_CACHE.name());
    agDomainNbOverrideDataCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    agDomainNbOverrideDataCacheCfg.setWriteThrough(false);
    agDomainNbOverrideDataCacheCfg.setReadThrough(false);
    agDomainNbOverrideDataCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    agDomainNbOverrideDataCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    agDomainNbOverrideDataCacheCfg.setBackups(1);

    agDomainNbOverrideDataCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, AGDomainNetblockOverrideData.class);
    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    agDomainNbOverrideDataCacheCfg.setAffinity(affinityFunction);
    agDomainNbOverrideDataCacheCfg.setStatisticsEnabled(true);
    return agDomainNbOverrideDataCacheCfg;
  }


  private CacheConfiguration domainIpv4ApprovedIpsDataCacheCfg() {

    CacheConfiguration domainIpv4ApprovedIpsDataCacheCfg = new CacheConfiguration<>(
        CacheName.DOMAIN_IPV4_APPROVED_IPS_CACHE.name());
    domainIpv4ApprovedIpsDataCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    domainIpv4ApprovedIpsDataCacheCfg.setWriteThrough(false);
    domainIpv4ApprovedIpsDataCacheCfg.setReadThrough(false);
    domainIpv4ApprovedIpsDataCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    domainIpv4ApprovedIpsDataCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    domainIpv4ApprovedIpsDataCacheCfg.setBackups(1);
    domainIpv4ApprovedIpsDataCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, DomainIpv4ApprovedIpsData.class);


    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    domainIpv4ApprovedIpsDataCacheCfg.setAffinity(affinityFunction);
    domainIpv4ApprovedIpsDataCacheCfg.setStatisticsEnabled(true);
    return domainIpv4ApprovedIpsDataCacheCfg;
  }

  private CacheConfiguration domainCommentsDataCacheCfg() {

    CacheConfiguration domainCommentsDataCacheCfg = new CacheConfiguration<>(CacheName.DOMAIN_COMMENTS.name());
    domainCommentsDataCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    domainCommentsDataCacheCfg.setWriteThrough(false);
    domainCommentsDataCacheCfg.setReadThrough(false);
    domainCommentsDataCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    domainCommentsDataCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    domainCommentsDataCacheCfg.setBackups(1);
    domainCommentsDataCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, DomainCommentsData.class);


    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    domainCommentsDataCacheCfg.setAffinity(affinityFunction);
    domainCommentsDataCacheCfg.setStatisticsEnabled(true);
    return domainCommentsDataCacheCfg;
  }


  private CacheConfiguration userDomainNetblockDataCacheCfg() {

    CacheConfiguration userDomainNetblockDataCacheCfg = new CacheConfiguration<>(
        CacheName.USER_DOMAIN_NETBLOCK_IPV4.name());
    userDomainNetblockDataCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    userDomainNetblockDataCacheCfg.setWriteThrough(false);
    userDomainNetblockDataCacheCfg.setReadThrough(false);
    userDomainNetblockDataCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    userDomainNetblockDataCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    userDomainNetblockDataCacheCfg.setBackups(1);


    userDomainNetblockDataCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, UserDomainNetblockData.class);
    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    userDomainNetblockDataCacheCfg.setAffinity(affinityFunction);
    userDomainNetblockDataCacheCfg.setStatisticsEnabled(true);
    return userDomainNetblockDataCacheCfg;
  }

  private CacheConfiguration unitDomainNetblockDataCacheCfg() {

    CacheConfiguration unitDomainNetblockDataCacheCfg = new CacheConfiguration<>(
        CacheName.UNIT_DOMAIN_NETBLOCK_IPV4.name());
    unitDomainNetblockDataCacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
    unitDomainNetblockDataCacheCfg.setWriteThrough(false);
    unitDomainNetblockDataCacheCfg.setReadThrough(false);
    unitDomainNetblockDataCacheCfg.setRebalanceMode(CacheRebalanceMode.ASYNC);
    unitDomainNetblockDataCacheCfg.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    unitDomainNetblockDataCacheCfg.setBackups(1);
    unitDomainNetblockDataCacheCfg.setIndexedTypes(DefaultDataAffinityKey.class, UnitDomainNetblockData.class);

    RendezvousAffinityFunction affinityFunction = new RendezvousAffinityFunction();
    affinityFunction.setExcludeNeighbors(true);
    unitDomainNetblockDataCacheCfg.setAffinity(affinityFunction);
    unitDomainNetblockDataCacheCfg.setStatisticsEnabled(true);
    return unitDomainNetblockDataCacheCfg;
  }

}
