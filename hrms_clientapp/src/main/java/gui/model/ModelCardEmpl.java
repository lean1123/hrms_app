package gui.model;

import javax.swing.Icon;

public class ModelCardEmpl {
    private String title;
    private String subTitle1;
    private String subTitle2;
    private String value1;
    private String value2;
    private Icon icon;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle1() {
		return subTitle1;
	}
	public void setSubTitle1(String subTitle1) {
		this.subTitle1 = subTitle1;
	}
	public String getSubTitle2() {
		return subTitle2;
	}
	public void setSubTitle2(String subTitle2) {
		this.subTitle2 = subTitle2;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public String getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	public Icon getIcon() {
		return icon;
	}
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	public ModelCardEmpl(String title, String subTitle1, String subTitle2, String value1, String value2, Icon icon) {
		super();
		this.title = title;
		this.subTitle1 = subTitle1;
		this.subTitle2 = subTitle2;
		this.value1 = value1;
		this.value2 = value2;
		this.icon = icon;
	}
	public ModelCardEmpl() {
		super();
	}
    
    
}
