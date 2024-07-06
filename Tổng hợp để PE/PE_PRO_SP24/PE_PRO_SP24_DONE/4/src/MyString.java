public class MyString implements IString{

    @Override
    public int f1(String  str) {
          String[] s = str.split("\\s");
          int count = 0;
          for(int i = 0; i < s.length; i++){
              if(Character.isAlphabetic(s[i].charAt(0)) && Character.isAlphabetic(s[i].charAt(s[i].length()-1))){
                  boolean flag = true;
                  for(int j = 1; j <= s[i].length()-2;j++ ){
                      if(Character.isDigit(s[i].charAt(j))){
                          flag = true;
                      }else{
                          flag = false;
                      }
                  }
                  if(flag == true){
                      System.out.println(s[i]);
                      count++;
                  }
              }
          }
          return count;
    }

    @Override
    public String f2(String  str) {
         char[] c = str.toCharArray();
         int maxCount = 0;
         char most = 0;
         for(int i = 0; i < c.length; i++){
             int count = 1;
             for(int j = i + 1; j < c.length; j++){
                 if(c[i] == c[j] && (c[i]-'0')%2 ==1){
                     count++;
                 }
             }
             if(count > maxCount){
                 maxCount = count;
                 most = c[i];
             }
         }
         //1 xuat hien ơ 1 và 3
         
         int count1 = 0;
         int[] temp = new int[c.length];
         for(int i = 0; i < c.length; i++){
             if(most == c[i]){
                 temp[count1++] = i;
             }
         }
         int[] result = new int[count1];
         for(int i = 0; i < count1; i++){
             result[i] = temp[i];
         }
         //result chứa 1 với 3
         int secondeIndex = result[1]; // secondindex = 3
         c[secondeIndex] = c[0];
         String totalResult = String.valueOf(c);
         
         return  totalResult;
    }

}