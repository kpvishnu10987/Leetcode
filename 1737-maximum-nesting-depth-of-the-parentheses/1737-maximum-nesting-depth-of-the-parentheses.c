int maxDepth(char* s) {
    int currentdepth=0;
    int maxdepth=0;
    for(int i=0;i<strlen(s);i++){
        if(s[i]=='('){
            currentdepth++;
            if(currentdepth>maxdepth){
                maxdepth=currentdepth;
            }
        }else if(s[i]==')'){
            currentdepth--;
        }

    }
    return maxdepth;
    
}