
public class SecurityManager {
	private PortRequis portRequisSecurityConnector;
	private PortFourni portFourniSecurityConnector;
	
	private PortRequis portRequisClearenceRequestConnector;
	private PortFourni portFourniClearenceRequestConnector;
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
	
	public SecurityManager() {
		super();
		this.portRequisSecurityConnector = new PortRequis();
		this.portFourniSecurityConnector = new PortFourni();
		this.portRequisClearenceRequestConnector = new PortRequis();
		this.portFourniClearenceRequestConnector = new PortFourni();
	}
	

	public void transmettreToClearenceRequestConnector()
	{
		String messageATransmettre = portRequisSecurityConnector.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans SecurityManager vers ClearenceReqCo");
			portRequisSecurityConnector.resetBuffer();
			//portFourniClearenceRequestConnector.take(messageATransmettre);
			portFourniClearenceRequestConnector.setBuffer(messageATransmettre);
			System.out.println("SecurityManager vers ClearenceReqCo sortie");
		}
	}
	
	public void transmettreToSecurityConnector()
	{
		String messageATransmettre = portRequisClearenceRequestConnector.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans SecurityManager vers SecurityCo");
			portRequisClearenceRequestConnector.resetBuffer();
			//portFourniSecurityConnector.take(messageATransmettre);
			portFourniSecurityConnector.setBuffer(messageATransmettre);
			System.out.println("Security vers SecurityCo sortie");
		}
	}

}
