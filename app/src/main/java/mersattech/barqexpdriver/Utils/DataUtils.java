package mersattech.barqexpdriver.Utils;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;

import com.github.msarhan.ummalqura.calendar.UmmalquraCalendar;

import net.alhazmy13.hijridatepicker.date.hijri.HijriDatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import mersattech.barqexpdriver.Adapters.ReasonsDialogRVAdapter;
import mersattech.barqexpdriver.Interfaces.ReasonsSelected;
import mersattech.barqexpdriver.Models.s.Reasonmodel.ReasonsModel;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.databinding.ReasonsDialogLayoutBinding;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataUtils {

    public static DataUtils sDataUtils;
    public static Locale myLocale;//Set Selected Locale
    public static ProgressDialog sProgressDialog;
    public static Retrofit sRetrofit;
    private int mReasonSelectedPosition;

    public static DataUtils getInstance() {
        if (sDataUtils != null) {
            return sDataUtils;
        }

        return new DataUtils();

    }

    /**
     * Returns the name used for storing default shared preferences.
     *
     * @see #getDefaultSharedPreferences(Context)
     */
    public static String getDefaultSharedPreferencesName(Context context) {
        return context.getPackageName() + "_preferences";
    }

    private static int getDefaultSharedPreferencesMode() {
        return Context.MODE_PRIVATE;
    }

    public static void setLocale(Context context, String lang_selected) {
        myLocale = getLocale();
        if (getLocale() == null || !myLocale.equals(new Locale(lang_selected))) {
            myLocale = new Locale(lang_selected);
            Locale.setDefault(myLocale);//set new locale as default
            Configuration config = new Configuration();//get Configuration
            config.locale = myLocale;//set config locale as selected locale
            context.getResources().updateConfiguration(config,
                    context.getResources().getDisplayMetrics());//Update the config
        }
    }

    public static Locale getLocale() {
        return myLocale;
    }

    public static ProgressDialog getsProgressDialog(Context context) {
        if (sProgressDialog == null) {
            sProgressDialog = new ProgressDialog(context);
            sProgressDialog.setMessage("Loading..."); // Setting Message
            sProgressDialog.setTitle("ProgressDialog"); // Setting Title
            sProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
            sProgressDialog.show(); // Display Progress Dialog
            sProgressDialog.setCancelable(false);
        }
        return sProgressDialog;
    }

    public static Retrofit getRetrofit() {

        if (sRetrofit == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            Retrofit.Builder builder =
                    new Retrofit.Builder().baseUrl("").addConverterFactory(
                            GsonConverterFactory.create());

            sRetrofit = builder.client(httpClient.build()).build();
        }

        return sRetrofit;

//        GitHubClient client =  retrofit.create(GitHubClient.class);
    }

    public boolean phoneNumberCheck(String value) {
        return value.length() == 10;
    }

    public boolean emailValidation(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }

    public DatePickerDialog showCalendarView(Context context, final EditText editText) {
        String date = editText.getText().toString().trim();
        String[] separated = date.split("-");

        Calendar newCalendar = Calendar.getInstance();

        if (!TextUtils.isEmpty(date)) {
            newCalendar.set(Calendar.YEAR, Integer.parseInt(separated[2]));
            newCalendar.set(Calendar.MONTH, Integer.parseInt(separated[1]) - 1);
            newCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(separated[0]));
        }


        DatePickerDialog fromDatePickerDialog = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault());

                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear++, dayOfMonth);
                        editText.setText("" + dayOfMonth + "-" + monthOfYear + "-" + year);
                    }

                }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        return fromDatePickerDialog;

    }

    public HijriDatePickerDialog showHijriCalendar(Context context, final EditText editText, final Locale locale) {
        String date = editText.getText().toString().trim();
        String[] separated = date.split("-");

        UmmalquraCalendar newCalendar = new UmmalquraCalendar();

        if (!TextUtils.isEmpty(date)) {
            newCalendar.set(Calendar.YEAR, Integer.parseInt(separated[2]));
            newCalendar.set(Calendar.MONTH, Integer.parseInt(separated[1]));
            newCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(separated[0]));
        }


        HijriDatePickerDialog fromDatePickerDialog = HijriDatePickerDialog.newInstance(
                new HijriDatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(HijriDatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
//                        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy", locale);
/*
                        UmmalquraCalendar newDate = new UmmalquraCalendar();
                        newDate.set(year, monthOfYear, dayOfMonth);*/
                        String newDate = "" + dayOfMonth + "-" + monthOfYear + "-" + year;
                        editText.setText(newDate);
                    }
                }, newCalendar.get(UmmalquraCalendar.YEAR), newCalendar.get(UmmalquraCalendar.MONTH),
                newCalendar.get(UmmalquraCalendar.DAY_OF_MONTH));
        return fromDatePickerDialog;
    }

    /**
     * Gets a SharedPreferences instance that points to the default file that is
     * used by the preference framework in the given context.
     *
     * @param context The context of the preferences whose values are wanted.
     * @return A SharedPreferences instance that can be used to retrieve and
     * listen to values of the preferences.
     */
    public SharedPreferences getDefaultSharedPreferences(Context context) {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context),
                getDefaultSharedPreferencesMode());
    }

    public void dateConvertor(EditText editText, boolean isHijri) {

        String date = editText.getText().toString().trim();

        String[] separated = date.split("-");

        if (!TextUtils.isEmpty(date)) {
            if (isHijri) {
                GregorianCalendar gCal = new GregorianCalendar(Integer.parseInt(separated[2]),
                        Integer.parseInt(separated[1]) - 1, Integer.parseInt(separated[0]));

                UmmalquraCalendar uCal = new UmmalquraCalendar();
                uCal.setTime(gCal.getTime());

                String uDate = "" + uCal.get(UmmalquraCalendar.DAY_OF_MONTH) + "-" +
                        uCal.get(UmmalquraCalendar.MONTH) + "-" + uCal.get(UmmalquraCalendar.YEAR);
                editText.setGravity(Gravity.RIGHT);
                editText.setText(uDate);

            } else {
                UmmalquraCalendar uCal = new UmmalquraCalendar(Integer.parseInt(separated[2]),
                        Integer.parseInt(separated[1]), Integer.parseInt(separated[0]));

                GregorianCalendar gCal = new GregorianCalendar();
                gCal.setTime(uCal.getTime());

                String gDate = "" + gCal.get(GregorianCalendar.DAY_OF_MONTH) + "-" +
                        (gCal.get(GregorianCalendar.MONTH) + 1) + "-" + gCal.get(GregorianCalendar.YEAR);
                editText.setGravity(Gravity.LEFT);
                editText.setText(gDate);
            }
        }

    }

    public String dateConvertorForRequest(String date, boolean isHijri) {

        String[] separated = date.split("-");

        if (!TextUtils.isEmpty(date)) {
            if (isHijri) {
                GregorianCalendar gCal = new GregorianCalendar(Integer.parseInt(separated[2]),
                        Integer.parseInt(separated[1]) - 1, Integer.parseInt(separated[0]));

                UmmalquraCalendar uCal = new UmmalquraCalendar();
                uCal.setTime(gCal.getTime());

                String uDate = "" + uCal.get(UmmalquraCalendar.DAY_OF_MONTH) + "/" +
                        uCal.get(UmmalquraCalendar.MONTH) + "/" + uCal.get(UmmalquraCalendar.YEAR);
                return uDate;

            } else {
                UmmalquraCalendar uCal = new UmmalquraCalendar(Integer.parseInt(separated[2]),
                        Integer.parseInt(separated[1]), Integer.parseInt(separated[0]));

                GregorianCalendar gCal = new GregorianCalendar();
                gCal.setTime(uCal.getTime());

                String gDate = "" + gCal.get(GregorianCalendar.YEAR) + "-" +
                        (gCal.get(GregorianCalendar.MONTH) + 1) + "-" + gCal.get(GregorianCalendar.DAY_OF_MONTH);
                return gDate;
            }
        }

        return date;

    }


    public Dialog getReasonsDialog(Context context, String dialogTitle,
                                   final ArrayList<ReasonsModel> reasonsList, final ReasonsSelected reasonsSelected) {

        final Dialog dialog = new Dialog(context);
        mReasonSelectedPosition = -1;
        int listSize = reasonsList.size();
        final int lastPos = --listSize;

        final ReasonsDialogLayoutBinding reasonsDialogLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.reasons_dialog_layout, null, false);
        dialog.setContentView(reasonsDialogLayoutBinding.getRoot());

        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount = 0.6f; // Dim level. 0.0 - no dim, 1.0 - completely opaque
        dialog.getWindow().setAttributes(lp);

        reasonsDialogLayoutBinding.dialogTitleTv.setText(dialogTitle);
        reasonsDialogLayoutBinding.reasonsRcv.setLayoutManager(new LinearLayoutManager(context));

        ReasonsDialogRVAdapter reasonsDialogRVAdapter = new ReasonsDialogRVAdapter(reasonsList, new ReasonsSelected() {
            @Override
            public void onReasonSelected(Dialog dialog, int position, String s) {
                mReasonSelectedPosition = position;
            }

            @Override
            public void onDismiss(Dialog dialog) {

            }
        });
        reasonsDialogLayoutBinding.reasonsRcv.setAdapter(reasonsDialogRVAdapter);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.dismiss_btn:
                        reasonsSelected.onDismiss(dialog);
                        break;

                    case R.id.confirm_cancellation_btn:
                        if (mReasonSelectedPosition == lastPos) {
                            reasonsDialogLayoutBinding.reasonsRcv.setVisibility(View.GONE);
                            reasonsDialogLayoutBinding.bottomButtonLayout.setVisibility(View.GONE);
                            reasonsDialogLayoutBinding.otherResaonsLayout.setVisibility(View.VISIBLE);
                            reasonsDialogLayoutBinding.reasonEt.requestFocus();
                        } else {
                            reasonsSelected.onReasonSelected(dialog, mReasonSelectedPosition, "");
                        }
                        break;

                    case R.id.other_resaons_submit:
                        reasonsSelected.onReasonSelected(dialog, mReasonSelectedPosition,
                                reasonsDialogLayoutBinding.reasonEt.getText().toString());
                        break;
                }
            }
        };

        reasonsDialogLayoutBinding.dismissBtn.setOnClickListener(onClickListener);
        reasonsDialogLayoutBinding.confirmCancellationBtn.setOnClickListener(onClickListener);
        reasonsDialogLayoutBinding.otherResaonsSubmit.setOnClickListener(onClickListener);
        reasonsDialogLayoutBinding.reasonTextWordsTv.setText(String.format(dialog.getContext()
                .getResources().getString(R.string.help_text_count), 0));

        reasonsDialogLayoutBinding.reasonEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() <= 256) {
                    reasonsDialogLayoutBinding.reasonTextWordsTv.setText(String.format(dialog.getContext()
                            .getResources().getString(R.string.help_text_count), s.length()));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        dialog.setCanceledOnTouchOutside(false);


        return dialog;
    }

    public String getDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        Date testDate = null;
        try {
            testDate = sdf.parse(date);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return testDate.toString();
    }

}
