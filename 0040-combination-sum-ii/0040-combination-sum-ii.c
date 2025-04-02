/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
 void helper(int *candidates,int candidatesSize,int target,int *currentCombination,int currentSize,int index,int **result,int *returnSize,int** returnColumnSizes){
    if(target==0){
        result[*returnSize]=malloc(currentSize*sizeof(int));
        memcpy(result[*returnSize],currentCombination,currentSize*sizeof(int));
        (*returnColumnSizes)[*returnSize]=currentSize;
        (*returnSize)++;
        return;
    }

    for(int i=index;i<candidatesSize;i++){
        if (i > index && candidates[i] == candidates[i - 1]) {
            continue;
        }
        if (candidates[i] > target) {
            break;
        }
        currentCombination[currentSize]=candidates[i];
        helper(candidates,candidatesSize,target-candidates[i],currentCombination,currentSize+1,i+1,result,returnSize,returnColumnSizes);
    }
    
 }
int** combinationSum2(int* candidates, int candidatesSize, int target, int* returnSize, int** returnColumnSizes) {
    for(int i=candidatesSize;i>=0;i--){
        for(int j=i;j<candidatesSize-1;j++){
            if(candidates[j+1]<candidates[j]){
                int temp=candidates[j];
                candidates[j]=candidates[j+1];
                candidates[j+1]=temp;
            }
        }
    }
    int **result=malloc(200*sizeof(int *));
    *returnSize=0;
    *returnColumnSizes=malloc(200*sizeof(int));
    int *currentCombination=malloc(target*sizeof(int));
    helper(candidates,candidatesSize,target,currentCombination,0,0,result,returnSize,returnColumnSizes);
    return result;
}