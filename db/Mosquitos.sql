CREATE TABLE `Mosquito` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `trapid` varchar(45) NOT NULL,
  `mosquitoes` int unsigned NOT NULL,
  `sector` enum('NORTH_WEST','NORTH_EAST','SOUTH_WEST','SOUTH_EAST','RURAL') NOT NULL,
  `created_at` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
