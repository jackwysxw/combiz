package combiz.ui.po;

import java.util.Date;

import combiz.domain.po.Po;
import combiz.domain.po.Poservicedetail;
import combiz.system.ui.ListWindow;

public class PoservicedetailList extends ListWindow
{
	///////////////////////////////////??????////////////////////////////////////////////////
	/**
	 * ?????????????
	 * 
	 * ???????��?? ?????2006-12-16
	 */
	public PoservicedetailList()
	{
		super();
	}

	
	/**
	 * ????????????????????????????????
	 * @throws Exception 
	 * ???????��?? ?????2007-1-9
	 */
	public boolean addNew()
	throws Exception
	{
		//??????????????
		Po parent = (Po) this.getOwnerWnd().getMainObject();
		
		Poservicedetail newobj= new Poservicedetail();
		//newobj.setXXXX(parent.getXXXX()); //????????j????
		newobj.setPonum(parent.getPonum());
		newobj.setEnterdate(new Date());

		this.mainObject = newobj;
		return true;
	}
}