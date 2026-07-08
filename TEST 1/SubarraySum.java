import java.util.HashMap;
import java.util.Scanner;

public class SubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == k) {
                System.out.println("Found from 0 to " + i);
                return;
            }

            if (map.containsKey(sum - k)) {
                int start = map.get(sum - k) + 1;
                System.out.println("Found from " + start + " to " + i);
                return;
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        System.out.println("Not Found");
    }
}