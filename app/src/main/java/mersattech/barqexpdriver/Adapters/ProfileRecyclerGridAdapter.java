package mersattech.barqexpdriver.Adapters;

import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mersattech.barqexpdriver.Interfaces.OnProfileItemClickInterface;
import mersattech.barqexpdriver.Models.s.Registration.Driverprofile.DriverProfileModel;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.databinding.LayoutProfileGridItemsBinding;


/**
 * Created by Mersat-tech on 14/11/2017.
 * to display profile tabs
 */

public class ProfileRecyclerGridAdapter extends RecyclerView.Adapter<ProfileRecyclerGridAdapter.MyViewHolder> {
    private ArrayList<DriverProfileModel> mProfileScreens;
    private TypedArray mDrawablesArray;
    private OnProfileItemClickInterface onProfileItemClickInterface;
    public ProfileRecyclerGridAdapter(ArrayList<DriverProfileModel> profileScreens, TypedArray intArray,
                                      OnProfileItemClickInterface onProfileItemClickInterface) {

        this.mProfileScreens = profileScreens;
        this.mDrawablesArray = intArray;
        this.onProfileItemClickInterface = onProfileItemClickInterface;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutProfileGridItemsBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.layout_profile_grid_items, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.layoutProfileGridItemsBinding.profileItemDiscription.setText(mProfileScreens.get(position).getCategoryName());

        holder.layoutProfileGridItemsBinding.profileDetailsImage.setImageResource(
                mDrawablesArray.getResourceId(position, 0));


        //Todo - Have to change the condition according to the response from service
        if (mProfileScreens.get(position).isStatus()) {

            holder.layoutProfileGridItemsBinding.status.setImageResource(R.drawable.ic_check_circle);
            holder.layoutProfileGridItemsBinding.status.onRtlPropertiesChanged(View.LAYOUT_DIRECTION_LTR);

        } else {
            holder.layoutProfileGridItemsBinding.status.setImageResource(R.drawable.ic_error);
        }
    }

    @Override
    public int getItemCount() {
        return mProfileScreens.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        LayoutProfileGridItemsBinding layoutProfileGridItemsBinding;

        MyViewHolder(LayoutProfileGridItemsBinding itemsBinding) {
            super(itemsBinding.getRoot());
            this.layoutProfileGridItemsBinding = itemsBinding;

            layoutProfileGridItemsBinding.parentCv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onProfileItemClickInterface.onProfileItemClickCallback(getAdapterPosition());
                }
            });
        }
    }

}
