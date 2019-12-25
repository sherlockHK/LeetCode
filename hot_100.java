/**
1.两数之和
给定一个整数数组 nums 和一个目标值 target，
请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
*/
//暴力，遍历
public static int[] twoSum(int[] nums, int target){
    for (int i = 0; i < nums.length -1; i++) {
        for (int j = i +1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target){
                return new int[]{i,j};
            }
        }
    }
    return null;
}

//利用hash表，查找速度从O(n)->O(1)
public static int[] twoSum(int[] nums, int target){
    Map<Integer, Integer> m = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        m.put(nums[i],i);
    }

    for (int i = 0; i < nums.length; i++) {
        int key = target - nums[i];
        if (m.containsKey(key) && m.get(key) != i){
            return new int[]{i, m.get(key)};
        }
    }
    return null;
}

/**
2.两数相加
给出两个 非空 的链表用来表示两个非负的整数。
其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/
public static ListNode getResult(ListNode l1, ListNode l2){
	boolean isCarry = false;
	ListNode root = null;
	ListNode p = null;
	while(l1 != null || l2 != null){
		int sum = (l1 == null ? 0 :l1.val) + (l2 ==null ? 0 :l2.val) + (isCarry? 1: 0);
		if (l1 != null) {
			l1 = l1.next;
		}
		if (l2 != null) {
			l2 = l2.next;
		}
		isCarry = sum >= 10;
		int reminder=  sum % 10;
		ListNode n = new ListNode(reminder);
		if(root == null){
			root = n;
			p = n;
		}else{
			p.next = n;
			p = p.next;
		}
		if (isCarry) {
			p.next = new ListNode(1);
		}
	}
	return root;
}

/**
3.无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/
public int lengthOfLongestSubstring(String s) {
    String sub = "";
    int re = 0;
    for (int i = 0; i < s.length(); i++) {
        String o = String.valueOf(s.charAt(i));
        int index = sub.indexOf(o);
        if (index != -1){
            sub = sub.substring(index + 1);
        }
        sub = sub + o;

        int length = sub.length();
        if (length > re){
            re = length;
        }
    }
    return re;
}

/**
4.寻找两个有序数组的中位数
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
你可以假设 nums1 和 nums2 不会同时为空。
示例 1:
nums1 = [1, 3]
nums2 = [2]
则中位数是 2.0
示例 2:
nums1 = [1, 2]
nums2 = [3, 4]
则中位数是 (2 + 3)/2 = 2.5
*/

/**
5.最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：
输入: "cbbd"
输出: "bb"
*/

/**
15.三数之和
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

/**
17.电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
*/
//回溯
static String[] arr = new String[]{"", "", "abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
public static List<String> letterCombinations(String s) {
    List<String> list = new ArrayList<>();
    if (s != null && s.length() != 0){
        merge("", s, list);
    }
    return list;
}

private static void merge(String s, String d, List<String> list) {
    if (d.length() == 0){
        list.add(s);
    }else {
        int d1 = Integer.valueOf(d.substring(0, 1));
        String s1 = arr[d1];
        for (int i = 0; i < s1.length(); i++) {
            merge(s+ s1.charAt(i), d.substring(1), list);
        }
    }
}

/**
19.删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：
给定的 n 保证是有效的。
进阶：
你能尝试使用一趟扫描实现吗？
*/
//普通方式，遍历一次
public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) return null;
    ListNode p = head;
    int count = 1;
    List<ListNode> list = new ArrayList<>();
    list.add(p);
    while (p.next != null){
        p = p.next;
        list.add(p);
        count++;
    }

   if (n ==count){
       head = count == 1? null : list.get(1);
   }else if (n == 1){
        list.get(list.size()-2).next = null;
    }else {
       list.get(count-n-1).next = list.get(count-n+1);
   }
    return head;
}

//双指针

/**
22.括号生成
给出 n 代表生成括号的对数，请你写出一个函数，
使其能够生成所有可能的并且有效的括号组合。
例如，给出 n = 3，生成结果为：
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/


/**
23.合并K个排序链表
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:
输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
*/
























































