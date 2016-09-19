package combiz.ui.doclib;

import combiz.system.FieldAdapter;
import combiz.system.ui.common.ICheckbox;
import combiz.system.ui.common.ICombobox;

import com.inbasis.zk.ui.Component;

public class FldDocread extends FieldAdapter
{	
	
	/**
	 * 初始化字段数据的时候调用该方法，该方法是在字段数据值被设置后（绑定后）调用的。
	 * 如果
	 */
	public void init(Component component)
	throws Exception
	{
	}

	/**
	 * 字段上鼠标移开后调用该方法。
	 * 可以利用该方法来进行数据的合法性效验。
	 */
	public void validate(Component component) 
	throws Exception 
	{
		
	}

	/**
	 * 
	 */
	public void action(Component component)
	throws Exception
	{
		String chk = (String) this.getValueByColname("docread");
		if(chk!=null && chk.equals("否"))
		{
			this.setValueByColname("docedit", "否");
		}
	}

}
