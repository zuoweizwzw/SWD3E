package zw.swd.screen;

import zw.swd.game.actions.AnimationAction3;
import zw.swd.game.actions.AnimationAction;
import zw.swd.game.actions.MoveAction;
import zw.swd.game.actions.SceneActorMoveAction;
import zw.swd.game.actions.SceneActorRunAction;
import zw.swd.game.actions.SceneActorWalkAction;
import zw.swd.graphics.scene.SceneActor;
import zw.swd.graphics.scene.SceneMap;
import zw.swd.gui.ControlFactory;
import zw.swd.gui.Dialog1;
import zw.swd.gui.actions.CloseDialogAction;
import zw.swd.gui.actions.OpenDialogAction;
import zw.swd.gui.actions.ShowDialogTextAction;
import zw.swd.gui.actions.StartFightAction;
import zw.swd.gui.actions.WaitMouseClickAction;
import zw.swd.math.Vector2;
import zw.swd.utils.FontLoader;
import zw.swd.utils.MagicLoader;
import zw.swd.utils.MapLoader;
import zw.swd.utils.Mappings;
import zw.swd.utils.SceneActorLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;

public class SceneScreen extends SWDScreen {

	public SceneMap sceneMap;
	SceneActor actor;
	public int gameState = 0;

	public SceneScreen() {
		// TODO Auto-generated constructor stub
		super();
		this.setSceneMap(MapLoader.loadSceneMap("1-1"));
		actor = new SceneActor("001");
		actor.pool = SceneActorLoader.loadSceneActorAnis("001");
		actor.setCurrentAniByName("run_leftdown");
		actor.setCoord(320, 240);

		this.sceneMap.sprites.addActor(actor);
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		handleAnalogInput();
		super.render(delta);
		
		
	}

	private void handleAnalogInput() {
		// TODO Auto-generated method stub
		handleMouseAnalog();
	}

	private void handleMouseAnalog() {
		// TODO Auto-generated method stub
		if (Gdx.input.isButtonPressed(Buttons.RIGHT)) {
			moveActor();

		}
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		Dialog1 dialog=(Dialog1)guiMgr.findActorByName("gui/dialog1");
		this.gameState=1;
		SequenceAction sequence=Actions.sequence(				
				new StartFightAction(this)
				);
		this.guiMgr.addAction(sequence);
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		if (button == Buttons.RIGHT) {
			if (gameState == 0) {

				if (actor.getActions().size > 0
						&& actor.getActions().get(0) instanceof SceneActorMoveAction) {
					SceneActorMoveAction action = (SceneActorMoveAction) this.actor
							.getActions().get(0);
					action.stopCmd = true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setSceneMap(SceneMap sceneMap) {
		this.sceneMap = sceneMap;
		this.spriteMgr.addActor(sceneMap);
	}

	private void moveActor() {

		Vector2 mouse = new Vector2(Gdx.input.getX(), 480 - Gdx.input.getY());
		Vector2 centerPoint = actor.getCenterPoint();
		Vector3 centerPoint_screen = this.spriteMgr.getCamera().project(
				new Vector3(centerPoint.x, centerPoint.y, 0));
		Vector2 deltaVec = mouse.subNew(new Vector2(centerPoint_screen.x,
				centerPoint_screen.y));

		int direction = (Mappings.getDirectionByVector(deltaVec));

		if (direction == -1)
			return;

		if (gameState == 0) {
			if (this.actor.getActions().size == 0) {

				if (deltaVec.len() <= 32)
					return;
				if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))this.actor
						.addAction(new SceneActorRunAction(direction, actor));
				else this.actor
				.addAction(new SceneActorWalkAction(direction, actor));
			} else if (actor.getActions().get(0) instanceof SceneActorMoveAction) {

				SceneActorMoveAction action = (SceneActorMoveAction) this.actor
						.getActions().get(0);
				if (deltaVec.len() <= 32) {
					action.stopCmd = true;
				}
				
				if(action instanceof SceneActorWalkAction&&Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
				{
					actor.removeAction(action);
					this.actor.addAction(new SceneActorRunAction(direction, actor));					
				}
				if(action instanceof SceneActorRunAction&&!Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
				{
					actor.removeAction(action);
					this.actor.addAction(new SceneActorWalkAction(direction, actor));					
				}
				if (action.direction != direction) {
					action.changeDirection(direction);
				}
			}

		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
