package gui.form;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import entity.Attendance;
import entity.Shift;
import gui.main.Application;
import gui.main.Main;
import gui.swing.dateChooser.DateChooser;
import gui.swing.timePicker.TimePicker;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.time.LocalTime;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form_Admin_Schedules_Edit extends JPanel{
	public Form_Admin_Schedules_Edit(int id) {

		initComponents(id);
		try {
			uploadDataToForm(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setOpaque(false);

	}

	private void initComponents(int id) {

		jLabel1 = new javax.swing.JLabel();
		lblReturn = new JLabel("Return");
		lblReturn.setIcon(new ImageIcon(Form_Leader_MyProfile.class.getResource("/gui/icon/icons8-return-16.png")));
		lblReturn.setForeground(new Color(30, 144, 255));
		lblReturn.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Application.main.showForm(Application.form_Admin_Schedules);
			}
		});
		

		jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(4, 72, 210));
		jLabel1.setText("Schedules / Edit Schedules");
		
		pnLeft = new JPanel();
		pnLeft.setBackground(Color.WHITE);
		
		JButton btnNewButton = new JButton("Cancel");
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (updateSchedule()) {
						Application.main.showForm(Application.form_Admin_Schedules);
						Form_Admin_Schedules.reloatData();
						Application.showMessageSucces("Update shift succes!");
					}
					else Application.showMessageError("Upadte shift faild");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBackground(new Color(50, 205, 50));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addGap(12))
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(pnLeft, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
									.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 504, Short.MAX_VALUE)
									.addComponent(lblReturn)))
							.addContainerGap())))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(lblReturn))
					.addGap(18)
					.addComponent(pnLeft, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnNewButton))
					.addContainerGap(202, Short.MAX_VALUE))
		);
		
		lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setEditable(false);
		lblNewLabel_1.setLabelFor(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Start Time");
		lblNewLabel_2_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
		
		dateChooserFrom = new DateChooser();
		
		timePickerStart = new TimePicker();
		timePickerStart.setForeground(new java.awt.Color(138, 48, 191));
        
		timePickerOff = new TimePicker();
		timePickerOff.setForeground(new java.awt.Color(138, 48, 191));
		
		timePickerStartAttendance = new TimePicker();
		timePickerStartAttendance.setForeground(new java.awt.Color(138, 48, 191));
        
		timePickerOffAttendance = new TimePicker();
		timePickerOffAttendance.setForeground(new java.awt.Color(138, 48, 191));
		
		txtStartTime = new JTextField();
		txtStartTime.setEditable(false);
		timePickerStart.setDisplayText(txtStartTime);
		txtStartTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startTime1ActionPerformed(e);
			}
		});
		txtStartTime.setColumns(10);
		txtStartTime.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Off Time");
		lblNewLabel_2_1_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
		
		txtOffTime = new JTextField();
		txtOffTime.setEditable(false);
		timePickerOff.setDisplayText(txtOffTime);
		txtOffTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				offTime1ActionPerformed(e);
			}
		});
		txtOffTime.setColumns(10);
		
		
		dateChooserTo = new DateChooser();
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Start Attendance Time");
		lblNewLabel_2_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
		
		txtStartAttendance = new JTextField();
		txtStartAttendance.setEditable(false);
		txtStartAttendance.setColumns(10);
		timePickerStartAttendance.setDisplayText(txtStartAttendance);
		txtStartAttendance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				attendanceStartTime1ActionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Off Attendance Time");
		lblNewLabel_2_1_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 9));
		
		txtOffAttendance = new JTextField();
		txtOffAttendance.setEditable(false);
		txtOffAttendance.setColumns(10);
		timePickerOffAttendance.setDisplayText(txtOffAttendance);
		txtOffAttendance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//attoffTime1ActionPerformed(e);
				attendanceOffTime1ActionPerformed(e);
			}
		});
		
		//pic.setBorderSize(100);
		
		GroupLayout gl_pnLeft = new GroupLayout(pnLeft);
		gl_pnLeft.setHorizontalGroup(
			gl_pnLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLeft.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnLeft.createParallelGroup(Alignment.LEADING)
						.addComponent(txtID, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtOffTime, 724, 724, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtStartTime, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
						.addComponent(txtStartAttendance, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
						.addComponent(txtOffAttendance, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnLeft.setVerticalGroup(
			gl_pnLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLeft.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtStartTime, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtOffTime, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtStartAttendance, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtOffAttendance, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		pnLeft.setLayout(gl_pnLeft);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	
	private void startTime1ActionPerformed(MouseEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        timePickerStart.showPopup(this, (getWidth() - timePickerStart.getPreferredSize().width) / 2, (getHeight() - timePickerStart.getPreferredSize().height) / 2);
    }
	
	private void offTime1ActionPerformed(MouseEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        timePickerOff.showPopup(this, (getWidth() - timePickerStart.getPreferredSize().width) / 2, (getHeight() - timePickerStart.getPreferredSize().height) / 2);
    }
	private void attendanceOffTime1ActionPerformed(MouseEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        timePickerOffAttendance.showPopup(this, (getWidth() - timePickerOffAttendance.getPreferredSize().width) / 2, (getHeight() - timePickerOffAttendance.getPreferredSize().height) / 2);
    }
	private void attendanceStartTime1ActionPerformed(MouseEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        timePickerStartAttendance.showPopup(this, (getWidth() - timePickerStartAttendance.getPreferredSize().width) / 2, (getHeight() - timePickerStartAttendance.getPreferredSize().height) / 2);
    }
	
	private void uploadDataToForm(int id) throws RemoteException {
		Shift shift = Application.shiftDao.findById(id);
		txtID.setText(shift.getId()+"");
		timePickerOff.setSelectedTime(shift.getEndTime());
		timePickerOffAttendance.setSelectedTime(shift.getEndAttendanceTime());
		timePickerStart.setSelectedTime(shift.getStartTime());
		timePickerStartAttendance.setSelectedTime(shift.getStartAttendanceTime());
	}
	
	private boolean updateSchedule() throws RemoteException {
		Shift shift = Application.shiftDao.findById(1);
		LocalTime timeIn = LocalTime.parse(txtStartTime.getText());
		LocalTime timeOut = LocalTime.parse(txtOffTime.getText());
		LocalTime timeInAtt = LocalTime.parse(txtStartAttendance.getText());
		LocalTime timeOutAtt = LocalTime.parse(txtOffAttendance.getText());
		shift.setStartTime(timeIn);
		shift.setEndTime(timeOut);
		shift.setStartAttendanceTime(timeInAtt);
		shift.setEndAttendanceTime(timeOutAtt);
		shift = Application.shiftDao.update(shift);
		if (shift==null) {
			return false;
		}
		return true;
	}
	
	private javax.swing.JLabel jLabel1;
	private JPanel pnLeft;
	
	private JLabel lblReturn;
	private JLabel lblNewLabel_1;
	private JTextField txtID;
	private JTextField txtStartTime;
	private JTextField txtOffTime;
	
	private TimePicker timePickerStart;
	private TimePicker timePickerOff;
	private TimePicker timePickerStartAttendance;
	private TimePicker timePickerOffAttendance;
	
	private DateChooser dateChooserFrom;
	private DateChooser dateChooserTo;
	private JTextField txtStartAttendance;
	private JTextField txtOffAttendance;
}
