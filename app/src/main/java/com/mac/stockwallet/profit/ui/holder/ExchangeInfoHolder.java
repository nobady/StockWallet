package com.mac.stockwallet.profit.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.freelib.multiitem.adapter.holder.BaseViewHolder;
import com.freelib.multiitem.adapter.holder.BaseViewHolderManager;
import com.mac.stockwallet.R;
import com.mac.stockwallet.profit.data.model.ExchangeInfoModel;

/**
 * Created by kingdee on 2019-08-12.
 */
public class ExchangeInfoHolder extends BaseViewHolderManager<ExchangeInfoModel.CoinsBean> {

    @Override
    public void onBindViewHolder(BaseViewHolder holder, ExchangeInfoModel.CoinsBean coinsBean) {
        TextView coinsNameTv = getView(holder.itemView, R.id.exchange_info_bi_type_tv);
        TextView coinsNumTv = getView(holder.itemView, R.id.exchange_info_has_num_tv);
        TextView coinsMoneyTv = getView(holder.itemView, R.id.exchange_info_has_money_other_tv);
        TextView coinsPriceTv = getView(holder.itemView, R.id.exchange_info_price_tv);
        TextView coinsRateTv = getView(holder.itemView, R.id.exchange_info_present_tv);

        coinsNameTv.setText(coinsBean.getCoinName());
        coinsNumTv.setText(String.valueOf(coinsBean.getTotal()));
        coinsMoneyTv.setText(String.valueOf(coinsBean.getMoney()));
        coinsPriceTv.setText(String.valueOf(coinsBean.getPrice()));
        coinsRateTv.setText(String.valueOf(coinsBean.getRate()));
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.adapter_item_exchange_info;
    }
}
