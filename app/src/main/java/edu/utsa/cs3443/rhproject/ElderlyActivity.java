package edu.utsa.cs3443.rhproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ElderlyActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_elderly);

        Switch elderlySwitch=findViewById(R.id.switch1);
        elderlySwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMainActivity();
            }
        });
        Button depositPage = findViewById(R.id.button5);
        depositPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDepositActivity();
            }

        });
        Button spendPage = findViewById(R.id.button6);
        spendPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSpendActivity();
            }
        });
    }
    public void launchMainActivity(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void launchDepositActivity(){
        Intent intent=new Intent(this, DepositActivity.class);
        startActivity(intent);
    }
    public void launchSpendActivity(){
        Intent intent=new Intent(this, SpendActivity.class);
        startActivity(intent);
    }
}
