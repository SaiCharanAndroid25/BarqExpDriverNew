package mersattech.barqexpdriver.Models.s.Updateendtrip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CancelDR {

    @SerializedName("ID")
    @Expose
    private int iD;
    @SerializedName("DeliveryRequestReturnReasonID")
    @Expose
    private int DeliveryRequestReturnReasonID;
    @SerializedName("EndLocationLatitude")
    @Expose
    private String endLocationLatitude;
    @SerializedName("EndLocationLongitude")
    @Expose
    private String endLocationLongitude;


    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public int getDeliveryRequestReturnReasonID() {
        return DeliveryRequestReturnReasonID;
    }

    public void setDeliveryRequestReturnReasonID(int DeliveryRequestReturnReasonID) {
        this.DeliveryRequestReturnReasonID = DeliveryRequestReturnReasonID;
    }

    public String getEndLocationLatitude() {
        return endLocationLatitude;
    }

    public void setEndLocationLatitude(String endLocationLatitude) {
        this.endLocationLatitude = endLocationLatitude;
    }

    public String getEndLocationLongitude() {
        return endLocationLongitude;
    }

    public void setEndLocationLongitude(String endLocationLongitude) {
        this.endLocationLongitude = endLocationLongitude;
    }

}
