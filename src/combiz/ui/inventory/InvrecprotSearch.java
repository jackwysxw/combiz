package combiz.ui.inventory;
import java.util.List;

import combiz.business.corp.LaborSrv;
import combiz.business.inventory.InvrectransSrv;
import combiz.business.inventory.WarehouseSrv;
import combiz.domain.inventory.Warehouse;
import combiz.system.IBOSrvUtil;
import combiz.system.ui.SearchWindow;
import combiz.system.ui.common.SBandbox;
import combiz.system.ui.common.SCombobox;
import combiz.system.util.Util;
public class InvrecprotSearch extends SearchWindow {

	@Override
	public void search() throws Exception {
		// TODO Auto-generated method stub
		int sumcount = 0;
		LaborSrv laborSrv;
 		laborSrv = (LaborSrv)IBOSrvUtil.getSrv("labor");
 		InvrectransSrv invusetranssrv = (InvrectransSrv)IBOSrvUtil.getSrv("invrectrans");
		SBandbox sband = (SBandbox) this.getFellow("invrectrans.towarehouse");
		String entersite = sband.getValue();
		if(Util.isNull(entersite))
		{
			throw new Exception("报表条件'仓库'不能为空，请确认！");
		}
 		WarehouseSrv warehousesrv = (WarehouseSrv)IBOSrvUtil.getSrv("warehouse");
 		List warelist = warehousesrv.getBaseDao().findWithQuery(Warehouse.class, "warehouse = '"+entersite+"'");
 		if (warelist.size()<0) {
 			throw new Exception("选择的'仓库'不存在，请确认！");
 		}
 		
 		SCombobox syear = (SCombobox) this.getFellow("invrectrans.transdate");
		String soyear = syear.getValue();
		if(Util.isNull(soyear))
		{
			throw new Exception("报表条件'查询年度'不能为空，请确认！");
		}
 		
		SCombobox smon = (SCombobox) this.getFellow("invrectrans.actualdate");
		String somon = smon.getValue();
		if(Util.isNull(somon))
		{
			throw new Exception("报表条件'查询月份'不能为空，请确认！");
		}
 		/*SBandbox sesitenum = (SBandbox) this.getFellow("invreport.sitenum");
		String sitenum = sesitenum.getValue();
		if(Util.isNull(sitenum))
		{
			throw new Exception("报表条件'地点'不能为空，请确认！");
		}
		SEDatebox setime = (SEDatebox) this.getFellow("s_invreport.thisdate");
		Date thistime = setime.getValue();
		if(thistime == null)
		{
			throw new Exception("报表条件'查询月份'不能为空，请确认！");
		}*/
		super.search();
	}
	

}
