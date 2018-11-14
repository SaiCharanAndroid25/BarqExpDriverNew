
package mersattech.barqexpdriver.Models.s.Orders;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OderRejectRequestModel {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("DeliveryStatusID")
    @Expose
    private Integer deliveryStatusID;
    @SerializedName("CancelReasonID")
    @Expose
    private Integer cancelReasonID;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getDeliveryStatusID() {
        return deliveryStatusID;
    }

    public void setDeliveryStatusID(Integer deliveryStatusID) {
        this.deliveryStatusID = deliveryStatusID;
    }

    public Integer getCancelReasonID() {
        return cancelReasonID;
    }

    public void setCancelReasonID(Integer cancelReasonID) {
        this.cancelReasonID = cancelReasonID;
    }


}
