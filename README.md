# dmgr-model-import说明文档
## 功能描述

- 从配置的excel模板中导入到db库,一个sheet对应数据库的一个表,sheet名即表明.

- sheet内列名即db库一张表的字段名,可根据单元格的数据格式导入到数据库中,比如:你需要导入的格式为日期格式,那么就把excel那一列的格式调整为日期格式.

- 如果你需要根据excel里的数据再做一些转化,转化逻辑可以写在controller层.

## 统一导数主方法入口

- cn.cpic.dmgr.export.**ModelImortManager**
## 统一导数配置模板
- *统一接入模板-生产-YYYYMMDD变更.xlsx* 导数的模板,复制到本地目录后填好自己需要导数的模型,更改主方法里面的Excel文件路径后跑数
## 数据库配置文件
- config.properties
## 增加配置字段
- 可以在Excel加一列,并在对应的Mappper.xml加上
# 常见错误问题及处理




