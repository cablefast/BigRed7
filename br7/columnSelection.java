package br7;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class columnSelection extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Select Column(s)";
	private static JCheckBox chckbxSerNum, chckbxMake, chckbxModel, chckbxWinName, chckbxClass, 
	chckbxPurchase, chckbxWarranty, chckbxBldg, chckbxRm, chckbxEDIPI, chckbxLast, chckbxFirst, 
	chckbxPara, chckbxLn, chckbxSpt, chckbxSptDec;
	private static final String[] COMBOOPT = new String[] {"Serial Number","Make","Model","Windows Name","Classification",
			"Purchase Date","Warranty Date","Building","Room","EDIPI","Last Name","First Name","PARA","LN","Support Level",
			"Support Description"};
	private JButton btnSelectAll, btnUnselectAll;
	
	public columnSelection() {
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
	
	   public static boolean getSerNumState() {
		      return chckbxSerNum.isSelected();
		   }
	   
	   public static boolean getMakeState() {
		      return chckbxMake.isSelected();
		   }
	   
	   public static boolean getModelState() {
		      return chckbxModel.isSelected();
		   }
	   
	   public static boolean getWinNameState() {
		      return chckbxWinName.isSelected();
		   }
	   
	   public static boolean getClassState() {
		      return chckbxClass.isSelected();
		   }
	   
	   public static boolean getPurchaseState() {
		      return chckbxPurchase.isSelected();
		   }
	   
	   public static boolean getWarrantyState() {
		      return chckbxWarranty.isSelected();
		   }
	   
	   public static boolean getBldgState() {
		      return chckbxBldg.isSelected();
		   }
	   
	   public static boolean getRmState() {
		      return chckbxRm.isSelected();
		   }
	   
	   public static boolean getEDIPIState() {
		      return chckbxEDIPI.isSelected();
		   }
	   
	   public static boolean getLastState() {
		      return chckbxLast.isSelected();
		   }
	   
	   public static boolean getFirstState() {
		      return chckbxFirst.isSelected();
		   }
	   
	   public static boolean getParaState() {
		      return chckbxPara.isSelected();
		   }
	   
	   public static boolean getLnState() {
		      return chckbxLn.isSelected();
		   }
	   
	   public static boolean getSptState() {
		      return chckbxSpt.isSelected();
		   }
	   
	   public static boolean getSptDecState() {
		      return chckbxSptDec.isSelected();
		   }
	   
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
