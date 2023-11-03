package MiniProject_2_inheritance_complite;

import java.util.*;
import java.util.Scanner;


public class Smartphone {

	Scanner sc = new Scanner(System.in);
	
	Addr [] addrarry = new Addr[10];
	int max=0;
	
	String data[] = new String[3];
	
	Addr insertinto(int num) {
				
		System.out.print("이름을 입력하세요 : "); String name = sc.next();
		System.out.print("번호를 입력하세요 : "); String no = sc.next();
		System.out.print("이메일을 입력하세요 : "); String email = sc.nextLine();
		System.out.print("주소를 입력하세요 : "); String address = sc.nextLine();
		System.out.print("생일를 입력하세요 : "); String Birthday = sc.nextLine();
		System.out.print("그룹을 입력하세요 : "); String group = sc.nextLine();
		
		if(num == 1) {
			
			insertCompany();
			return (Addr) new CompanyAddr(name, no, email, address, Birthday, group, data[0],data[1], data[2]);
			
		} else {
			
			insertCustomer();
			return (Addr) new CustomerAddr(name, no, email, address, Birthday, group, data[0],data[1], data[2]);
		}
	}
	
	void insertCompany() {
		
		System.out.print("회사이름을 입력하세요 : ");	data[0] = sc.nextLine();
		System.out.print("부서이름을 입력하세요 : ");	data[1] = sc.nextLine();
		System.out.print("직급을 입력하세요 : ");		data[2] = sc.nextLine();
		
	}
	
	void insertCustomer() {
		
		System.out.print("거래처 이름을 입력하세요 : ");	data[0] = sc.nextLine();
		System.out.print("품목 이름을 입력하세요 : ");	data[1] = sc.nextLine();
		System.out.print("직급을 입력하세요 : ");		data[2] = sc.nextLine();
		
	}
	
	
	void create(Addr objects) {		// 데이터 관리 편하게 하기 위해 CompanyAddr와 CustomerAddr 모두 Addr 참조변수에 저장.
		
		addrarry[max] = objects;
		max += 1;
	
		System.out.println("객체 " + max + "개가 생성이 완료 되었습니다.");
	}
	
	void search_all() {
		
		for(int i = 0; i<max; i++) {
			
			System.out.println("----------------\n");
			printinfo(addrarry[i]);
		}
	}
	
	void search_cho(String name) {
		
		System.out.println("================\n");
		
		for(int i = 0; i<max; i++) {
			
			if(addrarry[i].getname().equals(name)) {
				
				printinfo(addrarry[i]);
				System.out.println("검색이 완료되었습니다.");
				return;
			}
		} System.out.println("검색 결과가 없습니다.");
	}
	
	void delete(String name) {
		
		for(int i = 0; i < max; i++) {
			
			if(addrarry[i].getname().equals(name)) {
				
				for(int j = i; j<max; j++) {
					
					if(j == max -1) {
						
						addrarry[j] = null;
						max -= 1;
						
						System.out.println("삭제가 완료되었습니다.");
						return;
						
					} else {
						addrarry[j] = addrarry[j+1];
					}
				}
			}
		}
		System.out.println("찾으시는 이름이 없습니다.");
	}
	
	void edit(String name) {
		
		for(int i=0; i<max; i++) {
			
			if(addrarry[i].getname().equals(name)) {
				
				addrarry[i] = insertinto(0);
								
				System.out.println("수정이 완료되었습니다.");
				return;
			}
		}
	}
	
	
	void printinfo(Addr object) {
		
		System.out.println("이름 : " + object.getname());
		System.out.println("번호 : " + object.getno());
		System.out.println("이메일 : " + object.getemail());
		System.out.println("주소 : " + object.getaddress());
		System.out.println("생일 : " + object.getBirthday());
		System.out.println("그룹 : " + object.getgorup());
		
		if(object instanceof CompanyAddr) {
			
			CompanyAddrInfo((CompanyAddr) object);
		} else {
			
			CustomerAddrInfo((CustomerAddr) object);
		}
		
		System.out.println();
	}
	
	void CompanyAddrInfo(CompanyAddr object) {	
		
		System.out.println("회사 이름 : " + object.getCompanyName());
		System.out.println("부서 이름 : " + object.getDepartName());
		System.out.println("직급 명 : " + object.getRank());
	}
	
	void CustomerAddrInfo(CustomerAddr object) {
		
		System.out.println("거래처 이름 : " + object.getAccountName());
		System.out.println("거래품목 이름 : " + object.getItem());
		System.out.println("직급 명 : " + object.getRank());
	}
}