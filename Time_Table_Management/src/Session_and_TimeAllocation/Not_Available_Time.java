



package Session_and_TimeAllocation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

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

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;

import java.util.Date;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.MatteBorder;




public class Not_Available_Time {


	
	public JFrame frame;
	private JTable table;
	private JTextField id;
	private JComboBox selectlec;
	private JComboBox sessionsign;
	private JTextField textField;
	private JSpinner starttime;
	private JSpinner endtime;
	private JTextField start;
	private JTextField end;
	private JSpinner day;
	private JComboBox selectsubgroup ;
	private JComboBox selectroom ;
	private JComboBox selectgroup ;
	private JTextField textField_1;
	
	//refresh all the data
	
public void refreshtable() {
		
		try {
			
			Connection con = DBConnection.connect();
			
			String query="SELECT timeID as TID,selectLec as Lecturer,selectGroup AS Main,selectSubGroup AS SUB,selectRoom as Room,sessionSign as SessionSignature,Date as Days,startTime as Start,start as Time,endTime as End, end as Time FROM notavailableTime";
			//String query="select *  from notavailableTime ";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(1);
			columnModel.getColumn(1).setPreferredWidth(100);
			columnModel.getColumn(2).setPreferredWidth(50);
			columnModel.getColumn(3).setPreferredWidth(50);
			columnModel.getColumn(4).setPreferredWidth(40);
			columnModel.getColumn(5).setPreferredWidth(350);
			columnModel.getColumn(6).setPreferredWidth(50);
			columnModel.getColumn(7).setPreferredWidth(1);
			columnModel.getColumn(8).setPreferredWidth(1);
			columnModel.getColumn(9).setPreferredWidth(1);
			columnModel.getColumn(10).setPreferredWidth(1);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	//fill select lecture field
	  public void filllecture() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from session";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("lec1");
					 
					 selectlec.addItem(name);
				
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	  
	 
	  
	  
	  //fill Group ID field
	  public void fillgroups() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from Student_Groups";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("G_ID");
					 
					 selectgroup.addItem(name);
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	  
	  
	  
	  
	  
	  //select student Group
	  public void fillsubgroup() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from Student_Groups";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("Sub_G_ID");
					 
					 selectsubgroup .addItem(name);
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	  
	  //fill session signature field
	  public void fillsign() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from roomSession";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("sessionRoomCode");
					 
					 sessionsign.addItem(name);
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	  //fill select room
	  public void fillroom() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from location";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("roomName");
					 
					 selectroom.addItem(name);
					 
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
					Not_Available_Time window = new Not_Available_Time();
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
	public Not_Available_Time() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBackground(Color.YELLOW);
		frame.setResizable(false);
		frame.setTitle("Time Table Management System");
		frame.setSize(1350, 728);
		frame.setBounds(0, 0, 1350, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		//frame.setVisible(true);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(245, 145, 1081, 508);
		frame.getContentPane().add(panel_3);
		
		
		
		//not available time button
		JLabel lblNewLabel_1_1 = new JLabel("Not Available Time");


		
		
		JPanel panel_4 = new JPanel();
		panel_4.setForeground(Color.WHITE);
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(22, 10, 1036, 326);
		panel_3.add(panel_4);
	
		//select lecture 
		JLabel lblNewLabel_2 = new JLabel("Select Lecturer");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(28, 26, 149, 23);
		panel_4.add(lblNewLabel_2);
		
		selectlec = new JComboBox();
		selectlec.setFont(new Font("Tahoma", Font.BOLD, 13));
		selectlec.setBounds(187, 26, 245, 22);
		selectlec.setModel(new DefaultComboBoxModel(new String[] {""}));
		panel_4.add(selectlec);
		
		filllecture();
	
		
		JLabel lblSelectSubGroup = new JLabel("Selected sub Group");
		lblSelectSubGroup.setForeground(Color.WHITE);
		lblSelectSubGroup.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelectSubGroup.setBounds(28, 182, 149, 23);
		panel_4.add(lblSelectSubGroup);
		
		
		JLabel StartTime = new JLabel("Sart Time");
		StartTime.setForeground(Color.WHITE);
		StartTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		StartTime.setBounds(637, 187, 91, 23);
		panel_4.add(StartTime);
		
		JLabel EndTime = new JLabel("End Time");
		EndTime.setForeground(Color.WHITE);
		EndTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		EndTime.setBounds(637, 232, 57, 23);
		panel_4.add(EndTime);
		
		
		//add data
		JButton add = new JButton("ADD");
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String selectLec = selectlec.getSelectedItem().toString();
				String selectGroup = selectgroup.getSelectedItem().toString();
				String selectSubGroup = selectsubgroup.getSelectedItem().toString();
				String selectRoom = selectroom.getSelectedItem().toString();
				String sessionSign = sessionsign.getSelectedItem().toString();
				String Date = day.getValue().toString();
				String startTime = start.getText();
				String endTime = end.getText();
				String startAMPM = starttime.getValue().toString();
				String endAMPM = endtime.getValue().toString();
                
				if(starttime.getValue().equals(0)) {
					JOptionPane.showMessageDialog(null, "Please Select start Time!!!");
				}
				else if(endtime.getValue().equals(0)) {
					JOptionPane.showMessageDialog(null, "Please Select start Time!!!");
				}
				
				
				else {

					try {
							
						Connection con = DBConnection.connect();
						
				
						String query = "INSERT INTO notavailableTime values(null,'"+ selectLec +"','"+ selectGroup + "','"+ selectSubGroup + 
								"','"+ selectRoom +"','"+ sessionSign +"','"+ Date +"','"+ startTime +"','"+ startAMPM +"','"+ endTime +"','"+ endAMPM +"')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) 
	                    {
	                    	JLabel label = new JLabel("This is alredy exist");
	    					label.setHorizontalAlignment(SwingConstants.CENTER);
	    					JOptionPane.showMessageDialog(null, label);
	                    } 
	                    else
	                    {
							JLabel label = new JLabel("Not Availabale Time Data Entered Successfully");
							label.setHorizontalAlignment(SwingConstants.CENTER);
							JOptionPane.showMessageDialog(null, label);


						

						}
	                    refreshtable();
						con.close();
						
					} catch (Exception exception) {
						System.out.println("Failed!!");

					}

				
				}
				
			}
		});
		add.setBounds(717, 273, 141, 31);
		panel_4.add(add);
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Tahoma", Font.BOLD, 14));
		add.setEnabled(true);
		add.setBackground(Color.BLACK);
		
		
		//clear data from fields
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(885, 273, 141, 31);
		panel_4.add(btnClear);
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setEnabled(true);
		btnClear.setBackground(Color.BLACK);
		
		id = new JTextField();
		id.setBackground(SystemColor.menu);
		id.setBounds(-21, 66, 7, 23);
		panel_4.add(id);
		
		//start time AM
		starttime = new JSpinner();
		String[] ampmString1 = {"am", "pm"};
		starttime = new JSpinner(
		 new SpinnerListModel(ampmString1));
		starttime.setFont(new Font("Tahoma", Font.BOLD, 13));
		starttime.setBounds(932, 187, 43, 23);
		panel_4.add(starttime);
		
		//End time AM
		endtime = new JSpinner();
		String[] ampmString = {"am", "pm"};
		endtime = new JSpinner(
		 new SpinnerListModel(ampmString1));
		endtime.setFont(new Font("Tahoma", Font.BOLD, 13));
		endtime.setBounds(932, 232, 43, 23);
		panel_4.add(endtime);
		
		start = new JTextField();
		start.setFont(new Font("Tahoma", Font.BOLD, 13));
		start.setBounds(794, 187, 128, 22);
		panel_4.add(start);
		start.setColumns(10);
		
		end = new JTextField();
		end.setFont(new Font("Tahoma", Font.BOLD, 13));
		end.setBounds(794, 233, 128, 20);
		panel_4.add(end);
		
		
		//Add date
		JLabel date = new JLabel("Day");
		date.setForeground(Color.WHITE);
		date.setFont(new Font("Tahoma", Font.BOLD, 12));
		date.setBounds(636, 145, 74, 14);
		panel_4.add(date);
		
		 day = new JSpinner();
		String[] dayString = {"1.Monday", "2.Tuesday","3.Wednesday","4.Thursday","5.Friday","6.Saturday","7.Sunday"};//edited
		day = new JSpinner(
		new SpinnerListModel(dayString));
		day.setFont(new Font("Tahoma", Font.BOLD, 13));
		day.setBounds(793, 141, 182, 23);
		panel_4.add(day);
		
		
		//Add session sign
		JLabel session = new JLabel("Session Signature");
		session.setForeground(Color.WHITE);
		session.setFont(new Font("Tahoma", Font.BOLD, 12));
		session.setBounds(28, 87, 113, 14);
		panel_4.add(session);
		sessionsign = new JComboBox();
		sessionsign.setFont(new Font("Tahoma", Font.BOLD, 13));
		sessionsign.setModel(new DefaultComboBoxModel(new String[] {""}));
		sessionsign.setBounds(187, 83, 698, 23);
		panel_4.add(sessionsign);
		fillsign();
		
		JLabel lblNewLabel = new JLabel("Select Room");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(28, 241, 113, 14);
		panel_4.add(lblNewLabel);
		selectroom = new JComboBox();
		selectroom.setFont(new Font("Tahoma", Font.BOLD, 13));
		selectroom.setBounds(187, 239, 245, 23);
		panel_4.add(selectroom);
		selectroom.setModel(new DefaultComboBoxModel(new String[] {""}));
		panel_4.add(selectroom);
		fillroom() ;
	

	
		//select group
		JLabel lblSelectGroup = new JLabel("Select Group");
		lblSelectGroup.setForeground(Color.WHITE);
		lblSelectGroup.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelectGroup.setBounds(28, 136, 137, 14);
		panel_4.add(lblSelectGroup);
		selectgroup = new JComboBox();
		selectgroup.setFont(new Font("Tahoma", Font.BOLD, 13));
		selectgroup.setBounds(187, 134, 245, 23);
		panel_4.add(selectgroup);
		selectgroup.setModel(new DefaultComboBoxModel(new String[] {""}));
		fillgroups();

	
	
		//select sub group
		 selectsubgroup = new JComboBox();
		 selectsubgroup.setFont(new Font("Tahoma", Font.BOLD, 13));
		 selectsubgroup.setBounds(187, 184, 245, 23);
		 panel_4.add( selectsubgroup);
			selectsubgroup.setModel(new DefaultComboBoxModel(new String[] {""}));
		 fillsubgroup();
		
	
		
		
		

	
	
	btnClear.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
				id.setText("");
				selectlec.setSelectedIndex(0);
				selectgroup.setSelectedIndex(0);
				selectsubgroup.setSelectedIndex(0);
				selectroom.setSelectedIndex(0);
				sessionsign.setSelectedIndex(0);
				day.setValue(null);
				start.setText("");
				end.setText("");
				starttime.setValue(null);
				endtime.setValue(null);
				
				
			}
		});
		
		

		//delete data
		JButton delete = new JButton("DELETE");
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					
					Connection con = DBConnection.connect();
					String query="Delete from notavailableTime where timeID='"+id.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.execute();
					
				
					  JOptionPane.showMessageDialog(null, "Data Deleted","Alert",JOptionPane.WARNING_MESSAGE);
				
					
					refreshtable();
					pst.close();
					
					}
					catch(Exception en) {
						en.printStackTrace();
						
					}
				
				
				
			}
		});
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		delete.setEnabled(true);
		delete.setBackground(Color.BLACK);
		delete.setBounds(597, 467, 141, 31);
		panel_3.add(delete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 333, 1036, 124);
		panel_3.add(scrollPane);
		
		
		//display data in the table
		table = new JTable();
		//table header
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(153,153,153));
		h.setForeground(Color.WHITE);
		h.setFont(new Font("Times New Roman", Font.BOLD, 17));
				
		table.addMouseListener(new MouseAdapter() {


		@Override
		public void mouseClicked(MouseEvent arg0) {

			int selectedRow=table.getSelectedRow();
		

			
			 	id.setText(table.getValueAt(selectedRow, 0).toString());

			
				String combo2 = table.getValueAt(selectedRow, 1).toString(); 
				for(int j=0
						;j<selectlec.getItemCount();j++) {

					if(selectlec.getItemAt(j).toString().equalsIgnoreCase(combo2)) {
						selectlec.setSelectedIndex(j); } }

				String combo3 = table.getValueAt(selectedRow, 2).toString(); 
				for(int j=0
						;j<selectgroup.getItemCount();j++) {

					if(selectgroup.getItemAt(j).toString().equalsIgnoreCase(combo3)) {
						selectgroup.setSelectedIndex(j); } }
				
				

				String combo4 = table.getValueAt(selectedRow, 3).toString(); 
				for(int j=0
						;j<selectsubgroup.getItemCount();j++) {

					if(selectsubgroup.getItemAt(j).toString().equalsIgnoreCase(combo4)) {
						selectsubgroup.setSelectedIndex(j); } }
				
				String combo5 = table.getValueAt(selectedRow, 4).toString(); 
				for(int j=0
						;j<selectroom.getItemCount();j++) {

					if(selectroom.getItemAt(j).toString().equalsIgnoreCase(combo5)) {
						selectroom.setSelectedIndex(j); } }
				
				String combo6 = table.getValueAt(selectedRow, 5).toString(); 
				for(int j=0
						;j<sessionsign.getItemCount();j++) {

					if(sessionsign.getItemAt(j).toString().equalsIgnoreCase(combo6)) {
						sessionsign.setSelectedIndex(j); } }
				
					day.setValue(table.getValueAt(selectedRow, 6).toString());
					start.setText(table.getValueAt(selectedRow, 7).toString());
					end.setText(table.getValueAt(selectedRow, 9).toString());//edited
					starttime.setValue(table.getValueAt(selectedRow, 8).toString());//edited
					endtime.setValue(table.getValueAt(selectedRow, 10).toString());
				  
				  
			
		}
	});
	
		scrollPane.setViewportView(table);
		
		try {
			
			
			Connection con = DBConnection.connect();
			 
			 
			//String query="SELECT timeID as TID, selectLec as Lecturer, selectGroup as Group, selectSubGroup as SubGroup, selectRoom as Room, sessionSign as Signature, Date as Day, startTime as Start, start as STime,endTime as End, end as ETime FROM notavailableTime ";
			String query="SELECT timeID as TID,selectLec as Lecturer,selectGroup AS Main,selectSubGroup AS SUB,selectRoom as Room,sessionSign as SessionSignature,Date as Days,startTime as Start,start as Time,endTime as End, end as Time FROM notavailableTime";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(1);
			columnModel.getColumn(1).setPreferredWidth(100);
			columnModel.getColumn(2).setPreferredWidth(50);
			columnModel.getColumn(3).setPreferredWidth(50);
			columnModel.getColumn(4).setPreferredWidth(40);
			columnModel.getColumn(5).setPreferredWidth(350);
			columnModel.getColumn(6).setPreferredWidth(50);
			columnModel.getColumn(7).setPreferredWidth(1);
			columnModel.getColumn(8).setPreferredWidth(1);
			columnModel.getColumn(9).setPreferredWidth(1);
			columnModel.getColumn(10).setPreferredWidth(1);
			
			
			refreshtable();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		scrollPane.setViewportView(table);
		

		
		
		//update button
		JButton btnUpdate = new JButton("UPDATE");
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				try {
					Connection con = DBConnection.connect();					
					String query="Update notavailableTime set selectLec='"+selectlec.getSelectedItem()+"',selectGroup='"+selectgroup.getSelectedItem()+ "',selectSubGroup='"
					+selectsubgroup.getSelectedItem()+"',selectRoom='"+selectroom.getSelectedItem()+"',sessionSign='"+sessionsign.getSelectedItem()+"',Date='"+day.getValue()+"',startTime='"+start.getText()+"',start='"+starttime.getValue()+"',endTime='"+end.getText()+"',end='"+endtime.getValue()+"'"
							+ " where timeID='"+id.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					
					JLabel label = new JLabel("Your Data Has been Updated");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, label);

					refreshtable();
					pst.close();
					
				}
				catch(Exception ea) {
					ea.printStackTrace();
				}
				
				
			}
		});
		
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setEnabled(true);
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setBounds(319, 467, 141, 31);
		panel_3.add(btnUpdate);
		
		//conseccutive sessions button
		JButton btnNewButton_2_1 = new JButton("Conseccutive Sessions");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SessionsANDnotAvailableTimeAllocationConsecutive addlecturer=new SessionsANDnotAvailableTimeAllocationConsecutive();
				SessionsANDnotAvailableTimeAllocationConsecutive.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		btnNewButton_2_1.setBackground(Color.BLACK);
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setBounds(0, 251, 245, 37);
		frame.getContentPane().add(btnNewButton_2_1);
		btnNewButton_2_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		
		
		//parallel sessions button
		JButton btnNewButton_2_1_1 = new JButton("Parallel Sessions");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SessionsANDnotAvailableTimeAllocationParallel addlecturer=new SessionsANDnotAvailableTimeAllocationParallel();
				SessionsANDnotAvailableTimeAllocationParallel.main(null);
				frame.setVisible(false);
				
			}
			
		});

		btnNewButton_2_1_1.setBackground(Color.BLACK);
		btnNewButton_2_1_1.setForeground(Color.WHITE);
		btnNewButton_2_1_1.setBounds(0, 286, 245, 37);
		frame.getContentPane().add(btnNewButton_2_1_1);
		btnNewButton_2_1_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		
		//non overlapping session button
		JButton btnNewButton_2_1_2 = new JButton("Non Overlapping Sessions");
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SessionsANDnotAvailableTimeAllocationNoneOverlaping addlecturer=new SessionsANDnotAvailableTimeAllocationNoneOverlaping();
				SessionsANDnotAvailableTimeAllocationNoneOverlaping.main(null);
				frame.setVisible(false);
				
			}
			
		});

		btnNewButton_2_1_2.setBackground(Color.BLACK);
		btnNewButton_2_1_2.setForeground(Color.WHITE);
		btnNewButton_2_1_2.setBounds(0, 323, 245, 37);
		frame.getContentPane().add(btnNewButton_2_1_2);
		btnNewButton_2_1_2.setFont(new Font("Arial Black", Font.BOLD, 11));
		JButton btnNotAvailableTime = new JButton("Not available time");
		btnNotAvailableTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Not_Available_Time addlecturer=new Not_Available_Time();
				Not_Available_Time.main(null);
				frame.setVisible(false);
				
			}
			
		});

		btnNotAvailableTime.setBackground(Color.BLACK);
		btnNotAvailableTime.setForeground(Color.RED);
		btnNotAvailableTime.setBounds(0, 358, 245, 37);
		frame.getContentPane().add(btnNotAvailableTime);
		btnNotAvailableTime.setFont(new Font("Arial Black", Font.BOLD, 11));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 0, 1344, 37);
		frame.getContentPane().add(menuBar);
		
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
		
		textField_1 = new JTextField();
		textField_1.setText("                                                                       Time Table Management System");
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.GRAY);
		textField_1.setBounds(0, 35, 1334, 74);
		frame.getContentPane().add(textField_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setForeground(Color.RED);
		panel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(0, 102, 1334, 42);
		frame.getContentPane().add(panel_5);
		
		JLabel lblNotAvailableTime = new JLabel("NOT AVAILABLE TIME");
		lblNotAvailableTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotAvailableTime.setForeground(Color.RED);
		lblNotAvailableTime.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblNotAvailableTime.setBounds(522, 10, 278, 31);
		panel_5.add(lblNotAvailableTime);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GRAY);
		panel_1_1.setBounds(0, 145, 245, 110);
		frame.getContentPane().add(panel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 393, 245, 220);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.GRAY);
		panel_2_1.setBounds(0, 609, 245, 54);
		frame.getContentPane().add(panel_2_1);
		
		JButton btnDelete = new JButton("<<Back");
		btnDelete.setForeground(new Color(240, 248, 255));
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnDelete.setBackground(Color.BLACK);
		panel_2_1.add(btnDelete);
		btnNotAvailableTime.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				frame.dispose();
				new Not_Available_Time();
				
			}
		});
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		
				frame.dispose();
				new SessionsANDnotAvailableTimeAllocationNoneOverlaping();
			}
		});
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				new SessionsANDnotAvailableTimeAllocationParallel();
				
			}
		});
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				new SessionsANDnotAvailableTimeAllocationConsecutive();
				
			}
		});
		
		
		/*refresh table
		JButton btnrefresh = new JButton("REFRESH");
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = DbConnection.connect();
					
					String query="select timeID AS TID,selectLec as Lecturer,selectGroup as Group,selectSubGroup as SubGroup,selectRoom as Room,sessionSign as SessionSignature,Date as Day,startTime as StartTime,start as AMPM,endTime as EndTime,end as AMPM from notavailableTime ";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		btnrefresh.setForeground(Color.WHITE);
		btnrefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnrefresh.setEnabled(true);
		btnrefresh.setBackground(new Color(0, 153, 153));
		btnrefresh.setBounds(744, 554, 141, 31);
		panel_3.add(btnrefresh);*/
	}
}
