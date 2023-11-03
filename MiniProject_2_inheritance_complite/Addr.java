package MiniProject_2_inheritance_complite;

public class Addr {

	private String name;
	private String no;
	private String email;
	private String address;
	private String Birthday;
	private String group;
	
	public Addr(String name, String no, String email, String address, String Birthday, String group) {
		
		this.name = name;
		this.no = no;
		this.email = email;
		this.address = address;
		this.Birthday = Birthday;
		this.group = group;
	}
	
	void setname(String name) {
		
		this.name = name;
	}
	
	public String getname() {
		
		return this.name;
	}
	
	void setno(String no) {
		
		this.no = no;
	}
	
	public String getno() {
		
		return this.no;
	}
	
	public void setemail(String email) {
		
		this.email = email;
	}
	
	public String getemail() {
		
		return this.email;
	}
	
	public void setaddress(String address) {
		
		this.address = address;
	}
	
	public String getaddress() {
		
		return this.address;
	}
	
	
	void setBirthday(String Birthday) {
		
		this.Birthday = Birthday;
	}
	
	public String getBirthday() {
		
		return this.Birthday;
	}
	
	void setgroup(String group) {
		
		this.group = group;
	}
	
	public String getgorup() {
		
		return this.group;
	}
	
}
