package com.example.administrator.weekdome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        method1();

    }




    private void method1(){
        Observable<Integer> observable= Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.e(TAG,"被观察者点了一道菜："+1);
                emitter.onNext(1);
                Log.e(TAG,"被观察者点了一道菜："+2);
                emitter.onNext(2);
                Log.e(TAG,"被观察者点了一道菜："+3);
                emitter.onNext(3);
                Log.e(TAG,"被观察者点了一道菜："+4);
                emitter.onNext(4);



            }
        });
        Observer observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG,"观察者接到了第"+integer+"道菜：");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);

    }
}
