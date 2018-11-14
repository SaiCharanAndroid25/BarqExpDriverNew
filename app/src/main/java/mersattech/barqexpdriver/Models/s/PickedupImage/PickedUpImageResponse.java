
package mersattech.barqexpdriver.Models.s.PickedupImage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PickedUpImageResponse {

    @SerializedName("Details")
    @Expose
    private String details;
    @SerializedName("EnglishDetails")
    @Expose
    private String englishDetails;
    @SerializedName("List")
    @Expose
    private java.util.List<List> list = null;
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("EnglishMessage")
    @Expose
    private String englishMessage;
    @SerializedName("ItemCount")
    @Expose
    private Integer itemCount;
    @SerializedName("TotalPages")
    @Expose
    private Integer totalPages;

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
