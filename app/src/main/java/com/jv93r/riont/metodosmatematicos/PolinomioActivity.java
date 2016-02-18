package com.jv93r.riont.metodosmatematicos;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by riont on 30/01/16.
 */
public class PolinomioActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polinomio);

        final EditText editPol = (EditText) findViewById(R.id.editPolinomio);
        final EditText editEval = (EditText) findViewById(R.id.editEvaluarX);
        final TextView txtPol = (TextView) findViewById(R.id.txtPolinomio);
        Button btnCalcular = (Button) findViewById(R.id.btnCalcularPolinomio);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editEval.getText().toString().isEmpty() && editPol.getText().toString().isEmpty()){
                    Snackbar.make(v,"Campos Vacios... Rellene los campos",Snackbar.LENGTH_SHORT).show();
                }else{
                    Polinomio polinomio = new Polinomio(editPol.getText().toString()
                            ,Double.parseDouble(editEval.getText().toString()));
                    txtPol.setText(String.valueOf(polinomio.getResultado()));
                }
            }
        });
    }
}
