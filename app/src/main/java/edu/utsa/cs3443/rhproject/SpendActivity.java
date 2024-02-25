package edu.utsa.cs3443.rhproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SpendActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spend);

        Button backButton = findViewById(R.id.back_button);
        Button spendButton = findViewById(R.id.spend_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMainActivity();
            }
        });

        spendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //take away money from grand total
                launchMainActivity();
            }
        });
    }
    public void launchMainActivity(){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
