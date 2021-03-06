/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.study.boot.daemon.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.boot.common.util.WebResponse;
import com.study.boot.daemon.entity.StatusTraceLog;
import com.study.boot.daemon.service.StatusTraceLogService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * @author lengleng
 * @date 2018-08-03 22:15:45
 */
@RestController
@AllArgsConstructor
@RequestMapping("/status-trace-log")
@Api(tags = "任务轨迹管理")
public class StatusTraceLogController {
	private final StatusTraceLogService statusTraceLogService;

	/**
	 * 任务轨迹处理简单分页查询
	 *
	 * @param page           分页对象
	 * @param statusTraceLog 任务轨迹处理
	 * @return
	 */
	@GetMapping("/page")
	public WebResponse getStatusTraceLogPage(Page<StatusTraceLog> page, StatusTraceLog statusTraceLog) {
		return new WebResponse<>(statusTraceLogService.page(page, Wrappers.query(statusTraceLog)));
	}


	/**
	 * 信息
	 *
	 * @param id
	 * @return R
	 */
	@GetMapping("/{id}")
	public WebResponse getById(@PathVariable("id") String id) {
		return new WebResponse<>(statusTraceLogService.getById(id));
	}

	/**
	 * 保存
	 *
	 * @param statusTraceLog
	 * @return R
	 */
	@PostMapping
	public WebResponse save(@RequestBody StatusTraceLog statusTraceLog) {
		return new WebResponse<>(statusTraceLogService.save(statusTraceLog));
	}

	/**
	 * 修改
	 *
	 * @param statusTraceLog
	 * @return R
	 */
	@PutMapping
	public WebResponse update(@RequestBody StatusTraceLog statusTraceLog) {
		return new WebResponse<>(statusTraceLogService.updateById(statusTraceLog));
	}

	/**
	 * 删除
	 *
	 * @param id
	 * @return R
	 */
	@DeleteMapping("/{id}")
	public WebResponse removeById(@PathVariable("id") String id) {
		return new WebResponse<>(statusTraceLogService.removeById(id));
	}

}
