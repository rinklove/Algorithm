package card;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import main.Main;

public class OneCardManager {
	
	private String[] shape = {"하트", "스페이드", "다이아", "클로버"};
	/**
	 * 카드 초기 설정
	 */
	public void setCardPack(Stack<Card> fromCardStack) {
		for(int s = 0; s<shape.length;s++) {
			for(int number = 1; number<=13; number++) {
				fromCardStack.add(new Card(shape[s], number));
			}
		}
	}
	/**
	 * 카드 섞기
	 */
	public void shuffleCard(Stack<Card> fromCardStack) {
		Collections.shuffle(fromCardStack);
		
//		for(Card c : Main.toCardStack) {
//			System.out.println(c);
//		}
	}
	
	/**
	 * 카드 분배
	 */
	public void disturbCard(Stack<Card> fromCardStack, List<Card> my, List<Card> enemy) {
		int CardNumbers = 7;
		for(int i = 0; i < CardNumbers; i++) {
			my.add(fromCardStack.pop());
			enemy.add(fromCardStack.pop());
		}
	}
	
	/**
	 * 카드 리스트 출력
	 */
	public void printMyCards(List<Card> my) { 
		System.out.println("내 카드 리스트");
		for (int i =0; i<my.size(); i++) {
			System.out.println("Card " + (i+1) + my.get(i));			
		}
	}
	/**
	 * 상단에 있는 카드 출력
	 * @param toCardStack
	 */
	public void showTopCard(Stack<Card> toCardStack) {
		System.out.println("현재 상단에 있는 카드: "+toCardStack.peek());
	}
	
	/**
	 * @param cardList 누구카드팩에서
	 * @param index 번째 카드를 제거할 지
	 */
	public int putCard(Stack<Card> toCardStack, List<Card> cardList ,int index) {
		int attack = checkPutCards(toCardStack, cardList.get(index));
		if(attack >= 0) {
			toCardStack.push(cardList.get(index));
			cardList.remove(index);			
		} 
		return attack;
	}
	
	/**
	 * 카드 가져오기
	 * @param cardList 누구 카드팩에 
	 * @param number 장만큼 추가할 지
	 */
	public void bringCards(Stack<Card> fromCardStack, Stack<Card> toCardStack,List<Card> cardList, int number) {
		if(fromCardStack.isEmpty()) {
			refillCards(toCardStack, fromCardStack);
		}
		for(int i = 0; i<number; i++) {
			cardList.add(fromCardStack.pop());
		}
	}
	
	public int checkPutCards(Stack<Card> toCardStack, Card card) {
		int sum = 0;
		if(card.getShape() != toCardStack.peek().getShape() 
				&& card.getValue() != toCardStack.peek().getValue()) {
			System.out.println("같은 모양의 다른 숫자 카드또는 다른 모양의 같은 숫자 카드만 낼 수 있습니다");
			sum = -1;
		} else {
			switch(card.getValue()) {
//			case 1: sum += 3; break;
//			case 2: sum += 2; break;
//			case 3: if(sum > 0) sum -=2; break;
			case 7: switchShape(toCardStack); break;
			default: break;
			}
		}
		return sum;
	}
	
	/**
	 * 7카드 낼 때 모양 변경
	 */
	public void switchShape(Stack<Card> toCardStack) {
		System.out.println("1, 하트, 2. 스페이드, 3. 다이아, 4. 클로버 중에서 하나 고르세요(숫자입력)");
		int change = Main.sc.nextInt();
//		fromCardStack.get(Main.fromCardStack.size()-1).setShape(shape[change-1]);
		Card card = toCardStack.pop();
		card.setShape(shape[change-1]);
		toCardStack.push(card);
	}
	
	/**
	 * 
	 * @param toCardStack
	 * @param fromCardStack
	 */
	public void refillCards(Stack<Card> toCardStack, Stack<Card> fromCardStack) {
		Card top = toCardStack.pop();
		Collections.copy(fromCardStack, toCardStack);
		shuffleCard(fromCardStack);
		toCardStack.push(top);
	}
}
