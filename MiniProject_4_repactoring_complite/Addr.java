package MiniProject_4_repactoring_complite;

import java.util.*;
import java.util.List;

import Temp_noremove.Student;

public class Addr {

	private String name;
	private String no;
	private String mail;
	private String address;
	private String group;
	
	
	public Addr(String name, String no, String mail, String address, String group) {
		
		this.name = name;
		this.no = no;
		this.mail = mail;
		this.address = address;
		this.group = group;
	}
	
	public Addr(String no) {
		
		this.no = no;
	}
	
	public void printinfo(List<Addr> splist, int i) {
		
		System.out.println("이름 : " + splist.get(i).getname());
		System.out.println("번호 : " + splist.get(i).getno());
		System.out.println("메일 : " + splist.get(i).getmail());
		System.out.println("주소 : " + splist.get(i).getaddress());
		System.out.println("그룹 : " + splist.get(i).getgroup());
	}
	
	public String getname() {
		
		return this.name;
	}
	
	public String getno() {
		
		return this.no;
	}
	
	public String getmail() {
		
		return this.mail;
	}
	
	public String getaddress() {
		
		return this.address;
	}
	
	public String getgroup() {
		
		return this.group;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Addr) {
			Addr student = (Addr) obj;
			return this.no.contentEquals(student.no);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {		// 오버라이딩을 하지 않았을 경우 기본적으로 객체의 주소 값을 가지고 해쉬값을 가짐.
		
		System.out.printf("Addr : Addr 클래스 패이지 내 해쉬 코드 값 : %d \n", no.hashCode());
		return no.hashCode();
	}
}