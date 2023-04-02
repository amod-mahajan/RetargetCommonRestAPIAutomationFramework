package airlines;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.formula.functions.T;
import utils.ExcelUtils;

import java.io.IOException;

public class ExcelTest {

    public static void main(String[] args) throws IOException {
        System.out.println(ExcelUtils.getExcelDataAsListOfMap("CreateAirlineData", "Sheet1"));

    }
}
