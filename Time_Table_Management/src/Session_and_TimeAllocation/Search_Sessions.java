// IT19210452
// W.M.S.T Wijekoon

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

import Advanced.Consecutive_sessions;
import DB.DbConnection;
import DBC.DBConnection;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

public class Search_Sessions {

	private JFrame SrchSesFrm;
	
	private JTable table;
	private JComboBox lecbox;
	private JComboBox subjBox;
	private JComboBox groupBox;
	
	
	public void refreshtable() {

		try {

			Connection con = DbConnection.connect();

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

				String query="select * from lecturers ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("lectureName");
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

				Connection con = DbConnection.connect();

				String query="select * from subjects ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("subName");
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

				Connection con = DbConnection.connect();

				String query="select * from StudentGroup ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("GroupID");
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

				Connection con = DbConnection.connect();

				String query="select * from StudentGroup ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("SubGroupID");
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

		SrchSesFrm.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		SrchSesFrm.setBackground(Color.YELLOW);
		SrchSesFrm.setTitle("Time Table Management System");
		SrchSesFrm.setLocationRelativeTo(null);
		SrchSesFrm.setIconImage(logo);
		SrchSesFrm.setVisible(true);
		//ManageSesFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SrchSesFrm.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(10, 41, 1344, 65);
		SrchSesFrm.getContentPane().add(panel);

		JLabel label = new JLabel(" Sessions");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		label.setBackground(new Color(32, 178, 170));
		label.setBounds(262, 18, 1082, 36);
		panel.add(label);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(32, 178, 170));
		separator.setBackground(new Color(0, 139, 139));
		separator.setBounds(262, 102, 1082, 9);
		SrchSesFrm.getContentPane().add(separator);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panel_2.setBounds(262, 107, 1082, 37);
		SrchSesFrm.getContentPane().add(panel_2);

		JLabel lblSearchSessions = new JLabel("Search Sessions");
		lblSearchSessions.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchSessions.setForeground(new Color(0, 128, 128));
		lblSearchSessions.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSearchSessions.setBounds(405, 0, 278, 31);
		panel_2.add(lblSearchSessions);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(230, 230, 250));
		panel_3.setBounds(272, 144, 1065, 527);
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
					Connection con = DbConnection.connect();

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
							 Connection con = DbConnection.connect();
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
							 Connection con = DbConnection.connect();
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
								 Connection con = DbConnection.connect();
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
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(78, 61, 180, 37);
		panel_3.add(label_1);

		JLabel label_2 = new JLabel("Search by Group/Sub Group :");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(444, 61, 215, 37);
		panel_3.add(label_2);

		JLabel label_3 = new JLabel("Search by Subject :");
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
		
		
		        //load data to dropdown lec1
				loadLecturer1();
		
				//load data to dropdown subject name
				loadSubjectName();
				//load data to dropdown group id
				loadGroup();//load data to dropdown Subgroup id
				loadSubGroup();
				
	}

}
