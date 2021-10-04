

public class BruteForceSubStringSearch {

	public int bruteforce(String text,String pattern){
		int n = text.length();//length of the text
		int m = pattern.length();//length of the pattern;

		//loop condition
		for(int i=0; i < n-m; i++){
			//initialization of j
			int j = 0;
			while((j < m) && (text.charAt(i+j) == pattern.charAt(j))){
				j++;
			}
			if(j == m){
				return i;
			}
		}
		// if the substring isn't present 
		return -1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BruteForceSubStringSearch obj = new BruteForceSubStringSearch();

		String givenText = "This is the Brute-Force approach for Substring Search.";

//		String findString = "Here";

		int position = obj.bruteforce(givenText, "Search");
		int endindex = position + 1;
		//condition to check whether the pattern is matched are not
		if(position == -1){
			System.out.println("Pattern is not matched in the text");
		}else{
			System.out.println("Found at position:" + (position + 1));
//			System.out.println("End at the position:" + (endindex + findString.length()));
		}
	}
}

