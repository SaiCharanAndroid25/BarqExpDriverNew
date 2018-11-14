
package mersattech.barqexpdriver.Models.s.Orderdelivered;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryRequestDeliveredRequestBody {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("DeliveryStatusID")
    @Expose
    private Integer deliveryStatusID;
    @SerializedName("DeliveryOrderID")
    @Expose
    private Integer deliveryOrderID;

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

    public Integer getDeliveryOrderID() {
        return deliveryOrderID;
    }

    public void setDeliveryOrderID(Integer deliveryOrderID) {
        this.deliveryOrderID = deliveryOrderID;
    }

}
