package com.dish.mx.dev.crud;

import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Clase principal que utiliza a la clase APPConfig y EmpleadoDAO para poder
 * cumplir con el objetivo del sistema.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx%gt;
 *
 * @since 0.0.1
 *
 */
public class MainApp {

    /**
     * Clase principal que e muestra al usuario las 
     * opciones que puede elegir para trabajar con 
     * la base de datos.
     *
     * @version 0.0.1
     *
     * @author Gerardo Martinez &lt; gerardo.martinez@dish.com.mx %gt;
     * @param args
     *
     * @since 0.0.1
     *
     */
    public static void main(String args[]) {
        EmpleadoDAO empDAO; //Variable para acceder a los métodos de esta clase
        List<Empleado> imprimir; //Variable para poder guardar los resultados de los querys
        Empleado imprimir2; //Variable para poder imprimir registros de esta clase

        int a = 1; //Variable para tenr el control de la estructura do - while

        // Nos muestra el menú para el usuario
        do {
            System.out.println("¿Que quieres realizar en la base de datos?");
            System.out.println("1.- Consultar a la base");
            System.out.println("2.- Insertar un empleado a la base");
            System.out.println("3.- Actualizar los datos de un empleado");
            System.out.println("4.- Eliminar un empleado de la base");
            System.out.println("5.- Salir");

            // Se inicializa el contexto de spring
            ApplicationContext ctx
                    = new AnnotationConfigApplicationContext(AppConfig.class);

            // Obteneos el bean de la calse que queremos, en este caso
            // de la clase EmpleadoDAO
            empDAO = ctx.getBean(EmpleadoDAO.class);

            // Inicializamos la instancia Scanner para poder leer
            // datos desde la consola
            Scanner leer = new Scanner(System.in);

            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Retornar todos los registros de la tabla --> 1");
                    System.out.println("Buscar por número de empleado --> 2");
                    //Se guarda el valor de la opción elegida por el usuario
                    int eleccion = leer.nextInt();
                    // Según la opción es como se ejecutarán las acciones
                    // de nuestra estructura de decisión
                    if (eleccion == 1) {
                        // Se guardan todos los registros de la base en nuestra variable
                        imprimir = empDAO.encontrarTodos();
                        System.out.println(imprimir);
                    } else {
                        System.out.print("Ingresa el número del empleado: ");
                        // Se guarda el núm. de empleado escrito por el usuario
                        // desde la consola en la variable id
                        int id = leer.nextInt();
                        // Se guarda el o los registros devueltos desde la 
                        // base de datos
                        imprimir2 = empDAO.encontrarPorId(id);
                        System.out.println(imprimir2);
                    }
                    a = 1;
                    break;
                case 2:
                    // Guardamos en las variables correspondientes los valores que se le estan  
                    // pidiendo al usuario
                    System.out.print("Ingresa el número del empleado: ");
                    int num = leer.nextInt();
                    System.out.print("Ingresa el nombre del empleado: ");
                    String nom = leer.next();
                    System.out.print("Ingresa los anios de atiguedad del empleado: ");
                    int anti = leer.nextInt();
                    System.out.print("Ingresa la fecha de ingreso del empleado (aaaa-mm-dd): ");
                    String fecha = leer.next();
                    System.out.print("Ingresa el estatus del empleado: ");
                    String estatus = leer.next();
                    // Utilizamos el método pasandole los datos que ingreso el usuario
                    empDAO.insertarEmpleado(num, nom, anti, fecha, estatus);
                    System.out.println("Empleado registrado!");
                    // Se guardan todos los registros de la base en nuestra variable
                    imprimir = empDAO.encontrarTodos();
                    System.out.println(imprimir);
                    a = 1;
                    break;
                case 3:
                    // Utilizamos el método para realizar la actividad correspondiente
                    empDAO.actualizarEmpleado();
                    System.out.println("Empleado actualizado!");
                    // Se guardan todos los registros de la base en nuestra variable
                    imprimir = empDAO.encontrarTodos();
                    System.out.println(imprimir);
                    a = 1;
                    break;
                case 4:
                    System.out.println("Eliminar todos los registros de la tabla --> 1");
                    System.out.println("Eliminar un registro de la tabla por el número de empleado --> 2");
                    // Se lee la opción que el usuario introdujo en la consola 
                    // y se guarda en la variable elim
                    int elim = leer.nextInt();

                    // Según la opción elegida, es como actuará nuestra 
                    // estructura de decisión
                    if (elim == 1) {
                        // Método para elimianr a todos los registros de la base de datos
                        empDAO.eliminarTodos();
                        System.out.println("Todos los empleados han sido eliminados!");
                        // Se guardan todos los registros de la base en nuestra variable
                        imprimir = empDAO.encontrarTodos();
                        System.out.println(imprimir);
                    } else {
                        System.out.print("Ingrese el número de empleado del registro a eliminar: ");
                        // Leemos el núm. de empleado que introdujo por
                        // consola el usuario y lo asigna en la variable
                        int emp = leer.nextInt();
                        // El método elimina el registro de la base de datos
                        // de acuerdo al núm de empleado que eligió el usuario
                        empDAO.eliminarPorID(emp);
                        System.out.println("Empleado eliminado!");
                        // Se guardan todos los registros de la base en nuestra variable
                        imprimir = empDAO.encontrarTodos();
                        System.out.println(imprimir);
                    }
                    a = 1;
                    break;
                case 5:
                    System.out.println("\n\nSaliendo del programa... \n");
                    a = 2;
                    break;
                default:
                    System.out.println("La opción elegida es incorrecta");
                    a = 1;
                    break;
            }

        } while (a == 1);
    }
}
