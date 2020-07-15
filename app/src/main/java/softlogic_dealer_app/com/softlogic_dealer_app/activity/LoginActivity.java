package softlogic_dealer_app.com.softlogic_dealer_app.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import softlogic_dealer_app.com.softlogic_dealer_app.R;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    EditText userEmailLbl, passwordLbl;
    TextView forgetPasswordLbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.login_button);
        userEmailLbl = findViewById(R.id.userEmail_lbl);
        passwordLbl = findViewById(R.id.password_lbl);
        forgetPasswordLbl = findViewById(R.id.forget_password_lbl);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(myIntent);
            }
        });

    }
}
