package br7;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class AdminTab extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroupUserTypes = new ButtonGroup();
	
	public AdminTab() {

		
		setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow][][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, "cell 0 0 4 1,grow");
		
		JTextArea textAreaUserDisplay = new JTextArea();
		textAreaUserDisplay.setEditable(false);
		scrollPane.setViewportView(textAreaUserDisplay);
		
		JToggleButton tglbtnAllUsers = new JToggleButton("All Users");
		tglbtnAllUsers.setSelected(true);
		buttonGroupUserTypes.add(tglbtnAllUsers);
		add(tglbtnAllUsers, "cell 0 1,grow");
		
		JToggleButton tglbtnsearchUsers = new JToggleButton("\"Search\" Users");
		buttonGroupUserTypes.add(tglbtnsearchUsers);
		add(tglbtnsearchUsers, "cell 1 1,grow");
		
		JToggleButton tglbtnadvUsers = new JToggleButton("\"Adv\" Users");
		buttonGroupUserTypes.add(tglbtnadvUsers);
		add(tglbtnadvUsers, "cell 2 1,grow");
		
		JToggleButton tglbtnadminUsers = new JToggleButton("\"Admin\" Users");
		buttonGroupUserTypes.add(tglbtnadminUsers);
		add(tglbtnadminUsers, "cell 3 1,grow");
		
		JButton btnCreateUser = new JButton("Create User");
		add(btnCreateUser, "cell 0 2,grow");
		
		JButton btnChangeUserPassword = new JButton("Password Reset");
		add(btnChangeUserPassword, "cell 1 2 2 1,alignx center,growy");
		
		JButton btnDeleteUser = new JButton("Delete User");
		add(btnDeleteUser, "cell 3 2,grow");
	}



}