package gui.form;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import entity.Attendance;
import entity.Payroll;
import gui.dialog.Message;
import gui.main.Application;
import gui.main.Main;
import gui.model.ModelAttendancesTable;
import gui.model.ModelCard;
import gui.model.ModelEmployee1;
import gui.swing.cellJustEdit.TableActionCellEditor;
import gui.swing.cellJustEdit.TableActionCellRender;
import gui.swing.cellJustEdit.TableActionEvent;
import gui.swing.dateChooser.DateChooser;
import gui.swing.icon.GoogleMaterialDesignIcons;
import gui.swing.icon.IconFontSwing;
import gui.swing.table.ModelProfile;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form_Admin_Salary extends JPanel {
	private static List<Payroll> list = null;
	public Form_Admin_Salary() {
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
	
	public static void reloadData() {
		DefaultTableModel dm = (DefaultTableModel) table1.getModel();
		dm.getDataVector().removeAllElements();
		try {
			list = Application.payrollsDao.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DecimalFormat df = new DecimalFormat("#,###.#");
		for (Payroll p : list) {
			table1.addRow(new Object[] {p.getMonth()+"-"+p.getYear(),p.getEmployee().getFullName(),p.getEmployee().getDepartment().getName(),p.getEmployee().getRole(),
					df.format(p.getEmployee().getAggrementInfo().getBasicSalary()),p.getWorkDays(),df.format(p.getEmployee().getAggrementInfo().getAllowance()),
					df.format(p.getSalaryTotal()),df.format(p.getBHXH()),df.format(p.getBHYT()),df.format(p.getBHTN()),
					df.format(p.getRealSalary())});
//			table1.addRow(new Object[] { p.getMonth() + "-" + p.getYear(), 
//					df.format(p.getEmployee().getAggrementInfo().getBasicSalary()), p.getWorkDays(),
//					df.format(p.getEmployee().getAggrementInfo().getAllowance()), df.format(p.getSalaryTotal()),
//					df.format(p.getBHXH()), df.format(p.getBHYT()), df.format(p.getBHTN()), df.format(p.getBHXH()),
//					df.format(p.getSalaryTotal()) });
		}
	}
	
	private void initTableData() {

		// table1.addRow(new ModelAttendancesTable(LocalDate.now(), "Nguyen Hoang Huy",
		// "08:01:00 AM", "04:01:00 PM", "8 hr 0 mins", "In time/On
		// time").toRowTable());
		// table1.addRow(new ModelAttendancesTable(LocalDate.now(), "Nguyen Hoang Huy",
		// "08:01:00 AM", "04:01:00 PM", "8 hr 0 mins", "In time/On
		// time").toRowTable());

//		table1.addRow(new Object[] { "05-2024", "Nguyen Hoang Ngọc Huy", "IT", "Employee", "12.000.000", "28",
//				"1.000.000", "12.000.000", "450.000", "50.000", "20.000", "11.550.000" });

		
		try {
			list = Application.payrollsDao.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DecimalFormat df = new DecimalFormat("#,###.#");
		for (Payroll p : list) {
			table1.addRow(new Object[] {p.getMonth()+"-"+p.getYear(),p.getEmployee().getFullName(),p.getEmployee().getDepartment().getName(),p.getEmployee().getRole(),
					df.format(p.getEmployee().getAggrementInfo().getBasicSalary()),p.getWorkDays(),df.format(p.getEmployee().getAggrementInfo().getAllowance()),
					df.format(p.getSalaryTotal()),df.format(p.getBHXH()),df.format(p.getBHYT()),df.format(p.getBHTN()),
					df.format(p.getRealSalary())});
//			table1.addRow(new Object[] { p.getMonth() + "-" + p.getYear(), 
//					df.format(p.getEmployee().getAggrementInfo().getBasicSalary()), p.getWorkDays(),
//					df.format(p.getEmployee().getAggrementInfo().getAllowance()), df.format(p.getSalaryTotal()),
//					df.format(p.getBHXH()), df.format(p.getBHYT()), df.format(p.getBHTN()), df.format(p.getBHXH()),
//					df.format(p.getSalaryTotal()) });
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

//	private boolean showMessage(String message) {
//		Message obj = new Message(Main.getFrames()[0], true);
//		obj.showMessage(message);
//		return obj.isOk();
//	}

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

		card1.setColorGradient(new java.awt.Color(211, 28, 215));

		jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(4, 72, 210));
		jLabel1.setText("My Salary");

		card2.setBackground(new java.awt.Color(10, 30, 214));
		card2.setColorGradient(new java.awt.Color(72, 111, 252));

		card3.setBackground(new java.awt.Color(194, 85, 1));
		card3.setColorGradient(new java.awt.Color(255, 212, 99));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(76, 76, 76));
		jLabel5.setText("MY SALARY");
		jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

		table1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Date", "Name", "Department", "Position", "Basic Salary", "Working Days", "Allowance",
				"Total Salary", "BHXH", "BHYT", "BHTN", "Salary Received" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false,
					false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		

		

		jScrollPane1.setViewportView(table1);
		if (table1.getColumnModel().getColumnCount() > 0) {
			table1.getColumnModel().getColumn(0).setMaxWidth(60);
			table1.getColumnModel().getColumn(2).setPreferredWidth(60);
			table1.getColumnModel().getColumn(3).setMaxWidth(80);
			table1.getColumnModel().getColumn(5).setPreferredWidth(60);
			table1.getColumnModel().getColumn(8).setMaxWidth(60);
			table1.getColumnModel().getColumn(9).setMaxWidth(60);
			table1.getColumnModel().getColumn(10).setMaxWidth(60);
		}

		dateChooserStartDate = new DateChooser();

		txtStartDate = new JTextField();
		dateChooserStartDate.setTextRefernce(txtStartDate);
		txtStartDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dateChooserStartDate.showPopup();
			}
		});
		txtStartDate.setToolTipText("input date");
		txtStartDate.setEditable(false);
		txtStartDate.setColumns(10);

		dateChooserEndDate = new DateChooser();

		btnFilter = new JButton("Filter");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int year = dateChooserStartDate.getSelectedDate().getYear();
				int month = dateChooserStartDate.getSelectedDate().getMonth();

				String sId = txtIdEm.getText().trim();
				if (sId.equals("")) reloadData();
				else
				if (!sId.matches("^-?\\d+(\\.\\d+)?$"))
					Application.showMessageWarning("id is interger");
				else {
					int id = Integer.parseInt(sId);

					try {
						list = (List<Payroll>) Application.payrollsDao.findById(id, month, year);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					if (list != null) {
						DefaultTableModel dm = (DefaultTableModel) table1.getModel();
						dm.getDataVector().removeAllElements();
						table1.revalidate();
						DecimalFormat df = new DecimalFormat("#,###.#");
						for (Payroll p : list) {
							table1.addRow(new Object[] {p.getMonth()+"-"+p.getYear(),p.getEmployee().getFullName(),p.getEmployee().getDepartment().getName(),p.getEmployee().getRole(),
									df.format(p.getEmployee().getAggrementInfo().getBasicSalary()),p.getWorkDays(),df.format(p.getEmployee().getAggrementInfo().getAllowance()),
									df.format(p.getSalaryTotal()),df.format(p.getBHXH()),df.format(p.getBHYT()),df.format(p.getBHTN()),
									df.format(p.getRealSalary())});
//							table1.addRow(new Object[] { p.getMonth() + "-" + p.getYear(), 
//									df.format(p.getEmployee().getAggrementInfo().getBasicSalary()), p.getWorkDays(),
//									df.format(p.getEmployee().getAggrementInfo().getAllowance()), df.format(p.getSalaryTotal()),
//									df.format(p.getBHXH()), df.format(p.getBHYT()), df.format(p.getBHTN()), df.format(p.getBHXH()),
//									df.format(p.getSalaryTotal()) });
						}
					} else Application.showMessageWarning("Not found");
				}
				
			}
		});
		btnFilter.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnFilter.setForeground(new Color(255, 255, 255));
		btnFilter.setBackground(new Color(30, 144, 255));
		
		btnReset = new JButton("Reset Table");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloadData();
			}
		});
		
		txtIdEm = new JTextField();
		txtIdEm.setToolTipText("input id employee");
		txtIdEm.setColumns(10);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addGap(10)
							.addComponent(txtStartDate, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIdEm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnFilter)
							.addGap(6)
							.addComponent(btnReset))
						.addComponent(jLabel5))
					.addContainerGap(502, Short.MAX_VALUE))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel5)
					.addGap(10)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtStartDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtIdEm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFilter)
						.addComponent(btnReset))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
					.addContainerGap())
		);
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(jLabel1).addGap(0, 0, Short.MAX_VALUE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(jPanel1,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap().addComponent(jLabel1)

				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap()));
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

	private JTextField txtStartDate;
	private JButton btnFilter;

	private DateChooser dateChooserStartDate;
	private DateChooser dateChooserEndDate;
	private JButton btnReset;
	private JTextField txtIdEm;

	//private TableActionEvent event;
}
