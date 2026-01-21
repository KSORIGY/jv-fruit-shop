package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterImpl implements Converter {
    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(line -> {
                    String[] data = line.split(",");
                    FruitTransaction transaction = new FruitTransaction();
                    transaction.setOperation(FruitTransaction.Operation.fromCodeToOp(data[0]));
                    transaction.setFruit(data[1]);
                    transaction.setQuantity(Integer.parseInt(data[2]));
                    return transaction;
                })
                .collect(Collectors.toList());
    }
}
