import java.util.*;
public class palindrome
{
        public static void main(String[] args) {

            int arr[] = {0, 2, 5, 7, 9, 10};
            Set<Integer> set = new HashSet<>();
            for (int dup : arr) {
                boolean add = set.add(dup);
                if (!add)
                    System.out.println(dup);
            }
        }
}