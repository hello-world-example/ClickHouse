# ClickHouse 


```
cp ../ClickHouse/README.md .
cp -r ../ClickHouse/HuGo/themes/book ./HuGo/themes
cp -r ../ClickHouse/HuGo/config.* ./HuGo
cp -r ../ClickHouse/HuGo/assets ./HuGo
sed -i '' 's/ClickHouse/_NewProject_/g' `grep ClickHouse --include=\*.{md,html,xml,yaml,toml} -rl .`

git config user.email ykb553@163.com
git config -l | grep user

# 更新主题模块
# git submodule add -f https://github.com/o-fork/hugo-book HuGo/themes/book
$ git submodule init
$ git submodule update

# 本地服务
hugo server -s HuGo/

# 生成静态站点
hugo -s HuGo/
```
