BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Dictionnaire" ( 
	"id"		INTEGER PRIMARY KEY AUTOINCREMENT,
	"mot_francais"	TEXT NOT NULL,
	"mot_synonyme"	TEXT NOT NULL,
	"mot_anglais"	TEXT NOT NULL,
	"type"		TEXT NOT NULL,
	"definition"	TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS "Type" (
	"type"		TEXT NOT NULL,
	PRIMARY KEY("type")
);

CREATE TABLE IF NOT EXISTS "Equivalence" (
	"mot_anglais"	TEXT NOT NULL,
	"mot_francais"	TEXT NOT NULL,
	PRIMARY KEY("mot_anglais")
);
CREATE TABLE IF NOT EXISTS "VerbeIrregulier" (
	"preterit"		TEXT NOT NULL,
	"participe_passe"	TEXT NOT NULL,
	"mot_anglais"		TEXT NOT NULL,
	"mot_francais"		TEXT NOT NULL,
	PRIMARY KEY("mot_anglais"),
	CONSTRAINT fk_verbIrr_motAng FOREIGN KEY ("mot_anglais") REFERENCES Equivalence("mot_anglais")
);
CREATE TABLE IF NOT EXISTS "Player" (
	"id_player"	INTEGER PRIMARY KEY AUTOINCREMENT,
	"nom"		TEXT NOT NULL,
	"score"	INTEGER NOT NULL,
	"data_lheure"	DATE
);
