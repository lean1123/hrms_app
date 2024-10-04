package gui.form;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import entity.Employee;
import entity.RestAllowed;
import gui.main.Application;
import gui.swing.ImageAvatar;
import gui.swing.dateChooser.DateChooser;
import jnafilechooser.api.JnaFileChooser;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Form_Admin_LeaveOfAbsence_Edit extends JPanel {
	public Form_Admin_LeaveOfAbsence_Edit(int idRest) {

		initComponents(idRest);
		try {
			uploadDateToForm(idRest);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setOpaque(false);

	}

	private void initComponents(int idRest) {

		jLabel1 = new javax.swing.JLabel();
		lblReturn = new JLabel("Return");
		lblReturn.setIcon(new ImageIcon(Form_Leader_MyProfile.class.getResource("/gui/icon/icons8-return-16.png")));
		lblReturn.setForeground(new Color(30, 144, 255));
		lblReturn.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Application.main.showForm(Application.form_Admin_LeavesOfAbsence);
			}
		});

		jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(4, 72, 210));
		jLabel1.setText("My Department/Leave/Edit Leave");

		pnLeft = new JPanel();
		pnLeft.setBackground(Color.WHITE);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Application.main.showForm(Application.form_Admin_LeavesOfAbsence);
			}
		});

		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(50, 205, 50));
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if (editLeaveOfAbsence(idRest)) {
						Application.main.showForm(Application.form_Admin_LeavesOfAbsence);
						
						Form_Admin_LeavesOfAbsence.reloadTable();
						
						if (Form_Admin_LeavesOfAbsence.getTable1().isEditing()) {
							Form_Admin_LeavesOfAbsence.getTable1().getCellEditor().stopCellEditing();
						}
						Application.showMessageSucces("Edit leave succes!");
					} else
						Application.showMessageError("Edit leave failed!");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnLeft, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
								.addComponent(lblReturn))
						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnCancel)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel1).addComponent(lblReturn))
				.addGap(18).addComponent(pnLeft, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnCancel).addComponent(btnSave))
				.addGap(215)));

		lblNewLabel_1 = new JLabel("Full name");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 9));

		txtFullName = new JTextField();
		txtFullName.setEditable(false);
//		try {
//			txtFullName.setText(Application.employeeDao.findById(Application.idUserLogin).getFullName());
//		} catch (RemoteException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		lblNewLabel_1.setLabelFor(txtFullName);
		txtFullName.setColumns(10);

		lblNewLabel_2 = new JLabel("Reason");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 9));

		lblNewLabel_2_1_3 = new JLabel("Leave To");
		lblNewLabel_2_1_3.setFont(new Font("SansSerif", Font.PLAIN, 9));

		txtLeaveTo = new JTextField();
		txtLeaveTo.setColumns(10);

		dateChooserTo = new DateChooser();
		dateChooserTo.setTextRefernce(txtLeaveTo);

		lblNewLabel_2_1_4 = new JLabel("Status");
		lblNewLabel_2_1_4.setFont(new Font("SansSerif", Font.PLAIN, 9));

		lblNewLabel_2_1_6 = new JLabel("Leave From");
		lblNewLabel_2_1_6.setFont(new Font("SansSerif", Font.PLAIN, 9));

		txtLeaveFrom = new JTextField();
		txtLeaveFrom.setColumns(10);

		dateChooserFrom = new DateChooser();
		dateChooserFrom.setTextRefernce(txtLeaveFrom);

		txtReason = new JTextField();
		txtReason.setText((String) null);
		txtReason.setColumns(10);
		// pic.setBorderSize(100);

		cmbStatus = new JComboBox();
		cmbStatus.setModel(new DefaultComboBoxModel<>(new String[] { "Approved", "Waiting" }));

		GroupLayout gl_pnLeft = new GroupLayout(pnLeft);
		gl_pnLeft.setHorizontalGroup(gl_pnLeft.createParallelGroup(Alignment.TRAILING).addGroup(gl_pnLeft
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_pnLeft.createParallelGroup(Alignment.TRAILING)
						.addComponent(cmbStatus, Alignment.LEADING, 0, 410, Short.MAX_VALUE)
						.addComponent(txtFullName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 162,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 162,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_6, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 162,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLeaveFrom, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2_1_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 162,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLeaveTo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2_1_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 162,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtReason, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
				.addContainerGap()));
		gl_pnLeft.setVerticalGroup(gl_pnLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLeft.createSequentialGroup().addGap(26).addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtFullName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtReason, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE).addGap(10)
						.addComponent(lblNewLabel_2_1_6, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtLeaveFrom, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNewLabel_2_1_3, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtLeaveTo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNewLabel_2_1_4, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cmbStatus, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(39, Short.MAX_VALUE)));
		pnLeft.setLayout(gl_pnLeft);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

//	private void uploadDataToForm(int id) throws RemoteException {
//		Employee employee = Application.employeeDao.findById(id);
//		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		txtFullName.setText(employee.getFullName());
//		txtLeaveFrom.setText(dateTimeFormatter.format(employee.getDob()));
//		dateChooserFrom.setSelectedDate(Date.from(employee.getDob().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//		txtLeaveTo.setText(employee.getContact().getEmail());
//		txtReturnDate.setText(employee.getContact().getPhone());
//		DecimalFormat decimalFormat = new DecimalFormat("###");
//	}

	private void uploadDateToForm(int idRest) throws RemoteException {
		RestAllowed restAllowed = Application.restAllowedDao.findByID(idRest);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		txtFullName.setText(restAllowed.getEmployee().getFullName());
		txtLeaveFrom.setText(dateTimeFormatter.format(restAllowed.getFromDate()));
		dateChooserFrom
				.setSelectedDate(Date.from(restAllowed.getFromDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		txtLeaveTo.setText(dateTimeFormatter.format(restAllowed.getToDate()));
		dateChooserTo
				.setSelectedDate(Date.from(restAllowed.getToDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		if (restAllowed.isAllowedStatus())
			cmbStatus.setSelectedIndex(0);
		else
			cmbStatus.setSelectedIndex(1);
		txtReason.setText(restAllowed.getReason());
	}

	private boolean editLeaveOfAbsence(int idRest) throws RemoteException {
		RestAllowed restAllowed = Application.restAllowedDao.findByID(idRest);
		Employee employee = restAllowed.getEmployee();
		String reason = txtReason.getText();
		String stringLeaveFrom = txtLeaveFrom.getText();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate leaveFrom = LocalDate.parse(stringLeaveFrom, formatter);
		String stringLeaveTo = txtLeaveTo.getText();
		LocalDate leaveTo = LocalDate.parse(stringLeaveTo, formatter);
		LocalDate returnDate = leaveTo.plusDays(1);
		boolean isApproved = cmbStatus.getSelectedIndex() == 0 ? true : false;
		restAllowed.setEmployee(employee);
		restAllowed.setReason(reason);
		restAllowed.setFromDate(leaveFrom);
		restAllowed.setToDate(leaveTo);
		restAllowed.setReturnDate(returnDate);
		restAllowed.setAllowedStatus(isApproved);

		restAllowed = Application.restAllowedDao.update(restAllowed);
		if (restAllowed == null)
			return false;
		return true;
	}

	private javax.swing.JLabel jLabel1;
	private JPanel pnLeft;

	private JLabel lblReturn;
	private JLabel lblNewLabel_1;
	private JTextField txtFullName;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1_3;
	private JTextField txtLeaveTo;
	private JLabel lblNewLabel_2_1_4;
	private JLabel lblNewLabel_2_1_6;
	private JTextField txtLeaveFrom;

	private DateChooser dateChooserFrom;
	private DateChooser dateChooserTo;
	private JTextField txtReason;

	private JComboBox cmbStatus;
}
