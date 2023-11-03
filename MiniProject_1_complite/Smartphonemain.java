package MiniProject_1_complite;

import java.util.Scanner;

public class Smartphonemain {
	
	public static void main(String[] args) {
		
		Smartphone sp = new Smartphone();
		Scanner sc = new Scanner(System.in);
				
		System.out.println("두 명의 정보를 입력하세요");
		
		for(int i = 0; i<2; i++) {
			
			sp.create(sp.insertinto());
		}
		System.out.println("입력이 완료되었습니다.");
		
		while(true) {
			
			printmenu();
			System.out.print("원하는 메뉴를 선택 하세요"); int num = sc.nextInt();
			
			 String name = "";
			
			switch(num){
				
				case 1:
					System.out.println("연락처를 등록하겠습니다.");
					sp.create(sp.insertinto());
					break;
				
				case 2:
					System.out.println("모든 연락처를 검색하겠습니다. "); 
					sp.search_all();
					break;
					
				case 3 :
					System.out.print("연락처 검색하기 위해 이름을 입력하세요 : "); name = sc.next();
					sp.search_cho(name);
					break;
					
				case 4:
					System.out.print("삭제할 연락처의 이름을 하세요 : "); name = sc.next();
					sp.delete(name);
					break;
					
				case 5:
					System.out.print("수정할 연락처를 확인하기 위해 이름을 입력하세요 : "); name = sc.next();
					sp.search_cho(name);
					System.out.println("연락처를 수정하겠습니다.");
					sp.edit(name);
					break;
				case 6:
					System.out.println("프로그램을 종료하겠습니다.");
					return;
				default :
					System.out.println("잘못 선택 하셨습니다. 다시 선택 하세요");	
			}
		}
		
	}
	
	static void printmenu() {
		System.out.println("\n=====================");
		System.out.println(">>1. 연락처 등록\n>>2. 모든 연락처 검색\n>>3. 연락처 검색\n>>4. 연락처 삭제\n>>5. 연락처 수정\n>>6. 프로그램 종료");
		
	}
}
