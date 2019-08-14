package com.mac.stockwallet.profit.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.freelib.multiitem.adapter.holder.BaseViewHolder;
import com.freelib.multiitem.adapter.holder.BaseViewHolderManager;
import com.mac.stockwallet.R;
import com.mac.stockwallet.profit.data.model.ExchangeModel;
import com.mac.stockwallet.utils.ImageUtil;

/**
 * Created by kingdee on 2019-08-08.
 */
public class ExchangeHolder extends BaseViewHolderManager<ExchangeModel> {

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_exchange_adapter;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, ExchangeModel exchangeModel) {
        TextView infoTv = getView(holder.itemView, R.id.exchange_info_tv);
        TextView nameTv = getView(holder.itemView, R.id.exchange_name_tv);
        ImageView logoIv = getView(holder.itemView, R.id.exchange_logo_iv);
        infoTv.setText(exchangeModel.getInfo());
        nameTv.setText(exchangeModel.getName());
        ImageUtil.displayImg(infoTv.getContext(),exchangeModel.getLogo(),logoIv,R.mipmap.bar_icon_back_white);
    }
}
