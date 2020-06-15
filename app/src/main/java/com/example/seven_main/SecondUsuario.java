package com.example.seven_main;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class SecondUsuario {
    Context x;
    Usuario y;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String db= "DBUsuarios";
    String tabla= "create table if not exists usuario(id integer primary key autoincrement,usuario text, pass text, nombre text, ap text)";

    public SecondUsuario(Context x){
        this.x=x;
        //este comando mas va a ayudar a abrir la base de datos o crear la base de datos
        sql= x.openOrCreateDatabase(db,x.MODE_PRIVATE,null);
        sql.execSQL(tabla);
        y=new Usuario();
    }
    public boolean insertUsuario(Usuario y){
        if (buscar(y.getUsuarios())== 0) { //para que se pueda guardar los datos del cliente
            ContentValues cv = new ContentValues();
            cv.put("usuario", y.getUsuarios());
            cv.put("pass", y.getPassword());
            cv.put("nombre", y.getNombre());
            cv.put("app", y.getApellidos());
            return sql.insert("usuario", null, cv) > 0;

        }else{ //nos ayuda a dar resultado para ver si se registro correctamente
            return false;
        }
    }
    public int buscar (String y){
        int a=0;
        lista=selectUsuario();
        for(Usuario us:lista){
            if(us.getUsuarios().equals(y)){
                a++;
            }
        }
        return a;
    }
    public ArrayList<Usuario> selectUsuario(){
        ArrayList<Usuario> lista =new ArrayList<Usuario>();
        lista.clear();
        Cursor cr= sql.rawQuery("select * from usuario ",null);
        if (cr != null&&cr.moveToFirst()){
            do {
                Usuario y =new Usuario();
                y.setId(cr.getInt(0));
                y.setUsuarios(cr.getString(1));
                y.setPassword(cr.getString(2));
                y.setNombre(cr.getString(3));
                y.setApellidos(cr.getString(4));
                lista.add(y);
            }while (cr.moveToNext());
        }
        return lista;
    }
    public int login (String y, String p){
        int a=0;
        Cursor cr= sql.rawQuery("select * from usuario ",null);
        if (cr != null&&cr.moveToFirst()){
            do{
                if(cr != null&&cr.moveToFirst()){
                    a++;
                }
            }while (cr.moveToNext());
        }
        return a;
    }
    public Usuario getUsuario(String y,String p){
        lista=selectUsuario();
        for (Usuario yq:lista){
            if (yq.getUsuarios().equals(y)&&yq.getPassword().equals(p)){
                return yq;
            }
        }
        return null;
    }
    public Usuario getUsuariobyId(int id){
        lista=selectUsuario();
        for (Usuario yq:lista){
            if (yq.getId()==id){
                return yq;
            }
        }
        return null;
    }
}

