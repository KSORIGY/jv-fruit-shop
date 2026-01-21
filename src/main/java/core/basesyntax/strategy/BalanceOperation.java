package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        FruitDao.getFruitsStorage().put(transaction.getFruit(), transaction.getQuantity());
    }
}
