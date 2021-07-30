/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
*/
class IsomorphicStrings{
	    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map=new HashMap<>();
        int cha[]=new int[257];
        for(int i=0;i<s.length();i++){
            if(cha[t.charAt(i)]!=0 && cha[t.charAt(i)]!=s.charAt(i))return false;
            else if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),t.charAt(i));
                cha[t.charAt(i)]=s.charAt(i);
            }
            else if(map.get(s.charAt(i))!=t.charAt(i)){
               return false;
            }
            
        }
        return true;
    }
}