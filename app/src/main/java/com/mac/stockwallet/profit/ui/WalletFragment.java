package com.mac.stockwallet.profit.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mac.stockwallet.R;
import com.mac.stockwallet.base.BaseFragment;
import com.mac.stockwallet.profit.viewmodel.WalletViewModel;

public class WalletFragment extends BaseFragment {

    private WalletViewModel mViewModel;

    public static WalletFragment newInstance() {
        return new WalletFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.wallet_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(WalletViewModel.class);
        // TODO: Use the ViewModel
    }

}
