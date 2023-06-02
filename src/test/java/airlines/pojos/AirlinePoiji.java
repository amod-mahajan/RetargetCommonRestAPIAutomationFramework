package airlines.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelUnknownCells;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@ToString
public class AirlinePoiji {

    @ExcelCell(0)
    private int id;
    @ExcelCellName("Name")
    private String name;
    @ExcelCellName("Country")
    private String country;
    @ExcelCellName("Logo")
    private String logo;
    @ExcelCellName("Slogan")
    private String slogan;
    @ExcelCellName("HeadQuarter")
    private List<String> head_quaters;
    @ExcelCellName("Website")
    private String website;
    @ExcelCellName("Established")
    private String established;

    @ExcelUnknownCells
    private Map<String,String> extracells;
}
