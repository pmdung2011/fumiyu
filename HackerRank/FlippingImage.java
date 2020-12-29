package HackerRank;

//Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
//
//        To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
//
//        To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
//leetcode
public class FlippingImage {
    //Swap in place
    public int[][] flipAndInvertImage(int[][] A) {
        int length = A[0].length;
        //Loop through the 2d array
        for (int[] row : A) {
            //loop each row
            for (int i = 0; i < (length + 1) / 2; i++) {
                //swap/flip
                //then invert
                int temp = row[i] ^ 1;
                row[i] = row[length - 1 - i] ^ 1;
                row[length - 1 - i] = temp;
            }
        }
        return A;
    }
}
