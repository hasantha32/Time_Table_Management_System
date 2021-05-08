package Session_and_TimeAllocation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import DBC.DBConnection;
import Home.Dashboard;
import Home.StartUp;
import Leactures_and_Subjects.Add_Lecturer;
import Leactures_and_Subjects.Add_Subjects;
import Leactures_and_Subjects.Manage_Lecturer;
import Leactures_and_Subjects.Manage_Subjects;
import Location_and_Statistics.Add_Locations;
import Location_and_Statistics.Add_Locations_Sessions;
import Location_and_Statistics.Manage_Locations;
import Location_and_Statistics.Visualizing_static;
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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.DropMode;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Add_Session {

	private JFrame frame;
	private JComboBox comboBoxLec1,comboBox_1,comboBox_2,comboBox_3;

	/**
	 * Launch the application.
	 */
	PreparedStatement pst=null;
	ResultSet rs = null;
	JSpinner spinner,spinner_1,spinner_1_1,spinner_2;
	JComboBox comboBox_1_1_1;
	private JTextField txtAddSession;
	private JTextField txtTimeTableManagement;
	public static void main(String[] args) {
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Session window = new Add_Session();
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
	public void fillcombobox() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Lecturers";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("LecturerName");
				comboBoxLec1.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void fillcombobox2() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Lecturers";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("LecturerName");
				comboBox_1.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	public void fillcombobox3() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from SUbjects";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("SubjectName");
				comboBox_1_1_1.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public Add_Session() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(30, 30, 970, 675);
		//100,100, 960, 635
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtAddSession = new JTextField();
		txtAddSession.setBounds(0, 84, 956, 29);
		frame.getContentPane().add(txtAddSession);
		txtAddSession.setText("                                                                   ADD SESSION");
		txtAddSession.setForeground(Color.RED);
		txtAddSession.setFont(new Font("Arial Black", Font.BOLD, 19));
		txtAddSession.setEditable(false);
		txtAddSession.setColumns(10);
		txtAddSession.setBackground(Color.BLACK);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(0, 114, 174, 134);
		frame.getContentPane().add(panel_1_1);
		panel_1_1.setBackground(Color.GRAY);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setLayout(null);
		panel_3.setBounds(184, 123, 762, 433);
		frame.getContentPane().add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Select Lecturer 1");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 87, 160, 36);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Select Lecturer 2(Optional)");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 133, 232, 36);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Select Tag");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(484, 87, 72, 36);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Student Group");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 225, 160, 36);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("No.of.Students");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setBounds(10, 271, 160, 43);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Duration");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_8.setBounds(437, 235, 160, 43);
		panel_3.add(lblNewLabel_8);
		
	    comboBoxLec1 = new JComboBox();

	    comboBoxLec1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBoxLec1.setBackground(Color.WHITE);
		comboBoxLec1.setBounds(211, 87, 217, 29);
		panel_3.add(comboBoxLec1);
		
		 comboBox_1 = new JComboBox();
	
		 comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(211, 135, 217, 29);
		panel_3.add(comboBox_1);
		
		 comboBox_2 = new JComboBox();
		 comboBox_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Tutorials", "Labs", "Lecturers"}));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(560, 90, 191, 29);
		panel_3.add(comboBox_2);
		
		 comboBox_3 = new JComboBox();
		 comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"12.1", "12.2", "13.1", "13.2", "14.1", "14.2"}));
		 comboBox_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(171, 236, 232, 29);
		panel_3.add(comboBox_3);
		
		JLabel lblNewLabel_7 = new JLabel("Start Time");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBounds(10, 324, 142, 35);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("End Time");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_9.setBounds(10, 372, 130, 53);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("Subject Name");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_11.setBounds(437, 300, 142, 29);
		panel_3.add(lblNewLabel_11);
		
	    spinner = new JSpinner();
		spinner.setFont(new Font("Times New Roman", Font.BOLD, 16));
		spinner.setModel(new SpinnerNumberModel(new Float(1), new Float(1), new Float(5), new Float(1)));
		spinner.setForeground(Color.BLACK);
		spinner.setBackground(Color.LIGHT_GRAY);
		spinner.setBounds(554, 248, 202, 29);
		panel_3.add(spinner);
		
		 spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		spinner_1.setModel(new SpinnerDateModel(new Date(1615141800000L), new Date(1615141800000L), null, Calendar.HOUR));
		spinner_1.setBounds(171, 334, 232, 29);
		panel_3.add(spinner_1);
		
		 spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerDateModel(new Date(1615141800000L), null, null, Calendar.HOUR));
		spinner_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		spinner_1_1.setBounds(171, 381, 232, 29);
		panel_3.add(spinner_1_1);
		
		 spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 400, 1));
		spinner_2.setForeground(Color.BLACK);
		spinner_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		spinner_2.setBackground(Color.WHITE);
		spinner_2.setBounds(171, 289, 232, 29);
		panel_3.add(spinner_2);
		
		 comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		comboBox_1_1_1.setBackground(Color.WHITE);
		comboBox_1_1_1.setBounds(554, 300, 202, 29);
		panel_3.add(comboBox_1_1_1);
		
		txtTimeTableManagement = new JTextField();
		txtTimeTableManagement.setBounds(0, 0, 956, 87);
		frame.getContentPane().add(txtTimeTableManagement);
		txtTimeTableManagement.setText("                                              Time Table Management System");
		txtTimeTableManagement.setForeground(Color.WHITE);
		txtTimeTableManagement.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtTimeTableManagement.setEditable(false);
		txtTimeTableManagement.setColumns(10);
		txtTimeTableManagement.setBackground(Color.GRAY);
		
		JButton btnAddLecturer = new JButton("ADD LECTURER");

		btnAddLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Lecturer addlecture=new Add_Lecturer();
				Add_Lecturer.main(null);
				frame.setVisible(false);
				
			}
			
		});
		btnAddLecturer.setForeground(Color.WHITE);
		btnAddLecturer.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAddLecturer.setBackground(Color.BLACK);
		btnAddLecturer.setBounds(0, 247, 174, 35);
		frame.getContentPane().add(btnAddLecturer);
		
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
		btnManageLecturer.setBounds(0, 281, 174, 29);
		frame.getContentPane().add(btnManageLecturer);
		
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
		btnAddSession.setBounds(0, 307, 174, 35);
		frame.getContentPane().add(btnAddSession);
		
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
		btnUpdateSession.setBounds(0, 341, 174, 29);
		frame.getContentPane().add(btnUpdateSession);
		
		JButton btnManageLsession = new JButton("ADD SESSION");
		btnManageLsession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Session addsession=new Add_Session();
				Add_Session.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		
		btnManageLsession.setForeground(Color.RED);
		btnManageLsession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageLsession.setBackground(Color.BLACK);
		btnManageLsession.setBounds(0, 368, 174, 35);
		frame.getContentPane().add(btnManageLsession);
		
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
		btnManageSession.setBounds(0, 401, 174, 35);
		frame.getContentPane().add(btnManageSession);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 433, 174, 144);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 573, 174, 38);
		frame.getContentPane().add(panel_2);
		
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
		panel_2.add(btnDelete);
		
		JButton btnNewButton_13 = new JButton("Submit");
		btnNewButton_13.setBounds(381, 567, 160, 33);
		frame.getContentPane().add(btnNewButton_13);
		btnNewButton_13.setForeground(Color.WHITE);
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				
				
				
				try {
					
					
					if(comboBoxLec1.getSelectedItem().equals("")||comboBox_1.getSelectedItem().equals("") ||comboBox_2.getSelectedItem().equals("")||comboBox_3.getSelectedItem().equals("")||comboBox_1_1_1.getSelectedItem().equals("")||spinner_1.getValue().equals("")||spinner_2.getValue().equals("")||spinner.getValue().equals("")||spinner_1_1.getValue().equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the form");
						
						 
							
						
					}else if(comboBoxLec1.getSelectedItem().toString().equals(comboBox_1.getSelectedItem().toString())){
						JOptionPane.showMessageDialog(null, "Select a different lecturer for lecturer 2");
					
					}else{
						
						Connection connec = DBConnection.connect();
						
						/*String checkID= "select Emp_ID from Lecturers";
						PreparedStatement pstID = conn.prepareStatement(checkID);
						rs=pstID.executeQuery();
						while(rs.next()) {
							String id = rs.getString("Emp_ID");
						if(LecturerID.getText().equals(id)) {
							System.out.println("The Lecturer id has already exist! Please choose a different id.");
							JOptionPane.showMessageDialog(null, "The Lecturer id has already exist! Please choose a different id.");
						}*/
					
					//String sq="SELECT Emp_ID from Lecturers";
					//java.sql.Statement state = connec.createStatement();
	                //int x = state.executeUpdate(sq);
	                //if (x == 0) {
	                 //   JOptionPane.showMessageDialog(null, "This is alredy exist");
	                //}
					//else {
							
							
							String Lecturer1=comboBoxLec1.getSelectedItem().toString();
							String Lecturer2=comboBox_1.getSelectedItem().toString();
							String Tag=comboBox_2.getSelectedItem().toString();
							String Group=comboBox_3.getSelectedItem().toString();
							//String subjectcode=comboBox_1_1.getSelectedItem().toString();
							String subjectname=comboBox_1_1_1.getSelectedItem().toString();
							String numberofstudents=spinner_2.getValue().toString();
							String duration=spinner.getValue().toString();
							String starttime=spinner_1.getValue().toString();
							String endtime=spinner_1_1.getValue().toString();
							
				               //String spinner=spinner;
				               //String value =spinner.getValue().toString();
				               
							String msg = "" + subjectname;
			                msg += " \n";
			                
			             //System.out.println(value);
							
							

		                	Connection con = DBConnection.connect();

		                    String query = "INSERT INTO Sessions values(null,'" + Lecturer1 + "','" + Lecturer2 + "','" + Tag + "','" +
		                    		Group + "','" + numberofstudents + "','" + starttime + "','"+ endtime +"','"+ duration +"','"+ subjectname +"')";

		                    java.sql.Statement sta = con.createStatement();
		                    int xx = sta.executeUpdate(query);
		                    /*if (xx == 0) {
		                        JOptionPane.showMessageDialog(null, "This is alredy exist");
		                    } else {
		                        JOptionPane.showMessageDialog(null,
		                            "Welcome, " + msg + "Your account is sucessfully created");
		                    }
		                    String checkID= "select Emp_ID from Lecturers";
							PreparedStatement pstID = conn.prepareStatement(checkID);
							rs=pstID.executeQuery();
							while(rs.next()) {
								String id = rs.getString("Emp_ID");
								if(LecturerID.getText().equals(id))
								JOptionPane.showMessageDialog(null, "This is alredy exist");
								
							}*/
							
		                    
		                    
		                    
		                    JOptionPane.showMessageDialog(null,
		                            "Subject, " + msg + " is sucessfully added");
		                    
		                    con.close();
		                    comboBoxLec1.setSelectedItem(null);
		    				comboBox_1.setSelectedItem(null);
		    				comboBox_2.setSelectedItem(null);
		    				comboBox_3.setSelectedItem(null);
		    				//comboBox_1_1.setSelectedItem(null);
		    				comboBox_1_1_1.setSelectedItem(null);
		                    
		                   
		                
							
							
							
							
							
							
						
					}
					}
					
					
				catch(Exception w){
					JOptionPane.showMessageDialog(null, w );
					
				}
				
				finally{
	                try{
	                     pst.close();
	                            rs.close();
	                }catch(Exception r){
	                    
	                }
	            }
					
					
				
				
				
			}
		});
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_13.setBackground(Color.BLACK);
		
		JButton btnNewButton_14 = new JButton("Clear");
		btnNewButton_14.setBounds(635, 567, 160, 33);
		frame.getContentPane().add(btnNewButton_14);
		btnNewButton_14.setForeground(Color.WHITE);
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBoxLec1.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				comboBox_2.setSelectedItem(null);
				comboBox_3.setSelectedItem(null);
				//comboBox_1_1.setSelectedItem(null);
				comboBox_1_1_1.setSelectedItem(null);
				//textField.setText(null);comboBox_2
			
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.BLACK);
		
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
				
				Manage_Workingdays_Hours manage_Workingdays_Hours=new Manage_Workingdays_Hours();
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
		
		
		
		
		
		
		
		
		//////////////////////////
		
		
		fillcombobox();
		fillcombobox2();
		fillcombobox3();
		//fillcombobox4();
		
	}
}
