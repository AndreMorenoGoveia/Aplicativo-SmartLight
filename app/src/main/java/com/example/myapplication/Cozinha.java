package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Cozinha extends AppCompatActivity {

    ImageView image;
    SwitchMaterial button, auto;
    Boolean estado = false, autob = false;
    ImageButton retorna;

    public void switcher1(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (estado) {
                    image.setImageResource(R.drawable.cozinhaapagada);
                    estado = false;
                } else {
                    image.setImageResource(R.drawable.cozinhaacesa);
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
                        image.setImageResource(R.drawable.cozinhaacesa);
                    }
                    else{
                        image.setImageResource(R.drawable.cozinhaapagada);
                    }
                    autob = false;
                } else {
                    image.setImageResource(R.drawable.cozinhaauto);
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

        setContentView(R.layout.activity_cozinha);

        image = (ImageView) findViewById(R.id.corredorsolo);
        button = (SwitchMaterial) findViewById(R.id.switch1);
        auto = (SwitchMaterial) findViewById(R.id.switch2);
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