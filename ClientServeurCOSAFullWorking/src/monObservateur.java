//Interface implémentée par tous les observateurs.
public interface monObservateur
{
     // Méthode appelée automatiquement lorsque l'état (position ou précision) du GPS change.
     public void notifier();
     
     public void bind();
}