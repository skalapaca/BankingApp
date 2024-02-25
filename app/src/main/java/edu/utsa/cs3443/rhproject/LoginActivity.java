package edu.utsa.cs3443.rhproject;

import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.rhproject.account.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ArrayList<Account> accounts = new ArrayList<>();

        Button loginButton = findViewById(R.id.login_button);
        TextView createAccount = (TextView)findViewById(R.id.create_account);
        TextView username = (EditText)findViewById(R.id.editTextTextUsername);
        TextView password = (EditText)findViewById(R.id.editTextTextPassword);

        String user = username.getText().toString();
        String pass = password.getText().toString();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (0==0/*password and username matches set in file*/) {
                    launchMainActivity();
                }
                else /*if there are no matches*/{
                    Toast toast = Toast.makeText(view.getContext(), "Invalid credentials", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCreateActivity();
            }
        });
    }
    private void launchCreateActivity() {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }
    private void launchMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
