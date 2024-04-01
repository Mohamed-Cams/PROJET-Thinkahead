# Morpion JAVA

**LABADY Sterley Gilbert | 20005333**

_Jeu Morpion_

Programmation d'un jeu de Morpion en JAVA avec Interface Graphique
Jeu composé d'un plateau de 9 cases. Le morpion est un jeu de réflexion se pratiquant à
deux joueurs au tour par tour et dont le but est de créer le premier un alignement sur une
grille.

Fonctionnalités :
- Grille
- Placement du pion
- IA
- Score

Environnement de développement : JAVA

Interface graphique : OUI !

**Pour le faire fonctionner** : il suffit de le lancer le fichier main.class On vous demandera ensuite si vous voulez jouer Humain vs Humain ou Humain vs AI ou ANNULER Si vous décidez de jouer, la fenêtre de jeu se lancera automatiquement.


**Explication du code :**

On va expliquer chaque class, leurs attributs et leurs méthodes. On commence par les plus simples vers les plus complexes. 


**class Tuple :**

C’est un objet que j’ai créé qui fonctionne comme les tuples en python, son constructeur prend en paramètre 2 int, x et y. En gros ca me permettre de stocker 2 entier sous forme de Tuple


**class Tuple2 :**

Celui-ci fonctionne différemment du premier Tuple. Le constructeur de celui-ci prend en paramètre un Tuple et un entier. Donc a la fin Tuple2 stockera 3 entiers (les 2 int du Tuple et l’autre int passer en parametre a la construction de Tuple2).


**class Player :**

_3 attributs :_

un String Sign qui sera le signe du joueur soit “X” soit “O”.

un boolean playable qui indiquera si c’est au joueur de jouer ou pas. playable = True ca veut dire c’est à ce joueur de jouer, playable = False, le cas contraire.

un boolean human qui indiquera si c’est un humain ou un AI. human = True, c’est un humain, human = false, c’est un AI.

_1 méthode :_

Cette méthode bestMove est implémenté que pour l’AI, pour qu’il puisse calculer le meilleur mouvement face au joueur. Cette méthode retourne un Tuple2, qui stock un Tuple et un int. Le Tuple stock le les coordonnées de la case sur laquelle l’AI doit jouer. Et l’int stock le score du mouvement.
Cette méthode parcourt chaque case de la grille et calcule un score pour chaque mouvement et stock les coordonnées de chaque case et leur score dans un tableau de Tuple2.
A la fin de la fonction, elle parcourt le tableau et sélectionne le mouvement avec le meilleur score dans le tableau et retourne le Tuple2 stockant le Tuple avec les coordonnées de la case et le score.


**class Human :**

Celle-ci est  juste une class Fille qui hérite de la class Player.


**class AI :**

Celle-ci est  juste une class Fille qui hérite de la class Player.


**class Game :**

_6 attributs :_

la taille int de la grille (size)

le tableau String de la grille (table)

2 attributs Player :  player1 et player2, qui représentent les 2 joueurs passer en paramètre pour lancer le jeu.

2 attributs int : score_player1 et score_player2 pour le score des joueurs qui joue.

_6 methodes :_

void show() : affiche la grille en console

boolean full() : vérifie si toutes les cases du tableau sont jouées. Si oui, elle retourne True, sinon elle retourne False.

String dia() : vérifie s' il y a un alignement dans un diagonale. Si oui, retourne le signe du joueur, sinon retourne *.

String col() : vérifie s' il y a un alignement dans une colonne. Si oui, retourne le signe du joueur, sinon retourne *.

String line() : vérifie s' il y a un alignement dans une ligne. Si oui, retourne le signe du joueur, sinon retourne *.

String win() : Cette dernière fait appelle aux méthodes col, line et dia pour parcourir toutes les diagonales, toutes les lignes et toutes les colonnes pour vérifier s'il y a un alignement. Si oui, elle retourne le signe du Player, si non elle retourne *.


**class Morpion :**

Cette class représente la partie graphique du jeu, implémentée en partie avec Apache Netbeans pour le graphique (boutons, fenêtre …).

9 Boutons pour représenter les cases de la table de la class Game.

Un bouton Reset pour réinitialiser la grille

Un bouton Exit pour pour quitter le jeu

Un label pour indiquer autour de qui de jouer en analysant les playable des 2 Player

Des labels pour indiquer le score des Player.

_NB : _

A chaque fois qu’un Player joue, le bouton de la case devient unclickable. 

A chaque fois qu’un Player a fini de jouer, son playable devient False, et celui de son adversaire devient True.

A chaque fois qu’un joueur a fini de jouer on vérifie s'il y a un alignement dans la table de game avec la méthode win().

_1 attribut :_

Game game : c’est un objet de jeu.

_15 méthodes :_

initComponents() : Cette méthode initialise toute l’interface graphique du jeu.

void ai_random_move() : lorsqu'un Player est un AI, si il joue en premier, si la grille est vide, l’AI joue aléatoirement.

void ai_move() : celle ci lance la méthode bestMove de game pour récupérer les coordonnées de la case du meilleur mouvement pour jouer.

void on_click() : Cette méthode est lancée à chaque fois qu’un Player Humain clique sur un bouton de la grille. Celle-ci met le bouton en unclickable et passe la main à son adversaire pour jouer.

9 méthodes pour l’event des boutons de la grille. Ces méthodes lancent la méthode on_click en passant en paramètre les indices du bouton dans la grille.

Une méthode pour le bouton exit qui lance un System.exit(0);

Une méthode pour le bouton Reset : Qui remet la grille de bouton en clickable, réinitialise la table de game avec des étoiles.


**class Choice :**

Cette class représente une petite interface graphique qui apparaît au lancement du jeu et qui contient 3 boutons : 2 qui permettent de choisir si on veut jouer entre Humain et Humain ou entre un Humain et un AI. Et l’autre si on désire sortir du jeu.
On a 3 methodes a lancer au click d’un des boutons. Pour le bouton ANNULER c’est un System.exit(0).

Humain vs Humain : Au clic du bouton, on créera 2 Player Human, un Game qui prendra en paramètre ces 2 Player qu’on vient de créer. Et on lance la class Morpion qui prendra en paramètre Game

Humain vs AI : Au clic du bouton, on créera 2 Player un Human et un AI, un Game qui prendra en paramètre ces 2 Player qu’on vient de créer. Et on lance la class Morpion qui prendra en paramètre Game


**class main :**

Voici le point de départ du jeu. Il n’y pas grand chose implémenté ici. On lance juste la class Choice au lancement du jeu.


**CONCLUSION :**

Dans un environnement purement Java, j’ai pu développer un jeu Morpion assez avancé. On peut choisir de jouer entre Humains ou contre un AI. Un AI assez costaud, difficile à battre. J'implémente et affiche les scores des joueurs. Tout ça couronné par une interface graphique.

Les prévisions pour le projet final sont 100% réalisées.

Je peux dire qu'en ce moment je domine Java, j’ai beaucoup appris, dans le cours et aussi par mes propres recherches. Avant le début du cours je ne connaissais que le nom de ce langage. Ce cours m’a tout appris et aujourd’hui j’ai un niveau avancé en Java. 

De la je vous remercie pour le cours, et plus précisément pour votre méthode pédagogique car l'enchaînement des TPs est la chose qui m’a le plus aidé dans l'apprentissage de ce langage.

**LABADY Sterley Gilbert | 20005333**
