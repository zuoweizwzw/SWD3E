package zw.swd.gui.actions;

import java.util.ArrayList;

import zw.swd.gui.Dialog1;
import zw.swd.screen.SWDScreen;

import com.badlogic.gdx.scenes.scene2d.Action;

public class ShowDialogTextAction extends Action{

	public StringBuffer totalText;
	public ArrayList<StringBuffer> showText=new ArrayList<StringBuffer>();
	
	SWDScreen screen;
	public int status=0;
	public float speed=0.02f;
	public float count=0;
	@Override
	public boolean act(float delta) {
		// TODO Auto-generated method stub
		Dialog1 dialog=(Dialog1)screen.guiMgr.findActorByName("gui/dialog1");
		if(status==0)
		{
			count=0;
			status=1;
			dialog.clearText();
			showText.add(new StringBuffer());
		}
		if(status==1)
		{
			count+=delta;
			if(count>=speed)
			{
				count=0;
				if(totalText.charAt(0)=='['&&(totalText.charAt(10)==']'||totalText.charAt(8)==']'))
				{
					char c=totalText.charAt(0);
					while(c!=']')
					{
						showText.get(showText.size()-1).append(totalText.charAt(0));
						totalText.deleteCharAt(0);
						c=totalText.charAt(0);
					}
					showText.get(showText.size()-1).append(totalText.charAt(0));
					totalText.deleteCharAt(0);
				}
				if(totalText.charAt(0)=='\n')
				{
					showText.add(new StringBuffer());
				}
				if(dialog.textBox.font.getBounds(showText.get(showText.size()-1)).width>480)
				{
					showText.get(showText.size()-1).append("\n");
					showText.add(new StringBuffer());
				}
				showText.get(showText.size()-1).append(totalText.charAt(0));
				totalText.deleteCharAt(0);
				
				
				String finalText="";
				for(StringBuffer buffer:showText)
				{
					finalText+=buffer.toString();
				}
				dialog.textBox.text=finalText;
				if(totalText.length()==0)
				{
					return true;
				}
			}
		}
		return false;
	}
	public ShowDialogTextAction(SWDScreen screen,String text) {
		// TODO Auto-generated constructor stub
		this.screen=screen;
		this.totalText=new StringBuffer(text);
	}

}
