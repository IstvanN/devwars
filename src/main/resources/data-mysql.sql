INSERT INTO `os` (`iqmodifier`, `name`) VALUES (3, 'debian');
INSERT INTO `os` (`iqmodifier`, `name`) VALUES (1, 'ubuntu');
INSERT INTO `os` (`iqmodifier`, `name`) VALUES (0, 'MacOS');
INSERT INTO `os` (`iqmodifier`, `name`) VALUES (-2, 'Win');

INSERT INTO `competence` (`description`, `type`) VALUES ('Java', '0');
INSERT INTO `competence` (`description`, `type`) VALUES ('Python', '0');

INSERT INTO `action` (`action_type`, `base_amount`, `description`, `name`, `required_competence_id`) VALUES ('1', '6', 'flame', 'Flamma', '1');
INSERT INTO `action` (`action_type`, `base_amount`, `description`, `name`, `required_competence_id`) VALUES ('1', '7', 'ice', 'Coool', '2');

INSERT INTO `game_character` (`age`, `league`, `name`, `os_id`) VALUES ('23', '1', 'Joe', '1');
INSERT INTO `game_character` (`age`, `league`, `name`, `os_id`) VALUES ('30', '2', 'Kate', '2');

INSERT INTO `game_character_competence` (`character_id`, `competence_id`) VALUES (1, 1)
INSERT INTO `game_character_competence` (`character_id`, `competence_id`) VALUES (2, 2)