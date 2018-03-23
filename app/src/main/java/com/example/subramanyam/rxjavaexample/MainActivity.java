package com.example.subramanyam.rxjavaexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "value";
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable<Integer> observable=Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(5);
//                e.onError(new Throwable("ERROR GENERATED"));
                e.onComplete();
            }
        });
        Observer<Integer> observer=new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG,"Subscribe :"+d);
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG,"onNext :"+integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"Error :"+e);
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"complete :");
            }
        };
        observable.blockingFirst();
        observable.blockingFirst(3);
        observable.subscribe(observer);
        Observable observable1=Observable.range(0,10);
        Observer<Integer> observer1=new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG,"Subscribe :"+d);
            }

            @Override
            public void onNext(Integer s) {
                Log.e(TAG,"onNext :"+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable1.subscribe(observer1);

        //Network Operartions
        retrofit=new Retrofit.Builder().
                baseUrl("http://www.zoftino.com/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getStoreCouponData();
        getSingleData();
    }

    private void getSingleData() {
        retrofit.create(StoreCouponsApi.class).getCoupons("topcoupons")
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this::handle,this::handleError);
    }

    private void handle(StoreCoupons storeCoupons) {
        Log.e("single",storeCoupons.getCoupons().get(2).toString());
    }

    private void getStoreCouponData() {
        Observable.just(retrofit.create(StoreCouponsApi.class)).subscribeOn(Schedulers.computation())
                .flatMap(s -> {
                    Observable<StoreCoupons> couponsObservable=s.getCoupons("topcoupons").subscribeOn(Schedulers.io());
                    Observable<StoreOffers> storeOffersObservable=s.getStoreInfo().subscribeOn(Schedulers.io());
                    return Observable.concatArray(couponsObservable,storeOffersObservable);
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResults,this::handleError);



    }

    private void handleError(Throwable throwable) {
        Log.e("err",""+throwable);
    }

    private void handleResults(Object o) {
        if (o instanceof StoreCoupons){
            StoreCoupons storeCoupons= (StoreCoupons) o;
            Log.e("object",""+((StoreCoupons) o).getCoupons().get(1).getCoupon());
        }else if (o instanceof StoreOffers){
            Log.e("da",""+((StoreOffers) o).getStore());
        }
        Log.e("object",""+o);
    }

}
