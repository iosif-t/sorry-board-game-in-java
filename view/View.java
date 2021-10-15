package view;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;



import model.*;

public class View extends JFrame  {
	private int yellowHome1,yellowHome2,redHome1,redHome2,yellowStart1,yellowStart2,redStart1,redStart2,yellowToSafeZone,redToSafeZone;
	private JLabel[] table,temp,safeZoneRed,safeZoneYellow,startForYellow,startForRed,restTable,redHome,yellowHome;
	private Square[] tableSimulation,tmp;
	private JLabel img;
	private URL urlImage;
	private Image image;
	private ClassLoader cldr;
	private JButton card1,card2,foldButton,pawn1,pawn2,pawn3,pawn4,saveButton,continueSavedButton,pVsC;
	private JTextArea txt;
	private JLayeredPaneExtension panel;
	private ArrayList<JLabel> cards;
	private ArrayList<Card> cardSimulation;
	
	public JButton getBackCard() {
		return this.card1;
	}
	
	public JButton getCurrentButton() {
		return this.card2;
	}
	public JLabel[] getTable() {
		return this.temp;
	}
	public Square[] getSimulationTable() {
		return this.tmp;
	}
	public JButton[] getButtons() {
		JButton[] b = new JButton[4];
		b[0]=this.pawn1;
		b[1]=this.pawn2;
		b[2]=this.pawn3;
		b[3]=this.pawn4;
		return b;
	}
	public int getYellowHome1() {
		return this.yellowHome1;
	}
	public int getYellowHome2() {
		return this.yellowHome2;
	}
	public int getRedHome1() {
		return this.redHome1;
	}
	public int getRedHome2() {
		return this.redHome2;
	}
	public int getYellowStart1() {
		return this.yellowStart1;
	}
	public int getYellowStart2() {
		return this.yellowStart2;
	}
	public int getRedStart1() {
		return this.redStart1;
	}
	public int getRedStart2() {
		return this.redStart2;
	}
	public int getYellowToSafetyZone() {
		return this.yellowToSafeZone+3;
	}
	public int getRedToSafetyZone() {
		return this.redToSafeZone +1;
	}
	public JTextArea getTxt() {
		return this.txt;
	}
	public ArrayList<JLabel> getCards(){
		return this.cards;
	}
	public ArrayList<Card> getCardSimulation() {
		return this.cardSimulation;
	}
	public JButton getFoldButton() {
		return this.foldButton;
	}
	public JButton getSaveButton() {
		return this.saveButton;
	}
	public JButton getContinueButton() {
		return this.continueSavedButton;
	}
	public JButton getVsButton() {
		return this.pVsC;
	}
	
	/**
	 * constructor
	 */
	public View() {
		JLabel pos1=addToPane(panel,11*56,13*63),pos2=addToPane(panel,11*62,13*63),pos3=addToPane(panel,4*55,75),
			pos4=addToPane(panel,4*72,75),hom1=addToPane(panel,3*55,7*55),hom2=addToPane(panel,3*32,7*55),hom3=addToPane(panel,12*61,8*66),hom4=addToPane(panel,13*62,8*66);
		
		
		cardSimulation=new ArrayList<Card>();
		cards= new ArrayList<JLabel>();
		tableSimulation =new Square[74];
		tmp=new Square[78];
		table=new JLabel[78];
		temp=new JLabel[78];
		cldr=this.getClass().getClassLoader();
        JFrame win = new JFrame("Sorry Game");
        urlImage=cldr.getResource("images/background.png");
        
        image=new ImageIcon(urlImage).getImage();
        image=image.getScaledInstance(2000,1001,java.awt.Image.SCALE_SMOOTH);
        panel=new JLayeredPaneExtension(image);
       
        //gia sorry
        urlImage=cldr.getResource("images/sorryImage.png");
        image= new ImageIcon(urlImage).getImage();
        image = image.getScaledInstance(300, 100, java.awt.Image.SCALE_SMOOTH);
        img= new JLabel(new ImageIcon(image)); 
        img.setBounds(5*60, 7*60, 300, 100);
        img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        panel.add(img);
      
        panel.add(hom3);
        panel.add(hom4);
        
        
     
       table[27]=addToPanel(panel,0,0);
       tableSimulation[27]=new SimpleSquare(27);
       table[26]=addToPanel(panel,0,60);
       tableSimulation[26]=new SimpleSquare(26);
       table[20]=addToPanel(panel,0,7*60);
       tableSimulation[20]=new SimpleSquare(20);
       table[19]=addToPanel(panel,0,8*60);
       tableSimulation[19]=new SimpleSquare(19);
       table[18]=addToPanel(panel,0,9*60);
       tableSimulation[18]=new SimpleSquare(18);
       table[17]=addToPanel(panel,0,10*60);
       tableSimulation[17]=new SimpleSquare(17);
       
       
       table[12]=addToPanel(panel,0,15*60);
       tableSimulation[12]=new SimpleSquare(12);
       table[11]=addToPanel(panel,60,15*60);
       tableSimulation[11]=new SimpleSquare(11);
       table[5]=addToPanel(panel,7*60,15*60);
       tableSimulation[5]=new SimpleSquare(5);
       table[4]=addToPanel(panel,8*60,15*60);
       tableSimulation[4]=new SimpleSquare(4);
       table[3]=addToPanel(panel,9*60,15*60);
       tableSimulation[3]=new SimpleSquare(3);
       table[2]=addToPanel(panel,10*60,15*60); 
       tableSimulation[2]=new SimpleSquare(2);
      
       
       table[64]=addToPanel(panel,15*60,15*60);
       tableSimulation[64]=new SimpleSquare(64);
       table[63]=addToPanel(panel,15*60,14*60);
       tableSimulation[63]=new SimpleSquare(63);
       table[57]=addToPanel(panel,15*60,8*60);
       tableSimulation[57]=new SimpleSquare(57);
       table[56]=addToPanel(panel,15*60,7*60);
       tableSimulation[56]=new SimpleSquare(56);
       table[55]=addToPanel(panel,15*60,6*60);
       tableSimulation[55]=new SimpleSquare(55);
       table[54]=addToPanel(panel,15*60,5*60);
       tableSimulation[54]=new SimpleSquare(54);
       
       
       table[49]=addToPanel(panel,15*60,0);
       tableSimulation[49]=new SimpleSquare(49);
       table[39]=addToPanel(panel,5*60,0);
       tableSimulation[39]=new SimpleSquare(39);
       table[40]=addToPanel(panel,6*60,0);
       tableSimulation[40]=new SimpleSquare(40);
       table[41]=addToPanel(panel,7*60,0);
       tableSimulation[41]=new SimpleSquare(41);
       table[42]=addToPanel(panel,8*60,0);
       tableSimulation[42]=new SimpleSquare(42);
       table[48]=addToPanel(panel,14*60,0);
       tableSimulation[48]=new SimpleSquare(48);
       
       
       urlImage=cldr.getResource("images/slides/redSlideStart.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(60, 0, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       table[28]=img;
       tableSimulation[28]=new StartSlideSquare("red",false,28);
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/redSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(2*60, 0, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       table[29]=img;
       tableSimulation[29]=new IternalSlideSquare("red",false,29);
       redToSafeZone=29;
  //     panel.add(img);
       
       urlImage=cldr.getResource("images/slides/redSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(3*60, 0, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[37]=new IternalSlideSquare("red",false,37);
       table[37]=img;
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/redSlideEnd.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(4*60, 0, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[38]=new EndSlideSquare("red",false,38);
       table[38]=img;
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/redSlideStart.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(9*60, 0, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[43]=new StartSlideSquare("red",true,43);
       table[43]=img;
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/redSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(10*60, 0, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[44]=new IternalSlideSquare("red",true,44);
       table[44]=img;
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/redSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(11*60, 0, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[45]=new IternalSlideSquare("red",true,45);
       table[45]=img;
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/redSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(12*60, 0, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[46]=new IternalSlideSquare("red",true,46);
       table[46]=img;
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/redSlideEnd.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(13*60, 0, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[47]=new EndSlideSquare("red",true,47);
       table[47]=img;
   //    panel.add(img);
        
        //edw gia prasino
       urlImage=cldr.getResource("images/slides/greenSlideEnd.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(0, 2*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[25]=new EndSlideSquare("green",true,25);
       table[25]=img;
  //     panel.add(img);
       
       urlImage=cldr.getResource("images/slides/greenSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(0, 3*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[24]=new IternalSlideSquare("green",true,24);
       table[24]=img;
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/greenSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(0, 4*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[23]=new IternalSlideSquare("green",true,23);
       table[23]=img;
 //      panel.add(img);
       
       
       urlImage=cldr.getResource("images/slides/greenSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(0, 5*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[22]=new IternalSlideSquare("green",true,22);
       table[22]=img;
 //      panel.add(img);
       
       
       urlImage=cldr.getResource("images/slides/greenSlideStart.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(0, 6*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[21]=new StartSlideSquare("green",true,21);
       table[21]=img;
//       panel.add(img);
       
       
       urlImage=cldr.getResource("images/slides/greenSlideEnd.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(0, 11*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[16]=new EndSlideSquare("green",false,16);
       table[16]=img;
   //    panel.add(img);
       
       
       urlImage=cldr.getResource("images/slides/greenSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(0, 12*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[15]=new IternalSlideSquare("green",false,15);
       table[15]=img;
   //    panel.add(img);
       
       
       urlImage=cldr.getResource("images/slides/greenSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(0, 13*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[14]=new IternalSlideSquare("green",false,14);
       table[14]=img;
   //    panel.add(img);
       
       
       urlImage=cldr.getResource("images/slides/greenSlideStart.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(0, 14*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[13]=new StartSlideSquare("green",false,13);
       table[13]=img;
   //    panel.add(img);
      
       //egw ta kitrina
        
       urlImage=cldr.getResource("images/slides/yellowSlideEnd.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(2*60, 15*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[10]=new EndSlideSquare("yellow",true,10);
       table[10]=img;
  //     panel.add(img);
       
       urlImage=cldr.getResource("images/slides/yellowSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(3*60, 15*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[9]=new IternalSlideSquare("yellow",true,9);
       table[9]=img;
  //     panel.add(img);
       
       urlImage=cldr.getResource("images/slides/yellowSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(4*60, 15*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[8]=new IternalSlideSquare("yellow",true,8);
       table[8]=img;
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/yellowSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(5*60, 15*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[7]=new IternalSlideSquare("yellow",true,7);
       table[7]=img;
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/yellowSlideStart.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(6*60, 15*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[6]=new StartSlideSquare("yellow",true,6);
       table[6]=img;
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/yellowSlideEnd.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(11*60, 15*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       table[1]=img;
       tableSimulation[1]=new EndSlideSquare("yellow",true,1);
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/yellowSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(12*60, 15*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[73]=new IternalSlideSquare("yellow",false,73);
       table[73]=img;
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/yellowSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(13*60, 15*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[66]=new IternalSlideSquare("yellow",true,66);
       table[66]=img;
      
       yellowToSafeZone=66;
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/yellowSlideStart.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(14*60, 15*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[65]=new StartSlideSquare("yellow",true,65);
       table[65]=img;
   //    panel.add(img);
       
       //edw gia ta blue
       urlImage=cldr.getResource("images/slides/blueSlideEnd.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(15*60, 13*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[62]=new EndSlideSquare("blue",true,62);
       table[62]=img;
    //   panel.add(img);
       
       urlImage=cldr.getResource("images/slides/blueSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(15*60, 12*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[61]=new IternalSlideSquare("blue",true,61);
       table[61]=img;
    //   panel.add(img);
       
       urlImage=cldr.getResource("images/slides/blueSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(15*60, 11*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[60]=new IternalSlideSquare("blue",true,60);
       table[60]=img;
    //   panel.add(img);
       
       urlImage=cldr.getResource("images/slides/blueSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(15*60, 10*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[59]=new IternalSlideSquare("blue",true,59);
       table[59]=img;
   //    panel.add(img);
       
       urlImage=cldr.getResource("images/slides/blueSlideStart.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(15*60, 9*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[58]=new StartSlideSquare("blue",true,58);
       table[58]=img;
    
       
       
       
       
       urlImage=cldr.getResource("images/slides/blueSlideEnd.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(15*60, 4*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[53]=new EndSlideSquare("blue",true,53);
       table[53]=img;
     //  panel.add(img);
       
       urlImage=cldr.getResource("images/slides/blueSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(15*60, 3*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[52]=new IternalSlideSquare("blue",true,52);
       table[52]=img;
     //  panel.add(img);
       
       urlImage=cldr.getResource("images/slides/blueSlideMedium.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(15*60, 2*60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[51]=new IternalSlideSquare("blue",true,51);
       table[51]=img;
     //  panel.add(img);
       
       urlImage=cldr.getResource("images/slides/blueSlideStart.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       img= new JLabel(new ImageIcon(image));
       img.setBounds(15*60, 60, 60, 60);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
       tableSimulation[50]=new StartSlideSquare("blue",true,50);
       table[50]=img;
      // panel.add(img);
       
       
       
       //safe zone gia kitrino
       table[67]=addToPanelYellow(panel,13*60,14*60);
       tableSimulation[67]= new SafetyZoneSquare("yellow",67);
       table[68]=addToPanelYellow(panel,13*60,13*60);
       tableSimulation[68]= new SafetyZoneSquare("yellow",68);
       table[69]=addToPanelYellow(panel,13*60,12*60);
       tableSimulation[69]= new SafetyZoneSquare("yellow",69);
       table[70]=addToPanelYellow(panel,13*60,11*60);
       tableSimulation[70]= new SafetyZoneSquare("yellow",70);
       table[71]=addToPanelYellow(panel,13*60,10*60);
       tableSimulation[71]= new SafetyZoneSquare("yellow",71);
       
       
       img=new JLabel();
       img.setBounds(12*60, 8*60, 160, 120);
       
       img.setBackground(Color.white);
       img.setOpaque(true);
       img.setBorder(BorderFactory.createLineBorder(Color.YELLOW,9));
       img.setText("HOME");
       img.setFont(new Font("Serif",Font.BOLD,22));
       img.setVerticalAlignment(JLabel.TOP);
       img.setHorizontalAlignment(0);
       table[72]=img;
       tableSimulation[72]=new HomeSquare("yellow",72);
       
       
      
      // panel.add(img);
       
       img=new JLabel();
       img.setBounds(10*60, 13*60, 160, 120);
       
       img.setBackground(Color.white);
       img.setOpaque(true);
       img.setBorder(BorderFactory.createLineBorder(Color.YELLOW,9));
       img.setText("START");
       img.setFont(new Font("Serif",Font.BOLD,22));
       img.setVerticalAlignment(JLabel.TOP);
       img.setHorizontalAlignment(0);
       
       table[0]=img;
       tableSimulation[0]=new StartSquare("yellow",0);
      
       
       //safe zone gia kokkina
       	table[30]= addToPanelRed(panel,2*60,60);
       	tableSimulation[30]= new SafetyZoneSquare("red",30);
      	table[31]= addToPanelRed(panel,2*60,2*60);
      	tableSimulation[31]= new SafetyZoneSquare("red",31);
      	table[32]= addToPanelRed(panel,2*60,3*60);
      	tableSimulation[32]= new SafetyZoneSquare("red",32);
      	table[33]= addToPanelRed(panel,2*60,4*60);
      	tableSimulation[33]= new SafetyZoneSquare("red",33);
      	table[34]= addToPanelRed(panel,2*60,5*60);
      	tableSimulation[34]= new SafetyZoneSquare("red",34);
       
       
       img=new JLabel();
       img.setBounds(80, 6*60, 160, 120);
       img.setBackground(Color.white);
       img.setOpaque(true);
       img.setBorder(BorderFactory.createLineBorder(Color.RED,9));
       img.setText("HOME");
       img.setFont(new Font("Serif",Font.BOLD,22));
       img.setVerticalAlignment(JLabel.BOTTOM);
       img.setHorizontalAlignment(0);
       table[35]=img;
       tableSimulation[35]=new HomeSquare("red",35);
      
     //  panel.add(img);
       
       img=new JLabel();
       img.setBounds(4*50, 60, 160, 120);
       img.setBackground(Color.white);
       img.setOpaque(true);
       img.setBorder(BorderFactory.createLineBorder(Color.RED,9));
       img.setText("START");
       img.setFont(new Font("Serif",Font.BOLD,22));
       img.setVerticalAlignment(JLabel.BOTTOM);
       img.setHorizontalAlignment(0);
       table[36]=img;
       tableSimulation[36]=new StartSquare("red",36);
      
      // panel.add(img);
       
       
       
       //edw ta JBUttons       
       card1=new JButton();
       
       urlImage=cldr.getResource("images/cards/backCard.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH);
       card1=new JButton(new ImageIcon(image));
       card1.setBounds(20*60, 4*60, 200, 300);
       panel.add(card1);
       
       card2=new JButton();
       card2.setBounds(24*60, 4*60, 200, 300);
       panel.add(card2);
       
       foldButton=new JButton();
       foldButton.setBounds(20*60, 10*60, 450, 100);
       foldButton.setText("Fold Button");
       foldButton.setFont(new Font("Serif",Font.BOLD,20));
       foldButton.setBackground(Color.RED);
       foldButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       panel.add(foldButton);
       
       
       img=new JLabel();
       img.setText("Receive Card");
       img.setFont(new Font("Serif",Font.BOLD,20));
       img.setBounds(20*60,9*61 , 150, 25);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       img.setBackground(Color.GRAY);
       img.setOpaque(true);
       panel.add(img);
       
       img=new JLabel();
       img.setText("Current Card");
       img.setFont(new Font("Serif",Font.BOLD,20));
       img.setBounds(24*60,9*61 , 150, 25);
       img.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       img.setBackground(Color.GRAY);
       img.setOpaque(true);
       panel.add(img);
       
       
       //jTextArea
       txt=new JTextArea();
       txt.setBounds(20*60,12*61,300,150);
       txt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       txt.setBackground(Color.WHITE);
       txt.setText("Info Box");
       txt.setOpaque(true);
       txt.setFont(new Font("Serif",Font.BOLD,20));
       panel.add(txt);
       
       
       //ta yellow pawns
       pawn1=new JButton();
       urlImage=cldr.getResource("images/pawns/yellowPawn1.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       pawn1=new JButton(new ImageIcon(image));
       pawn1.setOpaque(true);
      
       pawn1.setSize(60,60);
     //  table[yellowStart].add(pawn1);
      
      
       
       
      
       
       
       
       pawn2=new JButton();
       urlImage=cldr.getResource("images/pawns/yellowPawn2.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       pawn2=new JButton(new ImageIcon(image));
       pawn2.setOpaque(true);
       pawn2.setVisible(true);  
       pawn2.setSize(60,60);
    //   pawn2.setBounds(11*56,13*63,60,60);
   //    panel.add(pawn2);
      
       
        
       //ta red pawns
       pawn3=new JButton();
       urlImage=cldr.getResource("images/pawns/redPawn1.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       pawn3=new JButton(new ImageIcon(image));
       pawn3.setOpaque(true);
       pawn3.setVisible(true); 
       pawn3.setSize(60,60);
      // pawn3.setBounds(4*55, 80, 60, 60);
      // panel.add(pawn3);
       
       
       
       pawn4=new JButton();
       urlImage=cldr.getResource("images/pawns/redPawn2.png");
       image= new ImageIcon(urlImage).getImage();
       image = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
       pawn4=new JButton(new ImageIcon(image));
       pawn4.setOpaque(true);
       pawn4.setVisible(true);
       pawn4.setSize(60,60);
   //    pawn4.setBounds(5*57, 80, 60, 60);
  //     panel.add(pawn4);
      
       
       saveButton=new JButton();
       saveButton.setOpaque(true);
       saveButton.setText("Save Game");
       saveButton.setBounds(17*60, 0, 100, 40);
       panel.add(saveButton);
       
       
       continueSavedButton=new JButton();
       continueSavedButton.setOpaque(true);
       continueSavedButton.setText("Continue Saved Game");
       continueSavedButton.setBounds(17*61+100, 0, 200, 40);
       panel.add(continueSavedButton);
       
       
       
       pVsC=new JButton();
       pVsC.setOpaque(true);
       pVsC.setText("Play vs Co");
       pVsC.setBounds(17*62+300, 0, 200, 40);
       panel.add(pVsC);
       
       
       panel.add(pos1);
       panel.add(pos2);
       panel.add(pos3);
       panel.add(pos4);
       pos4.add(pawn4);
       pos3.add(pawn3);
       pos2.add(pawn2);
       pos1.add(pawn1); 
      
       panel.add(hom2);
       panel.add(hom1);
       table[74]=pos1;
       table[75]=pos2;
       table[76]=pos3;
       table[77]=pos4; 
       
       temp[0]=pos1;
       tmp[0]=new StartSquare("yellow",0);
       tmp[1]=new StartSquare("yellow",1);
       yellowStart1=0;
       yellowStart2=1;
       temp[1]=pos2;
       int j=2;
       for(int i=1;i<35;i++) {
    	   tmp[j]=tableSimulation[i];
    	   temp[j]=table[i];
    	   j++;
       }
       tmp[j]=new HomeSquare("red",j);
       tmp[j+1]=new HomeSquare("red",j+1);
       tmp[j+2]=new StartSquare("red",j+2);
       tmp[j+3]=new StartSquare("red",j+3);
       temp[j]=hom1;
       redHome1=j;
       redHome2=j+1;
       temp[j+1]=hom2;
       temp[j+2]=pos3;
       redStart1=j+2;
       redStart2=j+3;
       temp[j+3]=pos4;
       j=j+4;
       for(int i=37;i<72;i++) {
    	   tmp[j]=tableSimulation[i];
    	   temp[j]=table[i];
    	   j++;
       }
       yellowHome1=j;
       yellowHome2=j+1;
       tmp[j]=new HomeSquare("yellow",j);
       tmp[j+1]=new HomeSquare("yellow",j+1);
       tmp[j+2]=tableSimulation[73];
       temp[j]=hom3;
       temp[j+1]=hom4;
       temp[j+2]=table[73];
       
       
       
       
       for(int i=0;i<74;i++)
    	   panel.add(table[i]);
      
    /*   restTable=new JLabel[60];
       j=0;
       for(int i=2;i<78;i++) {
    	   if(i==31)
    		   i=40;
    	   else if(i==70)
    		   i=77;
    	   restTable[j]=temp[i];
    	   j++;
       }
       safeZoneRed=new JLabel[5];
       safeZoneYellow=new JLabel[5];
       int a=31,b=70;
       for(int i=0;i<5;i++) {
    	   safeZoneRed[i]=temp[a];
    	   a++;
    	   safeZoneYellow[i]=temp[b];
    	   b++;
       }
       startForYellow=new JLabel[2];
       startForYellow[0]=temp[0];
       startForYellow[1]=temp[1];
       startForRed=new JLabel[2];
       startForRed[0]=temp[38];
       startForRed[1]=temp[39];
       redHome= new JLabel[2];
       yellowHome=new JLabel[2];
       redHome[0]=temp[36];
       redHome[1]=temp[37];
       yellowHome[0]=temp[75];
       yellowHome[1]=temp[76]; */
       
       
       
       
       
       initializeCards(cards);
       ShuffleSim();
       win.setSize(1000,800);
       win.add(panel);
       win.setVisible(true);
       win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	
	
	public JLayeredPaneExtension getPanel() {
		return this.panel;
	}
	
	public JLabel addToPanel(JLayeredPaneExtension panel,int x,int y) {
		JLabel img=new JLabel();
		img.setBounds(x,y,60,60);
		img.setBackground(Color.white);
		img.setOpaque(true);
		img.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		//panel.add(img);
		return img;
	}
	public JLabel addToPane(JLayeredPaneExtension panel,int x,int y) {
		JLabel img=new JLabel();
		img.setBounds(x,y,60,60);
		img.setBackground(Color.white);
		img.setOpaque(true);
		return img;
	}
	
	public JLabel addToPanelYellow(JLayeredPaneExtension panel,int x,int y) {
		JLabel img=new JLabel();
		img.setBounds(x,y,60,60);
		img.setBackground(Color.yellow);
		img.setOpaque(true);
		img.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		//panel.add(img);
		return img;
	}
	public JLabel addToPanelRed(JLayeredPaneExtension panel,int x,int y) {
		JLabel img=new JLabel();
		img.setBounds(x,y,60,60);
		img.setBackground(Color.red);
		img.setOpaque(true);
		img.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		//panel.add(img);
		return img;
	}
	
	
	
	
    

	/**
	 * transformer
	 * pre pass a pawn and the next position 
	 * post the pawn is refreshed
	 * @param p pawn
	 * @param  position position
	 */
	public void updatePawn(Pawn p , int position) {}
	/**
	 * transformer
	 * pre pass an alive card
	 * post the card is discarded
	 * @param c card
	 */
	public void discardCard(Card c) {}
	
	/**
	 * transformer
	 * pre pass a message
	 * post the message now is on infobox
	 * @param message message
	 */
	public void updateInfoBox(String message) {}
	/**
	 * transformer
	 * pre pass the winning message
	 * post the winner is now shown
	 * @param message message
	 */
	public void showWinningMessage(String message) {}
	/**
	 * pre pass a message for invalid action
	 * post the message is now shown
	 * @param action action
	 */
	public void showInvalidAction(String action) {}
	/**
	 * transformer
	 * pre pass the deck
	 * post the deck is now initialized
	 * @param d deck
	 */
	public void initializeCards(ArrayList<JLabel> cards) {
	
		for(int i=0;i<4;i++) {
			   
		       cards.add(initCards("images/cards/card1.png"));
		       
		       cards.add(initCards("images/cards/card2.png"));
		      
		       cards.add(initCards("images/cards/card3.png"));
		       
		       cards.add(initCards("images/cards/card4.png"));
		     
		       cards.add(initCards("images/cards/card5.png"));
		      
		       cards.add(initCards("images/cards/cardSorry.png"));
		       
		       cards.add(initCards("images/cards/card7.png"));
		       
		       cards.add(initCards("images/cards/card8.png"));
		      
		       cards.add(initCards("images/cards/card10.png"));
		       
		       cards.add(initCards("images/cards/card11.png"));
		      
		       cards.add(initCards("images/cards/card12.png"));
		       
		      }
	}
	public void ShuffleSim() {
		for(int i=0;i<4;i++) {
			cardSimulation.add(new NumberOneCard());
			cardSimulation.add(new NumberTwoCard());
			cardSimulation.add(new NumberThreeCard());
			cardSimulation.add(new NumberFourCard());
			cardSimulation.add(new NumberFiveCard());
			cardSimulation.add(new SorryCard());
			cardSimulation.add(new NumberSevenCard());
			cardSimulation.add(new NumberEightCard());
			cardSimulation.add(new NumberTenCard());
			cardSimulation.add(new NumberElevenCard());
			cardSimulation.add(new NumberTwelveCard());
		}
		
	}
	
	
	/**
	 * constructor
	 * pre pass the deck
	 * post the cards have been initialized
	 * @param d deck
	 */
	public JLabel initCards(String path) {
		urlImage=cldr.getResource(path);
        image= new ImageIcon(urlImage).getImage();
        image = image.getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH);
        img= new JLabel(new ImageIcon(image)); 
        img.setOpaque(true);
        img.setSize(200,300);
        return img;
		
	}
	public ArrayList<JLabel> shuffle(){
		initializeCards(this.cards);
		return this.cards;
	}
	public ArrayList<Card> getSim(){
		ShuffleSim();
		return this.cardSimulation;
	}
	
}
