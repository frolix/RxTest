package com.example.operatorsrx.viewmodel;

import java.util.concurrent.Future;


import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class MainViewModel extends ViewModel {

    private Repository repository;

    public MainViewModel(){
        repository = Repository.getInstance();
    }

    public Future<Observable<ResponseBody>> makeFuterQuary(){
        return repository.makeFutureQuery();
    }


}
