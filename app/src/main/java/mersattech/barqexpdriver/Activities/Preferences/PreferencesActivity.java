package mersattech.barqexpdriver.Activities.Preferences;

import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mersattech.barqexpdriver.Activities.BaseActivity;
import mersattech.barqexpdriver.Activities.HomeActivity;
import mersattech.barqexpdriver.Models.s.LoginModel.CityList;
import mersattech.barqexpdriver.Models.s.LoginModel.DriverRegistrationModel;
import mersattech.barqexpdriver.Models.s.LoginModel.FindCityResponseModel;
import mersattech.barqexpdriver.Models.s.LoginModel.LanguageUpdateRequestBody;
import mersattech.barqexpdriver.Models.s.ModifyPreference.ModifyPreferenceRequestBody;
import mersattech.barqexpdriver.Models.s.ModifyPreference.ModifyPreferenceResponseBody;
import mersattech.barqexpdriver.Models.s.Preferences.PreferenceResponseBody;
import mersattech.barqexpdriver.NetworkUtils.NetworkConstants;
import mersattech.barqexpdriver.NetworkUtils.NetworkUtils;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Utils.AppConstants;
import mersattech.barqexpdriver.Utils.AppPreferences;
import mersattech.barqexpdriver.Utils.DataUtils;
import mersattech.barqexpdriver.databinding.SettingsActivityBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PreferencesActivity extends BaseActivity {

    private SettingsActivityBinding mSettingsActivityBinding;
    private View.OnClickListener mOnClickListener;
    private int mLanguageSelected;
    private ProgressDialog mProgressDialog;
    private String lang_selected;
    private List<CityList> mAllCityList = new ArrayList<>();
    private List<String> mCitiesList = new ArrayList<>();
    private String mLocaleVal;
    private ArrayAdapter<String> mCitySpinnerAdapter;
    private int fromCity_Index;
    private int toCity_Index;
    private boolean noUpdateError = false;
    private boolean fromLogin;
    private String mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSettingsActivityBinding = DataBindingUtil.
                setContentView(this, R.layout.settings_activity);


        mAuth = AppPreferences.getAppPreferences(getApplicationContext()).getString(AppPreferences.TOKEN, "");

        mLanguageSelected = DataUtils.getInstance().getDefaultSharedPreferences(PreferencesActivity.this).
                getInt(AppConstants.LANGUAGE_SELECTED, 1);
        mLocaleVal = DataUtils.getLocale().getLanguage();

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.arabian_cb:
                    case R.id.arabic_lang_layout:
                        lang_selected = AppConstants.ARABIC_LANG;
                        mLanguageSelected = 2;
                        mSettingsActivityBinding.englishCb.setChecked(false);
                        mSettingsActivityBinding.arabianCb.setChecked(true);
                        break;

                    case R.id.english_cb:
                    case R.id.english_lang_layout:
                        mLanguageSelected = 1;
                        lang_selected = AppConstants.ENGLISH_LANG;
                        mSettingsActivityBinding.arabianCb.setChecked(false);
                        mSettingsActivityBinding.englishCb.setChecked(true);
                        break;

                    case R.id.back_icon:
                        onBackPressed();
                        break;

                    case R.id.save_btn:
                        if (mSettingsActivityBinding.preferTypeSpinner.getSelectedItem().toString().equals("Select")) {
                            noUpdateError = true;
                            Toast.makeText(PreferencesActivity.this, "Type of Service not selected", Toast.LENGTH_SHORT).show();
                        } else if (mSettingsActivityBinding.preferTypeSpinner.getSelectedItemPosition() == 1) {
                            if (mSettingsActivityBinding.preferCitySpinner.getSelectedItemPosition() == 0) {
                                Toast.makeText(PreferencesActivity.this, "Local City not selected", Toast.LENGTH_SHORT).show();

                                noUpdateError = true;
                            } else if (mSettingsActivityBinding.preferTimeFrom.getText() == null) {

                                noUpdateError = true;
                            } else if (mSettingsActivityBinding.preferTimeTo.getText() == null) {
                                noUpdateError = true;

                            }
                        } else if (mSettingsActivityBinding.preferTypeSpinner.getSelectedItemPosition() == 2) {
                            if (mSettingsActivityBinding.fromCityTrip.getSelectedItemPosition() == 0) {
                                Toast.makeText(PreferencesActivity.this, "From City not selected", Toast.LENGTH_SHORT).show();
                                noUpdateError = true;

                            } else if (mSettingsActivityBinding.toCityTrip.getSelectedItemPosition() == 0) {
                                Toast.makeText(PreferencesActivity.this, "To City not selected", Toast.LENGTH_SHORT).show();
                                noUpdateError = true;
                            } else if (mSettingsActivityBinding.preferTimeFrom.getText() == null) {
                                noUpdateError = true;
                            } else if (mSettingsActivityBinding.preferTimeTo.getText() == null) {
                                noUpdateError = true;
                            }
                        }

                        if (mSettingsActivityBinding.englishCb.isChecked()) {
                            mLanguageSelected = 1;
                            lang_selected = AppConstants.ENGLISH_LANG;

                        } else if (mSettingsActivityBinding.arabianCb.isChecked()) {
                            mLanguageSelected = 2;
                            lang_selected = AppConstants.ARABIC_LANG;
                        }
                        if (NetworkUtils.getInstance().isNetworkAvailable(PreferencesActivity.this)) {
                            if (!noUpdateError) {
                                mProgressDialog.dismiss();
//                            mProgressDialog = getProgressDialog(PreferencesActivity.this);
                                callUpdatePreferences();
                                callLanguageUpdateApi();
                            } else {
                                noUpdateError = false;
                            }

                        } else {
                            Toast.makeText(PreferencesActivity.this, getString(R.string.no_network_message), Toast.LENGTH_SHORT).show();
                        }

                        break;

                    case R.id.prefer_time_from:
                        TimePickerDialog timePickerDialogForFrom = new TimePickerDialog(PreferencesActivity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int i, int i1) {

                                mSettingsActivityBinding.preferTimeFrom.setText(new StringBuilder().append(pad(i))
                                        .append(":").append(pad(i1)));
                            }
                        }, 0, 0, true);
                        timePickerDialogForFrom.show();
                        break;
                    case R.id.prefer_time_to:
                        TimePickerDialog timePickerDialogForTo = new TimePickerDialog(PreferencesActivity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                                mSettingsActivityBinding.preferTimeTo.setText(new StringBuilder().append(pad(i))
                                        .append(":").append(pad(i1)));

                            }
                        }, 0, 0, true);
                        timePickerDialogForTo.show();

                        break;
                }
            }
        };

        initialiseViews();
        registerViewListeners();
    }

    private void callUpdatePreferences() {
        mProgressDialog = getProgressDialog(this);

        Call<ModifyPreferenceResponseBody> modifyPreferenceResponseBodyCall = NetworkUtils.
                getApiInterface().updatePreferences(/*getToken(this)*/"bearer "+mAuth, getupdateprefrequest());
        modifyPreferenceResponseBodyCall.enqueue(new Callback<ModifyPreferenceResponseBody>() {
            @Override
            public void onResponse(Call<ModifyPreferenceResponseBody> call, Response<ModifyPreferenceResponseBody> response) {
                ModifyPreferenceResponseBody modifyPreferenceResponseBody = response.body();
                if (modifyPreferenceResponseBody != null) {
                    mProgressDialog.dismiss();
                    switch (modifyPreferenceResponseBody.getStatus()) {
                        case 0:
                            mProgressDialog.dismiss();
                            Toast.makeText(PreferencesActivity.this, "Preferences Updated", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(PreferencesActivity.this, HomeActivity.class);
                            intent.putExtra(AppConstants.FROM_LOGIN, true);
                            startActivity(intent);
                            finish();
                            break;

                    }
                }
            }

            @Override
            public void onFailure(Call<ModifyPreferenceResponseBody> call, Throwable t) {
                mProgressDialog.dismiss();
            }
        });

    }

    private ModifyPreferenceRequestBody getupdateprefrequest() {
        ModifyPreferenceRequestBody modifyPreferenceRequestBody = new ModifyPreferenceRequestBody();
        modifyPreferenceRequestBody.setServiceTypeIndicator(mSettingsActivityBinding.preferTypeSpinner.getSelectedItemPosition());
        modifyPreferenceRequestBody.setAvailabilityFromTime(new StringBuilder().
                append(mSettingsActivityBinding.preferTimeFrom.getText()).append(":00").toString());
        modifyPreferenceRequestBody.setAvailabilityToTime(new StringBuilder().
                append(mSettingsActivityBinding.preferTimeTo.getText()).append(":00").toString());
        if (mSettingsActivityBinding.preferTypeSpinner.getSelectedItemPosition() == 1) {
            modifyPreferenceRequestBody.setLocalCityID(mAllCityList.get(mSettingsActivityBinding.
                    preferCitySpinner.getSelectedItemPosition()).getID());

        } else if (mSettingsActivityBinding.preferTypeSpinner.getSelectedItemPosition() == 2) {

            modifyPreferenceRequestBody.setDomesticFromCityID(mAllCityList.get(mSettingsActivityBinding.fromCityTrip
                    .getSelectedItemPosition()).getID());
            modifyPreferenceRequestBody.setDomesticToCityID(mAllCityList.get(mSettingsActivityBinding.toCityTrip
                    .getSelectedItemPosition()).getID());

        }
        return modifyPreferenceRequestBody;
    }

    private void callLanguageUpdateApi() {
        final SharedPreferences sharedPreferences = DataUtils.getInstance().getDefaultSharedPreferences(
                PreferencesActivity.this);

        retrofit2.Call<DriverRegistrationModel> languageUpdateCall = NetworkUtils.getApiInterface().setLanguagePref("bearer "+mAuth
               /* getToken(PreferencesActivity.this)*/, getRequestBody());

        languageUpdateCall.enqueue(new Callback<DriverRegistrationModel>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<DriverRegistrationModel> call,
                                   @NonNull Response<DriverRegistrationModel> response) {
                DriverRegistrationModel driverRegistrationModel = response.body();

                if (driverRegistrationModel != null) {
                    switch (driverRegistrationModel.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:
                            setLanguagePrefs(sharedPreferences.edit(), lang_selected);
                            SharedPreferences sharedPreferences = DataUtils.getInstance().getDefaultSharedPreferences(PreferencesActivity.this);
                            sharedPreferences.edit().putBoolean("Pref_Set", true).apply();
                            if (!fromLogin) {
                                Intent resultIntent = new Intent();
                                setResult(AppConstants.LANGUAGE_CHANGED, resultIntent);
                                finish();
                                break;
                            } else {
                                Intent intent = new Intent(PreferencesActivity.this, HomeActivity.class);
                                intent.putExtra(AppConstants.FROM_LOGIN, true);
                                startActivity(intent);
                                finish();
                            }

                        default:
                            showToastMessage(PreferencesActivity.this, driverRegistrationModel);
                            break;
                    }
                } else {
                    Toast.makeText(PreferencesActivity.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }

                mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(@NonNull retrofit2.Call<DriverRegistrationModel> call, @NonNull Throwable t) {
                Toast.makeText(PreferencesActivity.this, getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
                mProgressDialog.dismiss();
            }
        });
    }

    private LanguageUpdateRequestBody getRequestBody() {
        LanguageUpdateRequestBody requestBody = new LanguageUpdateRequestBody();
        requestBody.setLanguage(mLanguageSelected);
        return requestBody;
    }

    private void setLanguagePrefs(SharedPreferences.Editor editor, String lang_selected) {
        editor.putInt(AppConstants.LANGUAGE_SELECTED, mLanguageSelected);
        editor.putString(AppConstants.LANGUAGE_SELECTED_KEY, lang_selected);
        editor.apply();
    }

    private void initialiseViews() {
        mProgressDialog = getProgressDialog(PreferencesActivity.this);

        fromLogin = getIntent().getBooleanExtra(AppConstants.FROM_LOGIN, false);
        if (fromLogin) {
            setToolbar(mSettingsActivityBinding.toolbar, getString(R.string.settings_title), false);
        } else {
            setToolbar(mSettingsActivityBinding.toolbar, getString(R.string.settings_title), true);
        }
        switch (mLanguageSelected) {
            case 1:
                mSettingsActivityBinding.englishCb.setChecked(true);
                mSettingsActivityBinding.arabianCb.setChecked(false);
                break;

            case 2:
                mSettingsActivityBinding.englishCb.setChecked(false);
                mSettingsActivityBinding.arabianCb.setChecked(true);
                break;

            default:
                mSettingsActivityBinding.englishCb.setChecked(true);
                mSettingsActivityBinding.arabianCb.setChecked(false);
                break;
        }
        mCitySpinnerAdapter = setSpinnerAdapter(mCitiesList);
        getCityList();

    }


    private void registerViewListeners() {
        mSettingsActivityBinding.arabicLangLayout.setOnClickListener(mOnClickListener);
        mSettingsActivityBinding.englishLangLayout.setOnClickListener(mOnClickListener);
        mSettingsActivityBinding.toolbar.backIcon.setOnClickListener(mOnClickListener);
        mSettingsActivityBinding.saveBtn.setOnClickListener(mOnClickListener);
        mSettingsActivityBinding.preferTimeFrom.setOnClickListener(mOnClickListener);
        mSettingsActivityBinding.preferTimeTo.setOnClickListener(mOnClickListener);

        mSettingsActivityBinding.fromCityTrip.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                fromCity_Index = i;
                if (toCity_Index != 0) {
                    if (toCity_Index == fromCity_Index) {
                        Toast.makeText(PreferencesActivity.this, "Same city Routes can't be selected", Toast.LENGTH_LONG).show();
                        mSettingsActivityBinding.fromCityTrip.setSelection(0);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mSettingsActivityBinding.toCityTrip.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                toCity_Index = i;
                if (fromCity_Index != 0) {
                    if (toCity_Index == fromCity_Index) {
                        Toast.makeText(PreferencesActivity.this, "Same city Routes can't be selected", Toast.LENGTH_LONG).show();
                        mSettingsActivityBinding.toCityTrip.setSelection(0);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mSettingsActivityBinding.preferTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:

                        break;
                    case 1:
                        localViews();
                        break;
                    case 2:
                        domesticViews();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSettingsActivityBinding.unbind();
    }

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    private void getCityList() {

        {
            final int mCountryId =  getCountryId(this);
            Call<FindCityResponseModel> getCitiesListBYCountryId = NetworkUtils.getApiInterface().getCityListByCountryId("bearer "+mAuth
                    /*getToken(this)*/, mCountryId);

            getCitiesListBYCountryId.enqueue(new Callback<FindCityResponseModel>() {
                @Override
                public void onResponse(@NonNull Call<FindCityResponseModel> call, @NonNull Response<FindCityResponseModel> response) {
                    FindCityResponseModel findCityResponseModel = response.body();

                    if (findCityResponseModel != null) {
                        switch (findCityResponseModel.getStatus()) {
                            case NetworkConstants.RESPONSE_SUCCESS:
                                mAllCityList = findCityResponseModel.getList();
                                mCitiesList.clear();

                                for (int cityListIndex = 0; cityListIndex < mAllCityList.size(); cityListIndex++) {
                                    CityList cityList = findCityResponseModel.getList().get(cityListIndex);
                                    if (mLocaleVal.equals(AppConstants.ARABIC_LANG)) {
                                        mCitiesList.add(cityListIndex, cityList.getName());
                                    } else {
                                        mCitiesList.add(cityListIndex, cityList.getEnglishName());
                                    }
                                }

                                mAllCityList.add(0, getDefaultCityData(mCountryId));
                                if (mLocaleVal.equals(AppConstants.ARABIC_LANG)) {
                                    mCitiesList.add(0, getDefaultCityData(mCountryId).getName());
                                } else {
                                    mCitiesList.add(0, getDefaultCityData(mCountryId).getEnglishName());
                                }


                                mSettingsActivityBinding.toCityTrip.setAdapter(mCitySpinnerAdapter);
                                mSettingsActivityBinding.fromCityTrip.setAdapter(mCitySpinnerAdapter);
                                mSettingsActivityBinding.preferCitySpinner.setAdapter(mCitySpinnerAdapter);
                                if (!fromLogin) {
                                    intializeSpinner();
                                } else {
                                    mProgressDialog.dismiss();

                                }
                                break;


                        }
                    } else {
                        mProgressDialog.dismiss();
                        Toast.makeText(PreferencesActivity.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<FindCityResponseModel> call, @NonNull Throwable t) {
                    Toast.makeText(PreferencesActivity.this, getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
                    mProgressDialog.dismiss();
                }
            });
        }
    }

    private void intializeSpinner() {
        Call<PreferenceResponseBody> getDriverPreferences = NetworkUtils.getApiInterface().getPreferences(getToken(this));

        getDriverPreferences.enqueue(new Callback<PreferenceResponseBody>() {
            @Override
            public void onResponse(Call<PreferenceResponseBody> call, Response<PreferenceResponseBody> response) {
                PreferenceResponseBody preferenceResponseBody = response.body();
                if (preferenceResponseBody != null) {
                    switch (preferenceResponseBody.getStatus()) {
                        case 0:
                            mSettingsActivityBinding.preferTypeSpinner.setSelection(preferenceResponseBody.getEntity().getServiceTypeIndicator() != null ? preferenceResponseBody.getEntity().getServiceTypeIndicator() : 0);
                            if (preferenceResponseBody.getEntity().getServiceTypeIndicator() != null) {
                                if (preferenceResponseBody.getEntity().getServiceTypeIndicator() == 1)

                                {
                                    setIdToSpinnersforlocal(true, preferenceResponseBody);
                                } else if (preferenceResponseBody.getEntity().getServiceTypeIndicator() == 2) {
                                    setIdToSpinnersforlocal(false, preferenceResponseBody);
                                }
                            }
                    }
                    mProgressDialog.dismiss();

                } else {
                    mProgressDialog.dismiss();
                    Toast.makeText(PreferencesActivity.this, "No Repsonse from Driver Preference", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PreferenceResponseBody> call, Throwable t) {
                mProgressDialog.dismiss();

            }
        });

    }

    private void setIdToSpinnersforlocal(boolean b, PreferenceResponseBody preferenceResponseBody) {
        if (b) {
            localViews();
            int mcityIDIndex = 0;
            if (mAllCityList != null) {
                for (int i = 0; i < mAllCityList.size(); i++) {
                    if (preferenceResponseBody.getEntity().
                            getLocalCityID() == mAllCityList.get(i).getID()) {
                        mcityIDIndex = i;
                        break;
                    }

                }
            }
            mSettingsActivityBinding.preferCitySpinner.setSelection(mcityIDIndex);
            mSettingsActivityBinding.preferTimeFrom.setText(preferenceResponseBody.getEntity().
                    getAvailabilityFromTime().substring(0, 5));
            mSettingsActivityBinding.preferTimeTo.setText(preferenceResponseBody.getEntity().
                    getAvailabilityToTime().substring(0, 5));
            mProgressDialog.dismiss();
        } else {
            int mfromcityIDIndex = 0, mtocitylistindex = 0;
            if (mAllCityList != null) {
                for (int i = 0; i < mAllCityList.size(); i++) {
                    if (preferenceResponseBody.getEntity().
                            getDomesticFromCityID() == mAllCityList.get(i).getID()) {
                        mfromcityIDIndex = i;
                        break;

                    }
                }
                for (int i = 0; i < mAllCityList.size(); i++) {
                    if (preferenceResponseBody.getEntity().
                            getDomesticToCityID() == mAllCityList.get(i).getID()) {
                        mtocitylistindex = i;
                        break;
                    }

                }
            }
            domesticViews();
            mSettingsActivityBinding.toCityTrip.setSelection(mtocitylistindex);
            mSettingsActivityBinding.fromCityTrip.setSelection(mfromcityIDIndex);
            mSettingsActivityBinding.preferTimeFrom.setText(preferenceResponseBody.getEntity().
                    getAvailabilityFromTime().substring(0, 5));
            mSettingsActivityBinding.preferTimeTo.setText(preferenceResponseBody.getEntity().
                    getAvailabilityToTime().substring(0, 5));
            mProgressDialog.dismiss();


        }


    }

    private CityList getDefaultCityData(int countryId) {
        CityList defaultListItem =
                new CityList();
        defaultListItem.setID(0);
        defaultListItem.setName(getString(R.string.city));
        defaultListItem.setEnglishName(getString(R.string.city));
        defaultListItem.setCountryID(countryId);

        return defaultListItem;
    }

    private ArrayAdapter<String> setSpinnerAdapter(List<String> list) {
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return spinnerAdapter;
    }


    private void localViews() {
        mSettingsActivityBinding.cityOfPreferenceCard.setVisibility(View.VISIBLE);
        mSettingsActivityBinding.prefernceTripCard.setVisibility(View.GONE);
    }

    private void domesticViews() {
        mSettingsActivityBinding.cityOfPreferenceCard.setVisibility(View.GONE);
        mSettingsActivityBinding.prefernceTripCard.setVisibility(View.VISIBLE);

    }
}