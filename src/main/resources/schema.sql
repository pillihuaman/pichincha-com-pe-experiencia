CREATE TABLE TIPO_CAMBIO (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(255) NOT NULL,
    monto_inicial DECIMAL(20, 4) NOT NULL,
    monto_final DECIMAL(20, 4) NOT NULL,
    moneda_origen VARCHAR(10) NOT NULL,
    moneda_destino VARCHAR(10) NOT NULL,
    tipo_cambio DECIMAL(20, 4) NOT NULL,
    fecha_proceso TIMESTAMP NOT NULL
);