package com.example.autocool;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClassiqueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classique);

        final Button buttonLesTarifsH = (Button) findViewById(R.id.btnHoraire);
        buttonLesTarifsH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassiqueActivity.this, listeTarifsCLQHActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonLesTarifsK = (Button) findViewById(R.id.btnKilometrique);
        buttonLesTarifsK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassiqueActivity.this, listeTarifsCLQKActivity.class);
                startActivity(intent);
            }
        });
    }
}
