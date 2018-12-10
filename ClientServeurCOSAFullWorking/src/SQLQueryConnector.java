
public class SQLQueryConnector {

	private RoleRequis roleRequisManager;
	private RoleFourni roleFourniManager;
	
	private RoleRequis roleRequisDataBase;
	private RoleFourni roleFourniDataBase;
	
	
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
		String messageATransmettre = roleRequisManager.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans SQlQueryCo vers DataBase");
			roleRequisManager.resetBuffer();
			roleFourniDataBase.setBuffer(messageATransmettre);
			System.out.println("SQlQueryCo vers DataBase sortie");
		}
	}
	
	public void transmettreToManager()
	{
		String messageATransmettre = roleRequisDataBase.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans SQlQueryCo vers Manager");
			roleRequisDataBase.resetBuffer();
    		//roleFourniManager.take(messageATransmettre);
			roleFourniManager.setBuffer(messageATransmettre);
			System.out.println("SQlQueryCo vers Manager sortie");
		}
	}

	public SQLQueryConnector() {
		super();
		this.roleRequisManager = new RoleRequis();
		this.roleFourniManager = new RoleFourni();
		this.roleRequisDataBase = new RoleRequis();
		this.roleFourniDataBase = new RoleFourni();
	}

}
