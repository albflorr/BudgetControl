/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura.persistence;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection instance;
    
    // Cargamos el archivo .env
    private static final Dotenv dotenv = Dotenv.load();
    private DatabaseConnection() {}

    public static Connection getInstance() throws SQLException {
        if (instance == null || instance.isClosed()) {
            try {
                // Obtenemos los valores desde el archivo .env
                String url = dotenv.get("DB_URL");
                String user = dotenv.get("DB_USER");
                String password = dotenv.get("DB_PASSWORD");

                if (url == null || user == null) {
                    throw new RuntimeException("Error: Variables de entorno no configuradas en .env");
                }

                instance = DriverManager.getConnection(url, user, password);
                System.out.println("Conexión establecida exitosamente desde .env");
                
            } catch (SQLException e) {
                System.err.println("Error al conectar a MySQL: " + e.getMessage());
                throw e;
            }
        }
        return instance;
    }
}
