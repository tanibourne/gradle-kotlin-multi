import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

plugins {
	java
	id("org.springframework.boot") version "3.0.6"
	id("io.spring.dependency-management") version "1.1.0"
}


allprojects {
	group = "com.example"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}
}


java.sourceCompatibility = JavaVersion.VERSION_17



subprojects {
	apply(plugin = "java")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")


	configurations {
		compileOnly {
			extendsFrom(configurations.annotationProcessor.get())
		}
	}


	//루트 하위 모듈에서 공통 dependencies

	dependencies{
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		developmentOnly("org.springframework.boot:spring-boot-devtools")
		compileOnly("org.projectlombok:lombok")
		annotationProcessor("org.projectlombok:lombok")
	}

}

tasks.withType<Test> {
	useJUnitPlatform()
}

//module-core에 module-api,module-batch가 의존

project(":module-core") {



	bootJar.enabled = false // 실행 가능한 Jar파일을 생성하는것을 하지 않는다. 만약 도메인과
	jar.enabled = true // 기본 JAR파일 생성 활성화 한다 기본 옵션이 true지만 명시

}

project(":module-api"){
	dependencies {
		implementation(project(":module-core"))
	}

}
project(":module-batch") {
	dependencies {
		implementation(project(":module-core"))
	}
}
