double myPow(double x, int n) {
    if(n==0) return 1;
    long long z=n;
    if(z < 0){
        x = 1/x;
        z=-z;
    }
    double half = myPow(x,z/2);
    if(z%2 == 0){
        return half*half;
    }else{
        return half*half*x;
    }
}