package com.example.countries.Ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.countries.Data.PostsClient;
import com.example.countries.Model.Root;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MoveViewModel extends ViewModel {
    MutableLiveData<Root> postsMutableLiveData = new MutableLiveData<>();

    public void getPosts(Integer per_page) {

        Observable observable = PostsClient.getINSTANCE().getPosts(per_page)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());


        Observer<Root> observer= new Observer <Root>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Root value) {

                postsMutableLiveData.setValue(value);
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
