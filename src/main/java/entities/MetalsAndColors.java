package entities;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetalsAndColors {
    public Integer[] summary;
    public String[] elements;
    public String color;
    public String metals;
    public String[] vegetables;
}
