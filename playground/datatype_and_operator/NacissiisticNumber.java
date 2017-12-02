package condition_stat;


public class NacissiisticNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// output all narcissistic numbers 
		// if a 3-digit number which ...
		
		int i = 100, iH,iD,iU;
		System.out.println("all narcissistic numbers are:");
		while (i<1000) {
			iH =(i/100)%10;
			iD =(i/10)%10;
			iU =(i%10);
			if(i == (Math.pow(iH, 3) + Math.pow(iD, 3)+Math.pow(iU, 3))){
				System.out.println(i);
			}
			i++;
		}	
		
	}

}
