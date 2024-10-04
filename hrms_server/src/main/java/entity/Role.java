package entity;

import java.io.Serializable;

public enum Role implements Serializable{
	EMPLOYEE("Employee"), LEADER("Leader"), MANAGER("Manager");

	private String name;

	public String getName() {
		return name;
	}

	private Role(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
