/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
void parenthesis(char **result,int *count,char *current,int n,int open,int close){
    if(strlen(current)==2*n){
        result[*count]=strdup(current);
        (*count)++;
        return;
    }
    if(open<n){
        char newStr[2*n+1];
        strcpy(newStr,current);
        strcat(newStr,"(");
        parenthesis(result,count,newStr,n,open+1,close);
    }
    if(close<open){
        char newStr[2*n+1];
        strcpy(newStr,current);
        strcat(newStr,")");
        parenthesis(result,count,newStr,n,open,close+1);
    }
}

char** generateParenthesis(int n, int* returnSize) {
    char **result=(char **)malloc(100000*sizeof(char *));
    *returnSize=0;
    char *start=(char *)malloc((2*n+1) * sizeof(char));
    start[0]='\0';  
    parenthesis(result, returnSize, start, n, 0, 0);
    free(start);  
    return result;
}
