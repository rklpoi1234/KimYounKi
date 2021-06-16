
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Integer[] arr = new Integer[N];
        int max = 0;

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(sc.next());
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i=0; i<arr.length; i++) {
            arr[i] = arr[i] + i + 1;
            if(max <= arr[i])
                max = arr[i];
        }
        System.out.print(max+1);
    }
}