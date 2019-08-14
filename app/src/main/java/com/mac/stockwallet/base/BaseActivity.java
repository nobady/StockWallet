package com.mac.stockwallet.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kingdee on 2019-07-31.
 */
public class BaseActivity extends AppCompatActivity {


    public Fragment getFragment(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag);
    }

    public void changeFragment(int replaceLayoutId, Fragment orgF, Fragment newF, String newFTag) {
        if (orgF == newF) {
            return;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (orgF != null) {
            if (orgF.isAdded()) {
                ft.hide(orgF);
            }
        }
        if (newF != null) {
            if (newF.isAdded()) {
                ft.show(newF);
            } else {
                ft.add(replaceLayoutId, newF, newFTag);
            }
        }
        ft.commitAllowingStateLoss();
    }
}
