
//Interface implémentée par toutes les classes souhaitant avoir des observateurs à leur écoute.
public interface monObservable
{
     // Méthode permettant d'ajouter (abonner) un observateur.
     public void ajouterObservateur(monObservateur o);
     // Méthode permettant de supprimer (résilier) un observateur.
     public void supprimerObservateur(monObservateur o);
     // Méthode qui permet d'avertir tous les observateurs lors d'un changement d'état.
     public void notifierObservateurs();
}