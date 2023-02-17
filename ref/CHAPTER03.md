## 프로젝트 생성 pom.xml
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.2.22.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.26</version>
    <scope>provided</scope>
</dependency>
```

# 3.1 소개 
- 빈 정의 상속
- 빈 클래스의 생성자 인수를 찾는 방법 
- 원시타입이나 컬렉션 타입 또는 사용자 정의 타입을 사용해 빈 프로퍼티나 생성자 인수 설정
- 빈 프로퍼티에 p-namespace, 생성자 인수에 c-namespace를 활용한 XML파일 작성
- 빈 인스턴스를 생성하는 팩토리 클래스를 작성할 때 사용하는 스프링 FactoryBean 인터페이스
- 빈 설정 모듈화 

<br>

## 3.2 빈 정의 상속 
    빈 정의를 간결화하기 위해 빈 정의가 다른 빈 정의의 설정을 상속하는 경우 

<br>

### 3.2.1 빈 정의 상속 예제 
![alt](images/%EA%B7%B8%EB%A6%BC3-1.png)

```java
// 도메인 
package bankapp_chap03.domain;
//...

@ToString
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankStatement {
	private Date transactionDate;
	private double amount;
	private String transactionType;
	private String referenceNumber;
}

@ToString
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FixedDepositDetails {
	private long id;
	private float depositAmount;
	private int tenure;
	private String email;
}

```

<br>

	DatabaseOperations : PersonnalBankingDao와 FixedDepositDao의 공통 설정이다.
	애플리케이션의 여러빈이 같은 설정집합을 공유한다면 다른 빈 정의의 부모역할을 하는 빈 정의를 만들 수 있다.

```java
package bankapp_chap03.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import bankapp_chap03.domain.BankStatement;
import bankapp_chap03.domain.FixedDepositDetails;

public class DatabaseOperations {
	
	private static Map<Long, FixedDepositDetails> fixedDeposits = 
							new HashMap<Long, FixedDepositDetails>();
	
	public boolean saveFd(FixedDepositDetails fdd) {
		fixedDeposits.put(fdd.getId(), fdd);
		return true;
	}

	public FixedDepositDetails loadFd(long id) {
		return fixedDeposits.get(id);
	}

	public BankStatement getMiniStatement() {
		return BankStatement.builder()
				.amount(100)
				.referenceNumber("Ref. no. 1")
				.transactionDate(new Date())
				.transactionType("credit").build();
	}
}
```

<br>

```java
// Dao 인터페이스 
package bankapp_chap03.dao;

// FixedDepositDao
public interface FixedDepositDao {

	FixedDepositDetails getFixedDepositDetails(long id);

	boolean createFixedDeposit(FixedDepositDetails fdd);
}

// PersonalBakingDao
public interface PersonalBakingDao {
	BankStatement getMiniStatement();
}

// Dao 구현체 
// FixedDepositDaoImpl
@Setter
public class FixedDepositDaoImpl implements FixedDepositDao {
	
	private DatabaseOperations databaseOperations;

	public FixedDepositDaoImpl() {
		System.out.println("FixedDepositDaoImpl 생성");
	}
	
	@Override
	public FixedDepositDetails getFixedDepositDetails(long id) {
		return databaseOperations.loadFd(id);
	}

	@Override
	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		return databaseOperations.saveFd(fdd);
	}
}

// PersonalBankingDaoImpl
@Setter
public class PersonalBankingDaoImpl implements PersonalBakingDao {

	private DatabaseOperations databaseOperations;
	
	@Override
	public BankStatement getMiniStatement() {
		return databaseOperations.getMiniStatement();
	}
}

```

<br>

```java
// 서비스
package bankapp_chap03.service;

public interface FixedDepositService {
	
	FixedDepositDao getFixedDepositDao();

	FixedDepositDetails getFixedDepositDetails(long id);

	boolean createFixedDeposit(FixedDepositDetails fdd);
}

public interface PersonalBankingService {
	BankStatement getMiniStatement();
}


// 서비스 구현체 
// FixedDepositServiceImpl
@Setter
public class FixedDepositServiceImpl implements FixedDepositService {

	private FixedDepositDao fixedDepositDao;
	
	public FixedDepositServiceImpl() {
		System.out.println("FixedDepositServiceImpl 생성");
	}
	
	@Override
	public FixedDepositDao getFixedDepositDao() {
		return fixedDepositDao;
	}

	@Override
	public FixedDepositDetails getFixedDepositDetails(long id) {
		return fixedDepositDao.getFixedDepositDetails(id);
	}

	@Override
	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		return fixedDepositDao.createFixedDeposit(fdd);
	}
}

// PersonalBankingServiceImpl
@Setter
public class PersonalBankingServiceImpl implements PersonalBankingService {

	private PersonalBakingDao personalBakingDao;
	
	@Override
	public BankStatement getMiniStatement() {
		return personalBakingDao.getMiniStatement();
	}
}
```

<br>

```java
// 컨트롤러 인터페이스
package bankapp_chap03.controller;

public interface FixedDepositController {
	
	FixedDepositService getFixedDepositService();

	boolean submit(FixedDepositDetails fixedDepositDetails);

	FixedDepositDetails get();
}

public interface PersonalBankingController {
	BankStatement getMiniStatement();
}

// 컨트롤러 구현체
@Setter
@Getter
public class FixedDepositControllerImpl implements FixedDepositController {

	private FixedDepositService fixedDepositService;
	
	public FixedDepositControllerImpl() {
		System.out.println("FixedDepositControllerImpl 생성");
	}
	
	@Override
	public FixedDepositDetails get() {
		return fixedDepositService.getFixedDepositDetails(1L);
	}

	@Override
	public boolean submit(FixedDepositDetails fixedDepositDetails) {
		return fixedDepositService.createFixedDeposit(fixedDepositDetails);
	}
}

@AllArgsConstructor
public class PersonalBankingControllerImpl implements PersonalBankingController {

	private PersonalBankingService personalBankingService;
	
	@Override
	public BankStatement getMiniStatement() {
		return personalBankingService.getMiniStatement();
	}
}
```


```xml
<!-- 설정 파일 : applicationContext.xml-->
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">


	<!-- domain : 스코프가 프로토 타입에 유의 -->
	<bean id="fixedDepositDetails"
		class="bankapp_chap03.domain.FixedDepositDetails" scope="prototype" />

	<!-- util -->
	<bean id="databaseOperations" class="bankapp_chap03.util.DatabaseOperations"/>
	
	<!-- dao -->
	<bean id="personalBankingDao" class="bankapp_chap03.dao.PersonalBankingDaoImpl">
		<property name="databaseOperations" ref="databaseOperations"/>
	</bean>
	<bean id="fixedDepositDao" class="bankapp_chap03.dao.FixedDepositDaoImpl">
		<property name="databaseOperations" ref="databaseOperations"/>
	</bean>
	
	<!-- service -->
	<bean id="personalBankingService" class="bankapp_chap03.service.PersonalBankingServiceImpl">
		<property name="personalBakingDao" ref="personalBankingDao"/>
	</bean>
	<bean id="fixedDepositService" class="bankapp_chap03.service.FixedDepositServiceImpl">
		<property name="fixedDepositDao" ref="fixedDepositDao"/>
	</bean>
	
	<!-- controller -->
	<bean id="fixedDepositController" class="bankapp_chap03.controller.FixedDepositControllerImpl">
		<property name="fixedDepositService" ref="fixedDepositService"/>
	</bean>
	<bean id="personalBankingController" class="bankapp_chap03.controller.PersonalBankingControllerImpl">
		<constructor-arg ref="personalBankingService"/>
	</bean>
	
</beans>
```

```java
package bankapp_chap03;

public class BankApp {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		FixedDepositController fixedDepositController = context.getBean(FixedDepositController.class);
		PersonalBankingController personalBankingController = context.getBean(PersonalBankingController.class);
		
		FixedDepositDetails depositDetails = context.getBean(FixedDepositDetails.class); 
		depositDetails.setDepositAmount(100);
		depositDetails.setEmail("someemail@somedomain.com");
		depositDetails.setId(1);
		depositDetails.setTenure(10);
		
		fixedDepositController.submit(depositDetails);
		System.out.println(fixedDepositController.get());
		
		System.out.println(personalBankingController.getMiniStatement());
	}
}
```

<br>

    personalBankingDao와fixedDepositDao는 databaseOperations에 의존하고 있다. 
    애플리케이션의 여러 빈이 같은 설정 집합을 공유한다면 다른빈 정의의 부모역할을 하는 빈 정의를 만들수있다.
```xml
<!-- util -->
<bean id="databaseOperations" class="bankapp_chap03.util.DatabaseOperations"/>

<!-- dao -->
<bean id="personalBankingDao" class="bankapp_chap03.dao.PersonalBankingDaoImpl">
    <property name="databaseOperations" ref="databaseOperations"/>
</bean>
<bean id="fixedDepositDao" class="bankapp_chap03.dao.FixedDepositDaoImpl">
    <property name="databaseOperations" ref="databaseOperations"/>
</bean>
```

<br>
    위 설정을 다음과 같이 변경하자 .
    abstract속성이 true이면 빈은 추상빈이 된다. class속성을 정의하지 않는다. 
    스프링 컨테이너는 추상빈 정의에 해당하는 빈을 생성하지 않는다.
    
```xml
<!-- dao -->
<bean id="daoTemplate" abstract="true">
    <property name="databaseOperations" ref="databaseOperations"/>
</bean>

<bean id="personalBankingDao" parent="daoTemplate" class="bankapp_chap03.dao.PersonalBankingDaoImpl"/>
<bean id="fixedDepositDao" parent="daoTemplate" class="bankapp_chap03.dao.FixedDepositDaoImpl"/>
```
    
	다음은 빈 상속이 fixedDeposit과 personalBankingDao빈 정의에 대해 어떻게 작용하지는지 보여준다. 
![alt](images/pic_3-2.png)


<br>

## 3.2.2 상속할 수 있는 정보