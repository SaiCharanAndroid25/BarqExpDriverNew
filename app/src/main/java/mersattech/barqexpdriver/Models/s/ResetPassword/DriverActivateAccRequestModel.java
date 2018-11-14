package mersattech.barqexpdriver.Models.s.ResetPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriverActivateAccRequestModel {

    @SerializedName("MobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("ActivationCode")
    @Expose
    private String activationCode;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }
}
