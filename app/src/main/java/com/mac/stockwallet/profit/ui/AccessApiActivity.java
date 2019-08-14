package com.mac.stockwallet.profit.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mac.stockwallet.R;
import com.mac.stockwallet.base.BaseActivity;
import com.mac.stockwallet.profit.ui.ui.accessapi.AccessApiFragment;

public class AccessApiActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.access_api_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, AccessApiFragment.newInstance())
                .commitNow();
        }
    }
}
