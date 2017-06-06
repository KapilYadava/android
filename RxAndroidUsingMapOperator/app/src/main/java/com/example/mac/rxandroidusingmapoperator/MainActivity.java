package com.example.mac.rxandroidusingmapoperator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import rx.Observable;
import rx.android.view.OnClickEvent;
import rx.android.view.ViewObservable;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton = (Button)findViewById(R.id.my_button); // Create a Button from a layout
        Observable<OnClickEvent> clicksObservable = ViewObservable.clicks(myButton); // Create a ViewObservable for the Button
        clicksObservable
                .skip(4)    // Skip the first 4 clicks
                .subscribe(new Action1<OnClickEvent>() {
                    @Override
                    public void call(OnClickEvent onClickEvent) {
                        Log.d("Click Action", "Clicked!");
                        // Printed from the fifth click onwards
                    }
                });
    }
}
