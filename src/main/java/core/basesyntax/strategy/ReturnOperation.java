package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int quantityNow = FruitDao.getFruitsStorage().get(transaction.getFruit());
        int returnQuantity = transaction.getQuantity();
        int quantityAfterReturn = quantityNow + returnQuantity;
        FruitDao.getFruitsStorage().put(transaction.getFruit(), quantityAfterReturn);
    }
}
