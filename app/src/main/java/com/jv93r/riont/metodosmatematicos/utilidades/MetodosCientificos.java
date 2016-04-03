package com.jv93r.riont.metodosmatematicos.utilidades;

/**
 * Created by riont on 27/01/16.
 */
public class MetodosCientificos {
    public MetodosCientificos() {
    }
    public static float errorAbsoluto(float valorVerdadero,float valorReal){
        return Math.abs(valorVerdadero - valorReal);
    }
    public static float errorRelativo(float valorVerdadero,float valorReal){
        return Math.abs(errorAbsoluto(valorVerdadero,valorReal) / valorReal);
    }
    public static float errorRelativoPorcentual(float valorVerdadero,float valorReal){
        return Math.abs(errorRelativo(valorVerdadero,valorReal) * 100);
    }
}
