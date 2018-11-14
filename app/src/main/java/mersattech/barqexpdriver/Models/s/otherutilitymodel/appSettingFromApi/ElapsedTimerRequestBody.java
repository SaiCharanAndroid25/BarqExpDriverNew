
package mersattech.barqexpdriver.Models.s.otherutilitymodel.appSettingFromApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ElapsedTimerRequestBody {

    @SerializedName("Driveruserid")
    @Expose
    private Integer driveruserid;
    @SerializedName("Deliveryorderid")
    @Expose
    private int deliveryorderid;

    public Integer getDriveruserid() {
        return driveruserid;
    }

    public void setDriveruserid(Integer driveruserid) {
        this.driveruserid = driveruserid;
    }

    public int getDeliveryorderid() {
        return deliveryorderid;
    }

    public void setDeliveryorderid(int deliveryorderid) {
        this.deliveryorderid = deliveryorderid;
    }

}
