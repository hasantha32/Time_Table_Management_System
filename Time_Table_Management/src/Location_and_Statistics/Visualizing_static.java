package Location_and_Statistics;

import java.awt.BorderLayout;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.MatteBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import DBC.DBConnection;
import Home.StartUp;
import Leactures_and_Subjects.Add_Lecturer;
import Leactures_and_Subjects.Add_Subjects;
import Leactures_and_Subjects.Manage_Lecturer;
import Leactures_and_Subjects.Manage_Subjects;
import Session_and_TimeAllocation.Add_Session;
import Session_and_TimeAllocation.ConsecutiveSessionRooms;
import Session_and_TimeAllocation.Manage_Session_Rooms;

import Session_and_TimeAllocation.Manage_Sessions;
import Session_and_TimeAllocation.Not_Available_Time;
import Session_and_TimeAllocation.SessionsANDnotAvailableTimeAllocationConsecutive;
import Session_and_TimeAllocation.SessionsANDnotAvailableTimeAllocationNoneOverlaping;
import Session_and_TimeAllocation.SessionsANDnotAvailableTimeAllocationParallel;
import Session_and_TimeAllocation.SessionsRooms;
import Students_and_Tags.Add_Student_Groups;
import Students_and_Tags.Add_Tag;
import Students_and_Tags.Manage_Student_Groups;
import Students_and_Tags.Manage_Tags;
import Timetable.Lecturer;
import Timetable.Location;
import Timetable.Student;
import Working_Days_and_Hours.Add_Workingdays_Hours;

import Working_Days_and_Hours.Manage_Workingdays_Hours;

import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Visualizing_static {
	
	private JFrame frame;
	private JFrame staticFrame;
	private JTextField statictextField;
	private JTextField statictextField_1;
	private JTextField statictextField_2;
	private JTextField statictextField_3;
	
	private int gSum1, gSum2, gSum3, gSum4;
	private JTextField statictextField_4;
	private JTextField statictextField_5;
	private JTextField statictextField_6;
	private JTextField txtTimeTableManagement;
	private JTextField txtVisualizingStatic;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visualizing_static window = new Visualizing_static();
					window.staticFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setData() {

		try {
			Connection con = DBConnection.connect();
	
	//********L	
			String query1="select count (*) as reglec from lecturers ";
			PreparedStatement pst1=con.prepareStatement(query1);
			ResultSet rs1=pst1.executeQuery();
			
			String sum1 = rs1.getString("reglec");
			gSum1 = Integer.parseInt(sum1);	
			statictextField.setText(sum1);

	//S**
			String query3="select count (*) as regsub from subjects ";
			PreparedStatement pst3=con.prepareStatement(query3);
			ResultSet rs3=pst3.executeQuery();
			String sum3 = rs3.getString("regsub");
			gSum3 = Integer.parseInt(sum3);			
			statictextField_2.setText(sum3);

			//	
					String query2="select count (*) as regstu from Student_Groups ";
					PreparedStatement pst2=con.prepareStatement(query2);
					ResultSet rs2=pst2.executeQuery();
					String sum2 = rs2.getString("regstu");
					gSum2 = Integer.parseInt(sum2);			
					statictextField_1.setText(sum2);
					
	//
			String query4="select count(*) as regroom from location ";
			PreparedStatement pst4=con.prepareStatement(query4);
			ResultSet rs4=pst4.executeQuery();
			String sum4 = rs4.getString("regroom");
			gSum4 = Integer.parseInt(sum4);			
			statictextField_3.setText(sum4);
	/////////////////////
			System.out.println(gSum4);
		}
		catch(Exception load) {
			load.printStackTrace();
		}	
	}
	public void setLatestData() {
		try {
			Connection con = DBConnection.connect();
	
			//Lecturer
			String lastLec ="SELECT LecturerName FROM Lecturers WHERE Emp_ID = (SELECT MAX(Emp_ID) FROM Lecturers)";
			PreparedStatement pst1 =con.prepareStatement(lastLec);
			ResultSet rs1 =pst1.executeQuery();
			String txtLastLec = rs1.getString("LecturerName");
			statictextField_4.setText(txtLastLec);
			
			//Subject
			String lastLec2 ="SELECT SubjectName FROM SUbjects WHERE SubjectCode = (SELECT MAX(SubjectCode) FROM SUbjects)";
			PreparedStatement pst12 =con.prepareStatement(lastLec2);
			ResultSet rs12 =pst12.executeQuery();
			String txtLastLec2 = rs12.getString("SubjectName");
			statictextField_5.setText(txtLastLec2);
			
			//Group
			String lastLec3 ="SELECT semester FROM Student_Groups WHERE studentgroupID = (SELECT MAX(studentgroupID) FROM Student_Groups)";
			PreparedStatement pst13 =con.prepareStatement(lastLec3);
			ResultSet rs13 =pst13.executeQuery();
			String txtLastLec3 = rs13.getString("semester");
			statictextField_6.setText(txtLastLec3);
			
						
		}catch (Exception a) {
			a.printStackTrace();
		}
	}


	
	/**
	 * Create the application.
	 */
	public Visualizing_static() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		staticFrame = new JFrame();
		staticFrame.getContentPane().setBackground(SystemColor.activeCaption);
		staticFrame.setBackground(Color.YELLOW);
		staticFrame.setResizable(false);
		staticFrame.setTitle("");
		staticFrame.setSize(1400, 860);
		staticFrame.setBounds(0, 0, 1050, 700);
		staticFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		staticFrame.setLocationRelativeTo(null); //this method display the JFrame to center position of a screen
		//staticFrame.setVisible(true);
		staticFrame.getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(189, 144, 1155, 527);
		panel_2.setBackground(SystemColor.activeCaption);
		staticFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel staticpanel_3 = new JPanel();
		staticpanel_3.setBackground(SystemColor.activeCaption);
		staticpanel_3.setForeground(Color.WHITE);
		staticpanel_3.setBounds(-16, 26, 1009, 509);
		panel_2.add(staticpanel_3);
		staticpanel_3.setLayout(null);
		
		JLabel staticlblNewLabel = new JLabel("Registered Lecturers");
		staticlblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		staticlblNewLabel.setBounds(212, 32, 141, 44);
		staticpanel_3.add(staticlblNewLabel);
		
		JLabel staticlblNewLabel_2 = new JLabel("Registered "
				+ "Students");
		staticlblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		staticlblNewLabel_2.setBounds(212, 86, 141, 37);
		staticpanel_3.add(staticlblNewLabel_2);
		
		JLabel staticlblNewLabel_3 = new JLabel("Registered Subjects");
		staticlblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		staticlblNewLabel_3.setBounds(497, 53, 134, 13);
		staticpanel_3.add(staticlblNewLabel_3);
		
		JLabel staticlblNewLabel_4 = new JLabel("Registered Rooms");
		staticlblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		staticlblNewLabel_4.setBounds(497, 103, 134, 13);
		staticpanel_3.add(staticlblNewLabel_4);
		
		statictextField = new JTextField();
		statictextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		statictextField.setForeground(new Color(255, 255, 255));
		statictextField.setBackground(Color.DARK_GRAY);
		statictextField.setBounds(381, 44, 61, 29);
		statictextField.setEditable(false);
		staticpanel_3.add(statictextField);
		statictextField.setColumns(10);
		
		statictextField_1 = new JTextField();
		statictextField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		statictextField_1.setBackground(Color.DARK_GRAY);
		statictextField_1.setForeground(new Color(255, 255, 255));
		statictextField_1.setColumns(10);
		statictextField_1.setBounds(381, 94, 61, 29);
		statictextField_1.setEditable(false);
		staticpanel_3.add(statictextField_1);
		
		statictextField_2 = new JTextField();
		statictextField_2.setForeground(new Color(255, 255, 255));
		statictextField_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		statictextField_2.setBackground(Color.DARK_GRAY);
		statictextField_2.setColumns(10);
		statictextField_2.setBounds(660, 44, 61, 29);
		statictextField_2.setEditable(false);
		staticpanel_3.add(statictextField_2);
		
		statictextField_3 = new JTextField();
		statictextField_3.setBackground(Color.DARK_GRAY);
		statictextField_3.setForeground(new Color(255, 255, 255));
		statictextField_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		statictextField_3.setColumns(10);
		statictextField_3.setBounds(660, 94, 61, 29);
		statictextField_3.setEditable(false);
		staticpanel_3.add(statictextField_3);
		
		
		
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setForeground(Color.BLACK);
		menuBar_2.setBorderPainted(false);
		menuBar_2.setBorder(null);
		menuBar_2.setBackground(Color.BLACK);
		menuBar_2.setBounds(3, 0, 1049, 27);
		staticFrame.getContentPane().add(menuBar_2);
		
		
		
	/*	
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(0, 0, 0));
		frame.setJMenuBar(menuBar);
		*/
		JMenu mnNewMenu = new JMenu("Category");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu.setBackground(Color.BLACK);
		mnNewMenu.setForeground(Color.YELLOW);
		menuBar_2.add(mnNewMenu);
		
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
		menuBar_2.add(mnNewMenu_7);
		
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
		JPanel staticpanel_4 = new JPanel();
		staticpanel_4.setBackground(new Color(128, 128, 128));
		staticpanel_4.setBounds(86, 224, 380, 259);
		staticpanel_3.add(staticpanel_4);
		staticpanel_4.setLayout(new BoxLayout(staticpanel_4, BoxLayout.X_AXIS));
		
		JButton btnGraphButton = new JButton("Graph");
		btnGraphButton.setForeground(new Color(255, 255, 255));
		btnGraphButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGraphButton.setBackground(Color.BLACK);
		btnGraphButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultCategoryDataset dataset = new DefaultCategoryDataset();

				 dataset.setValue(gSum1 , "Lecturer", "Lecturer");
				 dataset.setValue(gSum2 , "No.Of Students", "Student");
				 dataset.setValue(gSum3 , "Subjects", "Subjects");
				 dataset.setValue(gSum4 , "Rooms", "Rooms");
				
				 
				 JFreeChart chart = ChartFactory.createBarChart3D("Statistics of the System", " ", "Total", dataset,
						 PlotOrientation.VERTICAL,false,true,false);
				 
				 chart.setBackgroundPaint(Color.GRAY);
				 chart.getTitle().setPaint(Color.WHITE);
				 
				 
				 CategoryPlot p = chart.getCategoryPlot();
				 p.setRangeGridlinePaint(Color.white);
				 
				 ChartPanel chartPanel = new ChartPanel(chart);
				 staticpanel_4.removeAll();
				 staticpanel_4.add(chartPanel, BorderLayout.CENTER);
				 staticpanel_4.validate();
				 
				/* ChartFrame frame1 = new ChartFrame("Statistics", chart);
	
				frame1.setVisible(true);
				frame1.setSize(500, 700);*/
			
			}
		});
		btnGraphButton.setBounds(229, 183, 105, 31);
		staticpanel_3.add(btnGraphButton);
		
		JPanel staticpanel_5 = new JPanel();
		staticpanel_5.setBackground(new Color(128, 128, 128));
		staticpanel_5.setBounds(539, 224, 268, 259);
		staticpanel_3.add(staticpanel_5);
		staticpanel_5.setLayout(null);
		
		JLabel staticlblNewLabel_5 = new JLabel("What is New?");
		staticlblNewLabel_5.setForeground(new Color(255, 255, 255));
		staticlblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		staticlblNewLabel_5.setBounds(10, 21, 99, 13);
		staticpanel_5.add(staticlblNewLabel_5);
		
		JLabel staticlblNewLabel_6 = new JLabel("Lecturer");
		staticlblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		staticlblNewLabel_6.setBounds(35, 73, 65, 13);
		staticpanel_5.add(staticlblNewLabel_6);
		
		JLabel staticlblNewLabel_7 = new JLabel("Subject");
		staticlblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		staticlblNewLabel_7.setBounds(35, 124, 65, 13);
		staticpanel_5.add(staticlblNewLabel_7);
		
		JLabel staticlblNewLabel_8 = new JLabel("Group");
		staticlblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		staticlblNewLabel_8.setBounds(35, 179, 45, 13);
		staticpanel_5.add(staticlblNewLabel_8);
		
		statictextField_4 = new JTextField();
		statictextField_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		statictextField_4.setBounds(110, 70, 132, 19);
		statictextField_4.setEditable(false);
		staticpanel_5.add(statictextField_4);
		statictextField_4.setColumns(10);
		
		statictextField_5 = new JTextField();
		statictextField_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		statictextField_5.setBounds(110, 121, 132, 19);
		statictextField_5.setEditable(false);
		staticpanel_5.add(statictextField_5);
		statictextField_5.setColumns(10);
		
		statictextField_6 = new JTextField();
		statictextField_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		statictextField_6.setBounds(110, 176, 132, 19);
		statictextField_6.setEditable(false);
		staticpanel_5.add(statictextField_6);
		statictextField_6.setColumns(10);
		
		txtTimeTableManagement = new JTextField();
		txtTimeTableManagement.setText("                                                       Time Table Management System");
		txtTimeTableManagement.setForeground(Color.WHITE);
		txtTimeTableManagement.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtTimeTableManagement.setEditable(false);
		txtTimeTableManagement.setColumns(10);
		txtTimeTableManagement.setBackground(Color.GRAY);
		txtTimeTableManagement.setBounds(3, 28, 1341, 72);
		staticFrame.getContentPane().add(txtTimeTableManagement);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(-615, -84, 946, 27);
		staticFrame.getContentPane().add(menuBar);
		
		txtVisualizingStatic = new JTextField();
		txtVisualizingStatic.setText("                                                                        VISUALIZING STATIC");
		txtVisualizingStatic.setForeground(Color.RED);
		txtVisualizingStatic.setFont(new Font("Arial Black", Font.BOLD, 19));
		txtVisualizingStatic.setEditable(false);
		txtVisualizingStatic.setColumns(10);
		txtVisualizingStatic.setBackground(Color.BLACK);
		txtVisualizingStatic.setBounds(3, 97, 1341, 29);
		staticFrame.getContentPane().add(txtVisualizingStatic);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GRAY);
		panel_1_1.setBounds(3, 126, 179, 281);
		staticFrame.getContentPane().add(panel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(3, 406, 179, 215);
		staticFrame.getContentPane().add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(3, 618, 179, 53);
		staticFrame.getContentPane().add(panel);
		
		JButton btnDelete_1_1 = new JButton("<<Back");
		btnDelete_1_1.setForeground(new Color(240, 248, 255));
		btnDelete_1_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnDelete_1_1.setBackground(Color.BLACK);
		panel.add(btnDelete_1_1);
		
		
		
		
		setData();
		setLatestData();
	}
}
