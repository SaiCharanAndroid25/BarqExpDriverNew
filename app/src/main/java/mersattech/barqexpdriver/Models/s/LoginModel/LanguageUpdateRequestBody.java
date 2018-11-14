package mersattech.barqexpdriver.Models.s.LoginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LanguageUpdateRequestBody {

    @SerializedName("Language")
    @Expose
    private int language;

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

}
