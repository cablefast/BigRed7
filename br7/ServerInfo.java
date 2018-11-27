package br7;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class ServerInfo extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Server Info";
	private JTextField txtUrl;
	private JTextField txtPassword;
	private JTextField txtUserName;
	private JButton btnSubmit;
	private JLabel lblUrl;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private TextPrompt txtUrlPrompt;
	private static final String TXTURLPROMPTTEXT = "XXX.XXX.XXX.XXX:XXXX\\server";
	
	public ServerInfo() {
		super(TITLE);
		setSize(new Dimension(400, 250));
		setAlwaysOnTop(true);
		setType(Type.UTILITY);		
		getContentPane().setLayout(new GridLayout(4, 2, 5, 25));
		
		lblUrl = new JLabel("Server Path");
		getContentPane().add(lblUrl);
		
		txtUrl = new JTextField();
		getContentPane().add(txtUrl);
		
		txtUrlPrompt = new TextPrompt(TXTURLPROMPTTEXT, txtUrl, TextPrompt.Show.FOCUS_LOST);
		txtUrlPrompt.changeStyle(Font.ITALIC);
		
		lblUserName = new JLabel("Server Login");
		getContentPane().add(lblUserName);
		
		txtUserName = new JTextField();
		getContentPane().add(txtUserName);
		
		lblPassword = new JLabel("Server Password");
		getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		getContentPane().add(txtPassword);
		
		btnSubmit = new JButton("Submit");
		getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent e) {
		FileWriter fw;		
		try {
			fw = new FileWriter("servdat.br7");
			fw.write(txtUrl.getText());
			fw.write(System.lineSeparator());
			fw.write(txtUserName.getText());
			fw.write(System.lineSeparator());
			fw.write(txtPassword.getText());
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setVisible(false);
	}

}
