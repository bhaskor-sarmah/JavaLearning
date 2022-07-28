package com.bhaskor.reccursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Give a set of expression in the form of a string find the eval for a string
 * There will be three types of expression
 * 1. Assignment Operator   e.g A=10    (Setting value of A to 10)
 * 2. Expression Statement  e.g B=C+D   (Evaluate Value of B from Value of C and D)
 * 3. Evaluation            e.g eval A  (This should print to value of A to the screen)
 *
 * e.g:
 * A=B+C
 * B=D+E
 * D=2
 * E=3
 * eval A (Prints 5)
 * D=4
 * C=1
 * eval A (Prints 8)
 *
 * e.g:
 * A=B+C
 * eval A (Prints cannot evaluate A)
 * B=3
 * C=5
 * eval A (Prints 8)
 */

public class EvaluateExpression {

  public static void main(String[] args) {
    String string[] = new String[]{"A=B+C","B=D+E","D=2","E=3","eval A","D=4","C=1","A=1","eval A"};
//    String string[] = new String[]{"A=B+C","D=E+F","B=H+G","H=5","G=4","F=P+Q","Q=B+D","D=6","P=1","eval F"};
//    String string[] = new String[]{"D=B+C","C=E+F","F=3","E=Q+D","eval D"};
    Map<String, Operand> testMap = new HashMap<>();

    for(String s: string){
      if(s.startsWith("eval")){
        String str = s.split(" ")[1];
        Operand operand = testMap.getOrDefault(str, new Operand(0, null, null));
        System.out.println(operand);
        continue;
      }

      if(s.contains("+") && s.contains("=")){
        processExpression(testMap, s);
        continue;
      }

      if(s.contains("=")){
        processAssignmentOperation(testMap, s);
      }
    }

  }

  private static void processExpression(Map<String, Operand> testMap, String s) {
    String arr[] = s.split("=");
    String key = arr[0];
    String arr1[] = arr[1].split("\\+");
    String left = arr1[0];
    String right = arr1[1];

    Operand leftOperand = putIntoMap(testMap, left, null, null);
    Operand rightOperand = putIntoMap(testMap, right, null, null);

    putIntoMap(testMap, key, leftOperand, rightOperand);
  }

  private static void processAssignmentOperation(Map<String, Operand> testMap, String s) {
    String arr[] = s.split("=");
    String key = arr[0];
    if(testMap.containsKey(key)){
      Operand opd = testMap.get(key);
      opd.value = Integer.parseInt(arr[1]);
      opd.left = null;
      opd.right = null;
    }else{
      Operand opd = new Operand(Integer.parseInt(arr[1]), null, null);
      testMap.put(key, opd);
    }
  }

  private static Operand putIntoMap(Map<String, Operand> testMap, String key, Operand leftOperand, Operand rightOperand) {
    if(testMap.containsKey(key)){
      Operand opd = testMap.get(key);
      if(leftOperand != null) {
        opd.left = leftOperand;
      }
      if(rightOperand != null) {
        opd.right = rightOperand;
      }
    }else{
      Operand opd = new Operand(0, leftOperand, rightOperand);
      testMap.put(key, opd);
    }

    return testMap.get(key);
  }

  static class Operand{
    int value;
    Operand left;
    Operand right;

    Operand(int value, Operand left, Operand right){
      this.value = value;
      this.left = left;
      this.right = right;
    }

    @Override
    public String toString(){
      return String.valueOf(getValue());
    }

    public int getValue(){
      if(left == null && right == null){
        return value;
      }else if(left == null){
        return right.getValue();
      }else if(right == null){
        return left.getValue();
      }else{
        return left.getValue()+ right.getValue();
      }
    }
  }
}
