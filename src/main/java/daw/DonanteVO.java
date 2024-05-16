    /*
 * Clase para mapear los datos de la tabla Persona
 */
package daw;

import java.time.LocalDate;

/**
 *
 * @author tomas
 */
public class DonanteVO {

    private int id_paciente;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String grupoSanguineo;
    private String rh;
    private int numeroDonaciones;

    public DonanteVO(int id_paciente, String nombre, LocalDate fechaNacimiento, String grupoSanguineo, String rh, int numeroDonaciones) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.grupoSanguineo = grupoSanguineo;
        this.rh = rh;
        this.numeroDonaciones = numeroDonaciones;
    }

    public DonanteVO() {
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public int getNumeroDonaciones() {
        return numeroDonaciones;
    }

    public void setNumeroDonaciones(int numeroDonaciones) {
        this.numeroDonaciones = numeroDonaciones;
    }

    @Override
    public String toString() {
        return "DonanteVO{"
                + "id_paciente=" + id_paciente
                + ", nombre=" + nombre
                + ", fechaNacimiento=" + fechaNacimiento
                + ", grupoSanguineo=" + grupoSanguineo
                + ", rh=" + rh
                + ", numeroDonaciones=" + numeroDonaciones
                + '}';
    }

}
