package edu.utsa.cs3443.rhproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button depositPage = findViewById(R.id.button16);
        Button spendPage = findViewById(R.id.button19);
        Button logoutButton = findViewById(R.id.logout_button);
        Switch elderlySwitch=findViewById(R.id.switch3);
        Button helpPage = findViewById(R.id.button10);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLoginActivity();
            }
        });

        depositPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDeposit();
            }
        });

        spendPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSpend();
            }
        });


        elderlySwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchElderly();
            }
        });

        helpPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHelp();
            }
        });
    }
    public void launchLoginActivity(){
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void launchDeposit(){
        Intent intent=new Intent(this, DepositActivity.class);
        startActivity(intent);
    }
    public void launchSpend(){
        Intent intent=new Intent(this, SpendActivity.class);
        startActivity(intent);
    }
    public void launchHelp(){
        Intent intent=new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
    public void launchElderly(){
        Intent intent=new Intent(this, ElderlyActivity.class);
        startActivity(intent);
    }
}