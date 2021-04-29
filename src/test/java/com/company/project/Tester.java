package com.company.project;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * 单元测试继承该类即可
 */
@SpringBootTest(classes = Application.class)
@Transactional
@Rollback
public abstract class Tester {}



