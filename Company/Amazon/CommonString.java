class CommonString{

    public static String commonString(String s1, String s2){
        if(s1 == null || s2 == null) return null;

        StringBuilder prefix = new StringBuilder();

        int len = Math.min(s1.length(), s2.length());
        int i = 0;
        while(i < len){
            if(s1.charAt(i) != s2.charAt(i)) break;
            prefix.append(s1.charAt(i));
            i++;
        }
        return prefix.toString();
    }

    public static void main(String[] args){
        String s1 = "asdfghj";
        String s2 = "asdqwe";
        System.out.println(commonString(s1, s2));
    }
}