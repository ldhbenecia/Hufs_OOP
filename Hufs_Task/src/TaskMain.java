/* [주석 1 : 과제 설명]
  객체지향 프로그래밍 평가과제 (배점 25점)
  학과 : 컴퓨터전자시스템공학부
  학번 : 201902965
  이름 : 임동혁
  과제 주제 : 한류 관련 처리를 하는 프로그램
*/

// 11.19 Start -> 구현 못한 주석 : 6(배열), 7(컬렉션 프레임워크), 8(파일 입/출력
// 11.21 -> 6(배열) 사용하여 한류 정의 출력, 7, 8 남음

// 입력 받은 조건의 정보 출력 만들어야함. 이거를 상속을 이용해서 같은 틀로 만들면 될듯 
// -> 클래스 상속과 다형성으로 입력받은 숫자에 따른 출력할 정보 타이틀 출력 구현 끝

// 배열, 컬렉션프레임워크 -> 한류 정보를 String 배열로 처리, 7번 컬렉션프레임워크 또한 ArrayList 사용하면 될듯 -> 총 수출액으로 구현 끝

// 8 (파일 입출력) -> 한류 종류를 입력 받아서 입력 받으면 그 단어가 포함된 txt 파일을 열어서 처리
// -> txt 파일로 FAQ 관련 부분 구현 끝

// 1 : 한류 정보
// 2 : 한류 총 수출액
// 3 : 한류 FAQ
// 4 : 종료

import java.util.Scanner;
import java.util.*;
import java.io.*;

class Print{
   public static void print(){
      System.out.println("한류 관련 처리 프로그램을 시작합니다.");
   }
}

public class TaskMain {
  public static void main(String[] args){
    
    int n = 9; // 입력받은 정수 값 선언, 초기 값은 그냥 9로 초기화
    Print p = new Print(); // 시작 멘트 객체 생성
    p.print(); // 시젝 멘트 출력

    Scanner sc = new Scanner(System.in); // 입력 변수 설정
    ChooseOption print = new ChooseOption(); // 프로그램 시작 시 번호별로 정보 출력하기 위한 객체 생성

    while(true) {
      print.print(); // 멘트 출력

      // 주석 4 : 예외 처리
      try {
        n = sc.nextInt(); // 입력 값 받기
        print.select(n); // 입력 값에 맞는 멘트 출력
        break; // 정상적으로 입력 받았으면 탈출
      }
      catch (InputMismatchException e) { // 정수가 아니라 문자나 다른 게 입력되었을 경우 
        sc = new Scanner(System.in); // 입력 초기화
        System.out.println("정상적인 숫자(0 ~ 4)를 입력하세요.");
      }
      if(n == 0) { // n 값이 0이면 바로 프로그램 종료
        break;
      }
    }

    // 주석 6 : 참조 타입(배열)
    // 한류 정보 출력 배열
    String[] HallyuInformation = {
      "한류는 좁게는 음악, 영화, 드라마 같은 대중문화부터 시작하여 넓게는 패션, 화장품, 음식, 관광, 무술, 산업 등 대한민국의 문화가 세계에 알려지는 현상을 뜻한다.", 
      "한류라는 용어는 중화권에서 1990년대 후반 H.O.T. 신드롬이 일어나고, 한국의 아이돌 댄스 그룹과 한국 드라마가 중화권에서 청소년층에게 인기를 끌면서 생겨난 신조어다.", 
      " 이 용어가 직접적으로 만들어진 계기는 모 기사에 따르면 1997년 대만 미디어를 통해서라고 한다. 대만에선 한파주의보를 한류(寒流)라고 부르는데, ", 
      "그해 선풍적인 인기를 끈 한국 드라마들의 경쟁력을 경계해야 한다는 의미에서 한류(韓流)로 바꾸어 불렀다고 한다."
    };

    // 주석 7 : 컬렉션 프레임워크
    // 한류로 인한 총 수출액 ArrayList
    // add 메소드를 이용한 요소 저장
    ArrayList<Integer> year = new ArrayList<Integer>(); // 년도
    year.add(2016);
    year.add(2017);
    year.add(2018);
    year.add(2019);

    ArrayList<Integer> arrayList = new ArrayList<Integer>(); // 문화콘텐츠
    arrayList.add(3119);
    arrayList.add(4724);
    arrayList.add(5356);
    arrayList.add(6384);

    ArrayList<Integer> arrayList2 = new ArrayList<Integer>(); // 소비재 및 관광
    arrayList2.add(4441);
    arrayList2.add(5073);
    arrayList2.add(4707);
    arrayList2.add(5935);


    // 주석 5 : 상속 다형성 -> paint 사용
    // 입력받은 수에 따른 정보 타이틀 출력 -> 상속 다형성으로 구현
    switch(n) {
      case 1:
        paint(new Hallyu());
        for (int i = 0; i < HallyuInformation.length; i++) {
          System.out.println(HallyuInformation[i]);
        }
        break;
      case 2:
        paint(new Export());
        for (int i = 0; i < arrayList.size(); i++) {
          System.out.println(year.get(i) + "년 한류 총 수출액 문화콘텐츠 분야 : " + arrayList.get(i));
        }

        for (int i = 0; i < arrayList.size(); i++) {
          System.out.println(year.get(i) + "년 한류 총 수출액 소비재 및 관광 분야 : " + arrayList2.get(i));
        }
        break;
      case 3:
        paint(new HallyuFAQ());

        // 주석 8 : 파일 입출력
        // 파일 쓰기
        try {
          BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/donghyeoklim/Desktop/Hufs.Study/Study/2-2/객체지향프로그래밍/Hufs_Task/src/TextFile/kind.txt"));
          writer.write("살면서 들은 한국 관련 질문 리스트와 답변 리스트를 출력합니다.");
          writer.close();
        }
        catch(Exception ex) {}

        // 파일 읽기
        try {
          // kind.txt에 위에서 파일 쓰기로 입력한 값을 출력
          File aFile = new File("/Users/donghyeoklim/Desktop/Hufs.Study/Study/2-2/객체지향프로그래밍/Hufs_Task/src/TextFile/kind.txt");
          FileReader fileReader = new FileReader(aFile);
          BufferedReader reader = new BufferedReader(fileReader);

          String line = null;
          while((line = reader.readLine()) != null) {
            System.out.println(line);
          }
          reader.close();
        }
        catch(Exception ex) {}

        try {
          // FAQ.txt 파일 읽기
          File aFile2 = new File("/Users/donghyeoklim/Desktop/Hufs.Study/Study/2-2/객체지향프로그래밍/Hufs_Task/src/TextFile/FAQ.txt");
          FileReader fileReader2 = new FileReader(aFile2);
          BufferedReader reader2 = new BufferedReader(fileReader2);

          String line2 = null;
          while((line2 = reader2.readLine()) != null) {
            System.out.println(line2);
          }
          reader2.close();
        }
        catch(Exception ex) {}
        break;

      default:
        break;
      }


  }

  // 상속 다형성, 타이틀 출력 메서드
  public static void paint(Information i) {
    i.showTitle();
  }
}
