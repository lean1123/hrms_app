package gui.main;

import gui.component.Header;
import gui.component.Menu;
import gui.event.EventMenuSelected;
import gui.event.EventShowPopupMenu;
import gui.form.Form_Admin_Attendances;
import gui.form.Form_Employee_Check_In_Out;
import gui.form.Form_Employee_Dashboard;
import gui.form.Form_Employee_MyAttendances;
import gui.form.Form_Employee_MyLeave;
import gui.form.Form_Employee_MySchedules;
import gui.form.Form_Leader_MyProfile;
import gui.form.Form_Leader_Attendances;
import gui.form.Form_Leader_Dashboard;
import gui.form.Form_Leader_Employees;
import gui.form.Form_Leader_LeavesOfAbsenca;
import gui.form.Form_General_Schedules;
import gui.form.Form_Admin_Dashboard;
import gui.form.Form_Admin_LeavesOfAbsence;
import gui.form.Form_Admin_Schedules;
import gui.form.Form_Admin_Employees;
import gui.form.MainForm;
import gui.swing.MenuItem;
import gui.swing.PopupMenu;
import gui.swing.icon.GoogleMaterialDesignIcons;
import gui.swing.icon.IconFontSwing;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

	private MigLayout layout;
	private Menu menu;
	private Header header;
	public static MainForm main;
	private Animator animator;
	private static String roleLogin;

	public Main() {
		initComponents();
		init("leader");
	}

	private void init(String role) {
		layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
		bg.setLayout(layout);
		// Init google icon font
		IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
		menu = new Menu();
		header = new Header();
		main = new MainForm();
		if (role.equals("admin")) {
			menu.addEvent(new EventMenuSelected() {
				@Override
				public void menuSelected(int menuIndex, int subMenuIndex) {
					System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
					if (menuIndex == 0) {
						main.showForm(new Form_Admin_Dashboard());
					}
					if (menuIndex == 1) {
						main.showForm(new Form_Admin_Employees());
					}
					if (menuIndex == 2) {
						main.showForm(new Form_Admin_Attendances());
					}
					if (menuIndex == 3) {
						main.showForm(new Form_Admin_Schedules());
					}
					if (menuIndex == 4) {
						main.showForm(new Form_Admin_LeavesOfAbsence());
					}
					if (menuIndex == 5) {
						// salary
					}
					if (menuIndex == 6) {
						// report
					}
					if (menuIndex == 7) {
						// message
					}
				}
			});
		} else if (role.equals("leader")) {
			menu.addEvent(new EventMenuSelected() {
				@Override
				public void menuSelected(int menuIndex, int subMenuIndex) {
					System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
					if (menuIndex == 0) {
						main.showForm(new Form_Leader_Dashboard());
					}
					if (menuIndex == 1) {
						main.showForm(new Form_Leader_MyProfile(1));
					}
					if (menuIndex == 2) {
						// salary
					}
					if (menuIndex == 3) {
						if (subMenuIndex == 0) {
							main.showForm(new Form_Leader_Employees());
						}
						if (subMenuIndex == 1) {
							main.showForm(new Form_Leader_Attendances());
						}
						if (subMenuIndex == 2) {
							main.showForm(new Form_General_Schedules());
						}
						if (subMenuIndex == 3) {
							main.showForm(new Form_Leader_LeavesOfAbsenca());
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
						main.showForm(new Form_Employee_Dashboard());
					}
					if (menuIndex == 1) {
						main.showForm(new Form_Employee_Check_In_Out());
					}
					if (menuIndex == 2) {
						main.showForm(new Form_Leader_MyProfile(1));
					}
					if (menuIndex == 3) {
						main.showForm(new Form_Employee_MyAttendances());
					}
					if (menuIndex == 4) {
						main.showForm(new Form_Employee_MySchedules());
					}
					if (menuIndex == 5) {
						main.showForm(new Form_Employee_MyLeave());
					}
					if (menuIndex == 6) {
						// main.showForm(new Form_Employee_MySchedules()); salay
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
		menu.addEventShowPopup(new EventShowPopupMenu() {
			@Override
			public void showPopup(Component com) {
				MenuItem item = (MenuItem) com;
				PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(),
						item.getMenu().getSubMenu());
				int x = Main.this.getX() + 52;
				int y = Main.this.getY() + com.getY() + 86;
				popup.setLocation(x, y);
				popup.setVisible(true);
			}
		});
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

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		bg = new javax.swing.JLayeredPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		bg.setBackground(new java.awt.Color(245, 245, 245));
		bg.setOpaque(true);

		javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
		bg.setLayout(bgLayout);
		bgLayout.setHorizontalGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
				1366, Short.MAX_VALUE));
		bgLayout.setVerticalGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 783,
				Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(bg));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(bg));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

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
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLayeredPane bg;
	// End of variables declaration//GEN-END:variables
}
