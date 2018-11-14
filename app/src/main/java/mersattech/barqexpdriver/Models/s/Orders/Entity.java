
package mersattech.barqexpdriver.Models.s.Orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("ID")
    @Expose
    private int iD;
    @SerializedName("driveruserid")
    @Expose
    private Object driveruserid;
    @SerializedName("DeliveryOrderid")
    @Expose
    private int deliveryOrderid;
    @SerializedName("AssignmentStatusIndicator")
    @Expose
    private int assignmentStatusIndicator;
    @SerializedName("AssignmentRejectionReasonid")
    @Expose
    private Object assignmentRejectionReasonid;
    @SerializedName("Timer")
    @Expose
    private int timer;

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public Object getDriveruserid() {
        return driveruserid;
    }

    public void setDriveruserid(Object driveruserid) {
        this.driveruserid = driveruserid;
    }

    public int getDeliveryOrderid() {
        return deliveryOrderid;
    }

    public void setDeliveryOrderid(int deliveryOrderid) {
        this.deliveryOrderid = deliveryOrderid;
    }

    public int getAssignmentStatusIndicator() {
        return assignmentStatusIndicator;
    }

    public void setAssignmentStatusIndicator(int assignmentStatusIndicator) {
        this.assignmentStatusIndicator = assignmentStatusIndicator;
    }

    public Object getAssignmentRejectionReasonid() {
        return assignmentRejectionReasonid;
    }

    public void setAssignmentRejectionReasonid(Object assignmentRejectionReasonid) {
        this.assignmentRejectionReasonid = assignmentRejectionReasonid;
    }

}
