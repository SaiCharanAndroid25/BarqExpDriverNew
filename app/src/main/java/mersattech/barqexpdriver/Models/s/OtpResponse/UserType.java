package mersattech.barqexpdriver.Models.s.OtpResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserType {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Code")
    @Expose
    private Object code;
    @SerializedName("Name")
    @Expose
    private Object name;
    @SerializedName("EnglishName")
    @Expose
    private Object englishName;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getEnglishName() {
        return englishName;
    }

    public void setEnglishName(Object englishName) {
        this.englishName = englishName;
    }
}
