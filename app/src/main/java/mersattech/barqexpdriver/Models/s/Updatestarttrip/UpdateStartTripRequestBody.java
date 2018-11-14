
package mersattech.barqexpdriver.Models.s.Updatestarttrip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateStartTripRequestBody {

    @SerializedName("ID")
    @Expose
    private Integer iD;
//    @SerializedName("DeliveryRequestID")
//    @Expose
//    private Integer deliveryRequestID;
    @SerializedName("EstimatedTravelTime")
    @Expose
    private String estimatedTravelTime;
    @SerializedName("EstimatedDistance")
    @Expose
    private String estimatedDistance;
    @SerializedName("StartLocationLatitude")
    @Expose
    private String startLocationLatitude;
    @SerializedName("StartLocationLongitude")
    @Expose
    private String startLocationLongitude;


    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

//    public Integer getDeliveryRequestID() {
//        return deliveryRequestID;
//    }
//
//    public void setDeliveryRequestID(Integer deliveryRequestID) {
//        this.deliveryRequestID = deliveryRequestID;
//    }

    public String getEstimatedTravelTime() {
        return estimatedTravelTime;
    }

    public void setEstimatedTravelTime(String estimatedTravelTime) {
        this.estimatedTravelTime = estimatedTravelTime;
    }

    public String getEstimatedDistance() {
        return estimatedDistance;
    }

    public void setEstimatedDistance(String estimatedDistance) {
        this.estimatedDistance = estimatedDistance;
    }

    public String getStartLocationLatitude() {
        return startLocationLatitude;
    }

    public void setStartLocationLatitude(String startLocationLatitude) {
        this.startLocationLatitude = startLocationLatitude;
    }

    public String getStartLocationLongitude() {
        return startLocationLongitude;
    }

    public void setStartLocationLongitude(String startLocationLongitude) {
        this.startLocationLongitude = startLocationLongitude;
    }



}
