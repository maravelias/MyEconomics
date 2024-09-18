WITH latest_transactions AS (
    SELECT 
        ei.trader_id AS trader_id,
        t.title AS title,
        -SUM(ei.ammount) AS amount,
        'Credit' AS type,
        MAX(ei.transaction_date) AS latest_transaction_date,
        (CURRENT_DATE - MAX(ei.transaction_date)) AS days_since_last_transaction,
        COALESCE(MAX(t.credit_days), 0) AS credit_days
    FROM 
        myec_expense_invoice ei
    JOIN 
        myec_trader t ON ei.trader_id = t.id
    GROUP BY 
        ei.trader_id, t.title
    UNION ALL
    SELECT 
        bt.trader_id AS trader_id,
        t.title AS title,
        SUM(bt.ammount) AS amount,
        'Debit' AS type,
        MAX(bt.transaction_date) AS latest_transaction_date,
        (CURRENT_DATE - MAX(bt.transaction_date)) AS days_since_last_transaction,
        COALESCE(MAX(t.credit_days), 0) AS credit_days
    FROM 
        myec_bank_transaction bt
    JOIN 
        myec_trader t ON bt.trader_id = t.id
    WHERE 
        transaction_type LIKE 'TRANSFER_TO_TRADER'
    GROUP BY 
        bt.trader_id, t.title
),
latest_credit_transactions AS (
    SELECT 
        trader_id,
        MAX(latest_transaction_date) AS latest_transaction_date
    FROM 
        latest_transactions
    WHERE 
        type = 'Credit'
    GROUP BY 
        trader_id
)
SELECT
    lt.trader_id,
    lt.title,
    SUM(lt.amount) AS balance,
    lct.latest_transaction_date,
    (CURRENT_DATE - lct.latest_transaction_date) AS days_since_last_transaction
FROM 
    latest_transactions lt
JOIN 
    latest_credit_transactions lct ON lt.trader_id = lct.trader_id
GROUP BY 
    lt.trader_id, lt.title, lct.latest_transaction_date;