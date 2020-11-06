package by.grodno.vika.webappsample.service;

public class SQL {

	public static final String SELECT_ALL = "select * from public.testtable order by id";
	public static final String DELETE_BY_ID = "delete from public.testtable where id = ?";
	public static final String INSERT = "INSERT INTO public.testTable "
			+ "(empl_name, empl_last_name, salary, birthdate,  male, dept_num) VALUES (?,?,?,?,?,?)";
	public static final String UPDATE_BY_ID = "UPDATE public.testtable SET empl_name = ?, empl_last_name = ?, salary = ?,  birthdate = ?,  male = ?,  dept_num = ? where id = ?";
	public static final String SELECT_ALL_DEP = "select * from public.dept order by id";
	public static final String DELETE_BY_ID_DEP = "delete from public.dept where id = ?";
	public static final String INSERT_DEP = "INSERT INTO public.dept " + "(id, dept_name) VALUES (?,?)";

	public static final String SELECT_ALL_WITH_DEPT_NAME = "SELECT t.id , t.empl_name, t.empl_last_name, t.birthdate, t.male, t.salary, t.dept_num, d.dept_name\r\n"
			+ "FROM public.testtable t \r\n" + "LEFT JOIN public.dept d ON d.id = t.dept_num \r\n" + "ORDER BY t.id";
	
	
	public static final String SELECT_WITH_SAME_DEPT = "SELECT t.id , t.empl_name, t.empl_last_name, t.birthdate, t.male, t.salary\r\n" + 
	"   FROM public.testtable t\r\n" + 
	"   WHERE t.dept_num IN (?) VALUE (?)\r\n" + 
	"   ORDER BY t.id";
}
