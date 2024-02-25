package edu.utsa.cs3443.rhproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DepositActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        Button backButton = findViewById(R.id.back_button);
        Button depositButton = findViewById(R.id.deposit_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMainActivity();
            }
        });

        depositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //determine grand total in account
                launchMainActivity();
            }
        });
    }
    public void launchMainActivity(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}