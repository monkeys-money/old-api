-- Cadastrar os dados do usuário

INSERT INTO USER (user_id, 
                  username, 
                  email, 
                  password, 
                  date_creation, 
                  date_update)
          VALUES (user_user_id_SEQ.nextval,
                  "lhsribas",
                  "lhs.ribas@gmail.com",
                  "teste@123",
                  sysdate,
                  NULL);

INSERT INTO USER (user_id, 
                  username, 
                  email, 
                  password, 
                  date_creation, 
                  date_update)
          VALUES (user_user_id_SEQ.nextval,
                  "camilhomem",
                  "camilhomem@gmail.com",
                  "teste@123",
                  sysdate,
                  NULL);

-- Cadastrar os dados para a conta do usuário.

INSERT INTO PROFILE (profile_id,
                     user_id,
                     fisrt_name,
                     middle_name,
                     last_name,
                     born_date,
                     gender,
                     date_creation,
                     date_update)
             VALUES (profile_profile_id_SEQ.nextval,
                     1,
                     "Luiz Hnerique",
                     "de Sousa",
                     "Ribas",
                     TO_DATE('1986/11/07', 'yyyy/mm/dd'),
                     "MASCULINO",
                     sysdate,
                     NULL)

INSERT INTO PROFILE (profile_id,
                     user_id,
                     fisrt_name,
                     middle_name,
                     last_name,
                     born_date,
                     gender,
                     date_creation,
                     date_update)
             VALUES (profile_profile_id_SEQ.nextval,
                     2,
                     "Camilla",
                     "",
                     "Milhomem",
                     TO_DATE('1990/11/02', 'yyyy/mm/dd'),
                     "FEMININO",
                     sysdate,
                     NULL)

-- Alterar todos os dados do usuário, utilizando seu código como referência.

UPDATE USER
   SET username = "junoely", 
       email = "juliana.noely@gmail.com", 
       password = "teste@teste@123",
       date_update = sysdate
 WHERE user_id = 1

UPDATE PROFILE
   SET fisrt_name = "Juliana",
       middle_name = "Ferreira",
       last_name = "Noely",
       born_date = TO_DATE('1990/11/02', 'yyyy/mm/dd'),
       gender = "FEMININO",
       date_update = sysdate
 WHERE profile_id = 1

-- Cadastrar as receitas do usuário.

INSERT INTO REVENUE (revenue_id,
                     user_id,
                     revenue,
                     description,
                     value,
                     date_revenue,
                     date_creation,
                     date_update)
             VALUES (revenue_revenue_id_SEQ.nextval,
                     1,
                     "Freelancer Portal Kubbee TEch",
                     "Freelancer Realizado para a empresa Kubbee Tech",
                     10000.00
                     TO_DATE('2022/10/01 13:02:44', 'yyyy/mm/dd hh24:mi:ss'),
                     sysdate,
                     NULL)

INSERT INTO REVENUE (revenue_id,
                     user_id,
                     revenue,
                     description,
                     value,
                     date_revenue,
                     date_creation,
                     date_update)
             VALUES (revenue_revenue_id_SEQ.nextval,
                     2,
                     "Cesta de Café da Manhã",
                     "Lote de cestas de café da manhã para empresa Kubbee Tech",
                     2000.00
                     TO_DATE('2022/10/10 10:05:44', 'yyyy/mm/dd hh24:mi:ss'),
                     sysdate,
                     NULL)

-- Alterar todos os dados das receitas do usuário, utilizando o código como referência.

UPDATE REVENUE
   SET revenue = "Venda Guitarra Gibson",
       description = "Venda Guitarra Gibson Les Paul Black Faded",
       value = 15000.00,
       date_revenue = TO_DATE('2022/10/10 10:05:44', 'yyyy/mm/dd hh24:mi:ss'),
       date_update = sysdate
 WHERE revenue_id = 1

-- Cadastrar as despesas do usuário.

INSERT INTO EXPENDITURE (expenditure_id,
                         user_id,
                         expenditure,
                         description,
                         value,
                         date_expenditure,
                         date_creation,
                         date_update)
                 VALUES (expenditure_expenditure_id_SEQ.nextval,
                         1,
                         "Tenis Nike",
                         "Tenis Nike Branco Basquete Tamanho 45",
                         700.00,
                         TO_DATE('2022/10/16 13:02:44', 'yyyy/mm/dd hh24:mi:ss'),
                         sysdate,
                         NULL)

INSERT INTO EXPENDITURE (expenditure_id,
                         user_id,
                         expenditure,
                         description,
                         value,
                         date_expenditure,
                         date_creation,
                         date_update)
                 VALUES (expenditure_expenditure_id_SEQ.nextval,
                         2,
                         "Bolsa Lelis Blanc",
                         "Bolsa de Mão Preta Lelis Blanc",
                         5000.00,
                         TO_DATE('2022/10/14 09:02:44', 'yyyy/mm/dd hh24:mi:ss'),
                         sysdate,
                         NULL)

-- Alterar todos os dados das despesas do usuário, utilizando o código como referência.

UPDATE EXPENDITURE 
   SET expenditure = "Tenis Adidas",
       description = "Tenis Adidas Preto Basquete Tamanho 45",
       value = 850.00,
       date_expenditure = TO_DATE('2022/10/14 09:02:44', 'yyyy/mm/dd hh24:mi:ss'),
       date_update = sysdate
 WHERE expenditure_id = 1

-- Cadastrar os dados para investimentos.

INSERT INTO INVESTIMENT (investiment_id,
                         user_id,
                         investiment,
                         description,
                         value,
                         date_investiment,
                         date_creation,
                         date_update)
                 VALUES (investiment_investiment_id_SEQ.nextval,
                         1,
                         "Stock Microsoft",
                         "Investiment in the Microsoft",
                         10000.00
                         TO_DATE('2022/10/01 13:02:44', 'yyyy/mm/dd hh24:mi:ss'),
                         sysdate,
                         NULL)

INSERT INTO INVESTIMENT (investiment_id,
                         user_id,
                         investiment,
                         description,
                         value,
                         date_investiment,
                         date_creation,
                         date_update)
                 VALUES (investiment_investiment_id_SEQ.nextval,
                         1,
                         "Stock Amazon",
                         "Investiment in the Amazon",
                         10000.00
                         TO_DATE('2022/10/01 13:02:44', 'yyyy/mm/dd hh24:mi:ss'),
                         sysdate,
                         NULL);

-- Alterar todos os dados para investimentos do usuário, utilizando o código como referência.

UPDATE INVESTIMENT 
   SET investiment = "Stock Apple",
       description = "Investiment in the Apple",
       value = 20000.00,
       date_investiment = TO_DATE('2022/10/15 13:02:44', 'yyyy/mm/dd hh24:mi:ss'),
       date_update = sysdate
 WHERE investiment_id = 1;

-- Consultar os dados de um usuário (filtrar a partir do seu código).
-- select user 1
SELECT * 
  FROM USER u 
 WHERE u.user_id = 1;

-- select user 2
SELECT * 
  FROM USER u 
 WHERE u.user_id = 2;

-- select user 1 with profile
    SELECT *
      FROM USER u 
INNER JOIN PROFILE p 
        ON u.user_id = p.user_id
     WHERE u.user_id = 1;

-- select user 2 with profile
    SELECT *
      FROM USER u 
INNER JOIN PROFILE p 
        ON u.user_id = p.user_id
     WHERE u.user_id = 2;

-- Consultar os dados de um único registro de despesa de um usuário (filtrar a partir do código do usuário e do código da despesa).
    SELECT *
      FROM EXPENDITURE e
INNER JOIN USER u
        ON e.user_id = u.user_id
     WHERE e.expenditure_id = 1
       AND e.user_id = 1

-- Consultar os dados de todos os registros de despesas de um usuário, ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código).
SELECT *
      FROM EXPENDITURE e
INNER JOIN USER u
        ON e.user_id = u.user_id
     WHERE e.user_id = 1
  ORDER BY e.date_creation DESC


-- Consultar os dados de um único registro de investimento de um usuário (filtrar a partir do código do usuário e do código de investimento.
    SELECT *
      FROM INVESTIMENT i
INNER JOIN USER u
        ON i.user_id = u.user_id
     WHERE i.investiment_id = 1
       AND i.user_id = 1


-- Consultar os dados de todos os registros de investimentos de um usuário, ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código).

    SELECT *
      FROM INVESTIMENT i
INNER JOIN USER u
        ON i.user_id = u.user_id
     WHERE i.user_id = 1
  ORDER BY i.date_creation DESC;

-- Consultar os dados básicos de um usuário, o último investimento registrado e a última despesa registrada (filtrar a partir do código de usuário – consulta necessária para o dashboard. Dica: veja consulta com junções).

    SELECT u.username, 
           u.email,
           i.*,
           e.*
      FROM USER u
INNER JOIN EXPENDITURE e
        ON u.user_id = e.user_id
INNER JOIN INVESTIMENT i
        ON u.user_id = i.user_id
     WHERE e.expenditure_id = (SELECT max(ee.expenditure_id) FROM EXPENDITURE ee WHERE ee.user_id = 1)
       AND i.investiment_id = (SELECT max(ii.investiment_id) FROM INVESTIMENT ii WHERE ii.user_id = 1);