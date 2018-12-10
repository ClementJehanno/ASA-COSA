
public class Server {
	//ports
	private PortFourni portFourni; //toServConf
	private PortRequis portRequis; //fromRPC
	
	private PortRequis portRequisFromServConf;
	private PortFourni portFourniToRPC;
	
	//configuration	
	private ServeurConfiguration serverConfiguration;
	
	
	
	public Server() {
		super();
		// TODO Auto-generated constructor stub
		this.portFourni = new PortFourni();
		this.portRequis = new PortRequis();
		this.portFourniToRPC = new PortFourni();
		this.portRequisFromServConf = new PortRequis();
		this.serverConfiguration = new ServeurConfiguration();
	}

	public PortFourni getPortFourni() {
		return portFourni;
	}

	public void setPortFourni(PortFourni portFourni) {
		this.portFourni = portFourni;
	}

	public PortRequis getPortRequis() {
		return portRequis;
	}

	public void setPortRequis(PortRequis portRequis) {
		this.portRequis = portRequis;
	}
	
	public PortRequis getPortRequisFromServConf()
	{
		return portRequisFromServConf;
	}
	
	public PortFourni getPortFourniToRPC()
	{
		return portFourniToRPC;
	}
	
	
	
	
	public ServeurConfiguration getServerConfiguration()
	{
		return serverConfiguration;
	}
	
	public void transmettreToServConf()
	{
		String messageATransmettre = portRequis.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans Server vers ServeurConfig");
			portRequis.resetBuffer();
			//portFourni.take(messageATransmettre);
			portFourni.setBuffer(messageATransmettre);
			System.out.println("Server vers ServeurConfig sortie");
			
		}
	}
	
	public void runRequest()
	{
		serverConfiguration.runRequest();
	}
	
	public void transmettreToRPCConnector()
	{
		String messageATransmettre = portRequisFromServConf.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans Server vers RPCConnec");
			portRequisFromServConf.resetBuffer();
			//portFourni.take(messageATransmettre);
			portFourniToRPC.setBuffer(messageATransmettre);
			System.out.println("Server vers RPCConnec sortie");
			
		}
		
	}
}
