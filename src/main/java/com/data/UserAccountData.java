package com.data;

import java.util.Objects;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class UserAccountData implements Data<DefaultDataAffinityKey> {

  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "user_account_idx1", order = 1),
      @QuerySqlField.Group(name = "user_account_idx3", order = 2)})
  private long userId;

  private String userName;

  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "user_account_idx3", order = 0),
      @QuerySqlField.Group(name = "user_account_idx4", order = 0)})
  private long subscriptionId;

  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "user_account_idx2", order = 1),
      @QuerySqlField.Group(name = "user_account_idx4", order = 1)})
  private long unitId;

  private long userStatus;

  //TODO: change userRole long to int
  @QuerySqlField(orderedGroups = {@QuerySqlField.Group(name = "user_account_idx3", order = 1)})
  private int userRole;

  @QuerySqlField
  private String firstName;
  @QuerySqlField
  private String lastName;
  private String prefix;
  private String title;
  private String company;

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public long getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(long subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public long getUnitId() {
    return unitId;
  }

  public void setUnitId(long unitId) {
    this.unitId = unitId;
  }

  public long getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(long userStatus) {
    this.userStatus = userStatus;
  }

  public int getUserRole() {
    return userRole;
  }

  public void setUserRole(int userRole) {
    this.userRole = userRole;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  @Override
  public DefaultDataAffinityKey getKey() {
    return new DefaultDataAffinityKey(userId, subscriptionId);
  }

  @Override
  public String getCacheName() {
    return CacheName.USER_ACCOUNT_CACHE.name();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserAccountData)) {
      return false;
    }
    UserAccountData that = (UserAccountData) o;
    return userId == that.userId && subscriptionId == that.subscriptionId && unitId == that.unitId
        && userStatus == that.userStatus && userRole == that.userRole && Objects.equals(userName, that.userName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(userId, userName, subscriptionId, unitId, userStatus, userRole);
  }
}
