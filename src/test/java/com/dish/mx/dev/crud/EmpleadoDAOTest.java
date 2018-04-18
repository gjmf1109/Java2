/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dish.mx.dev.crud;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gerardo.martinez
 */
public class EmpleadoDAOTest {
    
    public EmpleadoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of encontrarTodos method, of class EmpleadoDAO.
     */
//    @Test
//    public void testEncontrarTodos() {
//        System.out.println("encontrarTodos");
//        EmpleadoDAO instance = new EmpleadoDAO();
//        List<Empleado> expResult = null;
//        List<Empleado> result = instance.encontrarTodos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of encontrarPorId method, of class EmpleadoDAO.
     */
    @Test
    public void testEncontrarPorId() {
        System.out.println("encontrarPorId");
        int id = 1;
        EmpleadoDAO instance = new EmpleadoDAO();
        Empleado expResult = new Empleado(1, "Gerardo", 1, "2017-03-20", "T");
        Empleado result = instance.encontrarPorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of eliminarTodos method, of class EmpleadoDAO.
     */
//    @Test
//    public void testEliminarTodos() {
//        System.out.println("eliminarTodos");
//        EmpleadoDAO instance = new EmpleadoDAO();
//        int expResult = 0;
//        int result = instance.eliminarTodos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of eliminarPorID method, of class EmpleadoDAO.
     */
//    @Test
//    public void testEliminarPorID() {
//        System.out.println("eliminarPorID");
//        int id = 0;
//        EmpleadoDAO instance = new EmpleadoDAO();
//        int expResult = 0;
//        int result = instance.eliminarPorID(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of insertarEmpleado method, of class EmpleadoDAO.
     */
//    @Test
//    public void testInsertarEmpleado() {
//        System.out.println("insertarEmpleado");
//        int num_empleado = 0;
//        String nombre = "";
//        int antiguedad = 0;
//        String fecha = "";
//        String activo = "";
//        EmpleadoDAO instance = new EmpleadoDAO();
//        instance.insertarEmpleado(num_empleado, nombre, antiguedad, fecha, activo);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of actualizarEmpleado method, of class EmpleadoDAO.
     */
//    @Test
//    public void testActualizarEmpleado() {
//        System.out.println("actualizarEmpleado");
//        EmpleadoDAO instance = new EmpleadoDAO();
//        instance.actualizarEmpleado();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
