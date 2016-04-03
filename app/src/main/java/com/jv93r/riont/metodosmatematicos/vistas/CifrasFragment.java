package com.jv93r.riont.metodosmatematicos.vistas;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jv93r.riont.metodosmatematicos.R;
import com.jv93r.riont.metodosmatematicos.utilidades.CifrasSignificativas;


/**
 * Created by riont on 27/01/16.
 */
public class CifrasFragment extends Fragment{
    public CifrasFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cifras,container,false);
        Button btnCalcular = (Button) v.findViewById(R.id.btnCalcular);
        final EditText editNum = (EditText) v.findViewById(R.id.editNum);
        final EditText editCifras = (EditText) v.findViewById(R.id.editCifras);
        final TextView txtResultado = (TextView) v.findViewById(R.id.txtResultado);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtNum = editNum.getText().toString();
                String txtCifras = editCifras.getText().toString();
                if (!txtNum.isEmpty() && !txtCifras.isEmpty()) {
                    CifrasSignificativas cs = new CifrasSignificativas();
                    double num = Double.parseDouble(txtNum);
                    int cifras = Integer.parseInt(txtCifras);
                    if (cifras > 0 && num > 0.0f) {
                        String truncado = cs.trucamiento(num, cifras) + "";
                        String redondeado = cs.redondear(num, cifras) + "";
                        String msj = "Redondeado:"
                                + redondeado + " Truncado:" + truncado;
                        txtResultado.setText(msj);
                    } else {
                        Snackbar.make(v, "Datos Ingresados Invalidos", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                    }
                } else {
                    Snackbar.make(v, "Algo esta vacio... por favor rellene los formularios", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                }
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Siguiente instruccion da problemas en tablet
    }
}
