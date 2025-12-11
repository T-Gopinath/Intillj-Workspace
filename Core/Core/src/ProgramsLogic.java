import java.util.*;
import java.util.stream.IntStream;

 public class ProgramsLogic {

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
         }

     public void secondHighest(int[] num) {
         int max1 = Integer.MIN_VALUE;
         int max2 = Integer.MAX_VALUE;
         for (int n : num) {
             if (n > max1) {
                 max2 = max1;
                 max1 = n;
             } else if (n > max2 && n != max1) {
                 max2 = n;
             }
         }
     }

     //Detect loop in linked list Detect cycle in linked list using fast and slow pinters.
     static class ListNode{
         int data;
         ListNode next;
         ListNode(int data) {
             this.data = data;
             this.next = null;
         }
     }

         public void loopInLinkedList( ListNode head  ) {
             ListNode slow=head, fast=head;
             while(fast != null && fast.next != null) {
                 slow=slow.next;
                 fast = fast.next.next;
                 if (slow == fast) {
                     System.out.println("Cylcle ");
                 }
             }
         }

         public void pllindromeNumber(int number) {
             int n = number;
             int rev = 0;
             while(n>0) {
                 rev=rev*10+n%10;
                 n=n/10;
                 System.out.println(rev==n);
             }
         }

         //Reverse a Linked List, Reverse single linked list in-place.
         /*   public void reverseLinkedList(ListNode head ) {
                ListNode prev=null;
                curr=head;
                while(curr != null) {
                    ListNode nxt=curr.next;
                    curr.next = prev;
                    prev=curr;
                    curr=nxt;
                    head=prev;
                }
                }
            */

        public static int[] merge(int[] arr1, int[] arr2) {
           return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
        }

     public void anagrams(String s1, String s2) {
         char[] s11 = s1.toCharArray() ; Arrays.sort(s11);
         char[] s22 = s2.toCharArray(); Arrays.sort(s22);
         boolean b = Arrays.equals(s11, s22);
     }

     public void nonRepeatingChar() {
         String s = "stress";
         Map<Character, Integer> map = new LinkedHashMap<>();
         for (char c : s.toCharArray())
             map.put(c, map.getOrDefault(c, 0) + 1);
         for (char c : s.toCharArray())
             if (map.get(c) == 1) {
                 System.out.println(c);
                 break;
             }
     }

     // missing number
     public void missingNumber(int[] arr) {
         int n = 5;
         int[] arr1 = {1,2,3};
         int sum = n*(n+1);
         for(int x: arr)
         sum -=x;
     }
     //2. Count digits (no String)
     public void coutNumbers(int num) {
         int count = 0;
         while ( num> 0) {
             count++;
            num/= 10;
         }
     }

     //1. Reverse a number (no String) Reverse digits of an integer without converting to String
     public static int reverseNumber(int num) {
         num =123;
         int rev = 0;
         while(num > 0) {
             rev = rev *10 + num%10;
             num=num/10;
         }
         return num;
     }

     // //14) Dynamic Programming
     public int fib(int n) {
            if (n<2) return n;
            int a=0,b=1;
            for (int i=2;i<=n;i++) {
                int c=a+b;
                a=b;
                b=c;
            }
            return b;
        }

     //13) Sliding Window - Longest substring without repeating chars
     public int lengthOfLongestSubstring(String s) {
         int[] last = new int[256];
         Arrays.fill(last, -1);
         int res=0, start=0;
         for (int i=0;i<s.length();i++) {
             start = Math.max(start, last[s.charAt(i)] + 1);
             res = Math.max(res, i - start + 1);
             last[s.charAt(i)] = i;
         }
         return res;
     }

     //12) Two pointers - Container with most water
     int maxArea(int[] h) {
         int l=0, r=h.length-1, ans=0;
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
        //11) Topological Sort (Kahn's)
        List<Integer> topo(int n, List<List<Integer>> adj) {
         int[] indeg = new int[n];
         for (int u=0;u<n;u++)
             for (int v: adj.get(u))
                 indeg[v]++;
                Queue<Integer> q = new ArrayDeque<>();
                for (int i=0;i<n;i++)
                    if (indeg[i]==0)
                    q.add(i);
                    List<Integer> order = new ArrayList<>();
                        while (!q.isEmpty()) {
                            int u=q.poll();
                            order.add(u);
                            for (int v: adj.get(u))
                                if (--indeg[v]==0) q.add(v);
                        }
         return  order.size()==n ? order : Collections.emptyList();
     }

        // 10) Graph - DFS (recursive)
        public void dfs(int u, boolean[] vis, List<List<Integer>> adj)
         {
             vis[u]=true;
             for(int v: adj.get(u))
                 if(!vis[v])
                     dfs(v,vis,adj);
         }


     //9) Union-Find (Disjoint Set) class DSU
     class DSU {
         int[] parent, rank;
         DSU(int n)
         {
             parent=new int[n];
             rank=new int[n];
             for(int i=0;i<n;i++)
                 parent[i]=i;
         }
         public int find(int x)
         {
             if (parent[x] != x) {
                 parent[x] = find(parent[x]);  // Path compression
             }
             return parent[x];
         }
         void union(int a,int b) {
             a=find(a);
             b=find(b);
             if(a==b)
                return;
             if(rank[a]<rank[b])
                 parent[a]=b;
             else if(rank[b]<rank[a])
                 parent[b]=a;
             else {
                 parent[b]=a; rank[a]++;
             }
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

         //7) Binary Search Tree - Insert & Search Insert:
         public TreeNode insert(TreeNode root, int val) {
             if (root==null) return new TreeNode(val);
             if (val < root.val)
                 root.left = insert(root.left, val);
             else
                 root.right = insert(root.right, val);
             return root;
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
             }
             return res;
         }

         //6) Binary Tree - Inorder Traversal (Recursive + Iterative) Recursive:
         public void inorder(TreeNode  node, List<Integer> res) {
             if (node==null)
                 return;
             inorder(node.left,res);
             res.add(node.val);     inorder(node.right,res);
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

//2) Reverse Linked List (Iterative) Problem: Reverse singly linked list.

         public ListNode  reverse(ListNode head) {
             ListNode prev = null;     ListNode cur = head;
             while (cur != null) {
                 ListNode next = cur.next;
                 cur.next = prev;
                 prev = cur;
                 cur = next;
             }
             return prev;
         }


         // Given nums[] and target, return indices of two numbers
         // summing to target. Solution idea: single-pass HashMap storing value->index
         static int[] twoSum(int[] nums, int target) {
             Map<Integer,Integer> m = new HashMap<>();
             for (int i=0; i<nums.length; i++)     {
                 int need = target - nums[i];
                 if(m.containsKey(need))
                     return new int[]{m.get(need), i};
                 m.put(nums[i], i);
             }
             throw new IllegalArgumentException("No solution");
         }

         }



 }

