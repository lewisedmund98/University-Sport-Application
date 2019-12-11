package textBasedUI;

import java.io.IOException;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal; 

/**
 * The Main class handles all of the text-based UI's capabilities. It makes 
 * use of the Lanterna Java library to construct an empty terminal and define 
 * text graphics to be used. Using the putString method it draws text onto the 
 * terminal and then flushes the terminal output onto the screen. When certain 
 * keys are pressed different text will be displayed.
 * @author Lewis Edmund
 *
 */

public class Main {
	
	public static void main(String[] args) {
		
		//terminal construction
		DefaultTerminalFactory dtf = new DefaultTerminalFactory();
		Terminal terminal = null;
		
		try {
			
			//terminal set up
			terminal = dtf.createTerminal();
			terminal.enterPrivateMode();
			terminal.clearScreen();
			terminal.setCursorVisible(false);
			
			//text and colour set up
			final TextGraphics textGraphics = terminal.newTextGraphics();
			textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
			textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
			
			//draw home page
			textGraphics.putString(2, 1, "Welcome to RHUL Sport!", SGR.BOLD);
			textGraphics.putString(5, 3, "Press ESC to exit");
			textGraphics.putString(5, 4, "Press UP for Clubs");
			textGraphics.putString(5, 5, "Press RIGHT for Fixtures and Results");
			textGraphics.putString(5, 6, "Press DOWN for Venues");
			textGraphics.putString(5, 7, "Press LEFT for Memberships");
			terminal.flush();
			
			//navigation
			boolean keepRunning = true;
			while(keepRunning) {
				KeyStroke ks = terminal.readInput();
				if (ks != null) {
					switch (ks.getKeyType()) {
						case Escape:
							keepRunning = false;
							break;
						case Home: 
							terminal.clearScreen();
							textGraphics.putString(2, 1, "Welcome to RHUL Sport!", SGR.BOLD);
							textGraphics.putString(5, 3, "Press ESC to exit");
							textGraphics.putString(5, 4, "Press UP for Clubs");
							textGraphics.putString(5, 5, "Press RIGHT for Fixtures and Results");
							textGraphics.putString(5, 6, "Press DOWN for Venues");
							textGraphics.putString(5, 7, "Press LEFT for Memberships");
							terminal.flush();
							break;
						case ArrowUp:
							terminal.clearScreen();
							textGraphics.putString(2, 1, "RHUL Clubs Page", SGR.BOLD);
							textGraphics.putString(5, 4, "Press HOME to return");
							textGraphics.putString(5, 5, "Press RIGHT for Fixtures and Results");
							textGraphics.putString(5, 6, "Press DOWN for Venues");
							textGraphics.putString(5, 7, "Press LEFT for Memberships");
							textGraphics.putString(5, 12, "Press TAB for Hockey");
							textGraphics.putString(5, 13, "Press BACKSPACE for Men's Football");
							textGraphics.putString(5, 14, "Press DELETE for Netball");
							textGraphics.putString(5, 15, "Press ENTER for Tennis");
							textGraphics.putString(5, 16, "Press INSERT for Women's Rugby");
							terminal.flush();
							break;
						case Tab:
							terminal.clearScreen();
							textGraphics.putString(2, 1, "RHUL Hockey Page", SGR.BOLD);
							textGraphics.putString(5, 4, "Press UP to return");
							textGraphics.putString(5, 7, "Welcome the the home of Hockey at Royal Holloway!");
							terminal.flush();
							break;
						case ArrowRight:
							terminal.clearScreen();
							textGraphics.putString(2, 1, "RHUL Fixtures and Results Page", SGR.BOLD);
							textGraphics.putString(5, 4, "Press Home to return");
							textGraphics.putString(5, 5, "Press UP for Clubs");
							textGraphics.putString(5, 6, "Press DOWN for Venues");
							textGraphics.putString(5, 7, "Press LEFT for Memberships");
							terminal.flush();
							break;
						case ArrowDown:
							terminal.clearScreen();
							textGraphics.putString(2, 1, "RHUL Venues Page", SGR.BOLD);
							textGraphics.putString(5, 4, "Press Home to return");
							textGraphics.putString(5, 5, "Press UP for Clubs");
							textGraphics.putString(5, 6, "Press RIGHT for Fixtures and Results");
							textGraphics.putString(5, 7, "Press LEFT for Memberships");
							terminal.flush();
							break;
						case ArrowLeft:
							terminal.clearScreen();
							textGraphics.putString(2, 1, "RHUL Membership Page", SGR.BOLD);
							textGraphics.putString(5, 4, "Press Home to return");
							textGraphics.putString(5, 5, "Press UP for Clubs");
							textGraphics.putString(5, 6, "Press RIGHT for Fixtures and Results");
							textGraphics.putString(5, 7, "Press DOWN for Venues");
							terminal.flush();
							break;
						default:
							System.out.println("Default Branch");
							break;
					}
				}
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(terminal != null) {
				try {
					terminal.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}

