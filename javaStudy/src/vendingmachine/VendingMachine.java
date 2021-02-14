package vendingmachine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
	int process = 1; // ���μ��� ���� 1�� ���嵷���� 2�� �����ۻ��� 3�� �մԵ� 4�� ���Ǳ��� 5�� �ܵ�
	int cusMoneyTotal = 0;
	HashMap<Integer, Integer> vendingMoney = new HashMap<Integer, Integer>(); // ��迡 �ִ� �� �ݾ�,����
	HashMap<String, String[]> item = new HashMap<String, String[]>();; // ��迡 ǰ���̸� / ����,���
	String[] permitValue; // ��ĳ�ʿ� ��밪 ����
	String lastScanner; // ������ ��ĳ�ʿ� ����
	
	Scanner scanner = new Scanner(System.in);
	

	public VendingMachine(String[] permitValue) {
		this.permitValue = permitValue;
		for (int i = 0; i < permitValue.length; i++) {
			vendingMoney.put(Integer.parseInt(permitValue[i]), 0);
		}
		System.out.println("(���Ǳ� ����) �����ܰ�� ������ �Ұ��� '����',�� ���ܰ�� ������� ���� '����'�� �Է����ּ���.");
		System.out.println("(���Ǳ� ����) ���Ǳ�ȿ� �ִ� �� Ȯ���ϰ� ������ '���Ǳ�'");
		

		proContlloer(); // �����

	}
	
	public void proContlloer() {

		switch (process) {
		case 1:
			System.out.println("(������) ���Ǳ⿡ ���� �־ �Ž������� ���弼��");
			if(scannerValueCheck("���� �Ǵ� �츮���� ȭ�� ��������")) {
				moneyPutin(vendingMoney);
			}
			proContlloer();
			break;
		case 2:
			System.out.println("(������) ���Ǳ⿡ �����۰� ���� ��� �־��ּ���");
			System.out.println("(������) �ִ� ����� �������̸�:����:��� �Դϴ�.");
			if(scannerValueCheck("�� ���� ���� ������ ������")) {
				itemExcute();
			}
			proContlloer();		
			break;
		case 3:
			System.out.println("�մ� ���־�");
			if(scannerValueCheck("���� �Ǵ� �츮���� ȭ�� ��������")) {
				cusMoneyTotal += Integer.parseInt(lastScanner);
				moneyPutin(vendingMoney);
			}
			proContlloer();
			break;
		case 4:
			System.out.println("��� ���� �������� �������ּ���!");
			if(scannerValueCheck("�ش� ǰ���� ���ܴ�^^")) {
				itemBuy();
			}
			proContlloer();
			break;
		case 5:
			System.out.println("���� �ŷ�����!");
			moneyChange();
			process = 3;
			proContlloer();
			break;
		}

	}
	
	public void itemBuy() {
		
		String[] valueArr = item.get(lastScanner);
		
		//  ��� �ִ°��
		if(Integer.parseInt(valueArr[1]) > 0) {
			// ������ �մ��� ������ �ִ� ������ �۰ų�������� �׸��� �ش� ��ǰ��
			if(Integer.parseInt(valueArr[0]) <= cusMoneyTotal) {
				// �����۰��
				valueArr[1] = String.valueOf((Integer.parseInt(valueArr[1])-1));
				item.put(lastScanner,valueArr );

				cusMoneyTotal = cusMoneyTotal - Integer.parseInt(valueArr[0]);
				System.out.println("����\""+lastScanner+"\"�̰ų� �Ծ��");
			}else {
				System.out.println("���� ���³���");
			}
		}else {
			System.out.println("���̸��� �ش��ϴ� ��ǰ�� ǰ���Դϴ�.");
		}

		
	}
	
	public boolean keyController(String input) {
		
		switch (input) {
		case "����":
			process++;
			return true;
		case "����":
			process--;
			return true;
		case "���Ǳ�":
			moneyConfirm(vendingMoney,"�����");
			return true;
		case "����Ʈ":
			itemConfirm();
			return true;
		case "�ѵ�":
			System.out.println("�� ��������:"+cusMoneyTotal);
			return true;
		default:
			break;
		}
		return false;
	}
	
	public void itemConfirm() {
		Iterator<String> iterator = item.keySet().iterator();
		System.out.println("���Ǳ⿡ �ִ� ����Դϴ�.");
		while (iterator.hasNext()) {
			String key = iterator.next();
			String[] valueArr = item.get(key);
			System.out.printf("ǰ��:%s, ����:%s, ���:%s\n",key,valueArr[0],valueArr[1]);
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
				System.out.printf("���Ǳ��� ������ %s�� �� %d��,%d���Դϴ�.\n",str,key,valueArr);
			}
		}
		System.out.printf("���Ǳ⿡ �ִ� %s���� �� %d�Դϴ�.\n",str,mapSum);
	}
	
	public void moneyChange() {
		
		TreeMap<Integer, Integer> tempMap = new TreeMap<Integer, Integer>();
		
		for (int i = 0; i < permitValue.length; i++) {
			// �� : changeMoney/chnag
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
			System.out.printf("�Ž����� %d��¥�� %d�� �޾ҽ��ϴ�.\n",key,value);
		}
		
	}
	
	public void moneyPutin(HashMap<Integer, Integer> map) {
		map.put(Integer.parseInt(lastScanner), map.get(Integer.parseInt(lastScanner))+1);
	}
	
	// ��ĳ�ʿ� ���� ���� �̻��ҽ� ����� ����.
	public boolean scannerValueCheck(String str) {
		lastScanner = scanner.nextLine();
		
		// Ű�� ���� �Ǵ� ���� �Ǵ� ��ɾ�
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

				// ������ ������ ��ġ ���� Ȯ��
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
	
	// ���� ���� üũ
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
	
	// ���� üũ
	public boolean strNumChk(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c < 48 || c > 57) { // ���ڰ� �ƴѰ��
				System.out.println("���ڰ� �ƴմϴ�.");
				return false;
			}
		}
		return true;
	}
	
}
