package br7;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author      Matthew Flautt <mf56@students.uwf.edu>
 * @version     1.0
 * @since       1.0
 */
public class ChangeTab extends JPanel implements ActionListener {

	/**
	 * a default serial version ID to the selected type.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Button that sets the new asset frame to visible
	 */
	private JButton btnNewAsset;
	
	/**
	 * Button that sets the new user frame to visible
	 */
	private JButton btnNewUser;
	
	/**
	 * Button that sets the assign asset frame to visible
	 */
	private JButton btnAssignAsset;
	
	/**
	 * Button that sets the unassign asset frame to visible
	 */
	private JButton btnUnassignAsset;
	
	/**
	 * Button that sets the update asset frame to visible
	 */
	private JButton btnUpdateAsset;
	
	/**
	 * Button that sets the delete asset frame to visible
	 */
	private JButton btnDeleteAsset;
	
	/**
	 * Button that sets the update user frame to visible
	 */
	private JButton btnUpdateUser;
	
	/**
	 * Button that sets the delete user frame to visible
	 */
	private JButton btnDeleteUser;
	
	/**
	 * Input asset frame
	 */
	private InputAsset inputAsset;
	
	/**
	 * Input user frame
	 */
	private InputUser inputUser;
	
	/**
	 * Assign asset frame
	 */
	private AssignAsset assignAsset;
	
	/**
	 * Unassign asset frame
	 */
	private UnassignAsset unassignAsset;
	
	/**
	 * Update asset frame
	 */
	private UpdateAsset updateAsset;
	
	/**
	 * Delete asset frame
	 */
	private DeleteAsset deleteAsset;
	
	/**
	 * Update user frame
	 */
	private UpdateUser updateUser;
	
	/**
	 * Delete user frame
	 */
	private DeleteUser deleteUser;

	/**
	 * Constructor of this class
	 * 
	 * MIG layout used. Visible items added to panel
	 */
	public ChangeTab() {
		setLayout(new MigLayout("", "[grow][][grow]", "[grow][][grow][][grow][][grow]"));
		
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

	}
	
	/**
	 * Decides what to do when a user selects an action
	 * 
	 * Sets one of the eight frames visible when the corresponding button is pressed
	 *
	 * @param user started action event
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewAsset) inputAsset.setVisible(true);
		if (e.getSource() == btnNewUser) inputUser.setVisible(true);
		if (e.getSource() == btnAssignAsset) assignAsset.setVisible(true);
		if (e.getSource() == btnUnassignAsset) unassignAsset.setVisible(true);
		if (e.getSource() == btnUpdateAsset) updateAsset.setVisible(true);
		if (e.getSource() == btnDeleteAsset) deleteAsset.setVisible(true);
		if (e.getSource() == btnUpdateUser) updateUser.setVisible(true);
		if (e.getSource() == btnDeleteUser) deleteUser.setVisible(true);
	}

}
