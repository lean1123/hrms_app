package gui.form;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import entity.Account;
import entity.AggrementInfo;
import entity.Contact;
import entity.Department;
import entity.Employee;
import entity.Manager;
import entity.Role;
import entity.Shift;
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
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

public class Form_Leader_Employee_Edit extends JPanel {
	public Form_Leader_Employee_Edit(int id) {

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
				Application.main.showForm(Application.form_Leader_Employees);

			}
		});

		pnRight = new javax.swing.JPanel();

		jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(4, 72, 210));
		jLabel1.setText("My Department/Employees/Edit employee");

		pnRight.setBackground(new java.awt.Color(255, 255, 255));

		lblNewLabel_3 = new JLabel("Designation");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));

		lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 9));

		lblNewLabel_5 = new JLabel("Position");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 9));

		String position = "";
		try {
			position = Application.employeeDao.findById(id).getRole().getName();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cmbPosition = new JComboBox(new String[] { position });
		cmbPosition.setEditable(false);

		lblNewLabel_2_2 = new JLabel("Office Start Date");
		lblNewLabel_2_2.setFont(new Font("SansSerif", Font.PLAIN, 9));

		String departmentName = "";
		try {
			departmentName = Application.employeeDao.findById(Application.idUserLogin).getDepartment().getName();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		cmbDepartment = new JComboBox(new String[] { departmentName });
		cmbDepartment.setEditable(false);

		txtOfficeStartDate = new JTextField();
		txtOfficeStartDate.setEditable(false);
		txtOfficeStartDate.setColumns(10);

		javax.swing.GroupLayout gl_pnRight = new javax.swing.GroupLayout(pnRight);
		gl_pnRight.setHorizontalGroup(gl_pnRight.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
				.addGroup(gl_pnRight.createSequentialGroup().addContainerGap()
						.addComponent(cmbPosition, 0, 462, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_pnRight.createSequentialGroup().addGap(10).addGroup(gl_pnRight
						.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(310, Short.MAX_VALUE))
				.addGroup(gl_pnRight.createSequentialGroup().addContainerGap()
						.addComponent(cmbDepartment, 0, 462, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_pnRight.createSequentialGroup().addContainerGap()
						.addComponent(txtOfficeStartDate, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
						.addContainerGap()));
		gl_pnRight.setVerticalGroup(gl_pnRight.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnRight.createSequentialGroup()
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cmbDepartment, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cmbPosition, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtOfficeStartDate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(335, Short.MAX_VALUE)));
		pnRight.setLayout(gl_pnRight);

		pnLeft = new JPanel();
		pnLeft.setBackground(Color.WHITE);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Application.main.showForm(Application.form_Leader_Employees);
			}
		});

		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(50, 205, 50));
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if (updateEmployee(id)) {
						Application.main.showForm(Application.form_Leader_Employees);
						Form_Leader_Employees.reloadTableData();
						Application.showMessageSucces("Update employee succes");
					} else
						Application.showMessageError("Update employee failed!");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JPanel pnRight_1 = new JPanel();
		pnRight_1.setBackground(Color.WHITE);

		JLabel lblNewLabel_3_1 = new JLabel("Salary");
		lblNewLabel_3_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_3_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_3_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));

		JLabel lblNewLabel_4_1 = new JLabel("Salary Aggrement");
		lblNewLabel_4_1.setFont(new Font("SansSerif", Font.PLAIN, 9));

		JLabel lblNewLabel_5_1 = new JLabel("Allowance");
		lblNewLabel_5_1.setFont(new Font("SansSerif", Font.PLAIN, 9));

		txtSalaryAgg = new JTextField();
		txtSalaryAgg.setColumns(10);

		txtAllowance = new JTextField();
		txtAllowance.setColumns(10);
		GroupLayout gl_pnRight_1 = new GroupLayout(pnRight_1);
		gl_pnRight_1.setHorizontalGroup(gl_pnRight_1.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblNewLabel_3_1, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
				.addGroup(gl_pnRight_1.createSequentialGroup().addGap(10)
						.addGroup(gl_pnRight_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 162,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 162,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(310, Short.MAX_VALUE))
				.addGroup(gl_pnRight_1.createSequentialGroup().addContainerGap()
						.addComponent(txtSalaryAgg, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE).addContainerGap())
				.addGroup(Alignment.LEADING, gl_pnRight_1.createSequentialGroup().addContainerGap()
						.addComponent(txtAllowance, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE).addContainerGap()));
		gl_pnRight_1.setVerticalGroup(gl_pnRight_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnRight_1.createSequentialGroup()
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtSalaryAgg, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtAllowance, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(81, Short.MAX_VALUE)));
		pnRight_1.setLayout(gl_pnRight_1);

		pnRight_2 = new JPanel();
		pnRight_2.setBackground(Color.WHITE);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);

		lblNewLabel_3_2 = new JLabel("Account");
		lblNewLabel_3_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_3_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_3_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));

		lblNewLabel_4_2 = new JLabel("User name");
		lblNewLabel_4_2.setFont(new Font("SansSerif", Font.PLAIN, 9));

		lblNewLabel_5_2 = new JLabel("Password");
		lblNewLabel_5_2.setFont(new Font("SansSerif", Font.PLAIN, 9));

		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		GroupLayout gl_pnRight_2 = new GroupLayout(pnRight_2);
		gl_pnRight_2
				.setHorizontalGroup(gl_pnRight_2.createParallelGroup(Alignment.TRAILING).addGap(0, 482, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3_2, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
						.addGroup(gl_pnRight_2.createSequentialGroup().addGap(10)
								.addGroup(gl_pnRight_2.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_4_2, GroupLayout.PREFERRED_SIZE, 162,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5_2, GroupLayout.PREFERRED_SIZE, 162,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(310, Short.MAX_VALUE))
						.addGroup(gl_pnRight_2.createSequentialGroup().addContainerGap()
								.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(Alignment.LEADING,
								gl_pnRight_2.createSequentialGroup().addContainerGap()
										.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
										.addContainerGap()));
		gl_pnRight_2.setVerticalGroup(gl_pnRight_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 145, Short.MAX_VALUE)
				.addGroup(gl_pnRight_2.createSequentialGroup()
						.addComponent(lblNewLabel_3_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_4_2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(lblNewLabel_5_2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(81, Short.MAX_VALUE)));
		pnRight_2.setLayout(gl_pnRight_2);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup()
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 465, Short.MAX_VALUE).addComponent(lblReturn))
						.addGroup(layout.createSequentialGroup()
								.addComponent(pnLeft, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE).addGap(18)
								.addGroup(layout.createParallelGroup(Alignment.TRAILING)
										.addComponent(pnRight, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
										.addComponent(pnRight_1, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
										.addComponent(pnRight_2, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
						.addGroup(layout.createSequentialGroup()
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnCancel)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel1).addComponent(lblReturn))
				.addGap(18)
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
						.addComponent(pnRight, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(pnRight_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(pnRight_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnSave)
								.addComponent(btnCancel)))
						.addComponent(pnLeft, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE))
				.addGap(23)));

		lblNewLabel = new JLabel(" Personal Information");
		lblNewLabel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

		lblNewLabel_1 = new JLabel("Full name");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 9));

		txtFullName = new JTextField();
		lblNewLabel_1.setLabelFor(txtFullName);
		txtFullName.setColumns(10);

		lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 9));

		cmbGender = new JComboBox(new String[] { "Male", "Female" });
		lblNewLabel_2.setLabelFor(cmbGender);

		lblNewLabel_2_1_3 = new JLabel("Email Address");
		lblNewLabel_2_1_3.setFont(new Font("SansSerif", Font.PLAIN, 9));

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		lblNewLabel_2_1_4 = new JLabel("Mobile No.");
		lblNewLabel_2_1_4.setFont(new Font("SansSerif", Font.PLAIN, 9));

		txtMobile = new JTextField();
		txtMobile.setColumns(10);

		lblNewLabel_2_1_6 = new JLabel("Date of Birth");
		lblNewLabel_2_1_6.setFont(new Font("SansSerif", Font.PLAIN, 9));

		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setColumns(10);

		dateChooserDOB = new DateChooser();
		dateChooserDOB.setTextRefernce(txtDateOfBirth);

		lblNewLabel_2_1_8 = new JLabel("Home Address");
		lblNewLabel_2_1_8.setFont(new Font("SansSerif", Font.PLAIN, 9));

		txtHomeAddress = new JTextField();
		txtHomeAddress.setColumns(10);

		lblNewLabel_2_1_9 = new JLabel("Upload Profile photo");
		lblNewLabel_2_1_9.setFont(new Font("SansSerif", Font.PLAIN, 9));

		txtPhoto = new JTextField();
		txtPhoto.setEditable(false);
		txtPhoto.setColumns(10);

		JButton btnAddPhoto = new JButton("Add Photo");
		btnAddPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filePath = addPhotoActionPerformed(e);
				txtPhoto.setText(filePath);
			}
		});
		// pic.setBorderSize(100);

		GroupLayout gl_pnLeft = new GroupLayout(pnLeft);
		gl_pnLeft.setHorizontalGroup(gl_pnLeft.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
				.addGroup(gl_pnLeft.createSequentialGroup().addContainerGap()
						.addComponent(txtFullName, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE).addContainerGap())
				.addGroup(
						gl_pnLeft.createSequentialGroup().addContainerGap()
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 162,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(321, Short.MAX_VALUE))
				.addGroup(
						gl_pnLeft.createSequentialGroup().addContainerGap()
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 162,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(321, Short.MAX_VALUE))
				.addGroup(gl_pnLeft.createSequentialGroup().addContainerGap()
						.addComponent(cmbGender, 0, 473, Short.MAX_VALUE).addContainerGap())
				.addGroup(
						gl_pnLeft.createSequentialGroup().addContainerGap()
								.addComponent(lblNewLabel_2_1_6, GroupLayout.PREFERRED_SIZE, 162,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(321, Short.MAX_VALUE))
				.addGroup(gl_pnLeft.createSequentialGroup().addContainerGap()
						.addComponent(txtDateOfBirth, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE).addContainerGap())
				.addGroup(
						gl_pnLeft.createSequentialGroup().addContainerGap()
								.addComponent(lblNewLabel_2_1_3, GroupLayout.PREFERRED_SIZE, 162,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(321, Short.MAX_VALUE))
				.addGroup(gl_pnLeft.createSequentialGroup().addContainerGap()
						.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_pnLeft.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel_2_1_4, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(321, Short.MAX_VALUE))
				.addGroup(gl_pnLeft.createSequentialGroup().addContainerGap()
						.addComponent(txtMobile, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE).addContainerGap())
				.addGroup(
						gl_pnLeft.createSequentialGroup().addContainerGap()
								.addComponent(lblNewLabel_2_1_8, GroupLayout.PREFERRED_SIZE, 162,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(321, Short.MAX_VALUE))
				.addGroup(gl_pnLeft.createSequentialGroup().addContainerGap()
						.addComponent(txtHomeAddress, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_pnLeft.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel_2_1_9, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(321, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						gl_pnLeft.createSequentialGroup().addContainerGap()
								.addComponent(txtPhoto, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnAddPhoto, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_pnLeft.setVerticalGroup(gl_pnLeft.createParallelGroup(Alignment.LEADING).addGroup(gl_pnLeft
				.createSequentialGroup().addComponent(lblNewLabel).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblNewLabel_1).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtFullName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(cmbGender, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(lblNewLabel_2_1_6, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtDateOfBirth, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(lblNewLabel_2_1_3, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(lblNewLabel_2_1_4, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtMobile, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(lblNewLabel_2_1_8, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtHomeAddress, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(lblNewLabel_2_1_9, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_pnLeft.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAddPhoto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtPhoto, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
				.addContainerGap(60, Short.MAX_VALUE)));
		pnLeft.setLayout(gl_pnLeft);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private String addPhotoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		JnaFileChooser jnaCh = new JnaFileChooser();
		jnaCh.setDefaultFileName("chọn ảnh");
		jnaCh.addFilter("ảnh", "png", "jpg");
		boolean save = jnaCh.showSaveDialog(null);
		if (save) {
			System.out.println(jnaCh.getSelectedFile());
			// txtPhoto.setText(jnaCh.getSelectedFile().toString());
		}
		return jnaCh.getSelectedFile().toString();
	}

	public String uploadImageToCloudinary(String pathFile, String publicId) throws IOException {
		Cloudinary cloudinary = new Cloudinary(Application.CLOUDINARY_URL);
		cloudinary.config.secure = true;
		File file = new File(pathFile);
		String folderName = "image-profile"; // Thay "image-profile" bằng tên thư mục của bạn
		Map params = ObjectUtils.asMap("public_id", publicId, "folder", folderName);
		Map response = cloudinary.uploader().upload(file, params);

		String publicUrl = cloudinary.url().format("png").version(response.get("version")).generate(publicId);
		String folderUrl = cloudinary.url().generate(folderName);
		String finalUrl = folderUrl + "/" + publicUrl.substring(publicUrl.lastIndexOf('/') + 1);

		System.out.println("Upload successful. Public URL: " + finalUrl);
		return finalUrl;
	}

	private void uploadDataToForm(int id) throws RemoteException {
		Employee employee = Application.employeeDao.findById(id);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		txtFullName.setText(employee.getFullName());
		txtDateOfBirth.setText(dateTimeFormatter.format(employee.getDob()));
		dateChooserDOB.setSelectedDate(Date.from(employee.getDob().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		txtEmail.setText(employee.getContact().getEmail());
		txtMobile.setText(employee.getContact().getPhone());
		txtHomeAddress.setText(employee.getAddress());
		txtPhoto.setText(employee.getAvatar());
		txtOfficeStartDate.setText(dateTimeFormatter.format(employee.getAggrementInfo().getApplyDate()));
		DecimalFormat decimalFormat = new DecimalFormat("###");
		txtSalaryAgg.setText(decimalFormat.format(employee.getAggrementInfo().getBasicSalary()));
		txtAllowance.setText(decimalFormat.format(employee.getAggrementInfo().getAllowance()));
		txtUsername.setText(employee.getAccount().getUserName());
		txtPassword.setText(employee.getAccount().getPassWord());
		cmbGender.setSelectedIndex(employee.isSex() ? 0 : 1);
	}

	private boolean updateEmployee(int id) throws RemoteException {
		Employee employee = Application.employeeDao.findById(id);

		String fullName = txtFullName.getText().trim();
		boolean gender = cmbGender.getSelectedItem().equals("Male") ? true : false;
		String dobString = txtDateOfBirth.getText().trim();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dateDob = LocalDate.parse(dobString, formatter);
		String email = txtEmail.getText().trim();
		String mobile = txtMobile.getText().trim();
		String homeAddress = txtHomeAddress.getText().trim();
		String urlPhoto = txtPhoto.getText().trim();
		String departmentName = (String) cmbDepartment.getSelectedItem();
		Department department = Application.departmentDao.findByName(departmentName).get(0);

		String role = (String) cmbPosition.getSelectedItem();
		String startDateString = txtOfficeStartDate.getText().trim();
		LocalDate startDate = LocalDate.parse(startDateString, formatter);
		double salary = Double.parseDouble(txtSalaryAgg.getText().trim());
		double allowance = Double.parseDouble(txtAllowance.getText().trim());
		String userName = txtUsername.getText().trim();
		String password = txtPassword.getText().trim();

		boolean check = false;

		Account account = employee.getAccount();
		account.setUserName(userName);
		account.setPassWord(password);

		Manager manager = employee.getManager();

		employee.setFullName(fullName);
		employee.setSex(gender);
		employee.setDob(dateDob);
		Contact contact = new Contact(mobile, email);
		employee.setContact(contact);
		employee.setAddress(homeAddress);
		employee.setAvatar(urlPhoto);
		employee.setDepartment(department);
		employee.setRole(role.equals("LEADER") ? Role.LEADER : Role.EMPLOYEE);
		employee.setAccount(account);

		Shift shift = Application.shiftDao.findById(1);
		employee.setShift(shift);

		Employee leader = employee.getLeader();
		employee.setLeader(leader);
		employee.setManager(manager);

		AggrementInfo aggrementInfo = employee.getAggrementInfo();
		aggrementInfo.setApplyDate(startDate);
		aggrementInfo.setAllowance(allowance);
		aggrementInfo.setBasicSalary(salary);
		aggrementInfo.setNumberOfRestDays(12);

		employee.setAggrementInfo(aggrementInfo);
		employee = Application.employeeDao.update(employee);
		if (employee == null) {
			return false; // Trả về false nếu không thể lưu thông tin nhân viên
		}
		return true;
	}

	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel pnRight;
	private JPanel pnLeft;

	private JLabel lblReturn;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtFullName;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1_3;
	private JTextField txtEmail;
	private JLabel lblNewLabel_2_1_4;
	private JTextField txtMobile;
	private JLabel lblNewLabel_2_1_6;
	private JTextField txtDateOfBirth;
	private JLabel lblNewLabel_2_1_8;
	private JTextField txtHomeAddress;
	private JLabel lblNewLabel_2_1_9;
	private JTextField txtPhoto;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JComboBox cmbPosition;
	private JLabel lblNewLabel_2_2;
	private JComboBox cmbDepartment;
	private JTextField txtOfficeStartDate;
	private JTextField txtSalaryAgg;
	private JTextField txtAllowance;
	private JPanel pnRight_2;
	private JTextField txtPassword;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_4_2;
	private JLabel lblNewLabel_5_2;
	private JTextField txtUsername;
	private JComboBox cmbGender;

	private DateChooser dateChooserDOB;
}
