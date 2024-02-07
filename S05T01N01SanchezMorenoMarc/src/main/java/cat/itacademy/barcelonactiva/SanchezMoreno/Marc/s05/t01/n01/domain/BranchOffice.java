package cat.itacademy.barcelonactiva.SanchezMoreno.Marc.s05.t01.n01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="branchOffices", uniqueConstraints = @UniqueConstraint(columnNames = "branchOfficeName"))
public class BranchOffice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String country;


	public int getId() {
		return id;
	}

	public void setId(int pk_BranchOfficeID) {
		this.id = pk_BranchOfficeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String branchOfficeName) {
		this.name = branchOfficeName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String branchOfficeCountry) {
		this.country = branchOfficeCountry;
	}

}
