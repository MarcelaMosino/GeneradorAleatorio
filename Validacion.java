package MotorPseudoAleatorio;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Validacion {
    Random ale = new Random();
    
    public void msg(String ms){
        JOptionPane.showMessageDialog(null, ms, "Generador MMD", -1);
    }
    
    public int pregunta(String msg){
        return JOptionPane.showConfirmDialog(null,msg,
                "", JOptionPane.YES_NO_OPTION);
    }
    
    public boolean isNum(String cad){
        try {
            Integer.parseInt(cad);
            return true;
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null,"Solo entrada numérica",
                    "Numeros mayores a 500", 0);
            return false;
        }
    }
    
    public int capInt(String msg){
        String aux;
        do{
            aux = JOptionPane.showInputDialog(msg);
        } while(!isNum(aux));
        return Integer.parseInt(aux);
    }
    
    public long impar(long m){
        float a = ale.nextFloat()*m;
        long b = (2*(int)a+1)%m;
        return b;
    }  
    
    public int obtenP(){        
        int[] valores = {3,11,13,19,21,27,29,37,53,59,61,67,69,77,83,91};
        int index = (int)ale.nextFloat()*16;
        return valores[index];
    }
    
    public int obtenT(){
        return Math.abs(ale.nextInt(100));
    }
    
    public String imprimeArreglo(long h, long[]arreglo)throws IOException{
        String cadenota ="";
        Archivo a = new Archivo();
        
        for(int i=0; i<h;i++){
            if((i+1)!=h)
                cadenota += arreglo[i]+",";
            else 
                cadenota += arreglo[i];
            if(i%20==0&&i!=0)
                cadenota +="\n";
        } a.escribir(cadenota);
        cadenota += "\n";        
        return cadenota;
    }
}
