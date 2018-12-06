package br7;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class AssignAsset extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Assign Asset";
	private JTextField txtAssetSerialNumber;
	private JTextField txtUserLn;
	private JTextField txtUserPara;
	private JTextField txtUserPos;
	private JButton btnAssignAsset;
	private JButton btnCancel;
	
	public AssignAsset() {
		super(TITLE);
		setSize(new Dimension(250, 300));
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		getContentPane().setLayout(new GridLayout(5, 2, 5, 30));
		
		JLabel lblAssetSerialNumber = new JLabel("Asset Serial Number");
		getContentPane().add(lblAssetSerialNumber);
		
		txtAssetSerialNumber = new JTextField();
		getContentPane().add(txtAssetSerialNumber);
		
		JLabel lblUserPara = new JLabel("User Para");
		getContentPane().add(lblUserPara);
		
		txtUserPara = new JTextField();
		getContentPane().add(txtUserPara);
		
		JLabel lblUserLn = new JLabel("User Ln");
		getContentPane().add(lblUserLn);
		
		txtUserLn = new JTextField();
		getContentPane().add(txtUserLn);
		
		JLabel lblUserPos = new JLabel("User Pos");
		getContentPane().add(lblUserPos);
		
		txtUserPos = new JTextField();
		getContentPane().add(txtUserPos);
		
		btnAssignAsset = new JButton("Assign Asset");
		getContentPane().add(btnAssignAsset);
		
		btnCancel = new JButton("Cancel");
		getContentPane().add(btnCancel);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel)	setVisible(false);
		
	}

}
