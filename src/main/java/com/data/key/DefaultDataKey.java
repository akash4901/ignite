package com.data.key;

public class DefaultDataKey implements DataKey<Long> {

  private static final long serialVersionUID = 2541547034201234691L;
  private Long id;

  public DefaultDataKey(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DefaultDataKey)) {
      return false;
    }

    DefaultDataKey that = (DefaultDataKey) o;

    return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
  }

  @Override
  public int hashCode() {
    return getId() != null ? getId().hashCode() : 0;
  }
}
