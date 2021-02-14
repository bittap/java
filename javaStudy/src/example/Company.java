package example;

public enum Company {
	���¿�(0001,1,1),
	���ѻ�(0002,10,5);
	
	private Integer cid;
	private String depart;
	private String position;
	
	private Company(Integer cid, Integer depart, Integer position) {
		this.cid = cid;
		
		if(depart >= 0 && depart <= 5) {
			this.depart = "����";
		}else if(depart >= 6 && depart <= 10){
			this.depart = "ȸ��";
		}else if(depart >= 11 && depart < 15) {
			this.depart = "�λ�";
		}else if(depart >= 16 && depart < 20) {
			this.depart = "��������";
		}
		
		if(position >= 0 && position <= 5) {
			this.position = "����";
		}else if(position >= 6 && position <= 10){
			this.position = "����";
		}else if(position >= 11 && position < 15) {
			this.position = "�븮";
		}else if(position >= 16 && position < 20) {
			this.position = "���";
		}
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	


	
}
