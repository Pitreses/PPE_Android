package com.example.autocool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CooperativeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooperative);

        final Button buttonLesTarifsH = (Button) findViewById(R.id.btnHoraire);
        buttonLesTarifsH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CooperativeActivity.this, listeTarifsCPHActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonLesTarifsK = (Button) findViewById(R.id.btnKilometrique);
        buttonLesTarifsK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CooperativeActivity.this, listeTarifsCPKActivity.class);
                startActivity(intent);
            }
        });
    }
}
