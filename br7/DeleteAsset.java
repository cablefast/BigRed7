package br7;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class DeleteAsset extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Delete Asset";
	private JTextField txtSerialNumber;
	private JLabel lblSerialNumber;
	private JButton btnDeleteAsset, btnCancel;
	
	public DeleteAsset() {
		super(TITLE);
		setSize(new Dimension(250, 140));
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		getContentPane().setLayout(new GridLayout(2, 2, 5, 25));
		
		lblSerialNumber = new JLabel("Serial Number");
		getContentPane().add(lblSerialNumber);
		
		txtSerialNumber = new JTextField();
		getContentPane().add(txtSerialNumber);
		
		btnDeleteAsset = new JButton("Delete Asset");
		getContentPane().add(btnDeleteAsset);
		
		btnCancel = new JButton("Cancel");
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel)	setVisible(false);		
	}

}
