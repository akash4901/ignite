package com.example.demo;

import com.data.AssetGroupData;
import com.data.CacheName;
import com.data.DefaultDataAffinityKey;
import com.task.CreateAssetGroupIgniteTask;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.config.client"})
public class Client {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Client.class, args);
		System.out.println("Client Started");
    Ignite ignite ;
		try {
			ignite = applicationContext.getBean(Ignite.class);
			init(ignite);
			submitTask(ignite);
		} catch (Exception e) {
				SpringApplication.exit(applicationContext, () -> 1);
		}

	}

	private static void submitTask(Ignite ignite) {
		CreateAssetGroupIgniteTask igniteTask = new CreateAssetGroupIgniteTask();
		DefaultDataAffinityKey key = new DefaultDataAffinityKey(10000L,22222L);
		ignite.compute().affinityCall(CacheName.ASSET_GROUP_CACHE.name(), key.getAffinityId(), igniteTask);
		System.out.println("Task Submitted");
	}

	private static void init(Ignite ignite) {
		IgniteCache<Object, Object> cache = ignite.cache(CacheName.ASSET_GROUP_CACHE.name());
		for (int i = 100;i<=1000;i++) {
			DefaultDataAffinityKey key = new DefaultDataAffinityKey(i, i+2343);
			cache.put(key, new AssetGroupData());
		}
		System.out.println("Cluster set actviee");
	}



}

