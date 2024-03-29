package com.example.operatorsrx.view.activity;

import android.os.Bundle;
import android.util.Log;

import com.example.operatorsrx.R;
import com.example.operatorsrx.viewmodel.MainViewModel;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        try {
            viewModel.makeFuterQuary().get()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ResponseBody>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            Log.d(TAG, "onSubscribe: called.");
                        }

                        @Override
                        public void onNext(ResponseBody responseBody) {
                            Log.d(TAG, "onNext: got response from server!");
                            try {
                                Log.d(TAG, "onNext: "+responseBody.string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "onError: ",e);
                        }

                        @Override
                        public void onComplete() {
                            Log.d(TAG, "onComplete: called");
                        }
                    });
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}
