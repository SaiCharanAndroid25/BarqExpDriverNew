package mersattech.barqexpdriver.Models.s.LoginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriverLoginRequestModel {

    @SerializedName("MobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("Password")
    @Expose
    private String password;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
