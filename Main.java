import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        VectorHeap<Paciente> emergencyQueue = new VectorHeap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String nombre = parts[0].trim();
                    String sintoma = parts[1].trim();
                    char codigoEmergencia = parts[2].trim().charAt(0);
                    Paciente paciente = new Paciente(nombre, sintoma, codigoEmergencia);
                    emergencyQueue.add(paciente);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (emergencyQueue.size() > 0) {
            Paciente nextPatient = emergencyQueue.remove();
            System.out.println(nextPatient.getNombre() + ", " + nextPatient.getSintoma() + ", " + nextPatient.getCodigoEmergencia());
        }
    }
}