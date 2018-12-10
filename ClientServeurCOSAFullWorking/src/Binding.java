
public class Binding {
	private PortRequis portRequis;
	private PortFourni portFourni;
	
	public PortRequis getPortRequis() {
		return portRequis;
	}
	public void setPortRequis(PortRequis portRequis) {
		this.portRequis = portRequis;
	}
	public PortFourni getPortFourni() {
		return portFourni;
	}
	public void setPortFourni(PortFourni portFourni) {
		this.portFourni = portFourni;
	}
	
	public Binding() {
		super();
		this.portRequis = new PortRequis();
		this.portFourni = new PortFourni();
	}

	public void transmettre(String nom)
	{
		String messageATransmettre = portFourni.getBuffer();
		if(!messageATransmettre.isEmpty())
		{
			System.out.println("Message : " + messageATransmettre + " dans Binding " + nom);
			portFourni.resetBuffer();
			//portRequis.deliver(messageATransmettre);
			portRequis.setBuffer(messageATransmettre);
			System.out.println("Binding " + nom + " sortie");
		}
	}
}
