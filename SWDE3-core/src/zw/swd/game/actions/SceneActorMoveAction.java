package zw.swd.game.actions;

import com.badlogic.gdx.scenes.scene2d.Action;

public abstract class SceneActorMoveAction extends Action{

	public boolean stopCmd=false;
	public int direction;
	public void sendStopCmd()
	{
		this.stopCmd=true;
	}
	
	public abstract void changeDirection(int direction);
	}

