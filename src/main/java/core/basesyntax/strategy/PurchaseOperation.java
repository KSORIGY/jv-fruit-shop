package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int quantityNow = FruitDao.getFruitsStorage().get(transaction.getFruit());
        int purchasedQuantity = transaction.getQuantity();
        int countLeft = quantityNow - purchasedQuantity;
        FruitDao.getFruitsStorage().put(transaction.getFruit(), countLeft);
    }
}
