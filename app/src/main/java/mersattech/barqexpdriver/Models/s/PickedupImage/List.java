
package mersattech.barqexpdriver.Models.s.PickedupImage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("delivery_item_image_stream_id")
    @Expose
    private String deliveryItemImageStreamId;

    public String getDeliveryItemImageStreamId() {
        return deliveryItemImageStreamId;
    }

    public void setDeliveryItemImageStreamId(String deliveryItemImageStreamId) {
        this.deliveryItemImageStreamId = deliveryItemImageStreamId;
    }

}
