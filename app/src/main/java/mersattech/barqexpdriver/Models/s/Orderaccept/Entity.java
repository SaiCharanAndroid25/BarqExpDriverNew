
package mersattech.barqexpdriver.Models.s.Orderaccept;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("ID")
    @Expose
    private Long iD;
    @SerializedName("driveruserid")
    @Expose
    private Long driveruserid;
    @SerializedName("DeliveryOrderid")
    @Expose
    private Long deliveryOrderid;
    @SerializedName("AssignmentStatusIndicator")
    @Expose
    private Long assignmentStatusIndicator;
    @SerializedName("AssignmentRejectionReasonid")
    @Expose
    private Long assignmentRejectionReasonid;
    @SerializedName("ResponseTime")
    @Expose
    private String responseTime;
    @SerializedName("AppSettingEntity")
    @Expose
    private AppSettingEntity appSettingEntity;

    public Long getID() {
        return iD;
    }

    public void setID(Long iD) {
        this.iD = iD;
    }

    public Long getDriveruserid() {
        return driveruserid;
    }

    public void setDriveruserid(Long driveruserid) {
        this.driveruserid = driveruserid;
    }

    public Long getDeliveryOrderid() {
        return deliveryOrderid;
    }

    public void setDeliveryOrderid(Long deliveryOrderid) {
        this.deliveryOrderid = deliveryOrderid;
    }

    public Long getAssignmentStatusIndicator() {
        return assignmentStatusIndicator;
    }

    public void setAssignmentStatusIndicator(Long assignmentStatusIndicator) {
        this.assignmentStatusIndicator = assignmentStatusIndicator;
    }

    public Long getAssignmentRejectionReasonid() {
        return assignmentRejectionReasonid;
    }

    public void setAssignmentRejectionReasonid(Long assignmentRejectionReasonid) {
        this.assignmentRejectionReasonid = assignmentRejectionReasonid;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public AppSettingEntity getAppSettingEntity() {
        return appSettingEntity;
    }

    public void setAppSettingEntity(AppSettingEntity appSettingEntity) {
        this.appSettingEntity = appSettingEntity;
    }

}
