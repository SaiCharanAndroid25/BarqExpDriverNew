package mersattech.barqexpdriver.Activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mersattech.barqexpdriver.DemoPackage.DemoActivity;
import mersattech.barqexpdriver.Profile.ProfileFragment;
import mersattech.barqexpdriver.databinding.FragmentProfileeBinding;
import mersattech.barqexpdriver.R;



public class ProfileFragment1 extends Fragment {
    private FragmentProfileeBinding mFragmentProfile1Binding;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentProfile1Binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_profilee, container, false);

        return mFragmentProfile1Binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mFragmentProfile1Binding.id1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), DemoActivity.class);
                startActivity(i);
            }
        });
        mFragmentProfile1Binding.id2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent i = new Intent(getActivity(), ProfileFragment.class);
                startActivity(i);*/
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFragmentProfile1Binding.unbind();
    }
}
