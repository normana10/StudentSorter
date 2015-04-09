import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class GUIMain extends JFrame{
	
	   public static void main(String[] args) {
		   setupWindow();
		   
		   
		   
	   }
	   
	   public static void setupWindow(){
		   JFrame frame = new JFrame("Team Maker 2k15");
		   frame.setResizable(false);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setSize(700, 1000);
		   
		   JPanel panel = new JPanel();
		   panel.setLayout(new BorderLayout());
		   
		   JLabel title = new JLabel("Student Sorter 2k15", SwingConstants.CENTER);
		   title.setFont(new Font("Times New Roman", Font.BOLD, 70));
		   panel.add(title, BorderLayout.PAGE_START);
		   
		   JLabel b = new JLabel("L2", SwingConstants.CENTER);
		   panel.add(b, BorderLayout.LINE_START);
		   //TODO Get rid of these labels after ^ and down
		   JLabel d = new JLabel("L4", SwingConstants.CENTER);
		   panel.add(d, BorderLayout.LINE_END);
		   
		   JPanel centerColumn = new JPanel();
		   centerColumn.setLayout(new BoxLayout(centerColumn, BoxLayout.PAGE_AXIS));
		   
		   JPanel numberOfTeamsLayout = new JPanel(new FlowLayout());
		   JRadioButton numTeamsRadio = new JRadioButton("Number Of Teams:");
		   JTextField numTeamsTextField = new JTextField("", 10);
		   numberOfTeamsLayout.add(numTeamsRadio);
		   numberOfTeamsLayout.add(numTeamsTextField);
		   
		   JPanel studentsPerTeamLayout = new JPanel(new FlowLayout());
		   JRadioButton studPerTeamRadio = new JRadioButton("Students Per Team:");
		   JTextField studPerTeamTextField = new JTextField("", 10);
		   studentsPerTeamLayout.add(studPerTeamRadio);
		   studentsPerTeamLayout.add(studPerTeamTextField);
		   
		   ButtonGroup radioButtons = new ButtonGroup();
		   radioButtons.add(studPerTeamRadio);
		   radioButtons.add(numTeamsRadio);
		   //TODO Make a radio turn on if start typing in respective textbox
		   studPerTeamRadio.setSelected(true);
		   centerColumn.add(numberOfTeamsLayout);
		   centerColumn.add(studentsPerTeamLayout);
		   
		   JButton SORT = new JButton("SORT");
		   SORT.setFont(new Font("Arial", Font.BOLD, 120));
		   //SORT.setPreferredSize(new Dimension(400,80));
		   centerColumn.add(SORT);
		   
		   panel.add(centerColumn, BorderLayout.CENTER);
		   
		   JPanel bottomToolbar = new JPanel();
		   bottomToolbar.setLayout(new FlowLayout());
		   
		   JButton creditButton = new JButton("Credit");
		   bottomToolbar.add(creditButton);
		   creditButton.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e) {
				   JFrame credit = new JFrame("Credit");
				   credit.setResizable(false);
				   credit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				   credit.setSize(400, 400);
				   JPanel credits = new JPanel();
				   credits.setLayout(new BoxLayout(credits, BoxLayout.Y_AXIS));
				   
				   JLabel topCredit = new JLabel("Student Sorter 2k15");
				   JLabel author = new JLabel("By: Arthur Normand");
				   JLabel started = new JLabel("Started: April 9, 2k15");
				   JLabel updated = new JLabel("Last Updated: April 9, 2k15");
				   JLabel source = new JLabel("Source:");
				   JLabel sourceHTML = new JLabel("");
			   }
		   });
		   
		   JButton fileBroswerButton = new JButton("Browse...");
		   bottomToolbar.add(fileBroswerButton);
		   
		   JButton exitButton = new JButton("Exit");
		   bottomToolbar.add(exitButton);
		   exitButton.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e) {
				   System.exit(0);
			   }
		   });
		   
		   panel.add(bottomToolbar, BorderLayout.PAGE_END);
		   
		   frame.add(panel);
		   frame.setVisible(true);
	   }
}
