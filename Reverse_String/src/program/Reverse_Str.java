package program;

public class Reverse_Str {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String nam = "MaryDora";
String rev = "";
int len =nam.length(); //leng=10
for(int i= len-1;i>=0;i--) {
	rev = rev+ nam.charAt(i);
}
System.out.println(rev);
	}
		
		
}
	