/*
Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.
*/
class CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        int Mod=1000000007;
        long a=1,e=1,i=1,o=1,u=1;
        for(int le=1;le<n;le++){
            long pres_a=(e+i+u)%Mod;
            long pres_e=(a+i)%Mod;
            long pres_i=(e+o)%Mod;
            long pres_o=i%Mod;
            long pres_u=(i+o)%Mod;
            
            a=pres_a;e=pres_e;i=pres_i;o=pres_o;u=pres_u;
        }
        long result=(a+e+i+o+u)%Mod;
        return (int)result;
    }
}
