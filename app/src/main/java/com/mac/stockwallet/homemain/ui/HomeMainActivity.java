package com.mac.stockwallet.homemain.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.freelib.multiitem.adapter.BaseItemAdapter;
import com.freelib.multiitem.adapter.holder.BaseViewHolder;
import com.freelib.multiitem.listener.OnItemClickListener;
import com.mac.stockwallet.R;
import com.mac.stockwallet.base.BaseActivity;
import com.mac.stockwallet.base.BaseFragment;
import com.mac.stockwallet.business.BusinessFragment;
import com.mac.stockwallet.homemain.HomeMenuViewModel;
import com.mac.stockwallet.homemain.data.HomeMenuHolder;
import com.mac.stockwallet.homemain.data.model.HomeMenuItem;
import com.mac.stockwallet.me.MeFragment;
import com.mac.stockwallet.profit.ui.ProfitFragment;
import com.mac.stockwallet.utils.LogUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingdee on 2019-07-31.
 */
public class HomeMainActivity extends BaseActivity {

    private List<HomeMenuItem> mMenuItems;
    private RecyclerView mMenuGridView;
    private BaseItemAdapter mMenuAdapter;

    private String mCurrFragmentTag = "";
    protected WeakReference<BaseFragment> mReferenceFrag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        initMenus();

    }

    private void initMenus() {
        mMenuItems = new ArrayList<>();
        mMenuGridView = findViewById(R.id.home_menu_view);
        mMenuAdapter = new BaseItemAdapter();
        mMenuAdapter.register(HomeMenuItem.class, new HomeMenuHolder());
        mMenuAdapter.setDataItems(mMenuItems);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mMenuGridView.setLayoutManager(layoutManager);
        mMenuGridView.setAdapter(mMenuAdapter);

        HomeMenuViewModel homeMenuViewModel = ViewModelProviders.of(this).get(HomeMenuViewModel.class);
        homeMenuViewModel.getMenusLiveData().observe(this, mMenuObserver);
        homeMenuViewModel.loadMenu();

        mMenuAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseViewHolder baseViewHolder) {
                changeOrNewFragment(baseViewHolder.getItemPosition());
            }
        });
    }

    private Observer<List<HomeMenuItem>> mMenuObserver = new Observer<List<HomeMenuItem>>() {

        @Override
        public void onChanged(@Nullable List<HomeMenuItem> menuItemList) {
            if (mMenuAdapter == null) {
                return;
            }
            mMenuItems.clear();
            mMenuItems.addAll(menuItemList);
            mMenuAdapter.notifyDataSetChanged();

            int selectedPosition = getSelectedPosition();
            changeOrNewFragment(selectedPosition);
        }
    };
    private void setSelectItem(int selectItem){
        for (int i = 0; i < mMenuItems.size(); i++) {
            mMenuItems.get(i).selected = (i==selectItem);
        }
    }

    private void changeOrNewFragment(int position) {
        if (mMenuItems == null || mMenuItems.isEmpty() || mMenuItems.size() <= position) {
            return;
        }
        if (isFinishing()) {
            return;
        }
        HomeMenuItem menuItem = mMenuItems.get(position);
        BaseFragment oldFragment = (BaseFragment) getFragment(mCurrFragmentTag);
        BaseFragment newFragment = (BaseFragment) getFragment(menuItem.getKey());
//
        if (oldFragment != null && oldFragment == newFragment) {
            oldFragment.onShowRepeat();
            setSelectedFragment(oldFragment);
        } else {
            if (newFragment == null) {
                switch (menuItem.mMenuType) {
                    case ME:
                        newFragment = MeFragment.getInstance();
                        break;
                    case PROFIT:
                        newFragment = ProfitFragment.getInstance();
                        break;
                    case BUSINESS:
                        newFragment = BusinessFragment.getInstance();
                        break;
                    default:
                        break;
                }
            }

            changeFragment(R.id.frameLayout, oldFragment, newFragment, menuItem.getKey());
            setSelectedFragment(newFragment);
            mCurrFragmentTag = menuItem.getKey();
            setSelectItem(position);
            mMenuAdapter.notifyDataSetChanged();
        }

        LogUtils.debug("mCurrFragmentTag = "+mCurrFragmentTag);

    }

    private void setSelectedFragment(BaseFragment fragment) {
        mReferenceFrag = new WeakReference<>(fragment);
    }


    private int getSelectedPosition() {
        for (int i = 0; i < mMenuItems.size(); i++) {
            HomeMenuItem homeMenuItem = mMenuItems.get(i);
            if (homeMenuItem.isSelected()) {
                return i;
            }
        }
        return 0;
    }


}
