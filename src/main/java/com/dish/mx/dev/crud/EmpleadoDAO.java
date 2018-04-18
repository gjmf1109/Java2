package com.dish.mx.dev.crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * Clase en la que se implementan todos los métodos que ejecutan los querys para
 * obtener los datos de la base.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt; gerardo.martinez@dish.com.mx %gt;
 *
 * @since 0.0.1
 *
 */
public class EmpleadoDAO {

    private static final Logger logger = LogManager.getLogger(EmpleadoDAO.class);
    private JdbcTemplate jdbcTemplate; //Variable para poder acceder a los métodos de esta clase

    // Constructor vacío
    public EmpleadoDAO() {
    }

    // Constructor con argumentos
    public EmpleadoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * El método ejecuta un query para poder obtener todos los registros de la
     * base de datos
     *
     * @return Regresa una lista con los registros obtenidos por el query
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public List<Empleado> encontrarTodos() {
        return jdbcTemplate.query("SELECT * FROM empleado", new EmpleadoRowMapper());
    }

    /**
     * El método ejecuta un query para poder obtener todos los registros de la
     * base de datos según el id introducido
     *
     * @return Regresa un objeto del tipo Empleado con los registros obtenidos
     * por el query
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public Empleado encontrarPorId(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM empleado WHERE num_empleado = ?", new Object[]{id},
                new EmpleadoRowMapper());
    }

    /**
     * El método ejecuta un query para poder eliminar todos los registros de la
     * base de datos
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public int eliminarTodos() {
        return jdbcTemplate.update("DELETE from empleado");
    }

    /**
     * El método ejecuta un query para poder obtener todos los registros de la
     * base de datos de acuerdo al id introducido.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public int eliminarPorID(int id) {
        return jdbcTemplate.update("DELETE FROM empleado WHERE num_empleado = ?", id);
    }

    /**
     * El método ejecuta un query para poder insertar registros en la base de
     * datos de acuerdo a los datos que se le pasan en los argumentos del mismo.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public void insertarEmpleado(int num_empleado, String nombre, int antiguedad, String fecha, String activo) {
        jdbcTemplate.update("INSERT INTO empleado (num_empleado, nombre, antiguedad, fecha_actualizacion, activo) "
                + "VALUES(?,?,?,?,?)", num_empleado, nombre, antiguedad, fecha, activo);
    }

    /**
     * El método ejecuta un query para poder actualizar todos los registros de
     * la base de datos de acuerdo a los datos que el usuario proporcione
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public void actualizarEmpleado() {
        int numEmp = 0;
        int resp = 0;
        Object[] insert = new Object[3];
        Empleado empleado = new Empleado();
        Scanner leer = new Scanner(System.in);

        System.out.print("¿Cuál es el número de empleado?: ");
        numEmp = leer.nextInt();
        empleado = encontrarPorId(numEmp);
        //System.out.print("Dame el nombre de la columna que quieres actualizar: ");
        //insert[0] = leer.next();
        System.out.print("Número actual del empleado: " + empleado.getNumEmpleado());
        System.out.print("Número nuevo del empleado (Digite el mismo número de empleado si no quiere cambiarlo): ");
        empleado.setNumEmpleado(leer.nextInt());

        System.out.print("Nombre actual del empleado: " + empleado.getNombre());
        System.out.print("Nombre nuevo del empleado (Digite el mismo nombre si no quiere cambiarlo): ");
        empleado.setNombre(leer.next());

        System.out.print("Antiguedad actual del empleado: " + empleado.getAntiguedad());
        System.out.print("Atiguedad nueva del empleado (Digite el mismo número de antiguedad si no quiere cambiarla): ");
        empleado.setAntiguedad(leer.nextInt());

        System.out.print("Fecha actual del empleado: " + empleado.getFechaActualizacion());
        System.out.print("Nueva fecha de actualización del empleado (Digite la misma fecha si no quiere cambiarla): ");
        empleado.setFechaActualizacion(leer.next());

        System.out.print("Estatus actual del empleado: " + empleado.getActivo());
        System.out.print("Nuevo estatus del empleado (Digite el mismo estatus si no quiere cambiarlo): ");
        empleado.setActivo(leer.next());

        /* En el primer argumento tenemos el query a ejecutar y en el segundo argumento
        un obtejo en el cual se recuperan los datos de Empleado para poder utilizarlos en el query*/
        resp = jdbcTemplate.update("UPDATE empleado SET num_empleado = ? , nombre = ?, "
                + "antiguedad = ?, fecha_actualizacion = ?, activo = ? "
                + "WHERE  num_empleado= ?", new Object[]{empleado.getNumEmpleado(), empleado.getNombre(),
                    empleado.getAntiguedad(), empleado.getFechaActualizacion(), empleado.getActivo(), numEmp});
        System.out.println("Se actualizaron " + resp + " líneas.");
        //Se imprimen, uno a uno, los registros de toda la tabla
        // de la base de datos.
        for (Empleado e : encontrarTodos()) {
            System.out.println(e.toString());
        }
    }

    /**
     * Clase en la que se obtienen los datos de la clase Empleado y los retorna
     * para poder utilizarlos en donde sean requeridos, la clase es privada ya
     * que no la voya utilizar en alguna otra clase, solo en esta.
     *
     * @version 0.0.1
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx%gt;
     *
     * @since 0.0.1
     *
     */
    private static class EmpleadoRowMapper implements RowMapper<Empleado> {

        @Override
        public Empleado mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Empleado(rs.getInt("num_empleado"), rs.getString("nombre"), rs.getInt("antiguedad"),
                    rs.getString("fecha_actualizacion"), rs.getString("activo"));
        }
    }

}
