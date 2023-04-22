package days14;

interface Repairable{   }

abstract class Unit{
	private int hp;  // 현재 생명력(체력)
	private int max_hp;  // 최대 생명령(체력)
	Unit(int p){
		max_hp = p;   // 캐릭터별 전달된 최대 체력 초기화
		hp = (int)(p*0.95);  // 현재 체력은 최대의 90%로 초기화
	}
	// 추상 클래스는 하나이상의 추상 메서드를 포함합니다.
	public abstract void move(int x, int y);
	//public void move(int x, int y) {   System.out.println("x:" + x + ", y:" + y + " 로 이동합니다");    }
	public int getHp() { 		return hp;  	}
	public void setHp(int hp) {		this.hp = hp;  	}
	public int getMax_hp() {		return max_hp;   }
	public void setMax_hp(int max_hp) {		this.max_hp = max_hp; 	}
}


class GroundUnit extends Unit{
	GroundUnit(int p){  		super(p);	}
	@Override
	public void move(int x, int y) { System.out.println("x:" + x + ", y:" + y + " 로 뛰어갑니다"); 	}
}
class AirUnit extends Unit{
	AirUnit(int p) { 	super(p);	}
	@Override
	public void move(int x, int y) { 	System.out.println("x:" + x + ", y:" + y + " 로 날아갑니다");  }
}

class Tank extends GroundUnit implements Repairable {
	Tank() { 	super( 150 );	}
	public String toString() {	return "Tank";	}
}
class Battlecruiser extends AirUnit implements Repairable{
	Battlecruiser() {		super(350);	}
	public String toString() { return "Battlecruiser";  }
}
class Marine extends GroundUnit{ 
	Marine(){ super(40); }
	public String toString() { return "Marine"; }
}
class SCV extends GroundUnit  implements Repairable { 
	SCV(){ super(40); }
	public String toString() { return "SCV"; }
	
	//public void repaire(Tank t) {}
	//public void repaire(Battlecruiser b) {}
	//public void repaire(SCV s) {}
	public void repaire( Repairable r ) {
		// this <- s1       r <- t, b, s2
		// this 가 r을 수리합니다
		
		// 전달된 객체의 hp, max_hp 등에 getter/setter 메서드들을 통해 접근하려면 Unit 참조변수로 변환이 필요합니다.
		// 실제 인스턴스는 t, b, s2 이므로 그들의 부모인 Unit 참조 변수로 변환은 가능합니다
		// 그래도 안전을 위한다면
		if( r instanceof Unit) { 
			Unit u = (Unit)r;
			if(u.getHp()  !=  u.getMax_hp() ) {
				while( u.getHp()  !=  u.getMax_hp() ) {
					u.setHp( u.getHp() + 1 );
					System.out.println(u + "체력 1를 repair 했습니다. 현재 체력 : " + u.getHp() );
				}
			}else {
				System.out.println(u + "의 hp는 만땅입니다.");
				return;
			}
			System.out.println(u + "의 수리가 끝났습니다\n");
		}
		
	}
}

public class Interface04 {

	public static void main(String[] args) {
		
		Tank t = new Tank();
		Battlecruiser b = new Battlecruiser();
		Marine m = new Marine();
		SCV s1 = new SCV();
		SCV s2 = new SCV();

		System.out.print( t + " : ");
		t.move(10,40);
		System.out.print( b + " : ");
		b.move(20,30);
		System.out.print( m + " : ");
		m.move(30,20);
		System.out.print( s1 + " : ");
		s1.move(40,10);
		
		s1.repaire(t);
		s1.repaire(b);
		s1.repaire(s2);
		//s1.repaire(m);  // Marine 은 Repairable 을 implements 하지 않았으므로 전달 불가
		
	}

}
