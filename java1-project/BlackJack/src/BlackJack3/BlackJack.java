package BlackJack3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class BlackJack implements KeyListener {
	private Frame frame;
	private int playerCost;
	private int dealerCost;
	private int originalPlayerCost;
	private int currentBetAmount = 0;

	private static String[] SUITS = { "(♣)", "(◆)", "(♥)", "(♠)" };

	private boolean gameEnd = false;
	private boolean playerBusted = false;
	private boolean dealerBusted = false;
	private int gameResult = 0; // 1 = Player Win, 2 = Draw, 3 = Lose;
	private int gameState = 0; // 1 = select mode, 2 = bet mode, 3 = game mode, 4 = continue mode
	private boolean isDataExist;

	private ArrayList<Card> deck;
	private ArrayList<Card> playerCards;
	private ArrayList<Card> dealerCards;

	public BlackJack() {
		this.playerCost = 100;
		this.dealerCost = 10000;
		this.originalPlayerCost = playerCost;

		frame = new Frame(this);
		initTitle();
	}

	public void initTitle() {
		File checkFile = new File("log.txt");
		gameState = 1;
		if (checkFile.exists()) {
			isDataExist = true;
		} else {
			isDataExist = false;
		}
		frame.addText("\n--------------- WooWon's BlackJack Game ---------------\n\n");
		frame.addText("       1. START NEW GAME\n\n");
		if (isDataExist) {
			frame.addText("       2. CONTINUE GAME\n");
		} else {
			frame.addText("\n");
		}
		frame.addText("-------------------------------------------------------\n\n");
		frame.addText("               Select : ");
	}

	public void initElements() {
		playerCards = new ArrayList<>();
		dealerCards = new ArrayList<>();
		deck = getDeck();

		// 상태 및 결과 초기화
		gameEnd = false;
		playerBusted = false;
		dealerBusted = false;
		currentBetAmount = 0;
		gameResult = 0;
		gameState = 0;

		// 카드 2장씩 나눠주기
		for (int i = 0; i < 2; i++) {
			playerCards.add(getCard());
			dealerCards.add(getCard());
		}
		betMoney();
	}

	private void betMoney() {
		gameState = 2;
		frame.setText(null);
		frame.addText("\n--------------- WooWon's BlackJack Game ---------------\n\n\n");
		frame.addText("       # Dealer($" + dealerCost + ") \n");
		frame.addText("       # Player($" + playerCost + ") \n");
		frame.addText("-------------------------------------------------------\n\n\n");
		frame.addText("           How much money do you want to bet? \n\n");
		frame.addText("           " + currentBetAmount + "\t(Up/Down/Enter)");
	}

	private void startGame() {
		Card tempCard;
		calculateBet(gameResult);
		gameState = 3;

		frame.setText(null);
		frame.addText("\n--------------- WooWon's BlackJack Game ---------------\n");
		frame.addText("       # Betting : $" + currentBetAmount + "\n\n");
		frame.addText("       # Dealer($" + dealerCost + ")\t");
		if (gameEnd == false) {
			tempCard = dealerCards.get(0);
			frame.addText(tempCard.printCard());
			frame.addText("XX");
		} else {
			// 게임 종료 판정이 되었을 때 dealer 출력 부분
			for (int i = 0; i < dealerCards.size(); i++) {
				tempCard = dealerCards.get(i);
				frame.addText(tempCard.printCard());
			}
		}

		frame.addText("\n       # Player($" + playerCost + ")\t");
		// playerCards 출력하기
		for (int i = 0; i < playerCards.size(); i++) {
			tempCard = playerCards.get(i);
			frame.addText(tempCard.printCard());
		}
		frame.addText("\n-------------------------------------------------------\n\n\n");
		printCurrentStatus();
	}

	private ArrayList<Card> getDeck() {
		ArrayList<Card> deck = new ArrayList<Card>();

		// 덱 순차적으로 생성하기
		for (String suit : SUITS) {
			for (int i = 1; i <= 13; i++) {
				String rank;
				switch (i) {
				case 1:
					rank = "A";
					break;
				case 11:
					rank = "J";
					break;
				case 12:
					rank = "Q";
					break;
				case 13:
					rank = "K";
					break;
				default:
					rank = Integer.toString(i);
					break;
				}
				Card card = new Card(suit, rank);
				deck.add(card);
			}
		}
		Collections.shuffle(deck);	// 덱 섞기
		return deck;
	}

	private void hit() {
		// 각각 카드 하나씩 나눠주기
		playerCards.add(getCard());
		dealerCards.add(getCard());
		if (getPoints(playerCards) > 21) { // Player busted
			gameEnd = true;
			playerBusted = true;
			gameResult = 3; // Lose
		}
	}

	private void stand() {
		gameEnd = true;
		while (getPoints(dealerCards) < 17) {
			dealerCards.add(getCard());
		}
		printCurrentStatus();

		// Dealer Busted.
		if (getPoints(dealerCards) > 21) {
			gameEnd = true;
			dealerBusted = true;
			gameResult = 1; // Win
		}

	}

	private Card getCard() {
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}

	private int getPoints(ArrayList<Card> cards) {
		int points = 0;
		String number;

		for (int i = 0; i < cards.size(); i++) {
			number = cards.get(i).getRank();

			if (number.equals("A")) { // 11로 다 더하기
				points += 11;
			} else if (number.equals("J") || number.equals("Q") || number.equals("K")) {
				points += 10;
			} else {
				points += Integer.parseInt(number);
			}
		}
		for (int i = 0; i < cards.size(); i++) {
			number = cards.get(i).getRank();
			if (number.equals("A") && points > 21) { // 총 합이 21이 넘으면 A카드 하나당 10 빼기
				points -= 10;
			}
		}

		return points;
	}

	private void calculateBet(int gameResult) {
		switch (gameResult) {
		case 1: // Player Win
			dealerCost -= currentBetAmount;
			playerCost += currentBetAmount * 2;
			break;
		case 2: // Draw
			playerCost += currentBetAmount;
			break;
		case 3: // Player Lose
			dealerCost += currentBetAmount;
			break;
		default:
			break;
		}
	}

	private void printCurrentStatus() {

		if (playerCost == 0 && gameEnd == true && gameResult == 3) {
			frame.addText("\n\n           You lost EVERYTHING!! Quit Game!");
			File file = new File("log.txt");
			if (file.exists()) {
				file.delete();
			}
			return;	// 게임이 끝났으므로 return을 하여 함수를 끝냄
		}

		if (gameEnd == false) {
			frame.addText("           Hit or Stand? (H/S): ");
		} else if (playerBusted == true) {
			frame.addText("           Player busted...");
			gameResult = 3; // Lose
		} else if (dealerBusted == true) {
			frame.addText("           Dealer busted...");
			gameResult = 1; // Win
		} else if (getPoints(playerCards) == getPoints(dealerCards)) {
			frame.addText("           Equal points...");
			gameResult = 2; // Draw
		} else if (getPoints(playerCards) > getPoints(dealerCards)) {
			frame.addText("           Player Wins...");
			gameResult = 1;
		} else if (getPoints(playerCards) < getPoints(dealerCards)) {
			frame.addText("           Dealer Wins...");
			gameResult = 3;
		}

		if (gameEnd == true) {
			gameState = 4;
			saveData();
			frame.addText("\n\n           Play Again? (Y/N)");
		}

	}

	private void displayResult() {
		int resultBetAmount = playerCost - originalPlayerCost;

		frame.setText(null);

		frame.addText("\n--------------- WooWon's BlackJack Game ---------------\n\n");

		if (resultBetAmount > 0) {
			frame.addText("   You earned $" + resultBetAmount);
		} else if (resultBetAmount < 0) {
			frame.addText("   You lost $" + -resultBetAmount);
		} else {
			frame.addText("   No $ changed");
		}

		frame.addText("\n\n\n-------------------------------------------------------");
	}

	private void saveData() {
		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new FileWriter("log.txt"));
			out.write(playerCost + System.lineSeparator());
			out.write(dealerCost + System.lineSeparator());
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Could not write to file");
		}
	}

	private void loadData() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("log.txt"));

			playerCost = Integer.parseInt(in.readLine());
			dealerCost = Integer.parseInt(in.readLine());

			originalPlayerCost = playerCost;

			in.close();

		} catch (IOException e) {
			if (e.equals(e)) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_1: {
			// 배팅 화면 출력
			if (gameState != 1)
				break;
			initElements();
			break;
		}
		case KeyEvent.VK_2: {
			// 배팅 화면 출력
			if (gameState != 1)
				break;
			loadData();
			initElements();
			break;
		}
		case KeyEvent.VK_UP: {
			if (gameState != 2)
				break;
			if (currentBetAmount + 10 > playerCost)
				break;
			currentBetAmount += 10;
			betMoney();
			break;
		}
		case KeyEvent.VK_DOWN: {
			if (gameState != 2)
				break;
			if (currentBetAmount - 10 < 10)
				break;
			currentBetAmount -= 10;
			betMoney();
			break;
		}
		case KeyEvent.VK_ENTER: {
			if (gameState != 2)
				break;
			if (currentBetAmount == 0) {
				break;
			}
			playerCost -= currentBetAmount;
			startGame();
			break;
		}
		case KeyEvent.VK_H: {
			if (gameState != 3 || gameEnd)
				return;
			hit();
			startGame();
			break;
		}
		case KeyEvent.VK_S: {
			if (gameState != 3 || gameEnd)
				break;
			stand();
			startGame();
			break;
		}
		case KeyEvent.VK_Y: {
			if (gameState != 4)
				break;
			initElements();
			break;
		}
		case KeyEvent.VK_N: {
			if (gameState != 4)
				break;
			displayResult();
			break;
		}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
