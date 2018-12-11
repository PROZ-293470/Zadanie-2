package mvc.dra;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mvc.dra.controller.MainController;

/** 
 * Klasa glowna <code>Main</code> zgodna z nazwa pliku Main.java, dziedziczaca z klasy Application.
 * @author Wojtek Rokicki
 * @version Alpha
*/
public class Main extends Application {
	/**
	 * Metoda glowna <code>main</code> klasy <code>Main</code> wywolujaca metode launch, ktora najpierw wywoluje metode init i nastepnie metode start. Kiedy aplikacja konczy dzialanie, wolana jest metoda stop. 
	 * @param args Tablica argumentow przyjetych z konsoli podczas wywolywania programu.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Metoda <code>start()</code> jest abstrakcyjna i musi byc nadpisana.
	 * Klasa <code>Stage</code> reprezentuje okno aplikacji, kontener (na najwyzszym poziomie) 
	 * zawierajacy wszystkie obiekty interfejsu uzytkownika. W chwili uruchamiania 
	 * aplikacji, tworzony jest obiekt klasy <code>Stage</code> i przekazywany, jako parametr 
	 * wywolania do metody <code>start</code>.
	 */
	@Override
	public void start(Stage primaryStage) {
		ViewLoader<AnchorPane, MainController> viewLoader = new ViewLoader<AnchorPane, MainController>("view/Main.fxml");
		AnchorPane anchorPane = viewLoader.getLayout();
		MainController controller = viewLoader.getController();
		controller.initialize();
		Scene scene = new Scene(anchorPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Warcaby");
		primaryStage.show();
	}

}
