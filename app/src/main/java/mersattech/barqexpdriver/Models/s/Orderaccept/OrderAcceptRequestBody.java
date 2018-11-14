
package mersattech.barqexpdriver.Models.s.Orderaccept;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderAcceptRequestBody {

    @SerializedName("DeliveryOrderid")
    @Expose
    private int deliveryOrderid;

    public int getDeliveryOrderid() {
        return deliveryOrderid;
    }

    public void setDeliveryOrderid(int deliveryOrderid) {
        this.deliveryOrderid = deliveryOrderid;
    }

}
