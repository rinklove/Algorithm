package card;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import main.Main;

public class CardGameHelper {

	// 카드 먹는 스택
	public Stack<Card> toCardStack = new Stack<Card>();
	// 카드 먹는 스택
	public Stack<Card> fromCardStack = new Stack<Card>();

	public List<Card> myCard = new ArrayList<Card>();
	public List<Card> enemyCard = new ArrayList<Card>();

	OneCardManager manager;

	public CardGameHelper() {
		manager = new OneCardManager();
	}

	private void setGame() {
		manager.setCardPack(fromCardStack);
		manager.shuffleCard(fromCardStack);
		manager.disturbCard(fromCardStack, myCard, enemyCard);
		toCardStack.push(fromCardStack.pop());
	}

	public void playCardGame() {
		setGame();
		while(true) {
			actUser();
			if(myCard.size() == 0) break;
			actEnemy();
			if(enemyCard.size() == 0) break;
		}
	}
	
	private void actUser() {
		while (true) {
			System.out.println("---------------------------------------------------1---");
			manager.showTopCard(toCardStack);
			System.out.println("------------------------------------------------------");
			manager.printMyCards(myCard);
			System.out.println("------------------------------------------------------");
			System.out.println("1. 카드 내기 / 2. 카드 먹기중에서 행동을 선택하세요");
			int actNum = Main.sc.nextInt();
			if(actNum==1) {
				System.out.println("낼 카드를 선택하세요");
				int index = Main.sc.nextInt();
				int result = manager.putCard(toCardStack, myCard, index - 1);
				if (result == 0) break;				
			} else if(actNum == 2) {
				manager.bringCards(fromCardStack, toCardStack, myCard, 1);
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
			}
		}
	}
	
	/**
	 * 컴퓨터 무슨 카드 낼 지 선택
	 */
	private void actEnemy() {
		for (int i = 0; i < enemyCard.size(); i++) {
			int attack = manager.putCard(toCardStack, enemyCard, i);
			if (attack == 0) {
				manager.showTopCard(toCardStack);
				return;				
			}
		}
		manager.bringCards(fromCardStack, toCardStack, enemyCard, 1);
	}

}
