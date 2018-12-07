package br7;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;

/**
 * @author      Matthew Flautt <mf56@students.uwf.edu>
 * @version     1.0
 * @since       1.0
 */
public class ColumnSelection extends JFrame implements ActionListener {
	
	/**
	 * a default serial version ID to the selected type.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The title of the frame
	 */
	private static final String TITLE = "Select Column(s)";
	
	/**
	 * Checkbox that display's the serial number column in the results
	 */
	private static JCheckBox chckbxSerNum;
	
	/**
	 * Checkbox that display's the make column in the results
	 */
	private static JCheckBox chckbxMake;
	
	/**
	 * Checkbox that display's the model column in the results
	 */
	private static JCheckBox chckbxModel;
	
	/**
	 * Checkbox that display's the windows name column in the results
	 */
	private static JCheckBox chckbxWinName;
	
	/**
	 * Checkbox that display's the classification column in the results
	 */
	private static JCheckBox chckbxClass;
	
	/**
	 * Checkbox that display's the purchase date column in the results
	 */
	private static JCheckBox chckbxPurchase;
	
	/**
	 * Checkbox that display's the warranty end date column in the results
	 */
	private static JCheckBox chckbxWarranty;
	
	/**
	 * Checkbox that display's the building number column in the results
	 */
	private static JCheckBox chckbxBldg;
	
	/**
	 * Checkbox that display's the room number column in the results
	 */
	private static JCheckBox chckbxRm;
	
	/**
	 * Checkbox that display's the EDIPI column in the results
	 */
	private static JCheckBox chckbxEDIPI;
	
	/**
	 * Checkbox that display's the last name column in the results
	 */
	private static JCheckBox chckbxLast;
	
	/**
	 * Checkbox that display's the first name column in the results
	 */
	private static JCheckBox chckbxFirst;
	
	/**
	 * Checkbox that display's the paragraph number column in the results
	 */
	private static JCheckBox chckbxPara;
	
	/**
	 * Checkbox that display's the line number column in the results
	 */
	private static JCheckBox chckbxLn;
	
	/**
	 * Checkbox that display's the support column in the results
	 */
	private static JCheckBox chckbxSpt;
	
	/**
	 * Checkbox that display's the support description column in the results
	 */
	private static JCheckBox chckbxSptDec;
	
	/**
	 * Array that holds the names for different checkboxes
	 */
	private static final String[] COMBOOPT = new String[] {"Serial Number","Make","Model","Windows Name","Classification",
			"Purchase Date","Warranty Date","Building","Room","EDIPI","Last Name","First Name","PARA","LN","Support Level",
			"Support Description"};
	
	/**
	 * Button that selects all of the checkboxes
	 */
	private JButton btnSelectAll;
	
	/**
	 * Button that unselects all of the checkboxes
	 */
	private JButton btnUnselectAll;
	
	/**
	 * Constructor of this class
	 * 
	 * Box layout used. Visible items added to panel
	 */
	public ColumnSelection() {
		super(TITLE);
		setSize(new Dimension(165, 490));
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		chckbxSerNum = new JCheckBox(COMBOOPT[0]);
		chckbxSerNum.setSelected(true);
		getContentPane().add(chckbxSerNum);
		
		chckbxMake = new JCheckBox(COMBOOPT[1]);
		chckbxMake.setSelected(true);
		getContentPane().add(chckbxMake);
		
		chckbxModel = new JCheckBox(COMBOOPT[2]);
		chckbxModel.setSelected(true);
		getContentPane().add(chckbxModel);
		
		chckbxWinName = new JCheckBox(COMBOOPT[3]);
		chckbxWinName.setSelected(true);
		getContentPane().add(chckbxWinName);
		
		chckbxClass = new JCheckBox(COMBOOPT[4]);
		chckbxClass.setSelected(true);
		getContentPane().add(chckbxClass);
		
		chckbxPurchase = new JCheckBox(COMBOOPT[5]);
		chckbxPurchase.setSelected(true);
		getContentPane().add(chckbxPurchase);
		
		chckbxWarranty = new JCheckBox(COMBOOPT[6]);
		chckbxWarranty.setSelected(true);
		getContentPane().add(chckbxWarranty);
		
		chckbxBldg = new JCheckBox(COMBOOPT[7]);
		chckbxBldg.setSelected(true);
		getContentPane().add(chckbxBldg);
		
		chckbxRm = new JCheckBox(COMBOOPT[8]);
		chckbxRm.setSelected(true);
		getContentPane().add(chckbxRm);
		
		chckbxEDIPI = new JCheckBox(COMBOOPT[9]);
		chckbxEDIPI.setSelected(true);
		getContentPane().add(chckbxEDIPI);
		
		chckbxLast = new JCheckBox(COMBOOPT[10]);
		chckbxLast.setSelected(true);
		getContentPane().add(chckbxLast);
		
		chckbxFirst = new JCheckBox(COMBOOPT[11]);
		chckbxFirst.setSelected(true);
		getContentPane().add(chckbxFirst);
		
		chckbxPara = new JCheckBox(COMBOOPT[12]);
		chckbxPara.setSelected(true);
		getContentPane().add(chckbxPara);
		
		chckbxLn = new JCheckBox(COMBOOPT[13]);
		chckbxLn.setSelected(true);
		getContentPane().add(chckbxLn);
		
		chckbxSpt = new JCheckBox(COMBOOPT[14]);
		chckbxSpt.setSelected(true);
		getContentPane().add(chckbxSpt);
		
		chckbxSptDec = new JCheckBox(COMBOOPT[15]);
		chckbxSptDec.setSelected(true);
		getContentPane().add(chckbxSptDec);
		
		btnSelectAll = new JButton("Select All");
		btnSelectAll.addActionListener(this);
		getContentPane().add(btnSelectAll);
		
		btnUnselectAll = new JButton("Unselect All");
		btnUnselectAll.addActionListener(this);
		getContentPane().add(btnUnselectAll);

	}
	
	/**
	 * Get serial number checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getSerNumState() {
		      return chckbxSerNum.isSelected();
		   }
	/**
	 * Get make checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getMakeState() {
		      return chckbxMake.isSelected();
		   }
	
	/**
	 * Get model checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getModelState() {
		      return chckbxModel.isSelected();
		   }
	
	/**
	 * Get windows name checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getWinNameState() {
		      return chckbxWinName.isSelected();
		   }

	/**
	 * Get classification checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getClassState() {
		      return chckbxClass.isSelected();
		   }

	/**
	 * Get purchase date checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getPurchaseState() {
		      return chckbxPurchase.isSelected();
		   }

	/**
	 * Get warranty date checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getWarrantyState() {
		      return chckbxWarranty.isSelected();
		   }

	/**
	 * Get building number checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getBldgState() {
		      return chckbxBldg.isSelected();
		   }

	/**
	 * Get room number checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getRmState() {
		      return chckbxRm.isSelected();
		   }

	/**
	 * Get EDIPI checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getEDIPIState() {
		      return chckbxEDIPI.isSelected();
		   }

	/**
	 * Get last name checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getLastState() {
		      return chckbxLast.isSelected();
		   }

	/**
	 * Get first name checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getFirstState() {
		      return chckbxFirst.isSelected();
		   }

	/**
	 * Get paragraph number checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getParaState() {
		      return chckbxPara.isSelected();
		   }

	/**
	 * Get line number checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getLnState() {
		      return chckbxLn.isSelected();
		   }
	
	/**
	 * Get support checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getSptState() {
		      return chckbxSpt.isSelected();
		   }

	/**
	 * Get support description checkbox state
	 * 
	 * gets the checkbox state for external classes
	 *
	 * @return boolean value of checkbox state
	 */
	public static boolean getSptDecState() {
		      return chckbxSptDec.isSelected();
		   }

	/**
	 * Decides what to do when a user selects an action
	 * 
	 * Sets all of the checkboxes to selected or unselected
	 *
	 * @param user started action event
	 */
	public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSelectAll) {
				chckbxSerNum.setSelected(true);
				chckbxMake.setSelected(true);
				chckbxModel.setSelected(true);
				chckbxWinName.setSelected(true);
				chckbxClass.setSelected(true);
				chckbxPurchase.setSelected(true);
				chckbxWarranty.setSelected(true);
				chckbxBldg.setSelected(true);
				chckbxRm.setSelected(true);
				chckbxEDIPI.setSelected(true);
				chckbxLast.setSelected(true);
				chckbxFirst.setSelected(true);
				chckbxPara.setSelected(true);
				chckbxLn.setSelected(true);
				chckbxSpt.setSelected(true);
				chckbxSptDec.setSelected(true);
			}
			if (e.getSource() == btnUnselectAll){
				chckbxSerNum.setSelected(false);
				chckbxMake.setSelected(false);
				chckbxModel.setSelected(false);
				chckbxWinName.setSelected(false);
				chckbxClass.setSelected(false);
				chckbxPurchase.setSelected(false);
				chckbxWarranty.setSelected(false);
				chckbxBldg.setSelected(false);
				chckbxRm.setSelected(false);
				chckbxEDIPI.setSelected(false);
				chckbxLast.setSelected(false);
				chckbxFirst.setSelected(false);
				chckbxPara.setSelected(false);
				chckbxLn.setSelected(false);
				chckbxSpt.setSelected(false);
				chckbxSptDec.setSelected(false);
			}
		}
	   
}
