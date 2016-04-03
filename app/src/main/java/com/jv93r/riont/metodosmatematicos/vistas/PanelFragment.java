package com.jv93r.riont.metodosmatematicos.vistas;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jv93r.riont.metodosmatematicos.R;

/**
 * Created by riont on 02/04/2016.
 */
public class PanelFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.panel_activity,container,false);
        inicializar(v);
        return v;
    }
    void inicializar(View v){
        if(MainActivity.devices.equals("phone")){
            Button btnCalculator = (Button) v.findViewById(R.id.btnCS);
            btnCalculator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment calculadora = new CifrasFragment();
                    cambiarFragment(R.id.contenido, calculadora);
                }
            });
            Button btnPolinmio = (Button) v.findViewById(R.id.btnPolinomio);
            btnPolinmio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment calculadora = new PolinomioFragment();
                    cambiarFragment(R.id.contenido,calculadora);
                }
            });
        }else if(MainActivity.devices.equals("tablet")){
            Button btnCalculator = (Button) v.findViewById(R.id.btnCS);
            btnCalculator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment f = new CifrasFragment();
                    cambiarFragment(R.id.panelB,f);
                }
            });
            Button btnPolinmio = (Button) v.findViewById(R.id.btnPolinomio);
            btnPolinmio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment f = new PolinomioFragment();
                    cambiarFragment(R.id.panelB, f);
                }
            });
        }
    }
    private void cambiarFragment(int id,Fragment fragment){
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.replace(id,fragment);
        ft.addToBackStack(null);

        ft.commit();
    }
}
