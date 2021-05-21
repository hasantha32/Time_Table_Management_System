

package Session_and_TimeAllocation;

import java.awt.EventQueue;



import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import java.awt.List;
import java.awt.ScrollPane;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import DBC.DBConnection;
import Home.StartUp;
import Leactures_and_Subjects.Add_Lecturer;
import Leactures_and_Subjects.Add_Subjects;
import Leactures_and_Subjects.Manage_Lecturer;
import Leactures_and_Subjects.Manage_Subjects;
import Location_and_Statistics.Add_Locations;

import Location_and_Statistics.Manage_Locations;
import Location_and_Statistics.Visualizing_static;
import Students_and_Tags.Add_Student_Groups;
import Students_and_Tags.Add_Tag;
import Students_and_Tags.Manage_Student_Groups;
import Students_and_Tags.Manage_Tags;
import Timetable.Lecturer;
import Timetable.Location;
import Timetable.Student;
import Working_Days_and_Hours.Add_Workingdays_Hours;
import Working_Days_and_Hours.Manage_Workingdays_Hours;
import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import java.awt.Panel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SessionsANDnotAvailableTimeAllocationConsecutive {

	
	
	private JFrame frame;
	private JFrame frmAddStudentGroup;
	private JTable table;
	private JComboBox comboBox_s1;
	private JComboBox comboBox_s2;
	private JComboBox comboBox_s3;
	private JTextField gensession;
	private JTextField textField;
	
	
	//fill  session 1
	  public void fillsesions1() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from session";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("sessionSignature");
					 comboBox_s1.addItem(name);
					 //comboBox_4_1.addItem(rs.getString("SubGroupID"));
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	     
	
	  //fill session 2 
	  public void fillsesions2() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from session";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("sessionSignature");
					 comboBox_s2.addItem(name);
					 //comboBox_4_1.addItem(rs.getString("SubGroupID"));
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	  
	  
	 //fill session 3
	  public void fillsesions3() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from session";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("sessionSignature");
					 comboBox_s3.addItem(name);
					 //comboBox_4_1.addItem(rs.getString("SubGroupID"));
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	  
	  

	  
	  //refresh method
	  public void refreshTable() {
			
			try {
				Connection con = DBConnection.connect();
				
				String query="select conSessionID AS SID,conSession AS ConsecutiveSession from consecutiveSession ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				TableColumnModel columnModel = table.getColumnModel();
				columnModel.getColumn(0).setPreferredWidth(6);
				columnModel.getColumn(1).setPreferredWidth(900);
				
				
				
				
				
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
					SessionsANDnotAvailableTimeAllocationConsecutive window = new SessionsANDnotAvailableTimeAllocationConsecutive();
					window.frmAddStudentGroup.setVisible(true);
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
     
     
	
	/**
	 * Create the application.
	 */
	public SessionsANDnotAvailableTimeAllocationConsecutive() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddStudentGroup = new JFrame();
		frmAddStudentGroup.getContentPane().setBackground(SystemColor.activeCaption);
		frmAddStudentGroup.setBackground(Color.YELLOW);
		frmAddStudentGroup.setResizable(false);
		frmAddStudentGroup.setTitle(" Time Table Management System ");
		frmAddStudentGroup.setSize(1350, 728);
		frmAddStudentGroup.setBounds(0, 0, 1350, 700);
		frmAddStudentGroup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddStudentGroup.getContentPane().setLayout(null);
		//frmAddStudentGroup.setExtendedState(frmAddStudentGroup.getExtendedState() | JFrame.MAXIMIZED_BOTH);

		
		frmAddStudentGroup.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		//frmAddStudentGroup.setVisible(true);
		
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(SystemColor.activeCaption);
		panel_6.setBounds(268, 152, 1081, 501);
		frmAddStudentGroup.getContentPane().add(panel_6);
		
		
		
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.DARK_GRAY);
		panel_7.setLayout(null);
		panel_7.setBounds(10, 10, 1030, 476);
		panel_6.add(panel_7);
		
		
		
		
		//session 1
		JLabel lblNewLabel_4_1 = new JLabel("Session 1");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(24, 24, 80, 21);
		panel_7.add(lblNewLabel_4_1);
		
		comboBox_s1 = new JComboBox();
		comboBox_s1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox_s1.setModel(new DefaultComboBoxModel(new String[] {"-"}));
		comboBox_s1.setBounds(189, 13, 764, 32);
		panel_7.add(comboBox_s1);
		
		fillsesions1();

	
		
		//session 2
		JLabel lblNewLabel_4 = new JLabel("Session 2");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(24, 87, 80, 21);
		panel_7.add(lblNewLabel_4);
		
		

	    comboBox_s2 = new JComboBox();
	    comboBox_s2.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    comboBox_s2.setModel(new DefaultComboBoxModel(new String[] {"-"}));
		comboBox_s2.setBounds(189, 76, 764, 32);
		panel_7.add(comboBox_s2);
		
		
		fillsesions2();
		
		
		//session 3
		JLabel lblNewLabel_5 = new JLabel("Session 3");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(24, 150, 96, 16);
		panel_7.add(lblNewLabel_5);
		
		comboBox_s3 = new JComboBox();
		comboBox_s3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox_s3.setModel(new DefaultComboBoxModel(new String[] {"-"}));
		comboBox_s3.setBounds(189, 142, 764, 32);
		panel_7.add(comboBox_s3);
		
		
		fillsesions3();
		
		
		
		
		gensession = new JTextField();
		gensession.setBackground(UIManager.getColor("Button.light"));
		gensession.setEnabled(false);
		gensession.setBounds(24, 300, 890, 3);
		panel_7.add(gensession);
		gensession.setColumns(10);
		
		
		//add consecutive sessions
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				gensession.setText(comboBox_s1.getSelectedItem().toString()+"+"+comboBox_s2.getSelectedItem().toString()+"+"+comboBox_s3.getSelectedItem().toString());
				
				String session1=comboBox_s1.getSelectedItem().toString();
				String session2=comboBox_s2.getSelectedItem().toString();
				String session3=comboBox_s3.getSelectedItem().toString();
				String session = gensession.getText();
				
			
				
				 try {
					 
					 Connection con = DBConnection.connect();
					 
					  

	                    String query = "INSERT INTO consecutiveSession values(null, '" + session1 + "', '" + session2+ "', '" + session3 + "', '" + session + "')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                    	JOptionPane.showMessageDialog(null, "       This is alredy exist","Alert",JOptionPane.WARNING_MESSAGE);
		                      
	                    } else {
	                    	
	                    	
	                    	JLabel label = new JLabel("Consective Sessions added Sucessfully");
	    					label.setHorizontalAlignment(SwingConstants.CENTER);
	    					JOptionPane.showMessageDialog(null, label);
	    					
	    					refreshTable();
	                    }
	                    con.close();
	                } catch (Exception exception) {
	                	
	                	System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
	                	
	                }
				
				
				
			}
		});
		
		
		
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(607, 203, 164, 40);
		panel_7.add(btnNewButton_2);
		
		
		
		//clear input feilds
		JButton btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox_s1.setSelectedIndex(0);
				comboBox_s2.setSelectedIndex(0);
				comboBox_s3.setSelectedIndex(0);
				
				
			
			}
		});
		
		
		
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setBounds(798, 203, 155, 40);
		panel_7.add(btnNewButton_3);
		
		
		
	
		
		//table view
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 303, 1006, 142);
		panel_7.add(scrollPane);
		
		
		table = new JTable();
		table.setRowHeight(30);
		
		
		//table header
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(153, 153, 153));
		h.setForeground(Color.WHITE);
		h.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		try {
			
			
			Connection con = DBConnection.connect();
			 
			 
			String query="select conSessionID AS SID,conSession AS ConsecutiveSession from consecutiveSession ";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JButton btnNewButton_2_1 = new JButton("Conseccutive Sessions");

			btnNewButton_2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					SessionsANDnotAvailableTimeAllocationConsecutive addlecturer=new SessionsANDnotAvailableTimeAllocationConsecutive();
					SessionsANDnotAvailableTimeAllocationConsecutive.main(null);
					frame.setVisible(false);
					
				}
				
			});
			btnNewButton_2_1.setForeground(Color.RED);
			btnNewButton_2_1.setBackground(Color.BLACK);
			btnNewButton_2_1.setBounds(-11, 284, 280, 37);
			frmAddStudentGroup.getContentPane().add(btnNewButton_2_1);
			btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JButton btnNewButton_2_1_1 = new JButton("Parallel Sessions");
			btnNewButton_2_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					SessionsANDnotAvailableTimeAllocationParallel addlecturer=new SessionsANDnotAvailableTimeAllocationParallel();
					SessionsANDnotAvailableTimeAllocationParallel.main(null);
					frame.setVisible(false);
					
				}
				
			});
			
			btnNewButton_2_1_1.setForeground(Color.WHITE);
			btnNewButton_2_1_1.setBackground(Color.BLACK);
			btnNewButton_2_1_1.setBounds(-1, 321, 275, 37);
			frmAddStudentGroup.getContentPane().add(btnNewButton_2_1_1);
			btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JButton btnNewButton_2_1_2 = new JButton("Non Overlapping Sessions");
			btnNewButton_2_1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					SessionsANDnotAvailableTimeAllocationNoneOverlaping addlecturer=new SessionsANDnotAvailableTimeAllocationNoneOverlaping();
					SessionsANDnotAvailableTimeAllocationNoneOverlaping.main(null);
					frame.setVisible(false);
					
				}
				
			});
			
			btnNewButton_2_1_2.setForeground(Color.WHITE);
			btnNewButton_2_1_2.setBackground(Color.BLACK);
			btnNewButton_2_1_2.setBounds(-1, 357, 270, 37);
			frmAddStudentGroup.getContentPane().add(btnNewButton_2_1_2);
			btnNewButton_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JButton btnNewButton_2_1_3 = new JButton("Not Available Times");
			btnNewButton_2_1_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Not_Available_Time addlecturer=new Not_Available_Time();
					Not_Available_Time.main(null);
					frame.setVisible(false);
					
				}
				
			});
			
			btnNewButton_2_1_3.setForeground(Color.WHITE);
			btnNewButton_2_1_3.setBackground(Color.BLACK);
			btnNewButton_2_1_3.setBounds(-1, 393, 270, 37);
			frmAddStudentGroup.getContentPane().add(btnNewButton_2_1_3);
			btnNewButton_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			textField = new JTextField();
			textField.setText("                                                                       Time Table Management System");
			textField.setForeground(Color.WHITE);
			textField.setFont(new Font("Tahoma", Font.PLAIN, 23));
			textField.setEditable(false);
			textField.setColumns(10);
			textField.setBackground(Color.GRAY);
			textField.setBounds(-1, 35, 1334, 74);
			frmAddStudentGroup.getContentPane().add(textField);
			
			JPanel panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.setForeground(Color.RED);
			panel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
			panel_5.setBackground(Color.BLACK);
			panel_5.setBounds(-1, 102, 1334, 42);
			frmAddStudentGroup.getContentPane().add(panel_5);
			
			JLabel lblConsecutiveSessions = new JLabel("CONSECUTIVE SESSIONS");
			lblConsecutiveSessions.setHorizontalAlignment(SwingConstants.CENTER);
			lblConsecutiveSessions.setForeground(Color.RED);
			lblConsecutiveSessions.setFont(new Font("Arial Black", Font.BOLD, 19));
			lblConsecutiveSessions.setBounds(504, 10, 321, 31);
			panel_5.add(lblConsecutiveSessions);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setForeground(Color.BLACK);
			menuBar.setBorderPainted(false);
			menuBar.setBorder(null);
			menuBar.setBackground(Color.BLACK);
			menuBar.setBounds(-1, 0, 1344, 37);
			frmAddStudentGroup.getContentPane().add(menuBar);
			
			JMenu mnNewMenu = new JMenu("Category");
			mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
			mnNewMenu.setBackground(Color.BLACK);
			mnNewMenu.setForeground(Color.YELLOW);
			menuBar.add(mnNewMenu);
			
			JMenu mnNewMenu_1 = new JMenu("Lectures & Subjects");
			mnNewMenu_1.setBackground(new Color(128, 128, 128));
			mnNewMenu.add(mnNewMenu_1);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("Add Lecture");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Add_Lecturer add_Lecturer=new Add_Lecturer();
					Add_Lecturer.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_1.add(mntmNewMenuItem);
			
			JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Subjects");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Add_Subjects add_Subjects=new Add_Subjects();
					Add_Subjects.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_1.add(mntmNewMenuItem_1);
			
			JMenuItem mntmNewMenuItem_2 = new JMenuItem("Manage Lecturers");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Manage_Lecturer manage_Lecturer=new Manage_Lecturer();
					Manage_Lecturer.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_1.add(mntmNewMenuItem_2);
			
			JMenuItem mntmNewMenuItem_3 = new JMenuItem("Manage Subjects");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Manage_Subjects manage_Subjects=new Manage_Subjects();
					Manage_Subjects.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_1.add(mntmNewMenuItem_3);
			
			JMenuBar menuBar_1 = new JMenuBar();
			mnNewMenu_1.add(menuBar_1);
			
			JMenu mnNewMenu_2 = new JMenu("Session & Time Allocation");
			mnNewMenu.add(mnNewMenu_2);
			
			JMenuItem mntmNewMenuItem_5 = new JMenuItem("Add Session");
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Add_Session add_Session=new Add_Session();
					Add_Session.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_2.add(mntmNewMenuItem_5);
			
			JMenuItem mntmNewMenuItem_4 = new JMenuItem("Manage Not Available Times");
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Manage_Session_Rooms manage_Not_Available_Times=new Manage_Session_Rooms();
					Manage_Session_Rooms.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_2.add(mntmNewMenuItem_4);
			
			JMenuItem mntmNewMenuItem_6 = new JMenuItem("Consecutive Session rooms");
			mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					ConsecutiveSessionRooms manage_Session_Rooms=new ConsecutiveSessionRooms();
					ConsecutiveSessionRooms.main(null);
					frame.setVisible(false);
					
				}
				
			});
			
			mnNewMenu_2.add(mntmNewMenuItem_6);
			
			JMenuItem mntmNewMenuItem_7 = new JMenuItem("Manage Sessions");
			mntmNewMenuItem_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Manage_Sessions manage_Sessions=new Manage_Sessions();
					Manage_Sessions.main(null);
					frame.setVisible(false);
					
				}
				
			});
			
			
			mnNewMenu_2.add(mntmNewMenuItem_7);
			
			///
			
			
			JMenuItem mntmNewMenuItem_21 = new JMenuItem("Session Rooms");
			mntmNewMenuItem_21.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					SessionsRooms manage_Session_Rooms=new SessionsRooms();
					SessionsRooms.main(null);
					frame.setVisible(false);
					
				}
				
			});
			
			mnNewMenu_2.add(mntmNewMenuItem_21);
			///
			
			
			
			
			JMenuItem mntmNewMenuItem_8 = new JMenuItem("Not Available Time");
			mntmNewMenuItem_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Not_Available_Time not_Available_Time=new Not_Available_Time();
					Not_Available_Time.main(null);
					frame.setVisible(false);
					
				}
				
			});
			
			
			mnNewMenu_2.add(mntmNewMenuItem_8);
			
			JMenuItem mntmNewMenuItem_9 = new JMenuItem("Sessions & Not Available Time Allocation Consecutive");
			mntmNewMenuItem_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					SessionsANDnotAvailableTimeAllocationConsecutive sessionsANDnotAvailableTimeAllocationConsecutive=new SessionsANDnotAvailableTimeAllocationConsecutive();
					SessionsANDnotAvailableTimeAllocationConsecutive.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_2.add(mntmNewMenuItem_9);
			
			
			JMenuItem mntmNewMenuItem_10 = new JMenuItem("Sessions & Not Available Time Allocation Non Overlaping");
			mntmNewMenuItem_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					SessionsANDnotAvailableTimeAllocationNoneOverlaping sessionsANDnotAvailableTimeAllocationNoneOverlaping=new SessionsANDnotAvailableTimeAllocationNoneOverlaping();
					SessionsANDnotAvailableTimeAllocationNoneOverlaping.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_2.add(mntmNewMenuItem_10);
			
			
			JMenuItem mntmNewMenuItem_31 = new JMenuItem("Sessions & Not Available Time Allocation Parallel");
			mntmNewMenuItem_31.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					SessionsANDnotAvailableTimeAllocationParallel sessionsANDnotAvailableTimeAllocationParallel=new SessionsANDnotAvailableTimeAllocationParallel();
					SessionsANDnotAvailableTimeAllocationParallel.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_2.add(mntmNewMenuItem_31);


			
			JMenu mnNewMenu_3 = new JMenu("Working Days & Hours ");
			mnNewMenu.add(mnNewMenu_3);
			
			JMenuItem mntmNewMenuItem_11 = new JMenuItem("Add Workingdays Hours");
			mntmNewMenuItem_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Add_Workingdays_Hours add_Workingdays_Hours=new Add_Workingdays_Hours();
					Add_Workingdays_Hours.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_3.add(mntmNewMenuItem_11);
			
			
			
			JMenuItem mntmNewMenuItem_65 = new JMenuItem("Manage Workingdays Hours");
			mntmNewMenuItem_65.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Manage_Workingdays_Hours add_Workingdays_Hours=new Manage_Workingdays_Hours();
					Manage_Workingdays_Hours.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_3.add(mntmNewMenuItem_65);
			
			
			JMenu mnNewMenu_4 = new JMenu("Student & Tags");
			mnNewMenu.add(mnNewMenu_4);
			
			JMenuItem mntmNewMenuItem_14 = new JMenuItem("Add Student Groups");
			
			mntmNewMenuItem_14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Add_Student_Groups addstudentgroups=new Add_Student_Groups();
					Add_Student_Groups.main(null);
					frame.setVisible(false);
					
				}
				
			});
			
			
			mnNewMenu_4.add(mntmNewMenuItem_14);
			
			JMenuItem mntmNewMenuItem_15 = new JMenuItem("Add Tag");
			mntmNewMenuItem_15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Add_Tag addtags=new Add_Tag();
					Add_Tag.main(null);
					frame.setVisible(false);
					
				}
				
			});
			
			mnNewMenu_4.add(mntmNewMenuItem_15);
			
			JMenuItem mntmNewMenuItem_16 = new JMenuItem("Manage Student Groups");
			
			
			mntmNewMenuItem_16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Manage_Student_Groups managestudentgroups=new Manage_Student_Groups();
					Manage_Student_Groups.main(null);
					frame.setVisible(false);
					
				}
				
			});
			
			mnNewMenu_4.add(mntmNewMenuItem_16);
			
			JMenuItem mntmNewMenuItem_17 = new JMenuItem("Manage Tags");
			
			
			mntmNewMenuItem_17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Manage_Tags managetags=new Manage_Tags();
					Manage_Tags.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_4.add(mntmNewMenuItem_17);
			
			JMenu mnNewMenu_5 = new JMenu("Location & Statistics");
			mnNewMenu.add(mnNewMenu_5);
			

			
			JMenuItem mntmNewMenuItem_19 = new JMenuItem("Add Locations");
			
			
			
			mntmNewMenuItem_19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Add_Locations addlocations=new Add_Locations();
					Add_Locations.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_5.add(mntmNewMenuItem_19);
			
			JMenuItem mntmNewMenuItem_30 = new JMenuItem("Manage Locations");
			
			
			
			mntmNewMenuItem_30.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Manage_Locations managelocations=new Manage_Locations();
					Manage_Locations.main(null);
					frame.setVisible(false);
					
				}
				
			});
			
			mnNewMenu_5.add(mntmNewMenuItem_30);
			
			
		JMenuItem mntmNewMenuItem_34 = new JMenuItem("Visualizing Static");
			
			
			
			mntmNewMenuItem_34.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Visualizing_static visualizing_static=new Visualizing_static();
					Visualizing_static.main(null);
					frame.setVisible(false);
					
				}
				
			});
			
			mnNewMenu_5.add(mntmNewMenuItem_34);
			
			
			
			JMenu mnNewMenu_33 = new JMenu("Generate Time Tables");
			mnNewMenu.add(mnNewMenu_33);
			
			JMenuItem mntmNewMenuItem_111 = new JMenuItem("Lecturer");
			mntmNewMenuItem_111.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Lecturer lec=new Lecturer();
					Lecturer.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_33.add(mntmNewMenuItem_111);
			
			
			
			JMenuItem mntmNewMenuItem_655 = new JMenuItem("Student");
			mntmNewMenuItem_655.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Student student=new Student();
					Student.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_33.add(mntmNewMenuItem_655);

			
			JMenuItem mntmNewMenuItem_432 = new JMenuItem("Location");
			mntmNewMenuItem_432.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Location location=new Location();
					Location.main(null);
					frame.setVisible(false);
					
				}
				
			});
			mnNewMenu_33.add(mntmNewMenuItem_432);
			
			
			
			
			
			////////////////////////////////////////////////////////////
			
			
			
			
			
			
			
			
			JMenu mnNewMenu_7 = new JMenu("About");
			
			


			mnNewMenu_7.setFont(new Font("Segoe UI", Font.BOLD, 15));
			mnNewMenu_7.setBackground(Color.BLACK);
			mnNewMenu_7.setForeground(Color.WHITE);
			menuBar.add(mnNewMenu_7);
			
			JMenuItem mntmNewMenuItem_22 = new JMenuItem("About");
			
			
			
			
			mntmNewMenuItem_22.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					StartUp startup=new StartUp();
					StartUp.main(null);
					frame.setVisible(false);
					
				}
				
			});
			
			mnNewMenu_7.add(mntmNewMenuItem_22);
			
			
			
			
			
			
			
			
			
			
			//////////////////////////
			
			JPanel panel_1_1 = new JPanel();
			panel_1_1.setBackground(Color.GRAY);
			panel_1_1.setBounds(-1, 144, 270, 141);
			frmAddStudentGroup.getContentPane().add(panel_1_1);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.GRAY);
			panel_1.setBounds(0, 428, 269, 182);
			frmAddStudentGroup.getContentPane().add(panel_1);
			
			JPanel panel_2_1 = new JPanel();
			panel_2_1.setBackground(Color.GRAY);
			panel_2_1.setBounds(-1, 609, 270, 54);
			frmAddStudentGroup.getContentPane().add(panel_2_1);
			
			JButton btnDelete = new JButton("<<Back");
			btnDelete.setForeground(new Color(240, 248, 255));
			btnDelete.setFont(new Font("SansSerif", Font.BOLD, 13));
			btnDelete.setBackground(Color.BLACK);
			panel_2_1.add(btnDelete);
			btnNewButton_2_1_3.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					
					//NotAvailableTime not= new NotAvailableTime();
					//not.main(null);
					frmAddStudentGroup.dispose();
					new  Not_Available_Time();
					
				}
			});
			btnNewButton_2_1_2.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
				
					frmAddStudentGroup.dispose();
					new  SessionsANDnotAvailableTimeAllocationNoneOverlaping();
					
				}
			});
			btnNewButton_2_1_1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					
					frmAddStudentGroup.dispose();
					new  SessionsANDnotAvailableTimeAllocationParallel();
					
				}
			});
			btnNewButton_2_1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					
					frmAddStudentGroup.dispose();
					new  SessionsANDnotAvailableTimeAllocationConsecutive();
					
				}
			});
			
			
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(6);
			columnModel.getColumn(1).setPreferredWidth(900);
			
			
			
			
			
			//refreshTable();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		

		
	}
}
