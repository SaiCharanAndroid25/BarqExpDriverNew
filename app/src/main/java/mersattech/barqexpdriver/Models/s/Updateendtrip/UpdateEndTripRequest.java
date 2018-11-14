
package mersattech.barqexpdriver.Models.s.Updateendtrip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateEndTripRequest {

    @SerializedName("ID")
    @Expose
    private int iD;

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
