package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;

import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }
    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.stream()
                .forEach(transaction -> operationStrategy
                        .get(transaction.getOperation()).handle(transaction));
    }
}
