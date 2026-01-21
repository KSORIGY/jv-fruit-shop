package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int quantityNow = FruitDao.fruitsStorage.get(transaction.getFruit());
        int supplyQuantity = transaction.getQuantity();
        int newQuantity = quantityNow + supplyQuantity;
        FruitDao.fruitsStorage.put(transaction.getFruit(), newQuantity);
    }
}
