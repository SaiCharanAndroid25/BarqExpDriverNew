
package mersattech.barqexpdriver.Models.s.otherutilitymodel.itemPickup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemPickupRequestBody {

    @SerializedName("ID")
    @Expose
    private int iD;
    @SerializedName("delivery_request_id")
    @Expose
    private int deliveryRequestId;
    @SerializedName("DeliveryOrderID")
    @Expose
    private int deliveryOrderId;

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public int getDeliveryRequestId() {
        return deliveryRequestId;
    }

    public void setDeliveryRequestId(int deliveryRequestId) {
        this.deliveryRequestId = deliveryRequestId;
    }

    public int getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public void setDeliveryOrderId(int deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }
}
