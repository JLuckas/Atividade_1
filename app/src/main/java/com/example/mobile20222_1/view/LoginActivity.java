package com.example.mobile20222_1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobile20222_1.Contract;
import com.example.mobile20222_1.LoginPresenter;
import com.example.mobile20222_1.R;
import com.example.mobile20222_1.model.LoginCredentials;

public class LoginActivity extends AppCompatActivity implements Contract.LoginView {


    private ProgressDialog progressDialog;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);
        presenter = new LoginPresenter(this);

        EditText emailView = findViewById(R.id.username);
        EditText passwordView = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailView.getText().toString();
                String password = passwordView.getText().toString();

                LoginCredentials credentials = new LoginCredentials(email, password);
                presenter.start(credentials);
            }
        });
}

    @Override
    public void showProgressbar() {
        progressDialog.show();

    }

    @Override
    public void hideProgressbar() {
        progressDialog.dismiss();
    }

    @Override
    public void onSuccess() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}