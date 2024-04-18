package com.Swino.TrainingJava.ExoTrader;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        Trader raoul= new Trader("Raoul","Cambridge");
        Trader mario= new Trader("Mario","Milan");
        Trader alan= new Trader("Alan","Cambridge");
        Trader brian= new Trader("Brian","Cambridge");
        List<Transaction> transaction= Arrays.asList(
                new Transaction(brian,2011,400),
                new Transaction(brian,2012,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,410),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950));

        //Exo 1
        List<Transaction> transac2011 = transaction
                .stream()
                .filter(transac -> transac.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList();
        transac2011.forEach(System.out::println);

        System.out.println("---------");

        //Exo 2
        List<String> villesUniques = transaction
                .stream()
                .map(transac -> transac.getTrader().getCity())
                .distinct()
                .toList();
        villesUniques.forEach(System.out::println);

        System.out.println("---------");

        //Exo 3
        List<String> tradersUniques = transaction
                .stream()
                .map(transac -> transac.getTrader().getName())
                .distinct().sorted(Comparator.naturalOrder())
                .toList();
        tradersUniques.forEach(System.out::println);

        System.out.println("---------");

        //Exo 4
        Optional<Transaction> traderMilan=transaction
                .stream()
                .filter(transac->transac.getTrader().getCity().equals("Milan"))
                .findFirst();

        if(traderMilan.isPresent()){
            System.out.println("il existe des traders basé à milan");
        }else{
            System.out.println("je n'ai pas trouvé de traders basée à milan");
        }

        System.out.println("---------");

        //Exo 5
        Optional<Integer> transactionLaPlusEleve= transaction
                .stream()
                .map(Transaction::getValue)
                .max(Comparator.naturalOrder());

        System.out.println(transactionLaPlusEleve.get());

        System.out.println("---------");

        //Exo 6
        List<Trader> traderCambridge= transaction
                .stream()
                .map(Transaction::getTrader)
                .filter(trader->trader.getCity().equals("Cambridge"))
                .distinct()
                .toList();

        traderCambridge.forEach(System.out::println);

        System.out.println("---------");

        //Exo 7
        List<Integer> traderCambridgeValeur= transaction
                .stream()
                .filter(transac->transac.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .distinct()
                .toList();
        traderCambridgeValeur.forEach(System.out::println);

        System.out.println("---------");

        //Exo 8
        Optional<Integer> valeurMin= transaction
                .stream()
                .map(Transaction::getValue)
                        .min(Comparator.naturalOrder());
        System.out.println(valeurMin.get());

    }
}
