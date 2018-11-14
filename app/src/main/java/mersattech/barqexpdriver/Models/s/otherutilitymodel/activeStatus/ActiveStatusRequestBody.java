
package mersattech.barqexpdriver.Models.s.otherutilitymodel.activeStatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActiveStatusRequestBody {

    @SerializedName("driveruserid")
    @Expose
    private Integer driveruserid;
    @SerializedName("isonline")
    @Expose
    private Integer isonline;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ActiveStatusRequestBody() {
    }

    /**
     * 
     * @param driveruserid
     * @param isonline
     */
    public ActiveStatusRequestBody(Integer driveruserid, Integer isonline) {
        super();
        this.driveruserid = driveruserid;
        this.isonline = isonline;
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

}
