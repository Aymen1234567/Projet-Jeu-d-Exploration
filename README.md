# ⚡ Exploration – Jeu d’exploration en Java
### Projet académique (L1 informatique)
**Exploration** est un **jeu d’exploration textuel** développé en **Java**, où le joueur navigue dans une **grille de salles générée aléatoirement**, collecte des ressources et tente d’atteindre une sortie tout en évitant les dangers.  

📚 Projet pédagogique pour l’apprentissage de la **programmation orientée objet** en Java.  

---

## 🧩 Présentation du projet

Le joueur commence au **centre de la grille** avec :

- 10 **énergies**  
- 10 **grenades**  

### Objectif du jeu

- Atteindre l’une des **quatre salles de sortie** situées aux coins de la grille  
- Éviter les **mines**  
- Gérer ses **ressources** (grenades pour ouvrir les portes, énergies pour utiliser les outils)  

### Commandes principales

1. **Avancer** : Choisir une direction (`haut`, `bas`, `gauche`, `droite`) pour explorer.  
   - Les salles fermées nécessitent une **grenade** pour s’ouvrir (sauf pour revenir en arrière).  
2. **Utiliser un outil** :  
   - **Détecteur de mines** : Coût 2 énergies, indique le nombre de mines autour.  
   - **Scanner unidirectionnel** : Coût 3 énergies, compte approximativement le nombre de salles vides dans une direction (±20% erreur).

### Types d’objets dans les salles

- **Mines** : Mort immédiate, fin de partie.  
- **Grenades** : Ramassage limité, ne peut pas dépasser la limite initiale.  
- **Énergies** : Ramassage limité, ne peut pas dépasser la limite initiale.  
- **Outils** :  
  - Détecteur de mines  
  - Scanner unidirectionnel  

> Le joueur **gagne** en atteignant une sortie et **perd** s’il touche une mine ou n’a plus de grenades pour accéder aux salles.

---

## 🏗️ Fonctionnalités supplémentaires

- **Classe `Bordure`** : Gère les limites de la grille, affiche un message si le joueur atteint une bordure.  
- **Classe `SalleVide`** : Représente une salle vide (50% des salles sont vides, 50% contiennent des objets).  

- La **grille** est composée de **50% salles vides** et **50% salles avec objets**.  

---

## ⚙️ Prérequis

- **Java JDK 8** ou supérieur  
- **Aucune dépendance externe** (Java standard uniquement)  

---

## ▶️ Exécution du jeu

1. Clonez le dépôt ou copiez les sources.  
2. Compilez tous les fichiers `.java` :

```bash
javac *.java

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
