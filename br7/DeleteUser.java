package br7;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class DeleteUser extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Delete User";
	private JTextField txtEdipi;
	private JLabel lblEdipi;
	private JButton btnDeleteUser, btnCancel;
	
	public DeleteUser() {
		super(TITLE);
		setSize(new Dimension(250, 140));
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		getContentPane().setLayout(new GridLayout(2, 2, 5, 25));
		
		lblEdipi = new JLabel("EDIPI");
		getContentPane().add(lblEdipi);
		
		txtEdipi = new JTextField();
		getContentPane().add(txtEdipi);
		
		btnDeleteUser = new JButton("Delete User");
		getContentPane().add(btnDeleteUser);
		
		btnCancel = new JButton("Cancel");
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel)	setVisible(false);
	}

}
