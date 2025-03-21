struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    struct ListNode dummy;
    dummy.next = NULL;
    struct ListNode* cur = &dummy;

    while (list1 != NULL && list2 != NULL) {
        if (list1->val > list2->val) {
            cur->next = list2;
            list2 = list2->next;
        } else {
            cur->next = list1;
            list1 = list1->next;
        }
        cur = cur->next;
    }

    cur->next = (list1 != NULL) ? list1 : list2;

    return dummy.next;
}