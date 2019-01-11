package com.data.key;

import java.io.Serializable;

public interface DataKey<K> extends Serializable{

  K getId();
}
