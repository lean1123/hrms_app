package gui.swing.cellActionApproved;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


public class TableActionCellEditor extends DefaultCellEditor {

    private static final long serialVersionUID = 1L;
	private TableActionEvent event;

    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelAction action = null;
        if (jtable.getValueAt(row, column-1).equals("Approved")) {
        	action = new PanelAction(true);
        }
        else {
        	action = new PanelAction(false);
        }
        action.initEvent(event, row);
        action.setBackground(new Color(239, 244, 255));
        return action;
    }
}
