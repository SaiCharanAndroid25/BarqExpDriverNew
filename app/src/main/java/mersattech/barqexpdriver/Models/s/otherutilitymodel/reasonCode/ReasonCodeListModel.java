
package mersattech.barqexpdriver.Models.s.otherutilitymodel.reasonCode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReasonCodeListModel {

    @SerializedName("Details")
    @Expose
    private Object details;
    @SerializedName("EnglishDetails")
    @Expose
    private Object englishDetails;
    @SerializedName("List")
    @Expose
    private java.util.List<List> list = null;
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("Message")
    @Expose
    private Object message;
    @SerializedName("EnglishMessage")
    @Expose
    private Object englishMessage;
    @SerializedName("ItemCount")
    @Expose
    private Integer itemCount;
    @SerializedName("TotalPages")
    @Expose
    private Integer totalPages;

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

    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

}
