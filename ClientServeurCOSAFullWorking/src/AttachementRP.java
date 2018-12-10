
public class AttachementRP {
	private RoleFourni roleFourni;
	private PortRequis portRequis;
	

	public RoleFourni getRoleFourni() {
		return roleFourni;
	}

	public void setRoleFourni(RoleFourni roleFourni) {
		this.roleFourni = roleFourni;
	}

	public PortRequis getPortRequis() {
		return portRequis;
	}

	public void setPortRequis(PortRequis portRequis) {
		this.portRequis = portRequis;
	}

	public AttachementRP(RoleFourni portFourni, PortRequis portRequis) {
		super();
		this.roleFourni = portFourni;
		this.portRequis = portRequis;
	}
	
	public AttachementRP() {
		super();
		// TODO Auto-generated constructor stub
		this.roleFourni = new RoleFourni();
		this.portRequis = new PortRequis();
	}
	
	public void transmettre(String nom) {
		String messageATransmettre = roleFourni.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans AttachementRP " + nom);
			//portRequis.take(messageATransmettre);
			portRequis.setBuffer(messageATransmettre);
			System.out.println("Attachement " + nom + " sortie ");
			
		}
	}
}
