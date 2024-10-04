package gui.swing.cellAction;

/**
 *
 * @author RAVEN
 */
public interface TableActionEvent {

    public void onView(int row);

    public void onDelete(int row);

    public void onEdit(int row);
}
