# dictionnaire-des-mots
#### Auteurs: Higo Medeiros & Quentin Rotolo
#### Université Grenoble Alpes - Projet Base de donées

# Introduction

Le dictionnaire vise à obtenir un type, une définition, un synonyme et sa traduction en anglais. Le mot en français peut être répété plusieurs fois avec un type différent, un synonyme différent, une traduction différente et une autre définition, mais il ne peut jamais y avoir de mots qui se répètent avec tous les mêmes attributs qui existent déjà dans la base de données.

![Diagramme](https://github.com/MedeirosHigo/dictionnaire-des-mots/assets/163612912/232e3daa-f8e4-4c7a-9afd-b491ff7710d0)


Nous avons changé l’architecture générale du projet. Nous travaillons toujours avec le dictionnaire multilingue. Une de nos mises à jour le distingue par :

- **Dictionnaire** : chaque mot est stocké et référencé par un ID (qui est la clé primaire de la table) afin d’identifier chaque mot de manière unique. On y stocke le mot français, le mot anglais, le type du mot (verbe, adjectif, etc.), des synonymes ainsi que sa ou ses définitions.
- **Type** : permet de donner le type de chaque mot parmi verbe, adjectif, attributs. Il y a la possibilité de rajouter d’autres types si besoin.
- **Équivalence** : assure l’équivalence entre un mot français et un mot anglais, ce qui est facile pour retrouver la traduction de l’un et l’autre.
- **Verbe irrégulier** : table qui contient le prétérit, le participe passé ainsi que l’équivalent français d’un verbe irrégulier.
- **Player** : Table permettant la gestion des joueurs. Chaque joueur est référencé par un identifiant (qui est clé primaire de la table), un nom, son score correspondant à son nombre de bonnes réponses pour chaque instance de jeu lancée.
