import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pruebas {

    @Test
    public void testAgregarPaciente() {
        VectorHeap<Paciente> cola = new VectorHeap<>();
        cola.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        assertEquals(1, cola.size());
    }

    @Test
    public void testEliminarPaciente() {
        VectorHeap<Paciente> cola = new VectorHeap<>();
        cola.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        Paciente pacienteEliminado = cola.remove();
        assertEquals("Juan Perez", pacienteEliminado.getNombre());
    }

    @Test
    public void testPrioridadPacientes() {
        VectorHeap<Paciente> cola = new VectorHeap<>();
        cola.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        cola.add(new Paciente("Maria Ramirez", "apendicitis", 'A'));
        cola.add(new Paciente("Lorenzo Toledo", "chikungunya", 'E'));
        assertEquals("Maria Ramirez", cola.remove().getNombre());
    }

    @Test
    public void testTamañoCola() {
        VectorHeap<Paciente> cola = new VectorHeap<>();
        cola.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        cola.add(new Paciente("Maria Ramirez", "apendicitis", 'A'));
        cola.add(new Paciente("Lorenzo Toledo", "chikungunya", 'E'));
        assertEquals(3, cola.size());
    }

    @Test
    public void testArchivoVacio() {
        VectorHeap<Paciente> cola = new VectorHeap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("archivo_vacio.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String nombre = parts[0].trim();
                String sintoma = parts[1].trim();
                char codigoEmergencia = parts[2].trim().charAt(0);
                cola.add(new Paciente(nombre, sintoma, codigoEmergencia));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(0, cola.size());
    }

    @Test
    public void testAgregarPaciente_Falla() {
        VectorHeap<Paciente> cola = new VectorHeap<>();
        cola.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        assertEquals(0, cola.size()); // Falla porque esperamos que el tamaño sea 1
    }
}