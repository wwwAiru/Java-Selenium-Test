package ru.egar.selenium_demo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {Application.class})
@ActiveProfiles("test")
public abstract class AbstractSpringBootTest {
}
