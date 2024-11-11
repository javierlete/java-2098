package ipartex.accesodatos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Globales {
	static {
		try {
			Properties props = new Properties();
			
			props.load(new FileReader("C:\\Users\\html.IPARTEKAULA\\git\\java-2098\\ipartex\\config\\ipartex.properties"));
			
			System.out.println("Se ha cargado la configuración");
			
			URL = props.getProperty("url");
			USER = props.getProperty("user");
			PASS = props.getProperty("pass");
			
			Class.forName(props.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver");
		} catch (FileNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el fichero de configuración");
		} catch (IOException e) {
			throw new RuntimeException("No se ha podido leer el fichero de configuración");
		}
	}
	
	public static final String URL;
	public static final String USER;
	public static final String PASS;
}
