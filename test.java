import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotheque {

    // Classe Livre pour représenter un livre
    public static class Livre {
        private String titre;
        private String auteur;
        private boolean estDisponible;

        public Livre(String titre, String auteur) {
            this.titre = titre;
            this.auteur = auteur;
            this.estDisponible = true;  // Livre disponible par défaut
        }

        public String getTitre() {
            return titre;
        }

        public String getAuteur() {
            return auteur;
        }

        public void emprunter() {
            if (estDisponible == true) {
                estDisponible = false;
            } else {
                System.out.println("Le livre est déjà emprunté.");
            }
        }

        public void retourner() {
            estDisponible = true;
        }

        public boolean estDisponible() {
            return estDisponible;
        }
    }

    // Liste des livres dans la bibliothèque
    private ArrayList<Livre> livres;

    public Bibliotheque() {
        livres = new ArrayList<>();
    }

    public void ajouterLivre(String titre, String auteur) {
        Livre livre = new Livre(titre, auteur);
        livres.add(livre);
    }

    public void afficherLivres() {
        System.out.println("Liste des livres disponibles : ");
        for (int i = 0; i < livres.size(); i++) {
            System.out.println(i + 1 + ". " + livres.get(i).getTitre() + " de " + livres.get(i).getAuteur() + " - " + (livres.get(i).estDisponible ? "Disponible" : "Emprunté"));
        }
    }

    public void emprunterLivre(int index) {
        if (index >= 0 && index < livres.size()) {
            Livre livre = livres.get(index);
            livre.emprunter();
        } else {
            System.out.println("Indice de livre invalide.");
        }
    }

    public void retournerLivre(int index) {
        if (index >= 0 && index < livres.size()) {
            Livre livre = livres.get(index);
            livre.retourner();
        } else {
            System.out.println("Indice de livre invalide.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bibliotheque bibliotheque = new Bibliotheque();

        // Ajouter quelques livres à la bibliothèque
        bibliotheque.ajouterLivre("Le Petit Prince", "Antoine de Saint-Exupéry");
        bibliotheque.ajouterLivre("1984", "George Orwell");
        bibliotheque.ajouterLivre("Moby Dick", "Herman Melville");

        // Menu
        boolean continuer = true;
        while (continuer) {
            System.out.println("\n1. Afficher les livres");
            System.out.println("2. Emprunter un livre");
            System.out.println("3. Retourner un livre");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine();  // Consommer le newline restant

            switch (choix) {
                case 1:
                    bibliotheque.afficherLivres();
                    break;

                case 2:
                    System.out.print("Entrez l'indice du livre à emprunter : ");
                    int indexEmprunt = scanner.nextInt();
                    scanner.nextLine();  // Consommer le newline restant
                    bibliotheque.emprunterLivre(indexEmprunt - 1);
                    break;

                case 3:
                    System.out.print("Entrez l'indice du livre à retourner : ");
                    int indexRetour = scanner.nextInt();
                    scanner.nextLine();  // Consommer le newline restant
                    bibliotheque.retournerLivre(indexRetour - 1);
                    break;

                case 4:
                    continuer = false;
                    break;

                default:
                    System.out.println("Option invalide. Essayez à nouveau.");
            }
        }

        scanner.close();
        System.out.println("Merci d'avoir utilisé le système de gestion de bibliothèque.");
    }
}


