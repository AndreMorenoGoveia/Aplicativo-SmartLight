package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPai extends AppCompatActivity {

    ImageButton retorna;
    Button entra;

    TextView senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide(); //Esconde a barra de acoes

        setContentView(R.layout.activity_login_pai);

         senha = (TextView) findViewById(R.id.senha);

        entra = (Button) findViewById(R.id.botaoentrar);
        entra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(senha.getText().toString().equals("pai")){
                    openActivityCasa();
                }
                else{
                    Toast.makeText(LoginPai.this, "Senha incorreta", Toast.LENGTH_SHORT).show();
                }
            }
        });


        retorna = (ImageButton) findViewById(R.id.retornabutton);
        retorna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMain();
            }
        });


    }


    public void openActivityMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openActivityCasa() {
        Intent intent = new Intent(this, Casa.class);
        startActivity(intent);
    }
}