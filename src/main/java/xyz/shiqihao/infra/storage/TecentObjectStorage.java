package xyz.shiqihao.infra.storage;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicSessionCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.tencent.cloud.CosStsClient;
import com.tencent.cloud.Credentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public final class TecentObjectStorage implements ObjectStorage {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            PROPERTIES.load(TecentObjectStorage.class.getResourceAsStream("/tencent-auth.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Credentials getCredential() {
        TreeMap<String, Object> config = new TreeMap<>();
        try {
            // 云 api 密钥 SecretId
            config.put("secretId", PROPERTIES.getProperty("secret.id"));
            // 云 api 密钥 SecretKey
            config.put("secretKey", PROPERTIES.getProperty("secret.key"));

            // 临时密钥有效时长，单位是秒
            config.put("durationSeconds", 1800);

            // 换成你的 bucket
            config.put("bucket", PROPERTIES.getProperty("bucket"));
            // 换成 bucket 所在地区
            config.put("region", PROPERTIES.getProperty("region"));

            // 可以通过 allowPrefixes 指定前缀数组, 例子： a.jpg 或者 a/* 或者 * (使用通配符*存在重大安全风险, 请谨慎评估使用)
            config.put("allowPrefixes", new String[]{"*"});

            // 密钥的权限列表。简单上传和分片需要以下的权限，其他权限列表请看 https://cloud.tencent.com/document/product/436/31923
            String[] allowActions = new String[]{
                    // 简单上传
                    "name/cos:PutObject",
                    "name/cos:PostObject",
            };
            config.put("allowActions", allowActions);

            return CosStsClient.getCredential(config).credentials;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void put(String filePath, File content) {
        Credentials credentials = getCredential();
        // 1 传入获取到的临时密钥 (tmpSecretId, tmpSecretKey, sessionToken)
        BasicSessionCredentials cred = new BasicSessionCredentials(credentials.tmpSecretId, credentials.tmpSecretKey, credentials.sessionToken);
        // 2 设置 bucket 的地域
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分
        Region region = new Region(PROPERTIES.getProperty("region")); // COS_REGION 参数：配置成存储桶 bucket 的实际地域，例如 ap-beijing，更多 COS 地域的简称请参见 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端
        COSClient cosClient = new COSClient(cred, clientConfig);
        // 指定文件将要存放的存储桶
        String bucketName = PROPERTIES.getProperty("bucket");
        // // 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        // String key = "folder/picture.jpg";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, filePath, content);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        LOGGER.info("putObjectResult: {}", new Gson().toJson(putObjectResult));
        cosClient.shutdown();
    }

    public static void main(String[] args) {
        File file = new File("Dockerfile");
        TecentObjectStorage cli = new TecentObjectStorage();
        cli.put("2024-08-05/my-app-be/Dockerfile", file);
    }
}
