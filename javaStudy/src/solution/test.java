package solution;

import java.util.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int chkCount = scanner.nextInt();
        
        Scanner scanner2 = new Scanner(System.in);
        String scannerValue = scanner2.nextLine();
        
        String[] scannerValueArr = scannerValue.split(" ");
        if(scannerValueArr.length != chkCount) {
        	System.exit(1);

        }
        ArrayList<Integer> numberArr = new ArrayList<Integer>();
        
        for (int i = 0; i < scannerValueArr.length; i++) {
			if(strNumChk(scannerValueArr[i])) {
				int vailNumber = Integer.parseInt(scannerValueArr[i]);
				if(vailNumber >= -1000 && vailNumber <= 1000) {
					numberArr.add(vailNumber);
				}
			}
		}
        
        if(numberArr.size() < 3) {
        	System.out.println("-1");
        }else {
        	Collections.sort(numberArr, new AscendingInteger());
            int result = 1;
            for (int i = 0; i < 3; i++) {
				result = result*numberArr.get(i);
			}
            System.out.println(result);
        }
        
    }
    

	public static boolean strNumChk(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if((c < 48 || c > 57) && c != '-') { // 숫자가 아닌경우
				return false;
			}
		}
		return true;
	}
}

class AscendingInteger implements Comparator<Integer> { 
	@Override 
	public int compare(Integer a, Integer b) { 
		int absA = Math.abs(a);
		int absB = Math.abs(b);
		
		if(absA >= absB) {
			return a.compareTo(b);
		}else {
			return b.compareTo(a);
		}
		 
	} 
} 

