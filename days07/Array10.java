package days07;

import java.util.Scanner;

public class Array10 {

	public static void main(String[] args) {
		
		// 야구 게임 프로그램
		// 컴퓨터가 나에게 알려주지 않은 숫자를  질문과 답변을 통해 맞춰가는 게임입니다.
		// 사용자에게 알려주지 않은 숫자 : 6 5 7 같은 한자리 숫자 세개를 준비하고
		// 질문 : 3 6 7  같은 한자리 숫자 세개를 입력받아 비교합니다.
		// 답변 : 같은 숫자가 자리수까지 같으면 S   숫자만 같으면 B 을 출력합니다.
		// 숫자 하나는 0~9 까지...  세개의 숫자 중 중복 숫자 없음	
		// 컴퓨터가 갖고 있는 숫자  : 5 6 8
		// 사용자가 컴퓨터에게 질문 : 4 5 8    
		// 답변-> 1S 1B
		// 1. 컴퓨터가 기억할 숫자를 저장할 배열, 사용자가 입력한 숫자를 저장할 배열생성
		int [] com = new int[3];  // 컴퓨터가 기억할 수수자를 저장할 배열
		int [] user = new int[3]; // 사용자가 입력한 숫자를 저장할 배열
		
		// 2. 컴퓨터가 사용자에게 공개하지 않은 숫자(0~9) 세개를 발생시켜서 com 배열에 저장. 중복 값 X
		int i=0;
		int j;
		while(i < com.length) {
			com[i] = (int)(Math.random()*10);
			System.out.println("i > "+com[i]); // i에 저장
			// 방금 결정된 숫자가 i번째이고,  0번째부터 i-1번째까지의 숫자와 중복된 값이 있는지 검사
			//System.out.println(i); i = com의 인덱스 012 com = new int[3];
			for(j=0; j<i; j++) {
				if(com[i]==com[j]) break;  // 검사도중 같은 값이 나오면 바로 반복 종료 미리들어가있던 i 와 지금 들어간j 의 숫자가 같다면 break;
			}
			
			// 같은값이 있었다면 0 ~ i-1 까지 가다가 중간에 멈췄을꺼고
			// 같은 값이 없었다면 j는 i와 같은 값에서 종료되었을 겁니다
			
			if( i==j ) i++;  // 현재숫자와 이전숫자사이에 같은 값이 없었다면 다음 숫자를 위해 i가 1증가합니다
		}
		// System.out.println(com[0] + " " + com[1] + " " + com[2]);
		Scanner sc = new Scanner(System.in);
		
		int s = 0, b = 0;// 여기 선언했는데 또?
		do {
			
			// 3. 사용자에게서 세개의 숫자(0~9까지의 숫자 세개)를 입력받아서 user 배열에 저장
			// 입력 방법 #1		
			/*
			System.out.printf("입력(반드시 한자리숫자를 입력하세요) : ");
			user[0] = Integer.parseInt( sc.nextLine() );
			System.out.printf("입력(반드시 한자리숫자를 입력하세요) : ");
			user[1] = Integer.parseInt( sc.nextLine() );
			System.out.printf("입력(반드시 한자리숫자를 입력하세요) : ");
			user[2] = Integer.parseInt( sc.nextLine() );
			*/
			
			/*
			//입력방법 #2
			System.out.print("입력(세자리숫자를 중복되지 않게) : ");
			int num = Integer.parseInt( sc.nextLine() );
			user[0] = num/100;   // 123/100 -> 1
			user[1] = (num%100) / 10;   // 123%100 -> 23   23/10  ->  2
			user[2] = (num%10)    // 123%10   -> 3
			*/
			
			// 입력 방법 #3
			System.out.print("입력 : ");
			String num = sc.nextLine();    //  456
			user[0] = num.charAt(0) - '0';   //  '4' - '0'  -> 4
			user[1] = num.charAt(1) - '0';   //  '5' - '0'  ->  5
			user[2] = num.charAt(2) - '0';   //  '6' - '0'  ->  6
			
			// System.out.println(user[0] + " " + user[1] + " " + user[2]);
			
			// 4. com 과 user 배열의 각 요소들을 서로 서로 비교해서 같은 값이 있는지, 자리는 같은지 다른지
			//    판단해서  S 와 B 를 예시처럼 출력합니다
			s = 0;
			b = 0;
			for(i=0; i<com.length; i++) {
				for(j=0;j<user.length; j++) { // user.length 나 com.length 나 배열의 길이가 같다
					if( com[i] == user[j] ) {
						if( i==j ) s++;
						else b++;
					}
				}
			}
			System.out.println(s + " Strike  " + b + " Ball");
		
		}while(s!=3);  // 5. 맞출때까지(3S 0B) 3~4까지를 반복합니다
		System.out.println("맞췄습니다. 프로그램을 종료합니다"); 
		
	}

}




