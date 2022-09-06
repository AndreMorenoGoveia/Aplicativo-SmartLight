package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class QuartoPais extends AppCompatActivity {

    ImageView image;
    SwitchMaterial button, auto;
    Boolean estado = false, autob = false;
    ImageButton retorna;

    public void switcher1(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (estado) {
                    image.setImageResource(R.drawable.quartopaisapagado);
                    estado = false;
                } else {
                    image.setImageResource(R.drawable.quartopaisaceso);
                    estado = true;
                }
            }
        });

    }

    public void switcher2(){

        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (autob) {
                    if(estado) {
                        image.setImageResource(R.drawable.quartopaisaceso);
                    }
                    else{
                        image.setImageResource(R.drawable.quartopaisapagado);
                    }
                    autob = false;
                } else {
                    image.setImageResource(R.drawable.quartopaisauto);
                    autob = true;
                }
                button.setEnabled(!(autob));
            }
        });

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide(); //Esconde a barra de acoes

        setContentView(R.layout.activity_quarto_pais);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("Valores", Context.MODE_PRIVATE);

        Boolean pai = sp.getBoolean("pai", true);
        Boolean mae = sp.getBoolean("mae", true);


        image = (ImageView) findViewById(R.id.corredorsolo);
        button = (SwitchMaterial) findViewById(R.id.switch1);
        auto = (SwitchMaterial) findViewById(R.id.switch2);
        button.setEnabled(mae || pai);
        auto.setEnabled(mae || pai);
        retorna = (ImageButton) findViewById((R.id.retornabutton));
        switcher1();
        switcher2();
        retorna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

    }


    public void openActivity() {

        Intent intent = new Intent(this, Casa.class);
        startActivity(intent);

    }
}