package gui.form;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import gui.main.Application;
import gui.swing.ImageAvatar;
import gui.swing.cellAction.TableActionEvent;
import javax.swing.border.MatteBorder;

import entity.Employee;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Form_Leader_Employee_ViewProfile extends JPanel {
	public Form_Leader_Employee_ViewProfile(int id) {

		initComponents(id);
try {
	uploadDataToForm(id);
} catch (RemoteException | MalformedURLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		setOpaque(false);

	}

	private void initComponents(int id) {

		card1 = new gui.component.Card();
		lbPath = new javax.swing.JLabel();
		lblReturn = new JLabel("Return");
		lblReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Application.main.showForm(Application.form_Leader_Employees);

			}
		});
		lblReturn.setIcon(new ImageIcon(Form_Leader_Employee_ViewProfile.class.getResource("/gui/icon/icons8-return-16.png")));
		lblReturn.setForeground(new Color(30, 144, 255));
		lblReturn.setFont(new Font("SansSerif", Font.BOLD, 12));
		card2 = new gui.component.Card();
		card3 = new gui.component.Card();
//        card4 = new gui.component.Card();
		pn_info = new javax.swing.JPanel();

		jLabel5 = new javax.swing.JLabel();

		card1.setColorGradient(new java.awt.Color(211, 28, 215));

		lbPath.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
		lbPath.setForeground(new java.awt.Color(4, 72, 210));
		lbPath.setText("My Department/Employees/View Profile");

		card2.setBackground(new java.awt.Color(10, 30, 214));
		card2.setColorGradient(new java.awt.Color(72, 111, 252));

		card3.setBackground(new java.awt.Color(194, 85, 1));
		card3.setColorGradient(new java.awt.Color(255, 212, 99));

		pn_info.setBackground(new java.awt.Color(255, 255, 255));

		jLabel5.setFont(new Font("SansSerif", Font.BOLD, 13)); // NOI18N
		jLabel5.setForeground(Color.DARK_GRAY);
		jLabel5.setText("  Personal Information");
		jLabel5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));

		lblAge1 = new JLabel("Age");
		lblAge1.setForeground(Color.GRAY);
		lblAge1.setFont(new Font("SansSerif", Font.BOLD, 12));

		lblAge = new JLabel("28");
		lblAge.setForeground(Color.DARK_GRAY);
		lblAge.setFont(new Font("SansSerif", Font.BOLD, 12));

		lblGender1 = new JLabel("Gender");
		lblGender1.setForeground(Color.GRAY);
		lblGender1.setFont(new Font("SansSerif", Font.BOLD, 12));

		lblGender = new JLabel("MALE");
		lblGender.setForeground(Color.DARK_GRAY);
		lblGender.setFont(new Font("SansSerif", Font.BOLD, 12));

		lblDayOfBirth1 = new JLabel("Day of Birth");
		lblDayOfBirth1.setForeground(Color.GRAY);
		lblDayOfBirth1.setFont(new Font("SansSerif", Font.BOLD, 12));

		lblDayOfBirth = new JLabel("January 07, 1991");
		lblDayOfBirth.setForeground(Color.DARK_GRAY);
		lblDayOfBirth.setFont(new Font("SansSerif", Font.BOLD, 12));

		lblHomeAddress1 = new JLabel("Home Address");
		lblHomeAddress1.setForeground(Color.GRAY);
		lblHomeAddress1.setFont(new Font("SansSerif", Font.BOLD, 12));

		lblHomeAddress = new JLabel("BRIGHTON, LONDON, UNITED KINGDOM");
		lblHomeAddress.setForeground(Color.DARK_GRAY);
		lblHomeAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		JLabel lblHomeAddress_2 = new JLabel("Designation");
		lblHomeAddress_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		lblHomeAddress_2.setForeground(Color.DARK_GRAY);
		lblHomeAddress_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblHomeAddress_3 = new JLabel("Department");
		lblHomeAddress_3.setForeground(Color.GRAY);
		lblHomeAddress_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblDepartment = new JLabel("EXECUTIVE");
		lblDepartment.setForeground(Color.DARK_GRAY);
		lblDepartment.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblHomeAddress_4 = new JLabel("Position");
		lblHomeAddress_4.setForeground(Color.GRAY);
		lblHomeAddress_4.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblPosition = new JLabel("CHIEF EXECCUTIVE OFFICER");
		lblPosition.setForeground(Color.DARK_GRAY);
		lblPosition.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblHomeAddress_8 = new JLabel("Offical Start Date");
		lblHomeAddress_8.setForeground(Color.GRAY);
		lblHomeAddress_8.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblStartDate = new JLabel("January 01, 2024");
		lblStartDate.setForeground(Color.DARK_GRAY);
		lblStartDate.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblHomeAddress_1 = new JLabel("Salary");
		lblHomeAddress_1.setForeground(Color.DARK_GRAY);
		lblHomeAddress_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblHomeAddress_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		
		lblHomeAddress_5 = new JLabel("Salary Aggrement");
		lblHomeAddress_5.setForeground(Color.GRAY);
		lblHomeAddress_5.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblSalary = new JLabel("12.000.000 VND");
		lblSalary.setForeground(Color.DARK_GRAY);
		lblSalary.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblHomeAddress_6 = new JLabel("Allowance");
		lblHomeAddress_6.setForeground(Color.GRAY);
		lblHomeAddress_6.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblAllowance = new JLabel("1.000.000 VND");
		lblAllowance.setForeground(Color.DARK_GRAY);
		lblAllowance.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblHomeAddress_7 = new JLabel("Account");
		lblHomeAddress_7.setForeground(Color.DARK_GRAY);
		lblHomeAddress_7.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblHomeAddress_7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		
		lblHomeAddress_9 = new JLabel("User name");
		lblHomeAddress_9.setForeground(Color.GRAY);
		lblHomeAddress_9.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblUserName = new JLabel("beck\\");
		lblUserName.setForeground(Color.DARK_GRAY);
		lblUserName.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblHomeAddress_10 = new JLabel("Password");
		lblHomeAddress_10.setForeground(Color.GRAY);
		lblHomeAddress_10.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblPassword = new JLabel("1234556");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 12));

		javax.swing.GroupLayout gl_pn_info = new javax.swing.GroupLayout(pn_info);
		gl_pn_info.setHorizontalGroup(
			gl_pn_info.createParallelGroup(Alignment.TRAILING)
				.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
				.addGroup(gl_pn_info.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pn_info.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pn_info.createSequentialGroup()
							.addComponent(lblHomeAddress_8, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblStartDate, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
						.addGroup(gl_pn_info.createSequentialGroup()
							.addComponent(lblHomeAddress_4, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPosition, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
						.addGroup(gl_pn_info.createSequentialGroup()
							.addComponent(lblHomeAddress_3, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDepartment, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
						.addComponent(lblHomeAddress_2, GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
						.addGroup(gl_pn_info.createSequentialGroup()
							.addComponent(lblHomeAddress1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHomeAddress, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
						.addGroup(gl_pn_info.createSequentialGroup()
							.addComponent(lblGender1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblGender, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
						.addGroup(gl_pn_info.createSequentialGroup()
							.addComponent(lblAge1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAge, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
						.addGroup(gl_pn_info.createSequentialGroup()
							.addComponent(lblDayOfBirth1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDayOfBirth, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(gl_pn_info.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pn_info.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pn_info.createSequentialGroup()
							.addComponent(lblHomeAddress_6, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAllowance, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pn_info.createSequentialGroup()
							.addComponent(lblHomeAddress_5, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSalary, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 0, Short.MAX_VALUE))
						.addComponent(lblHomeAddress_1, GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_pn_info.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_pn_info.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pn_info.createSequentialGroup()
							.addComponent(lblHomeAddress_10, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pn_info.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pn_info.createSequentialGroup()
								.addComponent(lblHomeAddress_9, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblUserName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(lblHomeAddress_7, GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_pn_info.setVerticalGroup(
			gl_pn_info.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pn_info.createSequentialGroup()
					.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pn_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAge1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pn_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pn_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDayOfBirth1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDayOfBirth, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pn_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHomeAddress1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHomeAddress, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblHomeAddress_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pn_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHomeAddress_3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDepartment, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pn_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHomeAddress_4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPosition, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pn_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHomeAddress_8, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStartDate, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblHomeAddress_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pn_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHomeAddress_5, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSalary, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pn_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHomeAddress_6, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAllowance, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblHomeAddress_7, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pn_info.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHomeAddress_9, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pn_info.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHomeAddress_10, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(216, Short.MAX_VALUE))
		);
		pn_info.setLayout(gl_pn_info);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
							.addComponent(lbPath, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 519, Short.MAX_VALUE)
							.addComponent(lblReturn))
						.addGroup(layout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(pn_info, GroupLayout.PREFERRED_SIZE, 527, Short.MAX_VALUE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbPath)
						.addComponent(lblReturn))
					.addGap(18)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(pn_info, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		lblEmail1 = new JLabel("Email");
		lblEmail1.setForeground(Color.GRAY);
		lblEmail1.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblEmail = new JLabel("davidbeckham@gmail.com");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblMobileNo1 = new JLabel("Mobile no.");
		lblMobileNo1.setForeground(Color.GRAY);
		lblMobileNo1.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblMobileNo = new JLabel("+0873748354");
		lblMobileNo.setForeground(Color.DARK_GRAY);
		lblMobileNo.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblEmail_2 = new JLabel("ID no.");
		lblEmail_2.setForeground(Color.GRAY);
		lblEmail_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblID = new JLabel("00011");
		lblID.setForeground(Color.DARK_GRAY);
		lblID.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblFullName = new JLabel("DAVID BECKHAM");
		lblFullName.setForeground(Color.DARK_GRAY);
		lblFullName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
//		Icon icon = new ImageIcon("/gui/icon/profile.jpg");
//		pic.setIcon(icon);
		
		imageAvatar = new ImageAvatar();
		imageAvatar.setBorderSize(1);
		imageAvatar.setIcon(new ImageIcon(Form_Leader_Employee_ViewProfile.class.getResource("/gui/icon/profile.jpg")));
		
		lblEdit = new JLabel("");
		lblEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Application.main.showForm(new Form_Leader_Employee_Edit(id));
			}
		});
		lblEdit.setToolTipText("Edit");
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit.setIcon(new ImageIcon(Form_Leader_Employee_ViewProfile.class.getResource("/gui/icon/edit.png")));
		//pic.setBorderSize(100);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblFullName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEmail_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblMobileNo1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmail1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblID, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblMobileNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(50)
							.addComponent(imageAvatar, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(273, Short.MAX_VALUE)
					.addComponent(lblEdit, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(imageAvatar, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
						.addComponent(lblEdit, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblFullName)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMobileNo, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMobileNo1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(11))
		);
		panel.setLayout(gl_panel);
		this.setLayout(layout);
		lblEdit.setVisible(false);
//		if (!isAdmin) {
//			lbPath.setText("My Profile");
//			lblReturn.setVisible(false);
//			lblEdit.setVisible(true);
//		}
	}// </editor-fold>//GEN-END:initComponents

	private void uploadDataToForm(int id) throws RemoteException, MalformedURLException {
		Employee employee = Application.employeeDao.findById(id);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		Icon icon = null;
    	try {
			URL url = new URL(employee.getAvatar());
			icon = new ImageIcon(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			icon = new ImageIcon(getClass().getResource("/gui/icon/noimage.jpg"));
		}
		imageAvatar.setIcon(icon);
		lblFullName.setText(employee.getFullName());
		lblEmail.setText(employee.getContact().getEmail());
		lblMobileNo.setText(employee.getContact().getPhone());
		lblID.setText(employee.getId()+"");
		lblAge.setText((LocalDate.now().getYear() - employee.getDob().getYear())+"");
		lblGender.setText(employee.isSex()?"Male":"Female");
		lblDayOfBirth.setText(dateTimeFormatter.format(employee.getDob()));
		lblHomeAddress.setText(employee.getAddress());
		lblDepartment.setText(employee.getDepartment().getName());
		lblPosition.setText(employee.getRole().getName());
		lblStartDate.setText(dateTimeFormatter.format(employee.getAggrementInfo().getApplyDate()));
		DecimalFormat decimalFormat = new DecimalFormat("#,### VND");
		lblSalary.setText(decimalFormat.format(employee.getAggrementInfo().getBasicSalary()));
		lblAllowance.setText(decimalFormat.format(employee.getAggrementInfo().getAllowance()));
		lblUserName.setText(employee.getAccount().getUserName());
		lblPassword.setText(employee.getAccount().getPassWord());
	}
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private gui.component.Card card1;
	private gui.component.Card card2;
	private gui.component.Card card3;
//    private gui.component.Card card4;
	private javax.swing.JLabel lbPath;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel pn_info;
	private JLabel lblAge1;
	private JLabel lblAge;
	private JLabel lblGender1;
	private JLabel lblGender;
	private JLabel lblDayOfBirth1;
	private JLabel lblDayOfBirth;
	private JLabel lblHomeAddress1;
	private JLabel lblHomeAddress;
	private JLabel lblHomeAddress_3;
	private JLabel lblDepartment;
	private JLabel lblHomeAddress_4;
	private JLabel lblPosition;
	private JLabel lblHomeAddress_8;
	private JLabel lblStartDate;
	private JLabel lblEmail1;
	private JLabel lblEmail;
	private JLabel lblMobileNo1;
	private JLabel lblMobileNo;
	private JLabel lblEmail_2;
	private JLabel lblID;
	private JLabel lblFullName;
	
	private JLabel lblReturn;
	
	private ImageAvatar imageAvatar; 
	private JLabel lblHomeAddress_1;
	private JLabel lblHomeAddress_5;
	private JLabel lblSalary;
	private JLabel lblHomeAddress_6;
	private JLabel lblAllowance;
	private JLabel lblHomeAddress_7;
	private JLabel lblHomeAddress_9;
	private JLabel lblUserName;
	private JLabel lblHomeAddress_10;
	private JLabel lblPassword;
	private JLabel lblEdit;
}
