
package mersattech.barqexpdriver.Models.s.Driveractivestatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IsDriverActiveStatusRequest {

    @SerializedName("OfflineStatusReasonText")
    @Expose
    private String offlineStatusReasonText;
    @SerializedName("isonline")
    @Expose
    private int isonline;

    public String getOfflineStatusReasonText() {
        return offlineStatusReasonText;
    }

    public void setOfflineStatusReasonText(String offlineStatusReasonText) {
        this.offlineStatusReasonText = offlineStatusReasonText;
    }

    public int getIsonline() {
        return isonline;
    }

    public void setIsonline(int isonline) {
        this.isonline = isonline;
    }

}
