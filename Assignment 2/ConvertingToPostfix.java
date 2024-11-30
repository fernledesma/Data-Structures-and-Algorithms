public class ConvertingToPostfix {
    LinkedStack<Character> characterStack= new LinkedStack<>();
    StringBuilder postfixExp = new StringBuilder();
    public ConvertingToPostfix(String infixExpression){
        String expression = convert(infixExpression);
    }
    char temp;
    char top;
    private String convert(String infixExpression) {
        for (int i=0; i<infixExpression.length(); i++){
            temp = infixExpression.charAt(i);
            top = characterStack.peek();
            if(temp == ' '){
                break;
            }
            else if (temp == '+' || temp == '-' || temp == '*' || temp == '/' || temp == '^'){
                while(!characterStack.isEmpty() && characterStack.peek() != '(' && getPrecedence(temp) <= getPrecedence(top)){
                    postfixExp.append(characterStack.pop());
                }
                characterStack.push(temp);
                break;
            }
            else if (temp == '('){
                characterStack.push(temp);
            }
            else if (temp == ')'){
                while(!characterStack.isEmpty() && top != '('){
                    postfixExp.append(characterStack.pop());
                }
                characterStack.pop();
                break;
            }
            else{
                postfixExp.append(temp);
                break;
            }
        }
        while (!characterStack.isEmpty()){
            postfixExp.append(characterStack.pop());
        }
        return postfixExp.toString();
    }

    private int getPrecedence(char character) {
        if(character == '+' || character == '-'){
            return 1;
        }
        else if(character == '*' || character == '/'){
            return 2;
        }
        else if(character == '^'){
            return 3;
        }
        else{
            return 0;
        }
    }
}
