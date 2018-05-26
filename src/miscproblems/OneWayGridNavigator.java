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
        final int LENGTH = 5;
        final int HEIGHT = 6;

        List<Character> pathArray = new ArrayList<Character>();

        OneWayGridNavigator op = new OneWayGridNavigator();

        String simplestPath = constructSimplestPath(LENGTH, HEIGHT);

        Set<String> permutations = op.permute(simplestPath, 0, simplestPath.length() - 1);
        System.out.println(permutations.size());
        for (String w : permutations) {
            System.out.println(w);
        }
    }

    /**
     * Generates all possible permutations of letters of the given String.
     * Internally uses the overloaded method : permute(String word, int st, int
     * lt)
     */
    private Set<String> permute(String word) {
        return permute(word, 0, word.length() - 1);
    }

    /**
     * Generates all possible permutations of letters of the given String. Takes
     * in the given string, the start and end characters (this is a recursive
     * function), and returns an array of permuted Strings
     * Idea : Fix a letter, bring it to the front. Recursively permute the 
     * remaining letters. Swap back the fixed letter. Repeat for all letters.
     */
    private Set<String> permute(String word, int st, int lt) {
        Set<String> results = new HashSet<String>();
        if (st == lt) {
            results.add(word);
        }
        for (int i = st; i <= lt; i++) {
            word = swap(word, st, i);
            permute(word, st + 1, lt);
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
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < LENGTH; i++) {
            sb.append("R");
        }
        for (int i = 0; i < HEIGHT; i++) {
            sb.append("L");
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
