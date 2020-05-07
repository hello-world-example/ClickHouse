# Docker 方式安装 ClickHouse 

## clickhouse-server 

```bash
$ docker pull yandex/clickhouse-server:20.3.8.53

# -v :/var/lib/clickhouse
# -v :/etc/clickhouse-server/config.xml
# 8123 https://clickhouse.tech/docs/v20.3/en/interfaces/http/
# 9000 https://clickhouse.tech/docs/v20.3/en/interfaces/cli/
# 9004 https://clickhouse.tech/docs/v20.3/en/interfaces/mysql/
$ docker run -d --name clickhouse-server \
  --ulimit nofile=262144:262144 \
  -p 8123:8123 \
  -p 9000:9000 \
  -p 9004:9004 \
  -e TZ="Asia/Shanghai" \
  yandex/clickhouse-server:20.3.8.53

# 官方文档： https://clickhouse.tech/docs/en/interfaces/http/
$ curl 'http://localhost:8123/'
Ok.

$ echo 'SELECT now()' | curl 'http://localhost:8123/?query=' --data-binary @-
2020-05-05 22:07:11

$ echo 'SELECT now() FORMAT Pretty' | curl 'http://localhost:8123/?query=' --data-binary @-
┏━━━━━━━━━━━━━━━━━━━━━┓
┃               now() ┃
┡━━━━━━━━━━━━━━━━━━━━━┩
│ 2020-05-05 22:08:00 │
└─────────────────────┘
```

## clickhouse-client

> - [Command-line Client](https://clickhouse.tech/docs/en/interfaces/cli/) 

```bash
$ docker pull yandex/clickhouse-client:20.3.8.53

$ docker run -it --rm --link clickhouse-server yandex/clickhouse-client:20.3.8.53 --host clickhouse-server

ClickHouse client version 20.3.8.53 (official build).
Connecting to clickhouse-server:9000 as user default.
Connected to ClickHouse server version 20.3.8 revision 54433.

:) help
Expected one of: ALTER query, Query with output, ANALYZE, TRUNCATE, KILL, 
KILL QUERY query, ALTER ROLE, SELECT subquery, DESCRIBE query, SHOW GRANTS, SHOW CREATE,
SHOW PROCESSLIST query, WATCH, ALTER USER, ALTER POLICY, CREATE VIEW query, CHECK TABLE,
SET ROLE, SELECT query, SELECT, CREATE DICTIONARY, CREATE USER, REVOKE, 
SET ROLE DEFAULT, SHOW POLICIES query, SYSTEM, ALTER LIVE VIEW, DROP query, 
OPTIMIZE query, RENAME TABLE, USE, SHOW, DETACH, DESC, SET, DROP QUOTA query, 
OPTIMIZE TABLE, SET DEFAULT ROLE, CREATE ROW POLICY, CREATE POLICY, ALTER ROW POLICY,
INSERT query, INSERT INTO, AST, SHOW QUOTA query, SHOW QUOTA USAGE, SHOW POLICIES, 
SHOW ROW POLICIES, GRANT, RENAME query, SHOW GRANTS query, EXISTS, DROP, 
CREATE LIVE VIEW query, SYSTEM query, SHOW PROCESSLIST, CREATE QUOTA, ALTER QUOTA, 
list of elements, CREATE DATABASE query, SET query, Query, CREATE, SHOW QUOTAS, WITH, 
EXISTS or SHOW CREATE query, WATCH query, CREATE ROLE, SHOW CREATE QUOTA query, 
USE query, ALTER TABLE, ATTACH, DESCRIBE, GRANT or REVOKE query, SELECT query, 
possibly with UNION, SELECT query, subquery, possibly with UNION, 
SHOW [TEMPORARY] TABLES|DATABASES [[NOT] LIKE 'str'] [LIMIT expr], 
CREATE QUOTA or ALTER QUOTA query, CREATE ROW POLICY or ALTER ROW POLICY query, 
CREATE ROLE or ALTER ROLE query, SET ROLE or SET DEFAULT ROLE query, 
CREATE USER or ALTER USER query, CREATE TABLE or ATTACH TABLE query

:)  select now()
┌───────────────now()─┐
│ 2020-05-05 21:59:04 │
└─────────────────────┘

:) show databases
┌─name────┐
│ default │
│ system  │
└─────────┘

:) use system
Ok.

:) show tables
┌─name───────────────────────────┐
│ aggregate_function_combinators │
│ data_type_families             │
│ databases                      │
..
│ zeros                          │
│ zeros_mt                       │
└────────────────────────────────┘
```




## Read More

- Docker Hub [yandex/clickhouse-server](https://hub.docker.com/r/yandex/clickhouse-server)

