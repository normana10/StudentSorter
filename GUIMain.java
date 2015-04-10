import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class GUIMain extends JFrame{
	
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException {
		   setupWindow();
		   
		   
	   }
	   
	   public static void setupWindow() throws IOException{
		   final JFrame frame = new JFrame("Team Maker 2k15");
		   frame.setResizable(false);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setSize(700, 600);
		   
		   JPanel panel = new JPanel();
		   panel.setLayout(new BorderLayout());
		   
		   JLabel title = new JLabel("Student Sorter 2k15", SwingConstants.LEFT);
		   title.setFont(new Font("Times New Roman", Font.BOLD, 65));
		   title.setBorder(new EmptyBorder(0,60,0,0));
		   //panel.add(title, BorderLayout.PAGE_START);
		   
		   
		   JPanel centerColumn = new JPanel();
		   centerColumn.setLayout(new BoxLayout(centerColumn, BoxLayout.PAGE_AXIS));
		   
		   int textFieldDist = 0;
		   
		   JPanel numberOfTeamsLayout = new JPanel(new FlowLayout());
		   final JRadioButton numTeamsRadio = new JRadioButton("Number Of Teams:");
		   final JTextField numTeamsTextField = new JTextField("", 10);
		   numberOfTeamsLayout.add(numTeamsRadio);
		   numberOfTeamsLayout.add(numTeamsTextField);
		   numberOfTeamsLayout.setBorder(new EmptyBorder(textFieldDist,0,0,0));
		   
		   JPanel studentsPerTeamLayout = new JPanel(new FlowLayout());
		   final JRadioButton studPerTeamRadio = new JRadioButton("Students Per Team:");
		   final JTextField studPerTeamTextField = new JTextField("5", 10);
		   studentsPerTeamLayout.add(studPerTeamRadio);
		   studentsPerTeamLayout.add(studPerTeamTextField);
		   studentsPerTeamLayout.setBorder(new EmptyBorder(0,0,textFieldDist,0));
		   
		   ButtonGroup radioButtons = new ButtonGroup();
		   radioButtons.add(studPerTeamRadio);
		   radioButtons.add(numTeamsRadio);
		   studPerTeamRadio.setSelected(true);
		   
		   JPanel bunnyLayout = new JPanel();
		   bunnyLayout.setLayout(new FlowLayout());
		   BufferedImage bunnyFile = ImageIO.read(new File("asciibunny.gif"));
		   JLabel bunnyPic = new JLabel(new ImageIcon(bunnyFile));
		   bunnyPic.setAlignmentX(Component.CENTER_ALIGNMENT);
		   bunnyLayout.add(bunnyPic);
		   
		   centerColumn.add(bunnyLayout);
		   centerColumn.add(numberOfTeamsLayout);
		   centerColumn.add(studentsPerTeamLayout);
		   
		   
		   numTeamsTextField.getDocument().addDocumentListener(new DocumentListener(){
			   public void insertUpdate(DocumentEvent e) {
				   numTeamsRadio.setSelected(true);
			   }
			   public void removeUpdate(DocumentEvent e) {
			   }
			   public void changedUpdate(DocumentEvent e) {
			   }
		   });
		   
		   studPerTeamTextField.getDocument().addDocumentListener(new DocumentListener(){
			   public void insertUpdate(DocumentEvent e) {
				   studPerTeamRadio.setSelected(true);
			   }
			   public void removeUpdate(DocumentEvent e) {
			   }
			   public void changedUpdate(DocumentEvent e) {
			   }
		   });
		   
		   
		   
		   JPanel bottomToolbar = new JPanel();
		   bottomToolbar.setLayout(new FlowLayout());
		   
		   int strutDist = 100;
		   
		   bottomToolbar.add(Box.createHorizontalStrut(10));
		   JButton creditButton = new JButton("Credit");
		   bottomToolbar.add(creditButton);
		   
		   bottomToolbar.add(Box.createHorizontalStrut(strutDist));
		   creditButton.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e) {
				   
				   JFrame credit = new JFrame("Credit");
				   credit.setResizable(false);
				   credit.setSize(400, 250);
				   JPanel credits = new JPanel();
				   credits.setLayout(new BoxLayout(credits, BoxLayout.Y_AXIS));
				   
				   JLabel topCredit = new JLabel("Student Sorter 2k15");
				   JLabel author = new JLabel("By: Arthur Normand");
				   JLabel started = new JLabel("Started: April 9, 2k15");
				   JLabel updated = new JLabel("Last Updated: April 10, 2k15");
				   JLabel source = new JLabel("Source:");
				   JButton sourceSite = new JButton("GitHub");
				   
				   topCredit.setAlignmentX(Component.CENTER_ALIGNMENT);
				   author.setAlignmentX(Component.CENTER_ALIGNMENT);
				   started.setAlignmentX(Component.CENTER_ALIGNMENT);
				   updated.setAlignmentX(Component.CENTER_ALIGNMENT);
				   source.setAlignmentX(Component.CENTER_ALIGNMENT);
				   sourceSite.setAlignmentX(Component.CENTER_ALIGNMENT);
				   
				   topCredit.setFont(new Font("Arial", Font.BOLD, 30));
				   author.setFont(new Font("Arial", Font.BOLD, 30));
				   started.setFont(new Font("Arial", Font.BOLD, 30));
				   updated.setFont(new Font("Arial", Font.BOLD, 30));
				   source.setFont(new Font("Arial", Font.BOLD, 30));
				   
				   credits.add(topCredit);
				   credits.add(author);
				   credits.add(started);
				   credits.add(updated);
				   credits.add(source);
				   credits.add(sourceSite);
				   
				   credit.add(credits);
				   credit.setVisible(true);
				   
				   sourceSite.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							URI uri = null;
							try {
								uri = new URI("https://github.com/normana10/StudentSorter/blob/master/GUIMain.java");
							} catch (URISyntaxException e2) {
							}
							Desktop dt = Desktop.getDesktop();
							try {
								dt.browse(uri.resolve(uri));
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
				   });
				   
			   }
		   });
		   
		   JButton fileBrowserButton = new JButton("Browse...");
		   bottomToolbar.add(fileBrowserButton);
		   bottomToolbar.add(Box.createHorizontalStrut(strutDist));
		   fileBrowserButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					FileDialog fd = new FileDialog(frame, "Choose a file", FileDialog.LOAD);
					fd.setDirectory("C:\\");
					fd.setFile("*.xml");
					fd.setVisible(true);
					
					File writtenTo = new File("CurrentStatsRoster.txt");
					
					if(!writtenTo.exists()){
						try {
							writtenTo.createNewFile();
						} catch (IOException e1) {
						}
					}
					
					FileWriter fWrite;
					BufferedWriter buffWriter = null;
					try {
						fWrite = new FileWriter(writtenTo.getAbsoluteFile());
						buffWriter = new BufferedWriter(fWrite);
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					
					BufferedReader reader = null;
					try {
						File file = fd.getFiles()[0];
					    reader = new BufferedReader(new FileReader(file));
					    reader.readLine();

					    String line;
					    while ((line = reader.readLine()) != null) {
					        buffWriter.write(line);
					        buffWriter.newLine();
					    }

					} catch (IOException e1) {
					    e1.printStackTrace();
					} finally {
					    try {
					        reader.close();
					    } catch (IOException e1) {
					        e1.printStackTrace();
					    }
					}
					try {
						buffWriter.close();
					} catch (IOException e1) {
					}
					
					frame.removeAll();
					frame.dispose();
					try {
						setupWindow();
					} catch (IOException e1) {
					}
					
				}
		   });
		   
		   
		   JButton exitButton = new JButton("Exit");
		   bottomToolbar.add(exitButton);
		   exitButton.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e) {
				   System.exit(0);
			   }
		   });
		   
		   panel.add(bottomToolbar, BorderLayout.PAGE_END);
		   
		   JPanel attendance = new JPanel();
		   attendance.setLayout(new BoxLayout(attendance, BoxLayout.Y_AXIS));
		   final JFrame attendanceWindow = new JFrame("Attendance");
		   
		   
		   JButton atten = new JButton("Attendance");
		   atten.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e) {
				   if(attendanceWindow.isVisible()){
					   attendanceWindow.setVisible(false);
				   } else {
					   attendanceWindow.pack();
					   attendanceWindow.setVisible(true);
				   }
			   }
		   });
		   panel.add(atten, BorderLayout.LINE_END);
		   
		   
		   JLabel checkboxNames = new JLabel("Attendance:", SwingConstants.CENTER);
		   checkboxNames.setHorizontalAlignment(JLabel.CENTER);
		   checkboxNames.setBorder(new EmptyBorder(10,2,2,8));
		   attendance.add(checkboxNames);
		   
		   BufferedReader passiveReader = null;
		   
		   File file = null;
		   try {
			   file = new File("CurrentStatsRoster.txt");
			   passiveReader = new BufferedReader(new FileReader(file));
			   passiveReader.readLine();
		   } catch (IOException e1) {
				e1.printStackTrace();
		   } finally {
		   }
		   
		   int numberOfLines = 1;
		   
		   while(passiveReader.readLine() != null){
			   numberOfLines++;
		   }
		   
		   final int numberOfStuds = numberOfLines;
		   
		   attendanceWindow.setSize(175, numberOfStuds * 23);
		   
		   attendanceWindow.setLocation(701, 0);
		   
		   passiveReader.close();
		   
		   BufferedReader meFile = new BufferedReader(new FileReader ("CurrentStatsRoster.txt"));
		   String currentLine = meFile.readLine();
			
		   int firstQMark = 0;
		   int secondQMark = 0;
		   int spaceBeforeName = 0;
		   String[] studNames = new String[10000];
		   //TODO 10k Stud Limit Again..... Algorithmic? Pls
		   String currentName = "";
		   
		   int count = 0;
		   while(currentLine != null){
			   
			   firstQMark = currentLine.indexOf("\"");
			   secondQMark = currentLine.indexOf("\"", 1);
			   spaceBeforeName = currentLine.indexOf(",") + 1;
			   
			   try{
			   currentName = currentLine.substring(spaceBeforeName, secondQMark) + " "
					   + currentLine.substring(firstQMark + 1, firstQMark + 2);
			   } catch(StringIndexOutOfBoundsException e1){
				   
			   }
			   
			   
			   studNames[count] = currentName;
			   currentLine = meFile.readLine();
			   count++;
		   }
		   
		   meFile.close();
		   
		   final JCheckBox[] checkBoxes = new JCheckBox[10000];
		   //TODO Current Limit of # of students, Fix algorithmically later? 10,000 Studs
		   
		   for(int i = 0; i < numberOfLines; i++){
			   checkBoxes[i] = new JCheckBox(studNames[i]);
			   checkBoxes[i].setSelected(true);
			   checkBoxes[i].setBorder(new EmptyBorder(0,0,0,50));
		   }
		   
		   for(int i = 0; i < numberOfLines; i++){
			   attendance.add(checkBoxes[i]);
		   }
		   
		   //frame.add(attendance, BorderLayout.EAST);
		   attendance.setBorder(new EmptyBorder(0,10,10,10));
		   attendanceWindow.add(attendance);
		   
		   JButton SORT = new JButton("SORT");
		   SORT.setFont(new Font("Arial", Font.BOLD, 120));
		   SORT.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e) {
				   
				   final JFrame teamWindow = new JFrame("Teams");
				   
				   sortAndCreateTeamWindow(teamWindow, numberOfStuds, checkBoxes,
						   numTeamsRadio, numTeamsTextField,
						   studPerTeamRadio, studPerTeamTextField);
				   
				   /*
				   for(int i = 0; i < 5; i++){
					   
					   sortAndCreateTeamWindow(teamWindow, numberOfStuds, checkBoxes,
							   numTeamsRadio, numTeamsTextField,
							   studPerTeamRadio, studPerTeamTextField);
					   teamWindow.repaint();
					   try {
							Thread.sleep(200 * i);
						   } catch (InterruptedException e1) {
						   }
				   }
				   */
				   
				   /*
				    * 
				    * 
				    * 
				    * 
				    * 
				    * 
				    * 
				    * 
				    * 
				    * 
				    * 
				    * 
				    * 
				    * 
				    */
				   
				   
			   }
		   });
		   
		   
		   centerColumn.add(SORT);
		   
		   panel.add(centerColumn, BorderLayout.CENTER);
		   
		   /*
		   BufferedImage myPicture = ImageIO.read(new File("bunny.jpg"));
		   JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		   frame.add(picLabel, BorderLayout.LINE_START);
		   */
		   
		   BufferedImage myPicture = ImageIO.read(new File("image.gif"));
		   JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		   frame.add(picLabel, BorderLayout.NORTH);
		   
		   frame.add(panel);
		   
		   frame.addComponentListener(new ComponentListener(){
			   public void componentResized(ComponentEvent e) {
			   }
			   public void componentMoved(ComponentEvent e) {
				   attendanceWindow.setLocation(frame.getX() + 700, frame.getY());
			   }
			   public void componentShown(ComponentEvent e) {
			   }
			   public void componentHidden(ComponentEvent e) {
			   }
		   });
		   
		   frame.setVisible(true);
	   }
	   
	   public static void sortAndCreateTeamWindow(final JFrame teamWindow, final int numberOfStuds, final JCheckBox[] checkBoxes,
			   final JRadioButton numTeamsRadio, final JTextField numTeamsTextField,
			   final JRadioButton studPerTeamRadio, final JTextField studPerTeamTextField){
		   
		   teamWindow.setResizable(true);
		   
		   JPanel teams = new JPanel();
		   
		   ArrayList<String> studNames = new ArrayList<String>();
		   
		   int counting = 0;
		   for(int i = 0; i < numberOfStuds; i++){
			   if(checkBoxes[i].isSelected() == true){
				   studNames.add(checkBoxes[i].getText());
				   counting++;
			   }
		   }
		   
		   ArrayList<JLabel> studs = new ArrayList<JLabel>();
		   
		   int numberOfStudsPresent = counting;
		   
		   for(int i = 0; i < numberOfStudsPresent; i++){
			   studs.add(new JLabel(studNames.get(i)));
		   }
		   
		   Collections.shuffle(studs);
		   
		   int numberOfTeams = 0;
		   int studsPerTeam = 0;
		   
		   if(numTeamsRadio.isSelected()){
			   try {
			   numberOfTeams = Integer.parseInt(numTeamsTextField.getText());
			   } catch (NumberFormatException e1){
				   System.exit(1);
			   }
			   studsPerTeam = numberOfStudsPresent/numberOfTeams;
			   
		   } else if(studPerTeamRadio.isSelected()){
			   try {
				   studsPerTeam = Integer.parseInt(studPerTeamTextField.getText());
				   } catch (NumberFormatException e1){
					   System.exit(1);
				   }
			   numberOfTeams = numberOfStudsPresent/studsPerTeam;
		   }
		   
		   
		   BufferedReader animalReader = null;
		   try{
			   File file = new File("AnimalNames.txt");
			   animalReader = new BufferedReader(new FileReader(file));
		   } catch (IOException e1){
			   
		   }
		   String animalOn = null;
		try {
			animalOn = animalReader.readLine();
		} catch (IOException e2) {
		}
		   int numOfAnimals = 0;
		   ArrayList<String> infiniteAnimals = new ArrayList<String>();
		   
		   while(animalOn != null){
			   infiniteAnimals.add(animalOn);
			   
			   try {
				animalOn = animalReader.readLine();
			} catch (IOException e1) {
			}
			   numOfAnimals++;
		   }
		   
		   JLabel[] animals = new JLabel[numOfAnimals];
		   
		   Collections.shuffle(infiniteAnimals);
		   
		   for(int i = 0; i < animals.length; i++){
			   animals[i] = new JLabel("(" + (i + 1) + ")Team " + infiniteAnimals.get(i));
		   }
		   
		   final JLabel[][] teamsArray = new JLabel[numberOfTeams][studsPerTeam + 2];
		   
		   
		   for (int h = 0; h < numberOfTeams; h++){
			   animals[h].setAlignmentX(Component.CENTER_ALIGNMENT);
			   animals[h].setFont(new Font("Arial", Font.BOLD, 30));
			   teamsArray[h][0] = animals[h];
		   }
		   
		   for(int i = studs.size() - 1; i >= 0; i--){
			   if(studs.get(i).getText() == null){
				   studs.remove(i);
			   }
		   }
		   
		   for (int h = 1; h < studsPerTeam + 1; h++){
			   for(int c = 0; c < numberOfTeams; c++){
				   studs.get(0).setAlignmentX(Component.CENTER_ALIGNMENT);
				   studs.get(0).setFont(new Font("Arial", Font.PLAIN, 20));
				   teamsArray[c][h] = studs.get(0);
				   studs.remove(0);
			   }
		   }
		   
		   for(int i = 0; i < numberOfTeams; i++){
			   if(!studs.isEmpty()){
				   studs.get(0).setAlignmentX(Component.CENTER_ALIGNMENT);
				   studs.get(0).setFont(new Font("Arial", Font.PLAIN, 20));
				   teamsArray[i][studsPerTeam + 1] = studs.get(0);
				   studs.remove(0);
			   }
		   }
		   
		   JPanel[] tempTeam = new JPanel[numberOfTeams];
		   
		   for(int i = 0; i < numberOfTeams; i++){
			   tempTeam[i] = new JPanel();
		   }
		   
		   for(int i = 0; i < numberOfTeams; i++){
			   tempTeam[i].setLayout(new BoxLayout(tempTeam[i], BoxLayout.Y_AXIS));
			   for(int c = 0; c < teamsArray[i].length; c++){
				   if(teamsArray[i][c] != null){
				   tempTeam[i].add(teamsArray[i][c]);
				   }
			   }
		   }
		   
		   for(int i = 0; i < numberOfTeams; i++){
			   teams.add(tempTeam[i]);
		   }
		   
		   int boxes = (int) Math.sqrt(numberOfTeams);
		   teams.setLayout(new GridLayout(boxes,boxes));
		   teams.setBorder(new EmptyBorder(15,15,15,15));
		   
		   teamWindow.setLayout(new BorderLayout());
		   teamWindow.add(teams, BorderLayout.CENTER);
		   
		   JPanel teamToolbar = new JPanel();
		   JButton teamExit = new JButton("Exit");
		   teamExit.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e) {
				   System.exit(0);
			   }
		   });
		   JButton teamBack = new JButton("Back");
		   teamBack.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e) {
				   teamWindow.dispose();
			   }
		   });
		   JButton REDO = new JButton("Redo?");
		   
		   teamToolbar.add(teamBack);
		   teamToolbar.add(REDO);
		   teamToolbar.add(teamExit);
		   
		   teamWindow.add(teamToolbar, BorderLayout.SOUTH);
		   
		   teamWindow.pack();
		   //teamWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		   REDO.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e) {
				   teamWindow.getContentPane().removeAll();
				   teamWindow.dispose();
				   sortAndCreateTeamWindow(teamWindow, numberOfStuds, checkBoxes,
						   numTeamsRadio, numTeamsTextField,
						   studPerTeamRadio, studPerTeamTextField);
			   }
		   });
		   
		   teamWindow.setVisible(true);
		   
	   }
}
