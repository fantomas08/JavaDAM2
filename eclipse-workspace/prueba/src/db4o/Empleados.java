package db4o;

public class Empleados {
	
	private int emp_no;
	private String apellido;
	private String oficio;
	private int dir;
	private String fecha_alt;
	private int salario;
	private int comision;
	private Departamentos dept_no;
	
	public Empleados(int emp_no, String apellido, String oficio, int dir, String fecha_alt, int salario, int comision,
			Departamentos dept_no) {
		this.emp_no = emp_no;
		this.apellido = apellido;
		this.oficio = oficio;
		this.dir = dir;
		this.fecha_alt = fecha_alt;
		this.salario = salario;
		this.comision = comision;
		this.dept_no = dept_no;
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public String getFecha_alt() {
		return fecha_alt;
	}

	public void setFecha_alt(String fecha_alt) {
		this.fecha_alt = fecha_alt;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public int getComision() {
		return comision;
	}

	public void setComision(int comision) {
		this.comision = comision;
	}

	public Departamentos getDept_no() {
		return dept_no;
	}

	public void setDept_no(Departamentos dept_no) {
		this.dept_no = dept_no;
	}

	@Override
	public String toString() {
		return "Empleados [emp_no=" + emp_no + ", apellido=" + apellido + ", oficio=" + oficio + ", dir=" + dir
				+ ", fecha_alt=" + fecha_alt + ", salario=" + salario + ", comision=" + comision + ", dept_no="
				+ dept_no + "]";
	}
}
