
package mersattech.barqexpdriver.Models.s.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("driveruserid")
    @Expose
    private Integer driveruserid;
    @SerializedName("isonline")
    @Expose
    private Integer isonline;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("OfflineStatusReasonText")
    @Expose
    private String offlineStatusReasonText;
    @SerializedName("DriverStatusIndicator")
    @Expose
    private Integer driverStatusIndicator;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getDriveruserid() {
        return driveruserid;
    }

    public void setDriveruserid(Integer driveruserid) {
        this.driveruserid = driveruserid;
    }

    public Integer getIsonline() {
        return isonline;
    }

    public void setIsonline(Integer isonline) {
        this.isonline = isonline;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getOfflineStatusReasonText() {
        return offlineStatusReasonText;
    }

    public void setOfflineStatusReasonText(String offlineStatusReasonText) {
        this.offlineStatusReasonText = offlineStatusReasonText;
    }

    public Integer getDriverStatusIndicator() {
        return driverStatusIndicator;
    }

    public void setDriverStatusIndicator(Integer driverStatusIndicator) {
        this.driverStatusIndicator = driverStatusIndicator;
    }

}
