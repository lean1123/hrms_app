package gui.model;

import javax.swing.Icon;

import gui.swing.table.ModelProfile;

public class ModelEmployee1 {
	private String id;
	private Icon icon;
	private String name;
	private String company;
	private String department;
	private String position;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Icon getIcon() {
		return icon;
	}
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ModelEmployee1(String id, Icon icon, String name, String company, String department, String position,
			String status) {
		super();
		this.id = id;
		this.icon = icon;
		this.name = name;
		this.company = company;
		this.department = department;
		this.position = position;
		this.status = status;
	}
	public ModelEmployee1() {
		super();
	}
	
	public Object[] toRowTable() {
        return new Object[]{id,new ModelProfile(icon, name), company, department, position, status};
    }
}
