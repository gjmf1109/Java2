package com.dish.mx.dev.crud;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Clase en la que definimos los beans que vamos a cargar al contexto de spring.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
 *
 * @since 0.0.1
 *
 */
// Define a la clase como una fuente de definición de beans
@Configuration
// En esta dirección busará el archivo properties
@PropertySource("classpath:db.properties")
// Realizará el escaneo de los paquetes para encontrar los beans
// definido en cada clase
@ComponentScan("com.dish.mx.dev.crud")

public class AppConfig {

    /**
     * El método recoge los datos necesarios para poder realizar la conexión
     * a la base de datos cuando se necesite.
     *
     * @return Regresa un objeto con los certificados para la conexión.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    @Bean
    DataSource dataSource(Environment env) {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        try {
            // Se obtiene el driver del archivo properties
            ds.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        } catch (Exception ex) {
            throw new RuntimeException(
                    "error while setting the driver class name in the datasource", ex);
        }
        //Obtengo los datos de mi archivo properties
        ds.setUrl(env.getRequiredProperty("jdbc.url"));
        ds.setUsername(env.getRequiredProperty("jdbc.username"));
        ds.setPassword(env.getRequiredProperty("jdbc.password"));

        return ds;
    }

    
    /**
     * Método para poder utilizar la conexión de la base con jdbcTemplate.
     *
     * @param dataSource
     * @return Regresa la instancia jdbcTemplate con los datos
     *  obtenidos por el DataSource.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * Método para poder tener el acceso a los datos de la base
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    @Bean
    DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * Método para poder utilizar la variable jdbcTemplate
     *  en mi clase EmpleadoDAO y realizar las acividades 
     *  necesarias con dicha variable.
     *
     * @param jdbcTemplate
     * @return Regresa una instancia de EmpleadoDAO pasándole como 
     *  argumento la variable jdbcTemplate para poder interactuar
     *  con la base de datos.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    // Bean para poder utilizar la variable jdbcTemplate 
    // en mi clase EmpleadoDAO
    @Bean
    EmpleadoDAO empleadoDAO(JdbcTemplate jdbcTemplate) {
        return new EmpleadoDAO(jdbcTemplate);
    }
}
