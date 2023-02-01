DROP TRIGGER IF EXISTS crearCheques;
CREATE TRIGGER crearCheques
ON chequera
AFTER INSERT
AS
BEGIN
    DECLARE @i INT = 1;
    DECLARE @x INT = 2;
    DECLARE @idchequera INT = 0;

    SET @idchequera = (SELECT id FROM inserted);

    SET @x = (SELECT cantidad FROM inserted);

    WHILE (@i <= @x)
    BEGIN
        INSERT INTO cheque (estado, id_chequera, total)
        VALUES (1, @idChequera, 0);

        SET @i = @i + 1;
    END;
END;