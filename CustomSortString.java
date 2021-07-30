class CustomSortString {
    public String customSortString(String order, String str) {
        char arr[]=str.toCharArray();
        Map<Character,Boolean> map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),true);
        }
        int visited[]=new int[26];
        for(int i=0;i<str.length();i++){
            //System.out.println("output"+arr[i]);
            if(map.containsKey(arr[i])){
                arr[i]='\0';
                visited[str.charAt(i)-'a']++;
            }
           
        }
        int pos=0;
        for(int i=0;i<arr.length;i++){
            if(pos<order.length() && arr[i]=='\0'){
                if(visited[order.charAt(pos)-'a']==0){
                    pos++;
                }
                if(pos<order.length() && visited[order.charAt(pos)-'a']>0){
                    arr[i]=order.charAt(pos);
                    visited[order.charAt(pos)-'a']--;
                }
            }
        }
        return new String(arr);
    }
}