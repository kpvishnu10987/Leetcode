int findClosestNumber(int* nums, int numsSize) {
    int min=999999;
    int index;
    for(int i=0; i < numsSize ; i++){
        int dis=abs(0-nums[i]);
        if(dis<min){
            min = dis;
            index = i;
        }
        if(dis==min && nums[i]>nums[index]){
            index = i;
        }

    }
    return nums[index];
}
