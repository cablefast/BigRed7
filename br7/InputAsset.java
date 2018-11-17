package br7;

import java.awt.Dimension;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Component;

public class InputAsset extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Input Asset Data";
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
	
	
	public InputAsset() {
		super(TITLE);
		setSize(new Dimension(250, 500));
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(7, 2, 0, 40));
		
		lblSerialNumber = new JLabel("Serial Number");
		panel.add(lblSerialNumber);
		
		txtSerialNumber = new JTextField();
		panel.add(txtSerialNumber);
		txtSerialNumber.setText("Serial Number");
		
		lblMake = new JLabel("Make");
		panel.add(lblMake);
		
		txtMake = new JTextField();
		panel.add(txtMake);
		txtMake.setText("Make");
		
		lblModel = new JLabel("Model");
		panel.add(lblModel);
		
		txtModel = new JTextField();
		panel.add(txtModel);
		txtModel.setText("Model");
		
		lblPurchaseDate = new JLabel("Purchase Date");
		panel.add(lblPurchaseDate);
		
		txtPurchaseDate = new JTextField();
		panel.add(txtPurchaseDate);
		txtPurchaseDate.setText("Purchase Date");
		
		lblWarrantyEndDate = new JLabel("Warranty End Date");
		panel.add(lblWarrantyEndDate);
		
		txtWarrantyEndDate = new JTextField();
		panel.add(txtWarrantyEndDate);
		txtWarrantyEndDate.setText("Warranty End Date");
		
		lblBuildingNumber = new JLabel("Building Number");
		panel.add(lblBuildingNumber);
		
		txtBuildingNumber = new JTextField();
		panel.add(txtBuildingNumber);
		txtBuildingNumber.setText("Building Number");
		
		lblRoomNumber = new JLabel("Room Number");
		panel.add(lblRoomNumber);
		
		txtRoomNumber = new JTextField();
		panel.add(txtRoomNumber);
		txtRoomNumber.setText("Room Number");
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
