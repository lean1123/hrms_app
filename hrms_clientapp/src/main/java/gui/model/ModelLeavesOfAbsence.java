package gui.model;

import javax.swing.Icon;

import gui.swing.table.ModelProfile;

public class ModelLeavesOfAbsence {
	private Icon icon;
	private String name;
	private String date;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ModelLeavesOfAbsence(Icon icon, String name, String date) {
		super();
		this.icon = icon;
		this.name = name;
		this.date = date;
	}
	public ModelLeavesOfAbsence() {
		super();
	}
	public Object[] toRowTable() {
        return new Object[]{new ModelProfile(icon, name), date};
    }
}
