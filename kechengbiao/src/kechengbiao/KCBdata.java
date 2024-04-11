package kechengbiao;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class KCBdata implements TableModel {
	
	private String[] title = {"周一","周二","周三","周四","周五","周六","周日"};
	private String[][] data=new String[8][7];
	
	
	public KCBdata() {
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[0].length;j++) {
				data[i][j]="";
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRowCount() {
		return 8;
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return title[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		return String.class;//这是什么写法？
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		data[rowIndex][columnIndex]=(String)aValue;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
