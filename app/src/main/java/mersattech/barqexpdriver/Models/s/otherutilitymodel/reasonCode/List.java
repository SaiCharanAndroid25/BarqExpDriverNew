
package mersattech.barqexpdriver.Models.s.otherutilitymodel.reasonCode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("ReasonsCodeTypeid")
    @Expose
    private Integer reasonsCodeTypeid;
    @SerializedName("Reason")
    @Expose
    private String reason;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getReasonsCodeTypeid() {
        return reasonsCodeTypeid;
    }

    public void setReasonsCodeTypeid(Integer reasonsCodeTypeid) {
        this.reasonsCodeTypeid = reasonsCodeTypeid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
