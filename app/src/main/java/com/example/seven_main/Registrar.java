package com.example.seven_main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity implements View.OnClickListener {
EditText us,pas, nom,ap;
Button reg, can;
SecondUsuario second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        us=(EditText)findViewById(R.id.RegUser);
        pas=(EditText)findViewById(R.id.RegPass);
        nom=(EditText)findViewById(R.id.RegNombre);
        ap=(EditText)findViewById(R.id.RegApellido);
        reg=(Button)findViewById(R.id.btnRegRegistrar);
        can=(Button)findViewById(R.id.btnRegCancelar);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        second = new SecondUsuario(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegRegistrar:
                Usuario y = new Usuario();
                y.setUsuarios(us.getText().toString());
                y.setPassword(pas.getText().toString());
                y.setNombre(nom.getText().toString());
                y.setApellidos(ap.getText().toString());
                if(!y.isNull()){ //validamos los valores
                    Toast.makeText(this,"campos vacios",Toast.LENGTH_LONG).show();
                }else if(second.insertUsuario(y)){
                    Toast.makeText(this,"registro exitoso",Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(Registrar.this,MainActivity.class);
                    startActivity(i2);
                    finish();
                }else {
                    Toast.makeText(this,"usuarios ya registrado",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnRegCancelar:
                Intent i=new Intent(Registrar.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}
