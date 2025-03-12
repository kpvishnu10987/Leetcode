int value(char r) {
    switch(r) {
        case 'I': return 1;
        case 'V': return 5;
        case 'X': return 10;
        case 'L': return 50;
        case 'C': return 100;
        case 'D': return 500;
        case 'M': return 1000;
        default: return 0;
    }
}


int romanToInt(char *s) {
    int sum = 0;
    int l = strlen(s);
    
    for(int i=0;i<l;i++){
        int s1=value(s[i]);
        if(i+1 < l){
            int s2=value(s[i+1]);
            if(s1>=s2){
                sum += s1;
            }else{
                sum +=(s2-s1);
                i++;
            }
        }else{
            sum += s1;
        }
    }
    return sum;
}


