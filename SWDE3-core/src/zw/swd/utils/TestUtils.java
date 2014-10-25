package zw.swd.utils;

import zw.swd.game.RoleModel;
import zw.swd.game.fight.FightModel;

public class TestUtils {

	public static RoleModel generateRoleModel(String resID)
	{
		RoleModel model=new RoleModel();
		model.gameID=resID+"/1";
		model.resCode=resID;
		
		if(resID.equals("001"))
		{
		model.name="陈靖仇";
		model.description="游戏主角";
		model.hp=1200;
		model.hp_max=1600;
		model.mp=400;
		model.mp_max=400;
		model.energe=100;
		model.energe=200;
		}
		if(resID.equals("002"))
		{
			model.name="于小雪";
			model.description="游戏主角";
			model.hp=1200;
			model.hp_max=1600;
			model.mp=400;
			model.mp_max=400;
			model.energe=100;
			model.energe=200;
		}
		return model;
	}
	public static FightModel generateFightModel()
	{
		FightModel model=new FightModel();
		model.allies.add(generateRoleModel("001"));
		model.fightMapResID="fightmap/1-1";
		return model;
	}
}
