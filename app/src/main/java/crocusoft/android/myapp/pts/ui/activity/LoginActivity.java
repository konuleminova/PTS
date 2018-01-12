package crocusoft.android.myapp.pts.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import crocusoft.android.myapp.pts.R;
import crocusoft.android.myapp.pts.network.ApiClient;
import crocusoft.android.myapp.pts.network.ApiInterface;
import crocusoft.android.myapp.pts.network.requests.ForgotPasswordRequestClass;
import crocusoft.android.myapp.pts.network.requests.LoginRequestClass;
import crocusoft.android.myapp.pts.network.responses.ForgotPassResponseClass;
import crocusoft.android.myapp.pts.network.responses.LoginResponseClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Asus on 12/24/2017.
 */

public class LoginActivity extends Activity {
    EditText emailText, passwordText, forgotPassEditText;
    Button loginButton;
    RelativeLayout forgotPassLayout;
    TextView forgotPassTextView;
    private static final int REQUEST_SIGNUP = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage_layout);
        emailText = (EditText) findViewById(R.id.username);
        passwordText = (EditText) findViewById(R.id.password);
        forgotPassEditText = (EditText) findViewById(R.id.forgot_password_edittext);
        forgotPassLayout = (RelativeLayout) findViewById(R.id.forgotPass_button_layout);
        forgotPassTextView = (TextView) findViewById(R.id.textview_forgotpass);
        loginButton = (Button) findViewById(R.id.loginbtn);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
                sendData();

            }
        });
        forgotPassLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgotPassEditText.setVisibility(View.VISIBLE);
                forgotPassTextView.setText("Send");
                //sendForogotPassData();

            }
        });


    }

    private void sendData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        LoginRequestClass requestClass = new LoginRequestClass();
        requestClass.setUsername(emailText.getText().toString());
        requestClass.setPassword(passwordText.getText().toString());
        apiInterface.sendMessage(requestClass).enqueue(new Callback<LoginResponseClass>() {
            @Override
            public void onResponse(Call<LoginResponseClass> call, Response<LoginResponseClass> response) {


                if (response.body().getCompany() != null) {
                    Log.e("message", response.body().getMessage().getMessage());
                    Toast.makeText(LoginActivity.this, response.body().getMessage().getMessage(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);



                } else {
                    Toast.makeText(getApplicationContext(), "Your email address or password is wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponseClass> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "System error", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void sendForogotPassData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        ForgotPasswordRequestClass requestClass = new ForgotPasswordRequestClass();
        if (forgotPassEditText != null && passwordText != null) {
            requestClass.setUsername(forgotPassEditText.getText().toString());
            requestClass.setPassword(passwordText.getText().toString());
        } else {
            Toast.makeText(getApplicationContext(), "null", Toast.LENGTH_LONG).show();
        }
        apiInterface.sendMessage(requestClass).enqueue(new Callback<ForgotPassResponseClass>() {
            @Override
            public void onResponse(Call<ForgotPassResponseClass> call, Response<ForgotPassResponseClass> response) {
                if (response.body().getMessage().getMessage() != null) {
                    Toast.makeText(LoginActivity.this, response.body().getMessage().getMessage(), Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(getApplicationContext(), "Your password is not changed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ForgotPassResponseClass> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "System error", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void login() {
        loginButton.setEnabled(false);
        if (!validate()) {
            onLoginFailed();
            return;
        } else {

            loginButton.setEnabled(true);
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                this.finish();
            }
        }
    }

//    @Override
//    public void onBackPressed() {
//        moveTaskToBack(true);
//    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_SHORT).show();
        loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (email.isEmpty()) {
            emailText.setError("Please enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
        }
        //|| !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        // || password.length() < 4 || password.length() > 10
        if (password.isEmpty()) {
            passwordText.setError("Please type between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        return valid;
    }
}
