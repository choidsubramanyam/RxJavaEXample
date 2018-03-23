
package com.example.subramanyam.rxjavaexample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class StoreOffers {

    @SerializedName("cashback")
    private List<String> mCashback;
    @SerializedName("maxCashback")
    private String mMaxCashback;
    @SerializedName("store")
    private String mStore;
    @SerializedName("topCoupons")
    private List<String> mTopCoupons;
    @SerializedName("totalCoupons")
    private String mTotalCoupons;

    public List<String> getCashback() {
        return mCashback;
    }

    public void setCashback(List<String> cashback) {
        mCashback = cashback;
    }

    public String getMaxCashback() {
        return mMaxCashback;
    }

    public void setMaxCashback(String maxCashback) {
        mMaxCashback = maxCashback;
    }

    public String getStore() {
        return mStore;
    }

    public void setStore(String store) {
        mStore = store;
    }

    public List<String> getTopCoupons() {
        return mTopCoupons;
    }

    public void setTopCoupons(List<String> topCoupons) {
        mTopCoupons = topCoupons;
    }

    public String getTotalCoupons() {
        return mTotalCoupons;
    }

    public void setTotalCoupons(String totalCoupons) {
        mTotalCoupons = totalCoupons;
    }

}
