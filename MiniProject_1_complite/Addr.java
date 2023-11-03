package MiniProject_1_complite;

public class Addr {

	private String name;
	private String no;
	private String email;
	private String address;
	private String group;
	
	public Addr(String name, String no, String email, String address, String group) {
		
		this.name = name;
		this.no = no;
		this.email = email;
		this.address = address;
		this.group = group;
	}
	
	void setname(String name) {
		
		this.name = name;
	}
	
	String getname() {
		
		return this.name;
	}
	
	void setno(String no) {
		
		this.no = no;
	}
	
	String getno() {
		
		return this.no;
	}
	
	void setemail(String email) {
		
		this.email = email;
	}
	
	String getemail() {
		
		return this.email;
	}
	
	void setaddress(String address) {
		
		this.address = address;
	}
	
	String setaddress() {
		
		return this.address;
	}
	
	void setgroup(String group) {
		
		this.group = group;
	}
	
	String getgorup() {
		
		return this.group;
	}
}
