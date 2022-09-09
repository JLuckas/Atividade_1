package com.example.mobile20222_1.model;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;

import com.example.mobile20222_1.Contract;

public class LoginInteractor {

    private Contract.LoginListener loginListener;

    public LoginInteractor(Contract.LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    public void login(LoginCredentials loginCredentials) {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                if (hasError(loginCredentials)){
                    return;
                }

                loginListener.onSuccess();
            }
        }, 3000);


    }


    //Faz a verificação de erros no login
    private boolean hasError(LoginCredentials loginCredentials) {

        String username = loginCredentials.getUsername();
        String password = loginCredentials.getPassword();

        if (TextUtils.isEmpty(username)) {
            loginListener.onFailed("O campo de email está vazio.");
            return true;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            loginListener.onFailed("O campo de email está preenchido com um modelo de email inválido.");
            return true;
        }

        if (TextUtils.isEmpty(password)) {
            loginListener.onFailed("O campo de senha está vazio.");
            return true;
        }

        if (password.length() < 5) {
            loginListener.onFailed("A senha precisa ter mais de 4 caracteres.");
            return true;
        }

        return false;


    }
}
