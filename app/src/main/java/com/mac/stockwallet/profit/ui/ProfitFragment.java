package com.mac.stockwallet.profit.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mac.stockwallet.R;
import com.mac.stockwallet.base.BaseFragment;
import com.mac.stockwallet.utils.ToastUtils;
import com.mac.ui_library.titlebar.OnTitleBarListenerImpl;
import com.mac.ui_library.titlebar.TitleBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingdee on 2019-08-05.
 */
public class ProfitFragment extends BaseFragment {


    private TitleBar mTitleBar;
    private String[] tabNames = {"交易所","钱包","手动模式"};
    private List<BaseFragment> mFragmentList;

    public static ProfitFragment getInstance(){
        return new ProfitFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_profit, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTitlebar(view);

        mFragmentList = new ArrayList<>();
        mFragmentList.add(ExchangeFragment.newInstance());
        mFragmentList.add(WalletFragment.newInstance());
        mFragmentList.add(ManualModelFragment.newInstance());

        TabLayout tabView = view.findViewById(R.id.tab_layout_profit);
        ViewPager viewPager = view.findViewById(R.id.viewPager_profit);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        tabView.setupWithViewPager(viewPager);

    }

    private void initTitlebar(View view) {
        mTitleBar = view.findViewById(R.id.titleBar_profit);

        mTitleBar.setOnTitleBarListener(new OnTitleBarListenerImpl(){
            @Override
            public void onFirstRightClick(View v) {
                ToastUtils.showMessage(getContext(),"待开发");
            }

            @Override
            public void onSecondRightClick(android.view.View v) {
                ToastUtils.showMessage(getContext(),"待开发");
            }
        });
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabNames[position];
        }
    }
}
