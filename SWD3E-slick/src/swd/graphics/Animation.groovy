package swd.graphics

import java.util.ArrayList;

import org.lwjgl.Sys;
import org.newdawn.slick.Color;

class Animation {

	private ArrayList<Frame> frames = new ArrayList<Frame>();
	public int currentFrame=-1;
	private long nextChange = 0;
	private boolean stopped = false;
	private long lastUpdate;
	private boolean firstUpdate = true;
	private boolean autoUpdate = true;
	private boolean loop = true;
	
	private void nextFrame(long delta) {
		if (stopped) {
			return;
		}
		if (frames.size() == 0) {
			return;
		}
		
		nextChange -= delta;
		
		while (nextChange < 0 && (!stopped)) {
			
			if ((currentFrame == frames.size() - 1) && (!loop)) {
				stopped = true;
				break;
			}
			currentFrame = (currentFrame + 1) % frames.size();
			
			int realDuration = (int) (((Frame) frames.get(currentFrame)).duration);
			nextChange = nextChange + realDuration;
		}
	}
	
	public void draw(float x,float y,float width,float height, Color col) {
		if (frames.size() == 0) {
			return;
		}
		
		if (autoUpdate) {
			long now = getTime();
			long delta = now - lastUpdate;
			if (firstUpdate) {
				delta = 0;
				firstUpdate = false;
			}
			lastUpdate = now;
			nextFrame(delta);
		}
		
		Frame frame = (Frame) frames.get(currentFrame);
		frame.draw(x,y,width,height, col);
	}
	private long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public int getWidth() {
		return ((Frame) frames.get(currentFrame)).getWidth();
	}
	
	public int getHeight() {
		return ((Frame) frames.get(currentFrame)).getHeight();
	}
}
