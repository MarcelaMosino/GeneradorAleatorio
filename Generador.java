/*
 * Clase Generadora
 */

//Importamos la clase io
import java.io.*;

public class Generador {
    //Creamos el objeto Validación
    static Validacion v = new Validacion();
    //Creamos las variables
    private long m, h, d, a;
    ///Creamos un arreglo
    private long[] numeros;

    //Método de Bienvenida!
    public void inicio(){
        String c= "El siguiente programa genera numeros aleatorios\n";
        c += "utilizando el método multiplicativo decimal(MMD)\n";
        c += "y los guarda en un archivo de texto";
        v.msg(c);
    }
    
    //Generar numeros aleatorios
    public void calculaD(int n){
        if(n<=500)
            d=4;
        else
            d = Math.round(1+Math.log10(n*2)+.9999999);
    }
    //Calculando los números
    public void calculaHMA(){
        
        int t = v.obtenT();
      
        int p = v.obtenP();
        h = Math.round(5*Math.pow(10, d-2));
        m = Math.round(Math.pow(10,d));
        if(t%2==0)
            a = Math.abs((200*t)+p);
        else
            a = Math.abs((200*t)-p);
    }
     //Obtenemos los números impares
    public long obtenSemilla(){
        long valor=0;

        do{
            valor = v.impar(m);
        } while((valor%5)==0);
        return valor;
    }
    //Recorre el arreglo
    public long calculaNumero(){
        long n0 =obtenSemilla();
        numeros = new long[(int)h];

        numeros[0] = n0;
        for(int i=1; i<h; i++)
            numeros[i]= (numeros[i-1]*a)%m;
        return 0;
    }
    //Método main
    public static void main(String[] args)throws IOException{
        Generador g =new Generador();
        int r;
        int n;
        //Menú donde se llaman todos los métodos y lo imprime en el archivo
        g.inicio();
        do{
            n = v.capInt("Periodo mínimo a generar");
            g.calculaD(n);
            g.calculaHMA();
            g.calculaNumero();
            System.out.println(v.imprimeArreglo(g.h, g.numeros));
            r = v.pregunta("Generar más numeros?");
        }while(r ==0);
    }
}
