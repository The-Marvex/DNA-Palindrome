import java.io.*;
import java.util.*;

public class DNAChecker{
    public static boolean isPalindrome(String seq){
        HashMap<String, String> code = new HashMap<>();
        code.put("A", "T");
        code.put("T", "A");
        code.put("G", "C");
        code.put("C", "G");
        for (int i = 0 ; i < seq.length()/2 ; i++) {
            if (!(code.get(Character.toString(seq.charAt(i))).equals(Character.toString(seq.charAt(seq.length()-i-1)))))
                return false;
        }
        return true;
    }
    public static void main(String[] args)throws IOException {
        String seq;
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String path = "~/DNA-Palindrome/seq/input.txt";
        File file = new File(path);
        long countPalindrome = 0;
        long countQuasiPalindrome = 0;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((seq = br.readLine()) != null){
            System.out.println(seq);
            System.out.println("Enter the minimum length of palindrome needed (must be >= 4)");
            int min_length = Integer.parseInt(read.readLine()) - 1;
            System.out.println("Enter the maximum length of palindrome needed (must be < Length of sequence)");
            int max_length = Integer.parseInt(read.readLine());
            int check = min_length;
            while(check <= max_length){
                for (int i = 0 ; i < seq.length() - check; i++ ) {
                    String toBeChecked = seq.substring(i, i+check+1);
                    if (isPalindrome(toBeChecked)) {
                        if (toBeChecked.length()%2==0) {
                            countPalindrome++;
                        }
                        else
                            countQuasiPalindrome++;
                        System.out.println(toBeChecked);
                    }
                }
                check++;
            }
        }
        System.out.println("The Number of palindrome occurances in the DNA Strand"+countPalindrome);
        System.out.println("The Number of quasi-palindrome occurances in the DNA Strand"+countQuasiPalindrome);
    }
}
