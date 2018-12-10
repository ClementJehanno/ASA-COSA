public class AttachementPR{
	private PortFourni portFourni;
	private RoleRequis roleRequis;
	

	public PortFourni getPortFourni() {
		return portFourni;
	}

	public void setPortFourni(PortFourni portFourni) {
		this.portFourni = portFourni;
	}

	public RoleRequis getRoleRequis() {
		return roleRequis;
	}

	public void setRoleRequis(RoleRequis roleRequis) {
		this.roleRequis = roleRequis;
	}

	public AttachementPR(PortFourni portFourni, RoleRequis roleRequis) {
		super();
		this.portFourni = portFourni;
		this.roleRequis = roleRequis;
	}
	
	public AttachementPR() {
		super();
		// TODO Auto-generated constructor stub
		this.portFourni = new PortFourni();
		this.roleRequis = new RoleRequis();
	}
	
	public void transmettre(String nom) {
		String messageATransmettre = portFourni.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans AttachementRP " + nom);
			portFourni.resetBuffer();
			//roleRequis.take(messageATransmettre);
			roleRequis.setBuffer(messageATransmettre);
			System.out.println("Attachement "+ nom + " sortie");
		}
	}
}
