package br7;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;

public class columnSelection extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Select Column(s)";
	private static JCheckBox chckbxSerNum, chckbxMake, chckbxModel, chckbxWinName, chckbxClass, 
	chckbxPurchase, chckbxWarranty, chckbxBldg, chckbxRm, chckbxEDIPI, chckbxLast, chckbxFirst, 
	chckbxPara, chckbxLn, chckbxSpt, chckbxSptDec;
	private static final String[] COMBOOPT = new String[] {"Serial Number","Make","Model","Windows Name","Classification",
			"Purchase Date","Warranty Date","Building","Room","EDIPI","Last Name","First Name","PARA","LN","Support Level",
			"Support Description"};
	
	public columnSelection() {
		super(TITLE);
		setSize(new Dimension(165, 425));
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		chckbxSerNum = new JCheckBox(COMBOOPT[0]);
		getContentPane().add(chckbxSerNum);
		
		chckbxMake = new JCheckBox(COMBOOPT[1]);
		getContentPane().add(chckbxMake);
		
		chckbxModel = new JCheckBox(COMBOOPT[2]);
		getContentPane().add(chckbxModel);
		
		chckbxWinName = new JCheckBox(COMBOOPT[3]);
		getContentPane().add(chckbxWinName);
		
		chckbxClass = new JCheckBox(COMBOOPT[4]);
		getContentPane().add(chckbxClass);
		
		chckbxPurchase = new JCheckBox(COMBOOPT[5]);
		getContentPane().add(chckbxPurchase);
		
		chckbxWarranty = new JCheckBox(COMBOOPT[6]);
		getContentPane().add(chckbxWarranty);
		
		chckbxBldg = new JCheckBox(COMBOOPT[7]);
		getContentPane().add(chckbxBldg);
		
		chckbxRm = new JCheckBox(COMBOOPT[8]);
		getContentPane().add(chckbxRm);
		
		chckbxEDIPI = new JCheckBox(COMBOOPT[9]);
		getContentPane().add(chckbxEDIPI);
		
		chckbxLast = new JCheckBox(COMBOOPT[10]);
		getContentPane().add(chckbxLast);
		
		chckbxFirst = new JCheckBox(COMBOOPT[11]);
		getContentPane().add(chckbxFirst);
		
		chckbxPara = new JCheckBox(COMBOOPT[12]);
		getContentPane().add(chckbxPara);
		
		chckbxLn = new JCheckBox(COMBOOPT[13]);
		getContentPane().add(chckbxLn);
		
		chckbxSpt = new JCheckBox(COMBOOPT[14]);
		getContentPane().add(chckbxSpt);
		
		chckbxSptDec = new JCheckBox(COMBOOPT[15]);
		getContentPane().add(chckbxSptDec);
	}
	
	   public boolean getSerNumState() {
		      return chckbxSerNum.isSelected();
		   }
	   
	   public boolean getMakeState() {
		      return chckbxMake.isSelected();
		   }
	   
	   public boolean getModelState() {
		      return chckbxModel.isSelected();
		   }
	   
	   public boolean getWinNameState() {
		      return chckbxWinName.isSelected();
		   }
	   
	   public boolean getClassState() {
		      return chckbxClass.isSelected();
		   }
	   
	   public boolean getPurchaseState() {
		      return chckbxPurchase.isSelected();
		   }
	   
	   public boolean getWarrantyState() {
		      return chckbxWarranty.isSelected();
		   }
	   
	   public boolean getBldgState() {
		      return chckbxBldg.isSelected();
		   }
	   
	   public boolean getRmState() {
		      return chckbxRm.isSelected();
		   }
	   
	   public boolean getEDIPIState() {
		      return chckbxEDIPI.isSelected();
		   }
	   
	   public boolean getLastState() {
		      return chckbxLast.isSelected();
		   }
	   
	   public boolean getFirstState() {
		      return chckbxFirst.isSelected();
		   }
	   
	   public boolean getParaState() {
		      return chckbxPara.isSelected();
		   }
	   
	   public boolean getLnState() {
		      return chckbxLn.isSelected();
		   }
	   
	   public boolean getSptState() {
		      return chckbxSpt.isSelected();
		   }
	   
	   public boolean getSptDecState() {
		      return chckbxSptDec.isSelected();
		   }
	
/*	private void chckbxCreator() {
		for(int i = 0; i < COMBOOPT.length; i++) {
			
		}
	}*/
	
	

}
