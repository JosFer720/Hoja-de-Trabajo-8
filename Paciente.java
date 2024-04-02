/**
 * Fernando Ruiz
 * 23065
 * 
 * Representa un paciente que llega a la sección de Emergencias de un hospital.
 * Cada paciente tiene un nombre, un síntoma y un código de emergencia que indica
 * la prioridad con la que debe ser atendido.
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    /**
     * Crea un nuevo paciente con el nombre, síntoma y código de emergencia especificados.
     * 
     * @param nombre           El nombre del paciente.
     * @param sintoma          El síntoma que presenta el paciente.
     * @param codigoEmergencia El código de emergencia del paciente (de 'A' a 'E').
     */
    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    /**
     * Obtiene el nombre del paciente.
     * 
     * @return El nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el síntoma del paciente.
     * 
     * @return El síntoma del paciente.
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * Obtiene el código de emergencia del paciente.
     * 
     * @return El código de emergencia del paciente.
     */
    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }

    /**
     * Compara este paciente con otro según su código de emergencia.
     * Los pacientes con un código de emergencia menor son considerados de mayor prioridad.
     * 
     * @param otro El otro paciente con el que se compara.
     * @return Un valor negativo si este paciente tiene mayor prioridad,
     *         cero si tienen la misma prioridad, o un valor positivo si el otro paciente tiene mayor prioridad.
     */
    @Override
    public int compareTo(Paciente otro) {
        return this.codigoEmergencia - otro.getCodigoEmergencia();
    }
}
