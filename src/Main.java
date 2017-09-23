import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application{

	@FXML Slider iterationsSlider;
	@FXML Slider lengthSlider;
	@FXML ChoiceBox<String> choiceBox;
	String algo = "tree";
	
	public static void main(String[] args) {
		launch(args);
	}
	double degreeChange = 50;
	double lengthChange = 0.6;

	@Override
	@FXML
	public void start(Stage primaryStage) throws Exception {
		
		double length = 300;
		double degrees = 90;
		double x = 650;
		double y = 700;
		
	    Parent vbx = FXMLLoader.load(getClass().getResource("Client.fxml"));
	    
	    iterationsSlider = (Slider) vbx.lookup("#iterationsSlider");
	    iterationsSlider.setPrefWidth(1300*0.2);
	    lengthSlider = (Slider) vbx.lookup("#lengthSlider");
	    lengthSlider.setPrefWidth(1300*0.2);
	    choiceBox = ((ChoiceBox<String>) vbx.lookup("#choiceBox"));
	    //Sets the list of algorithms
	    choiceBox.setItems(FXCollections.observableArrayList("tree", "tree2", "tree3", "treeRand"));
		
		
		Pane root = new Pane();
		ObservableList<Node> list = root.getChildren();
		list.addAll(getFunc(algo, length, degrees, x, y, lengthChange, degreeChange));
		
		BorderPane bp = new BorderPane();
		bp.setCenter(root);
		bp.setLeft(vbx);
	
		
		iterationsSlider.valueProperty().addListener(e -> {
			degreeChange = iterationsSlider.getValue()*36;
			list.clear();
			list.addAll(getFunc(algo, length, degrees, x, y, lengthChange, degreeChange));
			bp.setCenter(root);
		});
		
		lengthSlider.valueProperty().addListener(e -> {
			lengthChange = lengthSlider.getValue()/150;
			list.clear();
			list.addAll(getFunc(algo, length, degrees, x, y, lengthChange, degreeChange));
			bp.setCenter(root);
		});
		//Sets the algorithm
		choiceBox.valueProperty().addListener(e -> {
			algo = choiceBox.getValue().toString();
			list.clear();
			list.addAll(getFunc(algo, length, degrees, x, y, lengthChange, degreeChange));
			bp.setCenter(root);
		});
		
		Scene scene = new Scene(bp, 1300, 700);
		primaryStage.setTitle("Tree Recursion");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private static ArrayList<Line> getFunc(String id, double length, double degrees, double x, double y, double lengthChange, double degreeChange){
		switch(id){
			case "tree":
				return TreeRecursion.tree(length, degrees, x, y, lengthChange, degreeChange);
			case "tree2":
				return Tree2Recursion.tree2(length, degrees, x, y, lengthChange, degreeChange);
			case "tree3":
				return Tree3Recursion.tree3(length, degrees, x, y, lengthChange, degreeChange);
			case "treeRand":
				return TreeRandRecursion.treeRand(length, degrees, x, y, lengthChange, degreeChange);
		}
		return null;
	}
}
