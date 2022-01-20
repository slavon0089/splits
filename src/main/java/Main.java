import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String logsName =
                "2021-08-02 14:16:48.650 INFO 10176 --- [ restartedMain] ru.devray.study.sbitter.Application : No active profile set, falling back to default profiles: default\n" +
                        "2021-08-02 14:16:48.710 INFO 10176 --- [ restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable\n" +
                        "2021-08-02 14:16:48.710 INFO 10176 --- [ restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'\n" +
                        "2021-08-02 14:16:49.255 INFO 10176 --- [ restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.\n" +
                        "2021-08-02 14:16:49.295 INFO 10176 --- [ restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 31 ms. Found 1 JPA repository interfaces.\n" +
                        "2021-08-02 14:16:49.749 INFO 10176 --- [ restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer : Tomcat initialized with port(s): 8080 (http)\n" +
                        "2021-08-02 14:16:49.756 INFO 10176 --- [ restartedMain] o.apache.catalina.core.StandardService : Starting service [Tomcat]\n" +
                        "2021-08-02 14:16:49.756 INFO 10176 --- [ restartedMain] org.apache.catalina.core.StandardEngine : Starting Servlet engine: [Apache Tomcat/9.0.48]\n" +
                        "2021-08-02 14:16:49.947 INFO 10176 --- [ restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/] : Initializing Spring embedded WebApplicationContext\n" +
                        "2021-08-02 14:16:49.947 INFO 10176 --- [ restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1237 ms\n" +
                        "2021-08-02 14:16:50.077 INFO 10176 --- [ restartedMain] o.hibernate.jpa.internal.util.LogHelper : HHH000204: Processing PersistenceUnitInfo [name: default]\n" +
                        "2021-08-02 14:16:50.124 INFO 10176 --- [ restartedMain] org.hibernate.Version : HHH000412: Hibernate ORM core version 5.4.32.Final\n" +
                        "2021-08-02 14:16:50.228 INFO 10176 --- [ restartedMain] o.hibernate.annotations.common.Version : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}\n" +
                        "2021-08-02 14:16:50.309 INFO 10176 --- [ restartedMain] com.zaxxer.hikari.HikariDataSource : HikariPool-1 - Starting...\n" +
                        "2021-08-02 14:16:51.490 ERROR 10176 --- [ restartedMain] com.zaxxer.hikari.pool.HikariPool : HikariPool-1 - Exception during pool initialization/\n";

        String regexp = "((\\d{2}:){2}\\d{2}.\\d{3}).*?(\\s:\\s[A-Z].*)"; //\s:\s.*$

        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(logsName);

        while (m.find()) {
            for (int i = 0; i < m.groupCount(); i++) {
               // System.out.println("Время: " + m.group(1) + " Сообщение " + m.group(3));
            }
        }

        String[] lines = logsName.split("\n");


        String matchTime = "\\d{4}-\\d{2}-\\d{2}";
        
        for (String line: lines){
            boolean isMatchDate = line.matches("\\d{4}-\\d{2}-\\d{2}");
            System.out.println(line);
            System.out.println("Дата валидна: "+isMatchDate);

            boolean isMatchTime = line.matches("(\\d{2}:){2}\\d{2}.\\d{3}");
            System.out.println("Время валидно: " + isMatchTime);

            boolean isMatchText = line.matches("(\\[.*?]\\s)(.*?\\s:\\s)");
            System.out.println("Текст валидный: " + isMatchText);


           // String matchTime = "\\d{4}-\\d{2}-\\d{2}";
            System.out.println(line.matches(matchTime));
        }

        System.out.println(lines[0].matches(matchTime));





    }
}