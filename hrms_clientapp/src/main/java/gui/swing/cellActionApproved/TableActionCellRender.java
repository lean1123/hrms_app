package gui.swing.cellActionApproved;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class TableActionCellRender extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

	@Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
    	PanelAction action = null;
        if (jtable.getValueAt(row, column-1).equals("Approved")) {
        	action = new PanelAction(true);
        }
        else {
        	action = new PanelAction(false);
        }
        if (isSeleted == false) {
            action.setBackground(Color.WHITE);
        } else {
           action.setBackground(new Color(239, 244, 255));
        }
        return action;
    }
}
