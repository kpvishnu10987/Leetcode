char* removeOuterParentheses(char* s) {
    int n = strlen(s);
    int count = 0;
    int balance = 0;
    char* result = (char*)malloc(n + 1); 
    int index = 0;

    for(int i = 0; i < n; i++) {
        if(s[i] == '(' && count == 0) {
            count++;
        } else if(s[i] == ')' && count == 1 && balance < 1) {
            count--;
        } else {
            if(s[i] == '(') {
                result[index++] = s[i];
                balance++;
            } else if(s[i] == ')' && balance > 0) {
                result[index++] = s[i];
                balance--;
            }
        }
    }

    result[index] = '\0'; 
    return strdup(result); 
}