class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0;
        int ten = 0;

        for(int bill : bills){
            if(bill == 5){
                five += 1;
            }else if(bill == 10){
                if(five == 0) return false;
                five--;
                ten++;
            }else{
                if(ten > 0 && five >0){
                    ten--;
                    five--;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}