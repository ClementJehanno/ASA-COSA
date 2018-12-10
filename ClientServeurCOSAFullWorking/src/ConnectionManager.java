
public class ConnectionManager {
	
	boolean lockA;
	boolean lockB;
	boolean lockC;
	private PortRequis portRequisClearenceRequestConnector;
	private PortFourni portFourniClearenceRequestConnector;
	
	private PortRequis portRequisSQLQueryConnector;
	private PortFourni portFourniSQLQueryConnector;
	
	private PortRequis externalSocketIn;
	private PortFourni externalSocketOut;
	
	public PortRequis getExternalSocketIn() {
		return externalSocketIn;
	}
	public void setExternalSocketIn(PortRequis externalSocketIn) {
		this.externalSocketIn = externalSocketIn;
	}
	public PortFourni getExternalSocketOut() {
		return externalSocketOut;
	}
	public void setExternalSocketOut(PortFourni externalSocketOut) {
		this.externalSocketOut = externalSocketOut;
	}
	public PortRequis getPortRequisClearenceRequestConnector() {
		return portRequisClearenceRequestConnector;
	}
	public void setPortRequisClearenceRequestConnector(PortRequis portRequisClearenceRequestConnector) {
		this.portRequisClearenceRequestConnector = portRequisClearenceRequestConnector;
	}
	public PortFourni getPortFourniClearenceRequestConnector() {
		return portFourniClearenceRequestConnector;
	}
	public void setPortFourniClearenceRequestConnector(PortFourni portFourniClearenceRequestConnector) {
		this.portFourniClearenceRequestConnector = portFourniClearenceRequestConnector;
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
	public ConnectionManager() {
		super();
		this.portRequisClearenceRequestConnector = new PortRequis();
		this.portFourniClearenceRequestConnector = new PortFourni();
		this.portRequisSQLQueryConnector = new PortRequis();
		this.portFourniSQLQueryConnector = new PortFourni();
		this.externalSocketIn = new PortRequis();
		this.externalSocketOut = new PortFourni();
		lockA = false;
		lockB = false;
		lockC = false;
		
	}
	

	public void transmettreToSQLQueryConnector()
	{
		String messageATransmettre = portRequisClearenceRequestConnector.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans ConnexionManager vers SQLQueryCO");
			portRequisClearenceRequestConnector.resetBuffer();
			/*
			lockA = true;
			portFourniSQLQueryConnector.take(messageATransmettre);
			lockA = false;
			*/
			portFourniSQLQueryConnector.setBuffer(messageATransmettre);
			System.out.println("ConnexionManager vers SQLQueryCO sortie");
			
		}
	}
	
	public void transmettreToClearenceRequestConnector()
	{
		String messageATransmettre = externalSocketIn.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans ConnexionManager vers ClearenceRequestCo");
			externalSocketIn.resetBuffer();
			/*
			lockB = true;
			portRequisClearenceRequestConnector.take(messageATransmettre);
			lockB = false;
			*/
			portFourniClearenceRequestConnector.setBuffer(messageATransmettre);
			System.out.println("ConnexionManager vers ClearenceRequestCo sortie");
		}
	}
	
	public void transmettreToExternalSocketOut()
	{
		String messageATransmettre = portRequisSQLQueryConnector.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans ConnexionManager vers ExternalSocketOut");
			portRequisSQLQueryConnector.resetBuffer();
			/*
			lockC = true;
			externalSocketOut.deliver(messageATransmettre);
			lockC = false;
			*/
			externalSocketOut.setBuffer(messageATransmettre);
			System.out.println("ConnexionManager vers ExternalSocketOut sortie");
		}
	}
	
}
