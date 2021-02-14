package api;

public class Student {
	private String studentNum;
	
	public Student(String studentNum) {
		this.studentNum = studentNum;
	}
	
	public String getStudentNum() {
		return this.studentNum;
	}
	
	@Override
	public int hashCode() {
		return studentNum.hashCode();
	}
	

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student student = (Student)obj;
			if(student.studentNum.equals(this.studentNum)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
