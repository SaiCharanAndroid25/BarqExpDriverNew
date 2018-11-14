
package mersattech.barqexpdriver.Models.s.Driveractivestatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("ID")
    @Expose
    private int iD;
    @SerializedName("driveruserid")
    @Expose
    private Object driveruserid;
    @SerializedName("isonline")
    @Expose
    private Object isonline;
    @SerializedName("latitude")
    @Expose
    private Object latitude;
    @SerializedName("longitude")
    @Expose
    private Object longitude;
    @SerializedName("OfflineStatusReasonText")
    @Expose
    private Object offlineStatusReasonText;
    @SerializedName("DriverStatusIndicator")
    @Expose
    private Object driverStatusIndicator;

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public Object getDriveruserid() {
        return driveruserid;
    }

    public void setDriveruserid(Object driveruserid) {
        this.driveruserid = driveruserid;
    }

    public Object getIsonline() {
        return isonline;
    }

    public void setIsonline(Object isonline) {
        this.isonline = isonline;
    }

    public Object getLatitude() {
        return latitude;
    }

    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    public Object getOfflineStatusReasonText() {
        return offlineStatusReasonText;
    }

    public void setOfflineStatusReasonText(Object offlineStatusReasonText) {
        this.offlineStatusReasonText = offlineStatusReasonText;
    }

    public Object getDriverStatusIndicator() {
        return driverStatusIndicator;
    }

    public void setDriverStatusIndicator(Object driverStatusIndicator) {
        this.driverStatusIndicator = driverStatusIndicator;
    }

}
