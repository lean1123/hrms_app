package gui.model;

import javax.swing.Icon;

import gui.swing.table.ModelProfile;

public class ModelAttendance {

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

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public ModelAttendance() {
    }

	public ModelAttendance(Icon icon, String name, String type, String time) {
		super();
		this.icon = icon;
		this.name = name;
		this.type = type;
		this.time = time;
	}

	private Icon icon;
    private String name;
    private String type;
    private String time;

    public Object[] toRowTable() {
        return new Object[]{new ModelProfile(icon, name), type, time};
    }
}
