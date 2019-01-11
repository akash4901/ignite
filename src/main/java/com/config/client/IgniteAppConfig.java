package com.config.client;

import java.util.Arrays;
import org.apache.ignite.IgniteSpringBean;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteAppConfig {

  @Bean
  public IgniteSpringBean igniteInstance() {
    IgniteSpringBean ignite = new IgniteSpringBean();

    ignite.setConfiguration(getIgniteConfiguration(ignite));

    return ignite;
  }

  private IgniteConfiguration getIgniteConfiguration(IgniteSpringBean ignite) {
    String[] hosts = {"localhost"};
    TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
    ipFinder.setAddresses(Arrays.asList(hosts));

    TcpDiscoverySpi discoSpi = new TcpDiscoverySpi();
    discoSpi.setIpFinder(ipFinder);

    IgniteConfiguration cfg = new IgniteConfiguration();
    cfg.setDiscoverySpi(discoSpi);
    cfg.setIgniteInstanceName("springDataNode");
    cfg.setPeerClassLoadingEnabled(false);
    cfg.setRebalanceThreadPoolSize(4);
    //cfg.setLifecycleBeans(new IgniteLifeCycleBean());
    cfg.setClientMode(true);

    return cfg;
  }


}
