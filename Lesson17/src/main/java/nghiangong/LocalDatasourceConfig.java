package nghiangong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("aws")
public class LocalDatasourceConfig implements CommandLineRunner {
    @Autowired
    LocalDatasource localDatasource;


    @Override
    public void run(String... args) throws Exception {
        System.out.println(localDatasource.getUsername());
        System.out.println(localDatasource.getPassword());
        System.out.println(localDatasource.getUrl());
    }
}