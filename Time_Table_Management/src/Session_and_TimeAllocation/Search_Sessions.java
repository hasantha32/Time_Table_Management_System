package Session_and_TimeAllocation;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;



import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;


import DBC.DBConnection;
import Leactures_and_Subjects.Add_Lecturer;
import Leactures_and_Subjects.Add_Subjects;
import Leactures_and_Subjects.Manage_Lecturer;
import Leactures_and_Subjects.Manage_Subjects;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JMenuBar;

public class Search_Sessions {
	private JFrame frame;
	private JFrame SrchSesFrm;
	
	private JTable table;
	private JComboBox lecbox;
	private JComboBox subjBox;
	private JComboBox groupBox;
	private JTextField textField;
	
	
	public void refreshtable() {

		try {

			Connection con = DBConnection.connect();

			String query="select sessionID As SID, lec1 As Lecturer1,lec2 As Lecturer2,subCode As SubCode,subName As SubName,tag As Tag,studentGroup As GroupID,NoOfStudents As Students,duration As Duration,sessionSignature As SessionSignature from session ";
			
			
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(1);
			columnModel.getColumn(1).setPreferredWidth(80);
			columnModel.getColumn(2).setPreferredWidth(80);
			columnModel.getColumn(3).setPreferredWidth(20);
			columnModel.getColumn(4).setPreferredWidth(40);
			columnModel.getColumn(5).setPreferredWidth(30);
			columnModel.getColumn(6).setPreferredWidth(50);
			columnModel.getColumn(7).setPreferredWidth(1);
			columnModel.getColumn(8).setPreferredWidth(1);
			columnModel.getColumn(9).setPreferredWidth(300);



		}
		catch(Exception e) {
			e.printStackTrace();
		}


	}
	//load data to dropdown lec
	 public  void  loadLecturer1(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from Lecturers ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("LecturerName");
					lecbox.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	
}

	
	//load data to dropdown subject name
	  public  void  loadSubjectName(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from SUbjects ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("SubjectName");
					subjBox.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}	  
	//load data to dropdown group id
	  public  void  loadGroup(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from Student_Groups ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("G_ID");
					groupBox.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	//load data to dropdown Subgroup id
	  public  void  loadSubGroup(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from Student_Groups ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("G_ID");
					groupBox.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Sessions window = new Search_Sessions();
					window.SrchSesFrm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Search_Sessions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SrchSesFrm = new JFrame();
	
		
		SrchSesFrm.setSize(1400, 860);
		SrchSesFrm.setBounds(0, 0, 1350, 700);
		SrchSesFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SrchSesFrm.getContentPane().setBackground(SystemColor.activeCaption);
		SrchSesFrm.setBackground(Color.YELLOW);
		SrchSesFrm.setTitle("Time Table Management System");
		SrchSesFrm.setLocationRelativeTo(null);
	
		SrchSesFrm.setVisible(true);
		//ManageSesFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SrchSesFrm.getContentPane().setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(229, 144, 1065, 527);
		SrchSesFrm.getContentPane().add(panel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(10, 201, 1045, 277);
		panel_3.add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		

		table = new JTable();
		table.setBackground(SystemColor.window);
		table.setForeground(SystemColor.textText);
		table.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		
		//table header
				JTableHeader h = table.getTableHeader();
				h.setBackground(new Color(	153, 153, 153));
				h.setForeground(Color.WHITE);
				h.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
				h.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				

		table.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));


		
		table.setModel(new DefaultTableModel( new Object[][] { }, new String[] { }
				));
		
		//display details in a table				
		scrollPane_1.setViewportView(table);

				try {
					Connection con = DBConnection.connect();

					//String query="select * from session ";
					String query="select sessionID As SID, lec1 As Lecturer1,lec2 As Lecturer2,subCode As SubCode,subName As SubName,tag As Tag,studentGroup As GroupID,NoOfStudents As Students,duration As Duration,sessionSignature As SessionSignature from session ";
					
			
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					TableColumnModel columnModel = table.getColumnModel();
					columnModel.getColumn(0).setPreferredWidth(1);
					columnModel.getColumn(1).setPreferredWidth(80);
					columnModel.getColumn(2).setPreferredWidth(80);
					columnModel.getColumn(3).setPreferredWidth(20);
					columnModel.getColumn(4).setPreferredWidth(40);
					columnModel.getColumn(5).setPreferredWidth(30);
					columnModel.getColumn(6).setPreferredWidth(50);
					columnModel.getColumn(7).setPreferredWidth(1);
					columnModel.getColumn(8).setPreferredWidth(1);
					columnModel.getColumn(9).setPreferredWidth(300);


				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				//Search bar for lecturer
			
				 lecbox = new JComboBox();
				 lecbox.setBackground(Color.WHITE);
				 lecbox.setForeground(Color.DARK_GRAY);
				 lecbox.setFont(UIManager.getFont("Spinner.font"));
				lecbox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							
							String l2 = lecbox.getSelectedItem().toString();
							 Connection con = DBConnection.connect();
							// String selection=(String)searchcomboBox.getSelectedItem();
							 String query="select sessionID As SID, lec1 As Lecturer1,lec2 As Lecturer2,subCode As SubCode,subName As SubName,tag As Tag,studentGroup As GroupID,NoOfStudents As Students,duration As Duration,sessionSignature As SessionSignature from session  where lec1=? or lec2= '"+l2+"'";
							 PreparedStatement pst= con.prepareStatement(query);
							 pst.setString(1,(String)lecbox.getSelectedItem());
							 ResultSet rs=pst.executeQuery();

							 table.setModel(DbUtils.resultSetToTableModel(rs));
							 pst.close();
							 
						 }catch(Exception ep) {
							 ep.printStackTrace();
						 }
						
						
						
					}
				});
				lecbox.setModel(new DefaultComboBoxModel(new String[] {"                      Select Lecturer"}));
				lecbox.setBounds(50, 109, 223, 27);
				panel_3.add(lecbox);
				
				
			
				//Search bar for subName
				subjBox = new JComboBox();
				subjBox.setBackground(Color.WHITE);
				subjBox.setForeground(Color.DARK_GRAY);
				subjBox.setFont(UIManager.getFont("Spinner.font"));
				subjBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							 Connection con = DBConnection.connect();
							// String selection=(String)searchcomboBox.getSelectedItem();
							 String query="select sessionID As SID, lec1 As Lecturer1,lec2 As Lecturer2,subCode As SubCode,subName As SubName,tag As Tag,studentGroup As GroupID,NoOfStudents As Students,duration As Duration,sessionSignature As SessionSignature from session  where subName=?";
							 PreparedStatement pst= con.prepareStatement(query);
							 pst.setString(1,(String)subjBox.getSelectedItem());
							 ResultSet rs=pst.executeQuery();

							 table.setModel(DbUtils.resultSetToTableModel(rs));
							 pst.close();
							 
						 }catch(Exception ep) {
							 ep.printStackTrace();
						 }
						
						
						
					}
				});
				
				
				//Search bar for Groupid
				 groupBox = new JComboBox();
				 groupBox.setBackground(Color.WHITE);
				 groupBox.setForeground(Color.DARK_GRAY);
				 groupBox.setFont(UIManager.getFont("Spinner.font"));
				 groupBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
								 Connection con = DBConnection.connect();
								// String selection=(String)searchcomboBox.getSelectedItem();
								 String query="select sessionID As SID, lec1 As Lecturer1,lec2 As Lecturer2,subCode As SubCode,subName As SubName,tag As Tag,studentGroup As GroupID,NoOfStudents As Students,duration As Duration,sessionSignature As SessionSignature from session  where studentGroup=?";
								 PreparedStatement pst= con.prepareStatement(query);
								 pst.setString(1,(String)groupBox.getSelectedItem());
								 ResultSet rs=pst.executeQuery();

								 table.setModel(DbUtils.resultSetToTableModel(rs));
								 pst.close();
								 
							 }catch(Exception ep) {
								 ep.printStackTrace();
							 }
							
							
							
						}
					});
				 
				 
		
		JLabel label_1 = new JLabel("Search by Lecturer :");
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(78, 61, 180, 37);
		panel_3.add(label_1);

		JLabel label_2 = new JLabel("Search by Group/Sub Group :");
		label_2.setForeground(Color.WHITE);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(444, 61, 215, 37);
		panel_3.add(label_2);

		JLabel label_3 = new JLabel("Search by Subject :");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(850, 61, 215, 37);
		panel_3.add(label_3);

		

		
		groupBox.setModel(new DefaultComboBoxModel(new String[] {"                       Select Group"}));
		groupBox.setBounds(438, 109, 223, 27);
		panel_3.add(groupBox);

		 
		subjBox.setModel(new DefaultComboBoxModel(new String[] {"                      Select Subject"}));
		subjBox.setBounds(812, 109, 223, 27);
		panel_3.add(subjBox);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(10, 11, 1045, 474);
		panel_3.add(panel_4);
		
		//clear button
		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.setToolTipText("Click button to clear search bar");
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lecbox.setSelectedIndex(0);;
				groupBox.setSelectedIndex(0);
				subjBox.setSelectedIndex(0);
				refreshtable();
				
				
			}
		});
		btnNewButton.setBounds(477, 489, 140, 27);
		panel_3.add(btnNewButton);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setForeground(Color.RED);
		panel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(3, 96, 1334, 38);
		SrchSesFrm.getContentPane().add(panel_5);
		
		JLabel lblSearchSessions = new JLabel("SEARCH SESSIONS");
		lblSearchSessions.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchSessions.setForeground(Color.RED);
		lblSearchSessions.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblSearchSessions.setBounds(507, 0, 278, 31);
		panel_5.add(lblSearchSessions);
		
		textField = new JTextField();
		textField.setText("                                                                       Time Table Management System");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.GRAY);
		textField.setBounds(3, 32, 1334, 65);
		SrchSesFrm.getContentPane().add(textField);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(6, 8, 1331, 27);
		SrchSesFrm.getContentPane().add(menuBar);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GRAY);
		panel_1_1.setBounds(0, 133, 174, 157);
		SrchSesFrm.getContentPane().add(panel_1_1);
		
		JButton btnAddLecturer = new JButton("ADD LECTURER");
		
		btnAddLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Lecturer addlecturer=new Add_Lecturer();
				Add_Lecturer.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		btnAddLecturer.setForeground(Color.WHITE);
		btnAddLecturer.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAddLecturer.setBackground(Color.BLACK);
		btnAddLecturer.setBounds(0, 289, 174, 35);
		SrchSesFrm.getContentPane().add(btnAddLecturer);
		
		JButton btnManageLecturer = new JButton("MANAGE LECTURERS");
		
		btnManageLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Lecturer managelecture=new Manage_Lecturer();
				Manage_Lecturer.main(null);
				frame.setVisible(false);
				
			}
			
		});
		btnManageLecturer.setForeground(Color.WHITE);
		btnManageLecturer.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageLecturer.setBackground(Color.BLACK);
		btnManageLecturer.setBounds(0, 323, 174, 29);
		SrchSesFrm.getContentPane().add(btnManageLecturer);
		
		JButton btnAddSession = new JButton("ADD SUBJECT");
		
		btnAddSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Subjects addsubjects=new Add_Subjects();
				Add_Subjects.main(null);
				frame.setVisible(false);
				
			}
			
		});

		btnAddSession.setForeground(Color.WHITE);
		btnAddSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAddSession.setBackground(Color.BLACK);
		btnAddSession.setBounds(0, 349, 174, 35);
		SrchSesFrm.getContentPane().add(btnAddSession);
		
		JButton btnUpdateSession = new JButton("MANAGE SUBJECTS");

		btnUpdateSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Subjects managesubjects=new Manage_Subjects();
				Manage_Subjects.main(null);
				frame.setVisible(false);
				
			}
			
		});

		
		btnUpdateSession.setForeground(Color.WHITE);
		btnUpdateSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnUpdateSession.setBackground(Color.BLACK);
		btnUpdateSession.setBounds(0, 383, 174, 29);
		SrchSesFrm.getContentPane().add(btnUpdateSession);
		
		JButton btnManageLsession = new JButton("ADD SESSION");
		btnManageLsession.setForeground(Color.WHITE);
		btnManageLsession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageLsession.setBackground(Color.BLACK);
		btnManageLsession.setBounds(0, 410, 174, 35);
		SrchSesFrm.getContentPane().add(btnManageLsession);
		
		JButton btnManageSession = new JButton("MANAGE SESSION");
		btnManageSession.setForeground(Color.WHITE);
		btnManageSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageSession.setBackground(Color.BLACK);
		btnManageSession.setBounds(0, 443, 174, 35);
		SrchSesFrm.getContentPane().add(btnManageSession);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 513, 174, 106);
		SrchSesFrm.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 615, 174, 48);
		SrchSesFrm.getContentPane().add(panel_2);
		
		JButton btnDelete = new JButton("<<Back");
		btnDelete.setForeground(new Color(240, 248, 255));
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnDelete.setBackground(Color.BLACK);
		panel_2.add(btnDelete);
		
		JButton btnManageSession_1 = new JButton("SEARCH SESSION");
		btnManageSession_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageSession_1.setForeground(Color.RED);
		btnManageSession_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageSession_1.setBackground(Color.BLACK);
		btnManageSession_1.setBounds(0, 477, 174, 35);
		SrchSesFrm.getContentPane().add(btnManageSession_1);
		
		
		        //load data to dropdown lec1
				loadLecturer1();
		
				//load data to dropdown subject name
				loadSubjectName();
				//load data to dropdown group id
				loadGroup();//load data to dropdown Subgroup id
				loadSubGroup();
				
	}

}
