package days15;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

//액션리스너를 사용하지 않고 버튼 자체에 존재하는 이벤트 메서드를 사용
class JButtonEvent extends JFrame{
	
	JButtonEvent(){
		ImageIcon korea = new ImageIcon("images/korea1.gif");
		ImageIcon usa = new ImageIcon("images/usa.gif");
		ImageIcon germany = new ImageIcon("images/germany.gif");
		
		JButton eventButton = new JButton(korea); // 버튼 세개가 아니고 한개만.  최초국기는 대한민국만
		
		eventButton.setRolloverIcon( usa );
		eventButton.setPressedIcon(germany);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(eventButton);
		setTitle("버튼 자체 이벤트 처리 실습");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class Swing05 {

	public static void main(String[] args) {
		
		new JButtonEvent();

	}

}
