package com.mac.stockwallet.profit.data.model;

import java.util.List;

/**
 * Created by kingdee on 2019-08-12.
 */
public class ExchangeInfoModel {

    private double total;
    private double total$;
    private double change24h;
    private double change24hRate;
    private double historyProfit;
    private List<CoinsBean> coins;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal$() {
        return total$;
    }

    public void setTotal$(double total$) {
        this.total$ = total$;
    }

    public double getChange24h() {
        return change24h;
    }

    public void setChange24h(double change24h) {
        this.change24h = change24h;
    }

    public double getChange24hRate() {
        return change24hRate;
    }

    public void setChange24hRate(double change24hRate) {
        this.change24hRate = change24hRate;
    }

    public double getHistoryProfit() {
        return historyProfit;
    }

    public void setHistoryProfit(double historyProfit) {
        this.historyProfit = historyProfit;
    }

    public List<CoinsBean> getCoins() {
        return coins;
    }

    public void setCoins(List<CoinsBean> coins) {
        this.coins = coins;
    }

    public static class CoinsBean{
        private String coinName;
        private double total;
        private double money;
        private double price;
        private double rate;

        public String getCoinName() {
            return coinName;
        }

        public void setCoinName(String coinName) {
            this.coinName = coinName;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }
    }
}
