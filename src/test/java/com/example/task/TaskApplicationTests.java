package com.example.task;

import com.example.task.domain.entities.TaskList;
import com.example.task.domain.dto.TaskListDto;
import com.example.task.mappers.TaskListMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TaskApplicationTests {

	@Autowired
	private TaskListMapper taskListMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void testTaskListMapperWithEmptyTasks() {
		TaskList taskList = new TaskList(
				null,
				"My List",
				"Description",
				new ArrayList<>(),
				LocalDateTime.now(),
				LocalDateTime.now()
		);
		TaskListDto dto = taskListMapper.toDto(taskList);
		assertThat(dto.progress()).isNotNaN();
	}

}
