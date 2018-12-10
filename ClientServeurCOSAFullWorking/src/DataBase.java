
public class DataBase {
	private String maValue;
	
	private PortRequis portRequisSecurityConnector;
	private PortFourni portFourniSecurityConnector;
	
	private PortRequis portRequisSQLQueryConnector;
	private PortFourni portFourniSQLQueryConnector;
	
	
	public PortRequis getPortRequisSecurityConnector() {
		return portRequisSecurityConnector;
	}
	public void setPortRequisSecurityConnector(PortRequis portRequisSecurityConnector) {
		this.portRequisSecurityConnector = portRequisSecurityConnector;
	}
	public PortFourni getPortFourniSecurityConnector() {
		return portFourniSecurityConnector;
	}
	public void setPortFourniSecurityConnector(PortFourni portFourniSecurityConnector) {
		this.portFourniSecurityConnector = portFourniSecurityConnector;
	}
	public PortRequis getPortRequisSQLQueryConnector() {
		return portRequisSQLQueryConnector;
	}
	public void setPortRequisSQLQueryConnector(PortRequis portRequisSQLQueryConnector) {
		this.portRequisSQLQueryConnector = portRequisSQLQueryConnector;
	}
	public PortFourni getPortFourniSQLQueryConnector() {
		return portFourniSQLQueryConnector;
	}
	public void setPortFourniSQLQueryConnector(PortFourni portFourniSQLQueryConnector) {
		this.portFourniSQLQueryConnector = portFourniSQLQueryConnector;
	}
	public DataBase() {
		super();
		this.maValue = " World";
		this.portRequisSecurityConnector = new PortRequis();
		this.portFourniSecurityConnector = new PortFourni();
		this.portRequisSQLQueryConnector = new PortRequis();
		this.portFourniSQLQueryConnector = new PortFourni();
		
		maValue = " world!";
	}
	

	public void transmettreToSQLQueryConnector()
	{
		String messageATransmettre = portRequisSQLQueryConnector.getBuffer();
		
		if(!messageATransmettre.isEmpty())
		{
			messageATransmettre = maValue;
			
			System.out.println("Message : " + messageATransmettre + " dans DataBase vers SQLQueryCO");
			portRequisSecurityConnector.resetBuffer();
			//portFourniSQLQueryConnector.take(messageATransmettre);
			portFourniSQLQueryConnector.setBuffer(messageATransmettre);
			System.out.println("ConnexionManager vers SQLQueryCO sortie");
		}
	}
	
	public void transmettreToSecurityConnector()
	{
		String messageATransmettre = portRequisSecurityConnector.getBuffer();
		
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans ConnexionManager vers SecurityCo");
			portRequisSQLQueryConnector.resetBuffer();
			//portFourniSecurityConnector.take(messageATransmettre);
			portFourniSecurityConnector.setBuffer(messageATransmettre);
			System.out.println("ConnexionManager vers SecurityCo sortie");
		}
	}
	
}
