package com.example.subramanyam.rxjavaexample;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Subramanyam on 3/23/2018.
 */

public interface StoreCouponsApi {
    @GET("coupons")
    Observable<StoreCoupons> getCoupons(@Query("status") String status);
    @GET("storeOffers")
    Observable<StoreOffers> getStoreInfo();
}
