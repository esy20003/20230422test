package days15;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

// 컨테이너의 레이아웃 : 5행 1열의 GridLayout

// 1 행 : JPanel p1 배치 -> p1에는 GridLayout 으로 TextField 한개 배치
// 2 행 : JPanel p2 배치 -> p2 에는 GridLayout 으로 버튼 네개( 7, 8, 9, +)
// 3 행 : JPanel p3 배치 -> p3 에는 GridLayout 으로 버튼 네개( 4, 5, 6, -)
// 4 행 : JPanel p4 배치 -> p4 에는 GridLayout 으로 버튼 네개( 1, 2, 3, x)
// 5 행 : JPanel p5 배치 -> p5 에는 GridLayout 으로 버튼 네개( C, 0, =, ÷)

class Calculator extends JFrame implements ActionListener{
	JTextField jt;
	
	int firstNumber;
	int secondNumber;
	String operator;
	
	Calculator(){
		Container con = getContentPane();
		con.setLayout( new GridLayout(6, 1) );
		
		// 폰트 객체 생성
		Font f = new Font("굴림", Font.BOLD, 30);
		
		JPanel p0 = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		
		
		
		p0.setLayout( new GridLayout(1, 1) );
		jt = new JTextField(15);
		jt.setFont( f );  // 폰트 적용
		jt.setHorizontalAlignment( SwingConstants.RIGHT ); // 오른쪽 정렬
		jt.setEditable( false );  // 편집불가능으로 설정
		jt.setText("0");  // 최초 텍스트 0
		p0.add(jt);
		con.add(p0);
		
		p1.setLayout( new GridLayout(1,4) );
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton bplus = new JButton("+");
		b7.setFont(f);
		b8.setFont(f);
		b9.setFont(f);
		bplus.setFont(f);
		p1.add(b7);
		p1.add(b8);
		p1.add(b9);
		p1.add(bplus);
		con.add(p1);
		
		p2.setLayout( new GridLayout(1,4) );
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton bminus = new JButton("-");
		b4.setFont(f);
		b5.setFont(f);
		b6.setFont(f);
		bminus.setFont(f);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(bminus);
		con.add(p2);
		
		p3.setLayout( new GridLayout(1,4) );
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton bmul = new JButton("x");
		b1.setFont(f);
		b2.setFont(f);
		b3.setFont(f);
		bmul.setFont(f);
		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		p3.add(bmul);
		con.add(p3);
		
		p4.setLayout( new GridLayout(1,4) );
		JButton bc = new JButton("C");
		JButton b0 = new JButton("0");
		JButton be = new JButton("=");
		JButton bdiv = new JButton("÷");
		bc.setFont(f);
		b0.setFont(f);
		be.setFont(f);
		bdiv.setFont(f);
		p4.add(bc);
		p4.add(b0);
		p4.add(be);
		p4.add(bdiv);
		con.add(p4);
		
		p5.setLayout( new GridLayout(1,4) );
		JButton bb = new JButton("<-");
		JButton b10 = new JButton("sqr");
		JButton b11 = new JButton("1/x");
		JButton b12 = new JButton("x*x");
		bb.setFont(f);
		b10.setFont(f);
		b11.setFont(f);
		b12.setFont(f);
		p5.add(bb);
		p5.add(b10);
		p5.add(b11);
		p5.add(b12);
		con.add(p5);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		
		bb.addActionListener(this);
		bc.addActionListener(this);
		
		bplus.addActionListener(this);
		bminus.addActionListener(this);
		bmul.addActionListener(this);
		bdiv.addActionListener(this);
		be.addActionListener(this);
		
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		
		
		setTitle("계산기  실습");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 0~9 버튼을 클릭하면  최초값 0은 지워지고 클릭되는 숫자들이 쌓게 코딩해주세요 		
		// switch 를 이용해주세요
		String s = e.getActionCommand();
		String oldText="";
		oldText = jt.getText();
		
		DecimalFormat dc = new DecimalFormat("0.#######");
		double temp;
		
		switch(s) {
			case "0":	case "1":	case "2":	case "3":	case "4":   case "5":
			case "6":	case "7":	case "8":	case "9":
				if( oldText.equals("0") ) oldText = "";
				jt.setText( oldText + s );
				break;
			case "C":
				jt.setText("0");
				break;
			case "<-":
				// 현재 텍스트의 글자갯수를 얻는 메서드 : length()
				// 현재 텍스트의 일부 글자를 추출하는 메서드 : substring()
				// "123456"  -> "12345"
				// <- 버튼을 클릭하면 맨 오른쪽 글자를 제외한나머지 글자를 취해서 다시  jt 에 넣습니다.
				if( oldText.length() == 1 ) jt.setText( "0" );
				else {
					int strNum = oldText.length();
					String newText = oldText.substring( 0, strNum -1 );
					jt.setText(  newText  );
				}
				break;
			case "+":  case "-":	case "x":	case "÷":
				operator = s;
				firstNumber = Integer.parseInt( jt.getText() );
				jt.setText("0");
				break;
			case "=":
				secondNumber = Integer.parseInt( jt.getText() );
				switch(operator) {
					case "+":
						jt.setText( String.valueOf( firstNumber + secondNumber )  ); break;
					case "-":
						jt.setText( String.valueOf( firstNumber - secondNumber )  ); break;
					case "x":
						jt.setText( String.valueOf( firstNumber * secondNumber )  ); break;
					case "÷":
						temp = firstNumber / (double)secondNumber;
						jt.setText( String.valueOf( dc.format(temp) )  ); break;
				}
				break;
			case "sqr": // 현재 숫자 0일때는 계산 X - 아무일도 안일어나게 
				// 제곱근을 구하는 버튼으로 구현합니다.
				secondNumber = Integer.parseInt( jt.getText() );
				if( secondNumber == 0) return;
				temp = Math.sqrt(secondNumber);
				jt.setText( String.valueOf( dc.format(temp) )  ); 
				break;
			case "1/x": // 현재 숫자 0일때는 계산 X - 아무일도 안일어나게 
				// 화면에 있는 숫자로 1을 나눈 몫을 출력합니다
				secondNumber = Integer.parseInt( jt.getText() );
				if( secondNumber == 0) return;
				temp = 1.0 / secondNumber;
				jt.setText( String.valueOf( dc.format(temp) )  ); 
				break;
			case "x*x":				 
				// 입력된 숫자의 제곱을 출력합니다
				secondNumber = Integer.parseInt( jt.getText() );
				jt.setText( String.valueOf( secondNumber * secondNumber  ) );
				break;
		}
	}
}
public class Swing13 {

	public static void main(String[] args) {
		new Calculator();
	}

}
