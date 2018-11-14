
package mersattech.barqexpdriver.Models.s.Orderaccept;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppSettingEntity {

    @SerializedName("ID")
    @Expose
    private Long iD;
    @SerializedName("Code")
    @Expose
    private Long code;
    @SerializedName("DescriptionArabic")
    @Expose
    private String descriptionArabic;
    @SerializedName("DescriptionEnglish")
    @Expose
    private String descriptionEnglish;
    @SerializedName("Value")
    @Expose
    private Long value;

    public Long getID() {
        return iD;
    }

    public void setID(Long iD) {
        this.iD = iD;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDescriptionArabic() {
        return descriptionArabic;
    }

    public void setDescriptionArabic(String descriptionArabic) {
        this.descriptionArabic = descriptionArabic;
    }

    public String getDescriptionEnglish() {
        return descriptionEnglish;
    }

    public void setDescriptionEnglish(String descriptionEnglish) {
        this.descriptionEnglish = descriptionEnglish;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

}
