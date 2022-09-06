package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.Objects;

public class Casa extends AppCompatActivity {

    static String MQTTHOST = "tcp://driver.cloudmqtt.com:18985";
    static String USERNAME = "kmpiqynt";
    static String PASSWORD = "p0O_Fho_Dbho";
    String topicStr = "LED";
    MqttAndroidClient client;


    boolean quartofilhab, banheirofilhosb, quartofilhob, salab, corredorb, cozinhab, quartopaisb, banheiropaisb;
    ToggleButton quartofilha, banheirofilhos, quartofilho, sala, corredor, cozinha, quartopais, banheiropais;
    String message, topic = topicStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_casa);
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml("<font color=\"#1C1C1C\">" + "Minha Casa" + "</font>"));

        quartofilha = (ToggleButton) findViewById(R.id.quartofilha);
        banheirofilhos = (ToggleButton) findViewById(R.id.banheirofilhos);
        quartofilho = (ToggleButton) findViewById(R.id.quartofilho);
        sala = (ToggleButton) findViewById(R.id.sala);
        corredor = (ToggleButton) findViewById(R.id.corredor);
        cozinha = (ToggleButton) findViewById(R.id.cozinha);
        quartopais = (ToggleButton) findViewById(R.id.quartopais);
        banheiropais = (ToggleButton) findViewById(R.id.banheiropais);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("Valores", Context.MODE_PRIVATE);

        Boolean pai = sp.getBoolean("pai", true);
        Boolean mae = sp.getBoolean("mae", true);
        Boolean filha = sp.getBoolean("filha", true);
        Boolean filho = sp.getBoolean("filho", true);

        quartofilha.setEnabled(filha || mae || pai);
        banheirofilhos.setEnabled(mae || pai);
        quartofilho.setEnabled(filho || mae || pai);
        sala.setEnabled(filho || filha || mae || pai);
        corredor.setEnabled(filho || filha || mae || pai);
        cozinha.setEnabled(filho || filha || mae || pai);
        quartopais.setEnabled(pai || mae);
        banheiropais.setEnabled(pai || mae);



    /*
        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), MQTTHOST, clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());

        try {
            IMqttToken token = client.connect(options);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Toast.makeText(Casa.this, "Conectado ao Servidor", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Toast.makeText(Casa.this, "Desconectado", Toast.LENGTH_SHORT).show();

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }







        quartofilha = (ToggleButton) findViewById(R.id.quartofilha);
        quartofilha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quartofilhab) {
                    message = "D1";
                    quartofilhab = false;
                } else {
                    message = "L1";
                    quartofilhab = true;
                }
                try {
                    client.publish(topic, message.getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });

        banheirofilhos = (ToggleButton) findViewById(R.id.banheirofilhos);
        banheirofilhos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (banheirofilhosb) {
                    message = "D1";
                    banheirofilhosb = false;
                } else {
                    message = "L1";
                    banheirofilhosb = true;
                }
                try {
                    client.publish(topic, message.getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });

        quartofilho = (ToggleButton) findViewById(R.id.quartofilho);
        quartofilho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quartofilhob) {
                    message = "D1";
                    quartofilhob = false;
                } else {
                    message = "L1";
                    quartofilhob = true;
                }
                try {
                    client.publish(topic, message.getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });

        sala = (ToggleButton) findViewById(R.id.sala);
        sala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (salab) {
                    message = "D1";
                    salab = false;
                } else {
                    message = "L1";
                    salab = true;
                }
                try {
                    client.publish(topic, message.getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });

        corredor = (ToggleButton) findViewById(R.id.corredor);
        corredor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (corredorb) {
                    message = "D1";
                    corredorb = false;
                } else {
                    message = "L1";
                    corredorb = true;
                }
                try {
                    client.publish(topic, message.getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });

        cozinha = (ToggleButton) findViewById(R.id.cozinha);
        cozinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cozinhab) {
                    message = "D1";
                    cozinhab = false;
                } else {
                    message = "L1";
                    cozinhab = true;
                }
                try {
                    client.publish(topic, message.getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });

        quartopais = (ToggleButton) findViewById(R.id.quartopais);
        quartopais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quartopaisb) {
                    message = "D1";
                    quartopaisb = false;
                } else {
                    message = "L1";
                    quartopaisb = true;
                }
                try {
                    client.publish(topic, message.getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });

        banheiropais = (ToggleButton) findViewById(R.id.banheiropais);
        banheiropais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (banheiropaisb) {
                    message = "D1";
                    banheiropaisb = false;
                } else {
                    message = "L1";
                    banheiropaisb = true;
                }
                try {
                    client.publish(topic, message.getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });
    */
    }




    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.configuracoes, menu);
        return true;
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.retorna:
                Intent intent0 = new Intent(this, MainActivity.class);
                startActivity(intent0);
                return true;

            case R.id.hallway:
                Intent intent1 = new Intent(this, Corredor.class);
                startActivity(intent1);
                return true;

            case R.id.kitchen:
                Intent intent2 = new Intent(this, Cozinha.class);
                startActivity(intent2);
                return true;

            case R.id.daughteroom:
                Intent intent3 = new Intent(this, QuartoFilha.class);
                startActivity(intent3);
                return true;

            case R.id.siblinsbathroom:
                Intent intent4 = new Intent(this, BanheiroFilhos.class);
                startActivity(intent4);
                return true;

            case R.id.sonroom:
                Intent intent5 = new Intent(this, QuartoFilho.class);
                startActivity(intent5);
                return true;

            case R.id.parentroom:
                Intent intent6 = new Intent(this, QuartoPais.class);
                startActivity(intent6);
                return true;

            case R.id.parentbathroom:
                Intent intent7 = new Intent(this, BanheiroPais.class);
                startActivity(intent7);
                return true;

            case R.id.livingroom:
                Intent intent8 = new Intent(this, Sala.class);
                startActivity(intent8);
                return true;
        }
        return true;
    }
}




