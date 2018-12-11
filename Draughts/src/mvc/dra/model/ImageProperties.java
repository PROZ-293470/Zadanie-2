package mvc.dra.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Klasa <code>ImageProperties</code>
 * @author Wojtek
 *
 */


public class ImageProperties {
	
	//Metoda zwracajaca nazwe pliku grafiki
	static public String getImageName(String url){
		String name;
		int i = url.lastIndexOf("/view") + 6;
		name = url.substring(i);
		return name;
	}
	
	static public Image blackImage(String url) {
		int i = url.lastIndexOf("/view") + 6;
		url = url.substring(0,i) + "black.png";
		System.out.println(url + "\n");
		Image bIm = new Image(url);
		return bIm;
	}
	
	static public Image whiteImage(String url) {
		int i = url.lastIndexOf("/view") + 6;
		url = url.substring(0,i) + "white.png";
		System.out.println(url + "\n");
		Image bIm = new Image(url);
		return bIm;
	}
	
	static public Image emptyImage(String url) {
		int i = url.lastIndexOf("/view") + 6;
		url = url.substring(0,i) + "empty.png";
		System.out.println(url + "\n");
		Image bIm = new Image(url);
		return bIm;
	}
	
	static public Image selectedImage(String url) {
		int i = url.lastIndexOf("/view") + 6;
		url = url.substring(0,i) + "selected.png";
		System.out.println(url + "\n");
		Image bIm = new Image(url);
		return bIm;
	}
	
	static public ImageView search(String name, ImageView[] imageViewFields) {
		ImageView p = new ImageView();
		for (ImageView i: imageViewFields) {
			if(i.getImage().getUrl().endsWith(name)) return i;
		}
		return p;
	}
	
	
}