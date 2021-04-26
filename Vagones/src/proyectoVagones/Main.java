package proyectoVagones;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Tren miTren = new Tren("vagon.in");
		miTren.resolver();
		miTren.escribir();
	}
}
