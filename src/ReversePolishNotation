public class ReversePolishNotation {


    public static String infixToPostfix(String input){
        Stack num = new Stack();
        String output = "";
        String[] split_input = input.split(" ");

        for(int i = 0; i < split_input.length; i ++){
            System.out.println("Start");
            System.out.println(split_input[i]);
            num.display();

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

            System.out.println("end");
            System.out.println(split_input[i]);
            num.display();

        }
        System.out.println("very end");
        num.display();
        for(int k = 0; k <= num.size(); k++){
            if (num.peek().equals("(")){
                break;
            }
            output = output + num.pop() + " ";
        }
        System.out.println(output);

        return "0";
    }






    public static int evaluatePostfix(String input){
        return 0;

    }

}
