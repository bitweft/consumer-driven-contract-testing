DROP TABLE IF EXISTS billing_information;
Create table billing_information(user_id VARCHAR(100) NOT NULL, plan_start_date BIGINT, plan_end_date BIGINT, PRIMARY KEY(user_id));