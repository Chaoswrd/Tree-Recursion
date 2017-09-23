import java.util.ArrayList;

import javafx.scene.shape.Line;

public class TreeRandRecursion {
	public static ArrayList<Line> treeRand(double length, double degrees, double x, double y, double lengthChange, double degreeChange){
		if(length>1){
			//Math random is between 0.0-1.0 so divide it by 2 and plus five and you get between 0.5 and 1.0
			double rand = Math.random()/2+0.5;
			double rand2 = Math.random()/2+0.5;
			double xDisplacement = (x + Math.cos(Math.toRadians(degrees)) * length); //Gives current line end x
			double yDisplacement = (y - Math.sin(Math.toRadians(degrees)) * length); //Gives current line end y
			double xDisplacement2 = (x + Math.cos(Math.toRadians(degrees)) * length*rand); //Puts the left arm randomly on the line
			double yDisplacement2 = (y - Math.sin(Math.toRadians(degrees)) * length*rand);
			double xDisplacement3 = (x + Math.cos(Math.toRadians(degrees)) * length*rand2); //Puts the right arm randomly on the line
			double yDisplacement3 = (y - Math.sin(Math.toRadians(degrees)) * length*rand2);
			Line line = new Line();
			line.setStartX(x);
			line.setStartY(y);
			line.setEndX(xDisplacement);
			line.setEndY(yDisplacement);
			//Length*lengthChange determines how much shorter the line should get for every iteration
			//Degrees+-degreeChange changes the degree by a certain amount
			//x & y Displacement give the end position so next line will start there
			//lengthChange and degreeChange are constants that follow the recursion
			ArrayList<Line> lines = treeRand(length*lengthChange, degrees+degreeChange, xDisplacement2, yDisplacement2, lengthChange, degreeChange);
			ArrayList<Line> lines2 = treeRand(length*lengthChange, degrees-degreeChange, xDisplacement3, yDisplacement3, lengthChange, degreeChange);
			lines.add(line);
			lines.addAll(lines2);
			return lines;
		}
		else{
			return new ArrayList<Line>();
		}
	}
}
