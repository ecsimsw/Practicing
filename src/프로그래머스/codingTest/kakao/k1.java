package 프로그래머스.codingTest.kakao;


/*
1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다
 */


/*
"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
예2	"z-+.^."	"z--"
예3	"=.="	"aaa"
예4	"123_.def"	"123_.def"
예5	"abcdefghijklmn.p"	"abcdefghijklmn"
 */

public class k1 {
    static public void main(String[] args){

        String test ="-_.~!@#$%^&*()=+[{]}:?,<>/";
        test = test.toLowerCase();
        test = replace(test);

//        System.out.println(test);

        StringBuilder sb = comma(test);
        System.out.println("comma : "+ sb);

        if(sb.length()>0){
            if(sb.charAt(0) =='.'){ sb = sb.replace(0,1,""); }
        }

        if(sb.length()>0) {
            if (sb.charAt(sb.length() - 1) == '.') {
                sb = sb.replace(sb.length() - 1, sb.length(), "");
            }
        }
//        System.out.println("첫 끝 제거 : "+ sb);

        if(sb.length() == 0){sb= new StringBuilder("a");}

        sb = moreThan16(sb);

        if(sb.length()>0) {
            if (sb.charAt(sb.length() - 1) == '.') {
                sb = sb.replace(sb.length() - 1, sb.length(), "");
            }
        }
//        System.out.println("16이상 : " + sb );

        sb= lessThan3(sb);
//        System.out.println("3미만 : "+ sb);

        String answer = sb.toString();
        System.out.println(answer);
    }

    static String replace(String test){
        //~!@#$%^&*()=+[{]}:?,<>
        // 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)
        test = test.replaceAll("~","");
        test = test.replaceAll("!","");
        test = test.replaceAll("@","");
        test = test.replaceAll("#","");
        test = test.replaceAll("\\$","");
        test = test.replaceAll("%","");
        test = test.replaceAll("\\^","");
        test = test.replaceAll("&","");
        test = test.replaceAll("\\*","");
        test = test.replaceAll("\\(","");
        test = test.replaceAll("\\)","");
        test = test.replaceAll("=","");
        test = test.replaceAll("\\+","");
        test = test.replaceAll("\\[","");
        test = test.replaceAll("]","");
        test = test.replaceAll("\\{","");
        test = test.replaceAll("}","");
        test = test.replaceAll(":","");
        test = test.replaceAll("\\?","");
        test = test.replaceAll("\\\\","");
        test = test.replaceAll("/","");
        test = test.replaceAll(",","");
        test = test.replaceAll("<","");
        test = test.replaceAll(">","");
        return test;
    }

    static StringBuilder comma(String test){
        StringBuilder sb = new StringBuilder();
        char[] chars = test.toCharArray();

        for(int i=0; i<test.length(); i++){
            if(chars[i]=='.') {
                if(i!=test.length()-1){
                    if (chars[i + 1] == '.') {
                        sb.append(chars[i]);
                        i++;
                        while (i < test.length()) {
                            if (chars[i] == '.') {
                                i++;
                            } else {
                                sb.append(chars[i]);
                                break;
                            }
                        }
                    }
                    else{
                        sb.append(chars[i]);
                    }
                }
                else{
                    sb.append(chars[i]);
                }
            }
            else{ sb.append(chars[i]); }
        }

        return sb;
    }

    static StringBuilder moreThan16(StringBuilder sb){
        if(sb.length()>=16){
            sb.replace(15, sb.length(),"");
        }
        return sb;
    }

    static StringBuilder lessThan3(StringBuilder sb){
        if(sb.length() < 3){
            char lastChar = sb.charAt(sb.length()-1);
            while(sb.length()<3){
                sb.append(lastChar);
            }
        }
        return sb;
    }
}
