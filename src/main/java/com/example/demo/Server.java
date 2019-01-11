package com.example.demo;

import com.data.CacheName;
import java.util.ArrayList;
import java.util.List;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.CollectionUtils;

@SpringBootApplication
@ComponentScan({"com.config.server"})
public class Server {

	public static final List<String> QWEB_CACHENAMES = new ArrayList() {{
		add(CacheName.SUBSCRIPTION_CACHE.name());
		add(CacheName.USER_PERMISSION_CACHE.name());
		add(CacheName.UNIT_CACHE.name());
		add(CacheName.ADDONS_CACHE.name());
		add(CacheName.NETWORK_CACHE.name());
		add(CacheName.USER_ACCOUNT_CACHE.name());

	}};

	public static final List<String> AGMS_CACHENAMES = new ArrayList() {{
		add(CacheName.IP_CONTAINER_IPV4_CACHE.name());
		add(CacheName.SUB_DNS_NB_TRACK_IP_CACHE.name());
		add(CacheName.UNIT_ASSET_GROUP_CACHE.name());
		add(CacheName.USER_ASSET_GROUP_CACHE.name());
		add(CacheName.ASSET_GROUP_CACHE.name());
		add(CacheName.ASSET_GROUP_NAME_PER_ID_CACHE.name());
		add(CacheName.IPV4_ASSET_GROUP_DETAIL_CACHE.name());
		add(CacheName.DNS_NB_ASSET_GROUP_DETAIL_CACHE.name());

		add(CacheName.DOMAIN_CACHE.name());
		add(CacheName.DOMAIN_IPV4_NETBLOCK_CACHE.name());
		add(CacheName.DOMAIN_IPV4_APPROVED_IPS_CACHE.name());
		add(CacheName.ASSET_GROUP_DOMAIN_CACHE.name());
		add(CacheName.ASSET_GROUP_DOMAIN_NETBLOCK_OVERRIDE_CACHE.name());
		add(CacheName.USER_DOMAIN_NETBLOCK_IPV4.name());
		add(CacheName.UNIT_DOMAIN_NETBLOCK_IPV4.name());
	}};

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Server.class, args);

		Ignite ignite = applicationContext.getBean(Ignite.class);
		for (String cacheName : QWEB_CACHENAMES) {
			IgniteCache<Object, Object> cache = ignite.getOrCreateCache(cacheName);
			cache.localMetrics();
			cache.metrics();
		}

		for (String cacheName : AGMS_CACHENAMES) {
			IgniteCache<Object, Object> cache = ignite.getOrCreateCache(cacheName);
			cache.localMetrics();
			cache.metrics();
		}
		System.out.println("Server Started");


	}

}

