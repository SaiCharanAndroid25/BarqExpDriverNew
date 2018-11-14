package mersattech.barqexpdriver.Adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import mersattech.barqexpdriver.databinding.HistoryParentItemBinding;
import mersattech.barqexpdriver.Models.s.HistoryPackage.List;
import mersattech.barqexpdriver.R;



/**
 * Created by praveendewangan on 01/12/17.
 * Adapter to show history data
 */

public class HistoryParentListAdapter extends RecyclerView.Adapter<HistoryParentListAdapter.Historyview> implements Filterable {

    private Context mContext;
    private java.util.List<List> mHistoryList;
    private java.util.List<List> mStringFilterList;
    private ValueFilter mValueFilter;

    public HistoryParentListAdapter(java.util.List<List> list) {

        mHistoryList = list;
        mStringFilterList = list;
    }

    @Override
    public Historyview onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        HistoryParentItemBinding historyParentItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.history_parent_item, parent, false);
        return new Historyview(historyParentItemBinding);
    }

    @Override
    public void onBindViewHolder(Historyview holder, int position) {
        List parentItem = mHistoryList.get(position);

        holder.mHistoryParentItemBinding.orderId.setText(String.format(mContext.getResources().getString(
                R.string.history_order_id), parentItem.getID()));

        String dateTime = parentItem.getCreatedDatetime();

        SimpleDateFormat formatter = getFormator();
        Date date = null;
        try {
            date = formatter.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat newFormat = getFormator();
        String finalString = newFormat.format(date);

        holder.mHistoryParentItemBinding.dateValTv.setText(finalString);
        holder.mHistoryParentItemBinding.drValTv.setText(String.valueOf(parentItem.getCreatedDatetime()));
        holder.mHistoryParentItemBinding.statusValTv.setText(parentItem.getOrderStatus());
        /*holder.mHistoryParentItemBinding.distanceValTv.setText(String.format(mContext.getResources().getString(
                R.string.order_distance), parentItem.getActualDistanceKm()));
        holder.mHistoryParentItemBinding.timeValTv.setText(String.format(mContext.getResources().getString(
                R.string.order_duration), parentItem.getActualDurationMin()));*/

      /*  if (parentItem.isIsCOD()) {
            holder.mHistoryParentItemBinding.codValTv.setText(String.format(mContext.getResources().getString(
                    R.string.cod_amount), parentItem.getCODValue()));
            holder.mHistoryParentItemBinding.codLayout.setVisibility(View.VISIBLE);
        } else {
            holder.mHistoryParentItemBinding.codLayout.setVisibility(View.GONE);
        }*/

       /* if (parentItem.getDeliveryRequest() == null) {
            holder.mHistoryParentItemBinding.expandArrow.setVisibility(View.GONE);
        } else {
            holder.mHistoryParentItemBinding.expandArrow.setVisibility(View.VISIBLE);
        }*/
    }

    private SimpleDateFormat getFormator() {
        SimpleDateFormat simpleDateFormat;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD",
                    Locale.getDefault(Locale.Category.FORMAT));
        } else {
            simpleDateFormat = new SimpleDateFormat("DD-MM-YYYY");
        }
        return simpleDateFormat;
    }

    @Override
    public int getItemCount() {
        return mHistoryList.size();
    }

    @Override
    public Filter getFilter() {
        if (mValueFilter == null) {
            mValueFilter = new ValueFilter();
        }
        return mValueFilter;
    }

    class Historyview extends RecyclerView.ViewHolder {
        HistoryParentItemBinding mHistoryParentItemBinding;

        Historyview(HistoryParentItemBinding itemView) {
            super(itemView.getRoot());
            this.mHistoryParentItemBinding = itemView;

            mHistoryParentItemBinding.expandArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mHistoryParentItemBinding.expandArrow.setVisibility(View.GONE);
                    mHistoryParentItemBinding.compressArrow.setVisibility(View.VISIBLE);
                    mHistoryParentItemBinding.rvChildHistoryList.setLayoutManager(new LinearLayoutManager(mContext));
                    HistoryChildListAdapter historyChildListAdapter = new HistoryChildListAdapter(
                            mHistoryList.get(getAdapterPosition()).getDeliveryRequestDetails());
                    mHistoryParentItemBinding.rvChildHistoryList.setAdapter(historyChildListAdapter);
                    mHistoryParentItemBinding.rvChildHistoryList.setVisibility(View.VISIBLE);
                }
            });

            mHistoryParentItemBinding.compressArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mHistoryParentItemBinding.compressArrow.setVisibility(View.GONE);
                    mHistoryParentItemBinding.expandArrow.setVisibility(View.VISIBLE);
                    mHistoryParentItemBinding.rvChildHistoryList.setVisibility(View.GONE);
                }
            });
        }
    }

    private class ValueFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                java.util.List<List> filterList = new ArrayList<>();
                for (int i = 0; i < mStringFilterList.size(); i++) {
                    String orderID = "" + mStringFilterList.get(i).getID();
                    // String status = "" + mStringFilterList.get(i).getStatusText().toLowerCase();
                   /* if (orderID.contains(constraint.toString().toLowerCase())) {
                        filterList.add(mStringFilterList.get(i));
                    } else if (status.contains(constraint.toString().toLowerCase())) {
                        filterList.add(mStringFilterList.get(i));
                    }*/
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mStringFilterList.size();
                results.values = mStringFilterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mHistoryList = (java.util.List<List>) results.values;
            notifyDataSetChanged();
        }
    }
}
