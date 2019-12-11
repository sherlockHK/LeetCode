/**
7. 整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:
输入: 123
输出: 321

示例 2:
输入: -123
输出: -321

示例 3:
输入: 120
输出: 21

注意:
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
请根据这个假设，如果反转后整数溢出那么就返回 0。
*/

/**
9.回文数
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:
<<<<<<< HEAD
输入: 121
输出: true

示例 2:
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3:
=======

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

>>>>>>> db80584085d1b3a4534e5d1adafab664a1f34950
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:
<<<<<<< HEAD
你能不将整数转为字符串来解决这个问题吗？
*/

public boolean test(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        List<Integer> list = new ArrayList<>();
        while (x != 0){
            int re = x % 10;
            x = x / 10;
            list.add(re);
        }

        boolean flag = true;
        int size = list.size();
        if (size >1){
            for(int i = 0; i < size/2; i++){
                if (!list.get(i).equals(list.get(size - i -1))){
                    flag = false;
                }
            }
        }
        return flag;
    }

/*
13.罗马数字转整数

罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

示例 1:
输入: "III"
输出: 3

示例 2:
输入: "IV"
输出: 4

示例 3:
输入: "IX"
输出: 9

示例 4:
输入: "LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.

示例 5:
输入: "MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.
*/

private int calculateLC(String s) {
        String[] array = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            String prefix = array[i];
            while (s.startsWith(prefix)){
                Integer value = map.get(prefix);
                result += value;

                s = s.substring(prefix.length());
            }
        }
        return result;
    }


/**
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

示例 1:
输入: ["flower","flow","flight"]
输出: "fl"

示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

说明:
所有输入只包含小写字母 a-z 。
*/

/**
20.有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:
输入: "()"
输出: true

示例 2:
输入: "()[]{}"
输出: true

示例 3:
输入: "(]"
输出: false

示例 4:
输入: "([)]"
输出: false

示例 5:
输入: "{[]}"
输出: true
*/

/**
21.合并两个有序列表
将两个有序链表合并为一个新的有序链表并返回。
新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
*/
private ListNode MergeTwoSortedLinkList(ListNode l1, ListNode l2){
    ListNode head = new ListNode(-1);
    ListNode dummy = head;
    while (true){
       if (l1 == null){
           dummy.next = l2;
           break;
       }

       if (l2 == null){
           dummy.next = l1;
           break;
       }

       if (l1.val <= l2.val){
           dummy.next = l1;
           l1 = l1.next;
       }else {
           dummy.next = l2;
           l2 = l2.next;
       }
       dummy = dummy.next;
    }
    return head.next;
}

/**
26.删除排序数组中的重复项
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:
给定数组 nums = [1,1,2], 
函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
你不需要考虑数组中超出新长度后面的元素。
示例 2:
给定 nums = [0,0,1,1,1,2,2,3,3,4],
函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
你不需要考虑数组中超出新长度后面的元素。

说明:
为什么返回数值是整数，但输出的答案是数组呢?
请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
你可以想象内部操作如下:
// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);
// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

提示：双指针
*/

/**
27.移除数组元素
给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1:
给定 nums = [3,2,2,3], val = 3,
函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
你不需要考虑数组中超出新长度后面的元素。
示例 2:
给定 nums = [0,1,2,2,3,0,4,2], val = 2,
函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
注意这五个元素可为任意顺序。
你不需要考虑数组中超出新长度后面的元素。
*/
public int removeElement(int[] nums, int val) {
    if (nums == null || nums.length == 0){
        return 0;
    }

    int j=0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val){
            nums[j++] = nums[i];
        }
    }
    return j;
}

/**
28.字符串匹配（KMP）
实现 strStr() 函数。
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
如果不存在，则返回  -1。

示例 1:
输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:
输入: haystack = "aaaaa", needle = "bba"
输出: -1

说明:
当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
*/
public int strStr(String haystack, String needle) {
    if (needle == null || needle.length() == 0){
        return 0;
    }
    if (haystack == null || haystack.length() == 0) {
        return -1;
    }
    int len = needle.length();
    for (int i = 0; i <= haystack.length() - len; i++) {
        if (haystack.substring(i, i+len).equals(needle)){
            return i;
        }
    }
    return -1;
}

/**
35.搜索插入位置（二分法）
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。

示例 1:
输入: [1,3,5,6], 5
输出: 2
示例 2:
输入: [1,3,5,6], 2
输出: 1
示例 3:
输入: [1,3,5,6], 7
输出: 4
示例 4:
输入: [1,3,5,6], 0
输出: 0
*/
//暴力 O(n)
public int searchInsert(int[] nums, int target){
for (int i = 0; i < nums.length; i++) {
        if (target <= nums[i]){
            return i;
        }
    }
    return nums.length;
}

//二分法
public int binarySearch(int[] nums, int target){
    int l =0;
    int r = nums.length - 1;
    while(l <= r){
        int mid = (l + r) >>> 1;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] > target) {
            r = mid -1;
        }else{
            l = mid + 1;
        }
    }
    return l;
}

/**
38.报数
报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
注意：整数顺序将表示为一个字符串。

示例 1:
输入: 1
输出: "1"
示例 2:
输入: 4
输出: "1211"
*/

/**
53.最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素）
，返回其最大和。

示例:
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

进阶:
如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解
*/
/**
 * 动态规划
 *
 * */
public int maxSubArray(int[] nums) {
    int sum = 0;
    int max = nums[0];
    for (int num : nums) {
        if (sum < 0){
            sum = num;
        }else {
            sum += num;
        }

        if (sum > max) {
            max = sum;
        }
    }
    return max;
}

/**
58.最后一个单词的长度
给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
如果不存在最后一个单词，请返回 0 。
说明：一个单词是指由字母组成，但不包含任何空格的字符串。

示例:
输入: "Hello World"
输出: 5
*/
//分割字符串
public int lengthOfLastWord(String s) {
    String[] strArray = s.split(" ");
    if (strArray.length == 0) return 0;
    return strArray[strArray.length - 1].length();
}

//O(n)
public int lengthOfLastWord(String s) {
    if (s == null || s.length() == 0) return 0;
    int count = 0;

    for (int i = s.length() -1; i >= 0; i--) {
        if (s.charAt(i) != ' '){
            count++;
        }else if (count != 0){
            break;
        }
    }

    return count;
}

/**
66.加一
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
*/
//实现比较丑陋
public int[] plusOne(int[] digits){
    int p = 0;
    for (int i = digits.length -1; i >=0 ; i--) {
        if (i == digits.length -1){
            digits[i] += 1;
        }else {
            digits[i] += p;
            if (p == 1){
                p = 0;
            }
        }

        if (digits[i] !=0 && digits[i] % 10 == 0){
            p = 1;
            digits[i] = 0;
        }
    }
    if (p == 1){
        int[] ints = new int[digits.length + 1];
        ints[0] = 1;
        for (int i : digits) {
            ints[i+1] = digits[i];
        }
        return ints;
    }
    return digits;
}

//优雅实现
public int[] plusOne(int[] digits){
    int len = digits.length;
    for(int i = len -1; i >=0 ; i--){
        digits[i] += 1;
        digits[i] %= 10;
        if (digits[i] != 0) {
            return digits;
        }
    }
    digits = new int[len + 1];
    digits[0] = 1;
    return digits;
}

/**
67.二进制求和
给定两个二进制字符串，返回他们的和（用二进制表示）。
输入为非空字符串且只包含数字 1 和 0。

示例 1:
输入: a = "11", b = "1"
输出: "100"
示例 2:
输入: a = "1010", b = "1011"
输出: "10101"
*/
public String addBinary(String a, String b){
    int re = a.length() - b.length();
    for (int i = 0; i < Math.abs(re); i++) {
        if (re >0){
            b = "0" + b;
        }else if (re < 0){
            a = "0" + a;
        }
    }
    StringBuilder result = new StringBuilder();
    boolean isCarry = false;
    int i = a.length() -1;
    while (i >= 0) {
        int p = a.charAt(i) - '0';
        int q = b.charAt(i) - '0';
        int sum = p + q + (isCarry ? 1 : 0);
        isCarry = sum / 2 != 0;
        result.insert(0, sum % 2);
        i--;
    }
    if (isCarry){
        result.insert(0,1);
    }
    return result.toString();
}

/**
69.X的平方根
实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:
输入: 4
输出: 2
示例 2:
输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
*/
//二分法
public int mySqrt(int x) {

}

/**
70.爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。

示例 1：
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
*/
//找规律，斐波那契数列，递归，O(2^n)
public static int climbStairs(int n){
    return n <= 3 ? n : climbStairs(n -1) + climbStairs( n -2);
}

//类似斐波那契数列 f(n) = f(n-1)+f(n-2) {n > 3}
//动态规划
public static int climbStairs2(int n){
    if (n <= 3) return n;
    int first = 2, second = 3;
    int result = 0;
    for (int i = 3; i < n; i++) {
        result = first + second;
        first = second;
        second = result;
    }
    return result;
}

/**
83.删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:
输入: 1->1->2
输出: 1->2
示例 2:
输入: 1->1->2->3->3
输出: 1->2->3
*/
//丑陋的实现
public static ListNode deleteDuplicates(ListNode head) {
    ListNode list = head;
    ListNode pre = null;
    int preValue = 0;
    while (list != null){
        if (list.val == preValue && pre != null){
            //delete
            pre.next = list.next;
            preValue = pre.val;
        }else {
            pre = list;
            preValue = list.val;
        }
        list = list.next;
    }
    return head;
}

//优雅实现
public static ListNode deleteDuplicates(ListNode head) {
    ListNode cur = head;
    while (cur != null && cur.next != null){
        if (cur.val == cur.next.val){
            cur.next = cur.next.next;
        }else {
            cur = cur.next;
        }
    }
    return head;
}

/**
88.合并两个有序数组
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，
使得 num1 成为一个有序数组。
说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
输出: [1,2,2,3,5,6]
*/
//1、双指针 2.从右向左
public void merge(int[] nums1, int m, int[] nums2, int n) {
  int pos = m + n - 1, p = m -1, q = n -1;
    while (p >= 0 && q >= 0){
        if (nums1[p] >= nums2[q]){
            nums1[pos--] = nums1[p--];
        }else {
            nums1[pos--] = nums2[q--];
        }
    }

    while (p >= 0){
        nums1[pos--] = nums1[p--];
    }
    while (q >= 0){
        nums1[pos--] = nums2[q--];
    }
}


public static class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
}

public static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
}


/**
100.相同的树
给定两个二叉树，编写一个函数来检验它们是否相同。
如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1:
输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]
输出: true
示例 2:
输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]
输出: false
示例 3:
输入:       1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]
输出: false
*/
//二叉树遍历
public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null){
        return true;
    }
    if (p == null || q == null) {
        return false;
    }
    
    if (p.val !=  q.val) {
        return false;
    }

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}

/**
101.对称二叉树
给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    1
   / \
  2   2
   \   \
   3    3
说明:
如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
*/
//递归
public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isMirror(root.left, root.right);
}

public boolean isMirror(TreeNode t1, TreeNode t2){
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    if (t1.val != t2.val) return false;
    return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
}

//利用队列，迭代
public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root.left);
    q.offer(root.right);
    while (!q.isEmpty()){
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.offer(t1.left);
        q.offer(t2.right);
        q.offer(t1.right);
        q.offer(t2.left);
    }
    return true;
}

/**
104。二叉树的最大深度
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。
示例：
给定二叉树 [3,9,20,null,null,15,7]，
    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
*/
//递归， DFS
public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
}
//迭代，利用队列

/**
107.二叉树的层次遍历(自底向上)
给定一个二叉树，返回其节点值自底向上的层次遍历。 
（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：
[
  [15,7],
  [9,20],
  [3]
]
*/
//1.遍历，DFS 2.利用二叉树深度与list size的关系
public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> re = new ArrayList<>();
    dfs(root, 1, re);
    return re;
}

private void dfs(TreeNode root, int depth, List<List<Integer>> re) {
    if (root == null) return;
    List<Integer> list;
    if (depth > re.size()){
        list = new ArrayList<>();
        re.add(0, list);
    }else {
        list = re.get(re.size() - depth);
    }
    list.add(root.val);
    dfs(root.left, depth +1, re);
    dfs(root.right, depth +1, re);
}

/**
108.将有序数组转换成二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
示例:
给定有序数组: [-10,-3,0,5,9],
一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
      0
     / \
   -3   9
   /   /
 -10  5
*/
 //1.递归 2.二分
public static TreeNode sortedArrayToBST(int[] nums){
    if (nums == null || nums.length == 0) return null;
    int length = nums.length;
    int i = length / 2;
    TreeNode root = new TreeNode(nums[i]);
    int[] leftArr = Arrays.copyOfRange(nums, 0, i);
    int[] rightArr = Arrays.copyOfRange(nums, i+1, length);
    TreeNode left = sortedArrayToBST(leftArr);
    TreeNode right = sortedArrayToBST(rightArr);
    if (left != null){
        root.left = left;
    }
    if (right != null){
        root.right = right;
    }
    return root;
}

/**
110.平衡二叉树
给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
示例 1:
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回 true 。
示例 2:
给定二叉树 [1,2,2,3,3,null,null,4,4]
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
 返回false
*/
public static boolean isBalanced(TreeNode root){
    if (root == null) return true;
    if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1){
        return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
}

public static int getDepth(TreeNode t){
    if (t == null) return 0;
    return Math.max(getDepth(t.left), getDepth(t.right)) + 1;
}












