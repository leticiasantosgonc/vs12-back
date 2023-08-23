package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClients;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.time.LocalDate;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        // configurando mongodb
        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";

        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("vemserdbc");
        MongoCollection mongoCollection = mongoDatabase.getCollection("alunos");

        //criar novo aluno
//        Document novoAluno = new Document("nome", "João")
//                .append("idade", 23)
//                .append("data_nascimento", LocalDate.of(2000,10, 06 ));
//
//        mongoCollection.insertOne(novoAluno);

        //atualizar
//        mongoCollection.updateOne(Filters.eq("nome", "João"), new Document("$set", new Document("data_nascimento", LocalDate.of(2000, 10, 10))));

        //deletar
//        mongoCollection.deleteOne(Filters.eq("nome", "João"));

        //usado principalmente para relatórios
//        mongoCollection.aggregate(Arrays.asList(
//                match(Filters.empty()),
//                group("$curso", Accumulators.sum("qtd", 1))))
//                .forEach(doc -> System.out.println(doc.toString()));

//        mongoCollection.updateMany(Filters.empty(),
//                new Document("$set", new Document("disciplinas", Arrays.asList(new Document().append("nome", "Fisíca"), new Document("nome", "Cálculo")))));

        mongoCollection.aggregate(Arrays.asList(
                match(Filters.empty()),
                        group("$disciplinas.nome", Accumulators.sum("qtd", 1))))
                .forEach(doc -> System.out.println(doc.toString()));

    }
}