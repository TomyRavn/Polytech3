import java.util.Scanner;

public class PhoneBook {
   String name;
   String tell;

   void show() {
      System.out.println(name + "의 전화번호는" + tell + "입니다.");
   }


   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      System.out.println("인원 수>>");
      int a = sc.nextInt();
      
      PhoneBook[] ok = new PhoneBook[a];

      for (int i = 0; i < ok.length; i++) {
    	 ok[i] = new PhoneBook();
         System.out.print("이름과 전화번호를 입력하세요(이름과 전화번호는 빈 칸 없이 입력)>>");
         ok[i].name = sc.next();
         ok[i].tell = sc.next();

      }

      System.out.println("저장되었습니다.");

      while (true) {
         System.out.println("검색할 이름>>");
         String d = sc.next();

         if (d.equals("그만"))
            break;

         for (int i = 0; i < ok.length; i++) {
            if (d.equals(ok[i].name)) {
               ok[i].show();
               break;
               
            } else if(i+1 == ok.length) {
               System.out.println(d + "은(는) 없습니다.");
         }

      }
   }
}
}