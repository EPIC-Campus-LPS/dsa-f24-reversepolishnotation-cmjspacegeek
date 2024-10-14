public class ReversePolishNotation {


    public static String infixToPostfix(String input){
        Stack num = new Stack();
        String output = "";
        String[] split_input = input.split(" ");

        for(int i = 0; i < split_input.length; i ++){


            if(split_input[i].equals("+") || split_input[i].equals("-") || split_input[i].equals("*") || split_input[i].equals("/") || split_input[i].equals("^") || split_input[i].equals("(") || split_input[i].equals(")")){
                int index = 0;
                int index_stack = 0;

                if (split_input[i].equals(")")) {
                    for(int j = 0; j < num.size(); j++){
                        if (!num.peek().equals("(")){
                            output = output + num.pop() + " ";
                        } else {
                            num.pop();
                            break;
                        }
                    }

                    continue;
                }
                if (split_input[i].equals("(")) {
                    index = 4;
                }else if (split_input[i].equals("^")){
                    index = 3;
                } else if (split_input[i].equals("*") || split_input[i].equals("/")  ) {
                    index = 2;
                } else if (split_input[i].equals("+") || split_input[i].equals("-")) {
                    index = 1;
                }

                if (!num.isEmpty()) {
                    String peek1 = num.peek();

                    if (peek1.equals("(")) {
                        index_stack = 0;
                    }else if (peek1.equals("^")) {
                        index_stack = 3;
                    } else if (peek1.equals("*") || peek1.equals("/")) {
                        index_stack = 2;
                    } else if (peek1.equals("+") || peek1.equals("-")) {
                        index_stack = 1;
                    }

                    if (index > index_stack){
                        num.push(split_input[i]);
                    }
                    if (index <= index_stack){
                        for(int j = 0; j < num.size(); j++){
                            output = output + num.pop() + " ";

                            if (num.isEmpty()) {
                                num.push(split_input[i]);
                                break;
                            }
                            peek1 = num.peek();

                            if (peek1.equals("(")) {
                                index_stack = 0;
                            }else if (peek1.equals("^")) {
                                index_stack = 3;
                            } else if (peek1.equals("*") || peek1.equals("/")) {
                                index_stack = 2;
                            } else if (peek1.equals("+") || peek1.equals("-")) {
                                index_stack = 1;
                            }
                            if (index > index_stack){
                                num.push(split_input[i]);
                                break;

                            }

                            if (index == index_stack){
                                output = output + split_input[i] + " ";
                            }
                        }
                    }

                }else{
                    num.push(split_input[i]);
                }

            }else output = output + split_input[i] + " ";



        }

        for(int k = 0; k <= num.size(); k++){
            if (num.peek().equals("(")){
                break;
            }
            output = output + num.pop() + " ";
        }


        return output;
    }




    public static int evaluatePostfix(String input){
        Stack num = new Stack();
        String output = "";
        String[] split_input = input.split(" ");
        int num1;
        int num2;
        int num3 = 0;
        if (split_input.length < 3){
            throw new IllegalArgumentException("String must be longer than 2");
        }

        for(int i = 0; i < split_input.length; i ++) {




            if(split_input[i].equals("+") || split_input[i].equals("-") || split_input[i].equals("*") || split_input[i].equals("/") || split_input[i].equals("^") || split_input[i].equals("(") || split_input[i].equals(")")) {


                try {
                    num1 = Integer.valueOf(num.pop());
                    num2 = Integer.valueOf(num.pop());
                } catch (NegativeArraySizeException e) {
                    throw new IllegalArgumentException("Too many opps");
                }

                    if (split_input[i].equals("+")){
                        //System.out.println(num1 + "+" + num2);
                         num3 = num1 + num2;
                    }
                    else if (split_input[i].equals("-")){
                        //System.out.println(num1 + "-" + num2);
                         num3 = num2 - num1;
                    }
                    else if (split_input[i].equals("*")){
                        //System.out.println(num1 + "*" + num2);
                         num3 = num1 * num2;
                    }
                    else if (split_input[i].equals("/")){
                        //System.out.println(num1 + "/" + num2);
                         num3 = num1 / num2;
                    }
                    else if (split_input[i].equals("^")){
                        //System.out.println(num1 + "^" + num2);
                        num3 = (int) Math.pow(num1,num2);
                    }


                String pusher = "" + num3;
                num.push(pusher);
            }else if (split_input[i].matches("[1234567890]")){
                num.push(split_input[i]);
            }else{
                throw new IllegalArgumentException("letters");

            }
        }
        if (num.size() != 0){
            throw new IllegalArgumentException("Too few opps");
        }
        return num3;
    }
}
