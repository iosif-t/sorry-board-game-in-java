package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.*;
import model.*;

public class Controller {
	private Deck d;
	private View a;
	private Square[] simulator;
	private JLabel[] table;
	private JButton[] buttons;
	private int i=0,j=0,indexx=0,redWinner,yellowWinner;
	private ArrayList<Card> simulationCards;
	private ArrayList<JLabel> cards;
	private JButton currentCard,recieveCard,foldButton,vs;
	private boolean allowToMove,versusMode;
	/**
	 * constructor
	 * 
	 */
	public Controller() {
		versusMode=false;
		allowToMove=false;
		redWinner=0;
		yellowWinner=0;
		a=new View();
		d= new Deck(a.getYellowStart1(),a.getYellowStart2(),a.getRedStart1(),a.getRedStart2());
		simulationCards=a.getCardSimulation();
		simulator=a.getSimulationTable();
		cards=a.getCards();
		table=a.getTable();
		
		vs=a.getVsButton();
		vs.addActionListener(new vsListener());
		currentCard=a.getCurrentButton();
		recieveCard=a.getBackCard();
		recieveCard.addActionListener(new cardListener());
		buttons=a.getButtons();
		buttons[0].addActionListener(new yellowPawn1Listener());
		buttons[1].addActionListener(new yellowPawn2Listener());
		buttons[2].addActionListener(new redPawn1Listener());
		buttons[3].addActionListener(new redPawn2Listener());
		
		foldButton=a.getFoldButton();
		foldButton.addActionListener(new foldListener());
		
		d.randomPlayer(a);
		d.setPositionOfPlayer1Pawn1(a.getYellowStart1());
		d.setPositionOfPlayer1Pawn2(a.getYellowStart2());
		d.setPositionOfPlayer2Pawn1(a.getRedStart1());
		d.setPositionOfPlayer2Pawn2(a.getRedStart2());
		
		d.getFirstPlayer().getFirstPawn().setActive(true);
		d.getFirstPlayer().getSecondPawn().setActive(true);
		
		d.getSecondPlayer().getFirstPawn().setActive(true);
		d.getSecondPlayer().getSecondPawn().setActive(true);
		
		
		
	}
	
	public int getChoice(String msg) {
		int in= Integer.parseInt(JOptionPane.showInputDialog(msg,4));
		return in;
	}
	
	/**
	 * post we know if a player won
	 * @param p certain player
	 * @return true or false
	 */
	public boolean bothPawnsOnHome(Player p) {
		if(p.getColor()=="red") {
			if(redWinner==2) {
				announceWinner("red");
				return true;
			}
		}else if(p.getColor()=="yellow"&&yellowWinner==2) {
			announceWinner("yellow");
			return true;
			}
			
		return false;
	}
	
	
	/**
	 * observer
	 * post you know if the game has finished
	 * @return true if the game has finished
	 */
	public boolean gameHasFinished() {
		
		
		
		return true;
	}
	/**
	 * post announces the winner
	 */
	public void announceWinner(String color) {	
		if(color=="yellow") {
			a.getTxt().setText("Info Box\nYellow player Won");
		
		}
		else
			a.getTxt().setText("Info Box\nRed player Won");
		
		recieveCard.removeAll();
		
			
	}
	/**
	 * observer
	 * post return the player that should play
	 * @return the player that should play
	 */
	public Player playersTurn() {
		if(d.getFirstPlayer().getTurn())
			return d.getFirstPlayer();
		return d.getSecondPlayer();
	}
	
	
	/**
	 * post checks if the action is valid
	 */
	public void checkActions() {
		
		
	}
	/**
	 * post saves game
	 */
	public void saveGame() {}
	
	
	private class vsListener implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
				versusMode=true;
			
				if(d.getTurnOfPlayer2()) {
					recieveCard.doClick();
					Random r=new Random();
					int x=r.nextInt(2);
					if(x==1)
						buttons[2].doClick();
					else
						buttons[3].doClick();
				}
			
			
		}
		
	}
	
	private class foldListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(!allowToMove) {
				a.getTxt().setText("Info Box\nFold is not possible");
				return;
			}
			if(d.getTurnOfPlayer1()) {
				a.getTxt().setText("Info Box\nYellow player went fold");	
				d.SetTurnOfPlayer1(false);
				d.SetTurnOfPlayer2(true);
			}else {
				a.getTxt().setText("Info Box\nRed player went fold");
				d.SetTurnOfPlayer2(false);
				d.SetTurnOfPlayer1(true);
			}
			
			allowToMove=false;
			simulationCards.remove(indexx);
			a.getPanel().repaint();
			
			if(versusMode)
				vs.doClick();
		}
	}
	
	private class cardListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(allowToMove)
				return;
			int tmp=0;
			Random r=new Random();
			int index;
			if(cards.size()==1)
				index=0;
			else
				index=r.nextInt(cards.size()-1);
			
			
			if(j==1)
				currentCard.remove(tmp);
			
			j=1;
			currentCard.add(cards.get(index));
			currentCard.repaint();		
			tmp=index;
			indexx=index;
			cards.remove(index);
			if(cards.isEmpty()) {
				cards=a.shuffle();
				simulationCards=a.getSim();
				a.getTxt().setText("Info Box\nShuffle");
			}	
			a.getTxt().setText(a.getTxt().getText()+"\nCards left:"+cards.size());
			allowToMove=true;
			
		}	
		
	}
	
	private class yellowPawn1Listener implements ActionListener{
		private int i=a.getYellowStart1()+1;
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(bothPawnsOnHome(d.getFirstPlayer())) {
				
				return;
			}
			
			
			if(!allowToMove) {
				a.getTxt().setText("Info Box\nPick a card first");
				
				return;
			}
			if(!d.getTurnOfPlayer1()) {
				a.getTxt().setText("Info Box\nRed players turn");
				
				return;
			}
			
			
			if(d.getPositionOfPlayer1Pawn1()==a.getYellowStart1())
				i=a.getYellowStart1()+1;
			else if(d.getPositionOfPlayer1Pawn1()!=i)
				i=d.getPositionOfPlayer1Pawn1();
			
			
			if(i==a.getYellowStart1()+1) {
				if(simulationCards.get(indexx).getNumber()==1||simulationCards.get(indexx).getNumber()==2) {
					i+=simulationCards.get(indexx).getNumber();
					
					table[i].add(buttons[0]);
					checkPawns(0,i,simulationCards.get(indexx).getNumber());
					d.setPositionOfPlayer1Pawn1(i);
					allowToMove=false;
					a.getPanel().repaint();
					
					if(simulationCards.get(indexx).getNumber()==1) {
						d.SetTurnOfPlayer1(false);
						d.SetTurnOfPlayer2(true);
					}
					simulationCards.remove(indexx);
					if(versusMode)
						vs.doClick();
					return;
				}
				else if(simulationCards.get(indexx).getNumber()==0) {
					if(d.getPositionOfPlayer2Pawn1()!=a.getRedStart1()&&d.getPositionOfPlayer2Pawn1()<31||d.getPositionOfPlayer2Pawn1()>39) {
						table[d.getPositionOfPlayer2Pawn1()].add(buttons[0]);
						table[a.getRedStart1()].add(buttons[2]);
						i=d.getPositionOfPlayer2Pawn1();
					
						d.setPositionOfPlayer1Pawn1(i);
						d.setPositionOfPlayer2Pawn1(a.getRedStart1());
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer1(false);
						d.SetTurnOfPlayer2(true);
						if(versusMode)
							vs.doClick();
						return;
					}
					else if(d.getPositionOfPlayer2Pawn2()!=a.getRedStart2()&&d.getPositionOfPlayer2Pawn2()<31||d.getPositionOfPlayer2Pawn2()>39){
						table[d.getPositionOfPlayer2Pawn2()].add(buttons[0]);
						table[a.getRedStart2()].add(buttons[3]);
						i=d.getPositionOfPlayer2Pawn2();
						d.setPositionOfPlayer2Pawn2(a.getRedStart2());
						
						d.setPositionOfPlayer1Pawn1(i);
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer1(false);
						d.SetTurnOfPlayer2(true);
						if(versusMode)
							vs.doClick();
						return;
					}
					else {
						a.getTxt().setText("Info Box\nNot available move");
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer1(false);
						d.SetTurnOfPlayer2(true);
						if(versusMode)
							vs.doClick();
						return;
					}
				}
				a.getTxt().setText("Info Box");
				a.getTxt().setText(a.getTxt().getText()+"\nNot a starting card" +simulationCards.get(indexx).getNumber());
				simulationCards.remove(indexx);
				d.SetTurnOfPlayer1(false);
				d.SetTurnOfPlayer2(true);
				allowToMove=false;
				if(versusMode)
					vs.doClick();
				return;
			}
		   	
			
			if(simulator[i] instanceof SafetyZoneSquare&&simulator[i].getColor()=="yellow") {
				if(i+simulationCards.get(indexx).getNumber()==a.getYellowHome1()) {
					table[a.getYellowHome1()].add(buttons[0]);
					simulationCards.remove(indexx);
					allowToMove=false;
					yellowWinner++;
					d.setPositionOfPlayer1Pawn1(a.getYellowHome1());
					if(yellowWinner==2) {
						a.getTxt().setText("Info Box\nYellow player won!!!");
					}
					d.SetTurnOfPlayer1(false);
					d.SetTurnOfPlayer2(true);
					d.getFirstPlayer().getFirstPawn().setActive(false);
					a.getPanel().repaint();
					buttons[0].removeAll();
					if(versusMode)
						vs.doClick();
					return;
				}else if(i+simulationCards.get(indexx).getNumber()>a.getYellowHome1()) {
						if(simulationCards.get(indexx).getNumber()!=10&&simulationCards.get(indexx).getNumber()!=7)
							i-=simulationCards.get(indexx).getNumber();
				}
						
				}
			
			int checkForNumber2=simulationCards.get(indexx).getNumber();
			if(simulationCards.get(indexx).getNumber()==10) {
				i+=getChoice("-1 for a step back");
			}else if(checkForNumber2==7) {
				int t;
				t=getChoice("type the steps for this pawn");
				i+=t;
				d.setPositionOfPlayer1Pawn2(d.getPositionOfPlayer1Pawn2()+7-t);
				table[d.getPositionOfPlayer1Pawn2()].add(buttons[1]);
			}else if(checkForNumber2==11) {
				int t=getChoice("type 0 to trade pawns");
				if(t==0) {
					int p=i;
					if(d.getPositionOfPlayer2Pawn1()!=a.getRedStart1()&&d.getPositionOfPlayer2Pawn1()<31||d.getPositionOfPlayer2Pawn1()>39) {
						table[d.getPositionOfPlayer2Pawn1()].add(buttons[0]);
						table[p].add(buttons[2]);
						i=d.getPositionOfPlayer2Pawn1();
					
						d.setPositionOfPlayer1Pawn1(i);
						d.setPositionOfPlayer2Pawn1(p);
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer1(false);
						d.SetTurnOfPlayer2(true);
						if(versusMode)
							vs.doClick();
						return;
					}
					else if(d.getPositionOfPlayer2Pawn2()!=a.getRedStart2()&&d.getPositionOfPlayer2Pawn2()<31||d.getPositionOfPlayer2Pawn2()>39){
						table[d.getPositionOfPlayer2Pawn2()].add(buttons[0]);
						table[p].add(buttons[3]);
						i=d.getPositionOfPlayer2Pawn2();
						d.setPositionOfPlayer2Pawn2(p);
						d.setPositionOfPlayer1Pawn1(i);
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer1(false);
						d.SetTurnOfPlayer2(true);
						if(versusMode)
							vs.doClick();
						return;
					}else {
						
						a.getTxt().setText("Info Box\nNot available move");
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer1(false);
						d.SetTurnOfPlayer2(true);
						if(versusMode)
							vs.doClick();
						return;
						}
				}
				i+=11;
			}
			else
				i=i+simulationCards.get(indexx).getNumber();
			
			if(i>=31&&i<=39)
				i+=9;
			
			else if(i==29)
				i=41;
			else if(i<2) {
				int t=i;
				i=77;
				i+=-8+t;
			}
			if(simulator[i] instanceof StartSlideSquare&&simulator[i].getColor()!="yellow"&&!(i>=31&&i<=39)) {
				
				checkPawns(0,i,simulationCards.get(indexx).getNumber());
				checkPawns(0,i+1,simulationCards.get(indexx).getNumber());
				checkPawns(0,i+2,simulationCards.get(indexx).getNumber());
				checkPawns(0,i+3,simulationCards.get(indexx).getNumber());
				if(simulator[i+4] instanceof EndSlideSquare) {
					i=i+4;
					checkPawns(0,i+4,simulationCards.get(indexx).getNumber());
				}
				else
					i+=3;
			}
			if(checkForNumber2!=2) {
			d.SetTurnOfPlayer1(false);
			d.SetTurnOfPlayer2(true);
			}
			allowToMove=false;
			
			table[i].add(buttons[0]);
			d.setPositionOfPlayer1Pawn1(i);
			checkPawns(0,i,simulationCards.get(indexx).getNumber());
			simulationCards.remove(indexx);
			a.getPanel().repaint();
			i=d.getPositionOfPlayer1Pawn1();
			if(versusMode)
				vs.doClick();
		}
	}
	
	private class yellowPawn2Listener implements ActionListener{
		private int i=a.getYellowStart2();
		
		public void actionPerformed(ActionEvent e) {
			
			if(bothPawnsOnHome(d.getFirstPlayer())) {
				
				return;
			}
			
			
			if(!allowToMove) {
				a.getTxt().setText("Info Box\nPick a card first");
				
				return;
			}
			if(!d.getTurnOfPlayer1()) {
				a.getTxt().setText("Info Box\nRed players turn");
				return;
			}
			if(versusMode)
				vs.doClick();
			
			if(d.getPositionOfPlayer1Pawn2()==a.getYellowStart2())
				i=a.getYellowStart2();
			else if(d.getPositionOfPlayer1Pawn2()!=i)
				i=d.getPositionOfPlayer1Pawn2();
			
			if(i==a.getYellowStart2()) {
				if(simulationCards.get(indexx).getNumber()==1||simulationCards.get(indexx).getNumber()==2) {
					i+=simulationCards.get(indexx).getNumber();
					
					table[i].add(buttons[1]);
					checkPawns(1,i,simulationCards.get(indexx).getNumber());
					d.setPositionOfPlayer1Pawn2(i);
					a.getPanel().repaint();
					allowToMove=false;
					
					if(simulationCards.get(indexx).getNumber()==1) {
					d.SetTurnOfPlayer1(false);
					d.SetTurnOfPlayer2(true);
					}
					simulationCards.remove(indexx);
					if(versusMode)
						vs.doClick();
					return;
					
				}else if(simulationCards.get(indexx).getNumber()==0) {
					if(d.getPositionOfPlayer2Pawn1()!=a.getRedStart1()&&d.getPositionOfPlayer2Pawn1()<31||d.getPositionOfPlayer2Pawn1()>39) {
						table[d.getPositionOfPlayer2Pawn1()].add(buttons[1]);
						table[a.getRedStart1()].add(buttons[2]);
						i=d.getPositionOfPlayer2Pawn1();
					
						d.setPositionOfPlayer1Pawn2(i);
						d.setPositionOfPlayer2Pawn1(a.getRedStart1());
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						
							d.SetTurnOfPlayer1(false);
							d.SetTurnOfPlayer2(true);
						
						if(versusMode)
							vs.doClick();
						return;
					}
					else if(d.getPositionOfPlayer2Pawn2()!=a.getRedStart2()&&d.getPositionOfPlayer2Pawn2()<31||d.getPositionOfPlayer2Pawn2()>39){
						table[d.getPositionOfPlayer2Pawn2()].add(buttons[1]);
						table[a.getRedStart2()].add(buttons[3]);
						i=d.getPositionOfPlayer2Pawn2();
						d.setPositionOfPlayer2Pawn2(a.getRedStart2());
						d.setPositionOfPlayer1Pawn2(i);
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer1(false);
						d.SetTurnOfPlayer2(true);
						if(versusMode)
							vs.doClick();
						return;
					}else {
						
						a.getTxt().setText("Info Box\nNot available move");
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer1(false);
						d.SetTurnOfPlayer2(true);
						if(versusMode)
							vs.doClick();
						return;
						}
				}
					
					a.getTxt().setText("Info Box");
					a.getTxt().setText(a.getTxt().getText()+"\nNot a starting card" +simulationCards.get(indexx).getNumber());
					simulationCards.remove(indexx);
					d.SetTurnOfPlayer1(false);
					d.SetTurnOfPlayer2(true);
					allowToMove=false;
					if(versusMode)
						vs.doClick();
					return;
				}
			
			
			if(simulator[i] instanceof SafetyZoneSquare&&simulator[i].getColor()=="yellow") {
				if(i+simulationCards.get(indexx).getNumber()==a.getYellowHome1()) {
					table[a.getYellowHome2()].add(buttons[1]);
					simulationCards.remove(indexx);
					allowToMove=false;
					yellowWinner++;
					d.setPositionOfPlayer1Pawn2(a.getYellowHome2());
					if(yellowWinner==2) {
						a.getTxt().setText("Info Box\nYellow player won!!!");
					}
					d.SetTurnOfPlayer1(false);
					d.SetTurnOfPlayer2(true);
					d.getFirstPlayer().getSecondPawn().setActive(false);
					a.getPanel().repaint();
					buttons[1].removeAll();
					if(versusMode)
						vs.doClick();
					return;
				}else if(i+simulationCards.get(indexx).getNumber()>a.getYellowHome1()) {
					if(simulationCards.get(indexx).getNumber()!=10&&simulationCards.get(indexx).getNumber()!=7)
						i-=simulationCards.get(indexx).getNumber();
					}
				
				}
			
			int checkForNumber2=simulationCards.get(indexx).getNumber();
			
			if(simulationCards.get(indexx).getNumber()==10) {
				i+=getChoice("-1 for a step back");
			}else if(checkForNumber2==7) {
				int t;
				t=getChoice("type the steps for this pawn");
				i+=t;
				d.setPositionOfPlayer1Pawn1(d.getPositionOfPlayer1Pawn1()+7-t);
				table[d.getPositionOfPlayer1Pawn1()].add(buttons[0]);
			}else if(checkForNumber2==11) {
				int t=getChoice("type 0 to trade pawns");
				if(t==0) {
					int p=i;
					if(d.getPositionOfPlayer2Pawn1()!=a.getRedStart1()&&d.getPositionOfPlayer2Pawn1()<31||d.getPositionOfPlayer2Pawn1()>39) {
						table[d.getPositionOfPlayer2Pawn1()].add(buttons[1]);
						table[p].add(buttons[2]);
						i=d.getPositionOfPlayer2Pawn1();
					
						d.setPositionOfPlayer1Pawn2(i);
						d.setPositionOfPlayer2Pawn1(p);
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer1(false);
						d.SetTurnOfPlayer2(true);
						if(versusMode)
							vs.doClick();
						return;
					}
					else if(d.getPositionOfPlayer2Pawn2()!=a.getRedStart2()&&d.getPositionOfPlayer2Pawn2()<31||d.getPositionOfPlayer2Pawn2()>39){
						table[d.getPositionOfPlayer2Pawn2()].add(buttons[1]);
						table[p].add(buttons[3]);
						i=d.getPositionOfPlayer2Pawn2();
						d.setPositionOfPlayer2Pawn2(p);
						d.setPositionOfPlayer1Pawn2(i);
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer1(false);
						d.SetTurnOfPlayer2(true);
						if(versusMode)
							vs.doClick();
						return;
					}else {
						
						a.getTxt().setText("Info Box\nNot available move");
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer1(false);
						d.SetTurnOfPlayer2(true);
						if(versusMode)
							vs.doClick();
						return;
						}
				}
				i+=11;
			}
			else
				i=i+simulationCards.get(indexx).getNumber();
			
			if(i>=31&&i<=39)
				i+=9;
			
			else if(i==29)
				i=41;
			else if(i<2) {
				int t=i;
				i=77;
				i+=-8+t;
			}
			
			if(simulator[i] instanceof StartSlideSquare&&simulator[i].getColor()!="yellow"&&!(i>=31&&i<=39)) {
				checkPawns(1,i,simulationCards.get(indexx).getNumber());
				checkPawns(1,i+1,simulationCards.get(indexx).getNumber());
				checkPawns(1,i+2,simulationCards.get(indexx).getNumber());
				checkPawns(1,i+3,simulationCards.get(indexx).getNumber());
				
				if(simulator[i+4] instanceof EndSlideSquare) {
					i=i+4;
					checkPawns(1,i+4,simulationCards.get(indexx).getNumber());
				}
				else
					i+=3;
			}
		
			
			
			if(checkForNumber2!=2) {
			d.SetTurnOfPlayer1(false);
			d.SetTurnOfPlayer2(true);
			}
			allowToMove=false;
			
			table[i].add(buttons[1]);
			d.setPositionOfPlayer1Pawn2(i);
			checkPawns(1,i,simulationCards.get(indexx).getNumber());
			simulationCards.remove(indexx);
			a.getPanel().repaint();
			i=d.getPositionOfPlayer1Pawn2();
			if(versusMode)
				vs.doClick();
			
			
		}
		
	}
	
private class redPawn1Listener implements ActionListener{
		private int i=a.getRedStart1()+2;
		
		public void actionPerformed(ActionEvent e) {
			
			if(bothPawnsOnHome(d.getSecondPlayer())) {
				
				return;
			}
			
			
			
			if(!allowToMove) {
				a.getTxt().setText("Info Box\nPick a card first");
				
				
				return;
			}
			if(!d.getTurnOfPlayer2()) {
				a.getTxt().setText("Info Box\nYellow players turn");
				return;
			}
			
			
			if(d.getPositionOfPlayer2Pawn1()==a.getRedStart1())
				i=a.getRedStart1()+2;
			else if(d.getPositionOfPlayer2Pawn1()!=i)
				i=d.getPositionOfPlayer2Pawn1();
			
			if(i==a.getRedStart1()+2) {
				if(simulationCards.get(indexx).getNumber()==1||simulationCards.get(indexx).getNumber()==2) {
					i+=simulationCards.get(indexx).getNumber();
					
					table[i].add(buttons[2]);
					checkPawns(2,i,simulationCards.get(indexx).getNumber());
					d.setPositionOfPlayer2Pawn1(i);
					a.getPanel().repaint();
					allowToMove=false;
					
					if(simulationCards.get(indexx).getNumber()==1) {
						d.SetTurnOfPlayer2(false);
						d.SetTurnOfPlayer1(true);
					}
					else {
						if(versusMode)
							vs.doClick();
					}
					simulationCards.remove(indexx);
					return;
				}else if(simulationCards.get(indexx).getNumber()==0) {
					if(d.getPositionOfPlayer1Pawn1()!=a.getYellowStart1()&&d.getPositionOfPlayer1Pawn1()<70) {
						table[d.getPositionOfPlayer1Pawn1()].add(buttons[2]);
						table[a.getYellowStart1()].add(buttons[0]);
						i=d.getPositionOfPlayer1Pawn1();
					
						d.setPositionOfPlayer2Pawn1(i);
						d.setPositionOfPlayer1Pawn1(a.getYellowStart1());
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer2(false);
						d.SetTurnOfPlayer1(true);
						return;
					}
					else if(d.getPositionOfPlayer1Pawn2()!=a.getYellowStart2()&&d.getPositionOfPlayer1Pawn2()<70){
						table[d.getPositionOfPlayer1Pawn2()].add(buttons[2]);
						table[a.getYellowStart2()].add(buttons[1]);
						i=d.getPositionOfPlayer1Pawn2();
						d.setPositionOfPlayer1Pawn2(a.getYellowStart2());
						
						d.setPositionOfPlayer2Pawn1(i);
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer2(false);
						d.SetTurnOfPlayer1(true);
						return;
					}
					else {
						a.getTxt().setText("Info Box\nNot available move");
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer2(false);
						d.SetTurnOfPlayer1(true);
						return;
					}
				}
				
				a.getTxt().setText("Info Box");
				a.getTxt().setText(a.getTxt().getText()+"\nNot a starting card" +simulationCards.get(indexx).getNumber());
				simulationCards.remove(indexx);
				allowToMove=false;
				d.SetTurnOfPlayer2(false);
				d.SetTurnOfPlayer1(true);
						
				return;
			}
			
			if(simulator[i] instanceof SafetyZoneSquare&&simulator[i].getColor()=="red") {
				if(i+simulationCards.get(indexx).getNumber()==a.getRedHome1()) {
					table[a.getRedHome1()].add(buttons[2]);
					simulationCards.remove(indexx);
					allowToMove=false;
					redWinner++;
					d.setPositionOfPlayer2Pawn1(a.getRedHome1());
					if(redWinner==2) {
						a.getTxt().setText("Info Box\nRed player won!!!");
					}
					d.SetTurnOfPlayer2(false);
					d.SetTurnOfPlayer1(true);
					d.getSecondPlayer().getFirstPawn().setActive(false);
					a.getPanel().repaint();
					buttons[2].removeAll();
					return;
				}else if(i+simulationCards.get(indexx).getNumber()>a.getRedHome1()) {
					if(simulationCards.get(indexx).getNumber()!=10&&simulationCards.get(indexx).getNumber()!=7)
						i-=simulationCards.get(indexx).getNumber();
					}
				}
			
			int checkForNumber2=simulationCards.get(indexx).getNumber();
			if(simulationCards.get(indexx).getNumber()==10) {
				i+=getChoice("-1 for a step back");
			}else if(checkForNumber2==7) {
				int t;
				t=getChoice("type the steps for this pawn");
				i+=t;
				d.setPositionOfPlayer2Pawn2(d.getPositionOfPlayer2Pawn2()+7-t);
				table[d.getPositionOfPlayer2Pawn2()].add(buttons[3]);
			}else if(i+checkForNumber2<41&&d.getPositionOfPlayer2Pawn2()>=41) {
				i-=10;
			}else if(checkForNumber2==11) {
				int t=getChoice("type 0 if you want to trade");
				if(t==0) {
					int p=i;
					if(d.getPositionOfPlayer1Pawn1()!=a.getYellowStart1()&&d.getPositionOfPlayer1Pawn1()<70) {
						table[d.getPositionOfPlayer1Pawn1()].add(buttons[2]);
						table[i].add(buttons[0]);
						
						i=d.getPositionOfPlayer1Pawn1();
						d.setPositionOfPlayer2Pawn1(i);
						d.setPositionOfPlayer1Pawn1(p);
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer2(false);
						d.SetTurnOfPlayer1(true);
						return;
					}
					else if(d.getPositionOfPlayer1Pawn2()!=a.getYellowStart2()&&d.getPositionOfPlayer1Pawn2()<70){
						table[d.getPositionOfPlayer1Pawn2()].add(buttons[2]);
						table[i].add(buttons[1]);
						i=d.getPositionOfPlayer1Pawn2();
						d.setPositionOfPlayer1Pawn2(p);
						d.setPositionOfPlayer2Pawn2(i);
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer2(false);
						d.SetTurnOfPlayer1(true);
						return;
					}else {
						a.getTxt().setText("Info Box\nNot available move");
						simulationCards.remove(indexx);
						a.getPanel().repaint();
						allowToMove=false;
						d.SetTurnOfPlayer2(false);
						d.SetTurnOfPlayer1(true);
						return;
					}
				}
				i+=11;
			}
			else
				i=i+simulationCards.get(indexx).getNumber();
		
			if(i<2) {
				int t=i;
				i=77;
				i+=-8+t;
			}
			
			if(simulator[i] instanceof StartSlideSquare&&simulator[i].getColor()!="red") {
				checkPawns(2,i,simulationCards.get(indexx).getNumber());
				checkPawns(2,i+1,simulationCards.get(indexx).getNumber());
				checkPawns(2,i+2,simulationCards.get(indexx).getNumber());
				checkPawns(2,i+3,simulationCards.get(indexx).getNumber());
				if(simulator[i+4] instanceof EndSlideSquare) {
					i=i+4;
					checkPawns(2,i+4,simulationCards.get(indexx).getNumber());
				}
				else
					i+=3;
			}
			
			
			
			
			if(i>=70) {
				int t=i;
				i=2;
				if(t>70)
					i+=t-71;
				else
					i+=t-70;	
			}
			
			
			
			allowToMove=false;
			if(checkForNumber2!=2) {
			d.SetTurnOfPlayer1(true);
			d.SetTurnOfPlayer2(false);
			}
			table[i].add(buttons[2]);
			d.setPositionOfPlayer2Pawn1(i);
			checkPawns(2,i,simulationCards.get(indexx).getNumber());
			a.getPanel().repaint();
			
			
			i=d.getPositionOfPlayer2Pawn1();
			
			simulationCards.remove(indexx);
		}
		
	}
private class redPawn2Listener implements ActionListener{
	private int i=a.getRedStart2()+1;
	
	public void actionPerformed(ActionEvent e) {
		
		if(bothPawnsOnHome(d.getSecondPlayer())) {
			
			return;
		}
		
		
		
		if(!allowToMove) {
			a.getTxt().setText("Info Box\nPick a card first");
			return;
		}
		if(!d.getTurnOfPlayer2()) {
			a.getTxt().setText("Info Box\nYellow players turn");
			
			return;
		}
		if(d.getPositionOfPlayer2Pawn2()==a.getRedStart2())
			i=a.getRedStart2()+1;
		else if(d.getPositionOfPlayer2Pawn2()!=i)
			i=d.getPositionOfPlayer2Pawn2();
		
		
		
		
		if(i==a.getRedStart2()+1) {
			if(simulationCards.get(indexx).getNumber()==1||simulationCards.get(indexx).getNumber()==2) {
				i+=simulationCards.get(indexx).getNumber();
				
				table[i].add(buttons[3]);
				checkPawns(3,i,simulationCards.get(indexx).getNumber());
				d.setPositionOfPlayer2Pawn2(i);
				a.getPanel().repaint();
				allowToMove=false;
				
				if(simulationCards.get(indexx).getNumber()==1) {
				d.SetTurnOfPlayer2(false);
				d.SetTurnOfPlayer1(true);
				}else {
					if(versusMode)
						vs.doClick();
				}
				simulationCards.remove(indexx);
				return;
			}
			else if(simulationCards.get(indexx).getNumber()==0) {
				if(d.getPositionOfPlayer1Pawn1()!=a.getYellowStart1()&&d.getPositionOfPlayer1Pawn1()<70) {
					table[d.getPositionOfPlayer1Pawn1()].add(buttons[3]);
					table[a.getYellowStart1()].add(buttons[0]);
					i=d.getPositionOfPlayer1Pawn1();
					d.setPositionOfPlayer2Pawn2(i);
					d.setPositionOfPlayer1Pawn1(a.getYellowStart1());
					simulationCards.remove(indexx);
					a.getPanel().repaint();
					allowToMove=false;
					d.SetTurnOfPlayer2(false);
					d.SetTurnOfPlayer1(true);
					return;
				}
				else if(d.getPositionOfPlayer1Pawn2()!=a.getYellowStart2()&&d.getPositionOfPlayer1Pawn2()<70){
					table[d.getPositionOfPlayer1Pawn2()].add(buttons[3]);
					table[a.getYellowStart2()].add(buttons[1]);
					i=d.getPositionOfPlayer1Pawn2();
					d.setPositionOfPlayer1Pawn2(a.getYellowStart2());
					d.setPositionOfPlayer2Pawn2(i);
					simulationCards.remove(indexx);
					a.getPanel().repaint();
					allowToMove=false;
					d.SetTurnOfPlayer2(false);
					d.SetTurnOfPlayer1(true);
					return;
				}
				else {
					a.getTxt().setText("Info Box\nNot available move");
					simulationCards.remove(indexx);
					a.getPanel().repaint();
					allowToMove=false;
					d.SetTurnOfPlayer2(false);
					d.SetTurnOfPlayer1(true);
					return;
				}
			}
			a.getTxt().setText("Info Box");
			a.getTxt().setText(a.getTxt().getText()+"\nNot a starting card" +simulationCards.get(indexx).getNumber());
			simulationCards.remove(indexx);
			allowToMove=false;
			d.SetTurnOfPlayer2(false);
			d.SetTurnOfPlayer1(true);
					
			return;
		}
		
		if(simulator[i] instanceof SafetyZoneSquare&&simulator[i].getColor()=="red") {
			if(i+simulationCards.get(indexx).getNumber()==a.getRedHome1()) {
				table[a.getRedHome2()].add(buttons[3]);
				simulationCards.remove(indexx);
				allowToMove=false;
				d.setPositionOfPlayer2Pawn2(a.getRedStart2());
				redWinner++;
				if(redWinner==2) {
					a.getTxt().setText("Info Box\nRed player won!!!");
				}
				d.SetTurnOfPlayer2(false);
				d.SetTurnOfPlayer1(true);
				d.getSecondPlayer().getSecondPawn().setActive(false);
				a.getPanel().repaint();
				buttons[3].removeAll();
				return;
			}else if(i+simulationCards.get(indexx).getNumber()>a.getRedHome1()) {
				if(simulationCards.get(indexx).getNumber()!=10&&simulationCards.get(indexx).getNumber()!=7)
					i-=simulationCards.get(indexx).getNumber();
				}
			}
		
		int checkForNumber2=simulationCards.get(indexx).getNumber();
		
		if(simulationCards.get(indexx).getNumber()==10) {
			i+=getChoice("-1 for a step back");
		}else if(checkForNumber2==7) {
			int t;
			t=getChoice("type the steps for this pawn");
			i+=t;
			d.setPositionOfPlayer2Pawn1(d.getPositionOfPlayer2Pawn1()+7-t);
			table[d.getPositionOfPlayer2Pawn1()].add(buttons[2]);
		}else if(i+checkForNumber2<41&&d.getPositionOfPlayer2Pawn2()>=41) {
				i-=10;
		}else if(checkForNumber2==11) {
			int t=getChoice("type 0 if you want to trade");
			if(t==0) {
				int p=i;
				if(d.getPositionOfPlayer1Pawn1()!=a.getYellowStart1()&&d.getPositionOfPlayer1Pawn1()<70) {
					table[d.getPositionOfPlayer1Pawn1()].add(buttons[3]);
					table[i].add(buttons[0]);
					i=d.getPositionOfPlayer1Pawn1();
					d.setPositionOfPlayer2Pawn2(i);
					d.setPositionOfPlayer1Pawn1(p);
					simulationCards.remove(indexx);
					a.getPanel().repaint();
					allowToMove=false;
					d.SetTurnOfPlayer2(false);
					d.SetTurnOfPlayer1(true);
					return;
				}
				else if(d.getPositionOfPlayer1Pawn2()!=a.getYellowStart2()&&d.getPositionOfPlayer1Pawn2()<70){
					table[d.getPositionOfPlayer1Pawn2()].add(buttons[3]);
					table[i].add(buttons[1]);
					i=d.getPositionOfPlayer1Pawn2();
					d.setPositionOfPlayer1Pawn2(p);
					d.setPositionOfPlayer2Pawn2(i);
					simulationCards.remove(indexx);
					a.getPanel().repaint();
					allowToMove=false;
					d.SetTurnOfPlayer2(false);
					d.SetTurnOfPlayer1(true);
					return;
				}
				else {
					a.getTxt().setText("Info Box\nNot available move");
					simulationCards.remove(indexx);
					a.getPanel().repaint();
					allowToMove=false;
					d.SetTurnOfPlayer2(false);
					d.SetTurnOfPlayer1(true);
					return;
				}
			}
			i+=11;
		}else
			i=i+simulationCards.get(indexx).getNumber();
		
		if(i<2) {
			int t=i;
			i=77;
			i+=-8+t;
		}
		
		if(simulator[i] instanceof StartSlideSquare&&simulator[i].getColor()!="red") {
			checkPawns(3,i,simulationCards.get(indexx).getNumber());
			checkPawns(3,i+1,simulationCards.get(indexx).getNumber());
			checkPawns(3,i+2,simulationCards.get(indexx).getNumber());
			checkPawns(3,i+3,simulationCards.get(indexx).getNumber());
			if(simulator[i+4] instanceof EndSlideSquare) {
				i=i+4;
				checkPawns(3,i+4,simulationCards.get(indexx).getNumber());
			}
			else
				i+=3;
		}
		
		if(i>=70) {
			int t=i;
			i=2;
			if(t>70)
				i+=t-71;
			else
				i+=t-70;
		}
		
		
		
		allowToMove=false;
		if(checkForNumber2!=2) {
		d.SetTurnOfPlayer1(true);
		d.SetTurnOfPlayer2(false);
		}
		table[i].add(buttons[3]);
		d.setPositionOfPlayer2Pawn2(i);
		checkPawns(3,i,simulationCards.get(indexx).getNumber());
		i=d.getPositionOfPlayer2Pawn2();
		
		a.getPanel().repaint();
		
		simulationCards.remove(indexx);
		
	}
	
}




void checkPawns(int myPawn,int position,int numberOfCard) {
	Pawn[] pawns=d.getPawns();
	for(int i=0;i<4;i++) {
		if(i!=myPawn) {
			if(pawns[i].getPosition()==position&&pawns[i].getColor()!=pawns[myPawn].getColor()) {
				table[pawns[i].getStartingPosition()].add(buttons[i]);
				pawns[i].setPosition(pawns[i].getStartingPosition());
				a.getPanel().repaint();
			}
			else if(pawns[i].getPosition()==position&&pawns[i].getColor()==pawns[myPawn].getColor()) {
				a.getTxt().setText("Info Box\nNot possible move");
				
					table[position-numberOfCard].add(buttons[myPawn]);
					pawns[myPawn].setPosition(position-numberOfCard);
					a.getPanel().repaint();
				//	int pair=findPair(myPawn);
				//	table[position+numberOfCard].add(buttons[pair]);
				//	pawns[pair].setPosition(position+numberOfCard);
			}
		}
	}
}

	public int findPair(int p) {
		if(p==0) {
	
			return 1;
		}
		if(p==1) {
	
			return 0;
		}
		if(p==2) {
		
			return 3;
		}
	
		return 2;
	}
	
	
	public static void main(String[] args) {
    	Controller a = new Controller();
    }
	
	
}
