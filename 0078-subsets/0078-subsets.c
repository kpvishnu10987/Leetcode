/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
 void helper(int *nums,int numsSize,int index,int *tempsubset,int tempsize,int **result,int* returnSize,int **returnColumnSizes){
    result[*returnSize]=malloc(tempsize*sizeof(int));

    memcpy(result[*returnSize], tempsubset, tempsize * sizeof(int));
    (*returnColumnSizes)[*returnSize]=tempsize;
    (*returnSize)++;

    for(int i=index;i<numsSize;i++){
        tempsubset[tempsize]=nums[i];
        helper(nums,numsSize,i+1,tempsubset,tempsize+1,result,returnSize,returnColumnSizes);
    }
    
 }
int** subsets(int* nums, int numsSize, int* returnSize, int** returnColumnSizes) {
    *returnSize=0;
    int totalsubsets=1<<numsSize;
    int** result=(int**)malloc(totalsubsets * sizeof(int*));

    *returnColumnSizes = (int*)malloc(totalsubsets * sizeof(int));
    int* tempsubset=(int*)malloc(numsSize*sizeof(int)); 

    helper(nums,numsSize,0,tempsubset,0,result,returnSize,returnColumnSizes);

    
    return result; 
}