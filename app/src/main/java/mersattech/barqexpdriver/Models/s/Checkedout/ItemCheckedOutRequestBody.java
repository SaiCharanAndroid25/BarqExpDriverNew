package mersattech.barqexpdriver.Models.s.Checkedout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemCheckedOutRequestBody {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("DRInventoryStatusID")
    @Expose
    private Integer dRInventoryStatusID;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getDRInventoryStatusID() {
        return dRInventoryStatusID;
    }

    public void setDRInventoryStatusID(Integer dRInventoryStatusID) {
        this.dRInventoryStatusID = dRInventoryStatusID;
    }

}
