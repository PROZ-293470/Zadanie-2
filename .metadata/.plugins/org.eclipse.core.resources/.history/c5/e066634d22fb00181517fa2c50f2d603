package mvc.calc;

import javafx.fxml.FXMLLoader;
import java.io.IOException;
/**
 * Generyczna klasa <code>ViewLoader</code>, ktorej konstruktor pobiera sciezke do pliku FXML ze zdefiniowanym interfejsem kalkulatora.
 * @author Wojtek Rokicki
 * @version Alpha
 * @param <T> W tym przypadku parametr T to AnchorPane
 * @param <U> W tym przypadku parametr U to Object
 */
public class ViewLoader<T, U> {
	private T fxmlLayout = null;
	private U fxmlController = null;

	public ViewLoader(String fxml) {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
			fxmlLayout = fxmlLoader.load();
			fxmlController = fxmlLoader.getController();
		}

		catch (IOException ex) {
		}
	}

	/**
	 * Metoda <code>getLayout()</code> zwraca uklad (Layout) widoku.
	 * @return zwraca referencje do obiekt ukladu (tutaj AnchorPane)
	 */
	public T getLayout() {
		return fxmlLayout;
	}
	/**
	 * Metoda <code>getController()</code> zwraca uklad (Layout) widoku.
	 * @return zwraca referencje do obiekt kontrolera (tutaj Object)
	 */
	public U getController() {
		return fxmlController;
	}
}
