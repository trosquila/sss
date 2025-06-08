-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-06-2025 a las 10:00:00
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectoSSSBaseDatos`
--
CREATE DATABASE IF NOT EXISTS `proyectoSSSBaseDatos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `proyectoSSSBaseDatos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carexpense`
--

CREATE TABLE `carexpense` (
  `idExpense` int(11) NOT NULL,
  `mileage` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `expenseConcept` varchar(100) NOT NULL,
  `idCar` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `carexpense`
--

INSERT INTO `carexpense` (`idExpense`, `mileage`, `price`, `expenseConcept`, `idCar`, `idUser`, `date`) VALUES
(1, 45000, 45, 'Aceite', 1, 1, '2025-06-08 08:00:00'),
(2, 60000, 120, 'Cambio de neumáticos', 2, 2, '2025-06-08 08:05:00'),
(3, 30000, 80, 'Revisión general', 3, 3, '2025-06-08 08:10:00'),
(4, 75000, 200, 'Frenos', 4, 1, '2025-06-08 08:15:00'),
(5, 20000, 90, 'Batería', 5, 2, '2025-06-08 08:20:00'),
(6, 50000, 350, 'Seguro', 6, 3, '2025-06-08 08:25:00'),
(7, 65000, 60, 'ITV', 7, 1, '2025-06-08 08:30:00'),
(8, 40000, 55, 'Cambio de filtros', 8, 2, '2025-06-08 08:35:00'),
(9, 55000, 180, 'Reparaciones mecánicas', 9, 3, '2025-06-08 08:40:00'),
(10, 35000, 30, 'Cambio de luces', 10, 1, '2025-06-08 08:45:00'),
(11, 70000, 75, 'Alineación y balanceo', 11, 2, '2025-06-08 08:50:00'),
(12, 25000, 25, 'Lavado y mantenimiento estético', 12, 3, '2025-06-08 08:55:00'),
(13, 48000, 110, 'Sistema eléctrico', 13, 1, '2025-06-08 09:00:00'),
(14, 52000, 65, 'Cambio de líquidos refrigerantes', 14, 2, '2025-06-08 09:05:00'),
(15, 58000, 220, 'Amortiguadores y suspensión', 15, 3, '2025-06-08 09:10:00'),
(16, 42000, 50, 'Gasolina', 16, 1, '2025-06-08 09:15:00'),
(17, 67000, 95, 'Cambio de neumáticos', 17, 2, '2025-06-08 09:20:00'),
(18, 38000, 70, 'Revisión general', 18, 3, '2025-06-08 09:25:00'),
(19, 62000, 150, 'Frenos', 19, 1, '2025-06-08 09:30:00'),
(20, 29000, 85, 'Batería', 20, 2, '2025-06-08 09:35:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cars`
--

CREATE TABLE `cars` (
  `id` int(11) NOT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `licensePlate` varchar(20) NOT NULL,
  `engine` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `insuranceCompany` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cars`
--

INSERT INTO `cars` (`id`, `brand`, `model`, `licensePlate`, `engine`, `year`, `insuranceCompany`) VALUES
(1, 'Volkswagen', 'Golf', '1234 ABC', '1.9 TDI', 2005, 'MAPFRE'),
(2, 'Renault', 'Megane', '2345 BCD', '1.5 dCi', 2006, 'AXA'),
(3, 'Peugeot', '307', '3456 CDE', '1.6 HDi', 2007, 'ALLIANZ'),
(4, 'Ford', 'Focus', '4567 DEF', '1.8 TDCi', 2008, 'GENERALI'),
(5, 'Opel', 'Astra', '5678 EFG', '1.7 CDTI', 2009, 'SANITAS'),
(6, 'Seat', 'Leon', '6789 FGH', '2.0 TDI', 2010, 'PELAYO'),
(7, 'Audi', 'A3', '7890 GHI', '1.9 TDI', 2005, 'MUTUA MADRILEÑA'),
(8, 'BMW', 'Serie 3', '8901 HIJ', '2.0 d', 2006, 'CASER'),
(9, 'Mercedes', 'Clase C', '9012 IJK', '2.2 CDI', 2007, 'LINEA DIRECTA'),
(10, 'Toyota', 'Corolla', '0123 JKL', '1.4 D-4D', 2008, 'VERTI'),
(11, 'Honda', 'Civic', '1234 KLM', '2.2 i-CTDi', 2009, 'FIDELIDAD'),
(12, 'Nissan', 'Almera', '2345 LMN', '1.5 dCi', 2010, 'REALE'),
(13, 'Citroën', 'C4', '3456 MNO', '1.6 HDi', 2005, 'HELVETIA'),
(14, 'Fiat', 'Stilo', '4567 NOP', '1.9 JTD', 2006, 'LÍBERO'),
(15, 'Skoda', 'Octavia', '5678 OPQ', '1.9 TDI', 2007, 'WÜRTH'),
(16, 'Hyundai', 'i30', '6789 PQR', '1.6 CRDi', 2008, 'ZURICH'),
(17, 'Kia', 'Ceed', '7890 QRS', '1.6 CRDi', 2009, 'RACC'),
(18, 'Mazda', '3', '8901 RST', '2.0 MZR-CD', 2010, 'GES'),
(19, 'Volvo', 'S40', '9012 STU', '2.0 D', 2005, 'ATLANTICA'),
(20, 'Mitsubishi', 'Lancer', '0123 TUV', '1.8 DI-D', 2006, 'AGROBANCO'),
(21, 'Subaru', 'Impreza', '1234 UVW', '2.0 Boxer Diesel', 2007, 'ARAG'),
(22, 'Alfa Romeo', '147', '2345 VWX', '1.9 JTD', 2008, 'HNA'),
(23, 'Chevrolet', 'Aveo', '3456 WXY', '1.3 CDTI', 2009, 'AIG'),
(24, 'Dacia', 'Logan', '4567 XYZ', '1.5 dCi', 2010, 'GOTTA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `owners`
--

CREATE TABLE `owners` (
  `id_owners` int(11) NOT NULL,
  `car_id` int(11) NOT NULL,
  `user_uuid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `owners`
--

INSERT INTO `owners` (`id_owners`, `car_id`, `user_uuid`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 1),
(5, 5, 2),
(6, 6, 3),
(7, 7, 1),
(8, 8, 2),
(9, 9, 3),
(10, 10, 1),
(11, 11, 2),
(12, 12, 3),
(13, 13, 1),
(14, 14, 2),
(15, 15, 3),
(16, 16, 1),
(17, 17, 2),
(18, 18, 3),
(19, 19, 1),
(20, 20, 2),
(21, 21, 3),
(22, 22, 1),
(23, 23, 2),
(24, 24, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `UUID` int(11) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carexpense`
--
ALTER TABLE `carexpense`
  ADD PRIMARY KEY (`idExpense`);

--
-- Indices de la tabla `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `licensePlate` (`licensePlate`);

--
-- Indices de la tabla `owners`
--
ALTER TABLE `owners`
  ADD PRIMARY KEY (`id_owners`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UUID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carexpense`
--
ALTER TABLE `carexpense`
  MODIFY `idExpense` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `cars`
--
ALTER TABLE `cars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `owners`
--
ALTER TABLE `owners`
  MODIFY `id_owners` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `UUID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;