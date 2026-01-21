package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int quantityNow = FruitDao.getFruitsStorage().get(transaction.getFruit());
        int supplyQuantity = transaction.getQuantity();
        int newQuantity = quantityNow + supplyQuantity;
        FruitDao.getFruitsStorage().put(transaction.getFruit(), newQuantity);
    }
}
