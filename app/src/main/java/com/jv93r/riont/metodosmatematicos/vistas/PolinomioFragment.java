package com.jv93r.riont.metodosmatematicos.vistas;


import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jv93r.riont.metodosmatematicos.R;
import com.jv93r.riont.metodosmatematicos.utilidades.Polinomio;

/**
 * Created by riont on 30/01/16.
 */
public class PolinomioFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_polinomio,container,false);
        final EditText editPol = (EditText) v.findViewById(R.id.editPolinomio);
        final EditText editEval = (EditText) v.findViewById(R.id.editEvaluarX);
        final TextView txtPol = (TextView) v.findViewById(R.id.txtPolinomio);
        Button btnCalcular = (Button) v.findViewById(R.id.btnCalcularPolinomio);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editEval.getText().toString().isEmpty() && editPol.getText().toString().isEmpty()){
                    Snackbar.make(v, "Campos Vacios... Rellene los campos", Snackbar.LENGTH_SHORT).show();
                }else{
                    Polinomio polinomio = new Polinomio(editPol.getText().toString()
                            ,Double.parseDouble(editEval.getText().toString()));
                    txtPol.setText(String.valueOf(polinomio.getResultado()));
                }
            }
        });
        return v;
    }
}
