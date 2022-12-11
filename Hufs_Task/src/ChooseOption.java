// 주석 3 : 인터페이스 구현 클래스 선언
public class ChooseOption implements Interface {
  
  @Override
  public void print() {
    System.out.println("Hallyu: 1, Export(한류 총 수출액): 2, FAQ: 3, End: 0");
  }
  
  // 주석 5 : 인터페이스 다형성
  @Override 
  public int select(int n) {
    Option option;
    switch (n) {
      case 1:
				option = Option.Hallyu;
				System.out.println("한류에 대한 정보를 출력합니다.");
				break;
			case 2:
				option = Option.Export;
				System.out.println("한류 총 수출액에 대한 정보를 출력합니다.");
				break;
      case 3:
				option = Option.Type;
				System.out.println("한류 FAQ를 출력합니다.");
				break;
      case 0:
				option = Option.End;
				System.out.println("프로그램 종료");
				break;
      }
      return n;
    }
  }

// 주석 6 : 참조타입 (열거 타입)
enum Option {
  Hallyu,
  Export,
  Type,
  End
}