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

public class LoginFilha extends AppCompatActivity {

    ImageButton retorna;
    Button entra;

    TextView senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        setContentView(R.layout.activity_login_filha);

        senha = (TextView) findViewById(R.id.senha);

        entra = (Button) findViewById(R.id.botaoentrar);
        entra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(senha.getText().toString().equals("filha")){
                    openActivityCasa();
                }
                else{
                    Toast.makeText(LoginFilha.this, "Senha incorreta", Toast.LENGTH_SHORT).show();
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