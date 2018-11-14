package mersattech.barqexpdriver.Adapters;

import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mersattech.barqexpdriver.Interfaces.OnProfileItemClickInterface;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.databinding.NavigationMenuItemsLayoutBinding;


/**
 * Created by Mersat-tech on 15/11/2017.
 * Navigation Menu adapter
 */

public class NavigationMenuBarAdapter extends RecyclerView.Adapter<NavigationMenuBarAdapter.MyViewHolder> {
    private String[] mMenuItemNameList;
    private TypedArray mMenuDrawableItems;
    private OnProfileItemClickInterface mOnProfileItemClickInterface;

    public NavigationMenuBarAdapter(String[] menuItemNameList, TypedArray typedArray,
                                    OnProfileItemClickInterface onProfileItemClickInterface) {
        this.mMenuItemNameList = menuItemNameList;
        this.mMenuDrawableItems = typedArray;
        this.mOnProfileItemClickInterface = onProfileItemClickInterface;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NavigationMenuItemsLayoutBinding menuItemsLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.navigation_menu_items_layout, parent, false);
        return new MyViewHolder(menuItemsLayoutBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mNavigationMenuItemsLayoutBinding.menuItemTitle.setText(mMenuItemNameList[position]);
        holder.mNavigationMenuItemsLayoutBinding.menuItemImg.setImageResource(
                mMenuDrawableItems.getResourceId(position, 0));
    }

    @Override
    public int getItemCount() {
        return mMenuItemNameList.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        NavigationMenuItemsLayoutBinding mNavigationMenuItemsLayoutBinding;

        MyViewHolder(NavigationMenuItemsLayoutBinding menuItemsLayoutBinding) {
            super(menuItemsLayoutBinding.getRoot());
            this.mNavigationMenuItemsLayoutBinding = menuItemsLayoutBinding;

            mNavigationMenuItemsLayoutBinding.navigationMenuParentLayout.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mOnProfileItemClickInterface.onProfileItemClickCallback(getAdapterPosition());
                        }
                    });
        }
    }
}
