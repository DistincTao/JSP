-- 삽입
INSERT INTO BOARD
VALUES ("NUM", "TITLE", "WRITER", "CONTENT", "REGDATE", "CNT");


SELECT "NUM", "TITLE", "WRITER", "CONTENT", "REGDATE", "CNT"
  FROM BOARD; 
  
  
UPDATE BOARD
   SET TITLE = ?, CONTENT = ?
 WHERE BOARD;
 
 