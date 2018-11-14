
package mersattech.barqexpdriver.Models.s.OrderSequence;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderSequenceResponseBody {

    @SerializedName("Entity")
    @Expose
    private Entity entity;
    @SerializedName("Details")
    @Expose
    private String details;
    @SerializedName("EnglishDetails")
    @Expose
    private String englishDetails;
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("EnglishMessage")
    @Expose
    private String englishMessage;
    @SerializedName("ParameterList")
    @Expose
    private List<Object> parameterList = null;

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getEnglishDetails() {
        return englishDetails;
    }

    public void setEnglishDetails(String englishDetails) {
        this.englishDetails = englishDetails;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEnglishMessage() {
        return englishMessage;
    }

    public void setEnglishMessage(String englishMessage) {
        this.englishMessage = englishMessage;
    }

    public List<Object> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<Object> parameterList) {
        this.parameterList = parameterList;
    }

}
