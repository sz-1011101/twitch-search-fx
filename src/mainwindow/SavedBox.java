package mainwindow;

import javafx.scene.layout.VBox;

public class SavedBox extends VBox{
	
	public SavedBox(){
		Utility.loadFXMLasRoot("saved_box.fxml", this);
	}
}
