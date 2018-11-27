package br7;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class ChangeTab extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JButton btnNewAsset;
	private JButton btnNewUser;
	private JButton btnAssignAsset;
	private JButton btnUnassignAsset;
	private JButton btnUpdateAsset;
	private JButton btnDeleteAsset;
	private JButton btnUpdateUser;
	private JButton btnDeleteUser;

	private JButton btnUpdateServerInfo;
	private InputAsset inputAsset;
	private InputUser inputUser;
	private AssignAsset assignAsset;
	private UnassignAsset unassignAsset;
	private UpdateAsset updateAsset;
	private DeleteAsset deleteAsset;
	private UpdateUser updateUser;
	private DeleteUser deleteUser;
	private ServerInfo serverInfo;

	public ChangeTab() {
		setLayout(new MigLayout("", "[grow][][grow]", "[grow][][grow][][grow][][grow][][grow]"));
		
		btnNewAsset = new JButton("New Asset");
		add(btnNewAsset, "cell 0 0,growx,aligny center");
		btnNewAsset.addActionListener(this);
		
		btnNewUser = new JButton("New User");
		add(btnNewUser, "cell 2 0,growx,aligny center");
		btnNewUser.addActionListener(this);
		
		btnAssignAsset = new JButton("Assign Asset");
		add(btnAssignAsset, "cell 0 2,growx,aligny center");
		btnAssignAsset.addActionListener(this);
		
		btnUnassignAsset = new JButton("Unassign Asset");
		add(btnUnassignAsset, "cell 2 2,growx,aligny center");
		btnUnassignAsset.addActionListener(this);
		
		btnUpdateAsset = new JButton("Update Asset");
		add(btnUpdateAsset, "cell 0 4,growx,aligny center");
		btnUpdateAsset.addActionListener(this);
		
		btnDeleteAsset = new JButton("Delete Asset");
		add(btnDeleteAsset, "cell 2 4,growx,aligny center");
		btnDeleteAsset.addActionListener(this);
		
		btnUpdateUser = new JButton("Update User");
		add(btnUpdateUser, "cell 0 6,growx,aligny center");
		btnUpdateUser.addActionListener(this);
		
		btnDeleteUser = new JButton("Delete User");
		add(btnDeleteUser, "cell 2 6,growx,aligny center");
		btnDeleteUser.addActionListener(this);
		
		btnUpdateServerInfo = new JButton("Update Server Info");
		add(btnUpdateServerInfo, "cell 0 8,growx,aligny center");
		btnUpdateServerInfo.addActionListener(this);
		
		inputAsset = new InputAsset();
		inputAsset.setVisible(false);
		
		inputUser = new InputUser();
		inputUser.setVisible(false);
		
		assignAsset = new AssignAsset();
		assignAsset.setVisible(false);
		
		unassignAsset = new UnassignAsset();
		unassignAsset.setVisible(false);
		
		updateAsset = new UpdateAsset();
		updateAsset.setVisible(false);
		
		deleteAsset = new DeleteAsset();
		deleteAsset.setVisible(false);
		
		updateUser = new UpdateUser();
		updateUser.setVisible(false);
		
		deleteUser = new DeleteUser();
		deleteUser.setVisible(false);
		
		serverInfo = new ServerInfo();
		serverInfo.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewAsset) inputAsset.setVisible(true);
		if (e.getSource() == btnNewUser) inputUser.setVisible(true);
		if (e.getSource() == btnAssignAsset) assignAsset.setVisible(true);
		if (e.getSource() == btnUnassignAsset) unassignAsset.setVisible(true);
		if (e.getSource() == btnUpdateAsset) updateAsset.setVisible(true);
		if (e.getSource() == btnDeleteAsset) deleteAsset.setVisible(true);
		if (e.getSource() == btnUpdateUser) updateUser.setVisible(true);
		if (e.getSource() == btnDeleteUser) deleteUser.setVisible(true);
		if (e.getSource() == btnUpdateServerInfo) serverInfo.setVisible(true);
	}

}
