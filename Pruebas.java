/**
 * Fernando Ruiz
 * 23065
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase de pruebas unitarias para verificar el correcto funcionamiento de la cola de prioridad.
 */
public class Pruebas {

    /**
     * Prueba que verifica si un paciente se agrega correctamente a la cola de prioridad.
     */
    @Test
    public void testAgregarPaciente() {
        VectorHeap<Paciente> cola = new VectorHeap<>();
        cola.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        assertEquals(1, cola.size());
    }

    /**
     * Prueba que verifica si un paciente se elimina correctamente de la cola de prioridad.
     */
    @Test
    public void testEliminarPaciente() {
        VectorHeap<Paciente> cola = new VectorHeap<>();
        cola.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        Paciente pacienteEliminado = cola.remove();
        assertEquals("Juan Perez", pacienteEliminado.getNombre());
    }

    /**
     * Prueba que verifica si los pacientes se atienden en el orden correcto de prioridad.
     */
    @Test
    public void testPrioridadPacientes() {
        VectorHeap<Paciente> cola = new VectorHeap<>();
        cola.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        cola.add(new Paciente("Maria Ramirez", "apendicitis", 'A'));
        cola.add(new Paciente("Lorenzo Toledo", "chikungunya", 'E'));
        assertEquals("Maria Ramirez", cola.remove().getNombre());
    }

    /**
     * Prueba que verifica si el tamaño de la cola de prioridad se calcula correctamente.
     */
    @Test
    public void testTamañoCola() {
        VectorHeap<Paciente> cola = new VectorHeap<>();
        cola.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        cola.add(new Paciente("Maria Ramirez", "apendicitis", 'A'));
        cola.add(new Paciente("Lorenzo Toledo", "chikungunya", 'E'));
        assertEquals(3, cola.size());
    }

    /**
     * Prueba que verifica si la cola de prioridad está vacía cuando se lee desde un archivo vacío.
     */
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

    /**
     * Prueba que falla intencionalmente para demostrar que una prueba unitaria puede fallar.
     */
    @Test
    public void testAgregarPaciente_Falla() {
        VectorHeap<Paciente> cola = new VectorHeap<>();
        cola.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        assertEquals(0, cola.size()); // Falla porque esperamos que el tamaño sea 1
    }
}