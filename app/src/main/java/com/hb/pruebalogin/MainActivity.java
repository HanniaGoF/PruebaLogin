package com.hb.pruebalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String user, password;
    EditText us, pass;
    Button login, regis;
    TextView verify;
    SharedPreferences pref;//=getSharedPreferences("datos", MODE_PRIVATE);
    SharedPreferences.Editor editor;//=pref.edit();
    int contador=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref=getSharedPreferences("datos", MODE_PRIVATE);
        editor=pref.edit();
        /*editor.putString("user1","hannia");
        editor.putString("user2","hb");
        editor.putString("pass","12");
        editor.putString("pass2","123");*/
        editor.commit();//cerrado del archivo
        us=(EditText)findViewById(R.id.usuario);
        pass=(EditText)findViewById(R.id.contraseña);
        login=(Button)findViewById(R.id.ingresar);
        verify=(TextView)findViewById(R.id.verificacion);
        regis=(Button)findViewById(R.id.registros);
        //secret=(ImageView)findViewById(R.id.check);
        //salir=(Button)findViewById(R.id.iniciar);
    }

    public void ingreso(View view) {
        String nombre, pas;
        nombre = us.getText().toString();
        pas = pass.getText().toString();
        String usr1, pass1;
        //////////////metodo rapido
        usr1 = pref.getString(us.getText().toString(), "-");
        if (usr1.equals(pass.getText().toString()))
        {
            verify.setText("ya entraste");
            Intent i = new Intent(this, Principal.class);
            i.putExtra("userExtra",usr1);
            startActivity(i);
        }
        else
            verify.setText("datos erroneos");
        //////metodo lento
        /*contador=pref.getInt("contador",0);
        for(int i=1;i<=contador;i++){
            usr1=pref.getString("user "+i,"-");
            if(!usr1.equals("-") && usr1.equals(nombre)){
                pass1=pref.getString("pass "+i,"-");
                if (pass1.equals(pas)){
                    Toast.makeText(this,"hola xd "+nombre,Toast.LENGTH_SHORT).show();
                }
            }
        }*/
        if(nombre.equals(user)&&pas.equals(password))
        {
            Toast.makeText(this,"hola xd "+nombre,Toast.LENGTH_SHORT).show();
            verify.setText("si entro");
            regis.setVisibility(View.INVISIBLE);
            //secret.setVisibility(View.VISIBLE);
            login.setVisibility(View.INVISIBLE);
            //salir.setVisibility(View.VISIBLE);
            us.setText("");
            pass.setText("");
        }
        else
        {
            Toast.makeText(this,"user "+nombre+"\n pass: "+pass,Toast.LENGTH_SHORT).show();
            verify.setText("no existe");
            regis.setVisibility(View.VISIBLE);
        }
    }

    public void registro(View view) {
        user=us.getText().toString();
        password=pass.getText().toString();
        verify.setText("te has registrado");
        String usr=pref.getString(us.getText().toString(),"-");
        if (!usr.equals("-"))
        {
            editor.putString(us.getText().toString(),pass.getText().toString());
            editor.commit();
        }
        else
            verify.setText("ya estas registrado");
    }
}