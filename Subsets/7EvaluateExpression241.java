import java.util.*;

class EvaluateExpression {
  public static List<Integer> diffWaysToEvaluateExpression(String input) {
    List<Integer> res = new ArrayList<>();
        if(validNum(input)) 
            res.add(Integer.parseInt(input));
        else {
            for(int i=0;i<input.length();i++) {
                char curr=input.charAt(i);
                if(!Character.isDigit(curr)) {
                    List<Integer> left=diffWaysToEvaluateExpression(input.substring(0,i));
                    List<Integer> right=diffWaysToEvaluateExpression(input.substring(i+1));
                    for(int l:left) {
                        for(int r:right) {
                            if(curr=='+')
                                res.add(l+r);
                            else if(curr=='-')
                                res.add(l-r);
                            else if(curr=='*')
                                res.add(l*r);
                        }
                    }
                }
            }
        }
        
        return res;
  }

   public static boolean validNum(String input) {
        for(char c:input.toCharArray()) {
            if(!Character.isDigit(c))
                return false;
        }
        
        return true;
    }

  public static void main(String[] args) {
    List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
    System.out.println("Expression evaluations: " + result);

    result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
    System.out.println("Expression evaluations: " + result);
  }
}
