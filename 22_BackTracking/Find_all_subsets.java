class Find_all_subsets{
    public static void Find_all_subsets1(String str,int i,String ans){
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }
            else{
                System.out.println(ans);
            }
            return;
        } 
        Find_all_subsets1(str, i+1, ans+str.charAt(i));//for yes choice
        Find_all_subsets1(str, i+1, ans);//for no choice
    }
    public static void main(String[] args) {
        String str= "abc";
        Find_all_subsets1(str, 0, "");
    }
}