package mersattech.barqexpdriver.Models.s.ForgotPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgotPasswordRequestModel {

    @SerializedName("MobileNumber")
    @Expose
    private String mobileNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}
