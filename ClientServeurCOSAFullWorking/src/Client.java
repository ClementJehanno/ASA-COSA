
public class Client implements monObservable{
	private PortFourni portFourni;
	private PortRequis portRequis;
	
	private monObservateur obs;
	
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
	public Client(PortFourni portFourni, PortRequis portRequis) {
		super();
		this.portFourni = portFourni;
		this.portRequis = portRequis;
	}
	public Client() {
		super();
		this.portFourni = new PortFourni();
		this.portRequis = new PortRequis();
	}
	
	public void sendRequest(String request)
	{
		System.out.println("Client envoie : " + request); 
		this.portFourni.setBuffer(request);
		notifierObservateurs();
	}
	
	public void receiveRequest()
	{
		System.out.println("Client recoit : " + portRequis.getBuffer()); 
		
	}
	
	
	@Override
	public void ajouterObservateur(monObservateur o) {
		obs = o;
		
	}
	@Override
	public void supprimerObservateur(monObservateur o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notifierObservateurs() {
		
		obs.notifier();
		
	}
	
}
