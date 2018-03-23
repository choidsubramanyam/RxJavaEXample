
package com.example.subramanyam.rxjavaexample;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;


public class Coupon {

    @SerializedName("category")
    private String mCategory;
    @SerializedName("coupon")
    private String mCoupon;
    @SerializedName("couponCode")
    private String mCouponCode;
    @SerializedName("expiryDate")
    private String mExpiryDate;
    @SerializedName("store")
    private String mStore;

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public String getCoupon() {
        return mCoupon;
    }

    public void setCoupon(String coupon) {
        mCoupon = coupon;
    }

    public String getCouponCode() {
        return mCouponCode;
    }

    public void setCouponCode(String couponCode) {
        mCouponCode = couponCode;
    }

    public String getExpiryDate() {
        return mExpiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        mExpiryDate = expiryDate;
    }

    public String getStore() {
        return mStore;
    }

    public void setStore(String store) {
        mStore = store;
    }
    public String toString(){
        return new Gson().toJson(this);
    }
}
