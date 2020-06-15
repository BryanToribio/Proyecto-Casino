package com.example.seven_main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Inicio extends AppCompatActivity implements View.OnClickListener {
Button btnEliminar,btnEditar,btnMostrar,btnSalir;
TextView nombre;
int id=0;
Usuario y;
SecondUsuario second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        nombre=(TextView)findViewById(R.id.nombreUsuario);
        btnEditar=(Button)findViewById(R.id.btnEditar);
        btnEliminar=(Button)findViewById(R.id.btnEliminar);
        btnMostrar=(Button)findViewById(R.id.btnMostrar);
        btnSalir=(Button)findViewById(R.id.btnSalir);

        btnEliminar.setOnClickListener(this);
        btnEditar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);


        Bundle b= getIntent().getExtras();
        id=b.getInt("Id");
        second=new SecondUsuario(this);
        y=second.getUsuariobyId(id);
        nombre.setText(y.getNombre()+""+y.getApellidos());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEliminar:
                break;
            case R.id.btnEditar:
                Intent a = new Intent(Inicio.this,Editar.class);
                startActivity(a);
                break;
            case R.id.btnMostrar:
                Intent c = new Intent(Inicio.this,Editar.class);
                startActivity(c);
                break;
            case R.id.btnSalir:
                Intent i2 = new Intent(Inicio.this,Editar.class);
                startActivity(i2);
                break;

        }

    }
}
