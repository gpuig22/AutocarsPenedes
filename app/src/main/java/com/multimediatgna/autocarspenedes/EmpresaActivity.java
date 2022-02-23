package com.multimediatgna.autocarspenedes;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EmpresaActivity extends AppCompatActivity implements View.OnClickListener {

    Button MyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);

        MyButton = (Button) findViewById(R.id.mybutton);
        MyButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        this.finish();
    }
}