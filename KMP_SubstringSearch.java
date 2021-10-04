// the time-complexit is O(n)
public class KMP_SubstringSearch {

    void KMPSearch(String text, String pattern)
    {
        int n = text.length();//length of the text
		int m = pattern.length();//length of the pattern;

  
        // lps[] will hold the longest prefix suffix values for pattern
        int lps[] = new int[m];
        int j = 0; // index for pat[]
  
        // Pre-process the pattern (calculate lps[] array)
        computeLPSArray(pattern, m, lps);
  
        int i = 0; // index for txt[]
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            }
  
            // mismatch after j matches
            else if ((i < n) && (pattern.charAt(j) != text.charAt(i))) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }
  
    void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int lenght = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0
  
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(lenght)) {
            	lenght++;
                lps[i] = lenght;
                i++;
            }
            else {
                if (lenght != 0) {
                	lenght = lps[lenght - 1];

                }
                else{
                    lps[i] = lenght;
                    i++;
                }
            }
        }
    }
  
    // Driver program to test above function
    public static void main(String args[])
    {
        KMP_SubstringSearch search = new KMP_SubstringSearch();
    	
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        
        search.KMPSearch(txt, pat);
    }
}