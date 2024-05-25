
public class Interview {

	public static void main(String[] args) {

		int a[]= {7,28,49,70};
		
		int b=a[0];
		
		
		for(int j=1;j<=10;j++) {
			int c=1;
			int k=0;
			for(int i=k;i<a.length;i++) {
			if(b*j==a[i]) {
				c++;
				//System.out.println("number is already in the array");
				break;
				
			}
			
		}
			if(c==1) {
				System.out.println(b*j);
			}  
		}
		
		
	}

}
