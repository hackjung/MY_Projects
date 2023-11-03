package MiniProject_3_throw_Complete;

import java.util.*;
import java.util.Scanner;

public class Smartphone {

	Scanner sc = new Scanner(System.in);
	
	List <Addr> AddrArry = new ArrayList<Addr>();
	List <String> CompanyAddr = new ArrayList<String>();
	List <String> CustomerAddr = new ArrayList<String>();
	
	Addr insertinto(int num) {
				
		String name = InputName();
		String no = InputNumber();
		System.out.println("이메일을 입력하세요 : ");  String email = sc.nextLine();
		System.out.println("주소를 입력하세요 : ");   String address = sc.nextLine();
		System.out.println("생일를 입력하세요 : ");   String Birthday = sc.nextLine();
		System.out.println("그룹을 입력하세요 : ");   String group = sc.nextLine();
		
		if(num == 1) {
			
			insertCompany();
			return (Addr) new CompanyAddr(name, no, email, address, Birthday, group, CompanyAddr.get(0),CompanyAddr.get(1), CompanyAddr.get(2));
			
		} else {
			
			insertCustomer();
			return (Addr) new CustomerAddr(name, no, email, address, Birthday, group, CustomerAddr.get(0),CustomerAddr.get(1), CustomerAddr.get(2));
		}
	}
	
	String InputName() {
		
		String Name;
		Boolean bol1;
		Boolean bol2;
		
		while(true) {
			
			try {
				
				System.out.print("이름을 입력하세요 : "); Name = sc.nextLine();
				bol1 = BlankTest(Name);		// 공백 여부 검사
				bol2 = SpecialChar(Name);	// 이름 내 한글과 영문 외 다른 내용 검사.
				
				if(bol1 == true && bol2 == true) 
					return Name;
					
			} catch (BlankException e) {
				System.out.println(e.getMessage());
			} catch (SpecialChar e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	Boolean BlankTest(String Input) throws BlankException {
		
		char[] InputArry = Input.toCharArray();
		
		for(char t : InputArry) {
			
			if (t == ' ') 
				throw new BlankException("공백이 발생하였습니다.");
		}
		return true;
	}
	
	Boolean SpecialChar(String Input) throws SpecialChar {
		
		char[] InputArry = Input.toCharArray();
		String temp;
		
		for(char t : InputArry) {
			
			if(!(t >= 'A' && t <= 'Z') && !(t >= 'a' && t <= 'z')) {		// 해당 글자가 영어이거나
				temp = Character.toString(t);								// 해당 글자가 한글이거나
				if(temp.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {}
					else
						throw new SpecialChar("한글과 영문 외 다른 값이 입력되었습니다.");
			}
		}
		return true;
	}
	
	String InputNumber() {
		
		String No;
		String Pattern = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
		
		
		while(true) {
			
			System.out.print("번호를 입력하세요 : "); No = sc.nextLine();
			
			try {
				
				if(No.matches(Pattern) || No == " ")
					return No;
				else
					throw new NumberException("휴대전화 번호 형식에 맞지 않게 입력하셨습니다. 다시 입력하세요");
			} catch (NumberException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	void insertCompany() {
		
		System.out.print("회사이름을 입력하세요 : ");	CompanyAddr.add(sc.nextLine());
		System.out.print("부서이름을 입력하세요 : ");	CompanyAddr.add(sc.nextLine());
		System.out.print("직급을 입력하세요 : ");		CompanyAddr.add(sc.nextLine());
		
	}
	
	void insertCustomer() {
		
		System.out.print("거래처 이름을 입력하세요 : ");	CustomerAddr.add(sc.nextLine());
		System.out.print("품목 이름을 입력하세요 : ");	CustomerAddr.add(sc.nextLine());
		System.out.print("직급을 입력하세요 : ");		CustomerAddr.add(sc.nextLine());
		
	}
	
	
	void create(Addr objects) {		// 데이터 관리 편하게 하기 위해 CompanyAddr와 CustomerAddr 모두 Addr 참조변수에 저장.
		
		AddrArry.add(objects);
		CompanyAddr.clear(); CustomerAddr.clear();
		
		System.out.println("객체 " + AddrArry.size() + "개가 생성이 완료 되었습니다.");
	}
	
	void search_all() {
		
		for(int i = 0; i<AddrArry.size(); i++) {
			
			System.out.println("----------------\n");
			printinfo(AddrArry.get(i));
		}
	}
	
	void search_cho(String name) {
		
		System.out.println("================\n");
		
		for(int i = 0; i<AddrArry.size(); i++) {
			
			if(AddrArry.get(i).getname().equals(name)) {
				
				printinfo(AddrArry.get(i));
				System.out.println("검색이 완료되었습니다.");
				return;
			}
		} System.out.println("검색 결과가 없습니다.");
	}
	
	void delete(String name) {
		
		for(int i = 0; i < AddrArry.size(); i++) {
			
			if(AddrArry.get(i).getname().equals(name)) {
				
				AddrArry.remove(i);
				System.out.println("연락처를 삭제하였습니다.");
				return;
			}
		}
		System.out.println("찾으시는 이름이 없습니다.");
	}
	
	void edit(String name) {
		
		for(int i=0; i<AddrArry.size(); i++) {
			
			if(AddrArry.get(i).getname().equals(name)) {
				
				AddrArry.add(i, insertinto(0));
				AddrArry.remove(i+1);
				
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