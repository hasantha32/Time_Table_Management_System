



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
import Timetable.Lecturer;
import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;

import java.util.Date;
import javax.swing.JMenuBar;




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
				 
				 String query="select * from StudentGroup";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("GroupID");
					 
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
				 
				 String query="select * from StudentGroup";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("SubGroupID");
					 
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
		frame.setVisible(true);
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 37, 1344, 65);
		panel.setBackground(Color.GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel label_1 = new JLabel("Not Available Time");
		label_1.setBounds(594, 10, 270, 31);
		panel.add(label_1);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(245, 130, 1081, 508);
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
		selectlec.setBounds(214, 26, 218, 22);
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
		StartTime.setBounds(560, 111, 91, 23);
		panel_4.add(StartTime);
		
		JLabel EndTime = new JLabel("End Time");
		EndTime.setForeground(Color.WHITE);
		EndTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		EndTime.setBounds(560, 170, 57, 23);
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
		add.setBackground(new Color(0, 153, 153));
		
		
		//clear data from fields
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(885, 273, 141, 31);
		panel_4.add(btnClear);
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setEnabled(true);
		btnClear.setBackground(new Color(0, 153, 153));
		
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
		starttime.setBounds(855, 111, 43, 23);
		panel_4.add(starttime);
		
		//End time AM
		endtime = new JSpinner();
		String[] ampmString = {"am", "pm"};
		endtime = new JSpinner(
		 new SpinnerListModel(ampmString1));
		endtime.setFont(new Font("Tahoma", Font.BOLD, 13));
		endtime.setBounds(855, 170, 43, 23);
		panel_4.add(endtime);
		
		start = new JTextField();
		start.setFont(new Font("Tahoma", Font.BOLD, 13));
		start.setBounds(717, 111, 128, 22);
		panel_4.add(start);
		start.setColumns(10);
		
		end = new JTextField();
		end.setFont(new Font("Tahoma", Font.BOLD, 13));
		end.setBounds(717, 171, 128, 20);
		panel_4.add(end);
		
		
		//Add date
		JLabel date = new JLabel("Day");
		date.setForeground(Color.WHITE);
		date.setFont(new Font("Tahoma", Font.BOLD, 12));
		date.setBounds(560, 47, 74, 14);
		panel_4.add(date);
		
		 day = new JSpinner();
		String[] dayString = {"1.Monday", "2.Tuesday","3.Wednesday","4.Thursday","5.Friday","6.Saturday","7.Sunday"};//edited
		day = new JSpinner(
		new SpinnerListModel(dayString));
		day.setFont(new Font("Tahoma", Font.BOLD, 13));
		day.setBounds(717, 43, 182, 23);
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
		sessionsign.setBounds(214, 83, 218, 23);
		panel_4.add(sessionsign);
		fillsign();
		
		JLabel lblNewLabel = new JLabel("Select Room");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(28, 241, 113, 14);
		panel_4.add(lblNewLabel);
		selectroom = new JComboBox();
		selectroom.setFont(new Font("Tahoma", Font.BOLD, 13));
		selectroom.setBounds(214, 239, 218, 23);
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
		selectgroup.setBounds(214, 134, 218, 23);
		panel_4.add(selectgroup);
		selectgroup.setModel(new DefaultComboBoxModel(new String[] {""}));
		fillgroups();

	
	
		//select sub group
		 selectsubgroup = new JComboBox();
		 selectsubgroup.setFont(new Font("Tahoma", Font.BOLD, 13));
		 selectsubgroup.setBounds(214, 184, 218, 23);
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
		delete.setBackground(new Color(0, 153, 153));
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
		btnUpdate.setBackground(new Color(0, 153, 153));
		btnUpdate.setBounds(319, 467, 141, 31);
		panel_3.add(btnUpdate);
		
		//conseccutive sessions button
		JButton btnNewButton_2_1 = new JButton("Conseccutive Sessions");
		btnNewButton_2_1.setBounds(0, 251, 268, 37);
		frame.getContentPane().add(btnNewButton_2_1);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		//parallel sessions button
		JButton btnNewButton_2_1_1 = new JButton("Parallel Sessions");
		btnNewButton_2_1_1.setBounds(0, 286, 275, 37);
		frame.getContentPane().add(btnNewButton_2_1_1);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		//non overlapping session button
		JButton btnNewButton_2_1_2 = new JButton("Non Overlapping Sessions");
		btnNewButton_2_1_2.setBounds(0, 323, 275, 37);
		frame.getContentPane().add(btnNewButton_2_1_2);
		btnNewButton_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		JButton button = new JButton("Not available time");
		button.setBounds(0, 358, 263, 37);
		frame.getContentPane().add(button);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 0, 1344, 37);
		frame.getContentPane().add(menuBar);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				frame.dispose();
				new Not_Available_Time();
				
			}
		});
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		
				frame.dispose();
				new Non_overlappingSessions();
			}
		});
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				new Parallel_sessions();
				
			}
		});
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				new Consecutive_sessions();
				
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
