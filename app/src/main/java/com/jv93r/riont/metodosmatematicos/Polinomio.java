package com.jv93r.riont.metodosmatematicos;

import android.renderscript.Script;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * Created by riont on 29/01/16.
 */
public class Polinomio {
    private final double x;
    private final String expresion;
    private float resultado;


    public Polinomio(String polinomio,double x) {
        this.expresion = polinomio.trim().toLowerCase();
        this.x = x;
        this.resultado = 0.0f;
        decifrarPolinomio();
    }
    private void decifrarPolinomio(){
        String ecuacionSimple = expresion.replace("+"," + ");
        ecuacionSimple = ecuacionSimple.replace("-"," - ");
        StringTokenizer st1 = new StringTokenizer(ecuacionSimple," ");
        int signo = 1;
        while (st1.hasMoreElements()){
            String aux = st1.nextToken();
            if(aux.charAt(0)=='+' && aux.length()==1){
                signo = 1;
            }else if(aux.charAt(0)=='-' && aux.length()==1){
                signo = -1;
            }else{
                if(aux.contains("x^")){
                    StringTokenizer stAux = new StringTokenizer(aux, "x^");
                    int operacions = stAux.countTokens();
                    String []num = new String[operacions];
                    int i =0;
                    while (stAux.hasMoreElements()){
                        num[i] = stAux.nextToken();
                        i++;
                    }
                    if(operacions == 2){
                        resultado += Math.pow(x,
                                Integer.parseInt(num[1])) * signo * Float.parseFloat(num[0]);
                    }else if(operacions==1){
                        resultado += Math.pow(x,
                                Integer.parseInt(num[0])) * signo;
                    }
                }else if(aux.contains("x")){
                    StringTokenizer stAux = new StringTokenizer(aux, "x");
                    int operacions = stAux.countTokens();
                    String num="";
                    while(stAux.hasMoreElements()){
                        num = stAux.nextToken();
                    }
                    if(!num.equalsIgnoreCase("")){
                        resultado+= signo *Float.parseFloat(num) *x;
                    }else{
                        resultado+=signo *x;
                    }
                }else{
                    resultado += signo * Float.parseFloat(aux);
                }
            }
        }
    }
    public String getExpresion(){
        return expresion;
    }
    public double getResultado(){
        return this.resultado;
    }
}
