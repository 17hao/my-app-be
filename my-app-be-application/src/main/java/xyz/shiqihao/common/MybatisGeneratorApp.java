package xyz.shiqihao.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import xyz.shiqihao.common.util.AssertUtils;

@Log4j2
public class MybatisGeneratorApp {
    public static void main(String[] args) {
        try {
            List<String> warnings = new ArrayList<>();
            boolean overwrite = true;
            String[] tables = {"order_item", "order_summary"};
            for (String table : tables) {
                String resourceName = String.format("mybatis-generator/%s.xml", table);
                String fileName = AssertUtils.isNonNull(MybatisGeneratorApp.class.getClassLoader().getResource(resourceName)).getFile();
                File configFile = new File(fileName);
                ConfigurationParser cp = new ConfigurationParser(warnings);
                Configuration config = cp.parseConfiguration(configFile);
                DefaultShellCallback callback = new DefaultShellCallback(overwrite);
                MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
                generator.generate(null);
                for (String warning : warnings) {
                    log.warn(warning);
                }
            }
        } catch (Exception e) {
            log.error(e);
        }
    }
}
