package MiniProject_1_complite;

import java.util.Scanner;

public class Smartphone {

	Scanner sc = new Scanner(System.in);
	Addr [] addrarry = new Addr[10];
	
	int max_count = 0;
	
	Addr insertinto() {
		
		System.out.print("이름을 입력하세요 : "); String name = sc.next();
		System.out.print("번호를 입력하세요 : "); String no = sc.next();
		System.out.print("이메일을 입력하세요 : "); String email = sc.next();
		System.out.print("주소를 입력하세요 : "); String address = sc.next();
		System.out.print("그룹을 입력하세요 : "); String group = sc.next();
		System.out.println("");
		
		return new Addr(name, no, email, address, group);
	}
	
	void create(Addr object) {
		
		addrarry[max_count] = object;
		max_count += 1;
		
		System.out.println("객체 " + max_count + "개가 생성이 완료 되었습니다.");
	}
	
	void search_all() {
		
		for(int i = 0; i<max_count; i++) {
			
			printinfo(addrarry[i]);
		}
	}
	
	void search_cho(String name) {
		
		for(int i = 0; i<max_count; i++) {
			
			if(addrarry[i].getname().equals(name)) {
				
				printinfo(addrarry[i]);
				System.out.println("검색이 완료되었습니다.");
				return;
			}
		} System.out.println("검색 결과가 없습니다.");
	}
	
	void delete(String name) {
		
		for(int i = 0; i < max_count; i++) {
			
			if(addrarry[i].getname().equals(name)) {
				
				for(int j = i; j<max_count; j++) {
					
					if(j == max_count -1) {
						
						addrarry[j] = null;
						return;
						
					} else {
						addrarry[j] = addrarry[j+1];
					}
				}
			}
		}
	}
	
	void edit(String name) {
		
		for(int i=0; i<max_count; i++) {
			
			if(addrarry[i].getname().equals(name)) {
				
				addrarry[i] = insertinto();
				System.out.println("수정이 완료되었습니다.");
				return;
			}
		}
	}
	
	/* 이거 하나 물어보기 */
	void printinfo(Addr object) {
		
		System.out.println("이름 : " + object.getname());
		System.out.println("번호 : " + object.getno());
		System.out.println("이메일 : " + object.getemail());
		System.out.println("이메일 : " + object.setaddress());
		System.out.println("이메일 : " + object.getgorup());
		System.out.println();
	}
}
