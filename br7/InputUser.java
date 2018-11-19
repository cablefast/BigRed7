package br7;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class InputUser extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Input User Data";
	private JTextField txtEdipi;
	private JTextField txtFirstName;
	private JLabel lblLastName;
	private JTextField txtLastName;
	private JLabel lblPara;
	private JTextField txtPara;
	private JLabel lblLn;
	private JTextField txtLn;
	private JLabel lblPos;
	private JTextField txtPos;
	private JButton btnInputUser;
	private JButton btnCancel;
	
	public InputUser() {
		super(TITLE);
		setSize(new Dimension(250, 400));
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		getContentPane().setLayout(new GridLayout(7, 2, 5, 30));
		
		JLabel lblEdipi = new JLabel("EDIPI");
		getContentPane().add(lblEdipi);
		
		txtEdipi = new JTextField();
		getContentPane().add(txtEdipi);
		txtEdipi.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		getContentPane().add(lblFirstName);
		
		txtFirstName = new JTextField();
		getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		lblLastName = new JLabel("Last Name");
		getContentPane().add(lblLastName);
		
		txtLastName = new JTextField();
		getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		lblPara = new JLabel("Para");
		getContentPane().add(lblPara);
		
		txtPara = new JTextField();
		getContentPane().add(txtPara);
		txtPara.setColumns(10);
		
		lblLn = new JLabel("Ln");
		getContentPane().add(lblLn);
		
		txtLn = new JTextField();
		getContentPane().add(txtLn);
		txtLn.setColumns(10);
		
		lblPos = new JLabel("Pos");
		getContentPane().add(lblPos);
		
		txtPos = new JTextField();
		getContentPane().add(txtPos);
		txtPos.setColumns(10);
		
		btnInputUser = new JButton("Input User");
		getContentPane().add(btnInputUser);
		
		btnCancel = new JButton("Cancel");
		getContentPane().add(btnCancel);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
