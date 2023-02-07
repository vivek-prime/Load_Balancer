import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicationNode {
    private String nodeId;
    private boolean status;
}