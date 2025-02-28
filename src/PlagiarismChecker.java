import java.util.ArrayList;

/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Niko Madriz
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {

        // TODO Complete this function to return the length of the longest shared substring.
        int longest = Math.max(doc1.length(), doc2.length());
        int biggest = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < longest; i++) {
            biggest = recurse(i, doc1, doc2, arr);
        }
        return biggest;
    }

    public static int recurse(int index, String doc1, String doc2, ArrayList<Integer> arr) {
        int longest = Math.max(doc1.length(), doc2.length());
        if (index > longest) {
            return 0;
        }
        if (arr.indexOf(index) != 0) {
            return arr.get(index);
        }
        int len = Math.max(recurse(index + 1, doc1, doc2, arr), recurse(index, doc1.substring(index), doc2, arr));
        arr.add(len);
        return 1 + len;
    }
}
