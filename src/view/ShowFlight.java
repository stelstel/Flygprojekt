package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class ShowFlight extends JFrame{

	boolean isRunning = true;
	int fps = 60;				//Bestämmer hur snabbt spelet ska uppdateras, antal ggr per sekund
	int windowWidth = 1280;
	int windowHeight = 720;

	int ballX = 20;
	int ballY = 180;
	BufferedImage backBuffer;
	Insets insets;

	String planeName;
	String flightInfo;
	int loopCount=0;
	int blinkCount=0;
	boolean blink = true;
	String[] chat = {"","","","","","","","","","","","","",""};
	
	public ShowFlight(String name){
		planeName = name;
	}
	
	
	public void runLoop(){
		initialize();
		
		while(isRunning){

			// Systemets tid vid början av loop
			long time = System.currentTimeMillis();
			
			update();
			draw();
			
			// Räkna ut hur lång tid det tog, hur lång tid det är kvar på framen
			time = (1000 / fps) - (System.currentTimeMillis() - time);
			// Vänta in systemet
			if(time > 0){
				try{
					Thread.sleep(time);
				}
				catch(Exception e){
					
				}
			}
		}
		setVisible(false);
		return;
	}

	void initialize(){
		
		setTitle(planeName);
		setSize(windowWidth, windowHeight);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		
		insets = getInsets();
		setSize(insets.left + windowWidth + insets.right, insets.top + windowHeight + insets.bottom);
		
		backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
		
	}

	void update(){
		
		if(loopCount > 600)
			ballX++;
				
		if(blinkCount < 20)
			blink = true;
		else if(blinkCount < 40)
			blink = false;
		else
			blinkCount = 0;
		blinkCount++;
		
		
		if(loopCount < 200){
			flightInfo = "Ready for take off";
		} 
		else if(loopCount < 400){
			if(blink == true)
				flightInfo = "Please fasten seatbelts";
			else
				flightInfo = "";
		}	
		else if(loopCount < 1200)
			flightInfo = "";
		else if(loopCount < 1400)
			flightInfo = "Prepare for landing, please";
		else if(loopCount < 2000){
			if(blink == true)
				flightInfo = "Please fasten seatbelts";
			else
				flightInfo = "";
		}	
		else if(loopCount < 2200)
			flightInfo = "Ladies and gentlemen, welcome to Java Airport";
		else {
			isRunning = false;
		}
			
		if(ballX > 600 && ballY < 700)
			ballY++;

		if(loopCount == 500)
			chat[0] = "-May I serve you some food sir";
		else if(loopCount == 600)	
			chat[1] = "-Yes please";
		else if(loopCount == 700)	
			chat[2] = "-Enjoy your meal sir";
		else if(loopCount == 800)	
			chat[3] = "-Yummy yummy!";
		else if(loopCount == 1300)	
			chat[4] = "-You have to fasten your seatbelt sir, we are about to land";
		else if(loopCount == 1400)	
			chat[5] = "-But I have to go to the toilet";
		else if(loopCount == 1500)	
			chat[6] = "-Sorry, but that is not possible right now";
		else if(loopCount == 1600)	
			chat[7] = "-But this is urgent!!!";
		else if(loopCount == 1700)	
			chat[8] = "-SIT!!!";
		else if(loopCount == 1800)	
			chat[9] = "-shit...";
		else if(loopCount == 2000)	
			chat[10] = "-Have a nice day sir";
		else if(loopCount == 2100)	
			chat[11] = "-Fuck off";
                
		
		loopCount++;
	}

	void draw(){
		
		Graphics g = getGraphics();

		// Ritar objekt i bakgrunden
		Graphics bbg = backBuffer.getGraphics();
		
		//Window
		bbg.setColor(Color.WHITE);
		bbg.setColor(Color.lightGray);
		bbg.setColor(new Color ( 100, 200, 255 ));
		bbg.fillRect(0, 0, windowWidth, windowHeight);
		
		// Info board
		bbg.setColor(Color.BLACK);	
		bbg.fillRect(50, 0, windowWidth-100, 160);		
		bbg.setColor(Color.WHITE);	
		Font font = new Font("Serif", Font.PLAIN, 64);
		bbg.setFont(font);
		bbg.drawString(flightInfo, 80, 80);
		
		// Ball / airplane
		if(ballX > 20){
			bbg.setColor(Color.BLACK);					// Byt till Grå
			bbg.fillOval(ballX, ballY, 20, 20);
		}

		// Chat
		bbg.setColor(Color.DARK_GRAY);	
		Font font2 = new Font("Serif", Font.PLAIN, 32);
		bbg.setFont(font2);
		bbg.drawString(chat[0], 80, 260);
		bbg.drawString(chat[1], 80, 300);
		bbg.drawString(chat[2], 80, 340);
		bbg.drawString(chat[3], 80, 380);
		bbg.drawString(chat[4], 80, 420);
		bbg.drawString(chat[5], 80, 460);
		bbg.drawString(chat[6], 80, 500);
		bbg.drawString(chat[7], 80, 540);
		bbg.drawString(chat[8], 80, 580);
		bbg.drawString(chat[9], 80, 620);
		bbg.drawString(chat[10], 80, 660);
		bbg.drawString(chat[11], 80, 700);
		
		g.drawImage(backBuffer, insets.left, insets.top, this);

	}

}
