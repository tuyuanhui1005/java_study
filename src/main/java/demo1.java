
import java.util.*;


public class demo1 {

    public static void main(String[] args) {

        int i = 1;
        int j = 2;
        System.out.println(i++);
        System.out.println(++j);
        int[] numbs = {1, 2, 2, 3, 1, 4, 2};
        //   System.out.println(findShortestSubArray(numbs));
        String[] strs = {"ab", "cd"};
        //System.out.println(longestCommonPrefix(strs));
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        l4.setNext(l5);

        // System.out.println(Arrays.toString(reversePrint(l1)));
        //System.out.println(getKthFromEnd(l1, 2));
       // System.out.println(arrayPairSum(new int[]{6,2,6,5,1,2}));
    }


    /**
     * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/array-partition-i
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }


    /**
     * 反转打印链表
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {

        if (head == null) {
            return new int[]{};
        }
        ListNode temp = head;
        Stack s = new Stack<Integer>();
        while (temp != null) {
            s.push(temp.val);
            temp = temp.next;
        }
        int size = s.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) s.pop();
        }
        return arr;
    }

    /**
     * 链表中倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {

        ListNode temp = head;
        ListNode flag = head;
        while (k > 0) {
            flag = flag.next;
            k--;
        }

        while (flag != null) {
            temp = temp.next;
            flag = flag.next;
        }
        return temp;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }


    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }


}
