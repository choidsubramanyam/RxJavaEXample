
package com.example.subramanyam.rxjavaexample;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class StoreCoupons {

    @SerializedName("coupons")
    private List<Coupon> mCoupons;

    public List<Coupon> getCoupons() {
        return mCoupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        mCoupons = coupons;
    }

}
