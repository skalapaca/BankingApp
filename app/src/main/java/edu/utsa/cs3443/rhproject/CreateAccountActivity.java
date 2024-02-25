package edu.utsa.cs3443.rhproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        TextView newUsername = (EditText) findViewById(R.id.editTextTextNewUsername);
        TextView newPassword = (EditText)findViewById(R.id.editTextTextNewPassword);
        TextView confirmNewPassword = (EditText)findViewById(R.id.editTextTextConfirmNewPassword);
        Button submitButton = findViewById(R.id.submit_button);
        Button resetButton = findViewById(R.id.reset_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = newUsername.getText().toString();
                String npass = newPassword.getText().toString();
                String cnpass = confirmNewPassword.getText().toString();
                Toast toast;
                if ( (!user.equals("")) && (npass.equals(cnpass)) ) {
                    //create new Account object using user and npass
                    launchActivity();
                }
                else {
                    toast = Toast.makeText(view.getContext(), "Invalid user data!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newUsername.setText("");
                newPassword.setText("");
                confirmNewPassword.setText("");
            }
        });
    }
    private void launchActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
