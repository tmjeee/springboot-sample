CREATE TABLE IF NOT EXISTS `user` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(50),
    `email` varchar(50),
    `dateOfBirth` timestamp
);

INSERT INTO `user` (`name`, `email`, `dateOfBirth`) VALUES ( 'user1', 'user1@gmail.com', current_timestamp());
INSERT INTO `user` (`name`, `email`, `dateOfBirth`) VALUES ( 'user2', 'user1@gmail.com', current_timestamp());
INSERT INTO `user` (`name`, `email`, `dateOfBirth`) VALUES ( 'user3', 'user1@gmail.com', current_timestamp());
INSERT INTO `user` (`name`, `email`, `dateOfBirth`) VALUES ( 'user4', 'user1@gmail.com', current_timestamp());
INSERT INTO `user` (`name`, `email`, `dateOfBirth`) VALUES ( 'user5', 'user1@gmail.com', current_timestamp());
