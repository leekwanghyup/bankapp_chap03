package bankapp_chap03.util_schema;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DemoMapBean {
	private Map<String, Integer> scoreMap;
	private Map<Box, ScoreBox> scoreBoxMap;
}
