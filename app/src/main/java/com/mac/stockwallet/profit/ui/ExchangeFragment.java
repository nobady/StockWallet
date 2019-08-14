package com.mac.stockwallet.profit.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freelib.multiitem.adapter.BaseItemAdapter;
import com.freelib.multiitem.adapter.holder.BaseViewHolder;
import com.freelib.multiitem.listener.OnItemClickListener;
import com.mac.stockwallet.R;
import com.mac.stockwallet.base.BaseFragment;
import com.mac.stockwallet.profit.data.model.ExchangeModel;
import com.mac.stockwallet.profit.ui.holder.ExchangeHolder;
import com.mac.stockwallet.profit.viewmodel.ExchangeViewModel;
import com.mac.stockwallet.utils.ActivityIntentTools;

import java.util.ArrayList;
import java.util.List;

public class ExchangeFragment extends BaseFragment {

    private ExchangeViewModel mViewModel;
    private BaseItemAdapter mAdapter;
    private List<ExchangeModel> mExchangeModelList;

    public static ExchangeFragment newInstance() {
        return new ExchangeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.exchange_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mExchangeModelList = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.exchange_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new BaseItemAdapter();
        mAdapter.register(ExchangeModel.class,new ExchangeHolder());
        mAdapter.setDataItems(mExchangeModelList);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseViewHolder baseViewHolder) {
                ActivityIntentTools.gotoExchangeInfoActivity(getActivity(), ((ExchangeModel) baseViewHolder.itemData).getExchangeId());
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ExchangeViewModel.class);

        mViewModel.getExchangeLiveData().observe(this, mObserver);
        mViewModel.getExchangeDatas();
    }

    private Observer<List<ExchangeModel>> mObserver = new Observer<List<ExchangeModel>>() {
        @Override
        public void onChanged(@Nullable List<ExchangeModel> exchangeModels) {
            mAdapter.setDataItems(exchangeModels);
            mAdapter.notifyDataSetChanged();
        }
    };

}
