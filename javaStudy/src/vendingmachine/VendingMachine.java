package vendingmachine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
	int process = 1; // 프로세스 순서 1번 사장돈투입 2번 아이템생성 3번 손님돈 4번 물건구입 5번 잔돈
	int cusMoneyTotal = 0;
	HashMap<Integer, Integer> vendingMoney = new HashMap<Integer, Integer>(); // 기계에 있는 돈 금액,수량
	HashMap<String, String[]> item = new HashMap<String, String[]>();; // 기계에 품목이름 / 가격,재고
	String[] permitValue; // 스캐너에 허용값 설정
	String lastScanner; // 마지막 스캐너에 내용
	
	Scanner scanner = new Scanner(System.in);
	

	public VendingMachine(String[] permitValue) {
		this.permitValue = permitValue;
		for (int i = 0; i < permitValue.length; i++) {
			vendingMoney.put(Integer.parseInt(permitValue[i]), 0);
		}
		System.out.println("(자판기 설명) 다음단계로 갈려고 할경우는 '다음',그 전단계로 가고싶은 경우는 '이전'을 입력해주세요.");
		System.out.println("(자판기 설명) 자판기안에 있는 돈 확인하고 싶으면 '자판기'");
		

		proContlloer(); // 실행기

	}
	
	public void proContlloer() {

		switch (process) {
		case 1:
			System.out.println("(자판주) 자판기에 돈을 넣어서 거스름돈을 만드세요");
			if(scannerValueCheck("숫자 또는 우리나라 화폐만 넣으세요")) {
				moneyPutin(vendingMoney);
			}
			proContlloer();
			break;
		case 2:
			System.out.println("(자판주) 자판기에 아이템과 가격 재고를 넣어주세요");
			System.out.println("(자판주) 넣는 방식은 아이템이름:가격:재고 입니다.");
			if(scannerValueCheck("눈 없냐 위에 설명보고 만들어라")) {
				itemExcute();
			}
			proContlloer();		
			break;
		case 3:
			System.out.println("손님 돈넣어");
			if(scannerValueCheck("숫자 또는 우리나라 화폐만 넣으세요")) {
				cusMoneyTotal += Integer.parseInt(lastScanner);
				moneyPutin(vendingMoney);
			}
			proContlloer();
			break;
		case 4:
			System.out.println("사고 싶은 아이템을 선택해주세요!");
			if(scannerValueCheck("해당 품목은 없단다^^")) {
				itemBuy();
			}
			proContlloer();
			break;
		case 5:
			System.out.println("좋은 거래였다!");
			moneyChange();
			process = 3;
			proContlloer();
			break;
		}

	}
	
	public void itemBuy() {
		
		String[] valueArr = item.get(lastScanner);
		
		//  재고가 있는경우
		if(Integer.parseInt(valueArr[1]) > 0) {
			// 물건이 손님이 가지고 있는 돈보다 작거나같은경우 그리고 해당 물품에
			if(Integer.parseInt(valueArr[0]) <= cusMoneyTotal) {
				// 아이템계산
				valueArr[1] = String.valueOf((Integer.parseInt(valueArr[1])-1));
				item.put(lastScanner,valueArr );

				cusMoneyTotal = cusMoneyTotal - Integer.parseInt(valueArr[0]);
				System.out.println("옛다\""+lastScanner+"\"이거나 먹어라");
			}else {
				System.out.println("돈도 없는놈이");
			}
		}else {
			System.out.println("스미마센 해당하는 물품은 품절입니다.");
		}

		
	}
	
	public boolean keyController(String input) {
		
		switch (input) {
		case "다음":
			process++;
			return true;
		case "이전":
			process--;
			return true;
		case "자판기":
			moneyConfirm(vendingMoney,"사장님");
			return true;
		case "리스트":
			itemConfirm();
			return true;
		case "총돈":
			System.out.println("총 남은돈은:"+cusMoneyTotal);
			return true;
		default:
			break;
		}
		return false;
	}
	
	public void itemConfirm() {
		Iterator<String> iterator = item.keySet().iterator();
		System.out.println("자판기에 있는 목록입니다.");
		while (iterator.hasNext()) {
			String key = iterator.next();
			String[] valueArr = item.get(key);
			System.out.printf("품명:%s, 가격:%s, 재고:%s\n",key,valueArr[0],valueArr[1]);
		}
	}
	
	public void moneyConfirm(HashMap<Integer, Integer> map,String str) {
		Iterator<Integer> iterator = map.keySet().iterator();
		int mapSum = 0;
		while (iterator.hasNext()) {
			int key = iterator.next();
			int valueArr = map.get(key);
			mapSum += key*valueArr;
			if(valueArr != 0 ) {
				System.out.printf("자판기의 투입한 %s에 돈 %d원,%d개입니다.\n",str,key,valueArr);
			}
		}
		System.out.printf("자판기에 있는 %s돈은 총 %d입니다.\n",str,mapSum);
	}
	
	public void moneyChange() {
		
		TreeMap<Integer, Integer> tempMap = new TreeMap<Integer, Integer>();
		
		for (int i = 0; i < permitValue.length; i++) {
			// 몫 : changeMoney/chnag
			int mok = cusMoneyTotal/Integer.parseInt(permitValue[i]);
			int namage = cusMoneyTotal%Integer.parseInt(permitValue[i]);
			if(mok >= 1) {
				cusMoneyTotal = cusMoneyTotal%Integer.parseInt(permitValue[i]);
				tempMap.put(Integer.parseInt(permitValue[i]), mok);
			}
		}
		
		Iterator<Integer> iterator = tempMap.descendingKeySet().iterator();
		
		while(iterator.hasNext()) {
			Integer key =iterator.next();
			Integer value = tempMap.get(key);
			vendingMoney.put(key, vendingMoney.get(key)-value);
			System.out.printf("거스름돈 %d원짜리 %d를 받았습니다.\n",key,value);
		}
		
	}
	
	public void moneyPutin(HashMap<Integer, Integer> map) {
		map.put(Integer.parseInt(lastScanner), map.get(Integer.parseInt(lastScanner))+1);
	}
	
	// 스캐너에 받은 값이 이상할시 경고문을 띄운다.
	public boolean scannerValueCheck(String str) {
		lastScanner = scanner.nextLine();
		
		// 키가 다음 또는 이전 또는 명령어
		if(keyController(lastScanner)) {
			return false;
		}else {
			if(process == 1 || process == 3) {
				
				for (int i = 0; i < permitValue.length; i++) {
					if(lastScanner.equals(permitValue[i])) {
						return true;
					}
				}
			}else if(process == 2) {
				int pipeSu = charChk(lastScanner,':');
				if(pipeSu != 2) {
					System.out.println(str);
					return false;
				}

				// 문자형 숫자형 일치 여부 확인
				String[] strArr = lastScanner.split(":");

				if(strNumChk(strArr[1]) && strNumChk(strArr[2])) {
					return true;
				}else {
					return false;
				}
			}else if(process == 4) {
				if(item.get(lastScanner)!= null) {
					return true;
				}
			}
			System.out.println(str);
			return false;	
		}
		
	}
	

	public void itemExcute() {
		String[] strArr = lastScanner.split(":");
		item.put(strArr[0], new String[]{strArr[1],strArr[2]});
	}
	
	// 문자 갯수 체크
	public int charChk(String str,char chkStr) {
		int charChk = 0; 
		char[] strToChar = str.toCharArray();
		
		for(int i=0; i<strToChar.length; i++) {
			if(strToChar[i] == chkStr) {
				charChk++;
			}
		}
		return charChk;
	}
	
	// 숫자 체크
	public boolean strNumChk(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c < 48 || c > 57) { // 숫자가 아닌경우
				System.out.println("숫자가 아닙니다.");
				return false;
			}
		}
		return true;
	}
	
}
