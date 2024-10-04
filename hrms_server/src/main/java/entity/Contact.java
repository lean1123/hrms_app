package entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "contacts")
public class Contact implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String phone;
	
	private String email;
}
