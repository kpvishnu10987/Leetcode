int beautySum(char* s) {
    int total=0;
    int n=strlen(s);
    for(int i=0;i<n;i++){
        int count[26]={0};
        for(int j=i;j<n;j++){
            count[s[j]-'a']++;
            int max=0;
            int min=n;
            for(int k=0;k<26;k++){
                if(count[k]>0){
                    if(count[k]>max){
                        max=count[k];
                    }
                    if(count[k]<min){
                        min=count[k];
                    }
                }
            }
            total +=(max-min);
        }
    }
    return total;
}