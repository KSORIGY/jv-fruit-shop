package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String makeReport() {
        StringBuilder builder = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> entry : FruitDao.getFruitsStorage().entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return builder.toString();
    }
}
