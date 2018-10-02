package Interface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FrameUI extends JFrame{

	private static String title = "Big Red Seven";
	
	private SearchTab search = new SearchTab();
	
	static final long serialVersionUID = 1L;
	
	public FrameUI() {
		super(title);
		JTabbedPane jtp = new JTabbedPane();
        getContentPane().add(jtp);
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();
        jtp.addTab("Search", search);
        jtp.addTab("Adv. Search", jp2);
        jtp.addTab("Change", jp3);
        jtp.addTab("Admin", jp4);
        pack();
	}
}