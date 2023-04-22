package days03;

import java.util.Scanner;

public class ControllOp_IF09 {

	public static void main(String[] args) {
		
		int a = (int)(Math.random()*3);
		String com;
		if(a==0) com = "가위";
		else if(a==1) com="바위";
		else com = "보";

		Scanner sc = new Scanner(System.in);
		String user;
		System.out.print("가위/바위/보 중 하나를 입력하세요");
		user = sc.nextLine();
		
		System.out.println("컴퓨터 : " + com +" / " + "User : " + user );
		
		// 사용자를 기준으로 이겼습니다 / 무승부입니다 / 졌습니다.  중 하나를 출력하세요
		if( com.equals("가위") && user.equals("가위") ) System.out.println("무승부입니다");
		else if( com.equals("가위") && user.equals("바위") ) System.out.println("이겼습니다");
		else if( com.equals("가위") && user.equals("보") ) System.out.println("졌습니다");
		else if( com.equals("바위") && user.equals("가위") ) System.out.println("졌습니다");
		else if( com.equals("바위") && user.equals("바위") ) System.out.println("무승부입니다");
		else if( com.equals("바위") && user.equals("보") ) System.out.println("이겼습니다");
		else if( com.equals("보") && user.equals("가위") ) System.out.println("이겼입니다");
		else if( com.equals("보") && user.equals("바위") ) System.out.println("졌습니다");
		else System.out.println("졌습니다");
		
		if( com.equals("가위") ) {
			if(user.equals("가위")) System.out.println("무승부");
			else if(user.equals("바위")) System.out.println("승");
			else System.out.println("패");
		}else if( com.equals("바위") ) {
			if(user.equals("가위")) System.out.println("패");
			else if(user.equals("바위")) System.out.println("무승부"); 
			else System.out.println("승");
		}else {
			if(user.equals("가위")) System.out.println("승");
			else if(user.equals("바위")) System.out.println("패");
			else System.out.println("무승부");
		}
		
		if( com.equals( user ) ) System.out.println("무승부");
		//else if( com.equals("가위") && user.equals("바위") ) System.out.println("승");
		//else if( com.equals("바위") && user.equals("보") ) System.out.println("승");
		//else if( com.equals("보") && user.equals("가위") ) System.out.println("승");
		else if( com.equals("가위") && user.equals("바위") || 
				 	com.equals("바위") && user.equals("보") ||
				 	com.equals("보") && user.equals("가위")  ) System.out.println("승");
		else System.out.println("패");
		
		
		
		

	}

}
