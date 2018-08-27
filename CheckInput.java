package checkInput;

public class CheckInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="1234.5";
		String str2 ="abCDE";
		if(isStringDouble(str))
			System.out.println("number");
		if(isAlphabet(str2))
			System.out.println("alpha");

	}
	public static boolean isStringDouble(String s) {
	    try {
	        Double.parseDouble(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	public static boolean isAlphabet(String str)
	{
		return str.matches("^[A-Za-z]*$");
	}
}
