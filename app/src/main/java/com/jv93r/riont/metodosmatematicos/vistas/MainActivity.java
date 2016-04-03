package com.jv93r.riont.metodosmatematicos.vistas;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.jv93r.riont.metodosmatematicos.R;

public class MainActivity extends AppCompatActivity {

    public static String devices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

    //gola mundo
        View view = findViewById(R.id.contenido);
        devices = String.valueOf(view.getTag());

        if(devices.equals("phone")){
           cambiarFragment(R.id.contenido,new PanelFragment());
        }else if(devices.equals("tablet")){
           cambiarFragment(R.id.panelA,new PanelFragment());
        }
    }
    private void cambiarFragment(int id,Fragment fragment){
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.replace(id,fragment);
        ft.addToBackStack(null);

        ft.commit();
    }
}
