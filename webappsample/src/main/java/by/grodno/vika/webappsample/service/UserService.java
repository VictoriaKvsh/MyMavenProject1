package by.grodno.vika.webappsample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.apache.log4j.Logger;

import by.grodno.vika.webappsample.filter.LoggingFilter;

public class UserService {

	private static UserService userService;

	public static final Logger LOGGER = Logger.getLogger(UserService.class);

	private UserService() {
	}

	public static UserService getService() {
		if (userService == null) {
			userService = new UserService();
		}
		return userService;
	}

	public List<User> getUsers() {
		List<User> result = new ArrayList<User>();
		try (Connection conn = DBUtils.getConnetion(); Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(SQL.SELECT_ALL_WITH_DEPT_NAME);

			while (rs.next()) {

				User user = mapRawToUser(rs);

				result.add(user);
			}

			rs.close();
		} catch (Exception e) {
			LOGGER.error("Something went wrong here...", e);
		}

		return result;
	}

	private User mapRawToUser(ResultSet rs) throws SQLException {
		Integer id = rs.getInt(1);
		String fName = rs.getString(2);
		String lName = rs.getString(3);
		String dept = rs.getString(8);
		Integer deptNum = rs.getInt(7);
		Double sal = rs.getDouble(6);
		Date date = rs.getTimestamp(4);
		Boolean male = rs.getBoolean(5);
		User user = new User(id, fName, lName, date, male);
		user.setSalary(sal);
		user.setDepartmentName(dept);
		user.setDepartment(deptNum);
		return user;
	};

	
	
	
	public void deleteUser(Integer number) {
		try (Connection conn = DBUtils.getConnetion();
				PreparedStatement stmt = conn.prepareStatement(SQL.DELETE_BY_ID)) {

			stmt.setInt(1, number);

			stmt.execute();

		} catch (Exception e) {
			LOGGER.error("Something went wrong...", e);
		}

	};

	public void addUser(User user) {
		try (Connection conn = DBUtils.getConnetion();
				PreparedStatement stmt = conn.prepareStatement(SQL.INSERT, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setDouble(3, user.getSalary());
			stmt.setTimestamp(4,
					Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(user.getBirthdate())));
			stmt.setBoolean(5, user.isMale());
			stmt.setInt(6, user.getDepartment());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			generatedKeys.next();
			LOGGER.info("User created with id: " + generatedKeys.getLong(1));

		} catch (Exception e) {
			LOGGER.error("Something went wrong...", e);
		}

	}

	public void updateUser(String firstName, String lastName, Boolean male, Date birthdate, Double salary, Integer department, Integer id) {
		try (Connection conn = DBUtils.getConnetion();
				PreparedStatement stmt = conn.prepareStatement(SQL.UPDATE_BY_ID)) {

			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setDouble(3, salary);
		    stmt.setTimestamp(4,Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").format(birthdate)));
			stmt.setBoolean(5, male);
			stmt.setInt(6, department);
			stmt.setInt(7, id);
			
			stmt.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Something went wrong...", e);
		}
	}
	
	
	public List<User> getUsersWithDept (Integer depNum) {
		List<User> result = new ArrayList<User>();
		try (Connection conn = DBUtils.getConnetion(); Statement stmt = conn.createStatement()) {
			
			String sql = "SELECT t.id , t.empl_name, t.empl_last_name, t.birthdate, t.male, t.salary\r\n" + 
					"   FROM public.testtable t\r\n" + 
					"   WHERE t.dept_num IN ("+depNum+") \r\n" + 
					"   ORDER BY t.id";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String fName = rs.getString(2);
				String lName = rs.getString(3);
				Double sal = rs.getDouble(6);
				Date date = rs.getTimestamp(4);
				Boolean male = rs.getBoolean(5);
				User user = new User(id, fName, lName, date, male);
				user.setSalary(sal);	
				
				result.add(user);
			}

			rs.close();
		} catch (Exception e) {
			LOGGER.error("Something went wrong here...", e);
		}

		return result;
	}

}