
package mersattech.barqexpdriver.Models.s.otherutilitymodel.appSettingFromApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("driveruserid")
    @Expose
    private Object driveruserid;
    @SerializedName("DeliveryOrderid")
    @Expose
    private Object deliveryOrderid;
    @SerializedName("AssignmentStatusIndicator")
    @Expose
    private Object assignmentStatusIndicator;
    @SerializedName("AssignmentRejectionReasonid")
    @Expose
    private Object assignmentRejectionReasonid;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Object getDriveruserid() {
        return driveruserid;
    }

    public void setDriveruserid(Object driveruserid) {
        this.driveruserid = driveruserid;
    }

    public Object getDeliveryOrderid() {
        return deliveryOrderid;
    }

    public void setDeliveryOrderid(Object deliveryOrderid) {
        this.deliveryOrderid = deliveryOrderid;
    }

    public Object getAssignmentStatusIndicator() {
        return assignmentStatusIndicator;
    }

    public void setAssignmentStatusIndicator(Object assignmentStatusIndicator) {
        this.assignmentStatusIndicator = assignmentStatusIndicator;
    }

    public Object getAssignmentRejectionReasonid() {
        return assignmentRejectionReasonid;
    }

    public void setAssignmentRejectionReasonid(Object assignmentRejectionReasonid) {
        this.assignmentRejectionReasonid = assignmentRejectionReasonid;
    }

}
