class GfG
 {
	String encode(String str)
	{
          //Your code here
          String ansStr = "";
          int currCount = 0;
          for(int i = 0; i < str.length(); i++) {
              if(i == 0 || str.charAt(i) == str.charAt(i-1)) {
                  currCount++;
              }else {
                  ansStr += str.charAt(i-1);
                  ansStr += currCount;
                  currCount = 1;
              }
          }
          if(currCount != 0) {
              ansStr += str.charAt(str.length()-1);
              ansStr += currCount;
          }
          return ansStr;
	}
	
 }
