import javax.swing.*; // importamos la clase Swing
import java.io.*;  // importamos la clase io

public class Archivo {
    File f1, f;
    String nombre; 
    Validacion v = new Validacion(); // Creamos el objecto Validacion

    public void escribir(String c)throws IOException{
        nombre = JOptionPane.showInputDialog("Nombre del archivo "
                +"en que se guardaran los numeros generados"); // Buscamos el archivo
        f1 = new File(nombre); //
        int r;

        if(f1.exists()){
            r = v.pregunta("Sobreescribir archivo"); // Preguntamos si sobre escribimos en el archivo encontrado
            if(r == 0) // Si cierto eliminamos el contenido del archivo
                f1.delete();
            else // Y lo guardamos con un nuevo nombre
                nombre = nombreNuevo();
        }
        f = new File(nombre); // Si no es encuntra el archivo creamos uno nuevo
        escribeArchivo(c);
    }

    public void escribeArchivo(String c)throws IOException{
        FileWriter fw = new FileWriter(f); fw.flush(); // Creamos el nuevo objecto fw
        BufferedWriter bw = new BufferedWriter(fw); // Creamos el nuevo objecto bw

        // Escribimos en el archivo 
        fw.write(c);
        // Cerramos el archivo
        fw.close();
    }

    public String nombreNuevo(){
        String n;
        do{
            n = JOptionPane.showInputDialog("Nombre del nuevo archivo"); // ingresamos el nuevo nombre del archivo
            f1 = new File(n); // Creamos el nuevo archivo
        } while(f1.exists());
        return n;
    }
}
