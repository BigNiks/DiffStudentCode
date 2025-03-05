
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

        int biggest;
        int[][] lcs = new int[doc1.length() + 1][doc2.length() + 1];
        //Row and cols already set to 0
        //Iterate
        for (int i = 1; i < lcs.length; i++) {
            for (int j = 1; j < lcs[0].length; j++) {
                //If current characters are equal, add corner to the top left + 1
                if (doc1.charAt(i - 1) == doc2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                }
                //Else grab the biggest value out of the two adjacent squares above and to left
                else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        //return biggest
        biggest = lcs[doc1.length()][doc2.length()];
        return biggest;
    }

    //This was the memoization approach, not completely sure if it works but didn't want to delete
    /*public static int recurse(int i, int j, String doc1, String doc2, int[][] arr) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (doc1.charAt(i - 1) == doc2.charAt(j - 1) {
            arr[i][j] = recurse(i - 1, j - 1, doc1, doc2, arr);
        }
        else {
            arr[i][j] = Math.max(recurse(i - 1, j, doc1, doc2, arr), recurse(i, j - 1, doc1, doc2, arr));
        }
        return arr[doc1.length()][doc2.length()];
    }*/
}
