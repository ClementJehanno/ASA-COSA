
public class SecurityRequestConnector {

	private RoleRequis roleRequisSecurity;
	private RoleFourni roleFourniSecurity;
	
	private RoleRequis roleRequisDataBase;
	private RoleFourni roleFourniDataBase;
	

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

	public RoleRequis getRoleRequisDataBase() {
		return roleRequisDataBase;
	}

	public void setRoleRequisDataBase(RoleRequis roleRequisDataBase) {
		this.roleRequisDataBase = roleRequisDataBase;
	}

	public RoleFourni getRoleFourniDataBase() {
		return roleFourniDataBase;
	}

	public void setRoleFourniDataBase(RoleFourni roleFourniDataBase) {
		this.roleFourniDataBase = roleFourniDataBase;
	}

	public void transmettreToDataBase()
	{
		String messageATransmettre = roleRequisSecurity.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans SecurityRequestMan vers DataBase");
			roleRequisSecurity.resetBuffer();
			//roleFourniDataBase.take(messageATransmettre);
			roleFourniDataBase.setBuffer(messageATransmettre);
			System.out.println("SecurityRequestMan vers Database sortie");
		}
	}
	
	public void transmettreToSecurity()
	{
		String messageATransmettre = roleRequisDataBase.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans SecurityRequestMan vers Security");
			roleRequisDataBase.resetBuffer();
			//roleFourniSecurity.take(messageATransmettre);
			roleFourniSecurity.setBuffer(messageATransmettre);
			System.out.println("SecurityRequestMan vers Security sortie");
		}
	}

	public SecurityRequestConnector() {
		super();
		this.roleRequisSecurity = new RoleRequis();
		this.roleFourniSecurity = new RoleFourni();
		this.roleRequisDataBase = new RoleRequis();
		this.roleFourniDataBase = new RoleFourni();
	}
}
