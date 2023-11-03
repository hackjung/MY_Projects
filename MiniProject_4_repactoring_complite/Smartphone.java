package MiniProject_4_repactoring_complite;

import java.util.*;
import java.util.Map.Entry;

public class Smartphone {

	Scanner sc = new Scanner(System.in);

	List<Addr> splist = new ArrayList<Addr>();
//	Map<Addr, String> noMap = new HashMap<>();
	
	Map<Addr, String> noMap = new HashMap<Addr, String>();
	
	int MapSize = 0;
	
	/* 연락처를 추가할 때 실제로 Addr 객체 내 들어갈 데이터와 생성자를 호출하여 반환 하는 함수 */
	Addr inputdata() {
		
		System.out.print("이름을 입력하세요 : "); String name = sc.next();
		String no = InNo();
		System.out.print("메일를 입력하세요 : "); String mail = sc.next();
		System.out.print("주소를 입력하세요 : "); String address = sc.next();
		System.out.print("그룹을 입력하세요 : "); String group = sc.next();
		
		return new Addr(name, no, mail, address, group);
	}
	
	String InNo() {
			
		while(true) {
			
			System.out.print("번호를 입력하세요 : "); String No = sc.next();		// 이름 입력
			
			if(noMap.containsKey(new Addr(No))) 
				System.out.println("이미 동일한 연락처가 입력 되어 있으니 재 입력 바랍니다.");
			 else { noMap.put( new Addr(No), No); return No; }
		}
	}
	
	void addAddr(Addr object){
				
		splist.add(object);
		System.out.println("데이터가 저장되었습니다! " + splist.size());
	}
	
	/* 모든 연락처를 검색합니다. */
	void search_all() {
		
		int count = 0;
		
		for(int i = 0; i<splist.size(); i++) {
			
			splist.get(i).printinfo(splist, i);
			System.out.println();
			count += 1;
		}
		
		System.out.println("\n총 " + count + "명이 검색되었습니다.");
	}
	
	/* 매개변수 name 으로 전달받은 이름에만 해당하는 객체 검색 */
	void serach_index(String name) {
		
		for(int i=0; i<splist.size(); i++) {
			
			if(splist.get(i).getname().equals(name)) {
				
				splist.get(i).printinfo(splist, i);
				return;
			}	
		}
		System.out.println("찾으시는 이름이 없습니다. 다시 확인해 주세요");
	}
	
	/* 선택한 이름의 배열을 삭제함과 동시에 생기는 빈 공간을 들여쓰기 하기 */
	void delete(String name) {
		
		for(int i = 0; i<splist.size(); i++) {
			
			if(splist.get(i).getname().equals(name)) {
				
				splist.remove(i);
				System.out.println("삭제 되었습니다.");
				
				return;
			}
		}
		System.out.println("찾으시는 이름이 없습니다. 확인 후 다시 삭제해 주세요");
	}
	
	/* 원하는 이름애 대한 객체를 배열 내 찾아서 다시 입력 시키기 */
	void correction(String name) {
		
		for(int i = 0; i<splist.size() ; i++ ) {
			
			if(splist.get(i).getname().equals(name)) {
				
				splist.add(i, inputdata());
				splist.remove(i+1);
				System.out.println("수정이 완료되었습니다");
				break;
			}
		}
		System.out.println("수정을 원하는 대상이 존재하지 않습니다.");
	}
}
