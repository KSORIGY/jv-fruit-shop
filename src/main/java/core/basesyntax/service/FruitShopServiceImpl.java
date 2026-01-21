package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new RuntimeException("Transaction cannot be null");
        }

        Map<String, Integer> storage = FruitDao.getFruitsStorage();

        transactions.stream()
                .forEach(transaction -> operationStrategy
                        .get(transaction.getOperation())
                        .handle(transaction, storage));
        return storage;
    }
}
