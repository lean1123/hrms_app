package gui.form;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gui.dialog.Message;
import gui.main.Application;
import gui.main.Main;
import gui.model.ModelAttendance;
import gui.model.ModelCard;
import gui.model.ModelEmployee;
import gui.model.ModelEmployee1;
import gui.model.ModelLeavesOfAbsence;
import gui.swing.cellAction.TableActionCellEditor;
import gui.swing.cellAction.TableActionCellRender;
import gui.swing.cellAction.TableActionEvent;
import gui.swing.icon.GoogleMaterialDesignIcons;
import gui.swing.icon.IconFontSwing;
import gui.swing.table.ModelProfile;
import gui.swing.table.Table;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import entity.Employee;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.Font;

public class Form_Leader_Employees extends JPanel {
	private static List<Employee> list = null;

	public Form_Leader_Employees() {
		initComponents();
		table1.fixTable(jScrollPane1);
		setOpaque(false);
		initData();
	}

	private void initData() {
		initCardData();
		// initNoticeBoard();
		initTableData();
	}

	public static void reloadTableData() {
		// table1.setModel();
		DefaultTableModel dm = (DefaultTableModel) table1.getModel();
		dm.getDataVector().removeAllElements();

		try {
			list = Application.employeeDao.getEmployeesByLeader(Application.idUserLogin);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list!=null) {
			for (Employee employee : list) {
				Icon icon = null;
				try {
					URL url = new URL(employee.getAvatar());
					icon = new ImageIcon(url);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					icon = new ImageIcon(Form_Admin_Employees.class.getResource("/gui/icon/noimage.jpg"));
				}

				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				table1.addRow(new Object[] { employee.getId(), new ModelProfile(icon, employee.getFullName()),
						employee.isSex() ? "Male" : "Female", dateTimeFormatter.format(employee.getDob()),
						employee.getDepartment().getName(), employee.getRole().name() });
			}
		}
		
	}

	private void initTableData() {

		// table1.addRow(new ModelEmployee1("00012",new
		// ImageIcon(getClass().getResource("/gui/icon/profile.jpg")), "Jonh",
		// "Apple","Dev","Dev","Active").toRowTable());
		// table1.addRow(new ModelEmployee1("00013",new
		// ImageIcon(getClass().getResource("/gui/icon/profile1.jpg")), "Dara",
		// "Apple","Dev","Dev","Active").toRowTable());
		DefaultTableModel dm = (DefaultTableModel) table1.getModel();
		dm.getDataVector().removeAllElements();

		try {
			list = Application.employeeDao.getEmployeesByLeader(Application.idUserLogin);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list!=null) {
			for (Employee employee : list) {
				Icon icon = null;
				try {
					URL url = new URL(employee.getAvatar());
					icon = new ImageIcon(url);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					icon = new ImageIcon(getClass().getResource("/gui/icon/noimage.jpg"));
				}

				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				table1.addRow(new Object[] { employee.getId(), new ModelProfile(icon, employee.getFullName()),
						employee.isSex() ? "Male" : "Female", dateTimeFormatter.format(employee.getDob()),
						employee.getDepartment().getName(), employee.getRole().name() });
			}
		}
		

	}

	private void initCardData() {
		Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 60, new Color(255, 255, 255, 100),
				new Color(255, 255, 255, 15));
		card1.setData(new ModelCard("EMPLOYEES", "Regular", "Trainee", 5, 6, icon1));

	}

//    private void initNoticeBoard() {
//        noticeBoard.addDate("04/10/2021");
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(94, 49, 238), "Hidemode", "Now", "Sets the hide mode for the component. If the hide mode has been specified in the This hide mode can be overridden by the component constraint."));
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(218, 49, 238), "Tag", "2h ago", "Tags the component with metadata name that can be used by the layout engine. The tag can be used to explain for the layout manager what the components is showing, such as an OK or Cancel button."));
//        noticeBoard.addDate("03/10/2021");
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), "Further Reading", "12:30 PM", "There are more information to digest regarding MigLayout. The resources are all available at www.migcomponents.com"));
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(50, 93, 215), "Span", "10:30 AM", "Spans the current cell (merges) over a number of cells. Practically this means that this cell and the count number of cells will be treated as one cell and the component can use the space that all these cells have."));
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(27, 188, 204), "Skip ", "9:00 AM", "Skips a number of cells in the flow. This is used to jump over a number of cells before the next free cell is looked for. The skipping is done before this component is put in a cell and thus this cells is affected by it. \"count\" defaults to 1 if not specified."));
//        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(238, 46, 57), "Push", "7:15 AM", "Makes the row and/or column that the component is residing in grow with \"weight\". This can be used instead of having a \"grow\" keyword in the column/row constraints."));
//        noticeBoard.scrollToTop();
//    }

//    private boolean showMessage(String message) {
//        Message obj = new Message(Main.getFrames()[0], true);
//        obj.showMessage(message);
//        return obj.isOk();
//    }

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		card1 = new gui.component.Card();
		jLabel1 = new javax.swing.JLabel();
		card2 = new gui.component.Card();
		card3 = new gui.component.Card();
//        card4 = new gui.component.Card();
		jPanel1 = new javax.swing.JPanel();

		jLabel5 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();

		table1 = new gui.swing.table.Table();

		btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Application.main.showForm(new Form_Leader_Employee_AddNew());
			}
		});
		btnAdd.setIcon(new ImageIcon(Form_Leader_Employees.class.getResource("/gui/icon/add.png")));
		btnAdd.setBackground(Color.GREEN);
		btnAdd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

		card1.setColorGradient(new java.awt.Color(211, 28, 215));

		jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(4, 72, 210));
		jLabel1.setText("My Department / Employees");

		card2.setBackground(new java.awt.Color(10, 30, 214));
		card2.setColorGradient(new java.awt.Color(72, 111, 252));

		card3.setBackground(new java.awt.Color(194, 85, 1));
		card3.setColorGradient(new java.awt.Color(255, 212, 99));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(76, 76, 76));
		jLabel5.setText("List Employee");
		jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

		table1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Name", "Gender", "Date Of Birth", "Department", "Position", "" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, true };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		event = new TableActionEvent() {

			@Override
			public void onView(int row) {
				// TODO Auto-generated method stub
				int id = (int) table1.getValueAt(row, 0);
				Application.main.showForm(new Form_Leader_Employee_ViewProfile(id));
			}

			@Override
			public void onEdit(int row) {
				// TODO Auto-generated method stub
				int id = (int) table1.getValueAt(row, 0);
				Application.main.showForm(new Form_Leader_Employee_Edit(id));
			}

			@Override
			public void onDelete(int row) {
				// TODO Auto-generated method stub
				if (table1.isEditing()) {
					table1.getCellEditor().stopCellEditing();
				}
				int id = (int) table1.getValueAt(row, 0);
				try {
					if (Application.employeeDao.delete(Application.employeeDao.findById(id))) {
						reloadTableData();
						// DefaultTableModel model = (DefaultTableModel) table1.getModel();
						// model.removeRow(row);
						Application.showMessageSucces("deleted");

					}

					else
						Application.showMessageError("Faild");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		table1.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
		table1.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));

		jScrollPane1.setViewportView(table1);
		if (table1.getColumnModel().getColumnCount() > 0) {
			table1.getColumnModel().getColumn(0).setPreferredWidth(150);
		}

		txtSearch = new JTextField();
		txtSearch.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSearch.setBackground(new Color(30, 144, 255));

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = txtSearch.getText();
				if (s.equals("")) {
					reloadTableData();
				} else {
					try {
						list = Application.employeeDao.findByName(s);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (list != null) {
						DefaultTableModel dm = (DefaultTableModel) table1.getModel();
						dm.getDataVector().removeAllElements();
						for (Employee employee : list) {
							Icon icon = null;
							try {
								URL url = new URL(employee.getAvatar());
								icon = new ImageIcon(url);
							} catch (MalformedURLException e1) {
								// TODO Auto-generated catch block
								icon = new ImageIcon(Form_Admin_Employees.class.getResource("/gui/icon/noimage.jpg"));
							}

							DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							table1.addRow(new Object[] { employee.getId(),
									new ModelProfile(icon, employee.getFullName()),
									employee.isSex() ? "Male" : "Female", dateTimeFormatter.format(employee.getDob()),
									employee.getDepartment().getName(), employee.getRole().name() });
						}
					} 
					else	Application.showMessageWarning("Not found name employee");
				}
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel5)
								.addPreferredGap(ComponentPlacement.RELATED, 549, Short.MAX_VALUE).addComponent(btnAdd)
								.addContainerGap())
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(477, Short.MAX_VALUE)
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout
								.createParallelGroup(Alignment.BASELINE).addComponent(jLabel5).addComponent(btnAdd))
						.addGap(9)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSearch))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)));
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(18)
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE).addContainerGap()));
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private gui.component.Card card1;
	private gui.component.Card card2;
	private gui.component.Card card3;
//    private gui.component.Card card4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private static gui.swing.table.Table table1;

	private JButton btnAdd;

	private TableActionEvent event;
	private JTextField txtSearch;
	private JButton btnSearch;
}
