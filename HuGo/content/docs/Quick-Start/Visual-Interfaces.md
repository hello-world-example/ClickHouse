# ClickHouse 可视化

## Tabix

> - https://tabix.io/doc/

```bash
$ docker exec -it clickhouse-server bash

# 编辑配置文件，打开  <http_server_default_response> 标签的注释即可
$ vim /etc/clickhouse-server/config.xml

# 重启 clickhouse-server
$ docker restart clickhouse-server

# 访问 http://localhost:8123/， 返回的不再是 Ok.
# ❤❤❤ 用户名 默认为 default，密码留空 ❤❤❤
```

## Grafana

> https://grafana.com/grafana/plugins/vertamedia-clickhouse-datasource
>
> https://github.com/Vertamedia/clickhouse-grafana

```bash
$ docker run -d --name grafana -p 3000:3000 

$ docker exec -it grafana bash
# 安装 vertamedia-clickhouse-datasource 数据源插件
> grafana-cli plugins install vertamedia-clickhouse-datasource

# 重启生效
$ docker restart grafana
```

## DbVisualizer

https://dbvis.com/download/



## Read More

- [Visual Interfaces from Third-party Developers](https://clickhouse.tech/docs/en/interfaces/third-party/gui/)