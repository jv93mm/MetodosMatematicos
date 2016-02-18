package com.jv93r.riont.metodosmatematicos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

/**
 * Created by riont on 25/01/16.
 */
public class CifrasSignificativas {
    private int parteEntera;
    private double parteDecimal;
    public CifrasSignificativas() {
    }
    public double trucamiento(double num, int digitos){
        String aux = String.valueOf(num);
        if(digitos < aux.length() -1){
            aux = aux.replace(",",".");
            StringTokenizer st = new StringTokenizer(aux,".");
            int i =0;
            aux = "";
            boolean ban = false;
            boolean punto = false;
            while(st.hasMoreElements() && !ban){
                String s = st.nextToken();
                int j = 0;
                while(!ban && j < s.length()){
                    aux = aux+s.charAt(j);
                    j++;
                    if(j == s.length() && !punto){
                        aux = aux + ".";
                        punto = true;
                    }
                    if(i+ j >= digitos){
                        ban = true;
                    }
                }
                i+=j;
            }
        }
        return Double.parseDouble(aux);
    }
    public double redondear(double num,int digitos){
        String aux =""+num;
        if(aux.length() - 1 > digitos) {
            formarMantisa(num);
            String entero = "" + parteEntera;
            String decimal = "" + parteDecimal;
            if(digitos <entero.length()){
                int i =0;
                aux = "";
                while(i < digitos){
                    aux = aux + entero.charAt(i);
                    i++;
                }
            }else{
                double result = Double.parseDouble(entero) + Double.parseDouble(new BigDecimal(decimal)
                        .setScale(digitos-entero.length(), RoundingMode.HALF_EVEN).toString());
                aux = "" + result;
            }
        }
        return Double.parseDouble(aux);
    }
    private void formarMantisa(double num){
       String aux = num + "";
        String entero ="";
        String decimal = "";
        int i =0;
        while(aux.charAt(i)!='.' && i < aux.length()){
            entero = entero + aux.charAt(i);
            i++;
        }
        decimal = aux.substring(i,aux.length());
        this.parteEntera = Integer.parseInt(entero);
        this.parteDecimal = Double.parseDouble(decimal);
    }
    public int getParteEntera(){
        return this.parteEntera;
    }
    public double getParteDecimal(){
        return this.parteDecimal;
    }
}
