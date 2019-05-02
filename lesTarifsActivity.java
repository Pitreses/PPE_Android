package com.example.autocool;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lesTarifsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_tarifs);

        final Button buttonLesTarifsCL = (Button) findViewById(R.id.btnClassique);
        buttonLesTarifsCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lesTarifsActivity.this, ClassiqueActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonLesTarifsCP = (Button) findViewById(R.id.btnCooperative);
        buttonLesTarifsCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lesTarifsActivity.this, CooperativeActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonLesTarifsLIB = (Button) findViewById(R.id.btnLiberte);
        buttonLesTarifsLIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lesTarifsActivity.this, LiberteActivity.class);
                startActivity(intent);
            }
        });

    }
}
