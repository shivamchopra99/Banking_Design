package com.Banking.bankingservice;

import com.Banking.bankingservice.service.OrchestratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@Component
public class BankingServiceApplication {

    private static OrchestratorService orchestrator;

    @Autowired
    private OrchestratorService orchestratorService;

    @PostConstruct
    public void init() {

        this.orchestrator = orchestratorService;

    }

// from here it will read the input from the resources and send it to orchestrator service
    public static void main(String[] args) throws IOException {

        SpringApplication.run(BankingServiceApplication.class, args);
        BankingServiceApplication instance = new BankingServiceApplication();
        InputStream is = instance.getFileAsIOStream("static/input.txt");
        List<String> ans = instance.storeFileContent(is);
        orchestrator.performOperation(ans);


    }

    private InputStream getFileAsIOStream(final String fileName) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }


    private List<String> storeFileContent(InputStream is) throws IOException {
        List<String> lines;
        lines = new ArrayList<>();

        try (InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);) {
            String line;


            while ((line = br.readLine()) != null) {
                lines.add(line);
            }


            is.close();
        }

        return lines;
    }
}


