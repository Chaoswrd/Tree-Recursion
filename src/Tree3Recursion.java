import java.util.ArrayList;

import javafx.scene.shape.Line;

public class Tree3Recursion {
	public static ArrayList<Line> tree3(double length, double degrees, double x, double y, double lengthChange, double degreeChange){
		if(length>1){
			double xDisplacement = (x + Math.cos(Math.toRadians(degrees)) * length); //Finds end x for current line
			double yDisplacement = (y - Math.sin(Math.toRadians(degrees)) * length); //Finds end y for current line
			//Moves right line down half way
			double xDisplacement2 = (x + Math.cos(Math.toRadians(degrees)) * length/2); 
			double yDisplacement2 = (y - Math.sin(Math.toRadians(degrees)) * length/2);
			//Moves second left line down a third
			double xDisplacement3 = (x + Math.cos(Math.toRadians(degrees)) * length/3); 
			double yDisplacement3 = (y - Math.sin(Math.toRadians(degrees)) * length/3);
			//Moves second right line down a fourth
			double xDisplacement4 = (x + Math.cos(Math.toRadians(degrees)) * length/4); 
			double yDisplacement4 = (y - Math.sin(Math.toRadians(degrees)) * length/4);
			Line line = new Line();
			line.setStartX(x);
			line.setStartY(y);
			line.setEndX(xDisplacement);
			line.setEndY(yDisplacement);
			//Length*lengthChange determines how much shorter the line should get for every iteration
			//Degrees+-degreeChange changes the degree by a certain amount
			//x & y Displacement give the end position so next line will start there
			//lengthChange and degreeChange are constants that follow the recursion
			ArrayList<Line> lines = tree3(length*lengthChange, degrees+degreeChange, xDisplacement, yDisplacement, lengthChange, degreeChange);
			ArrayList<Line> lines2 = tree3(length*lengthChange*0.8, degrees-degreeChange, xDisplacement2, yDisplacement2, lengthChange, degreeChange);
			ArrayList<Line> lines3 = tree3(length*lengthChange*0.4, degrees+degreeChange, xDisplacement3, yDisplacement3, lengthChange, degreeChange);
			ArrayList<Line> lines4 = tree3(length*lengthChange*0.2, degrees-degreeChange, xDisplacement4, yDisplacement4, lengthChange, degreeChange);
			lines.add(line);
			lines.addAll(lines2);
			lines.addAll(lines3);
			lines.addAll(lines4);
			return lines;
		}
		else{
			return new ArrayList<Line>();
		}
	}
}
