package mersattech.barqexpdriver.Models.s.LoginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DriverRegistrationModel {

    @SerializedName("Entity")
    @Expose
    private Entity entity;
    @SerializedName("Details")
    @Expose
    private Object details;
    @SerializedName("EnglishDetails")
    @Expose
    private Object englishDetails;
    @SerializedName("Status")
    @Expose
    private int status;
    @SerializedName("Message")
    @Expose
    private Object message;
    @SerializedName("EnglishMessage")
    @Expose
    private Object englishMessage;
    @SerializedName("ParameterList")
    @Expose
    private List<Object> parameterList = null;

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public Object getEnglishDetails() {
        return englishDetails;
    }

    public void setEnglishDetails(Object englishDetails) {
        this.englishDetails = englishDetails;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getEnglishMessage() {
        return englishMessage;
    }

    public void setEnglishMessage(Object englishMessage) {
        this.englishMessage = englishMessage;
    }

    public List<Object> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<Object> parameterList) {
        this.parameterList = parameterList;
    }
}
