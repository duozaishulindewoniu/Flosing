package com.our.flosing.view;

/**
 * Created by huangrui on 2016/12/27.
 */

public interface ILoginView extends IBaseView {
    void updateView();
    void showError(String msg);
    void showProgressDialog();
    void hideProgressDialog();
}
