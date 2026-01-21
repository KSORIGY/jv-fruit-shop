package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.strategy.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);

        FileReader fileReader = new FileReaderImpl();
        Converter converter = new ConverterImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        WriteReport writeReport = new WriteReportImpl();

        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);

        List<String> lines = fileReader.readReport("reportToRead.csv");
        List<FruitTransaction> transactions = converter.convert(lines);
        fruitShopService.process(transactions);

        String report = reportGenerator.makeReport();
        writeReport.writeReport(report, "finalReport.csv");
    }
}
