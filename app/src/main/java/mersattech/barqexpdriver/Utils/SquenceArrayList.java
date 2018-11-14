package mersattech.barqexpdriver.Utils;

import mersattech.barqexpdriver.Models.s.OrderSequence.OrderSequenceResponseBody;

public class SquenceArrayList {
    private static final SquenceArrayList ourInstance = new SquenceArrayList();
    private OrderSequenceResponseBody orderSequenceResponseBody1 ;

    public OrderSequenceResponseBody getOrderSequenceResponseBody1() {
        return orderSequenceResponseBody1;
    }

    public void setOrderSequenceResponseBody1(OrderSequenceResponseBody orderSequenceResponseBody1) {
        this.orderSequenceResponseBody1 = orderSequenceResponseBody1;
    }


    public static SquenceArrayList getInstance() {
        return ourInstance;
    }

    private SquenceArrayList() {
    }
}
