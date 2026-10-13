class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        if(n>m) 
            return false;

        int[] freq = new int[26];

        for(int i=0;i<s1.length();i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        int low = 0, high = s1.length() - 1;

        for(int i=low;i<=high;i++) {
            freq[s2.charAt(i) - 'a']--;
        }
        while(high!=s2.length()) {

            for(int i = 0;i<26;i++) {
                if(i==25 && freq[25]==0) {
                    return true;
                }
                if(freq[i]!=0)
                    break;
            }

            freq[s2.charAt(low) - 'a']++;
            low++;
            high++;
            if(high<m) {
                freq[s2.charAt(high)- 'a']--;
            }
        }

        return false;

        
    }
}
