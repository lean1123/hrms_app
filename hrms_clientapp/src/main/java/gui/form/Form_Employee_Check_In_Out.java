package gui.form;

import static org.mockito.ArgumentMatchers.anyIterable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

import entity.Attendance;
import entity.Employee;
import entity.Payroll;
import gui.main.Application;
import gui.swing.ImageAvatar;
import gui.swing.panelShadow.PanelShadow;
import gui.swing.panelShadow.ShadowType;

public class Form_Employee_Check_In_Out extends JPanel {
	private boolean isCheckIn;

	public Form_Employee_Check_In_Out() {

		initComponents();

		setOpaque(false);

	}

	private void initComponents() {
		
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setToolTipText("");
		isCheckIn=true;

		jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(4, 72, 210));
		jLabel1.setText("Clock In/Out");
		
		panel_check = new JPanel();
		panel_check.setBackground(new Color(240, 255, 255));
		
		panelShadow = new PanelShadow();
		panelShadow.setShadowSize(20);
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		dayFormat = new SimpleDateFormat("EEEE");
		dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		
		panelShadow.setBackground(new Color(30, 144, 255));
		panelShadow.setShadowColor(new Color(0, 255, 255));
		panelShadow.setShadowType(ShadowType.CENTER);

		lblTime = new JLabel("");
		lblTime.setText(timeFormat.format(Calendar.getInstance().getTime()));
		lblTime.setFont(new Font("SansSerif", Font.PLAIN, 56));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);

		lblDay = new JLabel("");
		lblDay.setText(dayFormat.format(Calendar.getInstance().getTime()));
		lblDay.setForeground(Color.WHITE);
		lblDay.setFont(new Font("SansSerif", Font.PLAIN, 46));
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);

		lblDate = new JLabel("");
		lblDate.setText(dateFormat.format(Calendar.getInstance().getTime()));
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("SansSerif", Font.PLAIN, 36));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		
		setTime();
		
		javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow);
		panelShadow1Layout.setHorizontalGroup(
				panelShadow1Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						panelShadow1Layout.createSequentialGroup().addContainerGap()
								.addGroup(panelShadow1Layout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblDate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 357,
												Short.MAX_VALUE)
										.addComponent(lblTime, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
										.addComponent(lblDay, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
								.addContainerGap()));
		panelShadow1Layout.setVerticalGroup(panelShadow1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(panelShadow1Layout.createSequentialGroup().addGap(89)
						.addComponent(lblDay, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblTime, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(105, Short.MAX_VALUE)));
		panelShadow.setLayout(panelShadow1Layout);
		
		JPanel panel_id = new JPanel();
		panel_id.setBackground(new Color(255, 255, 255));
		
		JPanel panel_btn = new JPanel();
		panel_btn.setBackground(new Color(255, 255, 255));
		
		javax.swing.GroupLayout gl_panel_check = new javax.swing.GroupLayout(panel_check);
		gl_panel_check.setHorizontalGroup(
			gl_panel_check.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_check.createSequentialGroup()
					.addGap(380)
					.addGroup(gl_panel_check.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_btn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_id, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelShadow, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(400, Short.MAX_VALUE))
		);
		gl_panel_check.setVerticalGroup(
			gl_panel_check.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_check.createSequentialGroup()
					.addGap(29)
					.addComponent(panel_btn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(panelShadow, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(panel_id, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		btnTimeIn = new JButton("Time In");
		btnTimeIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelShadow.setBackground(new Color(30, 144, 255));
				panelShadow.setShadowColor(new Color(0, 255, 255));
				btnTimeIn.setBackground(new Color(0, 191, 255));
				btnTimeIn.setForeground(Color.white);
				btnTimeOut.setBackground(Color.white);
				btnTimeOut.setForeground(new Color(128, 128, 128));
				isCheckIn=true;
			}
		});
		btnTimeIn.setForeground(new Color(255, 255, 255));
		btnTimeIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTimeIn.setBackground(new Color(0, 191, 255));
		
		btnTimeOut = new JButton("Time Out");
		btnTimeOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelShadow.setBackground(new Color(199, 0, 57));
				panelShadow.setShadowColor(new Color(255, 105, 105));
				btnTimeOut.setBackground(new Color(199, 0, 57));
				btnTimeOut.setForeground(Color.white);
				btnTimeIn.setBackground(Color.white);
				btnTimeIn.setForeground(new Color(128, 128, 128));
				isCheckIn=false;
			}
		});
		btnTimeOut.setForeground(new Color(128, 128, 128));
		btnTimeOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTimeOut.setBackground(new Color(255, 255, 255));
		GroupLayout gl_panel_btn = new GroupLayout(panel_btn);
		gl_panel_btn.setHorizontalGroup(
			gl_panel_btn.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_btn.createSequentialGroup()
					.addComponent(btnTimeIn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTimeOut, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
		);
		gl_panel_btn.setVerticalGroup(
			gl_panel_btn.createParallelGroup(Alignment.LEADING)
				.addComponent(btnTimeIn, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
				.addComponent(btnTimeOut, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
		);
		panel_btn.setLayout(gl_panel_btn);
		
		txtEnterYourId = new JTextField();
		txtEnterYourId.setToolTipText("Enter your ID");
		txtEnterYourId.setForeground(new Color(105, 105, 105));
		txtEnterYourId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEnterYourId.setColumns(10);
		
		btnEnter = new JButton("Confirm");
		btnEnter.setForeground(new Color(255, 255, 255));
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEnter.setBackground(new Color(0, 250, 154));
		btnEnter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (isCheckIn) {
					//check in
					try {
						int id = Application.employeeDao.findById(Application.idUserLogin).getId();
						if (txtEnterYourId.getText().trim().equals(id+"")) {
							
							Attendance attendance = Application.attendanceDao.timeInAttendancing(id, LocalDate.now(), LocalTime.now());
							
							if (attendance==null) Application.showMessageError("check in faild");
							else Application.showMessageSucces("Letgo!!!");
						}else {
							Application.showMessageError("ID not correct");
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					//check out
					try {
						int id = Application.employeeDao.findById(Application.idUserLogin).getId();
						if (txtEnterYourId.getText().trim().equals(id+"")) {
							
							Attendance attendance = Application.attendanceDao.timeOutAttendancing(id, LocalDate.now(), LocalTime.now());
							
							if (attendance==null) Application.showMessageError("check out faild");
							else {
								Payroll payroll = Application.payrollsDao.salaryCalculating(id, LocalDate.now().getMonthValue(), LocalDate.now().getYear());
								Form_General_MySalary.reloadData();
								Application.showMessageSucces("Thanks for day!!");
							}
						}else {
							Application.showMessageError("ID not correct");
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		
		GroupLayout gl_panel_id = new GroupLayout(panel_id);
		gl_panel_id.setHorizontalGroup(
			gl_panel_id.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_id.createSequentialGroup()
					.addComponent(txtEnterYourId, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEnter, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
		);
		gl_panel_id.setVerticalGroup(
			gl_panel_id.createParallelGroup(Alignment.LEADING)
				.addComponent(txtEnterYourId, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
				.addComponent(btnEnter, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
		);
		panel_id.setLayout(gl_panel_id);
		panel_check.setLayout(gl_panel_check);
		
		
		
		

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_check, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
						.addComponent(jLabel1, Alignment.LEADING))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel1)
					.addGap(18)
					.addComponent(panel_check, GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
					.addContainerGap())
		);
		//pic.setBorderSize(100);
		
		
		this.setLayout(layout);
		
		
		
		
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */

	public void setTime() {
		Timer timer = new Timer(1000, e -> {
            String time = timeFormat.format(Calendar.getInstance().getTime());
            lblTime.setText(time);

            String day = dayFormat.format(Calendar.getInstance().getTime());
            lblDay.setText(day);

            String date = dateFormat.format(Calendar.getInstance().getTime());
            lblDate.setText(date);
        });
        timer.start();
	}
	// Variables declaration - do not modify//GEN-BEGIN:variables

//    private gui.component.Card card4;
	private javax.swing.JLabel jLabel1;
	
	private PanelShadow panelShadow;
	
	private javax.swing.JPanel jPanel1;
	private JPanel panel_check;
	private JLabel lblTime;
	private JLabel lblDay;
	private JLabel lblDate;
	private Calendar calendar;
	private SimpleDateFormat timeFormat;
	private SimpleDateFormat dayFormat;
	private SimpleDateFormat dateFormat;
	private JTextField txtEnterYourId;
	private JButton btnTimeIn;
	private JButton btnTimeOut;
	private JButton btnEnter;
}
