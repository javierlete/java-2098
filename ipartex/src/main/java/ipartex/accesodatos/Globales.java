package ipartex.accesodatos;

public class Globales {
	static {
		try {
			URL = "jdbc:sqlite:C:\\Users\\html.IPARTEKAULA\\git\\java-2098\\ipartex\\bdd\\ipartex.db";
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver");
		}
	}
	
	public static final String URL;
}
