/** 
*	Jeu de données invalide (ne doit pas marcher après éxécution)
*/


			-- Dictionnaire -- 
-- Erreur: type inexistant 
INSERT INTO Dictionnaire VALUES (0,"amélioration", progrès, "improvement", "nom commun", "Augmenter les capacités de qqln ou qqlchose");
-- Erreur: type et definition doivent être non nul
INSERT INTO Dictionnaire VALUES (1, "partir", "quitter", "leave", NULL, NULL);
-- Erreur: id doit être positif
INSERT INTO Dictionnaire VALUES (2, "marcher", "piétiner", "walk", "verbe", "avancer à pied");
-- Erreur: walk apparaît déjà dans la table, il doit être unique et non en double 
INSERT INTO Dictionnaire VALUES (3, "manger", "engloutir", "walk", "verbe", "mon activité préférée");


			-- Type -- 
-- Erreur: type invalide il faut un string au lieu d'un int 
INSERT INTO type VALUES (100);
-- Erreur: Type doit être différent de null
INSERT INTO type VALUES (NULL);
-- Erreur: absence de paramètres
INSERT INTO type VALUES ();


			-- Equivalence --
-- Erreur: inversion entre le mot français et anglais 
INSERT INTO Equivalence VALUES ("amélioration", "improvement");
-- Erreur: left n'existe pas comme mot_anglais et dans la table d'équivalence
INSERT INTO Equivalence VALUES ("left", "partir");
-- Erreur: un mot ne peux pas être vide
INSERT INTO Equivalence VALUES ("", "marcher");
-- Erreur: le mot français n'existe pas est n'est le bon dans la table des équivalences
INSERT INTO Equivalence VALUES ("eat", "bouger");


			-- VerbeIrregulier -- 
-- Erreur: il ne peux pas y avoir deux fois le même mot_anglais
INSERT INTO VerbeIrregulier VALUES ("leave", "left", "leave", "partir");
-- Erreur: ce mot anglais est déjà le mot anglais d'un autre n-uplet
INSERT INTO VerbeIrregulier VALUES ("ate", "eaten", "leave", "manger");


			-- Player -- 
-- Erreur: il manque un paramètre
INSERT INTO Player VALUES (0, "Pepito", 2021-10-12); 
-- Erreur: le numéro 0 existe déjà dans la table des id (en supposant que l'on ait enregistré la ligne du dessus sans problème) et le nom est null
INSERT INTO Player VALUES (0, NULL, 10, 2021-10-12); 



