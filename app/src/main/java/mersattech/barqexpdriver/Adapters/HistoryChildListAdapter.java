package mersattech.barqexpdriver.Adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import mersattech.barqexpdriver.Models.s.HistoryPackage.DeliveryRequestDetail;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.databinding.HistoryChildItemBinding;


/**
 * Created by Mersat-tech on 19-12-2017.
 * Adapter to show history data
 */

public class HistoryChildListAdapter extends RecyclerView.Adapter<HistoryChildListAdapter.Historyview> {

    private Context mContext;
    private List<DeliveryRequestDetail> mDeliveryRequest;
    private int lastPos;

    HistoryChildListAdapter(List<DeliveryRequestDetail> deliveryRequest) {
        mDeliveryRequest = deliveryRequest;
        try {
            this.lastPos = mDeliveryRequest.size();
        }catch(Exception e){

        }
        lastPos = --lastPos;
    }

    @Override
    public Historyview onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        HistoryChildItemBinding historyParentItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.history_child_item, parent, false);
        return new Historyview(historyParentItemBinding);
    }

    @Override
    public void onBindViewHolder(Historyview holder, int position) {
        if (position == lastPos) {
            holder.mHistoryChildItemBinding.viewSeparator.setVisibility(View.GONE);
        }
        DeliveryRequestDetail childItem = mDeliveryRequest.get(position);

        holder.mHistoryChildItemBinding.oderIdTv.setText(String.format(mContext.getResources().getString(
                R.string.history_dr_id), childItem.getID()));

        holder.mHistoryChildItemBinding.statusValTv.setText(childItem.getStatus());
        holder.mHistoryChildItemBinding.companyNameValTv.setText(childItem.getSenderAddress().getName());
       /* if (childItem.isIsCOD()) {
            holder.mHistoryChildItemBinding.codValTv.setText(String.format(mContext.getResources().getString(
                    R.string.cod_amount), childItem.getCODValue()));
            holder.mHistoryChildItemBinding.codLayout.setVisibility(View.VISIBLE);
        } else {
            holder.mHistoryChildItemBinding.codLayout.setVisibility(View.GONE);
        }*/
    }

    @Override
    public int getItemCount() {
        try {
            return mDeliveryRequest.size();
        }catch(Exception e){

        }
        return 0;
    }

    class Historyview extends RecyclerView.ViewHolder {
        HistoryChildItemBinding mHistoryChildItemBinding;

        Historyview(HistoryChildItemBinding itemView) {
            super(itemView.getRoot());
            mHistoryChildItemBinding = itemView;
        }
    }
}
