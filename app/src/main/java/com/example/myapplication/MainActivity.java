package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;


public class MainActivity extends AppCompatActivity {


    private ImageButton botaopai, botaomae, botaofilha, botaofilho;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide(); //Esconde a barra de acoes


        setContentView(R.layout.activity_main);


        sp = getSharedPreferences("Valores", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();

        editor.putBoolean("pai", false);
        editor.putBoolean("mae", false);
        editor.putBoolean("filha", false);
        editor.putBoolean("filho", false);
        editor.commit();


        botaopai = (ImageButton) findViewById(R.id.imageButtonPai);
        botaopai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitysenhapai();
            }
        });

        botaomae = (ImageButton) findViewById(R.id.imageButtonMae);
        botaomae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitysenhamae();
            }
        });

        botaofilha = (ImageButton) findViewById(R.id.imageButtonFilha);
        botaofilha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitysenhafilha();
            }
        });

        botaofilho = (ImageButton) findViewById(R.id.imageButtonFilho);
        botaofilho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitysenhafilho();
            }
        });


    }

    public void openActivitysenhapai() {

        Intent intent = new Intent(this, LoginPai.class);
        startActivity(intent);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("pai", true);
        editor.commit();

    }

    public void openActivitysenhamae() {

        Intent intent = new Intent(this, LoginMae.class);
        startActivity(intent);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("mae", true);
        editor.commit();

    }

    public void openActivitysenhafilha() {

        Intent intent = new Intent(this, LoginFilha.class);
        startActivity(intent);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("filha", true);
        editor.commit();

    }

    public void openActivitysenhafilho() {

        Intent intent = new Intent(this, LoginFilho.class);
        startActivity(intent);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("filho", true);
        editor.commit();

    }


}

