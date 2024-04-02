/**
 * Fernando Ruiz
 * 23065
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * Clase principal que maneja el sistema de atención de pacientes en la sección de Emergencias de un hospital.
 */
public class Main {
    /**
     * Método principal que lee los datos de los pacientes desde un archivo, los agrega a una cola de prioridad
     * y luego los imprime en orden de prioridad.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Crear una cola de prioridad para almacenar a los pacientes
        PriorityQueue<Paciente> emergencyQueue = new PriorityQueue<>();
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String line;
            // Leer cada línea del archivo de pacientes
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                // Verificar si la línea tiene el formato correcto
                if (parts.length == 3) {
                    String nombre = parts[0].trim();
                    String sintoma = parts[1].trim();
                    char codigoEmergencia = parts[2].trim().charAt(0);
                    // Crear un nuevo paciente y agregarlo a la cola de prioridad
                    Paciente paciente = new Paciente(nombre, sintoma, codigoEmergencia);
                    emergencyQueue.add(paciente);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir los pacientes en orden de prioridad
        while (!emergencyQueue.isEmpty()) {
            Paciente nextPatient = emergencyQueue.poll();
            System.out.println(nextPatient.getNombre() + ", " + nextPatient.getSintoma() + ", " + nextPatient.getCodigoEmergencia());
        }
    }
}