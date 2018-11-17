-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: hulirds.caklgmbaggid.eu-central-1.rds.amazonaws.com    Database: devwars
-- ------------------------------------------------------
-- Server version	5.6.37-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `action`
--

DROP TABLE IF EXISTS `action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `action_type` int(11) DEFAULT NULL,
  `base_amount` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `required_competence_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt5m9e6541t7gu45mxaci8tjao` (`required_competence_id`),
  CONSTRAINT `FKt5m9e6541t7gu45mxaci8tjao` FOREIGN KEY (`required_competence_id`) REFERENCES `competence` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action`
--

LOCK TABLES `action` WRITE;
/*!40000 ALTER TABLE `action` DISABLE KEYS */;
INSERT INTO `action` VALUES (1,1,5,'using TDD. Its better than sex!','TDD',1),(2,1,7,'scraping the hell out of the internet','Scraper',2),(5,1,6,'cross platform language','Cross-platform',1),(6,1,3,'HTTP ERROR CODE 418 Im a teapot','Teapot',5),(7,1,7,'coding in Vim. Infinite immersion.','Vim code',8),(8,1,6,'writing the Wanderer game in 12 lines','Short code',2),(9,1,3,'clapping two coconut-halves together and imitating horse-riding','Monthy Python',2),(10,1,6,'not missing any of the {}','Bajusz',3),(11,1,3,'the fact that the enemy cant C#','Not C#',4),(12,1,0,'using Stackoverflow. It didnt help much!','Stackoverflow',6),(13,1,5,'fixing the fridge','Fixing the fridge',4),(14,1,7,'getting hired by Bosch. Its super effective!','Bosch',4),(15,1,3,'being a motherfucking hipster','Hipster',8),(16,1,6,'rather just using WordPress','Wordpress',3),(17,1,4,'hissing like a sneiky boi. Enemy is hekin bamboozled!','Danger noodle',2),(18,1,5,'using shiny design','Shiny design',7),(19,1,2,'using !important on every CSS line','I know CSS',3),(20,1,5,'building a robot car and using it to deliver beer when coding','Robot Car',4),(21,1,5,'injecting the hell out of dependencies','DI (Y?)',5),(22,1,6,'using Bootstrap. Who the hell needs frontend guys?','Bootstrap',6),(23,1,6,'using Spring Security. The enemy is confused!','Spring Security',5),(24,1,4,'learning yet another JS framework. The enemy is confused!','Framework frenzy',3),(25,1,6,'flame','Flamma',1),(26,1,7,'ice','Coool',2);
/*!40000 ALTER TABLE `action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arena`
--

DROP TABLE IF EXISTS `arena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arena` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `current_hero_index` int(11) NOT NULL,
  `current_turn_number` int(11) NOT NULL,
  `dice_sides` int(11) NOT NULL,
  `game_over` bit(1) NOT NULL,
  `next_action_log_number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arena`
--

LOCK TABLES `arena` WRITE;
/*!40000 ALTER TABLE `arena` DISABLE KEYS */;
INSERT INTO `arena` VALUES (15,1,4,6,_binary '\0',9),(16,0,2,6,_binary '\0',5),(18,0,1,6,_binary '\0',3);
/*!40000 ALTER TABLE `arena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arena_action_log`
--

DROP TABLE IF EXISTS `arena_action_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arena_action_log` (
  `arena_id` bigint(20) NOT NULL,
  `message` varchar(1000) DEFAULT NULL,
  `action_order` int(11) NOT NULL,
  PRIMARY KEY (`arena_id`,`action_order`),
  CONSTRAINT `FKhckdjkdxu4emd6ce9jpgevbjw` FOREIGN KEY (`arena_id`) REFERENCES `arena` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arena_action_log`
--

LOCK TABLES `arena_action_log` WRITE;
/*!40000 ALTER TABLE `arena_action_log` DISABLE KEYS */;
INSERT INTO `arena_action_log` VALUES (15,'Starting battle between these heroes: [Hero: Character {name=\'Tojás\', age=31, os=OS name=Win , league=DevOps}, Hero: Character {name=\'Kond\', age=32, os=OS name=MacOS , league=Backend}]',1),(15,'Starting new turn 1 for Hero: Character {name=\'Tojás\', age=31, os=OS name=Win , league=DevOps}',2),(15,'Kond has taken -10 damage, caused by being a motherfucking hipster',3),(15,'Starting new turn 2 for Hero: Character {name=\'Kond\', age=32, os=OS name=MacOS , league=Backend}',4),(15,'Tojás has taken -15 damage, caused by using TDD. Its better than sex!',5),(15,'Starting new turn 3 for Hero: Character {name=\'Tojás\', age=31, os=OS name=Win , league=DevOps}',6),(15,'Kond has taken -14 damage, caused by coding in Vim. Infinite immersion.',7),(15,'Starting new turn 4 for Hero: Character {name=\'Kond\', age=32, os=OS name=MacOS , league=Backend}',8),(16,'Starting battle between these heroes: [Hero: Character {name=\'Ben\', age=24, os=OS name=Win , league=Data Scientist}, Hero: Character {name=\'Aze\', age=28, os=OS name=MacOS , league=Backend}]',1),(16,'Starting new turn 1 for Hero: Character {name=\'Aze\', age=28, os=OS name=MacOS , league=Backend}',2),(16,'Ben has taken -14 damage, caused by using Spring Security. The enemy is confused!',3),(16,'Starting new turn 2 for Hero: Character {name=\'Ben\', age=24, os=OS name=Win , league=Data Scientist}',4),(18,'Starting battle between these heroes: [Hero: Character {name=\'Ben\', age=24, os=OS name=Win , league=Data Scientist}, Hero: Character {name=\'Aze\', age=28, os=OS name=MacOS , league=Backend}]',1),(18,'Starting new turn 1 for Hero: Character {name=\'Ben\', age=24, os=OS name=Win , league=Data Scientist}',2);
/*!40000 ALTER TABLE `arena_action_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competence`
--

DROP TABLE IF EXISTS `competence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `competence` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competence`
--

LOCK TABLES `competence` WRITE;
/*!40000 ALTER TABLE `competence` DISABLE KEYS */;
INSERT INTO `competence` VALUES (1,'Java',0),(2,'Python',0),(3,'JavaScript',0),(4,'C',0),(5,'Spring',1),(6,'Thymeleaf',1),(7,'Angular',1),(8,'Vim',1),(17,'Java',0),(18,'Python',0),(19,'JavaScript',0),(20,'C',0),(21,'Spring',1),(22,'Thymeleaf',1),(23,'Angular',1),(24,'Vim',1);
/*!40000 ALTER TABLE `competence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_character`
--

DROP TABLE IF EXISTS `game_character`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_character` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `img_source` varchar(255) DEFAULT NULL,
  `league` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `os_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKorhir5wkro6ca5psy60jblwi3` (`os_id`),
  CONSTRAINT `FKorhir5wkro6ca5psy60jblwi3` FOREIGN KEY (`os_id`) REFERENCES `os` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_character`
--

LOCK TABLES `game_character` WRITE;
/*!40000 ALTER TABLE `game_character` DISABLE KEYS */;
INSERT INTO `game_character` VALUES (5,21,'/images/frontend.jpg',1,'Jozsi',4),(6,35,'/images/backend.jpg',0,'Möthpenis',4),(7,31,'/images/devops.jpg',2,'Tojás',4),(8,26,'/images/backend.jpg',0,'Koni',3),(9,28,'/images/backend.jpg',0,'Aze',3),(10,32,'/images/frontend.jpg',1,'YipYipBarni',2),(11,51,'/images/tester.jpg',3,'Anyukám',4),(12,24,'/images/ds.jpg',4,'Ben',4),(13,32,'/images/backend.jpg',0,'Kond',3),(14,23,NULL,1,'Joe',1),(15,30,NULL,2,'Kate',2);
/*!40000 ALTER TABLE `game_character` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_character_competence`
--

DROP TABLE IF EXISTS `game_character_competence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_character_competence` (
  `character_id` bigint(20) NOT NULL,
  `competence_id` bigint(20) NOT NULL,
  KEY `FKppd79fl43vq5vfu64foq5co15` (`competence_id`),
  KEY `FKdgycjf4x6t9lc7vv4gmff23qx` (`character_id`),
  CONSTRAINT `FKdgycjf4x6t9lc7vv4gmff23qx` FOREIGN KEY (`character_id`) REFERENCES `game_character` (`id`),
  CONSTRAINT `FKppd79fl43vq5vfu64foq5co15` FOREIGN KEY (`competence_id`) REFERENCES `competence` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_character_competence`
--

LOCK TABLES `game_character_competence` WRITE;
/*!40000 ALTER TABLE `game_character_competence` DISABLE KEYS */;
INSERT INTO `game_character_competence` VALUES (5,1),(5,6),(6,1),(6,5),(7,2),(7,8),(8,1),(8,5),(9,1),(9,5),(10,3),(10,7),(11,2),(11,8),(12,2),(12,5),(13,1),(13,5);
/*!40000 ALTER TABLE `game_character_competence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hero`
--

DROP TABLE IF EXISTS `hero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hero` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `action_points_per_turn` int(11) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `current_action_points` int(11) NOT NULL,
  `currenthp` int(11) NOT NULL,
  `iq` int(11) NOT NULL,
  `max_action_points` int(11) NOT NULL,
  `maxhp` int(11) NOT NULL,
  `arena_id` bigint(20) DEFAULT NULL,
  `base_character_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeynq594ufko38jfrya31oat42` (`arena_id`),
  KEY `FK5crlg585yngyyf89x30gi1k23` (`base_character_id`),
  CONSTRAINT `FK5crlg585yngyyf89x30gi1k23` FOREIGN KEY (`base_character_id`) REFERENCES `game_character` (`id`),
  CONSTRAINT `FKeynq594ufko38jfrya31oat42` FOREIGN KEY (`arena_id`) REFERENCES `arena` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hero`
--

LOCK TABLES `hero` WRITE;
/*!40000 ALTER TABLE `hero` DISABLE KEYS */;
INSERT INTO `hero` VALUES (29,1,_binary '\0',2,35,3,10,50,15,7),(30,1,_binary '',2,26,5,10,50,15,13),(31,1,_binary '',1,36,3,10,50,16,12),(32,1,_binary '\0',1,50,5,10,50,16,9),(35,1,_binary '',1,50,3,10,50,18,12),(36,1,_binary '\0',0,50,5,10,50,18,9);
/*!40000 ALTER TABLE `hero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hero_action`
--

DROP TABLE IF EXISTS `hero_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hero_action` (
  `hero_id` bigint(20) NOT NULL,
  `action_type` int(11) DEFAULT NULL,
  `base_amount` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  KEY `FK7l8ewfocnbx03xvcxjiijhmuj` (`hero_id`),
  CONSTRAINT `FK7l8ewfocnbx03xvcxjiijhmuj` FOREIGN KEY (`hero_id`) REFERENCES `hero` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hero_action`
--

LOCK TABLES `hero_action` WRITE;
/*!40000 ALTER TABLE `hero_action` DISABLE KEYS */;
INSERT INTO `hero_action` VALUES (29,1,7,'scraping the hell out of the internet','Scraper'),(29,1,6,'writing the Wanderer game in 12 lines','Short code'),(29,1,3,'clapping two coconut-halves together and imitating horse-riding','Monthy Python'),(29,1,4,'hissing like a sneiky boi. Enemy is hekin bamboozled!','Danger noodle'),(29,1,7,'coding in Vim. Infinite immersion.','Vim code'),(29,1,3,'being a motherfucking hipster','Hipster'),(30,1,5,'using TDD. Its better than sex!','TDD'),(30,1,6,'cross platform language','Cross-platform'),(30,1,3,'HTTP ERROR CODE 418 Im a teapot','Teapot'),(30,1,5,'injecting the hell out of dependencies','DI (Y?)'),(30,1,6,'using Spring Security. The enemy is confused!','Spring Security'),(31,1,7,'scraping the hell out of the internet','Scraper'),(31,1,6,'writing the Wanderer game in 12 lines','Short code'),(31,1,3,'clapping two coconut-halves together and imitating horse-riding','Monthy Python'),(31,1,4,'hissing like a sneiky boi. Enemy is hekin bamboozled!','Danger noodle'),(31,1,3,'HTTP ERROR CODE 418 Im a teapot','Teapot'),(31,1,5,'injecting the hell out of dependencies','DI (Y?)'),(31,1,6,'using Spring Security. The enemy is confused!','Spring Security'),(32,1,5,'using TDD. Its better than sex!','TDD'),(32,1,6,'cross platform language','Cross-platform'),(32,1,3,'HTTP ERROR CODE 418 Im a teapot','Teapot'),(32,1,5,'injecting the hell out of dependencies','DI (Y?)'),(32,1,6,'using Spring Security. The enemy is confused!','Spring Security'),(35,1,7,'scraping the hell out of the internet','Scraper'),(35,1,6,'writing the Wanderer game in 12 lines','Short code'),(35,1,3,'clapping two coconut-halves together and imitating horse-riding','Monthy Python'),(35,1,4,'hissing like a sneiky boi. Enemy is hekin bamboozled!','Danger noodle'),(35,1,7,'ice','Coool'),(35,1,3,'HTTP ERROR CODE 418 Im a teapot','Teapot'),(35,1,5,'injecting the hell out of dependencies','DI (Y?)'),(35,1,6,'using Spring Security. The enemy is confused!','Spring Security'),(36,1,5,'using TDD. Its better than sex!','TDD'),(36,1,6,'cross platform language','Cross-platform'),(36,1,6,'flame','Flamma'),(36,1,3,'HTTP ERROR CODE 418 Im a teapot','Teapot'),(36,1,5,'injecting the hell out of dependencies','DI (Y?)'),(36,1,6,'using Spring Security. The enemy is confused!','Spring Security');
/*!40000 ALTER TABLE `hero_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `os`
--

DROP TABLE IF EXISTS `os`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `os` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `iqmodifier` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os`
--

LOCK TABLES `os` WRITE;
/*!40000 ALTER TABLE `os` DISABLE KEYS */;
INSERT INTO `os` VALUES (1,3,'debian'),(2,1,'ubuntu'),(3,0,'MacOS'),(4,-2,'Win'),(9,3,'debian'),(10,1,'ubuntu'),(11,0,'MacOS'),(12,-2,'Win');
/*!40000 ALTER TABLE `os` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-17 13:38:05
