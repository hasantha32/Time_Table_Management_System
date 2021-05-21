

package Session_and_TimeAllocation;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ConsecutiveSessionRooms {
	
	

	private JFrame frame;
	private JFrame crframe;
	private JTable crtable;
	private JTable crtable_1;
	private JTable crtable_2;
	private JComboBox consession;
	private JComboBox consessionroom;
	private JTextField txtAddConsecutiveSession;
	private JTextField txtTimeTableManagement;
	
	
	public  void  loadConSession(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from consecutiveSession ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("conSession");
					consession.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	 public void loadConsessionRoom() {
		 try {
			 
			 Connection con = DBConnection.connect();
			 
			 String query ="select * from location";
			 PreparedStatement pst=con.prepareStatement(query);
			 ResultSet rs =pst.executeQuery();
			 
			 while(rs.next()) {
				 String room = rs.getString("roomName");
				 consessionroom.addItem(room);
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
					ConsecutiveSessionRooms window = new ConsecutiveSessionRooms();
					window.crframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsecutiveSessionRooms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		crframe = new JFrame();
		crframe.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		crframe.setBackground(Color.YELLOW);
		crframe.setResizable(false);
		crframe.setTitle("Time Table Management System");
		crframe.setSize(1400, 860);
		crframe.setBounds(0, 0, 1350, 700);
		crframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crframe.getContentPane().setLayout(null);
	
		crframe.setLocationRelativeTo(null);
		//crframe.setVisible(true);
		
		JPanel crpanel_2 = new JPanel();
		crpanel_2.setBackground(SystemColor.activeCaption);
		crpanel_2.setBounds(252, 150, 1092, 521);
		crframe.getContentPane().add(crpanel_2);
		crpanel_2.setLayout(null);
		
		JPanel crpanel_3 = new JPanel();
		crpanel_3.setBackground(Color.DARK_GRAY);
		crpanel_3.setBounds(135, 39, 756, 428);
		crpanel_2.add(crpanel_3);
		crpanel_3.setLayout(null);
		
		JLabel crlblNewLabel = new JLabel("Select Consecutive Session");
		crlblNewLabel.setForeground(Color.WHITE);
		crlblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		crlblNewLabel.setBounds(73, 79, 161, 13);
		crpanel_3.add(crlblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Room");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(462, 79, 78, 13);
		crpanel_3.add(lblNewLabel_1);
		
		JLabel crlblNewLabel_2 = new JLabel("Selected ConsecutiveSession Room");
		crlblNewLabel_2.setForeground(Color.WHITE);
		crlblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		crlblNewLabel_2.setBounds(73, 164, 200, 32);
		crpanel_3.add(crlblNewLabel_2);
		
		JTextArea generateConSesRoom = new JTextArea();
		generateConSesRoom.setBounds(276, 169, 339, 82);
		crpanel_3.add(generateConSesRoom);
		
		JButton crbtnNewButton_4 = new JButton("SUBMIT");
		crbtnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		crbtnNewButton_4.setForeground(Color.WHITE);
		crbtnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateConSesRoom.setText(consession.getSelectedItem().toString()+"\n"+"-"+consessionroom.getSelectedItem().toString());
				
				String consessionCode=consession.getSelectedItem().toString();
				String cRoom=consessionroom.getSelectedItem().toString();
				String consessionRoomCode = generateConSesRoom.getText();
				
				try {
					Connection con = DBConnection.connect();
					
					String query = "INSERT INTO roomconsecutivesession values (null,'"+consessionCode+"','"+cRoom+"','"+consessionRoomCode+"')";
					Statement sta = con.createStatement();
					int x = sta.executeUpdate(query);
					if(x==0) {
						JLabel label = new JLabel("This is alredy exist");
    					label.setHorizontalAlignment(SwingConstants.CENTER);
    					JOptionPane.showMessageDialog(null, label);
					}else {
    						JLabel label = new JLabel("Inserted Sucessfully");
	    					label.setHorizontalAlignment(SwingConstants.CENTER);
	    					JOptionPane.showMessageDialog(null, label);
	    					
    					}
						
    					con.close();
					
				}catch(Exception exception) {
					exception.printStackTrace();
					
				}
			}
		});
		crbtnNewButton_4.setBackground(Color.BLACK);
		crbtnNewButton_4.setBounds(296, 291, 105, 32);
		crpanel_3.add(crbtnNewButton_4);
		
		JButton crbtnNewButton_5 = new JButton("CLEAR");
		crbtnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		crbtnNewButton_5.setForeground(Color.WHITE);
		crbtnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateConSesRoom.setText("");
				consessionroom.setSelectedIndex(0);
				consession.setSelectedIndex(0);
				
			}
		});
		crbtnNewButton_5.setBackground(Color.BLACK);
		crbtnNewButton_5.setBounds(490, 291, 105, 32);
		crpanel_3.add(crbtnNewButton_5);
		
		consession = new JComboBox();
		consession.setModel(new DefaultComboBoxModel(new String[] {"Select Consecutive Session-------"}));
		consession.setBounds(262, 76, 176, 21);
		crpanel_3.add(consession);
		
		loadConSession();
		
		consessionroom = new JComboBox();
		consessionroom.setModel(new DefaultComboBoxModel(new String[] {"Select Room-----------"}));
		consessionroom.setBounds(550, 76, 161, 21);
		crpanel_3.add(consessionroom);
		
		loadConsessionRoom();
		
		//addsessionroom button
		
		JButton btnNewButton = new JButton("Add SessionRooms");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		
			
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					SessionsRooms sessionrooms=new SessionsRooms();
					SessionsRooms.main(null);
					crframe.setVisible(false);
					
				}
				
			});
		btnNewButton.setBounds(0, 319, 252, 39);
		crframe.getContentPane().add(btnNewButton);
		
		//add consession button
		JButton btnNewButton_2 = new JButton("Add ConsecutiveSessionsRooms");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ConsecutiveSessionRooms add_con = new ConsecutiveSessionRooms();
				//add_con.main(null);
				crframe.dispose();
				new ConsecutiveSessionRooms();
			}
		});
		btnNewButton_2.setBounds(0, 356, 251, 39);
		crframe.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 394, 252, 198);
		crframe.getContentPane().add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 592, 252, 71);
		crframe.getContentPane().add(panel_2);
		
		JButton btnDelete_1 = new JButton("<<Back");
		btnDelete_1.setForeground(new Color(240, 248, 255));
		btnDelete_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnDelete_1.setBackground(Color.BLACK);
		panel_2.add(btnDelete_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 150, 252, 170);
		crframe.getContentPane().add(panel_1);
		
		txtAddConsecutiveSession = new JTextField();
		txtAddConsecutiveSession.setText("                                                                      ADD CONSECUTIVE SESSION ROOMS");
		txtAddConsecutiveSession.setForeground(Color.RED);
		txtAddConsecutiveSession.setFont(new Font("Arial Black", Font.BOLD, 19));
		txtAddConsecutiveSession.setEditable(false);
		txtAddConsecutiveSession.setColumns(10);
		txtAddConsecutiveSession.setBackground(Color.BLACK);
		txtAddConsecutiveSession.setBounds(0, 123, 1344, 29);
		crframe.getContentPane().add(txtAddConsecutiveSession);
		
		txtTimeTableManagement = new JTextField();
		txtTimeTableManagement.setText("                                                                  Time Table Management System");
		txtTimeTableManagement.setForeground(Color.WHITE);
		txtTimeTableManagement.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtTimeTableManagement.setEditable(false);
		txtTimeTableManagement.setColumns(10);
		txtTimeTableManagement.setBackground(Color.GRAY);
		txtTimeTableManagement.setBounds(0, 34, 1344, 92);
		crframe.getContentPane().add(txtTimeTableManagement);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 0, 1344, 35);
		crframe.getContentPane().add(menuBar);
		
		
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
		
	}
}
