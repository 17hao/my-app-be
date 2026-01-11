CREATE TABLE `investment_operation`
(
    `id`          BIGINT UNSIGNED default 0 PRIMARY KEY,
    `is_deleted`  tinyint(1) NOT NULL default 0,
    `create_time` datetime      NOT NULL,
    `update_time` datetime      NOT NULL,
    `op_date`     DATE          NOT NULL COMMENT '操作日期',
    `op_platform` VARCHAR(31)   NOT NULL COMMENT '操作平台',
    `op_type`     VARCHAR(31)   NOT NULL COMMENT '操作类型',
    `op_item`     VARCHAR(2047) NOT NULL COMMENT '操作对象',
    `op_amount`   VARCHAR(2047) NOT NULL COMMENT '操作金额'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='投资操作流水表';


-- export data: docker exec [container_id] mysqldump -uadmin -p123456 my_db investment_operation --no-create-info --skip-extended-insert > investment_operation.sql
-- import data: usql -c "\i investment_operation.sql" mysql://admin:123456@localhost:13306/my_db_backup