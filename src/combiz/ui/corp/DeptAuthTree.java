package combiz.ui.corp;

import combiz.business.corp.DepartmentSrv;
import combiz.domain.corp.Corporation;
import combiz.domain.corp.Department;
import combiz.domain.corp.Labor;
import combiz.system.IBOSrvUtil;
import combiz.system.ui.ListWindow;
import combiz.system.ui.MainWindow;
import combiz.system.ui.TopWindow;
import combiz.system.util.Util;
import combiz.ui.corp.CorporationWindow;

import java.util.List;

import com.inbasis.zk.ui.Page;
import com.inbasis.zk.ui.UiException;
import com.inbasis.zk.ui.event.Event;
import com.inbasis.zul.Tree;
import com.inbasis.zul.Treecell;
import com.inbasis.zul.Treechildren;
import com.inbasis.zul.Treeitem;
import com.inbasis.zul.Treerow;

/**
 * 
 * @author brianhong
 *
 */
public class DeptAuthTree extends Tree
{
	DepartmentSrv departmentSrv;
	MainWindow mainWnd;
	
	public DeptAuthTree() 
	{
		super();
		this.setId("deptAuthTree_tree");
	}


	
	/**
	 * 
	 * 
	 * 作者：洪小林 日期：2007-6-6
	 * @throws Exception 
	 */
	public void onCreate()
	throws Exception
	{
		this.setVflex(true);
		
		Page topPage = this.getDesktop().getPage("topPage");
		TopWindow topWnd = (TopWindow) topPage.getFellow("topWnd");
		this.setHeight((topWnd.getDesktopHeight() - 180) +"px");
	}
	
	
	/**
	 * 
	 * 
	 * 作者：洪小林 日期：2007-6-6
	 * @throws Exception 
	 */
	public void createNavTree() 
	throws Exception
	{
		//清除树，重新构建
		this.getChildren().clear();
		
		mainWnd = (MainWindow) this.getFellow("mainWnd");
		Corporation corporation = (Corporation) mainWnd.getMainObject();
		departmentSrv = (DepartmentSrv)IBOSrvUtil.getSrv("department");
		departmentSrv.setOrderBy("orderby");
		List list = departmentSrv.findWithQuery("parent is null");
		if(list==null || list.isEmpty())
		{
			Treechildren tc = new Treechildren();
			tc.appendChild(new Treeitem("没有数据！"));
			this.appendChild(tc);
			return;
		}
		
		Treechildren tc = new Treechildren();
		Treeitem ti;
		for(int i=0;i<list.size();i++)
		{
			Department department = (Department)list.get(i);
			ti = new Treeitem(department.getDescription()); // + "[" + department.getDeptnum() + "]"
			ti.setValue(department);
			ti.setAttribute("type", "department");
			if(Util.getBoolean(department.getIscrewid()))
				ti.setImage("/images/nav_parent.gif");
			//else
			//	ti.setImage("/images/node_image_dept.gif");
			ti.setOpen(true);
			//很重要！这段不加上，树的自动滚动就出不来。
			Treerow treerow = (Treerow)ti.getChildren().get(0);
			Treecell treecell = (Treecell)treerow.getChildren().get(0);
			treecell.setStyle("white-space:nowrap;");
			//////////////////////////////////////////////
			if(Util.getBoolean(department.getHaschild()))
			{
				Treechildren nextChild = new Treechildren();
				ti.appendChild(nextChild);
				ti.addEventListener("onOpen", new openNode());
				this.expand(ti);
			}
			tc.appendChild(ti);
		}
		this.appendChild(tc);
		
		if(this.getItemCount()>0)
		{
			Treeitem treeitem = (Treeitem)this.getItems().iterator().next();
			this.selectItem(treeitem);
		}
		this.onSelect();
	}
	
	
	/**
	 * 展开树节点
	 * @param parentitem
	 * 作者：洪小林 日期：2007-4-25
	 */
	public void expand(Treeitem parentitem)
	throws Exception
	{
		//*********第一种：每次都删除后重新从数据库中取数
		Treechildren tc = parentitem.getTreechildren();
		if(tc!=null && tc.getChildren().size()>0)
			tc.getChildren().clear();

		Department parent = (Department)parentitem.getValue();
		//列出该部门下的人员
		List laborlist = mainWnd.getMainSrv().getBaseDao().findWithQuery(Labor.class, "deptnum='"+parent.getDeptnum()+"'");
		if(laborlist.size()>0)
		{
			Treeitem tichld;
			for(int j=0;j<laborlist.size();j++)
			{
				Labor labor = (Labor) laborlist.get(j);
				tichld = new Treeitem(labor.getLaborname());  //+"["+labor.getLabornum()+"]"
				tichld.setValue(labor);
				tichld.setAttribute("type", "labor");
				tichld.setImage("/images/top_personal.gif");
				tc.appendChild(tichld);
			}
		}
		//列出子部门
		List list = departmentSrv.findWithQuery("parent = '"+parent.getDeptnum()+"'");
		Treeitem ti;
		for(int i=0;i<list.size();i++)
		{
			Department department = (Department)list.get(i);
			ti = new Treeitem(department.getDescription());  // + "[" + department.getDeptnum() + "]"
			ti.setValue(department);
			ti.setAttribute("type", "department");
			if(Util.getBoolean(department.getIscrewid()))
				ti.setImage("/images/nav_parent.gif");
			//else
			//	ti.setImage("/images/node_image_dept.gif");
			ti.setOpen(true);
			//很重要！这段不加上，树的自动滚动就出不来。
			Treerow treerow = (Treerow)ti.getChildren().get(0);
			Treecell treecell = (Treecell)treerow.getChildren().get(0);
			treecell.setStyle("white-space:nowrap;");
			//////////////////////////////////////////////
			
			//if(Util.getBoolean(department.getHaschild()))
			//{
				Treechildren nextChild = new Treechildren();
				ti.appendChild(nextChild);
				ti.addEventListener("onOpen", new openNode());
				ti.setOpen(false);
			//}
			tc.appendChild(ti);
			//递归打开所有子集
			//if(Util.getBoolean(department.getHaschild()))
			//{
				//this.expand(ti);
			//}
		}
	}
	
	
	public class openNode implements com.inbasis.zk.ui.event.EventListener {
		public void onEvent(Event event) throws UiException {
			Treeitem treeitem = (Treeitem)event.getTarget();
			try {
				expand(treeitem);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public boolean isAsap() {
		return true; //Refer the following section for description
		}
	}
	

	
	/**
	 * 
	 * @TODO 选择事件
	 * @throws Exception
	 * @洪小林  2007-8-16  下午03:44:11
	 */
	public void onSelect()
	throws Exception
	{
		ListWindow listWnd = (ListWindow) this.getFellow("deptlabortable");
		
		Treeitem treeitem = getSelectedItem();
		String type = (String) treeitem.getAttribute("type");
		if(type!=null)
		{
			if(type.equals("department"))
			{
				Department department = (Department) treeitem.getValue();
				listWnd.getResultList("deptnum='"+department.getDeptnum()+"'");
			}
			else if(type.equals("labor"))
			{
				Labor labor = (Labor) treeitem.getValue();
				listWnd.getResultList("labornum='"+labor.getLabornum()+"'");
				CorporationWindow corpWnd = (CorporationWindow) this.getFellow("mainWnd");
				corpWnd.updateAuthList(labor);
			}
		}
	}
	
	
	
	//////////////////////////////////////////////////////////////////
	/**
	 *混淆
	 */
	private class NullClick
	{
		private void onEvent(Event event) throws UiException 
		{
			try {
			} catch (Exception e) {
				try {
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		private boolean isAsap() 
		{
			return true;
		}
	}
}
