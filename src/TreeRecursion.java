import java.util.ArrayList;

import javafx.scene.shape.Line;

public class TreeRecursion {
	public static ArrayList<Line> tree(double length, double degrees, double x, double y, double lengthChange, double degreeChange){
		if(length>1){
			double xDisplacement = (x + Math.cos(Math.toRadians(degrees)) * length); //Finds the end x
			double yDisplacement = (y - Math.sin(Math.toRadians(degrees)) * length); //Finds the end y
			Line line = new Line();
			line.setStartX(x);
			line.setStartY(y);
			line.setEndX(xDisplacement);
			line.setEndY(yDisplacement);
			//Length*lengthChange determines how much shorter the line should get for every iteration
			//Degrees+-degreeChange changes the degree by a certain amount
			//x & y Displacement give the end position so next line will start there
			//lengthChange and degreeChange are constants that follow the recursion
			ArrayList<Line> lines = tree(length*lengthChange, degrees+degreeChange, xDisplacement, yDisplacement, lengthChange, degreeChange);
			ArrayList<Line> lines2 = tree(length*lengthChange, degrees-degreeChange, xDisplacement, yDisplacement, lengthChange, degreeChange);
			lines.add(line);
			lines.addAll(lines2);
			return lines;
		}
		else{
			return new ArrayList<Line>();
		}
	}
}
