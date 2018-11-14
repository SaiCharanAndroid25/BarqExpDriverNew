
package mersattech.barqexpdriver.Models.s.Triptracking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TripTrackingRequestBody {


    @SerializedName("OrderTripSegmentID")
    @Expose
    private Integer orderTripSegmentID;
    @SerializedName("DriverLatitude")
    @Expose
    private String driverLatitude;
    @SerializedName("DriverLongitude")
    @Expose
    private String driverLongitude;



    public Integer getOrderTripSegmentID() {
        return orderTripSegmentID;
    }

    public void setOrderTripSegmentID(Integer orderTripSegmentID) {
        this.orderTripSegmentID = orderTripSegmentID;
    }

    public String getDriverLatitude() {
        return driverLatitude;
    }

    public void setDriverLatitude(String driverLatitude) {
        this.driverLatitude = driverLatitude;
    }

    public String getDriverLongitude() {
        return driverLongitude;
    }

    public void setDriverLongitude(String driverLongitude) {
        this.driverLongitude = driverLongitude;
    }


}
