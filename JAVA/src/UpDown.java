import java.util.Random;
import java.util.Scanner;

// 업 다운 게임 만들거임
public class UpDown {
    public static void main(String[] args) {
        int count = 0,input_num;
        Random rm = new Random();
        int choice_number = rm.nextInt(1,100);
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1~100사이의 숫자를 입력해주세요 : ");
            input_num = sc.nextInt();
            if(input_num != choice_number){
                if (input_num > choice_number){
                    System.out.println("Down");
                    count++;
                    continue;
                }
                if (input_num<choice_number){
                    System.out.println("Up");
                    count++;
                    continue;
                }
            }
            else {
                System.out.printf("정답입니다 %d번시도 하였습니다.",count);
                break;
            }
        }
    }
}