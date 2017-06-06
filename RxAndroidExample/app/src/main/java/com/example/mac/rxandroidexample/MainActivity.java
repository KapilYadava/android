package com.example.mac.rxandroidexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscription;

public class MainActivity extends AppCompatActivity implements Observer<String>{

    Subscription justSubscription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable<String> justObservable= Observable.just("Hello Kapil");// Emits "Hello"
        justSubscription= justObservable.subscribe((Observer<? super String>) this);
    }

    @Override
    public void onCompleted() {
        Log.v("Tag", "Completed");
    }

    @Override
    public void onError(Throwable e) {
        Log.v("Tag", "onError");
    }

    @Override
    public void onNext(String s) {
        Log.v("just", s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        justSubscription.unsubscribe();
    }
}
