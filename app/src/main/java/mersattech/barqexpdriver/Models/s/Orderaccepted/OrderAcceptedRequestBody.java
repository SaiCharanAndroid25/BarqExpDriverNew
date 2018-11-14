
package mersattech.barqexpdriver.Models.s.Orderaccepted;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderAcceptedRequestBody {

    @SerializedName("driveruserid")
    @Expose
    private Integer driveruserid;
    @SerializedName("DeliveryOrderid")
    @Expose
    private Integer deliveryOrderid;

    public Integer getDriveruserid() {
        return driveruserid;
    }

    public void setDriveruserid(Integer driveruserid) {
        this.driveruserid = driveruserid;
    }

    public Integer getDeliveryOrderid() {
        return deliveryOrderid;
    }

    public void setDeliveryOrderid(Integer deliveryOrderid) {
        this.deliveryOrderid = deliveryOrderid;
    }

}
