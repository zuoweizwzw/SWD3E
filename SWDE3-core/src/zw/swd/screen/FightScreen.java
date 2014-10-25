package zw.swd.screen;

import java.util.ArrayList;

import zw.swd.Cache;
import zw.swd.game.RoleModel;
import zw.swd.game.fight.FightModel;
import zw.swd.graphics.fight.FightMap;
import zw.swd.graphics.fight.FightRole;



public class FightScreen extends SWDScreen{

	public FightModel model;
	public ArrayList<FightRole> allies=new ArrayList<FightRole>();
	public ArrayList<FightRole> enemies=new ArrayList<FightRole>();
	public FightScreen(FightModel model) {
		
		super();
		
		// TODO Auto-generated constructor stub
		this.model=model;
		init();
		
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
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

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.spriteMgr.addActor(new FightMap(this.model.fightMapResID));
		for(int i=0;i<this.model.allies.size();i++)
		{
			RoleModel role=model.allies.get(i);
			FightRole fightRole=new FightRole(role);
			fightRole.setCoord(400, 200);
			fightRole.setAnimation(Cache.fightRoles.get(role.resCode+"/fight/stand_left"));
			this.spriteMgr.addActor(fightRole);
		}
	}

}
