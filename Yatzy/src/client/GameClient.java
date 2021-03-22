package client;

import java.util.Scanner;

public class GameClient {

	public final static Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("Welcome to the menu!\nHere you can play:\nYatzy");
			switch (SC.nextLine().toLowerCase()) {

			case "yatzy":
				ClientYatzy yatzy = new ClientYatzy();
				yatzy.start();
				break;
			case "un-titeled game":
				break;

			case "exit":
				System.exit(0);
				break;
			}
		}

	}
}
