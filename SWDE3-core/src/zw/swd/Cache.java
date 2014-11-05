package zw.swd;

import java.util.HashMap;

import zw.swd.game.MagicModel;
import zw.swd.graphics.Animation;
import zw.swd.graphics.scene.SceneMap;
import zw.swd.gui.Paper;

public class Cache {

	public static HashMap<String,MagicModel> magics=new HashMap<String, MagicModel>();
	public static HashMap<String,Animation>  fightMaps=new HashMap<String, Animation>();
	public static HashMap<String,Animation> fightRoles=new HashMap<String, Animation>();
	public static HashMap<String, Paper> controls=new HashMap<String, Paper>();
	
}
