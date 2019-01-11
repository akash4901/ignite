package com.data;

import com.data.key.AddOnsKey;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class AddOnsData implements Data<AddOnsKey> {

  private int addOnsId;
  @QuerySqlField
  private String addOnsName;

  @Override
  public AddOnsKey getKey() {
    return new AddOnsKey(addOnsId);
  }

  @Override
  public String getCacheName() {
    return CacheName.ADDONS_CACHE.name();
  }

  public int getAddOnsId() {
    return addOnsId;
  }

  public void setAddOnsId(int addOnsId) {
    this.addOnsId = addOnsId;
  }

  public String getAddOnsName() {
    return addOnsName;
  }

  public void setAddOnsName(String addOnsName) {
    this.addOnsName = addOnsName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    AddOnsData that = (AddOnsData) o;

    if (addOnsId != that.addOnsId) {
      return false;
    }
    return addOnsName != null ? addOnsName.equals(that.addOnsName) : that.addOnsName == null;

  }

  @Override
  public int hashCode() {
    int result = addOnsId;
    result = 31 * result + (addOnsName != null ? addOnsName.hashCode() : 0);
    return result;
  }
}
