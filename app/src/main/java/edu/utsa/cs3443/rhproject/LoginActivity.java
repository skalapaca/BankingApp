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

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginActivity extends AppCompatActivity {
//    CreateAccountActivity account = new CreateAccountActivity();
//    public ArrayList<Account> accounts = account.getAccounts();
    ArrayList<Account> accounts = new ArrayList<Account>();

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.view);
//
//        Intent intent = getIntent();
//
//        String userName = intent.getStringExtra("firstName");
//        String  = intent.getStringExtra("lastName");
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Account accountRey = new Account("ReyGuerra","Pass1234", "Rey");
        Account accountJoe = new Account("JoeMama", "Mother87", "Joe");
        Account accountJames = new Account("JamesLebron", "Baller23" , "James");
        Account accountMaria = new Account("DearMaria", "AllTimeLow1" , "Maria");

        accounts.add(accountRey);
        accounts.add(accountJoe);
        accounts.add(accountJames);
        accounts.add(accountMaria);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.login_button);
        TextView createAccount = findViewById(R.id.create_account);
        TextView username = (EditText)findViewById(R.id.editTextTextUsername);
        TextView password = (EditText)findViewById(R.id.editTextTextPassword);

//        String user = username.getText().toString().trim();
//        String pass = password.getText().toString().trim();


//        Toast toast = Toast.makeText(this, account.getUsername(), Toast.LENGTH_LONG);
//        toast.show();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                boolean accountFound = false;
                boolean passCorrect = false;

                for(Account account: accounts){
                    if (account.getUsername().equals(user)){
                        accountFound = true;
                        if (account.getPassword() == pass.hashCode()){
                            passCorrect = true;
                        }
                    }
                }

                boolean finalPassCorrect = passCorrect;
                boolean finalAccountFound = accountFound;
                if (finalAccountFound && finalPassCorrect) {
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

    public ArrayList<Account> readInAccounts() throws FileNotFoundException {
        ArrayList<Account> accounts = new ArrayList<Account>();
        File internalStorageDir = getFilesDir();
        File outputFile = new File(internalStorageDir, "AccountInfo");

        Scanner scnr = new Scanner(outputFile);
        String lineText = "";

        while(scnr.hasNext()) {
            lineText = scnr.nextLine();
            String[] strings = lineText.split(",");
            Account tempAccount = new Account(strings[0], strings[1], strings[2]);
            accounts.add(tempAccount);
        }

        return accounts;
    }
}
