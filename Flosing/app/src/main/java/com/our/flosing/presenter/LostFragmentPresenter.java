package com.our.flosing.presenter;

import com.our.flosing.bean.LostCard;
import com.our.flosing.model.LostCardModel;
import com.our.flosing.view.IBaseView;
import com.our.flosing.view.ILostFragmentView;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by huangrui on 2016/12/29.
 */

public class LostFragmentPresenter implements ILostFragmentPresenter {
    private LostCardModel lostCardModel;
    private ILostFragmentView lostFragmentView;

    public LostFragmentPresenter(ILostFragmentView lostFragmentView) {
        this.lostFragmentView = lostFragmentView;
        this.lostCardModel = new LostCardModel();
    }

    @Override
    public void takeView(IBaseView baseView) {
        this.lostFragmentView = (ILostFragmentView) baseView;
    }

    @Override
    public void getPageOfLosts(final Integer pageNumber) {
        lostCardModel.getPageOfLosts(pageNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<LostCard>>() {
                    @Override
                    public void call(List<LostCard> lostCards) {
                        lostFragmentView.refreshView(lostCards);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        lostFragmentView.showError(throwable.getMessage());
                    }
                });
    }

}
