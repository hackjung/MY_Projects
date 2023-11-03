package MiniProject_4_repactoring_complite;

import java.util.Scanner;

public class Smartphonemain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Smartphone sp = new Smartphone();
		
		
		while(true) {
			
			Smartphonemain.printmenu();
			System.out.print("\n원하는 메뉴를 번호를 통해 선택하세요. : "); int num = sc.nextInt();
			System.out.println();
			
			switch(num) {
			
				case 1:
					System.out.println("연락처를 등록합니다.");
					sp.addAddr(sp.inputdata());
					break;
					
				case 2:
					System.out.println("모든 연락처를 검색합니다.");
					sp.search_all();
					break;
					
				case 3:
					System.out.println("연락처를 검색합니다, 이름을 입력하세요 : "); String name = sc.next();
					sp.serach_index(name);
					break;
					
				case 4:
					System.out.println("연락처를 삭제합니다, 이름을 입력하세요 : "); String name2 = sc.next();
					sp.delete(name2);
					break;
				case 5:
					System.out.println("연락처를 수정합니다, 원하는 이름을 입력하세요 : "); String name3 = sc.next();
					System.out.println("원하는 사람에 대한 정보를 출력합니다");
					sp.serach_index(name3); System.out.println();
					sp.correction(name3);
					break;
				case 6:
					System.out.println("프로그램 종료합니다.");
					return;
					
				default :
					System.out.println("잘못 입력하셨습니다. 다시 입력하세요!");
			}	
		}
	}
	
	static void printmenu() {
		
		System.out.println("========================================");
		System.out.println(">>1. 연락처 등록\n>>2. 모든 연락처 검색\n>>3. 연락처 검색\n>>4. 연락처 삭제\n>>5. 연락처 수정\n>>6. 프로그램 종료");
	}
}
