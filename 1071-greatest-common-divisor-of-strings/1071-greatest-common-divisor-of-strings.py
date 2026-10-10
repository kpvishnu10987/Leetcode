class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        if str1 + str2 != str2 + str1:
            return ""

        return str1[:gcd(len(str1),len(str2))]
    def gcd(a,b)->int:
        if(a > b):
            return gcd(a,b)

        temp = b
        b = a % b
        a = temp
        return gcd(a,b)


        