class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length(), i = 0, j = n-1;
        while(i<j) {
            if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j))){
                i++;
                j--;
            } else if(!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if(!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}