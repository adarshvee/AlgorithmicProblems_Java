/*
 * Given a grid of length l and height h, find the number of different paths
to start at the left bottom and navigate to the right top. Motion is allowed
only in two directions : RIGHT or UP.
Idea : This is a permutation problem. The total possible moves are (l + h),
where there are l "right"s and h "top"s. Find all permutations of (l+h)
 */
package miscproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * *
 * @author Adarsh V Single Class Program to solve the one way grid problem
 */
public class OneWayGridNavigator {

    public static void main(String[] args) {
        //Hardcode length and height for now
        final int LENGTH = 1;
        final int HEIGHT = 1;

        int numPaths = findPaths(LENGTH, HEIGHT);
        
        System.out.println("Number of paths " + numPaths);
    }

    static int findPaths(final int LENGTH, final int HEIGHT) {
        List<Character> pathArray = new ArrayList<Character>();
        
        OneWayGridNavigator op = new OneWayGridNavigator();

        String simplestPath = constructSimplestPath(LENGTH, HEIGHT);

        Set<String> permutations = op.permute(simplestPath);
        
        for (String w : permutations) {
            System.out.println(w);
        }
        return permutations.size();
    }

    /**
     * Generates all possible permutations of letters of the given String.
     * Internally uses the overloaded method : permute(String word, int st, int
     * lt)
     */
    private Set<String> permute(String word) {
        Set<String> results = new HashSet<String>();
        return permute(word, 0, word.length() - 1, results);
    }

    /**
     * Generates all possible permutations of letters of the given String. Takes
     * in the given string, the start and end characters (this is a recursive
     * function), and returns an array of permuted Strings
     * Idea : Fix a letter, bring it to the front. Recursively permute the 
     * remaining letters. Swap back the fixed letter. Repeat for all letters.
     */
    private Set<String> permute(String word, int st, int lt, Set<String> results) {
        //Set<String> results = new HashSet<String>();
        if (st == lt) {
            results.add(word);
        }
        for (int i = st; i <= lt; i++) {
            word = swap(word, st, i);
            permute(word, st + 1, lt, results);
            word = swap(word, st, i);
        }
        return results;
    }

    /**
     * Constructs the simplest path for a grid of given LENGTH and HEIGHT. The
     * simplest path is to go all the way right and then go all the way up.
     * Returns a String with the path.
     */
    private static String constructSimplestPath(final int LENGTH, final int HEIGHT) {
        //Added to clear one side 0 lenght test case
        if (LENGTH * HEIGHT == 0) return "";
                
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < LENGTH; i++) {
            sb.append("R");
        }
        for (int i = 0; i < HEIGHT; i++) {
            sb.append("U");
        }
        return sb.toString();
    }
    
    /**
     * Utiliity function to swap two letters of a word
     */
    private String swap(String word, int i, int j) {
        char[] letters = word.toCharArray();
        char temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
        return String.valueOf(letters);
    }
}
