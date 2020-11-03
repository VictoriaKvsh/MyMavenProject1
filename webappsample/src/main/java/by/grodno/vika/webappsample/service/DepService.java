package by.grodno.vika.webappsample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;




public class DepService {

	private static final Logger LOG = Logger.getLogger(DepService.class);

	private static DepService service;

	private static final Object monitor = new Object();

	

	private DepService() {
	}

	public static DepService getService() {

		synchronized (monitor) {
			if (service == null) {
				service = new DepService();
			}
		}

		return service;
	}

	public List<Department> getCarList() {

		List<Department> result = new ArrayList<Department>();

		try (Connection conn = DBUtils.getConnetion(); Statement stmt = conn.createStatement()) {

			ResultSet executeQuery = stmt.executeQuery(SQL.SELECT_ALL_DEP);

			result = convertResult(executeQuery);

			executeQuery.close();

		} catch (Exception e) {
			LOG.error("Something went wrong", e);
		}

		return result;
	}

	private List<Department> convertResult(ResultSet executeQuery) throws SQLException {
		List<Department> result = new ArrayList<Department>();
		while (executeQuery.next()) {
			mapRowToDepartment(executeQuery, result);
		}
		return result;
	}

	private void mapRowToDepartment(ResultSet executeQuery, List<Department> result) throws SQLException {
		Department dep = new Department();
		dep.setId(executeQuery.getInt(1));
		dep.setDepName(executeQuery.getString(2));
		
		result.add(dep);
	}
	
	public void deleteDep(Integer id) {
		try (Connection conn = DBUtils.getConnetion();
				PreparedStatement stmt = conn.prepareStatement(SQL.DELETE_BY_ID_DEP)) {

			stmt.setInt(1, id);

			stmt.execute();

		} catch (Exception e) {
			LOG.error("Something went wrong...", e);
		}

	}

}
