public class Tries {
      
    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;
      
    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
       
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
          
        TrieNode(){
            isEndOfWord = false;
            
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }
       
    static TrieNode root; 
      
    // If not present, inserts key into trie
    // If the key is prefix of trie node, 
    // just marks leaf node
    static void insert(String key)
    {
    	
        int length = key.length();
        int index;
       
        TrieNode node = root;
       
        for (int level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (node.children[index] == null)
            	node.children[index] = new TrieNode();
       
            node = node.children[index];
        }
       
        // mark last node as leaf
        node.isEndOfWord = true;
    }
       
    // Returns true if key presents in trie, else false
    static boolean search(String key)
    {
        int length = key.length();
        int index;
        
        TrieNode node = root;
       
        for (int level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
       
            if (node.children[index] == null)
                return false;
       
            node = node.children[index];
        }
       
        return (node != null && node.isEndOfWord);
    }
       
    // Driver
    public static void main(String args[])
    {
    	// Input keys (use only 'a' through 'z' and lower case) 
    	String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};

    	String output[] = {"Not present in trie", "Present in trie"}; 

    	root = new TrieNode(); 

    	// Construct trie 
    	for (int i = 0; i < keys.length ; i++) {
    	insert(keys[i]); 
    	}
    	
    	String str1 = "book"; // true
    	String str2 = "still"; // false
    	String str3 = "filter"; // true
    	String str4 = "silver"; // true
    	String str5 = "films"; // false
    	
        // Search for different keys
    	
        if(search(str1) == true) {
            System.out.println(str1 + " --- " + output[1]);}
        else {System.out.println(str1 + " --- " + output[0]);
        }
          
        if(search(str2) == true) {
            System.out.println(str2 + " --- " + output[1]);}
        else {System.out.println(str2 + " --- " + output[0]);
        }
        
        if(search(str3) == true) {
            System.out.println(str3 + " --- " + output[1]);}
        else {System.out.println(str3 + " --- " + output[0]);
        }
        
        if(search(str4) == true) {
            System.out.println(str4 + " --- " + output[1]);}
        else {System.out.println(str4 + " --- " + output[0]);
        }
        
        if(search(str5) == true) {
            System.out.println(str5 + " --- " + output[1]);}
        else {System.out.println(str5 + " --- " + output[0]);
        }
    }
}