package com.mac.stockwallet.profit.ui;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.freelib.multiitem.adapter.BaseItemAdapter;
import com.mac.stockwallet.R;
import com.mac.stockwallet.base.BaseActivity;
import com.mac.stockwallet.profit.data.model.ExchangeInfoModel;
import com.mac.stockwallet.profit.ui.holder.ExchangeInfoHolder;
import com.mac.stockwallet.profit.viewmodel.ExchangeInfoViewModel;
import com.mac.ui_library.titlebar.TitleBar;

public class ExchangeInfoActivity extends BaseActivity {

    private ExchangeInfoViewModel mViewModel;
    private BaseItemAdapter mAdapter;
    private int mExchangeId;
    private String mExchangeName;
    private TitleBar mTitleBar;
    private TextView mTotalMoney$;
    private TextView mTotalMoney;
    private TextView mHoursChange;
    private TextView mHistoryChange;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exchange_info_fragment);
        mViewModel = ViewModelProviders.of(this).get(ExchangeInfoViewModel.class);

        initIntent();
        initTitleBar();
        initMoneyView();

        RecyclerView recyclerView = findViewById(R.id.exchange_info_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BaseItemAdapter();
        mAdapter.register(ExchangeInfoModel.CoinsBean.class,new ExchangeInfoHolder());
        recyclerView.setAdapter(mAdapter);

        mViewModel.getMutableLiveData().observe(this,mModelObserver);
        mViewModel.getExchangeInfoData(mExchangeId+"");
    }

    private void initMoneyView() {
        mTotalMoney$ = findViewById(R.id.tv_money_us);
        mTotalMoney = findViewById(R.id.tv_money_rmb);
        mHoursChange = findViewById(R.id.tv_24hours_change_value);
        mHistoryChange = findViewById(R.id.tv_history_profit_value);
    }

    private void initTitleBar() {
        mTitleBar = findViewById(R.id.titleBar_exchange_info);
        mTitleBar.setTitle(mExchangeName);
    }

    private void initIntent() {
        mExchangeId = getIntent().getIntExtra("exchangeId",0);
        mExchangeName = getIntent().getStringExtra("exchangeName");
    }


    private Observer<ExchangeInfoModel> mModelObserver = new Observer<ExchangeInfoModel>() {
        @SuppressLint("StringFormatMatches")
        @Override
        public void onChanged(@Nullable ExchangeInfoModel infoModel) {
            mTotalMoney.setText(String.valueOf(infoModel.getTotal()));
            mTotalMoney$.setText(getString(R.string.exchange_info_money_$,infoModel.getTotal$()));

            mHoursChange.setText(getString(R.string.change_rate_24,infoModel.getChange24h(),infoModel.getChange24hRate()));
            mHistoryChange.setText(String.valueOf(infoModel.getHistoryProfit()));

            mAdapter.setDataItems(infoModel.getCoins());
            mAdapter.notifyDataSetChanged();
        }
    };






}
