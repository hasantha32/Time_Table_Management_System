package Leactures_and_Subjects;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBC.DBConnection;
import Home.Dashboard;
import Home.StartUp;
import Location_and_Statistics.Add_Locations;
import Location_and_Statistics.Add_Locations_Sessions;
import Location_and_Statistics.Manage_Locations;
import Location_and_Statistics.Visualizing_static;
import Session_and_TimeAllocation.Add_Session;
import Session_and_TimeAllocation.Manage_Not_Available_Times;
import Session_and_TimeAllocation.Manage_Session_Rooms;
import Session_and_TimeAllocation.Manage_Sessions;
import Session_and_TimeAllocation.Not_Available_Time;
import Session_and_TimeAllocation.Search_Sessions;
import Session_and_TimeAllocation.SessionsANDnotAvailableTimeAllocationConsecutive;
import Session_and_TimeAllocation.SessionsANDnotAvailableTimeAllocationNoneOverlaping;
import Session_and_TimeAllocation.SessionsANDnotAvailableTimeAllocationParallel;

import Students_and_Tags.Add_Student_Groups;
import Students_and_Tags.Add_Tag;
import Students_and_Tags.Manage_Student_Groups;
import Students_and_Tags.Manage_Tags;
import Working_Days_and_Hours.Add_Workingdays_Hours;
import Working_Days_and_Hours.Genarate_Lecturer_Time_Table;
import Working_Days_and_Hours.Genarate_Student_TimeTable;
import Working_Days_and_Hours.Genarate_TimeLocation;
import Working_Days_and_Hours.Manage_Workingdays_Hours;
import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;

public class Manage_Lecturer {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtTimeTableManagement;
	private JTextField txtAddLecturer;
	private JTable table;
	private JTable table_1;
	private JTextField textField_2;
	
	
	PreparedStatement pst = null;
	Connection conn = null;
	ResultSet rs = null;
//////
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Lecturer window = new Manage_Lecturer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Manage_Lecturer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(1, 30, 1540, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(0, 0, 0));
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Category");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu.setBackground(Color.BLACK);
		mnNewMenu.setForeground(Color.YELLOW);
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Lecture & Subject");
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
				
				Manage_Not_Available_Times manage_Not_Available_Times=new Manage_Not_Available_Times();
				Manage_Not_Available_Times.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Manage Session Rooms");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Session_Rooms manage_Session_Rooms=new Manage_Session_Rooms();
				Manage_Session_Rooms.main(null);
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
		
		JMenuItem mntmNewMenuItem_20 = new JMenuItem("Genarate Lecture Time Table");
		mntmNewMenuItem_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Genarate_Lecturer_Time_Table genarate_Lecturer_Time_Table=new Genarate_Lecturer_Time_Table();
				Genarate_Lecturer_Time_Table.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		mnNewMenu_3.add(mntmNewMenuItem_20);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Genarate Student Time Table");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Genarate_Student_TimeTable genarate_Student_TimeTable=new Genarate_Student_TimeTable();
				Genarate_Student_TimeTable.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		mnNewMenu_3.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Genarate Time Location");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Genarate_TimeLocation genarate_TimeLocation=new Genarate_TimeLocation();
				Genarate_TimeLocation.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		mnNewMenu_3.add(mntmNewMenuItem_13);
		
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
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Add Locations Sessions");
		
		mntmNewMenuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Locations_Sessions addlocationssessions=new Add_Locations_Sessions();
				Add_Locations_Sessions.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		mnNewMenu_5.add(mntmNewMenuItem_18);
		
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
		
		
		//////////////
		
		
		
		
		JLabel lblNewLabel_8_1 = new JLabel("Rank");
		lblNewLabel_8_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_8_1.setBounds(1121, 579, 63, 20);
		frame.getContentPane().add(lblNewLabel_8_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Monday");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		chckbxNewCheckBox.setBackground(Color.GRAY);
		chckbxNewCheckBox.setBounds(428, 384, 100, 21);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setSelected(true);
		chckbxTuesday.setForeground(Color.WHITE);
		chckbxTuesday.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		chckbxTuesday.setBackground(Color.GRAY);
		chckbxTuesday.setBounds(428, 410, 100, 22);
		frame.getContentPane().add(chckbxTuesday);
		
		JLabel lblNewLabel_4_2_1_2 = new JLabel("From");
		lblNewLabel_4_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2.setBounds(531, 412, 36, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_2);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("From");
		lblNewLabel_4_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2.setBounds(531, 390, 36, 20);
		frame.getContentPane().add(lblNewLabel_4_2_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(569, 390, 53, 20);
		frame.getContentPane().add(spinner);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_2.setBounds(650, 390, 52, 20);
		frame.getContentPane().add(spinner_2);
		
		JLabel lblNewLabel_4_2_2_1 = new JLabel("To");
		lblNewLabel_4_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2_1.setBounds(632, 390, 28, 20);
		frame.getContentPane().add(lblNewLabel_4_2_2_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1.setBounds(569, 414, 53, 20);
		frame.getContentPane().add(spinner_1);
		
		JLabel lblNewLabel_4_2_1_2_1 = new JLabel("To");
		lblNewLabel_4_2_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2_1.setBounds(632, 412, 28, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_2_1);
		
		JSpinner spinner_1_3 = new JSpinner();
		spinner_1_3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_3.setBounds(650, 414, 52, 20);
		frame.getContentPane().add(spinner_1_3);
		
		JSpinner spinner_1_1_1 = new JSpinner();
		spinner_1_1_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_1_1.setBounds(650, 437, 52, 20);
		frame.getContentPane().add(spinner_1_1_1);
		
		JLabel lblNewLabel_4_2_1_1_2_1 = new JLabel("To");
		lblNewLabel_4_2_1_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2_1.setBounds(630, 437, 18, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_1_2_1);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_1.setBounds(569, 440, 52, 20);
		frame.getContentPane().add(spinner_1_1);
		
		JLabel lblNewLabel_4_2_1_1_2 = new JLabel("From");
		lblNewLabel_4_2_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2.setBounds(530, 437, 36, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_1_2);
		
		JLabel lblNewLabel_4_2_1_1_1_2 = new JLabel("From");
		lblNewLabel_4_2_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_1_2.setBounds(530, 465, 36, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_1_1_2);
		
		JSpinner spinner_1_2 = new JSpinner();
		spinner_1_2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_2.setBounds(569, 465, 52, 20);
		frame.getContentPane().add(spinner_1_2);
		
		JLabel lblNewLabel_4_2_1_1_1_2_1 = new JLabel("To");
		lblNewLabel_4_2_1_1_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_1_2_1.setBounds(630, 463, 18, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_1_1_2_1);
		
		JSpinner spinner_1_2_1 = new JSpinner();
		spinner_1_2_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_2_1.setBounds(650, 462, 52, 20);
		frame.getContentPane().add(spinner_1_2_1);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setSelected(true);
		chckbxThursday.setForeground(Color.WHITE);
		chckbxThursday.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		chckbxThursday.setBackground(Color.GRAY);
		chckbxThursday.setBounds(430, 467, 97, 20);
		frame.getContentPane().add(chckbxThursday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setSelected(true);
		chckbxWednesday.setForeground(Color.WHITE);
		chckbxWednesday.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		chckbxWednesday.setBackground(Color.GRAY);
		chckbxWednesday.setBounds(430, 440, 97, 22);
		frame.getContentPane().add(chckbxWednesday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setSelected(true);
		chckbxFriday.setForeground(Color.WHITE);
		chckbxFriday.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		chckbxFriday.setBackground(Color.GRAY);
		chckbxFriday.setBounds(797, 384, 89, 20);
		frame.getContentPane().add(chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setSelected(true);
		chckbxSaturday.setForeground(Color.WHITE);
		chckbxSaturday.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		chckbxSaturday.setBackground(Color.GRAY);
		chckbxSaturday.setBounds(797, 413, 89, 20);
		frame.getContentPane().add(chckbxSaturday);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setSelected(true);
		chckbxSunday.setForeground(Color.WHITE);
		chckbxSunday.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		chckbxSunday.setBackground(Color.GRAY);
		chckbxSunday.setBounds(799, 444, 87, 20);
		frame.getContentPane().add(chckbxSunday);
		
		JLabel lblNewLabel_4_2_2_2 = new JLabel("From");
		lblNewLabel_4_2_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_2_2.setBackground(Color.WHITE);
		lblNewLabel_4_2_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2_2.setBounds(892, 385, 36, 20);
		frame.getContentPane().add(lblNewLabel_4_2_2_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_3.setBounds(931, 387, 52, 20);
		frame.getContentPane().add(spinner_3);
		
		JLabel lblNewLabel_4_2_2_1_1 = new JLabel("To");
		lblNewLabel_4_2_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_4_2_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2_1_1.setBounds(989, 387, 28, 20);
		frame.getContentPane().add(lblNewLabel_4_2_2_1_1);
		
		JSpinner spinner_2_1 = new JSpinner();
		spinner_2_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_2_1.setBounds(1017, 387, 52, 20);
		frame.getContentPane().add(spinner_2_1);
		
		JSpinner spinner_1_3_1 = new JSpinner();
		spinner_1_3_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_3_1.setBounds(1017, 415, 52, 20);
		frame.getContentPane().add(spinner_1_3_1);
		
		JSpinner spinner_1_1_1_1 = new JSpinner();
		spinner_1_1_1_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_1_1_1.setBounds(1017, 443, 52, 20);
		frame.getContentPane().add(spinner_1_1_1_1);
		
		JLabel lblNewLabel_4_2_1_1_2_1_1 = new JLabel("To");
		lblNewLabel_4_2_1_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2_1_1.setBounds(989, 440, 28, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_1_2_1_1);
		
		JLabel lblNewLabel_4_2_1_2_1_1 = new JLabel("To");
		lblNewLabel_4_2_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_4_2_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2_1_1.setBounds(989, 411, 28, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_2_1_1);
		
		JSpinner spinner_1_4 = new JSpinner();
		spinner_1_4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_4.setBounds(931, 415, 52, 20);
		frame.getContentPane().add(spinner_1_4);
		
		JSpinner spinner_1_1_2 = new JSpinner();
		spinner_1_1_2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_1_2.setBounds(931, 444, 52, 20);
		frame.getContentPane().add(spinner_1_1_2);
		
		JLabel lblNewLabel_4_2_1_1_2_2 = new JLabel("From");
		lblNewLabel_4_2_1_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_2.setBackground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2_2.setBounds(892, 441, 36, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_1_2_2);
		
		JLabel lblNewLabel_4_2_1_2_2 = new JLabel("From");
		lblNewLabel_4_2_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_2.setBackground(Color.WHITE);
		lblNewLabel_4_2_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2_2.setBounds(892, 411, 36, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_2_2);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(Color.DARK_GRAY);
		panel_2_2.setBounds(420, 373, 733, 129);
		frame.getContentPane().add(panel_2_2);
		
		
		
		
		
		//////////
		
		
		JLabel lblNewLabel_4_1 = new JLabel("Active days & hours of lecturers");
		lblNewLabel_4_1.setForeground(Color.BLACK);
		lblNewLabel_4_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(216, 233, 312, 29);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		
		
		
		
		
		
		
		
		
		
		
		textField = new JTextField();
		textField.setBounds(553, 519, 164, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(553, 550, 164, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Lecture Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(446, 517, 97, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Employee ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(446, 548, 88, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Faculty");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(446, 584, 88, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(446, 615, 88, 20);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Center");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(775, 518, 82, 20);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Building");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_6.setBounds(775, 548, 88, 20);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Level");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_7.setBounds(775, 579, 88, 20);
		frame.getContentPane().add(lblNewLabel_7);
		
		
		
		
		
		
		
		
		
		
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Computing", "Engineering"}));

		comboBox.setBounds(553, 581, 164, 22);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"SE", "IT", "DS", "Civil", "Mechanical"}));

		comboBox_1.setBounds(553, 616, 164, 22);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {" Kandy", " Malabe", "Matara", "Jaffna"}));

		comboBox_2.setBounds(880, 517, 168, 22);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));

		comboBox_3.setBounds(880, 546, 168, 22);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Professor ", "AssistantProfessor  ", "Senior Lecturer(HG)", "Senior Lecturer   ", "Lecturer", "Assistant Lecturer"}));

		comboBox_4.setBounds(880, 577, 168, 22);
		frame.getContentPane().add(comboBox_4);
		
		
JButton btnClear = new JButton("Clear");
		
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(null);
				textField_1.setText(null);
				comboBox.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				comboBox_3.setSelectedItem(null);
				comboBox_4.setSelectedItem(null);
				comboBox_2.setSelectedItem(null);
				textField_2.setText(null);
			}
		});
		
		
		
		
		btnClear.setForeground(new Color(240, 248, 255));
		btnClear.setBackground(new Color(0, 0, 0));
		btnClear.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnClear.setBounds(518, 651, 132, 35);
		frame.getContentPane().add(btnClear);
		
		
		
		
		
		JButton btnSave = new JButton("Update");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//////////////////
				
				
	
					
				try {
					if(textField_2.getText().equals("")||textField.getText().equals("")||textField_1.getText().equals("")||comboBox.getSelectedItem().equals("")||comboBox_1.getSelectedItem().equals("")||comboBox_3.getSelectedItem().equals("")||comboBox_4.getSelectedItem().equals("")||comboBox_2.getSelectedItem().equals("")   ||spinner.getValue().equals("")||spinner_2.getValue().equals("") ||spinner_1.getValue().equals("")||spinner_1_3.getValue().equals("")||spinner_1_1.getValue().equals("")||spinner_1_1_1.getValue().equals("") ||spinner_1_2.getValue().equals("")||spinner_1_2_1.getValue().equals("")||spinner_3.getValue().equals("")||spinner_2_1.getValue().equals("")||spinner_1_4.getValue().equals("")||spinner_1_3_1.getValue().equals("") ||spinner_1_1_2.getValue().equals("")||spinner_1_1_1_1.getValue().equals("")    ||chckbxNewCheckBox.getText().equals("")||chckbxTuesday.getText().equals("")||chckbxWednesday.getText().equals("")||chckbxThursday.getText().equals("")||chckbxFriday.getText().equals("")||chckbxSaturday.getText().equals("")||chckbxSunday.getText().equals("")    ){
						JOptionPane.showMessageDialog(null, "Please fill the form and press generate button to generate the rank");
					}else if(!(textField.getText().trim().matches("^[A-Za-z]+"))) {
						JOptionPane.showMessageDialog(null, "Invalid lecturer name");
					}else if(comboBox.getSelectedItem().equals("Computing")&& comboBox_1.getSelectedItem().equals("Civil")) {
						JOptionPane.showMessageDialog(null, "Faculty and Department is mismatch");
						
					}else if(comboBox.getSelectedItem().equals("Computing")&& comboBox_1.getSelectedItem().equals("Mechanical")) {
						JOptionPane.showMessageDialog(null, "Faculty and Department is mismatch");
						
					}else if(comboBox.getSelectedItem().equals("Engineering")&& comboBox_1.getSelectedItem().equals("SE")) {
						JOptionPane.showMessageDialog(null, "Faculty and Department is mismatch");
						
					}else if(comboBox.getSelectedItem().equals("Engineering")&& comboBox_1.getSelectedItem().equals("DS")) {
						JOptionPane.showMessageDialog(null, "Faculty and Department is mismatch");
						
					}else if(comboBox.getSelectedItem().equals("Engineering")&& comboBox_1.getSelectedItem().equals("IT")) {
						JOptionPane.showMessageDialog(null, "Faculty and Department is mismatch");
					}else {
					Connection con = DBConnection.connect();
					
					//String query="Update Lecturers set LecturerName='"+textField.getText()+"',faculty='"+comboBox.getSelectedItem()+"',Department='"+comboBox_1.getSelectedItem()+"',center='"+comboBox_2.getSelectedItem()+"',building='"+comboBox_3.getSelectedItem()+"',level='"+comboBox_4.getSelectedItem()+"' ,rank='"+textField_2.getText()+"' where Lecturer ID='"+textField_1.getText()+"' ";
					
					//String query="Update Lecturers set LecturerName='"+textField.getText()+"',faculty='"+comboBox.getSelectedItem()+"',Department='"+comboBox_1.getSelectedItem()+"',center='"+comboBox_2.getSelectedItem()+"',building='"+comboBox_3.getSelectedItem()+"',level='"+comboBox_4.getSelectedItem()+"' ,rank='"+textField_2.getText()+"' where Lecturer ID='"+textField_1.getText()+"' ";

		
					
									String query="Update Lecturers set LecturerName='"+textField.getText()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query2="Update Lecturers set faculty='"+comboBox.getSelectedItem()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query3="Update Lecturers set Department='"+comboBox_1.getSelectedItem()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query4="Update Lecturers set center='"+comboBox_2.getSelectedItem()+"' where Emp_ID='"+textField_1.getText()+"' ";

									
									String query5="Update Lecturers set building='"+comboBox_3.getSelectedItem()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query6="Update Lecturers set level='"+comboBox_4.getSelectedItem()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query7="Update Lecturers set rank='"+textField_2.getText()+"' where Emp_ID='"+textField_1.getText()+"' ";

									
									
									
									//
									String query8="Update Lecturers set Mondayfrom='"+spinner.getValue()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query9="Update Lecturers set Mondayto='"+spinner_2.getValue()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query10="Update Lecturers set Tuesdayfrom='"+spinner_1.getValue()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query11="Update Lecturers set Tuesdayto='"+spinner_1_3.getValue()+"' where Emp_ID='"+textField_1.getText()+"' ";

									
									String query12="Update Lecturers set Wednesdayfrom='"+spinner_1_1.getValue()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query13="Update Lecturers set Wednesdayto='"+spinner_1_1_1.getValue()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query14="Update Lecturers set Thursdayfrom='"+spinner_1_2.getValue()+"' where Emp_ID='"+textField_1.getText()+"' ";

									String query15="Update Lecturers set Thursdayto='"+spinner_1_2_1.getValue()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query16="Update Lecturers set Fridayfrom='"+spinner_3.getValue()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query17="Update Lecturers set Fridayto='"+spinner_2_1.getValue()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query18="Update Lecturers set Saturdayfrom='"+spinner_1_4.getValue()+"' where Emp_ID='"+textField_1.getText()+"' ";

									
									String query19="Update Lecturers set Saturdayto='"+spinner_1_3_1.getValue()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query20="Update Lecturers set Sundayfrom='"+spinner_1_1_2.getValue()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query21="Update Lecturers set Sundayto='"+spinner_1_1_1_1.getValue()+"' where Emp_ID='"+textField_1.getText()+"' ";

									
									
					
							
					
									
									String query22="Update Lecturers set monday='"+chckbxNewCheckBox.isSelected()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query23="Update Lecturers set tuesday='"+chckbxTuesday.isSelected()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query24="Update Lecturers set wednesday='"+chckbxWednesday.isSelected()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query25="Update Lecturers set thursday='"+chckbxThursday.isSelected()+"' where Emp_ID='"+textField_1.getText()+"' ";

									String query26="Update Lecturers set friday='"+chckbxFriday.isSelected()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query27="Update Lecturers set saturday='"+chckbxSaturday.isSelected()+"' where Emp_ID='"+textField_1.getText()+"' ";
									
									String query28="Update Lecturers set sunday='"+chckbxSunday.isSelected()+"' where Emp_ID='"+textField_1.getText()+"' ";

									PreparedStatement pst2=con.prepareStatement(query2);
					PreparedStatement pst=con.prepareStatement(query);
					PreparedStatement pst3=con.prepareStatement(query3);
					PreparedStatement pst4=con.prepareStatement(query4);
					PreparedStatement pst5=con.prepareStatement(query5);
					PreparedStatement pst6=con.prepareStatement(query6);
					PreparedStatement pst7=con.prepareStatement(query7);
					
					PreparedStatement pst8=con.prepareStatement(query8);
					PreparedStatement pst9=con.prepareStatement(query9);
					PreparedStatement pst10=con.prepareStatement(query10);
					PreparedStatement pst11=con.prepareStatement(query11);
					PreparedStatement pst12=con.prepareStatement(query12);
					PreparedStatement pst13=con.prepareStatement(query13);
					PreparedStatement pst14=con.prepareStatement(query14);
					PreparedStatement pst15=con.prepareStatement(query15);
					PreparedStatement pst16=con.prepareStatement(query16);
					PreparedStatement pst17=con.prepareStatement(query17);
					PreparedStatement pst18=con.prepareStatement(query18);
					PreparedStatement pst19=con.prepareStatement(query19);
					PreparedStatement pst20=con.prepareStatement(query20);
					PreparedStatement pst21=con.prepareStatement(query21);
					
					
					
					
					PreparedStatement pst22=con.prepareStatement(query22);
					PreparedStatement pst23=con.prepareStatement(query23);
					PreparedStatement pst24=con.prepareStatement(query24);
					PreparedStatement pst25=con.prepareStatement(query25);
					PreparedStatement pst26=con.prepareStatement(query26);
					PreparedStatement pst27=con.prepareStatement(query27);
					PreparedStatement pst28=con.prepareStatement(query28);
					pst2.executeUpdate();
					pst.executeUpdate();
					pst3.executeUpdate();
					pst4.executeUpdate();
					pst5.executeUpdate();
					pst6.executeUpdate();
					pst7.executeUpdate();
					
					pst8.executeUpdate();
					pst9.executeUpdate();
					pst10.executeUpdate();
					pst11.executeUpdate();
					pst12.executeUpdate();
					pst13.executeUpdate();
					pst14.executeUpdate();
					pst15.executeUpdate();
					pst16.executeUpdate();
					pst17.executeUpdate();
					pst18.executeUpdate();
					pst19.executeUpdate();
					pst20.executeUpdate();
					pst21.executeUpdate();
					
					
					pst22.executeUpdate();
					pst23.executeUpdate();
					pst24.executeUpdate();
					pst25.executeUpdate();
					pst26.executeUpdate();
					pst27.executeUpdate();
					pst28.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					pst2.close();
					pst3.close();
					pst4.close();
					pst5.close();
					pst6.close();
					pst7.close();
					
					pst8.close();
					pst9.close();
					pst10.close();
					pst11.close();
					pst12.close();
					pst13.close();
					pst14.close();
					pst15.close();
					pst16.close();
					pst17.close();
					pst18.close();
					pst19.close();
					pst20.close();
					pst21.close();
					
					
					pst22.close();
					pst23.close();
					pst24.close();
					pst25.close();
					pst26.close();
					pst27.close();
					pst28.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
				}
				
				//////////////////
			
			}
		});
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(0, 0, 0));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(717, 651, 132, 35);
		frame.getContentPane().add(btnSave);
		
		
		
		txtTimeTableManagement = new JTextField();
		txtTimeTableManagement.setEditable(false);
		txtTimeTableManagement.setForeground(new Color(255, 255, 255));
		txtTimeTableManagement.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtTimeTableManagement.setText("                                                                                  Time Table Management System");
		txtTimeTableManagement.setBackground(Color.GRAY);
		txtTimeTableManagement.setBounds(0, 0, 1558, 87);
		frame.getContentPane().add(txtTimeTableManagement);
		txtTimeTableManagement.setColumns(10);
		
		txtAddLecturer = new JTextField();
		txtAddLecturer.setEditable(false);
		txtAddLecturer.setText("                                                                                                     MANAGE LECTURER");
		txtAddLecturer.setForeground(new Color(255, 0, 0));
		txtAddLecturer.setFont(new Font("Arial Black", Font.BOLD, 19));
		txtAddLecturer.setColumns(10);
		txtAddLecturer.setBackground(new Color(0, 0, 0));
		txtAddLecturer.setBounds(0, 84, 1558, 29);
		frame.getContentPane().add(txtAddLecturer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 116, 1526, 105);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 10));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

                int selectedRow=table.getSelectedRow();
				
				
				//textField.setText(table.getValueAt(selectedRow, 1).toString());
                textField.setText(table.getValueAt(selectedRow, 1).toString());
                textField_1.setText(table.getValueAt(selectedRow,0).toString());
                
                String facultyvalue=table.getValueAt(selectedRow, 2).toString();
                	String getFaculty=(String) comboBox.getSelectedItem();
                	comboBox.setSelectedItem(facultyvalue);
                	
                String Department=table.getValueAt(selectedRow, 3).toString();
                	String getDep=(String)comboBox_1.getSelectedItem();
                	comboBox_1.setSelectedItem(Department);
                	
                    String CenterName=table.getValueAt(selectedRow, 4).toString();
                 	String getCenter=(String)comboBox_2.getSelectedItem();
                 	comboBox_2.setSelectedItem(CenterName);
                 	
                	
                String buildingName=table.getValueAt(selectedRow, 5).toString();
                	String Getbuilding=(String)comboBox_3.getSelectedItem();
                	comboBox_3.setSelectedItem(buildingName);
                
                String LevelName=table.getValueAt(selectedRow, 6).toString();
                	String GetLevel=(String)comboBox_4.getSelectedItem();
                	comboBox_4.setSelectedItem(LevelName);
                	

                	
                
                	
                //comboBoxFacultyName.setSelectedItem(table_1.getValueAt(selectedRow, 2).toString());
                	spinner.setValue((Double)table.getValueAt(selectedRow,8));	
                   	spinner_2.setValue((Double)table.getValueAt(selectedRow,9));	
                   	spinner_1.setValue((Double)table.getValueAt(selectedRow,10));	
                   	spinner_1_3.setValue((Double)table.getValueAt(selectedRow,11));	
                   	spinner_1_1.setValue((Double)table.getValueAt(selectedRow,12));	
                   	spinner_1_1_1.setValue((Double)table.getValueAt(selectedRow,13));	
                   	spinner_1_2.setValue((Double)table.getValueAt(selectedRow,14));	
                   	spinner_1_2_1.setValue((Double)table.getValueAt(selectedRow,15));	

                	spinner_3.setValue((Double)table.getValueAt(selectedRow,16));	
                   	spinner_2_1.setValue((Double)table.getValueAt(selectedRow,17));	
                   	spinner_1_4.setValue((Double)table.getValueAt(selectedRow,18));	
                   	spinner_1_3_1.setValue((Double)table.getValueAt(selectedRow,19));	
                   	spinner_1_1_2.setValue((Double)table.getValueAt(selectedRow,20));	
                   	spinner_1_1_1_1.setValue((Double)table.getValueAt(selectedRow,21));	

			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				//
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Emp_ID", "LecturerName", "faculty", "Department", "center", "building", "level", "rank", "mondayfrom", "mondayto","Tuesdayfrom","Tuesdayto","Wednesdayfrom","Wednesdayto","Thursdayfrom","Thursdayto","Fridayfrom","Fridayto","Saturdayfrom","Saturdayto","Sundayfrom","Sundayto"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		table.getColumnModel().getColumn(1).setPreferredWidth(168);
		table.getColumnModel().getColumn(2).setPreferredWidth(81);
		table.getColumnModel().getColumn(3).setPreferredWidth(66);
		table.getColumnModel().getColumn(5).setPreferredWidth(27);
		table.getColumnModel().getColumn(6).setPreferredWidth(88);
		table.getColumnModel().getColumn(7).setPreferredWidth(88);
		table.getColumnModel().getColumn(8).setPreferredWidth(88);
		table.getColumnModel().getColumn(9).setPreferredWidth(88);
		
		scrollPane.setViewportView(table);
		
		
		
		
		////////////
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DBConnection.connect();
					
					String query="select Emp_ID,LecturerName, faculty, Department, center, building, level, rank,mondayfrom,mondayto,Tuesdayfrom,Tuesdayto,Wednesdayfrom,Wednesdayto,Thursdayfrom,Thursdayto,Fridayfrom,Fridayto,Saturdayfrom,Saturdayto,Sundayfrom,Sundayto from Lecturers ";

					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBackground(Color.GRAY);
		btnRefresh.setBounds(785, 231, 105, 35);
		frame.getContentPane().add(btnRefresh);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.GRAY);
		panel_2_1.setBounds(0, 643, 174, 53);
		frame.getContentPane().add(panel_2_1);
		
		///////
		////////
		//////////
	
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		scrollPane_1.setBounds(272, 272, 1028, 94);
		frame.getContentPane().add(scrollPane_1);
	

		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			
				
				 int selectedRow=table.getSelectedRow();
					
					
					//textField.setText(table.getValueAt(selectedRow, 1).toString());
	                textField.setText(table_1.getValueAt(selectedRow,0).toString());
	                
	                
	                String checkdaymon=table_1.getValueAt(selectedRow, 1).toString();
					String checkdaytues=table_1.getValueAt(selectedRow, 2).toString();
					String checkdayWed=table_1.getValueAt(selectedRow, 3).toString();
					String checkdayThur=table_1.getValueAt(selectedRow, 4).toString();
					String checkdayFri=table_1.getValueAt(selectedRow, 5).toString();
					String checkdaySat=table_1.getValueAt(selectedRow, 6).toString();
					
					String checkdaySun=table_1.getValueAt(selectedRow, 7).toString();
					
					if(checkdaymon.equals("Monday")) {
						chckbxNewCheckBox.setSelected(true);
					}
					else{
						chckbxNewCheckBox.setSelected(false);
					}
					
					
					if(checkdaytues.equals("Tuesday")) {
						chckbxTuesday.setSelected(true);
					}
					else{
						chckbxTuesday.setSelected(false);
					}
					
					if(checkdayWed.equals("Wednesday")) {
						chckbxWednesday.setSelected(true);
					}
					else{
						chckbxWednesday.setSelected(false);
					}
					
					if(checkdayThur.equals("Thursday")) {
						chckbxThursday.setSelected(true);
					}
					else{
						chckbxThursday.setSelected(false);
					}
					
					
					if(checkdayFri.equals("Friday")) {
						chckbxFriday.setSelected(true);
					}
					else{
						chckbxFriday.setSelected(false);
					}
					
					if(checkdaySat.equals("Saturday")) {
						chckbxSaturday.setSelected(true);
					}
					else{
						chckbxSaturday.setSelected(false);
					}
					
					if(checkdaySun.equals("Sunday")) {
						chckbxSunday.setSelected(true);
					}
					else{
						chckbxSunday.setSelected(false);
					}
					
				
	      	
			}
		});
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"LecturerName", "Monday", "Tuesday", "Wednesday","Thursday", "Friday", "Saturday","Sunday"
				
			
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DBConnection.connect();
					//String query="select *from Lecturers ";
					//String query="select LecturerName,monday, faculty from Lecturers ";
					String query="select LecturerName,Monday, Tuesday, Wednesday,Thursday, Friday, Saturday,Sunday from Lecturers ";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
	
		////////////
		/////////
		
		JButton btnDelete = new JButton("<<Back");
		
		
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Dashboard dashboard=new Dashboard();
				Dashboard.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		btnDelete.setForeground(new Color(240, 248, 255));
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnDelete.setBackground(Color.BLACK);
		panel_2_1.add(btnDelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 579, 174, 66);
		frame.getContentPane().add(panel_1);
		
		JButton btnManageLsession = new JButton("ADD SESSION");
		
		
		
		
		
		
		
		
		
		btnManageLsession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Session addsession=new Add_Session();
				Add_Session.main(null);
				frame.setVisible(false);
				
			}
			
		});
	
		
		
		
		btnManageLsession.setForeground(Color.WHITE);
		btnManageLsession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageLsession.setBackground(Color.BLACK);
		btnManageLsession.setBounds(0, 476, 174, 35);
		frame.getContentPane().add(btnManageLsession);
		
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
		btnUpdateSession.setBounds(0, 449, 174, 29);
		frame.getContentPane().add(btnUpdateSession);
		
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
		btnAddSession.setBounds(0, 415, 174, 35);
		frame.getContentPane().add(btnAddSession);
		
		JButton btnManageLecturer = new JButton("MANAGE LECTURERS");
		
		
		
		btnManageLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Lecturer managelecture=new Manage_Lecturer();
				Manage_Lecturer.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		
		
		
		
		
		
		
		
		
		btnManageLecturer.setForeground(Color.RED);
		btnManageLecturer.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageLecturer.setBackground(Color.BLACK);
		btnManageLecturer.setBounds(0, 389, 174, 29);
		frame.getContentPane().add(btnManageLecturer);
		
		JButton btnAddLecturer = new JButton("ADD LECTURER");
		
		
		btnAddLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Lecturer addlecturer=new Add_Lecturer();
				Add_Lecturer.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		
		btnAddLecturer.setForeground(new Color(255, 255, 255));
		btnAddLecturer.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAddLecturer.setBackground(Color.BLACK);
		btnAddLecturer.setBounds(0, 355, 174, 35);
		frame.getContentPane().add(btnAddLecturer);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GRAY);
		panel_1_1.setBounds(0, 108, 174, 256);
		frame.getContentPane().add(panel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(1187, 579, 168, 20);
		frame.getContentPane().add(textField_2);
		
		JButton btnManageSession = new JButton("MANAGE SESSION");
		
		btnManageSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Sessions managesession=new Manage_Sessions();
				Manage_Sessions.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		btnManageSession.setForeground(Color.WHITE);
		btnManageSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageSession.setBackground(Color.BLACK);
		btnManageSession.setBounds(0, 510, 174, 35);
		frame.getContentPane().add(btnManageSession);
		
		JButton btnDelete_2 = new JButton("Delete");
		btnDelete_2.setBounds(916, 650, 132, 34);
		frame.getContentPane().add(btnDelete_2);
		btnDelete_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				

				

				
				
				try {
					if(textField_1.getText().equals("")){
						JOptionPane.showMessageDialog(null, "PLEASE SELECT A LECTURER");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Delete from Lecturers where Emp_ID='"+textField_1.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted");
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
				}
				
	
			
				
				
			
				
				
				
				
				 /*PreparedStatement pst;
		            DBC con = new DBC();
		            try{
		                pst = con.mkDataBase().prepareStatement("Delete from regadmins where first_name='"+foodName.getText()+"' and  NIC='"+foodID.getText().toString()+"'");
		                pst.setString(1,foodName.getText());
		                pst.setString(2,foodID.getText());
		                
						
		                pst.execute();
		                
		                
		                
		                JOptionPane.showMessageDialog(null,"Item Deleted ");
		                
		                
		            }catch(Exception ex){
		                System.out.println(ex);
		                System.out.println("EEEE");
		                JOptionPane.showMessageDialog(null, "Item not found");
		            }finally{
		                
		            }*/
			}
		});
		
		
		btnDelete_2.setForeground(Color.WHITE);
		btnDelete_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete_2.setBackground(Color.BLACK);
		
		JButton btnNewButton = new JButton("Generate Rank");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				

            	String ID=textField_1.getText();
            	String levelvalue=(String) comboBox_4.getSelectedItem();
            	
            	String p="Professor";               
				String A="AssistantProfessor";  
				String S ="Senior Lecturer(HG)";
				String Se="Senior Lecturer";   
				String Lec="Lecturer";
				String AL="Assistant Lecturer";
            	
            	
            	int i=0;
				if(levelvalue.contains(p)) {
				 i=1;
					
				}
				if(levelvalue.contains(A)) {
					i=2;
				}
				if(levelvalue.contains(S)) {
					i=3;
				}
				if(levelvalue.contains(Se)) {
					i=4;
				}
				if(levelvalue.contains(Lec)) {
					i=5;
				}
				if(levelvalue.contains(AL)) {
					i=6;
				}
				String combination=i+"."+ID;
				textField_2.setText(combination);
				
			
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(1140, 548, 222, 21);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(1118, 539, 259, 65);
		frame.getContentPane().add(panel);
		
		JButton btnManageSession_1 = new JButton("SEARCH SESSION");
		btnManageSession_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Search_Sessions searchsession=new Search_Sessions();
				Search_Sessions.main(null);
				frame.setVisible(false);
				
			}
			
		});
		btnManageSession_1.setForeground(Color.WHITE);
		btnManageSession_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageSession_1.setBackground(Color.BLACK);
		btnManageSession_1.setBounds(0, 541, 174, 40);
		frame.getContentPane().add(btnManageSession_1);
		
	
	}
}
