package mersattech.barqexpdriver.Models.s.HistoryPackage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SenderAddress {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Phone")
    @Expose
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
