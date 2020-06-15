package com.example.seven_main;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText user, pass;
Button btnIngresar, btnRegistrar;
SecondUsuario second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.User);
        pass=(EditText)findViewById(R.id.Pass);
        btnIngresar=(Button)findViewById(R.id.btnIngresar);
        btnRegistrar=(Button)findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(this);
        btnIngresar.setOnClickListener(this);
        second = new SecondUsuario(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIngresar:
                String y=user.getText().toString();
                String p=pass.getText().toString();
                if (y.equals("")&&p.equals("")){
                    Toast.makeText(this,"Campos vacios",Toast.LENGTH_LONG).show();
                }else if (second.login(y,p)==1) {
                    Usuario ux = second.getUsuario(y, p);
                    Toast.makeText(this, "Datos Correctos", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(MainActivity.this, Inicio.class);
                    i2.putExtra("Id", ux.getId());
                    startActivity(i2);
                    finish();
                }else {
                    Toast.makeText(this, "usuario y/o password incorrectos", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnRegistrar:
                Intent i=new Intent(MainActivity.this,Registrar.class);
                startActivity(i);
                break;
        }
    }
}





























