
package mersattech.barqexpdriver.Models.s.otherutilitymodel.imageUpload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("ID")
    @Expose
    private int iD;
    @SerializedName("ImageName")
    @Expose
    private Object imageName;
    @SerializedName("delivery_request_id")
    @Expose
    private int deliveryRequestId;
    @SerializedName("delivery_item_image_stream_id")
    @Expose
    private Object deliveryItemImageStreamId;
    @SerializedName("delivery_request_item_id")
    @Expose
    private int deliveryRequestItemId;
    @SerializedName("StreamID")
    @Expose
    private String streamID;
    @SerializedName("DeliveryItemImage")
    @Expose
    private Object deliveryItemImage;

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public Object getImageName() {
        return imageName;
    }

    public void setImageName(Object imageName) {
        this.imageName = imageName;
    }

    public int getDeliveryRequestId() {
        return deliveryRequestId;
    }

    public void setDeliveryRequestId(int deliveryRequestId) {
        this.deliveryRequestId = deliveryRequestId;
    }

    public Object getDeliveryItemImageStreamId() {
        return deliveryItemImageStreamId;
    }

    public void setDeliveryItemImageStreamId(Object deliveryItemImageStreamId) {
        this.deliveryItemImageStreamId = deliveryItemImageStreamId;
    }

    public int getDeliveryRequestItemId() {
        return deliveryRequestItemId;
    }

    public void setDeliveryRequestItemId(int deliveryRequestItemId) {
        this.deliveryRequestItemId = deliveryRequestItemId;
    }

    public String getStreamID() {
        return streamID;
    }

    public void setStreamID(String streamID) {
        this.streamID = streamID;
    }

    public Object getDeliveryItemImage() {
        return deliveryItemImage;
    }

    public void setDeliveryItemImage(Object deliveryItemImage) {
        this.deliveryItemImage = deliveryItemImage;
    }

}
