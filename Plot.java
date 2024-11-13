
/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Plot represents a plot of land and contains a point and the depth 
 * and width of the plot. Methods are used to manipulate the data.
 * Due: 11/12/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Nathaniel Schuknecht
*/

public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot() {
		
		width = 1;
		depth = 1;
	}
	
	public Plot(int x, int y, int width, int depth) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public Plot(Plot otherPlot) {
		this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
	}
	
	public boolean overlaps(Plot plot) {
		
		//Checks if this plots x value overlaps
		if(x + width < plot.getX() || plot.getX() + plot.getWidth() < x)
			return false;
		
		//Checks if this plots y value overlaps
		if(y + depth < plot.getY() || plot.getY() + plot.getDepth() < y)
			return false;
		
		return true;
	}
	
	public boolean encompases(Plot plot) {
		return x >= plot.getX() && y >= plot.getY() && x + width <= plot.getX() + plot.getWidth() && y + depth <= plot.getY() + plot.getDepth();
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public String toString() {
		return x + "," + y + "," + width + "," + depth;
	}
}
