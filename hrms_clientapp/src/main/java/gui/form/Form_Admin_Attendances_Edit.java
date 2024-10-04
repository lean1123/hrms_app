package gui.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

import entity.Attendance;
import gui.main.Application;
import gui.swing.timePicker.TimePicker;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Form_Admin_Attendances_Edit extends JPanel{
	public Form_Admin_Attendances_Edit(int emId, LocalDate atDate) {

		initComponents(emId, atDate);
try {
	uploadDataToForm(emId, atDate);
} catch (RemoteException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		setOpaque(false);

	}
	
	
	
	private void uploadDataToForm(int emId, LocalDate atDate) throws RemoteException {
		Attendance attendance =  Application.attendanceDao.findById(emId, 1, atDate);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		txtFullName.setText(attendance.getEmployee().getFullName());
		txtDate.setText(dateTimeFormatter.format(attendance.getAttendancedDate()));
		timePickerIn.setSelectedTime(attendance.getTimeIn());
		timePickerOut.setSelectedTime(attendance.getTimeOut());
		txtReason.setText(attendance.getReason());
	}
	
	private boolean updateAttendance(int emId, LocalDate atDate) throws RemoteException {
		Attendance attendance =  Application.attendanceDao.findById(emId, 1, atDate);
		LocalTime timeIn = LocalTime.parse(txtTimeIn.getText());
		LocalTime timeOut = LocalTime.parse(txtTimeOut.getText());
		String reason = txtReason.getText();
		attendance.setTimeIn(timeIn);
		attendance.setTimeOut(timeOut);
		attendance.setReason(reason);
		System.out.println(timeIn.toString());
		attendance = Application.attendanceDao.update(attendance);
		if (attendance == null) return false;
		return true;
	}

	private void initComponents(int emId, LocalDate atDate) {

		jLabel1 = new javax.swing.JLabel();
		lblReturn = new JLabel("Return");
		lblReturn.setIcon(new ImageIcon(Form_Leader_MyProfile.class.getResource("/gui/icon/icons8-return-16.png")));
		lblReturn.setForeground(new Color(30, 144, 255));
		lblReturn.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Application.main.showForm(Application.form_Admin_Attendances);
			}
		});
		

		jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(4, 72, 210));
		jLabel1.setText("Attendances / Edit Attendances");
		
		pnLeft = new JPanel();
		pnLeft.setBackground(Color.WHITE);
		
		JButton btnCancle = new JButton("Cancel");
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if (updateAttendance(emId, atDate)) {
						Application.main.showForm(Application.form_Admin_Attendances);
						Form_Admin_Attendances.reloadTableData();
						Application.showMessageSucces("Update attandances succes");
					}
					else Application.showMessageError("Update attandances failed!");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBackground(new Color(50, 205, 50));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnLeft, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 767, Short.MAX_VALUE)
							.addComponent(lblReturn))
						.addGroup(layout.createSequentialGroup()
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancle)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(lblReturn))
					.addGap(18)
					.addComponent(pnLeft, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancle)
						.addComponent(btnSave))
					.addContainerGap(151, Short.MAX_VALUE))
		);
		
		lblNewLabel_1 = new JLabel("Employee");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
		
		txtFullName = new JTextField();
		txtFullName.setEditable(false);
		lblNewLabel_1.setLabelFor(txtFullName);
		txtFullName.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 9));
		
		JLabel lblNewLabel_2_1 = new JLabel("Time In");
		lblNewLabel_2_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
		
		lblNewLabel_2_1_7 = new JLabel("Time Out");
		lblNewLabel_2_1_7.setFont(new Font("SansSerif", Font.PLAIN, 9));
		
		txtTimeOut = new JTextField();
		txtTimeOut.setEditable(false);
		txtTimeOut.setBackground(new Color(255, 255, 255));
		txtTimeOut.setColumns(10);
		
		lblNewLabel_2_1_8 = new JLabel("Reason");
		lblNewLabel_2_1_8.setFont(new Font("SansSerif", Font.PLAIN, 9));
		
		txtReason = new JTextArea();
		txtReason.setBackground(new Color(255, 255, 255));
		
		timePickerIn = new TimePicker();
		timePickerIn.setForeground(new java.awt.Color(138, 48, 191));
		
		timePickerOut = new TimePicker();
		timePickerOut.setForeground(new java.awt.Color(138, 48, 191));
		timePickerOut.setDisplayText(txtTimeOut);
		
		txtTimeIn = new JTextField();
		txtTimeIn.setEditable(false);
		txtTimeIn.setColumns(10);
		txtTimeIn.setBackground(new Color(255, 255, 255));
		timePickerIn.setDisplayText(txtTimeIn);
		txtTimeIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startTime1ActionPerformed(e);
			}
		});
		
		txtTimeOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				offTime1ActionPerformed(e);
			}
		});
		
		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		//pic.setBorderSize(100);
		
		GroupLayout gl_pnLeft = new GroupLayout(pnLeft);
		gl_pnLeft.setHorizontalGroup(
			gl_pnLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnLeft.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnLeft.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtReason, GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_pnLeft.createSequentialGroup()
							.addGroup(gl_pnLeft.createParallelGroup(Alignment.LEADING)
								.addComponent(txtFullName, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_pnLeft.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnLeft.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
									.addGap(345))
								.addGroup(gl_pnLeft.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDate, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))))
						.addComponent(lblNewLabel_2_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_7, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimeOut, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2_1_8, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimeIn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnLeft.setVerticalGroup(
			gl_pnLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLeft.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_pnLeft.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnLeft.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtDate)
						.addComponent(txtFullName, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTimeIn, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNewLabel_2_1_7, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTimeOut, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2_1_8, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtReason, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnLeft.setLayout(gl_pnLeft);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private void startTime1ActionPerformed(MouseEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        timePickerIn.showPopup(this, (getWidth() - timePickerIn.getPreferredSize().width) / 2, (getHeight() - timePickerIn.getPreferredSize().height) / 2);
    }
	
	private void offTime1ActionPerformed(MouseEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        timePickerOut.showPopup(this, (getWidth() - timePickerOut.getPreferredSize().width) / 2, (getHeight() - timePickerOut.getPreferredSize().height) / 2);
    }


	private javax.swing.JLabel jLabel1;
	private JPanel pnLeft;
	
	private JLabel lblReturn;
	private JLabel lblNewLabel_1;
	private JTextField txtFullName;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1_7;
	private JTextField txtTimeOut;
	private JLabel lblNewLabel_2_1_8;
	private JTextField txtTimeIn;
	private JTextField txtDate;
	private JTextArea txtReason;
	
	private TimePicker timePickerIn;
	private TimePicker timePickerOut;
}
