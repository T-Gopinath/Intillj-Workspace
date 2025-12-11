import java.util.Arrays;
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
}

