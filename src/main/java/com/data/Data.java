package com.data;

import com.data.key.DataKey;

public interface Data<K extends DataKey> {

  public K getKey();

  public String getCacheName();
}
