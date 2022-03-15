package java_day16.cafe;
/**
 * 사전(Dictionary) 느낌으로 프로젝트에서 사용될 상수들을 
 * 모아놓은 클래스 입니다.
 */
public class Constants {
	// %s 는 스트링이 들어갈 자리 표시
	public static final String WELCOME_CAFE = "어서오세요. 카페 %s입니다. 주문해주세요\n";
	
	public static final int TYPE_WATER = 0;
	public static final int TYPE_FIRE = 1;
	public static final int TYPE_PLANT = 2;
	public static final int TYPE_THUNDER = 3;
	
	public static String typeToString(int type) {
		if (type == TYPE_WATER) return "물";
		if (type == TYPE_FIRE) return "불";
		if (type == TYPE_PLANT) return "풀";
		if (type == TYPE_THUNDER) return "전기";
		
		return null;
	}
}
