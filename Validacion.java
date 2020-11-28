import javax.swing.*;
import java.io.*;

public class Validacion {
    Lector datos; // Se crea lector para leer parametros

    public void msg(String ms){
        // Muestra un dialogo con el mensaje (ms)
        JOptionPane.showMessageDialog(null, ms, "Generador MMD", -1);
    }

    public int pregunta(String msg){
        // Pregunta cerrada (si, no) con mensaje (msg)
        return JOptionPane.showConfirmDialog(null,msg,
                "", JOptionPane.YES_NO_OPTION);
    }

    /**
     * Verifica que cad sea numerico
     * @param cad
     * @return isNum
     */
    public boolean isNum(String cad){
        try {
            // Se intenta parsear a entero
            Integer.parseInt(cad);
            // Si es posible, entonces es numerico
            return true;
        }catch(NumberFormatException nfe){
            // Se muestra mensaje de error
            JOptionPane.showMessageDialog(null,"Solo entrada numérica",
                    "Numeros mayores a 500", 0);
            // Se regresa falso, ya que no es numerico
            return false;
        }
    }

    /**
     * Captura un entero
     * @param msg
     * @return int
     */
    public int capInt(String msg){
        // String temporal para guardar el input
        String aux;
        do{
            // Se obtiene captura de usuario
            aux = JOptionPane.showInputDialog(msg);
            // Se repite hasta que se ingrese un entero
        } while(!isNum(aux));
        // Se regresa el input del usuario transformado a entero
        return Integer.parseInt(aux);
    }

    public long impar(long m){
        // Verifica que ya se hayan leido los parametros
        if (datos == null) readData();
        // Regresa el parametro pedido
        return datos.getImpar();
    }

    public int obtenP(){
        // Verifica que ya se hayan leido los parametros
        if (datos == null) readData();
        // Regresa el parametro pedido
        return datos.getP();
    }

    public int obtenT(){
        // Verifica que ya se hayan leido los parametros
        if (datos == null) readData();
        // Regresa el parametro pedido
        return datos.getT();
    }

    /**
     * Se leen los parametros de un archivo
     */
    private void readData() {
        // Se insancia objeto Lector
        datos = new Lector();
        // Se leen los parametros
        datos.readParameters();
    }

    /**
     * Escribe los numeros aleatorios
     * @param h
     * @param arreglo
     * @return String
     * @throws IOException
     */
    public String imprimeArreglo(long h, long[]arreglo)throws IOException{
        String cadenota ="";
        Archivo a = new Archivo();

        // Se agregan todos los elementos a un string con el formato
        // adecuado
        for(int i=0; i<h;i++){
            if((i+1)!=h)
                // Se le agrega una (,) si hay un elemento despues
                cadenota += arreglo[i]+",";
            else
                // Si no hay nada despues no se agrega nada
                cadenota += arreglo[i];
            if(i%20==0&&i!=0)
                // Cada 20 elementos se inserta un salto de linea
                cadenota +="\n";
        } a.escribir(cadenota); // Se escribe (cadenota) al archivo

        cadenota += "\n";
        return cadenota; // Regresa cadenota para imprimir a consola
    }
}
