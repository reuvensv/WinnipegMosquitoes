CREATE TABLE `data_portal` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `trapid` varchar(255) NOT NULL,
  `mosquitoes` int unsigned NOT NULL,
  `location` enum('NORTH_WEST','NORTH_EAST','SOUTH_WEST','SOUTH_EAST','RURAL') NOT NULL,
  `timestamp` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
