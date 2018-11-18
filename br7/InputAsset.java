package br7;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class InputAsset extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Input Asset Data";
	private JTextField txtSerialNumber, txtMake, txtModel, txtPurchaseDate, txtWarrantyEndDate, txtBuildingNumber, txtRoomNumber;
	private JLabel lblSerialNumber, lblMake, lblModel, lblPurchaseDate, lblWarrantyEndDate, lblBuildingNumber, lblRoomNumber;
	private TextPrompt datePrompt;
	private JButton btnInputAsset, btnCancel;
	private static final String DATEPRMPTTXT = "YYYY-MM-DD";
	
	
	public InputAsset() {
		super(TITLE);
		setSize(new Dimension(250, 500));
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(8, 2, 10, 40));
		
		lblSerialNumber = new JLabel("Serial Number");
		panel.add(lblSerialNumber);
		
		txtSerialNumber = new JTextField();
		panel.add(txtSerialNumber);
		
		lblMake = new JLabel("Make");
		panel.add(lblMake);
		
		txtMake = new JTextField();
		panel.add(txtMake);
		
		lblModel = new JLabel("Model");
		panel.add(lblModel);
		
		txtModel = new JTextField();
		panel.add(txtModel);
		
		lblPurchaseDate = new JLabel("Purchase Date");
		panel.add(lblPurchaseDate);
		
		txtPurchaseDate = new JTextField();
		txtPurchaseDate.setToolTipText("YYYY-MM-DD");
		panel.add(txtPurchaseDate);
		
		datePrompt = new TextPrompt(DATEPRMPTTXT, txtPurchaseDate, TextPrompt.Show.FOCUS_LOST);
		datePrompt.changeStyle(Font.ITALIC);
		
		lblWarrantyEndDate = new JLabel("Warranty End Date");
		panel.add(lblWarrantyEndDate);
		
		txtWarrantyEndDate = new JTextField();
		txtWarrantyEndDate.setToolTipText("YYYY-MM-DD");
		panel.add(txtWarrantyEndDate);
		
		datePrompt = new TextPrompt(DATEPRMPTTXT, txtWarrantyEndDate, TextPrompt.Show.FOCUS_LOST);
		datePrompt.changeStyle(Font.ITALIC);
		
		lblBuildingNumber = new JLabel("Building Number");
		panel.add(lblBuildingNumber);
		
		txtBuildingNumber = new JTextField();
		panel.add(txtBuildingNumber);
		
		lblRoomNumber = new JLabel("Room Number");
		panel.add(lblRoomNumber);
		
		txtRoomNumber = new JTextField();
		panel.add(txtRoomNumber);
		
		btnInputAsset = new JButton("Input Asset");
		panel.add(btnInputAsset);
		
		btnCancel = new JButton("Cancel");
		panel.add(btnCancel);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
