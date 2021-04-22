
public class Crp 
{

    public static void main(String[] args) 
    {

        Shift shf = new Shift();
        // 암호화 target 앞문자열 뒤정수(shift)
        System.out.println(shf.shift("LEON", 3));
    }
}

class Shift 
{
    public String shift(String s, int n) 
    {
        StringBuilder sb = new StringBuilder();
        // 연산시마다 필요한 메모리를 추가적할당 사용
        // https://taiyokara.tistory.com/32

        for (int i = 0; i < s.length(); i++) 
        { // string값길이만큼반복 스트링번지값에서하나씩 캐릭터형ch로변환
            char ch = s.charAt(i);
            if (ch > 'A' && ch < 'Z') 
            { // 정수형인지 문자형인지구분을해줘야됩니다.
                ch = (char) (ch + n);
                if (ch > 'Z') 
                { // z캐릭터값을 초과했을시 a~z한사이클안 26개의알파벳
                    ch -= 26;
                }
            }
            sb.append(ch);
        }

        return sb.toString();
    }
}
