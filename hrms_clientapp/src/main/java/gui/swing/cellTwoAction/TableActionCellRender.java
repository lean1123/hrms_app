package gui.swing.cellTwoAction;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author RAVEN
 */
public class TableActionCellRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
        PanelAction action = new PanelAction();
        if (isSeleted == false) {
            action.setBackground(Color.WHITE);
        } else {
           action.setBackground(new Color(239, 244, 255));
        }
        return action;
    }
}
