package br7;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class ChangeTab extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private InputAsset asset;

	public ChangeTab() {
		setLayout(new MigLayout("", "[grow][][grow][][]", "[grow][][grow][][grow][][grow]"));
		
		JButton btnNewAsset = new JButton("New Asset");
		add(btnNewAsset, "cell 0 0,growx,aligny center");
		btnNewAsset.addActionListener(this);
		
		JButton btnNewUser = new JButton("New User");
		add(btnNewUser, "cell 2 0,growx,aligny center");
		
		JCheckBox chckbxUploadCsv = new JCheckBox("Upload CSV");
		add(chckbxUploadCsv, "cell 4 0");
		
		JButton btnAssignAsset = new JButton("Assign Asset");
		add(btnAssignAsset, "cell 0 2,growx,aligny center");
		
		JButton btnUnassignAsset = new JButton("Unassign Asset");
		add(btnUnassignAsset, "cell 2 2,growx,aligny center");
		
		JButton btnUpdateAsset = new JButton("Update Asset");
		add(btnUpdateAsset, "cell 0 4,growx,aligny center");
		
		JButton btnDeleteAsset = new JButton("Delete Asset");
		add(btnDeleteAsset, "cell 2 4,growx,aligny center");
		
		JButton btnUpdateUser = new JButton("Update User");
		add(btnUpdateUser, "cell 0 6,growx,aligny center");
		
		JButton btnDeleteUser = new JButton("Delete User");
		add(btnDeleteUser, "cell 2 6,growx,aligny center");
		
		asset = new InputAsset();
		asset.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		asset.setVisible(true);
	}

}
