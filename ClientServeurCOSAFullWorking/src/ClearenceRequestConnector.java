
public class ClearenceRequestConnector {
	
	private RoleRequis roleRequisSecurity;
	private RoleFourni roleFourniSecurity;
	
	private RoleRequis roleRequisManager;
	private RoleFourni roleFourniManager;
	

	public RoleRequis getRoleRequisSecurity() {
		return roleRequisSecurity;
	}

	public void setRoleRequisSecurity(RoleRequis roleRequisSecurity) {
		this.roleRequisSecurity = roleRequisSecurity;
	}

	public RoleFourni getRoleFourniSecurity() {
		return roleFourniSecurity;
	}

	public void setRoleFourniSecurity(RoleFourni roleFourniSecurity) {
		this.roleFourniSecurity = roleFourniSecurity;
	}

	public RoleRequis getRoleRequisManager() {
		return roleRequisManager;
	}

	public void setRoleRequisManager(RoleRequis roleRequisManager) {
		this.roleRequisManager = roleRequisManager;
	}

	public RoleFourni getRoleFourniManager() {
		return roleFourniManager;
	}

	public void setRoleFourniManager(RoleFourni roleFourniManager) {
		this.roleFourniManager = roleFourniManager;
	}

	public void transmettreToManager()
	{
		String messageATransmettre = roleRequisSecurity.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans ClearenceRequestManager vers CoManager");
			roleRequisSecurity.resetBuffer();
			//roleFourniManager.take(messageATransmettre);
			roleFourniManager.setBuffer(messageATransmettre);
			System.out.println("ClearenceRequestManager to CoManager sortie");
		}
	}
	
	public void transmettreToSecurity()
	{
		String messageATransmettre = roleRequisManager.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans ClearenceRequestManager vers Security");
			roleRequisManager.resetBuffer();
			//roleFourniSecurity.take(messageATransmettre);
			roleFourniSecurity.setBuffer(messageATransmettre);
			System.out.println("ClearenceRequestManager to Security sortie");
		}
	}

	public ClearenceRequestConnector() {
		super();
		this.roleRequisSecurity = new RoleRequis();
		this.roleFourniSecurity = new RoleFourni();
		this.roleRequisManager = new RoleRequis();
		this.roleFourniManager = new RoleFourni();
	}

}
