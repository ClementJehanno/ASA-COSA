
public class ServeurConfiguration implements monObservateur  {
	
	private ClearenceRequestConnector clearenceRequestConnector;
	private ConnectionManager connectionManager;
	private DataBase dataBase;
	private SecurityManager securityManager;
	private SecurityRequestConnector securityRequestConnector;
	private SQLQueryConnector sqlQueryConnector;
	private AttachementPR attachementConnectionManagerClearenceRequest;
	private AttachementRP attachementClearenceRequestConnectionManger;
	private AttachementPR attachementConnectionManagerSQLQueryConnector;
	private AttachementRP attachementSQLQueryConnectorConnectionManager;
	private AttachementPR attachementDatabaseSQLQueryConnector;
	private AttachementRP attachementSQLQueryConnector;
	private AttachementPR attachementDatabaseSecurityRequest;
	private AttachementRP attachementSecurityConnectorDatabase;
	private AttachementPR attachementSecurityManagerSecurityRequest;
	private AttachementRP attachementSecurityRequestSecurityManger;
	private AttachementPR attachementSecurityManagerClearenceRequest;
	private AttachementRP attachementClearenceReuqestSecurityManager;
	
	private Binding	bindingConnectionManagerServeurConfig;
	private Binding bindingServerConfigConnectionManger;
	
	private PortRequis fromServerConf;
	private PortFourni toServerConf;
	
	private PortRequis fromServer;
	private PortFourni toServer;
	
	public ServeurConfiguration() {
		super();
		clearenceRequestConnector = new ClearenceRequestConnector();
		securityRequestConnector = new SecurityRequestConnector();
		sqlQueryConnector = new SQLQueryConnector();
		
		connectionManager = new ConnectionManager();
		dataBase = new DataBase();
		securityManager = new SecurityManager();
		
		bindingConnectionManagerServeurConfig = new Binding();
		bindingServerConfigConnectionManger = new Binding();
		
		fromServerConf = new PortRequis();
		toServerConf = new PortFourni();
		
		fromServer = new PortRequis();
		toServer = new PortFourni();
				
		attachementConnectionManagerClearenceRequest = new AttachementPR();
		attachementClearenceRequestConnectionManger = new AttachementRP();
		
		attachementConnectionManagerSQLQueryConnector = new AttachementPR();
		attachementSQLQueryConnectorConnectionManager = new AttachementRP();
		
		attachementDatabaseSQLQueryConnector = new AttachementPR();
		attachementSQLQueryConnector = new AttachementRP();
		
		attachementDatabaseSecurityRequest = new AttachementPR();
		attachementSecurityConnectorDatabase = new AttachementRP();
		
		attachementSecurityManagerSecurityRequest = new AttachementPR();
		attachementSecurityRequestSecurityManger = new AttachementRP();
		
		attachementSecurityManagerClearenceRequest = new AttachementPR();
		attachementClearenceReuqestSecurityManager = new AttachementRP();
		
		//Lier les ports : attachement
		attachementConnectionManagerClearenceRequest.setPortFourni(connectionManager.getPortFourniClearenceRequestConnector());
		attachementConnectionManagerClearenceRequest.setRoleRequis(clearenceRequestConnector.getRoleRequisManager());
		attachementClearenceRequestConnectionManger.setPortRequis(connectionManager.getPortRequisClearenceRequestConnector());
		attachementClearenceRequestConnectionManger.setRoleFourni(clearenceRequestConnector.getRoleFourniManager());
		
		attachementConnectionManagerSQLQueryConnector.setPortFourni(connectionManager.getPortFourniSQLQueryConnector());
		attachementConnectionManagerSQLQueryConnector.setRoleRequis(sqlQueryConnector.getRoleRequisManager());
		attachementSQLQueryConnectorConnectionManager.setPortRequis(connectionManager.getPortRequisSQLQueryConnector());
		attachementSQLQueryConnectorConnectionManager.setRoleFourni(sqlQueryConnector.getRoleFourniManager());
		
		attachementDatabaseSQLQueryConnector.setPortFourni(dataBase.getPortFourniSQLQueryConnector());
		attachementDatabaseSQLQueryConnector.setRoleRequis(sqlQueryConnector.getRoleRequisDataBase());
		attachementSQLQueryConnector.setPortRequis(dataBase.getPortRequisSQLQueryConnector());
		attachementSQLQueryConnector.setRoleFourni(sqlQueryConnector.getRoleFourniDataBase());
		
		attachementDatabaseSecurityRequest.setPortFourni(dataBase.getPortFourniSecurityConnector());
		attachementDatabaseSecurityRequest.setRoleRequis(securityRequestConnector.getRoleRequisDataBase());
		attachementSecurityConnectorDatabase.setPortRequis(dataBase.getPortRequisSecurityConnector());
		attachementSecurityConnectorDatabase.setRoleFourni(securityRequestConnector.getRoleFourniDataBase());
		
		attachementSecurityManagerSecurityRequest.setPortFourni(securityManager.getPortFourniSecurityConnector());
		attachementSecurityManagerSecurityRequest.setRoleRequis(securityRequestConnector.getRoleRequisSecurity());
		attachementSecurityRequestSecurityManger.setPortRequis(securityManager.getPortRequisSecurityConnector());
		attachementSecurityRequestSecurityManger.setRoleFourni(securityRequestConnector.getRoleFourniSecurity());
		
		attachementSecurityManagerClearenceRequest.setPortFourni(securityManager.getPortFourniClearenceRequestConnector());
		attachementSecurityManagerClearenceRequest.setRoleRequis(clearenceRequestConnector.getRoleRequisSecurity());
		attachementClearenceReuqestSecurityManager.setPortRequis(securityManager.getPortRequisClearenceRequestConnector());
		attachementClearenceReuqestSecurityManager.setRoleFourni(clearenceRequestConnector.getRoleFourniSecurity());
		
		//lier les ports : Binding
		bindingConnectionManagerServeurConfig.setPortFourni(connectionManager.getExternalSocketOut());
		bindingConnectionManagerServeurConfig.setPortRequis(fromServerConf);
		
		bindingServerConfigConnectionManger.setPortFourni(toServerConf);
		bindingServerConfigConnectionManger.setPortRequis(connectionManager.getExternalSocketIn());
		
		
		
	}
	
	public PortRequis getFromServerConf()
	{
		return fromServerConf;
	}
	public PortFourni getToServerConf()
	{
		return toServerConf;
	}
	
	public PortRequis getFromServer()
	{
		return fromServer;
	}
	public PortFourni getToServer()
	{
		return toServer;
	}
	
	
	public void simuler()
	{
//		toServerConf.setBuffer("testBuffer");
		//toServerConf.deliver("test");
	}

	public void runRequest()
	{
		fromServToBindingToCoManager();
		bindingServerConfigConnectionManger.transmettre("serverConfigConnectionManger");
		connectionManager.transmettreToClearenceRequestConnector();
		attachementConnectionManagerClearenceRequest.transmettre("attachementConnectionManagerClearenceRequest.");
		clearenceRequestConnector.transmettreToSecurity();
		attachementClearenceReuqestSecurityManager.transmettre("attachementClearenceReuqestSecurityManager");
		securityManager.transmettreToSecurityConnector();
		attachementSecurityManagerSecurityRequest.transmettre("attachementSecurityManagerSecurityRequest");
		securityRequestConnector.transmettreToDataBase();
		attachementSecurityConnectorDatabase.transmettre("attachementSecurityConnectorDatabase");
		dataBase.transmettreToSecurityConnector();
		attachementDatabaseSecurityRequest.transmettre("attachementDatabaseSecurityRequest");
		securityRequestConnector.transmettreToSecurity();
		attachementSecurityRequestSecurityManger.transmettre("attachementSecurityRequestSecurityManger");
		securityManager.transmettreToClearenceRequestConnector();
		attachementSecurityManagerClearenceRequest.transmettre("attachementSecurityManagerClearenceRequest");
		clearenceRequestConnector.transmettreToManager();
		attachementClearenceRequestConnectionManger.transmettre("attachementClearenceRequestConnectionManger");
		connectionManager.transmettreToSQLQueryConnector();
		attachementConnectionManagerSQLQueryConnector.transmettre("attachementConnectionManagerSQLQueryConnector");
		sqlQueryConnector.transmettreToDataBase();
		attachementSQLQueryConnector.transmettre("attachementSQLQueryConnector");
		dataBase.transmettreToSQLQueryConnector();
		attachementDatabaseSQLQueryConnector.transmettre("attachementDatabaseSQLQueryConnector");
		sqlQueryConnector.transmettreToManager();
		attachementSQLQueryConnectorConnectionManager.transmettre("attachementSQLQueryConnectorConnectionManager");
		connectionManager.transmettreToExternalSocketOut();
		bindingConnectionManagerServeurConfig.transmettre("bindingConnectionManagerServeurConfig");
		fromCoManagerToBindingToServer();
	
	
	}
	
	
	@Override
	public void notifier() {
		//il faut mettre un ordre ici
		//Ca va pas être joli
		connectionManager.transmettreToClearenceRequestConnector();
		connectionManager.transmettreToSQLQueryConnector();
		clearenceRequestConnector.transmettreToSecurity();
		clearenceRequestConnector.transmettreToManager();
		securityRequestConnector.transmettreToDataBase();
		securityRequestConnector.transmettreToSecurity();
		sqlQueryConnector.transmettreToDataBase();
		sqlQueryConnector.transmettreToManager();
		dataBase.transmettreToSecurityConnector();
		dataBase.transmettreToSQLQueryConnector();
		securityManager.transmettreToClearenceRequestConnector();
		securityManager.transmettreToSecurityConnector();

		//attachements
		//AttachementPR
		attachementConnectionManagerClearenceRequest.transmettre("attachementConnectionManagerClearenceRequest.");
		attachementConnectionManagerSQLQueryConnector.transmettre("attachementConnectionManagerSQLQueryConnector");
		attachementDatabaseSQLQueryConnector.transmettre("attachementDatabaseSQLQueryConnector");
		attachementDatabaseSecurityRequest.transmettre("attachementDatabaseSecurityRequest");
		attachementSecurityManagerSecurityRequest.transmettre("attachementSecurityManagerSecurityRequest");
		attachementSecurityManagerClearenceRequest.transmettre("attachementSecurityManagerClearenceRequest");
		
		//AttachementRP
		attachementClearenceRequestConnectionManger.transmettre("attachementClearenceRequestConnectionManger");
		attachementSQLQueryConnectorConnectionManager.transmettre("attachementSQLQueryConnectorConnectionManager");
		attachementSQLQueryConnector.transmettre("attachementSQLQueryConnector");
		attachementSecurityConnectorDatabase.transmettre("attachementSecurityDatabaseSecurity");
		attachementSecurityRequestSecurityManger.transmettre("attachementSecurityRequestSecurityManger");
		attachementClearenceReuqestSecurityManager.transmettre("attachementClearenceReuqestSecurityManager");
		
		//On va sur les binding
		bindingConnectionManagerServeurConfig.transmettre("connectionManagerServeurConfig");
		
	}
	
	@Override
	public void bind()
	{
		bindingConnectionManagerServeurConfig.transmettre("connectionManagerServeurConfig");
		bindingServerConfigConnectionManger.transmettre("serverConfigConnectionManger");
		
		//On va sur les attachement
		connectionManager.transmettreToClearenceRequestConnector();
	}
	
	public void fromServToBindingToCoManager()
	{
		String messageATransmettre = fromServer.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans ServerConfig vers CoManager");
			fromServer.resetBuffer();
			//portFourniClearenceRequestConnector.take(messageATransmettre);
			toServerConf.setBuffer(messageATransmettre);
			System.out.println("ServerConfig vers CoManager sortie");
		}
	}
	
	public void fromCoManagerToBindingToServer()
	{
		String messageATransmettre = fromServerConf.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans ServerConfig vers Server");
			fromServer.resetBuffer();
			//portFourniClearenceRequestConnector.take(messageATransmettre);
			toServer.setBuffer(messageATransmettre);
			System.out.println("ServerConfig vers Server sortie");
		}
	}
}
