CREATE TABLE employee(
    eid BIGINT NOT NULL AUTO_INCREMENT COMMENT '员工id，10001开始，默认的账号',
    name VARCHAR(120) NOT NULL  COMMENT '员工姓名',
    salary FLOAT NOT NULL DEFAULT 0 COMMENT '员工基本工资',
    password VARCHAR(30) NOT NULL COMMENT '员工密码，规则：姓名拼音',
    did INT NOT NULL COMMENT '部门号，外键',
    PRIMARY KEY (eid),
    FOREIGN KEY (did) REFERENCES department(did)
)ENGINE =InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='用户数据表';

CREATE TABLE department(
    did INT NOT NULL AUTO_INCREMENT COMMENT '部门id,11001，默认账号',
    name VARCHAR(120) NOT NULL COMMENT '部门名称',
    password VARCHAR(30) NOT NULL COMMENT '部门登录密码',
    PRIMARY KEY (did)
)ENGINE =InnoDB AUTO_INCREMENT=11000 DEFAULT CHARSET=utf8 COMMENT ='部门表';

CREATE TABLE salary(
    sid BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id,自增',
    eid BIGINT NOT NULL COMMENT '外键：eid',
    salary FLOAT NOT NULL DEFAULT 0 COMMENT '员工基本工资',
    fine FLOAT COMMENT '处罚金额',
    bonus FLOAT COMMENT '奖金',
    tax FLOAT COMMENT '税收',
    realsalary FLOAT NOT NULL DEFAULT 0 COMMENT '计算后的实际工资',
    date TIMESTAMP NOT NULL DEFAULT current_timestamp,
    PRIMARY KEY (sid),
    FOREIGN KEY (eid) REFERENCES employee(eid)
)ENGINE =InnoDB DEFAULT CHARSET=utf8 COMMENT ='工资单条记录';


CREATE TABLE transfer(
    tid BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id自增',
    eid BIGINT COMMENT '外键员工id',
    old INT NOT NULL DEFAULT -1 COMMENT '原部门id，-1表示新员工',
    new INT NOT NULL DEFAULT -1 COMMENT '新部门id，-1表示开除，0表示退休',
    DATE TIMESTAMP NOT NULL DEFAULT current_timestamp,
    PRIMARY KEY (tid),
    FOREIGN KEY (eid) REFERENCES employee(eid)
)ENGINE =InnoDB DEFAULT CHARSET =utf8 COMMENT '职务调度记录表';


CREATE TABLE absence(
    aid BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id,自增',
    eid BIGINT COMMENT '外键：员工Id',
    starttime TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '缺勤开始时间',
    endtime TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '缺勤结束时间',
    state int NOT NULL DEFAULT 0 COMMENT '缺勤类型',
    description VARCHAR(256) COMMENT '缺勤描述',
    PRIMARY KEY (aid),
    FOREIGN KEY (eid) REFERENCES employee(eid)
)ENGINE InnoDB DEFAULT CHARSET utf8 COMMENT ='缺勤记录表';

