package mvc.dra.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import mvc.dra.model.ImageProperties;

public class MainController {

	@FXML
	private ImageView field00;

	@FXML
	private ImageView field20;

	@FXML
	private ImageView field40;

	@FXML
	private ImageView field60;

	@FXML
	private ImageView field11;

	@FXML
	private ImageView field31;

	@FXML
	private ImageView field51;

	@FXML
	private ImageView field71;

	@FXML
	private ImageView field02;

	@FXML
	private ImageView field22;

	@FXML
	private ImageView field42;

	@FXML
	private ImageView field62;

	@FXML
	private ImageView field13;

	@FXML
	private ImageView field33;

	@FXML
	private ImageView field53;

	@FXML
	private ImageView field73;

	@FXML
	private ImageView field04;

	@FXML
	private ImageView field24;

	@FXML
	private ImageView field44;

	@FXML
	private ImageView field64;

	@FXML
	private ImageView field15;

	@FXML
	private ImageView field35;

	@FXML
	private ImageView field55;

	@FXML
	private ImageView field75;

	@FXML
	private ImageView field06;

	@FXML
	private ImageView field26;

	@FXML
	private ImageView field46;

	@FXML
	private ImageView field66;

	@FXML
	private ImageView field17;

	@FXML
	private ImageView field37;

	@FXML
	private ImageView field57;

	@FXML
	private ImageView field77;

	private ImageView[] imageViewFields;

	public void initialize() {
		imageViewFields = new ImageView[32];

		imageViewFields[0] = field00;
		imageViewFields[1] = field20;
		imageViewFields[2] = field40;
		imageViewFields[3] = field60;
		imageViewFields[4] = field11;
		imageViewFields[5] = field31;
		imageViewFields[6] = field51;
		imageViewFields[7] = field71;
		imageViewFields[8] = field02;
		imageViewFields[9] = field22;
		imageViewFields[10] = field42;
		imageViewFields[11] = field62;
		imageViewFields[12] = field13;
		imageViewFields[13] = field33;
		imageViewFields[14] = field53;
		imageViewFields[15] = field73;
		imageViewFields[16] = field04;
		imageViewFields[17] = field24;
		imageViewFields[18] = field44;
		imageViewFields[19] = field64;
		imageViewFields[20] = field15;
		imageViewFields[21] = field35;
		imageViewFields[22] = field55;
		imageViewFields[23] = field75;
		imageViewFields[24] = field06;
		imageViewFields[25] = field26;
		imageViewFields[26] = field46;
		imageViewFields[27] = field66;
		imageViewFields[28] = field17;
		imageViewFields[29] = field37;
		imageViewFields[30] = field57;
		imageViewFields[31] = field77;
	}

	boolean active = false;
	ImageView s1 = new ImageView();
	ImageView s2 = new ImageView();
	ImageView s3 = new ImageView();
	ImageView s4 = new ImageView();
	ImageView r = new ImageView();

	ImageView activePiece;

	private ImageView searchImageViewField(int x, int y) {
		ImageView img = new ImageView();
		for (ImageView i : imageViewFields) {
			if (i.getX() == x && i.getY() == y)
				img = i;
		}
		return img;
	}

	@FXML
	void fieldClicked(MouseEvent event) {
		ImageView img = (ImageView) event.getSource();
		int x = (int) img.getX();
		int y = (int) img.getY();

		String url = img.getImage().getUrl();
		String name = ImageProperties.getImageName(url);

		if (active == true) {
			if (name.equals("selected.png")) {
				if (s4.getId() == img.getId())
					s3.setImage(ImageProperties.emptyImage(url));
				if (s3.getId() == img.getId())
					s4.setImage(ImageProperties.emptyImage(url));
				img.setImage(activePiece.getImage());
				activePiece.setImage(ImageProperties.emptyImage(url));
				active = false;
				s3 = s4 = r; // zerowanie znacznikow
				return;
			}
		}

		if (name.equals("empty.png"))
			return;

		activePiece = img;
		s3.setImage(ImageProperties.emptyImage(url));
		s4.setImage(ImageProperties.emptyImage(url));

		System.out.println(img.getId());

		//Poruszanie sie
		if (x == 0) {
			if (name.equals("black.png"))
				s1 = searchImageViewField(x + 1, y + 1);
			else
				s1 = searchImageViewField(x + 1, y - 1);
			if ((ImageProperties.getImageName(s1.getImage().getUrl())).equals("empty.png")) {
				s1.setImage(ImageProperties.selectedImage(url));
				s3 = s1;
				active = true;
			}
		} else if (x == 7) {
			if (name.equals("black.png"))
				s1 = searchImageViewField(x - 1, y + 1);
			else
				s1 = searchImageViewField(x - 1, y - 1);
			if ((ImageProperties.getImageName(s1.getImage().getUrl())).equals("empty.png")) {
				s1.setImage(ImageProperties.selectedImage(url));
				s3 = s1;
				active = true;
			}
		} else {
			if (name.equals("black.png")) {
				s1 = searchImageViewField(x + 1, y + 1);
				s2 = searchImageViewField(x - 1, y + 1);
			} else {
				s1 = searchImageViewField(x - 1, y - 1);
				s2 = searchImageViewField(x + 1, y - 1);
			}
			if ((ImageProperties.getImageName(s1.getImage().getUrl())).equals("empty.png")) {
				s1.setImage(ImageProperties.selectedImage(url));
				s3 = s1;
				active = true;
			}
			if ((ImageProperties.getImageName(s2.getImage().getUrl())).equals("empty.png")) {
				s2.setImage(ImageProperties.selectedImage(url));
				s4 = s2;
				active = true;
			}
			
			//Bicie
			
		}
	}

}
