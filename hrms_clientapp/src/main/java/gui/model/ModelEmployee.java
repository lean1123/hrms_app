package gui.model;

import gui.swing.table.ModelProfile;
import javax.swing.Icon;

public class ModelEmployee {


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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public ModelEmployee() {
    }
	
	

    public ModelEmployee(Icon icon, String name, String position, String startDate) {
		super();
		this.icon = icon;
		this.name = name;
		this.position = position;
		this.startDate = startDate;
	}



	private Icon icon;
    private String name;
    private String position;
    private String startDate;

    public Object[] toRowTable() {
        return new Object[]{new ModelProfile(icon, name), position, startDate};
    }
}
