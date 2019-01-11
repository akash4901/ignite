package com.task;

import com.data.IpV4AssetGroupData;
import org.apache.ignite.lang.IgniteCallable;


public class CreateAssetGroupIgniteTask implements IgniteCallable<IpV4AssetGroupData> {

 // private static final Logger LOGGER = LoggerFactory.getLogger(CreateAssetGroupIgniteTask.class);

  private static final long serialVersionUID = -1061985816946505025L;

  @Override
  public IpV4AssetGroupData call() {
    System.out.println("inside Task");
    return new IpV4AssetGroupData();
  }






}
