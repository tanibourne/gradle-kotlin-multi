package org.example.member;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModuleCoreApplicationTests {

    // 테스트가 실패한 이유는 module-core 프로젝트의 경우 @SpringBootApplication과 같은 Spring Context를 불러오는 포인트가 없어서 인데요,
    // 이를 위해 임시 시작 포인트용 클래스를 생성하겠습니다.

    public void contextLoads() {}
}
