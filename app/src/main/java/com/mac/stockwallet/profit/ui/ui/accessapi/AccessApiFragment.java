package com.mac.stockwallet.profit.ui.ui.accessapi;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mac.stockwallet.R;
import com.mac.stockwallet.base.BaseFragment;

public class AccessApiFragment extends BaseFragment {

    private AccessApiViewModel mViewModel;

    public static AccessApiFragment newInstance() {
        return new AccessApiFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.access_api_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AccessApiViewModel.class);
    }

}
