/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 struct ListNode* helper(struct ListNode *l1,struct ListNode *l2,int carry){
    if(l1==NULL &&l2==NULL && carry==0){
        return NULL;
    }
    struct ListNode* newnode = malloc(sizeof(struct ListNode));
    int sum = carry;
    if(l1){
        sum += l1->val;
        l1 = l1->next;
    }
    if(l2){
        sum += l2->val;
        l2 = l2->next;
    }
    carry = sum / 10;
    newnode->val=sum%10;
    newnode->next=helper(l1,l2,carry);
    return newnode;
 }
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    return helper(l1,l2,0);
}