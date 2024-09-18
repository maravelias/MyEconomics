WITH latest_transactions AS (SELECT ei.trader_id                              as trader_id,
                                    t.title                                   as title,
                                    - SUM(ei.ammount)                           as ammount,
                                    'Credit'                                  as type,
                                    MAX(ei.transaction_date)                  AS latest_transaction_date,
                                    (CURRENT_DATE - MAX(ei.transaction_date)) AS days_since_last_transaction,
                                    COALESCE(MAX(t.credit_days), 0)           as credit_days

                             FROM myec_expense_invoice as ei
                                      JOIN
                                  myec_trader as t ON ei.trader_id = t.id
                             GROUP BY ei.trader_id,
                                      t.title
                             UNION ALL
                             SELECT bt.trader_id                              as trader_id,
                                    t.title                                   as title,
                                    sum(bt.ammount)                           as ammount,
                                    'Debit'                                   as type,
                                    MAX(bt.transaction_date)                  AS latest_transaction_date,
                                    (CURRENT_DATE - MAX(bt.transaction_date)) AS days_since_last_transaction,
                                    COALESCE(MAX(t.credit_days), 0)           as credit_days

                             FROM myec_bank_transaction as bt
                                      JOIN myec_trader as t ON bt.trader_id = t.id
                             WHERE transaction_type like 'TRANSFER_TO_TRADER'
                             GROUP BY bt.trader_id,
                                      t.title)
SELECT
    lt.trader_id,
    lt.title,
    SUM(lt.ammount) as balance,
    (
        select MAX(temp_transactions.latest_transaction_date)
        from latest_transactions as temp_transactions
        where temp_transactions.type like 'Credit' and temp_transactions.trader_id = lt.trader_id
    )as latest_transaction_date ,

    (CURRENT_DATE - (
        select MAX(temp_transactions.latest_transaction_date)
        from latest_transactions as temp_transactions
        where temp_transactions.type like 'Credit' and temp_transactions.trader_id = lt.trader_id
    )


        ) AS days_since_last_transaction



FROM latest_transactions as lt
GROUP BY lt.trader_id,
         lt.title