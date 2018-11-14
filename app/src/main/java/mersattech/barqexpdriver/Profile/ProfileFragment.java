package mersattech.barqexpdriver.Profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.io.IOException;
import java.util.ArrayList;

import mersattech.barqexpdriver.Activities.HomeActivity;
import mersattech.barqexpdriver.Adapters.ProfileRecyclerGridAdapter;
import mersattech.barqexpdriver.Interfaces.OnProfileItemClickInterface;
import mersattech.barqexpdriver.Models.s.DriverProfile.DriverProfileResponse;
import mersattech.barqexpdriver.Models.s.Registration.Driverprofile.DriverProfileModel;
import mersattech.barqexpdriver.Models.s.Registration.Driverprofile.Entity;
import mersattech.barqexpdriver.Models.s.Registration.Driverprofile.GetDriverProfileResponse;
import mersattech.barqexpdriver.NetworkUtils.NetworkConstants;
import mersattech.barqexpdriver.NetworkUtils.NetworkUtils;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Utils.AppConstants;
import mersattech.barqexpdriver.Utils.AppPreferences;
import mersattech.barqexpdriver.Utils.DataUtils;
import mersattech.barqexpdriver.databinding.FragmentProfileBinding;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mersat-tech on 14/11/2017.
 * Profile fragment to show profile details.
 */

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding mFragmentProfileBinding;
    private String mProfileId;
    private DriverProfileResponse mGetDriverProfileResponse;
    private boolean isDriverDocs;
    SharedPreferences sharedpreferences;
    private String mAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentProfileBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_profile, container, false);

      /*  sharedpreferences = getSharedPreferences("MyPref",
                Context.MODE_PRIVATE);*/
        return mFragmentProfileBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAuth = AppPreferences.getAppPreferences(getActivity()).getString(AppPreferences.TOKEN, "");
        if (NetworkUtils.getInstance().isNetworkAvailable(getActivity())) {
            callGetProfileApi();
        } else {
            Toast.makeText(getActivity(), getString(R.string.no_network_message), Toast.LENGTH_SHORT).show();
        }
    }

    private void callGetProfileApi() {
        Call<DriverProfileResponse> getDriverProfileCall = NetworkUtils.
                getApiInterface()
                .getDRiverProfile(/*"bearer JMjlbNbiHztnFQXciRIsM00xQp9smCltKtQcqAs_44DszJ9W-0SewcHE1hIvUEbmctxXaHcSSXCpdQo3shkjglV-xK-SqWmYoiDUhHBx1rvexUj4Ug2YjLflBIFfXm92uzNiaD7a3md_j3NGejdwhqhGK9qzKnoIYb2m0MvOst30sqKjKGHRuVre4E1QFiXO5JLyCyX6ciMzmh5lqzoPRxjSIFX9RgbowaRrHnwqAUpxN_uYil_wZBLab7Wlti3g35L5n3AMn3rzRNn-2rViVRj537pnl18Vq4Qc8Q3rpP401Mfvhs9rMyvM3KBbuhwQgkYoHZDbmS2N72sEKEGZn7r6NnwwXAp7fCrZDnOFsV9lgbZAPSxUYrF3Jp7RkJJlHzzaSw6szDK10ogjwHiU6AWWlF1lJNovghVaIfQOnCYBBXZDRZXRp0AuYxLJcl-9zd03bOPKZLzVqkZPVp-LeA"
             */   "bearer "+mAuth);

        getDriverProfileCall.enqueue(new Callback<DriverProfileResponse>() {
            @Override
            public void onResponse(@NonNull Call<DriverProfileResponse> call,
                                   @NonNull Response<DriverProfileResponse> response) {
                mGetDriverProfileResponse = response.body();

                if (mGetDriverProfileResponse != null) {
                    switch (mGetDriverProfileResponse.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:
                            initialiseViews();
                            break;

                        default:
                            Toast.makeText(getActivity(), getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
                            break;
                    }
                } else {
                    Toast.makeText(getActivity(), getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<DriverProfileResponse> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initialiseViews() {

        if (getArguments() != null) {
            if (getArguments().getString("profileImageId") != null) {
                mProfileId = getArguments().getString("profileImageId");
            }
        }

        setProfilePic(true, mGetDriverProfileResponse.getEntity().getPhotographID());

        mFragmentProfileBinding.nameValue.setText(mGetDriverProfileResponse.getEntity().getName()/*String.valueOf(DataUtils.getInstance().getDefaultSharedPreferences(
                getActivity()).getString("name", ""))*/);
        mFragmentProfileBinding.phoneValue.setText(mGetDriverProfileResponse.getEntity().getMobileNumber());
     /*   mFragmentProfileBinding.addressValue.setText(mGetDriverProfileResponse.getEntity().getName()
                +mGetDriverProfileResponse.getEntity().getStreetName()
                +mGetDriverProfileResponse.getEntity().getBuildingNumber());*/

    }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = DataUtils.getInstance().getDefaultSharedPreferences(getActivity());
        if (sharedPreferences.getString("profileImageId", null) != null) {
            mProfileId = sharedPreferences.getString("profileImageId", null);
        }

        if (isDriverDocs) {
            isDriverDocs = false;
            setProfilePic(false, "");
        }
    }

    private void setProfilePic(boolean isFromServer, String photoId) {
        Call<ResponseBody> getProfilePic;
        if (isFromServer) {
            getProfilePic = NetworkUtils.getApiInterface().getImage(photoId);
        } else {
            getProfilePic = NetworkUtils.getApiInterface().getImage(mProfileId);
        }
        getProfilePic.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call,
                                   @NonNull Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        byte[] bytes = response.body().bytes();
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        mFragmentProfileBinding.profilePic.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), getString(R.string.image_loading_fail_msg), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFragmentProfileBinding.unbind();
    }
}
