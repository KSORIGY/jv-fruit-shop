package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

import java.util.Map;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> map) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity cannot be negative");
        }
        map.put(transaction.getFruit(), transaction.getQuantity());
    }
}
