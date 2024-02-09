package com.blueyonder.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="department")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int depid;
	private String depname;
	private String deplocation;
	
	@Override
	public String toString() {
		return "Department [depid=" + depid + ", depname=" + depname + ", deplocation=" + deplocation + "]";
	}

	public void setDeplocation(String deplocation2) {
		// TODO Auto-generated method stub
		this.deplocation = deplocation2;
	}
	
	public void setDepname(String depname2)
	{
		this.depname = depname2;
	}
	
	public void setDepid(int depid2) {
		this.depid=depid2;
	}
}
