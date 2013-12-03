package game;

import processing.core.PApplet;
import levels.*;

public class Game extends PApplet {
	
	protected static int rectWidth, rectHeight, screenX, screenY;
	private Ball ball;
	protected static int spaces = 10;
	private int space = 50;
	private int offset;
	public static boolean[][] gridH = new boolean[spaces + 1][spaces + 1];
	public static boolean[][] gridW = new boolean[spaces + 1][spaces + 1];
	protected int bg = color(0xAA, 0xAA, 0xFF);
	static double GRAVITY = .15;
	static double FRICTION = .3;
	Level level1 = new Level1();
	
	public void setup() {
		rectWidth = 500;
		rectHeight = rectWidth; // keep these the same!
		screenX = (int)Math.ceil(Math.sqrt(rectWidth * rectWidth + rectHeight * rectHeight)) + 25;
		screenY = screenX; // Do not change this equality, otherwise it will break.
		offset = -rectWidth / 2;
		size(screenX, screenY);
		strokeWeight(2);
		smooth();
		ball = new Ball(this, offset + 34, offset + 20, 0, 2, 16);
		
		level1.load();
	}
	
	public void draw() {
		background(bg);
		translate(width / 2, height / 2);
		rotate(calcAngle());
		 
		strokeWeight(2);
		rectMode(CENTER);
		rect(0, 0, rectWidth, rectHeight);
		drawGrid();
		ball.render();
	}
	
	public float calcAngle() {
		float angle = 0;
		
		if (mouseX < width / 2) {
			if (mouseY > height / 2)
				angle += PI / 2;
			else
				angle -= PI / 2;
			angle += atan((float)(width / 2 - mouseX) / (float)(mouseY - height / 2));
		}
		else
			angle += atan((float)(mouseY - height / 2) / (float)(mouseX - width / 2));
		
		return angle;
	}
	
	public void drawGrid() {
		stroke(0, 0, 0);
		for (int x = 1; x <= spaces; x++)
			for (int y = 1; y <= spaces; y++) {
				if (gridH[x][y])
					line(x * space + offset, y * space + offset, x * space + offset, (y - 1) * space + offset);
				if (gridW[x][y])
					line(x * space + offset, y * space + offset, (x - 1) * space + offset, y * space + offset);
			}
	}
}