package sec09.calc;
import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        //리스트에 16, 31, 3, 55, 1을 담습니다.
        List<Integer> list = new ArrayList<>();
        list.add(16);
        list.add(31);
        list.add(3);
        list.add(55);
        list.add(1);
        System.out.println(quickSort(list));

    }

    public static List<Integer> quickSort(List<Integer> list) {
        //피벗보다 작은 숫자들을 담을 리스트를 선언
        List<Integer> less = new ArrayList();
        //피벗보다 큰 숫자들을 담을 리스트를 선언
        List<Integer> greater = new ArrayList();
        //작은 숫자, 피벗, 큰 숫자들을 순서대로 담을 리스트를 선언
        List<Integer> finalList = new ArrayList();
        // 리스트에 원소가 1개일 때 그냥 반환한다.
        if (list.size() < 2) {
            return list;
        } else {

            int pivot = list.get(0);
            for (int i : list) {
                if (i < pivot) {
                    less.add(i);
                }
                if (i > pivot) {
                    greater.add(i);
                }
            }
            //기준 원소보다 작은 숫자들을 퀵정렬한 결과를 리스트에 추가한다.
            finalList.addAll(quickSort(less));
            //피벗이 된 원소를 리스트에 추가한다.
            finalList.add(pivot);
            //기준 원소보다 큰 숫자들을 퀵정렬한 결과를 리스트에 추가한다.
            finalList.addAll(quickSort(greater));
           
            return finalList;
        }

    }

}

