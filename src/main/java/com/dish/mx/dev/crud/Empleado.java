package com.dish.mx.dev.crud;

/**
 * Clase en la que definimos los atributos de la tabla a
 * manipular en la base de datos.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
 *
 * @since 0.0.1
 *
 */
public class Empleado {

    private int numEmpleado;
    private String nombre;
    private int antiguedad;
    private String fechaActualizacion;
    private String activo;

    public Empleado() {

    }

    public Empleado(int num_empleado, String nombre, int antiguedad, String fecha, String activo) {
        this.numEmpleado = num_empleado;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.fechaActualizacion = fecha;
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "num_empleado=" + numEmpleado + ", nombre=" + nombre + ", antiguedad=" + antiguedad + ", fecha_actualizacion=" + fechaActualizacion + ", activo=" + activo + '}';
    }

    /**
     * @return the num_empleado
     */
    public int getNumEmpleado() {
        return numEmpleado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the antiguedad
     */
    public int getAntiguedad() {
        return antiguedad;
    }

    /**
     * @return the fecha_actualizacion
     */
    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * @return the activo
     */
    public String getActivo() {
        return activo;
    }

    /**
     * @param numEmpleado the num_empleado to set
     */
    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param antiguedad the antiguedad to set
     */
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    /**
     * @param fechaActualizacion the fecha_actualizacion to set
     */
    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(String activo) {
        this.activo = activo;
    }

}
