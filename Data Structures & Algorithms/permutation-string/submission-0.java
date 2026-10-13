class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] freq = new int[26];

        for(int i=0;i<s1.length();i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        int low = 0, high = s1.length() - 1;
        while(high!=s2.length()) {
            int[] arr = freq.clone();

            for(int i=low;i<=high;i++) {
                arr[s2.charAt(i) - 'a']--;
            }

            for(int i = 0;i<arr.length;i++) {
                if(i==arr.length-1 && arr[i]==0) {
                    return true;
                }
                if(arr[i]!=0)
                    break;
            }
            low++;
            high++;
        }

        return false;

        
    }
}
