import org.w3c.dom.Node;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.*;

class Codechef {

    public static void main (String[] args) throws java.lang.Exception
    {
            List<String> stringSort = List.of("a","bd","dd","efg");
    }

   // Given nums[] and target, return indices of two numbers
   // summing to target. Solution idea: single-pass HashMap storing value->index

    static int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> m = new HashMap<>();
            for (int i=0; i<nums.length; i++)
                {
                    int need = target - nums[i];
                    if(m.containsKey(need))
                        return new int[]{m.get(need), i};
                    m.put(nums[i], i);
                }
            throw new IllegalArgumentException("No solution"); }
    }

   //2) Reverse Linked List (Iterative) Problem: Reverse singly linked list.

    class ListNode {
        int next;
     }

        public ListNode ListNode reverse(ListNode head) {
            ListNode prev = null;     ListNode cur = head;
                while (cur != null) {
                    ListNode next = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = next;
                    }
                return prev;
        }

        // 3) Detect Cycle in Linked List (Floyd)

    boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next!= null)
                {
                        if (slow == fast) return true;
                        slow = slow.next;         fast =
                        fast.next.next;
                }
            return false;
    }

    //4) Stack - Evaluate Reverse Polish Notation Use stack and parse tokens.

        int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
            for(String t: tokens) {
                switch(t) {
                case "+" -> st.push(st.pop() + st.pop());
             case "-" -> {
                    int b=st.pop(), a=st.pop(); st.push(a-b); }
                case "*" ->
                    st.push(st.pop() * st.pop());
             case "/" -> { int b=st.pop(), a=st.pop();
                st.push(a/b); }
                default -> st.push(Integer.parseInt(t));
            }
            }
            return
                st.pop();
    }


    //5) Queue - BFS on Graph (Shortest path in unweighted graph) Use Queue for level-order.

    public int bfs(int start, int target, List<List<Integer>> adj) {
            int n = adj.size();
         boolean[] vis = new boolean[n];
         Queue<Integer> q = new ArrayDeque<>();
         q.add(start);
         vis[start]=true;
         int level=0;
         while (!q.isEmpty()) {
             int sz=q.size();
            for (int i=0;i<sz;i++) {
                int u=q.poll();
                if (u==target)
                    return level;
                for (int v: adj.get(u))
                    if (!vis[v])
                    {
                        vis[v]=true;
                        q.add(v);
                }
            }         level++;
        }
        return -1;
    }

    //6) Binary Tree - Inorder Traversal (Recursive + Iterative) Recursive:
        public void inorder(TreeNode  node, List<Integer> res) {
        if (node==null)
                return;
            inorder(node.left,res);
            res.add(node.val);     inorder(node.right,res);
    }
        List<Integer> inorderIter(TreeNode root) {
            List<Integer> res = new  ArrayList<>();
            Deque<TreeNode> st = new ArrayDeque<>();
            TreeNode cur = root;
            while(cur != null || !st.isEmpty()) {
                    while (cur != null) {
                            st.push(cur); cur = cur.left;
                    }
                    cur = st.pop();
                    res.add(cur.val);
                    cur = cur.right;
            }     return res; }

    //7) Binary Search Tree - Insert & Search Insert:
    public TreeNode insert(TreeNode root, int val) {
        if (root==null) return new TreeNode(val);
        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        return root;
}
//search:
    boolean search(TreeNode root, int val) {
        while (root != null) {
                if (root.val == val)
                    return true;
                root = val < root.val ? root.left : root.right;
        }
        return false;
}
    // 8) Heap - Kth largest (Min-heap)
   public  int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n: nums) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }     return
               pq.peek(); }

    //9) Union-Find (Disjoint Set) class DSU

    DSU {
        int[] parent, rank;
        DSU(int n)
         {
             parent=new
             int[n];
            rank=new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }
        int find(int x)
        { return         parent[x]==x?x:parent[x]=find(parent[x]);
        }
        void union(int a,int b)
        {         a=find(a);
        b=find(b); if(a==b)
            return;
        if(rank[a]<rank[b]) parent[a]=b;
        else if(rank[b]<rank[a])
        parent[b]=a;
        else {
                parent[b]=a; rank[a]++;
            }
        }
    }
    // 10) Graph - DFS (recursive)

    void dfs(int u, boolean[] vis, List<List<Integer>> adj)
        {
            vis[u]=true;
            for(int v: adj.get(u))
                if(!vis[v])
                    dfs(v,vis,adj);
        }

            //11) Topological Sort (Kahn's)

        List<Integer> topo(int n, List<List<Integer>> adj)
            {     int[]
                indeg = new int[n];
                for (int u=0;u<n;u++)
                    for (int v: adj.get(u))
                        indeg[v]++;
                    Queue<Integer> q = new ArrayDeque<>();
                    for (int i=0;i<n;i++)
                        if (indeg[i]==0) q.add(i);
                     List<Integer> order = new ArrayList<>();
                     while (!q.isEmpty()) {
                         int u=q.poll();
                      order.add(u);
                      for (int v: adj.get(u))
                            if (--indeg[v]==0) q.add(v);
                     }
                     return
                         order.size()==n ? order : Collections.emptyList();
            }

            //12) Two pointers - Container with most water
            int maxArea(int[] h) {
                int l=0, r=h.length-1,
                    ans=0;
                while (l<r)
                {
                    ans = Math.max(ans, Math.min(h[l],h[r])*(r-l));
                    if(h[l] < h[r])
                        l++;
                    else
                        r--;
                }
                return ans;
    }

    //13) Sliding Window - Longest substring without repeating chars

 public int lengthOfLongestSubstring(String s) {
    int[] last = new int[256];
    Arrays.fill(last, -1);
     int res=0, start=0;
     for (int i=0;i<s.length();i++) {
         start = Math.max(start,
            last[s.charAt(i)] + 1);
         res = Math.max(res, i - start + 1);
         last[s.charAt(i)] =            i;
     }
     return res;
}

  //14) Dynamic Programming
  Fibonacci (bottom-up) int fib(int n) {     if (n<2) return n;     int
        a=0,b=1;     for (int i=2;i<=n;i++) { int c=a+b; a=b; b=c; }     return b; }

   //1. Reverse a number (no String) Reverse digits of an integer without converting to String

    public static int reverseNumber(int num) {
        num =123;
         int rev = 0;
         while(num > 0) {
                rev = rev *10 + num%10;
                num=num/10;
         }
          return num;
//2. Count digits (no String
            public void coutNumbers(int num) {
                    int count = 0;
                    while ( n > 0) {
                        count++;
                        n /= 10;
                    }
        }

        // missing number
        public void missingNumber(int[] arr) {
                    int n = 5;
                    int[] arr1 = {1,2,3};
                    int sum = n*(n+!);
                    for()int x: arr)
            sum -=x;
        }

        public void nonRepeatingChar() {
            String s = "stress";
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
            for (char c : s.toCharArray())
                if (map.get(c) == 1) {
                    System.out.println(c);
                    break;
                }
        }
        }

        public void anagrams(String s1, String s2) {
            char[] s11 = s1.toCharArray() ; Arrays.sort(s11);
            char[] s22 = s2.toCharArray(); Arrays.sort(s22);
            boolean b = Arrays.equals(s11, s22);
        }

        pubic void secondHighest(int[] num) {
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MAX_VALUE;
            for(int n: num) {
                if(n>max1) {
                    max2=max1;
                    max1=n;
                } else if(n > max2 && n!= max1) {
                    max2 = n;
            }
        }

            //Detect loop in linked list Detect cycle in linked list using fast and slow pinters.

            public void loopInLinkedList(   ) {
                    ListNode slow=head, fast=head;
                    while(fast != null && fast.next != null) {
                            slow=slow.next;
                            fast = fast.next.next;
                        if (slow == fast) {
                            System.out.println("Cylcle ");
                        }
                        }
                    }
            }

            public void pllindromeNumber(int number) {
                int origin = number;
                int rev = 0;
                while(n>0){ rev=rev*10+n%10;
                n=n/10;
                System.out.println(rev==org);
                }
            }

           //Reverse a Linked List, Reverse single linked list in-place.
            public void reverseLinkedList() {
                ListNode prev=null;
                curr=head;
                while(curr != null) {
                        LisstNode nxt=curr.next;
                        curr.next = prev;
                        prev=curr;
                        curr=nxt;
                        head=prev;
                }
            }

    public static int[] merge(int[] arr1, int[] arr2)  {
            IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted();
        }

        // Moving zeros to end
        public static void moveZeros(int[] arr) {
            int index = 0; // position to place next non-zero

            // Move all non-zero values to the front
            for (int num : arr) {
                if (num != 0) {
                    arr[index++] = num;
                }
            }

            // Fill the rest with zeros
            while (index < arr.length) {
                arr[index++] = 0;
            }


            // Rotate array by k (Juggling)
            //Rotate array to right by k positions using gcd method.

}

    //Find pair in sorted array that sums to target using two pointers.
    public static boolean findPair(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum == target) {
                System.out.println("Pair found: " + arr[left] + ", " + arr[right]);
                return true;
            }

            if (sum < target) {
                left++;     // need a bigger sum
            } else {
                right--;    // need a smaller sum
            }
        }

        System.out.println("No pair found");
        return false;
    }

    //Implement stack using queues Make LIFO using two FIFO queues.
import java.util.*;

class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        // Step 1: Add new element to q2
        q2.add(x);

        // Step 2: Move everything from q1 → q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: Swap q1 & q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.remove();  // O(1)
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    //Rotate array by k (Juggling)
    //Rotate array to right by k positions using gcd method.
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Rotate Right by k using Juggling Algorithm
    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n;           // reduce extra rotations
        if (k == 0) return;  // no rotation

        int g = gcd(n, k);   // number of cycles

        for (int i = 0; i < g; i++) {
            int temp = arr[i];
            int j = i;

            while (true) {
                int next = (j + k) % n;

                if (next == i)
                    break;

                arr[j] = arr[next];
                j = next;
            }
            arr[j] = temp;
        }
    }
}

    // Inorder traversal without recursion (stack)

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class InorderTraversal {

    static void inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            // Go to the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Pop and visit
            curr = stack.pop();
            System.out.print(curr.val + " ");

            // Go to right subtree
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        // Sample tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        inorder(root);  // Output: 1 3 2
    }

                  //    4
                  //   / \
                  //  2   6
                  //  / \ / \
                  //  1  3 5  7

    /*Stack operations: Push 4, push 2, push 1
    Visit 1
    Visit 2
    Visit 3
    Visit 4
    Visit 5
    Visit 6
    Visit 7*/


}

// Validate parentheses
//Check if string of parentheses is valid.

/*
    "()[]{}"      → true
    "(]"          → false
    "([{}])"      → true
    "([)]"        → false

 */

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                // If closing without matching opening → invalid
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // Check matching pairs
                if ( (c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[') ) {
                    return false;
                }
            }
        }

        // All brackets should be closed
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));   // true
        System.out.println(isValid("(]"));       // false
        System.out.println(isValid("([{}])"));   // true
    }
}
    //Fibonacci Numbers (Iterative Method)
    /*
        fib(0) = 0
    fib(1) = 1
    fib(n) = fib(n-1) + fib(n-2)
    */
    public class FibonacciIterative {

        public static int fibonacci(int n) {
            if (n <= 1) return n;

            int a = 0, b = 1;   // first two Fibonacci numbers

            for (int i = 2; i <= n; i++) {
                int c = a + b;
                a = b;
                b = c;
            }

            return b;
        }

        public static void main(String[] args) {
            System.out.println(fibonacci(10));   // Output: 55
        }
    }

    /*Binary Search (Iterative)
    Works on a sorted array (ascending order).
        🧠 Logic

Start with left = 0, right = n-1.

Find mid.

Compare:

If arr[mid] == target → return.

If target > arr[mid] → search right.

If target < arr[mid] → search left.

Repeat while left <= right

📌 Time & Space

Time: O(log n)

Space: O(1)*/

public class BinarySearchIterative {

    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;  // avoids overflow

            if (arr[mid] == target) {
                return mid;      // found
            }
            else if (arr[mid] < target) {
                left = mid + 1;  // search right half
            }
            else {
                right = mid - 1; // search left half
            }
        }

        return -1;  // not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72};
        System.out.println(binarySearch(arr, 23)); // Output: 5
    }
}

    /*
        Count set bits — Brian Kernighan’s algorithm
        Brian Kernighan’s trick repeatedly clears the lowest set bit (turns the rightmost 1 to 0) using n = n & (n-1).
        Each iteration removes one 1, so the loop runs exactly as many times as there are set bits.
        Complexity: O(k) where k = number of 1-bits (not number of bits overall). Space O(1).
        How it works (quick example):
        n = 0b10110 (22)
        n & (n-1) → 0b10110 & 0b10101 = 0b10100 (clears the lowest 1)
        repeat until n == 0 — number of iterations = number of 1s (here 3).
     */


public class BitCount {
    // Counts 1-bits in 32-bit two's-complement representation
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    //If you want the count for an unsigned 32-bit value passed as a long:
    public static int countSetBitsUnsigned(long value) {
        // treat value as unsigned 32-bit in lower bits
        int n = (int)(value & 0xFFFFFFFFL);
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }


    // Example / quick test
    public static void main(String[] args) {
        System.out.println(countSetBits(0));      // 0
        System.out.println(countSetBits(1));      // 1
        System.out.println(countSetBits(22));     // 3  (10110)
        System.out.println(countSetBits(-1));     // 32 (all ones in 32-bit two's complement)
        // Note: For Java you can also use Integer.bitCount(n) which is highly optimized.
    }
}
    /*
        ✅ Power of Two Check (Bit Trick)

        A number n is a power of two if and only if:

        n > 0

        n & (n - 1) == 0

        Because a power-of-two number has exactly one set bit, and subtracting 1 flips all lower bits.
        Example: 8 = 1000, 7 = 0111, 1000 & 0111 = 0.
     */
   /* public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
*/

    /*✅ 1. Vertical Scan (Most Common Approach)

We compare characters of each string at the same index.

Time: O(N·M)

N = number of strings, M = length of smallest string

✅ Java Code (Vertical Scan)*/

    class Langestofsubstring{
        public static String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";

            for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);

                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                        return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0];
       }
    }

    /*
        ✅ Matrix Transpose (In-Place) — Java Program
        Logic
        For a square matrix, transpose can be done by:
        Swapping elements at (i, j) with (j, i)
        Only for j > i (upper triangle), to avoid double swapping.
     */
    public class InPlaceTranspose {

        public static void transpose(int[][] matrix) {
            int n = matrix.length;

            // In-place transpose
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    // swap matrix[i][j] and matrix[j][i]
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        public static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            System.out.println("Original Matrix:");
            printMatrix(matrix);

            transpose(matrix);

            System.out.println("\nTransposed Matrix:");
            printMatrix(matrix);
        }
    }

    /*
        ✅ Java Program: Spiral Matrix Traversal (Clockwise)

            For the sample 4×4 matrix, output will be:
                Spiral Order: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]

     */
    import java.util.*;

public class SpiralMatrixTraversal {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return result;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // 1️⃣ Traverse Left → Right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // 2️⃣ Traverse Top → Bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // 3️⃣ Traverse Right → Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // 4️⃣ Traverse Bottom → Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13,14, 15, 16}
        };

        List<Integer> result = spiralOrder(matrix);
        System.out.println("Spiral Order: " + result);
    }
}

/*
    Here is a clear and clean Java program to find the K-th smallest element using QuickSelect (average time: O(n)):
    ✅ Java Program — QuickSelect (Kth Smallest Element)

        ✅ Example

        Input array:
        [7, 10, 4, 3, 20, 15]
        k = 3

        Output:

        3rd smallest element is: 7

 */

import java.util.*;

public class QuickSelect {

    // Function to partition the array
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];     // choosing last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;  // pivot index
    }

    // QuickSelect function
    public static int quickSelect(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int pivotIndex = partition(arr, low, high);

            // If pivot is the kth smallest
            if (pivotIndex == k - 1) {
                return arr[pivotIndex];
            }

            // If pivot index is greater, search left
            if (pivotIndex > k - 1) {
                return quickSelect(arr, low, pivotIndex - 1, k);
            }

            // Else search right
            return quickSelect(arr, pivotIndex + 1, high, k);
        }

        return -1; // should not reach here for valid k
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        int result = quickSelect(arr, 0, arr.length - 1, k);
        System.out.println(k + "rd smallest element is: " + result);
    }
}


/*
            ✅ Java Program — Serialize & Deserialize Binary Tree (Preorder)
            Here is a clean, interview-ready Java program to
            Serialize + Deserialize a Binary Tree using Preorder Traversal with
             Null markers (e.g., "1,2,null,null,3,4,null,null,5,null,null").

            This is the standard LeetCode / interview solution.


                import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}
 */



public class SerializeDeserializeTree {

    // ---------------- SERIALIZATION ----------------
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // ---------------- DESERIALIZATION ----------------
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();

        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }

    // ---------------- TEST ----------------
    public static void main(String[] args) {
        SerializeDeserializeTree codec = new SerializeDeserializeTree();

        // Building sample tree:
        //        1
        //      /   \
        //     2     3
        //          / \
        //         4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize
        String s = codec.serialize(root);
        System.out.println("Serialized: " + s);

        // Deserialize
        TreeNode node = codec.deserialize(s);
        System.out.println("Deserialization success: " + (node != null));
    }

    /*
            ✅ Java Program — Check if Two Trees Are Identical

                Here is a clean and simple Java program to check if two binary trees are identical.

            Two trees are identical if:
            ✔ Structure is same
            ✔ Corresponding node values are same
            class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}
     */



public class IdenticalTrees {

    public static boolean isIdentical(TreeNode p, TreeNode q) {
        // If both are null → identical
        if (p == null && q == null) return true;

        // If either is null → not identical
        if (p == null || q == null) return false;

        // Check value + left subtree + right subtree
        return (p.val == q.val) &&
                isIdentical(p.left, q.left) &&
                isIdentical(p.right, q.right);
    }

    public static void main(String[] args) {
        // Tree 1
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);

        // Tree 2
        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.right = new TreeNode(3);

        boolean result = isIdentical(a, b);
        System.out.println("Trees are identical: " + result);
    }
}
}

/*
        ✅ LRU Cache using LinkedHashMap (Simplest & Recommended)
        LinkedHashMap supports “accessOrder = true”, which automatically moves accessed entries to the end,
         helping us implement LRU with minimal code.


         🔍 How it Works

        LinkedHashMap stores keys in insertion order or access order.

        We enable access-order → whenever you call get(), the key moves to the end.

        removeEldestEntry() removes the oldest entry when size exceeds capacity.

        Both get() and put() are O(1).

        👍 Output
        {1=A, 2=B, 3=C}
        {3=C, 1=A, 4=D}

 */

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    public LRUCache(int capacity) {
        // accessOrder = true → moves element to end on get()
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;   // remove LRU
    }

    public V getValue(K key) {
        return super.getOrDefault(key, null);
    }

    public void putValue(K key, V value) {
        super.put(key, value);
    }

    public void printCache() {
        System.out.println(super.toString());
    }
}

public class Main {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.putValue(1, "A");
        cache.putValue(2, "B");
        cache.putValue(3, "C");
        cache.printCache(); // {1=A, 2=B, 3=C}

        cache.getValue(1);  // Makes 1 most recently used
        cache.putValue(4, "D"); // Removes LRU → key 2
        cache.printCache(); // {3=C, 1=A, 4=D}
    }
}


/*
        Sure! Here’s a Java implementation of a Min Stack that supports push, pop, top, and getMin operations all in O(1) time complexity using an auxiliary stack:

        ✅ Explanation:

        Two stacks approach:

        stack stores all elements.

        minStack stores the minimum elements.

        On push:

        Always push to the main stack.

        Push to minStack if the new element is ≤ current minimum.

        On pop:

        Pop from stack.

        If popped element equals minStack’s top, pop it from minStack too.

        getMin always returns minStack.peek(), ensuring O(1) access to the minimum element.

        This method guarantees that all operations, including getMin, run in constant time.

        If you want, I can also show a more space-efficient version that uses only one stack while still keeping O(1) getMin.

 */

    import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;      // main stack
    private Stack<Integer> minStack;   // stack to keep track of minimums

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        // push to minStack if it's empty or x is smaller than or equal to current min
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        int removed = stack.pop();
        // if the removed element is the minimum, pop it from minStack too
        if (!minStack.isEmpty() && removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) throw new RuntimeException("Stack is empty");
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) throw new RuntimeException("Stack is empty");
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(5);
        System.out.println("Min: " + minStack.getMin()); // 3
        minStack.push(2);
        minStack.push(1);
        System.out.println("Min: " + minStack.getMin()); // 1
        minStack.pop();
        System.out.println("Min: " + minStack.getMin()); // 2
        System.out.println("Top: " + minStack.top());    // 2
    }
}


/*      merge overlapping intervals
        ✅ Output for this example:
            Merged Intervals: [[1, 6], [8, 10], [15, 18]]

            How it works:

        Sort intervals by their start time.

        Compare current interval with previous:

        If overlapping (curr.start <= prev.end), merge by updating prev.end.

        Else, add prev to result and move prev to current.

        Add the last interval after the loop.
 */

import java.util.*;

class Interval {
    int start;
    int end;

    Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

public class MergeIntervals {

    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // Sort intervals by start time
        intervals.sort(Comparator.comparingInt(i -> i.start));

        List<Interval> merged = new ArrayList<>();
        Interval prev = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start <= prev.end) {
                // Overlapping intervals, merge them
                prev.end = Math.max(prev.end, curr.end);
            } else {
                // No overlap, add previous interval
                merged.add(prev);
                prev = curr;
            }
        }

        // Add the last interval
        merged.add(prev);

        return merged;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        List<Interval> merged = mergeIntervals(intervals);
        System.out.println("Merged Intervals: " + merged);
    }
}


/*
    Kth largest (heap) Find kth largest using a min-heap of size k
    Algorithm

Create a min-heap of size k.

Iterate through the array:

Add the current element to the heap.

If heap size exceeds k, remove the smallest element (heap root).

After processing all elements, the root of the min-heap is the kth largest element.

Why min-heap?

Because we want the kth largest element, we maintain the k largest elements in the heap.

The smallest among these k elements (the heap root) will be the kth largest overall.
Example

Input: nums = [3,2,1,5,6,4], k = 2
Process using a min-heap of size 2:

Add 3 → heap: [3]

Add 2 → heap: [2,3]

Add 1 → heap: [2,3] (remove 1, size > 2)

Add 5 → heap: [3,5] (remove 2)

Add 6 → heap: [5,6] (remove 3)

Add 4 → heap: [5,6] (remove 4)

Heap root: 5 → 2nd largest element.


✅ Time Complexity:

O(n log k) → for n elements, maintaining heap of size k.

✅ Space Complexity:

O(k) → size of the heap.
 */
 */
 */

 */
import java.util.PriorityQueue;

public class KthLargest {
    public static int findKthLargest(int[] nums, int k) {
        // Min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest to keep heap size k
            }
        }

        // The root of the heap is the kth largest
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Kth largest element is: " + findKthLargest(nums, k));
    }
}


/*
        Topological Sort using Kahn's Algorithm (in-degree method) for a Directed Acyclic Graph (DAG):
        ✅ How it works:

Compute the in-degree for all vertices.

Add vertices with in-degree 0 to a queue.

Remove vertices from the queue one by one, reduce the in-degree of their neighbors, and add new vertices with in-degree 0 to the queue.

If all vertices are processed, we get a valid topological order.

If not all vertices are processed, the graph has a cycle.

Example Output:
Topological Order: [4, 5, 0, 2, 3, 1]
*/

import java.util.*;

public class TopologicalSortKahn {

    // Function to perform topological sort using Kahn's algorithm
    public static List<Integer> topologicalSort(int vertices, List<List<Integer>> adj) {
        int[] inDegree = new int[vertices];  // Array to store in-degrees of all vertices

        // Calculate in-degree for each vertex
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Queue to store vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            topoOrder.add(current);

            // Reduce in-degree of neighboring vertices
            for (int neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check for cycle
        if (topoOrder.size() != vertices) {
            System.out.println("Graph has a cycle! Topological sort not possible.");
            return new ArrayList<>();
        }

        return topoOrder;
    }

    public static void main(String[] args) {
        int vertices = 6;

        // Adjacency list representation of DAG
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Example edges
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> topoOrder = topologicalSort(vertices, adj);

        System.out.println("Topological Order: " + topoOrder);
    }
}
/**
 Word search in grid (DFS backtracking)
 Check if word exists in 2D board.

 ✅ How it works:

 Loop through each cell of the board.

 Start DFS from cells that match the first character of the word.

 Recursively explore all four directions.

 Mark cells as visited by temporarily replacing the character (#) to avoid revisiting.

 Backtrack after DFS by restoring the original character.

 Return true if the entire word is found, false otherwise.
 */

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, int index) {
        // Base case: all characters matched
        if (index == word.length()) return true;

        // Check boundaries and character match
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited by temporarily changing its value
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all 4 directions: up, down, left, right
        boolean found = dfs(board, word, row + 1, col, index + 1)
                || dfs(board, word, row - 1, col, index + 1)
                || dfs(board, word, row, col + 1, index + 1)
                || dfs(board, word, row, col - 1, index + 1);

        // Restore original value (backtrack)
        board[row][col] = temp;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word1 = "ABCCED"; // true
        String word2 = "SEE";    // true
        String word3 = "ABCB";   // false

        System.out.println(exist(board, word1)); // true
        System.out.println(exist(board, word2)); // true
        System.out.println(exist(board, word3)); // false
    }
}

/*
    Subset generation (backtracking)
Generate all subsets (power set).

✅ How it works:

Start with an empty subset.

At each step, either include or exclude the current element (backtracking explores all combinations).

Add the current subset to the result.

Recursively explore the next elements.

Backtrack by removing the last element before exploring the next possibility.

Example output for {1, 2, 3}:

[]
[1]
[1, 2]
[1, 2, 3]
[1, 3]
[2]
[2, 3]
[3]

 */

import java.util.ArrayList;
import java.util.List;

public class SubsetGenerator {

    // Function to generate all subsets
    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    // Backtracking helper function
    private static void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(current));

        // Explore further elements to add
        for (int i = index; i < nums.length; i++) {
            // Include nums[i]
            current.add(nums[i]);
            // Recurse
            backtrack(nums, i + 1, current, result);
            // Backtrack: remove last element
            current.remove(current.size() - 1);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}


/*
        Combination Sum (unique combinations)
        Find combinations summing to target using candidates

        Sure! You want a Java program to find all unique combinations of numbers from a given array (candidates) that sum up to a target value. Each number in candidates can be used multiple times in a combination. This is a classic backtracking problem. Here's a clean implementation:

        ✅ How it works:

Sort candidates (optional but helps pruning).

Start backtracking from the first index.

Add a number to the current combination and recursively try to reach the target.

If target becomes 0 → add combination to the result.

Remove last element (backtrack) and try next candidate.

Example Output:

For candidates = [2,3,6,7] and target = 7:

[2, 2, 3]
[7]

 */

import java.util.*;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Optional: helps to prune branches early
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start,
                                  List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            // Found a valid combination
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                // No need to continue as the array is sorted
                break;
            }

            combination.add(candidates[i]);
            // `i` instead of `i+1` allows reuse of the same element
            backtrack(candidates, target - candidates[i], i, combination, result);
            combination.remove(combination.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> combinations = combinationSum(candidates, target);
        System.out.println("Combinations summing to " + target + ":");
        for (List<Integer> comb : combinations) {
            System.out.println(comb);
        }
    }
}


/*
        Count islands (DFS/BFS)
        Count connected components of 1s in grid.

        ✅ Explanation:

Treat each 1 in the grid as part of a potential island.

For each unvisited 1, start a DFS/BFS to mark all connected 1s.

Each DFS/BFS invocation represents one island → increment the count.

You can consider 4 directions (N, S, E, W) or 8 directions (including diagonals) depending on the problem. Here, I used 8-direction connectivity.

 */

//DFS Approach

public class CountIslandsDFS {
    private static final int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

    // DFS to mark all connected 1s
    private static void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;

        for (int k = 0; k < 8; k++) {
            int newRow = row + rowDir[k];
            int newCol = col + colDir[k];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                    && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                dfs(grid, newRow, newCol, visited);
            }
        }
    }

    public static int countIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println("Number of islands (DFS): " + countIslands(grid));
    }
}

//BFS Approach
import java.util.LinkedList;
import java.util.Queue;

public class CountIslandsBFS {
    private static final int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static void bfs(int[][] grid, int row, int col, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int k = 0; k < 8; k++) {
                int newRow = r + rowDir[k];
                int newCol = c + colDir[k];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                        && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    queue.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

    public static int countIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println("Number of islands (BFS): " + countIslands(grid));
    }
}

