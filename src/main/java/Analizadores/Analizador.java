package Analizadores;
import java.io.*;
import java.util.ArrayList;

public class Analizador {
    //variable donde se almacena la ruta con el archivo de estudiantes en formato csv
    private String ruta;

    //lista de estudiantes que almacena los estudiantes en formato json
    private ArrayList<String> estudiantes;

    //constructor de analizador
    public Analizador(String ruta) {
        this.ruta = ruta;
        this.estudiantes = new ArrayList<>();
    }

    //metodo que verifica si el formato es csv
    public boolean verificarFormato() {
        File archivo = new File(this.ruta);
        String[] formatoSplit = archivo.getName().split("\\.");
        return formatoSplit.length > 1 && formatoSplit[formatoSplit.length - 1].toLowerCase().equals("csv");
    }

    //metodo que invoca la verificacion del formato como medida inicial,
    //ademas de leer un archivo,formar la estructura de json para los datos de los estudiantes y guardarlos en una lista
    //escribe en el nuevo archivo.json la lista donde guardamos los datos de dicho formato
    public void conversor() {
        try {
            if (verificarFormato()) {
                File archivo = new File(this.ruta);

                BufferedReader lector = new BufferedReader(new FileReader(archivo));
                BufferedWriter traductor = new BufferedWriter(new FileWriter("C:/Users/jeison Franco/IdeaProjects/Tarea3_JeisonSFrancoC/src/software1_pruebas/estudiantes.json"));

                String linea;
                while ((linea = lector.readLine()) != null) {
                    String[] datos = linea.split(",");
                    String formatoJSON = "{\"id\":\"" + datos[0] + "\",\"nombre\":\"" + datos[1] + "\",\"apellido\":\"" + datos[2] + "\"}";
                    this.estudiantes.add(formatoJSON);
                }
                traductor.write(String.valueOf(this.estudiantes));
                traductor.newLine();

                lector.close();
                traductor.close();
            } else {
                System.out.println("No es un formato soportado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //devuelve la lista que generamos con los datos transformados al formato json
    public ArrayList<String> getEstudiantes() {
        return this.estudiantes;
    }
}