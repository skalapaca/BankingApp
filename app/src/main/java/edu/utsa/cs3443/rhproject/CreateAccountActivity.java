package edu.utsa.cs3443.rhproject;

import edu.utsa.cs3443.rhproject.account.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CreateAccountActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        TextView newFirstName = (EditText)findViewById(R.id.editTextFirstName);
        TextView newUsername = (EditText)findViewById(R.id.editTextTextNewUsername);
        TextView newPassword = (EditText)findViewById(R.id.editTextTextNewPassword);
        TextView confirmNewPassword = (EditText)findViewById(R.id.editTextTextConfirmNewPassword);
        Button submitButton = findViewById(R.id.submit_button);
        Button resetButton = findViewById(R.id.reset_button);
        Button backButton = findViewById(R.id.back_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = newFirstName.getText().toString();
                String user = newUsername.getText().toString();
                String npass = newPassword.getText().toString();
                String cnpass = confirmNewPassword.getText().toString();
                if ( isValidPass(npass, cnpass) ) {
                    Account account = new Account(user, npass, name);
                    outputToTextFile(account);
                    //launchActivity();
                }
                else {
                    Toast toast = Toast.makeText(view.getContext(), "Invalid user data!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newFirstName.setText("");
                newUsername.setText("");
                newPassword.setText("");
                confirmNewPassword.setText("");
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });
    }
    private void launchActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public boolean isValidPass(String pass, String cpass) {
        boolean valid = false, hasDigit = false, hasCapital = false;

        valid = !pass.equals(""); //Check that pass is not blank
        valid = (pass.equals(cpass));
        valid = (pass.length() < 8) ? false : true; //Check that pass is not less than 8 chars

        for(char c : pass.toCharArray()) {
            if (Character.isDigit(c))
                hasDigit = true; // checks that string has at least 1 digit

            if(Character.isUpperCase(c))
                hasCapital = true;//checks that string has at least 1 upper case letter.

            if(hasCapital && hasDigit)
                break;
        }

        if (!hasDigit || !hasCapital )
            valid = false;
        else
            valid = true;

        return valid;
    }

    public void outputToTextFile(Account account) {
        try {
            FileWriter output = new FileWriter("C:/Users/bossh/AccountsInfo.txt", true);
            output.write(account.getUsername() + "," + account.getPassword() + "," + account.getName() + "\n");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
