package combiz.ui.po;


import combiz.domain.po.Poline;
import combiz.system.FieldAdapter;
import combiz.system.ui.RecWindow;

import com.inbasis.zk.ui.Component;
import com.inbasis.zul.Doublebox;

public class FldOrderqty extends FieldAdapter
{	
	
	/**
	 * ��ʼ���ֶ����ݵ�ʱ����ø÷������÷��������ֶ�����ֵ�����ú󣨰󶨺󣩵��õġ�
	 * ���
	 */
	public void init(Component component) 
	{
		
	}

	/**
	 * 
	 * @TODO �������뿪�����ı���ʱ��ϵͳ�Զ����㵥���������Ļ�������ֵ����һ���ı���
	 * @param component
	 * @throws Exception
	 * @����� 2007-8-8 ����11:06:49
	 */
	public void validate(Component component) 
	throws Exception 
	{	
		double unitcost=0.0,orderqty=0.0,taxunitcost=0.0,receivedqty=0.0;
		//�õ���������
		Poline pl = (Poline)this.mainObject;
		//����
		Doublebox dbox = (Doublebox)component;
		if(dbox.getValue()==null){
			orderqty=0;
			//throw new WrongValueException(dbox,"<font color='red'>�����붩������</font>");
		}else{
		orderqty = dbox.getValue();
		}
		//����˰����
		Doublebox dbox1 = (Doublebox)dbox.getFellow("poline.unitcost");
		
		if(dbox1.getValue()==null){
			unitcost=0;
			//throw new WrongValueException(dbox1,"<font color='red'>�����뵥��</font>");
		}else{
			unitcost = dbox1.getValue();
		}
		//��˰����
		Doublebox dbox2 = (Doublebox)dbox.getFellow("poline.taxunitcost");
		if(dbox2.getValue()==null){
			taxunitcost = 0;
		}else{taxunitcost=dbox2.getValue();}
		//����˰�ܼ�
		double num = unitcost * orderqty;
		pl.setLinecost(num);
		
		//��˰�ܼ�
		double taxnum = orderqty * taxunitcost;
		pl.setTaxlinecost(taxnum);
		
		//��������RECEIVEDQTY
		Doublebox dbox3 = (Doublebox)dbox.getFellow("poline.receivedqty");
		if(dbox3.getValue()==null){
			receivedqty = 0.0;
		}else{receivedqty=dbox3.getValue();}
		//��������
		double rejectedqty = orderqty - receivedqty;
 
		pl.setRejectedqty(rejectedqty);
		//ֵ�󶨣�������󶨣���֮ǰ�ĸ�ֵ���׷ѹ���
		RecWindow  recWnd = (RecWindow)component.getFellow("mainWnd");
		recWnd.bandData();
	}

	/**
	 * 
	 */
	public void action(Component component)
	{
		
	}

}