package days14;

public class Exception05 {

	public static void main(String[] args) {
		try {
			method01();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void method01() throws Exception {
		method2();
		
		/*
		try {
			method02();
		} catch (Exception e) {
			
		}
		*/
	}

	public static void method2() throws Exception {
			
		throw new Exception(); 
		
		// 예외상황에 마우스를 올리고서, 풍선도움말처럼 표시되는 곳에서 메뉴를 선택합니다
		// 1. add throws declaration
		// 2. surround with try catch
		// 2번을 선택하면 현재위치에서 try catch가 추가되며, 이는 현재메서드에서 에러처릴 마무리 하겠다는 뜻입니다
		// 또는 수동으로 try catch를 사용해줄 수도 있습니다.
		/*
		try {
			throw new Exception();  // 예외 강제 발생
		}catch(Exception e) {
			
		}
		*/
	}

}
