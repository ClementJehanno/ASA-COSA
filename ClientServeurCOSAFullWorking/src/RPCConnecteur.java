
public class RPCConnecteur {
	private RoleRequis roleRequis; //fromClient
	private RoleFourni roleFourni; //toServer
	
	private RoleRequis fromServ;
	private RoleFourni toClient;

	public RoleRequis getRoleRequis() {
		return roleRequis;
	}

	public void setRoleRequis(RoleRequis roleRequis) {
		this.roleRequis = roleRequis;
	}

	public RoleFourni getRoleFourni() {
		return roleFourni;
	}

	public void setRoleFourni(RoleFourni roleFourni) {
		this.roleFourni = roleFourni;
	}
	
	public RoleRequis getRoleRequisfromServ()
	{
		return fromServ;
	}
	
	public RoleFourni getRoleFournitoClient()
	{
		return toClient;
	}

	public RPCConnecteur() {
		super();
		// TODO Auto-generated constructor stub
		this.roleRequis = new RoleRequis();
		this.roleFourni = new RoleFourni();
		this.fromServ = new RoleRequis();
		this.toClient = new RoleFourni();
	}
	
	public void transmettre() //client to serv
	{
		String messageATransmettre = roleRequis.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans RPCCo vers Serveur");
			roleRequis.resetBuffer();
			//roleFourni.take(messageATransmettre);
			roleFourni.setBuffer(messageATransmettre);
			System.out.println("RPCCo vers Serveur sortie");
		}
	}
	
	public void transmettreFromServToClient()
	{
		String messageATransmettre = fromServ.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans RPCCo vers Client");
			fromServ.resetBuffer();
			//roleFourni.take(messageATransmettre);
			toClient.setBuffer(messageATransmettre);
			System.out.println("RPCCo vers Client sortie");
		}
	}
}
