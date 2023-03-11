package calculation;

public class Functions {
    public static double answer(String problem){
        double answer = 0;
        double term1,term2;
        int pos = 0;
        if (!(problem.isEmpty()||problem.equals(null))){
            pos = problem.indexOf("+");
            if (pos == -1) pos = problem.indexOf("-");
            if (pos == -1) pos = problem.indexOf("*");
            if (pos == -1) pos = problem.indexOf("/");
            if (pos == -1) pos = problem.indexOf("^");
        }

        if (pos == 0){
            answer = 0;
        }else{
            String operator = problem.substring(pos, pos+1);
            term1 = Double.parseDouble(problem.substring(0, pos));
            term2 = Double.parseDouble(problem.substring(pos+1,problem.length()));
            switch (operator){
                case "+":answer = term1+term2;break;
                case "-":answer = term1-term2;break;
                case "*":answer = term1*term2;break;
                case "/":answer = term1/term2;break;
                case "^":answer = Math.pow(term1,term2);
            }
        }
        return answer;
    }
}