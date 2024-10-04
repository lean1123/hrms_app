package gui.main;

import static org.mockito.Mockito.CALLS_REAL_METHODS;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import dao.interfaces.IAccount;
import dao.interfaces.IAggrementInfo;
import dao.interfaces.IAttendance;
import dao.interfaces.IDepartment;
import dao.interfaces.IEmployeeDao;
import dao.interfaces.IManagerDao;
import dao.interfaces.IPayrolls;
import dao.interfaces.IRestAllowed;
import dao.interfaces.IShift;
import entity.Attendance;
import entity.Employee;
import entity.Role;
import gui.component.Header;
import gui.component.Menu;
import gui.dialog.Message;
import gui.event.EventMenuSelected;
import gui.event.EventShowPopupMenu;
import gui.form.Form_Admin_Attendances;
import gui.form.Form_Admin_Attendances_Edit;
import gui.form.Form_Admin_Dashboard;
import gui.form.Form_Admin_Employee_AddNew;
import gui.form.Form_Admin_Employee_Edit;
import gui.form.Form_Admin_Employee_ViewProfile;
import gui.form.Form_Admin_Employees;
import gui.form.Form_Admin_LeavesOfAbsence;
import gui.form.Form_Admin_Salary;
import gui.form.Form_Admin_Schedules;
import gui.form.Form_Admin_Schedules_Edit;
import gui.form.Form_Employee_Check_In_Out;
import gui.form.Form_Employee_Dashboard;
import gui.form.Form_Employee_MyAttendances;
import gui.form.Form_Employee_MyLeave;
import gui.form.Form_Employee_MyProfile;
import gui.form.Form_General_MySalary;
import gui.form.Form_General_Report;
import gui.form.Form_Employee_MySchedules;
import gui.form.Form_Leader_Attendances_Edit;
import gui.form.Form_Leader_Employee_AddNew;
import gui.form.Form_Leader_Employee_Edit;
import gui.form.Form_Leader_Employee_ViewProfile;
import gui.form.Form_Employee_EditMyProfile;
import gui.form.Form_Leader_MyProfile;
import gui.form.Form_Leader_Attendances;
import gui.form.Form_Leader_Dashboard;
import gui.form.Form_Leader_EditMyProfile;
import gui.form.Form_Leader_Employees;
import gui.form.Form_Leader_LeavesOfAbsenca;
import gui.form.Form_General_Schedules;
import gui.form.MainForm;
import gui.swing.MenuItem;
import gui.swing.PopupMenu;
import gui.swing.icon.GoogleMaterialDesignIcons;
import gui.swing.icon.IconFontSwing;
import net.miginfocom.swing.MigLayout;

public class Application extends javax.swing.JFrame {

	private Animator animatorLogin;
	private Animator animatorBody;
	private boolean signIn;
	
	public static String CLOUDINARY_URL = "cloudinary://577653484354958:R8mLoMgAd0_gedm8SRT4-vfSKoA@dohpvtyop";

	
	public static int idUserLogin=-1;
	public static int idAccountLogin=-1;
	
	public static IEmployeeDao employeeDao;
	public static IShift shiftDao;
	public static IManagerDao managerDao;
	public static IAttendance attendanceDao;
	public static IDepartment departmentDao;
	public static IAccount accountDao;
	public static IAggrementInfo aggrementInfoDao;
	public static IRestAllowed restAllowedDao;
	public static IPayrolls payrollsDao;
	
	public static Thread threadUploadPhoto;
	
	public void connectServer() {
		try {
			employeeDao = (IEmployeeDao) Naming.lookup("rmi://localhost:2003/employeeDao");
			shiftDao = (IShift) Naming.lookup("rmi://localhost:2003/shiftDao");
			managerDao = (IManagerDao) Naming.lookup("rmi://localhost:2003/managerDao");
			attendanceDao = (IAttendance) Naming.lookup("rmi://localhost:2003/attendanceDao");
			departmentDao = (IDepartment) Naming.lookup("rmi://localhost:2003/departmentDao");
			accountDao = (IAccount) Naming.lookup("rmi://localhost:2003/accountDao");
			aggrementInfoDao = (IAggrementInfo) Naming.lookup("rmi://localhost:2003/aggrementInfoDao");
			restAllowedDao = (IRestAllowed) Naming.lookup("rmi://localhost:2003/restallowedDao");
			payrollsDao = (IPayrolls) Naming.lookup("rmi://localhost:2003/payrollDao");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Server not active");	
			System.exit(0);
		}
	}
	
	public Application() {
		threadUploadPhoto = new Thread();
		roleLogin = "employee";
		initComponents();
		//initMain();
		connectServer();
		getContentPane().setBackground(new Color(245, 245, 245));
		TimingTarget targetLogin = new TimingTargetAdapter() {
			@Override
			public void timingEvent(float fraction) {
				if (signIn) {
					background1.setAnimate(fraction);
				} else {
					background1.setAnimate(1f - fraction);
				}
			}

			@Override
			public void end() {
				if (signIn) {
					panelLogin.setVisible(false);
					background1.setShowPaint(true);
					// panelBody.setAlpha(0);
					// panelBody.setVisible(true);
					bg.setVisible(true);
					animatorBody.start();
				} else {
					enableLogin(true);
					txtUser.grabFocus();
				}
			}
		};
		TimingTarget targetBody = new TimingTargetAdapter() {
			@Override
			public void timingEvent(float fraction) {
				if (signIn) {
					// panelBody.setAlpha(fraction);
				} else {
					// panelBody.setAlpha(1f - fraction);
				}
			}

			@Override
			public void end() {
				if (signIn == false) {
					// panelBody.setVisible(false);
					bg.setVisible(false);
					background1.setShowPaint(false);
					background1.setAnimate(1);
					panelLogin.setVisible(true);
					animatorLogin.start();
				}
			}
		};
		animatorLogin = new Animator(1500, targetLogin);
		animatorBody = new Animator(500, targetBody);
		animatorLogin.setResolution(0);
		animatorBody.setResolution(0);
		// jScrollPane1.getViewport().setOpaque(false);
		// jScrollPane1.setViewportBorder(null);

		
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		background1 = new gui.swing.login.Background();
		panelLogin = new javax.swing.JPanel();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		cmdSignIn = new gui.swing.login.Button();
		txtUser = new gui.swing.login.TextField();
		txtPass = new gui.swing.login.PasswordField();

		jScrollPane1 = new javax.swing.JScrollPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		background1.setLayout(new java.awt.CardLayout());

		panelLogin.setOpaque(false);

		jPanel1.setOpaque(false);

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icon/logo.png"))); // NOI18N

		cmdSignIn.setBackground(new java.awt.Color(157, 153, 255));
		cmdSignIn.setForeground(new java.awt.Color(255, 255, 255));
		cmdSignIn.setText("Sign In");
		cmdSignIn.setEffectColor(new java.awt.Color(199, 196, 255));
		cmdSignIn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmdSignInActionPerformed(evt);
			}
		});

		txtUser.setBackground(new java.awt.Color(245, 245, 245));
		txtUser.setLabelText("User Name");
		txtUser.setLineColor(new java.awt.Color(131, 126, 253));
		txtUser.setSelectionColor(new java.awt.Color(157, 153, 255));

		txtPass.setBackground(new java.awt.Color(245, 245, 245));
		txtPass.setLabelText("Password");
		txtPass.setLineColor(new java.awt.Color(131, 126, 253));
		txtPass.setSelectionColor(new java.awt.Color(157, 153, 255));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addGap(20, 20, 20)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cmdSignIn, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
						.addGap(20, 20, 20)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(jLabel1)
						.addGap(20, 20, 20)
						.addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
						.addComponent(cmdSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
		panelLogin.setLayout(panelLoginLayout);
		panelLoginLayout
				.setHorizontalGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelLoginLayout.createSequentialGroup().addContainerGap(427, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(428, Short.MAX_VALUE)));
		panelLoginLayout
				.setVerticalGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelLoginLayout.createSequentialGroup().addContainerGap(63, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(233, Short.MAX_VALUE)));

		background1.add(panelLogin, "card2");

		// add main app
		bg = new javax.swing.JLayeredPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		bg.setBackground(new java.awt.Color(245, 245, 245));
		bg.setOpaque(true);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();



		
		javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
		bg.setLayout(bgLayout);
		bgLayout.setHorizontalGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
				(int) width, Short.MAX_VALUE));//1366
		bgLayout.setVerticalGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, (int) height-50,
				Short.MAX_VALUE));//783

		background1.add(bg, "card3");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(background1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(background1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		setLocationRelativeTo(null);

	}// </editor-fold>//GEN-END:initComponents

	private void initMain() {
		layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
		bg.setLayout(layout);
		// Init google icon font
		IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
		menu = new Menu();
		header = new Header();
		main = new MainForm();
		
		Header.cmdLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (showMessageWarning("Do you want logout?")) {
					jButton1ActionPerformed(e);
				}
				
			}
		});
		
		menu.addEventShowPopup(new EventShowPopupMenu() {
			@Override
			public void showPopup(Component com) {
				MenuItem item = (MenuItem) com;
				PopupMenu popup = new PopupMenu(Application.this, item.getIndex(), item.getEventSelected(),
						item.getMenu().getSubMenu());
				int x = Application.this.getX() + 52;
				int y = Application.this.getY() + com.getY() + 86;
				popup.setLocation(x, y);
				popup.setVisible(true);
			}
		});
		
		bg.add(menu, "w 230!, spany 2"); // Span Y 2cell
		bg.add(header, "h 50!, wrap");
		bg.add(main, "w 100%, h 100%");
		TimingTarget target = new TimingTargetAdapter() {
			@Override
			public void timingEvent(float fraction) {
				double width;
				if (menu.isShowMenu()) {
					width = 60 + (170 * (1f - fraction));
				} else {
					width = 60 + (170 * fraction);
				}
				layout.setComponentConstraints(menu, "w " + width + "!, spany2");
				menu.revalidate();
			}

			@Override
			public void end() {
				menu.setShowMenu(!menu.isShowMenu());
				menu.setEnableMenu(true);
			}

		};
		animator = new Animator(500, target);
		animator.setResolution(0);
		animator.setDeceleration(0.5f);
		animator.setAcceleration(0.5f);
		header.addMenuEvent(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (!animator.isRunning()) {
					animator.start();
				}
				menu.setEnableMenu(false);
				if (menu.isShowMenu()) {
					menu.hideallMenu();
				}
			}
		});

	}

	private void cmdSignInActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmdSignInActionPerformed
		if (!animatorLogin.isRunning()) {
			animatorLogin.stop();
			signIn = true;
			String user = txtUser.getText().trim();
			String pass = String.valueOf(txtPass.getPassword());
			boolean action = true;
			if (user.equals("")) {
				txtUser.setHelperText("Please input user name");
				txtUser.grabFocus();
				action = false;
			}
			if (pass.equals("")) {
				txtPass.setHelperText("Please input password");
				if (action) {
					txtPass.grabFocus();
				}
				action = false;
			}
//			if (action) {
//				animatorLogin.start();
//				enableLogin(false);
//			}
			if (user.equals("admin") && pass.equals("1")) {
				//initComponents();
				initMain();
				initMenu("admin");
				animatorLogin.start();
				enableLogin(false);
			}
			if (user.equals("leader") && pass.equals("1")) {
				//initComponents();
				initMain();
				initMenu("leader");
				animatorLogin.start();
				enableLogin(false);
			}
			if (user.equals("employee") && pass.equals("1")) {
				initMain();
				initMenu("employee");
				
				animatorLogin.start();
				enableLogin(false);
				
			}
			
			try {
				idAccountLogin = accountDao.login(user, pass);
				System.out.println(idAccountLogin);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				Application.showMessageError("user name or pasword wrong!");
			}
			if (idAccountLogin==0) {
				txtUser.setHelperText("Please input user name again");
				txtUser.grabFocus();
				txtPass.setHelperText("Please input password again");
				action = false;
			}
			else {
				if (idAccountLogin==1) {
					initMain();
					initMenu("admin");
					animatorLogin.start();
					enableLogin(false);
				}
				else {
					Employee employee = null;
					try {
						idUserLogin = employeeDao.getIdByIdAccount(idAccountLogin);
						 employee = employeeDao.findById(idUserLogin);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (employee.getRole().equals(Role.LEADER))  {
						initMain();
						initMenu("leader");
						animatorLogin.start();
						enableLogin(false);
					}
					else if (employee.getRole().equals(Role.EMPLOYEE)) {
						initMain();
						initMenu("employee");
						
						animatorLogin.start();
						enableLogin(false);
					}
				}
			}
		}
	}// GEN-LAST:event_cmdSignInActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		signIn = false;
		clearLogin();
		bg.removeAll();
		animatorLogin.cancel();
		animatorBody.start();
	}// GEN-LAST:event_jButton1ActionPerformed

	private void enableLogin(boolean action) {
		txtUser.setEditable(action);
		txtPass.setEditable(action);
		cmdSignIn.setEnabled(action);
	}

	public void clearLogin() {
		txtUser.setText("");
		txtPass.setText("");
		txtUser.setHelperText("");
		txtPass.setHelperText("");
	}
	
	private void initMenu(String role) {
		if (role.equals("admin")) {
			
			form_Admin_Employees = new Form_Admin_Employees();
			
			
			
			
			menu.addEvent(new EventMenuSelected() {
				@Override
				public void menuSelected(int menuIndex, int subMenuIndex) {
					System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
					if (menuIndex == 0) {
						form_Admin_Dashboard = new Form_Admin_Dashboard();
						main.showForm(form_Admin_Dashboard);
					}
					if (menuIndex == 1) {
						form_Admin_Employees = new Form_Admin_Employees();
						main.showForm(form_Admin_Employees);
					}
					if (menuIndex == 2) {
						form_Admin_Attendances = new Form_Admin_Attendances();
						main.showForm(form_Admin_Attendances);
					}
					if (menuIndex == 3) {
						form_Admin_Schedules = new Form_Admin_Schedules();
						main.showForm(form_Admin_Schedules);
					}
					if (menuIndex == 4) {
						form_Admin_LeavesOfAbsence = new Form_Admin_LeavesOfAbsence();
						main.showForm(form_Admin_LeavesOfAbsence);
					}
					if (menuIndex == 5) {
						form_Admin_Salary = new Form_Admin_Salary();
						main.showForm(form_Admin_Salary);
					}
					if (menuIndex == 6) {
						main.showForm(new Form_General_Report());
					}
					if (menuIndex == 7) {
						// message
					}
				}
			});
		} else if (role.equals("leader")) {
			
			
			
			form_Leader_Employees = new Form_Leader_Employees();
			
			
			menu.addEvent(new EventMenuSelected() {
				@Override
				public void menuSelected(int menuIndex, int subMenuIndex) {
					System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
					if (menuIndex == 0) {
						form_Leader_Dashboard = new Form_Leader_Dashboard();
						main.showForm(form_Leader_Dashboard);
					}
					if (menuIndex == 1) {
						form_Leader_MyProfile = new Form_Leader_MyProfile(idUserLogin);
						main.showForm(form_Leader_MyProfile);
					}
					if (menuIndex == 2) {
						form_General_MySalary = new Form_General_MySalary();
						main.showForm(form_General_MySalary);
					}
					if (menuIndex == 3) {
						if (subMenuIndex == 0) {
							form_Leader_Employees = new Form_Leader_Employees();
							main.showForm(form_Leader_Employees);
						}
						
						if (subMenuIndex == 1) {
							form_General_Schedules  = new Form_General_Schedules();
							main.showForm(form_General_Schedules);
						}
						if (subMenuIndex == 2) {
							form_Leader_LeavesOfAbsenca = new Form_Leader_LeavesOfAbsenca();
							main.showForm(form_Leader_LeavesOfAbsenca);
						}
					}
					if (menuIndex == 4) {
						// report
					}
					if (menuIndex == 5) {
						// message
					}
				}
			});
		} else if (role.equals("employee")) {
			
			
			
			
			
			
			
			menu.addEvent(new EventMenuSelected() {
				@Override
				public void menuSelected(int menuIndex, int subMenuIndex) {
					System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
					if (menuIndex == 0) {
						form_Employee_Dashboard = new Form_Employee_Dashboard();
						main.showForm(form_Employee_Dashboard);
					}
					if (menuIndex == 1) {
						form_Employee_Check_In_Out = new Form_Employee_Check_In_Out();
						main.showForm(form_Employee_Check_In_Out);
					}
					if (menuIndex == 2) {
						form_Employee_MyProfile = new Form_Employee_MyProfile(idUserLogin);
						main.showForm(form_Employee_MyProfile);
					}
					if (menuIndex == 3) {
						form_Employee_MyAttendances = new Form_Employee_MyAttendances();
						main.showForm(form_Employee_MyAttendances);
					}
					if (menuIndex == 4) {
						form_General_Schedules = new Form_General_Schedules();
						main.showForm(form_General_Schedules);
					}
					if (menuIndex == 5) {
						form_Employee_MyLeave = new Form_Employee_MyLeave();
						main.showForm(form_Employee_MyLeave);
					}
					if (menuIndex == 6) {
						form_General_MySalary = new Form_General_MySalary();
						main.showForm(form_General_MySalary);
					}
					if (menuIndex == 7) {
						// main.showForm(new Form_Employee_MySchedules()); report
					}
					if (menuIndex == 8) {
						// main.showForm(new Form_Employee_MySchedules()); message
					}
				}
			});
		}
		if (role.equals("admin")) {
			menu.initMenuItem();
			// Start with this form
			main.showForm(new Form_Admin_Dashboard());
		} else if (role.equals("leader")) {
			menu.initMenuItemLeader();
			// Start with this form
			main.showForm(new Form_Leader_Dashboard());
		} else if (role.equals("employee")) {
			menu.initMenuItemEmployee();
			// Start with this form
			main.showForm(new Form_Employee_Dashboard());
		}
	}
	
	private void initMenu1(String role) {
		if (role.equals("admin")) {
			form_Admin_Dashboard = new Form_Admin_Dashboard();
			form_Admin_Employees = new Form_Admin_Employees();
			form_Admin_Attendances = new Form_Admin_Attendances();
			form_Admin_Schedules = new Form_Admin_Schedules();
			form_Admin_LeavesOfAbsence = new Form_Admin_LeavesOfAbsence();
			form_Admin_Salary = new Form_Admin_Salary();
			menu.addEvent(new EventMenuSelected() {
				@Override
				public void menuSelected(int menuIndex, int subMenuIndex) {
					System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
					if (menuIndex == 0) {
						main.showForm(form_Admin_Dashboard);
					}
					if (menuIndex == 1) {
						main.showForm(form_Admin_Employees);
					}
					if (menuIndex == 2) {
						main.showForm(form_Admin_Attendances);
					}
					if (menuIndex == 3) {
						main.showForm(form_Admin_Schedules);
					}
					if (menuIndex == 4) {
						main.showForm(form_Admin_LeavesOfAbsence);
					}
					if (menuIndex == 5) {
						main.showForm(form_Admin_Salary);
					}
					if (menuIndex == 6) {
						main.showForm(new Form_General_Report());
						
					}
					if (menuIndex == 7) {
						// message
					}
				}
			});
		} else if (role.equals("leader")) {
			form_Leader_Dashboard = new Form_Leader_Dashboard();
			form_Leader_MyProfile = new Form_Leader_MyProfile(idUserLogin);
			form_General_MySalary = new Form_General_MySalary();
			form_Leader_Employees = new Form_Leader_Employees();
			form_General_Schedules  = new Form_General_Schedules();
			form_Leader_LeavesOfAbsenca = new Form_Leader_LeavesOfAbsenca();
			menu.addEvent(new EventMenuSelected() {
				@Override
				public void menuSelected(int menuIndex, int subMenuIndex) {
					System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
					if (menuIndex == 0) {
						main.showForm(form_Leader_Dashboard);
					}
					if (menuIndex == 1) {
						main.showForm(form_Leader_MyProfile);
					}
					if (menuIndex == 2) {
						main.showForm(form_General_MySalary);
					}
					if (menuIndex == 3) {
						if (subMenuIndex == 0) {
							main.showForm(form_Leader_Employees);
						}
						
						if (subMenuIndex == 1) {
							main.showForm(form_General_Schedules);
						}
						if (subMenuIndex == 2) {
							main.showForm(form_Leader_LeavesOfAbsenca);
						}
					}
					if (menuIndex == 4) {
						// report
					}
					if (menuIndex == 5) {
						// message
					}
				}
			});
		} else if (role.equals("employee")) {
			form_Employee_Dashboard = new Form_Employee_Dashboard();
			form_Employee_Check_In_Out = new Form_Employee_Check_In_Out();
			form_Employee_MyProfile = new Form_Employee_MyProfile(idUserLogin);
			form_Employee_MyAttendances = new Form_Employee_MyAttendances();
			form_General_Schedules = new Form_General_Schedules();
			form_Employee_MyLeave = new Form_Employee_MyLeave();
			form_General_MySalary = new Form_General_MySalary();
			menu.addEvent(new EventMenuSelected() {
				@Override
				public void menuSelected(int menuIndex, int subMenuIndex) {
					System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
					if (menuIndex == 0) {
						main.showForm(form_Employee_Dashboard);
					}
					if (menuIndex == 1) {
						main.showForm(form_Employee_Check_In_Out);
					}
					if (menuIndex == 2) {
						main.showForm(form_Employee_MyProfile);
					}
					if (menuIndex == 3) {
						main.showForm(form_Employee_MyAttendances);
					}
					if (menuIndex == 4) {
						main.showForm(form_General_Schedules);
					}
					if (menuIndex == 5) {
						main.showForm(form_Employee_MyLeave);
					}
					if (menuIndex == 6) {
						main.showForm(form_General_MySalary);
					}
					if (menuIndex == 7) {
						// main.showForm(new Form_Employee_MySchedules()); report
					}
					if (menuIndex == 8) {
						// main.showForm(new Form_Employee_MySchedules()); message
					}
				}
			});
		}
		if (role.equals("admin")) {
			menu.initMenuItem();
			// Start with this form
			main.showForm(new Form_Admin_Dashboard());
		} else if (role.equals("leader")) {
			menu.initMenuItemLeader();
			// Start with this form
			main.showForm(new Form_Leader_Dashboard());
		} else if (role.equals("employee")) {
			menu.initMenuItemEmployee();
			// Start with this form
			main.showForm(new Form_Employee_Dashboard());
		}
	}

	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Application().setVisible(true);
			}
		});
	}
	public static boolean showMessageWarning(String message) {
        Message obj = new Message(Main.getFrames()[0], true,"WARNING");
        obj.showMessage(message);
        return obj.isOk();
    }
	
	public static boolean showMessageError(String message) {
        Message obj = new Message(Main.getFrames()[0], true,"ERROR");
        obj.showMessage(message);
        return obj.isOk();
    }
	
	public static boolean showMessageSucces(String message) {
        Message obj = new Message(Main.getFrames()[0], true,"SUCCESS");
        obj.showMessage(message);
        return obj.isOk();
    }

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private gui.swing.login.Background background1;
	private gui.swing.login.Button cmdSignIn;

	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
//	private com.raven.swing.PanelTransparent panelBody;
	private javax.swing.JPanel panelLogin;
	private gui.swing.login.PasswordField txtPass;
	private gui.swing.login.TextField txtUser;
	// End of variables declaration//GEN-END:variables

	private MigLayout layout;
	private Menu menu;
	private Header header;
	public static MainForm main;
	private Animator animator;
	private static String roleLogin;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLayeredPane bg;
	// End of variables declaration//GEN-END:variables
	
	
	public static Form_Admin_Attendances form_Admin_Attendances;
	public static Form_Admin_Dashboard form_Admin_Dashboard;
	public static Form_Admin_Employees form_Admin_Employees;
	public static Form_Admin_LeavesOfAbsence form_Admin_LeavesOfAbsence;
	public static Form_Admin_Salary form_Admin_Salary;
	public static Form_Admin_Schedules_Edit form_Admin_Schedules_Edit;
	public static Form_Admin_Schedules form_Admin_Schedules;
	public static Form_Admin_Attendances_Edit form_Admin_Attendances_Edit;
	public static Form_Admin_Employee_AddNew form_Admin_Employee_AddNew;
	public static Form_Admin_Employee_Edit form_Admin_Employee_Edit;
	public static Form_Admin_Employee_ViewProfile form_Admin_Employee_ViewProfile;
	
	
	public static Form_Employee_Check_In_Out form_Employee_Check_In_Out;
	public static Form_Employee_Dashboard form_Employee_Dashboard;
	public static Form_Employee_MyAttendances form_Employee_MyAttendances;
	public static Form_Employee_MyLeave form_Employee_MyLeave;
	public static Form_Employee_MySchedules form_Employee_MySchedules;
	public static Form_Employee_EditMyProfile form_Employee_EditMyProfile;
	public static Form_Employee_MyProfile form_Employee_MyProfile;
	
	public static Form_General_MySalary form_General_MySalary;
	public static Form_General_Schedules form_General_Schedules;
	public static Form_General_Report form_General_Report;
	
	public static Form_Leader_Attendances_Edit form_Leader_Attendances_Edit;
	public static Form_Leader_Employee_AddNew form_Leader_Employee_AddNew;
	public static Form_Leader_MyProfile form_Leader_MyProfile;
	public static Form_Leader_Attendances form_Leader_Attendances;
	public static Form_Leader_Dashboard form_Leader_Dashboard;
	public static Form_Leader_Employees form_Leader_Employees;
	public static Form_Leader_LeavesOfAbsenca form_Leader_LeavesOfAbsenca;
	public static Form_Leader_EditMyProfile form_Leader_EditMyProfile;
	public static Form_Leader_Employee_Edit form_Leader_Employee_Edit;
	public static Form_Leader_Employee_ViewProfile form_Leader_Employee_ViewProfile;
	
}