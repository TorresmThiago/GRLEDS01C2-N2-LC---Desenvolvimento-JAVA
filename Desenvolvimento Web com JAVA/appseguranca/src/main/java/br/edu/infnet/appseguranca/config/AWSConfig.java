package br.edu.infnet.appseguranca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AWSConfig {

    @Bean
    public AmazonS3 authenticationS3() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAYN2D6IGOAZHDIQHN",
                "mslObwomhooJu4bViBIKC0N7jeYyoKyineSKRmHj");
        return AmazonS3ClientBuilder.standard()
                .withRegion("us-east-2")
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }
}
