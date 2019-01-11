package com.data;

import com.data.key.DataKey;

public interface UpdatableData<K extends DataKey> extends Data<K> {

  /**
   * @return true if the data/entry is newly created. false if it is existing data/entry is updated
   */
  boolean isUpdated();
}
