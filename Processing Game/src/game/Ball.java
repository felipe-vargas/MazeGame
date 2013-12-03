package game;

import processing.core.PApplet;
import java.util.ArrayList;

public class Ball {
	private PApplet p;
	private double x, y;
	private double vx, vy; // in pixels per second
	private int radius;
	private int diameter;
	
	public Ball(PApplet parent, int x, int y, double vx, double vy, int diameter) {
		p = parent;
		this.x = x;
		this.y = y;
		this.vx = vx; // pixels per frame
		this.vy = vy; // pixels per frame
		this.diameter = diameter;
		radius = diameter / 2;
	}
	
	/**
	 * Converts between the center-origin coordinate system and
	 * the grid-corner system.
	 * @param coord : The coordinate to be converted.
	 * @param dir	: True specifies conversion to center-system. False 
	 * 				  specifies conversion to left-corner system.
	 * @return		: Returns the converted double.
	 */
	private double convert(double coord, boolean dir) {
		if (dir)
			return coord - Game.rectWidth / 2;
		return coord + Game.rectWidth / 2;
	}
	
	private boolean contains(int xCoord, int yCoord) {
		if (convert(x, false) - radius < xCoord && xCoord < convert(x, false) + radius &&
			convert(y, false) - radius < yCoord && yCoord < convert(y, false) + radius) {
			return true;
		}
		
		return false;
	}
	
	public void detectCollision() {
		int[][] pixels = new int[Game.screenX][698];
		p.loadPixels();
		for (int yCoord = 0; yCoord < 698; yCoord++)
			for (int xCoord = 0; xCoord < Game.screenX; xCoord++) {
				int c = p.pixels[yCoord * Game.screenX + xCoord];
				pixels[xCoord][yCoord] = c;
				if (c == p.color(0, 0, 0)) {
					System.out.println("Pixel is black");
				}
				if (c == p.color(0, 0, 0) && contains(xCoord, yCoord)) {
					vy = 0;
					vx = 0;
					break;
				}
			} 
	}
	
	public void detectCollisionx() {
		int xCoord = (int)Math.ceil(convert(x, false) / 50);
		int yCoord = (int)Math.ceil(convert(y, false) / 50);
		
		if (Game.gridW[xCoord][yCoord] && convert(y, false) + vy + radius >= yCoord * 50) {
			vy = 0;
			y = convert(yCoord * 50 - radius, true);
			
			if (vx > 0) {
				vx -= Game.FRICTION;
				if (vx < 0)
					vx = 0;
			}
			else if (vx < 0) {
				vx += Game.FRICTION;
				if (vx > 0)
					vx = 0;
			}
		}
		if (Game.gridH[xCoord][yCoord] && convert(x, false) + vx + radius >= xCoord * 50) {
			vx = 0;
			x = convert(xCoord * 50 - radius - 1, true);
		}
		
		yCoord -= 1;
		
		if (yCoord > 0)
			if (Game.gridW[xCoord][yCoord] && convert(y, false) + vy - radius <= yCoord * 50) {
				vy = 0;
				y = convert(yCoord * 50 + radius + 1, true);
			}
		
		xCoord -= 1;
		yCoord += 1;
		
		if (xCoord > 0)
			if (Game.gridH[xCoord][yCoord] && convert(x, false) + vx - radius <= xCoord * 50) {
				vx = 0;
				x = convert(xCoord * 50 + radius + 1, true);
			}
	}
	
	public void render() {
		
		/*x = 300;
		y = 35;
		System.out.println(contains(Game.rectWidth/2 + 300, Game.rectWidth/2 + 35));*/
		
		vy += Game.GRAVITY;
		detectCollision();
		
		x += vx;
		y += vy;
		
		p.strokeWeight(1);
		p.fill(p.color(0xFF, 0xFF, 0xFF));
		p.ellipseMode(p.CENTER);
		
		p.ellipse((float)x, (float)y, diameter, diameter);
	}
}
