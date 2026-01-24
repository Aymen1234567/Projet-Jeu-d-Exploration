Description
Ce projet est un jeu d'exploration en Java où le joueur navigue dans une grille de salles générée aléatoirement. Le joueur commence au centre avec 10 énergies et 10 grenades. L'objectif est d'atteindre l'une des quatre salles de sortie situées aux coins de la grille, en évitant les mines et en gérant les ressources (grenades pour ouvrir les portes, énergies pour utiliser les outils).
Au lancement, une salle vide apparaît avec le joueur au centre. Deux commandes principales sont disponibles :

Avancer : Choisir une direction (haut, bas, gauche, droite) pour explorer. Les salles fermées nécessitent une grenade pour s'ouvrir (sauf pour revenir en arrière).
Utiliser un outil : Activer le détecteur de mines (coût : 2 énergies) ou le scanner unidirectionnel (coût : 3 énergies).

Dans les salles, le joueur peut trouver :

Mines : Mort immédiate (fin du jeu).
Grenades : Ramasser un nombre limité (sans dépasser la limite initiale).
Énergies : Ramasser un nombre limité (sans dépasser la limite initiale).
Outils : Détecteur de mines (indique le nombre de mines autour) ou scanner unidirectionnel (compte les salles vides dans une direction, avec une marge d'erreur de 20%).

Le joueur gagne en atteignant une sortie. Il perd s'il touche une mine ou épuisé toutes ses grenades (impossible d'accéder à de nouvelles salles).
Fonctionnalités supplémentaires :

Classe Bordure : Gère les limites du jeu, affiche "vous êtes arrivé à la limite" lors de l'interaction.
Classe SalleVide : Représente les salles vides (50% des salles sont vides, 50% contiennent des objets comme outils, mines, etc.).

La grille est composée de 50% de salles vides et 50% de salles avec objets.
Prérequis

Java JDK 8 ou supérieur.
Pas de dépendances externes (bibliothèques standard Java uniquement).

Comment Exécuter

Clonez le dépôt (si applicable) ou compilez les fichiers Java.
Compilez tous les fichiers .java avec javac *.java.
Exécutez la classe principale : java Exploration.
Suivez les instructions à l'écran pour jouer.

Diagramme de Classes
Voici une représentation textuelle simplifiée du diagramme de classes (basée sur le diagramme fourni). Les flèches indiquent l'héritage ou les relations.
textObjet
├── Bordure
├── SalleVide
├── Mine
├── CaisseGrenades
├── ReserveEnergie
├── Outil
│   ├── DetecteurMines
│   └── ScannerUnidirectionnel
└── Sortie

Autres classes :
- Direction (énumération pour haut, bas, gauche, droite)
- Position (gère les coordonnées sur le plateau)
- Salle (contient un objet, gère les accès)
- Plateau (grille de salles, gère le joueur)
- Joueur (gère les ressources, mouvements)
- Jeu (gère l'initialisation et le déroulement)
- Exploration (classe principale, lance le jeu)
- Categorie (gère les catégories d'objets)
- LesOutils (gère les outils du joueur)
Pour une vue graphique, référez-vous au diagramme dans le PDF du projet.
Descriptif des Classes
Voici un résumé des classes principales (basé sur la documentation du projet) :

Bordure.java : Étend Objet. Gère les limites ; interaction affiche "vous êtes arrivé à la limite".
CaisseGrenades.java : Représente une caisse de grenades (max 10). Méthodes pour get/set nombre et interaction (ramasser).
DetecteurMines.java : Étend Outil. Détecte les mines autour (8 salles) ; coût 2 énergies.
Exploration.java : Classe principale ; lance Jeu.joue().
Jeu.java : Gère le plateau, catégories d'objets, initialisation aléatoire, et boucle de jeu.
Joueur.java : Gère nom, power (énergies), grenades, position, outils, statut (gagnant/perdant). Méthodes pour avancer, lancer grenade, récupérer outil.
Mine.java : Étend Objet. Interaction met le joueur en perdant et affiche "match perdue".
Plateau.java : Grille de salles ; gère visibilité, dimensions, placement de salles/joueur.
Position.java : Gère rang/ligne/colonne ; méthodes pour positions suivantes, validation.
ReserveEnergie.java : Représente une réserve d'énergie (max aléatoire). Interaction pour ramasser.
Salle.java : Représente une salle ; gère visibilité, contenu (objet), accès directions.
SalleVide.java : Étend Objet. Représente une salle vide (interaction vide).
ScannerUnidirectionnel.java : Étend Outil. Scanne salles vides dans une direction (avec marge d'erreur 20%) ; coût 3 énergies.
Sortie.java : Étend Objet. Interaction affiche "match gangnée".

Pour plus de détails sur les attributs/méthodes, consultez le PDF du projet.
Jeux d'Essais
Voici des exemples de sessions de jeu commentées (basés sur les captures d'écran fournies) :

Essai : Lancement et mouvement basique
Commande : 1 (avancer), direction "h" (haut).
Salle fermée : Lancer grenade ? Oui.
Résultat : Accès à une nouvelle salle, possiblement vide ou avec objet.

Essai : Ramasser grenades
Trouve caisse de grenades.
Choisit de ramasser 6 grenades (ajoutées au stock, reste 15 dans caisse).

Essai : Utiliser outil
Commande : 2 (utiliser outil), 1 (détecteur de mines).
Résultat : "Il n'y en a pas" (pas de mines autour).

Essai : Scanner unidirectionnel
Commande : 2, 2 (scanner). Direction "b" (bas).
Résultat : Affiche nombre approximatif de salles vides (avec erreur ±20%).


Le jeu est en mode texte (console).
Proportion : 50% salles vides.
Améliorations possibles : Interface graphique, plus d'objets, IA pour le joueur.
