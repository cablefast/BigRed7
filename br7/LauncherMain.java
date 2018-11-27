package br7;
import java.io.File;


import javax.swing.JFrame;

public class LauncherMain {

	public static void main(String[] args) {
		FrameUI frame = new FrameUI();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    createFile();
	}
	
	private static void createFile() {
		File file = new File ("servdat.br7");
		if (file.exists()) return;
		ServerInfo serverInfo = new ServerInfo();
		serverInfo.setVisible(true);
	}
	
}