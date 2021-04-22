import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class CrpPatient {
    // 환자식
    // 한마디로 치환 암호 : 단일 치환
    // public static void main(String[] args) {
    // String k = "LEON";
    // String S = "ROSE";
    // String ch = "";
    // String[] Arr;
    // String[] kArr;
    // String[] chArr;
    // String[] CrpArr;

    // Stack<String> stack = new Stack<>();

    // charchange cc = new charchange(k, kArr);

    // }

    // }

    // public charchange(String k, String[] kArr)
    // {
    // for (int i = 0; i < x.length; i++)
    // {
    // stack(x[i].charCodeAt(0))
    // }
    // return y.map(m - 65);
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> com = new ArrayList<Integer>();
        // sub 에 배열값을 담기위한
        // har[] arr;
        System.out.println("text : ");

        String text = sc.nextLine(); // next vs nextLine?

        text = text.toUpperCase(); // 소문자 -> 대문자 경우의수줄이기

        char arr[] = text.toCharArray(); // 문자형으로... arr가 문자형을몰라서여기서선언하였습니땃

        for (int i = 65; i < 90; i++) { // 총 25
            com.add(i); // 캐릭터값으로 쓸 값들이 추가됨됨
        }
        Crp(com, arr);

    }

    // encryption
    public static void Crp(ArrayList<Integer> com, char arr[]) {
        Collections.shuffle(com); // s안붙여서고생하지말아야겠습니다
        // 말그대로 셔플 이것도 추후 블로그에다 추가 해서 봐야겠어요
        // List나 배열의 내용을 랜덤 형태로 보여줄때
        char crp_arr[] = new char[arr.length];// 5글자면 arr에는 5칸만들어지겟지렁이

        for (int i = 0; i < arr.length; i++) {
            int text = com.get(arr[i] - 65); // a가들어왔다면 0을 com에 +
            crp_arr[i] = (char) text;
        }
        String crp_text = String.valueOf(crp_arr); //string인 crp_arr을리터
        System.out.println(crp_text);

    }

}