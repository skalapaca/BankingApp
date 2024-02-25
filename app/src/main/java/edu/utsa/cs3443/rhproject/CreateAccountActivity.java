package edu.utsa.cs3443.rhproject;

import edu.utsa.cs3443.rhproject.account.*;
import androidx.appcompat.app.AppCompatActivity;

import android.accounts.AccountAuthenticatorActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateAccountActivity extends AppCompatActivity {
    public final ArrayList<Account> accounts = new ArrayList<Account>();

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

        Account accountRey = new Account("ReyGuerra", "Pass123" , "Rey");
        Account accountJoe = new Account("JoeMama", "Mother87", "Joe");
        Account accountJames = new Account("JamesLebron", "Baller23" , "James");
        Account accountMaria = new Account("DearMaria", "AllTimeLow1" , "Maria");
        accounts.add(accountRey);
        accounts.add(accountJoe);
        accounts.add(accountJames);
        accounts.add(accountMaria);
        accounts.get(0).

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = newFirstName.getText().toString();
                String user = newUsername.getText().toString();
                String npass = newPassword.getText().toString();
                String cnpass = confirmNewPassword.getText().toString();
                if ( isValidPass(npass, cnpass) ) {
                    Account account = new Account(user, npass, name);
                    accounts.add(account);
                    launchActivity();
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
        intent.putExtra("username", accounts.get(accounts.size()-1).getUsername());
        intent.putExtra("password", accounts.get(accounts.size()-1).getPassword());
        intent.putExtra("name", accounts.get(accounts.size()-1).getName());
        startActivity(intent);
    }

    public boolean isValidPass(String pass, String cpass) {
        boolean valid = false, hasDigit = false, hasCapital = false;

        valid = !pass.equals(""); //Check that pass is not blank
        valid = (pass.equals(cpass));
        valid = pass.length() >= 8; //Check that pass is not less than 8 chars

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

    public void outputToTextFile(Account account) throws IOException {
        File internalStorageDir = getFilesDir();
        File outputFile = new File(internalStorageDir, "AccountInfo");
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println(account.getUsername() + "," + account.getPassword() + "," + account.getName() + "\n");
        printStream.close();
        outputStream.close();
            FileWriter output = new FileWriter("\\AccountsInfo.txt", true);
            output.write(account.getUsername() + "," + account.getPassword() + "," + account.getName() + "\n");
            output.close();
    }

    public ArrayList<Account> getAccounts(){
        return this.accounts;
    }


}
