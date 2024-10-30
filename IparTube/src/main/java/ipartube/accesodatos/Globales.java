package ipartube.accesodatos;

public class Globales {

	static final String url = "jdbc:sqlite:C:\\Users\\html.IPARTEKAULA\\git\\java-2098\\IparTube\\bdd\\ipartube.db";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver", e);
		}
	}

}
