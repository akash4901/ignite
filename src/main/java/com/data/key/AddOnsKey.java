package com.data.key;


public class AddOnsKey implements DataKey<Integer> {

  private int addOnsId;

  public AddOnsKey(int addOnsId) {
    this.addOnsId = addOnsId;
  }

  @Override
  public Integer getId() {
    return addOnsId;
  }
}
