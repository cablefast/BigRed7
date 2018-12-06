package br7;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class UpdateAsset extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Update Asset Data";
	private JTextField txtSerialNumber;
	private JTextField txtMake;
	private JTextField txtModel;
	private JTextField txtPurchaseDate;
	private JTextField txtWarrantyEndDate;
	private JTextField txtBuildingNumber;
	private JTextField txtRoomNumber;
	private JLabel lblSerialNumber;
	private JLabel lblMake;
	private JLabel lblModel;
	private JLabel lblPurchaseDate;
	private JLabel lblWarrantyEndDate;
	private JLabel lblBuildingNumber;
	private JLabel lblRoomNumber;
	private TextPrompt datePrompt;
	private JButton btnUpdateAsset, btnCancel;
	private static final String DATEPRMPTTXT = "YYYY-MM-DD";
	
	public UpdateAsset() {
		super(TITLE);
		setSize(new Dimension(250, 500));
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		getContentPane().setLayout(new GridLayout(8, 2, 5, 40));
		
		lblSerialNumber = new JLabel("Serial Number");
		getContentPane().add(lblSerialNumber);
		
		txtSerialNumber = new JTextField();
		getContentPane().add(txtSerialNumber);
		
		lblMake = new JLabel("Make");
		getContentPane().add(lblMake);
		
		txtMake = new JTextField();
		getContentPane().add(txtMake);
		
		lblModel = new JLabel("Model");
		getContentPane().add(lblModel);
		
		txtModel = new JTextField();
		getContentPane().add(txtModel);
		
		lblPurchaseDate = new JLabel("Purchase Date");
		getContentPane().add(lblPurchaseDate);
		
		txtPurchaseDate = new JTextField();
		getContentPane().add(txtPurchaseDate);
		txtPurchaseDate.setToolTipText("YYYY-MM-DD");
		
		datePrompt = new TextPrompt(DATEPRMPTTXT, txtPurchaseDate, TextPrompt.Show.FOCUS_LOST);
		datePrompt.changeStyle(Font.ITALIC);
		
		lblWarrantyEndDate = new JLabel("Warranty End Date");
		getContentPane().add(lblWarrantyEndDate);
		
		txtWarrantyEndDate = new JTextField();
		getContentPane().add(txtWarrantyEndDate);
		txtWarrantyEndDate.setToolTipText("YYYY-MM-DD");
				
		datePrompt = new TextPrompt(DATEPRMPTTXT, txtWarrantyEndDate, TextPrompt.Show.FOCUS_LOST);
		datePrompt.changeStyle(Font.ITALIC);
		
		lblBuildingNumber = new JLabel("Building Number");
		getContentPane().add(lblBuildingNumber);
		
		txtBuildingNumber = new JTextField();
		getContentPane().add(txtBuildingNumber);
		
		lblRoomNumber = new JLabel("Room Number");
		getContentPane().add(lblRoomNumber);
		
		txtRoomNumber = new JTextField();
		getContentPane().add(txtRoomNumber);
		
		btnUpdateAsset = new JButton("Update Asset");
		getContentPane().add(btnUpdateAsset);
		
		btnCancel = new JButton("Cancel");
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel)	setVisible(false);
	}

}
