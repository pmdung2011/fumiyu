package HackerRank;

class PalindromeNum {
    public static boolean isPalindrome(int x) {
        int newNum = 0, orgNum = x;
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        while (x > 0) {
            newNum = newNum * 10 + x % 10; //Reverse the org num
            x /= 10;//Remove the last digit
        }
        return newNum - orgNum == 0;
    }

    public static void main(String[] args) {
        int num = 123;
        System.out.println(isPalindrome(num));
    }
}
