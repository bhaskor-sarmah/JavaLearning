package com.bhaskor.reccursion;

import java.util.ArrayList;
import java.util.List;

public class CreateBracket {
  /*
  n=3, (((    )))

  ((())), ()()(), (())(), ()(())

  3+0+0

  2+1+0

  1+1+1

  String str = createBracket(n);
  */
  public static void createBracket(int n, int open, int close, String str, List<String> result){
    if(open==n && close == n){
      result.add(str);
      return;
    }

    if(open < n){
      createBracket(n, open+1, close, str+"{", result);
    }

    if(close < open){
      createBracket(n, open, close+1, str+"}", result);
    }
  }

  public static void main(String[] args) {
    int n = 3;
    List<String> result = new ArrayList<>();
    String res = "";
    createBracket(n, 0, 0, res, result);
    for(String s: result) {
      System.out.println(s);
    }
  }
}
