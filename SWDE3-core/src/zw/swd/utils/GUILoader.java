package zw.swd.utils;

import java.io.FileInputStream;

import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

import zw.swd.Config;
import zw.swd.gui.Paper;

public class GUILoader {

	public static Paper loadControls()
	{
		XmlReader reader=new XmlReader();
		try
		{
		Element root=reader.parse(new FileInputStream(Config.resPath+"\\gui\\scripts\\1.xml"));
		int count=root.getChildCount();
		for(int i=0;i<count;i++)
		{
			Element controlElement=root.getChild(i);
			if(!controlElement.getName().equals("control")) continue;
			Paper paper=loadControl(controlElement);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static Paper loadControl(Element controlElement) throws Exception
	{
		String type=controlElement.get("type");
		Class c=Class.forName(type);
		Paper paper=(Paper) c.newInstance();
		paper.setName(controlElement.get("id"));
		if(controlElement.getAttributes().containsKey("size"))
		{
		String size_str=controlElement.get("size");
		paper.setSize(Float.parseFloat(size_str.split(",")[0]), Float.parseFloat(size_str.split(",")[1]));
		}
		if(controlElement.getAttributes().containsKey("location"))
		{
		String location_str=controlElement.get("location");
		paper.setPosition(Float.parseFloat(location_str.split(",")[0]), Float.parseFloat(location_str.split(",")[1]));
		}
		return paper;
	}
}
