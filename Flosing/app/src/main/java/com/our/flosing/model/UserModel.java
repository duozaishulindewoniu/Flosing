package com.our.flosing.model;

import android.content.Intent;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SaveCallback;
import com.our.flosing.bean.User;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by huangrui on 2016/12/27.
 */

public class UserModel implements IUserModel {
    public Observable<Boolean> login(final String name, final String password) {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(final Subscriber subscriber) {
                AVUser.logInInBackground(name, password, new LogInCallback<AVUser>() {
                    @Override
                    public void done(AVUser avUser, AVException e) {
                        if (e == null) {
                            subscriber.onNext(true);
                            subscriber.onCompleted();
                        } else subscriber.onError(e);
                    }
                });
            }
        });
    }

    public Observable<Boolean> register(final String username, final String email, final String password) {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(final  Subscriber subscriber) {
                AVUser user = new AVUser();
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);
                user.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(AVException e) {
                        if (e == null) {
                            subscriber.onNext(true);
                            subscriber.onCompleted();
                        } else subscriber.onError(e);
                    }
                });
            }
        });
    }

}