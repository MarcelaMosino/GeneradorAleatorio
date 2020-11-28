import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Lector
 * Clase que lee los parametros
 */
public class Lector {
    // Contendra el archivo a leer
    File in;

    // Parametros que se leeran
    private int p, t, impar;

    // Constructor: pregunta por el archivo a leer
    public Lector() {
        // Pregunta el nombre del archivo a leer
        String file = JOptionPane.showInputDialog("Nombre del archivo "
                +"del que se tomarán los datos");

        // Crea objeto de tipo file, con el nuevo archivo
        in = new File(file);
    }

    public int getImpar() {
        // Obtiene el parametro (impar)
        return impar;
    }

    public int getT() {
        // Obtiene el parametro (T)
        return t;
    }

    public int getP() {
        // Obtiene el parametro (P)
        return p;
    }

    /**
     * Lee los parametros del archivo
     */
    public void readParameters() {
        // Se instancia un lector de archivos
        Scanner scan;
        try {
            scan = new Scanner(in);

            // Se leen los parametros del algoritmo
            impar = scan.nextInt();
            t = scan.nextInt();
            p = scan.nextInt();
        } catch (FileNotFoundException e) {
            // Si ocurre un error se muestra su mensaje
            new Validacion().msg(e.getMessage());
        }
    }
}
