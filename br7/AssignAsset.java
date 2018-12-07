package br7;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;

/**
 * @author      Matthew Flautt <mf56@students.uwf.edu>
 * @version     1.0
 * @since       1.0
 */
public class AssignAsset extends JFrame implements ActionListener {
	
	/**
	 * a default serial version ID to the selected type.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The title of the frame
	 */
	private static final String TITLE = "Assign Asset";
	
	/**
	 * Text field for user to enter a serial number.
	 */
	private JTextField txtAssetSerialNumber;
	
	/**
	 * Text field for user to enter a line number.
	 */
	private JTextField txtUserLn;
	
	/**
	 * Text field for user to enter a paragraph number.
	 */
	private JTextField txtUserPara;
	
	/**
	 * Text field for user to enter a position number.
	 */
	private JTextField txtUserPos;
	
	/**
	 * Button that starts the assign asset action.
	 */
	private JButton btnAssignAsset;
	
	/**
	 * Button that cancels the action and closes the form
	 */
	private JButton btnCancel;
	
	/**
	 * Constructor of this class
	 * 
	 * Grid layout used. Visible items added to panel
	 */
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
		btnCancel.addActionListener(this);
		
	}
	
	/**
	 * Decides what to do when a user selects an action
	 * 
	 * Different actions defined for btnCancel or btnAssignAsset
	 *
	 * @param user started action event
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel)	setVisible(false);
		
	}

}
