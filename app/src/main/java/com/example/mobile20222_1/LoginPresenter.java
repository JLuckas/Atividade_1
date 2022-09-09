package com.example.mobile20222_1;

import com.example.mobile20222_1.model.LoginCredentials;
import com.example.mobile20222_1.model.LoginInteractor;

public class LoginPresenter implements Contract.LoginListener{


    private Contract.LoginView loginView;


    private LoginInteractor loginInteractor;

    //O construtor do método LoginView
    public LoginPresenter(Contract.LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractor(this);

    }

    public void start(LoginCredentials credentials) {
        loginView.showProgressbar();
        loginInteractor.login(credentials);
    }

    @Override
    public void onSuccess() {
        loginView.hideProgressbar();
        loginView.onSuccess();
    }

    @Override
    public void onFailed(String message) {
        loginView.hideProgressbar();
        loginView.onFailed(message);
    }
}
