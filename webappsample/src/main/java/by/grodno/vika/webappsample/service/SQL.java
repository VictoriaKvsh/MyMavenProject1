package by.grodno.vika.webappsample.service;

public class SQL {

	public static final String SELECT_ALL = "select * from public.testtable order by id";
	public static final String DELETE_BY_ID = "delete from public.testtable where id = ?";
	public static final String INSERT = "INSERT INTO public.testTable "
			+ "(empl_name, empl_last_name, salary, birthdate,  male) VALUES (?,?,?,?,?)";
	public static final String UPDATE_BY_ID = "UPDATE public.testtable SET empl_name = ?, empl_last_name = ?, salary = ?,  birthdate = ?,  male = ? where id = ?";
	public static final String SELECT_ALL_DEP = "select * from public.dept order by id";
}
