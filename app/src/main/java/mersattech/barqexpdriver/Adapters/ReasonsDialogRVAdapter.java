package mersattech.barqexpdriver.Adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mersattech.barqexpdriver.Interfaces.ReasonsSelected;
import mersattech.barqexpdriver.Models.s.Reasonmodel.ReasonsModel;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.databinding.ReasonsDialogItemLayoutBinding;

/**
 * Created by Mersat-tech on 17/11/2017.
 * reasons adapter
 */

public class ReasonsDialogRVAdapter extends RecyclerView.Adapter<ReasonsDialogRVAdapter.MyViewHolder> {

    private ArrayList<ReasonsModel> mReasonsList;
    private ReasonsSelected reasonsSelected;

    public ReasonsDialogRVAdapter(ArrayList<ReasonsModel> reasonsList, ReasonsSelected reasonsSelected) {
        mReasonsList = reasonsList;
        this.reasonsSelected = reasonsSelected;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ReasonsDialogItemLayoutBinding reasonsDialogItemLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.reasons_dialog_item_layout, parent, false);

        return new MyViewHolder(reasonsDialogItemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.mReasonsDialogItemLayoutBinding.radiobtn.setText(
                mReasonsList.get(holder.getAdapterPosition()).getmReason());

        if (mReasonsList.get(holder.getAdapterPosition()).ismStatus()) {
            holder.mReasonsDialogItemLayoutBinding.radiobtn.setChecked(true);
        } else {
            holder.mReasonsDialogItemLayoutBinding.radiobtn.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return mReasonsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ReasonsDialogItemLayoutBinding mReasonsDialogItemLayoutBinding;

        MyViewHolder(ReasonsDialogItemLayoutBinding reasonsDialogItemLayoutBinding) {
            super(reasonsDialogItemLayoutBinding.getRoot());
            this.mReasonsDialogItemLayoutBinding = reasonsDialogItemLayoutBinding;

            mReasonsDialogItemLayoutBinding.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!mReasonsList.get(getAdapterPosition()).ismStatus()) {
                        for (int reasonlist = 0; reasonlist < mReasonsList.size(); reasonlist++) {
                            mReasonsList.get(reasonlist).setmStatus(false);
                        }
                        mReasonsList.get(getAdapterPosition()).setmStatus(true);

                        reasonsSelected.onReasonSelected(null, getAdapterPosition(), "");
                        notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
