package swd.graphics

import org.newdawn.slick.Color;
import org.newdawn.slick.Image

class FrameItem {

	public boolean main;
	public Image img;
	public int offsetX;
	public int offsetY;
	public void draw(float x,float y,float width,float height, Color col)
	{
		img.draw(x+offsetX, y+offsetY, width, height, col);
	}
}
