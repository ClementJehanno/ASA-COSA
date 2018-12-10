public class ClientServeurConfiguration implements monObservateur {
	private Server server;
	private RPCConnecteur RPCConnecteur;
	private Client client;
	private AttachementPR attachementClientRPC;
	private AttachementRP attachementRPCServeur;
	private AttachementPR attachementServeurRPC;
	private AttachementRP attachementRPCClient;
	
	private Binding bindToServConf;
	private Binding bindFromServConfToServ;
	
	public ClientServeurConfiguration() {
		super();
		//Creation du modèle Client-Server

		//Client
		client = new Client();
		
		//RPCConnecteur
		RPCConnecteur = new RPCConnecteur();		
		
		//Serveur
		server = new Server();
		
		
			//Client -> RPCConnector
		attachementClientRPC = new AttachementPR();	
		attachementClientRPC.setPortFourni(client.getPortFourni());
		attachementClientRPC.setRoleRequis(RPCConnecteur.getRoleRequis());
			
		//RPCConnector -> Serveur
		attachementRPCServeur = new AttachementRP();	
		attachementRPCServeur.setRoleFourni(RPCConnecteur.getRoleFourni());
		attachementRPCServeur.setPortRequis(server.getPortRequis());
		
		//Serveur -> RPCConnector
		attachementServeurRPC = new AttachementPR();
		attachementServeurRPC.setPortFourni(server.getPortFourniToRPC());
		attachementServeurRPC.setRoleRequis(RPCConnecteur.getRoleRequisfromServ());
		
		//RPCCOnnector -> Client
		attachementRPCClient = new AttachementRP();
		attachementRPCClient.setRoleFourni(RPCConnecteur.getRoleFournitoClient());
		attachementRPCClient.setPortRequis(client.getPortRequis());
		
		//Binding server -> serv conf
		bindToServConf = new Binding();
		bindToServConf.setPortFourni(server.getPortFourni());
		bindToServConf.setPortRequis(server.getServerConfiguration().getFromServer());
		
		//Binding ServConf to Server
		bindFromServConfToServ = new Binding();
		bindFromServConfToServ.setPortFourni(server.getServerConfiguration().getToServer());
		bindFromServConfToServ.setPortRequis(server.getPortRequisFromServConf());
		
		//Observer

		
		client.ajouterObservateur(this);
		
		
		
	}
	
	public void simulate()
	{
		client.sendRequest("Hello ");
		//String result = transitMsg();
		//serverConfiguration.simuler();
		
	}

	@Override
	public void notifier() {
		// TODO Auto-generated method stub
		//On ne sait pas où est le message donc on demande à tout le monde de transmettre
		attachementClientRPC.transmettre("attachementClientRPC");
		RPCConnecteur.transmettre();
		attachementRPCServeur.transmettre("attachementRPCServeur");
		server.transmettreToServConf();
		bindToServConf.transmettre("bindingToServConf");
		server.runRequest();
		bindFromServConfToServ.transmettre("bindFromServConfToServ");
		server.transmettreToRPCConnector();
		attachementServeurRPC.transmettre("attachementServeurRPC");
		RPCConnecteur.transmettreFromServToClient();
		attachementRPCClient.transmettre("attachementRPCClient");
		client.receiveRequest();
	
	}
	
	@Override
	public void bind()
	{
		//
	}

	
}
