package mersattech.barqexpdriver.Activities.History;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Toast;
import mersattech.barqexpdriver.Activities.BaseActivity;
import mersattech.barqexpdriver.Adapters.HistoryParentListAdapter;
import mersattech.barqexpdriver.Models.s.HistoryPackage.HistoryResponse;
import mersattech.barqexpdriver.NetworkUtils.NetworkConstants;
import mersattech.barqexpdriver.NetworkUtils.NetworkUtils;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Utils.AppPreferences;
import mersattech.barqexpdriver.databinding.HistoryActivityBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends BaseActivity {

    HistoryActivityBinding mHistoryActivityBinding;
    private ProgressDialog mProgressDialog;
    private View.OnClickListener mOnClickListener;
    SharedPreferences sharedpreferences;
    private String mAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedpreferences = getSharedPreferences("MyPref",
                Context.MODE_PRIVATE);


        mHistoryActivityBinding = DataBindingUtil.setContentView(this, R.layout.history_activity);
        mHistoryActivityBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        initialiseViews();
        registerViewListeners();
        apiCall();
    }

    private void apiCall() {
        mAuth = AppPreferences.getAppPreferences(getApplicationContext()).getString(AppPreferences.TOKEN, "");

        if (NetworkUtils.getInstance().isNetworkAvailable(HistoryActivity.this)) {
            mHistoryActivityBinding.noInternetLayout.setVisibility(View.GONE);
            mHistoryActivityBinding.recyclerview.setVisibility(View.VISIBLE);
            mHistoryActivityBinding.searchSortLayout.setVisibility(View.GONE);
            mProgressDialog = getProgressDialog(HistoryActivity.this);
            callGetHistoryApi();
        } else {
            mHistoryActivityBinding.searchSortLayout.setVisibility(View.GONE);
            mHistoryActivityBinding.recyclerview.setVisibility(View.GONE);
            mHistoryActivityBinding.noInternetLayout.setVisibility(View.VISIBLE);
            Toast.makeText(this, getString(R.string.no_network_message), Toast.LENGTH_SHORT).show();
        }
    }

    private void initialiseViews() {
        setToolbar(mHistoryActivityBinding.toolbar, getString(R.string.history_title_text), true);

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.back_icon:
                        onBackPressed();
                        break;

                    case R.id.retry_iv:
                        apiCall();
                        break;

                    case R.id.sort_iv:
                        Toast.makeText(HistoryActivity.this, R.string.coming_soon_hint_text, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

    }

    private void registerViewListeners() {
        mHistoryActivityBinding.toolbar.backIcon.setOnClickListener(mOnClickListener);
        mHistoryActivityBinding.retryIv.setOnClickListener(mOnClickListener);
        mHistoryActivityBinding.sortIv.setOnClickListener(mOnClickListener);
        mHistoryActivityBinding.swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Do your task
                mHistoryActivityBinding.swipeContainer.setRefreshing(false);
                apiCall();

            }
        });
    }

    private void callGetHistoryApi() {
        Call<HistoryResponse> getHistoryResponseCall = NetworkUtils.getApiInterface().
                getHistoryDetails( "bearer "+mAuth,1,2);

        getHistoryResponseCall.enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<HistoryResponse> call,
                                   @NonNull Response<HistoryResponse> response) {
                HistoryResponse getHistoryResponse = response.body();

                if (getHistoryResponse != null) {
                    switch (getHistoryResponse.getStatus()) {
                        case NetworkConstants.RESPONSE_SUCCESS:
                          Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                            setData(getHistoryResponse.getList());
                            break;

                        default:
                            mProgressDialog.dismiss();
                            mHistoryActivityBinding.searchSortLayout.setVisibility(View.GONE);
                            mHistoryActivityBinding.noLocationPermission.setText(R.string.no_history_hint_text);
                            mHistoryActivityBinding.retryIv.setVisibility(View.GONE);
                            mHistoryActivityBinding.noInternetLayout.setVisibility(View.VISIBLE);
                            showToastMessage(HistoryActivity.this, getHistoryResponse);
                            break;
                    }
                } else {
                    mProgressDialog.dismiss();
                    Toast.makeText(HistoryActivity.this, getString(R.string.no_response), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<HistoryResponse> call, @NonNull Throwable t) {
                Toast.makeText(HistoryActivity.this, getString(R.string.api_failure_message), Toast.LENGTH_SHORT).show();
                mProgressDialog.dismiss();
            }
        });
    }

    private void setData(java.util.List<mersattech.barqexpdriver.Models.s.HistoryPackage.List> list) {
        final HistoryParentListAdapter historyListAdapter = new HistoryParentListAdapter(list);
        mHistoryActivityBinding.recyclerview.setAdapter(historyListAdapter);
        mProgressDialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHistoryActivityBinding.unbind();
    }
}