package com.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by ppawar on 8/9/2018.
 */
public class JobStatusData {

  private long jobId;
  private long subscriptionId;
  private long userId;
  private String requestId;
  private Operation operation;
  private Status status;
  private String message;
  private String entityIds;
  private long createdOn;
  private long updatedOn;
  private long timeTakenToComplete;
  private long retriedCount;


  public JobStatusData() {
  }

  public JobStatusData(JobStatusDataBuilder dataBuilder) {
    this(dataBuilder.getJobId(), dataBuilder.getSubscriptionId(), dataBuilder.getUserId(), dataBuilder.getRequestId(),
        dataBuilder.getOperation(), dataBuilder.getStatus(), dataBuilder.getMessage(), dataBuilder.getEntityIds(),
        dataBuilder.getCreatedOn(), dataBuilder.getUpdatedOn(),dataBuilder.getTimeTakenToComplete(),dataBuilder.getRetriedCount());
  }

  public JobStatusData(long jobId, long subscriptionId, long userId, String requestId, Operation operation,
      Status status, String message, String entityIds, long createdOn, long updatedOn,long timeTakenToComplete,long retriedCount) {
    this.jobId = jobId;
    this.subscriptionId = subscriptionId;
    this.userId = userId;
    this.requestId = requestId;
    this.operation = operation;
    this.status = status;
    this.message = message;
    this.entityIds = entityIds;
    this.createdOn = createdOn;
    this.updatedOn = updatedOn;
    this.timeTakenToComplete=timeTakenToComplete;
    this.retriedCount=retriedCount;
  }

  public enum Operation {
    ADD_ASSET_GROUPS_TO_USER("ADD_ASSET_GROUPS_TO_USER"), REMOVE_ASSET_GROUPS_FROM_USER(
        "REMOVE_ASSET_GROUPS_FROM_USER"), RESET_ASSET_GROUPS_FOR_USER("RESET_ASSET_GROUPS_FOR_USER"),

    ADD_ASSET_GROUPS_TO_UNIT("ADD_ASSET_GROUPS_TO_UNIT"), REMOVE_ASSET_GROUPS_FROM_UNIT(
        "REMOVE_ASSET_GROUPS_FROM_UNIT"), RESET_ASSET_GROUPS_FOR_UNIT("RESET_ASSET_GROUPS_FOR_UNIT"), EDIT_DOMAIN(
        "EDIT_DOMAIN"), CREATE_DOMAIN("CREATE_DOMAIN"), SET_DOMAIN_APPROVED_IP("SET_DOMAIN_APPROVED_IP"), REMOVE_DOMAIN(
        "REMOVE_DOMAIN"), ADD_IPS("ADD_IPS"), REMOVE_IPS("REMOVE_IPS"), EDIT_ASSET_GROUP(
        "EDIT_ASSET_GROUP"), REMOVE_ASSET_GROUP("REMOVE_ASSET_GROUP"), ADD_IPS_TO_ASSET_GROUP(
        "ADD_IPS_TO_ASSET_GROUP"), ADD_DNS_NETBIOS_TO_ASSET_GROUP(
        "ADD_DNS_NETBIOS_TO_ASSET_GROUP"), ADD_DOMAIN_TO_ASSET_GROUP(
        "ADD_DOMAIN_TO_ASSET_GROUP"), REMOVE_IPS_TO_ASSET_GROUP(
        "REMOVE_IPS_TO_ASSET_GROUP"), REMOVE_DNS_NETBIOS_TO_ASSET_GROUP(
        "REMOVE_DNS_NETBIOS_TO_ASSET_GROUP"), REMOVE_DOMAIN_TO_ASSET_GROUP("REMOVE_DOMAIN_TO_ASSET_GROUP");
    private String value;

    Operation(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public enum Status {
    QUEUED("QUEUED"), INPROGESS("INPROGESS"),JOBSTARTED("JOBSTARTED"),COMPLETED("COMPLETED"), FAILED("FAILED");
    private String value;

    Status(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public long getJobId() {
    return jobId;
  }

  public void setJobId(long jobId) {
    this.jobId = jobId;
  }

  public long getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(long subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public Operation getOperation() {
    return operation;
  }

  public void setOperation(Operation operation) {
    this.operation = operation;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getEntityIds() {
    return entityIds;
  }

  public void setEntityIds(String entityIds) {
    this.entityIds = entityIds;
  }

  public long getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(long createdOn) {
    this.createdOn = createdOn;
  }

  public long getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(long updatedOn) {
    this.updatedOn = updatedOn;
  }

  public long getTimeTakenToComplete() {
    return timeTakenToComplete;
  }

  public void setTimeTakenToComplete(long timeTakenToComplete) {
    this.timeTakenToComplete = timeTakenToComplete;
  }

  public long getRetriedCount() {
    return retriedCount;
  }

  public void setRetriedCount(long retriedCount) {
    this.retriedCount = retriedCount;
  }

  @Override
  public String toString() {
    return "JobStatusData{" + "jobId=" + jobId + ", subscriptionId=" + subscriptionId + ", userId=" + userId
        + ", requestId='" + requestId + '\'' + ", operation=" + operation + ", status=" + status + ", message='"
        + message + '\'' + ", entityIds='" + entityIds + '\'' + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn
        + ", timeTakenToComplete=" + timeTakenToComplete + ", retriedCount=" + retriedCount + '}';
  }

  public static class JobStatusDataBuilder {

    private long jobId;
    private long subscriptionId;
    private long userId;
    private String requestId;
    private Operation operation;
    private Status status;
    private String message;
    private String entityIds;
    private long createdOn;
    private long updatedOn;
    private long timeTakenToComplete;
    private long retriedCount;

    public JobStatusDataBuilder() {

    }

    public long getJobId() {
      return jobId;
    }

    public void setJobId(long jobId) {
      this.jobId = jobId;
    }

    public long getSubscriptionId() {
      return subscriptionId;
    }

    public void setSubscriptionId(long subscriptionId) {
      this.subscriptionId = subscriptionId;
    }

    public long getUserId() {
      return userId;
    }

    public void setUserId(long userId) {
      this.userId = userId;
    }

    public String getRequestId() {
      return requestId;
    }

    public void setRequestId(String requestId) {
      this.requestId = requestId;
    }

    public Operation getOperation() {
      return operation;
    }

    public void setOperation(Operation operation) {
      this.operation = operation;
    }

    public Status getStatus() {
      return status;
    }

    public void setStatus(Status status) {
      this.status = status;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public String getEntityIds() {
      return entityIds;
    }

    public void setEntityIds(String entityIds) {
      this.entityIds = entityIds;
    }

    public long getCreatedOn() {
      return createdOn;
    }

    public void setCreatedOn(long createdOn) {
      this.createdOn = createdOn;
    }

    public long getUpdatedOn() {
      return updatedOn;
    }

    public void setUpdatedOn(long updatedOn) {
      this.updatedOn = updatedOn;
    }

    public long getTimeTakenToComplete() {
      return timeTakenToComplete;
    }

    public void setTimeTakenToComplete(long timeTakenToComplete) {
      this.timeTakenToComplete = timeTakenToComplete;
    }

    public long getRetriedCount() {
      return retriedCount;
    }

    public void setRetriedCount(long retriedCount) {
      this.retriedCount = retriedCount;
    }
  }

  public static class JobStatusDataRowMapper implements RowMapper<JobStatusData> {

    @Override
    public JobStatusData mapRow(ResultSet rs, int rowNum) throws SQLException {

      JobStatusData jobStatusData = new JobStatusData();
      jobStatusData.setJobId(rs.getLong("JOB_ID"));
      jobStatusData.setCreatedOn(rs.getDate("created_on").getTime());
      jobStatusData.setUpdatedOn(rs.getDate("updated_on").getTime());
      jobStatusData.setSubscriptionId(rs.getLong("subscription_id"));
      jobStatusData.setRequestId(rs.getString("request_id"));
      jobStatusData.setEntityIds(rs.getString("entity_ids"));
      jobStatusData.setMessage(rs.getString("message"));
      jobStatusData.setStatus(JobStatusData.Status.valueOf(rs.getString("status")));
      jobStatusData.setOperation(JobStatusData.Operation.valueOf(rs.getString("operation")));
      jobStatusData.setUserId(rs.getLong("user_id"));
      jobStatusData.setTimeTakenToComplete(rs.getLong("time_taken_to_Complete"));
      jobStatusData.setRetriedCount(rs.getLong("retried_count"));
      return jobStatusData;
    }
  }
}
