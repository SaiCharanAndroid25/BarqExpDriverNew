
package mersattech.barqexpdriver.Models.s.Itemdeliver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemDeliveredRequestbody {

    @SerializedName("ID")
    @Expose
    private Integer iD;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

}
