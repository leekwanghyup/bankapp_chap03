package bankapp_chap03.util_schema.path;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter // 빈의 프로퍼티를 노출하려면 반드시 게터가 필요하다.
public class NameBox {
	private String name; 
}
