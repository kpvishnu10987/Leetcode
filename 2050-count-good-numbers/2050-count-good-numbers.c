const int MOD = 1000000007;

long long power(long long base, long long exp, long long mod) {
    long long result = 1;
    while (exp > 0) {
        if (exp % 2 == 1) {
            result = (result * base) % mod;
        }
        base = (base * base) % mod;
        exp /= 2;
    }
    return result;
}

int countGoodNumbers(long long n) {
    long long even_pos = n / 2;
    long long odd_pos = (n + 1) / 2;
    return (power(5, odd_pos, MOD) * power(4, even_pos, MOD)) % MOD;
}
