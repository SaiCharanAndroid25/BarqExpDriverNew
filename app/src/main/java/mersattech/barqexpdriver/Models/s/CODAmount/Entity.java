package mersattech.barqexpdriver.Models.s.CODAmount;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("TotalCOD")
    @Expose
    private Integer totalCOD;
    @SerializedName("TotalCollectedCOD")
    @Expose
    private Integer totalCollectedCOD;

    public Integer getTotalCOD() {
        return totalCOD;
    }

    public void setTotalCOD(Integer totalCOD) {
        this.totalCOD = totalCOD;
    }

    public Integer getTotalCollectedCOD() {
        return totalCollectedCOD;
    }

    public void setTotalCollectedCOD(Integer totalCollectedCOD) {
        this.totalCollectedCOD = totalCollectedCOD;
    }

}
