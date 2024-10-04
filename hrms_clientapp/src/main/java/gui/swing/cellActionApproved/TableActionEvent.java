package gui.swing.cellActionApproved;

public interface TableActionEvent {

    public void onApproved(int row);
    
    public void onDeny(int row);

    public void onDelete(int row);

    public void onEdit(int row);
}
