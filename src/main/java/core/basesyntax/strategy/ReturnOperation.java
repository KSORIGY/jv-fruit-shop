package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> map) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity cannot be negative");
        }
        String fruit = transaction.getFruit();

        int currentQuantity = map.getOrDefault(fruit, 0);

        map.put(fruit, currentQuantity + transaction.getQuantity());
    }
}
