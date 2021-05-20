
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
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Advanced.Consecutive_sessions;
import DB.DbConnection;
import DBC.DBConnection;
import Home.Home;
import Lecturer.Add_Lecturer;
import Locations.ManageLocations;
import Session.Add_Session;
import Statistics.Statistics;
import Student.Add_StudentGroup;
import Subject.Add_Subjects;
import Tags.Add_Tags;
import Timetable.Lecturer;
import WorkingDays.AddWorkingdays;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import net.proteanit.sql.DbUtils;

public class SessionsRooms {
	private Image home_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/home.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image lec_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/lecturer.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image stu_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/student.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image sub_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/subject.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image session_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/session.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image tag_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/tags.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image location_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/location.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image st_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/statics.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image days_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/Wdays.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image time_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/time.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image adv_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/adv1.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image room_logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/room.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image logo = new ImageIcon(Add_StudentGroup.class.getResource("/images/pp.png")).getImage().getScaledInstance(1000,1000,Image.SCALE_SMOOTH);

	private JFrame rframe;
	private JTable rtable;
	private JTable rtable_1;
	private JTable rtable_2;
	private JComboBox session;
	private JComboBox sessionroom;
	private JTextArea generateroom;
	
	 public  void  loadSession(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from session ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("sessionSignature");
					session.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	 public void loadsessionRoom() {
		 try {
			 
			 Connection con = DBConnection.connect();
			 
			 String query ="select * from location";
			 PreparedStatement pst=con.prepareStatement(query);
			 ResultSet rs =pst.executeQuery();
			 
			 while(rs.next()) {
				 String room = rs.getString("roomName");
				 sessionroom.addItem(room);
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
					SessionsRooms window = new SessionsRooms();
					window.rframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SessionsRooms() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rframe = new JFrame();
		rframe.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		rframe.setBackground(Color.YELLOW);
		rframe.setResizable(false);
		rframe.setTitle("Time Table Management System");
		rframe.setSize(1400, 860);
		rframe.setBounds(0, 0, 1350, 700);
		rframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rframe.getContentPane().setLayout(null);
		rframe.setIconImage(logo);
		rframe.setLocationRelativeTo(null);
		rframe.setVisible(true);
		
		JPanel srpanel_2 = new JPanel();
		srpanel_2.setBackground(new Color(230, 230, 250));
		srpanel_2.setBounds(262, 108, 1082, 563);
		rframe.getContentPane().add(srpanel_2);
		srpanel_2.setLayout(null);
		
		JPanel srpanel_3 = new JPanel();
		srpanel_3.setBounds(138, 83, 756, 428);
		srpanel_2.add(srpanel_3);
		srpanel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Session");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(108, 79, 85, 13);
		srpanel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Room");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(462, 79, 78, 13);
		srpanel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Selected Session Room");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(108, 164, 134, 32);
		srpanel_3.add(lblNewLabel_2);
		
		generateroom = new JTextArea();
		generateroom.setBounds(252, 169, 455, 60);
		srpanel_3.add(generateroom);
		generateroom.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("SUBMIT");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				generateroom.setText(session.getSelectedItem().toString()+"\n"+"-"+sessionroom.getSelectedItem().toString());
				
				String sessionCode=session.getSelectedItem().toString();
				String room=sessionroom.getSelectedItem().toString();
				String sessionRoomCode = generateroom.getText();
				
				try {
					Connection con = DbConnection.connect();
					
					String query = "INSERT INTO roomSession values (null,'"+sessionCode+"','"+room+"','"+sessionRoomCode+"')";
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
		
		btnNewButton_4.setBackground(new Color(0, 139, 139));
		btnNewButton_4.setBounds(303, 254, 105, 32);
		srpanel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("CLEAR");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				generateroom.setText("");
				session.setSelectedIndex(0);
				sessionroom.setSelectedIndex(0);
				
			}
		});
		btnNewButton_5.setBackground(new Color(0, 139, 139));
		btnNewButton_5.setBounds(511, 254, 105, 32);
		srpanel_3.add(btnNewButton_5);
		
		session = new JComboBox();
		session.setModel(new DefaultComboBoxModel(new String[] {"Select Session---------------"}));
		session.setBounds(252, 76, 180, 21);
		srpanel_3.add(session);
		
		loadSession();
		
		sessionroom = new JComboBox();
		sessionroom.setModel(new DefaultComboBoxModel(new String[] {"Select Room-------------"}));
		sessionroom.setBounds(561, 76, 134, 21);
		srpanel_3.add(sessionroom);
		
		loadsessionRoom();
		
		JPanel srpanel_6 = new JPanel();
		srpanel_6.setBounds(0, 0, 1082, 49);
		srpanel_2.add(srpanel_6);
		srpanel_6.setLayout(null);
		
		
		JLabel lollblNewLabel_1 = new JLabel("Add Session Rooms");
		lollblNewLabel_1.setForeground(new Color(0, 128, 128));
		lollblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lollblNewLabel_1.setBounds(406, 13, 278, 31);
		srpanel_6.add(lollblNewLabel_1);
		
		//addsessionroom button
		JButton btnNewButton = new JButton("Add SessionRooms");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ManageSessionsRooms manage_ro = new ManageSessionsRooms();
				//manage_ro.main(null);
				rframe.dispose();
				new SessionsRooms();
				
			}
		});
		btnNewButton.setBounds(0, 274, 179, 38);
		rframe.getContentPane().add(btnNewButton);
		
		//add consession button
		JButton btnNewButton_2 = new JButton("Add ConsecutiveSessionsRooms");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ConsecutiveSessionRooms add_con = new ConsecutiveSessionRooms();
				//add_con.main(null);
				rframe.dispose();
				new ConsecutiveSessionRooms();
			
			}
		});
		btnNewButton_2.setBounds(0, 311, 251, 38);
		rframe.getContentPane().add(btnNewButton_2);
		
		
		
		
		
	}
}
