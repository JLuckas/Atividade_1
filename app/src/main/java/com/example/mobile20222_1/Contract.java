package com.example.mobile20222_1;

public interface Contract {

    interface  LoginView{

        void showProgressbar();

        void hideProgressbar();

        void onSuccess();

        void onFailed(String message);

    }

    interface LoginListener{

        void onSuccess();

        void onFailed(String message);

    }
}
