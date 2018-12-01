package br7;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class FrameUI extends JFrame{

	private static final String TITLE = "Big Red Seven";
	private SearchTab search = new SearchTab();
	private AdvancedSearchTab adv = new AdvancedSearchTab();
	private ChangeTab change = new ChangeTab();
	private ImageIcon icon;
	private JTabbedPane jtp;
	
	static final long serialVersionUID = 1L;
	
	public FrameUI() {
		super(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jtp = new JTabbedPane();
		jtp.setPreferredSize(new Dimension(800, 800));
        getContentPane().add(jtp);
        jtp.addTab("Search", search);
        jtp.addTab("Adv. Search", adv);
        jtp.addTab("Change", change); 
        icon = new ImageIcon(getClass().getResource("/16.png"));
        setIconImage(icon.getImage());        
        pack();
	}
}