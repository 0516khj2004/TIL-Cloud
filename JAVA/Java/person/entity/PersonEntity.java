package workshop.person.entity;

public class PersonEntity {
	private String name;
	private char gender;
	private String ssn;
	private String address;
	private String phone; 
	
	public PersonEntity() {
		
	}
	
	public PersonEntity(String name, String ssn, String address, String phone) {
		this.name = name;
//		this.ssn = ssn;
		setSsn(ssn);
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
		char flag = this.ssn.charAt(6);
		
		if(flag == '1' || flag == '3') {
			setGender('³²');
		}else if(flag == '2' || flag == '4') {
			setGender('¿©');
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "PersonEntity [name=" + name + ", gender=" + gender + ", ssn=" + ssn + ", address=" + address
				+ ", phone=" + phone + "]";
	}
	
	
	
}
