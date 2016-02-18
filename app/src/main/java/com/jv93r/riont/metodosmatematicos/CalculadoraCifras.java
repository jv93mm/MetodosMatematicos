package com.jv93r.riont.metodosmatematicos;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by riont on 27/01/16.
 */
public class CalculadoraCifras extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora_cifras);

        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        final EditText editNum = (EditText) findViewById(R.id.editNum);
        final EditText editCifras = (EditText) findViewById(R.id.editCifras);
        final TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
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
                        txtResultado.setText("Redondeado:"
                                + redondeado + " Truncado:" + truncado);
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
    }
}
