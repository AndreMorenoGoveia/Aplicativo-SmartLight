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

public class Sala extends AppCompatActivity {

    ImageView image;
    SwitchMaterial button;
    Boolean estado = false;
    ImageButton retorna;

    public void switcher(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (estado) {
                    image.setImageResource(R.drawable.salaapagada);
                    estado = false;
                } else {
                    image.setImageResource(R.drawable.salaacesa);
                    estado = true;
                }
            }
        });

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide(); //Esconde a barra de acoes

        setContentView(R.layout.activity_sala);

        image = (ImageView) findViewById(R.id.corredorsolo);
        button = (SwitchMaterial) findViewById(R.id.switch1);
        retorna = (ImageButton) findViewById((R.id.retornabutton));
        switcher();
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
