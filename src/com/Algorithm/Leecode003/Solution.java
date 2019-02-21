package com.Algorithm.Leecode003;

/**
 * @ClassName: Solution
 * @Description: java类作用描述
 * @Author: xinyuan
 * @CreateDate: 2019/2/21 19:27
 */
public class Solution {
    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode l10 = new ListNode(4);
        ListNode l11 = new ListNode(3);
        l1.next = l10;
        l10.next = l11;
        ListNode l2 = new ListNode(5);
        ListNode l20 = new ListNode(6);
        ListNode l21 = new ListNode(4);
        l2.next = l20;
        l20.next = l21;
        Solution solution = new Solution();
        solution.addTwoNumbers(l1,l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int indexNum = 0;   //设置一个记录是否有进位的临时变量
        ListNode l0 = new ListNode(0);  //返回的最终结果
        ListNode indexl0 = l0;  //临时记录的变量
        while(l1 != null || l2 != null || indexNum == 1){
            if(l1 != null){
                if(l2 != null){
                    int sum = l1.val + l2.val + indexNum;
                    if(sum >= 10){   //判断是否有进位
                        indexNum = 1;
                    }else{
                        indexNum = 0;
                    }
                    indexl0.val = sum % 10;
                    l1 = l1.next;
                    l2 = l2.next;
                }else{
                    int sum = l1.val + indexNum;
                    if(sum >= 10){   //判断是否有进位
                        indexNum = 1;
                    }else{
                        indexNum = 0;
                    }
                    indexl0.val = sum % 10;
                    l1 = l1.next;
                }
            }else{
                if(l2 != null){
                    int sum = l2.val + indexNum;
                    if(sum >= 10){   //判断是否有进位
                        indexNum = 1;
                    }else{
                        indexNum = 0;
                    }
                    indexl0.val = sum % 10;
                    l2 = l2.next;
                }else{
                    int sum = indexNum;
                    indexNum = 0;
                    indexl0.val = sum % 10;
                }
            }
            if(l1 != null || l2 != null || indexNum == 1){
                ListNode index_l = new ListNode(0);
                indexl0.next = index_l;
                indexl0 = indexl0.next;
            }
        }
        return l0;
    }
}
