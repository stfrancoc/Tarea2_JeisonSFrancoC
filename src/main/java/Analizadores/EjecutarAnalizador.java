package Analizadores;

import javax.swing.*;
import java.util.Scanner;

public class EjecutarAnalizador {
    public static void main(String[] args) {
        //opcion para pedir datos del usuario
        //String ruta = JOptionPane.showInputDialog("Ingrese la ruta");

        //scaner para pedir datos al usuario por la consola
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese la ruta");
        String rutaString = scanner.nextLine();

        //objeto de tipo analizador con la ruta que le pedimos al usuario
        Analizador analizador = new Analizador(rutaString);

        // ruta de pruebas
        //String rutaPruebas = "C:/Users/jeison Franco/IdeaProjects/Tarea3_JeisonSFrancoC/src/software1_pruebas/estudiantes.csv";

        //ejecucion de metodo conversor de la clase analizador del respectivo objeto que construimos con el dato del usuario
        analizador.conversor();
        //salida para comprobar la estructura de los estudiantes en json
        System.out.println(analizador.getEstudiantes());

    }
}
